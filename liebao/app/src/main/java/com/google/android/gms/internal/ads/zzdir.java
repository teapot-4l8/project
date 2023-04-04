package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdir implements zzdhe<zzdis> {
    private String packageName;
    private zzebs zzgka;
    private zzazk zzhho;

    public zzdir(zzazk zzazkVar, zzebs zzebsVar, String str) {
        this.zzhho = zzazkVar;
        this.zzgka = zzebsVar;
        this.packageName = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdis> zzatu() {
        new zzbbe();
        zzebt<String> zzag = zzebh.zzag(null);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxx)).booleanValue()) {
            zzag = this.zzhho.zzeb(this.packageName);
        }
        zzebt<String> zzec = this.zzhho.zzec(this.packageName);
        return zzebh.zzb(zzag, zzec).zzb(new Callable(zzag, zzec) { // from class: com.google.android.gms.internal.ads.zzdiu
            private final zzebt zzgbc;
            private final zzebt zzgkr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgkr = zzag;
                this.zzgbc = zzec;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzdis((String) this.zzgkr.get(), (String) this.zzgbc.get());
            }
        }, zzbat.zzeke);
    }
}
