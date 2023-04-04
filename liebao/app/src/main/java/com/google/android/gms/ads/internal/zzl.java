package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzacm;
import com.google.android.gms.internal.ads.zzadc;
import com.google.android.gms.internal.ads.zzasr;
import com.google.android.gms.internal.ads.zzasx;
import com.google.android.gms.internal.ads.zzavn;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzeh;
import com.google.android.gms.internal.ads.zzei;
import com.google.android.gms.internal.ads.zzsq;
import com.google.android.gms.internal.ads.zzvq;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzwx;
import com.google.android.gms.internal.ads.zzxc;
import com.google.android.gms.internal.ads.zzxd;
import com.google.android.gms.internal.ads.zzxp;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzxy;
import com.google.android.gms.internal.ads.zzye;
import com.google.android.gms.internal.ads.zzyg;
import com.google.android.gms.internal.ads.zzyx;
import com.google.android.gms.internal.ads.zzzc;
import com.google.android.gms.internal.ads.zzzd;
import com.google.android.gms.internal.ads.zzzj;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzl extends zzxp {
    private final Context context;
    private final zzbar zzbpx;
    private final zzvt zzbpy;
    private final Future<zzei> zzbpz = zzbat.zzeke.zze(new zzq(this));
    private final zzs zzbqa;
    private WebView zzbqb;
    private zzxc zzbqc;
    private zzei zzbqd;
    private AsyncTask<Void, Void, String> zzbqe;

    public zzl(Context context, zzvt zzvtVar, String str, zzbar zzbarVar) {
        this.context = context;
        this.zzbpx = zzbarVar;
        this.zzbpy = zzvtVar;
        this.zzbqb = new WebView(this.context);
        this.zzbqa = new zzs(context, str);
        zzbt(0);
        this.zzbqb.setVerticalScrollBarEnabled(false);
        this.zzbqb.getSettings().setJavaScriptEnabled(true);
        this.zzbqb.setWebViewClient(new zzo(this));
        this.zzbqb.setOnTouchListener(new zzn(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzzd getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean isLoading() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setManualImpressionsEnabled(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzvq zzvqVar, zzxd zzxdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzyg zzygVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzyx zzyxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final String zzkl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzzc zzkm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final IObjectWrapper zzki() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzbqb);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzbqe.cancel(true);
        this.zzbpz.cancel(true);
        this.zzbqb.destroy();
        this.zzbqb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean zza(zzvq zzvqVar) {
        Preconditions.checkNotNull(this.zzbqb, "This Search Ad has already been torn down");
        this.zzbqa.zza(zzvqVar, this.zzbpx);
        this.zzbqe = new zzp(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxc zzxcVar) {
        this.zzbqc = zzxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxy zzxyVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxt zzxtVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void showInterstitial() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzkj() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzvt zzkk() {
        return this.zzbpy;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzvt zzvtVar) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzasr zzasrVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzasx zzasxVar, String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxy zzkn() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxc zzko() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzacm zzacmVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwx zzwxVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzye zzyeVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzavn zzavnVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setUserId(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzbl(String str) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzaaz zzaazVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzzj zzzjVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwc zzwcVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzsq zzsqVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzbm(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzww.zzqw();
            return zzbae.zze(this.context, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzbt(int i) {
        if (this.zzbqb == null) {
            return;
        }
        this.zzbqb.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzkp() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzadc.zzddu.get());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzbqa.getQuery());
        builder.appendQueryParameter("pubId", this.zzbqa.zzlv());
        Map<String, String> zzlw = this.zzbqa.zzlw();
        for (String str : zzlw.keySet()) {
            builder.appendQueryParameter(str, zzlw.get(str));
        }
        Uri build = builder.build();
        zzei zzeiVar = this.zzbqd;
        if (zzeiVar != null) {
            try {
                build = zzeiVar.zza(build, this.context);
            } catch (zzeh e2) {
                com.google.android.gms.ads.internal.util.zzd.zzd("Unable to process ad data", e2);
            }
        }
        String zzkq = zzkq();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(zzkq).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(zzkq);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzkq() {
        String zzlu = this.zzbqa.zzlu();
        if (TextUtils.isEmpty(zzlu)) {
            zzlu = "www.google.com";
        }
        String str = zzadc.zzddu.get();
        StringBuilder sb = new StringBuilder(String.valueOf(zzlu).length() + 8 + String.valueOf(str).length());
        sb.append("https://");
        sb.append(zzlu);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzbn(String str) {
        if (this.zzbqd == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzbqd.zza(parse, this.context, null, null);
        } catch (zzeh e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Unable to process ad data", e2);
        }
        return parse.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbo(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.context.startActivity(intent);
    }
}
