package cn.jiguang.aj;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.f.i;
import cn.jiguang.f.k;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class b {
    public static File a(Context context, File file) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        try {
            String k = i.k(cn.jiguang.f.a.a(context));
            if (TextUtils.isEmpty(k)) {
                cn.jiguang.an.d.h("PIU", "process name to md5 failed");
                k.a((Closeable) null);
                k.a((Closeable) null);
                return null;
            }
            String k2 = i.k(k + file.getName());
            if (TextUtils.isEmpty(k2)) {
                cn.jiguang.an.d.h("PIU", "process + fileName to md5 failed");
                k.a((Closeable) null);
                k.a((Closeable) null);
                return null;
            }
            File file2 = new File(file.getParentFile(), k + File.separator + k2 + ".d");
            if (file2.exists()) {
                file2.delete();
            }
            file2.getParentFile().mkdirs();
            file2.createNewFile();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[32];
                    fileInputStream.read(bArr);
                    String str = new String(bArr, "utf-8");
                    cn.jiguang.an.d.b("PIU", "get md5:" + str);
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    cipher.init(2, new SecretKeySpec(str.getBytes("utf-8"), "AES"), new IvParameterSpec(cn.jiguang.al.c.f3725a.getBytes("utf-8")));
                    CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream2, cipher);
                    byte[] bArr2 = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr2, 0, 8192);
                        if (read == -1) {
                            break;
                        }
                        cipherOutputStream.write(bArr2, 0, read);
                    }
                    k.a(cipherOutputStream);
                    String a2 = cn.jiguang.al.a.a(file2.getAbsolutePath());
                    cn.jiguang.an.d.b("PIU", "dd f md:" + a2);
                    if (!str.equals(a2)) {
                        k.a(fileOutputStream2);
                        k.a((Closeable) fileInputStream);
                        return null;
                    }
                    cn.jiguang.an.d.b("PIU", "d d success");
                    k.a(fileOutputStream2);
                    k.a((Closeable) fileInputStream);
                    return file2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    fileOutputStream = fileOutputStream2;
                    th = th2;
                    try {
                        cn.jiguang.an.d.f("PIU", "decode failed:" + th.getMessage());
                        return null;
                    } finally {
                        k.a(fileOutputStream);
                        k.a((Closeable) fileInputStream);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    public static File a(Context context, String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        String a2 = a(str, sb.toString(), i2);
        return new File(context.getFilesDir() + File.separator + ".p", a2);
    }

    private static String a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            str = str2 + i;
        }
        return "." + str;
    }

    public static File b(Context context, String str, int i, int i2) {
        if (context != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            String str2 = context.getFilesDir() + File.separator + ".p";
            File file = new File(str2, a(str, sb.toString(), i2) + "o");
            cn.jiguang.an.d.b("PIU", "getLibPath mkdirs:" + file.mkdirs());
            return file;
        }
        return null;
    }

    public static File c(Context context, String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        String str2 = context.getFilesDir() + File.separator + ".p";
        File file = new File(str2, a(str, sb.toString(), i2) + "ox");
        cn.jiguang.an.d.b("PIU", "getOptimizedDexPath mkdirs:" + file.mkdirs());
        return file;
    }
}
