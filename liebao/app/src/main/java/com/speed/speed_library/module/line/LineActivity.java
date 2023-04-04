package com.speed.speed_library.module.line;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.d;
import androidx.fragment.app.j;
import androidx.fragment.app.n;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.speed.speed_library.R;
import com.speed.speed_library.event.RouteEvent;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.a.h;
import kotlin.d.b.i;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

/* compiled from: LineActivity.kt */
/* loaded from: classes.dex */
public final class LineActivity extends com.speed.speed_library.a.a implements View.OnClickListener {
    private a k;
    private ArrayList<String> l = new ArrayList<>();
    private int m;
    private HashMap n;

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.n == null) {
            this.n = new HashMap();
        }
        View view = (View) this.n.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.n.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_line);
        this.l = h.a((Object[]) new String[]{"VIP线路", "SVIP线路"});
        ViewPager viewPager = (ViewPager) d(R.id.viewpager);
        i.a((Object) viewPager, "viewpager");
        a(viewPager);
        l();
    }

    public final void l() {
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(this);
    }

    private final void a(ViewPager viewPager) {
        j j = j();
        i.a((Object) j, "supportFragmentManager");
        a aVar = new a(j);
        this.k = aVar;
        if (aVar == null) {
            i.b("pagerAdapter");
        }
        String str = this.l.get(0);
        i.a((Object) str, "TAB_TITLES[0]");
        aVar.a(com.speed.speed_library.module.line.a.f5706b.a("vip"), str);
        a aVar2 = this.k;
        if (aVar2 == null) {
            i.b("pagerAdapter");
        }
        String str2 = this.l.get(1);
        i.a((Object) str2, "TAB_TITLES[1]");
        aVar2.a(com.speed.speed_library.module.line.a.f5706b.a("svip"), str2);
        a aVar3 = this.k;
        if (aVar3 == null) {
            i.b("pagerAdapter");
        }
        viewPager.setAdapter(aVar3);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setCurrentItem(this.m);
        ((TabLayout) d(R.id.tab_layout)).setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new b());
    }

    /* compiled from: LineActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements ViewPager.f {
        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageScrolled(int i, float f, int i2) {
        }

        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.f
        public void onPageSelected(int i) {
            LineActivity.this.m = i;
        }
    }

    /* compiled from: LineActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends n {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList<com.speed.speed_library.a.b> f5703a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<String> f5704b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j jVar) {
            super(jVar);
            i.b(jVar, "fm");
            this.f5703a = new ArrayList<>();
            this.f5704b = new ArrayList<>();
        }

        public final void a(com.speed.speed_library.a.b bVar, String str) {
            i.b(bVar, "fragment");
            i.b(str, "title");
            this.f5703a.add(bVar);
            this.f5704b.add(str);
        }

        @Override // androidx.fragment.app.n
        public d a(int i) {
            com.speed.speed_library.a.b bVar = this.f5703a.get(i);
            i.a((Object) bVar, "mFragments[position]");
            return bVar;
        }

        @Override // androidx.viewpager.widget.a
        public int b() {
            return this.f5703a.size();
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence c(int i) {
            return this.f5704b.get(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            finish();
        }
    }

    @m(a = ThreadMode.MAIN)
    public final void routeEvent(RouteEvent routeEvent) {
        i.b(routeEvent, "event");
        if (isFinishing()) {
            return;
        }
        finish();
    }
}
