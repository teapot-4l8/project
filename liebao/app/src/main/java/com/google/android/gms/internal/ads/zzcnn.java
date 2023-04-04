package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcnn extends zzajr {
    private final /* synthetic */ zzcna zzgpu;
    private final /* synthetic */ Object zzgpx;
    private final /* synthetic */ String zzgpy;
    private final /* synthetic */ long zzgpz;
    private final /* synthetic */ zzbbe zzgqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnn(zzcna zzcnaVar, Object obj, String str, long j, zzbbe zzbbeVar) {
        this.zzgpu = zzcnaVar;
        this.zzgpx = obj;
        this.zzgpy = str;
        this.zzgpz = j;
        this.zzgqa = zzbbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final void onInitializationSucceeded() {
        zzcmk zzcmkVar;
        zzbyr zzbyrVar;
        synchronized (this.zzgpx) {
            this.zzgpu.zza(this.zzgpy, true, "", (int) (com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - this.zzgpz));
            zzcmkVar = this.zzgpu.zzgpi;
            zzcmkVar.zzgh(this.zzgpy);
            zzbyrVar = this.zzgpu.zzgpk;
            zzbyrVar.zzfv(this.zzgpy);
            this.zzgqa.set(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajo
    public final void onInitializationFailed(String str) {
        zzcmk zzcmkVar;
        zzbyr zzbyrVar;
        synchronized (this.zzgpx) {
            this.zzgpu.zza(this.zzgpy, false, str, (int) (com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - this.zzgpz));
            zzcmkVar = this.zzgpu.zzgpi;
            zzcmkVar.zzt(this.zzgpy, d.O);
            zzbyrVar = this.zzgpu.zzgpk;
            zzbyrVar.zzn(this.zzgpy, d.O);
            this.zzgqa.set(false);
        }
    }
}
