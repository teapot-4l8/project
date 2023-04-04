package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    long f1750a;

    /* renamed from: b  reason: collision with root package name */
    boolean f1751b;

    /* renamed from: c  reason: collision with root package name */
    boolean f1752c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1753d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f1754e;
    private final Runnable f;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1750a = -1L;
        this.f1751b = false;
        this.f1752c = false;
        this.f1753d = false;
        this.f1754e = new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar.1
            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar.this.f1751b = false;
                ContentLoadingProgressBar.this.f1750a = -1L;
                ContentLoadingProgressBar.this.setVisibility(8);
            }
        };
        this.f = new Runnable() { // from class: androidx.core.widget.ContentLoadingProgressBar.2
            @Override // java.lang.Runnable
            public void run() {
                ContentLoadingProgressBar.this.f1752c = false;
                if (ContentLoadingProgressBar.this.f1753d) {
                    return;
                }
                ContentLoadingProgressBar.this.f1750a = System.currentTimeMillis();
                ContentLoadingProgressBar.this.setVisibility(0);
            }
        };
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    private void c() {
        removeCallbacks(this.f1754e);
        removeCallbacks(this.f);
    }

    public synchronized void a() {
        this.f1753d = true;
        removeCallbacks(this.f);
        this.f1752c = false;
        long currentTimeMillis = System.currentTimeMillis() - this.f1750a;
        if (currentTimeMillis < 500 && this.f1750a != -1) {
            if (!this.f1751b) {
                postDelayed(this.f1754e, 500 - currentTimeMillis);
                this.f1751b = true;
            }
        }
        setVisibility(8);
    }

    public synchronized void b() {
        this.f1750a = -1L;
        this.f1753d = false;
        removeCallbacks(this.f1754e);
        this.f1751b = false;
        if (!this.f1752c) {
            postDelayed(this.f, 500L);
            this.f1752c = true;
        }
    }
}
