package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcq implements zzdhb<Bundle> {
    private final String zzadd;
    private final zzvt zzbpy;
    private final float zzbsn;
    private final boolean zzcit;
    private final int zzdrr;
    private final int zzdrs;
    private final String zzhdl;
    private final String zzhdm;
    private final boolean zzhdn;

    public zzdcq(zzvt zzvtVar, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzvtVar, "the adSize must not be null");
        this.zzbpy = zzvtVar;
        this.zzadd = str;
        this.zzcit = z;
        this.zzhdl = str2;
        this.zzbsn = f;
        this.zzdrr = i;
        this.zzdrs = i2;
        this.zzhdm = str3;
        this.zzhdn = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        String str;
        zzvt[] zzvtVarArr;
        Bundle bundle2 = bundle;
        zzdpw.zza(bundle2, "smart_w", "full", this.zzbpy.width == -1);
        zzdpw.zza(bundle2, "smart_h", "auto", this.zzbpy.height == -2);
        zzdpw.zza(bundle2, "ene", (Boolean) true, this.zzbpy.zzciu);
        zzdpw.zza(bundle2, "rafmt", "102", this.zzbpy.zzcix);
        zzdpw.zza(bundle2, "rafmt", "103", this.zzbpy.zzciy);
        zzdpw.zza(bundle2, "rafmt", "105", this.zzbpy.zzadh);
        zzdpw.zza(bundle2, "inline_adaptive_slot", (Boolean) true, this.zzhdn);
        zzdpw.zza(bundle2, "interscroller_slot", (Boolean) true, this.zzbpy.zzadh);
        zzdpw.zza(bundle2, "format", this.zzadd);
        zzdpw.zza(bundle2, "fluid", "height", this.zzcit);
        zzdpw.zza(bundle2, "sz", this.zzhdl, !TextUtils.isEmpty(str));
        bundle2.putFloat("u_sd", this.zzbsn);
        bundle2.putInt("sw", this.zzdrr);
        bundle2.putInt("sh", this.zzdrs);
        String str2 = this.zzhdm;
        zzdpw.zza(bundle2, "sc", str2, true ^ TextUtils.isEmpty(str2));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        if (this.zzbpy.zzcis == null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("height", this.zzbpy.height);
            bundle3.putInt("width", this.zzbpy.width);
            bundle3.putBoolean("is_fluid_height", this.zzbpy.zzcit);
            arrayList.add(bundle3);
        } else {
            for (zzvt zzvtVar : this.zzbpy.zzcis) {
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("is_fluid_height", zzvtVar.zzcit);
                bundle4.putInt("height", zzvtVar.height);
                bundle4.putInt("width", zzvtVar.width);
                arrayList.add(bundle4);
            }
        }
        bundle2.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
