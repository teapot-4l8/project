package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f6051a;

        /* renamed from: b  reason: collision with root package name */
        public String f6052b;

        /* renamed from: c  reason: collision with root package name */
        public long f6053c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String[]> f6054d;
    }

    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public interface b {
        boolean a(long j);

        boolean a(long j, long j2, String str);

        boolean a(String str, int i, String str2, String str3);
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (str != null && str2 != null) {
            final a aVar = new a();
            readTraceFile(str2, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(String str3, int i, String str4, String str5) {
                    x.c("new thread %s", str3);
                    if (a.this.f6051a > 0 && a.this.f6053c > 0 && a.this.f6052b != null) {
                        if (a.this.f6054d == null) {
                            a.this.f6054d = new HashMap();
                        }
                        Map<String, String[]> map = a.this.f6054d;
                        StringBuilder sb = new StringBuilder();
                        sb.append(i);
                        map.put(str3, new String[]{str4, str5, sb.toString()});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j, long j2, String str3) {
                    x.c("new process %s", str3);
                    if (str3.equals(str)) {
                        a.this.f6051a = j;
                        a.this.f6052b = str3;
                        a.this.f6053c = j2;
                        return z;
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j) {
                    x.c("process end %d", Long.valueOf(j));
                    return a.this.f6051a <= 0 || a.this.f6053c <= 0 || a.this.f6052b == null;
                }
            });
            if (aVar.f6051a > 0 && aVar.f6053c > 0 && aVar.f6052b != null) {
                return aVar;
            }
        }
        return null;
    }

    public static a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            x.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str2, int i, String str3, String str4) {
                x.c("new thread %s", str2);
                if (a.this.f6054d == null) {
                    a.this.f6054d = new HashMap();
                }
                Map<String, String[]> map = a.this.f6054d;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                map.put(str2, new String[]{str3, str4, sb.toString()});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j, long j2, String str2) {
                x.c("new process %s", str2);
                a.this.f6051a = j;
                a.this.f6052b = str2;
                a.this.f6053c = j2;
                return z;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j) {
                x.c("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (aVar.f6051a <= 0 || aVar.f6053c <= 0 || aVar.f6052b == null) {
            x.e("first dump error %s", aVar.f6051a + " " + aVar.f6053c + " " + aVar.f6052b);
            return null;
        }
        return aVar;
    }

    public static void readTraceFile(String str, b bVar) {
        Throwable th;
        if (str == null || bVar == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    while (true) {
                        Object[] a2 = a(bufferedReader2, compile);
                        if (a2 == null) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e2) {
                                if (x.a(e2)) {
                                    return;
                                }
                                e2.printStackTrace();
                                return;
                            }
                        }
                        String[] split = a2[1].toString().split("\\s");
                        long parseLong = Long.parseLong(split[2]);
                        long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                        Object[] a3 = a(bufferedReader2, compile3);
                        if (a3 == null) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e3) {
                                if (x.a(e3)) {
                                    return;
                                }
                                e3.printStackTrace();
                                return;
                            }
                        }
                        Matcher matcher = compile3.matcher(a3[1].toString());
                        matcher.find();
                        matcher.group(1);
                        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                        if (!bVar.a(parseLong, time, matcher.group(1))) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e4) {
                                if (x.a(e4)) {
                                    return;
                                }
                                e4.printStackTrace();
                                return;
                            }
                        }
                        while (true) {
                            Object[] a4 = a(bufferedReader2, compile4, compile2);
                            if (a4 == null) {
                                break;
                            } else if (a4[0] == compile4) {
                                String obj = a4[1].toString();
                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                matcher2.find();
                                String group = matcher2.group();
                                String substring = group.substring(1, group.length() - 1);
                                obj.contains("NATIVE");
                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                matcher3.find();
                                String group2 = matcher3.group();
                                bVar.a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), a(bufferedReader2), b(bufferedReader2));
                            } else if (!bVar.a(Long.parseLong(a4[1].toString().split("\\s")[2]))) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e5) {
                                    if (x.a(e5)) {
                                        return;
                                    }
                                    e5.printStackTrace();
                                    return;
                                }
                            }
                        }
                        simpleDateFormat = simpleDateFormat2;
                    }
                } catch (Exception e6) {
                    e = e6;
                    bufferedReader = bufferedReader2;
                    if (!x.a(e)) {
                        e.printStackTrace();
                    }
                    x.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            if (x.a(e7)) {
                                return;
                            }
                            e7.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                            if (!x.a(e8)) {
                                e8.printStackTrace();
                            }
                        }
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0011, code lost:
        r5 = r8[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r5.matcher(r1).matches() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        return new java.lang.Object[]{r5, r1};
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
        if (r8 != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0006, code lost:
        r1 = r7.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000a, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
        r2 = r8.length;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
        if (r4 >= r2) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) {
        if (bufferedReader != null) {
        }
        return null;
    }

    private static String a(BufferedReader bufferedReader) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    private static String b(BufferedReader bufferedReader) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
