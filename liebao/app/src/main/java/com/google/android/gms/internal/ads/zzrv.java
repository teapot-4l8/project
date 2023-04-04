package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzrv implements ValueCallback<String> {
    private final /* synthetic */ zzrs zzbul;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrv(zzrs zzrsVar) {
        this.zzbul = zzrsVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        this.zzbul.zzbuh.zza(this.zzbul.zzbue, this.zzbul.zzbuf, str, this.zzbul.zzbug);
    }
}
