package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbft extends FrameLayout implements zzbfi {
    private final zzbfi zzeul;
    private final zzbch zzeum;
    private final AtomicBoolean zzeun;

    public zzbft(zzbfi zzbfiVar) {
        super(zzbfiVar.getContext());
        this.zzeun = new AtomicBoolean();
        this.zzeul = zzbfiVar;
        this.zzeum = new zzbch(zzbfiVar.zzaea(), this, this);
        addView(this.zzeul.getView());
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbgr
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final zzbch zzabu() {
        return this.zzeum;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void onPause() {
        this.zzeum.onPause();
        this.zzeul.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzael() {
        this.zzeum.onDestroy();
        this.zzeul.zzael();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzaer() {
        setBackgroundColor(0);
        this.zzeul.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final int zzacd() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final int zzace() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zzacf() {
        this.zzeul.zzacf();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zzdw(int i) {
        this.zzeul.zzdw(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zzdx(int i) {
        this.zzeul.zzdx(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final int zzacg() {
        return this.zzeul.zzacg();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final int zzach() {
        return this.zzeul.zzach();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final WebView getWebView() {
        return this.zzeul.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(String str, Map<String, ?> map) {
        this.zzeul.zza(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(String str, JSONObject jSONObject) {
        this.zzeul.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(String str, zzaig<? super zzbfi> zzaigVar) {
        this.zzeul.zza(str, zzaigVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzb(String str, zzaig<? super zzbfi> zzaigVar) {
        this.zzeul.zzb(str, zzaigVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(String str, Predicate<zzaig<? super zzbfi>> predicate) {
        this.zzeul.zza(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzady() {
        this.zzeul.zzady();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzec(int i) {
        this.zzeul.zzec(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzwm() {
        this.zzeul.zzwm();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzadz() {
        this.zzeul.zzadz();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zza(boolean z, long j) {
        this.zzeul.zza(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zzcv(String str) {
        this.zzeul.zzcv(str);
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zzb(String str, JSONObject jSONObject) {
        this.zzeul.zzb(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs, com.google.android.gms.internal.ads.zzbgk
    public final Activity zzabx() {
        return this.zzeul.zzabx();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final Context zzaea() {
        return this.zzeul.zzaea();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs
    public final com.google.android.gms.ads.internal.zzb zzaby() {
        return this.zzeul.zzaby();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final com.google.android.gms.ads.internal.overlay.zze zzaeb() {
        return this.zzeul.zzaeb();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final IObjectWrapper zzaej() {
        return this.zzeul.zzaej();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final com.google.android.gms.ads.internal.overlay.zze zzaec() {
        return this.zzeul.zzaec();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbgq
    public final zzbgx zzaed() {
        return this.zzeul.zzaed();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final String zzaee() {
        return this.zzeul.zzaee();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final zzbgu zzaef() {
        return this.zzeul.zzaef();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final WebViewClient zzaeg() {
        return this.zzeul.zzaeg();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final boolean zzaeh() {
        return this.zzeul.zzaeh();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbgp
    public final zzei zzaei() {
        return this.zzeul.zzaei();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs, com.google.android.gms.internal.ads.zzbgs
    public final zzbar zzacc() {
        return this.zzeul.zzacc();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final boolean zzaek() {
        return this.zzeul.zzaek();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final boolean isDestroyed() {
        return this.zzeul.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final boolean zzaem() {
        return this.zzeul.zzaem();
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final void zzks() {
        this.zzeul.zzks();
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final void zzkr() {
        this.zzeul.zzkr();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final String getRequestId() {
        return this.zzeul.getRequestId();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final String zzabz() {
        return this.zzeul.zzabz();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zzdv(int i) {
        this.zzeul.zzdv(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final int zzaca() {
        return this.zzeul.zzaca();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final zzacf zzabw() {
        return this.zzeul.zzabw();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs
    public final zzace zzacb() {
        return this.zzeul.zzacb();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs
    public final zzbgc zzabv() {
        return this.zzeul.zzabv();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzeul.zza(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzar(IObjectWrapper iObjectWrapper) {
        this.zzeul.zzar(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(zzbgx zzbgxVar) {
        this.zzeul.zza(zzbgxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzbe(boolean z) {
        this.zzeul.zzbe(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzaeo() {
        this.zzeul.zzaeo();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzby(Context context) {
        this.zzeul.zzby(context);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzap(boolean z) {
        this.zzeul.zzap(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzac(boolean z) {
        this.zzeul.zzac(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void setRequestedOrientation(int i) {
        this.zzeul.setRequestedOrientation(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzb(com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzeul.zzb(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzbf(boolean z) {
        this.zzeul.zzbf(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs
    public final void zza(String str, zzbek zzbekVar) {
        this.zzeul.zza(str, zzbekVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final zzbek zzfe(String str) {
        return this.zzeul.zzfe(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzaep() {
        this.zzeul.zzaep();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void destroy() {
        IObjectWrapper zzaej = zzaej();
        if (zzaej != null) {
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(zzaej) { // from class: com.google.android.gms.internal.ads.zzbfw
                private final IObjectWrapper zzeup;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeup = zzaej;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbft.zzas(this.zzeup);
                }
            });
            com.google.android.gms.ads.internal.util.zzj.zzegq.postDelayed(new zzbfv(this), ((Integer) zzww.zzra().zzd(zzabq.zzcwi)).intValue());
            return;
        }
        this.zzeul.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void loadData(String str, String str2, String str3) {
        this.zzeul.loadData(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzeul.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void loadUrl(String str) {
        this.zzeul.loadUrl(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzb(String str, String str2, String str3) {
        this.zzeul.zzb(str, str2, str3);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbfi
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzeul.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbfi
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzeul.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzeul.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzeul.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void onResume() {
        this.zzeul.onResume();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzaes() {
        TextView textView = new TextView(getContext());
        Resources resources = com.google.android.gms.ads.internal.zzr.zzkz().getResources();
        textView.setText(resources != null ? resources.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzbb(boolean z) {
        this.zzeul.zzbb(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(zzaef zzaefVar) {
        this.zzeul.zza(zzaefVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(zzsi zzsiVar) {
        this.zzeul.zza(zzsiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final zzsi zzaet() {
        return this.zzeul.zzaet();
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        this.zzeul.zza(zzqxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(zzaeg zzaegVar) {
        this.zzeul.zza(zzaegVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final zzaeg zzaeq() {
        return this.zzeul.zzaeq();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs
    public final void zza(zzbgc zzbgcVar) {
        this.zzeul.zza(zzbgcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final boolean zzaen() {
        return this.zzeul.zzaen();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzbg(boolean z) {
        this.zzeul.zzbg(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zzaz(boolean z) {
        this.zzeul.zzaz(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zzwn() {
        this.zzeul.zzwn();
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        this.zzeul.zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zzb(boolean z, int i) {
        this.zzeul.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zza(boolean z, int i, String str) {
        this.zzeul.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzeul.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zza(com.google.android.gms.ads.internal.util.zzbg zzbgVar, zzcsh zzcshVar, zzcmb zzcmbVar, zzdtw zzdtwVar, String str, String str2, int i) {
        this.zzeul.zza(zzbgVar, zzcshVar, zzcmbVar, zzdtwVar, str, str2, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final boolean zzc(boolean z, int i) {
        if (this.zzeun.compareAndSet(false, true)) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcpq)).booleanValue()) {
                return false;
            }
            if (this.zzeul.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.zzeul.getParent()).removeView(this.zzeul.getView());
            }
            return this.zzeul.zzc(z, i);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final boolean zzaeu() {
        return this.zzeun.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbex
    public final zzdot zzadk() {
        return this.zzeul.zzadk();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbgd
    public final zzdoy zzaev() {
        return this.zzeul.zzaev();
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void onAdClicked() {
        zzbfi zzbfiVar = this.zzeul;
        if (zzbfiVar != null) {
            zzbfiVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(zzdot zzdotVar, zzdoy zzdoyVar) {
        this.zzeul.zza(zzdotVar, zzdoyVar);
    }

    public static final /* synthetic */ void zzas(IObjectWrapper iObjectWrapper) {
        com.google.android.gms.ads.internal.zzr.zzlk().zzad(iObjectWrapper);
    }
}
