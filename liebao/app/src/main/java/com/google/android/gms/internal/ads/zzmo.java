package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzmo implements zzmh.zza {
    public final String id;

    public zzmo(String str) {
        this.id = (String) zzpg.checkNotNull(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
