package org.greenrobot.eventbus;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;

/* compiled from: Logger.java */
/* loaded from: classes2.dex */
public interface g {
    void a(Level level, String str);

    void a(Level level, String str, Throwable th);

    /* compiled from: Logger.java */
    /* loaded from: classes2.dex */
    public static class a implements g {

        /* renamed from: a  reason: collision with root package name */
        static final boolean f7812a;

        /* renamed from: b  reason: collision with root package name */
        private final String f7813b;

        static {
            boolean z = false;
            try {
                if (Class.forName("android.util.Log") != null) {
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            }
            f7812a = z;
        }

        public static boolean a() {
            return f7812a;
        }

        public a(String str) {
            this.f7813b = str;
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(a(level), this.f7813b, str);
            }
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                int a2 = a(level);
                String str2 = this.f7813b;
                Log.println(a2, str2, str + "\n" + Log.getStackTraceString(th));
            }
        }

        protected int a(Level level) {
            int intValue = level.intValue();
            if (intValue < 800) {
                return intValue < 500 ? 2 : 3;
            } else if (intValue < 900) {
                return 4;
            } else {
                return intValue < 1000 ? 5 : 6;
            }
        }
    }

    /* compiled from: Logger.java */
    /* loaded from: classes2.dex */
    public static class b implements g {
        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }
}
