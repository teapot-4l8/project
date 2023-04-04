package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzbfi;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzk {
    public final Context context;
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzdtv;

    public zzk(zzbfi zzbfiVar) {
        this.zzdtv = zzbfiVar.getLayoutParams();
        ViewParent parent = zzbfiVar.getParent();
        this.context = zzbfiVar.zzaea();
        if (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            this.parent = viewGroup;
            this.index = viewGroup.indexOfChild(zzbfiVar.getView());
            this.parent.removeView(zzbfiVar.getView());
            zzbfiVar.zzbe(true);
            return;
        }
        throw new zzi("Could not get the parent of the WebView for an overlay.");
    }
}
