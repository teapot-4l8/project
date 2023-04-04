package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgp;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzve;
import com.umeng.analytics.pro.ak;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaio<T extends zzve & zzbex & zzbfi & zzakr & zzbgd & zzbgk & zzbgo & zzbgp & zzbgr> implements zzaig<T> {
    private final com.google.android.gms.ads.internal.zza zzdjd;
    private final zzcmb zzdje;
    private final zzdtw zzdjf;
    private final zzaqz zzdjh;
    private final zzcsh zzdji;
    private com.google.android.gms.ads.internal.overlay.zzv zzdjj = null;
    private final zzbas zzdjg = new zzbas();

    public zzaio(com.google.android.gms.ads.internal.zza zzaVar, zzaqz zzaqzVar, zzcsh zzcshVar, zzcmb zzcmbVar, zzdtw zzdtwVar) {
        this.zzdjd = zzaVar;
        this.zzdjh = zzaqzVar;
        this.zzdji = zzcshVar;
        this.zzdje = zzcmbVar;
        this.zzdjf = zzdtwVar;
    }

    private final boolean zza(T t, Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzr.zzkv();
        boolean zzbd = com.google.android.gms.ads.internal.util.zzj.zzbd(context);
        com.google.android.gms.ads.internal.zzr.zzkv();
        com.google.android.gms.ads.internal.util.zzbg zzbg = com.google.android.gms.ads.internal.util.zzj.zzbg(context);
        zzcmb zzcmbVar = this.zzdje;
        if (zzcmbVar != null) {
            zzcsr.zza(context, zzcmbVar, this.zzdjf, this.zzdji, str2, "offline_open");
        }
        T t2 = t;
        boolean z = t2.zzaed().zzafj() && t2.zzabx() == null;
        if (zzbd) {
            this.zzdji.zzb(this.zzdjg, str2);
            return false;
        }
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (com.google.android.gms.ads.internal.util.zzj.zzbf(context) && zzbg != null && !z) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdbe)).booleanValue()) {
                if (t2.zzaed().zzafj()) {
                    zzcsr.zza(t2.zzabx(), null, zzbg, this.zzdji, this.zzdje, this.zzdjf, str2, str);
                } else {
                    t.zza(zzbg, this.zzdji, this.zzdje, this.zzdjf, str2, str, com.google.android.gms.ads.internal.zzr.zzkx().zzzv());
                }
                zzcmb zzcmbVar2 = this.zzdje;
                if (zzcmbVar2 != null) {
                    zzcsr.zza(context, zzcmbVar2, this.zzdjf, this.zzdji, str2, "dialog_impression");
                }
                t.onAdClicked();
                return true;
            }
        }
        this.zzdji.zzgn(str2);
        if (this.zzdje != null) {
            HashMap hashMap = new HashMap();
            com.google.android.gms.ads.internal.zzr.zzkv();
            if (!com.google.android.gms.ads.internal.util.zzj.zzbf(context)) {
                hashMap.put("dialog_not_shown_reason", "notifications_disabled");
            } else if (zzbg == null) {
                hashMap.put("dialog_not_shown_reason", "work_manager_unavailable");
            } else {
                if (!((Boolean) zzww.zzra().zzd(zzabq.zzdbe)).booleanValue()) {
                    hashMap.put("dialog_not_shown_reason", "notification_flow_disabled");
                } else if (z) {
                    hashMap.put("dialog_not_shown_reason", "fullscreen_no_activity");
                }
            }
            zzcsr.zza(context, this.zzdje, this.zzdjf, this.zzdji, str2, "dialog_not_shown", hashMap);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzacs zzacsVar) {
        if (this.zzdje == null) {
            return;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            this.zzdjf.zzb(zzdtx.zzgy("cct_action").zzw("cct_open_status", zzacsVar.toString()));
        } else {
            this.zzdje.zzarp().zzs("action", "cct_action").zzs("cct_open_status", zzacsVar.toString()).zzarm();
        }
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = map.get("o");
        if (str != null) {
            if (ak.ax.equalsIgnoreCase(str)) {
                return 7;
            }
            if ("l".equalsIgnoreCase(str)) {
                return 6;
            }
            if (ak.aF.equalsIgnoreCase(str)) {
                return com.google.android.gms.ads.internal.zzr.zzkx().zzzv();
            }
            return -1;
        }
        return -1;
    }

    private final void zzae(boolean z) {
        zzaqz zzaqzVar = this.zzdjh;
        if (zzaqzVar != null) {
            zzaqzVar.zzag(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri zza(Context context, zzei zzeiVar, Uri uri, View view, Activity activity) {
        if (zzeiVar == null) {
            return uri;
        }
        try {
            return zzeiVar.zzc(uri) ? zzeiVar.zza(uri, context, view, activity) : uri;
        } catch (zzeh unused) {
            return uri;
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e2) {
            String valueOf = String.valueOf(uri.toString());
            com.google.android.gms.ads.internal.util.zzd.zzc(valueOf.length() != 0 ? "Error adding click uptime parameter to url: ".concat(valueOf) : new String("Error adding click uptime parameter to url: "), e2);
        }
        return uri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzaig
    public final /* synthetic */ void zza(Object obj, Map map) {
        String str;
        boolean z;
        zzve zzveVar = (zzve) obj;
        zzbfi zzbfiVar = (zzbfi) zzveVar;
        String zzc = zzayv.zzc((String) map.get(ak.aG), zzbfiVar.getContext(), true);
        String str2 = (String) map.get(ak.av);
        if (str2 == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zza zzaVar = this.zzdjd;
        if (zzaVar != null && !zzaVar.zzkc()) {
            this.zzdjd.zzbk(zzc);
            return;
        }
        zzdot zzadk = zzbfiVar.zzadk();
        zzdoy zzaev = zzbfiVar.zzaev();
        if (zzadk == null || zzaev == null) {
            str = "";
            z = false;
        } else {
            boolean z2 = zzadk.zzhmz;
            str = zzaev.zzbwe;
            z = z2;
        }
        if ("expand".equalsIgnoreCase(str2)) {
            if (zzbfiVar.zzaek()) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Cannot expand WebView that is already expanded.");
                return;
            }
            zzae(false);
            ((zzbgo) zzveVar).zzb(zzc(map), zzd(map));
        } else if ("webapp".equalsIgnoreCase(str2)) {
            zzae(false);
            if (zzc != null) {
                ((zzbgo) zzveVar).zza(zzc(map), zzd(map), zzc);
            } else {
                ((zzbgo) zzveVar).zza(zzc(map), zzd(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else {
            if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcvm)).booleanValue()) {
                    zzae(true);
                    if (TextUtils.isEmpty(zzc)) {
                        com.google.android.gms.ads.internal.util.zzd.zzez("Cannot open browser with null or empty url");
                        zza(zzacs.EMPTY_URL);
                        return;
                    }
                    Uri zze = zze(zza(zzbfiVar.getContext(), zzbfiVar.zzaei(), Uri.parse(zzc), zzbfiVar.getView(), zzbfiVar.zzabx()));
                    if (z && this.zzdji != null && zza(zzveVar, zzbfiVar.getContext(), zze.toString(), str)) {
                        return;
                    }
                    this.zzdjj = new zzair(this);
                    ((zzbgo) zzveVar).zza(new com.google.android.gms.ads.internal.overlay.zzb(zze.toString(), this.zzdjj, true));
                    return;
                }
            }
            if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
                zzae(true);
                Intent zze2 = new zzait(zzbfiVar.getContext(), zzbfiVar.zzaei(), zzbfiVar.getView()).zze(map);
                if (!z || this.zzdji == null || zze2 == null || !zza(zzveVar, zzbfiVar.getContext(), zze2.getData().toString(), str)) {
                    try {
                        ((zzbgo) zzveVar).zza(new com.google.android.gms.ads.internal.overlay.zzb(zze2, this.zzdjj));
                    } catch (ActivityNotFoundException e2) {
                        com.google.android.gms.ads.internal.util.zzd.zzez(e2.getMessage());
                    }
                }
            } else if ("open_app".equalsIgnoreCase(str2)) {
                if (((Boolean) zzww.zzra().zzd(zzabq.zzdaw)).booleanValue()) {
                    zzae(true);
                    String str3 = (String) map.get(ak.ax);
                    if (str3 == null) {
                        com.google.android.gms.ads.internal.util.zzd.zzez("Package name missing from open app action.");
                    } else if (z && this.zzdji != null && zza(zzveVar, zzbfiVar.getContext(), str3, str)) {
                    } else {
                        PackageManager packageManager = zzbfiVar.getContext().getPackageManager();
                        if (packageManager == null) {
                            com.google.android.gms.ads.internal.util.zzd.zzez("Cannot get package manager from open app action.");
                            return;
                        }
                        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str3);
                        if (launchIntentForPackage != null) {
                            ((zzbgo) zzveVar).zza(new com.google.android.gms.ads.internal.overlay.zzb(launchIntentForPackage, this.zzdjj));
                        }
                    }
                }
            } else {
                zzae(true);
                String str4 = (String) map.get("intent_url");
                Intent intent = null;
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        intent = Intent.parseUri(str4, 0);
                    } catch (URISyntaxException e3) {
                        String valueOf = String.valueOf(str4);
                        com.google.android.gms.ads.internal.util.zzd.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e3);
                    }
                }
                if (intent != null && intent.getData() != null) {
                    Uri data = intent.getData();
                    if (!Uri.EMPTY.equals(data)) {
                        Uri zze3 = zze(zza(zzbfiVar.getContext(), zzbfiVar.zzaei(), data, zzbfiVar.getView(), zzbfiVar.zzabx()));
                        if (!TextUtils.isEmpty(intent.getType())) {
                            if (((Boolean) zzww.zzra().zzd(zzabq.zzdax)).booleanValue()) {
                                intent.setDataAndType(zze3, intent.getType());
                            }
                        }
                        intent.setData(zze3);
                    }
                }
                boolean z3 = ((Boolean) zzww.zzra().zzd(zzabq.zzdbh)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map.containsKey("event_id");
                HashMap hashMap = new HashMap();
                if (z3) {
                    this.zzdjj = new zzaiq(this, hashMap, map, zzveVar);
                }
                if (intent != null) {
                    if (!z || this.zzdji == null || !zza(zzveVar, zzbfiVar.getContext(), intent.getData().toString(), str)) {
                        ((zzbgo) zzveVar).zza(new com.google.android.gms.ads.internal.overlay.zzb(intent, this.zzdjj));
                        return;
                    } else if (z3) {
                        hashMap.put((String) map.get("event_id"), true);
                        ((zzakr) zzveVar).zza("openIntentAsync", hashMap);
                        return;
                    } else {
                        return;
                    }
                }
                if (!TextUtils.isEmpty(zzc)) {
                    zzc = zze(zza(zzbfiVar.getContext(), zzbfiVar.zzaei(), Uri.parse(zzc), zzbfiVar.getView(), zzbfiVar.zzabx())).toString();
                }
                if (!z || this.zzdji == null || !zza(zzveVar, zzbfiVar.getContext(), zzc, str)) {
                    ((zzbgo) zzveVar).zza(new com.google.android.gms.ads.internal.overlay.zzb((String) map.get(ak.aC), zzc, (String) map.get("m"), (String) map.get(ak.ax), (String) map.get(ak.aF), (String) map.get("f"), (String) map.get("e"), this.zzdjj));
                } else if (z3) {
                    hashMap.put((String) map.get("event_id"), true);
                    ((zzakr) zzveVar).zza("openIntentAsync", hashMap);
                }
            }
        }
    }
}
