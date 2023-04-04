package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.d;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbcr {
    private final Context context;
    private final zzbar zzdvi;
    private final String zzdvx;
    private final zzach zzelz;
    private boolean zzemd;
    private final zzacf zzeos;
    private final long[] zzeou;
    private final String[] zzeov;
    private zzbbz zzepa;
    private boolean zzepb;
    private boolean zzepc;
    private final com.google.android.gms.ads.internal.util.zzau zzeot = new com.google.android.gms.ads.internal.util.zzav().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzaah();
    private boolean zzeow = false;
    private boolean zzeox = false;
    private boolean zzeoy = false;
    private boolean zzeoz = false;
    private long zzepd = -1;

    public zzbcr(Context context, zzbar zzbarVar, String str, zzach zzachVar, zzacf zzacfVar) {
        this.context = context;
        this.zzdvi = zzbarVar;
        this.zzdvx = str;
        this.zzelz = zzachVar;
        this.zzeos = zzacfVar;
        String str2 = (String) zzww.zzra().zzd(zzabq.zzcno);
        if (str2 == null) {
            this.zzeov = new String[0];
            this.zzeou = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzeov = new String[split.length];
        this.zzeou = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzeou[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzd("Unable to parse frame hash target time number.", e2);
                this.zzeou[i] = -1;
            }
        }
    }

    public final void zzb(zzbbz zzbbzVar) {
        zzaby.zza(this.zzelz, this.zzeos, "vpc2");
        this.zzeow = true;
        zzach zzachVar = this.zzelz;
        if (zzachVar != null) {
            zzachVar.zzg("vpn", zzbbzVar.zzaaw());
        }
        this.zzepa = zzbbzVar;
    }

    public final void zzff() {
        if (!this.zzeow || this.zzeox) {
            return;
        }
        zzaby.zza(this.zzelz, this.zzeos, "vfr2");
        this.zzeox = true;
    }

    public final void onStop() {
        if (!zzadz.zzdgg.get().booleanValue() || this.zzepb) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(d.y, "native-player-metrics");
        bundle.putString("request", this.zzdvx);
        bundle.putString("player", this.zzepa.zzaaw());
        for (com.google.android.gms.ads.internal.util.zzaw zzawVar : this.zzeot.zzaag()) {
            String valueOf = String.valueOf(zzawVar.name);
            bundle.putString(valueOf.length() != 0 ? "fps_c_".concat(valueOf) : new String("fps_c_"), Integer.toString(zzawVar.count));
            String valueOf2 = String.valueOf(zzawVar.name);
            bundle.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(zzawVar.zzeid));
        }
        int i = 0;
        while (true) {
            long[] jArr = this.zzeou;
            if (i < jArr.length) {
                String str = this.zzeov[i];
                if (str != null) {
                    String valueOf3 = String.valueOf(Long.valueOf(jArr[i]));
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 3);
                    sb.append("fh_");
                    sb.append(valueOf3);
                    bundle.putString(sb.toString(), str);
                }
                i++;
            } else {
                com.google.android.gms.ads.internal.zzr.zzkv().zza(this.context, this.zzdvi.zzbrz, "gmob-apps", bundle, true);
                this.zzepb = true;
                return;
            }
        }
    }

    public final void zzc(zzbbz zzbbzVar) {
        if (this.zzeoy && !this.zzeoz) {
            if (com.google.android.gms.ads.internal.util.zzd.zzyz() && !this.zzeoz) {
                com.google.android.gms.ads.internal.util.zzd.zzed("VideoMetricsMixin first frame");
            }
            zzaby.zza(this.zzelz, this.zzeos, "vff2");
            this.zzeoz = true;
        }
        long nanoTime = com.google.android.gms.ads.internal.zzr.zzlc().nanoTime();
        if (this.zzemd && this.zzepc && this.zzepd != -1) {
            double nanos = TimeUnit.SECONDS.toNanos(1L);
            double d2 = nanoTime - this.zzepd;
            Double.isNaN(nanos);
            Double.isNaN(d2);
            this.zzeot.zza(nanos / d2);
        }
        this.zzepc = this.zzemd;
        this.zzepd = nanoTime;
        long longValue = ((Long) zzww.zzra().zzd(zzabq.zzcnp)).longValue();
        long currentPosition = zzbbzVar.getCurrentPosition();
        int i = 0;
        while (true) {
            String[] strArr = this.zzeov;
            if (i >= strArr.length) {
                return;
            }
            if (strArr[i] == null && longValue > Math.abs(currentPosition - this.zzeou[i])) {
                String[] strArr2 = this.zzeov;
                int i2 = 8;
                Bitmap bitmap = zzbbzVar.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j);
                        i4++;
                        j--;
                        i2 = 8;
                    }
                    i3++;
                    i2 = 8;
                }
                strArr2[i] = String.format("%016X", Long.valueOf(j2));
                return;
            }
            i++;
        }
    }

    public final void zzabs() {
        this.zzemd = true;
        if (!this.zzeox || this.zzeoy) {
            return;
        }
        zzaby.zza(this.zzelz, this.zzeos, "vfp2");
        this.zzeoy = true;
    }

    public final void zzabt() {
        this.zzemd = false;
    }
}
