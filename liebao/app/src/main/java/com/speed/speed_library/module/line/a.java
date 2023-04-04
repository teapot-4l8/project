package com.speed.speed_library.module.line;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.speed.speed_library.R;
import com.speed.speed_library.adapter.LineAdapter;
import com.speed.speed_library.adapter.LineTwoAdapter;
import com.speed.speed_library.b.g;
import com.speed.speed_library.b.h;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.Route;
import com.speed.speed_library.model.RouteExpandHeaderModel;
import com.speed.speed_library.model.RouteExpandModel;
import com.speed.speed_library.model.RouteModel;
import d.a.a.a.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.d.b.i;
import utils.AppLog;

/* compiled from: LineFragment.kt */
/* loaded from: classes2.dex */
public final class a extends com.speed.speed_library.a.b {

    /* renamed from: b  reason: collision with root package name */
    public static final C0146a f5706b = new C0146a(null);
    private static String h = "vip";

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<MultiItemEntity> f5707c;

    /* renamed from: d  reason: collision with root package name */
    private LineAdapter f5708d;

    /* renamed from: e  reason: collision with root package name */
    private LineTwoAdapter f5709e;
    private List<Route> f;
    private String g = "";
    private HashMap i;

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public View a(int i) {
        if (this.i == null) {
            this.i = new HashMap();
        }
        View view = (View) this.i.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this.i.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public void c() {
        HashMap hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d, androidx.fragment.app.d
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.g = (arguments == null || (r2 = arguments.getString(h)) == null) ? "" : "";
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_line, viewGroup, false);
        i.a((Object) inflate, "inflater.inflate(R.layou…t_line, container, false)");
        a(inflate);
        e();
        if (g.f5610b.p() == null) {
            f();
        } else {
            RouteModel p = g.f5610b.p();
            if (p == null) {
                i.a();
            }
            a(p);
        }
        return a();
    }

    /* compiled from: LineFragment.kt */
    /* renamed from: com.speed.speed_library.module.line.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0146a {
        private C0146a() {
        }

        public /* synthetic */ C0146a(kotlin.d.b.g gVar) {
            this();
        }

        public final String a() {
            return a.h;
        }

        public final a a(String str) {
            i.b(str, "str");
            Bundle bundle = new Bundle();
            a aVar = new a();
            bundle.putString(a(), str);
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    public final void e() {
        this.f5707c = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) a().findViewById(R.id.recyclerView);
        i.a((Object) recyclerView, "mRootView.recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (this.g.equals("vip")) {
            ArrayList<MultiItemEntity> arrayList = this.f5707c;
            if (arrayList == null) {
                i.a();
            }
            this.f5708d = new LineAdapter(arrayList);
            RecyclerView recyclerView2 = (RecyclerView) a().findViewById(R.id.recyclerView);
            i.a((Object) recyclerView2, "mRootView.recyclerView");
            recyclerView2.setAdapter(this.f5708d);
            LineAdapter lineAdapter = this.f5708d;
            if (lineAdapter == null) {
                i.a();
            }
            lineAdapter.expand(0);
            return;
        }
        ArrayList<MultiItemEntity> arrayList2 = this.f5707c;
        if (arrayList2 == null) {
            i.a();
        }
        this.f5709e = new LineTwoAdapter(arrayList2);
        RecyclerView recyclerView3 = (RecyclerView) a().findViewById(R.id.recyclerView);
        i.a((Object) recyclerView3, "mRootView.recyclerView");
        recyclerView3.setAdapter(this.f5709e);
        LineTwoAdapter lineTwoAdapter = this.f5709e;
        if (lineTwoAdapter == null) {
            i.a();
        }
        lineTwoAdapter.expand(0);
    }

    public final void f() {
        c.f6985a.a().e().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new b());
    }

    /* compiled from: LineFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends com.speed.speed_library.a.c<BaseModel<RouteModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
        }

        b() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<RouteModel> baseModel) {
            i.b(baseModel, "response");
            if (!h.f5614a.a(baseModel, true) || baseModel.getData() == null) {
                return;
            }
            ArrayList arrayList = a.this.f5707c;
            if (arrayList != null) {
                arrayList.clear();
            }
            a.this.a(baseModel.getData());
        }
    }

    public final void a(RouteModel routeModel) {
        i.b(routeModel, "RouteModelData");
        if (this.g.equals("vip")) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : routeModel.getRoute_list()) {
                if (((Route) obj).getType() == 0) {
                    arrayList.add(obj);
                }
            }
            this.f = arrayList;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : routeModel.getRoute_list()) {
                if (((Route) obj2).getType() == 1) {
                    arrayList2.add(obj2);
                }
            }
            this.f = arrayList2;
        }
        List<Route> list = this.f;
        if (list != null) {
            if (list == null) {
                i.a();
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : list) {
                if (hashSet.add(((Route) obj3).getGroup_name())) {
                    arrayList3.add(obj3);
                }
            }
            ArrayList arrayList4 = arrayList3;
            int size = arrayList4.size();
            for (int i = 0; i < size; i++) {
                String group_name = ((Route) arrayList4.get(i)).getGroup_name();
                RouteExpandHeaderModel routeExpandHeaderModel = new RouteExpandHeaderModel(group_name);
                List<Route> list2 = this.f;
                if (list2 == null) {
                    i.a();
                }
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    List<Route> list3 = this.f;
                    if (list3 == null) {
                        i.a();
                    }
                    if (i.a((Object) list3.get(i2).getGroup_name(), (Object) group_name)) {
                        List<Route> list4 = this.f;
                        if (list4 == null) {
                            i.a();
                        }
                        Route route = list4.get(i2);
                        routeExpandHeaderModel.addSubItem(new RouteExpandModel(route.getDesc(), route.getFlag_name(), route.getGroup_name(), route.getId(), route.getIp(), route.getLabel(), route.getName(), route.getType(), route.getType_name(), route.getVip_state(), route.getImage_url()));
                    }
                }
                ArrayList<MultiItemEntity> arrayList5 = this.f5707c;
                if (arrayList5 != null) {
                    arrayList5.add(routeExpandHeaderModel);
                }
            }
            AppLog appLog = AppLog.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append("7777");
            ArrayList<MultiItemEntity> arrayList6 = this.f5707c;
            if (arrayList6 == null) {
                i.a();
            }
            sb.append(String.valueOf(arrayList6.size()));
            appLog.d(sb.toString());
            if (this.g.equals("vip")) {
                LineAdapter lineAdapter = this.f5708d;
                if (lineAdapter != null) {
                    lineAdapter.a(true);
                }
                LineAdapter lineAdapter2 = this.f5708d;
                if (lineAdapter2 == null) {
                    i.a();
                }
                lineAdapter2.expand(0);
                LineAdapter lineAdapter3 = this.f5708d;
                if (lineAdapter3 != null) {
                    lineAdapter3.notifyDataSetChanged();
                    return;
                }
                return;
            }
            LineTwoAdapter lineTwoAdapter = this.f5709e;
            if (lineTwoAdapter != null) {
                lineTwoAdapter.a(true);
            }
            LineTwoAdapter lineTwoAdapter2 = this.f5709e;
            if (lineTwoAdapter2 == null) {
                i.a();
            }
            lineTwoAdapter2.expand(0);
            LineTwoAdapter lineTwoAdapter3 = this.f5709e;
            if (lineTwoAdapter3 != null) {
                lineTwoAdapter3.notifyDataSetChanged();
            }
        }
    }
}
