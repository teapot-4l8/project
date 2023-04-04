package com.lxj.xpopup.g;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdRequest;
import java.util.HashMap;

/* compiled from: KeyboardUtils.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f5516a;

    /* renamed from: b  reason: collision with root package name */
    private static ViewTreeObserver.OnGlobalLayoutListener f5517b;

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<View, a> f5518c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static int f5519d = 0;

    /* compiled from: KeyboardUtils.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            return f5516a;
        }
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= b()) {
            f5519d = abs;
            return 0;
        }
        return abs - f5519d;
    }

    public static void a(final Activity activity, com.lxj.xpopup.b.b bVar, a aVar) {
        if ((activity.getWindow().getAttributes().flags & AdRequest.MAX_CONTENT_URL_LENGTH) != 0) {
            activity.getWindow().clearFlags(AdRequest.MAX_CONTENT_URL_LENGTH);
        }
        f5516a = b(activity);
        f5518c.put(bVar, aVar);
        ((FrameLayout) activity.findViewById(16908290)).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.lxj.xpopup.g.b.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int b2 = b.b(activity);
                if (b.f5516a != b2) {
                    for (a aVar2 : b.f5518c.values()) {
                        aVar2.a(b2);
                    }
                    b.f5516a = b2;
                }
            }
        });
    }

    public static void a(View view, com.lxj.xpopup.b.b bVar) {
        View findViewById;
        f5517b = null;
        if (view == null || (findViewById = view.findViewById(16908290)) == null) {
            return;
        }
        findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(f5517b);
        f5518c.remove(bVar);
    }

    private static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void a(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
    }

    public static void b(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
