package cn.jiguang.an;

import android.os.Environment;
import android.util.Log;
import cn.jiguang.f.i;
import cn.jiguang.internal.JConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f3750a = ".jpush";

    /* renamed from: b  reason: collision with root package name */
    private static String f3751b = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + f3750a + File.separator;

    /* renamed from: c  reason: collision with root package name */
    private static String f3752c;

    /* renamed from: d  reason: collision with root package name */
    private static final SimpleDateFormat f3753d;

    /* renamed from: e  reason: collision with root package name */
    private static ArrayList<String> f3754e;
    private static boolean f;
    private static boolean g;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(f3751b);
        sb.append(f3750a);
        f3752c = sb.toString();
        f3753d = new SimpleDateFormat("MM.dd_HH:mm:ss_SSS", Locale.ENGLISH);
        f3754e = new ArrayList<>();
        f = false;
        g = false;
    }

    public static void a(String str, String str2, String str3, Throwable th) {
        str2 = (str2 == null || str2.trim().equals("")) ? "Logger" : "Logger";
        if (str3 == null) {
            return;
        }
        try {
            String format = f3753d.format(new Date());
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str3), 256);
            String a2 = i.a("[" + str2 + "]", 24);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return;
                    }
                    String str4 = ((Object) format) + " " + i.a(str, 5) + " " + a2 + " " + readLine;
                    if (!g) {
                        try {
                            f3754e.add(str4);
                            if (f3754e.size() == 500) {
                                ArrayList<String> arrayList = f3754e;
                                f3754e = new ArrayList<>();
                                boolean c2 = cn.jiguang.f.a.c(JConstants.mApplicationContext, "android.permission.WRITE_EXTERNAL_STORAGE");
                                f = c2;
                                if (c2) {
                                    d.a("Logger", "have writable external storage, write log file");
                                    a(arrayList);
                                } else {
                                    d.a("Logger", "no writable external storage");
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException unused) {
                            f3754e = new ArrayList<>();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    d.h("Logger", e2.getMessage());
                    return;
                }
            }
        } catch (Throwable th3) {
            Log.w("Logger", "logtofile call failed:" + th3.getMessage());
        }
    }

    private static void a(ArrayList<String> arrayList) {
        try {
            if (JConstants.mApplicationContext == null || cn.jiguang.f.a.c(JConstants.mApplicationContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                cn.jiguang.ba.a.a("ASYNC", new c(arrayList));
            } else {
                d.f("Logger", "WRITE_EXTERNAL_STORAGE not get");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c() {
        File[] listFiles;
        try {
            File file = new File(f3751b);
            if (file.exists()) {
                int length = f3750a.length() + 1;
                int length2 = cn.jiguang.f.c.f4068a.length() + length;
                if (file.listFiles() != null) {
                    for (File file2 : file.listFiles()) {
                        if (cn.jiguang.f.c.a(cn.jiguang.f.c.b(file2.getName().substring(length, length2)), 2)) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            d.h("Logger", th.getMessage());
        }
    }
}
