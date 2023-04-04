package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbm implements zzaz {
    private final /* synthetic */ Context val$appContext;
    private File zzdb = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbm(Context context) {
        this.val$appContext = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final File zzo() {
        if (this.zzdb == null) {
            this.zzdb = new File(this.val$appContext.getCacheDir(), "volley");
        }
        return this.zzdb;
    }
}
