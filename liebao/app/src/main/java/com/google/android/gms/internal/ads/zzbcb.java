package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.Preconditions;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbcb extends FrameLayout implements zzbca {
    private final zzbcs zzekz;
    private final FrameLayout zzely;
    private final zzach zzelz;
    private final zzbcu zzema;
    private final long zzemb;
    private zzbbz zzemc;
    private boolean zzemd;
    private boolean zzeme;
    private boolean zzemf;
    private boolean zzemg;
    private long zzemh;
    private long zzemi;
    private String zzemj;
    private String[] zzemk;
    private Bitmap zzeml;
    private ImageView zzemm;
    private boolean zzemn;

    public static void zza(zzbcs zzbcsVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzbcsVar.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbcs zzbcsVar, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbcsVar.zza("onVideoEvent", hashMap);
    }

    public static void zza(zzbcs zzbcsVar, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put(d.O, str);
        zzbcsVar.zza("onVideoEvent", hashMap);
    }

    public zzbcb(Context context, zzbcs zzbcsVar, int i, boolean z, zzach zzachVar, zzbcp zzbcpVar) {
        super(context);
        this.zzekz = zzbcsVar;
        this.zzelz = zzachVar;
        this.zzely = new FrameLayout(context);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcnz)).booleanValue()) {
            this.zzely.setBackgroundResource(17170444);
        }
        addView(this.zzely, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbcsVar.zzaby());
        zzbbz zza = zzbcsVar.zzaby().zzbov.zza(context, zzbcsVar, i, z, zzachVar, zzbcpVar);
        this.zzemc = zza;
        if (zza != null) {
            this.zzely.addView(zza, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcnq)).booleanValue()) {
                zzabk();
            }
        }
        this.zzemm = new ImageView(context);
        this.zzemb = ((Long) zzww.zzra().zzd(zzabq.zzcnu)).longValue();
        boolean booleanValue = ((Boolean) zzww.zzra().zzd(zzabq.zzcns)).booleanValue();
        this.zzemg = booleanValue;
        zzach zzachVar2 = this.zzelz;
        if (zzachVar2 != null) {
            zzachVar2.zzg("spinner_used", booleanValue ? "1" : "0");
        }
        this.zzema = new zzbcu(this);
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar != null) {
            zzbbzVar.zza(this);
        }
        if (this.zzemc == null) {
            zzl("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.zzely.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzc(String str, String[] strArr) {
        this.zzemj = str;
        this.zzemk = strArr;
    }

    public final void zza(float f, float f2) {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar != null) {
            zzbbzVar.zza(f, f2);
        }
    }

    public final void zzic() {
        if (this.zzemc == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.zzemj)) {
            this.zzemc.zzb(this.zzemj, this.zzemk);
        } else {
            zzd("no_src", new String[0]);
        }
    }

    public final void pause() {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar == null) {
            return;
        }
        zzbbzVar.pause();
    }

    public final void play() {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar == null) {
            return;
        }
        zzbbzVar.play();
    }

    public final void seekTo(int i) {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar == null) {
            return;
        }
        zzbbzVar.seekTo(i);
    }

    public final void zzabi() {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar == null) {
            return;
        }
        zzbbzVar.zzelx.setMuted(true);
        zzbbzVar.zzabc();
    }

    public final void zzabj() {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar == null) {
            return;
        }
        zzbbzVar.zzelx.setMuted(false);
        zzbbzVar.zzabc();
    }

    public final void setVolume(float f) {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar == null) {
            return;
        }
        zzbbzVar.zzelx.setVolume(f);
        zzbbzVar.zzabc();
    }

    public final void zzdq(int i) {
        this.zzemc.zzdq(i);
    }

    public final void zzdr(int i) {
        this.zzemc.zzdr(i);
    }

    public final void zzds(int i) {
        this.zzemc.zzds(i);
    }

    public final void zzdt(int i) {
        this.zzemc.zzdt(i);
    }

    public final void zzdu(int i) {
        this.zzemc.zzdu(i);
    }

    public final void zze(MotionEvent motionEvent) {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar == null) {
            return;
        }
        zzbbzVar.dispatchTouchEvent(motionEvent);
    }

    public final void zzabk() {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar == null) {
            return;
        }
        TextView textView = new TextView(zzbbzVar.getContext());
        String valueOf = String.valueOf(this.zzemc.zzaaw());
        textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.zzely.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzely.bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzabd() {
        this.zzema.resume();
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbcg(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzff() {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar != null && this.zzemi == 0) {
            zzd("canplaythrough", "duration", String.valueOf(zzbbzVar.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.zzemc.getVideoWidth()), "videoHeight", String.valueOf(this.zzemc.getVideoHeight()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzabe() {
        if (this.zzekz.zzabx() != null && !this.zzeme) {
            boolean z = (this.zzekz.zzabx().getWindow().getAttributes().flags & 128) != 0;
            this.zzemf = z;
            if (!z) {
                this.zzekz.zzabx().getWindow().addFlags(128);
                this.zzeme = true;
            }
        }
        this.zzemd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void onPaused() {
        zzd("pause", new String[0]);
        zzabn();
        this.zzemd = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzabf() {
        zzd("ended", new String[0]);
        zzabn();
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzl(String str, String str2) {
        zzd(d.O, "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzm(String str, String str2) {
        zzd("exception", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzabg() {
        if (this.zzemn && this.zzeml != null && !zzabm()) {
            this.zzemm.setImageBitmap(this.zzeml);
            this.zzemm.invalidate();
            this.zzely.addView(this.zzemm, new FrameLayout.LayoutParams(-1, -1));
            this.zzely.bringChildToFront(this.zzemm);
        }
        this.zzema.pause();
        this.zzemi = this.zzemh;
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbcf(this));
    }

    public final void destroy() {
        this.zzema.pause();
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar != null) {
            zzbbzVar.stop();
        }
        zzabn();
    }

    public final void finalize() {
        try {
            this.zzema.pause();
            if (this.zzemc != null) {
                zzbbz zzbbzVar = this.zzemc;
                zzebs zzebsVar = zzbat.zzeki;
                zzbbzVar.getClass();
                zzebsVar.execute(zzbce.zza(zzbbzVar));
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzabl() {
        zzbbz zzbbzVar = this.zzemc;
        if (zzbbzVar == null) {
            return;
        }
        long currentPosition = zzbbzVar.getCurrentPosition();
        if (this.zzemh == currentPosition || currentPosition <= 0) {
            return;
        }
        float f = ((float) currentPosition) / 1000.0f;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue()) {
            zzd("timeupdate", "time", String.valueOf(f), "totalBytes", String.valueOf(this.zzemc.getTotalBytes()), "qoeCachedBytes", String.valueOf(this.zzemc.zznh()), "qoeLoadedBytes", String.valueOf(this.zzemc.zzaba()), "droppedFrames", String.valueOf(this.zzemc.zzabb()), "reportTime", String.valueOf(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis()));
        } else {
            zzd("timeupdate", "time", String.valueOf(f));
        }
        this.zzemh = currentPosition;
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzabh() {
        if (this.zzemd && zzabm()) {
            this.zzely.removeView(this.zzemm);
        }
        if (this.zzeml != null) {
            long elapsedRealtime = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime();
            if (this.zzemc.getBitmap(this.zzeml) != null) {
                this.zzemn = true;
            }
            long elapsedRealtime2 = com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - elapsedRealtime;
            if (com.google.android.gms.ads.internal.util.zzd.zzyz()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
            }
            if (elapsedRealtime2 > this.zzemb) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzemg = false;
                this.zzeml = null;
                zzach zzachVar = this.zzelz;
                if (zzachVar != null) {
                    zzachVar.zzg("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbca
    public final void zzm(int i, int i2) {
        if (this.zzemg) {
            int max = Math.max(i / ((Integer) zzww.zzra().zzd(zzabq.zzcnt)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzww.zzra().zzd(zzabq.zzcnt)).intValue(), 1);
            Bitmap bitmap = this.zzeml;
            if (bitmap != null && bitmap.getWidth() == max && this.zzeml.getHeight() == max2) {
                return;
            }
            this.zzeml = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
            this.zzemn = false;
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzema.resume();
        } else {
            this.zzema.pause();
            this.zzemi = this.zzemh;
        }
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.zzbcd
            private final zzbcb zzemo;
            private final boolean zzemp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzemo = this;
                this.zzemp = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzemo.zzay(this.zzemp);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbca
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzema.resume();
            z = true;
        } else {
            this.zzema.pause();
            this.zzemi = this.zzemh;
            z = false;
        }
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbci(this, z));
    }

    private final boolean zzabm() {
        return this.zzemm.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzekz.zza("onVideoEvent", hashMap);
    }

    private final void zzabn() {
        if (this.zzekz.zzabx() == null || !this.zzeme || this.zzemf) {
            return;
        }
        this.zzekz.zzabx().getWindow().clearFlags(128);
        this.zzeme = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzay(boolean z) {
        zzd("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }
}
