package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcrm implements zzesa<zzcrl> {
    private final zzesn<zzcrj> zzfew;
    private final zzesn<zzebs> zzgtb;

    private zzcrm(zzesn<zzcrj> zzesnVar, zzesn<zzebs> zzesnVar2) {
        this.zzfew = zzesnVar;
        this.zzgtb = zzesnVar2;
    }

    public static zzcrm zzaq(zzesn<zzcrj> zzesnVar, zzesn<zzebs> zzesnVar2) {
        return new zzcrm(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcrl(this.zzfew.get(), this.zzgtb.get());
    }
}
