package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import com.umeng.analytics.pro.d;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbev extends zzbek implements zzbdx {
    private String zzemj;
    private boolean zzesi;
    private zzbdn zzesl;
    private Exception zzesm;
    private boolean zzesn;

    public zzbev(zzbcs zzbcsVar, zzbcp zzbcpVar) {
        super(zzbcsVar);
        zzbdn zzbdnVar = new zzbdn(zzbcsVar.getContext(), zzbcpVar, this.zzerx.get());
        this.zzesl = zzbdnVar;
        zzbdnVar.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void zzdy(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void zzp(int i, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void zzb(boolean z, long j) {
        zzbcs zzbcsVar = this.zzerx.get();
        if (zzbcsVar != null) {
            zzbat.zzeki.execute(new Runnable(zzbcsVar, z, j) { // from class: com.google.android.gms.internal.ads.zzbey
                private final boolean zzemp;
                private final long zzepu;
                private final zzbcs zzerd;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzerd = zzbcsVar;
                    this.zzemp = z;
                    this.zzepu = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzerd.zza(this.zzemp, this.zzepu);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void zzb(String str, Exception exc) {
        String str2 = (String) zzww.zzra().zzd(zzabq.zzcnd);
        if (str2 != null) {
            List asList = Arrays.asList(str2.split(","));
            if (asList.contains("all") || asList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.zzesm = exc;
        com.google.android.gms.ads.internal.util.zzd.zzd("Precache error", exc);
        zzfk(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void zzc(String str, Exception exc) {
        com.google.android.gms.ads.internal.util.zzd.zzd("Precache exception", exc);
    }

    @Override // com.google.android.gms.internal.ads.zzbek
    public final void zzdr(int i) {
        this.zzesl.zzadg().zzeb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbek
    public final void zzdq(int i) {
        this.zzesl.zzadg().zzea(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbek
    public final void zzds(int i) {
        this.zzesl.zzadg().zzds(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbek
    public final void zzdt(int i) {
        this.zzesl.zzadg().zzdt(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbek, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzbdn zzbdnVar = this.zzesl;
        if (zzbdnVar != null) {
            zzbdnVar.zza((zzbdx) null);
            this.zzesl.release();
        }
        super.release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbek
    public final String zzfi(String str) {
        String valueOf = String.valueOf(super.zzfi(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }

    @Override // com.google.android.gms.internal.ads.zzbek
    public final boolean zzfh(String str) {
        return zze(str, new String[]{str});
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009f, code lost:
        if (r15.zzesm == null) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
        throw r15.zzesm;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b1, code lost:
        r17 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01cf, code lost:
        r6 = r13;
        r7 = r14;
        r5 = r15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20, types: [long] */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v11, types: [int] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    @Override // com.google.android.gms.internal.ads.zzbek
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zze(String str, String[] strArr) {
        String str2;
        String str3;
        zzbev zzbevVar;
        Exception exc;
        long j;
        long j2;
        long j3;
        String str4;
        long j4;
        String str5;
        long j5;
        long j6;
        long j7;
        zzbev zzbevVar2 = this;
        String str6 = str;
        zzbevVar2.zzemj = str6;
        String zzfi = zzfi(str);
        String str7 = d.O;
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                try {
                    uriArr[i] = Uri.parse(strArr[i]);
                } catch (Exception e2) {
                    exc = e2;
                    str2 = str6;
                    str3 = zzfi;
                    zzbevVar = zzbevVar2;
                    String str8 = str7;
                    String message = exc.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
                    sb.append("Failed to preload url ");
                    sb.append(str2);
                    sb.append(" Exception: ");
                    sb.append(message);
                    com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
                    release();
                    zzbevVar.zza(str2, str3, str8, zzd(str8, exc));
                    return false;
                }
            }
            zzbevVar2.zzesl.zza(uriArr, zzbevVar2.zzeiz);
            zzbcs zzbcsVar = zzbevVar2.zzerx.get();
            if (zzbcsVar != null) {
                zzbcsVar.zza(zzfi, zzbevVar2);
            }
            Clock zzlc = com.google.android.gms.ads.internal.zzr.zzlc();
            long currentTimeMillis = zzlc.currentTimeMillis();
            long longValue = ((Long) zzww.zzra().zzd(zzabq.zzcnm)).longValue();
            long longValue2 = ((Long) zzww.zzra().zzd(zzabq.zzcnl)).longValue() * 1000;
            long intValue = ((Integer) zzww.zzra().zzd(zzabq.zzcnk)).intValue();
            boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue();
            ?? r1 = -1;
            while (true) {
                synchronized (this) {
                    try {
                        if (zzlc.currentTimeMillis() - currentTimeMillis > longValue2) {
                            long j8 = longValue2;
                            StringBuilder sb2 = new StringBuilder(47);
                            sb2.append("Timeout reached. Limit: ");
                            sb2.append(j8);
                            sb2.append(" ms");
                            throw new IOException(sb2.toString());
                        } else if (zzbevVar2.zzesi) {
                            break;
                        } else if (!zzbevVar2.zzesn) {
                            zzhh zzadd = zzbevVar2.zzesl.zzadd();
                            if (zzadd == null) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long duration = zzadd.getDuration();
                            if (duration > 0) {
                                long bufferedPosition = zzadd.getBufferedPosition();
                                if (bufferedPosition != r1) {
                                    try {
                                        j = intValue;
                                        j7 = duration;
                                        j2 = longValue2;
                                        j4 = longValue;
                                        str5 = zzfi;
                                    } catch (Throwable th) {
                                        th = th;
                                        zzbevVar = this;
                                        str2 = str;
                                        str3 = zzfi;
                                    }
                                    try {
                                        zza(str, zzfi, bufferedPosition, j7, bufferedPosition > 0, booleanValue ? zzbevVar2.zzesl.zzaba() : -1L, booleanValue ? zzbevVar2.zzesl.zznh() : -1L, booleanValue ? zzbevVar2.zzesl.getTotalBytes() : -1L, zzbdn.zzade(), zzbdn.zzadf());
                                        j6 = bufferedPosition;
                                        j5 = duration;
                                        str2 = j7;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        zzbevVar = this;
                                        str2 = str;
                                        str3 = str5;
                                        try {
                                            throw th;
                                        } catch (Exception e3) {
                                            e = e3;
                                            exc = e;
                                            String str82 = str7;
                                            String message2 = exc.getMessage();
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message2).length());
                                            sb3.append("Failed to preload url ");
                                            sb3.append(str2);
                                            sb3.append(" Exception: ");
                                            sb3.append(message2);
                                            com.google.android.gms.ads.internal.util.zzd.zzez(sb3.toString());
                                            release();
                                            zzbevVar.zza(str2, str3, str82, zzd(str82, exc));
                                            return false;
                                        }
                                    }
                                } else {
                                    j = intValue;
                                    j2 = longValue2;
                                    j4 = longValue;
                                    str5 = zzfi;
                                    j5 = duration;
                                    j6 = r1;
                                    str2 = intValue;
                                }
                                zzbevVar = (bufferedPosition > j5 ? 1 : (bufferedPosition == j5 ? 0 : -1));
                                if (zzbevVar >= 0) {
                                    zzc(str, str5, j5);
                                } else {
                                    try {
                                        zzbev zzbevVar3 = this;
                                        str2 = str;
                                        str3 = str5;
                                        if (zzbevVar3.zzesl.getBytesTransferred() < j || bufferedPosition <= 0) {
                                            j3 = j4;
                                            str4 = j6;
                                            zzbevVar = zzbevVar3;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        throw th;
                                    }
                                }
                            } else {
                                j = intValue;
                                j2 = longValue2;
                                str2 = str6;
                                str3 = zzfi;
                                zzbevVar = zzbevVar2;
                                j3 = longValue;
                                str4 = r1;
                            }
                            try {
                                try {
                                    zzbevVar.wait(j3);
                                } catch (InterruptedException unused) {
                                    throw new IOException("Wait interrupted.");
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                str7 = str4;
                                throw th;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                longValue = j3;
                zzbevVar2 = zzbevVar;
                str6 = str2;
                zzfi = str3;
                intValue = j;
                longValue2 = j2;
                r1 = str4;
            }
            return true;
        } catch (Exception e4) {
            e = e4;
            str2 = str6;
            str3 = zzfi;
            zzbevVar = zzbevVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbek
    public final void abort() {
        zzfk(null);
    }

    private final void zzfk(String str) {
        synchronized (this) {
            this.zzesi = true;
            notify();
            release();
        }
        String str2 = this.zzemj;
        if (str2 != null) {
            String zzfi = zzfi(str2);
            Exception exc = this.zzesm;
            if (exc != null) {
                zza(this.zzemj, zzfi, "badUrl", zzd(str, exc));
            } else {
                zza(this.zzemj, zzfi, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final zzbdn zzadi() {
        synchronized (this) {
            this.zzesn = true;
            notify();
        }
        this.zzesl.zza((zzbdx) null);
        zzbdn zzbdnVar = this.zzesl;
        this.zzesl = null;
        return zzbdnVar;
    }

    private static String zzd(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }
}
