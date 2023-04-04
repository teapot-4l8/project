package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

/* compiled from: TooltipPopup.java */
/* loaded from: classes.dex */
class ba {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1040a;

    /* renamed from: b  reason: collision with root package name */
    private final View f1041b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f1042c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f1043d = new WindowManager.LayoutParams();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f1044e = new Rect();
    private final int[] f = new int[2];
    private final int[] g = new int[2];

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(Context context) {
        this.f1040a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f1041b = inflate;
        this.f1042c = (TextView) inflate.findViewById(R.id.message);
        this.f1043d.setTitle(getClass().getSimpleName());
        this.f1043d.packageName = this.f1040a.getPackageName();
        this.f1043d.type = 1002;
        this.f1043d.width = -2;
        this.f1043d.height = -2;
        this.f1043d.format = -3;
        this.f1043d.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        this.f1043d.flags = 24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.f1042c.setText(charSequence);
        a(view, i, i2, z, this.f1043d);
        ((WindowManager) this.f1040a.getSystemService("window")).addView(this.f1041b, this.f1043d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (b()) {
            ((WindowManager) this.f1040a.getSystemService("window")).removeView(this.f1041b);
        }
    }

    boolean b() {
        return this.f1041b.getParent() != null;
    }

    private void a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1040a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1040a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1040a.getResources().getDimensionPixelOffset(z ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View a2 = a(view);
        if (a2 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a2.getWindowVisibleDisplayFrame(this.f1044e);
        if (this.f1044e.left < 0 && this.f1044e.top < 0) {
            Resources resources = this.f1040a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1044e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a2.getLocationOnScreen(this.g);
        view.getLocationOnScreen(this.f);
        int[] iArr = this.f;
        int i4 = iArr[0];
        int[] iArr2 = this.g;
        iArr[0] = i4 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (a2.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1041b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1041b.getMeasuredHeight();
        int[] iArr3 = this.f;
        int i5 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i6 = iArr3[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i5 >= 0) {
                layoutParams.y = i5;
            } else {
                layoutParams.y = i6;
            }
        } else if (measuredHeight + i6 <= this.f1044e.height()) {
            layoutParams.y = i6;
        } else {
            layoutParams.y = i5;
        }
    }

    private static View a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
