package com.sunfusheng.marqueeview;

import android.content.Context;
import java.util.List;

/* compiled from: Utils.java */
/* loaded from: classes2.dex */
public class b {
    public static <T> boolean a(List<T> list) {
        return list == null || list.size() == 0;
    }

    public static int a(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
