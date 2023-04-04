package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbos extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private final Context context;
    private View zzaay;

    public static zzbos zza(Context context, View view, zzdot zzdotVar) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzbos zzbosVar = new zzbos(context);
        if (!zzdotVar.zzhmj.isEmpty() && (resources = zzbosVar.context.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            zzdow zzdowVar = zzdotVar.zzhmj.get(0);
            zzbosVar.setLayoutParams(new FrameLayout.LayoutParams((int) (zzdowVar.width * displayMetrics.density), (int) (zzdowVar.height * displayMetrics.density)));
        }
        zzbosVar.zzaay = view;
        zzbosVar.addView(view);
        com.google.android.gms.ads.internal.zzr.zzls();
        zzbbm.zza((View) zzbosVar, (ViewTreeObserver.OnScrollChangedListener) zzbosVar);
        com.google.android.gms.ads.internal.zzr.zzls();
        zzbbm.zza((View) zzbosVar, (ViewTreeObserver.OnGlobalLayoutListener) zzbosVar);
        JSONObject jSONObject = zzdotVar.zzhmy;
        if (jSONObject != null) {
            RelativeLayout relativeLayout = new RelativeLayout(zzbosVar.context);
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            if (optJSONObject != null) {
                zzbosVar.zza(optJSONObject, relativeLayout, 10);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
            if (optJSONObject2 != null) {
                zzbosVar.zza(optJSONObject2, relativeLayout, 12);
            }
            zzbosVar.addView(relativeLayout);
        }
        return zzbosVar;
    }

    private zzbos(Context context) {
        super(context);
        this.context = context;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzaay.setY(-iArr[1]);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzaay.setY(-iArr[1]);
    }

    private final void zza(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.context);
        textView.setTextColor(-1);
        textView.setBackgroundColor(-16777216);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb = zzb(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, zzb, 0, zzb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    private final int zzb(double d2) {
        zzww.zzqw();
        return zzbae.zze(this.context, (int) d2);
    }
}
