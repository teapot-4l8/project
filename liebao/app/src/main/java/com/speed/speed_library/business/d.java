package com.speed.speed_library.business;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.speed.speed_library.b.g;
import com.speed.speed_library.b.h;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.CommonModel;
import com.speed.speed_library.model.CommonPoint;
import com.speed.speed_library.model.Data;
import com.speed.speed_library.model.PointModel;
import com.speed.speed_library.model.UserModel;
import java.util.ArrayList;
import java.util.Calendar;
import kotlin.d.b.i;
import okhttp3.ab;
import okhttp3.q;
import okhttp3.v;

/* compiled from: PointManager.kt */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f5631a = new d();

    private d() {
    }

    public final void a() {
        b();
        d();
        c();
    }

    public final void b() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append((char) 24180);
        sb.append(calendar.get(2) + 1);
        sb.append((char) 26376);
        sb.append(i2);
        sb.append((char) 26085);
        String sb2 = sb.toString();
        com.speed.speed_library.utils.c.f5860a.c(System.currentTimeMillis() / 1000);
        if (g.f5610b.I() != null) {
            PointModel I = g.f5610b.I();
            if (kotlin.h.g.a(I != null ? I.getDate() : null, sb2, false, 2, (Object) null)) {
                return;
            }
            ab a2 = q.a(v.b("application/json; charset=utf-8"), new Gson().toJson(g.f5610b.I()));
            i.a((Object) a2, "FormBody.create(\n       …ectPoint())\n            )");
            d.a.a.a.a.c.f6985a.a().a(a2).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new b());
        }
    }

    /* compiled from: PointManager.kt */
    /* loaded from: classes2.dex */
    public static final class b extends com.speed.speed_library.a.c<BaseModel<CommonModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
        }

        b() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<CommonModel> baseModel) {
            i.b(baseModel, "response");
            if (h.f5614a.a(baseModel, false)) {
                g.f5610b.J();
            }
        }
    }

    public static /* synthetic */ void a(d dVar, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        dVar.a(i, i2, i3, i4);
    }

    public final void a(int i, int i2, int i3, int i4) {
        Calendar calendar = Calendar.getInstance();
        int i5 = calendar.get(1);
        int i6 = calendar.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(i5);
        sb.append((char) 24180);
        sb.append(calendar.get(2) + 1);
        sb.append((char) 26376);
        sb.append(i6);
        sb.append((char) 26085);
        String sb2 = sb.toString();
        int i7 = 0;
        if (g.f5610b.I() != null) {
            PointModel I = g.f5610b.I();
            if (!kotlin.h.g.a(I != null ? I.getDate() : null, sb2, false, 2, (Object) null)) {
                b();
                return;
            }
        }
        PointModel I2 = g.f5610b.I();
        if (I2 == null) {
            I2 = new PointModel();
        }
        if (I2 == null) {
            i.a();
        }
        I2.setPoint_type(1);
        I2.setLast_time(e.f5632a.a());
        if (e.f5632a.b()) {
            UserModel j = g.f5610b.j();
            Integer valueOf = j != null ? Integer.valueOf(j.getUid()) : null;
            if (valueOf == null) {
                i.a();
            }
            i7 = valueOf.intValue();
        }
        I2.setUid(i7);
        Data data = I2.getData();
        if (data == null) {
            data = new Data();
        }
        if (i != 0) {
            data.setOpen_count(data.getOpen_count() + 1);
        }
        if (i2 != 0) {
            data.setConnect_success(data.getConnect_success() + 1);
        }
        if (i3 != 0) {
            data.setConnect_fail(data.getConnect_fail() + 1);
        }
        if (i4 != 0) {
            data.setConnect_time(i4);
        }
        I2.setData(data);
        I2.setDate(sb2);
        g.f5610b.a(I2);
    }

    public final void c() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append((char) 24180);
        sb.append(calendar.get(2) + 1);
        sb.append((char) 26376);
        sb.append(i2);
        sb.append((char) 26085);
        String sb2 = sb.toString();
        if (g.f5610b.K() != null) {
            PointModel K = g.f5610b.K();
            if (kotlin.h.g.a(K != null ? K.getDate() : null, sb2, false, 2, (Object) null)) {
                return;
            }
            ab a2 = q.a(v.b("application/json; charset=utf-8"), new Gson().toJson(g.f5610b.K()));
            i.a((Object) a2, "FormBody.create(\n       …arePoint())\n            )");
            d.a.a.a.a.c.f6985a.a().a(a2).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new C0140d());
        }
    }

    /* compiled from: PointManager.kt */
    /* renamed from: com.speed.speed_library.business.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0140d extends com.speed.speed_library.a.c<BaseModel<CommonModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
        }

        C0140d() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<CommonModel> baseModel) {
            i.b(baseModel, "response");
            if (h.f5614a.a(baseModel, false)) {
                g.f5610b.L();
            }
        }
    }

    public static /* synthetic */ void a(d dVar, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        dVar.a(i, i2, i3);
    }

    public final void a(int i, int i2, int i3) {
        g.f5610b.K();
        Calendar calendar = Calendar.getInstance();
        int i4 = calendar.get(1);
        int i5 = calendar.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(i4);
        sb.append((char) 24180);
        sb.append(calendar.get(2) + 1);
        sb.append((char) 26376);
        sb.append(i5);
        sb.append((char) 26085);
        String sb2 = sb.toString();
        int i6 = 0;
        if (g.f5610b.K() != null) {
            PointModel K = g.f5610b.K();
            if (!kotlin.h.g.a(K != null ? K.getDate() : null, sb2, false, 2, (Object) null)) {
                b();
                return;
            }
        }
        PointModel K2 = g.f5610b.K();
        if (K2 == null) {
            K2 = new PointModel();
        }
        if (K2 == null) {
            i.a();
        }
        K2.setPoint_type(3);
        K2.setLast_time(e.f5632a.a());
        if (e.f5632a.b()) {
            UserModel j = g.f5610b.j();
            Integer valueOf = j != null ? Integer.valueOf(j.getUid()) : null;
            if (valueOf == null) {
                i.a();
            }
            i6 = valueOf.intValue();
        }
        K2.setUid(i6);
        Data data = K2.getData();
        if (data == null) {
            data = new Data();
        }
        if (i != 0) {
            data.setShare_count(data.getShare_count() + 1);
        }
        if (i2 != 0) {
            data.setLink_count(data.getLink_count() + 1);
        }
        if (i3 != 0) {
            data.setDownload_count(data.getDownload_count() + 1);
        }
        K2.setData(data);
        K2.setDate(sb2);
        g.f5610b.b(K2);
    }

    public final void d() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append((char) 24180);
        sb.append(calendar.get(2) + 1);
        sb.append((char) 26376);
        sb.append(i2);
        sb.append((char) 26085);
        String sb2 = sb.toString();
        if (g.f5610b.O() != null) {
            PointModel O = g.f5610b.O();
            if (kotlin.h.g.a(O != null ? O.getDate() : null, sb2, false, 2, (Object) null)) {
                return;
            }
            ab a2 = q.a(v.b("application/json; charset=utf-8"), new Gson().toJson(g.f5610b.O()));
            i.a((Object) a2, "FormBody.create(\n       …monPoint())\n            )");
            d.a.a.a.a.c.f6985a.a().a(a2).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new c());
        }
    }

    /* compiled from: PointManager.kt */
    /* loaded from: classes2.dex */
    public static final class c extends com.speed.speed_library.a.c<BaseModel<CommonModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
        }

        c() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<CommonModel> baseModel) {
            i.b(baseModel, "response");
            if (h.f5614a.a(baseModel, false)) {
                g.f5610b.N();
                g.f5610b.P();
            }
        }
    }

    public final void a(int i) {
        ArrayList<CommonPoint> arrayList = new ArrayList<>();
        if (g.f5610b.M() != null) {
            arrayList = g.f5610b.M();
            if (arrayList == null) {
                i.a();
            }
            if (arrayList == null) {
                i.a();
            }
            int size = arrayList.size();
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (arrayList.get(i2).getType() == i) {
                    CommonPoint commonPoint = arrayList.get(i2);
                    commonPoint.setCount(commonPoint.getCount() + 1);
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                arrayList.add(new CommonPoint(1, i));
            }
        } else {
            arrayList.add(new CommonPoint(1, i));
        }
        g.f5610b.a(arrayList);
        e();
    }

    public final void e() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append((char) 24180);
        sb.append(calendar.get(2) + 1);
        sb.append((char) 26376);
        sb.append(i2);
        sb.append((char) 26085);
        String sb2 = sb.toString();
        int i3 = 0;
        if (g.f5610b.O() != null) {
            PointModel O = g.f5610b.O();
            if (!kotlin.h.g.a(O != null ? O.getDate() : null, sb2, false, 2, (Object) null)) {
                d();
                return;
            }
        }
        PointModel O2 = g.f5610b.O();
        if (O2 == null) {
            O2 = new PointModel();
        }
        if (O2 == null) {
            i.a();
        }
        O2.setPoint_type(2);
        O2.setLast_time(e.f5632a.a());
        if (e.f5632a.b()) {
            UserModel j = g.f5610b.j();
            Integer valueOf = j != null ? Integer.valueOf(j.getUid()) : null;
            if (valueOf == null) {
                i.a();
            }
            i3 = valueOf.intValue();
        }
        O2.setUid(i3);
        Data data = O2.getData();
        if (data == null) {
            data = new Data();
        }
        O2.setData(data);
        Data data2 = O2.getData();
        if (data2 == null) {
            i.a();
        }
        ArrayList<CommonPoint> M = g.f5610b.M();
        if (M == null) {
            M = new ArrayList<>();
        }
        data2.setList(M);
        O2.setDate(sb2);
        g.f5610b.c(O2);
    }

    public final void a(String str) {
        i.b(str, "ip");
        if (e.f5632a.b() && !TextUtils.isEmpty(str)) {
            d.a.a.a.a.a a2 = d.a.a.a.a.c.f6985a.a();
            UserModel j = g.f5610b.j();
            if (j == null) {
                i.a();
            }
            a2.a(j.getUid(), str).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new a());
        }
    }

    /* compiled from: PointManager.kt */
    /* loaded from: classes2.dex */
    public static final class a extends com.speed.speed_library.a.c<BaseModel<CommonModel>> {
        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<CommonModel> baseModel) {
            i.b(baseModel, "response");
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
        }

        a() {
        }
    }
}
