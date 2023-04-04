package androidx.work.impl.b;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DependencyDao_Impl.java */
/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.room.j f2848a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.c f2849b;

    public c(androidx.room.j jVar) {
        this.f2848a = jVar;
        this.f2849b = new androidx.room.c<a>(jVar) { // from class: androidx.work.impl.b.c.1
            @Override // androidx.room.n
            public String a() {
                return "INSERT OR IGNORE INTO `Dependency`(`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }

            @Override // androidx.room.c
            public void a(androidx.e.a.f fVar, a aVar) {
                if (aVar.f2846a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, aVar.f2846a);
                }
                if (aVar.f2847b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, aVar.f2847b);
                }
            }
        };
    }

    @Override // androidx.work.impl.b.b
    public void a(a aVar) {
        this.f2848a.f();
        this.f2848a.g();
        try {
            this.f2849b.a((androidx.room.c) aVar);
            this.f2848a.j();
        } finally {
            this.f2848a.h();
        }
    }

    @Override // androidx.work.impl.b.b
    public boolean a(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f2848a.f();
        boolean z = false;
        Cursor a3 = androidx.room.b.b.a(this.f2848a, a2, false);
        try {
            if (a3.moveToFirst()) {
                z = a3.getInt(0) != 0;
            }
            return z;
        } finally {
            a3.close();
            a2.a();
        }
    }

    @Override // androidx.work.impl.b.b
    public List<String> b(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f2848a.f();
        Cursor a3 = androidx.room.b.b.a(this.f2848a, a2, false);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(a3.getString(0));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    @Override // androidx.work.impl.b.b
    public boolean c(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f2848a.f();
        boolean z = false;
        Cursor a3 = androidx.room.b.b.a(this.f2848a, a2, false);
        try {
            if (a3.moveToFirst()) {
                z = a3.getInt(0) != 0;
            }
            return z;
        } finally {
            a3.close();
            a2.a();
        }
    }
}
