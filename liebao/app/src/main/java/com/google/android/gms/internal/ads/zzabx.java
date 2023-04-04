package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes.dex */
public final class zzabx {
    private Context context;
    private File file;
    private String zzbrz;
    private String zzdbu;
    private BlockingQueue<zzach> zzdbx = new ArrayBlockingQueue(100);
    private LinkedHashMap<String, String> zzdby = new LinkedHashMap<>();
    private Map<String, zzacb> zzdbz = new HashMap();
    private final HashSet<String> zzdca = new HashSet<>(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));
    private AtomicBoolean zzdcb;

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.context = context;
        this.zzbrz = str;
        this.zzdbu = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.zzdcb = atomicBoolean;
        atomicBoolean.set(zzadj.zzdeo.get().booleanValue());
        if (this.zzdcb.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.file = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzdby.put(entry.getKey(), entry.getValue());
        }
        zzbat.zzeke.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzabw
            private final zzabx zzdbw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdbw = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdbw.zzsq();
            }
        });
        this.zzdbz.put("action", zzacb.zzdcd);
        this.zzdbz.put("ad_format", zzacb.zzdcd);
        this.zzdbz.put("e", zzacb.zzdce);
    }

    public final boolean zza(zzach zzachVar) {
        return this.zzdbx.offer(zzachVar);
    }

    private final void zza(Map<String, String> map, zzacg zzacgVar) {
        Uri.Builder buildUpon = Uri.parse(this.zzdbu).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String uri = buildUpon.build().toString();
        if (zzacgVar != null) {
            StringBuilder sb = new StringBuilder(uri);
            if (!TextUtils.isEmpty(zzacgVar.zzsu())) {
                sb.append("&it=");
                sb.append(zzacgVar.zzsu());
            }
            if (!TextUtils.isEmpty(zzacgVar.zzsv())) {
                sb.append("&blat=");
                sb.append(zzacgVar.zzsv());
            }
            uri = sb.toString();
        }
        if (this.zzdcb.get()) {
            File file = this.file;
            if (file != null) {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                        try {
                            fileOutputStream2.write(uri.getBytes());
                            fileOutputStream2.write(10);
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e2) {
                                com.google.android.gms.ads.internal.util.zzd.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileOutputStream = fileOutputStream2;
                            com.google.android.gms.ads.internal.util.zzd.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    com.google.android.gms.ads.internal.util.zzd.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    com.google.android.gms.ads.internal.util.zzd.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e6) {
                    e = e6;
                }
            } else {
                com.google.android.gms.ads.internal.util.zzd.zzez("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
            }
        } else {
            com.google.android.gms.ads.internal.zzr.zzkv();
            com.google.android.gms.ads.internal.util.zzj.zzb(this.context, this.zzbrz, uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> zza(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String str = (String) linkedHashMap.get(key);
            linkedHashMap.put(key, zzcq(key).zzf(str, entry.getValue()));
        }
        return linkedHashMap;
    }

    public final zzacb zzcq(String str) {
        zzacb zzacbVar = this.zzdbz.get(str);
        return zzacbVar != null ? zzacbVar : zzacb.zzdcc;
    }

    public final void zzcr(String str) {
        if (this.zzdca.contains(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("sdkVersion", this.zzbrz);
        linkedHashMap.put("ue", str);
        zza(zza(this.zzdby, linkedHashMap), (zzacg) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzsq() {
        while (true) {
            try {
                zzach take = this.zzdbx.take();
                zzacg zzsw = take.zzsw();
                if (zzsw != null && !TextUtils.isEmpty(zzsw.zzsu())) {
                    zza(zza(this.zzdby, take.zzsx()), zzsw);
                }
            } catch (InterruptedException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzd("CsiReporter:reporter interrupted", e2);
                return;
            }
        }
    }
}
