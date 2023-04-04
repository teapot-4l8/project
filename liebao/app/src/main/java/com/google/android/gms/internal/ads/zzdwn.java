package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import com.umeng.analytics.pro.ak;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdwn implements zzdvb {
    private final Object zzhxj;
    private final zzdwm zzhxk;
    private final zzdwy zzhxl;
    private final zzduv zzvx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdwn(Object obj, zzdwm zzdwmVar, zzdwy zzdwyVar, zzduv zzduvVar) {
        this.zzhxj = obj;
        this.zzhxk = zzdwmVar;
        this.zzhxl = zzdwyVar;
        this.zzvx = zzduvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdwm zzazn() {
        return this.zzhxk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean zzazo() {
        try {
        } catch (Exception e2) {
            throw new zzdww(2001, e2);
        }
        return ((Boolean) this.zzhxj.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zzhxj, new Object[0])).booleanValue();
    }

    public final synchronized void close() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zzhxj.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zzhxj, new Object[0]);
            this.zzvx.zzh(3001, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e2) {
            throw new zzdww(2003, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvb
    public final synchronized String zzs(Context context, String str) {
        Map<String, Object> zzcd;
        zzcd = this.zzhxl.zzcd();
        zzcd.put("f", "q");
        zzcd.put("ctx", context);
        zzcd.put("aid", null);
        return zzj(zzd(null, zzcd));
    }

    @Override // com.google.android.gms.internal.ads.zzdvb
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map<String, Object> zzce;
        zzce = this.zzhxl.zzce();
        zzce.put("f", ak.aE);
        zzce.put("ctx", context);
        zzce.put("aid", null);
        zzce.put("view", view);
        zzce.put("act", activity);
        return zzj(zzd(null, zzce));
    }

    @Override // com.google.android.gms.internal.ads.zzdvb
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> zzcf;
        zzcf = this.zzhxl.zzcf();
        zzcf.put("f", ak.aF);
        zzcf.put("ctx", context);
        zzcf.put("cs", str2);
        zzcf.put("aid", null);
        zzcf.put("view", view);
        zzcf.put("act", activity);
        return zzj(zzd(null, zzcf));
    }

    @Override // com.google.android.gms.internal.ads.zzdvb
    public final synchronized void zza(String str, MotionEvent motionEvent) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("aid", null);
            hashMap.put("evt", motionEvent);
            this.zzhxj.getClass().getDeclaredMethod("he", Map.class).invoke(this.zzhxj, hashMap);
            this.zzvx.zzh(3003, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e2) {
            throw new zzdww(2005, e2);
        }
    }

    public final synchronized int zzazp() {
        try {
        } catch (Exception e2) {
            throw new zzdww(2006, e2);
        }
        return ((Integer) this.zzhxj.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zzhxj, new Object[0])).intValue();
    }

    private static String zzj(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(((zzcf.zzf) ((zzena) zzcf.zzf.zzbm().zza(zzcm.DG).zzi(zzelq.zzt(bArr)).zzbjv())).toByteArray(), 11);
    }

    private final synchronized byte[] zzd(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e2) {
            this.zzvx.zza(2007, System.currentTimeMillis() - currentTimeMillis, e2);
            return null;
        }
        return (byte[]) this.zzhxj.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.zzhxj, null, map2);
    }
}
