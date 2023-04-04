package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzely {
    private final byte[] buffer;
    private final zzemk zziph;

    private zzely(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zziph = zzemk.zzv(bArr);
    }

    public final zzelq zzbhp() {
        this.zziph.zzbis();
        return new zzema(this.buffer);
    }

    public final zzemk zzbhq() {
        return this.zziph;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzely(int i, zzelp zzelpVar) {
        this(i);
    }
}
