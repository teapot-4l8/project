package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzuh;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcsb {
    private Context context;
    private final zzdtw zzdjf;
    private zzbar zzdvi;
    private final com.google.android.gms.ads.internal.util.zzf zzeci = com.google.android.gms.ads.internal.zzr.zzkz().zzyl();
    private zzcrl zzgtr;
    private zztz zzgud;
    private final String zzgue;

    public zzcsb(Context context, zzbar zzbarVar, zztz zztzVar, zzcrl zzcrlVar, String str, zzdtw zzdtwVar) {
        this.context = context;
        this.zzdvi = zzbarVar;
        this.zzgud = zztzVar;
        this.zzgtr = zzcrlVar;
        this.zzgue = str;
        this.zzdjf = zzdtwVar;
    }

    public final void zzbo(boolean z) {
        try {
            this.zzgtr.zza(new zzdsr(this, z) { // from class: com.google.android.gms.internal.ads.zzcsa
                private final boolean zzemp;
                private final zzcsb zzguc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzguc = this;
                    this.zzemp = z;
                }

                @Override // com.google.android.gms.internal.ads.zzdsr
                public final Object apply(Object obj) {
                    return this.zzguc.zza(this.zzemp, (SQLiteDatabase) obj);
                }
            });
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            com.google.android.gms.ads.internal.util.zzd.zzex(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    private static void zza(SQLiteDatabase sQLiteDatabase, ArrayList<zzuh.zzo.zza> arrayList) {
        ArrayList<zzuh.zzo.zza> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        long j = 0;
        while (i < size) {
            zzuh.zzo.zza zzaVar = arrayList2.get(i);
            i++;
            zzuh.zzo.zza zzaVar2 = zzaVar;
            if (zzaVar2.zzoz() == zzur.ENUM_TRUE && zzaVar2.getTimestamp() > j) {
                j = zzaVar2.getTimestamp();
            }
        }
        if (j != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, Long.valueOf(j));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(boolean z, SQLiteDatabase sQLiteDatabase) {
        if (z) {
            this.context.deleteDatabase("OfflineUpload.db");
            return null;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            this.zzdjf.zzb(zzdtx.zzgy("oa_upload").zzw("oa_failed_reqs", String.valueOf(zzcry.zza(sQLiteDatabase, 0))).zzw("oa_total_reqs", String.valueOf(zzcry.zza(sQLiteDatabase, 1))).zzw("oa_upload_time", String.valueOf(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis())).zzw("oa_last_successful_time", String.valueOf(zzcry.zzb(sQLiteDatabase, 2))).zzw("oa_session_id", this.zzeci.zzzn() ? "" : this.zzgue));
            ArrayList<zzuh.zzo.zza> zza = zzcry.zza(sQLiteDatabase);
            zza(sQLiteDatabase, zza);
            ArrayList<zzuh.zzo.zza> arrayList = zza;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                zzuh.zzo.zza zzaVar = arrayList.get(i);
                i++;
                zzuh.zzo.zza zzaVar2 = zzaVar;
                zzdtx zzw = zzdtx.zzgy("oa_signals").zzw("oa_session_id", this.zzeci.zzzn() ? "" : this.zzgue);
                zzuh.zzm zzpd = zzaVar2.zzpd();
                zzw.zzw("oa_sig_ts", String.valueOf(zzaVar2.getTimestamp())).zzw("oa_sig_status", String.valueOf(zzaVar2.zzoz().zzv())).zzw("oa_sig_resp_lat", String.valueOf(zzaVar2.zzpa())).zzw("oa_sig_render_lat", String.valueOf(zzaVar2.zzpb())).zzw("oa_sig_formats", zzdzi.zza(zzaVar2.zzpc(), zzcsf.zzebv).toString()).zzw("oa_sig_nw_type", zzpd.zzor() ? String.valueOf(zzpd.zzos().zzv()) : "-1").zzw("oa_sig_wifi", String.valueOf(zzaVar2.zzpe().zzv())).zzw("oa_sig_airplane", String.valueOf(zzaVar2.zzpf().zzv())).zzw("oa_sig_data", String.valueOf(zzaVar2.zzpg().zzv())).zzw("oa_sig_nw_resp", String.valueOf(zzaVar2.zzph())).zzw("oa_sig_offline", String.valueOf(zzaVar2.zzpi().zzv())).zzw("oa_sig_nw_state", String.valueOf(zzaVar2.zzpj().zzv()));
                if (zzpd.zzot() && zzpd.zzor() && zzpd.zzos().equals(zzuh.zzm.zzc.CELL)) {
                    zzw.zzw("oa_sig_cell_type", String.valueOf(zzpd.zzou().zzv()));
                }
                this.zzdjf.zzb(zzw);
            }
        } else {
            ArrayList<zzuh.zzo.zza> zza2 = zzcry.zza(sQLiteDatabase);
            zza(sQLiteDatabase, zza2);
            this.zzgud.zza(new zzty((zzuh.zzo) ((zzena) zzuh.zzo.zzpm().zzca(this.context.getPackageName()).zzcb(Build.MODEL).zzco(zzcry.zza(sQLiteDatabase, 0)).zzf(zza2).zzcp(zzcry.zza(sQLiteDatabase, 1)).zzev(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis()).zzew(zzcry.zzb(sQLiteDatabase, 2)).zzbjv())) { // from class: com.google.android.gms.internal.ads.zzcsd
                private final zzuh.zzo zzgug;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgug = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzty
                public final void zza(zzuh.zzi.zza zzaVar3) {
                    zzaVar3.zza(this.zzgug);
                }
            });
            final zzuh.zzu zzuVar = (zzuh.zzu) ((zzena) zzuh.zzu.zzpt().zzcq(this.zzdvi.zzeka).zzcr(this.zzdvi.zzekb).zzcs(this.zzdvi.zzekc ? 0 : 2).zzbjv());
            this.zzgud.zza(new zzty(zzuVar) { // from class: com.google.android.gms.internal.ads.zzcsc
                private final zzuh.zzu zzguf;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzguf = zzuVar;
                }

                @Override // com.google.android.gms.internal.ads.zzty
                public final void zza(zzuh.zzi.zza zzaVar3) {
                    zzaVar3.zza(zzaVar3.zzoj().zzbji().zza(this.zzguf));
                }
            });
            this.zzgud.zza(zzub.zza.zzb.OFFLINE_UPLOAD);
        }
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{ak.V});
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
