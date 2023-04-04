package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcsh extends SQLiteOpenHelper {
    private final Context context;
    private final zzebs zzgta;

    public zzcsh(Context context, zzebs zzebsVar) {
        super(context, "AdMobOfflineBufferedPings.db", (SQLiteDatabase.CursorFactory) null, ((Integer) zzww.zzra().zzd(zzabq.zzdbd)).intValue());
        this.context = context;
        this.zzgta = zzebsVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE offline_buffered_pings (timestamp INTEGER PRIMARY_KEY, gws_query_id TEXT, url TEXT, event_state INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS offline_buffered_pings");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    private final void zza(zzdsr<SQLiteDatabase, Void> zzdsrVar) {
        zzebh.zza(this.zzgta.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcsg
            private final zzcsh zzguk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguk = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzguk.getWritableDatabase();
            }
        }), new zzcsm(this, zzdsrVar), this.zzgta);
    }

    public static void zza(SQLiteDatabase sQLiteDatabase, zzbas zzbasVar) {
        sQLiteDatabase.beginTransaction();
        try {
            String[] strArr = {ImagesContract.URL};
            StringBuilder sb = new StringBuilder(25);
            sb.append("event_state = 1");
            Cursor query = sQLiteDatabase.query("offline_buffered_pings", strArr, sb.toString(), null, null, null, "timestamp ASC", null);
            int count = query.getCount();
            String[] strArr2 = new String[count];
            int i = 0;
            while (query.moveToNext()) {
                int columnIndex = query.getColumnIndex(ImagesContract.URL);
                if (columnIndex != -1) {
                    strArr2[i] = query.getString(columnIndex);
                }
                i++;
            }
            query.close();
            sQLiteDatabase.delete("offline_buffered_pings", "event_state = ?", new String[]{Integer.toString(1)});
            sQLiteDatabase.setTransactionSuccessful();
            for (int i2 = 0; i2 < count; i2++) {
                zzbasVar.zzen(strArr2[i2]);
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public final void zza(zzbas zzbasVar) {
        zza(new zzdsr(zzbasVar) { // from class: com.google.android.gms.internal.ads.zzcsj
            private final zzbas zzdvd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdvd = zzbasVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdsr
            public final Object apply(Object obj) {
                return zzcsh.zza(this.zzdvd, (SQLiteDatabase) obj);
            }
        });
    }

    public final void zza(SQLiteDatabase sQLiteDatabase, zzbas zzbasVar, String str) {
        this.zzgta.execute(new Runnable(sQLiteDatabase, str, zzbasVar) { // from class: com.google.android.gms.internal.ads.zzcsi
            private final String zzdkl;
            private final SQLiteDatabase zzgul;
            private final zzbas zzgum;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgul = sQLiteDatabase;
                this.zzdkl = str;
                this.zzgum = zzbasVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzcsh.zza(this.zzgul, this.zzdkl, this.zzgum);
            }
        });
    }

    public final void zzb(zzbas zzbasVar, String str) {
        zza(new zzdsr(this, zzbasVar, str) { // from class: com.google.android.gms.internal.ads.zzcsl
            private final String zzdmx;
            private final zzcsh zzguk;
            private final zzbas zzgun;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguk = this;
                this.zzgun = zzbasVar;
                this.zzdmx = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdsr
            public final Object apply(Object obj) {
                return this.zzguk.zza(this.zzgun, this.zzdmx, (SQLiteDatabase) obj);
            }
        });
    }

    public static void zza(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.delete("offline_buffered_pings", "gws_query_id = ? AND event_state = ?", new String[]{str, Integer.toString(0)});
    }

    public final void zzgn(String str) {
        zza(new zzdsr(this, str) { // from class: com.google.android.gms.internal.ads.zzcsk
            private final String zzdkl;
            private final zzcsh zzguk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguk = this;
                this.zzdkl = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdsr
            public final Object apply(Object obj) {
                zzcsh.zza((SQLiteDatabase) obj, this.zzdkl);
                return null;
            }
        });
    }

    public final void zza(zzcso zzcsoVar) {
        zza(new zzdsr(this, zzcsoVar) { // from class: com.google.android.gms.internal.ads.zzcsn
            private final zzcsh zzguk;
            private final zzcso zzguo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguk = this;
                this.zzguo = zzcsoVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdsr
            public final Object apply(Object obj) {
                return this.zzguk.zza(this.zzguo, (SQLiteDatabase) obj);
            }
        });
    }

    public final /* synthetic */ Void zza(zzcso zzcsoVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzcsoVar.timestamp));
        contentValues.put("gws_query_id", zzcsoVar.zzbwe);
        contentValues.put(ImagesContract.URL, zzcsoVar.url);
        contentValues.put("event_state", Integer.valueOf(zzcsoVar.zzgup - 1));
        sQLiteDatabase.insert("offline_buffered_pings", null, contentValues);
        com.google.android.gms.ads.internal.zzr.zzkv();
        com.google.android.gms.ads.internal.util.zzbg zzbg = com.google.android.gms.ads.internal.util.zzj.zzbg(this.context);
        if (zzbg != null) {
            try {
                zzbg.zzaq(ObjectWrapper.wrap(this.context));
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.zzd.zza("Failed to schedule offline ping sender.", e2);
            }
        }
        return null;
    }

    public final /* synthetic */ Void zza(zzbas zzbasVar, String str, SQLiteDatabase sQLiteDatabase) {
        zza(sQLiteDatabase, zzbasVar, str);
        return null;
    }

    public static final /* synthetic */ void zza(SQLiteDatabase sQLiteDatabase, String str, zzbas zzbasVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_state", (Integer) 1);
        sQLiteDatabase.update("offline_buffered_pings", contentValues, "gws_query_id = ?", new String[]{str});
        zza(sQLiteDatabase, zzbasVar);
    }

    public static final /* synthetic */ Void zza(zzbas zzbasVar, SQLiteDatabase sQLiteDatabase) {
        zza(sQLiteDatabase, zzbasVar);
        return null;
    }
}
