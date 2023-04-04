package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzei;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzp extends AsyncTask<Void, Void, String> {
    private final /* synthetic */ zzl zzbqf;

    private zzp(zzl zzlVar) {
        this.zzbqf = zzlVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: zza */
    public final String doInBackground(Void... voidArr) {
        Future future;
        try {
            zzl zzlVar = this.zzbqf;
            future = this.zzbqf.zzbpz;
            zzlVar.zzbqd = (zzei) future.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            zzbao.zzd("", e2);
        }
        return this.zzbqf.zzkp();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(String str) {
        WebView webView;
        WebView webView2;
        String str2 = str;
        webView = this.zzbqf.zzbqb;
        if (webView == null || str2 == null) {
            return;
        }
        webView2 = this.zzbqf.zzbqb;
        webView2.loadUrl(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzp(zzl zzlVar, zzo zzoVar) {
        this(zzlVar);
    }
}
