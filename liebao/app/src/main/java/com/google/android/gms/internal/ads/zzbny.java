package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbny implements zzesa<zzbzl<zzbwy>> {
    private final zzbnl zzfxk;
    private final zzesn<zzbve> zzfxo;

    public zzbny(zzbnl zzbnlVar, zzesn<zzbve> zzesnVar) {
        this.zzfxk = zzbnlVar;
        this.zzfxo = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(new zzbwy(this.zzfxo.get()) { // from class: com.google.android.gms.internal.ads.zzbnn
            private final zzbve zzfxm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfxm = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbwy
            public final void zzakz() {
                this.zzfxm.zzamm();
            }
        }, zzbat.zzekj));
    }
}
