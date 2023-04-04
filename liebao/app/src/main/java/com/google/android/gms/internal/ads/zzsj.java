package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzsj implements Comparator<zzrx> {
    public zzsj(zzsg zzsgVar) {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzrx zzrxVar, zzrx zzrxVar2) {
        zzrx zzrxVar3 = zzrxVar;
        zzrx zzrxVar4 = zzrxVar2;
        if (zzrxVar3.zzmv() < zzrxVar4.zzmv()) {
            return -1;
        }
        if (zzrxVar3.zzmv() > zzrxVar4.zzmv()) {
            return 1;
        }
        if (zzrxVar3.zzmu() < zzrxVar4.zzmu()) {
            return -1;
        }
        if (zzrxVar3.zzmu() > zzrxVar4.zzmu()) {
            return 1;
        }
        float zzmx = (zzrxVar3.zzmx() - zzrxVar3.zzmv()) * (zzrxVar3.zzmw() - zzrxVar3.zzmu());
        float zzmx2 = (zzrxVar4.zzmx() - zzrxVar4.zzmv()) * (zzrxVar4.zzmw() - zzrxVar4.zzmu());
        if (zzmx > zzmx2) {
            return -1;
        }
        return zzmx < zzmx2 ? 1 : 0;
    }
}
