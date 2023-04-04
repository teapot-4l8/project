package com.speed.speed_library.business;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.fm.openinstall.OpenInstall;
import com.orhanobut.hawk.Hawk;
import com.speed.speed_library.event.BadgeEvent;
import com.speed.speed_library.event.UserInfoEvent;
import com.speed.speed_library.model.BadgeModel;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.BootStrapModel;
import com.speed.speed_library.model.CheckInListModel;
import com.speed.speed_library.model.CommonModel;
import com.speed.speed_library.model.ConfigModel;
import com.speed.speed_library.model.UserModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;
import utils.AppLog;

/* compiled from: Business.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5623a = new a();

    private a() {
    }

    public final void a() {
        d.a.a.a.a.c.f6985a.a().g().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new d());
    }

    /* compiled from: Business.kt */
    /* loaded from: classes2.dex */
    public static final class d extends com.speed.speed_library.a.c<BaseModel<BadgeModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
        }

        d() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<BadgeModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (com.speed.speed_library.b.h.f5614a.a(baseModel, true)) {
                com.speed.speed_library.b.g.f5610b.b(baseModel.getData().getId());
                org.greenrobot.eventbus.c.a().d(new BadgeEvent());
            }
        }
    }

    public final void b() {
        if (com.speed.speed_library.business.e.f5632a.b()) {
            d.a.a.a.a.c.f6985a.a().h().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new g());
        }
    }

    /* compiled from: Business.kt */
    /* loaded from: classes2.dex */
    public static final class g extends com.speed.speed_library.a.c<BaseModel<BadgeModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
        }

        g() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<BadgeModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (com.speed.speed_library.b.h.f5614a.a(baseModel, true)) {
                com.speed.speed_library.b.g.f5610b.c(baseModel.getData().getId());
                org.greenrobot.eventbus.c.a().d(new BadgeEvent());
            }
        }
    }

    public final void c() {
        d.a.a.a.a.c.f6985a.a().d().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new c());
    }

    /* compiled from: Business.kt */
    /* loaded from: classes2.dex */
    public static final class c extends com.speed.speed_library.a.c<BaseModel<BootStrapModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
        }

        c() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<BootStrapModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (!com.speed.speed_library.b.h.f5614a.a(baseModel, false) || baseModel.getData() == null) {
                return;
            }
            if (!TextUtils.isEmpty(baseModel.getData().getImg_url())) {
                com.speed.speed_library.b.g.f5610b.a(baseModel.getData());
                String str = (String) Hawk.get(baseModel.getData().getImg_url(), "");
                if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                    com.bumptech.glide.c.b(com.speed.speed_library.b.g.f5610b.a()).f().a(baseModel.getData().getImg_url()).a((com.bumptech.glide.i<Bitmap>) new C0137a(baseModel));
                    return;
                }
                return;
            }
            com.speed.speed_library.b.g.f5610b.o();
        }

        /* compiled from: Business.kt */
        /* renamed from: com.speed.speed_library.business.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0137a extends com.bumptech.glide.g.a.f<Bitmap> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BaseModel f5624a;

            C0137a(BaseModel baseModel) {
                this.f5624a = baseModel;
            }

            @Override // com.bumptech.glide.g.a.h
            public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.g.b.b bVar) {
                a((Bitmap) obj, (com.bumptech.glide.g.b.b<? super Bitmap>) bVar);
            }

            public void a(Bitmap bitmap, com.bumptech.glide.g.b.b<? super Bitmap> bVar) {
                kotlin.d.b.i.b(bitmap, "resource");
                Hawk.put(((BootStrapModel) this.f5624a.getData()).getImg_url(), com.speed.speed_library.utils.a.f5858a.a(bitmap, Bitmap.CompressFormat.JPEG, 100, new File(com.speed.speed_library.b.g.f5610b.a().getCacheDir(), UUID.randomUUID().toString())));
                AppLog.INSTANCE.i("保存成功");
            }
        }
    }

    public final void d() {
        d.a.a.a.a.c.f6985a.a().f().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new f());
    }

    /* compiled from: Business.kt */
    /* loaded from: classes2.dex */
    public static final class f extends com.speed.speed_library.a.c<BaseModel<ConfigModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
        }

        f() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<ConfigModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (com.speed.speed_library.b.h.f5614a.a(baseModel, false)) {
                com.speed.speed_library.b.g.f5610b.a(baseModel.getData());
                a.f5623a.e();
            }
        }
    }

    public final void e() {
        if (com.speed.speed_library.b.g.f5610b.t() != null) {
            ConfigModel t = com.speed.speed_library.b.g.f5610b.t();
            Integer valueOf = t != null ? Integer.valueOf(t.getRoute_control()) : null;
            if (valueOf != null && valueOf.intValue() == -1) {
                com.speed.speed_library.b.g.f5610b.i(0);
            } else if (valueOf != null && valueOf.intValue() == 2) {
                com.speed.speed_library.b.g.f5610b.i(1);
            } else if (com.speed.speed_library.b.g.f5610b.y() == 0) {
                if (valueOf != null && valueOf.intValue() == 0) {
                    com.speed.speed_library.b.g.f5610b.i(0);
                } else if (valueOf != null && valueOf.intValue() == 1) {
                    com.speed.speed_library.b.g.f5610b.i(1);
                }
            }
        }
    }

    public final void f() {
        if (com.speed.speed_library.business.e.f5632a.b()) {
            return;
        }
        if (TextUtils.isEmpty(com.speed.speed_library.b.g.f5610b.b())) {
            i();
        }
        d.a.a.a.a.c.f6985a.a().a("", "").b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new C0136a());
    }

    /* compiled from: Business.kt */
    /* renamed from: com.speed.speed_library.business.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0136a extends com.speed.speed_library.a.c<BaseModel<UserModel>> {
        C0136a() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<UserModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (com.speed.speed_library.b.h.f5614a.a(baseModel, true)) {
                com.speed.speed_library.b.g.f5610b.a(baseModel.getData());
                org.greenrobot.eventbus.c.a().d(new UserInfoEvent());
            }
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
            com.speed.speed_library.b.h.f5614a.a(th);
        }
    }

    public final void g() {
        if (com.speed.speed_library.business.e.f5632a.b()) {
            d.a.a.a.a.c.f6985a.a().a().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new i());
        }
    }

    /* compiled from: Business.kt */
    /* loaded from: classes2.dex */
    public static final class i extends com.speed.speed_library.a.c<BaseModel<UserModel>> {
        i() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<UserModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (com.speed.speed_library.b.h.f5614a.a(baseModel, true)) {
                if (com.speed.speed_library.business.e.f5632a.b()) {
                    UserModel data = baseModel.getData();
                    UserModel j = com.speed.speed_library.b.g.f5610b.j();
                    String token = j != null ? j.getToken() : null;
                    if (token == null) {
                        kotlin.d.b.i.a();
                    }
                    data.setToken(token);
                }
                com.speed.speed_library.b.g.f5610b.a(baseModel.getData());
                org.greenrobot.eventbus.c.a().d(new UserInfoEvent());
            }
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
            com.speed.speed_library.b.h.f5614a.a(th);
        }
    }

    public final void h() {
        if (com.speed.speed_library.business.e.f5632a.b()) {
            d.a.a.a.a.c.f6985a.a().c().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new e());
        }
    }

    /* compiled from: Business.kt */
    /* loaded from: classes2.dex */
    public static final class e extends com.speed.speed_library.a.c<BaseModel<CheckInListModel>> {
        e() {
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
            com.speed.speed_library.b.h.f5614a.a(th);
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<CheckInListModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (!com.speed.speed_library.b.h.f5614a.a(baseModel, false) || baseModel.getData() == null || baseModel.getData().getCheck_in_list() == null) {
                return;
            }
            ArrayList<Long> check_in_list = baseModel.getData().getCheck_in_list();
            Integer valueOf = check_in_list != null ? Integer.valueOf(check_in_list.size()) : null;
            if (valueOf == null) {
                kotlin.d.b.i.a();
            }
            if (valueOf.intValue() > 0) {
                try {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    com.speed.speed_library.utils.c cVar = com.speed.speed_library.utils.c.f5860a;
                    ArrayList<Long> check_in_list2 = baseModel.getData().getCheck_in_list();
                    if (check_in_list2 == null) {
                        kotlin.d.b.i.a();
                    }
                    Long l = check_in_list2.get(0);
                    kotlin.d.b.i.a((Object) l, "response.data.check_in_list!![0]");
                    String a2 = cVar.a(l.longValue());
                    ArrayList<Long> check_in_list3 = baseModel.getData().getCheck_in_list();
                    if (check_in_list3 == null) {
                        kotlin.d.b.i.a();
                    }
                    Iterator<Long> it = check_in_list3.iterator();
                    while (it.hasNext()) {
                        Long next = it.next();
                        com.speed.speed_library.utils.c cVar2 = com.speed.speed_library.utils.c.f5860a;
                        kotlin.d.b.i.a((Object) next, "item");
                        arrayList.add(Integer.valueOf(Integer.parseInt(cVar2.b(next.longValue()))));
                    }
                    com.speed.speed_library.b.g.f5610b.a(a2, arrayList);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* compiled from: Business.kt */
    /* loaded from: classes2.dex */
    public static final class b extends com.fm.openinstall.a.a {
        b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00bb, code lost:
            if (kotlin.d.b.i.a((java.lang.Object) (r6 != null ? r6.getChannel() : null), (java.lang.Object) "") == false) goto L44;
         */
        @Override // com.fm.openinstall.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(com.fm.openinstall.b.a aVar) {
            kotlin.d.b.i.b(aVar, "appData");
            try {
                com.speed.speed_library.b.g gVar = com.speed.speed_library.b.g.f5610b;
                String b2 = aVar.b();
                kotlin.d.b.i.a((Object) b2, "appData.getData()");
                gVar.c(b2);
                JSONObject jSONObject = new JSONObject(aVar.b());
                if (jSONObject.optString("spread_num") != null) {
                    com.speed.speed_library.b.g gVar2 = com.speed.speed_library.b.g.f5610b;
                    String optString = jSONObject.optString("spread_num");
                    if (optString == null) {
                        throw new kotlin.i("null cannot be cast to non-null type kotlin.String");
                    }
                    gVar2.b(optString);
                }
                if (!TextUtils.isEmpty(com.c.a.a.g.a(com.speed.speed_library.b.g.f5610b.a()))) {
                    com.speed.speed_library.b.g gVar3 = com.speed.speed_library.b.g.f5610b;
                    String a2 = com.c.a.a.g.a(com.speed.speed_library.b.g.f5610b.a());
                    gVar3.a(a2 != null ? a2 : "");
                    return;
                }
                if (jSONObject.optString("channel") != null) {
                    com.speed.speed_library.b.g gVar4 = com.speed.speed_library.b.g.f5610b;
                    String optString2 = jSONObject.optString("channel");
                    if (optString2 == null) {
                        throw new kotlin.i("null cannot be cast to non-null type kotlin.String");
                    }
                    gVar4.a(optString2);
                }
                if (com.speed.speed_library.b.g.f5610b.b() != null && (!kotlin.d.b.i.a((Object) com.speed.speed_library.b.g.f5610b.b(), (Object) "")) && (!kotlin.d.b.i.a((Object) com.speed.speed_library.b.g.f5610b.b(), (Object) "official")) && com.speed.speed_library.b.g.f5610b.j() != null) {
                    UserModel j = com.speed.speed_library.b.g.f5610b.j();
                }
                UserModel j2 = com.speed.speed_library.b.g.f5610b.j();
                if (!kotlin.d.b.i.a((Object) (j2 != null ? j2.getChannel() : null), (Object) "official")) {
                    return;
                }
                a.f5623a.g();
            } catch (Exception unused) {
            }
        }
    }

    public final void i() {
        OpenInstall.getInstall(new b());
    }

    public final void a(String str, int i2) {
        kotlin.d.b.i.b(str, "type_name");
        d.a.a.a.a.c.f6985a.a().b(str, i2).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new h());
    }

    /* compiled from: Business.kt */
    /* loaded from: classes2.dex */
    public static final class h extends com.speed.speed_library.a.c<BaseModel<CommonModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
        }

        h() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<CommonModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            com.speed.speed_library.b.h.f5614a.a(baseModel, false);
        }
    }
}
