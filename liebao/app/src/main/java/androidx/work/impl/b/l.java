package androidx.work.impl.b;

import android.database.Cursor;
import androidx.work.impl.b.j;
import androidx.work.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WorkSpecDao_Impl.java */
/* loaded from: classes.dex */
public final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.room.j f2871a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.c f2872b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.n f2873c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.room.n f2874d;

    /* renamed from: e  reason: collision with root package name */
    private final androidx.room.n f2875e;
    private final androidx.room.n f;
    private final androidx.room.n g;
    private final androidx.room.n h;
    private final androidx.room.n i;
    private final androidx.room.n j;

    public l(androidx.room.j jVar) {
        this.f2871a = jVar;
        this.f2872b = new androidx.room.c<j>(jVar) { // from class: androidx.work.impl.b.l.1
            @Override // androidx.room.n
            public String a() {
                return "INSERT OR IGNORE INTO `WorkSpec`(`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void a(androidx.e.a.f fVar, j jVar2) {
                if (jVar2.f2864a == null) {
                    fVar.a(1);
                } else {
                    fVar.a(1, jVar2.f2864a);
                }
                fVar.a(2, p.a(jVar2.f2865b));
                if (jVar2.f2866c == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, jVar2.f2866c);
                }
                if (jVar2.f2867d == null) {
                    fVar.a(4);
                } else {
                    fVar.a(4, jVar2.f2867d);
                }
                byte[] a2 = androidx.work.e.a(jVar2.f2868e);
                if (a2 == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, a2);
                }
                byte[] a3 = androidx.work.e.a(jVar2.f);
                if (a3 == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, a3);
                }
                fVar.a(7, jVar2.g);
                fVar.a(8, jVar2.h);
                fVar.a(9, jVar2.i);
                fVar.a(10, jVar2.k);
                fVar.a(11, p.a(jVar2.l));
                fVar.a(12, jVar2.m);
                fVar.a(13, jVar2.n);
                fVar.a(14, jVar2.o);
                fVar.a(15, jVar2.p);
                androidx.work.c cVar = jVar2.j;
                if (cVar != null) {
                    fVar.a(16, p.a(cVar.a()));
                    fVar.a(17, cVar.b() ? 1L : 0L);
                    fVar.a(18, cVar.c() ? 1L : 0L);
                    fVar.a(19, cVar.d() ? 1L : 0L);
                    fVar.a(20, cVar.e() ? 1L : 0L);
                    fVar.a(21, cVar.f());
                    fVar.a(22, cVar.g());
                    byte[] a4 = p.a(cVar.h());
                    if (a4 == null) {
                        fVar.a(23);
                        return;
                    } else {
                        fVar.a(23, a4);
                        return;
                    }
                }
                fVar.a(16);
                fVar.a(17);
                fVar.a(18);
                fVar.a(19);
                fVar.a(20);
                fVar.a(21);
                fVar.a(22);
                fVar.a(23);
            }
        };
        this.f2873c = new androidx.room.n(jVar) { // from class: androidx.work.impl.b.l.2
            @Override // androidx.room.n
            public String a() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.f2874d = new androidx.room.n(jVar) { // from class: androidx.work.impl.b.l.3
            @Override // androidx.room.n
            public String a() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.f2875e = new androidx.room.n(jVar) { // from class: androidx.work.impl.b.l.4
            @Override // androidx.room.n
            public String a() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.f = new androidx.room.n(jVar) { // from class: androidx.work.impl.b.l.5
            @Override // androidx.room.n
            public String a() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.g = new androidx.room.n(jVar) { // from class: androidx.work.impl.b.l.6
            @Override // androidx.room.n
            public String a() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.h = new androidx.room.n(jVar) { // from class: androidx.work.impl.b.l.7
            @Override // androidx.room.n
            public String a() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.i = new androidx.room.n(jVar) { // from class: androidx.work.impl.b.l.8
            @Override // androidx.room.n
            public String a() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.j = new androidx.room.n(jVar) { // from class: androidx.work.impl.b.l.9
            @Override // androidx.room.n
            public String a() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    @Override // androidx.work.impl.b.k
    public void a(j jVar) {
        this.f2871a.f();
        this.f2871a.g();
        try {
            this.f2872b.a((androidx.room.c) jVar);
            this.f2871a.j();
        } finally {
            this.f2871a.h();
        }
    }

    @Override // androidx.work.impl.b.k
    public void a(String str) {
        this.f2871a.f();
        androidx.e.a.f c2 = this.f2873c.c();
        if (str == null) {
            c2.a(1);
        } else {
            c2.a(1, str);
        }
        this.f2871a.g();
        try {
            c2.a();
            this.f2871a.j();
        } finally {
            this.f2871a.h();
            this.f2873c.a(c2);
        }
    }

    @Override // androidx.work.impl.b.k
    public void a(String str, androidx.work.e eVar) {
        this.f2871a.f();
        androidx.e.a.f c2 = this.f2874d.c();
        byte[] a2 = androidx.work.e.a(eVar);
        if (a2 == null) {
            c2.a(1);
        } else {
            c2.a(1, a2);
        }
        if (str == null) {
            c2.a(2);
        } else {
            c2.a(2, str);
        }
        this.f2871a.g();
        try {
            c2.a();
            this.f2871a.j();
        } finally {
            this.f2871a.h();
            this.f2874d.a(c2);
        }
    }

    @Override // androidx.work.impl.b.k
    public void a(String str, long j) {
        this.f2871a.f();
        androidx.e.a.f c2 = this.f2875e.c();
        c2.a(1, j);
        if (str == null) {
            c2.a(2);
        } else {
            c2.a(2, str);
        }
        this.f2871a.g();
        try {
            c2.a();
            this.f2871a.j();
        } finally {
            this.f2871a.h();
            this.f2875e.a(c2);
        }
    }

    @Override // androidx.work.impl.b.k
    public int d(String str) {
        this.f2871a.f();
        androidx.e.a.f c2 = this.f.c();
        if (str == null) {
            c2.a(1);
        } else {
            c2.a(1, str);
        }
        this.f2871a.g();
        try {
            int a2 = c2.a();
            this.f2871a.j();
            return a2;
        } finally {
            this.f2871a.h();
            this.f.a(c2);
        }
    }

    @Override // androidx.work.impl.b.k
    public int e(String str) {
        this.f2871a.f();
        androidx.e.a.f c2 = this.g.c();
        if (str == null) {
            c2.a(1);
        } else {
            c2.a(1, str);
        }
        this.f2871a.g();
        try {
            int a2 = c2.a();
            this.f2871a.j();
            return a2;
        } finally {
            this.f2871a.h();
            this.g.a(c2);
        }
    }

    @Override // androidx.work.impl.b.k
    public int b(String str, long j) {
        this.f2871a.f();
        androidx.e.a.f c2 = this.h.c();
        c2.a(1, j);
        if (str == null) {
            c2.a(2);
        } else {
            c2.a(2, str);
        }
        this.f2871a.g();
        try {
            int a2 = c2.a();
            this.f2871a.j();
            return a2;
        } finally {
            this.f2871a.h();
            this.h.a(c2);
        }
    }

    @Override // androidx.work.impl.b.k
    public int b() {
        this.f2871a.f();
        androidx.e.a.f c2 = this.i.c();
        this.f2871a.g();
        try {
            int a2 = c2.a();
            this.f2871a.j();
            return a2;
        } finally {
            this.f2871a.h();
            this.i.a(c2);
        }
    }

    @Override // androidx.work.impl.b.k
    public j b(String str) {
        androidx.room.m mVar;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        j jVar;
        androidx.room.m a16 = androidx.room.m.a("SELECT * FROM workspec WHERE id=?", 1);
        if (str == null) {
            a16.a(1);
        } else {
            a16.a(1, str);
        }
        this.f2871a.f();
        Cursor a17 = androidx.room.b.b.a(this.f2871a, a16, false);
        try {
            a2 = androidx.room.b.a.a(a17, "id");
            a3 = androidx.room.b.a.a(a17, "state");
            a4 = androidx.room.b.a.a(a17, "worker_class_name");
            a5 = androidx.room.b.a.a(a17, "input_merger_class_name");
            a6 = androidx.room.b.a.a(a17, "input");
            a7 = androidx.room.b.a.a(a17, "output");
            a8 = androidx.room.b.a.a(a17, "initial_delay");
            a9 = androidx.room.b.a.a(a17, "interval_duration");
            a10 = androidx.room.b.a.a(a17, "flex_duration");
            a11 = androidx.room.b.a.a(a17, "run_attempt_count");
            a12 = androidx.room.b.a.a(a17, "backoff_policy");
            a13 = androidx.room.b.a.a(a17, "backoff_delay_duration");
            a14 = androidx.room.b.a.a(a17, "period_start_time");
            a15 = androidx.room.b.a.a(a17, "minimum_retention_duration");
            mVar = a16;
        } catch (Throwable th) {
            th = th;
            mVar = a16;
        }
        try {
            int a18 = androidx.room.b.a.a(a17, "schedule_requested_at");
            int a19 = androidx.room.b.a.a(a17, "required_network_type");
            int a20 = androidx.room.b.a.a(a17, "requires_charging");
            int a21 = androidx.room.b.a.a(a17, "requires_device_idle");
            int a22 = androidx.room.b.a.a(a17, "requires_battery_not_low");
            int a23 = androidx.room.b.a.a(a17, "requires_storage_not_low");
            int a24 = androidx.room.b.a.a(a17, "trigger_content_update_delay");
            int a25 = androidx.room.b.a.a(a17, "trigger_max_content_delay");
            int a26 = androidx.room.b.a.a(a17, "content_uri_triggers");
            if (a17.moveToFirst()) {
                String string = a17.getString(a2);
                String string2 = a17.getString(a4);
                androidx.work.c cVar = new androidx.work.c();
                cVar.a(p.c(a17.getInt(a19)));
                cVar.a(a17.getInt(a20) != 0);
                cVar.b(a17.getInt(a21) != 0);
                cVar.c(a17.getInt(a22) != 0);
                cVar.d(a17.getInt(a23) != 0);
                cVar.a(a17.getLong(a24));
                cVar.b(a17.getLong(a25));
                cVar.a(p.a(a17.getBlob(a26)));
                jVar = new j(string, string2);
                jVar.f2865b = p.a(a17.getInt(a3));
                jVar.f2867d = a17.getString(a5);
                jVar.f2868e = androidx.work.e.a(a17.getBlob(a6));
                jVar.f = androidx.work.e.a(a17.getBlob(a7));
                jVar.g = a17.getLong(a8);
                jVar.h = a17.getLong(a9);
                jVar.i = a17.getLong(a10);
                jVar.k = a17.getInt(a11);
                jVar.l = p.b(a17.getInt(a12));
                jVar.m = a17.getLong(a13);
                jVar.n = a17.getLong(a14);
                jVar.o = a17.getLong(a15);
                jVar.p = a17.getLong(a18);
                jVar.j = cVar;
            } else {
                jVar = null;
            }
            a17.close();
            mVar.a();
            return jVar;
        } catch (Throwable th2) {
            th = th2;
            a17.close();
            mVar.a();
            throw th;
        }
    }

    @Override // androidx.work.impl.b.k
    public List<j.a> c(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f2871a.f();
        Cursor a3 = androidx.room.b.b.a(this.f2871a, a2, false);
        try {
            int a4 = androidx.room.b.a.a(a3, "id");
            int a5 = androidx.room.b.a.a(a3, "state");
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                j.a aVar = new j.a();
                aVar.f2869a = a3.getString(a4);
                aVar.f2870b = p.a(a3.getInt(a5));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    @Override // androidx.work.impl.b.k
    public m.a f(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f2871a.f();
        Cursor a3 = androidx.room.b.b.a(this.f2871a, a2, false);
        try {
            return a3.moveToFirst() ? p.a(a3.getInt(0)) : null;
        } finally {
            a3.close();
            a2.a();
        }
    }

    @Override // androidx.work.impl.b.k
    public List<androidx.work.e> g(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f2871a.f();
        Cursor a3 = androidx.room.b.b.a(this.f2871a, a2, false);
        try {
            ArrayList arrayList = new ArrayList(a3.getCount());
            while (a3.moveToNext()) {
                arrayList.add(androidx.work.e.a(a3.getBlob(0)));
            }
            return arrayList;
        } finally {
            a3.close();
            a2.a();
        }
    }

    @Override // androidx.work.impl.b.k
    public List<String> h(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f2871a.f();
        Cursor a3 = androidx.room.b.b.a(this.f2871a, a2, false);
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

    @Override // androidx.work.impl.b.k
    public List<String> i(String str) {
        androidx.room.m a2 = androidx.room.m.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            a2.a(1);
        } else {
            a2.a(1, str);
        }
        this.f2871a.f();
        Cursor a3 = androidx.room.b.b.a(this.f2871a, a2, false);
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

    @Override // androidx.work.impl.b.k
    public List<String> a() {
        androidx.room.m a2 = androidx.room.m.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.f2871a.f();
        Cursor a3 = androidx.room.b.b.a(this.f2871a, a2, false);
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

    @Override // androidx.work.impl.b.k
    public List<j> a(int i) {
        androidx.room.m mVar;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        androidx.room.m a16 = androidx.room.m.a("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        a16.a(1, i);
        this.f2871a.f();
        Cursor a17 = androidx.room.b.b.a(this.f2871a, a16, false);
        try {
            a2 = androidx.room.b.a.a(a17, "id");
            a3 = androidx.room.b.a.a(a17, "state");
            a4 = androidx.room.b.a.a(a17, "worker_class_name");
            a5 = androidx.room.b.a.a(a17, "input_merger_class_name");
            a6 = androidx.room.b.a.a(a17, "input");
            a7 = androidx.room.b.a.a(a17, "output");
            a8 = androidx.room.b.a.a(a17, "initial_delay");
            a9 = androidx.room.b.a.a(a17, "interval_duration");
            a10 = androidx.room.b.a.a(a17, "flex_duration");
            a11 = androidx.room.b.a.a(a17, "run_attempt_count");
            a12 = androidx.room.b.a.a(a17, "backoff_policy");
            a13 = androidx.room.b.a.a(a17, "backoff_delay_duration");
            a14 = androidx.room.b.a.a(a17, "period_start_time");
            a15 = androidx.room.b.a.a(a17, "minimum_retention_duration");
            mVar = a16;
        } catch (Throwable th) {
            th = th;
            mVar = a16;
        }
        try {
            int a18 = androidx.room.b.a.a(a17, "schedule_requested_at");
            int a19 = androidx.room.b.a.a(a17, "required_network_type");
            int i2 = a15;
            int a20 = androidx.room.b.a.a(a17, "requires_charging");
            int i3 = a14;
            int a21 = androidx.room.b.a.a(a17, "requires_device_idle");
            int i4 = a13;
            int a22 = androidx.room.b.a.a(a17, "requires_battery_not_low");
            int i5 = a12;
            int a23 = androidx.room.b.a.a(a17, "requires_storage_not_low");
            int i6 = a11;
            int a24 = androidx.room.b.a.a(a17, "trigger_content_update_delay");
            int i7 = a10;
            int a25 = androidx.room.b.a.a(a17, "trigger_max_content_delay");
            int i8 = a9;
            int a26 = androidx.room.b.a.a(a17, "content_uri_triggers");
            int i9 = a8;
            int i10 = a7;
            ArrayList arrayList = new ArrayList(a17.getCount());
            while (a17.moveToNext()) {
                String string = a17.getString(a2);
                int i11 = a2;
                String string2 = a17.getString(a4);
                int i12 = a4;
                androidx.work.c cVar = new androidx.work.c();
                int i13 = a19;
                cVar.a(p.c(a17.getInt(a19)));
                cVar.a(a17.getInt(a20) != 0);
                cVar.b(a17.getInt(a21) != 0);
                cVar.c(a17.getInt(a22) != 0);
                cVar.d(a17.getInt(a23) != 0);
                int i14 = a22;
                int i15 = a20;
                cVar.a(a17.getLong(a24));
                cVar.b(a17.getLong(a25));
                cVar.a(p.a(a17.getBlob(a26)));
                j jVar = new j(string, string2);
                jVar.f2865b = p.a(a17.getInt(a3));
                jVar.f2867d = a17.getString(a5);
                jVar.f2868e = androidx.work.e.a(a17.getBlob(a6));
                int i16 = i10;
                jVar.f = androidx.work.e.a(a17.getBlob(i16));
                i10 = i16;
                int i17 = i9;
                jVar.g = a17.getLong(i17);
                int i18 = a21;
                i9 = i17;
                int i19 = i8;
                jVar.h = a17.getLong(i19);
                i8 = i19;
                int i20 = i7;
                jVar.i = a17.getLong(i20);
                int i21 = i6;
                jVar.k = a17.getInt(i21);
                int i22 = i5;
                i6 = i21;
                jVar.l = p.b(a17.getInt(i22));
                i7 = i20;
                int i23 = i4;
                jVar.m = a17.getLong(i23);
                i5 = i22;
                int i24 = i3;
                jVar.n = a17.getLong(i24);
                i3 = i24;
                int i25 = i2;
                jVar.o = a17.getLong(i25);
                i2 = i25;
                int i26 = a18;
                jVar.p = a17.getLong(i26);
                jVar.j = cVar;
                arrayList.add(jVar);
                a18 = i26;
                a20 = i15;
                a21 = i18;
                a4 = i12;
                a22 = i14;
                a19 = i13;
                i4 = i23;
                a2 = i11;
            }
            a17.close();
            mVar.a();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            a17.close();
            mVar.a();
            throw th;
        }
    }

    @Override // androidx.work.impl.b.k
    public List<j> c() {
        androidx.room.m mVar;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        androidx.room.m a16 = androidx.room.m.a("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f2871a.f();
        Cursor a17 = androidx.room.b.b.a(this.f2871a, a16, false);
        try {
            a2 = androidx.room.b.a.a(a17, "id");
            a3 = androidx.room.b.a.a(a17, "state");
            a4 = androidx.room.b.a.a(a17, "worker_class_name");
            a5 = androidx.room.b.a.a(a17, "input_merger_class_name");
            a6 = androidx.room.b.a.a(a17, "input");
            a7 = androidx.room.b.a.a(a17, "output");
            a8 = androidx.room.b.a.a(a17, "initial_delay");
            a9 = androidx.room.b.a.a(a17, "interval_duration");
            a10 = androidx.room.b.a.a(a17, "flex_duration");
            a11 = androidx.room.b.a.a(a17, "run_attempt_count");
            a12 = androidx.room.b.a.a(a17, "backoff_policy");
            a13 = androidx.room.b.a.a(a17, "backoff_delay_duration");
            a14 = androidx.room.b.a.a(a17, "period_start_time");
            a15 = androidx.room.b.a.a(a17, "minimum_retention_duration");
            mVar = a16;
        } catch (Throwable th) {
            th = th;
            mVar = a16;
        }
        try {
            int a18 = androidx.room.b.a.a(a17, "schedule_requested_at");
            int a19 = androidx.room.b.a.a(a17, "required_network_type");
            int i = a15;
            int a20 = androidx.room.b.a.a(a17, "requires_charging");
            int i2 = a14;
            int a21 = androidx.room.b.a.a(a17, "requires_device_idle");
            int i3 = a13;
            int a22 = androidx.room.b.a.a(a17, "requires_battery_not_low");
            int i4 = a12;
            int a23 = androidx.room.b.a.a(a17, "requires_storage_not_low");
            int i5 = a11;
            int a24 = androidx.room.b.a.a(a17, "trigger_content_update_delay");
            int i6 = a10;
            int a25 = androidx.room.b.a.a(a17, "trigger_max_content_delay");
            int i7 = a9;
            int a26 = androidx.room.b.a.a(a17, "content_uri_triggers");
            int i8 = a8;
            int i9 = a7;
            ArrayList arrayList = new ArrayList(a17.getCount());
            while (a17.moveToNext()) {
                String string = a17.getString(a2);
                int i10 = a2;
                String string2 = a17.getString(a4);
                int i11 = a4;
                androidx.work.c cVar = new androidx.work.c();
                int i12 = a19;
                cVar.a(p.c(a17.getInt(a19)));
                cVar.a(a17.getInt(a20) != 0);
                cVar.b(a17.getInt(a21) != 0);
                cVar.c(a17.getInt(a22) != 0);
                cVar.d(a17.getInt(a23) != 0);
                int i13 = a21;
                int i14 = a20;
                cVar.a(a17.getLong(a24));
                cVar.b(a17.getLong(a25));
                cVar.a(p.a(a17.getBlob(a26)));
                j jVar = new j(string, string2);
                jVar.f2865b = p.a(a17.getInt(a3));
                jVar.f2867d = a17.getString(a5);
                jVar.f2868e = androidx.work.e.a(a17.getBlob(a6));
                int i15 = i9;
                jVar.f = androidx.work.e.a(a17.getBlob(i15));
                i9 = i15;
                int i16 = i8;
                jVar.g = a17.getLong(i16);
                i8 = i16;
                int i17 = a3;
                int i18 = i7;
                jVar.h = a17.getLong(i18);
                i7 = i18;
                int i19 = i6;
                jVar.i = a17.getLong(i19);
                int i20 = i5;
                jVar.k = a17.getInt(i20);
                int i21 = i4;
                i5 = i20;
                jVar.l = p.b(a17.getInt(i21));
                i6 = i19;
                int i22 = i3;
                jVar.m = a17.getLong(i22);
                i4 = i21;
                int i23 = i2;
                jVar.n = a17.getLong(i23);
                i2 = i23;
                int i24 = i;
                jVar.o = a17.getLong(i24);
                i = i24;
                int i25 = a18;
                jVar.p = a17.getLong(i25);
                jVar.j = cVar;
                arrayList.add(jVar);
                a18 = i25;
                a20 = i14;
                a2 = i10;
                a4 = i11;
                a21 = i13;
                a19 = i12;
                i3 = i22;
                a3 = i17;
            }
            a17.close();
            mVar.a();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            a17.close();
            mVar.a();
            throw th;
        }
    }

    @Override // androidx.work.impl.b.k
    public List<j> d() {
        androidx.room.m mVar;
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        androidx.room.m a16 = androidx.room.m.a("SELECT * FROM workspec WHERE state=1", 0);
        this.f2871a.f();
        Cursor a17 = androidx.room.b.b.a(this.f2871a, a16, false);
        try {
            a2 = androidx.room.b.a.a(a17, "id");
            a3 = androidx.room.b.a.a(a17, "state");
            a4 = androidx.room.b.a.a(a17, "worker_class_name");
            a5 = androidx.room.b.a.a(a17, "input_merger_class_name");
            a6 = androidx.room.b.a.a(a17, "input");
            a7 = androidx.room.b.a.a(a17, "output");
            a8 = androidx.room.b.a.a(a17, "initial_delay");
            a9 = androidx.room.b.a.a(a17, "interval_duration");
            a10 = androidx.room.b.a.a(a17, "flex_duration");
            a11 = androidx.room.b.a.a(a17, "run_attempt_count");
            a12 = androidx.room.b.a.a(a17, "backoff_policy");
            a13 = androidx.room.b.a.a(a17, "backoff_delay_duration");
            a14 = androidx.room.b.a.a(a17, "period_start_time");
            a15 = androidx.room.b.a.a(a17, "minimum_retention_duration");
            mVar = a16;
        } catch (Throwable th) {
            th = th;
            mVar = a16;
        }
        try {
            int a18 = androidx.room.b.a.a(a17, "schedule_requested_at");
            int a19 = androidx.room.b.a.a(a17, "required_network_type");
            int i = a15;
            int a20 = androidx.room.b.a.a(a17, "requires_charging");
            int i2 = a14;
            int a21 = androidx.room.b.a.a(a17, "requires_device_idle");
            int i3 = a13;
            int a22 = androidx.room.b.a.a(a17, "requires_battery_not_low");
            int i4 = a12;
            int a23 = androidx.room.b.a.a(a17, "requires_storage_not_low");
            int i5 = a11;
            int a24 = androidx.room.b.a.a(a17, "trigger_content_update_delay");
            int i6 = a10;
            int a25 = androidx.room.b.a.a(a17, "trigger_max_content_delay");
            int i7 = a9;
            int a26 = androidx.room.b.a.a(a17, "content_uri_triggers");
            int i8 = a8;
            int i9 = a7;
            ArrayList arrayList = new ArrayList(a17.getCount());
            while (a17.moveToNext()) {
                String string = a17.getString(a2);
                int i10 = a2;
                String string2 = a17.getString(a4);
                int i11 = a4;
                androidx.work.c cVar = new androidx.work.c();
                int i12 = a19;
                cVar.a(p.c(a17.getInt(a19)));
                cVar.a(a17.getInt(a20) != 0);
                cVar.b(a17.getInt(a21) != 0);
                cVar.c(a17.getInt(a22) != 0);
                cVar.d(a17.getInt(a23) != 0);
                int i13 = a21;
                int i14 = a20;
                cVar.a(a17.getLong(a24));
                cVar.b(a17.getLong(a25));
                cVar.a(p.a(a17.getBlob(a26)));
                j jVar = new j(string, string2);
                jVar.f2865b = p.a(a17.getInt(a3));
                jVar.f2867d = a17.getString(a5);
                jVar.f2868e = androidx.work.e.a(a17.getBlob(a6));
                int i15 = i9;
                jVar.f = androidx.work.e.a(a17.getBlob(i15));
                i9 = i15;
                int i16 = i8;
                jVar.g = a17.getLong(i16);
                i8 = i16;
                int i17 = a3;
                int i18 = i7;
                jVar.h = a17.getLong(i18);
                i7 = i18;
                int i19 = i6;
                jVar.i = a17.getLong(i19);
                int i20 = i5;
                jVar.k = a17.getInt(i20);
                int i21 = i4;
                i5 = i20;
                jVar.l = p.b(a17.getInt(i21));
                i6 = i19;
                int i22 = i3;
                jVar.m = a17.getLong(i22);
                i4 = i21;
                int i23 = i2;
                jVar.n = a17.getLong(i23);
                i2 = i23;
                int i24 = i;
                jVar.o = a17.getLong(i24);
                i = i24;
                int i25 = a18;
                jVar.p = a17.getLong(i25);
                jVar.j = cVar;
                arrayList.add(jVar);
                a18 = i25;
                a20 = i14;
                a2 = i10;
                a4 = i11;
                a21 = i13;
                a19 = i12;
                i3 = i22;
                a3 = i17;
            }
            a17.close();
            mVar.a();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            a17.close();
            mVar.a();
            throw th;
        }
    }

    @Override // androidx.work.impl.b.k
    public int a(m.a aVar, String... strArr) {
        this.f2871a.f();
        StringBuilder a2 = androidx.room.b.c.a();
        a2.append("UPDATE workspec SET state=");
        a2.append("?");
        a2.append(" WHERE id IN (");
        androidx.room.b.c.a(a2, strArr.length);
        a2.append(")");
        androidx.e.a.f a3 = this.f2871a.a(a2.toString());
        a3.a(1, p.a(aVar));
        int i = 2;
        for (String str : strArr) {
            if (str == null) {
                a3.a(i);
            } else {
                a3.a(i, str);
            }
            i++;
        }
        this.f2871a.g();
        try {
            int a4 = a3.a();
            this.f2871a.j();
            return a4;
        } finally {
            this.f2871a.h();
        }
    }
}
