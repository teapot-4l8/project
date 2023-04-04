package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzeqz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaxf implements zzaxo {
    private static List<Future<Void>> zzebi = Collections.synchronizedList(new ArrayList());
    private final Context context;
    private final zzaxn zzdyb;
    private final zzeqz.zzb.C0112zzb zzebj;
    private final LinkedHashMap<String, zzeqz.zzb.zzh.C0118zzb> zzebk;
    private final zzaxq zzebn;
    private boolean zzebo;
    private final List<String> zzebl = new ArrayList();
    private final List<String> zzebm = new ArrayList();
    private final Object lock = new Object();
    private HashSet<String> zzebp = new HashSet<>();
    private boolean zzebq = false;
    private boolean zzebr = false;
    private boolean zzebs = false;

    public zzaxf(Context context, zzbar zzbarVar, zzaxn zzaxnVar, String str, zzaxq zzaxqVar) {
        Preconditions.checkNotNull(zzaxnVar, "SafeBrowsing config is not present.");
        this.context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzebk = new LinkedHashMap<>();
        this.zzebn = zzaxqVar;
        this.zzdyb = zzaxnVar;
        for (String str2 : zzaxnVar.zzeca) {
            this.zzebp.add(str2.toLowerCase(Locale.ENGLISH));
        }
        this.zzebp.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzeqz.zzb.C0112zzb zzbmo = zzeqz.zzb.zzbmo();
        zzbmo.zzb(zzeqz.zzb.zzg.OCTAGON_AD);
        zzbmo.zzif(str);
        zzbmo.zzig(str);
        zzeqz.zzb.zza.C0111zza zzbmq = zzeqz.zzb.zza.zzbmq();
        if (this.zzdyb.zzebw != null) {
            zzbmq.zzii(this.zzdyb.zzebw);
        }
        zzbmo.zzb((zzeqz.zzb.zza) ((zzena) zzbmq.zzbjv()));
        zzeqz.zzb.zzi.zza zzca = zzeqz.zzb.zzi.zzbnf().zzca(Wrappers.packageManager(this.context).isCallerInstantApp());
        if (zzbarVar.zzbrz != null) {
            zzca.zzin(zzbarVar.zzbrz);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.context);
        if (apkVersion > 0) {
            zzca.zzft(apkVersion);
        }
        zzbmo.zzb((zzeqz.zzb.zzi) ((zzena) zzca.zzbjv()));
        this.zzebj = zzbmo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Void zzdy(String str) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final zzaxn zzxg() {
        return this.zzdyb;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void zzdw(String str) {
        synchronized (this.lock) {
            if (str == null) {
                this.zzebj.zzbms();
            } else {
                this.zzebj.zzih(str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final boolean zzxh() {
        return PlatformVersion.isAtLeastKitKat() && this.zzdyb.zzeby && !this.zzebr;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void zzl(View view) {
        if (this.zzdyb.zzeby && !this.zzebr) {
            com.google.android.gms.ads.internal.zzr.zzkv();
            Bitmap zzn = com.google.android.gms.ads.internal.util.zzj.zzn(view);
            if (zzn == null) {
                zzaxp.zzdz("Failed to capture the webview bitmap.");
                return;
            }
            this.zzebr = true;
            com.google.android.gms.ads.internal.util.zzj.zzc(new Runnable(this, zzn) { // from class: com.google.android.gms.internal.ads.zzaxe
                private final zzaxf zzebg;
                private final Bitmap zzebh;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzebg = this;
                    this.zzebh = zzn;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzebg.zza(this.zzebh);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void zza(String str, Map<String, String> map, int i) {
        synchronized (this.lock) {
            if (i == 3) {
                this.zzebs = true;
            }
            if (this.zzebk.containsKey(str)) {
                if (i == 3) {
                    this.zzebk.get(str).zzb(zzeqz.zzb.zzh.zza.zzij(i));
                }
                return;
            }
            zzeqz.zzb.zzh.C0118zzb zzbnd = zzeqz.zzb.zzh.zzbnd();
            zzeqz.zzb.zzh.zza zzij = zzeqz.zzb.zzh.zza.zzij(i);
            if (zzij != null) {
                zzbnd.zzb(zzij);
            }
            zzbnd.zzik(this.zzebk.size());
            zzbnd.zzil(str);
            zzeqz.zzb.zzd.C0114zzb zzbmv = zzeqz.zzb.zzd.zzbmv();
            if (this.zzebp.size() > 0 && map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey() != null ? entry.getKey() : "";
                    String value = entry.getValue() != null ? entry.getValue() : "";
                    if (this.zzebp.contains(key.toLowerCase(Locale.ENGLISH))) {
                        zzbmv.zzb((zzeqz.zzb.zzc) ((zzena) zzeqz.zzb.zzc.zzbmt().zzap(zzelq.zzhz(key)).zzaq(zzelq.zzhz(value)).zzbjv()));
                    }
                }
            }
            zzbnd.zzb((zzeqz.zzb.zzd) ((zzena) zzbmv.zzbjv()));
            this.zzebk.put(str, zzbnd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void zzxi() {
        this.zzebq = true;
    }

    private final zzeqz.zzb.zzh.C0118zzb zzdx(String str) {
        zzeqz.zzb.zzh.C0118zzb c0118zzb;
        synchronized (this.lock) {
            c0118zzb = this.zzebk.get(str);
        }
        return c0118zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void zzxj() {
        synchronized (this.lock) {
            zzebt zzb = zzebh.zzb(this.zzebn.zza(this.context, this.zzebk.keySet()), new zzear(this) { // from class: com.google.android.gms.internal.ads.zzaxh
                private final zzaxf zzebg;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzebg = this;
                }

                @Override // com.google.android.gms.internal.ads.zzear
                public final zzebt zzf(Object obj) {
                    return this.zzebg.zzi((Map) obj);
                }
            }, zzbat.zzekj);
            zzebt zza = zzebh.zza(zzb, 10L, TimeUnit.SECONDS, zzbat.zzekh);
            zzebh.zza(zzb, new zzaxi(this, zza), zzbat.zzekj);
            zzebi.add(zza);
        }
    }

    private final zzebt<Void> zzxk() {
        zzebt<Void> zzb;
        if (!((this.zzebo && this.zzdyb.zzecc) || (this.zzebs && this.zzdyb.zzecb) || (!this.zzebo && this.zzdyb.zzebz))) {
            return zzebh.zzag(null);
        }
        synchronized (this.lock) {
            for (zzeqz.zzb.zzh.C0118zzb c0118zzb : this.zzebk.values()) {
                this.zzebj.zzb((zzeqz.zzb.zzh) ((zzena) c0118zzb.zzbjv()));
            }
            this.zzebj.zzo(this.zzebl);
            this.zzebj.zzp(this.zzebm);
            if (zzaxp.isEnabled()) {
                String url = this.zzebj.getUrl();
                String zzbmm = this.zzebj.zzbmm();
                StringBuilder sb = new StringBuilder(String.valueOf(url).length() + 53 + String.valueOf(zzbmm).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(url);
                sb.append("\n  clickUrl: ");
                sb.append(zzbmm);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzeqz.zzb.zzh zzhVar : this.zzebj.zzbml()) {
                    sb2.append("    [");
                    sb2.append(zzhVar.zzbnc());
                    sb2.append("] ");
                    sb2.append(zzhVar.getUrl());
                }
                zzaxp.zzdz(sb2.toString());
            }
            zzebt<String> zza = new com.google.android.gms.ads.internal.util.zzay(this.context).zza(1, this.zzdyb.zzebx, null, ((zzeqz.zzb) ((zzena) this.zzebj.zzbjv())).toByteArray());
            if (zzaxp.isEnabled()) {
                zza.addListener(zzaxg.zzebt, zzbat.zzeke);
            }
            zzb = zzebh.zzb(zza, zzaxj.zzebv, zzbat.zzekj);
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzi(Map map) {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.lock) {
                            int length = optJSONArray.length();
                            zzeqz.zzb.zzh.C0118zzb zzdx = zzdx(str);
                            if (zzdx == null) {
                                String valueOf = String.valueOf(str);
                                zzaxp.zzdz(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                for (int i = 0; i < length; i++) {
                                    zzdx.zzim(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                this.zzebo = (length > 0) | this.zzebo;
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                if (zzadt.zzdfx.get().booleanValue()) {
                    com.google.android.gms.ads.internal.util.zzd.zzb("Failed to get SafeBrowsing metadata", e2);
                }
                return zzebh.immediateFailedFuture(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzebo) {
            synchronized (this.lock) {
                this.zzebj.zzb(zzeqz.zzb.zzg.OCTAGON_AD_SB_MATCH);
            }
        }
        return zzxk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bitmap bitmap) {
        zzelz zzbhk = zzelq.zzbhk();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzbhk);
        synchronized (this.lock) {
            this.zzebj.zzb((zzeqz.zzb.zzf) ((zzena) zzeqz.zzb.zzf.zzbna().zzas(zzbhk.zzbgy()).zzij("image/png").zzb(zzeqz.zzb.zzf.zza.TYPE_CREATIVE).zzbjv()));
        }
    }
}
