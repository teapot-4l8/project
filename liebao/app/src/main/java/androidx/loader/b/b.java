package androidx.loader.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.loader.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* compiled from: CursorLoader.java */
/* loaded from: classes.dex */
public class b extends a<Cursor> {
    final c<Cursor>.a f;
    Uri g;
    String[] h;
    String i;
    String[] j;
    String k;
    Cursor l;
    androidx.core.d.a m;

    @Override // androidx.loader.b.a
    /* renamed from: h */
    public Cursor d() {
        synchronized (this) {
            if (g()) {
                throw new androidx.core.d.c();
            }
            this.m = new androidx.core.d.a();
        }
        try {
            Cursor a2 = androidx.core.content.a.a(m().getContentResolver(), this.g, this.h, this.i, this.j, this.k, this.m);
            if (a2 != null) {
                try {
                    a2.getCount();
                    a2.registerContentObserver(this.f);
                } catch (RuntimeException e2) {
                    a2.close();
                    throw e2;
                }
            }
            synchronized (this) {
                this.m = null;
            }
            return a2;
        } catch (Throwable th) {
            synchronized (this) {
                this.m = null;
                throw th;
            }
        }
    }

    @Override // androidx.loader.b.a
    public void f() {
        super.f();
        synchronized (this) {
            if (this.m != null) {
                this.m.c();
            }
        }
    }

    @Override // androidx.loader.b.c
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void b(Cursor cursor) {
        if (p()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.l;
        this.l = cursor;
        if (n()) {
            super.b((b) cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    public b(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f = new c.a();
        this.g = uri;
        this.h = strArr;
        this.i = str;
        this.j = strArr2;
        this.k = str2;
    }

    @Override // androidx.loader.b.c
    protected void i() {
        Cursor cursor = this.l;
        if (cursor != null) {
            b(cursor);
        }
        if (x() || this.l == null) {
            s();
        }
    }

    @Override // androidx.loader.b.c
    protected void j() {
        r();
    }

    @Override // androidx.loader.b.a
    /* renamed from: b */
    public void a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.loader.b.c
    public void k() {
        super.k();
        j();
        Cursor cursor = this.l;
        if (cursor != null && !cursor.isClosed()) {
            this.l.close();
        }
        this.l = null;
    }

    @Override // androidx.loader.b.a, androidx.loader.b.c
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.u);
    }
}
