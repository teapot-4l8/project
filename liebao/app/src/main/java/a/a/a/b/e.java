package a.a.a.b;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class e implements a.a.a.b.a {

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, List<d>> f22c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Map<String, String> f23d;

    e(Map<String, List<d>> map) {
        this.f22c = Collections.unmodifiableMap(map);
    }

    @Override // a.a.a.b.a
    public Map<String, String> a() {
        if (this.f23d == null) {
            synchronized (this) {
                if (this.f23d == null) {
                    this.f23d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f23d;
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<d>> entry : this.f22c.entrySet()) {
            String a2 = a(entry.getValue());
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put(entry.getKey(), a2);
            }
        }
        return hashMap;
    }

    private String a(List<d> list) {
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
        return "LazyHeaders{headers=" + this.f22c + '}';
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f22c.equals(((e) obj).f22c);
        }
        return false;
    }

    public int hashCode() {
        return this.f22c.hashCode();
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final String f24a = b();

        /* renamed from: b  reason: collision with root package name */
        private static final Map<String, List<d>> f25b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f26c = true;

        /* renamed from: d  reason: collision with root package name */
        private Map<String, List<d>> f27d = f25b;

        /* renamed from: e  reason: collision with root package name */
        private boolean f28e = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f24a)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(f24a)));
            }
            f25b = Collections.unmodifiableMap(hashMap);
        }

        public e a() {
            this.f26c = true;
            return new e(this.f27d);
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
    static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        private final String f29a;

        b(String str) {
            this.f29a = str;
        }

        @Override // a.a.a.b.d
        public String a() {
            return this.f29a;
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f29a + "'}";
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f29a.equals(((b) obj).f29a);
            }
            return false;
        }

        public int hashCode() {
            return this.f29a.hashCode();
        }
    }
}
