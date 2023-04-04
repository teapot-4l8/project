package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaqx implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqu zzdqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqx(zzaqu zzaquVar) {
        this.zzdqr = zzaquVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        Intent createIntent = this.zzdqr.createIntent();
        com.google.android.gms.ads.internal.zzr.zzkv();
        context = this.zzdqr.context;
        com.google.android.gms.ads.internal.util.zzj.zza(context, createIntent);
    }
}
