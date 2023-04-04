package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcev {
    private final zzcdz zzgfo;
    private final zzchu zzgio;
    private final zzcja zzgix;
    private final zzblv zzgiy;

    public zzcev(zzcja zzcjaVar, zzchu zzchuVar, zzblv zzblvVar, zzcdz zzcdzVar) {
        this.zzgix = zzcjaVar;
        this.zzgio = zzchuVar;
        this.zzgiy = zzblvVar;
        this.zzgfo = zzcdzVar;
    }

    public final View zzapz() {
        zzbfi zza = this.zzgix.zza(zzvt.zzqk(), null, null);
        zza.getView().setVisibility(8);
        zza.zza("/sendMessageToSdk", new zzaig(this) { // from class: com.google.android.gms.internal.ads.zzceu
            private final zzcev zzgiw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgiw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                this.zzgiw.zzd((zzbfi) obj, map);
            }
        });
        zza.zza("/adMuted", new zzaig(this) { // from class: com.google.android.gms.internal.ads.zzcex
            private final zzcev zzgiw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgiw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                this.zzgiw.zzc((zzbfi) obj, map);
            }
        });
        this.zzgio.zza(new WeakReference(zza), "/loadHtml", new zzaig(this) { // from class: com.google.android.gms.internal.ads.zzcew
            private final zzcev zzgiw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgiw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, final Map map) {
                final zzcev zzcevVar = this.zzgiw;
                zzbfi zzbfiVar = (zzbfi) obj;
                zzbfiVar.zzaef().zza(new zzbgt(zzcevVar, map) { // from class: com.google.android.gms.internal.ads.zzcfb
                    private final Map zzeds;
                    private final zzcev zzgiw;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgiw = zzcevVar;
                        this.zzeds = map;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbgt
                    public final void zzam(boolean z) {
                        this.zzgiw.zza(this.zzeds, z);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzbfiVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzbfiVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        });
        this.zzgio.zza(new WeakReference(zza), "/showOverlay", new zzaig(this) { // from class: com.google.android.gms.internal.ads.zzcez
            private final zzcev zzgiw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgiw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                this.zzgiw.zzb((zzbfi) obj, map);
            }
        });
        this.zzgio.zza(new WeakReference(zza), "/hideOverlay", new zzaig(this) { // from class: com.google.android.gms.internal.ads.zzcey
            private final zzcev zzgiw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgiw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                this.zzgiw.zza((zzbfi) obj, map);
            }
        });
        return zza.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbfi zzbfiVar, Map map) {
        com.google.android.gms.ads.internal.util.zzd.zzey("Hiding native ads overlay.");
        zzbfiVar.getView().setVisibility(8);
        this.zzgiy.zzbi(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbfi zzbfiVar, Map map) {
        com.google.android.gms.ads.internal.util.zzd.zzey("Showing native ads overlay.");
        zzbfiVar.getView().setVisibility(0);
        this.zzgiy.zzbi(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzgio.zza("sendMessageToNativeJs", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbfi zzbfiVar, Map map) {
        this.zzgfo.zzaoe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzbfi zzbfiVar, Map map) {
        this.zzgio.zza("sendMessageToNativeJs", map);
    }
}
