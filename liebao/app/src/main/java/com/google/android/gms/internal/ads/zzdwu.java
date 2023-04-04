package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdwu {
    private static final Object zzhxt = new Object();
    private final Context context;
    private final SharedPreferences zzcmn;
    private final String zzhxq;
    private final zzdwd zzhxr;
    private boolean zzhxs;

    public zzdwu(Context context, zzgp zzgpVar, zzdwd zzdwdVar, boolean z) {
        this(context, zzgpVar, zzdwdVar);
        this.zzhxs = z;
    }

    private zzdwu(Context context, zzgp zzgpVar, zzdwd zzdwdVar) {
        this.zzhxs = false;
        this.context = context;
        this.zzhxq = Integer.toString(zzgpVar.zzv());
        this.zzcmn = context.getSharedPreferences("pcvmspf", 0);
        this.zzhxr = zzdwdVar;
    }

    public final zzdwm zzp(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzhxt) {
            zzgv zzer = zzer(i);
            if (zzer == null) {
                zza(4022, currentTimeMillis);
                return null;
            }
            File zzhk = zzhk(zzer.zzdh());
            File file = new File(zzhk, "pcam.jar");
            if (!file.exists()) {
                file = new File(zzhk, "pcam");
            }
            File file2 = new File(zzhk, "pcbc");
            File file3 = new File(zzhk, "pcopt");
            zza(5016, currentTimeMillis);
            return new zzdwm(zzer, file, file2, file3);
        }
    }

    public final boolean zzes(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzhxt) {
            zzgv zzer = zzer(i);
            if (zzer == null) {
                zza(4025, currentTimeMillis);
                return false;
            }
            File zzhk = zzhk(zzer.zzdh());
            if (!new File(zzhk, "pcam.jar").exists()) {
                zza(4026, currentTimeMillis);
                return false;
            } else if (!new File(zzhk, "pcbc").exists()) {
                zza(4027, currentTimeMillis);
                return false;
            } else {
                zza(5019, currentTimeMillis);
                return true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1 A[Catch: all -> 0x018b, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x001c, B:8:0x0026, B:9:0x002b, B:11:0x002d, B:13:0x003e, B:17:0x004b, B:21:0x0056, B:35:0x00b1, B:37:0x00b3, B:39:0x00d3, B:40:0x00d8, B:42:0x00da, B:44:0x00e8, B:45:0x00ed, B:48:0x00f1, B:50:0x00f7, B:51:0x00ff, B:53:0x0101, B:55:0x0123, B:56:0x012a, B:58:0x0130, B:60:0x0137, B:62:0x0139, B:64:0x0146, B:65:0x014d, B:67:0x0155, B:68:0x015c, B:70:0x0172, B:72:0x017e, B:73:0x0181, B:74:0x0184, B:75:0x0189, B:22:0x0081, B:24:0x0087, B:28:0x0096, B:30:0x009c, B:32:0x00a6, B:31:0x00a1), top: B:82:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3 A[Catch: all -> 0x018b, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x001c, B:8:0x0026, B:9:0x002b, B:11:0x002d, B:13:0x003e, B:17:0x004b, B:21:0x0056, B:35:0x00b1, B:37:0x00b3, B:39:0x00d3, B:40:0x00d8, B:42:0x00da, B:44:0x00e8, B:45:0x00ed, B:48:0x00f1, B:50:0x00f7, B:51:0x00ff, B:53:0x0101, B:55:0x0123, B:56:0x012a, B:58:0x0130, B:60:0x0137, B:62:0x0139, B:64:0x0146, B:65:0x014d, B:67:0x0155, B:68:0x015c, B:70:0x0172, B:72:0x017e, B:73:0x0181, B:74:0x0184, B:75:0x0189, B:22:0x0081, B:24:0x0087, B:28:0x0096, B:30:0x009c, B:32:0x00a6, B:31:0x00a1), top: B:82:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(zzgr zzgrVar, zzdwv zzdwvVar) {
        boolean z;
        File[] listFiles;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzhxt) {
            zzgv zzer = zzer(zzdwx.zzhxv);
            String zzdh = zzgrVar.zzdd().zzdh();
            if (zzer != null && zzer.zzdh().equals(zzdh)) {
                zza(4014, currentTimeMillis);
                return false;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            File zzhk = zzhk(zzdh);
            if (zzhk.exists()) {
                String str = zzhk.isDirectory() ? "1" : "0";
                String str2 = zzhk.isFile() ? "1" : "0";
                StringBuilder sb = new StringBuilder(str.length() + 5 + str2.length());
                sb.append("d:");
                sb.append(str);
                sb.append(",f:");
                sb.append(str2);
                zza(4023, currentTimeMillis2, sb.toString());
                zza(4015, currentTimeMillis2);
            } else if (!zzhk.mkdirs()) {
                String str3 = zzhk.canWrite() ? "1" : "0";
                zza(4024, currentTimeMillis2, str3.length() != 0 ? "cw:".concat(str3) : new String("cw:"));
                zza(4015, currentTimeMillis2);
                z = false;
                if (z) {
                    return false;
                }
                File zzhk2 = zzhk(zzdh);
                File file = new File(zzhk2, "pcam.jar");
                File file2 = new File(zzhk2, "pcbc");
                if (!zzdwo.zza(file, zzgrVar.zzde().toByteArray())) {
                    zza(4016, currentTimeMillis);
                    return false;
                } else if (!zzdwo.zza(file2, zzgrVar.zzdf().toByteArray())) {
                    zza(4017, currentTimeMillis);
                    return false;
                } else if (zzdwvVar != null && !zzdwvVar.zzb(file)) {
                    zza(4018, currentTimeMillis);
                    zzdwo.zze(zzhk2);
                    return false;
                } else {
                    String zzb = zzb(zzgrVar);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    String string = this.zzcmn.getString(zzazs(), null);
                    SharedPreferences.Editor edit = this.zzcmn.edit();
                    edit.putString(zzazs(), zzb);
                    if (string != null) {
                        edit.putString(zzazr(), string);
                    }
                    boolean commit = edit.commit();
                    if (!commit) {
                        zza(4019, currentTimeMillis3);
                    }
                    if (commit) {
                        HashSet hashSet = new HashSet();
                        zzgv zzer2 = zzer(zzdwx.zzhxv);
                        if (zzer2 != null) {
                            hashSet.add(zzer2.zzdh());
                        }
                        zzgv zzer3 = zzer(zzdwx.zzhxw);
                        if (zzer3 != null) {
                            hashSet.add(zzer3.zzdh());
                        }
                        for (File file3 : new File(this.context.getDir("pccache", 0), this.zzhxq).listFiles()) {
                            if (!hashSet.contains(file3.getName())) {
                                zzdwo.zze(file3);
                            }
                        }
                        zza(5014, currentTimeMillis);
                        return true;
                    }
                    return false;
                }
            }
            z = true;
            if (z) {
            }
        }
    }

    public final boolean zza(zzgr zzgrVar) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzhxt) {
            if (!zzdwo.zza(new File(zzhk(zzgrVar.zzdd().zzdh()), "pcbc"), zzgrVar.zzdf().toByteArray())) {
                zza(4020, currentTimeMillis);
                return false;
            }
            String zzb = zzb(zzgrVar);
            SharedPreferences.Editor edit = this.zzcmn.edit();
            edit.putString(zzazs(), zzb);
            boolean commit = edit.commit();
            if (commit) {
                zza(5015, currentTimeMillis);
            } else {
                zza(4021, currentTimeMillis);
            }
            return commit;
        }
    }

    private final zzgv zzer(int i) {
        String string;
        zzemn zzbiw;
        if (i == zzdwx.zzhxv) {
            string = this.zzcmn.getString(zzazs(), null);
        } else {
            string = i == zzdwx.zzhxw ? this.zzcmn.getString(zzazr(), null) : null;
        }
        if (string == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzelq zzt = zzelq.zzt(Hex.stringToBytes(string));
            if (this.zzhxs) {
                zzbiw = zzemn.zzbiv();
            } else {
                zzbiw = zzemn.zzbiw();
            }
            return zzgv.zzb(zzt, zzbiw);
        } catch (zzenn unused) {
            return null;
        } catch (NullPointerException unused2) {
            zza(2029, currentTimeMillis);
            return null;
        }
    }

    private final File zzhk(String str) {
        return new File(new File(this.context.getDir("pccache", 0), this.zzhxq), str);
    }

    private final String zzazr() {
        String valueOf = String.valueOf(this.zzhxq);
        return valueOf.length() != 0 ? "FBAMTD".concat(valueOf) : new String("FBAMTD");
    }

    private final String zzazs() {
        String valueOf = String.valueOf(this.zzhxq);
        return valueOf.length() != 0 ? "LATMTD".concat(valueOf) : new String("LATMTD");
    }

    private static String zzb(zzgr zzgrVar) {
        return Hex.bytesToStringLowercase(((zzgv) ((zzena) zzgv.zzdm().zzav(zzgrVar.zzdd().zzdh()).zzaw(zzgrVar.zzdd().zzdi()).zzdk(zzgrVar.zzdd().zzdk()).zzdl(zzgrVar.zzdd().zzdl()).zzdj(zzgrVar.zzdd().zzdj()).zzbjv())).zzbgy().toByteArray());
    }

    private final void zza(int i, long j) {
        zzdwd zzdwdVar = this.zzhxr;
        if (zzdwdVar != null) {
            zzdwdVar.zza(i, j);
        }
    }

    private final void zza(int i, long j, String str) {
        zzdwd zzdwdVar = this.zzhxr;
        if (zzdwdVar != null) {
            zzdwdVar.zza(i, j, str);
        }
    }
}
