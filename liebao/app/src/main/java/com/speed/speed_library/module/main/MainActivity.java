package com.speed.speed_library.module.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.lxj.xpopup.a;
import com.snail.antifake.jni.EmulatorDetectUtil;
import com.speed.speed_library.R;
import com.speed.speed_library.b.f;
import com.speed.speed_library.b.g;
import com.speed.speed_library.b.h;
import com.speed.speed_library.event.BadgeEvent;
import com.speed.speed_library.event.BuyTypeEvent;
import com.speed.speed_library.model.ActivityInfo;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.BootStrapModel;
import com.speed.speed_library.model.ConfigModel;
import com.speed.speed_library.model.HideDialogEvent;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.utils.DeviceUtils;
import java.util.HashMap;
import kotlin.d.b.i;
import ml.w568w.checkxposed.util.NativeDetect;
import ml.w568w.library.XposedDetect;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

/* compiled from: MainActivity.kt */
/* loaded from: classes.dex */
public final class MainActivity extends com.speed.speed_library.a.a implements CompoundButton.OnCheckedChangeListener {
    public j k;
    private final String l = "home";
    private final String m = "store";
    private final String n = "me";
    private com.lxj.xpopup.b.d o;
    private androidx.fragment.app.d p;

    /* renamed from: q  reason: collision with root package name */
    private androidx.fragment.app.d f5723q;
    private androidx.fragment.app.d r;
    private androidx.fragment.app.d s;
    private q.rorbin.badgeview.a t;
    private HashMap u;

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.u == null) {
            this.u = new HashMap();
        }
        View view = (View) this.u.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.u.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mainn);
        n();
        l();
        a(bundle);
        m();
        o();
        com.speed.speed_library.business.update.fullupdate.a.f5646b.a(this, false);
        com.speed.speed_library.business.a.f5623a.a();
        com.speed.speed_library.business.a.f5623a.b();
        com.speed.speed_library.business.a.f5623a.g();
        com.speed.speed_library.business.d.a(com.speed.speed_library.business.d.f5631a, 1, 0, 0, 0, 14, null);
    }

    public final void l() {
        j j = j();
        i.a((Object) j, "supportFragmentManager");
        this.k = j;
        q.rorbin.badgeview.a a2 = new q.rorbin.badgeview.e(this).a(d(R.id.ll_view));
        i.a((Object) a2, "QBadgeView(this).bindTarget(ll_view)");
        this.t = a2;
        if (a2 == null) {
            i.b("mMenuBadge");
        }
        a2.b(49);
    }

    public final void m() {
        MainActivity mainActivity = this;
        ((RadioButton) d(R.id.tab_home_btn)).setOnCheckedChangeListener(mainActivity);
        ((RadioButton) d(R.id.tab_store_btn)).setOnCheckedChangeListener(mainActivity);
        ((RadioButton) d(R.id.tab_my_btn)).setOnCheckedChangeListener(mainActivity);
    }

    private final void a(Bundle bundle) {
        if (bundle != null) {
            try {
                j jVar = this.k;
                if (jVar == null) {
                    i.b("mFragmentManager");
                }
                androidx.fragment.app.d a2 = jVar.a(this.l);
                this.p = a2;
                this.s = a2;
                j jVar2 = this.k;
                if (jVar2 == null) {
                    i.b("mFragmentManager");
                }
                this.r = jVar2.a(this.n);
                j jVar3 = this.k;
                if (jVar3 == null) {
                    i.b("mFragmentManager");
                }
                this.f5723q = jVar3.a(this.m);
                if (this.s == null) {
                    com.speed.speed_library.module.main.b a3 = com.speed.speed_library.module.main.b.f5738d.a();
                    this.p = a3;
                    this.s = a3;
                }
                if (this.f5723q == null) {
                    this.f5723q = com.speed.speed_library.module.webview.b.f5819b.a(com.speed.speed_library.b.b.f5592a.a("vip"));
                }
                if (this.r == null) {
                    this.r = com.speed.speed_library.module.main.a.f5734b.a();
                }
                j jVar4 = this.k;
                if (jVar4 == null) {
                    i.b("mFragmentManager");
                }
                p a4 = jVar4 != null ? jVar4.a() : null;
                androidx.fragment.app.d dVar = this.p;
                if (dVar == null) {
                    i.a();
                }
                p b2 = a4.b(dVar);
                androidx.fragment.app.d dVar2 = this.f5723q;
                if (dVar2 == null) {
                    i.a();
                }
                p b3 = b2.b(dVar2);
                androidx.fragment.app.d dVar3 = this.r;
                if (dVar3 == null) {
                    i.a();
                }
                p b4 = b3.b(dVar3);
                androidx.fragment.app.d dVar4 = this.s;
                if (dVar4 == null) {
                    i.a();
                }
                b4.c(dVar4).c();
                return;
            } catch (Exception unused) {
                return;
            }
        }
        com.speed.speed_library.module.main.b a5 = com.speed.speed_library.module.main.b.f5738d.a();
        this.p = a5;
        this.s = a5;
        this.f5723q = com.speed.speed_library.module.webview.b.f5819b.a(com.speed.speed_library.b.b.f5592a.a("vip"));
        this.r = com.speed.speed_library.module.main.a.f5734b.a();
        j jVar5 = this.k;
        if (jVar5 == null) {
            i.b("mFragmentManager");
        }
        p a6 = jVar5.a();
        i.a((Object) a6, "mFragmentManager.beginTransaction()");
        int i = R.id.fragments;
        androidx.fragment.app.d dVar5 = this.p;
        if (dVar5 == null) {
            i.a();
        }
        a6.a(i, dVar5, this.l).c();
    }

    public final void a(androidx.fragment.app.d dVar, String str) {
        i.b(dVar, "fragment");
        if (dVar == this.s) {
            return;
        }
        j jVar = this.k;
        if (jVar == null) {
            i.b("mFragmentManager");
        }
        p a2 = jVar.a();
        i.a((Object) a2, "mFragmentManager.beginTransaction()");
        j jVar2 = this.k;
        if (jVar2 == null) {
            i.b("mFragmentManager");
        }
        jVar2.b();
        if (!dVar.isAdded()) {
            androidx.fragment.app.d dVar2 = this.s;
            if (dVar2 == null) {
                i.a();
            }
            a2.b(dVar2).a(R.id.fragments, dVar, str).c(dVar).c();
        } else {
            androidx.fragment.app.d dVar3 = this.s;
            if (dVar3 == null) {
                i.a();
            }
            a2.b(dVar3).c(dVar).c();
        }
        this.s = dVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            if (compoundButton == null) {
                i.a();
            }
            int id = compoundButton.getId();
            if (id == R.id.tab_home_btn) {
                androidx.fragment.app.d dVar = this.p;
                if (dVar == null) {
                    i.a();
                }
                a(dVar, this.l);
            } else if (id == R.id.tab_store_btn) {
                if (this.f5723q == null) {
                    this.f5723q = com.speed.speed_library.module.webview.b.f5819b.a(com.speed.speed_library.b.b.f5592a.a("vip"));
                }
                androidx.fragment.app.d dVar2 = this.f5723q;
                if (dVar2 == null) {
                    i.a();
                }
                a(dVar2, this.m);
            } else if (id == R.id.tab_my_btn) {
                androidx.fragment.app.d dVar3 = this.r;
                if (dVar3 == null) {
                    i.a();
                }
                a(dVar3, this.n);
            }
        }
    }

    public final void n() {
        int i;
        if (DeviceUtils.a()) {
            f.a(getResources().getString(R.string.toast_app_fail) + ",", 0, 2, null);
            finish();
            System.exit(0);
        } else if (EmulatorDetectUtil.a(this)) {
            f.a(getResources().getString(R.string.toast_app_fail) + ".", 0, 2, null);
            finish();
            System.exit(0);
        } else if (DeviceUtils.AntiRoot().equals("yes")) {
            f.a(getResources().getString(R.string.toast_app_fail) + "!", 0, 2, null);
            finish();
            System.exit(0);
        } else if (XposedDetect.a(getPackageManager()).a()) {
            f.a(getResources().getString(R.string.toast_app_fail) + ":", 0, 2, null);
            finish();
            System.exit(0);
        } else if (NativeDetect.detectXposed(Process.myPid())) {
            f.a(getResources().getString(R.string.toast_app_fail) + ";", 0, 2, null);
            finish();
            System.exit(0);
        } else {
            PackageManager packageManager = g.f5610b.a().getPackageManager();
            i.a((Object) packageManager, "Global.context.getPackageManager()");
            try {
                String packageName = getPackageName();
                if (packageName == null) {
                    i.a();
                }
                Signature[] signatureArr = packageManager.getPackageInfo(packageName, 64).signatures;
                i.a((Object) signatureArr, "packageInfo.signatures");
                i = signatureArr[0].hashCode();
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                i = 0;
            }
            if (i != com.speed.speed_library.b.d.f5595a.c()) {
                f.a(getResources().getString(R.string.toast_app_fail) + "!!", 0, 2, null);
                finish();
                System.exit(0);
            }
        }
    }

    public final void o() {
        if (getIntent() == null || getIntent().getStringExtra(com.speed.speed_library.b.d.f5595a.g()) == null) {
            return;
        }
        getIntent().getIntExtra(com.speed.speed_library.b.d.f5595a.h(), 1);
        String stringExtra = getIntent().getStringExtra(com.speed.speed_library.b.d.f5595a.g());
        i.a((Object) stringExtra, "intent.getStringExtra(Co…nt.INTENT_KEY_ADVERT_URL)");
        int intExtra = getIntent().getIntExtra(com.speed.speed_library.b.d.f5595a.h(), 1);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        com.speed.speed_library.business.a aVar = com.speed.speed_library.business.a.f5623a;
        String T = com.speed.speed_library.b.d.f5595a.T();
        BootStrapModel n = g.f5610b.n();
        if (n == null) {
            i.a();
        }
        aVar.a(T, n.getId());
        if (intExtra == 1) {
            com.speed.speed_library.utils.f.f5870a.a(this, stringExtra);
        } else {
            com.speed.speed_library.b.c.f5594a.a(this, stringExtra, "");
        }
    }

    public final void p() {
        d.a.a.a.a.c.f6985a.a().f().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new b());
    }

    /* compiled from: MainActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends com.speed.speed_library.a.c<BaseModel<ConfigModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
        }

        b() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<ConfigModel> baseModel) {
            i.b(baseModel, "response");
            if (!h.f5614a.a(baseModel, false) || baseModel.getData() == null || baseModel.getData().getActivity_info() == null) {
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            ActivityInfo activity_info = baseModel.getData().getActivity_info();
            if (activity_info == null) {
                i.a();
            }
            mainActivity.a(activity_info);
        }
    }

    public final void a(ActivityInfo activityInfo) {
        i.b(activityInfo, "activityInfoModel");
        try {
            if (g.f5610b.z()) {
                return;
            }
            if (!TextUtils.isEmpty(activityInfo.getImage_url()) && !isFinishing()) {
                i.a((Object) com.bumptech.glide.c.a((androidx.fragment.app.e) this).f().a(activityInfo.getImage_url()).a((com.bumptech.glide.i<Bitmap>) new c(activityInfo)), "Glide.with(this@MainActi… }\n                    })");
            } else if (!TextUtils.isEmpty(activityInfo.getDesc()) && !isFinishing()) {
                com.speed.speed_library.widget.a.d dVar = new com.speed.speed_library.widget.a.d(this);
                dVar.setCanceledOnTouchOutside(true);
                dVar.a(activityInfo.getTitle());
                dVar.b(activityInfo.getDesc());
                dVar.c(activityInfo.getBtn_title());
                dVar.b();
                dVar.a(new d(activityInfo, dVar));
                dVar.setOnCancelListener(new e(dVar));
                dVar.show();
                g.f5610b.k(activityInfo.getExpire_time());
            }
        } catch (Exception unused) {
        }
    }

    /* compiled from: MainActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends com.bumptech.glide.g.a.f<Bitmap> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ActivityInfo f5727b;

        c(ActivityInfo activityInfo) {
            this.f5727b = activityInfo;
        }

        @Override // com.bumptech.glide.g.a.h
        public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.g.b.b bVar) {
            a((Bitmap) obj, (com.bumptech.glide.g.b.b<? super Bitmap>) bVar);
        }

        public void a(Bitmap bitmap, com.bumptech.glide.g.b.b<? super Bitmap> bVar) {
            i.b(bitmap, "resource");
            MainActivity mainActivity = MainActivity.this;
            if (mainActivity == null || mainActivity.isFinishing()) {
                return;
            }
            com.speed.speed_library.widget.a.a aVar = new com.speed.speed_library.widget.a.a(MainActivity.this);
            aVar.setCanceledOnTouchOutside(true);
            aVar.a(new a(aVar));
            androidx.core.graphics.drawable.b a2 = androidx.core.graphics.drawable.d.a(g.f5610b.a().getResources(), bitmap);
            i.a((Object) a2, "RoundedBitmapDrawableFac…                        )");
            a2.a(30);
            aVar.a(a2);
            aVar.show();
            g.f5610b.k(this.f5727b.getExpire_time());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MainActivity.kt */
        /* loaded from: classes2.dex */
        public static final class a implements View.OnClickListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ com.speed.speed_library.widget.a.a f5729b;

            a(com.speed.speed_library.widget.a.a aVar) {
                this.f5729b = aVar;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!TextUtils.isEmpty(c.this.f5727b.getLink_url())) {
                    if (c.this.f5727b.getSkip_type() == 1) {
                        com.speed.speed_library.utils.f.f5870a.a(MainActivity.this, c.this.f5727b.getLink_url());
                    } else {
                        com.speed.speed_library.b.c.f5594a.a(MainActivity.this, c.this.f5727b.getLink_url(), "");
                    }
                }
                com.speed.speed_library.widget.a.a aVar = this.f5729b;
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ActivityInfo f5731b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.speed.speed_library.widget.a.d f5732c;

        d(ActivityInfo activityInfo, com.speed.speed_library.widget.a.d dVar) {
            this.f5731b = activityInfo;
            this.f5732c = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!TextUtils.isEmpty(this.f5731b.getLink_url())) {
                if (this.f5731b.getSkip_type() == 1) {
                    com.speed.speed_library.utils.f.f5870a.a(MainActivity.this, this.f5731b.getLink_url());
                } else {
                    com.speed.speed_library.b.c.f5594a.a(MainActivity.this, this.f5731b.getLink_url(), "");
                }
            }
            com.speed.speed_library.widget.a.d dVar = this.f5732c;
            if (dVar != null) {
                dVar.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.speed.speed_library.widget.a.d f5733a;

        e(com.speed.speed_library.widget.a.d dVar) {
            this.f5733a = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.f5733a.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        androidx.fragment.app.d a2 = j().a(this.l);
        if (a2 == null) {
            i.a();
        }
        a2.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
        if (r0.intValue() > com.speed.speed_library.b.g.f5610b.w()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q() {
        if (g.f5610b.f() <= g.f5610b.u() && g.f5610b.d() <= com.speed.speed_library.utils.e.b(g.f5610b.a())) {
            if (com.speed.speed_library.business.e.f5632a.b()) {
                UserModel j = g.f5610b.j();
                Integer valueOf = j != null ? Integer.valueOf(j.getSpread_count()) : null;
                if (valueOf == null) {
                    i.a();
                }
            }
            q.rorbin.badgeview.a aVar = this.t;
            if (aVar == null) {
                i.b("mMenuBadge");
            }
            aVar.a(0);
            return;
        }
        q.rorbin.badgeview.a aVar2 = this.t;
        if (aVar2 == null) {
            i.b("mMenuBadge");
        }
        aVar2.a(-1);
    }

    @m(a = ThreadMode.MAIN)
    public final void badgeEvent(BadgeEvent badgeEvent) {
        i.b(badgeEvent, "event");
        q();
    }

    /* compiled from: MainActivity.kt */
    /* loaded from: classes2.dex */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((RadioButton) MainActivity.this.d(R.id.tab_store_btn)).performClick();
        }
    }

    @m(a = ThreadMode.MAIN)
    public final void buyTypeEventEvent(BuyTypeEvent buyTypeEvent) {
        i.b(buyTypeEvent, "event");
        new Handler().postDelayed(new a(), 200L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        com.speed.speed_library.business.a.f5623a.i();
        com.speed.speed_library.business.a.f5623a.h();
        com.speed.speed_library.business.d.f5631a.a();
        p();
        r();
    }

    public final void r() {
        if (!com.speed.speed_library.business.e.f5632a.b()) {
            com.speed.speed_library.business.a.f5623a.f();
        } else if (g.f5610b.A()) {
        } else {
            UserModel j = g.f5610b.j();
            if ((j != null ? Integer.valueOf(j.getCoupon_count()) : null) != null) {
                UserModel j2 = g.f5610b.j();
                Integer valueOf = j2 != null ? Integer.valueOf(j2.getCoupon_count()) : null;
                if (valueOf == null) {
                    i.a();
                }
                if (valueOf.intValue() <= 0 || isFinishing()) {
                    return;
                }
                MainActivity mainActivity = this;
                this.o = (com.lxj.xpopup.b.d) new a.C0125a(mainActivity).b(false).a(new com.speed.speed_library.module.a.a(mainActivity)).f();
                g gVar = g.f5610b;
                ConfigModel t = g.f5610b.t();
                gVar.l(t != null ? t.getCoupon_show_interval_time() : 4);
            }
        }
    }

    @m(a = ThreadMode.MAIN)
    public final void hideDialogEvent(HideDialogEvent hideDialogEvent) {
        i.b(hideDialogEvent, "event");
        com.lxj.xpopup.b.d dVar = this.o;
        if (dVar != null) {
            if (dVar == null) {
                i.a();
            }
            if (dVar.isShown()) {
                com.lxj.xpopup.b.d dVar2 = this.o;
                if (dVar2 == null) {
                    i.a();
                }
                dVar2.n();
            }
        }
    }
}
