package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddp implements zzdhe<zzddq> {
    private final Context context;
    private final zzebs zzgka;

    public zzddp(zzebs zzebsVar, Context context) {
        this.zzgka = zzebsVar;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzddq> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdds
            private final zzddp zzheg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzheg = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzheg.zzaub();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzddq zzaub() {
        AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
        return new zzddq(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), com.google.android.gms.ads.internal.zzr.zzla().zzrg(), com.google.android.gms.ads.internal.zzr.zzla().zzrh());
    }
}
