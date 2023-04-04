package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f694a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f695b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f696c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f697d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f698e;

    public d() {
        super(null);
    }

    public d(Context context, int i) {
        super(context);
        this.f694a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f695b = theme;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void a(Configuration configuration) {
        if (this.f698e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f697d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f697d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    private Resources b() {
        if (this.f698e == null) {
            if (this.f697d == null) {
                this.f698e = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.f698e = createConfigurationContext(this.f697d).getResources();
            } else {
                Resources resources = super.getResources();
                Configuration configuration = new Configuration(resources.getConfiguration());
                configuration.updateFrom(this.f697d);
                this.f698e = new Resources(resources.getAssets(), resources.getDisplayMetrics(), configuration);
            }
        }
        return this.f698e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f694a != i) {
            this.f694a = i;
            c();
        }
    }

    public int a() {
        return this.f694a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f695b;
        if (theme != null) {
            return theme;
        }
        if (this.f694a == 0) {
            this.f694a = R.style.Theme_AppCompat_Light;
        }
        c();
        return this.f695b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f696c == null) {
                this.f696c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f696c;
        }
        return getBaseContext().getSystemService(str);
    }

    protected void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    private void c() {
        boolean z = this.f695b == null;
        if (z) {
            this.f695b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f695b.setTo(theme);
            }
        }
        a(this.f695b, this.f694a, z);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
