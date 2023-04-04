package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzarn extends NativeAd.Image {
    private final int height;
    private final Uri uri;
    private final int width;
    private final double zzdgw;
    private final zzaes zzdhb;
    private final Drawable zzdhc;

    /* JADX WARN: Can't wrap try/catch for region: R(19:1|2|3|(15:5|6|7|8|9|10|11|12|13|14|15|16|17|18|19)|34|6|7|8|9|10|11|12|13|14|15|16|17|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
        com.google.android.gms.internal.ads.zzbao.zzc("", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0033, code lost:
        com.google.android.gms.internal.ads.zzbao.zzc("", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
        com.google.android.gms.internal.ads.zzbao.zzc("", r1);
        r1 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
        com.google.android.gms.internal.ads.zzbao.zzc("", r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzarn(zzaes zzaesVar) {
        Drawable drawable;
        IObjectWrapper zztn;
        this.zzdhb = zzaesVar;
        Uri uri = null;
        try {
            zztn = zzaesVar.zztn();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
        if (zztn != null) {
            drawable = (Drawable) ObjectWrapper.unwrap(zztn);
            this.zzdhc = drawable;
            uri = this.zzdhb.getUri();
            this.uri = uri;
            double d2 = 1.0d;
            d2 = this.zzdhb.getScale();
            this.zzdgw = d2;
            int i = -1;
            int i2 = this.zzdhb.getWidth();
            this.width = i2;
            i = this.zzdhb.getHeight();
            this.height = i;
        }
        drawable = null;
        this.zzdhc = drawable;
        uri = this.zzdhb.getUri();
        this.uri = uri;
        double d22 = 1.0d;
        d22 = this.zzdhb.getScale();
        this.zzdgw = d22;
        int i3 = -1;
        int i22 = this.zzdhb.getWidth();
        this.width = i22;
        i3 = this.zzdhb.getHeight();
        this.height = i3;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzdhc;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final double getScale() {
        return this.zzdgw;
    }
}
