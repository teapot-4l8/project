package com.lxj.xpermission;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class XPermission {

    /* renamed from: a  reason: collision with root package name */
    private static List<String> f5356a;

    /* renamed from: b  reason: collision with root package name */
    private static XPermission f5357b;
    private static c m;
    private static c n;

    /* renamed from: c  reason: collision with root package name */
    private Context f5358c;

    /* renamed from: d  reason: collision with root package name */
    private b f5359d;

    /* renamed from: e  reason: collision with root package name */
    private c f5360e;
    private a f;
    private d g;
    private Set<String> h;
    private List<String> i;
    private List<String> j;
    private List<String> k;
    private List<String> l;

    /* loaded from: classes.dex */
    public interface a {
        void a(List<String> list);

        void a(List<String> list, List<String> list2);
    }

    /* loaded from: classes.dex */
    public interface b {

        /* loaded from: classes.dex */
        public interface a {
        }

        void a(a aVar);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(Activity activity);
    }

    public List<String> a() {
        return a(this.f5358c.getPackageName());
    }

    public List<String> a(String str) {
        try {
            String[] strArr = this.f5358c.getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            if (strArr == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return Collections.emptyList();
        }
    }

    private boolean b(String str) {
        return Build.VERSION.SDK_INT < 23 || androidx.core.content.b.b(this.f5358c, str) == 0;
    }

    public boolean b() {
        return Settings.System.canWrite(this.f5358c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + this.f5358c.getPackageName()));
        if (!a(intent)) {
            d();
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public boolean c() {
        if (Build.VERSION.SDK_INT >= 26) {
            AppOpsManager appOpsManager = (AppOpsManager) this.f5358c.getSystemService("appops");
            if (appOpsManager == null) {
                return false;
            }
            int checkOpNoThrow = appOpsManager.checkOpNoThrow("android:system_alert_window", Process.myUid(), this.f5358c.getPackageName());
            return checkOpNoThrow == 0 || checkOpNoThrow == 1;
        }
        return Settings.canDrawOverlays(this.f5358c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, int i) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + this.f5358c.getPackageName()));
        if (!a(intent)) {
            d();
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public void d() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + this.f5358c.getPackageName()));
        if (a(intent)) {
            this.f5358c.startActivity(intent.addFlags(268435456));
        }
    }

    public static XPermission a(Context context, String... strArr) {
        XPermission xPermission = f5357b;
        if (xPermission == null) {
            return new XPermission(context, strArr);
        }
        xPermission.a(strArr);
        return f5357b;
    }

    private boolean a(Intent intent) {
        return this.f5358c.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    private XPermission(Context context, String... strArr) {
        f5357b = this;
        this.f5358c = context;
        a(strArr);
    }

    private void a(String... strArr) {
        String[] a2;
        this.h = new LinkedHashSet();
        f5356a = a();
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            for (String str2 : com.lxj.xpermission.a.a(str)) {
                if (f5356a.contains(str2)) {
                    this.h.add(str2);
                }
            }
        }
    }

    public XPermission a(c cVar) {
        this.f5360e = cVar;
        return this;
    }

    public void e() {
        this.j = new ArrayList();
        this.i = new ArrayList();
        if (Build.VERSION.SDK_INT < 23) {
            this.j.addAll(this.h);
            j();
            return;
        }
        for (String str : this.h) {
            if (b(str)) {
                this.j.add(str);
            } else {
                this.i.add(str);
            }
        }
        if (this.i.isEmpty()) {
            j();
        } else {
            i();
        }
    }

    private void i() {
        this.k = new ArrayList();
        this.l = new ArrayList();
        PermissionActivity.a(this.f5358c, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Activity activity) {
        boolean z = false;
        if (this.f5359d != null) {
            Iterator<String> it = this.i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (activity.shouldShowRequestPermissionRationale(it.next())) {
                    b(activity);
                    this.f5359d.a(new b.a() { // from class: com.lxj.xpermission.XPermission.1
                    });
                    z = true;
                    break;
                }
            }
            this.f5359d = null;
        }
        return z;
    }

    private void b(Activity activity) {
        for (String str : this.i) {
            if (b(str)) {
                this.j.add(str);
            } else {
                this.k.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.l.add(str);
                }
            }
        }
    }

    private void j() {
        if (this.f5360e != null) {
            if (this.i.size() == 0 || this.h.size() == this.j.size()) {
                this.f5360e.a();
            } else if (!this.k.isEmpty()) {
                this.f5360e.b();
            }
            this.f5360e = null;
        }
        if (this.f != null) {
            if (this.i.size() == 0 || this.h.size() == this.j.size()) {
                this.f.a(this.j);
            } else if (!this.k.isEmpty()) {
                this.f.a(this.l, this.k);
            }
            this.f = null;
        }
        this.f5359d = null;
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        b(activity);
        j();
    }

    /* loaded from: classes.dex */
    public static class PermissionActivity extends Activity {
        public static void a(Context context, int i) {
            Intent intent = new Intent(context, PermissionActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("TYPE", i);
            context.startActivity(intent);
        }

        @Override // android.app.Activity
        protected void onCreate(Bundle bundle) {
            getWindow().addFlags(262672);
            getWindow().getAttributes().alpha = 0.0f;
            int intExtra = getIntent().getIntExtra("TYPE", 1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    super.onCreate(bundle);
                    XPermission.f5357b.a(this, 2);
                } else if (intExtra == 3) {
                    super.onCreate(bundle);
                    XPermission.f5357b.b(this, 3);
                }
            } else if (XPermission.f5357b != null) {
                if (XPermission.f5357b.g != null) {
                    XPermission.f5357b.g.a(this);
                }
                super.onCreate(bundle);
                if (!XPermission.f5357b.a(this)) {
                    if (XPermission.f5357b.i != null) {
                        int size = XPermission.f5357b.i.size();
                        if (size > 0) {
                            requestPermissions((String[]) XPermission.f5357b.i.toArray(new String[size]), 1);
                            return;
                        } else {
                            finish();
                            return;
                        }
                    }
                    return;
                }
                finish();
            } else {
                super.onCreate(bundle);
                Log.e("XPermission", "request permissions failed");
                finish();
            }
        }

        @Override // android.app.Activity
        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            XPermission.f5357b.c(this);
            finish();
        }

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            finish();
            return true;
        }

        @Override // android.app.Activity
        protected void onActivityResult(int i, int i2, Intent intent) {
            if (i == 2) {
                if (XPermission.m == null) {
                    return;
                }
                if (XPermission.f5357b.b()) {
                    XPermission.m.a();
                } else {
                    XPermission.m.b();
                }
                c unused = XPermission.m = null;
            } else if (i == 3) {
                if (XPermission.n == null) {
                    return;
                }
                if (XPermission.f5357b.c()) {
                    XPermission.n.a();
                } else {
                    XPermission.n.b();
                }
                c unused2 = XPermission.n = null;
            }
            finish();
        }
    }
}
