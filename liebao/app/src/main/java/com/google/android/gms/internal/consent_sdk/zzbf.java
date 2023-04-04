package com.google.android.gms.internal.consent_sdk;

import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzbf extends WebViewClient {
    private final /* synthetic */ zzbe zza;

    private zzbf(zzbe zzbeVar) {
        this.zza = zzbeVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        boolean zza;
        zzbj zzbjVar;
        zzbe zzbeVar = this.zza;
        zza = zzbe.zza(str);
        if (zza) {
            zzbjVar = this.zza.zzb;
            zzbjVar.zza(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean zza;
        zzbj zzbjVar;
        String uri = webResourceRequest.getUrl().toString();
        zzbe zzbeVar = this.zza;
        zza = zzbe.zza(uri);
        if (zza) {
            zzbjVar = this.zza.zzb;
            zzbjVar.zza(uri);
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean zza;
        zzbj zzbjVar;
        zzbe zzbeVar = this.zza;
        zza = zzbe.zza(str);
        if (zza) {
            zzbjVar = this.zza.zzb;
            zzbjVar.zza(str);
            return true;
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        boolean z;
        zzbj unused;
        z = this.zza.zzc;
        if (z) {
            return;
        }
        unused = this.zza.zzb;
        Log.d("UserMessagingPlatform", "Wall html loaded.");
        this.zza.zzc = true;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        zzbj zzbjVar;
        zzbjVar = this.zza.zzb;
        zzbjVar.zza(i, str, str2);
    }
}
