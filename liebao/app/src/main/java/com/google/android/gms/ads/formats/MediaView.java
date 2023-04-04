package com.google.android.gms.ads.formats;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaej;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public class MediaView extends FrameLayout {
    private MediaContent zzbnv;
    private boolean zzbnw;
    private zzaeh zzbnx;
    private ImageView.ScaleType zzbny;
    private boolean zzbnz;
    private zzaej zzboa;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.zzbnw = true;
        this.zzbnv = mediaContent;
        zzaeh zzaehVar = this.zzbnx;
        if (zzaehVar != null) {
            zzaehVar.setMediaContent(mediaContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void zza(zzaeh zzaehVar) {
        this.zzbnx = zzaehVar;
        if (this.zzbnw) {
            zzaehVar.setMediaContent(this.zzbnv);
        }
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzbnz = true;
        this.zzbny = scaleType;
        zzaej zzaejVar = this.zzboa;
        if (zzaejVar != null) {
            zzaejVar.setImageScaleType(scaleType);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void zza(zzaej zzaejVar) {
        this.zzboa = zzaejVar;
        if (this.zzbnz) {
            zzaejVar.setImageScaleType(this.zzbny);
        }
    }
}
