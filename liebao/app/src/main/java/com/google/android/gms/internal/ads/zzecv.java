package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeon;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzecv<KeyFormatProtoT extends zzeon, KeyProtoT extends zzeon> {
    private final zzecx<KeyFormatProtoT, KeyProtoT> zzieo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzecv(zzecx<KeyFormatProtoT, KeyProtoT> zzecxVar) {
        this.zzieo = zzecxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final KeyProtoT zzq(zzelq zzelqVar) {
        KeyFormatProtoT zzr = this.zzieo.zzr(zzelqVar);
        this.zzieo.zzd(zzr);
        return this.zzieo.zze(zzr);
    }
}
