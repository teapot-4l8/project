package cn.jiguang.v;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import com.google.zxing.common.StringUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {
    public static JSONObject a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    Object onEvent = JCoreManager.onEvent(context, "JCOMMON", 42, null, null, str);
                    if (onEvent instanceof JSONObject) {
                        return (JSONObject) onEvent;
                    }
                    return null;
                }
            } catch (Throwable th) {
                cn.jiguang.ad.a.d("JCommonFileHelper", "readJson throwable:" + th.getMessage());
            }
        }
        return null;
    }

    private static void a(File file, ZipOutputStream zipOutputStream, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str.trim().length() == 0 ? "" : File.separator);
            sb.append(file.getName());
            String str2 = new String(sb.toString().getBytes("8859_1"), StringUtils.GB2312);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        a(file2, zipOutputStream, str2);
                    }
                    return;
                }
                return;
            }
            byte[] bArr = new byte[1048576];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
            zipOutputStream.putNextEntry(new ZipEntry(str2));
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    bufferedInputStream.close();
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    return;
                }
                zipOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JCommonFileHelper", "zipFile throwable:" + th.getMessage());
        }
    }

    public static void a(Collection<File> collection, File file) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File file2 : collection) {
            a(file2, zipOutputStream, "");
        }
        zipOutputStream.close();
    }

    public static boolean a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File a2 = cn.jiguang.f.e.a(context, str);
                    if (a2 == null) {
                        return false;
                    }
                    return cn.jiguang.f.e.a(a2, str2);
                }
            } catch (Throwable th) {
                cn.jiguang.ad.a.d("JCommonFileHelper", "writeString throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, JSONObject jSONObject) {
        boolean booleanValue;
        if (context != null && !TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                synchronized (str) {
                    Object onEvent = JCoreManager.onEvent(context, "JCOMMON", 41, null, null, str, jSONObject);
                    booleanValue = onEvent instanceof Boolean ? ((Boolean) onEvent).booleanValue() : false;
                }
                return booleanValue;
            } catch (Throwable th) {
                cn.jiguang.ad.a.d("JCommonFileHelper", "writeJson throwable:" + th.getMessage());
            }
        }
        return false;
    }

    public static String b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                synchronized (str) {
                    File a2 = cn.jiguang.f.e.a(context, str);
                    if (a2 == null) {
                        return null;
                    }
                    return cn.jiguang.f.e.b(a2);
                }
            } catch (Throwable th) {
                cn.jiguang.ad.a.d("JCommonFileHelper", "readString throwable:" + th.getMessage());
            }
        }
        return null;
    }
}
