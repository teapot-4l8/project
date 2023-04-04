package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdwb {
    private final Context context;
    private final zzduv zzvx;

    public zzdwb(Context context, zzduv zzduvVar) {
        this.context = context;
        this.zzvx = zzduvVar;
    }

    private final void zzc(byte[] bArr, String str) {
        if (this.zzvx == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("os.arch:");
        sb.append(zzdyn.OS_ARCH.value());
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";");
        sb.append("CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            sb.append("dbg:");
            sb.append(str);
            sb.append(";");
        }
        this.zzvx.zzg(4007, sb.toString());
    }

    private final String zzazd() {
        HashSet hashSet = new HashSet(Arrays.asList("i686", "armv71"));
        String value = zzdyn.OS_ARCH.value();
        if (TextUtils.isEmpty(value) || !hashSet.contains(value)) {
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
                if (strArr != null && strArr.length > 0) {
                    return strArr[0];
                }
            } catch (IllegalAccessException e2) {
                zzduv zzduvVar = this.zzvx;
                if (zzduvVar != null) {
                    zzduvVar.zza(2024, 0L, e2);
                }
            } catch (NoSuchFieldException e3) {
                zzduv zzduvVar2 = this.zzvx;
                if (zzduvVar2 != null) {
                    zzduvVar2.zza(2024, 0L, e3);
                }
            }
            if (Build.CPU_ABI != null) {
                return Build.CPU_ABI;
            }
            return Build.CPU_ABI2;
        }
        return value;
    }

    private final zzgp zzaze() {
        FileInputStream fileInputStream;
        byte[] bArr;
        File file = new File(new File(this.context.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            zzduv zzduvVar = this.zzvx;
            if (zzduvVar != null) {
                zzduvVar.zzg(5017, "No lib/");
            }
            return zzgp.UNKNOWN;
        }
        File[] listFiles = file.listFiles(new zzeab(Pattern.compile(".*\\.so$", 2)));
        if (listFiles == null || listFiles.length == 0) {
            zzduv zzduvVar2 = this.zzvx;
            if (zzduvVar2 != null) {
                zzduvVar2.zzg(5017, "No .so");
            }
            return zzgp.UNKNOWN;
        }
        try {
            fileInputStream = new FileInputStream(listFiles[0]);
            bArr = new byte[20];
        } catch (IOException e2) {
            zzc(null, e2.toString());
        }
        if (fileInputStream.read(bArr) == 20) {
            byte[] bArr2 = {0, 0};
            if (bArr[5] == 2) {
                zzc(bArr, null);
                zzgp zzgpVar = zzgp.UNSUPPORTED;
                fileInputStream.close();
                return zzgpVar;
            }
            bArr2[0] = bArr[19];
            bArr2[1] = bArr[18];
            short s = ByteBuffer.wrap(bArr2).getShort();
            if (s == 3) {
                zzgp zzgpVar2 = zzgp.X86;
                fileInputStream.close();
                return zzgpVar2;
            } else if (s == 40) {
                zzgp zzgpVar3 = zzgp.ARM7;
                fileInputStream.close();
                return zzgpVar3;
            } else if (s == 62) {
                zzgp zzgpVar4 = zzgp.X86_64;
                fileInputStream.close();
                return zzgpVar4;
            } else if (s == 183) {
                zzgp zzgpVar5 = zzgp.ARM64;
                fileInputStream.close();
                return zzgpVar5;
            } else {
                zzc(bArr, null);
                zzgp zzgpVar6 = zzgp.UNSUPPORTED;
                fileInputStream.close();
                return zzgpVar6;
            }
        }
        fileInputStream.close();
        return zzgp.UNSUPPORTED;
    }

    public final zzgp zzazf() {
        zzgp zzaze = zzaze();
        if (zzaze == zzgp.UNKNOWN) {
            String zzazd = zzazd();
            if (TextUtils.isEmpty(zzazd)) {
                zzc(null, "Empty dev arch");
                zzaze = zzgp.UNSUPPORTED;
            } else if (zzazd.equalsIgnoreCase("i686") || zzazd.equalsIgnoreCase("x86")) {
                zzaze = zzgp.X86;
            } else if (zzazd.equalsIgnoreCase("x86_64")) {
                zzaze = zzgp.X86_64;
            } else if (zzazd.equalsIgnoreCase("arm64-v8a")) {
                zzaze = zzgp.ARM64;
            } else if (zzazd.equalsIgnoreCase("armeabi-v7a") || zzazd.equalsIgnoreCase("armv71")) {
                zzaze = zzgp.ARM7;
            } else {
                zzc(null, zzazd);
                zzaze = zzgp.UNSUPPORTED;
            }
        }
        zzduv zzduvVar = this.zzvx;
        if (zzduvVar != null) {
            zzduvVar.zzg(5018, zzaze.name());
        }
        return zzaze;
    }

    public static boolean zza(zzgp zzgpVar) {
        int i = zzdwa.zzhwy[zzgpVar.ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }
}
