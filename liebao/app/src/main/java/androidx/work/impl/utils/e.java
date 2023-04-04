package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: Preferences.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f3043a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f3044b;

    public e(Context context) {
        this.f3043a = context;
    }

    public boolean a() {
        return b().getBoolean("reschedule_needed", false);
    }

    public void a(boolean z) {
        b().edit().putBoolean("reschedule_needed", z).apply();
    }

    private SharedPreferences b() {
        SharedPreferences sharedPreferences;
        synchronized (e.class) {
            if (this.f3044b == null) {
                this.f3044b = this.f3043a.getSharedPreferences("androidx.work.util.preferences", 0);
            }
            sharedPreferences = this.f3044b;
        }
        return sharedPreferences;
    }
}
