package androidx.work.impl.b;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WorkTagDao_Impl.java */
/* loaded from: classes.dex */
public final class o implements n {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.room.j f2887a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.c f2888b;

    public o(androidx.room.j jVar) {
        this.f2887a = jVar;
        this.f2888b = new androidx.room.c<m>(jVar) { // from class: androidx.work.impl.b.o.1
            @Override // androidx.room.n
            public String a() {
                return "INSERT OR IGNORE INTO `WorkTag`(`tag`,`work_spec_id`) VALUES (?,?)";
            }

            @Override // androidx.room.c
            public void a(androidx.e.a.f fVar, m mVar) {
                if (mVar.f2885a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, mVar.f2885a);
                }
                if (mVar.f2886b == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, mVar.f2886b);
                }
            }
        };
    }

    @Override // androidx.work.impl.b.n
    public void a(m mVar) {
        this.f2887a.f();
        this.f2887a.g();
        try {
            this.f2888b.a((androidx.room.c) mVar);
            this.f2887a.j();
        } finally {
            this.f2887a.h();
        }
    }

    @Override // androidx.work.impl.b.n
    public List<String> a(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f2887a.f();
        Cursor a3 = androidx.room.b.b.a(this.f2887a, a2, false);
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
}
