package b.a.d;

import com.google.android.gms.ads.AdRequest;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0065a {

        /* renamed from: a  reason: collision with root package name */
        private static final a f3124a = new a();
    }

    private a() {
    }

    public static a a() {
        return C0065a.f3124a;
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int read;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[AdRequest.MAX_CONTENT_URL_LENGTH];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                    continue;
                }
            } catch (Exception unused) {
            }
        } while (read >= 512);
        return sb.toString();
    }

    public String a(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(String str) {
        Process process;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            process = Runtime.getRuntime().exec("sh");
            try {
                bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
                try {
                    bufferedInputStream3 = new BufferedInputStream(process.getInputStream());
                } catch (Exception unused) {
                    bufferedInputStream2 = 0;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream3 = null;
                }
            } catch (Exception unused2) {
                bufferedOutputStream = null;
                bufferedInputStream2 = bufferedOutputStream;
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream2 != 0) {
                }
                if (process != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } catch (Exception unused3) {
            process = null;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
            bufferedInputStream = null;
        }
        try {
            bufferedOutputStream.write(str.getBytes());
            bufferedOutputStream.write(10);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            process.waitFor();
            String a2 = a(bufferedInputStream3);
            try {
                bufferedOutputStream.close();
            } catch (IOException unused4) {
            }
            try {
                bufferedInputStream3.close();
            } catch (IOException unused5) {
            }
            if (process != null) {
                process.destroy();
            }
            return a2;
        } catch (Exception unused6) {
            bufferedInputStream2 = bufferedInputStream3;
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException unused7) {
                }
            }
            if (bufferedInputStream2 != 0) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused8) {
                }
            }
            if (process != null) {
                process.destroy();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream2 = bufferedOutputStream;
            bufferedInputStream = bufferedInputStream3;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException unused9) {
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException unused10) {
                }
            }
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }
}
