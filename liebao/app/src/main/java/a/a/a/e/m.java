package a.a.a.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.l;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/* compiled from: Ping.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private int f379a;

    /* renamed from: b  reason: collision with root package name */
    private int f380b;

    /* renamed from: c  reason: collision with root package name */
    private String f381c;

    /* renamed from: d  reason: collision with root package name */
    private a.a.a.c.h.a f382d;

    public m(String str) {
        this(32, 10, str);
    }

    public m(int i, int i2, String str) {
        this.f379a = i;
        this.f380b = i2;
        this.f381c = str;
        a.a.a.c.h.a aVar = new a.a.a.c.h.a();
        this.f382d = aVar;
        aVar.a(str);
    }

    public a.a.a.c.h.a a() {
        return c();
    }

    private a.a.a.c.h.a c() {
        String b2 = b(this.f381c);
        if (TextUtils.isEmpty(b2)) {
            this.f382d.b(-1);
            return this.f382d;
        }
        String c2 = c(a(this.f380b, this.f379a, b2));
        if (c2 != null) {
            try {
                this.f382d.b(l.a.DEFAULT_DRAG_ANIMATION_DURATION);
                this.f382d.b(a(c2));
                c(c2, this.f382d);
                a(c2, this.f382d);
                b(c2, this.f382d);
            } catch (Exception e2) {
                this.f382d.b(-1);
                e2.printStackTrace();
            }
        }
        return this.f382d;
    }

    private String a(String str) {
        try {
            if (str.contains("ping")) {
                return str.substring(str.indexOf("(") + 1, str.indexOf(")"));
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void a(String str, a.a.a.c.h.a aVar) {
        try {
            if (str.contains("rtt")) {
                String substring = str.substring(str.indexOf("rtt"));
                String[] split = substring.substring(substring.indexOf("=") + 2).split("/");
                aVar.e(Float.parseFloat(split[0]));
                aVar.b(Float.parseFloat(split[1]));
                aVar.d(Float.parseFloat(split[2]));
                aVar.c(Float.parseFloat(split[3].substring(0, split[3].indexOf(" ms"))));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(String str, a.a.a.c.h.a aVar) {
        try {
            if (str.contains("ttl")) {
                String substring = str.substring(str.indexOf("ttl"), str.indexOf("\n", str.indexOf("ttl")));
                aVar.e(Integer.parseInt(substring.substring(4, substring.indexOf(" "))));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c(String str, a.a.a.c.h.a aVar) {
        String[] split;
        try {
            if (str.contains("statistics")) {
                String substring = str.substring(str.indexOf("\n", str.indexOf("statistics")) + 1);
                for (String str2 : substring.substring(0, substring.indexOf("\n")).split(", ")) {
                    if (str2.contains(" packets transmitted")) {
                        aVar.c(Integer.parseInt(str2.substring(0, str2.indexOf(" packets transmitted"))));
                    }
                    if (str2.contains(" received")) {
                        aVar.d(Integer.parseInt(str2.substring(0, str2.indexOf(" received"))));
                    }
                    if (str2.contains(" errors")) {
                        aVar.b(Integer.parseInt(str2.substring(0, str2.indexOf(" errors"))));
                    }
                    if (str2.contains(" packet loss")) {
                        aVar.a(Float.parseFloat(str2.substring(0, str2.indexOf("%"))));
                    }
                    if (str2.contains("time")) {
                        aVar.a(Integer.parseInt(str2.substring(str2.lastIndexOf("e") + 2, str2.indexOf("ms"))));
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String b(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String c(String str) {
        Throwable th;
        Process process;
        try {
            try {
                process = Runtime.getRuntime().exec(str);
            } catch (IOException e2) {
                e = e2;
                process = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                if (str != 0) {
                }
                throw th;
            }
            try {
                InputStream inputStream = process.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                }
                bufferedReader.close();
                inputStream.close();
                String sb2 = sb.toString();
                if (process != null) {
                    process.destroy();
                }
                return sb2;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                if (process != null) {
                    process.destroy();
                }
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            if (str != 0) {
                str.destroy();
            }
            throw th;
        }
    }

    private String a(int i, int i2, String str) {
        return String.format("/system/bin/ping -c %d -w %d  %s", Integer.valueOf(i), Integer.valueOf(i2), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b() {
        Throwable th;
        Process process;
        try {
            process = Runtime.getRuntime().exec(String.format("/system/bin/ip route list table 0", new Object[0]));
        } catch (IOException e2) {
            e = e2;
            process = null;
        } catch (Throwable th2) {
            th = th2;
            process = null;
            if (process != null) {
            }
            throw th;
        }
        try {
            try {
                InputStream inputStream = process.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    Log.d("1111111111", readLine);
                    sb.append(readLine);
                    sb.append("\n");
                }
                bufferedReader.close();
                inputStream.close();
                String sb2 = sb.toString();
                if (process != null) {
                    process.destroy();
                }
                return sb2;
            } catch (Throwable th3) {
                th = th3;
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            if (process != null) {
                process.destroy();
            }
            return null;
        }
    }
}
