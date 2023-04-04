package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaqz extends zzarj {
    private static final Set<String> zzdqt = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private int height;
    private final Object lock;
    private int width;
    private zzari zzdjk;
    private final zzbfi zzdkm;
    private final Activity zzdqj;
    private String zzdqu;
    private boolean zzdqv;
    private int zzdqw;
    private int zzdqx;
    private int zzdqy;
    private int zzdqz;
    private zzbgx zzdra;
    private ImageView zzdrb;
    private LinearLayout zzdrc;
    private PopupWindow zzdrd;
    private RelativeLayout zzdre;
    private ViewGroup zzdrf;

    public zzaqz(zzbfi zzbfiVar, zzari zzariVar) {
        super(zzbfiVar, "resize");
        this.zzdqu = "top-right";
        this.zzdqv = true;
        this.zzdqw = 0;
        this.zzdqx = 0;
        this.height = -1;
        this.zzdqy = 0;
        this.zzdqz = 0;
        this.width = -1;
        this.lock = new Object();
        this.zzdkm = zzbfiVar;
        this.zzdqj = zzbfiVar.zzabx();
        this.zzdjk = zzariVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x021c A[Catch: all -> 0x04b6, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0132, B:62:0x0138, B:64:0x013c, B:67:0x0142, B:69:0x0146, B:71:0x014a, B:142:0x0297, B:143:0x029c, B:145:0x029e, B:147:0x02c0, B:149:0x02c4, B:151:0x02d4, B:153:0x0306, B:157:0x0338, B:158:0x036c, B:188:0x03c2, B:195:0x03f1, B:196:0x0409, B:197:0x0428, B:199:0x0430, B:200:0x0439, B:201:0x045e, B:204:0x0461, B:206:0x0471, B:208:0x047b, B:210:0x048d, B:211:0x04a6, B:207:0x0476, B:189:0x03c9, B:190:0x03d0, B:191:0x03d7, B:192:0x03de, B:193:0x03e4, B:194:0x03eb, B:160:0x0370, B:163:0x037a, B:166:0x0384, B:169:0x038e, B:172:0x0398, B:175:0x03a2, B:152:0x0301, B:213:0x04a8, B:214:0x04ad, B:125:0x023b, B:127:0x023f, B:128:0x0250, B:134:0x027b, B:136:0x027f, B:140:0x028f, B:137:0x0282, B:139:0x0289, B:131:0x0272, B:133:0x0277, B:72:0x0151, B:74:0x0155, B:75:0x015b, B:102:0x01a8, B:110:0x0219, B:112:0x021c, B:114:0x021f, B:116:0x0223, B:103:0x01b6, B:106:0x01e6, B:104:0x01c7, B:105:0x01da, B:107:0x01e9, B:108:0x0200, B:109:0x0210, B:77:0x015f, B:80:0x0169, B:83:0x0173, B:86:0x017d, B:89:0x0187, B:92:0x0191, B:120:0x022b, B:121:0x0231, B:216:0x04af, B:217:0x04b4), top: B:222:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023b A[Catch: all -> 0x04b6, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0132, B:62:0x0138, B:64:0x013c, B:67:0x0142, B:69:0x0146, B:71:0x014a, B:142:0x0297, B:143:0x029c, B:145:0x029e, B:147:0x02c0, B:149:0x02c4, B:151:0x02d4, B:153:0x0306, B:157:0x0338, B:158:0x036c, B:188:0x03c2, B:195:0x03f1, B:196:0x0409, B:197:0x0428, B:199:0x0430, B:200:0x0439, B:201:0x045e, B:204:0x0461, B:206:0x0471, B:208:0x047b, B:210:0x048d, B:211:0x04a6, B:207:0x0476, B:189:0x03c9, B:190:0x03d0, B:191:0x03d7, B:192:0x03de, B:193:0x03e4, B:194:0x03eb, B:160:0x0370, B:163:0x037a, B:166:0x0384, B:169:0x038e, B:172:0x0398, B:175:0x03a2, B:152:0x0301, B:213:0x04a8, B:214:0x04ad, B:125:0x023b, B:127:0x023f, B:128:0x0250, B:134:0x027b, B:136:0x027f, B:140:0x028f, B:137:0x0282, B:139:0x0289, B:131:0x0272, B:133:0x0277, B:72:0x0151, B:74:0x0155, B:75:0x015b, B:102:0x01a8, B:110:0x0219, B:112:0x021c, B:114:0x021f, B:116:0x0223, B:103:0x01b6, B:106:0x01e6, B:104:0x01c7, B:105:0x01da, B:107:0x01e9, B:108:0x0200, B:109:0x0210, B:77:0x015f, B:80:0x0169, B:83:0x0173, B:86:0x017d, B:89:0x0187, B:92:0x0191, B:120:0x022b, B:121:0x0231, B:216:0x04af, B:217:0x04b4), top: B:222:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0297 A[Catch: all -> 0x04b6, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0132, B:62:0x0138, B:64:0x013c, B:67:0x0142, B:69:0x0146, B:71:0x014a, B:142:0x0297, B:143:0x029c, B:145:0x029e, B:147:0x02c0, B:149:0x02c4, B:151:0x02d4, B:153:0x0306, B:157:0x0338, B:158:0x036c, B:188:0x03c2, B:195:0x03f1, B:196:0x0409, B:197:0x0428, B:199:0x0430, B:200:0x0439, B:201:0x045e, B:204:0x0461, B:206:0x0471, B:208:0x047b, B:210:0x048d, B:211:0x04a6, B:207:0x0476, B:189:0x03c9, B:190:0x03d0, B:191:0x03d7, B:192:0x03de, B:193:0x03e4, B:194:0x03eb, B:160:0x0370, B:163:0x037a, B:166:0x0384, B:169:0x038e, B:172:0x0398, B:175:0x03a2, B:152:0x0301, B:213:0x04a8, B:214:0x04ad, B:125:0x023b, B:127:0x023f, B:128:0x0250, B:134:0x027b, B:136:0x027f, B:140:0x028f, B:137:0x0282, B:139:0x0289, B:131:0x0272, B:133:0x0277, B:72:0x0151, B:74:0x0155, B:75:0x015b, B:102:0x01a8, B:110:0x0219, B:112:0x021c, B:114:0x021f, B:116:0x0223, B:103:0x01b6, B:106:0x01e6, B:104:0x01c7, B:105:0x01da, B:107:0x01e9, B:108:0x0200, B:109:0x0210, B:77:0x015f, B:80:0x0169, B:83:0x0173, B:86:0x017d, B:89:0x0187, B:92:0x0191, B:120:0x022b, B:121:0x0231, B:216:0x04af, B:217:0x04b4), top: B:222:0x0007, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x029e A[Catch: all -> 0x04b6, TryCatch #0 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:9:0x0012, B:11:0x001a, B:12:0x001f, B:14:0x0021, B:16:0x002d, B:17:0x0032, B:19:0x0034, B:21:0x003c, B:22:0x0041, B:24:0x0043, B:26:0x0051, B:27:0x0062, B:29:0x0070, B:30:0x0081, B:32:0x008f, B:33:0x00a0, B:35:0x00ae, B:36:0x00bf, B:38:0x00cd, B:39:0x00db, B:41:0x00e9, B:42:0x00eb, B:44:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:59:0x0132, B:62:0x0138, B:64:0x013c, B:67:0x0142, B:69:0x0146, B:71:0x014a, B:142:0x0297, B:143:0x029c, B:145:0x029e, B:147:0x02c0, B:149:0x02c4, B:151:0x02d4, B:153:0x0306, B:157:0x0338, B:158:0x036c, B:188:0x03c2, B:195:0x03f1, B:196:0x0409, B:197:0x0428, B:199:0x0430, B:200:0x0439, B:201:0x045e, B:204:0x0461, B:206:0x0471, B:208:0x047b, B:210:0x048d, B:211:0x04a6, B:207:0x0476, B:189:0x03c9, B:190:0x03d0, B:191:0x03d7, B:192:0x03de, B:193:0x03e4, B:194:0x03eb, B:160:0x0370, B:163:0x037a, B:166:0x0384, B:169:0x038e, B:172:0x0398, B:175:0x03a2, B:152:0x0301, B:213:0x04a8, B:214:0x04ad, B:125:0x023b, B:127:0x023f, B:128:0x0250, B:134:0x027b, B:136:0x027f, B:140:0x028f, B:137:0x0282, B:139:0x0289, B:131:0x0272, B:133:0x0277, B:72:0x0151, B:74:0x0155, B:75:0x015b, B:102:0x01a8, B:110:0x0219, B:112:0x021c, B:114:0x021f, B:116:0x0223, B:103:0x01b6, B:106:0x01e6, B:104:0x01c7, B:105:0x01da, B:107:0x01e9, B:108:0x0200, B:109:0x0210, B:77:0x015f, B:80:0x0169, B:83:0x0173, B:86:0x017d, B:89:0x0187, B:92:0x0191, B:120:0x022b, B:121:0x0231, B:216:0x04af, B:217:0x04b4), top: B:222:0x0007, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzg(Map<String, String> map) {
        boolean z;
        int[] iArr;
        char c2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        synchronized (this.lock) {
            if (this.zzdqj == null) {
                zzdt("Not an activity context. Cannot resize.");
            } else if (this.zzdkm.zzaed() == null) {
                zzdt("Webview is not yet available, size is not set.");
            } else if (this.zzdkm.zzaed().zzafj()) {
                zzdt("Is interstitial. Cannot resize an interstitial.");
            } else if (this.zzdkm.zzaek()) {
                zzdt("Cannot resize an expanded banner.");
            } else {
                if (!TextUtils.isEmpty(map.get("width"))) {
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    this.width = com.google.android.gms.ads.internal.util.zzj.zzei(map.get("width"));
                }
                if (!TextUtils.isEmpty(map.get("height"))) {
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    this.height = com.google.android.gms.ads.internal.util.zzj.zzei(map.get("height"));
                }
                if (!TextUtils.isEmpty(map.get("offsetX"))) {
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    this.zzdqy = com.google.android.gms.ads.internal.util.zzj.zzei(map.get("offsetX"));
                }
                if (!TextUtils.isEmpty(map.get("offsetY"))) {
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    this.zzdqz = com.google.android.gms.ads.internal.util.zzj.zzei(map.get("offsetY"));
                }
                if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
                    this.zzdqv = Boolean.parseBoolean(map.get("allowOffscreen"));
                }
                String str = map.get("customClosePosition");
                if (!TextUtils.isEmpty(str)) {
                    this.zzdqu = str;
                }
                if (!(this.width >= 0 && this.height >= 0)) {
                    zzdt("Invalid width and height options. Cannot resize.");
                    return;
                }
                Window window = this.zzdqj.getWindow();
                if (window != null && window.getDecorView() != null) {
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    int[] zzg = com.google.android.gms.ads.internal.util.zzj.zzg(this.zzdqj);
                    com.google.android.gms.ads.internal.zzr.zzkv();
                    int[] zzh = com.google.android.gms.ads.internal.util.zzj.zzh(this.zzdqj);
                    int i7 = zzg[0];
                    int i8 = zzg[1];
                    char c3 = 65535;
                    if (this.width >= 50 && this.width <= i7) {
                        if (this.height >= 50 && this.height <= i8) {
                            if (this.height == i8 && this.width == i7) {
                                com.google.android.gms.ads.internal.util.zzd.zzez("Cannot resize to a full-screen ad.");
                            } else {
                                if (this.zzdqv) {
                                    String str2 = this.zzdqu;
                                    switch (str2.hashCode()) {
                                        case -1364013995:
                                            if (str2.equals("center")) {
                                                c2 = 2;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -1012429441:
                                            if (str2.equals("top-left")) {
                                                c2 = 0;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case -655373719:
                                            if (str2.equals("bottom-left")) {
                                                c2 = 3;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 1163912186:
                                            if (str2.equals("bottom-right")) {
                                                c2 = 5;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 1288627767:
                                            if (str2.equals("bottom-center")) {
                                                c2 = 4;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        case 1755462605:
                                            if (str2.equals("top-center")) {
                                                c2 = 1;
                                                break;
                                            }
                                            c2 = 65535;
                                            break;
                                        default:
                                            c2 = 65535;
                                            break;
                                    }
                                    if (c2 == 0) {
                                        i = this.zzdqw + this.zzdqy;
                                        i2 = this.zzdqx;
                                        i3 = this.zzdqz;
                                    } else if (c2 != 1) {
                                        if (c2 != 2) {
                                            if (c2 == 3) {
                                                i = this.zzdqw + this.zzdqy;
                                                i5 = this.zzdqx + this.zzdqz;
                                                i6 = this.height;
                                            } else if (c2 == 4) {
                                                i = ((this.zzdqw + this.zzdqy) + (this.width / 2)) - 25;
                                                i5 = this.zzdqx + this.zzdqz;
                                                i6 = this.height;
                                            } else if (c2 == 5) {
                                                i = ((this.zzdqw + this.zzdqy) + this.width) - 50;
                                                i5 = this.zzdqx + this.zzdqz;
                                                i6 = this.height;
                                            } else {
                                                i = ((this.zzdqw + this.zzdqy) + this.width) - 50;
                                                i2 = this.zzdqx;
                                                i3 = this.zzdqz;
                                            }
                                            i4 = (i5 + i6) - 50;
                                        } else {
                                            i = ((this.zzdqw + this.zzdqy) + (this.width / 2)) - 25;
                                            i4 = ((this.zzdqx + this.zzdqz) + (this.height / 2)) - 25;
                                        }
                                        if (i >= 0) {
                                            if (i + 50 <= i7) {
                                                if (i4 >= zzh[0]) {
                                                    if (i4 + 50 <= zzh[1]) {
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        i = ((this.zzdqw + this.zzdqy) + (this.width / 2)) - 25;
                                        i2 = this.zzdqx;
                                        i3 = this.zzdqz;
                                    }
                                    i4 = i2 + i3;
                                    if (i >= 0) {
                                    }
                                }
                                z = true;
                                if (z) {
                                    iArr = null;
                                } else if (this.zzdqv) {
                                    iArr = new int[]{this.zzdqw + this.zzdqy, this.zzdqx + this.zzdqz};
                                } else {
                                    com.google.android.gms.ads.internal.zzr.zzkv();
                                    int[] zzg2 = com.google.android.gms.ads.internal.util.zzj.zzg(this.zzdqj);
                                    com.google.android.gms.ads.internal.zzr.zzkv();
                                    int[] zzh2 = com.google.android.gms.ads.internal.util.zzj.zzh(this.zzdqj);
                                    int i9 = zzg2[0];
                                    int i10 = this.zzdqw + this.zzdqy;
                                    int i11 = this.zzdqx + this.zzdqz;
                                    if (i10 < 0) {
                                        i10 = 0;
                                    } else if (this.width + i10 > i9) {
                                        i10 = i9 - this.width;
                                    }
                                    if (i11 < zzh2[0]) {
                                        i11 = zzh2[0];
                                    } else if (this.height + i11 > zzh2[1]) {
                                        i11 = zzh2[1] - this.height;
                                    }
                                    iArr = new int[]{i10, i11};
                                }
                                if (iArr != null) {
                                    zzdt("Resize location out of screen or close button is not visible.");
                                    return;
                                }
                                zzww.zzqw();
                                int zze = zzbae.zze(this.zzdqj, this.width);
                                zzww.zzqw();
                                int zze2 = zzbae.zze(this.zzdqj, this.height);
                                ViewParent parent = this.zzdkm.getView().getParent();
                                if (parent != null && (parent instanceof ViewGroup)) {
                                    ((ViewGroup) parent).removeView(this.zzdkm.getView());
                                    if (this.zzdrd == null) {
                                        this.zzdrf = (ViewGroup) parent;
                                        com.google.android.gms.ads.internal.zzr.zzkv();
                                        Bitmap zzm = com.google.android.gms.ads.internal.util.zzj.zzm(this.zzdkm.getView());
                                        ImageView imageView = new ImageView(this.zzdqj);
                                        this.zzdrb = imageView;
                                        imageView.setImageBitmap(zzm);
                                        this.zzdra = this.zzdkm.zzaed();
                                        this.zzdrf.addView(this.zzdrb);
                                    } else {
                                        this.zzdrd.dismiss();
                                    }
                                    RelativeLayout relativeLayout = new RelativeLayout(this.zzdqj);
                                    this.zzdre = relativeLayout;
                                    relativeLayout.setBackgroundColor(0);
                                    this.zzdre.setLayoutParams(new ViewGroup.LayoutParams(zze, zze2));
                                    com.google.android.gms.ads.internal.zzr.zzkv();
                                    PopupWindow zza = com.google.android.gms.ads.internal.util.zzj.zza(this.zzdre, zze, zze2, false);
                                    this.zzdrd = zza;
                                    zza.setOutsideTouchable(true);
                                    this.zzdrd.setTouchable(true);
                                    this.zzdrd.setClippingEnabled(!this.zzdqv);
                                    this.zzdre.addView(this.zzdkm.getView(), -1, -1);
                                    this.zzdrc = new LinearLayout(this.zzdqj);
                                    zzww.zzqw();
                                    int zze3 = zzbae.zze(this.zzdqj, 50);
                                    zzww.zzqw();
                                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(zze3, zzbae.zze(this.zzdqj, 50));
                                    String str3 = this.zzdqu;
                                    switch (str3.hashCode()) {
                                        case -1364013995:
                                            if (str3.equals("center")) {
                                                c3 = 2;
                                                break;
                                            }
                                            break;
                                        case -1012429441:
                                            if (str3.equals("top-left")) {
                                                c3 = 0;
                                                break;
                                            }
                                            break;
                                        case -655373719:
                                            if (str3.equals("bottom-left")) {
                                                c3 = 3;
                                                break;
                                            }
                                            break;
                                        case 1163912186:
                                            if (str3.equals("bottom-right")) {
                                                c3 = 5;
                                                break;
                                            }
                                            break;
                                        case 1288627767:
                                            if (str3.equals("bottom-center")) {
                                                c3 = 4;
                                                break;
                                            }
                                            break;
                                        case 1755462605:
                                            if (str3.equals("top-center")) {
                                                c3 = 1;
                                                break;
                                            }
                                            break;
                                    }
                                    if (c3 == 0) {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(9);
                                    } else if (c3 == 1) {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(14);
                                    } else if (c3 == 2) {
                                        layoutParams.addRule(13);
                                    } else if (c3 == 3) {
                                        layoutParams.addRule(12);
                                        layoutParams.addRule(9);
                                    } else if (c3 == 4) {
                                        layoutParams.addRule(12);
                                        layoutParams.addRule(14);
                                    } else if (c3 == 5) {
                                        layoutParams.addRule(12);
                                        layoutParams.addRule(11);
                                    } else {
                                        layoutParams.addRule(10);
                                        layoutParams.addRule(11);
                                    }
                                    this.zzdrc.setOnClickListener(new zzaqy(this));
                                    this.zzdrc.setContentDescription("Close button");
                                    this.zzdre.addView(this.zzdrc, layoutParams);
                                    try {
                                        PopupWindow popupWindow = this.zzdrd;
                                        View decorView = window.getDecorView();
                                        zzww.zzqw();
                                        int zze4 = zzbae.zze(this.zzdqj, iArr[0]);
                                        zzww.zzqw();
                                        popupWindow.showAtLocation(decorView, 0, zze4, zzbae.zze(this.zzdqj, iArr[1]));
                                        int i12 = iArr[0];
                                        int i13 = iArr[1];
                                        if (this.zzdjk != null) {
                                            this.zzdjk.zza(i12, i13, this.width, this.height);
                                        }
                                        this.zzdkm.zza(zzbgx.zzs(zze, zze2));
                                        int i14 = iArr[0];
                                        int i15 = iArr[1];
                                        com.google.android.gms.ads.internal.zzr.zzkv();
                                        zzb(i14, i15 - com.google.android.gms.ads.internal.util.zzj.zzh(this.zzdqj)[0], this.width, this.height);
                                        zzdv("resized");
                                        return;
                                    } catch (RuntimeException e2) {
                                        String valueOf = String.valueOf(e2.getMessage());
                                        zzdt(valueOf.length() != 0 ? "Cannot show popup window: ".concat(valueOf) : new String("Cannot show popup window: "));
                                        this.zzdre.removeView(this.zzdkm.getView());
                                        if (this.zzdrf != null) {
                                            this.zzdrf.removeView(this.zzdrb);
                                            this.zzdrf.addView(this.zzdkm.getView());
                                            this.zzdkm.zza(this.zzdra);
                                        }
                                        return;
                                    }
                                }
                                zzdt("Webview is detached, probably in the middle of a resize or expand.");
                                return;
                            }
                            z = false;
                            if (z) {
                            }
                            if (iArr != null) {
                            }
                        }
                        com.google.android.gms.ads.internal.util.zzd.zzez("Height is too small or too large.");
                        z = false;
                        if (z) {
                        }
                        if (iArr != null) {
                        }
                    }
                    com.google.android.gms.ads.internal.util.zzd.zzez("Width is too small or too large.");
                    z = false;
                    if (z) {
                    }
                    if (iArr != null) {
                    }
                }
                zzdt("Activity context is not ready, cannot get window or decor view.");
            }
        }
    }

    public final void zzag(boolean z) {
        synchronized (this.lock) {
            if (this.zzdrd != null) {
                this.zzdrd.dismiss();
                this.zzdre.removeView(this.zzdkm.getView());
                if (this.zzdrf != null) {
                    this.zzdrf.removeView(this.zzdrb);
                    this.zzdrf.addView(this.zzdkm.getView());
                    this.zzdkm.zza(this.zzdra);
                }
                if (z) {
                    zzdv("default");
                    if (this.zzdjk != null) {
                        this.zzdjk.zzwb();
                    }
                }
                this.zzdrd = null;
                this.zzdre = null;
                this.zzdrf = null;
                this.zzdrc = null;
            }
        }
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.lock) {
            this.zzdqw = i;
            this.zzdqx = i2;
            PopupWindow popupWindow = this.zzdrd;
        }
    }

    public final boolean zzwa() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdrd != null;
        }
        return z;
    }

    public final void zzk(int i, int i2) {
        this.zzdqw = i;
        this.zzdqx = i2;
    }
}
