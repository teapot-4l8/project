package com.bumptech.glide.c.c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<i>> f4924c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f4925d;

    j(Map<String, List<i>> map) {
        this.f4924c = Collections.unmodifiableMap(map);
    }

    @Override // com.bumptech.glide.c.c.h
    public Map<String, String> a() {
        if (this.f4925d == null) {
            synchronized (this) {
                if (this.f4925d == null) {
                    this.f4925d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f4925d;
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f4924c.entrySet()) {
            String a2 = a(entry.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(entry.getKey(), a2);
            }
        }
        return hashMap;
    }

    private String a(List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String a2 = list.get(i).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f4924c + '}';
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f4924c.equals(((j) obj).f4924c);
        }
        return false;
    }

    public int hashCode() {
        return this.f4924c.hashCode();
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final String f4926a = b();

        /* renamed from: b  reason: collision with root package name */
        private static final Map<String, List<i>> f4927b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f4928c = true;

        /* renamed from: d  reason: collision with root package name */
        private Map<String, List<i>> f4929d = f4927b;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4930e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f4926a)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(f4926a)));
            }
            f4927b = Collections.unmodifiableMap(hashMap);
        }

        public j a() {
            this.f4928c = true;
            return new j(this.f4929d);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    static final class b implements i {

        /* renamed from: a  reason: collision with root package name */
        private final String f4931a;

        b(String str) {
            this.f4931a = str;
        }

        @Override // com.bumptech.glide.c.c.i
        public String a() {
            return this.f4931a;
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f4931a + "'}";
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f4931a.equals(((b) obj).f4931a);
            }
            return false;
        }

        public int hashCode() {
            return this.f4931a.hashCode();
        }
    }
}
