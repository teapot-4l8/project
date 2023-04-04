package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcic implements com.google.android.gms.ads.internal.overlay.zzp, com.google.android.gms.ads.internal.overlay.zzx, zzahn, zzahp, zzve {
    private zzve zzchr;
    private zzahn zzdic;
    private zzahp zzdie;
    private com.google.android.gms.ads.internal.overlay.zzp zzduf;
    private com.google.android.gms.ads.internal.overlay.zzx zzduj;

    private zzcic() {
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final synchronized void onAdClicked() {
        if (this.zzchr != null) {
            this.zzchr.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        if (this.zzduf != null) {
            this.zzduf.zza(zzlVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onUserLeaveHint() {
        if (this.zzduf != null) {
            this.zzduf.onUserLeaveHint();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onPause() {
        if (this.zzduf != null) {
            this.zzduf.onPause();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onResume() {
        if (this.zzduf != null) {
            this.zzduf.onResume();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void zzvz() {
        if (this.zzduf != null) {
            this.zzduf.zzvz();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final synchronized void zzws() {
        if (this.zzduj != null) {
            this.zzduj.zzws();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final synchronized void zza(String str, Bundle bundle) {
        if (this.zzdic != null) {
            this.zzdic.zza(str, bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzdie != null) {
            this.zzdie.onAppEvent(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zza(zzve zzveVar, zzahn zzahnVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar, zzahp zzahpVar, com.google.android.gms.ads.internal.overlay.zzx zzxVar) {
        this.zzchr = zzveVar;
        this.zzdic = zzahnVar;
        this.zzduf = zzpVar;
        this.zzdie = zzahpVar;
        this.zzduj = zzxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcic(zzchz zzchzVar) {
        this();
    }
}
