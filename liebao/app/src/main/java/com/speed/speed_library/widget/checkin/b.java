package com.speed.speed_library.widget.checkin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.speed.speed_library.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: DateAdapter.kt */
/* loaded from: classes2.dex */
public final class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a> f5925a;

    /* renamed from: b  reason: collision with root package name */
    private com.speed.speed_library.widget.checkin.a f5926b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f5927c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5928d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5929e;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public b(Context context, int i, int i2) {
        i.b(context, com.umeng.analytics.pro.d.R);
        this.f5927c = context;
        this.f5928d = i;
        this.f5929e = i2;
        this.f5925a = new ArrayList<>();
        a aVar = new a(null, null, 3, null);
        int c2 = c.f5937a.c() - 1;
        int i3 = 0;
        for (int i4 = 0; i4 < c2; i4++) {
            this.f5925a.add(aVar);
        }
        int a2 = c.f5937a.a();
        while (i3 < a2) {
            i3++;
            this.f5925a.add(new a(Integer.valueOf(i3), null, 2, null));
        }
    }

    public final void a(ArrayList<Boolean> arrayList) {
        i.b(arrayList, "cheakDays");
        Iterator<a> it = this.f5925a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            Integer a2 = next.a();
            if (a2 == null) {
                i.a();
            }
            if (a2.intValue() > 0) {
                Integer a3 = next.a();
                if (a3 == null) {
                    i.a();
                }
                next.a(arrayList.get(a3.intValue()));
            }
        }
    }

    public final void a(int i) {
        a aVar = this.f5925a.get((c.f5937a.c() - 2) + i);
        i.a((Object) aVar, "days[DateUtil.firstDayOfMonth() - 2 + day]");
        a aVar2 = aVar;
        Integer a2 = aVar2.a();
        if (a2 != null && a2.intValue() == i) {
            Boolean b2 = aVar2.b();
            if (b2 == null) {
                i.a();
            }
            if (b2.booleanValue()) {
                com.speed.speed_library.widget.checkin.a aVar3 = this.f5926b;
                if (aVar3 != null) {
                    aVar3.b(i);
                    return;
                }
                return;
            }
            aVar2.a(true);
            com.speed.speed_library.widget.checkin.a aVar4 = this.f5926b;
            if (aVar4 != null) {
                aVar4.a(i);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5925a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        a aVar = this.f5925a.get(i);
        i.a((Object) aVar, "days[i]");
        return aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0158b c0158b;
        RelativeLayout a2;
        i.b(viewGroup, "viewGroup");
        if (view == null) {
            view = LayoutInflater.from(this.f5927c).inflate(R.layout.item_date_gv, (ViewGroup) null);
            c0158b = new C0158b();
            if (view == null) {
                i.a();
            }
            view.setTag(c0158b);
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                throw new kotlin.i("null cannot be cast to non-null type com.speed.speed_library.widget.checkin.DateAdapter.ViewHolder");
            }
            c0158b = (C0158b) tag;
        }
        c0158b.a((TextView) view.findViewById(R.id.tvWeek));
        c0158b.a((RelativeLayout) view.findViewById(R.id.rlItem));
        c0158b.a((ImageView) view.findViewById(R.id.ivStatus));
        c0158b.a((LinearLayout) view.findViewById(R.id.ll_item_checkin));
        TextView b2 = c0158b.b();
        if (b2 != null) {
            b2.setText(String.valueOf(this.f5925a.get(i).a()));
        }
        Integer a3 = this.f5925a.get(i).a();
        if (a3 != null && a3.intValue() == 0 && (a2 = c0158b.a()) != null) {
            a2.setVisibility(8);
        }
        Boolean b3 = this.f5925a.get(i).b();
        if (b3 == null) {
            i.a();
        }
        if (b3.booleanValue()) {
            LinearLayout d2 = c0158b.d();
            if (d2 == null) {
                i.a();
            }
            d2.setBackgroundResource(R.drawable.icon_dot_blue);
        } else {
            Integer a4 = this.f5925a.get(i).a();
            int d3 = c.f5937a.d();
            if (a4 != null && a4.intValue() == d3) {
                TextView b4 = c0158b.b();
                if (b4 != null) {
                    b4.setTextColor(this.f5927c.getResources().getColor(R.color.colorPrimary));
                }
            } else {
                TextView b5 = c0158b.b();
                if (b5 != null) {
                    b5.setTextColor(this.f5929e);
                }
                ImageView c2 = c0158b.c();
                if (c2 != null) {
                    c2.setVisibility(8);
                }
            }
        }
        return view;
    }

    /* compiled from: DateAdapter.kt */
    /* renamed from: com.speed.speed_library.widget.checkin.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C0158b {

        /* renamed from: b  reason: collision with root package name */
        private RelativeLayout f5933b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f5934c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f5935d;

        /* renamed from: e  reason: collision with root package name */
        private LinearLayout f5936e;

        public C0158b() {
        }

        public final RelativeLayout a() {
            return this.f5933b;
        }

        public final void a(RelativeLayout relativeLayout) {
            this.f5933b = relativeLayout;
        }

        public final void a(TextView textView) {
            this.f5934c = textView;
        }

        public final TextView b() {
            return this.f5934c;
        }

        public final void a(ImageView imageView) {
            this.f5935d = imageView;
        }

        public final ImageView c() {
            return this.f5935d;
        }

        public final void a(LinearLayout linearLayout) {
            this.f5936e = linearLayout;
        }

        public final LinearLayout d() {
            return this.f5936e;
        }
    }

    public final void a(com.speed.speed_library.widget.checkin.a aVar) {
        i.b(aVar, "linstener");
        this.f5926b = aVar;
    }

    /* compiled from: DateAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f5930a;

        /* renamed from: b  reason: collision with root package name */
        private Boolean f5931b;

        public a() {
            this(null, null, 3, null);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return i.a(this.f5930a, aVar.f5930a) && i.a(this.f5931b, aVar.f5931b);
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            Integer num = this.f5930a;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            Boolean bool = this.f5931b;
            return hashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "Data(day=" + this.f5930a + ", isCheak=" + this.f5931b + ")";
        }

        public a(Integer num, Boolean bool) {
            this.f5930a = num;
            this.f5931b = bool;
        }

        public /* synthetic */ a(Integer num, Boolean bool, int i, g gVar) {
            this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? false : bool);
        }

        public final Integer a() {
            return this.f5930a;
        }

        public final void a(Boolean bool) {
            this.f5931b = bool;
        }

        public final Boolean b() {
            return this.f5931b;
        }
    }
}
