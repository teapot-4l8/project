package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzuh;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zztz {
    private final zzue zzbwr;
    private final zzuh.zzi.zza zzbws;
    private final boolean zzbwt;

    public static zztz zznl() {
        return new zztz();
    }

    public zztz(zzue zzueVar) {
        this.zzbws = zzuh.zzi.zzom();
        this.zzbwr = zzueVar;
        this.zzbwt = ((Boolean) zzww.zzra().zzd(zzabq.zzcwb)).booleanValue();
    }

    private zztz() {
        this.zzbws = zzuh.zzi.zzom();
        this.zzbwt = false;
        this.zzbwr = new zzue();
    }

    public final synchronized void zza(zzub.zza.zzb zzbVar) {
        if (this.zzbwt) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwc)).booleanValue()) {
                zzc(zzbVar);
            } else {
                zzb(zzbVar);
            }
        }
    }

    private final synchronized void zzb(zzub.zza.zzb zzbVar) {
        this.zzbws.zzoi().zza(zznm());
        this.zzbwr.zzf(((zzuh.zzi) ((zzena) this.zzbws.zzbjv())).toByteArray()).zzby(zzbVar.zzv()).log();
        String valueOf = String.valueOf(Integer.toString(zzbVar.zzv(), 10));
        com.google.android.gms.ads.internal.util.zzd.zzed(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void zzc(zzub.zza.zzb zzbVar) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
            try {
                try {
                    fileOutputStream.write(zzd(zzbVar).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        com.google.android.gms.ads.internal.util.zzd.zzed("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    com.google.android.gms.ads.internal.util.zzd.zzed("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        com.google.android.gms.ads.internal.util.zzd.zzed("Could not close Clearcut output stream.");
                    }
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                    com.google.android.gms.ads.internal.util.zzd.zzed("Could not close Clearcut output stream.");
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Could not find file for Clearcut");
        }
    }

    private final synchronized String zzd(zzub.zza.zzb zzbVar) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", this.zzbws.zzoh(), Long.valueOf(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime()), Integer.valueOf(zzbVar.zzv()), Base64.encodeToString(((zzuh.zzi) ((zzena) this.zzbws.zzbjv())).toByteArray(), 3));
    }

    public final synchronized void zza(zzty zztyVar) {
        if (this.zzbwt) {
            try {
                zztyVar.zza(this.zzbws);
            } catch (NullPointerException e2) {
                com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "AdMobClearcutLogger.modify");
            }
        }
    }

    private static List<Long> zznm() {
        List<String> zzsj = zzabq.zzsj();
        ArrayList arrayList = new ArrayList();
        for (String str : zzsj) {
            for (String str2 : str.split(",")) {
                try {
                    arrayList.add(Long.valueOf(str2));
                } catch (NumberFormatException unused) {
                    com.google.android.gms.ads.internal.util.zzd.zzed("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }
}
