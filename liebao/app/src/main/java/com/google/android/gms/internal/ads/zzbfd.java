package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbfd implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzesu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfd(JsPromptResult jsPromptResult) {
        this.zzesu = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzesu.cancel();
    }
}
