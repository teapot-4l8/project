package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbxe extends zzbxq<AppEventListener> implements zzahp {
    public zzbxe(Set<zzbzl<AppEventListener>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final synchronized void onAppEvent(String str, String str2) {
        zza(new zzbxs(str, str2) { // from class: com.google.android.gms.internal.ads.zzbxd
            private final String zzdkl;
            private final String zzdmo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = str;
                this.zzdkl = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((AppEventListener) obj).onAppEvent(this.zzdmo, this.zzdkl);
            }
        });
    }
}
