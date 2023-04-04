package com.speed.speed_library.module.setting;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.b.e;
import b.b.h;
import com.speed.speed_library.R;
import com.speed.speed_library.adapter.AppAgentAdapter;
import com.speed.speed_library.model.AppAgentModel;
import com.speed.speed_library.widget.LoadingLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.d.b.i;
import kotlin.h.g;
import utils.AppLog;

/* compiled from: AppAgentActivity.kt */
/* loaded from: classes2.dex */
public final class AppAgentActivity extends com.speed.speed_library.a.a {
    private AppAgentAdapter l;
    private AppAgentAdapter n;
    private HashMap o;
    private ArrayList<AppAgentModel> k = new ArrayList<>();
    private ArrayList<AppAgentModel> m = new ArrayList<>();

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.o == null) {
            this.o = new HashMap();
        }
        View view = (View) this.o.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.o.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public final ArrayList<AppAgentModel> l() {
        return this.k;
    }

    public final void a(AppAgentAdapter appAgentAdapter) {
        this.l = appAgentAdapter;
    }

    public final AppAgentAdapter m() {
        return this.l;
    }

    public final ArrayList<AppAgentModel> n() {
        return this.m;
    }

    public final AppAgentAdapter o() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_app_agent);
        p();
        q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppAgentActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppAgentActivity.this.finish();
        }
    }

    public final void p() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText(getString(R.string.setting_use_vpn_app_title_header));
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(new c());
        RecyclerView recyclerView = (RecyclerView) d(R.id.recyclerView_search);
        i.a((Object) recyclerView, "recyclerView_search");
        recyclerView.setVisibility(8);
        RecyclerView recyclerView2 = (RecyclerView) d(R.id.recyclerView);
        i.a((Object) recyclerView2, "recyclerView");
        recyclerView2.setVisibility(0);
        this.n = new AppAgentAdapter(this.m);
        RecyclerView recyclerView3 = (RecyclerView) d(R.id.recyclerView_search);
        i.a((Object) recyclerView3, "recyclerView_search");
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView4 = (RecyclerView) d(R.id.recyclerView_search);
        i.a((Object) recyclerView4, "recyclerView_search");
        recyclerView4.setAdapter(this.n);
        ((EditText) d(R.id.et_search)).addTextChangedListener(new d());
    }

    /* compiled from: AppAgentActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        d() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ArrayList<AppAgentModel> n;
            String valueOf = String.valueOf(charSequence);
            if (TextUtils.isEmpty(valueOf)) {
                AppAgentActivity.this.q();
                RecyclerView recyclerView = (RecyclerView) AppAgentActivity.this.d(R.id.recyclerView);
                i.a((Object) recyclerView, "recyclerView");
                recyclerView.setVisibility(0);
                RecyclerView recyclerView2 = (RecyclerView) AppAgentActivity.this.d(R.id.recyclerView_search);
                i.a((Object) recyclerView2, "recyclerView_search");
                recyclerView2.setVisibility(8);
                return;
            }
            RecyclerView recyclerView3 = (RecyclerView) AppAgentActivity.this.d(R.id.recyclerView);
            i.a((Object) recyclerView3, "recyclerView");
            recyclerView3.setVisibility(8);
            RecyclerView recyclerView4 = (RecyclerView) AppAgentActivity.this.d(R.id.recyclerView_search);
            i.a((Object) recyclerView4, "recyclerView_search");
            recyclerView4.setVisibility(0);
            ArrayList<AppAgentModel> n2 = AppAgentActivity.this.n();
            if (n2 != null) {
                n2.clear();
            }
            ArrayList<AppAgentModel> l = AppAgentActivity.this.l();
            if (l == null) {
                i.a();
            }
            Iterator<AppAgentModel> it = l.iterator();
            while (it.hasNext()) {
                AppAgentModel next = it.next();
                AppLog appLog = AppLog.INSTANCE;
                appLog.d("route.name::" + next.getAppName());
                String appName = next.getAppName();
                if (appName == null) {
                    throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = appName.toLowerCase();
                i.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                String str = lowerCase;
                if (valueOf == null) {
                    throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase2 = valueOf.toLowerCase();
                i.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                if (g.a((CharSequence) str, (CharSequence) lowerCase2, false, 2, (Object) null) && (n = AppAgentActivity.this.n()) != null) {
                    n.add(next);
                }
            }
            AppAgentAdapter o = AppAgentActivity.this.o();
            if (o != null) {
                o.a(AppAgentActivity.this.n());
            }
        }
    }

    public final void q() {
        ((LoadingLayout) d(R.id.loading_layout)).setStatus(LoadingLayout.f5877a.b());
        ArrayList<String> W = com.speed.speed_library.b.g.f5610b.W();
        if (W == null) {
            W = new ArrayList<>();
        }
        e.b("").a(new a(W)).b(b.b.h.a.b()).a(b.b.a.b.a.a()).a(new b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppAgentActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a<T, R> implements b.b.d.e<T, R> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f5781b;

        a(ArrayList arrayList) {
            this.f5781b = arrayList;
        }

        @Override // b.b.d.e
        public final ArrayList<AppAgentModel> a(String str) {
            i.b(str, "it");
            List<PackageInfo> a2 = com.speed.speed_library.b.c.f5594a.a(AppAgentActivity.this);
            ArrayList<AppAgentModel> arrayList = new ArrayList<>();
            for (PackageInfo packageInfo : a2) {
                if (!packageInfo.packageName.equals(AppAgentActivity.this.getPackageName())) {
                    AppAgentModel appAgentModel = new AppAgentModel();
                    appAgentModel.setAppName(packageInfo.applicationInfo.loadLabel(AppAgentActivity.this.getPackageManager()).toString());
                    String str2 = packageInfo.packageName;
                    i.a((Object) str2, "packageInfo.packageName");
                    appAgentModel.setPackageName(str2);
                    appAgentModel.setDrawable(packageInfo.applicationInfo.loadIcon(AppAgentActivity.this.getPackageManager()));
                    if (this.f5781b.contains(appAgentModel.getPackageName())) {
                        appAgentModel.setSwitch(false);
                    } else {
                        appAgentModel.setSwitch(true);
                    }
                    arrayList.add(appAgentModel);
                }
            }
            return arrayList;
        }
    }

    /* compiled from: AppAgentActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements h<ArrayList<AppAgentModel>> {
        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            i.b(bVar, "d");
        }

        b() {
        }

        @Override // b.b.h
        /* renamed from: a */
        public void a_(ArrayList<AppAgentModel> arrayList) {
            i.b(arrayList, "list");
            AppAgentActivity.this.l().clear();
            AppAgentActivity.this.l().addAll(arrayList);
            AppAgentActivity.this.a(new AppAgentAdapter(arrayList));
            RecyclerView recyclerView = (RecyclerView) AppAgentActivity.this.d(R.id.recyclerView);
            i.a((Object) recyclerView, "recyclerView");
            recyclerView.setLayoutManager(new LinearLayoutManager(AppAgentActivity.this));
            RecyclerView recyclerView2 = (RecyclerView) AppAgentActivity.this.d(R.id.recyclerView);
            i.a((Object) recyclerView2, "recyclerView");
            recyclerView2.setAdapter(AppAgentActivity.this.m());
            AppAgentAdapter m = AppAgentActivity.this.m();
            if (m != null) {
                m.notifyDataSetChanged();
            }
        }

        @Override // b.b.h
        public void a(Throwable th) {
            i.b(th, "e");
            ((LoadingLayout) AppAgentActivity.this.d(R.id.loading_layout)).setStatus(LoadingLayout.f5877a.a());
        }

        @Override // b.b.h
        public void b() {
            ((LoadingLayout) AppAgentActivity.this.d(R.id.loading_layout)).setStatus(LoadingLayout.f5877a.a());
        }
    }
}
