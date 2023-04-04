package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzblr implements zzesa<zzamx> {
    private final zzesn<zzamo> zzfvm;

    private zzblr(zzesn<zzamo> zzesnVar) {
        this.zzfvm = zzesnVar;
    }

    public static zzblr zzb(zzesn<zzamo> zzesnVar) {
        return new zzblr(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzamx) zzesg.zzbd(this.zzfvm.get().zzvb());
    }
}
