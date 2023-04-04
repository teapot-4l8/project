package com.bumptech.glide.c.b.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f4735a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4736b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f4737c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4738d;

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        int i;
        this.f4737c = aVar.f4740b;
        if (a(aVar.f4741c)) {
            i = aVar.i / 2;
        } else {
            i = aVar.i;
        }
        this.f4738d = i;
        int a2 = a(aVar.f4741c, aVar.g, aVar.h);
        float a3 = aVar.f4742d.a() * aVar.f4742d.b() * 4;
        int round = Math.round(aVar.f * a3);
        int round2 = Math.round(a3 * aVar.f4743e);
        int i2 = a2 - this.f4738d;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f4736b = round2;
            this.f4735a = round;
        } else {
            float f = i2 / (aVar.f + aVar.f4743e);
            this.f4736b = Math.round(aVar.f4743e * f);
            this.f4735a = Math.round(f * aVar.f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f4736b));
            sb.append(", pool size: ");
            sb.append(a(this.f4735a));
            sb.append(", byte array size: ");
            sb.append(a(this.f4738d));
            sb.append(", memory class limited? ");
            sb.append(i3 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f4741c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f4741c));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    public int a() {
        return this.f4736b;
    }

    public int b() {
        return this.f4735a;
    }

    public int c() {
        return this.f4738d;
    }

    private static int a(ActivityManager activityManager, float f, float f2) {
        boolean a2 = a(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (a2) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.f4737c, i);
    }

    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final int f4739a;

        /* renamed from: b  reason: collision with root package name */
        final Context f4740b;

        /* renamed from: c  reason: collision with root package name */
        ActivityManager f4741c;

        /* renamed from: d  reason: collision with root package name */
        c f4742d;
        float f;

        /* renamed from: e  reason: collision with root package name */
        float f4743e = 2.0f;
        float g = 0.4f;
        float h = 0.33f;
        int i = 4194304;

        static {
            f4739a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f = f4739a;
            this.f4740b = context;
            this.f4741c = (ActivityManager) context.getSystemService("activity");
            this.f4742d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.a(this.f4741c)) {
                return;
            }
            this.f = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f4744a;

        b(DisplayMetrics displayMetrics) {
            this.f4744a = displayMetrics;
        }

        @Override // com.bumptech.glide.c.b.b.i.c
        public int a() {
            return this.f4744a.widthPixels;
        }

        @Override // com.bumptech.glide.c.b.b.i.c
        public int b() {
            return this.f4744a.heightPixels;
        }
    }
}
