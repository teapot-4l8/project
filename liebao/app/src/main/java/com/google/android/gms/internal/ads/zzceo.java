package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzceo implements zzaeg {
    private final /* synthetic */ zzcfl zzgik;
    private final /* synthetic */ ViewGroup zzgil;
    private final /* synthetic */ zzcen zzgim;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzceo(zzcen zzcenVar, zzcfl zzcflVar, ViewGroup viewGroup) {
        this.zzgim = zzcenVar;
        this.zzgik = zzcflVar;
        this.zzgil = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zztp() {
        boolean zza;
        zzcen zzcenVar = this.zzgim;
        zza = zzcen.zza(this.zzgik, zzcel.zzgib);
        if (zza) {
            this.zzgik.onClick(this.zzgil);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final void zzc(MotionEvent motionEvent) {
        this.zzgik.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzaeg
    public final JSONObject zztq() {
        return this.zzgik.zztq();
    }
}
