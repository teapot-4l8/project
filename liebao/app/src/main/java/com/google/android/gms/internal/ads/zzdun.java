package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdun {
    private final Context context;
    private final Clock zzbqq;
    private final String zzbrz;
    private final String zzckb;
    private final String zzdvq;
    private final zzei zzftt;
    private final zzdph zzgbf;
    private final zzcwk zzgda;

    public zzdun(zzcwk zzcwkVar, zzbar zzbarVar, String str, String str2, Context context, zzdph zzdphVar, Clock clock, zzei zzeiVar) {
        this.zzgda = zzcwkVar;
        this.zzbrz = zzbarVar.zzbrz;
        this.zzdvq = str;
        this.zzckb = str2;
        this.context = context;
        this.zzgbf = zzdphVar;
        this.zzbqq = clock;
        this.zzftt = zzeiVar;
    }

    public final List<String> zza(zzdpi zzdpiVar, zzdot zzdotVar, List<String> list) {
        return zza(zzdpiVar, zzdotVar, false, "", "", list);
    }

    public static List<String> zza(int i, int i2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            StringBuilder sb = new StringBuilder(23);
            sb.append(2);
            sb.append(".");
            sb.append(i2);
            arrayList.add(zzc(str, "@gw_mpe@", sb.toString()));
        }
        return arrayList;
    }

    public final List<String> zza(zzdpi zzdpiVar, zzdot zzdotVar, boolean z, String str, String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = z ? "1" : "0";
        for (String str4 : list) {
            String zzc = zzc(zzc(zzc(str4, "@gw_adlocid@", zzdpiVar.zzhns.zzfzg.zzhny), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzbrz);
            if (zzdotVar != null) {
                zzc = zzayv.zzc(zzc(zzc(zzc(zzc, "@gw_qdata@", zzdotVar.zzdng), "@gw_adnetid@", zzdotVar.id), "@gw_allocid@", zzdotVar.zzdnw), this.context, zzdotVar.zzdyj);
            }
            String zzc2 = zzc(zzc(zzc(zzc, "@gw_adnetstatus@", this.zzgda.zzasy()), "@gw_seqnum@", this.zzdvq), "@gw_sessid@", this.zzckb);
            boolean z2 = ((Boolean) zzww.zzra().zzd(zzabq.zzctj)).booleanValue() && !TextUtils.isEmpty(str);
            boolean isEmpty = true ^ TextUtils.isEmpty(str2);
            if (z2 || isEmpty) {
                if (this.zzftt.zzb(Uri.parse(zzc2))) {
                    Uri.Builder buildUpon = Uri.parse(zzc2).buildUpon();
                    if (z2) {
                        buildUpon = buildUpon.appendQueryParameter("ms", str);
                    }
                    if (isEmpty) {
                        buildUpon = buildUpon.appendQueryParameter("attok", str2);
                    }
                    zzc2 = buildUpon.build().toString();
                }
            }
            arrayList.add(zzc2);
        }
        return arrayList;
    }

    public final List<String> zza(zzdot zzdotVar, List<String> list, zzavd zzavdVar) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = this.zzbqq.currentTimeMillis();
        try {
            String type = zzavdVar.getType();
            String num = Integer.toString(zzavdVar.getAmount());
            zzdph zzdphVar = this.zzgbf;
            String zzhc = zzdphVar == null ? "" : zzhc(zzdphVar.zzear);
            zzdph zzdphVar2 = this.zzgbf;
            String zzhc2 = zzdphVar2 != null ? zzhc(zzdphVar2.zzeas) : "";
            for (String str : list) {
                arrayList.add(zzayv.zzc(zzc(zzc(zzc(zzc(zzc(zzc(str, "@gw_rwd_userid@", Uri.encode(zzhc)), "@gw_rwd_custom_data@", Uri.encode(zzhc2)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzbrz), this.context, zzdotVar.zzdyj));
            }
            return arrayList;
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Unable to determine award type and amount.", e2);
            return arrayList;
        }
    }

    private static String zzc(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    private static String zzhc(String str) {
        return (TextUtils.isEmpty(str) || !zzbai.isEnabled()) ? str : "fakeForAdDebugLog";
    }
}
