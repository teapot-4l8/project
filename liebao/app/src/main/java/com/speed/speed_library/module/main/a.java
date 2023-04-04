package com.speed.speed_library.module.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.e;
import com.speed.speed_library.R;
import com.speed.speed_library.b.f;
import com.speed.speed_library.business.d;
import com.speed.speed_library.event.BadgeEvent;
import com.speed.speed_library.event.UserInfoEvent;
import com.speed.speed_library.model.ConfigModel;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.module.setting.AboutActivity;
import com.speed.speed_library.module.setting.AccountActivity;
import com.speed.speed_library.module.setting.FeedbackActivity;
import com.speed.speed_library.module.setting.ProtectKillActivity;
import com.speed.speed_library.utils.h;
import java.util.Calendar;
import java.util.HashMap;
import kotlin.d.b.g;
import kotlin.d.b.i;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.m;

/* compiled from: MyFragment.kt */
/* loaded from: classes.dex */
public final class a extends com.speed.speed_library.a.b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static final C0147a f5734b = new C0147a(null);

    /* renamed from: c  reason: collision with root package name */
    private String f5735c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f5736d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f5737e = "";
    private q.rorbin.badgeview.a f;
    private HashMap g;

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public View a(int i) {
        if (this.g == null) {
            this.g = new HashMap();
        }
        View view = (View) this.g.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this.g.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public void c() {
        HashMap hashMap = this.g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d, androidx.fragment.app.d
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    /* compiled from: MyFragment.kt */
    /* renamed from: com.speed.speed_library.module.main.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0147a {
        private C0147a() {
        }

        public /* synthetic */ C0147a(g gVar) {
            this();
        }

        public final a a() {
            Bundle bundle = new Bundle();
            a aVar = new a();
            aVar.setArguments(bundle);
            return aVar;
        }
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h hVar = h.f5876a;
        e activity = getActivity();
        if (activity == null) {
            i.a();
        }
        i.a((Object) activity, "this.activity!!");
        hVar.a(activity, getResources().getColor(R.color.colorWhite), true);
        c.a().a(this);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_my, viewGroup, false);
        i.a((Object) inflate, "inflater.inflate(R.layou…ent_my, container, false)");
        a(inflate);
        e();
        f();
        g();
        h();
        return a();
    }

    @Override // androidx.fragment.app.d
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        h hVar = h.f5876a;
        e activity = getActivity();
        if (activity == null) {
            i.a();
        }
        i.a((Object) activity, "this.activity!!");
        hVar.a(activity, getResources().getColor(R.color.colorWhite), true);
        g();
        e();
        h();
    }

    public final void e() {
        ConfigModel t;
        if (com.speed.speed_library.b.g.f5610b.t() != null && (t = com.speed.speed_library.b.g.f5610b.t()) != null && t.is_show_pc_scan() == 1) {
            ((ImageView) a().findViewById(R.id.iv_right_two)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_scan));
            ImageView imageView = (ImageView) a().findViewById(R.id.iv_right_two);
            i.a((Object) imageView, "mRootView.iv_right_two");
            imageView.setVisibility(0);
        } else {
            ImageView imageView2 = (ImageView) a().findViewById(R.id.iv_right_two);
            i.a((Object) imageView2, "mRootView.iv_right_two");
            imageView2.setVisibility(8);
        }
        q.rorbin.badgeview.a a2 = new q.rorbin.badgeview.e(getActivity()).a((ImageView) a().findViewById(R.id.iv_right));
        i.a((Object) a2, "QBadgeView(this.activity…arget(mRootView.iv_right)");
        this.f = a2;
        i();
    }

    public final void f() {
        a aVar = this;
        ((RelativeLayout) a().findViewById(R.id.rl_menu_preferential)).setOnClickListener(aVar);
        ((RelativeLayout) a().findViewById(R.id.rl_menu_share)).setOnClickListener(aVar);
        ((RelativeLayout) a().findViewById(R.id.rl_menu_setting_more)).setOnClickListener(aVar);
        ((RelativeLayout) a().findViewById(R.id.rl_menu_setting_about)).setOnClickListener(aVar);
        ((RelativeLayout) a().findViewById(R.id.tv_check_in)).setOnClickListener(aVar);
        ((RelativeLayout) a().findViewById(R.id.rl_menu_common_problem)).setOnClickListener(aVar);
        ((RelativeLayout) a().findViewById(R.id.rl_menu_setting_feedback)).setOnClickListener(aVar);
        ((RelativeLayout) a().findViewById(R.id.rl_menu_ad)).setOnClickListener(aVar);
        ((TextView) a().findViewById(R.id.tv_account)).setOnClickListener(aVar);
        ((RelativeLayout) a().findViewById(R.id.rl_my_buy)).setOnClickListener(aVar);
        ((LinearLayout) a().findViewById(R.id.ll_right)).setOnClickListener(aVar);
        ((TextView) a().findViewById(R.id.tv_normal_vip_buy)).setOnClickListener(aVar);
        ((TextView) a().findViewById(R.id.tv_vip_rebuy)).setOnClickListener(aVar);
        ((TextView) a().findViewById(R.id.tv_vip_buy_renew)).setOnClickListener(aVar);
        ((TextView) a().findViewById(R.id.tv_svip_buy)).setOnClickListener(aVar);
        ((TextView) a().findViewById(R.id.tv_svip_buy_renew)).setOnClickListener(aVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (RelativeLayout) a().findViewById(R.id.tv_check_in))) {
            d.f5631a.a(3);
            e activity = getActivity();
            if (activity == null) {
                i.a();
            }
            i.a((Object) activity, "this.activity!!");
            com.speed.speed_library.widget.a.b bVar = new com.speed.speed_library.widget.a.b(activity);
            bVar.setCanceledOnTouchOutside(true);
            bVar.show();
        } else if (i.a(view, (RelativeLayout) a().findViewById(R.id.rl_my_buy))) {
            com.speed.speed_library.b.c cVar = com.speed.speed_library.b.c.f5594a;
            e activity2 = getActivity();
            if (activity2 == null) {
                i.a();
            }
            i.a((Object) activity2, "activity!!");
            cVar.a(activity2, com.speed.speed_library.b.b.f5592a.a("vip"), "常见问题");
        } else if (i.a(view, (RelativeLayout) a().findViewById(R.id.rl_menu_preferential))) {
            if (!com.speed.speed_library.business.e.f5632a.b()) {
                f.a("登录异常，请稍后再试", 0, 2, null);
                com.speed.speed_library.business.a.f5623a.f();
                return;
            }
            com.speed.speed_library.b.c cVar2 = com.speed.speed_library.b.c.f5594a;
            Context context = getContext();
            if (context == null) {
                i.a();
            }
            i.a((Object) context, "this.context!!");
            cVar2.a(context, com.speed.speed_library.b.b.f5592a.d(), "优惠券");
            d.f5631a.a(4);
        } else if (i.a(view, (RelativeLayout) a().findViewById(R.id.rl_menu_share))) {
            if (!com.speed.speed_library.business.e.f5632a.b()) {
                f.a("登录异常，请稍后再试", 0, 2, null);
                com.speed.speed_library.business.a.f5623a.f();
                return;
            }
            com.speed.speed_library.b.c cVar3 = com.speed.speed_library.b.c.f5594a;
            Context context2 = getContext();
            if (context2 == null) {
                i.a();
            }
            i.a((Object) context2, "this.context!!");
            cVar3.a(context2, com.speed.speed_library.b.b.f5592a.c(), "分享");
            d.a(d.f5631a, 1, 0, 0, 6, null);
            com.speed.speed_library.b.g gVar = com.speed.speed_library.b.g.f5610b;
            UserModel j = com.speed.speed_library.b.g.f5610b.j();
            if (j == null) {
                i.a();
            }
            gVar.h(j.getSpread_count());
            i();
        } else if (i.a(view, (RelativeLayout) a().findViewById(R.id.rl_menu_setting_more))) {
            e activity3 = getActivity();
            if (activity3 != null) {
                activity3.startActivity(new Intent(getActivity(), ProtectKillActivity.class));
            }
        } else if (i.a(view, (RelativeLayout) a().findViewById(R.id.rl_menu_setting_about))) {
            e activity4 = getActivity();
            if (activity4 != null) {
                activity4.startActivity(new Intent(getActivity(), AboutActivity.class));
            }
        } else if (i.a(view, (TextView) a().findViewById(R.id.tv_normal_vip_buy)) || i.a(view, (TextView) a().findViewById(R.id.tv_vip_rebuy)) || i.a(view, (TextView) a().findViewById(R.id.tv_vip_buy_renew))) {
            com.speed.speed_library.b.c cVar4 = com.speed.speed_library.b.c.f5594a;
            e activity5 = getActivity();
            if (activity5 == null) {
                i.a();
            }
            i.a((Object) activity5, "this.activity!!");
            cVar4.a(activity5, com.speed.speed_library.b.b.f5592a.a("vip"), "套餐");
        } else if (i.a(view, (TextView) a().findViewById(R.id.tv_svip_buy)) || i.a(view, (TextView) a().findViewById(R.id.tv_svip_buy_renew))) {
            com.speed.speed_library.b.c cVar5 = com.speed.speed_library.b.c.f5594a;
            e activity6 = getActivity();
            if (activity6 == null) {
                i.a();
            }
            i.a((Object) activity6, "this.activity!!");
            cVar5.a(activity6, com.speed.speed_library.b.b.f5592a.a("svip"), "套餐");
        } else if (i.a(view, (RelativeLayout) a().findViewById(R.id.rl_menu_common_problem))) {
            com.speed.speed_library.b.c cVar6 = com.speed.speed_library.b.c.f5594a;
            e activity7 = getActivity();
            if (activity7 == null) {
                i.a();
            }
            i.a((Object) activity7, "activity!!");
            cVar6.a(activity7, com.speed.speed_library.b.b.f5592a.b(), "常见问题");
            d.f5631a.a(2);
        } else if (i.a(view, (RelativeLayout) a().findViewById(R.id.rl_menu_setting_feedback))) {
            e activity8 = getActivity();
            if (activity8 == null) {
                i.a();
            }
            e activity9 = getActivity();
            if (activity9 == null) {
                i.a();
            }
            activity8.startActivity(new Intent(activity9, FeedbackActivity.class));
            d.f5631a.a(12);
        } else if (i.a(view, (RelativeLayout) a().findViewById(R.id.rl_menu_ad))) {
            com.speed.speed_library.b.c cVar7 = com.speed.speed_library.b.c.f5594a;
            e activity10 = getActivity();
            if (activity10 == null) {
                i.a();
            }
            i.a((Object) activity10, "activity!!");
            cVar7.a(activity10, com.speed.speed_library.b.b.f5592a.i(), "商务合作");
        } else if (i.a(view, (TextView) a().findViewById(R.id.tv_account))) {
            if (!com.speed.speed_library.business.e.f5632a.b()) {
                f.a("当前账号暂未登录，请先登录", 0, 2, null);
                com.speed.speed_library.business.a.f5623a.f();
                return;
            }
            e activity11 = getActivity();
            if (activity11 == null) {
                i.a();
            }
            startActivity(new Intent(activity11, AccountActivity.class));
        } else if (i.a(view, (LinearLayout) a().findViewById(R.id.ll_right))) {
            e activity12 = getActivity();
            if (activity12 == null) {
                i.a();
            }
            startActivity(new Intent(activity12, ProtectKillActivity.class));
        }
    }

    public final void g() {
        if (com.speed.speed_library.business.e.f5632a.b()) {
            UserModel j = com.speed.speed_library.b.g.f5610b.j();
            if (!TextUtils.isEmpty(j != null ? j.getPhone() : null)) {
                TextView textView = (TextView) a().findViewById(R.id.tv_account);
                i.a((Object) textView, "mRootView.tv_account");
                StringBuilder sb = new StringBuilder();
                sb.append("账号: ");
                UserModel j2 = com.speed.speed_library.b.g.f5610b.j();
                sb.append(j2 != null ? j2.getPhone() : null);
                textView.setText(sb.toString());
            } else {
                TextView textView2 = (TextView) a().findViewById(R.id.tv_account);
                i.a((Object) textView2, "mRootView.tv_account");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ID: ");
                UserModel j3 = com.speed.speed_library.b.g.f5610b.j();
                sb2.append(j3 != null ? Integer.valueOf(j3.getUid()) : null);
                textView2.setText(sb2.toString());
            }
            UserModel j4 = com.speed.speed_library.b.g.f5610b.j();
            Long valueOf = j4 != null ? Long.valueOf(j4.getExpire_time()) : null;
            if (valueOf == null) {
                i.a();
            }
            if (valueOf.longValue() > com.speed.speed_library.business.e.f5632a.a()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("到期: ");
                com.speed.speed_library.b.c cVar = com.speed.speed_library.b.c.f5594a;
                UserModel j5 = com.speed.speed_library.b.g.f5610b.j();
                Long valueOf2 = j5 != null ? Long.valueOf(j5.getExpire_time()) : null;
                if (valueOf2 == null) {
                    i.a();
                }
                sb3.append(cVar.a(valueOf2.longValue()));
                this.f5735c = sb3.toString();
                UserModel j6 = com.speed.speed_library.b.g.f5610b.j();
                Long valueOf3 = j6 != null ? Long.valueOf(j6.getVip_expire_time()) : null;
                if (valueOf3 == null) {
                    i.a();
                }
                if (valueOf3.longValue() > com.speed.speed_library.business.e.f5632a.a()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("到期: ");
                    com.speed.speed_library.b.c cVar2 = com.speed.speed_library.b.c.f5594a;
                    UserModel j7 = com.speed.speed_library.b.g.f5610b.j();
                    Long valueOf4 = j7 != null ? Long.valueOf(j7.getVip_expire_time()) : null;
                    if (valueOf4 == null) {
                        i.a();
                    }
                    sb4.append(cVar2.a(valueOf4.longValue()));
                    this.f5736d = sb4.toString();
                    LinearLayout linearLayout = (LinearLayout) a().findViewById(R.id.ll_have_vip_no_svip);
                    i.a((Object) linearLayout, "mRootView.ll_have_vip_no_svip");
                    linearLayout.setVisibility(8);
                    RelativeLayout relativeLayout = (RelativeLayout) a().findViewById(R.id.rl_no_vip_no_svip);
                    i.a((Object) relativeLayout, "mRootView.rl_no_vip_no_svip");
                    relativeLayout.setVisibility(8);
                    LinearLayout linearLayout2 = (LinearLayout) a().findViewById(R.id.ll_have_vip_have_svip);
                    i.a((Object) linearLayout2, "mRootView.ll_have_vip_have_svip");
                    linearLayout2.setVisibility(0);
                    TextView textView3 = (TextView) a().findViewById(R.id.tv_vip_expire_two);
                    i.a((Object) textView3, "mRootView.tv_vip_expire_two");
                    textView3.setText(this.f5735c);
                    TextView textView4 = (TextView) a().findViewById(R.id.tv_svip_expire);
                    i.a((Object) textView4, "mRootView.tv_svip_expire");
                    textView4.setText(this.f5736d);
                } else {
                    UserModel j8 = com.speed.speed_library.b.g.f5610b.j();
                    if (j8 != null && j8.getType() == 1) {
                        this.f5736d = "您的免费时间已到期";
                    } else {
                        UserModel j9 = com.speed.speed_library.b.g.f5610b.j();
                        if (j9 != null && j9.getType() == 2) {
                            this.f5736d = "您的服务时间已到期";
                        }
                    }
                    RelativeLayout relativeLayout2 = (RelativeLayout) a().findViewById(R.id.rl_no_vip_no_svip);
                    i.a((Object) relativeLayout2, "mRootView.rl_no_vip_no_svip");
                    relativeLayout2.setVisibility(8);
                    LinearLayout linearLayout3 = (LinearLayout) a().findViewById(R.id.ll_have_vip_have_svip);
                    i.a((Object) linearLayout3, "mRootView.ll_have_vip_have_svip");
                    linearLayout3.setVisibility(8);
                    LinearLayout linearLayout4 = (LinearLayout) a().findViewById(R.id.ll_have_vip_no_svip);
                    i.a((Object) linearLayout4, "mRootView.ll_have_vip_no_svip");
                    linearLayout4.setVisibility(0);
                    TextView textView5 = (TextView) a().findViewById(R.id.tv_vip_expire);
                    i.a((Object) textView5, "mRootView.tv_vip_expire");
                    textView5.setText(this.f5735c);
                }
            } else {
                UserModel j10 = com.speed.speed_library.b.g.f5610b.j();
                if (j10 != null && j10.getType() == 1) {
                    this.f5735c = "您的免费时间已到期";
                } else {
                    UserModel j11 = com.speed.speed_library.b.g.f5610b.j();
                    if (j11 != null && j11.getType() == 2) {
                        this.f5735c = "您的服务时间已到期";
                    }
                }
                LinearLayout linearLayout5 = (LinearLayout) a().findViewById(R.id.ll_have_vip_have_svip);
                i.a((Object) linearLayout5, "mRootView.ll_have_vip_have_svip");
                linearLayout5.setVisibility(8);
                LinearLayout linearLayout6 = (LinearLayout) a().findViewById(R.id.ll_have_vip_no_svip);
                i.a((Object) linearLayout6, "mRootView.ll_have_vip_no_svip");
                linearLayout6.setVisibility(8);
                RelativeLayout relativeLayout3 = (RelativeLayout) a().findViewById(R.id.rl_no_vip_no_svip);
                i.a((Object) relativeLayout3, "mRootView.rl_no_vip_no_svip");
                relativeLayout3.setVisibility(0);
            }
        } else {
            TextView textView6 = (TextView) a().findViewById(R.id.tv_account);
            i.a((Object) textView6, "mRootView.tv_account");
            textView6.setText("");
        }
        ConfigModel t = com.speed.speed_library.b.g.f5610b.t();
        if (t != null && t.getShow_share_view() == 0) {
            RelativeLayout relativeLayout4 = (RelativeLayout) a().findViewById(R.id.rl_menu_share);
            i.a((Object) relativeLayout4, "mRootView.rl_menu_share");
            relativeLayout4.setVisibility(8);
            LinearLayout linearLayout7 = (LinearLayout) a().findViewById(R.id.ll_menu_share_line);
            i.a((Object) linearLayout7, "mRootView.ll_menu_share_line");
            linearLayout7.setVisibility(8);
            return;
        }
        RelativeLayout relativeLayout5 = (RelativeLayout) a().findViewById(R.id.rl_menu_share);
        i.a((Object) relativeLayout5, "mRootView.rl_menu_share");
        relativeLayout5.setVisibility(0);
        LinearLayout linearLayout8 = (LinearLayout) a().findViewById(R.id.ll_menu_share_line);
        i.a((Object) linearLayout8, "mRootView.ll_menu_share_line");
        linearLayout8.setVisibility(0);
    }

    public final void h() {
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
        this.f5737e = sb.toString();
    }

    public final void i() {
        if (com.speed.speed_library.b.g.f5610b.f() > com.speed.speed_library.b.g.f5610b.u()) {
            View findViewById = a().findViewById(R.id.view_dot_red_feedback);
            i.a((Object) findViewById, "mRootView.view_dot_red_feedback");
            findViewById.setVisibility(0);
        } else {
            View findViewById2 = a().findViewById(R.id.view_dot_red_feedback);
            i.a((Object) findViewById2, "mRootView.view_dot_red_feedback");
            findViewById2.setVisibility(8);
        }
        if (com.speed.speed_library.b.g.f5610b.d() > com.speed.speed_library.utils.e.b(com.speed.speed_library.b.g.f5610b.a())) {
            q.rorbin.badgeview.a aVar = this.f;
            if (aVar == null) {
                i.b("mSettingBadge");
            }
            aVar.a(-1);
        } else {
            q.rorbin.badgeview.a aVar2 = this.f;
            if (aVar2 == null) {
                i.b("mSettingBadge");
            }
            aVar2.a(0);
        }
        if (com.speed.speed_library.business.e.f5632a.b()) {
            UserModel j = com.speed.speed_library.b.g.f5610b.j();
            Integer valueOf = j != null ? Integer.valueOf(j.getSpread_count()) : null;
            if (valueOf == null) {
                i.a();
            }
            if (valueOf.intValue() > com.speed.speed_library.b.g.f5610b.w()) {
                View findViewById3 = a().findViewById(R.id.view_dot_red_share);
                i.a((Object) findViewById3, "mRootView.view_dot_red_share");
                findViewById3.setVisibility(0);
                return;
            }
        }
        View findViewById4 = a().findViewById(R.id.view_dot_red_share);
        i.a((Object) findViewById4, "mRootView.view_dot_red_share");
        findViewById4.setVisibility(8);
    }

    @m(a = ThreadMode.MAIN)
    public final void userInfoEvent(UserInfoEvent userInfoEvent) {
        i.b(userInfoEvent, "event");
        g();
    }

    @m(a = ThreadMode.MAIN)
    public final void badgeEvent(BadgeEvent badgeEvent) {
        i.b(badgeEvent, "event");
        i();
    }
}
