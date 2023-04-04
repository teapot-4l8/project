package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbfe implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsPromptResult zzesu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfe(JsPromptResult jsPromptResult) {
        this.zzesu = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zzesu.cancel();
    }
}
