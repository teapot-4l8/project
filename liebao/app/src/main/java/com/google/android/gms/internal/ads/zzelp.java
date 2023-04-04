package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzelp extends zzelr {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzelq zzipb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzelp(zzelq zzelqVar) {
        this.zzipb = zzelqVar;
        this.limit = this.zzipb.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzelv
    public final byte nextByte() {
        int i = this.position;
        if (i >= this.limit) {
            throw new NoSuchElementException();
        }
        this.position = i + 1;
        return this.zzipb.zzgi(i);
    }
}
