package cn.jiguang.al;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f3724a = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);

    private static File a(String str, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        Throwable th;
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                if (inputStream != null) {
                    inputStream.close();
                }
                fileOutputStream.close();
                return file;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    public static String a(String str, int i, String str2) {
        byte[] a2;
        try {
            HttpURLConnection a3 = a(str);
            a3.setRequestProperty("Content-Type", "application/json");
            a3.setConnectTimeout(10000);
            a3.setReadTimeout(10000);
            a3.setRequestMethod("POST");
            a3.setDoOutput(true);
            a3.setDoInput(true);
            a3.getOutputStream().write(str2.getBytes());
            int responseCode = a3.getResponseCode();
            cn.jiguang.an.d.f("HttpUtils", "httpPost:" + str + " responseCode:" + responseCode);
            if (200 == responseCode && (a2 = a(a3.getInputStream())) != null) {
                return new String(a2, "UTF-8");
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            cn.jiguang.an.d.a("HttpUtils", "httpPost:" + str + " fail.", th);
            return null;
        }
    }

    private static HttpURLConnection a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static File b(String str, int i, String str2) {
        try {
            HttpURLConnection a2 = a(str);
            a2.setConnectTimeout(10000);
            a2.setReadTimeout(10000);
            int responseCode = a2.getResponseCode();
            cn.jiguang.an.d.f("HttpUtils", "download:" + str + " responseCode:" + responseCode);
            if (200 != responseCode) {
                return null;
            }
            return a(str2, a2.getInputStream());
        } catch (Throwable th) {
            cn.jiguang.an.d.a("HttpUtils", "download:" + str + " fail.", th);
            return null;
        }
    }
}
