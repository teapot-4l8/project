package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzov extends IOException {
    private final int type;
    private final zzos zzbji;

    public zzov(String str, zzos zzosVar, int i) {
        super(str);
        this.zzbji = zzosVar;
        this.type = 1;
    }

    public zzov(IOException iOException, zzos zzosVar, int i) {
        super(iOException);
        this.zzbji = zzosVar;
        this.type = i;
    }

    public zzov(String str, IOException iOException, zzos zzosVar, int i) {
        super(str, iOException);
        this.zzbji = zzosVar;
        this.type = 1;
    }
}
