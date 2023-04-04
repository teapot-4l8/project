package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcmk {
    private String zzgou;
    private zzcmg zzgov;
    private List<Map<String, String>> zzgor = new ArrayList();
    private boolean zzgos = false;
    private boolean zzgot = false;
    private final com.google.android.gms.ads.internal.util.zzf zzeci = com.google.android.gms.ads.internal.zzr.zzkz().zzyl();

    public zzcmk(String str, zzcmg zzcmgVar) {
        this.zzgou = str;
        this.zzgov = zzcmgVar;
    }

    public final synchronized void zzgg(String str) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsg)).booleanValue()) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
                Map<String, String> zzaru = zzaru();
                zzaru.put("action", "adapter_init_started");
                zzaru.put("ancn", str);
                this.zzgor.add(zzaru);
            }
        }
    }

    public final synchronized void zzgh(String str) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsg)).booleanValue()) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
                Map<String, String> zzaru = zzaru();
                zzaru.put("action", "adapter_init_finished");
                zzaru.put("ancn", str);
                this.zzgor.add(zzaru);
            }
        }
    }

    public final synchronized void zzt(String str, String str2) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsg)).booleanValue()) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
                Map<String, String> zzaru = zzaru();
                zzaru.put("action", "adapter_init_finished");
                zzaru.put("ancn", str);
                zzaru.put("rqe", str2);
                this.zzgor.add(zzaru);
            }
        }
    }

    public final synchronized void zzars() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsg)).booleanValue()) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
                if (!this.zzgos) {
                    Map<String, String> zzaru = zzaru();
                    zzaru.put("action", "init_started");
                    this.zzgor.add(zzaru);
                    this.zzgos = true;
                }
            }
        }
    }

    public final synchronized void zzart() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsg)).booleanValue()) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
                if (!this.zzgot) {
                    Map<String, String> zzaru = zzaru();
                    zzaru.put("action", "init_finished");
                    this.zzgor.add(zzaru);
                    for (Map<String, String> map : this.zzgor) {
                        this.zzgov.zzo(map);
                    }
                    this.zzgot = true;
                }
            }
        }
    }

    private final Map<String, String> zzaru() {
        Map<String, String> zzarq = this.zzgov.zzarq();
        zzarq.put("tms", Long.toString(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime(), 10));
        zzarq.put("tid", this.zzeci.zzzn() ? "" : this.zzgou);
        return zzarq;
    }
}
