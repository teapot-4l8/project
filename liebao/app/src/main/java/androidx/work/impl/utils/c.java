package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: IdGenerator.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3039a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f3040b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3041c;

    public c(Context context) {
        this.f3039a = context;
    }

    public int a(int i, int i2) {
        synchronized (c.class) {
            b();
            int a2 = a("next_job_scheduler_id");
            if (a2 >= i && a2 <= i2) {
                i = a2;
            }
            a("next_job_scheduler_id", i + 1);
        }
        return i;
    }

    public int a() {
        int a2;
        synchronized (c.class) {
            b();
            a2 = a("next_alarm_manager_id");
        }
        return a2;
    }

    private int a(String str) {
        int i = this.f3040b.getInt(str, 0);
        a(str, i != Integer.MAX_VALUE ? i + 1 : 0);
        return i;
    }

    private void a(String str, int i) {
        this.f3040b.edit().putInt(str, i).apply();
    }

    private void b() {
        if (this.f3041c) {
            return;
        }
        this.f3040b = this.f3039a.getSharedPreferences("androidx.work.util.id", 0);
        this.f3041c = true;
    }
}
