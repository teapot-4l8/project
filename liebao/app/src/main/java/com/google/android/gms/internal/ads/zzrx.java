package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzrx {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;
    private final int zzbun;

    public zzrx(float f, float f2, float f3, float f4, int i) {
        this.left = f;
        this.top = f2;
        this.right = f + f3;
        this.bottom = f2 + f4;
        this.zzbun = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzmu() {
        return this.left;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzmv() {
        return this.top;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzmw() {
        return this.right;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float zzmx() {
        return this.bottom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzmy() {
        return this.zzbun;
    }
}
