package com.umeng.commonsdk.internal.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: CpuUtil.java */
/* loaded from: classes2.dex */
public class c {

    /* compiled from: CpuUtil.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f6774a;

        /* renamed from: b  reason: collision with root package name */
        public String f6775b;

        /* renamed from: c  reason: collision with root package name */
        public int f6776c;

        /* renamed from: d  reason: collision with root package name */
        public String f6777d;

        /* renamed from: e  reason: collision with root package name */
        public String f6778e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x012f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0128 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a() {
        a aVar;
        BufferedReader bufferedReader;
        FileReader fileReader;
        Throwable th;
        int i;
        FileReader fileReader2 = null;
        int i2 = 0;
        try {
            try {
                aVar = new a();
                try {
                    fileReader = new FileReader("/proc/cpuinfo");
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                    } catch (Exception unused) {
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        th = th;
                        if (fileReader != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                    try {
                        try {
                            int i3 = 0;
                            boolean z = true;
                            i = 0;
                            for (String readLine = bufferedReader.readLine(); !TextUtils.isEmpty(readLine) && (i3 = i3 + 1) < 30; readLine = bufferedReader.readLine()) {
                                try {
                                    String[] split = readLine.split(":\\s+", 2);
                                    if (z && split != null && split.length > 1) {
                                        aVar.f6774a = split[1];
                                        z = false;
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("processor")) {
                                        i++;
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Features")) {
                                        aVar.f6777d = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("implementer")) {
                                        aVar.f6778e = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("architecture")) {
                                        aVar.f = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("variant")) {
                                        aVar.g = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("part")) {
                                        aVar.h = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("revision")) {
                                        aVar.i = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Hardware")) {
                                        aVar.j = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Revision")) {
                                        aVar.k = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("Serial")) {
                                        aVar.l = split[1];
                                    }
                                    if (split != null && split.length > 1 && split[0].contains("implementer")) {
                                        aVar.f6778e = split[1];
                                    }
                                } catch (Exception unused2) {
                                    fileReader2 = fileReader;
                                    i2 = i;
                                    if (fileReader2 != null) {
                                        try {
                                            fileReader2.close();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException unused4) {
                                        }
                                    }
                                    i = i2;
                                    aVar.f6776c = i;
                                    return aVar;
                                }
                            }
                            try {
                                fileReader.close();
                            } catch (IOException unused5) {
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException unused6) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused8) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused9) {
                        fileReader2 = fileReader;
                        if (fileReader2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        i = i2;
                        aVar.f6776c = i;
                        return aVar;
                    }
                } catch (Exception unused10) {
                    bufferedReader = null;
                }
            } catch (Exception unused11) {
                aVar = null;
                bufferedReader = null;
            }
            aVar.f6776c = i;
            return aVar;
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static String b() {
        byte[] bArr;
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String c() {
        byte[] bArr;
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            while (inputStream.read(new byte[24]) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception unused) {
        }
        return str.trim();
    }

    public static String d() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
        } catch (Exception unused) {
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            String trim = bufferedReader.readLine().trim();
            try {
                bufferedReader.close();
                return trim;
            } catch (Throwable unused2) {
                return trim;
            }
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused5) {
                }
            }
            throw th;
        }
    }
}
