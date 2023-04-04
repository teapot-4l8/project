package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzasg;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzu extends zzasg {
    private Activity zzaax;
    private AdOverlayInfoParcel zzdus;
    private boolean zzdth = false;
    private boolean zzdut = false;

    public zzu(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdus = adOverlayInfoParcel;
        this.zzaax = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onBackPressed() {
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onRestart() {
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onStart() {
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void zzae(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void zzdq() {
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final boolean zzwh() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onCreate(Bundle bundle) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbq)).booleanValue()) {
            this.zzaax.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdus;
        if (adOverlayInfoParcel == null) {
            this.zzaax.finish();
        } else if (z) {
            this.zzaax.finish();
        } else {
            if (bundle == null) {
                if (adOverlayInfoParcel.zzchr != null) {
                    this.zzdus.zzchr.onAdClicked();
                }
                if (this.zzaax.getIntent() != null && this.zzaax.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && this.zzdus.zzduf != null) {
                    this.zzdus.zzduf.zzvz();
                }
            }
            com.google.android.gms.ads.internal.zzr.zzkt();
            if (zza.zza(this.zzaax, this.zzdus.zzdue, this.zzdus.zzduj, this.zzdus.zzdue.zzdjj)) {
                return;
            }
            this.zzaax.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onResume() {
        if (this.zzdth) {
            this.zzaax.finish();
            return;
        }
        this.zzdth = true;
        if (this.zzdus.zzduf != null) {
            this.zzdus.zzduf.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdth);
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onPause() {
        if (this.zzdus.zzduf != null) {
            this.zzdus.zzduf.onPause();
        }
        if (this.zzaax.isFinishing()) {
            zzwr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onUserLeaveHint() {
        if (this.zzdus.zzduf != null) {
            this.zzdus.zzduf.onUserLeaveHint();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onStop() {
        if (this.zzaax.isFinishing()) {
            zzwr();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzash
    public final void onDestroy() {
        if (this.zzaax.isFinishing()) {
            zzwr();
        }
    }

    private final synchronized void zzwr() {
        if (!this.zzdut) {
            if (this.zzdus.zzduf != null) {
                this.zzdus.zzduf.zza(zzl.OTHER);
            }
            this.zzdut = true;
        }
    }
}
