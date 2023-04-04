package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdce implements zzdhb<Bundle> {
    private final Context context;
    private final zzvt zzbpy;
    private final List<Parcelable> zzhdf;

    public zzdce(Context context, zzvt zzvtVar, List<Parcelable> list) {
        this.context = context;
        this.zzbpy = zzvtVar;
        this.zzhdf = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdhb
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (zzadp.zzdfk.get().booleanValue()) {
            Bundle bundle3 = new Bundle();
            com.google.android.gms.ads.internal.zzr.zzkv();
            bundle3.putString("activity", com.google.android.gms.ads.internal.util.zzj.zzas(this.context));
            Bundle bundle4 = new Bundle();
            bundle4.putInt("width", this.zzbpy.width);
            bundle4.putInt("height", this.zzbpy.height);
            bundle3.putBundle("size", bundle4);
            if (this.zzhdf.size() > 0) {
                List<Parcelable> list = this.zzhdf;
                bundle3.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle2.putBundle("view_hierarchy", bundle3);
        }
    }
}
