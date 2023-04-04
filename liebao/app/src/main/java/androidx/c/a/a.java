package androidx.c.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.c.a.b;
import com.umeng.analytics.pro.ao;

/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f1234a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f1235b;

    /* renamed from: c  reason: collision with root package name */
    protected Cursor f1236c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f1237d;

    /* renamed from: e  reason: collision with root package name */
    protected int f1238e;
    protected C0028a f;
    protected DataSetObserver g;
    protected androidx.c.a.b h;
    protected FilterQueryProvider i;

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void a(View view, Context context, Cursor cursor);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public a(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    void a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.f1235b = true;
        } else {
            this.f1235b = false;
        }
        boolean z = cursor != null;
        this.f1236c = cursor;
        this.f1234a = z;
        this.f1237d = context;
        this.f1238e = z ? cursor.getColumnIndexOrThrow(ao.f6395d) : -1;
        if ((i & 2) == 2) {
            this.f = new C0028a();
            this.g = new b();
        } else {
            this.f = null;
            this.g = null;
        }
        if (z) {
            C0028a c0028a = this.f;
            if (c0028a != null) {
                cursor.registerContentObserver(c0028a);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @Override // androidx.c.a.b.a
    public Cursor a() {
        return this.f1236c;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f1234a || (cursor = this.f1236c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f1234a || (cursor = this.f1236c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f1236c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f1234a && (cursor = this.f1236c) != null && cursor.moveToPosition(i)) {
            return this.f1236c.getLong(this.f1238e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f1234a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f1236c.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        if (view == null) {
            view = a(this.f1237d, this.f1236c, viewGroup);
        }
        a(view, this.f1237d, this.f1236c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f1234a) {
            this.f1236c.moveToPosition(i);
            if (view == null) {
                view = b(this.f1237d, this.f1236c, viewGroup);
            }
            a(view, this.f1237d, this.f1236c);
            return view;
        }
        return null;
    }

    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return a(context, cursor, viewGroup);
    }

    public void a(Cursor cursor) {
        Cursor c2 = c(cursor);
        if (c2 != null) {
            c2.close();
        }
    }

    public Cursor c(Cursor cursor) {
        Cursor cursor2 = this.f1236c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0028a c0028a = this.f;
            if (c0028a != null) {
                cursor2.unregisterContentObserver(c0028a);
            }
            DataSetObserver dataSetObserver = this.g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1236c = cursor;
        if (cursor != null) {
            C0028a c0028a2 = this.f;
            if (c0028a2 != null) {
                cursor.registerContentObserver(c0028a2);
            }
            DataSetObserver dataSetObserver2 = this.g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f1238e = cursor.getColumnIndexOrThrow(ao.f6395d);
            this.f1234a = true;
            notifyDataSetChanged();
        } else {
            this.f1238e = -1;
            this.f1234a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    public CharSequence b(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor a(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.i;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.f1236c;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.h == null) {
            this.h = new androidx.c.a.b(this);
        }
        return this.h;
    }

    protected void b() {
        Cursor cursor;
        if (!this.f1235b || (cursor = this.f1236c) == null || cursor.isClosed()) {
            return;
        }
        this.f1234a = this.f1236c.requery();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* renamed from: androidx.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0028a extends ContentObserver {
        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        C0028a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CursorAdapter.java */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a.this.f1234a = true;
            a.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a.this.f1234a = false;
            a.this.notifyDataSetInvalidated();
        }
    }
}
