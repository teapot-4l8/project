package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaaj extends zzyk {
    private zzajt zzcly;

    @Override // com.google.android.gms.internal.ads.zzyh
    public final String getVersionString() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void setAppMuted(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void setAppVolume(float f) {
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(zzaat zzaatVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(zzann zzannVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(String str, IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzcd(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzce(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final float zzrg() {
        return 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final boolean zzrh() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zzrj() {
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void initialize() {
        zzbao.zzex("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzbae.zzaah.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzaai
            private final zzaaj zzclx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzclx = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzclx.zzsa();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void zza(zzajt zzajtVar) {
        this.zzcly = zzajtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final List<zzajm> zzri() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzsa() {
        zzajt zzajtVar = this.zzcly;
        if (zzajtVar != null) {
            try {
                zzajtVar.zze(Collections.emptyList());
            } catch (RemoteException e2) {
                zzbao.zzd("Could not notify onComplete event.", e2);
            }
        }
    }
}
