package androidx.core.h.a;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: AccessibilityClickableSpanCompat.java */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final int f1656a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1657b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1658c;

    public a(int i, d dVar, int i2) {
        this.f1656a = i;
        this.f1657b = dVar;
        this.f1658c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1656a);
        this.f1657b.a(this.f1658c, bundle);
    }
}
