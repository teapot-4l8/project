package b.a.h.a;

import android.text.TextUtils;
import b.a.h.a.b;
import b.a.k.e;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final e f3207a = e.a("HttpPoster");

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3208b;

    private a(boolean z) {
        this.f3208b = z;
    }

    public static a a(boolean z) {
        return new a(z);
    }

    private void a(HttpURLConnection httpURLConnection) {
        boolean z = httpURLConnection instanceof HttpsURLConnection;
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(5000);
    }

    public b a(String str, d dVar, d dVar2) {
        return a(str, dVar, c.a(dVar2), false);
    }

    public b a(String str, d dVar, String str2) {
        return a(str, dVar, str2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x017a A[ADDED_TO_REGION, EDGE_INSN: B:110:0x017a->B:91:0x017a ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012e A[Catch: IOException -> 0x012a, TryCatch #7 {IOException -> 0x012a, blocks: (B:56:0x0126, B:59:0x012e, B:61:0x0133), top: B:92:0x0126 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0133 A[Catch: IOException -> 0x012a, TRY_LEAVE, TryCatch #7 {IOException -> 0x012a, blocks: (B:56:0x0126, B:59:0x012e, B:61:0x0133), top: B:92:0x0126 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0147 A[Catch: IOException -> 0x0143, TryCatch #9 {IOException -> 0x0143, blocks: (B:66:0x013f, B:69:0x0147, B:71:0x014c), top: B:94:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014c A[Catch: IOException -> 0x0143, TRY_LEAVE, TryCatch #9 {IOException -> 0x0143, blocks: (B:66:0x013f, B:69:0x0147, B:71:0x014c), top: B:94:0x013f }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0164 A[Catch: IOException -> 0x0160, TryCatch #12 {IOException -> 0x0160, blocks: (B:78:0x015c, B:81:0x0164, B:83:0x0169), top: B:98:0x015c }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0169 A[Catch: IOException -> 0x0160, TRY_LEAVE, TryCatch #12 {IOException -> 0x0160, blocks: (B:78:0x015c, B:81:0x0164, B:83:0x0169), top: B:98:0x015c }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b a(String str, d dVar, String str2, boolean z) {
        d dVar2;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        InputStream inputStream2;
        BufferedOutputStream bufferedOutputStream;
        InputStream errorStream;
        b bVar = new b();
        (dVar == null ? new d(true) : dVar).a("ts", String.valueOf(System.currentTimeMillis()));
        b bVar2 = bVar;
        int i = 0;
        boolean z2 = false;
        String str3 = str;
        do {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                str3 = str3 + "?" + c.a(dVar2);
                httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
                try {
                    a(httpURLConnection);
                    if (!TextUtils.isEmpty(str2)) {
                        int length = str2.getBytes("UTF-8").length;
                        httpURLConnection.setFixedLengthStreamingMode(length);
                        if (z) {
                            httpURLConnection.setRequestProperty("content-type", "text/plain;charset=utf-8");
                            httpURLConnection.setRequestProperty("content-length", String.valueOf(length));
                        }
                    }
                    httpURLConnection.connect();
                    if (TextUtils.isEmpty(str2)) {
                        outputStream = null;
                        bufferedOutputStream = null;
                    } else {
                        outputStream = httpURLConnection.getOutputStream();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(outputStream);
                        } catch (EOFException unused) {
                            inputStream2 = null;
                            i++;
                            if (bufferedOutputStream2 != null) {
                            }
                            if (outputStream != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            if (this.f3208b) {
                            }
                            return bVar2;
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            try {
                                bVar2.a(b.a.FAIL);
                                bVar2.a(-1);
                                bVar2.b(e.toString());
                                if (bufferedOutputStream2 != null) {
                                }
                                if (outputStream != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection != null) {
                                }
                                return bVar2;
                            } catch (Throwable th) {
                                th = th;
                                if (bufferedOutputStream2 != null) {
                                    try {
                                        bufferedOutputStream2.close();
                                    } catch (IOException unused2) {
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        throw th;
                                    }
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (httpURLConnection != null) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = null;
                            if (bufferedOutputStream2 != null) {
                            }
                            if (outputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                        try {
                            bufferedOutputStream.write(str2.getBytes("UTF-8"));
                            bufferedOutputStream.flush();
                        } catch (EOFException unused3) {
                            inputStream2 = null;
                            bufferedOutputStream2 = bufferedOutputStream;
                            i++;
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException unused4) {
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    if (this.f3208b) {
                                        break;
                                    } else if (z2) {
                                    }
                                    return bVar2;
                                }
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (httpURLConnection != null) {
                            }
                            if (this.f3208b) {
                            }
                            return bVar2;
                        } catch (Exception e3) {
                            e = e3;
                            inputStream = null;
                            bufferedOutputStream2 = bufferedOutputStream;
                            bVar2.a(b.a.FAIL);
                            bVar2.a(-1);
                            bVar2.b(e.toString());
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException unused5) {
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    return bVar2;
                                }
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                            }
                            return bVar2;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                            bufferedOutputStream2 = bufferedOutputStream;
                            if (bufferedOutputStream2 != null) {
                            }
                            if (outputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (httpURLConnection != null) {
                            }
                            throw th;
                        }
                    }
                    if (httpURLConnection.getResponseCode() == 200) {
                        errorStream = httpURLConnection.getInputStream();
                        bVar2 = b.a(c.a(errorStream));
                    } else {
                        int responseCode = httpURLConnection.getResponseCode();
                        errorStream = httpURLConnection.getErrorStream();
                        String a2 = c.a(errorStream);
                        bVar2.a(b.a.FAIL);
                        bVar2.a(-1);
                        bVar2.b(responseCode + " : " + a2);
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (errorStream != null) {
                        errorStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    z2 = true;
                } catch (EOFException unused7) {
                    inputStream2 = null;
                    outputStream = null;
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                    outputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    outputStream = null;
                }
            } catch (EOFException unused8) {
                inputStream2 = null;
                httpURLConnection = null;
                outputStream = null;
            } catch (Exception e5) {
                e = e5;
                inputStream = null;
                httpURLConnection = null;
                outputStream = null;
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                httpURLConnection = null;
                outputStream = null;
            }
            if (this.f3208b || i >= 3) {
                break;
                break;
            }
        } while (z2);
        return bVar2;
    }
}
