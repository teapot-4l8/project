package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzceq implements View.OnClickListener {
    private final Clock zzbqq;
    private final zzchu zzgio;
    private zzagr zzgip;
    private zzaig<Object> zzgiq;
    String zzgir;
    Long zzgis;
    WeakReference<View> zzgit;

    public zzceq(zzchu zzchuVar, Clock clock) {
        this.zzgio = zzchuVar;
        this.zzbqq = clock;
    }

    public final void zza(zzagr zzagrVar) {
        this.zzgip = zzagrVar;
        zzaig<Object> zzaigVar = this.zzgiq;
        if (zzaigVar != null) {
            this.zzgio.zzb("/unconfirmedClick", zzaigVar);
        }
        zzaig<Object> zzaigVar2 = new zzaig(this, zzagrVar) { // from class: com.google.android.gms.internal.ads.zzcet
            private final zzceq zzgiu;
            private final zzagr zzgiv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgiu = this;
                this.zzgiv = zzagrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                zzceq zzceqVar = this.zzgiu;
                zzagr zzagrVar2 = this.zzgiv;
                try {
                    zzceqVar.zzgis = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    com.google.android.gms.ads.internal.util.zzd.zzex("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzceqVar.zzgir = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzagrVar2 == null) {
                    com.google.android.gms.ads.internal.util.zzd.zzdz("Received unconfirmed click but UnconfirmedClickListener is null.");
                    return;
                }
                try {
                    zzagrVar2.onUnconfirmedClickReceived(str);
                } catch (RemoteException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        };
        this.zzgiq = zzaigVar2;
        this.zzgio.zza("/unconfirmedClick", zzaigVar2);
    }

    public final zzagr zzapx() {
        return this.zzgip;
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzgip == null || this.zzgis == null) {
            return;
        }
        zzapy();
        try {
            this.zzgip.onUnconfirmedClickCancelled();
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference<View> weakReference = this.zzgit;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.zzgir != null && this.zzgis != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", this.zzgir);
            hashMap.put("time_interval", String.valueOf(this.zzbqq.currentTimeMillis() - this.zzgis.longValue()));
            hashMap.put("messageType", "onePointFiveClick");
            this.zzgio.zza("sendMessageToNativeJs", hashMap);
        }
        zzapy();
    }

    private final void zzapy() {
        View view;
        this.zzgir = null;
        this.zzgis = null;
        WeakReference<View> weakReference = this.zzgit;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.zzgit = null;
    }
}
