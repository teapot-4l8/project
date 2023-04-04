package a.a.a.e;

import a.a.a.c.j.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: TraceRoute.java */
/* loaded from: classes.dex */
public class s {

    /* compiled from: TraceRoute.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(a.C0003a c0003a);

        void a(boolean z);
    }

    private s() {
    }

    /* compiled from: TraceRoute.java */
    /* loaded from: classes.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private static final s f398a = new s();
    }

    public static s a() {
        return c.f398a;
    }

    public void a(String str, b bVar) {
        a(new d(str, 1), bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0075, code lost:
        if (r2 == null) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x007a: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:36:0x007a */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Process] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(a aVar) {
        BufferedReader bufferedReader;
        InterruptedException e2;
        IOException e3;
        BufferedReader bufferedReader2;
        Process process;
        Process process2;
        String str = "";
        BufferedReader bufferedReader3 = null;
        try {
            try {
                aVar = Runtime.getRuntime().exec("/system/bin/ping -c 1 -w 1 " + aVar.a());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(aVar.getInputStream()));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            str = str + readLine;
                        } catch (IOException e4) {
                            e3 = e4;
                            e3.printStackTrace();
                            process2 = aVar;
                            process = aVar;
                        } catch (InterruptedException e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            process = aVar;
                            if (bufferedReader != null) {
                                process2 = aVar;
                                bufferedReader.close();
                                process = process2;
                            }
                            process.destroy();
                            return str;
                        }
                    }
                    bufferedReader.close();
                    aVar.waitFor();
                    process2 = aVar;
                } catch (IOException e6) {
                    bufferedReader = null;
                    e3 = e6;
                } catch (InterruptedException e7) {
                    bufferedReader = null;
                    e2 = e7;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (Exception unused) {
                            throw th;
                        }
                    }
                    aVar.destroy();
                    throw th;
                }
            } catch (IOException e8) {
                bufferedReader = null;
                e3 = e8;
                aVar = null;
            } catch (InterruptedException e9) {
                bufferedReader = null;
                e2 = e9;
                aVar = null;
            } catch (Throwable th2) {
                th = th2;
                aVar = 0;
            }
            try {
                bufferedReader.close();
                process = process2;
                process.destroy();
            } catch (Exception unused2) {
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader3 = bufferedReader2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x017d, code lost:
        if (r11 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x017f, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0182, code lost:
        r9.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x018f, code lost:
        if (r11 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0192, code lost:
        r20.a(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0195, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(d dVar, b bVar) {
        String substring;
        Pattern compile = Pattern.compile("(?<=from ).*(?=: icmp_seq=1 ttl=)");
        Pattern compile2 = Pattern.compile("(?<=time=).*?ms");
        Process process = null;
        BufferedReader bufferedReader = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    if (dVar.b() >= 30) {
                        break;
                    }
                    StringBuilder sb = new StringBuilder();
                    process = Runtime.getRuntime().exec("/system/bin/ping -c 1 -w 1 -t " + dVar.b() + " " + dVar.a());
                    boolean z3 = z;
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            } catch (Exception e2) {
                                e = e2;
                                bufferedReader = bufferedReader2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                    throw th;
                                }
                            }
                            process.destroy();
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                    process.waitFor();
                    a.C0003a c0003a = new a.C0003a();
                    if (sb.toString().contains("From") && sb.toString().contains("icmp_seq=1")) {
                        String substring2 = sb.substring(sb.indexOf("From"));
                        String substring3 = substring2.substring(0, substring2.indexOf("icmp_seq=1"));
                        if (substring3.contains("(") && substring3.contains(")")) {
                            substring = substring3.substring(substring3.indexOf("(") + 1, substring3.indexOf(")"));
                        } else {
                            substring = substring3.substring(substring3.indexOf("From") + 5, substring3.indexOf(":"));
                        }
                        String a2 = a(new a(substring));
                        if (a2.length() == 0) {
                            z = true;
                            bufferedReader = bufferedReader2;
                        } else {
                            Matcher matcher = compile2.matcher(a2);
                            if (matcher.find()) {
                                String group = matcher.group();
                                c0003a.a(dVar.b());
                                c0003a.a(substring);
                                c0003a.b(group);
                            } else {
                                c0003a.a(dVar.b());
                                c0003a.a(substring);
                            }
                            try {
                                bVar.a(c0003a);
                                dVar.a(dVar.b() + 1);
                                z = z3;
                                z2 = true;
                                bufferedReader = bufferedReader2;
                            } catch (Exception e3) {
                                e = e3;
                                bufferedReader = bufferedReader2;
                                z2 = true;
                                e.printStackTrace();
                            }
                        }
                    } else {
                        Matcher matcher2 = compile.matcher(sb.toString());
                        if (matcher2.find()) {
                            String group2 = matcher2.group();
                            Matcher matcher3 = compile2.matcher(sb.toString());
                            if (matcher3.find()) {
                                String group3 = matcher3.group();
                                c0003a.a(dVar.b());
                                c0003a.a(group2);
                                c0003a.b(group3);
                                bVar.a(c0003a);
                                z2 = true;
                            }
                            z = true;
                            bufferedReader = bufferedReader2;
                        } else {
                            if (sb.length() == 0) {
                                z = true;
                            } else {
                                c0003a.a(dVar.b());
                                dVar.a(dVar.b() + 1);
                                z = z3;
                                z2 = true;
                            }
                            bVar.a(c0003a);
                            bufferedReader = bufferedReader2;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TraceRoute.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        private String f397b;

        public String a() {
            return this.f397b;
        }

        public a(String str) {
            this.f397b = str;
            Matcher matcher = Pattern.compile("(?<=\\().*?(?=\\))").matcher(str);
            if (matcher.find()) {
                this.f397b = matcher.group();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TraceRoute.java */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: b  reason: collision with root package name */
        private final String f400b;

        /* renamed from: c  reason: collision with root package name */
        private int f401c;

        public d(String str, int i) {
            this.f400b = str;
            this.f401c = i;
        }

        public String a() {
            return this.f400b;
        }

        public int b() {
            return this.f401c;
        }

        public void a(int i) {
            this.f401c = i;
        }
    }
}
