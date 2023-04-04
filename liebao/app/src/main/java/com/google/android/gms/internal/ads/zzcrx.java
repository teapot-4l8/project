package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzuh;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcrx implements zzebi<Bundle> {
    private final /* synthetic */ boolean zzgtz;
    final /* synthetic */ zzcru zzgua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcrx(zzcru zzcruVar, boolean z) {
        this.zzgua = zzcruVar;
        this.zzgtz = z;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        com.google.android.gms.ads.internal.util.zzd.zzex("Failed to get signals bundle");
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(Bundle bundle) {
        com.google.android.gms.ads.internal.util.zzf zzfVar;
        final ArrayList zzl;
        final zzuh.zzo.zzb zzk;
        final zzuh.zzm zzj;
        zzcrl zzcrlVar;
        Bundle bundle2 = bundle;
        zzfVar = this.zzgua.zzeci;
        if (zzfVar.zzzn()) {
            return;
        }
        zzcru zzcruVar = this.zzgua;
        zzl = zzcru.zzl(bundle2);
        zzcru zzcruVar2 = this.zzgua;
        zzk = zzcru.zzk(bundle2);
        zzj = this.zzgua.zzj(bundle2);
        zzcrlVar = this.zzgua.zzgtr;
        final boolean z = this.zzgtz;
        zzcrlVar.zza(new zzdsr(this, z, zzl, zzj, zzk) { // from class: com.google.android.gms.internal.ads.zzcrw
            private final boolean zzemp;
            private final zzcrx zzgtv;
            private final ArrayList zzgtw;
            private final zzuh.zzm zzgtx;
            private final zzuh.zzo.zzb zzgty;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgtv = this;
                this.zzemp = z;
                this.zzgtw = zzl;
                this.zzgtx = zzj;
                this.zzgty = zzk;
            }

            @Override // com.google.android.gms.internal.ads.zzdsr
            public final Object apply(Object obj) {
                com.google.android.gms.ads.internal.util.zzf zzfVar2;
                byte[] zza;
                zzcrx zzcrxVar = this.zzgtv;
                boolean z2 = this.zzemp;
                ArrayList arrayList = this.zzgtw;
                zzuh.zzm zzmVar = this.zzgtx;
                zzuh.zzo.zzb zzbVar = this.zzgty;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                zzfVar2 = zzcrxVar.zzgua.zzeci;
                if (!zzfVar2.zzzn()) {
                    zza = zzcrxVar.zzgua.zza(z2, arrayList, zzmVar, zzbVar);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("timestamp", Long.valueOf(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis()));
                    contentValues.put("serialized_proto_data", zza);
                    sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
                    sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", "total_requests"));
                    if (!z2) {
                        sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", ak.V));
                    }
                }
                return null;
            }
        });
    }
}
