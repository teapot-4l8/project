package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbch {
    private final Context zzcmo;
    private final zzbcs zzekz;
    private final ViewGroup zzems;
    private zzbcb zzemt;

    public zzbch(Context context, ViewGroup viewGroup, zzbfi zzbfiVar) {
        this(context, viewGroup, zzbfiVar, null);
    }

    private zzbch(Context context, ViewGroup viewGroup, zzbcs zzbcsVar, zzbcb zzbcbVar) {
        this.zzcmo = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzems = viewGroup;
        this.zzekz = zzbcsVar;
        this.zzemt = null;
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbcb zzbcbVar = this.zzemt;
        if (zzbcbVar != null) {
            zzbcbVar.zzd(i, i2, i3, i4);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbcp zzbcpVar) {
        if (this.zzemt != null) {
            return;
        }
        zzaby.zza(this.zzekz.zzacb().zzsr(), this.zzekz.zzabw(), "vpr2");
        Context context = this.zzcmo;
        zzbcs zzbcsVar = this.zzekz;
        zzbcb zzbcbVar = new zzbcb(context, zzbcsVar, i5, z, zzbcsVar.zzacb().zzsr(), zzbcpVar);
        this.zzemt = zzbcbVar;
        this.zzems.addView(zzbcbVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzemt.zzd(i, i2, i3, i4);
        this.zzekz.zzaz(false);
    }

    public final zzbcb zzabo() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzemt;
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbcb zzbcbVar = this.zzemt;
        if (zzbcbVar != null) {
            zzbcbVar.pause();
        }
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbcb zzbcbVar = this.zzemt;
        if (zzbcbVar != null) {
            zzbcbVar.destroy();
            this.zzems.removeView(this.zzemt);
            this.zzemt = null;
        }
    }
}
