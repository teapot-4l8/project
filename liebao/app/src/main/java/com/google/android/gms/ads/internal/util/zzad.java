package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzww;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzad {
    private final Context context;
    private Handler handler;
    private int state;
    private String zzbrz;
    private String zzbvf;
    private String zzdul;
    private String zzdyc;
    private int zzehc;
    private PointF zzehd;
    private PointF zzehe;
    private Runnable zzehf;

    public zzad(Context context) {
        this.state = 0;
        this.zzehf = new Runnable(this) { // from class: com.google.android.gms.ads.internal.util.zzag
            private final zzad zzehg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehg = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzehg.zzaac();
            }
        };
        this.context = context;
        this.zzehc = ViewConfiguration.get(context).getScaledTouchSlop();
        com.google.android.gms.ads.internal.zzr.zzlj().zzaai();
        this.handler = com.google.android.gms.ads.internal.zzr.zzlj().getHandler();
    }

    public zzad(Context context, String str) {
        this(context);
        this.zzdul = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        boolean z = false;
        if (actionMasked == 0) {
            this.state = 0;
            this.zzehd = new PointF(motionEvent.getX(0), motionEvent.getY(0));
            return;
        }
        int i = this.state;
        if (i == -1) {
            return;
        }
        if (i == 0 && actionMasked == 5) {
            this.state = 5;
            this.zzehe = new PointF(motionEvent.getX(1), motionEvent.getY(1));
            this.handler.postDelayed(this.zzehf, ((Long) zzww.zzra().zzd(zzabq.zzcvq)).longValue());
        } else if (this.state == 5) {
            if (pointerCount == 2) {
                if (actionMasked == 2) {
                    boolean z2 = false;
                    for (int i2 = 0; i2 < historySize; i2++) {
                        if (!zza(motionEvent.getHistoricalX(0, i2), motionEvent.getHistoricalY(0, i2), motionEvent.getHistoricalX(1, i2), motionEvent.getHistoricalY(1, i2))) {
                            z2 = true;
                        }
                    }
                    if (zza(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                        z = z2;
                    }
                }
                if (z) {
                    return;
                }
                this.state = -1;
                this.handler.removeCallbacks(this.zzehf);
                return;
            }
            z = true;
            if (z) {
            }
        }
    }

    private final boolean zza(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzehd.x - f) < ((float) this.zzehc) && Math.abs(this.zzehd.y - f2) < ((float) this.zzehc) && Math.abs(this.zzehe.x - f3) < ((float) this.zzehc) && Math.abs(this.zzehe.y - f4) < ((float) this.zzehc);
    }

    public final void showDialog() {
        try {
            if (!(this.context instanceof Activity)) {
                zzd.zzey("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzr.zzlf().zzaae()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = com.google.android.gms.ads.internal.zzr.zzlf().zzaaf() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            int zza = zza((List<String>) arrayList, "Ad Information", true);
            int zza2 = zza((List<String>) arrayList, str, true);
            int zza3 = zza((List<String>) arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context, com.google.android.gms.ads.internal.zzr.zzkx().zzzy());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener(this, zza, zza2, zza3) { // from class: com.google.android.gms.ads.internal.util.zzaf
                private final zzad zzehg;
                private final int zzehh;
                private final int zzehi;
                private final int zzehj;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzehg = this;
                    this.zzehh = zza;
                    this.zzehi = zza2;
                    this.zzehj = zza3;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.zzehg.zza(this.zzehh, this.zzehi, this.zzehj, dialogInterface, i);
                }
            });
            builder.create().show();
        } catch (WindowManager.BadTokenException e2) {
            zzd.zza("", e2);
        }
    }

    public final void setAdUnitId(String str) {
        this.zzbvf = str;
    }

    public final void zzu(String str) {
        this.zzbrz = str;
    }

    public final void zzeo(String str) {
        this.zzdul = str;
    }

    public final void zzep(String str) {
        this.zzdyc = str;
    }

    private static int zza(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzdul);
        sb.append(",DebugSignal: ");
        sb.append(this.zzdyc);
        sb.append(",AFMA Version: ");
        sb.append(this.zzbrz);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzbvf);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaaa() {
        com.google.android.gms.ads.internal.zzr.zzlf().zza(this.context, this.zzbvf, this.zzbrz, this.zzdyc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaab() {
        com.google.android.gms.ads.internal.zzr.zzlf().zze(this.context, this.zzbvf, this.zzbrz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        zzj.zza(this.context, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void zza(int i, int i2, int i3, DialogInterface dialogInterface, int i4) {
        String str;
        if (i4 != i) {
            if (i4 == i2) {
                zzd.zzdz("Debug mode [Creative Preview] selected.");
                zzbat.zzeke.execute(new Runnable(this) { // from class: com.google.android.gms.ads.internal.util.zzak
                    private final zzad zzehg;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzehg = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzehg.zzaab();
                    }
                });
            } else if (i4 == i3) {
                zzd.zzdz("Debug mode [Troubleshooting] selected.");
                zzbat.zzeke.execute(new Runnable(this) { // from class: com.google.android.gms.ads.internal.util.zzaj
                    private final zzad zzehg;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzehg = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzehg.zzaaa();
                    }
                });
            }
        } else if (!(this.context instanceof Activity)) {
            zzd.zzey("Can not create dialog without Activity Context");
        } else {
            String str2 = this.zzdul;
            if (!TextUtils.isEmpty(str2)) {
                Uri build = new Uri.Builder().encodedQuery(str2.replaceAll("\\+", "%20")).build();
                StringBuilder sb = new StringBuilder();
                com.google.android.gms.ads.internal.zzr.zzkv();
                Map<String, String> zzg = zzj.zzg(build);
                for (String str3 : zzg.keySet()) {
                    sb.append(str3);
                    sb.append(" = ");
                    sb.append(zzg.get(str3));
                    sb.append("\n\n");
                }
                str = sb.toString().trim();
            }
            str = "No debug information";
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setMessage(str);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new DialogInterface.OnClickListener(this, str) { // from class: com.google.android.gms.ads.internal.util.zzai
                private final String zzdkl;
                private final zzad zzehg;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzehg = this;
                    this.zzdkl = str;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i5) {
                    this.zzehg.zza(this.zzdkl, dialogInterface2, i5);
                }
            });
            builder.setNegativeButton("Close", zzah.zzehk);
            builder.create().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaac() {
        this.state = 4;
        showDialog();
    }
}
