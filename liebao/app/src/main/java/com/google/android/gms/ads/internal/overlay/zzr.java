package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzr extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzduq;
    private final zzab zzdur;

    public zzr(Context context, zzq zzqVar, zzab zzabVar) {
        super(context);
        this.zzdur = zzabVar;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zzduq = imageButton;
        imageButton.setImageResource(17301527);
        this.zzduq.setBackgroundColor(0);
        this.zzduq.setOnClickListener(this);
        ImageButton imageButton2 = this.zzduq;
        zzww.zzqw();
        int zze = zzbae.zze(context, zzqVar.paddingLeft);
        zzww.zzqw();
        int zze2 = zzbae.zze(context, 0);
        zzww.zzqw();
        int zze3 = zzbae.zze(context, zzqVar.paddingRight);
        zzww.zzqw();
        imageButton2.setPadding(zze, zze2, zze3, zzbae.zze(context, zzqVar.paddingBottom));
        this.zzduq.setContentDescription("Interstitial close button");
        ImageButton imageButton3 = this.zzduq;
        zzww.zzqw();
        int zze4 = zzbae.zze(context, zzqVar.size + zzqVar.paddingLeft + zzqVar.paddingRight);
        zzww.zzqw();
        addView(imageButton3, new FrameLayout.LayoutParams(zze4, zzbae.zze(context, zzqVar.size + zzqVar.paddingBottom), 17));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzab zzabVar = this.zzdur;
        if (zzabVar != null) {
            zzabVar.zzwg();
        }
    }

    public final void zzap(boolean z) {
        if (z) {
            this.zzduq.setVisibility(8);
        } else {
            this.zzduq.setVisibility(0);
        }
    }
}
