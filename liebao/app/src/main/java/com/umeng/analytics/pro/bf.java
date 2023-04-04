package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldMetaData.java */
/* loaded from: classes2.dex */
public class bf implements Serializable {

    /* renamed from: d  reason: collision with root package name */
    private static Map<Class<? extends at>, Map<? extends ba, bf>> f6423d = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final String f6424a;

    /* renamed from: b  reason: collision with root package name */
    public final byte f6425b;

    /* renamed from: c  reason: collision with root package name */
    public final bg f6426c;

    public bf(String str, byte b2, bg bgVar) {
        this.f6424a = str;
        this.f6425b = b2;
        this.f6426c = bgVar;
    }

    public static void a(Class<? extends at> cls, Map<? extends ba, bf> map) {
        f6423d.put(cls, map);
    }

    public static Map<? extends ba, bf> a(Class<? extends at> cls) {
        if (!f6423d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            } catch (InstantiationException e3) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e3.getMessage());
            }
        }
        return f6423d.get(cls);
    }
}
