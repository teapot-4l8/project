package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzarc implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzara zzdri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarc(zzara zzaraVar) {
        this.zzdri = zzaraVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdri.zzdt("User canceled the download.");
    }
}
