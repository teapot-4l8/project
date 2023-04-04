package com.lxj.xpopup.g.a;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: NavigationBarObserver.java */
/* loaded from: classes2.dex */
public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<c> f5511a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5512b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f5513c;

    public static a a() {
        return C0128a.f5514a;
    }

    private a() {
        super(new Handler(Looper.getMainLooper()));
        this.f5513c = false;
    }

    public void a(Context context) {
        this.f5512b = context.getApplicationContext();
        if (Build.VERSION.SDK_INT < 17 || context == null || context.getContentResolver() == null || this.f5513c.booleanValue()) {
            return;
        }
        Uri uri = null;
        if (b.a()) {
            uri = Settings.Global.getUriFor("force_fsg_nav_bar");
        } else if (b.b()) {
            if (b.f() || Build.VERSION.SDK_INT < 21) {
                uri = Settings.System.getUriFor("navigationbar_is_min");
            } else {
                uri = Settings.Global.getUriFor("navigationbar_is_min");
            }
        }
        if (uri != null) {
            context.getContentResolver().registerContentObserver(uri, true, this);
            this.f5513c = true;
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        ArrayList<c> arrayList;
        int i;
        super.onChange(z);
        if (Build.VERSION.SDK_INT < 17 || (context = this.f5512b) == null || context.getContentResolver() == null || (arrayList = this.f5511a) == null || arrayList.isEmpty()) {
            return;
        }
        if (b.a()) {
            i = Settings.Global.getInt(this.f5512b.getContentResolver(), "force_fsg_nav_bar", 0);
        } else if (!b.b()) {
            i = 0;
        } else if (b.f() || Build.VERSION.SDK_INT < 21) {
            i = Settings.System.getInt(this.f5512b.getContentResolver(), "navigationbar_is_min", 0);
        } else {
            i = Settings.Global.getInt(this.f5512b.getContentResolver(), "navigationbar_is_min", 0);
        }
        Iterator<c> it = this.f5511a.iterator();
        while (it.hasNext()) {
            c next = it.next();
            boolean z2 = true;
            if (i == 1) {
                z2 = false;
            }
            next.a(z2);
        }
    }

    public void a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (this.f5511a == null) {
            this.f5511a = new ArrayList<>();
        }
        if (this.f5511a.contains(cVar)) {
            return;
        }
        this.f5511a.add(cVar);
    }

    public void b(c cVar) {
        ArrayList<c> arrayList;
        if (this.f5513c.booleanValue()) {
            this.f5512b.getContentResolver().unregisterContentObserver(this);
            this.f5513c = false;
        }
        this.f5512b = null;
        if (cVar == null || (arrayList = this.f5511a) == null) {
            return;
        }
        arrayList.remove(cVar);
    }

    /* compiled from: NavigationBarObserver.java */
    /* renamed from: com.lxj.xpopup.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0128a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f5514a = new a();
    }
}
