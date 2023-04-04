package com.speed.speed_library.widget.checkin;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.speed.speed_library.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: CheakInView.kt */
/* loaded from: classes2.dex */
public final class CheckInView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private b f5924a;

    public /* synthetic */ CheckInView(Context context, Integer num, Integer num2, Integer num3, Integer num4, String[] strArr, int i, g gVar) {
        this(context, (i & 2) != 0 ? Integer.valueOf(R.color.cheakColor) : num, (i & 4) != 0 ? Integer.valueOf(R.color.unCheakColor) : num2, (i & 8) != 0 ? Integer.valueOf(R.color.titleTextColor) : num3, (i & 16) != 0 ? Integer.valueOf(R.color.titleBgColor) : num4, (i & 32) != 0 ? context.getResources().getStringArray(R.array.weeks) : strArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckInView(Context context, Integer num, Integer num2, Integer num3, Integer num4, String[] strArr) {
        super(context);
        i.b(context, com.umeng.analytics.pro.d.R);
        if (num == null) {
            i.a();
        }
        int intValue = num.intValue();
        if (num2 == null) {
            i.a();
        }
        int intValue2 = num2.intValue();
        if (num3 == null) {
            i.a();
        }
        int intValue3 = num3.intValue();
        if (num4 == null) {
            i.a();
        }
        int intValue4 = num4.intValue();
        if (strArr == null) {
            i.a();
        }
        a(intValue, intValue2, intValue3, intValue4, strArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckInView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(attributeSet, "attrs");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CheckInView);
        int color = obtainStyledAttributes.getColor(R.styleable.CheckInView_cheakColor, getResources().getColor(R.color.cheakColor));
        int color2 = obtainStyledAttributes.getColor(R.styleable.CheckInView_unCheakColor, getResources().getColor(R.color.unCheakColor));
        int color3 = obtainStyledAttributes.getColor(R.styleable.CheckInView_titleTextColor, getResources().getColor(R.color.titleTextColor));
        int color4 = obtainStyledAttributes.getColor(R.styleable.CheckInView_titleBgColor, getResources().getColor(R.color.titleBgColor));
        String[] stringArray = context.getResources().getStringArray(R.array.weeks);
        i.a((Object) stringArray, "context.resources.getStringArray(R.array.weeks)");
        a(color, color2, color3, color4, stringArray);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckInView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(attributeSet, "attrs");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CheckInView);
        int color = obtainStyledAttributes.getColor(R.styleable.CheckInView_cheakColor, getResources().getColor(R.color.cheakColor));
        int color2 = obtainStyledAttributes.getColor(R.styleable.CheckInView_unCheakColor, getResources().getColor(R.color.unCheakColor));
        int color3 = obtainStyledAttributes.getColor(R.styleable.CheckInView_titleTextColor, getResources().getColor(R.color.titleTextColor));
        int color4 = obtainStyledAttributes.getColor(R.styleable.CheckInView_titleBgColor, getResources().getColor(R.color.titleBgColor));
        String[] stringArray = context.getResources().getStringArray(R.array.weeks);
        i.a((Object) stringArray, "context.resources.getStringArray(R.array.weeks)");
        a(color, color2, color3, color4, stringArray);
    }

    private final void a(int i, int i2, int i3, int i4, String[] strArr) {
        View inflate = View.inflate(getContext(), R.layout.view_check_in, this);
        i.a((Object) inflate, "view");
        TextView textView = (TextView) inflate.findViewById(R.id.tvYear);
        i.a((Object) textView, "view.tvYear");
        textView.setText(c.f5937a.b());
        GridView gridView = (GridView) inflate.findViewById(R.id.gvWeek);
        i.a((Object) gridView, "view.gvWeek");
        Context context = getContext();
        i.a((Object) context, com.umeng.analytics.pro.d.R);
        gridView.setAdapter((ListAdapter) new d(context, strArr, i2));
        Context context2 = getContext();
        i.a((Object) context2, com.umeng.analytics.pro.d.R);
        this.f5924a = new b(context2, i, i2);
        GridView gridView2 = (GridView) inflate.findViewById(R.id.gvDate);
        i.a((Object) gridView2, "view.gvDate");
        gridView2.setAdapter((ListAdapter) this.f5924a);
    }

    public final void setCheckInLinstener(a aVar) {
        i.b(aVar, "linstener");
        b bVar = this.f5924a;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public final void a(ArrayList<Integer> arrayList) {
        i.b(arrayList, "cheakDays");
        ArrayList<Boolean> arrayList2 = new ArrayList<>();
        int a2 = c.f5937a.a();
        if (a2 >= 0) {
            int i = 0;
            while (true) {
                arrayList2.add(false);
                if (i == a2) {
                    break;
                }
                i++;
            }
        }
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            i.a((Object) next, "item");
            arrayList2.set(next.intValue(), true);
        }
        b bVar = this.f5924a;
        if (bVar != null) {
            bVar.a(arrayList2);
        }
        b bVar2 = this.f5924a;
        if (bVar2 != null) {
            bVar2.notifyDataSetChanged();
        }
    }

    public final void a(int i) {
        b bVar = this.f5924a;
        if (bVar != null) {
            bVar.a(i);
        }
        b bVar2 = this.f5924a;
        if (bVar2 != null) {
            bVar2.notifyDataSetChanged();
        }
    }

    public final void a() {
        a(c.f5937a.d());
    }
}
