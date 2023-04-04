package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaec extends RelativeLayout {
    private static final float[] zzdgj = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private AnimationDrawable zzdgk;

    public zzaec(Context context, zzaed zzaedVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.checkNotNull(zzaedVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzdgj, null, null));
        shapeDrawable.getPaint().setColor(zzaedVar.getBackgroundColor());
        setLayoutParams(layoutParams);
        com.google.android.gms.ads.internal.zzr.zzkx();
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzaedVar.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzaedVar.getText());
            textView.setTextColor(zzaedVar.getTextColor());
            textView.setTextSize(zzaedVar.getTextSize());
            zzww.zzqw();
            int zze = zzbae.zze(context, 4);
            zzww.zzqw();
            textView.setPadding(zze, 0, zzbae.zze(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzaee> zztk = zzaedVar.zztk();
        if (zztk != null && zztk.size() > 1) {
            this.zzdgk = new AnimationDrawable();
            for (zzaee zzaeeVar : zztk) {
                try {
                    this.zzdgk.addFrame((Drawable) ObjectWrapper.unwrap(zzaeeVar.zztn()), zzaedVar.zztl());
                } catch (Exception e2) {
                    com.google.android.gms.ads.internal.util.zzd.zzc("Error while getting drawable.", e2);
                }
            }
            com.google.android.gms.ads.internal.zzr.zzkx();
            imageView.setBackground(this.zzdgk);
        } else if (zztk.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.unwrap(zztk.get(0).zztn()));
            } catch (Exception e3) {
                com.google.android.gms.ads.internal.util.zzd.zzc("Error while getting drawable.", e3);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzdgk;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
