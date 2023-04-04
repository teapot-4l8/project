package com.google.android.gms.internal.ads;

import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzefd implements zzedg<zzecr, zzecr> {
    private static final Logger logger = Logger.getLogger(zzefd.class.getName());

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    private static class zza implements zzecr {
        private final zzedc<zzecr> zzigq;

        public zza(zzedc<zzecr> zzedcVar) {
            this.zzigq = zzedcVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedg
    public final Class<zzecr> zzbbh() {
        return zzecr.class;
    }

    @Override // com.google.android.gms.internal.ads.zzedg
    public final Class<zzecr> zzbbu() {
        return zzecr.class;
    }

    @Override // com.google.android.gms.internal.ads.zzedg
    public final /* synthetic */ zzecr zza(zzedc<zzecr> zzedcVar) {
        return new zza(zzedcVar);
    }
}
