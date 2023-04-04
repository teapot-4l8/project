package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzdvc extends zzduy {
    private String zzhvq;
    private Boolean zzhvr;
    private Boolean zzhvs;

    @Override // com.google.android.gms.internal.ads.zzduy
    public final zzduy zzhf(String str) {
        if (str == null) {
            throw new NullPointerException("Null clientVersion");
        }
        this.zzhvq = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzduy
    public final zzduy zzbt(boolean z) {
        this.zzhvr = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzduy
    public final zzduy zzbu(boolean z) {
        this.zzhvs = true;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzduy
    public final zzduz zzayn() {
        String concat = this.zzhvq == null ? "".concat(" clientVersion") : "";
        if (this.zzhvr == null) {
            concat = String.valueOf(concat).concat(" shouldGetAdvertisingId");
        }
        if (this.zzhvs == null) {
            concat = String.valueOf(concat).concat(" isGooglePlayServicesAvailable");
        }
        if (!concat.isEmpty()) {
            String valueOf = String.valueOf(concat);
            throw new IllegalStateException(valueOf.length() != 0 ? "Missing required properties:".concat(valueOf) : new String("Missing required properties:"));
        }
        return new zzdva(this.zzhvq, this.zzhvr.booleanValue(), this.zzhvs.booleanValue());
    }
}
