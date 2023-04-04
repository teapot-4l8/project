package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfo extends zzgn {
    private final Activity zzaax;
    private final View zzaay;

    public zzfo(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i, int i2, View view, Activity activity) {
        super(zzfcVar, str, str2, zzbVar, i, 62);
        this.zzaay = view;
        this.zzaax = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        if (this.zzaay == null) {
            return;
        }
        boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcst)).booleanValue();
        Object[] objArr = (Object[]) this.zzabq.invoke(null, this.zzaay, this.zzaax, Boolean.valueOf(booleanValue));
        synchronized (this.zzabg) {
            this.zzabg.zzbp(((Long) objArr[0]).longValue());
            this.zzabg.zzbq(((Long) objArr[1]).longValue());
            if (booleanValue) {
                this.zzabg.zzaj((String) objArr[2]);
            }
        }
    }
}
