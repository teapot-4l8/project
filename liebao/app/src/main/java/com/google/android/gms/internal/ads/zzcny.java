package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcny implements zzesa<zzebt<String>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdtg> zzfxq;

    private zzcny(zzesn<zzdtg> zzesnVar, zzesn<Context> zzesnVar2) {
        this.zzfxq = zzesnVar;
        this.zzeyq = zzesnVar2;
    }

    public static zzcny zzai(zzesn<zzdtg> zzesnVar, zzesn<Context> zzesnVar2) {
        return new zzcny(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzebt) zzesg.zzbd(this.zzfxq.get().zzt(zzdth.WEBVIEW_COOKIE).zzc(new Callable(com.google.android.gms.ads.internal.zzr.zzkx().zzbi(this.zzeyq.get())) { // from class: com.google.android.gms.internal.ads.zzcnu
            private final CookieManager zzgqk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgqk = r1;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                CookieManager cookieManager = this.zzgqk;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) zzww.zzra().zzd(zzabq.zzcpu));
            }
        }).zza(1L, TimeUnit.SECONDS).zza(Exception.class, zzcnx.zzgqm).zzayi());
    }
}
