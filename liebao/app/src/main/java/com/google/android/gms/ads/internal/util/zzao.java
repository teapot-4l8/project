package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzao implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzal zzehs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(zzal zzalVar) {
        this.zzehs = zzalVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        zzj.zzb(this.zzehs.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
