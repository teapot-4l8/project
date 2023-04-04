package com.bumptech.glide.c.b.a;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: SizeConfigStrategy.java */
/* loaded from: classes.dex */
public class n implements l {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config[] f4706a;

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config[] f4707b;

    /* renamed from: c  reason: collision with root package name */
    private static final Bitmap.Config[] f4708c;

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f4709d;

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f4710e;
    private final b f = new b();
    private final h<a, Bitmap> g = new h<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> h = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f4706a = configArr;
        f4707b = configArr;
        f4708c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f4709d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f4710e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    @Override // com.bumptech.glide.c.b.a.l
    public void a(Bitmap bitmap) {
        a a2 = this.f.a(com.bumptech.glide.i.j.a(bitmap), bitmap.getConfig());
        this.g.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.f4712a));
        a3.put(Integer.valueOf(a2.f4712a), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.c.b.a.l
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        a b2 = b(com.bumptech.glide.i.j.a(i, i2, config), config);
        Bitmap a2 = this.g.a((h<a, Bitmap>) b2);
        if (a2 != null) {
            a(Integer.valueOf(b2.f4712a), a2);
            a2.reconfigure(i, i2, a2.getConfig() != null ? a2.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return a2;
    }

    private a b(int i, Bitmap.Config config) {
        Bitmap.Config[] b2;
        a a2 = this.f.a(i, config);
        for (Bitmap.Config config2 : b(config)) {
            Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return a2;
                        }
                    } else if (config2.equals(config)) {
                        return a2;
                    }
                }
                this.f.a(a2);
                return this.f.a(ceilingKey.intValue(), config2);
            }
        }
        return a2;
    }

    @Override // com.bumptech.glide.c.b.a.l
    public Bitmap a() {
        Bitmap a2 = this.g.a();
        if (a2 != null) {
            a(Integer.valueOf(com.bumptech.glide.i.j.a(a2)), a2);
        }
        return a2;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> a2 = a(bitmap.getConfig());
        Integer num2 = (Integer) a2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            a2.remove(num);
        } else {
            a2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.h.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.h.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // com.bumptech.glide.c.b.a.l
    public String b(Bitmap bitmap) {
        return a(com.bumptech.glide.i.j.a(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.c.b.a.l
    public String b(int i, int i2, Bitmap.Config config) {
        return a(com.bumptech.glide.i.j.a(i, i2, config), config);
    }

    @Override // com.bumptech.glide.c.b.a.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.i.j.a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.g);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.h.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static class b extends d<a> {
        b() {
        }

        public a a(int i, Bitmap.Config config) {
            a c2 = c();
            c2.a(i, config);
            return c2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.c.b.a.d
        /* renamed from: a */
        public a b() {
            return new a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f4712a;

        /* renamed from: b  reason: collision with root package name */
        private final b f4713b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f4714c;

        public a(b bVar) {
            this.f4713b = bVar;
        }

        public void a(int i, Bitmap.Config config) {
            this.f4712a = i;
            this.f4714c = config;
        }

        @Override // com.bumptech.glide.c.b.a.m
        public void a() {
            this.f4713b.a(this);
        }

        public String toString() {
            return n.a(this.f4712a, this.f4714c);
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.f4712a == aVar.f4712a && com.bumptech.glide.i.j.a(this.f4714c, aVar.f4714c);
            }
            return false;
        }

        public int hashCode() {
            int i = this.f4712a * 31;
            Bitmap.Config config = this.f4714c;
            return i + (config != null ? config.hashCode() : 0);
        }
    }

    static String a(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Bitmap.Config[] b(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f4707b;
        }
        int i = AnonymousClass1.f4711a[config.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return i != 4 ? new Bitmap.Config[]{config} : f4710e;
                }
                return f4709d;
            }
            return f4708c;
        }
        return f4706a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* renamed from: com.bumptech.glide.c.b.a.n$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4711a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f4711a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4711a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4711a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4711a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
