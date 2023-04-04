package com.snail.antifake.a;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: ShellAdbUtils.java */
/* loaded from: classes2.dex */
public class b {
    public static a a(String str, boolean z) {
        return a(new String[]{str}, z, true);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:6|7|(1:9)(1:162)|10|12|13|14|15|(3:17|(2:19|20)(2:22|23)|21)|24|25|(19:48|49|50|51|52|53|55|56|(3:57|58|(1:60)(1:61))|(2:62|(1:64)(0))|29|(1:31)|(1:33)|(1:36)|37|(1:39)(1:45)|(1:41)|42|43)(1:27)|28|29|(0)|(0)|(0)|37|(0)(0)|(0)|42|43) */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x014d, code lost:
        if (r10 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0171, code lost:
        if (r10 != null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0173, code lost:
        r10.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0176, code lost:
        r8 = r9;
        r10 = r1;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f7, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00f8, code lost:
        r2.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0141 A[Catch: IOException -> 0x013d, TryCatch #7 {IOException -> 0x013d, blocks: (B:96:0x0139, B:100:0x0141, B:102:0x0146), top: B:153:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0146 A[Catch: IOException -> 0x013d, TRY_LEAVE, TryCatch #7 {IOException -> 0x013d, blocks: (B:96:0x0139, B:100:0x0141, B:102:0x0146), top: B:153:0x0139 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0165 A[Catch: IOException -> 0x0161, TryCatch #19 {IOException -> 0x0161, blocks: (B:113:0x015d, B:117:0x0165, B:119:0x016a), top: B:162:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016a A[Catch: IOException -> 0x0161, TRY_LEAVE, TryCatch #19 {IOException -> 0x0161, blocks: (B:113:0x015d, B:117:0x0165, B:119:0x016a), top: B:162:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019d A[Catch: IOException -> 0x0199, TryCatch #8 {IOException -> 0x0199, blocks: (B:137:0x0195, B:141:0x019d, B:143:0x01a2), top: B:155:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a2 A[Catch: IOException -> 0x0199, TRY_LEAVE, TryCatch #8 {IOException -> 0x0199, blocks: (B:137:0x0195, B:141:0x019d, B:143:0x01a2), top: B:155:0x0195 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ee A[Catch: IOException -> 0x00f7, TryCatch #0 {IOException -> 0x00f7, blocks: (B:64:0x00e9, B:66:0x00ee, B:68:0x00f3), top: B:151:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f3 A[Catch: IOException -> 0x00f7, TRY_LEAVE, TryCatch #0 {IOException -> 0x00f7, blocks: (B:64:0x00e9, B:66:0x00ee, B:68:0x00f3), top: B:151:0x00e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fd  */
    /* JADX WARN: Type inference failed for: r10v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v24, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(String[] strArr, boolean z, boolean z2) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        StringBuilder sb;
        Process process2;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        BufferedReader bufferedReader3;
        BufferedReader bufferedReader4;
        int i;
        StringBuilder sb2;
        int i2;
        DataOutputStream dataOutputStream3;
        Process process3;
        Process process4;
        DataOutputStream dataOutputStream4 = null;
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    try {
                        process = Runtime.getRuntime().exec(z ? "su" : "sh");
                        try {
                            dataOutputStream3 = new DataOutputStream(process.getOutputStream());
                        } catch (IOException e2) {
                            e = e2;
                            process2 = process;
                            sb = null;
                            dataOutputStream = null;
                            BufferedReader bufferedReader5 = dataOutputStream;
                            bufferedReader3 = bufferedReader5;
                            bufferedReader4 = bufferedReader3;
                            dataOutputStream2 = bufferedReader5;
                            i = -1;
                            e.printStackTrace();
                            if (dataOutputStream2 != null) {
                            }
                            if (bufferedReader3 != null) {
                            }
                            if (bufferedReader4 != null) {
                            }
                        } catch (Exception e3) {
                            e = e3;
                            process2 = process;
                            sb = null;
                            dataOutputStream = null;
                            dataOutputStream2 = dataOutputStream;
                            bufferedReader3 = dataOutputStream2;
                            bufferedReader4 = bufferedReader3;
                            i = -1;
                            e.printStackTrace();
                            if (dataOutputStream2 != null) {
                            }
                            if (bufferedReader3 != null) {
                            }
                            if (bufferedReader4 != null) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = null;
                            bufferedReader2 = bufferedReader;
                            if (dataOutputStream4 != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                            if (process != null) {
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        sb = null;
                        process2 = null;
                        dataOutputStream = null;
                    } catch (Exception e5) {
                        e = e5;
                        sb = null;
                        process2 = null;
                        dataOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        process = null;
                        bufferedReader = null;
                    }
                    try {
                        try {
                            for (String str : strArr) {
                                if (str != null) {
                                    dataOutputStream3.write(str.getBytes());
                                    dataOutputStream3.writeBytes("\n");
                                    dataOutputStream3.flush();
                                }
                            }
                            dataOutputStream3.writeBytes("exit\n");
                            dataOutputStream3.flush();
                            i2 = process.waitFor();
                        } catch (IOException e6) {
                            e = e6;
                            process2 = process;
                            sb = null;
                            dataOutputStream = null;
                            bufferedReader3 = null;
                            bufferedReader4 = null;
                            dataOutputStream2 = dataOutputStream3;
                            i = -1;
                            e.printStackTrace();
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                            }
                            if (bufferedReader4 != null) {
                                bufferedReader4.close();
                            }
                        } catch (Exception e8) {
                            e = e8;
                            process2 = process;
                            sb = null;
                            dataOutputStream = null;
                            bufferedReader3 = null;
                            bufferedReader4 = null;
                            dataOutputStream2 = dataOutputStream3;
                            i = -1;
                            e.printStackTrace();
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                            }
                            if (bufferedReader4 != null) {
                                bufferedReader4.close();
                            }
                        }
                        if (z2 != 0) {
                            try {
                                sb2 = new StringBuilder();
                                try {
                                    ?? sb3 = new StringBuilder();
                                    try {
                                        bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                                        try {
                                            bufferedReader2 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                                            while (true) {
                                                try {
                                                    String readLine = bufferedReader.readLine();
                                                    if (readLine == null) {
                                                        break;
                                                    }
                                                    sb2.append(readLine);
                                                } catch (IOException e10) {
                                                    process4 = process;
                                                    sb = sb2;
                                                    e = e10;
                                                    bufferedReader4 = bufferedReader2;
                                                    bufferedReader3 = bufferedReader;
                                                    dataOutputStream2 = dataOutputStream3;
                                                    i = i2;
                                                    dataOutputStream = sb3;
                                                    process2 = process4;
                                                    e.printStackTrace();
                                                    if (dataOutputStream2 != null) {
                                                    }
                                                    if (bufferedReader3 != null) {
                                                    }
                                                    if (bufferedReader4 != null) {
                                                    }
                                                } catch (Exception e11) {
                                                    process3 = process;
                                                    sb = sb2;
                                                    e = e11;
                                                    bufferedReader4 = bufferedReader2;
                                                    bufferedReader3 = bufferedReader;
                                                    dataOutputStream2 = dataOutputStream3;
                                                    i = i2;
                                                    dataOutputStream = sb3;
                                                    process2 = process3;
                                                    e.printStackTrace();
                                                    if (dataOutputStream2 != null) {
                                                    }
                                                    if (bufferedReader3 != null) {
                                                    }
                                                    if (bufferedReader4 != null) {
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    dataOutputStream4 = dataOutputStream3;
                                                    if (dataOutputStream4 != null) {
                                                        try {
                                                            dataOutputStream4.close();
                                                        } catch (IOException e12) {
                                                            e12.printStackTrace();
                                                            if (process != null) {
                                                                process.destroy();
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    if (bufferedReader != null) {
                                                        bufferedReader.close();
                                                    }
                                                    if (bufferedReader2 != null) {
                                                        bufferedReader2.close();
                                                    }
                                                    if (process != null) {
                                                    }
                                                    throw th;
                                                }
                                            }
                                            while (true) {
                                                String readLine2 = bufferedReader2.readLine();
                                                z2 = sb3;
                                                if (readLine2 != null) {
                                                    sb3.append(readLine2);
                                                }
                                            }
                                            dataOutputStream3.close();
                                            if (bufferedReader != null) {
                                                bufferedReader.close();
                                            }
                                            if (bufferedReader2 != null) {
                                                bufferedReader2.close();
                                            }
                                            if (process != null) {
                                                process.destroy();
                                            }
                                        } catch (IOException e13) {
                                            bufferedReader4 = null;
                                            process4 = process;
                                            sb = sb2;
                                            e = e13;
                                        } catch (Exception e14) {
                                            bufferedReader4 = null;
                                            process3 = process;
                                            sb = sb2;
                                            e = e14;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            bufferedReader2 = null;
                                        }
                                    } catch (IOException e15) {
                                        bufferedReader3 = null;
                                        bufferedReader4 = null;
                                        process4 = process;
                                        sb = sb2;
                                        e = e15;
                                    } catch (Exception e16) {
                                        bufferedReader3 = null;
                                        bufferedReader4 = null;
                                        process3 = process;
                                        sb = sb2;
                                        e = e16;
                                    }
                                } catch (IOException e17) {
                                    bufferedReader3 = null;
                                    bufferedReader4 = null;
                                    dataOutputStream2 = dataOutputStream3;
                                    i = i2;
                                    dataOutputStream = null;
                                    process4 = process;
                                    sb = sb2;
                                    e = e17;
                                } catch (Exception e18) {
                                    bufferedReader3 = null;
                                    bufferedReader4 = null;
                                    dataOutputStream2 = dataOutputStream3;
                                    i = i2;
                                    dataOutputStream = null;
                                    process3 = process;
                                    sb = sb2;
                                    e = e18;
                                }
                            } catch (IOException e19) {
                                e = e19;
                                process2 = process;
                                sb = null;
                                bufferedReader3 = null;
                                bufferedReader4 = null;
                                dataOutputStream2 = dataOutputStream3;
                                i = i2;
                                dataOutputStream = null;
                            } catch (Exception e20) {
                                e = e20;
                                process2 = process;
                                sb = null;
                                bufferedReader3 = null;
                                bufferedReader4 = null;
                                dataOutputStream2 = dataOutputStream3;
                                i = i2;
                                dataOutputStream = null;
                            }
                            return new a(i2, sb2 != null ? null : sb2.toString(), z2 != 0 ? z2.toString() : null);
                        }
                        sb2 = null;
                        z2 = 0;
                        bufferedReader = null;
                        bufferedReader2 = null;
                        dataOutputStream3.close();
                        if (bufferedReader != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        if (process != null) {
                        }
                        return new a(i2, sb2 != null ? null : sb2.toString(), z2 != 0 ? z2.toString() : null);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader = null;
                        bufferedReader2 = null;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                process = z2;
                dataOutputStream4 = dataOutputStream2;
                bufferedReader = bufferedReader3;
                bufferedReader2 = bufferedReader4;
            }
        }
        return new a(-1, null, null);
    }

    /* compiled from: ShellAdbUtils.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f5535a;

        /* renamed from: b  reason: collision with root package name */
        public String f5536b;

        /* renamed from: c  reason: collision with root package name */
        public String f5537c;

        public a(int i, String str, String str2) {
            this.f5535a = i;
            this.f5536b = str;
            this.f5537c = str2;
        }
    }
}
