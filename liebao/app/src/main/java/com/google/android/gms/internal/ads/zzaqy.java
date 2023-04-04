package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzaqy implements View.OnClickListener {
    private final /* synthetic */ zzaqz zzdqs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqy(zzaqz zzaqzVar) {
        this.zzdqs = zzaqzVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzdqs.zzag(true);
    }
}
