package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzepd implements zzeol {
    private final int flags;
    private final String info;
    private final Object[] zzivv;
    private final zzeon zzivy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzepd(zzeon zzeonVar, String str, Object[] objArr) {
        this.zzivy = zzeonVar;
        this.info = str;
        this.zzivv = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.flags = i | (charAt2 << i2);
                return;
            }
            i |= (charAt2 & 8191) << i2;
            i2 += 13;
            i3 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzblf() {
        return this.info;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zzblg() {
        return this.zzivv;
    }

    @Override // com.google.android.gms.internal.ads.zzeol
    public final zzeon zzbkz() {
        return this.zzivy;
    }

    @Override // com.google.android.gms.internal.ads.zzeol
    public final int zzbkx() {
        return (this.flags & 1) == 1 ? zzeoy.zziwn : zzeoy.zziwo;
    }

    @Override // com.google.android.gms.internal.ads.zzeol
    public final boolean zzbky() {
        return (this.flags & 2) == 2;
    }
}
