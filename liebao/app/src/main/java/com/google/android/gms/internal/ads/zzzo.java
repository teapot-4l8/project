package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzzo {
    private String zzadx;
    private String zzcie;
    private String zzcig;
    private String zzcik;
    private boolean zzcim;
    private AdInfo zzckq;
    private Date zznc;
    private Location zzng;
    private final HashSet<String> zzcky = new HashSet<>();
    private final Bundle zzckl = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzckz = new HashMap<>();
    private final HashSet<String> zzcla = new HashSet<>();
    private final Bundle zzcii = new Bundle();
    private final HashSet<String> zzclb = new HashSet<>();
    private final List<String> zzcin = new ArrayList();
    private int zzcib = -1;
    private boolean zzbns = false;
    private int zzadv = -1;
    private int zzadw = -1;
    private int zzcio = 60000;

    public final void zzcf(String str) {
        this.zzcky.add(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzckz.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzckl.putBundle(cls.getName(), bundle);
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzckl.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzckl.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzckl.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzcg(String str) {
        this.zzcla.add(str);
    }

    public final void zzch(String str) {
        this.zzcla.remove(str);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zznc = date;
    }

    public final void zzci(String str) {
        this.zzcig = str;
    }

    public final void zzc(List<String> list) {
        this.zzcin.clear();
        for (String str : list) {
            if (TextUtils.isEmpty(str)) {
                zzbao.zzez("neighboring content URL should not be null or empty");
            } else {
                this.zzcin.add(str);
            }
        }
    }

    @Deprecated
    public final void zzda(int i) {
        this.zzcib = i;
    }

    public final void zza(Location location) {
        this.zzng = location;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbns = z;
    }

    public final void zzcj(String str) {
        this.zzcie = str;
    }

    public final void zzck(String str) {
        this.zzcik = str;
    }

    @Deprecated
    public final void zzaa(boolean z) {
        this.zzadv = z ? 1 : 0;
    }

    public final void zzd(String str, String str2) {
        this.zzcii.putString(str, str2);
    }

    public final void zzcl(String str) {
        this.zzclb.add(str);
    }

    @Deprecated
    public final void zzab(boolean z) {
        this.zzcim = z;
    }

    public final void zza(AdInfo adInfo) {
        this.zzckq = adInfo;
    }

    @Deprecated
    public final void zzdb(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzadw = i;
        }
    }

    @Deprecated
    public final void zzcm(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzadx = str;
        }
    }

    public final void zzdc(int i) {
        this.zzcio = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Date zza(zzzo zzzoVar) {
        return zzzoVar.zznc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zzb(zzzo zzzoVar) {
        return zzzoVar.zzcig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List zzc(zzzo zzzoVar) {
        return zzzoVar.zzcin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzd(zzzo zzzoVar) {
        return zzzoVar.zzcib;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HashSet zze(zzzo zzzoVar) {
        return zzzoVar.zzcky;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Location zzf(zzzo zzzoVar) {
        return zzzoVar.zzng;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzg(zzzo zzzoVar) {
        return zzzoVar.zzbns;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bundle zzh(zzzo zzzoVar) {
        return zzzoVar.zzckl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HashMap zzi(zzzo zzzoVar) {
        return zzzoVar.zzckz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zzj(zzzo zzzoVar) {
        return zzzoVar.zzcie;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zzk(zzzo zzzoVar) {
        return zzzoVar.zzcik;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzl(zzzo zzzoVar) {
        return zzzoVar.zzadv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HashSet zzm(zzzo zzzoVar) {
        return zzzoVar.zzcla;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bundle zzn(zzzo zzzoVar) {
        return zzzoVar.zzcii;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HashSet zzo(zzzo zzzoVar) {
        return zzzoVar.zzclb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzp(zzzo zzzoVar) {
        return zzzoVar.zzcim;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AdInfo zzq(zzzo zzzoVar) {
        return zzzoVar.zzckq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzr(zzzo zzzoVar) {
        return zzzoVar.zzadw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zzs(zzzo zzzoVar) {
        return zzzoVar.zzadx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzt(zzzo zzzoVar) {
        return zzzoVar.zzcio;
    }
}
