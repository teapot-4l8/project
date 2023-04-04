package cn.jpush.android.u;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class c {
    public static File a(Context context, String str) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            Logger.w("FileUtils", "can't get file :" + str);
            return null;
        }
        return new File(filesDir, str);
    }

    public static Object a(File file) {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            Object readObject = objectInputStream.readObject();
            g.a((Closeable) objectInputStream);
            return readObject;
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            g.a((Closeable) objectInputStream2);
            throw th;
        }
    }

    private static void a(Context context) {
        File[] listFiles;
        File a2 = a(context, "rich");
        if (a2 != null && a2.exists() && a2.isDirectory() && (listFiles = a2.listFiles()) != null && listFiles.length > 10) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: cn.jpush.android.u.c.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(File file, File file2) {
                    if (file.lastModified() > file2.lastModified()) {
                        return -1;
                    }
                    return file.lastModified() < file2.lastModified() ? 1 : 0;
                }
            });
            c(listFiles[listFiles.length - 1]);
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Throwable th) {
            Logger.w("FileUtils", "FileUtils e:" + th);
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        byte[] bytes;
        if (str2 != null) {
            try {
                bytes = str2.getBytes("UTF-8");
            } catch (Exception e2) {
                Logger.w("FileUtils", "getBytes exception:" + e2);
                return false;
            }
        } else {
            bytes = null;
        }
        return b(str, bytes);
    }

    public static boolean a(String str, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return b(str, bArr);
    }

    public static String b(Context context, String str) {
        try {
            File a2 = a(context, str);
            if (a2 == null) {
                Logger.w("FileUtils", str + " can't be null");
                return "";
            }
            if (a2.isFile()) {
                a2.delete();
            }
            if (!a2.exists()) {
                a2.mkdirs();
            }
            return a2.getAbsolutePath() + File.separator;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : str.substring(str.lastIndexOf("/") + 1);
    }

    public static void b(File file) {
        if (file == null || file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(String str, String str2) {
        Logger.v("FileUtils", "action:createHtmlFile - filePath:" + str + ", content:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return a(str, str2);
    }

    private static boolean b(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                b(file);
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    g.a(fileOutputStream2);
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    Logger.w("FileUtils", "save to file exception:" + e + " path = " + str);
                    g.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    g.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static String c(Context context, String str) {
        try {
            if (!a.a()) {
                a(context);
                return b(context, "rich" + File.separator + str);
            }
            String str2 = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + File.separator + str + File.separator;
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean c(File file) {
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    return file.delete();
                }
                String[] list = file.list();
                if (list != null) {
                    for (String str : list) {
                        File file2 = new File(file, str);
                        if (file2.isDirectory()) {
                            c(file2);
                        } else {
                            file2.delete();
                        }
                    }
                }
                return file.delete();
            }
            return false;
        } catch (Exception unused) {
            Logger.e("FileUtils", "Delete dir error");
            return false;
        }
    }

    public static String d(Context context, String str) {
        try {
            if (a.a()) {
                String str2 = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath() + File.separator + str;
                if (new File(str2).exists()) {
                    return str2;
                }
                Logger.ww("FileUtils", "Can't find developer picture resource in SDCard.");
                return "";
            }
            return "";
        } catch (Throwable th) {
            Logger.ww("FileUtils", "Get developer picture resource failed.");
            th.printStackTrace();
            return "";
        }
    }
}
