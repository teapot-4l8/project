package a.a.a.d;

import java.util.ArrayList;
import java.util.List;

/* compiled from: SetResponse.java */
/* loaded from: classes.dex */
public class cm {

    /* renamed from: a  reason: collision with root package name */
    private static final cm f231a = new cm(0);

    /* renamed from: b  reason: collision with root package name */
    private static final cm f232b = new cm(1);

    /* renamed from: c  reason: collision with root package name */
    private static final cm f233c = new cm(2);

    /* renamed from: d  reason: collision with root package name */
    private int f234d;

    /* renamed from: e  reason: collision with root package name */
    private List<bu<?>> f235e;

    private cm() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(int i, bu<?> buVar) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.f234d = i;
        ArrayList arrayList = new ArrayList();
        this.f235e = arrayList;
        arrayList.add(buVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(int i) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.f234d = i;
        this.f235e = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cm a(int i) {
        switch (i) {
            case 0:
                return f231a;
            case 1:
                return f232b;
            case 2:
                return f233c;
            case 3:
            case 4:
            case 5:
            case 6:
                cm cmVar = new cm();
                cmVar.f234d = i;
                cmVar.f235e = null;
                return cmVar;
            default:
                throw new IllegalArgumentException("invalid type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(bu<?> buVar) {
        if (this.f235e == null) {
            this.f235e = new ArrayList();
        }
        this.f235e.add(buVar);
    }

    public boolean a() {
        return this.f234d == 1;
    }

    public boolean b() {
        return this.f234d == 2;
    }

    public boolean c() {
        return this.f234d == 3;
    }

    public boolean d() {
        return this.f234d == 4;
    }

    public boolean e() {
        return this.f234d == 5;
    }

    public boolean f() {
        return this.f234d == 6;
    }

    public List<bu<?>> g() {
        if (this.f234d != 6) {
            return null;
        }
        return this.f235e;
    }

    public k h() {
        return (k) this.f235e.get(0).g();
    }

    public s i() {
        return (s) this.f235e.get(0).g();
    }

    public String toString() {
        switch (this.f234d) {
            case 0:
                return "unknown";
            case 1:
                return "NXDOMAIN";
            case 2:
                return "NXRRSET";
            case 3:
                return "delegation: " + this.f235e.get(0);
            case 4:
                return "CNAME: " + this.f235e.get(0);
            case 5:
                return "DNAME: " + this.f235e.get(0);
            case 6:
                return "successful";
            default:
                throw new IllegalStateException();
        }
    }
}
