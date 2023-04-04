package cn.jpush.android.o;

import cn.jiguang.internal.JConstants;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.u.g;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, int i, long j) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        String str2;
        Exception e2;
        AssertionError e3;
        Logger.d("HttpManager", "action:httpSimpleGet - " + str);
        i = (i < 1 || i > 10) ? 1 : 1;
        j = (j < 200 || j > JConstants.MIN) ? 2000L : 2000L;
        int i2 = 0;
        int i3 = -1;
        String str3 = null;
        while (true) {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setRequestProperty("Connection", "Close");
                    httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                    i3 = httpURLConnection.getResponseCode();
                    Logger.v("HttpManager", "statusCode:" + i3);
                } catch (Throwable unused) {
                    inputStream = null;
                }
            } catch (Throwable unused2) {
                httpURLConnection = null;
                inputStream = null;
            }
            if (i3 == 200) {
                inputStream = httpURLConnection.getInputStream();
                try {
                    str2 = new String(a(inputStream), "UTF-8");
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused3) {
                        }
                    }
                    try {
                        g.a((Closeable) inputStream);
                        return str2;
                    } catch (AssertionError e4) {
                        e3 = e4;
                        Logger.e("HttpManager", "Catch AssertionError to avoid http close crash - " + e3.toString());
                        str3 = str2;
                        if (i2 < i) {
                        }
                    } catch (Exception e5) {
                        e2 = e5;
                        Logger.d("HttpManager", "http client execute error:" + e2.getMessage());
                        str3 = str2;
                        if (i2 < i) {
                        }
                    }
                } catch (Throwable unused4) {
                    try {
                        Logger.d("HttpManager", "httpSimpleGet failed,retriedCount:" + i2 + ",statusCode:" + i3);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused5) {
                            }
                        }
                        try {
                            g.a((Closeable) inputStream);
                        } catch (AssertionError e6) {
                            str2 = str3;
                            e3 = e6;
                            Logger.e("HttpManager", "Catch AssertionError to avoid http close crash - " + e3.toString());
                            str3 = str2;
                            if (i2 < i) {
                            }
                        } catch (Exception e7) {
                            str2 = str3;
                            e2 = e7;
                            Logger.d("HttpManager", "http client execute error:" + e2.getMessage());
                            str3 = str2;
                            if (i2 < i) {
                            }
                        }
                        if (i2 < i) {
                        }
                    } catch (Throwable th) {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused6) {
                            }
                        }
                        g.a((Closeable) inputStream);
                        throw th;
                        break;
                    }
                }
            } else {
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused7) {
                    }
                }
                g.a((Closeable) null);
                if (i2 < i) {
                    return str3;
                }
                i2++;
                try {
                    Thread.sleep(j);
                } catch (InterruptedException unused8) {
                }
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        return g.b(inputStream);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x012b A[Catch: all -> 0x0133, TRY_ENTER, TryCatch #3 {all -> 0x0133, blocks: (B:52:0x0100, B:54:0x0105, B:63:0x012b, B:65:0x0130), top: B:85:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0130 A[Catch: all -> 0x0133, TRY_LEAVE, TryCatch #3 {all -> 0x0133, blocks: (B:52:0x0100, B:54:0x0105, B:63:0x012b, B:65:0x0130), top: B:85:0x0017 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] a(String str) {
        InputStream inputStream;
        byte[] bArr;
        String str2;
        Logger.d("HttpManager", "action:httpGetIconBytes-" + str);
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream2 = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection2.setRequestProperty("Accept-Encoding", "identity");
                    httpURLConnection2.addRequestProperty("Connection", "Close");
                    httpURLConnection2.setReadTimeout(5000);
                    int responseCode = httpURLConnection2.getResponseCode();
                    Logger.v("HttpManager", "httpGetIconBytes statusCode:" + responseCode);
                    if (responseCode == 200) {
                        int contentLength = httpURLConnection2.getContentLength();
                        inputStream = httpURLConnection2.getInputStream();
                        if (inputStream != null) {
                            try {
                                bArr = a(inputStream);
                            } catch (Throwable th) {
                                th = th;
                                bArr = null;
                                httpURLConnection = httpURLConnection2;
                                try {
                                    Logger.w("HttpManager", "httpGetIconBytes failed:" + th.getMessage());
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    return bArr;
                                } catch (Throwable th2) {
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused) {
                                            throw th2;
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    throw th2;
                                }
                            }
                        } else {
                            bArr = null;
                        }
                        try {
                            if (bArr == null || contentLength == 0) {
                                Logger.d("HttpManager", "httpGetIconBytes - Unexpected: downloaded bytes content length is 0");
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return null;
                            } else if (contentLength > 30720) {
                                Logger.d("HttpManager", "httpGetIconBytes - Unexpected:icon  size too big,max size is30720");
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return null;
                            } else if (bArr.length < contentLength) {
                                Logger.d("HttpManager", "httpGetIconBytes - Download bytes failed. Got bytes len < header content length.");
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                return null;
                            } else {
                                inputStream2 = inputStream;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection = httpURLConnection2;
                            Logger.w("HttpManager", "httpGetIconBytes failed:" + th.getMessage());
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            return bArr;
                        }
                    } else {
                        if (400 == responseCode) {
                            str2 = "httpGetIconBytes - server response failure - " + str;
                        } else if (404 == responseCode) {
                            str2 = "httpGetIconBytes - Request path does not exist: 404 - " + str;
                        } else {
                            str2 = "httpGetIconBytes - Other wrong response status - " + responseCode + ", url:" + str;
                        }
                        Logger.d("HttpManager", str2);
                        bArr = null;
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    bArr = null;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                bArr = null;
            }
        } catch (Throwable unused5) {
        }
        return bArr;
    }

    public static byte[] a(String str, int i) {
        byte[] bArr = null;
        for (int i2 = 0; i2 < i; i2++) {
            bArr = a(str);
            if (bArr != null) {
                break;
            }
        }
        return bArr;
    }

    public static byte[] a(String str, int i, long j, int i2) {
        byte[] bArr = null;
        for (int i3 = 0; i3 < i2; i3++) {
            bArr = b(str, i, j);
            if (bArr != null) {
                break;
            }
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
        if (r8 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bb, code lost:
        if (r8 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bd, code lost:
        r8.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c0, code lost:
        r6 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] b(String str, int i, long j) {
        HttpURLConnection httpURLConnection;
        Exception e2;
        byte[] bArr;
        StringBuilder sb;
        String str2;
        i = (i < 1 || i > 10) ? 1 : 1;
        j = (j < 200 || j > JConstants.MIN) ? 2000L : 2000L;
        Logger.d("HttpManager", "action:httpGet - " + str);
        int i2 = -1;
        int i3 = 0;
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection2 = null;
        int i4 = 0;
        while (true) {
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (SSLHandshakeException unused) {
                } catch (SSLPeerUnverifiedException unused2) {
                } catch (Exception e3) {
                    httpURLConnection = httpURLConnection2;
                    e2 = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                    httpURLConnection.addRequestProperty("Connection", "Close");
                    i2 = httpURLConnection.getResponseCode();
                    Logger.v("HttpManager", "statusCode:" + i2);
                    if (i2 == 200) {
                        i4 = httpURLConnection.getContentLength();
                        inputStream = httpURLConnection.getInputStream();
                        if (inputStream == null) {
                            bArr = null;
                            break;
                        }
                        bArr = a(inputStream);
                        break;
                    } else if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                } catch (SSLHandshakeException unused4) {
                    httpURLConnection2 = httpURLConnection;
                    Logger.dd("HttpManager", "Catch SSLHandshakeException, http client execute error!");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    bArr = null;
                    if (200 != i2) {
                    }
                    sb.append(str);
                    Logger.d("HttpManager", sb.toString());
                    return null;
                } catch (SSLPeerUnverifiedException unused6) {
                    httpURLConnection2 = httpURLConnection;
                    Logger.ee("HttpManager", "Catch SSLPeerUnverifiedException, http client execute error!");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (i3 >= i) {
                        return null;
                    }
                    i3++;
                    try {
                        Thread.sleep(i3 * j);
                    } catch (InterruptedException unused8) {
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    Logger.d("HttpManager", "http client execute error:" + e2.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused9) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused10) {
                    }
                }
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused11) {
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (200 != i2) {
            try {
                if (i4 == 0) {
                    Logger.d("HttpManager", "Unexpected: downloaded bytes content length is 0");
                    return null;
                } else if (bArr.length < i4) {
                    Logger.d("HttpManager", "Download bytes failed. Got bytes len < header content length.");
                    return null;
                } else {
                    return bArr;
                }
            } catch (Exception e5) {
                sb = new StringBuilder();
                sb.append("parse response error:");
                str = e5.getMessage();
            }
        } else {
            if (400 == i2) {
                sb = new StringBuilder();
                str2 = "server response failure - ";
            } else if (404 == i2) {
                sb = new StringBuilder();
                str2 = "Request path does not exist: 404 - ";
            } else {
                sb = new StringBuilder();
                sb.append("Other wrong response status - ");
                sb.append(i2);
                str2 = ", url:";
            }
            sb.append(str2);
        }
        sb.append(str);
        Logger.d("HttpManager", sb.toString());
        return null;
    }
}
