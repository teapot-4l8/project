package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbgp;
import com.google.android.gms.internal.ads.zzbgr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbgg<WebViewT extends zzbgk & zzbgp & zzbgr> {
    private final zzbgh zzewo;
    private final WebViewT zzewp;

    public zzbgg(WebViewT webviewt, zzbgh zzbghVar) {
        this.zzewo = zzbghVar;
        this.zzewp = webviewt;
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zzd.zzez("URL is empty, ignoring message");
        } else {
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzbgi
                private final String zzdkl;
                private final zzbgg zzewq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzewq = this;
                    this.zzdkl = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzewq.zzfo(this.zzdkl);
                }
            });
        }
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Click string is empty, not proceeding.");
            return "";
        }
        zzei zzaei = this.zzewp.zzaei();
        if (zzaei == null) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Signal utils is empty, ignoring.");
            return "";
        }
        zzdy zzcb = zzaei.zzcb();
        if (zzcb == null) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Signals object is empty, ignoring.");
            return "";
        } else if (this.zzewp.getContext() == null) {
            com.google.android.gms.ads.internal.util.zzd.zzed("Context is null, ignoring.");
            return "";
        } else {
            return zzcb.zza(this.zzewp.getContext(), str, this.zzewp.getView(), this.zzewp.zzabx());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzfo(String str) {
        this.zzewo.zzj(Uri.parse(str));
    }
}
