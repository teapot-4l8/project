package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcrn implements zzebi<SQLiteDatabase> {
    private final /* synthetic */ zzdsr zzgtc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcrn(zzcrl zzcrlVar, zzdsr zzdsrVar) {
        this.zzgtc = zzdsrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        com.google.android.gms.ads.internal.util.zzd.zzex(valueOf.length() != 0 ? "Failed to get offline signal database: ".concat(valueOf) : new String("Failed to get offline signal database: "));
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(SQLiteDatabase sQLiteDatabase) {
        try {
            this.zzgtc.apply(sQLiteDatabase);
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            com.google.android.gms.ads.internal.util.zzd.zzex(valueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(valueOf) : new String("Error executing function on offline signal database: "));
        }
    }
}
