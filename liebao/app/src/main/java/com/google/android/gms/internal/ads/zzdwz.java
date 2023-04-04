package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.umeng.analytics.pro.ak;
import com.youth.banner.config.BannerConfig;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdwz {
    private static final HashMap<String, Class<?>> zzhxz = new HashMap<>();
    private final Context context;
    private final zzdwy zzhxl;
    private final zzduu zzhya;
    private zzdwn zzhyb;
    private final Object zzhyc = new Object();
    private final zzduv zzvx;

    public zzdwz(Context context, zzdwy zzdwyVar, zzduv zzduvVar, zzduu zzduuVar) {
        this.context = context;
        this.zzhxl = zzdwyVar;
        this.zzvx = zzduvVar;
        this.zzhya = zzduuVar;
    }

    private final synchronized Class<?> zza(zzdwm zzdwmVar) {
        if (zzdwmVar.zzazj() == null) {
            throw new zzdww(4010, ak.A);
        }
        String zzdh = zzdwmVar.zzazj().zzdh();
        Class<?> cls = zzhxz.get(zzdh);
        if (cls != null) {
            return cls;
        }
        try {
            if (!this.zzhya.zzb(zzdwmVar.zzazk())) {
                throw new zzdww(2026, "VM did not pass signature verification");
            }
            try {
                File zzazl = zzdwmVar.zzazl();
                if (!zzazl.exists()) {
                    zzazl.mkdirs();
                }
                Class<?> loadClass = new DexClassLoader(zzdwmVar.zzazk().getAbsolutePath(), zzazl.getAbsolutePath(), null, this.context.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                zzhxz.put(zzdh, loadClass);
                return loadClass;
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e2) {
                throw new zzdww(2008, e2);
            }
        } catch (GeneralSecurityException e3) {
            throw new zzdww(2026, e3);
        }
    }

    private final Object zza(Class<?> cls, zzdwm zzdwmVar) {
        try {
            return cls.getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.context, "msa-r", zzdwmVar.zzazm(), null, new Bundle(), 2);
        } catch (Exception e2) {
            throw new zzdww(2004, e2);
        }
    }

    public final void zzb(zzdwm zzdwmVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzdwn zzdwnVar = new zzdwn(zza(zza(zzdwmVar), zzdwmVar), zzdwmVar, this.zzhxl, this.zzvx);
            if (!zzdwnVar.zzazo()) {
                throw new zzdww(4000, "init failed");
            }
            int zzazp = zzdwnVar.zzazp();
            if (zzazp != 0) {
                StringBuilder sb = new StringBuilder(15);
                sb.append("ci: ");
                sb.append(zzazp);
                throw new zzdww(4001, sb.toString());
            }
            synchronized (this.zzhyc) {
                if (this.zzhyb != null) {
                    try {
                        this.zzhyb.close();
                    } catch (zzdww e2) {
                        this.zzvx.zza(e2.zzazt(), -1L, e2);
                    }
                }
                this.zzhyb = zzdwnVar;
            }
            this.zzvx.zzh(BannerConfig.LOOP_TIME, System.currentTimeMillis() - currentTimeMillis);
        } catch (zzdww e3) {
            this.zzvx.zza(e3.zzazt(), System.currentTimeMillis() - currentTimeMillis, e3);
        } catch (Exception e4) {
            this.zzvx.zza(4010, System.currentTimeMillis() - currentTimeMillis, e4);
        }
    }

    public final zzdvb zzazu() {
        zzdwn zzdwnVar;
        synchronized (this.zzhyc) {
            zzdwnVar = this.zzhyb;
        }
        return zzdwnVar;
    }

    public final zzdwm zzazv() {
        synchronized (this.zzhyc) {
            if (this.zzhyb != null) {
                return this.zzhyb.zzazn();
            }
            return null;
        }
    }
}
