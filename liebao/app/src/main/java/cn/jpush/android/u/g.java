package cn.jpush.android.u;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4497a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f4498b = new ConcurrentHashMap<>();

    /* loaded from: classes.dex */
    private static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a  reason: collision with root package name */
        private String f4499a;

        a(String str) {
            this.f4499a = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f4499a, Locale.ENGLISH);
        }
    }

    public static double a(double d2, double d3, double d4, double d5) {
        double d6 = d3 * 0.008726646259971648d;
        double d7 = d5 * 0.008726646259971648d;
        return Math.round((Math.asin(Math.sqrt(Math.pow(Math.sin(d6 - d7), 2.0d) + ((Math.cos(d6 * 2.0d) * Math.cos(d7 * 2.0d)) * Math.pow(Math.sin((d2 - d4) * 0.008726646259971648d), 2.0d)))) * 1.2756274E7d) * 10000.0d) / 10000;
    }

    public static String a(Collection<String> collection, String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : collection) {
            sb.append(str2);
            sb.append(str);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f4498b.get(str);
        if (threadLocal == null) {
            synchronized (f4497a) {
                threadLocal = f4498b.get(str);
                if (threadLocal == null) {
                    threadLocal = new a(str);
                    f4498b.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String optString = jSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream != null) {
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            return bArr;
        }
        throw new IOException("InputStream is null");
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    a(byteArrayOutputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            a(byteArrayOutputStream2);
            throw th;
        }
    }
}
