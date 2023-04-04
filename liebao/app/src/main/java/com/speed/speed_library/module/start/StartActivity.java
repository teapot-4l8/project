package com.speed.speed_library.module.start;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.app.b;
import com.orhanobut.hawk.Hawk;
import com.snail.antifake.jni.EmulatorDetectUtil;
import com.speed.speed_library.R;
import com.speed.speed_library.b.e;
import com.speed.speed_library.b.f;
import com.speed.speed_library.b.g;
import com.speed.speed_library.model.BootStrapModel;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.module.main.MainActivity;
import com.speed.speed_library.utils.DeviceUtils;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.d.b.i;
import leavesc.hello.monitor.holder.ContextHolder;
import ml.w568w.checkxposed.util.NativeDetect;
import ml.w568w.library.XposedDetect;
import utils.AppLog;

/* compiled from: StartActivity.kt */
/* loaded from: classes2.dex */
public final class StartActivity extends com.speed.speed_library.a.a {
    public b.a k;
    private final int l = 1;
    private final int m = 2;
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

    public final int l() {
        return this.m;
    }

    public final b.a m() {
        b.a aVar = this.k;
        if (aVar == null) {
            i.b("dialog");
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    // 这里先执行
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setContentView(R.layout.activity_start);
        if (DeviceUtils.a()) { // 检测root
            f.a(getResources().getString(R.string.toast_app_fail) + ",", 0, 2, null);
            return;
        }
        StartActivity startActivity = this;
        if (EmulatorDetectUtil.a(startActivity)) { // 模拟器检测
            f.a(getResources().getString(R.string.toast_app_fail) + ".", 0, 2, null);
        } else if (DeviceUtils.AntiRoot().equals("yes")) { // 检测root ida更改值
            f.a(getResources().getString(R.string.toast_app_fail) + "!", 0, 2, null);
        } else {
            if (g.f5610b.t() == null || g.f5610b.ac() == 1) {
                if (NativeDetect.detectXposed(Process.myPid())) { // 检测xposed是否在运行 false
                    g.f5610b.ab();
                    f.a(getResources().getString(R.string.toast_app_fail) + ";", 0, 2, null);
                    return;
                } else if (XposedDetect.a(getPackageManager()).a()) { // 检测xposed 我把这段smali都删了
                    f.a(getResources().getString(R.string.toast_app_fail) + ":", 0, 2, null); // 显示提示
                    return;
                }
            }
            if (com.speed.speed_library.utils.g.f5871a.b(startActivity)) { // 检测代理
                String string = getResources().getString(R.string.toast_api_proxy_fail);
                i.a((Object) string, "resources.getString(R.string.toast_api_proxy_fail)");
                f.a(string, 0, 2, null);
                return;
            }
            PackageManager packageManager = g.f5610b.a().getPackageManager();
            i.a((Object) packageManager, "Global.context.getPackageManager()");
            try {
                String packageName = getPackageName();
                if (packageName == null) {
                    i.a();
                }
                Signature[] signatureArr = packageManager.getPackageInfo(packageName, 64).signatures;
                i.a((Object) signatureArr, "packageInfo.signatures");
                i = signatureArr[0].hashCode(); // hook看看i是什么
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                i = 0;
            }
            AppLog appLog = AppLog.INSTANCE;
            appLog.d("4444444::" + i);
            if (i != com.speed.speed_library.b.d.f5595a.c()) { // 签名校验？
                                                                // 用MT重新签名会使so文件的修改失效
                f.a(getResources().getString(R.string.toast_app_fail) + "!!", 0, 2, null);
                return;
            }
            if (g.f5610b.Y() == 0) {
                g.f5610b.X();
                g.f5610b.q();
                g.f5610b.s();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = getWindow();
                window.clearFlags(67108864);
                window.getDecorView().setSystemUiVisibility(1280);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            }
            if (com.speed.speed_library.b.i.f5619a.c() != null) {
                ((ImageView) d(R.id.iv_start)).setImageBitmap(com.speed.speed_library.b.i.f5619a.c());
            } else {
                try {
                    InputStream open = getAssets().open("ic_launcher_start.png");
                    i.a((Object) open, "assets.open(\"ic_launcher_start\" + \".png\")");
                    ((ImageView) d(R.id.iv_start)).setImageBitmap(BitmapFactory.decodeStream(open));
                } catch (Exception unused) {
                    f.a("请设置启动页图片,并命名为ic_launcher_start.png", 0, 2, null);
                }
            }
            this.k = new b.a(startActivity);
            n();
        }
    }

    public final void n() {
        if (Build.VERSION.SDK_INT > 21) {
            if (androidx.core.app.a.b(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                androidx.core.app.a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, this.l);
                return;
            } else {
                p();
                return;
            }
        }
        p();
    }

    @Override // androidx.fragment.app.e, android.app.Activity, androidx.core.app.a.InterfaceC0030a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        i.b(strArr, "permissions");
        i.b(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == this.l) {
            boolean z = false;
            if (iArr.length > 0 && iArr[0] == 0) {
                AppLog.INSTANCE.i("获取权限成功");
                p();
                return;
            }
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                } else if (shouldShowRequestPermissionRationale(strArr[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                n();
                AppLog.INSTANCE.i("权限禁止");
                return;
            }
            o();
        }
    }

    public final void o() {
        b.a aVar = this.k;
        if (aVar == null) {
            i.b("dialog");
        }
        aVar.b(getString(R.string.permission_to_setting_agree)).a(false).a("设置", new b()).b(getString(R.string.cancle), new c()).b();
        b.a aVar2 = this.k;
        if (aVar2 == null) {
            i.b("dialog");
        }
        aVar2.c();
    }

    /* compiled from: StartActivity.kt */
    /* loaded from: classes2.dex */
    static final class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", com.speed.speed_library.b.c.f5594a.b(), null));
            StartActivity startActivity = StartActivity.this;
            startActivity.startActivityForResult(intent, startActivity.l());
        }
    }

    /* compiled from: StartActivity.kt */
    /* loaded from: classes2.dex */
    static final class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            StartActivity.this.m().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        n();
    }

    public final void p() {
        q();
        e.f5601a.a(g.f5610b.a()).a();
        new Handler().postDelayed(new a(), 400L);
    }

    /* compiled from: StartActivity.kt */
    /* loaded from: classes2.dex */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.speed.speed_library.business.a.f5623a.d();
            com.speed.speed_library.business.b.f5625a.a();
            com.speed.speed_library.business.a.f5623a.c();
            com.speed.speed_library.business.a.f5623a.h();
            com.speed.speed_library.business.a.f5623a.i();
            StartActivity.this.r();
            com.speed.speed_library.business.d.f5631a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        if (g.f5610b.n() != null) {
            BootStrapModel n = g.f5610b.n();
            if (!TextUtils.isEmpty(n != null ? n.getImg_url() : null)) {
                BootStrapModel n2 = g.f5610b.n();
                String str = (String) Hawk.get(n2 != null ? n2.getImg_url() : null, "");
                if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                    Intent intent = new Intent(this, AdvertActivity.class);
                    intent.putExtra(com.speed.speed_library.b.d.f5595a.e(), str);
                    String f = com.speed.speed_library.b.d.f5595a.f();
                    BootStrapModel n3 = g.f5610b.n();
                    intent.putExtra(f, n3 != null ? Integer.valueOf(n3.getSkip_time()) : null);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        }
        new Handler().postDelayed(new d(), 1500L);
    }

    /* compiled from: StartActivity.kt */
    /* loaded from: classes2.dex */
    static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.speed.speed_library.business.a.f5623a.f();
            StartActivity.this.startActivity(new Intent(StartActivity.this, MainActivity.class));
            StartActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, android.app.Activity
    public void onNewIntent(Intent intent) {
        i.b(intent, "intent");
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    public final void q() {
        UserModel j;
        try {
            if (com.speed.speed_library.business.e.f5632a.b() && (j = g.f5610b.j()) != null && j.getWhitelist() == 1) {
                ContextHolder.setContext(g.f5610b.a());
                new leavesc.hello.monitor.c.a().b();
                new leavesc.hello.monitor.c.a().c();
                leavesc.hello.monitor.a.a(false);
            }
        } catch (Exception unused) {
        }
    }
}
