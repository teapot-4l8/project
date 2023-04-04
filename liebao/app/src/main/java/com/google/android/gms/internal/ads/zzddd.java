package com.google.android.gms.internal.ads;

import android.os.Bundle;
import cn.jpush.android.service.WakedResultReceiver;
import com.umeng.analytics.pro.ak;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddd implements zzdhb<Bundle> {
    private final zzbar zzdvi;
    private final zzwc zzhdy;

    public zzddd(zzwc zzwcVar, zzbar zzbarVar) {
        this.zzhdy = zzwcVar;
        this.zzdvi = zzbarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        int intValue = ((Integer) zzww.zzra().zzd(zzabq.zzcws)).intValue();
        zzbar zzbarVar = this.zzdvi;
        if (zzbarVar != null && zzbarVar.zzekb >= intValue) {
            bundle2.putString("app_open_version", WakedResultReceiver.WAKE_TYPE_KEY);
        }
        zzwc zzwcVar = this.zzhdy;
        if (zzwcVar != null) {
            if (zzwcVar.orientation == 1) {
                bundle2.putString("avo", ak.ax);
            } else if (this.zzhdy.orientation == 2) {
                bundle2.putString("avo", "l");
            }
        }
    }
}
