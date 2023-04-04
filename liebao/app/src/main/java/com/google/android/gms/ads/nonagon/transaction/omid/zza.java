package com.google.android.gms.ads.nonagon.transaction.omid;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zza {
    static final /* synthetic */ int[] zzhoj;

    static {
        int[] iArr = new int[OmidMediaType.values().length];
        zzhoj = iArr;
        try {
            iArr[OmidMediaType.DISPLAY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zzhoj[OmidMediaType.VIDEO.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            zzhoj[OmidMediaType.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
