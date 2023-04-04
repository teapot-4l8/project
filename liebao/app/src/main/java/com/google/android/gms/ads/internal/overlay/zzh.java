package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzad;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzh extends RelativeLayout {
    private zzad zzdts;
    boolean zzdtt;

    public zzh(Context context, String str, String str2, String str3) {
        super(context);
        zzad zzadVar = new zzad(context, str);
        this.zzdts = zzadVar;
        zzadVar.zzu(str2);
        this.zzdts.setAdUnitId(str3);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzdtt) {
            return false;
        }
        this.zzdts.zzd(motionEvent);
        return false;
    }
}
