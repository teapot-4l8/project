package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import androidx.core.app.i;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcsr extends zzarx {
    private final Context context;
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzbas zzdjg;
    private final zzcsh zzdji;

    public zzcsr(Context context, zzcsh zzcshVar, zzbas zzbasVar, zzcmb zzcmbVar, zzdtw zzdtwVar) {
        this.context = context;
        this.zzdje = zzcmbVar;
        this.zzdjg = zzbasVar;
        this.zzdji = zzcshVar;
        this.zzdjf = zzdtwVar;
    }

    public static void zza(final Activity activity, final com.google.android.gms.ads.internal.overlay.zze zzeVar, final com.google.android.gms.ads.internal.util.zzbg zzbgVar, final zzcsh zzcshVar, final zzcmb zzcmbVar, final zzdtw zzdtwVar, final String str, final String str2) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        AlertDialog.Builder zzc = com.google.android.gms.ads.internal.util.zzj.zzc(activity, com.google.android.gms.ads.internal.zzr.zzkx().zzzy());
        final Resources resources = com.google.android.gms.ads.internal.zzr.zzkz().getResources();
        zzc.setTitle(resources == null ? "Open ad when you're back online." : resources.getString(R.string.offline_opt_in_title)).setMessage(resources == null ? "We'll send you a notification with a link to the advertiser site." : resources.getString(R.string.offline_opt_in_message)).setPositiveButton(resources == null ? "OK" : resources.getString(R.string.offline_opt_in_confirm), new DialogInterface.OnClickListener(zzcmbVar, activity, zzdtwVar, zzcshVar, str, zzbgVar, str2, resources, zzeVar) { // from class: com.google.android.gms.internal.ads.zzcsq
            private final Activity zzehb;
            private final String zzetx;
            private final zzcmb zzguq;
            private final zzdtw zzgur;
            private final zzcsh zzgus;
            private final com.google.android.gms.ads.internal.util.zzbg zzgut;
            private final String zzguu;
            private final Resources zzguv;
            private final com.google.android.gms.ads.internal.overlay.zze zzguw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguq = zzcmbVar;
                this.zzehb = activity;
                this.zzgur = zzdtwVar;
                this.zzgus = zzcshVar;
                this.zzetx = str;
                this.zzgut = zzbgVar;
                this.zzguu = str2;
                this.zzguv = resources;
                this.zzguw = zzeVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                com.google.android.gms.ads.internal.overlay.zze zzeVar2;
                zzcmb zzcmbVar2 = this.zzguq;
                Activity activity2 = this.zzehb;
                zzdtw zzdtwVar2 = this.zzgur;
                zzcsh zzcshVar2 = this.zzgus;
                String str3 = this.zzetx;
                com.google.android.gms.ads.internal.util.zzbg zzbgVar2 = this.zzgut;
                String str4 = this.zzguu;
                Resources resources2 = this.zzguv;
                com.google.android.gms.ads.internal.overlay.zze zzeVar3 = this.zzguw;
                if (zzcmbVar2 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("dialog_action", "confirm");
                    zzeVar2 = zzeVar3;
                    zzcsr.zza(activity2, zzcmbVar2, zzdtwVar2, zzcshVar2, str3, "dialog_click", hashMap);
                } else {
                    zzeVar2 = zzeVar3;
                }
                boolean z = false;
                try {
                    z = zzbgVar2.zzd(ObjectWrapper.wrap(activity2), str4, str3);
                } catch (RemoteException e2) {
                    com.google.android.gms.ads.internal.util.zzd.zzc("Failed to schedule offline notification poster.", e2);
                }
                if (!z) {
                    zzcshVar2.zzgn(str3);
                    if (zzcmbVar2 != null) {
                        zzcsr.zza(activity2, zzcmbVar2, zzdtwVar2, zzcshVar2, str3, "offline_notification_worker_not_scheduled");
                    }
                }
                com.google.android.gms.ads.internal.zzr.zzkv();
                AlertDialog.Builder zzc2 = com.google.android.gms.ads.internal.util.zzj.zzc(activity2, com.google.android.gms.ads.internal.zzr.zzkx().zzzy());
                zzc2.setMessage(resources2 == null ? "You'll get a notification with the link when you're back online" : resources2.getString(R.string.offline_opt_in_confirmation)).setOnCancelListener(new DialogInterface.OnCancelListener(zzeVar2) { // from class: com.google.android.gms.internal.ads.zzcsv
                    private final com.google.android.gms.ads.internal.overlay.zze zzdsz;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdsz = zzeVar2;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface2) {
                        com.google.android.gms.ads.internal.overlay.zze zzeVar4 = this.zzdsz;
                        if (zzeVar4 != null) {
                            zzeVar4.close();
                        }
                    }
                });
                AlertDialog create = zzc2.create();
                create.show();
                Timer timer = new Timer();
                timer.schedule(new zzcsu(create, timer, zzeVar2), 3000L);
            }
        }).setNegativeButton(resources == null ? "No thanks" : resources.getString(R.string.offline_opt_in_decline), new DialogInterface.OnClickListener(zzcshVar, str, zzcmbVar, activity, zzdtwVar, zzeVar) { // from class: com.google.android.gms.internal.ads.zzcst
            private final String zzdkl;
            private final zzcsh zzguk;
            private final zzcmb zzgux;
            private final Activity zzguy;
            private final zzdtw zzguz;
            private final com.google.android.gms.ads.internal.overlay.zze zzgva;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguk = zzcshVar;
                this.zzdkl = str;
                this.zzgux = zzcmbVar;
                this.zzguy = activity;
                this.zzguz = zzdtwVar;
                this.zzgva = zzeVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                zzcsh zzcshVar2 = this.zzguk;
                String str3 = this.zzdkl;
                zzcmb zzcmbVar2 = this.zzgux;
                Activity activity2 = this.zzguy;
                zzdtw zzdtwVar2 = this.zzguz;
                com.google.android.gms.ads.internal.overlay.zze zzeVar2 = this.zzgva;
                zzcshVar2.zzgn(str3);
                if (zzcmbVar2 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("dialog_action", "dismiss");
                    zzcsr.zza(activity2, zzcmbVar2, zzdtwVar2, zzcshVar2, str3, "dialog_click", hashMap);
                }
                if (zzeVar2 != null) {
                    zzeVar2.close();
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener(zzcshVar, str, zzcmbVar, activity, zzdtwVar, zzeVar) { // from class: com.google.android.gms.internal.ads.zzcss
            private final String zzdkl;
            private final zzcsh zzguk;
            private final zzcmb zzgux;
            private final Activity zzguy;
            private final zzdtw zzguz;
            private final com.google.android.gms.ads.internal.overlay.zze zzgva;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzguk = zzcshVar;
                this.zzdkl = str;
                this.zzgux = zzcmbVar;
                this.zzguy = activity;
                this.zzguz = zzdtwVar;
                this.zzgva = zzeVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                zzcsh zzcshVar2 = this.zzguk;
                String str3 = this.zzdkl;
                zzcmb zzcmbVar2 = this.zzgux;
                Activity activity2 = this.zzguy;
                zzdtw zzdtwVar2 = this.zzguz;
                com.google.android.gms.ads.internal.overlay.zze zzeVar2 = this.zzgva;
                zzcshVar2.zzgn(str3);
                if (zzcmbVar2 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("dialog_action", "dismiss");
                    zzcsr.zza(activity2, zzcmbVar2, zzdtwVar2, zzcshVar2, str3, "dialog_click", hashMap);
                }
                if (zzeVar2 != null) {
                    zzeVar2.close();
                }
            }
        });
        zzc.create().show();
    }

    public static void zza(Context context, zzcmb zzcmbVar, zzdtw zzdtwVar, zzcsh zzcshVar, String str, String str2) {
        zza(context, zzcmbVar, zzdtwVar, zzcshVar, str, str2, new HashMap());
    }

    public static void zza(Context context, zzcmb zzcmbVar, zzdtw zzdtwVar, zzcsh zzcshVar, String str, String str2, Map<String, String> map) {
        String zzarn;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            zzdtx zzw = zzdtx.zzgy(str2).zzw("gqi", str);
            com.google.android.gms.ads.internal.zzr.zzkv();
            zzdtx zzw2 = zzw.zzw("device_connectivity", com.google.android.gms.ads.internal.util.zzj.zzbd(context) ? "online" : "offline").zzw("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis()));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                zzw2.zzw(entry.getKey(), entry.getValue());
            }
            zzarn = zzdtwVar.zzc(zzw2);
        } else {
            zzcma zzarp = zzcmbVar.zzarp();
            zzarp.zzs("gqi", str);
            zzarp.zzs("action", str2);
            com.google.android.gms.ads.internal.zzr.zzkv();
            zzarp.zzs("device_connectivity", com.google.android.gms.ads.internal.util.zzj.zzbd(context) ? "online" : "offline");
            zzarp.zzs("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis()));
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                zzarp.zzs(entry2.getKey(), entry2.getValue());
            }
            zzarn = zzarp.zzarn();
        }
        zzcshVar.zza(new zzcso(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis(), str, zzarn, zzcse.zzgui));
    }

    private final void zza(String str, String str2, Map<String, String> map) {
        zza(this.context, this.zzdje, this.zzdjf, this.zzdji, str, str2, map);
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final void zzc(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            com.google.android.gms.ads.internal.zzr.zzkv();
            boolean zzbd = com.google.android.gms.ads.internal.util.zzj.zzbd(this.context);
            int i = zzcsx.zzgvg;
            HashMap hashMap = new HashMap();
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (zzbd) {
                    i = zzcsx.zzgvf;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                try {
                    Context context = this.context;
                    Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zza(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zzdji.getWritableDatabase();
                if (i == zzcsx.zzgvf) {
                    this.zzdji.zza(writableDatabase, this.zzdjg, stringExtra2);
                } else {
                    zzcsh.zza(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51);
                sb.append("Failed to get writable offline buffering database: ");
                sb.append(valueOf);
                com.google.android.gms.ads.internal.util.zzd.zzex(sb.toString());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final void zzc(IObjectWrapper iObjectWrapper, String str, String str2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        com.google.android.gms.ads.internal.zzr.zzkv();
        com.google.android.gms.ads.internal.util.zzj.zzbe(context);
        int i = PlatformVersion.isAtLeastM() ? 1140850688 : 1073741824;
        Intent intent = new Intent();
        intent.setClass(context, AdService.class);
        intent.setAction("offline_notification_clicked");
        intent.putExtra("offline_notification_action", "offline_notification_clicked");
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str);
        PendingIntent service = zzdxk.getService(context, 0, intent, i);
        Intent intent2 = new Intent();
        intent2.setClass(context, AdService.class);
        intent2.setAction("offline_notification_dismissed");
        intent2.putExtra("offline_notification_action", "offline_notification_dismissed");
        intent2.putExtra("gws_query_id", str2);
        PendingIntent service2 = zzdxk.getService(context, 0, intent2, i);
        Resources resources = com.google.android.gms.ads.internal.zzr.zzkz().getResources();
        ((NotificationManager) context.getSystemService("notification")).notify(str2, 54321, new i.c(context, "offline_notification_channel").a((CharSequence) (resources == null ? "View the ad you saved when you were offline" : resources.getString(R.string.offline_notification_title))).b(resources == null ? "Tap to open ad" : resources.getString(R.string.offline_notification_text)).b(true).b(service2).a(service).a(context.getApplicationInfo().icon).b());
        zza(str2, "offline_notification_impression", new HashMap());
    }

    @Override // com.google.android.gms.internal.ads.zzaru
    public final void zzwe() {
        this.zzdji.zza(this.zzdjg);
    }
}
