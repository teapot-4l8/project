package com.speed.speed_library.business.update.fullupdate;

import android.content.ContentValues;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* compiled from: FullUpdateHttp.java */
/* loaded from: classes2.dex */
public final class c {

    /* compiled from: FullUpdateHttp.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(int i);

        void b();
    }

    public static long a(String str, File file, boolean z, a aVar) {
        return a(str, file, z, new ContentValues(), aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(String str, File file, boolean z, ContentValues contentValues, a aVar) {
        int i;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        if (!z && file.exists() && file.isFile()) {
            file.delete();
        }
        FileOutputStream fileOutputStream3 = null;
        FileInputStream fileInputStream = null;
        fileOutputStream3 = null;
        FileOutputStream fileOutputStream4 = null;
        InputStream inputStream2 = null;
        int i2 = 0;
        if (z && file.exists()) {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        i = fileInputStream2.available();
                        fileInputStream2.close();
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                throw e3;
            }
        } else {
            i = 0;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            if (i > 0) {
                httpURLConnection.setRequestProperty("RANGE", "bytes=" + i + "-");
            }
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue().toString());
            }
            if (httpURLConnection.getResponseCode() != 301 && httpURLConnection.getResponseCode() != 302) {
                long j = -1;
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        long contentLength = httpURLConnection.getContentLength();
                        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                        if (headerField != null && headerField.equalsIgnoreCase("gzip")) {
                            inputStream = new GZIPInputStream(inputStream);
                        }
                        FileOutputStream fileOutputStream5 = new FileOutputStream(file, z);
                        try {
                            byte[] bArr = new byte[8192];
                            int i3 = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream5.write(bArr, i2, read);
                                fileOutputStream5.flush();
                                fileOutputStream2 = fileOutputStream5;
                                j += read;
                                if (aVar != null) {
                                    try {
                                        i3 = (int) ((100 * j) / contentLength);
                                        aVar.a(i3);
                                    } catch (Exception e4) {
                                        e = e4;
                                        fileOutputStream = fileOutputStream2;
                                        inputStream2 = inputStream;
                                        try {
                                            aVar.b();
                                            throw e;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStream = inputStream2;
                                            fileOutputStream3 = fileOutputStream;
                                            if (fileOutputStream3 != null) {
                                                fileOutputStream3.close();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        fileOutputStream3 = fileOutputStream2;
                                        if (fileOutputStream3 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        throw th;
                                    }
                                }
                                fileOutputStream5 = fileOutputStream2;
                                i2 = 0;
                            }
                            fileOutputStream2 = fileOutputStream5;
                            if (i3 != 100) {
                                aVar.a(100);
                            }
                            if (j < 0) {
                                j = 0;
                            }
                            fileOutputStream4 = fileOutputStream2;
                        } catch (Exception e5) {
                            e = e5;
                            fileOutputStream2 = fileOutputStream5;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream2 = fileOutputStream5;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        fileOutputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } else {
                    aVar.b();
                    inputStream = null;
                }
                if (fileOutputStream4 != null) {
                    fileOutputStream4.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (j >= 0) {
                    if (aVar != null) {
                        aVar.a();
                    }
                    return j;
                }
                throw new Exception("Download file fail: " + str);
            }
            return a(httpURLConnection.getHeaderField("location"), file, z, contentValues, aVar);
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }
}
