package com.speed.speed_library.debug.netinfo.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: BaseRecyclerHolder.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.x {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<View> f5697a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5698b;

    private b(View view, Context context) {
        super(view);
        this.f5698b = context;
        this.f5697a = new SparseArray<>(8);
    }

    public static b a(View view, Context context) {
        return new b(view, context);
    }

    public <T extends View> T a(int i) {
        T t = (T) this.f5697a.get(i);
        if (t == null) {
            T t2 = (T) this.itemView.findViewById(i);
            this.f5697a.put(i, t2);
            return t2;
        }
        return t;
    }

    public b a(int i, String str) {
        TextView textView = (TextView) a(i);
        if (str == null) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
        return this;
    }
}
