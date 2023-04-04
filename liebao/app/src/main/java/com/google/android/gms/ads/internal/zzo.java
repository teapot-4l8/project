package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzxc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzo extends WebViewClient {
    private final /* synthetic */ zzl zzbqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzl zzlVar) {
        this.zzbqf = zzlVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        zzxc zzxcVar;
        zzxc zzxcVar2;
        String zzbn;
        zzxc zzxcVar3;
        zzxc zzxcVar4;
        zzxc zzxcVar5;
        zzxc zzxcVar6;
        zzxc zzxcVar7;
        zzxc zzxcVar8;
        if (str.startsWith(this.zzbqf.zzkq())) {
            return false;
        }
        if (!str.startsWith("gmsg://noAdLoaded")) {
            if (!str.startsWith("gmsg://scriptLoadFailed")) {
                if (!str.startsWith("gmsg://adResized")) {
                    if (str.startsWith("gmsg://")) {
                        return true;
                    }
                    zzxcVar = this.zzbqf.zzbqc;
                    if (zzxcVar != null) {
                        try {
                            zzxcVar2 = this.zzbqf.zzbqc;
                            zzxcVar2.onAdLeftApplication();
                        } catch (RemoteException e2) {
                            com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
                        }
                    }
                    zzbn = this.zzbqf.zzbn(str);
                    this.zzbqf.zzbo(zzbn);
                    return true;
                }
                zzxcVar3 = this.zzbqf.zzbqc;
                if (zzxcVar3 != null) {
                    try {
                        zzxcVar4 = this.zzbqf.zzbqc;
                        zzxcVar4.onAdLoaded();
                    } catch (RemoteException e3) {
                        com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e3);
                    }
                }
                this.zzbqf.zzbt(this.zzbqf.zzbm(str));
                return true;
            }
            zzxcVar5 = this.zzbqf.zzbqc;
            if (zzxcVar5 != null) {
                try {
                    zzxcVar6 = this.zzbqf.zzbqc;
                    zzxcVar6.onAdFailedToLoad(0);
                } catch (RemoteException e4) {
                    com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e4);
                }
            }
            this.zzbqf.zzbt(0);
            return true;
        }
        zzxcVar7 = this.zzbqf.zzbqc;
        if (zzxcVar7 != null) {
            try {
                zzxcVar8 = this.zzbqf.zzbqc;
                zzxcVar8.onAdFailedToLoad(3);
            } catch (RemoteException e5) {
                com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e5);
            }
        }
        this.zzbqf.zzbt(0);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzxc zzxcVar;
        zzxc zzxcVar2;
        zzxcVar = this.zzbqf.zzbqc;
        if (zzxcVar != null) {
            try {
                zzxcVar2 = this.zzbqf.zzbqc;
                zzxcVar2.onAdFailedToLoad(0);
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
