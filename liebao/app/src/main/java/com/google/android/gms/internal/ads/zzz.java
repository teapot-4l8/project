package com.google.android.gms.internal.ads;

import androidx.recyclerview.widget.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzz {
    public final List<zzv> allHeaders;
    public final byte[] data;
    public final int statusCode;
    public final Map<String, String> zzaj;
    public final boolean zzak;
    private final long zzal;

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzz(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, r0, z, j);
        List arrayList;
        if (map == null) {
            arrayList = null;
        } else if (map.isEmpty()) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new zzv(entry.getKey(), entry.getValue()));
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzz(int i, byte[] bArr, boolean z, long j, List<zzv> list) {
        this(i, bArr, r0, list, z, j);
        Map treeMap;
        if (list == null) {
            treeMap = null;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzv zzvVar : list) {
                treeMap.put(zzvVar.getName(), zzvVar.getValue());
            }
        }
    }

    @Deprecated
    public zzz(byte[] bArr, Map<String, String> map) {
        this((int) l.a.DEFAULT_DRAG_ANIMATION_DURATION, bArr, map, false, 0L);
    }

    private zzz(int i, byte[] bArr, Map<String, String> map, List<zzv> list, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.zzaj = map;
        if (list == null) {
            this.allHeaders = null;
        } else {
            this.allHeaders = Collections.unmodifiableList(list);
        }
        this.zzak = z;
        this.zzal = j;
    }
}
