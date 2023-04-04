package leavesc.hello.monitor.db;

import android.database.Cursor;
import androidx.e.a.f;
import androidx.lifecycle.LiveData;
import androidx.room.c;
import androidx.room.g;
import androidx.room.j;
import androidx.room.m;
import androidx.room.n;
import com.google.android.gms.common.internal.ImagesContract;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: MonitorHttpInformationDao_Impl.java */
/* loaded from: classes2.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f7253a;

    /* renamed from: b  reason: collision with root package name */
    private final c f7254b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.b f7255c;

    /* renamed from: d  reason: collision with root package name */
    private final n f7256d;

    public b(j jVar) {
        this.f7253a = jVar;
        this.f7254b = new c<leavesc.hello.monitor.db.a.b>(jVar) { // from class: leavesc.hello.monitor.db.b.1
            @Override // androidx.room.n
            public String a() {
                return "INSERT OR ABORT INTO `monitor_httpInformation`(`id`,`requestDate`,`responseDate`,`duration`,`method`,`url`,`host`,`path`,`scheme`,`protocol`,`requestHeaders`,`requestBody`,`requestContentType`,`requestContentLength`,`requestBodyIsPlainText`,`responseCode`,`responseHeaders`,`responseBody`,`responseMessage`,`responseContentType`,`responseContentLength`,`responseBodyIsPlainText`,`error`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void a(f fVar, leavesc.hello.monitor.db.a.b bVar) {
                fVar.a(1, bVar.i());
                Long a2 = leavesc.hello.monitor.b.a.a(bVar.j());
                if (a2 == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, a2.longValue());
                }
                Long a3 = leavesc.hello.monitor.b.a.a(bVar.k());
                if (a3 == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, a3.longValue());
                }
                fVar.a(4, bVar.l());
                if (bVar.m() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, bVar.m());
                }
                if (bVar.n() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, bVar.n());
                }
                if (bVar.o() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, bVar.o());
                }
                if (bVar.p() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, bVar.p());
                }
                if (bVar.q() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, bVar.q());
                }
                if (bVar.r() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, bVar.r());
                }
                if (bVar.s() == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, bVar.s());
                }
                if (bVar.t() == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, bVar.t());
                }
                if (bVar.u() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, bVar.u());
                }
                fVar.a(14, bVar.v());
                fVar.a(15, bVar.w() ? 1L : 0L);
                fVar.a(16, bVar.x());
                if (bVar.y() == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, bVar.y());
                }
                if (bVar.z() == null) {
                    fVar.a(18);
                } else {
                    fVar.a(18, bVar.z());
                }
                if (bVar.A() == null) {
                    fVar.a(19);
                } else {
                    fVar.a(19, bVar.A());
                }
                if (bVar.B() == null) {
                    fVar.a(20);
                } else {
                    fVar.a(20, bVar.B());
                }
                fVar.a(21, bVar.C());
                fVar.a(22, bVar.D() ? 1L : 0L);
                if (bVar.E() == null) {
                    fVar.a(23);
                } else {
                    fVar.a(23, bVar.E());
                }
            }
        };
        this.f7255c = new androidx.room.b<leavesc.hello.monitor.db.a.b>(jVar) { // from class: leavesc.hello.monitor.db.b.2
            @Override // androidx.room.b, androidx.room.n
            public String a() {
                return "UPDATE OR ABORT `monitor_httpInformation` SET `id` = ?,`requestDate` = ?,`responseDate` = ?,`duration` = ?,`method` = ?,`url` = ?,`host` = ?,`path` = ?,`scheme` = ?,`protocol` = ?,`requestHeaders` = ?,`requestBody` = ?,`requestContentType` = ?,`requestContentLength` = ?,`requestBodyIsPlainText` = ?,`responseCode` = ?,`responseHeaders` = ?,`responseBody` = ?,`responseMessage` = ?,`responseContentType` = ?,`responseContentLength` = ?,`responseBodyIsPlainText` = ?,`error` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void a(f fVar, leavesc.hello.monitor.db.a.b bVar) {
                fVar.a(1, bVar.i());
                Long a2 = leavesc.hello.monitor.b.a.a(bVar.j());
                if (a2 == null) {
                    fVar.a(2);
                } else {
                    fVar.a(2, a2.longValue());
                }
                Long a3 = leavesc.hello.monitor.b.a.a(bVar.k());
                if (a3 == null) {
                    fVar.a(3);
                } else {
                    fVar.a(3, a3.longValue());
                }
                fVar.a(4, bVar.l());
                if (bVar.m() == null) {
                    fVar.a(5);
                } else {
                    fVar.a(5, bVar.m());
                }
                if (bVar.n() == null) {
                    fVar.a(6);
                } else {
                    fVar.a(6, bVar.n());
                }
                if (bVar.o() == null) {
                    fVar.a(7);
                } else {
                    fVar.a(7, bVar.o());
                }
                if (bVar.p() == null) {
                    fVar.a(8);
                } else {
                    fVar.a(8, bVar.p());
                }
                if (bVar.q() == null) {
                    fVar.a(9);
                } else {
                    fVar.a(9, bVar.q());
                }
                if (bVar.r() == null) {
                    fVar.a(10);
                } else {
                    fVar.a(10, bVar.r());
                }
                if (bVar.s() == null) {
                    fVar.a(11);
                } else {
                    fVar.a(11, bVar.s());
                }
                if (bVar.t() == null) {
                    fVar.a(12);
                } else {
                    fVar.a(12, bVar.t());
                }
                if (bVar.u() == null) {
                    fVar.a(13);
                } else {
                    fVar.a(13, bVar.u());
                }
                fVar.a(14, bVar.v());
                fVar.a(15, bVar.w() ? 1L : 0L);
                fVar.a(16, bVar.x());
                if (bVar.y() == null) {
                    fVar.a(17);
                } else {
                    fVar.a(17, bVar.y());
                }
                if (bVar.z() == null) {
                    fVar.a(18);
                } else {
                    fVar.a(18, bVar.z());
                }
                if (bVar.A() == null) {
                    fVar.a(19);
                } else {
                    fVar.a(19, bVar.A());
                }
                if (bVar.B() == null) {
                    fVar.a(20);
                } else {
                    fVar.a(20, bVar.B());
                }
                fVar.a(21, bVar.C());
                fVar.a(22, bVar.D() ? 1L : 0L);
                if (bVar.E() == null) {
                    fVar.a(23);
                } else {
                    fVar.a(23, bVar.E());
                }
                fVar.a(24, bVar.i());
            }
        };
        this.f7256d = new n(jVar) { // from class: leavesc.hello.monitor.db.b.3
            @Override // androidx.room.n
            public String a() {
                return "DELETE FROM monitor_httpInformation";
            }
        };
    }

    @Override // leavesc.hello.monitor.db.a
    public long a(leavesc.hello.monitor.db.a.b bVar) {
        this.f7253a.g();
        try {
            long b2 = this.f7254b.b(bVar);
            this.f7253a.j();
            return b2;
        } finally {
            this.f7253a.h();
        }
    }

    @Override // leavesc.hello.monitor.db.a
    public void b(leavesc.hello.monitor.db.a.b bVar) {
        this.f7253a.g();
        try {
            this.f7255c.a((androidx.room.b) bVar);
            this.f7253a.j();
        } finally {
            this.f7253a.h();
        }
    }

    @Override // leavesc.hello.monitor.db.a
    public void a() {
        f c2 = this.f7256d.c();
        this.f7253a.g();
        try {
            c2.a();
            this.f7253a.j();
        } finally {
            this.f7253a.h();
            this.f7256d.a(c2);
        }
    }

    @Override // leavesc.hello.monitor.db.a
    public LiveData<leavesc.hello.monitor.db.a.b> a(long j) {
        final m a2 = m.a("SELECT * FROM monitor_httpInformation WHERE id =?", 1);
        a2.a(1, j);
        return new androidx.lifecycle.c<leavesc.hello.monitor.db.a.b>(this.f7253a.i()) { // from class: leavesc.hello.monitor.db.b.4
            private g.b i;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.lifecycle.c
            /* renamed from: d */
            public leavesc.hello.monitor.db.a.b c() {
                if (this.i == null) {
                    this.i = new g.b("monitor_httpInformation", new String[0]) { // from class: leavesc.hello.monitor.db.b.4.1
                        @Override // androidx.room.g.b
                        public void a(Set<String> set) {
                            b();
                        }
                    };
                    b.this.f7253a.k().b(this.i);
                }
                Cursor a3 = b.this.f7253a.a(a2);
                try {
                    int columnIndexOrThrow = a3.getColumnIndexOrThrow("id");
                    int columnIndexOrThrow2 = a3.getColumnIndexOrThrow("requestDate");
                    int columnIndexOrThrow3 = a3.getColumnIndexOrThrow("responseDate");
                    int columnIndexOrThrow4 = a3.getColumnIndexOrThrow("duration");
                    int columnIndexOrThrow5 = a3.getColumnIndexOrThrow("method");
                    int columnIndexOrThrow6 = a3.getColumnIndexOrThrow(ImagesContract.URL);
                    int columnIndexOrThrow7 = a3.getColumnIndexOrThrow("host");
                    int columnIndexOrThrow8 = a3.getColumnIndexOrThrow("path");
                    int columnIndexOrThrow9 = a3.getColumnIndexOrThrow("scheme");
                    int columnIndexOrThrow10 = a3.getColumnIndexOrThrow("protocol");
                    int columnIndexOrThrow11 = a3.getColumnIndexOrThrow("requestHeaders");
                    int columnIndexOrThrow12 = a3.getColumnIndexOrThrow("requestBody");
                    int columnIndexOrThrow13 = a3.getColumnIndexOrThrow("requestContentType");
                    int columnIndexOrThrow14 = a3.getColumnIndexOrThrow("requestContentLength");
                    int columnIndexOrThrow15 = a3.getColumnIndexOrThrow("requestBodyIsPlainText");
                    int columnIndexOrThrow16 = a3.getColumnIndexOrThrow("responseCode");
                    int columnIndexOrThrow17 = a3.getColumnIndexOrThrow("responseHeaders");
                    int columnIndexOrThrow18 = a3.getColumnIndexOrThrow("responseBody");
                    int columnIndexOrThrow19 = a3.getColumnIndexOrThrow("responseMessage");
                    int columnIndexOrThrow20 = a3.getColumnIndexOrThrow("responseContentType");
                    int columnIndexOrThrow21 = a3.getColumnIndexOrThrow("responseContentLength");
                    int columnIndexOrThrow22 = a3.getColumnIndexOrThrow("responseBodyIsPlainText");
                    int columnIndexOrThrow23 = a3.getColumnIndexOrThrow(d.O);
                    leavesc.hello.monitor.db.a.b bVar = null;
                    Long valueOf = null;
                    if (a3.moveToFirst()) {
                        leavesc.hello.monitor.db.a.b bVar2 = new leavesc.hello.monitor.db.a.b();
                        bVar2.a(a3.getLong(columnIndexOrThrow));
                        bVar2.a(leavesc.hello.monitor.b.a.a(a3.isNull(columnIndexOrThrow2) ? null : Long.valueOf(a3.getLong(columnIndexOrThrow2))));
                        if (!a3.isNull(columnIndexOrThrow3)) {
                            valueOf = Long.valueOf(a3.getLong(columnIndexOrThrow3));
                        }
                        bVar2.b(leavesc.hello.monitor.b.a.a(valueOf));
                        bVar2.b(a3.getLong(columnIndexOrThrow4));
                        bVar2.a(a3.getString(columnIndexOrThrow5));
                        bVar2.b(a3.getString(columnIndexOrThrow6));
                        bVar2.c(a3.getString(columnIndexOrThrow7));
                        bVar2.d(a3.getString(columnIndexOrThrow8));
                        bVar2.e(a3.getString(columnIndexOrThrow9));
                        bVar2.f(a3.getString(columnIndexOrThrow10));
                        bVar2.g(a3.getString(columnIndexOrThrow11));
                        bVar2.h(a3.getString(columnIndexOrThrow12));
                        bVar2.i(a3.getString(columnIndexOrThrow13));
                        bVar2.c(a3.getLong(columnIndexOrThrow14));
                        boolean z = true;
                        bVar2.c(a3.getInt(columnIndexOrThrow15) != 0);
                        bVar2.a(a3.getInt(columnIndexOrThrow16));
                        bVar2.j(a3.getString(columnIndexOrThrow17));
                        bVar2.k(a3.getString(columnIndexOrThrow18));
                        bVar2.l(a3.getString(columnIndexOrThrow19));
                        bVar2.m(a3.getString(columnIndexOrThrow20));
                        bVar2.d(a3.getLong(columnIndexOrThrow21));
                        if (a3.getInt(columnIndexOrThrow22) == 0) {
                            z = false;
                        }
                        bVar2.d(z);
                        bVar2.n(a3.getString(columnIndexOrThrow23));
                        bVar = bVar2;
                    }
                    return bVar;
                } finally {
                    a3.close();
                }
            }

            protected void finalize() {
                a2.a();
            }
        }.a();
    }

    @Override // leavesc.hello.monitor.db.a
    public LiveData<List<leavesc.hello.monitor.db.a.b>> a(int i) {
        final m a2 = m.a("SELECT * FROM monitor_httpInformation order by id desc limit ?", 1);
        a2.a(1, i);
        return new androidx.lifecycle.c<List<leavesc.hello.monitor.db.a.b>>(this.f7253a.i()) { // from class: leavesc.hello.monitor.db.b.5
            private g.b i;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.lifecycle.c
            /* renamed from: d */
            public List<leavesc.hello.monitor.db.a.b> c() {
                if (this.i == null) {
                    this.i = new g.b("monitor_httpInformation", new String[0]) { // from class: leavesc.hello.monitor.db.b.5.1
                        @Override // androidx.room.g.b
                        public void a(Set<String> set) {
                            b();
                        }
                    };
                    b.this.f7253a.k().b(this.i);
                }
                Cursor a3 = b.this.f7253a.a(a2);
                try {
                    int columnIndexOrThrow = a3.getColumnIndexOrThrow("id");
                    int columnIndexOrThrow2 = a3.getColumnIndexOrThrow("requestDate");
                    int columnIndexOrThrow3 = a3.getColumnIndexOrThrow("responseDate");
                    int columnIndexOrThrow4 = a3.getColumnIndexOrThrow("duration");
                    int columnIndexOrThrow5 = a3.getColumnIndexOrThrow("method");
                    int columnIndexOrThrow6 = a3.getColumnIndexOrThrow(ImagesContract.URL);
                    int columnIndexOrThrow7 = a3.getColumnIndexOrThrow("host");
                    int columnIndexOrThrow8 = a3.getColumnIndexOrThrow("path");
                    int columnIndexOrThrow9 = a3.getColumnIndexOrThrow("scheme");
                    int columnIndexOrThrow10 = a3.getColumnIndexOrThrow("protocol");
                    int columnIndexOrThrow11 = a3.getColumnIndexOrThrow("requestHeaders");
                    int columnIndexOrThrow12 = a3.getColumnIndexOrThrow("requestBody");
                    int columnIndexOrThrow13 = a3.getColumnIndexOrThrow("requestContentType");
                    int columnIndexOrThrow14 = a3.getColumnIndexOrThrow("requestContentLength");
                    int columnIndexOrThrow15 = a3.getColumnIndexOrThrow("requestBodyIsPlainText");
                    int columnIndexOrThrow16 = a3.getColumnIndexOrThrow("responseCode");
                    int columnIndexOrThrow17 = a3.getColumnIndexOrThrow("responseHeaders");
                    int columnIndexOrThrow18 = a3.getColumnIndexOrThrow("responseBody");
                    int columnIndexOrThrow19 = a3.getColumnIndexOrThrow("responseMessage");
                    int columnIndexOrThrow20 = a3.getColumnIndexOrThrow("responseContentType");
                    int columnIndexOrThrow21 = a3.getColumnIndexOrThrow("responseContentLength");
                    int columnIndexOrThrow22 = a3.getColumnIndexOrThrow("responseBodyIsPlainText");
                    int columnIndexOrThrow23 = a3.getColumnIndexOrThrow(d.O);
                    int i2 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(a3.getCount());
                    while (a3.moveToNext()) {
                        leavesc.hello.monitor.db.a.b bVar = new leavesc.hello.monitor.db.a.b();
                        int i3 = columnIndexOrThrow12;
                        int i4 = columnIndexOrThrow13;
                        bVar.a(a3.getLong(columnIndexOrThrow));
                        Long l = null;
                        bVar.a(leavesc.hello.monitor.b.a.a(a3.isNull(columnIndexOrThrow2) ? null : Long.valueOf(a3.getLong(columnIndexOrThrow2))));
                        if (!a3.isNull(columnIndexOrThrow3)) {
                            l = Long.valueOf(a3.getLong(columnIndexOrThrow3));
                        }
                        bVar.b(leavesc.hello.monitor.b.a.a(l));
                        bVar.b(a3.getLong(columnIndexOrThrow4));
                        bVar.a(a3.getString(columnIndexOrThrow5));
                        bVar.b(a3.getString(columnIndexOrThrow6));
                        bVar.c(a3.getString(columnIndexOrThrow7));
                        bVar.d(a3.getString(columnIndexOrThrow8));
                        bVar.e(a3.getString(columnIndexOrThrow9));
                        bVar.f(a3.getString(columnIndexOrThrow10));
                        bVar.g(a3.getString(columnIndexOrThrow11));
                        columnIndexOrThrow12 = i3;
                        bVar.h(a3.getString(columnIndexOrThrow12));
                        int i5 = columnIndexOrThrow;
                        columnIndexOrThrow13 = i4;
                        bVar.i(a3.getString(columnIndexOrThrow13));
                        int i6 = columnIndexOrThrow3;
                        int i7 = i2;
                        int i8 = columnIndexOrThrow2;
                        bVar.c(a3.getLong(i7));
                        int i9 = columnIndexOrThrow15;
                        bVar.c(a3.getInt(i9) != 0);
                        int i10 = columnIndexOrThrow16;
                        bVar.a(a3.getInt(i10));
                        int i11 = columnIndexOrThrow17;
                        bVar.j(a3.getString(i11));
                        int i12 = columnIndexOrThrow18;
                        bVar.k(a3.getString(i12));
                        int i13 = columnIndexOrThrow19;
                        bVar.l(a3.getString(i13));
                        int i14 = columnIndexOrThrow20;
                        bVar.m(a3.getString(i14));
                        int i15 = columnIndexOrThrow21;
                        bVar.d(a3.getLong(i15));
                        int i16 = columnIndexOrThrow22;
                        bVar.d(a3.getInt(i16) != 0);
                        int i17 = columnIndexOrThrow23;
                        bVar.n(a3.getString(i17));
                        arrayList.add(bVar);
                        columnIndexOrThrow22 = i16;
                        columnIndexOrThrow23 = i17;
                        columnIndexOrThrow2 = i8;
                        columnIndexOrThrow = i5;
                        columnIndexOrThrow3 = i6;
                        i2 = i7;
                        columnIndexOrThrow16 = i10;
                        columnIndexOrThrow21 = i15;
                        columnIndexOrThrow15 = i9;
                        columnIndexOrThrow17 = i11;
                        columnIndexOrThrow18 = i12;
                        columnIndexOrThrow19 = i13;
                        columnIndexOrThrow20 = i14;
                    }
                    return arrayList;
                } finally {
                    a3.close();
                }
            }

            protected void finalize() {
                a2.a();
            }
        }.a();
    }
}
