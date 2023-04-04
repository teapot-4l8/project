package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbez implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzest;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbez(JsResult jsResult) {
        this.zzest = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzest.cancel();
    }
}
