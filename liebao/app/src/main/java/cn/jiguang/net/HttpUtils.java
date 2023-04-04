package cn.jiguang.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import cn.jiguang.an.d;
import cn.jiguang.f.c;
import cn.jiguang.f.k;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* loaded from: classes.dex */
public class HttpUtils {

    /* loaded from: classes.dex */
    public abstract class HttpListener {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:6|7|8|9|(4:13|(1:15)|16|(1:18))|19|20|(6:114|115|(2:117|(1:119))|120|(1:122)(1:125)|123)|(2:23|(16:25|26|27|28|29|30|32|33|(9:36|37|(3:54|55|(1:57))|(1:44)|(1:46)|(1:48)|50|(1:52)|53)|62|(3:40|42|44)|(0)|(0)|50|(0)|53))|113|28|29|30|32|33|(9:36|37|(0)|(0)|(0)|(0)|50|(0)|53)|62|(0)|(0)|(0)|50|(0)|53) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01fb, code lost:
        if ((r10 instanceof java.net.UnknownHostException) != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01fd, code lost:
        r2.setResponseCode(3003);
        r11 = "域名无效";
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0207, code lost:
        if ((r10 instanceof javax.net.ssl.SSLHandshakeException) != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0209, code lost:
        r2.setResponseCode(3005);
        r11 = "SSL失败";
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0231, code lost:
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0265, code lost:
        if (r11 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0267, code lost:
        r11.disconnect();
        r3 = r3;
        r9 = r9;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f0, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f1, code lost:
        cn.jiguang.an.d.b("HttpUtils", "get input stream error:" + r4.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0106, code lost:
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0172, code lost:
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0173, code lost:
        r11 = r9;
        r9 = r1;
        r1 = r4;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0177, code lost:
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:
        r8 = r1;
        r1 = r9;
        r9 = r8;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x017d, code lost:
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x017e, code lost:
        r11 = r9;
        r9 = r1;
        r1 = r4;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d8, code lost:
        if (r11 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ee, code lost:
        r2.setResponseCode(3001);
        r11 = "请求超时";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01f9 A[Catch: all -> 0x0235, TryCatch #16 {all -> 0x0235, blocks: (B:97:0x01e2, B:99:0x01ee, B:100:0x01f5, B:107:0x0211, B:101:0x01f9, B:103:0x01fd, B:104:0x0205, B:106:0x0209), top: B:139:0x01e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0139 A[Catch: all -> 0x0172, IOException -> 0x0177, MalformedURLException -> 0x017d, TryCatch #14 {MalformedURLException -> 0x017d, IOException -> 0x0177, all -> 0x0172, blocks: (B:45:0x0107, B:59:0x0129, B:61:0x012f, B:63:0x0139, B:65:0x0145), top: B:141:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0145 A[Catch: all -> 0x0172, IOException -> 0x0177, MalformedURLException -> 0x017d, TRY_LEAVE, TryCatch #14 {MalformedURLException -> 0x017d, IOException -> 0x0177, all -> 0x0172, blocks: (B:45:0x0107, B:59:0x0129, B:61:0x012f, B:63:0x0139, B:65:0x0145), top: B:141:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01ee A[Catch: all -> 0x0235, TryCatch #16 {all -> 0x0235, blocks: (B:97:0x01e2, B:99:0x01ee, B:100:0x01f5, B:107:0x0211, B:101:0x01f9, B:103:0x01fd, B:104:0x0205, B:106:0x0209), top: B:139:0x01e2 }] */
    /* JADX WARN: Type inference failed for: r11v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static HttpResponse a(Context context, HttpRequest httpRequest, boolean z) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream2;
        String str;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream4;
        OutputStream outputStream3;
        HttpURLConnection httpURLConnectionWithProxy;
        OutputStream outputStream4;
        URL url;
        HttpsURLConnection httpsURLConnection;
        HostnameVerifier defaultHostVerifier;
        OutputStream outputStream5;
        int responseCode;
        byte[] bArr;
        InputStream inputStream5 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        InputStream inputStream6 = null;
        inputStream5 = null;
        inputStream5 = null;
        inputStream5 = null;
        inputStream5 = null;
        inputStream5 = null;
        HttpURLConnection httpURLConnection4 = null;
        inputStream5 = null;
        if (httpRequest == null) {
            return null;
        }
        OutputStream url2 = httpRequest.getUrl();
        HttpResponse httpResponse = new HttpResponse(url2);
        try {
            try {
                httpURLConnectionWithProxy = getHttpURLConnectionWithProxy(context, httpRequest.getUrl());
                try {
                    d.a("HttpUtils", "host:" + url.getHost() + ",port:" + httpURLConnectionWithProxy.getURL().getPort());
                    if (httpRequest != null && httpURLConnectionWithProxy != null) {
                        setURLConnection(httpRequest.getRequestProperties(), httpURLConnectionWithProxy);
                        if (httpRequest.getConnectTimeout() >= 0) {
                            httpURLConnectionWithProxy.setConnectTimeout(httpRequest.getConnectTimeout());
                        }
                        if (httpRequest.getReadTimeout() >= 0) {
                            httpURLConnectionWithProxy.setReadTimeout(httpRequest.getReadTimeout());
                        }
                    }
                    if (httpURLConnectionWithProxy instanceof HttpsURLConnection) {
                        try {
                            if (httpRequest.getSslTrustManager() != null) {
                                SSLContext sSLContext = SSLContext.getInstance("TLS");
                                sSLContext.init(null, new TrustManager[]{httpRequest.getSslTrustManager()}, new SecureRandom());
                                if (sSLContext != null) {
                                    ((HttpsURLConnection) httpURLConnectionWithProxy).setSSLSocketFactory(sSLContext.getSocketFactory());
                                }
                            }
                            if (httpRequest.getHostnameVerifier() != null) {
                                httpsURLConnection = (HttpsURLConnection) httpURLConnectionWithProxy;
                                defaultHostVerifier = httpRequest.getHostnameVerifier();
                            } else {
                                httpsURLConnection = (HttpsURLConnection) httpURLConnectionWithProxy;
                                defaultHostVerifier = new DefaultHostVerifier(httpURLConnectionWithProxy.getURL().getHost());
                            }
                            httpsURLConnection.setHostnameVerifier(defaultHostVerifier);
                        } catch (Throwable th) {
                            d.g("HttpUtils", "set ssl config error:" + th.getMessage());
                        }
                    }
                } catch (MalformedURLException e2) {
                    e = e2;
                    httpURLConnection2 = httpURLConnectionWithProxy;
                    inputStream3 = null;
                    outputStream2 = null;
                } catch (IOException e3) {
                    e = e3;
                    outputStream4 = null;
                    inputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnectionWithProxy;
                    inputStream = null;
                    outputStream = null;
                }
            } catch (MalformedURLException e4) {
                e = e4;
                inputStream3 = null;
                httpURLConnection2 = null;
                outputStream2 = null;
            } catch (IOException e5) {
                e = e5;
                context = null;
                url2 = null;
                inputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                httpURLConnection = null;
                outputStream = null;
            }
            if (z != 0) {
                httpURLConnectionWithProxy.setRequestMethod("POST");
                httpURLConnectionWithProxy.setDoOutput(true);
                httpURLConnectionWithProxy.setDoInput(true);
                byte[] paras = httpRequest.getParas();
                if (paras != null) {
                    OutputStream outputStream6 = httpURLConnectionWithProxy.getOutputStream();
                    try {
                        outputStream6.write(paras);
                        outputStream5 = outputStream6;
                        responseCode = httpURLConnectionWithProxy.getResponseCode();
                        httpResponse.setResponseCode(responseCode);
                        inputStream2 = httpURLConnectionWithProxy.getInputStream();
                    } catch (MalformedURLException e6) {
                        e = e6;
                        httpURLConnection2 = httpURLConnectionWithProxy;
                        inputStream3 = null;
                        outputStream2 = outputStream5;
                        d.f("HttpUtils", "http post  error:" + e.getMessage());
                        httpResponse.setResponseCode(3004);
                        httpResponse.setResponseBody("MalformedURLException");
                        k.a((Closeable) inputStream5);
                        k.a((Closeable) inputStream3);
                        k.a(outputStream2);
                        outputStream3 = outputStream2;
                        inputStream4 = inputStream3;
                        httpURLConnection3 = httpURLConnection2;
                        url2 = outputStream2;
                        context = inputStream3;
                        z = httpURLConnection2;
                    } catch (IOException e7) {
                        e = e7;
                        inputStream2 = null;
                        outputStream4 = outputStream5;
                        httpURLConnection4 = httpURLConnectionWithProxy;
                        context = inputStream2;
                        url2 = outputStream4;
                        try {
                            httpResponse.setResponseCode(2998);
                            httpResponse.setResponseBody("网络错误");
                            if (!(e instanceof SocketTimeoutException)) {
                            }
                            httpResponse.setResponseBody(str);
                            d.f("HttpUtils", "http post IOException error:" + e.getMessage());
                            k.a((Closeable) inputStream2);
                            k.a((Closeable) context);
                            k.a((Closeable) url2);
                            if (httpURLConnection4 != null) {
                            }
                            return httpResponse;
                        } catch (Throwable th4) {
                            th = th4;
                            z = httpURLConnection4;
                            inputStream5 = inputStream2;
                            k.a((Closeable) inputStream5);
                            k.a((Closeable) context);
                            k.a((Closeable) url2);
                            if (z != 0) {
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        httpURLConnection = httpURLConnectionWithProxy;
                        inputStream = null;
                        outputStream = outputStream5;
                        d.f("HttpUtils", "http post Exception error:" + th);
                        httpResponse.setResponseCode(3006);
                        httpResponse.setResponseBody("UNKnow execption" + th.getMessage());
                        k.a((Closeable) inputStream5);
                        k.a((Closeable) inputStream);
                        k.a(outputStream);
                        outputStream3 = outputStream;
                        inputStream4 = inputStream;
                        httpURLConnection3 = httpURLConnection;
                        url2 = outputStream;
                        context = inputStream;
                        z = httpURLConnection;
                    }
                    if (httpRequest.isHaveRspData() && inputStream2 != null) {
                        try {
                            bArr = readInputStream(inputStream2);
                            if (bArr != null) {
                                try {
                                    if (httpRequest.isRspDatazip()) {
                                        bArr = k.b(bArr);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                        if (bArr == null && responseCode != 200 && httpRequest.isNeedErrorInput()) {
                            inputStream6 = httpURLConnectionWithProxy.getErrorStream();
                            bArr = readInputStream(inputStream6);
                        }
                        if (bArr != null) {
                            httpResponse.setResponseBody(new String(bArr, "UTF-8"));
                        }
                        if (httpURLConnectionWithProxy != null) {
                            httpResponse.setResponseCode(httpURLConnectionWithProxy.getResponseCode());
                            httpResponse.setResponseHeader("expires", httpURLConnectionWithProxy.getHeaderField("Expires"));
                            httpResponse.setResponseHeader("cache-control", httpURLConnectionWithProxy.getHeaderField("Cache-Control"));
                        }
                        k.a((Closeable) inputStream2);
                        k.a((Closeable) inputStream6);
                        k.a(outputStream5);
                        if (httpURLConnectionWithProxy != null) {
                            httpURLConnectionWithProxy.disconnect();
                        }
                        return httpResponse;
                    }
                    bArr = null;
                    if (bArr == null) {
                        inputStream6 = httpURLConnectionWithProxy.getErrorStream();
                        bArr = readInputStream(inputStream6);
                    }
                    if (bArr != null) {
                    }
                    if (httpURLConnectionWithProxy != null) {
                    }
                    k.a((Closeable) inputStream2);
                    k.a((Closeable) inputStream6);
                    k.a(outputStream5);
                    if (httpURLConnectionWithProxy != null) {
                    }
                    return httpResponse;
                }
            }
            outputStream5 = null;
            responseCode = httpURLConnectionWithProxy.getResponseCode();
            httpResponse.setResponseCode(responseCode);
            inputStream2 = httpURLConnectionWithProxy.getInputStream();
            if (httpRequest.isHaveRspData()) {
                bArr = readInputStream(inputStream2);
                if (bArr != null) {
                }
                if (bArr == null) {
                }
                if (bArr != null) {
                }
                if (httpURLConnectionWithProxy != null) {
                }
                k.a((Closeable) inputStream2);
                k.a((Closeable) inputStream6);
                k.a(outputStream5);
                if (httpURLConnectionWithProxy != null) {
                }
                return httpResponse;
            }
            bArr = null;
            if (bArr == null) {
            }
            if (bArr != null) {
            }
            if (httpURLConnectionWithProxy != null) {
            }
            k.a((Closeable) inputStream2);
            k.a((Closeable) inputStream6);
            k.a(outputStream5);
            if (httpURLConnectionWithProxy != null) {
            }
            return httpResponse;
        } catch (Throwable th6) {
            th = th6;
            k.a((Closeable) inputStream5);
            k.a((Closeable) context);
            k.a((Closeable) url2);
            if (z != 0) {
                z.disconnect();
            }
            throw th;
        }
    }

    public static String appendParaToUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        sb.append(str2);
        sb.append("=");
        sb.append(str3);
        return sb.toString();
    }

    public static HttpURLConnection getHttpURLConnectionWithProxy(Context context, String str) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        URL url = new URL(str);
        if (context != null) {
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"))) {
                    return (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80)));
                }
            } catch (Throwable unused) {
            }
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static String getUrlWithParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        String joinParas = joinParas(map);
        if (!TextUtils.isEmpty(joinParas)) {
            sb.append("?");
            sb.append(joinParas);
        }
        return sb.toString();
    }

    public static String getUrlWithValueEncodeParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        String joinParasWithEncodedValue = joinParasWithEncodedValue(map);
        if (!TextUtils.isEmpty(joinParasWithEncodedValue)) {
            sb.append("?");
            sb.append(joinParasWithEncodedValue);
        }
        return sb.toString();
    }

    public static HttpResponse httpGet(Context context, HttpRequest httpRequest) {
        return a(context, httpRequest, false);
    }

    public static HttpResponse httpGet(Context context, String str) {
        return httpGet(context, new HttpRequest(str));
    }

    public static void httpGet(Context context, HttpRequest httpRequest, HttpListener httpListener) {
        new a(context, httpListener).execute(httpRequest);
    }

    public static void httpGet(Context context, String str, HttpListener httpListener) {
        new b(httpListener, context).execute(str);
    }

    public static String httpGetString(Context context, HttpRequest httpRequest) {
        HttpResponse httpGet = httpGet(context, httpRequest);
        if (httpGet == null) {
            return null;
        }
        return httpGet.getResponseBody();
    }

    public static String httpGetString(Context context, String str) {
        HttpResponse httpGet = httpGet(context, new HttpRequest(str));
        if (httpGet == null) {
            return null;
        }
        return httpGet.getResponseBody();
    }

    public static HttpResponse httpPost(Context context, HttpRequest httpRequest) {
        return a(context, httpRequest, true);
    }

    public static HttpResponse httpPost(Context context, String str) {
        return httpPost(context, new HttpRequest(str));
    }

    public static String httpPostString(Context context, String str) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str));
        if (httpPost == null) {
            return null;
        }
        return httpPost.getResponseBody();
    }

    public static String httpPostString(Context context, String str, Map<String, String> map) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str, map));
        if (httpPost == null) {
            return null;
        }
        return httpPost.getResponseBody();
    }

    public static String joinParas(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            sb.append("=");
            sb.append(next.getValue());
            if (it.hasNext()) {
                sb.append("&");
            }
        }
        return sb.toString();
    }

    public static String joinParasWithEncodedValue(Map<String, String> map) {
        StringBuilder sb = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Map.Entry<String, String> next = it.next();
                    sb.append(next.getKey());
                    sb.append("=");
                    sb.append(URLEncoder.encode(next.getValue(), "UTF-8"));
                    if (it.hasNext()) {
                        sb.append("&");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static long parseGmtTime(String str) {
        try {
            return c.a("EEE, d MMM yyyy HH:mm:ss z").parse(str).getTime();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static byte[] readInputStream(InputStream inputStream) {
        return k.a(inputStream);
    }

    public static void setURLConnection(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map == null || map.size() == 0 || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
