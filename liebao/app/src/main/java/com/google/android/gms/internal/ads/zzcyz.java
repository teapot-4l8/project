package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcyz {
    private final zzckb zzgph;
    private final ConcurrentHashMap<String, zzaqa> zzhad = new ConcurrentHashMap<>();

    public zzcyz(zzckb zzckbVar) {
        this.zzgph = zzckbVar;
    }

    public final void zzgo(String str) {
        try {
            this.zzhad.put(str, this.zzgph.zzdi(str));
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Couldn't create RTB adapter : ", e2);
        }
    }

    @CheckForNull
    public final zzaqa zzgp(String str) {
        if (this.zzhad.containsKey(str)) {
            return this.zzhad.get(str);
        }
        return null;
    }
}
