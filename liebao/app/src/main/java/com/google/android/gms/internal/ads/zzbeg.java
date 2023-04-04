package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbeg implements zzaig<zzbcs> {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007a A[Catch: NumberFormatException -> 0x00ca, NullPointerException | NumberFormatException -> 0x00cc, TryCatch #2 {NullPointerException | NumberFormatException -> 0x00cc, blocks: (B:4:0x000c, B:5:0x0033, B:11:0x0069, B:15:0x007f, B:17:0x0085, B:18:0x00c3, B:14:0x007a), top: B:25:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085 A[Catch: NumberFormatException -> 0x00ca, NullPointerException | NumberFormatException -> 0x00cc, TryCatch #2 {NullPointerException | NumberFormatException -> 0x00cc, blocks: (B:4:0x000c, B:5:0x0033, B:11:0x0069, B:15:0x007f, B:17:0x0085, B:18:0x00c3, B:14:0x007a), top: B:25:0x000c }] */
    @Override // com.google.android.gms.internal.ads.zzaig
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ void zza(zzbcs zzbcsVar, Map map) {
        int i;
        zzbcs zzbcsVar2 = zzbcsVar;
        zzbgc zzabv = zzbcsVar2.zzabv();
        if (zzabv == null) {
            try {
                zzbgc zzbgcVar = new zzbgc(zzbcsVar2, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzbcsVar2.zza(zzbgcVar);
                zzabv = zzbgcVar;
            } catch (NullPointerException | NumberFormatException e2) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Unable to parse videoMeta message.", e2);
                com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get("duration"));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        if (parseInt >= 0 && 3 >= parseInt) {
            i = parseInt;
            String str = (String) map.get("aspectRatio");
            float parseFloat3 = !TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (com.google.android.gms.ads.internal.util.zzd.isLoggable(3)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 140);
                sb.append("Video Meta GMSG: currentTime : ");
                sb.append(parseFloat2);
                sb.append(" , duration : ");
                sb.append(parseFloat);
                sb.append(" , isMuted : ");
                sb.append(equals);
                sb.append(" , playbackState : ");
                sb.append(i);
                sb.append(" , aspectRatio : ");
                sb.append(str);
                com.google.android.gms.ads.internal.util.zzd.zzdz(sb.toString());
            }
            zzabv.zza(parseFloat2, parseFloat, i, equals, parseFloat3);
        }
        i = 0;
        String str2 = (String) map.get("aspectRatio");
        if (!TextUtils.isEmpty(str2)) {
        }
        if (com.google.android.gms.ads.internal.util.zzd.isLoggable(3)) {
        }
        zzabv.zza(parseFloat2, parseFloat, i, equals, parseFloat3);
    }
}
