package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public interface zzbfi extends com.google.android.gms.ads.internal.zzm, zzakr, zzalf, zzbcs, zzbex, zzbgd, zzbgk, zzbgo, zzbgp, zzbgr, zzbgs, zzqw, zzve {
    void destroy();

    @Override // com.google.android.gms.internal.ads.zzbcs, com.google.android.gms.internal.ads.zzbgk
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    @Override // com.google.android.gms.internal.ads.zzbgr
    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzbcs
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(com.google.android.gms.ads.internal.overlay.zze zzeVar);

    void zza(zzaef zzaefVar);

    void zza(zzaeg zzaegVar);

    @Override // com.google.android.gms.internal.ads.zzbcs
    void zza(zzbgc zzbgcVar);

    void zza(zzbgx zzbgxVar);

    void zza(zzdot zzdotVar, zzdoy zzdoyVar);

    void zza(zzsi zzsiVar);

    void zza(String str, Predicate<zzaig<? super zzbfi>> predicate);

    void zza(String str, zzaig<? super zzbfi> zzaigVar);

    @Override // com.google.android.gms.internal.ads.zzbcs
    void zza(String str, zzbek zzbekVar);

    @Override // com.google.android.gms.internal.ads.zzbcs
    zzbgc zzabv();

    @Override // com.google.android.gms.internal.ads.zzbcs, com.google.android.gms.internal.ads.zzbgk
    Activity zzabx();

    @Override // com.google.android.gms.internal.ads.zzbcs
    com.google.android.gms.ads.internal.zzb zzaby();

    void zzac(boolean z);

    @Override // com.google.android.gms.internal.ads.zzbcs
    zzace zzacb();

    @Override // com.google.android.gms.internal.ads.zzbcs, com.google.android.gms.internal.ads.zzbgs
    zzbar zzacc();

    @Override // com.google.android.gms.internal.ads.zzbex
    zzdot zzadk();

    void zzady();

    void zzadz();

    Context zzaea();

    com.google.android.gms.ads.internal.overlay.zze zzaeb();

    com.google.android.gms.ads.internal.overlay.zze zzaec();

    @Override // com.google.android.gms.internal.ads.zzbgq
    zzbgx zzaed();

    String zzaee();

    zzbgu zzaef();

    WebViewClient zzaeg();

    boolean zzaeh();

    @Override // com.google.android.gms.internal.ads.zzbgp
    zzei zzaei();

    IObjectWrapper zzaej();

    boolean zzaek();

    void zzael();

    boolean zzaem();

    boolean zzaen();

    void zzaeo();

    void zzaep();

    zzaeg zzaeq();

    void zzaer();

    void zzaes();

    zzsi zzaet();

    boolean zzaeu();

    @Override // com.google.android.gms.internal.ads.zzbgd
    zzdoy zzaev();

    void zzap(boolean z);

    void zzar(IObjectWrapper iObjectWrapper);

    void zzb(com.google.android.gms.ads.internal.overlay.zze zzeVar);

    void zzb(String str, zzaig<? super zzbfi> zzaigVar);

    void zzb(String str, String str2, String str3);

    void zzbb(boolean z);

    void zzbe(boolean z);

    void zzbf(boolean z);

    void zzbg(boolean z);

    void zzby(Context context);

    boolean zzc(boolean z, int i);

    void zzec(int i);

    void zzwm();
}
