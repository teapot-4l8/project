package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzoy extends zzov {
    private final int responseCode;
    private final Map<String, List<String>> zzbjr;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzoy(int i, Map<String, List<String>> map, zzos zzosVar) {
        super(r0.toString(), zzosVar, 1);
        StringBuilder sb = new StringBuilder(26);
        sb.append("Response code: ");
        sb.append(i);
        this.responseCode = i;
        this.zzbjr = map;
    }
}
