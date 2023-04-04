package com.speed.speed_library.module.main;

import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.speed.speed_library.R;
import com.speed.speed_library.a;
import com.speed.speed_library.b;
import com.speed.speed_library.event.BuyTypeEvent;
import com.speed.speed_library.event.LogoutEvent;
import com.speed.speed_library.event.RouteEvent;
import com.speed.speed_library.event.SceneSelectsEvent;
import com.speed.speed_library.event.UserInfoEvent;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.ConfigModel;
import com.speed.speed_library.model.Marquee;
import com.speed.speed_library.model.MarqueeModel;
import com.speed.speed_library.model.Route;
import com.speed.speed_library.model.RouteInfoModel;
import com.speed.speed_library.model.RouteModel;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.module.line.LineActivity;
import com.speed.speed_library.module.login.LoginActivity;
import com.speed.speed_library.speed.WireGuardService;
import com.speed.speed_library.speed.b;
import com.speed.speed_library.utils.g;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
import utils.AppLog;

/* compiled from: SpeedFragment.kt */
/* loaded from: classes.dex */
public final class b extends com.speed.speed_library.a.b implements IBinder.DeathRecipient, View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    public static final a f5738d = new a(null);

    /* renamed from: b  reason: collision with root package name */
    public Activity f5739b;

    /* renamed from: c  reason: collision with root package name */
    public Animation f5740c;
    private IBinder f;
    private com.speed.speed_library.a g;
    private int j;
    private int k;
    private Route m;
    private q.rorbin.badgeview.a r;
    private boolean s;
    private boolean t;
    private HashMap x;

    /* renamed from: e  reason: collision with root package name */
    private com.speed.speed_library.speed.b f5741e = new com.speed.speed_library.speed.b();
    private int h = 4;
    private int i = 4;
    private String l = "";
    private C0148b n = new C0148b();
    private String o = "";
    private String p = "";

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<Marquee> f5742q = new ArrayList<>();
    private ArrayList<Marquee> u = new ArrayList<>();
    private ServiceConnection v = new p();
    private b.a w = new o();

    /* compiled from: SpeedFragment.kt */
    /* renamed from: com.speed.speed_library.module.main.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0148b {

        /* renamed from: a  reason: collision with root package name */
        private Integer f5743a = 4;

        /* renamed from: b  reason: collision with root package name */
        private String f5744b = "";
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public View a(int i2) {
        if (this.x == null) {
            this.x = new HashMap();
        }
        View view = (View) this.x.get(Integer.valueOf(i2));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i2);
            this.x.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public void c() {
        HashMap hashMap = this.x;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d, androidx.fragment.app.d
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    public final int e() {
        return this.j;
    }

    public final void b(int i2) {
        this.k = i2;
    }

    public final void a(ArrayList<Marquee> arrayList) {
        kotlin.d.b.i.b(arrayList, "<set-?>");
        this.f5742q = arrayList;
    }

    public final ArrayList<Marquee> f() {
        return this.f5742q;
    }

    public final void a(boolean z) {
        this.s = z;
    }

    public final boolean g() {
        return this.s;
    }

    public final void b(boolean z) {
        this.t = z;
    }

    public final boolean h() {
        return this.t;
    }

    public final void b(ArrayList<Marquee> arrayList) {
        kotlin.d.b.i.b(arrayList, "<set-?>");
        this.u = arrayList;
    }

    public final ArrayList<Marquee> i() {
        return this.u;
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.d.b.g gVar) {
            this();
        }

        public final b a() {
            Bundle bundle = new Bundle();
            b bVar = new b();
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.speed.speed_library.utils.h hVar = com.speed.speed_library.utils.h.f5876a;
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
            kotlin.d.b.i.a();
        }
        kotlin.d.b.i.a((Object) activity, "this.activity!!");
        hVar.a(activity, getResources().getColor(R.color.colorGrayTwo), true);
        org.greenrobot.eventbus.c.a().a(this);
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 == null) {
            throw new kotlin.i("null cannot be cast to non-null type android.app.Activity");
        }
        this.f5739b = activity2;
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.d.b.i.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_speed, viewGroup, false);
        kotlin.d.b.i.a((Object) inflate, "inflater.inflate(R.layou…_speed, container, false)");
        a(inflate);
        j();
        n();
        t();
        z();
        s();
        p();
        k();
        return a();
    }

    public final void j() {
        TextView textView = (TextView) a().findViewById(R.id.headerbar_title);
        kotlin.d.b.i.a((Object) textView, "mRootView.headerbar_title");
        textView.setText("猎豹加速器");
        LinearLayout linearLayout = (LinearLayout) a().findViewById(R.id.ll_back);
        kotlin.d.b.i.a((Object) linearLayout, "mRootView.ll_back");
        linearLayout.setVisibility(8);
        ((RelativeLayout) a().findViewById(R.id.headerbar)).setBackgroundColor(getResources().getColor(R.color.colorGrayTwo));
        LinearLayout linearLayout2 = (LinearLayout) a().findViewById(R.id.ll_right);
        kotlin.d.b.i.a((Object) linearLayout2, "mRootView.ll_right");
        linearLayout2.setVisibility(0);
        ((ImageView) a().findViewById(R.id.iv_right)).setImageResource(R.mipmap.ic_home_notice);
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_rotate);
        kotlin.d.b.i.a((Object) loadAnimation, "AnimationUtils.loadAnima…vity, R.anim.anim_rotate)");
        this.f5740c = loadAnimation;
        if (loadAnimation == null) {
            kotlin.d.b.i.b("rotationAnim");
        }
        loadAnimation.setInterpolator(new LinearInterpolator());
        q.rorbin.badgeview.a a2 = new q.rorbin.badgeview.e(getActivity()).a((ImageView) a().findViewById(R.id.iv_right));
        kotlin.d.b.i.a((Object) a2, "QBadgeView(this.activity…arget(mRootView.iv_right)");
        this.r = a2;
    }

    public final void k() {
        ConfigModel t2;
        if (com.speed.speed_library.b.g.f5610b.t() != null && (t2 = com.speed.speed_library.b.g.f5610b.t()) != null && t2.is_use_admob_banner() == 1) {
            RelativeLayout relativeLayout = (RelativeLayout) a().findViewById(R.id.rl_banner);
            kotlin.d.b.i.a((Object) relativeLayout, "mRootView.rl_banner");
            relativeLayout.setVisibility(8);
            ((AdView) a().findViewById(R.id.adView)).loadAd(new AdRequest.Builder().build());
            AdView adView = (AdView) a().findViewById(R.id.adView);
            kotlin.d.b.i.a((Object) adView, "mRootView.adView");
            adView.setAdListener(new e());
            return;
        }
        AdView adView2 = (AdView) a().findViewById(R.id.adView);
        kotlin.d.b.i.a((Object) adView2, "mRootView.adView");
        adView2.setVisibility(8);
        l();
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends AdListener {
        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzve
        public void onAdClicked() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            kotlin.d.b.i.b(loadAdError, "adError");
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLeftApplication() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
        }

        e() {
        }
    }

    public final void l() {
        d.a.a.a.a.c.f6985a.a().a(0).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(d()).a(new q());
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class q extends com.speed.speed_library.a.c<BaseModel<MarqueeModel>> {
        q() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<MarqueeModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (!com.speed.speed_library.b.h.f5614a.a(baseModel, false) || baseModel.getData() == null || baseModel.getData().getList().size() == 0) {
                return;
            }
            View findViewById = b.this.a().findViewById(R.id.bannertwo);
            kotlin.d.b.i.a((Object) findViewById, "mRootView.findViewById(R.id.bannertwo)");
            ((ImageView) b.this.a().findViewById(R.id.iv_banner_close)).setOnClickListener(new a());
            b.this.i().clear();
            b.this.b(baseModel.getData().getList());
            ((Banner) findViewById).setAdapter(new C0150b(b.this.i())).addBannerLifecycleObserver(b.this).setIndicator(new CircleIndicator(b.this.getActivity()));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SpeedFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RelativeLayout relativeLayout = (RelativeLayout) b.this.a().findViewById(R.id.rl_banner);
                kotlin.d.b.i.a((Object) relativeLayout, "mRootView.rl_banner");
                relativeLayout.setVisibility(8);
            }
        }

        /* compiled from: SpeedFragment.kt */
        /* renamed from: com.speed.speed_library.module.main.b$q$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0150b extends BannerImageAdapter<Marquee> {
            C0150b(List list) {
                super(list);
            }

            @Override // com.youth.banner.holder.IViewHolder
            /* renamed from: a */
            public void onBindView(BannerImageHolder bannerImageHolder, Marquee marquee, int i, int i2) {
                kotlin.d.b.i.b(bannerImageHolder, "holder");
                kotlin.d.b.i.b(marquee, JThirdPlatFormInterface.KEY_DATA);
                androidx.fragment.app.e activity = b.this.getActivity();
                if (activity == null) {
                    kotlin.d.b.i.a();
                }
                com.bumptech.glide.c.a(activity).f().a(marquee.getImg_url()).a((com.bumptech.glide.i<Bitmap>) new a(bannerImageHolder, marquee));
            }

            /* compiled from: SpeedFragment.kt */
            /* renamed from: com.speed.speed_library.module.main.b$q$b$a */
            /* loaded from: classes2.dex */
            public static final class a extends com.bumptech.glide.g.a.f<Bitmap> {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ BannerImageHolder f5773b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ Marquee f5774c;

                a(BannerImageHolder bannerImageHolder, Marquee marquee) {
                    this.f5773b = bannerImageHolder;
                    this.f5774c = marquee;
                }

                @Override // com.bumptech.glide.g.a.h
                public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.g.b.b bVar) {
                    a((Bitmap) obj, (com.bumptech.glide.g.b.b<? super Bitmap>) bVar);
                }

                public void a(Bitmap bitmap, com.bumptech.glide.g.b.b<? super Bitmap> bVar) {
                    kotlin.d.b.i.b(bitmap, "resource");
                    if (b.this.getActivity() != null) {
                        androidx.fragment.app.e activity = b.this.getActivity();
                        if (activity == null) {
                            kotlin.d.b.i.a();
                        }
                        kotlin.d.b.i.a((Object) activity, "this@SpeedFragment.activity!!");
                        if (activity.isFinishing()) {
                            return;
                        }
                        AppLog.INSTANCE.d("33333333333");
                        RelativeLayout relativeLayout = (RelativeLayout) b.this.a().findViewById(R.id.rl_banner);
                        kotlin.d.b.i.a((Object) relativeLayout, "mRootView.rl_banner");
                        relativeLayout.setVisibility(0);
                        ImageView imageView = (ImageView) b.this.a().findViewById(R.id.iv_banner_close);
                        kotlin.d.b.i.a((Object) imageView, "mRootView.iv_banner_close");
                        imageView.setVisibility(0);
                        this.f5773b.imageView.setImageBitmap(bitmap);
                        this.f5773b.imageView.setOnClickListener(new View$OnClickListenerC0151a());
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: SpeedFragment.kt */
                /* renamed from: com.speed.speed_library.module.main.b$q$b$a$a  reason: collision with other inner class name */
                /* loaded from: classes2.dex */
                public static final class View$OnClickListenerC0151a implements View.OnClickListener {
                    View$OnClickListenerC0151a() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        com.speed.speed_library.business.a.f5623a.a(com.speed.speed_library.b.d.f5595a.U(), a.this.f5774c.getId());
                        if (a.this.f5774c.getLink_url().length() > 0) {
                            if (a.this.f5774c.getSkip_type() == 1) {
                                com.speed.speed_library.utils.f fVar = com.speed.speed_library.utils.f.f5870a;
                                androidx.fragment.app.e activity = b.this.getActivity();
                                if (activity == null) {
                                    kotlin.d.b.i.a();
                                }
                                kotlin.d.b.i.a((Object) activity, "this@SpeedFragment.activity!!");
                                fVar.a(activity, a.this.f5774c.getLink_url());
                                return;
                            }
                            com.speed.speed_library.b.c cVar = com.speed.speed_library.b.c.f5594a;
                            androidx.fragment.app.e activity2 = b.this.getActivity();
                            if (activity2 == null) {
                                kotlin.d.b.i.a();
                            }
                            kotlin.d.b.i.a((Object) activity2, "this@SpeedFragment.activity!!");
                            cVar.a(activity2, a.this.f5774c.getLink_url(), "");
                        }
                    }
                }

                @Override // com.bumptech.glide.g.a.a, com.bumptech.glide.g.a.h
                public void c(Drawable drawable) {
                    super.c(drawable);
                    AppLog.INSTANCE.d("44444444444");
                    RelativeLayout relativeLayout = (RelativeLayout) b.this.a().findViewById(R.id.rl_banner);
                    kotlin.d.b.i.a((Object) relativeLayout, "mRootView.rl_banner");
                    relativeLayout.setVisibility(8);
                    ImageView imageView = (ImageView) b.this.a().findViewById(R.id.iv_banner_close);
                    kotlin.d.b.i.a((Object) imageView, "mRootView.iv_banner_close");
                    imageView.setVisibility(8);
                }
            }
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
            com.speed.speed_library.b.h.f5614a.a(th);
        }
    }

    public final void m() {
        com.speed.speed_library.a aVar;
        if (com.speed.speed_library.b.g.f5610b.e() > com.speed.speed_library.b.g.f5610b.v()) {
            q.rorbin.badgeview.a aVar2 = this.r;
            if (aVar2 == null) {
                kotlin.d.b.i.b("mNoticeBadge");
            }
            aVar2.a(-1);
        } else {
            q.rorbin.badgeview.a aVar3 = this.r;
            if (aVar3 == null) {
                kotlin.d.b.i.b("mNoticeBadge");
            }
            aVar3.a(0);
        }
        try {
            if (!com.speed.speed_library.business.e.f5632a.b() || this.g == null || (aVar = this.g) == null || aVar.a() != 2 || this.m == null) {
                return;
            }
            com.speed.speed_library.b.g gVar = com.speed.speed_library.b.g.f5610b;
            Route route = this.m;
            if (route == null) {
                kotlin.d.b.i.a();
            }
            if (gVar.e(route.getId()) != null) {
                com.speed.speed_library.b.g gVar2 = com.speed.speed_library.b.g.f5610b;
                Route route2 = this.m;
                if (route2 == null) {
                    kotlin.d.b.i.a();
                }
                RouteInfoModel e2 = gVar2.e(route2.getId());
                Route route3 = this.m;
                if (route3 != null && route3.getVip_state() == 0) {
                    Long valueOf = e2 != null ? Long.valueOf(e2.getTs()) : null;
                    if (valueOf == null) {
                        kotlin.d.b.i.a();
                    }
                    if (valueOf.longValue() < com.speed.speed_library.business.e.f5632a.a()) {
                        com.speed.speed_library.a aVar4 = this.g;
                        if (aVar4 != null) {
                            aVar4.b();
                        }
                        com.speed.speed_library.b.f.a("当前连接已失效，请重新连接", 0, 2, null);
                        return;
                    }
                    return;
                }
                Route route4 = this.m;
                if (route4 != null && route4.getType() == 0) {
                    Long valueOf2 = e2 != null ? Long.valueOf(e2.getTs()) : null;
                    if (valueOf2 == null) {
                        kotlin.d.b.i.a();
                    }
                    if (valueOf2.longValue() < com.speed.speed_library.business.e.f5632a.a() || com.speed.speed_library.business.e.f5632a.c()) {
                        com.speed.speed_library.b.f.a("您的服务时间已到期，请充值", 0, 2, null);
                        com.speed.speed_library.a aVar5 = this.g;
                        if (aVar5 != null) {
                            aVar5.b();
                        }
                    }
                }
                Route route5 = this.m;
                if (route5 == null || route5.getType() != 1) {
                    return;
                }
                Long valueOf3 = e2 != null ? Long.valueOf(e2.getTs()) : null;
                if (valueOf3 == null) {
                    kotlin.d.b.i.a();
                }
                if (valueOf3.longValue() < com.speed.speed_library.business.e.f5632a.a() || com.speed.speed_library.business.e.f5632a.d()) {
                    com.speed.speed_library.b.f.a("您的高级SVIP服务时间已到期，请充值", 0, 2, null);
                    com.speed.speed_library.a aVar6 = this.g;
                    if (aVar6 != null) {
                        aVar6.b();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void n() {
        b bVar = this;
        ((LinearLayout) a().findViewById(R.id.ll_route)).setOnClickListener(bVar);
        ((RelativeLayout) a().findViewById(R.id.view_speed_progress)).setOnClickListener(bVar);
        ((LinearLayout) a().findViewById(R.id.ll_right)).setOnClickListener(bVar);
        ((LinearLayout) a().findViewById(R.id.ll_back)).setOnClickListener(bVar);
        ((MarqueeView) a().findViewById(R.id.view_marqueeView)).setOnItemClickListener(new f());
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f implements MarqueeView.a {
        f() {
        }

        @Override // com.sunfusheng.marqueeview.MarqueeView.a
        public void a(int i, TextView textView) {
            if (b.this.f().size() <= i || b.this.f().get(i) == null || TextUtils.isEmpty(b.this.f().get(i).getLink_url()) || b.this.getActivity() == null) {
                return;
            }
            androidx.fragment.app.e activity = b.this.getActivity();
            if (activity == null) {
                kotlin.d.b.i.a();
            }
            kotlin.d.b.i.a((Object) activity, "this@SpeedFragment.activity!!");
            if (activity.isFinishing()) {
                return;
            }
            if (b.this.f().get(i).getSkip_type() == 1) {
                com.speed.speed_library.utils.f fVar = com.speed.speed_library.utils.f.f5870a;
                androidx.fragment.app.e activity2 = b.this.getActivity();
                if (activity2 == null) {
                    kotlin.d.b.i.a();
                }
                kotlin.d.b.i.a((Object) activity2, "this@SpeedFragment.activity!!");
                fVar.a(activity2, b.this.f().get(i).getLink_url());
                return;
            }
            com.speed.speed_library.b.c cVar = com.speed.speed_library.b.c.f5594a;
            androidx.fragment.app.e activity3 = b.this.getActivity();
            if (activity3 == null) {
                kotlin.d.b.i.a();
            }
            kotlin.d.b.i.a((Object) activity3, "this@SpeedFragment.activity!!");
            cVar.a(activity3, b.this.f().get(i).getLink_url(), "");
        }
    }

    public final void o() {
        ArrayList<Marquee> arrayList;
        if (com.speed.speed_library.business.e.f5632a.b()) {
            UserModel j2 = com.speed.speed_library.b.g.f5610b.j();
            Long valueOf = j2 != null ? Long.valueOf(j2.getExpire_time()) : null;
            if (valueOf == null) {
                kotlin.d.b.i.a();
            }
            if (valueOf.longValue() > com.speed.speed_library.business.e.f5632a.a()) {
                UserModel j3 = com.speed.speed_library.b.g.f5610b.j();
                Long valueOf2 = j3 != null ? Long.valueOf(j3.getExpire_time()) : null;
                if (valueOf2 == null) {
                    kotlin.d.b.i.a();
                }
                long j4 = 60;
                int longValue = (int) ((((valueOf2.longValue() - com.speed.speed_library.business.e.f5632a.a()) / 24) / j4) / j4);
                AppLog.INSTANCE.d("到期剩余天数::" + longValue);
                if (longValue < 4) {
                    this.l = "  * 您的会员时长还有" + longValue + "天到期 >";
                    if (longValue <= 1) {
                        this.l = "  * 您的会员时长即将到期 >";
                    }
                    com.speed.speed_library.b.g gVar = com.speed.speed_library.b.g.f5610b;
                    String a2 = com.speed.speed_library.b.b.f5592a.a("vip");
                    String str = this.l;
                    gVar.a(new Marquee(1000, 0, "", a2, str, str));
                } else {
                    com.speed.speed_library.b.g.f5610b.a((Marquee) null);
                }
            } else {
                this.l = "  * 您的会员时长已到期，请充值 >";
                com.speed.speed_library.b.g gVar2 = com.speed.speed_library.b.g.f5610b;
                String a3 = com.speed.speed_library.b.b.f5592a.a("vip");
                String str2 = this.l;
                gVar2.a(new Marquee(1000, 0, "", a3, str2, str2));
            }
            if (com.speed.speed_library.b.g.f5610b.h() != null && com.speed.speed_library.b.g.f5610b.i() == 1) {
                Iterator<Marquee> it = this.f5742q.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Marquee next = it.next();
                    if (kotlin.h.g.a((CharSequence) next.getTitle(), (CharSequence) "* 您的会员", false, 2, (Object) null)) {
                        this.f5742q.remove(next);
                        break;
                    }
                }
                ArrayList<Marquee> arrayList2 = this.f5742q;
                Marquee h2 = com.speed.speed_library.b.g.f5610b.h();
                if (h2 == null) {
                    kotlin.d.b.i.a();
                }
                arrayList2.add(0, h2);
                LinearLayout linearLayout = (LinearLayout) a().findViewById(R.id.layout_marquee);
                kotlin.d.b.i.a((Object) linearLayout, "mRootView.layout_marquee");
                linearLayout.setVisibility(0);
                a((List<Marquee>) this.f5742q);
                return;
            } else if (com.speed.speed_library.b.g.f5610b.h() != null && com.speed.speed_library.b.g.f5610b.i() == 0) {
                this.f5742q.clear();
                ArrayList<Marquee> arrayList3 = this.f5742q;
                Marquee h3 = com.speed.speed_library.b.g.f5610b.h();
                if (h3 == null) {
                    kotlin.d.b.i.a();
                }
                arrayList3.add(h3);
                LinearLayout linearLayout2 = (LinearLayout) a().findViewById(R.id.layout_marquee);
                kotlin.d.b.i.a((Object) linearLayout2, "mRootView.layout_marquee");
                linearLayout2.setVisibility(0);
                a((List<Marquee>) this.f5742q);
                return;
            } else if (com.speed.speed_library.b.g.f5610b.h() == null && com.speed.speed_library.b.g.f5610b.i() == 1 && (arrayList = this.f5742q) != null && arrayList.size() > 0) {
                LinearLayout linearLayout3 = (LinearLayout) a().findViewById(R.id.layout_marquee);
                kotlin.d.b.i.a((Object) linearLayout3, "mRootView.layout_marquee");
                linearLayout3.setVisibility(0);
                Iterator<Marquee> it2 = this.f5742q.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Marquee next2 = it2.next();
                    if (kotlin.h.g.a((CharSequence) next2.getTitle(), (CharSequence) "* 您的会员", false, 2, (Object) null)) {
                        this.f5742q.remove(next2);
                        break;
                    }
                }
                a((List<Marquee>) this.f5742q);
                return;
            } else {
                LinearLayout linearLayout4 = (LinearLayout) a().findViewById(R.id.layout_marquee);
                kotlin.d.b.i.a((Object) linearLayout4, "mRootView.layout_marquee");
                linearLayout4.setVisibility(8);
                return;
            }
        }
        com.speed.speed_library.b.g.f5610b.a((Marquee) null);
        LinearLayout linearLayout5 = (LinearLayout) a().findViewById(R.id.layout_marquee);
        kotlin.d.b.i.a((Object) linearLayout5, "mRootView.layout_marquee");
        linearLayout5.setVisibility(8);
    }

    public final void p() {
        d.a.a.a.a.c.f6985a.a().j().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(d()).a(new l());
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class l extends com.speed.speed_library.a.c<BaseModel<MarqueeModel>> {
        l() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<MarqueeModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (com.speed.speed_library.b.h.f5614a.a(baseModel, false)) {
                if (baseModel.getData() != null && baseModel.getData().getList().size() > 0) {
                    b.this.a(baseModel.getData().getList());
                    com.speed.speed_library.b.g.f5610b.d(1);
                    LinearLayout linearLayout = (LinearLayout) b.this.a().findViewById(R.id.layout_marquee);
                    kotlin.d.b.i.a((Object) linearLayout, "mRootView.layout_marquee");
                    linearLayout.setVisibility(0);
                    b.this.a((List<Marquee>) baseModel.getData().getList());
                    return;
                }
                com.speed.speed_library.b.g.f5610b.d(0);
                LinearLayout linearLayout2 = (LinearLayout) b.this.a().findViewById(R.id.layout_marquee);
                kotlin.d.b.i.a((Object) linearLayout2, "mRootView.layout_marquee");
                linearLayout2.setVisibility(8);
                return;
            }
            com.speed.speed_library.b.g.f5610b.d(0);
            b.this.o();
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
            com.speed.speed_library.b.h.f5614a.a(th);
            LinearLayout linearLayout = (LinearLayout) b.this.a().findViewById(R.id.layout_marquee);
            kotlin.d.b.i.a((Object) linearLayout, "mRootView.layout_marquee");
            linearLayout.setVisibility(8);
            com.speed.speed_library.b.g.f5610b.d(0);
            b.this.o();
        }
    }

    public final void a(List<Marquee> list) {
        kotlin.d.b.i.b(list, "marqueeList");
        ArrayList arrayList = new ArrayList();
        for (Marquee marquee : list) {
            arrayList.add(marquee.getTitle());
        }
        try {
            ((MarqueeView) a().findViewById(R.id.view_marqueeView)).a((List) arrayList);
        } catch (Exception unused) {
            LinearLayout linearLayout = (LinearLayout) a().findViewById(R.id.layout_marquee);
            kotlin.d.b.i.a((Object) linearLayout, "mRootView.layout_marquee");
            linearLayout.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (kotlin.d.b.i.a(view, (LinearLayout) a().findViewById(R.id.ll_route))) {
            startActivity(new Intent(getActivity(), LineActivity.class));
        } else if (kotlin.d.b.i.a(view, (RelativeLayout) a().findViewById(R.id.view_speed_progress))) {
            q();
        } else if (kotlin.d.b.i.a(view, (LinearLayout) a().findViewById(R.id.ll_right))) {
            com.speed.speed_library.b.c cVar = com.speed.speed_library.b.c.f5594a;
            androidx.fragment.app.e activity = getActivity();
            if (activity == null) {
                kotlin.d.b.i.a();
            }
            kotlin.d.b.i.a((Object) activity, "this.activity!!");
            cVar.a(activity, com.speed.speed_library.b.b.f5592a.a(), "公告");
            com.speed.speed_library.b.g.f5610b.g(com.speed.speed_library.b.g.f5610b.e());
            q.rorbin.badgeview.a aVar = this.r;
            if (aVar == null) {
                kotlin.d.b.i.b("mNoticeBadge");
            }
            aVar.a(0);
            com.speed.speed_library.business.d.f5631a.a(1);
        } else if (kotlin.d.b.i.a(view, (LinearLayout) a().findViewById(R.id.ll_back))) {
            com.speed.speed_library.b.c cVar2 = com.speed.speed_library.b.c.f5594a;
            androidx.fragment.app.e activity2 = getActivity();
            if (activity2 == null) {
                kotlin.d.b.i.a();
            }
            kotlin.d.b.i.a((Object) activity2, "this.activity!!");
            cVar2.a(activity2, com.speed.speed_library.b.b.f5592a.g(), "网址导航");
        }
    }

    public final void q() {
        Route route;
        Route route2;
        try {
            com.speed.speed_library.a aVar = this.g;
            if ((aVar != null && aVar.a() == 4) || this.g == null) {
                if (!com.speed.speed_library.business.e.f5632a.b()) {
                    com.speed.speed_library.b.f.a("登录异常，请稍后再试", 0, 2, null);
                    com.speed.speed_library.business.a.f5623a.f();
                    com.speed.speed_library.business.a.f5623a.d();
                    return;
                } else if (com.speed.speed_library.b.g.f5610b.r() == null) {
                    com.speed.speed_library.b.f.a("请选择线路", 0, 2, null);
                    return;
                } else {
                    Route r2 = com.speed.speed_library.b.g.f5610b.r();
                    if (r2 == null || r2.getVip_state() != 0) {
                        if (this.m != null && (route2 = this.m) != null && route2.getType() == 0 && com.speed.speed_library.business.e.f5632a.c()) {
                            u();
                            return;
                        } else if (this.m != null && (route = this.m) != null && route.getType() == 1 && com.speed.speed_library.business.e.f5632a.d()) {
                            a("当前线路是高级SVIP线路，请先购买高级套餐!");
                            return;
                        }
                    }
                    v();
                    new Handler().postDelayed(new c(), 1000L);
                    return;
                }
            }
            com.speed.speed_library.a aVar2 = this.g;
            if (aVar2 != null && aVar2.a() == 2) {
                com.speed.speed_library.a aVar3 = this.g;
                if (aVar3 != null) {
                    aVar3.b();
                    return;
                }
                return;
            }
            com.speed.speed_library.b.f.a("正在处理中...", 0, 2, null);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.r();
        }
    }

    public final void r() {
        d.a.a.a.a.a a2 = d.a.a.a.a.c.f6985a.a();
        Route r2 = com.speed.speed_library.b.g.f5610b.r();
        a2.a(r2 != null ? Integer.valueOf(r2.getId()) : null, (String) kotlin.h.g.b((CharSequence) com.speed.speed_library.b.g.f5610b.B(), new String[]{","}, false, 0, 6, (Object) null).get(1)).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new m());
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class m extends com.speed.speed_library.a.c<BaseModel<RouteInfoModel>> {
        m() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<RouteInfoModel> baseModel) {
            String msg;
            androidx.fragment.app.e activity;
            kotlin.d.b.i.b(baseModel, "response");
            if (b.this.getActivity() != null) {
                androidx.fragment.app.e activity2 = b.this.getActivity();
                if (activity2 == null || !activity2.isFinishing()) {
                    if (com.speed.speed_library.b.h.f5614a.a(baseModel, true)) {
                        if (b.this.f5741e == null) {
                            b.this.f5741e = new com.speed.speed_library.speed.b();
                        }
                        b.this.f5741e.a(com.speed.speed_library.b.g.f5610b.x());
                        b.this.f5741e.b(com.speed.speed_library.b.g.f5610b.C());
                        b.this.f5741e.c(com.speed.speed_library.b.g.f5610b.D());
                        b.this.f5741e.a(com.speed.speed_library.b.b.f5592a.j());
                        if (com.speed.speed_library.b.g.f5610b.U() == 1) {
                            b.this.f5741e.d(1);
                            com.speed.speed_library.speed.b bVar = b.this.f5741e;
                            ArrayList<String> W = com.speed.speed_library.b.g.f5610b.W();
                            if (W == null) {
                                W = new ArrayList<>();
                            }
                            bVar.a(W);
                        } else {
                            b.this.f5741e.d(0);
                        }
                        com.speed.speed_library.speed.b bVar2 = b.this.f5741e;
                        long ts = baseModel.getData().getTs();
                        Route route = b.this.m;
                        if (route == null) {
                            kotlin.d.b.i.a();
                        }
                        String type_name = route.getType_name();
                        String their_public_key = baseModel.getData().getTheir_public_key();
                        String ip = baseModel.getData().getIp();
                        String allow_ip = baseModel.getData().getAllow_ip();
                        String B = com.speed.speed_library.b.g.f5610b.B();
                        String sign = baseModel.getData().getSign();
                        UserModel j = com.speed.speed_library.b.g.f5610b.j();
                        int whitelist = j != null ? j.getWhitelist() : 0;
                        ConfigModel t = com.speed.speed_library.b.g.f5610b.t();
                        bVar2.a(new b.C0155b(ts, type_name, their_public_key, ip, allow_ip, B, sign, 0, whitelist, t != null ? t.getVpn_interval_time() : 10, 32, 0, 0, 6144, null));
                        if (b.this.getActivity() == null || (activity = b.this.getActivity()) == null || activity.isFinishing()) {
                            return;
                        }
                        Intent prepare = VpnService.prepare(b.this.getActivity());
                        com.speed.speed_library.b.g gVar = com.speed.speed_library.b.g.f5610b;
                        Route route2 = b.this.m;
                        int id = route2 != null ? route2.getId() : 0;
                        RouteInfoModel data = baseModel.getData();
                        if (data == null) {
                            kotlin.d.b.i.a();
                        }
                        gVar.a(id, data);
                        if (prepare != null) {
                            androidx.fragment.app.e activity3 = b.this.getActivity();
                            if (activity3 != null) {
                                activity3.startActivityForResult(prepare, 14737);
                                return;
                            }
                            return;
                        }
                        b.this.onActivityResult(14737, -1, null);
                        return;
                    }
                    if (baseModel.getCode() == com.speed.speed_library.b.d.f5595a.m() && (msg = baseModel.getMsg()) != null) {
                        b.this.a(msg);
                    }
                    b.this.w();
                }
            }
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
            if (b.this.getActivity() != null) {
                androidx.fragment.app.e activity = b.this.getActivity();
                if (activity == null || !activity.isFinishing()) {
                    g.a aVar = com.speed.speed_library.utils.g.f5871a;
                    androidx.fragment.app.e activity2 = b.this.getActivity();
                    if (activity2 == null) {
                        kotlin.d.b.i.a();
                    }
                    kotlin.d.b.i.a((Object) activity2, "this@SpeedFragment.activity!!");
                    if (!aVar.a(activity2)) {
                        com.speed.speed_library.b.h.f5614a.a(th);
                    }
                    b.this.w();
                }
            }
        }
    }

    public final void s() {
        d.a.a.a.a.c.f6985a.a().e().b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new k());
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class k extends com.speed.speed_library.a.c<BaseModel<RouteModel>> {
        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            kotlin.d.b.i.b(th, "e");
        }

        k() {
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<RouteModel> baseModel) {
            kotlin.d.b.i.b(baseModel, "response");
            if (!com.speed.speed_library.b.h.f5614a.a(baseModel, true) || baseModel.getData() == null) {
                return;
            }
            com.speed.speed_library.b.g.f5610b.a(baseModel.getData());
            b.this.a(baseModel.getData());
        }
    }

    public final void a(RouteModel routeModel) {
        boolean z;
        kotlin.d.b.i.b(routeModel, "routeList");
        if (this.m != null) {
            if (com.speed.speed_library.b.g.f5610b.r() != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : routeModel.getRoute_list()) {
                    if (((Route) obj).getType() == 0) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    int id = ((Route) arrayList2.get(i2)).getId();
                    Route r2 = com.speed.speed_library.b.g.f5610b.r();
                    if (r2 != null && id == r2.getId()) {
                        this.m = (Route) arrayList2.get(i2);
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (!z) {
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : routeModel.getRoute_list()) {
                        if (((Route) obj2).getType() == 1) {
                            arrayList3.add(obj2);
                        }
                    }
                    ArrayList arrayList4 = arrayList3;
                    int size2 = arrayList4.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size2) {
                            break;
                        }
                        int id2 = ((Route) arrayList4.get(i3)).getId();
                        Route r3 = com.speed.speed_library.b.g.f5610b.r();
                        if (r3 != null && id2 == r3.getId()) {
                            this.m = (Route) arrayList4.get(i3);
                            z = true;
                            break;
                        }
                        i3++;
                    }
                }
            } else {
                z = false;
            }
            if (!z) {
                ArrayList arrayList5 = new ArrayList();
                for (Object obj3 : routeModel.getRoute_list()) {
                    if (((Route) obj3).getType() == 0) {
                        arrayList5.add(obj3);
                    }
                }
                Route b2 = b((List<Route>) arrayList5);
                this.m = b2 != null ? b2 : null;
            }
        } else {
            ArrayList arrayList6 = new ArrayList();
            for (Object obj4 : routeModel.getRoute_list()) {
                if (((Route) obj4).getType() == 0) {
                    arrayList6.add(obj4);
                }
            }
            Route b3 = b((List<Route>) arrayList6);
            this.m = b3 != null ? b3 : null;
        }
        if (this.m == null) {
            com.speed.speed_library.b.g.f5610b.s();
            TextView textView = (TextView) a().findViewById(R.id.tv_routename);
            kotlin.d.b.i.a((Object) textView, "mRootView.tv_routename");
            textView.setText("请选择线路");
            return;
        }
        com.speed.speed_library.b.g.f5610b.a(this.m);
        t();
    }

    public final Route b(List<Route> list) {
        kotlin.d.b.i.b(list, "routeList");
        if (list.size() > 0) {
            List<Route> list2 = list;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((Route) next).getType() == 0) {
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list2) {
                    if (((Route) obj).getType() == 0) {
                        arrayList2.add(obj);
                    }
                }
                return (Route) arrayList2.get(0);
            }
            return null;
        }
        return null;
    }

    public final void t() {
        androidx.fragment.app.e activity;
        Route r2 = com.speed.speed_library.b.g.f5610b.r();
        this.m = r2;
        if (r2 != null) {
            TextView textView = (TextView) a().findViewById(R.id.tv_routename);
            kotlin.d.b.i.a((Object) textView, "mRootView.tv_routename");
            Route route = this.m;
            if (route == null) {
                kotlin.d.b.i.a();
            }
            textView.setText(route.getName());
            Route route2 = this.m;
            if ((route2 != null ? route2.getImage_url() : null) != null) {
                Route route3 = this.m;
                String image_url = route3 != null ? route3.getImage_url() : null;
                if (image_url == null) {
                    kotlin.d.b.i.a();
                }
                if (image_url.length() > 0) {
                    if (getActivity() == null || (activity = getActivity()) == null || activity.isFinishing()) {
                        return;
                    }
                    com.bumptech.glide.j a2 = com.bumptech.glide.c.a(this);
                    Route route4 = this.m;
                    a2.a(route4 != null ? route4.getImage_url() : null).a((ImageView) a().findViewById(R.id.iv_home_flag));
                    return;
                }
            }
            Route route5 = this.m;
            if (kotlin.h.g.a(route5 != null ? route5.getFlag_name() : null, "hk", false, 2, (Object) null)) {
                ((ImageView) a().findViewById(R.id.iv_home_flag)).setImageResource(R.mipmap.ic_flag_hk);
                return;
            }
            Route route6 = this.m;
            if (kotlin.h.g.a(route6 != null ? route6.getFlag_name() : null, "jp", false, 2, (Object) null)) {
                ((ImageView) a().findViewById(R.id.iv_home_flag)).setImageResource(R.mipmap.ic_flag_jp);
                return;
            }
            Route route7 = this.m;
            if (kotlin.h.g.a(route7 != null ? route7.getFlag_name() : null, "usa", false, 2, (Object) null)) {
                ((ImageView) a().findViewById(R.id.iv_home_flag)).setImageResource(R.mipmap.ic_flag_usa);
                return;
            }
            Route route8 = this.m;
            if (kotlin.h.g.a(route8 != null ? route8.getFlag_name() : null, "kp", false, 2, (Object) null)) {
                ((ImageView) a().findViewById(R.id.iv_home_flag)).setImageResource(R.mipmap.ic_flag_kp);
                return;
            }
            Route route9 = this.m;
            if (kotlin.h.g.a(route9 != null ? route9.getFlag_name() : null, "cn", false, 2, (Object) null)) {
                ((ImageView) a().findViewById(R.id.iv_home_flag)).setImageResource(R.mipmap.ic_flag_cn);
                return;
            }
            Route route10 = this.m;
            if (kotlin.h.g.a(route10 != null ? route10.getFlag_name() : null, "ha", false, 2, (Object) null)) {
                ((ImageView) a().findViewById(R.id.iv_home_flag)).setImageResource(R.mipmap.ic_flag_hao);
                return;
            }
            Route route11 = this.m;
            if (kotlin.h.g.a(route11 != null ? route11.getFlag_name() : null, "fr", false, 2, (Object) null)) {
                ((ImageView) a().findViewById(R.id.iv_home_flag)).setImageResource(R.mipmap.ic_flag_fr);
                return;
            }
            Route route12 = this.m;
            if (kotlin.h.g.a(route12 != null ? route12.getFlag_name() : null, "de", false, 2, (Object) null)) {
                ((ImageView) a().findViewById(R.id.iv_home_flag)).setImageResource(R.mipmap.ic_flag_de);
                return;
            }
            Route route13 = this.m;
            if (kotlin.h.g.a(route13 != null ? route13.getFlag_name() : null, "gb", false, 2, (Object) null)) {
                ((ImageView) a().findViewById(R.id.iv_home_flag)).setImageResource(R.mipmap.ic_flag_gb);
            } else {
                ((ImageView) a().findViewById(R.id.iv_home_flag)).setImageResource(R.mipmap.ic_flag_default);
            }
        }
    }

    public final void u() {
        androidx.fragment.app.e activity;
        if (getActivity() == null || (activity = getActivity()) == null || activity.isFinishing()) {
            return;
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 == null) {
            kotlin.d.b.i.a();
        }
        kotlin.d.b.i.a((Object) activity2, "this.activity!!");
        com.speed.speed_library.widget.a.d dVar = new com.speed.speed_library.widget.a.d(activity2);
        dVar.setCanceledOnTouchOutside(true);
        dVar.b();
        dVar.a("温馨提示");
        dVar.c("购买");
        dVar.b("您的服务时间已到期，请购买套餐!");
        dVar.a(new t(dVar));
        dVar.setOnCancelListener(new u(dVar));
        dVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class t implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.speed.speed_library.widget.a.d f5778a;

        t(com.speed.speed_library.widget.a.d dVar) {
            this.f5778a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f5778a.dismiss();
            org.greenrobot.eventbus.c.a().d(new BuyTypeEvent("vip"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class u implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.speed.speed_library.widget.a.d f5779a;

        u(com.speed.speed_library.widget.a.d dVar) {
            this.f5779a = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.f5779a.cancel();
        }
    }

    public final void a(String str) {
        androidx.fragment.app.e activity;
        if (getActivity() == null || (activity = getActivity()) == null || activity.isFinishing()) {
            return;
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 == null) {
            kotlin.d.b.i.a();
        }
        kotlin.d.b.i.a((Object) activity2, "this.activity!!");
        com.speed.speed_library.widget.a.d dVar = new com.speed.speed_library.widget.a.d(activity2);
        dVar.setCanceledOnTouchOutside(true);
        dVar.b();
        dVar.a("温馨提示");
        if (str == null) {
            str = "当前线路是高级SVIP线路，请先购买高级套餐!";
        }
        dVar.b(str);
        dVar.c("购买");
        dVar.a(new r(dVar));
        dVar.setOnCancelListener(new s(dVar));
        dVar.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.speed.speed_library.widget.a.d f5776a;

        r(com.speed.speed_library.widget.a.d dVar) {
            this.f5776a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f5776a.dismiss();
            org.greenrobot.eventbus.c.a().d(new BuyTypeEvent("svip"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class s implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.speed.speed_library.widget.a.d f5777a;

        s(com.speed.speed_library.widget.a.d dVar) {
            this.f5777a = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.f5777a.cancel();
        }
    }

    public final void v() {
        ImageView imageView = (ImageView) a().findViewById(R.id.iv_speed_close);
        kotlin.d.b.i.a((Object) imageView, "mRootView.iv_speed_close");
        imageView.setVisibility(8);
        TextView textView = (TextView) a().findViewById(R.id.tv_connect_time);
        kotlin.d.b.i.a((Object) textView, "mRootView.tv_connect_time");
        textView.setVisibility(8);
        TextView textView2 = (TextView) a().findViewById(R.id.tv_connect_state_show);
        kotlin.d.b.i.a((Object) textView2, "mRootView.tv_connect_state_show");
        textView2.setText("连接中...");
        ImageView imageView2 = (ImageView) a().findViewById(R.id.iv_bg_speed_disconnected);
        kotlin.d.b.i.a((Object) imageView2, "mRootView.iv_bg_speed_disconnected");
        imageView2.setVisibility(8);
        ImageView imageView3 = (ImageView) a().findViewById(R.id.iv_bg_speed_connected);
        kotlin.d.b.i.a((Object) imageView3, "mRootView.iv_bg_speed_connected");
        imageView3.setVisibility(8);
        ImageView imageView4 = (ImageView) a().findViewById(R.id.iv_bg_speed_loading);
        kotlin.d.b.i.a((Object) imageView4, "mRootView.iv_bg_speed_loading");
        imageView4.setVisibility(0);
        ImageView imageView5 = (ImageView) a().findViewById(R.id.iv_bg_speed_loading);
        Animation animation = this.f5740c;
        if (animation == null) {
            kotlin.d.b.i.b("rotationAnim");
        }
        imageView5.startAnimation(animation);
    }

    public final void w() {
        E();
        AppLog appLog = AppLog.INSTANCE;
        appLog.d("diff_number_time===" + this.k);
        com.speed.speed_library.business.d.f5631a.a(0, 0, 0, this.k);
        LinearLayout linearLayout = (LinearLayout) a().findViewById(R.id.ll_up_down_flow);
        kotlin.d.b.i.a((Object) linearLayout, "mRootView.ll_up_down_flow");
        linearLayout.setVisibility(8);
        ImageView imageView = (ImageView) a().findViewById(R.id.iv_speed_close);
        kotlin.d.b.i.a((Object) imageView, "mRootView.iv_speed_close");
        imageView.setVisibility(0);
        TextView textView = (TextView) a().findViewById(R.id.tv_connect_time);
        kotlin.d.b.i.a((Object) textView, "mRootView.tv_connect_time");
        textView.setVisibility(8);
        TextView textView2 = (TextView) a().findViewById(R.id.tv_connect_state_show);
        kotlin.d.b.i.a((Object) textView2, "mRootView.tv_connect_state_show");
        textView2.setText("点击加速");
        ((TextView) a().findViewById(R.id.tv_connect_state_show)).setTextColor(getResources().getColor(R.color.text_color_three));
        ImageView imageView2 = (ImageView) a().findViewById(R.id.iv_bg_speed_disconnected);
        kotlin.d.b.i.a((Object) imageView2, "mRootView.iv_bg_speed_disconnected");
        imageView2.setVisibility(0);
        ImageView imageView3 = (ImageView) a().findViewById(R.id.iv_bg_speed_connected);
        kotlin.d.b.i.a((Object) imageView3, "mRootView.iv_bg_speed_connected");
        imageView3.setVisibility(8);
        ImageView imageView4 = (ImageView) a().findViewById(R.id.iv_bg_speed_loading);
        kotlin.d.b.i.a((Object) imageView4, "mRootView.iv_bg_speed_loading");
        imageView4.setVisibility(8);
        ((ImageView) a().findViewById(R.id.iv_bg_speed_loading)).clearAnimation();
    }

    public final void x() {
        ImageView imageView = (ImageView) a().findViewById(R.id.iv_speed_close);
        kotlin.d.b.i.a((Object) imageView, "mRootView.iv_speed_close");
        imageView.setVisibility(8);
        TextView textView = (TextView) a().findViewById(R.id.tv_connect_time);
        kotlin.d.b.i.a((Object) textView, "mRootView.tv_connect_time");
        textView.setVisibility(8);
        TextView textView2 = (TextView) a().findViewById(R.id.tv_connect_state_show);
        kotlin.d.b.i.a((Object) textView2, "mRootView.tv_connect_state_show");
        textView2.setText("断开中");
    }

    public final void y() {
        ImageView imageView = (ImageView) a().findViewById(R.id.iv_speed_close);
        kotlin.d.b.i.a((Object) imageView, "mRootView.iv_speed_close");
        imageView.setVisibility(8);
        TextView textView = (TextView) a().findViewById(R.id.tv_connect_time);
        kotlin.d.b.i.a((Object) textView, "mRootView.tv_connect_time");
        textView.setVisibility(0);
        TextView textView2 = (TextView) a().findViewById(R.id.tv_connect_time);
        kotlin.d.b.i.a((Object) textView2, "mRootView.tv_connect_time");
        textView2.setText("");
        TextView textView3 = (TextView) a().findViewById(R.id.tv_connect_state_show);
        kotlin.d.b.i.a((Object) textView3, "mRootView.tv_connect_state_show");
        textView3.setText("点击断开");
        ((TextView) a().findViewById(R.id.tv_connect_state_show)).setTextColor(getResources().getColor(R.color.colorWhite));
        ImageView imageView2 = (ImageView) a().findViewById(R.id.iv_bg_speed_disconnected);
        kotlin.d.b.i.a((Object) imageView2, "mRootView.iv_bg_speed_disconnected");
        imageView2.setVisibility(8);
        ((ImageView) a().findViewById(R.id.iv_bg_speed_loading)).clearAnimation();
        ImageView imageView3 = (ImageView) a().findViewById(R.id.iv_bg_speed_loading);
        kotlin.d.b.i.a((Object) imageView3, "mRootView.iv_bg_speed_loading");
        imageView3.setVisibility(8);
        ImageView imageView4 = (ImageView) a().findViewById(R.id.iv_bg_speed_connected);
        kotlin.d.b.i.a((Object) imageView4, "mRootView.iv_bg_speed_connected");
        imageView4.setVisibility(0);
        D();
        F();
    }

    @Override // androidx.fragment.app.d
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 14737) {
            if (i3 == -1) {
                Activity activity = this.f5739b;
                if (activity == null) {
                    kotlin.d.b.i.b("mActivity");
                }
                if (activity == null) {
                    return;
                }
                Activity activity2 = this.f5739b;
                if (activity2 == null) {
                    kotlin.d.b.i.b("mActivity");
                }
                Intent intent2 = new Intent(activity2, WireGuardService.class);
                intent2.setAction("WG.SERVICE");
                intent2.putExtra("configExtra", this.f5741e);
                if (Build.VERSION.SDK_INT >= 26) {
                    Activity activity3 = this.f5739b;
                    if (activity3 == null) {
                        kotlin.d.b.i.b("mActivity");
                    }
                    if (activity3 != null) {
                        activity3.startForegroundService(intent2);
                        return;
                    }
                    return;
                }
                Activity activity4 = this.f5739b;
                if (activity4 == null) {
                    kotlin.d.b.i.b("mActivity");
                }
                if (activity4 != null) {
                    activity4.startService(intent2);
                    return;
                }
                return;
            }
            com.speed.speed_library.b.f.a("未授权，无法建立连接", 0, 2, null);
            try {
                com.speed.speed_library.a aVar = this.g;
                if (aVar != null) {
                    aVar.b();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void z() {
        androidx.fragment.app.e activity;
        com.speed.speed_library.speed.a.a(this, "attachService");
        if (getActivity() == null || (activity = getActivity()) == null || activity.isFinishing()) {
            return;
        }
        Intent intent = new Intent(getActivity(), WireGuardService.class);
        intent.setAction("WG.SERVICE");
        intent.putExtra("configExtra", this.f5741e);
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            activity2.bindService(intent, this.v, 1);
        }
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class p implements ServiceConnection {
        p() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.speed.speed_library.speed.a.a(this, "onServiceDisconnected");
            b.this.g = null;
            b.this.f = null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            kotlin.d.b.i.b(componentName, "componentName");
            com.speed.speed_library.speed.a.a(this, "onServiceConnected");
            try {
                b.this.f = iBinder;
                IBinder iBinder2 = b.this.f;
                if (iBinder2 != null) {
                    iBinder2.linkToDeath(b.this, 0);
                }
                b.this.g = a.AbstractBinderC0132a.a(iBinder);
                com.speed.speed_library.a aVar = b.this.g;
                if (aVar != null) {
                    aVar.a(b.this.A());
                }
                b.this.B();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class o extends b.a {
        o() {
        }

        @Override // com.speed.speed_library.b
        public void a(int i, String str) {
            kotlin.d.b.i.b(str, JThirdPlatFormInterface.KEY_MSG);
            com.speed.speed_library.speed.a.a(this, "state1:::" + i);
            if (!TextUtils.isEmpty(str)) {
                com.speed.speed_library.b.g.f5610b.d(str);
            }
            androidx.fragment.app.e activity = b.this.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new RunnableC0149b(i));
            }
        }

        /* compiled from: SpeedFragment.kt */
        /* renamed from: com.speed.speed_library.module.main.b$o$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static final class RunnableC0149b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f5763b;

            RunnableC0149b(int i) {
                this.f5763b = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                androidx.fragment.app.e activity;
                androidx.fragment.app.e activity2;
                androidx.fragment.app.e activity3;
                androidx.fragment.app.e activity4;
                androidx.fragment.app.e activity5;
                androidx.fragment.app.e activity6;
                androidx.fragment.app.e activity7;
                androidx.fragment.app.e activity8;
                int i = this.f5763b;
                if (i == 1) {
                    if (b.this.getActivity() == null || (activity = b.this.getActivity()) == null || activity.isFinishing() || (activity2 = b.this.getActivity()) == null) {
                        return;
                    }
                    activity2.runOnUiThread(new Runnable() { // from class: com.speed.speed_library.module.main.b.o.b.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.fragment.app.e activity9 = b.this.getActivity();
                            if (activity9 == null || activity9.isFinishing()) {
                                return;
                            }
                            b.this.v();
                        }
                    });
                } else if (i == 2) {
                    if (b.this.getActivity() == null || (activity3 = b.this.getActivity()) == null || activity3.isFinishing() || (activity4 = b.this.getActivity()) == null) {
                        return;
                    }
                    activity4.runOnUiThread(new Runnable() { // from class: com.speed.speed_library.module.main.b.o.b.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.a(false);
                            b.this.b(false);
                            androidx.fragment.app.e activity9 = b.this.getActivity();
                            if (activity9 == null || activity9.isFinishing()) {
                                return;
                            }
                            b.this.y();
                        }
                    });
                } else if (i != 3) {
                    if (i != 4 || b.this.getActivity() == null || (activity7 = b.this.getActivity()) == null || activity7.isFinishing() || (activity8 = b.this.getActivity()) == null) {
                        return;
                    }
                    activity8.runOnUiThread(new Runnable() { // from class: com.speed.speed_library.module.main.b.o.b.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.fragment.app.e activity9 = b.this.getActivity();
                            if (activity9 == null || activity9.isFinishing()) {
                                return;
                            }
                            b.this.w();
                        }
                    });
                } else if (b.this.getActivity() == null || (activity5 = b.this.getActivity()) == null || activity5.isFinishing() || (activity6 = b.this.getActivity()) == null) {
                } else {
                    activity6.runOnUiThread(new Runnable() { // from class: com.speed.speed_library.module.main.b.o.b.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            androidx.fragment.app.e activity9 = b.this.getActivity();
                            if (activity9 == null || activity9.isFinishing()) {
                                return;
                            }
                            b.this.x();
                        }
                    });
                }
            }
        }

        @Override // com.speed.speed_library.b
        public void a(long j, long j2) {
            androidx.fragment.app.e activity;
            androidx.fragment.app.e activity2;
            if (b.this.getActivity() == null || (activity = b.this.getActivity()) == null || activity.isFinishing() || (activity2 = b.this.getActivity()) == null) {
                return;
            }
            activity2.runOnUiThread(new a(j, j2));
        }

        /* compiled from: SpeedFragment.kt */
        /* loaded from: classes2.dex */
        static final class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ long f5759b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ long f5760c;

            a(long j, long j2) {
                this.f5759b = j;
                this.f5760c = j2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.speed.speed_library.a aVar;
                androidx.fragment.app.e activity = b.this.getActivity();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                if (!b.this.g()) {
                    try {
                        if (b.this.g != null && (aVar = b.this.g) != null && aVar.a() == 2 && this.f5759b > 0 && this.f5760c > 0) {
                            b.this.a(true);
                            com.speed.speed_library.business.d.a(com.speed.speed_library.business.d.f5631a, 0, 1, 0, 0, 12, null);
                        }
                    } catch (Exception unused) {
                    }
                }
                if (!b.this.h()) {
                    b.this.b(true);
                    new Handler().postDelayed(new Runnable() { // from class: com.speed.speed_library.module.main.b.o.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.speed.speed_library.a aVar2;
                            try {
                                if (b.this.g == null || (aVar2 = b.this.g) == null || aVar2.a() != 2) {
                                    return;
                                }
                                if (a.this.f5759b <= 0 || a.this.f5760c <= 0) {
                                    com.speed.speed_library.business.d.a(com.speed.speed_library.business.d.f5631a, 0, 0, 1, 0, 8, null);
                                    com.speed.speed_library.business.d.f5631a.a(b.this.f5741e.a().d());
                                }
                            } catch (Exception unused2) {
                            }
                        }
                    }, 30000L);
                }
                LinearLayout linearLayout = (LinearLayout) b.this.a().findViewById(R.id.ll_up_down_flow);
                kotlin.d.b.i.a((Object) linearLayout, "mRootView.ll_up_down_flow");
                linearLayout.setVisibility(0);
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                long j = this.f5759b;
                double d2 = j;
                Double.isNaN(d2);
                double d3 = 1;
                if (d2 / 1.073741824E9d >= d3) {
                    TextView textView = (TextView) b.this.a(R.id.tv_up_flow);
                    kotlin.d.b.i.a((Object) textView, "tv_up_flow");
                    double d4 = this.f5759b;
                    Double.isNaN(d4);
                    textView.setText(decimalFormat.format(d4 / 1.073741824E9d).toString());
                    TextView textView2 = (TextView) b.this.a(R.id.tv_up_flow_unit);
                    kotlin.d.b.i.a((Object) textView2, "tv_up_flow_unit");
                    textView2.setText(" GB");
                } else {
                    double d5 = j;
                    Double.isNaN(d5);
                    if (d5 / 1048576.0d >= d3) {
                        TextView textView3 = (TextView) b.this.a(R.id.tv_up_flow);
                        kotlin.d.b.i.a((Object) textView3, "tv_up_flow");
                        double d6 = this.f5759b;
                        Double.isNaN(d6);
                        textView3.setText(decimalFormat.format(d6 / 1048576.0d).toString());
                        TextView textView4 = (TextView) b.this.a(R.id.tv_up_flow_unit);
                        kotlin.d.b.i.a((Object) textView4, "tv_up_flow_unit");
                        textView4.setText(" MB");
                    } else {
                        double d7 = j;
                        Double.isNaN(d7);
                        if (d7 / 1024.0d >= d3) {
                            TextView textView5 = (TextView) b.this.a(R.id.tv_up_flow);
                            kotlin.d.b.i.a((Object) textView5, "tv_up_flow");
                            double d8 = this.f5759b;
                            Double.isNaN(d8);
                            textView5.setText(decimalFormat.format(d8 / 1024.0d).toString());
                            TextView textView6 = (TextView) b.this.a(R.id.tv_up_flow_unit);
                            kotlin.d.b.i.a((Object) textView6, "tv_up_flow_unit");
                            textView6.setText(" KB");
                        } else {
                            TextView textView7 = (TextView) b.this.a(R.id.tv_up_flow);
                            kotlin.d.b.i.a((Object) textView7, "tv_up_flow");
                            textView7.setText(String.valueOf(this.f5759b));
                            TextView textView8 = (TextView) b.this.a(R.id.tv_up_flow_unit);
                            kotlin.d.b.i.a((Object) textView8, "tv_up_flow_unit");
                            textView8.setText(" B");
                        }
                    }
                }
                long j2 = this.f5760c;
                double d9 = j2;
                Double.isNaN(d9);
                if (d9 / 1.073741824E9d >= d3) {
                    TextView textView9 = (TextView) b.this.a(R.id.tv_down_flow);
                    kotlin.d.b.i.a((Object) textView9, "tv_down_flow");
                    double d10 = this.f5760c;
                    Double.isNaN(d10);
                    textView9.setText(decimalFormat.format(d10 / 1.073741824E9d).toString());
                    TextView textView10 = (TextView) b.this.a(R.id.tv_down_flow_unit);
                    kotlin.d.b.i.a((Object) textView10, "tv_down_flow_unit");
                    textView10.setText(" GB");
                    return;
                }
                double d11 = j2;
                Double.isNaN(d11);
                if (d11 / 1048576.0d >= d3) {
                    TextView textView11 = (TextView) b.this.a(R.id.tv_down_flow);
                    kotlin.d.b.i.a((Object) textView11, "tv_down_flow");
                    double d12 = this.f5760c;
                    Double.isNaN(d12);
                    textView11.setText(decimalFormat.format(d12 / 1048576.0d).toString());
                    TextView textView12 = (TextView) b.this.a(R.id.tv_down_flow_unit);
                    kotlin.d.b.i.a((Object) textView12, "tv_down_flow_unit");
                    textView12.setText(" MB");
                    return;
                }
                double d13 = j2;
                Double.isNaN(d13);
                if (d13 / 1024.0d >= d3) {
                    TextView textView13 = (TextView) b.this.a(R.id.tv_down_flow);
                    kotlin.d.b.i.a((Object) textView13, "tv_down_flow");
                    double d14 = this.f5760c;
                    Double.isNaN(d14);
                    textView13.setText(decimalFormat.format(d14 / 1024.0d).toString());
                    TextView textView14 = (TextView) b.this.a(R.id.tv_down_flow_unit);
                    kotlin.d.b.i.a((Object) textView14, "tv_down_flow_unit");
                    textView14.setText(" KB");
                    return;
                }
                TextView textView15 = (TextView) b.this.a(R.id.tv_down_flow);
                kotlin.d.b.i.a((Object) textView15, "tv_down_flow");
                textView15.setText(String.valueOf(this.f5759b));
                TextView textView16 = (TextView) b.this.a(R.id.tv_down_flow_unit);
                kotlin.d.b.i.a((Object) textView16, "tv_down_flow_unit");
                textView16.setText(" B");
            }
        }
    }

    public final b.a A() {
        return this.w;
    }

    public final void B() {
        androidx.fragment.app.e activity;
        com.speed.speed_library.a aVar = this.g;
        int a2 = aVar != null ? aVar.a() : this.i;
        this.i = a2;
        if (a2 != 2) {
            if (a2 == 4 && (activity = getActivity()) != null) {
                activity.runOnUiThread(new j());
                return;
            }
            return;
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            activity2.runOnUiThread(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            androidx.fragment.app.e activity = b.this.getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            b.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            androidx.fragment.app.e activity = b.this.getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            b.this.E();
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.f = null;
        this.g = null;
        new n().start();
        com.speed.speed_library.speed.a.a(this, "btservice:: binderided");
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    private final class n extends Thread {
        public n() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Thread.sleep(600L);
            androidx.fragment.app.e activity = b.this.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new a());
            }
        }

        /* compiled from: SpeedFragment.kt */
        /* loaded from: classes2.dex */
        static final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.z();
            }
        }
    }

    public final void C() {
        com.speed.speed_library.speed.a.a(this, "detachService:: detachService");
        try {
            com.speed.speed_library.a aVar = this.g;
            if (aVar != null) {
                aVar.b(this.w);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ServiceConnection serviceConnection = this.v;
        if (serviceConnection != null) {
            try {
                androidx.fragment.app.e activity = getActivity();
                if (activity != null) {
                    activity.unbindService(serviceConnection);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        IBinder iBinder = this.f;
        if (iBinder != null) {
            iBinder.unlinkToDeath(this, 0);
            this.f = null;
        }
        this.g = null;
    }

    public final void D() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (com.speed.speed_library.b.g.f5610b.E() > 0) {
            this.j = (int) (currentTimeMillis - com.speed.speed_library.b.g.f5610b.E());
        } else {
            this.j = 0;
            com.speed.speed_library.b.g.f5610b.a(currentTimeMillis);
        }
        if (b().b()) {
            return;
        }
        b().c();
    }

    public final void E() {
        this.j = 0;
        com.speed.speed_library.b.g.f5610b.F();
        if (b().b()) {
            return;
        }
        b().c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        b.b.e.a(1L, TimeUnit.SECONDS).a(b.b.a.b.a.a()).a(new d());
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d implements b.b.h<Long> {
        @Override // b.b.h
        public void a(Throwable th) {
            kotlin.d.b.i.b(th, "e");
        }

        d() {
        }

        @Override // b.b.h
        public /* synthetic */ void a_(Long l) {
            a(l.longValue());
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            kotlin.d.b.i.b(bVar, "disposable");
            b.this.b().a(bVar);
        }

        public void a(long j) {
            TextView textView = (TextView) b.this.a().findViewById(R.id.tv_connect_time);
            kotlin.d.b.i.a((Object) textView, "mRootView.tv_connect_time");
            int i = (int) j;
            textView.setText(com.speed.speed_library.utils.c.f5860a.a(b.this.e() + i));
            b bVar = b.this;
            bVar.b(bVar.e() + i);
        }

        @Override // b.b.h
        public void b() {
            AppLog.INSTANCE.i("onComplete结束");
        }
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onDestroy() {
        super.onDestroy();
        ((ImageView) a().findViewById(R.id.iv_bg_speed_loading)).clearAnimation();
        C();
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onResume() {
        super.onResume();
        com.speed.speed_library.business.b.f5625a.a();
        com.speed.speed_library.business.a.f5623a.g();
        com.speed.speed_library.business.a.f5623a.d();
    }

    @Override // androidx.fragment.app.d
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        com.speed.speed_library.utils.h hVar = com.speed.speed_library.utils.h.f5876a;
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
            kotlin.d.b.i.a();
        }
        kotlin.d.b.i.a((Object) activity, "this.activity!!");
        hVar.a(activity, getResources().getColor(R.color.colorGrayTwo), true);
        new Handler().postDelayed(new g(), 400L);
        new Handler().postDelayed(new h(), 1000L);
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    static final class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.speed.speed_library.a aVar;
            com.speed.speed_library.a aVar2;
            com.speed.speed_library.a aVar3;
            try {
                if (b.this.g == null || (b.this.g != null && (aVar3 = b.this.g) != null && aVar3.a() == 4)) {
                    LinearLayout linearLayout = (LinearLayout) b.this.a().findViewById(R.id.ll_up_down_flow);
                    kotlin.d.b.i.a((Object) linearLayout, "mRootView.ll_up_down_flow");
                    linearLayout.setVisibility(8);
                }
                if (b.this.g == null || (b.this.g != null && (aVar2 = b.this.g) != null && aVar2.a() == 4)) {
                    b.this.w();
                }
                if (b.this.g == null || (aVar = b.this.g) == null || aVar.a() != 2) {
                    return;
                }
                b.this.D();
                b.this.F();
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: SpeedFragment.kt */
    /* loaded from: classes2.dex */
    static final class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.m();
        }
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onStart() {
        super.onStart();
        ((MarqueeView) a().findViewById(R.id.view_marqueeView)).startFlipping();
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onStop() {
        super.onStop();
        ((MarqueeView) a().findViewById(R.id.view_marqueeView)).stopFlipping();
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public final void userInfoEvent(UserInfoEvent userInfoEvent) {
        kotlin.d.b.i.b(userInfoEvent, "event");
        m();
        o();
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public final void routeEvent(RouteEvent routeEvent) {
        com.speed.speed_library.a aVar;
        kotlin.d.b.i.b(routeEvent, "event");
        this.m = routeEvent.getRoute();
        TextView textView = (TextView) a().findViewById(R.id.tv_routename);
        kotlin.d.b.i.a((Object) textView, "mRootView.tv_routename");
        textView.setText(routeEvent.getRoute().getName());
        com.speed.speed_library.a aVar2 = this.g;
        if (aVar2 != null && ((aVar2 == null || aVar2.a() != 4) && (aVar = this.g) != null)) {
            aVar.b();
        }
        t();
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public final void logoutEvent(LogoutEvent logoutEvent) {
        kotlin.d.b.i.b(logoutEvent, "event");
        com.speed.speed_library.a aVar = this.g;
        if (aVar != null) {
            aVar.b();
        }
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            activity.startActivity(new Intent(getActivity(), LoginActivity.class));
        }
        androidx.fragment.app.e activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @org.greenrobot.eventbus.m(a = ThreadMode.MAIN)
    public final void sceneSelectEvent(SceneSelectsEvent sceneSelectsEvent) {
        com.speed.speed_library.a aVar;
        kotlin.d.b.i.b(sceneSelectsEvent, "event");
        if (com.speed.speed_library.b.g.f5610b.H().equals(sceneSelectsEvent.getType())) {
            return;
        }
        com.speed.speed_library.a aVar2 = this.g;
        if (aVar2 != null && aVar2 != null && aVar2.a() == 2 && (aVar = this.g) != null) {
            aVar.b();
        }
        com.speed.speed_library.b.g.f5610b.g(sceneSelectsEvent.getType());
        TextView textView = (TextView) a().findViewById(R.id.tv_routename);
        kotlin.d.b.i.a((Object) textView, "mRootView.tv_routename");
        textView.setText("");
        com.speed.speed_library.b.g.f5610b.q();
        com.speed.speed_library.b.g.f5610b.s();
        this.m = null;
        s();
    }
}
