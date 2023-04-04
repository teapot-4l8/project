package com.speed.speed_library.widget.checkin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.speed.speed_library.R;
import kotlin.d.b.i;

/* compiled from: WeekAdapter.kt */
/* loaded from: classes2.dex */
public final class d extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5938a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f5939b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5940c;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public d(Context context, String[] strArr, int i) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(strArr, "week");
        this.f5938a = context;
        this.f5939b = strArr;
        this.f5940c = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5939b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f5939b[i];
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        i.b(viewGroup, "viewGroup");
        if (view == null) {
            view = LayoutInflater.from(this.f5938a).inflate(R.layout.item_date_gv, (ViewGroup) null);
            aVar = new a();
            if (view == null) {
                i.a();
            }
            view.setTag(aVar);
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                throw new kotlin.i("null cannot be cast to non-null type com.speed.speed_library.widget.checkin.WeekAdapter.ViewHolder");
            }
            aVar = (a) tag;
        }
        aVar.a((TextView) view.findViewById(R.id.tvWeek));
        TextView a2 = aVar.a();
        if (a2 != null) {
            a2.setText(this.f5939b[i]);
        }
        TextView a3 = aVar.a();
        if (a3 != null) {
            a3.setTextColor(this.f5940c);
        }
        return view;
    }

    /* compiled from: WeekAdapter.kt */
    /* loaded from: classes2.dex */
    public final class a {

        /* renamed from: b  reason: collision with root package name */
        private TextView f5942b;

        public a() {
        }

        public final TextView a() {
            return this.f5942b;
        }

        public final void a(TextView textView) {
            this.f5942b = textView;
        }
    }
}
