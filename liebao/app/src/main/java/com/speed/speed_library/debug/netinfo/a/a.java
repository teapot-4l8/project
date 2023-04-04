package com.speed.speed_library.debug.netinfo.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* compiled from: BaseRecyclerAdapter.java */
/* loaded from: classes2.dex */
public abstract class a<T> extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    protected Context f5689a;

    /* renamed from: c  reason: collision with root package name */
    protected LayoutInflater f5691c;

    /* renamed from: d  reason: collision with root package name */
    protected int f5692d;

    /* renamed from: e  reason: collision with root package name */
    protected RecyclerView f5693e;
    private InterfaceC0144a h;
    private long f = 0;
    private int g = -1;

    /* renamed from: b  reason: collision with root package name */
    protected List<T> f5690b = new ArrayList();

    /* compiled from: BaseRecyclerAdapter.java */
    /* renamed from: com.speed.speed_library.debug.netinfo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0144a {
        void a(RecyclerView recyclerView, View view, int i);

        void b(RecyclerView recyclerView, View view, int i);
    }

    public abstract void a(b bVar, T t, int i);

    public void a(b bVar, T t, int i, Bundle bundle) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f5693e = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f5693e = null;
    }

    public void a(T t) {
        List<T> list = this.f5690b;
        list.add(list.size(), t);
        notifyItemInserted(this.f5690b.size());
    }

    public a(Context context, int i) {
        this.f5689a = context;
        this.f5691c = LayoutInflater.from(context);
        this.f5692d = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return b.a(this.f5691c.inflate(this.f5692d, viewGroup, false), this.f5689a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a */
    public void onBindViewHolder(b bVar, final int i) {
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.speed.speed_library.debug.netinfo.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (i != a.this.g) {
                    if (a.this.h != null && view != null && a.this.f5693e != null) {
                        a.this.h.a(a.this.f5693e, view, a.this.f5693e.getChildAdapterPosition(view));
                    }
                    a.this.g = i;
                    return;
                }
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                if (timeInMillis - a.this.f > 2000) {
                    a.this.f = timeInMillis;
                    if (a.this.h == null || view == null || a.this.f5693e == null) {
                        return;
                    }
                    a.this.h.a(a.this.f5693e, view, a.this.f5693e.getChildAdapterPosition(view));
                }
            }
        });
        bVar.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.speed.speed_library.debug.netinfo.a.a.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (a.this.h == null || view == null || a.this.f5693e == null) {
                    return true;
                }
                a.this.h.b(a.this.f5693e, view, a.this.f5693e.getChildAdapterPosition(view));
                return true;
            }
        });
        a(bVar, (b) this.f5690b.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(bVar, i);
            return;
        }
        a(bVar, this.f5690b.get(i), i, (Bundle) list.get(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        List<T> list = this.f5690b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
