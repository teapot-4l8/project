package androidx.room;

import android.database.Cursor;
import androidx.e.a.c;
import java.util.List;

/* compiled from: RoomOpenHelper.java */
/* loaded from: classes.dex */
public class l extends c.a {

    /* renamed from: b  reason: collision with root package name */
    private androidx.room.a f2469b;

    /* renamed from: c  reason: collision with root package name */
    private final a f2470c;

    /* renamed from: d  reason: collision with root package name */
    private final String f2471d;

    /* renamed from: e  reason: collision with root package name */
    private final String f2472e;

    public l(androidx.room.a aVar, a aVar2, String str, String str2) {
        super(aVar2.f2473a);
        this.f2469b = aVar;
        this.f2470c = aVar2;
        this.f2471d = str;
        this.f2472e = str2;
    }

    @Override // androidx.e.a.c.a
    public void a(androidx.e.a.b bVar) {
        super.a(bVar);
    }

    @Override // androidx.e.a.c.a
    public void b(androidx.e.a.b bVar) {
        f(bVar);
        this.f2470c.b(bVar);
        this.f2470c.d(bVar);
    }

    @Override // androidx.e.a.c.a
    public void a(androidx.e.a.b bVar, int i, int i2) {
        boolean z;
        List<androidx.room.a.a> a2;
        androidx.room.a aVar = this.f2469b;
        if (aVar == null || (a2 = aVar.f2393d.a(i, i2)) == null) {
            z = false;
        } else {
            this.f2470c.f(bVar);
            for (androidx.room.a.a aVar2 : a2) {
                aVar2.a(bVar);
            }
            this.f2470c.e(bVar);
            this.f2470c.g(bVar);
            f(bVar);
            z = true;
        }
        if (z) {
            return;
        }
        androidx.room.a aVar3 = this.f2469b;
        if (aVar3 != null && !aVar3.a(i, i2)) {
            this.f2470c.a(bVar);
            this.f2470c.b(bVar);
            return;
        }
        throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    @Override // androidx.e.a.c.a
    public void b(androidx.e.a.b bVar, int i, int i2) {
        a(bVar, i, i2);
    }

    @Override // androidx.e.a.c.a
    public void c(androidx.e.a.b bVar) {
        super.c(bVar);
        e(bVar);
        this.f2470c.c(bVar);
        this.f2469b = null;
    }

    private void e(androidx.e.a.b bVar) {
        if (h(bVar)) {
            Cursor a2 = bVar.a(new androidx.e.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                r1 = a2.moveToFirst() ? a2.getString(0) : null;
            } finally {
                a2.close();
            }
        }
        if (!this.f2471d.equals(r1) && !this.f2472e.equals(r1)) {
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
        }
    }

    private void f(androidx.e.a.b bVar) {
        g(bVar);
        bVar.c(k.a(this.f2471d));
    }

    private void g(androidx.e.a.b bVar) {
        bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean h(androidx.e.a.b bVar) {
        Cursor b2 = bVar.b("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (b2.moveToFirst()) {
                if (b2.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            b2.close();
        }
    }

    /* compiled from: RoomOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f2473a;

        protected abstract void a(androidx.e.a.b bVar);

        protected abstract void b(androidx.e.a.b bVar);

        protected abstract void c(androidx.e.a.b bVar);

        protected abstract void d(androidx.e.a.b bVar);

        protected abstract void e(androidx.e.a.b bVar);

        protected void f(androidx.e.a.b bVar) {
        }

        protected void g(androidx.e.a.b bVar) {
        }

        public a(int i) {
            this.f2473a = i;
        }
    }
}
