package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfk implements zzdhe<zzdfh> {
    private final PackageInfo zzdvo;
    private final com.google.android.gms.ads.internal.util.zzf zzecl;
    private final zzdpm zzfzg;
    private final zzebs zzgka;

    public zzdfk(zzebs zzebsVar, zzdpm zzdpmVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzgka = zzebsVar;
        this.zzfzg = zzdpmVar;
        this.zzdvo = packageInfo;
        this.zzecl = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdfh> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdfj
            private final zzdfk zzhff;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhff = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhff.zzauh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f9, code lost:
        if (r9 == 3) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void zza(ArrayList arrayList, Bundle bundle) {
        JSONArray optJSONArray;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", this.zzfzg.zzhoa);
        String str = "landscape";
        if (((Boolean) zzww.zzra().zzd(zzabq.zzctw)).booleanValue() && this.zzfzg.zzdpr.versionCode > 3) {
            bundle.putBoolean("enable_native_media_orientation", true);
            int i = this.zzfzg.zzdpr.zzbod;
            String str2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unknown" : "square" : "portrait" : "landscape" : "any";
            if (!"unknown".equals(str2)) {
                bundle.putString("native_media_orientation", str2);
            }
        }
        int i2 = this.zzfzg.zzdpr.zzboc;
        if (i2 == 0) {
            str = "any";
        } else if (i2 == 1) {
            str = "portrait";
        } else if (i2 != 2) {
            str = "unknown";
        }
        if (!"unknown".equals(str)) {
            bundle.putString("native_image_orientation", str);
        }
        bundle.putBoolean("native_multiple_images", this.zzfzg.zzdpr.zzboe);
        bundle.putBoolean("use_custom_mute", this.zzfzg.zzdpr.zzboh);
        PackageInfo packageInfo = this.zzdvo;
        int i3 = packageInfo == null ? 0 : packageInfo.versionCode;
        if (i3 > this.zzecl.zzzf()) {
            this.zzecl.zzzl();
            this.zzecl.zzdi(i3);
        }
        JSONObject zzzk = this.zzecl.zzzk();
        String jSONArray = (zzzk == null || (optJSONArray = zzzk.optJSONArray(this.zzfzg.zzhny)) == null) ? null : optJSONArray.toString();
        if (!TextUtils.isEmpty(jSONArray)) {
            bundle.putString("native_advanced_settings", jSONArray);
        }
        if (this.zzfzg.zzhby > 1) {
            bundle.putInt("max_num_ads", this.zzfzg.zzhby);
        }
        zzajy zzajyVar = this.zzfzg.zzdxd;
        if (zzajyVar != null) {
            if (TextUtils.isEmpty(zzajyVar.zzdkh)) {
                int i4 = zzajyVar.versionCode;
                String str3 = ak.ax;
                if (i4 >= 2) {
                    int i5 = zzajyVar.zzbod;
                    if (i5 != 2) {
                    }
                    str3 = "l";
                    bundle.putString("ia_var", str3);
                } else {
                    int i6 = zzajyVar.zzdkg;
                    if (i6 != 1) {
                        if (i6 != 2) {
                            int i7 = zzajyVar.zzdkg;
                            StringBuilder sb = new StringBuilder(52);
                            sb.append("Instream ad video aspect ratio ");
                            sb.append(i7);
                            sb.append(" is wrong.");
                            zzbao.zzex(sb.toString());
                        }
                        bundle.putString("ia_var", str3);
                    }
                    str3 = "l";
                    bundle.putString("ia_var", str3);
                }
            } else {
                bundle.putString("ad_tag", zzajyVar.zzdkh);
            }
            bundle.putBoolean("instr", true);
        }
        if (this.zzfzg.zzawb() != null) {
            bundle.putBoolean("has_delayed_banner_listener", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdfh zzauh() {
        ArrayList<String> arrayList = this.zzfzg.zzhnz;
        if (arrayList == null) {
            return zzdfm.zzhfg;
        }
        if (arrayList.isEmpty()) {
            return zzdfl.zzhfg;
        }
        return new zzdfh(this, arrayList) { // from class: com.google.android.gms.internal.ads.zzdfo
            private final zzdfk zzhff;
            private final ArrayList zzhfh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhff = this;
                this.zzhfh = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdhb
            public final void zzr(Bundle bundle) {
                this.zzhff.zza(this.zzhfh, bundle);
            }
        };
    }
}
