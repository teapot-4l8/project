package cn.jiguang.v;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class f {
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008c, code lost:
        if (r5 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0120, code lost:
        if (r5 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0124, code lost:
        return r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c1 A[Catch: IOException -> 0x00bd, DONT_GENERATE, TRY_LEAVE, TryCatch #12 {IOException -> 0x00bd, blocks: (B:46:0x00b9, B:50:0x00c1), top: B:94:0x00b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0109 A[Catch: IOException -> 0x0105, TRY_LEAVE, TryCatch #7 {IOException -> 0x0105, blocks: (B:60:0x0101, B:64:0x0109), top: B:91:0x0101 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0149 A[FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0, types: [int] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v14, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v21, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r13v22, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Runtime] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> a(String[] strArr, int i) {
        Process process;
        BufferedReader bufferedReader;
        ?? runtime;
        Throwable th;
        IOException e2;
        BufferedReader bufferedReader2 = null;
        ArrayList arrayList = i != 0 ? new ArrayList() : null;
        try {
            try {
                process = Runtime.getRuntime().exec(strArr);
            } catch (Throwable unused) {
                try {
                    String[] strArr2 = new String[3];
                    System.arraycopy(new String[]{"/system/bin/sh", "-c"}, 0, strArr2, 0, 2);
                    System.arraycopy(strArr, 0, strArr2, 2, 1);
                    runtime = Runtime.getRuntime();
                    process = runtime.exec(strArr2);
                } catch (IOException e3) {
                    e = e3;
                    process = null;
                    bufferedReader = null;
                    e2 = e;
                    i = bufferedReader;
                    cn.jiguang.ad.a.d("JCommonShellHelper", "executeCommand " + Arrays.toString(strArr) + " exception:" + e2.getMessage());
                    if (bufferedReader != null) {
                    }
                    if (i != 0) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    process = null;
                    bufferedReader = null;
                    th = th;
                    i = bufferedReader;
                    cn.jiguang.ad.a.d("JCommonShellHelper", "executeCommand " + Arrays.toString(strArr) + " throwable:" + th.getMessage());
                }
            }
            if (i != 0) {
                try {
                    i = new InputStreamReader(process.getInputStream());
                    try {
                        bufferedReader = new BufferedReader(i);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                arrayList.add(readLine);
                            } catch (IOException e4) {
                                e2 = e4;
                                cn.jiguang.ad.a.d("JCommonShellHelper", "executeCommand " + Arrays.toString(strArr) + " exception:" + e2.getMessage());
                                if (bufferedReader != null) {
                                }
                                if (i != 0) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                cn.jiguang.ad.a.d("JCommonShellHelper", "executeCommand " + Arrays.toString(strArr) + " throwable:" + th.getMessage());
                            }
                        }
                        bufferedReader2 = bufferedReader;
                        bufferedReader = bufferedReader;
                        i = i;
                    } catch (IOException e5) {
                        bufferedReader = null;
                        e2 = e5;
                    } catch (Throwable th4) {
                        bufferedReader = null;
                        th = th4;
                    }
                } catch (IOException e6) {
                    e = e6;
                    bufferedReader = null;
                    e2 = e;
                    i = bufferedReader;
                    cn.jiguang.ad.a.d("JCommonShellHelper", "executeCommand " + Arrays.toString(strArr) + " exception:" + e2.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            i = new StringBuilder("executeCommand  exception:");
                            i.append(e7.getMessage());
                            cn.jiguang.ad.a.d("JCommonShellHelper", i.toString());
                        }
                    }
                    if (i != 0) {
                        i.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                    th = th;
                    i = bufferedReader;
                    cn.jiguang.ad.a.d("JCommonShellHelper", "executeCommand " + Arrays.toString(strArr) + " throwable:" + th.getMessage());
                }
            } else {
                i = 0;
                bufferedReader = runtime;
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e8) {
                    i = new StringBuilder("executeCommand  exception:");
                    i.append(e8.getMessage());
                    cn.jiguang.ad.a.d("JCommonShellHelper", i.toString());
                }
            }
            if (i != 0) {
                i.close();
            }
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e9) {
                    cn.jiguang.ad.a.d("JCommonShellHelper", "executeCommand  exception:" + e9.getMessage());
                    if (process != null) {
                    }
                }
            }
            if (i != 0) {
                i.close();
            }
            if (process != null) {
                process.destroy();
            }
        }
    }
}
