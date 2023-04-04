package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzard implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzara zzdri;
    private final /* synthetic */ String zzdrj;
    private final /* synthetic */ String zzdrk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzard(zzara zzaraVar, String str, String str2) {
        this.zzdri = zzaraVar;
        this.zzdrj = str;
        this.zzdrk = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        context = this.zzdri.context;
        DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
        try {
            String str = this.zzdrj;
            String str2 = this.zzdrk;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            com.google.android.gms.ads.internal.zzr.zzkv();
            com.google.android.gms.ads.internal.util.zzj.zza(request);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.zzdri.zzdt("Could not store picture.");
        }
    }
}
