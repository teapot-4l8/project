package com.google.android.gms.ads.internal.util;

import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzv extends zzw {
    @Override // com.google.android.gms.ads.internal.util.zzr
    public final int zzzv() {
        return 14;
    }

    @Override // com.google.android.gms.ads.internal.util.zzr
    public boolean isAttachedToWindow(View view) {
        return super.isAttachedToWindow(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.ads.internal.util.zzr
    public final long zzzz() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzctl)).booleanValue()) {
            return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
        }
        return -1L;
    }
}
