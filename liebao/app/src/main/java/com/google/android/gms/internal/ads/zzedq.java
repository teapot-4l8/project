package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzedq implements zzedg<zzecn, zzecn> {
    private static final Logger logger = Logger.getLogger(zzedq.class.getName());

    @Override // com.google.android.gms.internal.ads.zzedg
    public final Class<zzecn> zzbbh() {
        return zzecn.class;
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    private static class zza implements zzecn {
        private final zzedc<zzecn> zzifx;

        private zza(zzedc<zzecn> zzedcVar) {
            this.zzifx = zzedcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzecn
        public final byte[] zzc(byte[] bArr, byte[] bArr2) {
            return zzejn.zza(this.zzifx.zzbbp().zzbbt(), this.zzifx.zzbbp().zzbbq().zzc(bArr, bArr2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedg
    public final Class<zzecn> zzbbu() {
        return zzecn.class;
    }

    @Override // com.google.android.gms.internal.ads.zzedg
    public final /* synthetic */ zzecn zza(zzedc<zzecn> zzedcVar) {
        return new zza(zzedcVar);
    }
}
