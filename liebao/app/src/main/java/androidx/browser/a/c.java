package androidx.browser.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;

/* compiled from: CustomTabsIntent.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f1220a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f1221b;

    public void a(Context context, Uri uri) {
        this.f1220a.setData(uri);
        androidx.core.content.b.a(context, this.f1220a, this.f1221b);
    }

    c(Intent intent, Bundle bundle) {
        this.f1220a = intent;
        this.f1221b = bundle;
    }

    /* compiled from: CustomTabsIntent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Intent f1222a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<Bundle> f1223b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f1224c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<Bundle> f1225d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1226e;

        public a() {
            this(null);
        }

        public a(e eVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.f1222a = intent;
            this.f1223b = null;
            this.f1224c = null;
            this.f1225d = null;
            this.f1226e = true;
            if (eVar != null) {
                intent.setPackage(eVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            androidx.core.app.e.a(bundle, "android.support.customtabs.extra.SESSION", eVar != null ? eVar.a() : null);
            this.f1222a.putExtras(bundle);
        }

        public c a() {
            ArrayList<Bundle> arrayList = this.f1223b;
            if (arrayList != null) {
                this.f1222a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f1225d;
            if (arrayList2 != null) {
                this.f1222a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f1222a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f1226e);
            return new c(this.f1222a, this.f1224c);
        }
    }
}
