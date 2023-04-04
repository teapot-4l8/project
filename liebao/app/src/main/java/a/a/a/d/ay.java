package a.a.a.d;

import java.util.HashMap;

/* compiled from: Mnemonic.java */
/* loaded from: classes.dex */
class ay {

    /* renamed from: c  reason: collision with root package name */
    private String f154c;

    /* renamed from: d  reason: collision with root package name */
    private int f155d;

    /* renamed from: e  reason: collision with root package name */
    private String f156e;
    private boolean g;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Integer> f152a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, String> f153b = new HashMap<>();
    private int f = Integer.MAX_VALUE;

    public ay(String str, int i) {
        this.f154c = str;
        this.f155d = i;
    }

    public void b(int i) {
        this.f = i;
    }

    public void a(String str) {
        this.f156e = b(str);
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void a(int i) {
        if (i < 0 || i > this.f) {
            throw new IllegalArgumentException(this.f154c + " " + i + "is out of range");
        }
    }

    private String b(String str) {
        int i = this.f155d;
        if (i == 2) {
            return str.toUpperCase();
        }
        return i == 3 ? str.toLowerCase() : str;
    }

    public void a(int i, String str) {
        a(i);
        String b2 = b(str);
        this.f152a.put(b2, Integer.valueOf(i));
        this.f153b.put(Integer.valueOf(i), b2);
    }

    public void b(int i, String str) {
        a(i);
        this.f152a.put(b(str), Integer.valueOf(i));
    }

    public void a(ay ayVar) {
        if (this.f155d != ayVar.f155d) {
            throw new IllegalArgumentException(ayVar.f154c + ": wordcases do not match");
        }
        this.f152a.putAll(ayVar.f152a);
        this.f153b.putAll(ayVar.f153b);
    }

    public String c(int i) {
        a(i);
        String str = this.f153b.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i);
        if (this.f156e != null) {
            return this.f156e + num;
        }
        return num;
    }
}
