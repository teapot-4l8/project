package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzepe extends zzelr {
    private final zzepg zziwu;
    private zzelv zziwv = zzblh();
    private final /* synthetic */ zzepf zziww;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzepe(zzepf zzepfVar) {
        this.zziww = zzepfVar;
        this.zziwu = new zzepg(this.zziww, null);
    }

    private final zzelv zzblh() {
        if (this.zziwu.hasNext()) {
            return (zzelv) ((zzelx) this.zziwu.next()).iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zziwv != null;
    }

    @Override // com.google.android.gms.internal.ads.zzelv
    public final byte nextByte() {
        zzelv zzelvVar = this.zziwv;
        if (zzelvVar == null) {
            throw new NoSuchElementException();
        }
        byte nextByte = zzelvVar.nextByte();
        if (!this.zziwv.hasNext()) {
            this.zziwv = zzblh();
        }
        return nextByte;
    }
}
