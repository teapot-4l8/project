package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbfb implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzest;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfb(JsResult jsResult) {
        this.zzest = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzest.confirm();
    }
}