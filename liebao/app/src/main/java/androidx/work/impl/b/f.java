package androidx.work.impl.b;

import android.database.Cursor;

/* compiled from: SystemIdInfoDao_Impl.java */
/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.room.j f2853a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.c f2854b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.n f2855c;

    public f(androidx.room.j jVar) {
        this.f2853a = jVar;
        this.f2854b = new androidx.room.c<d>(jVar) { // from class: androidx.work.impl.b.f.1
            @Override // androidx.room.n
            public String a() {
                return "INSERT OR REPLACE INTO `SystemIdInfo`(`work_spec_id`,`system_id`) VALUES (?,?)";
            }

            @Override // androidx.room.c
            public void a(androidx.e.a.f fVar, d dVar) {
                if (dVar.f2851a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, dVar.f2851a);
                }
                fVar.a(2, dVar.f2852b);
            }
        };
        this.f2855c = new androidx.room.n(jVar) { // from class: androidx.work.impl.b.f.2
            @Override // androidx.room.n
            public String a() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    @Override // androidx.work.impl.b.e
    public void a(d dVar) {
        this.f2853a.f();
        this.f2853a.g();
        try {
            this.f2854b.a((androidx.room.c) dVar);
            this.f2853a.j();
        } finally {
            this.f2853a.h();
        }
    }

    @Override // androidx.work.impl.b.e
    public void b(String str) {
        this.f2853a.f();
        androidx.e.a.f c2 = this.f2855c.c();
        if (str == null) {
            c2.a(1);
        } else {
            c2.a(1, str);
        }
        this.f2853a.g();
        try {
            c2.a();
            this.f2853a.j();
        } finally {
            this.f2853a.h();
            this.f2855c.a(c2);
        }
    }

    @Override // androidx.work.impl.b.e
    public d a(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT * FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f2853a.f();
        Cursor a3 = androidx.room.b.b.a(this.f2853a, a2, false);
        try {
            return a3.moveToFirst() ? new d(a3.getString(androidx.room.b.a.a(a3, "work_spec_id")), a3.getInt(androidx.room.b.a.a(a3, "system_id"))) : null;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
