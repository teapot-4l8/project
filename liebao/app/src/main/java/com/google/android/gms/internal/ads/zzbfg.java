package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbfg implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzesu;
    private final /* synthetic */ EditText zzesw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfg(JsPromptResult jsPromptResult, EditText editText) {
        this.zzesu = jsPromptResult;
        this.zzesw = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzesu.confirm(this.zzesw.getText().toString());
    }
}
