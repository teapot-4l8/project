package a.a.a.d;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

/* compiled from: ResolverConfig.java */
/* loaded from: classes.dex */
public class cb {

    /* renamed from: d  reason: collision with root package name */
    private static cb f203d;

    /* renamed from: a  reason: collision with root package name */
    private String[] f204a = null;

    /* renamed from: b  reason: collision with root package name */
    private bj[] f205b = null;

    /* renamed from: c  reason: collision with root package name */
    private int f206c = -1;

    static {
        k();
    }

    public cb() {
        if (a() || l()) {
            return;
        }
        if (this.f204a == null || this.f205b == null) {
            String property = System.getProperty("os.name");
            String property2 = System.getProperty("java.vendor");
            if (property.contains("Windows")) {
                d();
            } else if (property.contains("NetWare")) {
                c();
            } else if (property2.contains("Android")) {
                e();
            } else {
                b();
            }
        }
    }

    private void a(String str, List<String> list) {
        if (list.contains(str)) {
            return;
        }
        if (bo.b("verbose")) {
            PrintStream printStream = System.out;
            printStream.println("adding server " + str);
        }
        list.add(str);
    }

    private void b(String str, List<bj> list) {
        if (bo.b("verbose")) {
            PrintStream printStream = System.out;
            printStream.println("adding search " + str);
        }
        try {
            bj a2 = bj.a(str, bj.f178a);
            if (list.contains(a2)) {
                return;
            }
            list.add(a2);
        } catch (cy unused) {
        }
    }

    private int a(String str) {
        String substring = str.substring(6);
        try {
            int parseInt = Integer.parseInt(substring);
            if (parseInt >= 0) {
                if (bo.b("verbose")) {
                    PrintStream printStream = System.out;
                    printStream.println("setting ndots " + substring);
                }
                return parseInt;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private void a(List<String> list, List<bj> list2) {
        if (this.f204a == null && list.size() > 0) {
            this.f204a = (String[]) list.toArray(new String[0]);
        }
        if (this.f205b != null || list2.size() <= 0) {
            return;
        }
        this.f205b = (bj[]) list2.toArray(new bj[0]);
    }

    private void a(int i) {
        if (this.f206c >= 0 || i <= 0) {
            return;
        }
        this.f206c = i;
    }

    boolean a() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken(), arrayList);
            }
        }
        String property2 = System.getProperty("dns.search");
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, ",");
            while (stringTokenizer2.hasMoreTokens()) {
                b(stringTokenizer2.nextToken(), arrayList2);
            }
        }
        a(arrayList, arrayList2);
        return (this.f204a == null || this.f205b == null) ? false : true;
    }

    private boolean l() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        try {
            Class<?>[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object invoke = cls.getDeclaredMethod("open", clsArr).invoke(null, objArr);
            List<String> list = (List) cls.getMethod("nameservers", clsArr).invoke(invoke, objArr);
            List<String> list2 = (List) cls.getMethod("searchlist", clsArr).invoke(invoke, objArr);
            if (list.size() == 0) {
                return false;
            }
            for (String str : list) {
                a(str, arrayList);
            }
            if (list2.size() > 0) {
                for (String str2 : list2) {
                    b(str2, arrayList2);
                }
            }
            a(arrayList, arrayList2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    boolean a(InputStream inputStream) {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int i = -1;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.startsWith("nameserver")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                    stringTokenizer.nextToken();
                    a(stringTokenizer.nextToken(), arrayList);
                } else if (readLine.startsWith("domain")) {
                    StringTokenizer stringTokenizer2 = new StringTokenizer(readLine);
                    stringTokenizer2.nextToken();
                    if (stringTokenizer2.hasMoreTokens() && arrayList2.isEmpty()) {
                        b(stringTokenizer2.nextToken(), arrayList2);
                    }
                } else if (readLine.startsWith("search")) {
                    if (!arrayList2.isEmpty()) {
                        arrayList2.clear();
                    }
                    StringTokenizer stringTokenizer3 = new StringTokenizer(readLine);
                    stringTokenizer3.nextToken();
                    while (stringTokenizer3.hasMoreTokens()) {
                        b(stringTokenizer3.nextToken(), arrayList2);
                    }
                } else if (readLine.startsWith("options")) {
                    StringTokenizer stringTokenizer4 = new StringTokenizer(readLine);
                    stringTokenizer4.nextToken();
                    while (stringTokenizer4.hasMoreTokens()) {
                        String nextToken = stringTokenizer4.nextToken();
                        if (nextToken.startsWith("ndots:")) {
                            i = a(nextToken);
                        }
                    }
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            if (arrayList.isEmpty()) {
                return false;
            }
            a(arrayList, arrayList2);
            a(i);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    boolean b() {
        try {
            InputStream newInputStream = Files.newInputStream(Paths.get("/etc/resolv.conf", new String[0]), new OpenOption[0]);
            boolean a2 = a(newInputStream);
            if (newInputStream != null) {
                newInputStream.close();
            }
            return a2;
        } catch (Exception unused) {
            return false;
        }
    }

    boolean c() {
        try {
            InputStream newInputStream = Files.newInputStream(Paths.get("sys:/etc/resolv.cfg", new String[0]), new OpenOption[0]);
            boolean a2 = a(newInputStream);
            if (newInputStream != null) {
                newInputStream.close();
            }
            return a2;
        } catch (Exception unused) {
            return false;
        }
    }

    boolean a(InputStream inputStream, Locale locale) {
        ResourceBundle bundle;
        String str = cb.class.getPackage().getName() + ".windows.DNSServer";
        if (locale != null) {
            bundle = ResourceBundle.getBundle(str, locale);
        } else {
            bundle = ResourceBundle.getBundle(str);
        }
        String string = bundle.getString("host_name");
        String string2 = bundle.getString("primary_dns_suffix");
        String string3 = bundle.getString("dns_suffix");
        String string4 = bundle.getString("dns_servers");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            loop0: while (true) {
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break loop0;
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                    if (!stringTokenizer.hasMoreTokens()) {
                        break;
                    }
                    String nextToken = stringTokenizer.nextToken();
                    if (readLine.contains(":")) {
                        z = false;
                        z2 = false;
                    }
                    if (readLine.contains(string)) {
                        while (stringTokenizer.hasMoreTokens()) {
                            nextToken = stringTokenizer.nextToken();
                        }
                        try {
                            if (bj.a(nextToken, (bj) null).c() != 1) {
                                b(nextToken, arrayList2);
                            }
                        } catch (cy unused) {
                        }
                    } else {
                        if (readLine.contains(string2)) {
                            while (stringTokenizer.hasMoreTokens()) {
                                nextToken = stringTokenizer.nextToken();
                            }
                            if (!nextToken.equals(":")) {
                                b(nextToken, arrayList2);
                            }
                        } else {
                            if (!z && !readLine.contains(string3)) {
                                if (z2 || readLine.contains(string4)) {
                                    while (stringTokenizer.hasMoreTokens()) {
                                        nextToken = stringTokenizer.nextToken();
                                    }
                                    if (!nextToken.equals(":")) {
                                        a(nextToken, arrayList);
                                        z2 = true;
                                    }
                                }
                            }
                            while (stringTokenizer.hasMoreTokens()) {
                                nextToken = stringTokenizer.nextToken();
                            }
                            if (!nextToken.equals(":")) {
                                b(nextToken, arrayList2);
                            }
                        }
                        z = true;
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            a(arrayList, arrayList2);
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    private boolean b(InputStream inputStream) {
        int intValue = Integer.getInteger("com.example.httpinfo.dns.windows.parse.buffer", 8192).intValue();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, intValue);
        bufferedInputStream.mark(intValue);
        boolean a2 = a(bufferedInputStream, (Locale) null);
        if (this.f204a == null) {
            try {
                bufferedInputStream.reset();
                return a(bufferedInputStream, new Locale("", ""));
            } catch (IOException unused) {
                return false;
            }
        }
        return a2;
    }

    boolean d() {
        try {
            Process exec = Runtime.getRuntime().exec("ipconfig /all");
            boolean b2 = b(exec.getInputStream());
            exec.destroy();
            return b2;
        } catch (Exception unused) {
            return false;
        }
    }

    boolean e() {
        ArrayList arrayList = new ArrayList();
        List<bj> arrayList2 = new ArrayList<>();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i = 0; i < 4; i++) {
                String str = (String) method.invoke(null, strArr[i]);
                if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            a(arrayList, arrayList2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String[] f() {
        return this.f204a;
    }

    public String g() {
        String[] strArr = this.f204a;
        if (strArr == null) {
            return null;
        }
        return strArr[0];
    }

    public bj[] h() {
        return this.f205b;
    }

    public int i() {
        int i = this.f206c;
        if (i < 0) {
            return 1;
        }
        return i;
    }

    public static synchronized cb j() {
        cb cbVar;
        synchronized (cb.class) {
            cbVar = f203d;
        }
        return cbVar;
    }

    public static void k() {
        cb cbVar = new cb();
        synchronized (cb.class) {
            f203d = cbVar;
        }
    }
}
