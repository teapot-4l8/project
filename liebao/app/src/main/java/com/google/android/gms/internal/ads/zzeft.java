package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
class zzeft implements zzedg<zzeda, zzeda> {
    private static final Logger logger = Logger.getLogger(zzeft.class.getName());

    @Override // com.google.android.gms.internal.ads.zzedg
    public final Class<zzeda> zzbbh() {
        return zzeda.class;
    }

    @Override // com.google.android.gms.internal.ads.zzedg
    public final Class<zzeda> zzbbu() {
        return zzeda.class;
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    private static class zza implements zzeda {
        private final zzedc<zzeda> zzigq;
        private final byte[] zzihb;

        private zza(zzedc<zzeda> zzedcVar) {
            this.zzihb = new byte[]{0};
            this.zzigq = zzedcVar;
        }

        @Override // com.google.android.gms.internal.ads.zzeda
        public final byte[] zzk(byte[] bArr) {
            if (this.zzigq.zzbbp().zzbbs().equals(zzeiw.LEGACY)) {
                return zzejn.zza(this.zzigq.zzbbp().zzbbt(), this.zzigq.zzbbp().zzbbq().zzk(zzejn.zza(bArr, this.zzihb)));
            }
            return zzejn.zza(this.zzigq.zzbbp().zzbbt(), this.zzigq.zzbbp().zzbbq().zzk(bArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedg
    public final /* synthetic */ zzeda zza(zzedc<zzeda> zzedcVar) {
        return new zza(zzedcVar);
    }
}
