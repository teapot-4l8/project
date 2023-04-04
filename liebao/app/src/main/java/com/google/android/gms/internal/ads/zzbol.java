package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbol implements zzesa<Boolean> {
    private final zzesn<zzdpm> zzfxn;

    public zzbol(zzesn<zzdpm> zzesnVar) {
        this.zzfxn = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        boolean booleanValue;
        if (this.zzfxn.get().zzawb() != null) {
            booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcqo)).booleanValue();
        } else {
            booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcxj)).booleanValue();
        }
        return Boolean.valueOf(booleanValue);
    }
}
