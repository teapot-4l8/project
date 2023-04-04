package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaee extends zzaev {
    private final int height;
    private final Uri uri;
    private final int width;
    private final Drawable zzdgv;
    private final double zzdgw;

    public zzaee(Drawable drawable, Uri uri, double d2, int i, int i2) {
        this.zzdgv = drawable;
        this.uri = uri;
        this.zzdgw = d2;
        this.width = i;
        this.height = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final IObjectWrapper zztn() {
        return ObjectWrapper.wrap(this.zzdgv);
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final double getScale() {
        return this.zzdgw;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final int getWidth() {
        return this.width;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final int getHeight() {
        return this.height;
    }
}
