package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.zip.Deflater;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: UMSLUtils.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f6811a;

    /* renamed from: b  reason: collision with root package name */
    private static Object f6812b = new Object();

    public static boolean a(long j, long j2) {
        return j > j2;
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static int a(Context context, String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        int i = 101;
        if (context != null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    synchronized (f6812b) {
                        try {
                            File file = new File(context.getFilesDir() + File.separator + str);
                            if (!file.isDirectory()) {
                                file.mkdir();
                            }
                            fileOutputStream = new FileOutputStream(new File(file.getPath() + File.separator + str2));
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            fileOutputStream.write(bArr);
                            fileOutputStream.close();
                            i = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            throw th;
                        }
                    }
                }
            } catch (IOException e2) {
                UMCrashManager.reportCrash(context, e2);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0101, code lost:
        if (r2 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str, String str2, byte[] bArr) {
        boolean z;
        FileOutputStream fileOutputStream;
        if (context == null) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                synchronized (f6812b) {
                    try {
                        ULog.i("walle", "[stateless] begin write envelope, thread is " + Thread.currentThread());
                        File file = new File(context.getFilesDir() + "/" + a.f6801e);
                        if (!file.isDirectory()) {
                            file.mkdir();
                        }
                        File file2 = new File(file.getPath() + "/" + str);
                        if (!file2.isDirectory()) {
                            file2.mkdir();
                        }
                        File file3 = new File(file2.getPath() + "/" + str2);
                        if (!file3.exists()) {
                            file3.createNewFile();
                        }
                        fileOutputStream = new FileOutputStream(file3);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream2 = fileOutputStream;
                        z = false;
                        while (true) {
                            try {
                                break;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        throw th;
                    }
                    try {
                        return true;
                    } catch (Throwable th4) {
                        th = th4;
                        z = true;
                        while (true) {
                            break;
                            break;
                        }
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                z = false;
            } catch (Throwable th5) {
                th = th5;
                z = false;
            }
            try {
                break;
                throw th;
            } catch (IOException e3) {
                e = e3;
                ULog.i("walle", "[stateless] write envelope, e is " + e.getMessage());
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th6) {
                th = th6;
                ULog.i("walle", "[stateless] write envelope, e is " + th.getMessage());
                UMCrashManager.reportCrash(context, th);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                return z;
            }
        } catch (Throwable th7) {
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th7;
        }
    }

    public static byte[] a(String str) {
        byte[] bArr;
        synchronized (f6812b) {
            try {
                FileChannel channel = new RandomAccessFile(str, "r").getChannel();
                MappedByteBuffer load = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                bArr = new byte[(int) channel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (Throwable unused) {
                    }
                }
            } catch (IOException e2) {
                ULog.i("walle", "[stateless] write envelope, e is " + e2.getMessage());
                throw e2;
            }
        }
        return bArr;
    }

    public static File a(Context context) {
        File[] listFiles;
        File[] listFiles2;
        File file = null;
        try {
            synchronized (f6812b) {
                ULog.i("walle", "get last envelope begin, thread is " + Thread.currentThread());
                if (context != null && context.getApplicationContext() != null) {
                    String str = context.getApplicationContext().getFilesDir() + File.separator + a.f6801e;
                    if (!TextUtils.isEmpty(str)) {
                        File file2 = new File(str);
                        if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                            for (File file3 : listFiles) {
                                if (file3 != null && file3.isDirectory() && (listFiles2 = file3.listFiles()) != null && listFiles2.length > 0) {
                                    Arrays.sort(listFiles2, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.1
                                        @Override // java.util.Comparator
                                        /* renamed from: a */
                                        public int compare(File file4, File file5) {
                                            long lastModified = file4.lastModified() - file5.lastModified();
                                            if (lastModified > 0) {
                                                return 1;
                                            }
                                            return lastModified == 0 ? 0 : -1;
                                        }
                                    });
                                    File file4 = listFiles2[0];
                                    if (file4 != null && (file == null || file.lastModified() > file4.lastModified())) {
                                        file = file4;
                                    }
                                }
                            }
                        }
                    }
                }
                ULog.i("walle", "get last envelope end, thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return file;
    }

    public static File b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f6812b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f6812b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.2
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file2, File file3) {
                                long lastModified = file2.lastModified() - file3.lastModified();
                                if (lastModified > 0) {
                                    return 1;
                                }
                                return lastModified == 0 ? 0 : -1;
                            }
                        });
                        return listFiles[0];
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        String str;
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (z) {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.f6801e;
            } else {
                str = context.getApplicationContext().getFilesDir() + File.separator + a.f;
            }
            str2 = str;
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static File[] c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            synchronized (f6812b) {
                String str = context.getApplicationContext().getFilesDir() + File.separator + a.f;
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                synchronized (f6812b) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.3
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file2, File file3) {
                                long lastModified = file2.lastModified() - file3.lastModified();
                                if (lastModified > 0) {
                                    return 1;
                                }
                                return lastModified == 0 ? 0 : -1;
                            }
                        });
                        return listFiles;
                    }
                    return null;
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static void a(Context context, String str, int i) {
        try {
            if (str == null) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            File file = new File(str);
            if (!file.isDirectory()) {
                ULog.i("AmapLBS", "[lbs-build] fileDir not exist, thread is " + Thread.currentThread());
                return;
            }
            synchronized (f6812b) {
                File[] listFiles = file.listFiles();
                ULog.i("AmapLBS", "[lbs-build] delete file begin " + listFiles.length + ", thread is " + Thread.currentThread());
                if (listFiles != null && listFiles.length >= i) {
                    ULog.i("AmapLBS", "[lbs-build] file size >= max");
                    ArrayList arrayList = new ArrayList();
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            arrayList.add(file2);
                        }
                    }
                    if (arrayList.size() >= i) {
                        Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.4
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(File file3, File file4) {
                                if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                    return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                }
                                return -1;
                            }
                        });
                        if (ULog.DEBUG) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i2)).getPath());
                            }
                        }
                        for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                            if (arrayList.get(i3) != null) {
                                ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i3)).getPath());
                                try {
                                    ((File) arrayList.get(i3)).delete();
                                    arrayList.remove(i3);
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                } else {
                    ULog.i("AmapLBS", "[lbs-build] file size < max");
                }
                ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static void a(Context context, String str, final String str2, int i) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.isDirectory()) {
                synchronized (f6812b) {
                    File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.umeng.commonsdk.stateless.d.5
                        @Override // java.io.FilenameFilter
                        public boolean accept(File file2, String str3) {
                            return str3.startsWith(str2);
                        }
                    });
                    if (listFiles != null && listFiles.length >= i) {
                        ULog.i("AmapLBS", "[lbs-build] file size >= max");
                        ArrayList arrayList = new ArrayList();
                        for (File file2 : listFiles) {
                            if (file2 != null) {
                                arrayList.add(file2);
                            }
                        }
                        if (arrayList.size() >= i) {
                            Collections.sort(arrayList, new Comparator<File>() { // from class: com.umeng.commonsdk.stateless.d.6
                                @Override // java.util.Comparator
                                /* renamed from: a */
                                public int compare(File file3, File file4) {
                                    if (file3 == null || file4 == null || file3.lastModified() >= file4.lastModified()) {
                                        return (file3 == null || file4 == null || file3.lastModified() != file4.lastModified()) ? 1 : 0;
                                    }
                                    return -1;
                                }
                            });
                            if (ULog.DEBUG) {
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun native file is " + ((File) arrayList.get(i2)).getPath());
                                }
                            }
                            for (int i3 = 0; i3 <= arrayList.size() - i; i3++) {
                                if (arrayList.get(i3) != null) {
                                    ULog.i("AmapLBS", "[lbs-build] overrun remove file is " + ((File) arrayList.get(i3)).getPath());
                                    try {
                                        ((File) arrayList.get(i3)).delete();
                                        arrayList.remove(i3);
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    } else {
                        ULog.i("AmapLBS", "[lbs-build] file size < max");
                    }
                    ULog.i("AmapLBS", "[lbs-build] delete file end " + listFiles.length + ", thread is " + Thread.currentThread());
                }
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        f6811a = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (!deflater.finished()) {
                try {
                    int deflate = deflater.deflate(bArr2);
                    f6811a += deflate;
                    byteArrayOutputStream2.write(bArr2, 0, deflate);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            }
            deflater.end();
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(UMUtils.genIv()));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    public static String b(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String c(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d(String str) {
        int lastIndexOf;
        int lastIndexOf2;
        return (!TextUtils.isEmpty(str) && str.indexOf("envelope") < 0 && (lastIndexOf = str.lastIndexOf("_")) >= 0 && (lastIndexOf2 = str.lastIndexOf(".")) >= 0) ? str.substring(lastIndexOf + 1, lastIndexOf2) : "";
    }
}
