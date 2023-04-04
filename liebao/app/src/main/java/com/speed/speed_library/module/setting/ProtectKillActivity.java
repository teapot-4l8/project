package com.speed.speed_library.module.setting;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.google.gson.Gson;
import com.speed.speed_library.R;
import com.speed.speed_library.b.g;
import com.speed.speed_library.model.ConfigModel;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.model.WhiteListInfo;
import com.speed.speed_library.module.login.LoginActivity;
import java.util.HashMap;
import java.util.List;
import kotlin.d.b.i;
import utils.AppLog;

/* compiled from: ProtectKillActivity.kt */
/* loaded from: classes2.dex */
public final class ProtectKillActivity extends com.speed.speed_library.a.a implements View.OnClickListener {
    private HashMap k;

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.k.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_protect_kill);
        l();
        n();
    }

    public final void l() {
        ConfigModel t;
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("设置");
        TextView textView2 = (TextView) d(R.id.tv_version_name);
        i.a((Object) textView2, "tv_version_name");
        textView2.setText('V' + com.speed.speed_library.utils.e.a(g.f5610b.a()));
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(new e());
        m();
        if (g.f5610b.D() == 1) {
            Switch r0 = (Switch) d(R.id.switch_use_music);
            i.a((Object) r0, "switch_use_music");
            r0.setChecked(true);
        } else {
            Switch r02 = (Switch) d(R.id.switch_use_music);
            i.a((Object) r02, "switch_use_music");
            r02.setChecked(false);
        }
        if (g.f5610b.C() == 1) {
            Switch r03 = (Switch) d(R.id.switch_npv);
            i.a((Object) r03, "switch_npv");
            r03.setChecked(false);
        } else {
            Switch r04 = (Switch) d(R.id.switch_npv);
            i.a((Object) r04, "switch_npv");
            r04.setChecked(true);
        }
        if (g.f5610b.t() != null && (t = g.f5610b.t()) != null && t.is_show_use_music_backguard() == 0) {
            View d2 = d(R.id.rl_close_screen_line);
            i.a((Object) d2, "rl_close_screen_line");
            d2.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) d(R.id.rl_close_screen);
            i.a((Object) relativeLayout, "rl_close_screen");
            relativeLayout.setVisibility(8);
        } else {
            View d3 = d(R.id.rl_close_screen_line);
            i.a((Object) d3, "rl_close_screen_line");
            d3.setVisibility(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) d(R.id.rl_close_screen);
            i.a((Object) relativeLayout2, "rl_close_screen");
            relativeLayout2.setVisibility(0);
        }
        if (g.f5610b.U() == 1) {
            Switch r05 = (Switch) d(R.id.route_app_switch);
            i.a((Object) r05, "route_app_switch");
            r05.setChecked(true);
        } else {
            Switch r06 = (Switch) d(R.id.route_app_switch);
            i.a((Object) r06, "route_app_switch");
            r06.setChecked(false);
        }
        o();
        r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProtectKillActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ProtectKillActivity.this.finish();
        }
    }

    public final void m() {
        if (g.f5610b.t() != null) {
            ConfigModel t = g.f5610b.t();
            Integer valueOf = t != null ? Integer.valueOf(t.getRoute_control()) : null;
            if ((valueOf != null && valueOf.intValue() == -1) || (valueOf != null && valueOf.intValue() == 2)) {
                LinearLayout linearLayout = (LinearLayout) d(R.id.rl_setting_smart_route);
                i.a((Object) linearLayout, "rl_setting_smart_route");
                linearLayout.setVisibility(8);
                return;
            }
            LinearLayout linearLayout2 = (LinearLayout) d(R.id.rl_setting_smart_route);
            i.a((Object) linearLayout2, "rl_setting_smart_route");
            linearLayout2.setVisibility(0);
            AppLog appLog = AppLog.INSTANCE;
            appLog.d("rrrr" + g.f5610b.x());
            if (g.f5610b.x() == 0) {
                Switch r0 = (Switch) d(R.id.route_switch);
                i.a((Object) r0, "route_switch");
                r0.setChecked(false);
                return;
            }
            Switch r02 = (Switch) d(R.id.route_switch);
            i.a((Object) r02, "route_switch");
            r02.setChecked(true);
        }
    }

    public final void n() {
        ProtectKillActivity protectKillActivity = this;
        ((RelativeLayout) d(R.id.rl_update)).setOnClickListener(protectKillActivity);
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(protectKillActivity);
        ((RelativeLayout) d(R.id.rl_run)).setOnClickListener(protectKillActivity);
        ((RelativeLayout) d(R.id.rl_start_white)).setOnClickListener(protectKillActivity);
        ((RelativeLayout) d(R.id.rl_user_logout)).setOnClickListener(protectKillActivity);
        ((Switch) d(R.id.switch_use_music)).setOnCheckedChangeListener(new a());
        ((Switch) d(R.id.switch_npv)).setOnCheckedChangeListener(new b());
        ((Switch) d(R.id.route_switch)).setOnCheckedChangeListener(c.f5794a);
        ((Switch) d(R.id.route_app_switch)).setOnCheckedChangeListener(new d());
    }

    /* compiled from: ProtectKillActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                g.f5610b.n(1);
            } else {
                g.f5610b.n(0);
            }
        }
    }

    /* compiled from: ProtectKillActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                g.f5610b.m(0);
            } else {
                g.f5610b.m(1);
            }
            com.speed.speed_library.business.d.f5631a.a(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProtectKillActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public static final c f5794a = new c();

        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                g.f5610b.i(1);
            } else {
                g.f5610b.i(0);
            }
            com.speed.speed_library.business.d.f5631a.a(9);
            g.f5610b.j(1);
        }
    }

    /* compiled from: ProtectKillActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                g.f5610b.o(1);
                ProtectKillActivity.this.startActivity(new Intent(ProtectKillActivity.this, AppAgentActivity.class));
                return;
            }
            g.f5610b.o(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            finish();
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_run))) {
            p();
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_start_white))) {
            q();
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_update))) {
            com.speed.speed_library.business.update.fullupdate.a.f5646b.a(this, true);
        } else if (i.a(view, (RelativeLayout) d(R.id.rl_user_logout))) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra(com.speed.speed_library.b.d.f5595a.S(), "okBack");
            startActivity(intent);
        }
    }

    public final void o() {
        if (g.f5610b.j() != null) {
            UserModel j = g.f5610b.j();
            if (!TextUtils.isEmpty(j != null ? j.getPhone() : null)) {
                TextView textView = (TextView) d(R.id.tv_device_num);
                i.a((Object) textView, "tv_device_num");
                StringBuilder sb = new StringBuilder();
                UserModel j2 = g.f5610b.j();
                Integer valueOf = j2 != null ? Integer.valueOf(j2.getUse_device_num()) : null;
                if (valueOf == null) {
                    i.a();
                }
                sb.append(valueOf.intValue());
                sb.append('/');
                ConfigModel t = g.f5610b.t();
                sb.append(t != null ? Integer.valueOf(t.getLogin_device_limit()) : null);
                textView.setText(sb.toString());
                return;
            }
        }
        TextView textView2 = (TextView) d(R.id.tv_device_num);
        i.a((Object) textView2, "tv_device_num");
        textView2.setText("1/1");
    }

    public final void p() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Object systemService = getSystemService("power");
                if (systemService == null) {
                    throw new kotlin.i("null cannot be cast to non-null type android.os.PowerManager");
                }
                if (((PowerManager) systemService).isIgnoringBatteryOptimizations(getPackageName())) {
                    c(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
                    return;
                }
                Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                intent.setData(Uri.parse("package:" + getPackageName()));
                c(intent);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public final void q() {
        boolean z;
        String str;
        List<WhiteListInfo.IntentItem> intents;
        String brand;
        ProtectKillActivity protectKillActivity = this;
        String a2 = com.speed.speed_library.utils.e.a(protectKillActivity, "whitelist.json");
        i.a((Object) a2, "str");
        String packageName = getPackageName();
        i.a((Object) packageName, "packageName");
        WhiteListInfo whiteListInfo = (WhiteListInfo) new Gson().fromJson(kotlin.h.g.a(kotlin.h.g.a(a2, "{package}", packageName, false, 4, (Object) null), "{label}", com.speed.speed_library.b.c.f5594a.c(), false, 4, (Object) null), (Class<Object>) WhiteListInfo.class);
        StringBuilder sb = new StringBuilder();
        sb.append("size: ");
        List<WhiteListInfo.WhiteList> items = whiteListInfo.getItems();
        sb.append(items != null ? Integer.valueOf(items.size()) : null);
        Log.d("TAG", sb.toString());
        String str2 = Build.BRAND;
        Log.d("TAG", "brand: " + str2);
        List<WhiteListInfo.WhiteList> items2 = whiteListInfo.getItems();
        if (items2 != null) {
            z = false;
            for (WhiteListInfo.WhiteList whiteList : items2) {
                i.a((Object) str2, "brand");
                if (str2 == null) {
                    throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = str2.toLowerCase();
                i.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                WhiteListInfo.DeviceInfo device = whiteList.getDevice();
                if (device == null || (brand = device.getBrand()) == null) {
                    str = null;
                } else if (brand == null) {
                    throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
                } else {
                    str = brand.toLowerCase();
                    i.a((Object) str, "(this as java.lang.String).toLowerCase()");
                }
                if (lowerCase.equals(str) && (intents = whiteList.getIntents()) != null) {
                    for (WhiteListInfo.IntentItem intentItem : intents) {
                        Intent a3 = com.speed.speed_library.b.c.f5594a.a(intentItem);
                        if (com.speed.speed_library.b.c.f5594a.a(protectKillActivity, a3)) {
                            z = true;
                            a(intentItem.getTitle(), intentItem.getMessage(), a3);
                        }
                    }
                }
            }
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        String string = getString(R.string.setting_white_no);
        i.a((Object) string, "getString(R.string.setting_white_no)");
        com.speed.speed_library.b.f.a(string, 0, 2, null);
    }

    private final void a(String str, String str2, Intent intent) {
        AlertDialog.Builder title = new AlertDialog.Builder(this).setCancelable(false).setTitle(str);
        title.setMessage(str2 + " \n\n").setPositiveButton("确定", new f(intent)).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProtectKillActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Intent f5798b;

        f(Intent intent) {
            this.f5798b = intent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            ProtectKillActivity.this.c(this.f5798b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Intent intent) {
        try {
            startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            String string = getString(R.string.setting_white_no);
            i.a((Object) string, "getString(R.string.setting_white_no)");
            com.speed.speed_library.b.f.a(string, 0, 2, null);
        }
    }

    public final void r() {
        if (g.f5610b.d() > com.speed.speed_library.utils.e.b(g.f5610b.a())) {
            View d2 = d(R.id.dot_setting_red_version);
            i.a((Object) d2, "dot_setting_red_version");
            d2.setVisibility(0);
            return;
        }
        View d3 = d(R.id.dot_setting_red_version);
        i.a((Object) d3, "dot_setting_red_version");
        d3.setVisibility(8);
    }
}
