package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdwp {
    private final SharedPreferences zzcmn;
    private final File zzhxm;
    private final File zzhxn;
    private final zzgp zzvz;

    public zzdwp(Context context, zzgp zzgpVar) {
        this.zzcmn = context.getSharedPreferences("pcvmspf", 0);
        this.zzhxm = zzdwo.zza(context.getDir("pccache", 0), false);
        this.zzhxn = zzdwo.zza(context.getDir("tmppccache", 0), true);
        this.zzvz = zzgpVar;
    }

    public final zzdwm zzp(int i) {
        zzgv zzer = zzer(i);
        if (zzer == null) {
            return null;
        }
        String zzdh = zzer.zzdh();
        File zza = zzdwo.zza(zzdh, "pcam.jar", zzazq());
        if (!zza.exists()) {
            zza = zzdwo.zza(zzdh, "pcam", zzazq());
        }
        return new zzdwm(zzer, zza, zzdwo.zza(zzdh, "pcbc", zzazq()), zzdwo.zza(zzdh, "pcopt", zzazq()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0140, code lost:
        if (r0.commit() != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(zzgr zzgrVar, zzdwv zzdwvVar) {
        boolean z;
        boolean z2;
        zzgv zzer;
        zzgv zzer2;
        String zzdh = zzgrVar.zzdd().zzdh();
        byte[] byteArray = zzgrVar.zzde().toByteArray();
        byte[] byteArray2 = zzgrVar.zzdf().toByteArray();
        if (!TextUtils.isEmpty(zzdh) && byteArray2 != null && byteArray2.length != 0) {
            zzdwo.zze(this.zzhxn);
            this.zzhxn.mkdirs();
            zzdwo.zza(zzdh, this.zzhxn).mkdirs();
            File zza = zzdwo.zza(zzdh, "pcam.jar", this.zzhxn);
            if (byteArray == null || byteArray.length <= 0 || zzdwo.zza(zza, byteArray)) {
                z = zzdwo.zza(zzdwo.zza(zzdh, "pcbc", this.zzhxn), byteArray2);
                if (z) {
                    return false;
                }
                File zza2 = zzdwo.zza(zzgrVar.zzdd().zzdh(), "pcam.jar", this.zzhxn);
                if (!zza2.exists() || zzdwvVar == null || zzdwvVar.zzb(zza2)) {
                    String zzdh2 = zzgrVar.zzdd().zzdh();
                    boolean z3 = true;
                    if (!TextUtils.isEmpty(zzdh2)) {
                        File zza3 = zzdwo.zza(zzdh2, "pcam.jar", this.zzhxn);
                        File zza4 = zzdwo.zza(zzdh2, "pcbc", this.zzhxn);
                        File zza5 = zzdwo.zza(zzdh2, "pcam.jar", zzazq());
                        File zza6 = zzdwo.zza(zzdh2, "pcbc", zzazq());
                        if ((!zza3.exists() || zza3.renameTo(zza5)) && zza4.exists() && zza4.renameTo(zza6)) {
                            z2 = true;
                            if (z2) {
                                zzgv zzgvVar = (zzgv) ((zzena) zzgv.zzdm().zzav(zzgrVar.zzdd().zzdh()).zzaw(zzgrVar.zzdd().zzdi()).zzdk(zzgrVar.zzdd().zzdk()).zzdl(zzgrVar.zzdd().zzdl()).zzdj(zzgrVar.zzdd().zzdj()).zzbjv());
                                zzgv zzer3 = zzer(zzdwx.zzhxv);
                                SharedPreferences.Editor edit = this.zzcmn.edit();
                                if (zzer3 != null && !zzgvVar.zzdh().equals(zzer3.zzdh())) {
                                    edit.putString(zzazr(), zza(zzer3));
                                }
                                edit.putString(zzazs(), zza(zzgvVar));
                            }
                            z3 = false;
                            HashSet hashSet = new HashSet();
                            zzer = zzer(zzdwx.zzhxv);
                            if (zzer != null) {
                                hashSet.add(zzer.zzdh());
                            }
                            zzer2 = zzer(zzdwx.zzhxw);
                            if (zzer2 != null) {
                                hashSet.add(zzer2.zzdh());
                            }
                            for (File file : zzazq().listFiles()) {
                                String name = file.getName();
                                if (!hashSet.contains(name)) {
                                    zzdwo.zze(zzdwo.zza(name, zzazq()));
                                }
                            }
                            return z3;
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                    z3 = false;
                    HashSet hashSet2 = new HashSet();
                    zzer = zzer(zzdwx.zzhxv);
                    if (zzer != null) {
                    }
                    zzer2 = zzer(zzdwx.zzhxw);
                    if (zzer2 != null) {
                    }
                    while (r6 < r0) {
                    }
                    return z3;
                }
                return false;
            }
        }
        z = false;
        if (z) {
        }
    }

    private final File zzazq() {
        File file = new File(this.zzhxm, Integer.toString(this.zzvz.zzv()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private static String zza(zzgv zzgvVar) {
        return Hex.bytesToStringLowercase(zzgvVar.zzbgy().toByteArray());
    }

    private final String zzazr() {
        int zzv = this.zzvz.zzv();
        StringBuilder sb = new StringBuilder(17);
        sb.append("FBAMTD");
        sb.append(zzv);
        return sb.toString();
    }

    private final String zzazs() {
        int zzv = this.zzvz.zzv();
        StringBuilder sb = new StringBuilder(17);
        sb.append("LATMTD");
        sb.append(zzv);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzgv zzer(int i) {
        String string;
        zzgv zzl;
        File zza;
        File zza2;
        boolean z;
        if (i == zzdwx.zzhxv) {
            string = this.zzcmn.getString(zzazs(), null);
        } else {
            string = i == zzdwx.zzhxw ? this.zzcmn.getString(zzazr(), null) : null;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            zzl = zzgv.zzl(zzelq.zzt(Hex.stringToBytes(string)));
            String zzdh = zzl.zzdh();
            zza = zzdwo.zza(zzdh, "pcam.jar", zzazq());
            if (!zza.exists()) {
                zza = zzdwo.zza(zzdh, "pcam", zzazq());
            }
            zza2 = zzdwo.zza(zzdh, "pcbc", zzazq());
        } catch (zzenn unused) {
        }
        if (zza.exists()) {
            if (zza2.exists()) {
                z = true;
                if (z) {
                    return null;
                }
                return zzl;
            }
        }
        z = false;
        if (z) {
        }
    }
}
