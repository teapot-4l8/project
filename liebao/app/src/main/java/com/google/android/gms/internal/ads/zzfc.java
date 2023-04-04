package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzcf;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzfc {
    private static final String TAG = zzfc.class.getSimpleName();
    protected Context context;
    private zzfa zzyu;
    private ExecutorService zzzd;
    private DexClassLoader zzze;
    private zzek zzzf;
    private byte[] zzzg;
    private boolean zzzj;
    private zzdw zzzm;
    private Map<Pair<String, String>, zzgl> zzzp;
    private volatile AdvertisingIdClient zzzh = null;
    private volatile boolean zzxk = false;
    private Future zzzi = null;
    private volatile zzcf.zza zzzk = null;
    private Future zzzl = null;
    private boolean zzzn = false;
    private boolean zzzo = false;
    private boolean zzzq = false;

    public static zzfc zza(Context context, String str, String str2, boolean z) {
        zzfc zzfcVar = new zzfc(context);
        try {
            zzfcVar.zzzd = Executors.newCachedThreadPool(new zzfb());
            zzfcVar.zzxk = z;
            if (z) {
                zzfcVar.zzzi = zzfcVar.zzzd.submit(new zzfe(zzfcVar));
            }
            zzfcVar.zzzd.execute(new zzfg(zzfcVar));
            try {
                GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
                zzfcVar.zzzn = googleApiAvailabilityLight.getApkVersion(zzfcVar.context) > 0;
                zzfcVar.zzzo = googleApiAvailabilityLight.isGooglePlayServicesAvailable(zzfcVar.context) == 0;
            } catch (Throwable unused) {
            }
            zzfcVar.zza(0, true);
            if (zzfh.isMainThread() && ((Boolean) zzww.zzra().zzd(zzabq.zzctb)).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            zzek zzekVar = new zzek(null);
            zzfcVar.zzzf = zzekVar;
            try {
                zzfcVar.zzzg = zzekVar.zzao(str);
                try {
                    try {
                        File cacheDir = zzfcVar.context.getCacheDir();
                        if (cacheDir == null && (cacheDir = zzfcVar.context.getDir("dex", 0)) == null) {
                            throw new zzev();
                        }
                        File file = new File(String.format("%s/%s.jar", cacheDir, "1610724645094"));
                        if (!file.exists()) {
                            byte[] zza = zzfcVar.zzzf.zza(zzfcVar.zzzg, str2);
                            file.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            fileOutputStream.write(zza, 0, zza.length);
                            fileOutputStream.close();
                        }
                        zzfcVar.zzb(cacheDir, "1610724645094");
                        try {
                            zzfcVar.zzze = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzfcVar.context.getClassLoader());
                            zzc(file);
                            zzfcVar.zza(cacheDir, "1610724645094");
                            zzap(String.format("%s/%s.dex", cacheDir, "1610724645094"));
                            zzfcVar.zzzm = new zzdw(zzfcVar);
                            zzfcVar.zzzq = true;
                        } catch (Throwable th) {
                            zzc(file);
                            zzfcVar.zza(cacheDir, "1610724645094");
                            zzap(String.format("%s/%s.dex", cacheDir, "1610724645094"));
                            throw th;
                        }
                    } catch (zzej e2) {
                        throw new zzev(e2);
                    } catch (NullPointerException e3) {
                        throw new zzev(e3);
                    }
                } catch (FileNotFoundException e4) {
                    throw new zzev(e4);
                } catch (IOException e5) {
                    throw new zzev(e5);
                }
            } catch (zzej e6) {
                throw new zzev(e6);
            }
        } catch (zzev unused2) {
        }
        return zzfcVar;
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean isInitialized() {
        return this.zzzq;
    }

    public final ExecutorService zzch() {
        return this.zzzd;
    }

    public final DexClassLoader zzci() {
        return this.zzze;
    }

    public final zzek zzcj() {
        return this.zzzf;
    }

    public final byte[] zzck() {
        return this.zzzg;
    }

    public final boolean zzcl() {
        return this.zzzn;
    }

    public final zzdw zzcm() {
        return this.zzzm;
    }

    public final boolean zzcn() {
        return this.zzzo;
    }

    public final boolean zzcg() {
        return this.zzyu.zzcg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfa zzco() {
        return this.zzyu;
    }

    public final zzcf.zza zzcp() {
        return this.zzzk;
    }

    public final Future zzcq() {
        return this.zzzl;
    }

    private zzfc(Context context) {
        Context applicationContext = context.getApplicationContext();
        boolean z = applicationContext != null;
        this.zzzj = z;
        this.context = z ? applicationContext : context;
        this.zzzp = new HashMap();
        if (this.zzyu == null) {
            this.zzyu = new zzfa(this.context);
        }
    }

    private final void zza(File file, String str) {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file3);
            try {
                if (fileInputStream2.read(bArr) <= 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    zzc(file3);
                    return;
                }
                System.out.print("test");
                System.out.print("test");
                System.out.print("test");
                zzcf.zzc.zza zzg = zzcf.zzc.zzbf().zzh(zzelq.zzt(Build.VERSION.SDK.getBytes())).zzg(zzelq.zzt(str.getBytes()));
                byte[] bytes = this.zzzf.zzb(this.zzzg, bArr).getBytes();
                zzg.zze(zzelq.zzt(bytes)).zzf(zzelq.zzt(zzda.zzb(bytes)));
                file2.createNewFile();
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] byteArray = ((zzcf.zzc) ((zzena) zzg.zzbjv())).toByteArray();
                    fileOutputStream.write(byteArray, 0, byteArray.length);
                    fileOutputStream.close();
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    zzc(file3);
                } catch (zzej | IOException | NoSuchAlgorithmException unused4) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    zzc(file3);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    zzc(file3);
                    throw th;
                }
            } catch (zzej | IOException | NoSuchAlgorithmException unused9) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (zzej | IOException | NoSuchAlgorithmException unused10) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static void zzap(String str) {
        zzc(new File(str));
    }

    private static void zzc(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        } else {
            file.delete();
        }
    }

    private final boolean zzb(File file, String str) {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (file3.exists()) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            long length = file2.length();
            if (length <= 0) {
                zzc(file2);
                return false;
            }
            byte[] bArr = new byte[(int) length];
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            try {
                try {
                    if (fileInputStream2.read(bArr) <= 0) {
                        Log.d(TAG, "Cannot read the cache data.");
                        zzc(file2);
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        return false;
                    }
                    try {
                        try {
                            zzcf.zzc zzb = zzcf.zzc.zzb(bArr, zzemn.zzbiv());
                            if (str.equals(new String(zzb.zzbd().toByteArray())) && Arrays.equals(zzb.zzbc().toByteArray(), zzda.zzb(zzb.zzbb().toByteArray())) && Arrays.equals(zzb.zzbe().toByteArray(), Build.VERSION.SDK.getBytes())) {
                                byte[] zza = this.zzzf.zza(this.zzzg, new String(zzb.zzbb().toByteArray()));
                                file3.createNewFile();
                                fileOutputStream = new FileOutputStream(file3);
                                try {
                                    fileOutputStream.write(zza, 0, zza.length);
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException unused2) {
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                    return true;
                                } catch (zzej | IOException | NoSuchAlgorithmException unused4) {
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException unused5) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException unused6) {
                                        }
                                    }
                                    return false;
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException unused7) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException unused8) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                            zzc(file2);
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused9) {
                            }
                            return false;
                        } catch (IOException unused10) {
                            return false;
                        }
                    } catch (NullPointerException unused11) {
                        fileInputStream2.close();
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (zzej | IOException | NoSuchAlgorithmException unused12) {
                fileOutputStream = null;
            }
        } catch (zzej | IOException | NoSuchAlgorithmException unused13) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzzp.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzzp.put(new Pair<>(str, str2), new zzgl(this, str, str2, clsArr));
        return true;
    }

    public final Method zza(String str, String str2) {
        zzgl zzglVar = this.zzzp.get(new Pair(str, str2));
        if (zzglVar == null) {
            return null;
        }
        return zzglVar.zzdc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzcr() {
        try {
            if (this.zzzh == null && this.zzzj) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.context);
                advertisingIdClient.start();
                this.zzzh = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzzh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i, boolean z) {
        if (this.zzzo) {
            Future<?> submit = this.zzzd.submit(new zzfd(this, i, z));
            if (i == 0) {
                this.zzzl = submit;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcf.zza zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        return zzcs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zza(int i, zzcf.zza zzaVar) {
        if (i < 4) {
            return zzaVar == null || !zzaVar.zzai() || zzaVar.zzaf().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zzaVar.zzan() || !zzaVar.zzao().zzbh() || zzaVar.zzao().zzbi() == -2;
        }
        return false;
    }

    private final zzcf.zza zzcs() {
        try {
            return zzdvf.zzj(this.context, this.context.getPackageName(), Integer.toString(this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final AdvertisingIdClient zzct() {
        if (this.zzxk) {
            if (this.zzzh != null) {
                return this.zzzh;
            }
            Future future = this.zzzi;
            if (future != null) {
                try {
                    future.get(2000L, TimeUnit.MILLISECONDS);
                    this.zzzi = null;
                } catch (InterruptedException | ExecutionException unused) {
                } catch (TimeoutException unused2) {
                    this.zzzi.cancel(true);
                }
            }
            return this.zzzh;
        }
        return null;
    }

    public final int zzbv() {
        if (this.zzzm != null) {
            return zzdw.zzbv();
        }
        return Integer.MIN_VALUE;
    }
}
