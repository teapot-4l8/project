package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzaqw implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqu zzdqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqw(zzaqu zzaquVar) {
        this.zzdqr = zzaquVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdqr.zzdt("Operation denied by user.");
    }
}
