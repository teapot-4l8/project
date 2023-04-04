package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcfw {
    private final Executor executor;
    private final Clock zzbqq;
    private final com.google.android.gms.ads.internal.util.zzay zzgjt;

    public zzcfw(com.google.android.gms.ads.internal.util.zzay zzayVar, Clock clock, Executor executor) {
        this.zzgjt = zzayVar;
        this.zzbqq = clock;
        this.executor = executor;
    }

    public final zzebt<Bitmap> zza(String str, double d2, boolean z) {
        return zzebh.zzb(com.google.android.gms.ads.internal.util.zzay.zzeq(str), new zzcfz(this, d2, z), this.executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap zza(byte[] bArr, double d2, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d2 * 160.0d);
        if (!z) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyq)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zza(bArr, options);
            options.inJustDecodeBounds = false;
            int i = options.outWidth * options.outHeight;
            if (i > 0) {
                int i2 = i - 1;
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros(i2 / ((Integer) zzww.zzra().zzd(zzabq.zzcyr)).intValue())) / 2);
            }
        }
        return zza(bArr, options);
    }

    private final Bitmap zza(byte[] bArr, BitmapFactory.Options options) {
        long elapsedRealtime = this.zzbqq.elapsedRealtime();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long elapsedRealtime2 = this.zzbqq.elapsedRealtime();
        if (Build.VERSION.SDK_INT >= 19 && decodeByteArray != null) {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            long j = elapsedRealtime2 - elapsedRealtime;
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j);
            sb.append(" on ui thread: ");
            sb.append(z);
            com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        }
        return decodeByteArray;
    }
}
