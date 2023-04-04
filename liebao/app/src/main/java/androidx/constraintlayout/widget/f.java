package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: Placeholder.java */
/* loaded from: classes.dex */
public class f extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f1383a;

    /* renamed from: b  reason: collision with root package name */
    private View f1384b;

    /* renamed from: c  reason: collision with root package name */
    private int f1385c;

    public void setEmptyVisibility(int i) {
        this.f1385c = i;
    }

    public int getEmptyVisibility() {
        return this.f1385c;
    }

    public View getContent() {
        return this.f1384b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        if (this.f1383a == -1 && !isInEditMode()) {
            setVisibility(this.f1385c);
        }
        View findViewById = constraintLayout.findViewById(this.f1383a);
        this.f1384b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.a) findViewById.getLayoutParams()).aa = true;
            this.f1384b.setVisibility(0);
            setVisibility(0);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f1383a == i) {
            return;
        }
        View view = this.f1384b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.f1384b.getLayoutParams()).aa = false;
            this.f1384b = null;
        }
        this.f1383a = i;
        if (i == -1 || (findViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f1384b == null) {
            return;
        }
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f1384b.getLayoutParams();
        aVar2.al.e(0);
        aVar.al.j(aVar2.al.p());
        aVar.al.k(aVar2.al.r());
        aVar2.al.e(8);
    }
}
