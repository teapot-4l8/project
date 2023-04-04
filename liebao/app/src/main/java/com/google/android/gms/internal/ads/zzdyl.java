package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
abstract class zzdyl extends zzdxn<String> {
    private int limit;
    private int offset = 0;
    private final zzdxr zzhzb;
    private final boolean zzhzc;
    final CharSequence zzhzg;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdyl(zzdyh zzdyhVar, CharSequence charSequence) {
        zzdxr zzdxrVar;
        int i;
        zzdxrVar = zzdyhVar.zzhzb;
        this.zzhzb = zzdxrVar;
        this.zzhzc = false;
        i = zzdyhVar.limit;
        this.limit = i;
        this.zzhzg = charSequence;
    }

    abstract int zzev(int i);

    abstract int zzew(int i);

    @Override // com.google.android.gms.internal.ads.zzdxn
    protected final /* synthetic */ String zzazz() {
        int i = this.offset;
        while (true) {
            int i2 = this.offset;
            if (i2 != -1) {
                int zzev = zzev(i2);
                if (zzev == -1) {
                    zzev = this.zzhzg.length();
                    this.offset = -1;
                } else {
                    this.offset = zzew(zzev);
                }
                int i3 = this.offset;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    this.offset = i4;
                    if (i4 > this.zzhzg.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i < zzev && this.zzhzb.zzc(this.zzhzg.charAt(i))) {
                        i++;
                    }
                    while (zzev > i && this.zzhzb.zzc(this.zzhzg.charAt(zzev - 1))) {
                        zzev--;
                    }
                    int i5 = this.limit;
                    if (i5 == 1) {
                        zzev = this.zzhzg.length();
                        this.offset = -1;
                        while (zzev > i && this.zzhzb.zzc(this.zzhzg.charAt(zzev - 1))) {
                            zzev--;
                        }
                    } else {
                        this.limit = i5 - 1;
                    }
                    return this.zzhzg.subSequence(i, zzev).toString();
                }
            } else {
                zzbaa();
                return null;
            }
        }
    }
}
