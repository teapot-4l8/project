package b.a.g;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private b.a.k.e f3196b;

    public c(Context context) {
        super(context);
        this.f3196b = b.a.k.e.a("ExternalStorage");
    }

    private String a(File file) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.readFully(bArr);
            String str = new String(bArr);
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    private void a(File file, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    @Override // b.a.g.a
    public String b(String str) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            try {
                return a(new File(externalStorageDirectory.getAbsolutePath() + "/Installation", str));
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    @Override // b.a.g.a
    public boolean b(String str, String str2) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            try {
                File file = new File(externalStorageDirectory.getAbsolutePath() + "/Installation", str);
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                a(file, str2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }
}
