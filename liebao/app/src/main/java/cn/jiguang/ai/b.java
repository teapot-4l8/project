package cn.jiguang.ai;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import cn.jiguang.f.i;
import cn.jiguang.net.DefaultHostVerifier;
import cn.jiguang.net.HttpUtils;
import cn.jiguang.net.SSLTrustManager;
import cn.jiguang.o.f;
import cn.jiguang.o.h;
import com.tencent.bugly.BuglyStrategy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f3709a = "";

    private static String a(byte[] bArr) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                int i = b2 & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JWakeConfigHelper", "get md5 throwable:" + th.getMessage());
            return "";
        }
    }

    private static List<String> a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.get(i).toString());
            }
            return arrayList;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x02b5, code lost:
        if (r5 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02ea, code lost:
        if (r5 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x031f, code lost:
        if (r5 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0354, code lost:
        if (r5 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0356, code lost:
        r5.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0359, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x029c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0306 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x033b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject a(Context context) {
        Throwable th;
        JSONException jSONException;
        IOException iOException;
        UnsupportedEncodingException unsupportedEncodingException;
        InputStream inputStream;
        InputStream inputStream2;
        String str;
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    if (!cn.jiguang.d.b.a(context)) {
                        cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig failed because is not validRegistered");
                        return null;
                    }
                    String a2 = cn.jiguang.am.a.a(context);
                    if (TextUtils.isEmpty(a2)) {
                        cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig failed because can't get appKey");
                        return null;
                    }
                    long d2 = cn.jiguang.d.a.d(context);
                    if (d2 == 0) {
                        cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig failed because can't get uid");
                        return null;
                    }
                    String f = cn.jiguang.d.a.f(context);
                    if (TextUtils.isEmpty(f)) {
                        cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig failed because need register first");
                        return null;
                    }
                    f.c(context, "JWakeConfigHelper");
                    String str2 = "https://bjuser.jpush.cn/v1/appawake/status";
                    if (h.f4177a && !TextUtils.isEmpty(f3709a)) {
                        cn.jiguang.ad.a.a("JWakeConfigHelper", "use test url:" + f3709a);
                        str2 = f3709a;
                    }
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    String str3 = Build.MANUFACTURER;
                    String str4 = Build.MODEL;
                    hashMap2.put("appkey", a2);
                    hashMap2.put("uid", String.valueOf(d2));
                    if (!TextUtils.isEmpty(str3)) {
                        hashMap2.put("manufacturer", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        hashMap2.put("model", str4);
                    }
                    String urlWithValueEncodeParas = HttpUtils.getUrlWithValueEncodeParas(str2, hashMap2);
                    cn.jiguang.ad.a.a("JWakeConfigHelper", "url:" + urlWithValueEncodeParas);
                    hashMap.put("Content-Type", "text/plain");
                    hashMap.put("Accept", "application/json");
                    hashMap.put("X-Http-Platform", "android");
                    hashMap.put("X-Http-Appkey", a2);
                    String a3 = a("".getBytes("UTF-8"));
                    String e2 = i.e(d2 + i.e(f) + a3);
                    if (TextUtils.isEmpty(e2)) {
                        return null;
                    }
                    String encodeToString = Base64.encodeToString((d2 + ":" + e2).getBytes(), 10);
                    if (TextUtils.isEmpty(encodeToString)) {
                        return null;
                    }
                    hashMap.put("Authorization", "Basic " + encodeToString);
                    hashMap.put("Charset", "UTF-8");
                    HttpURLConnection httpURLConnectionWithProxy = HttpUtils.getHttpURLConnectionWithProxy(context, urlWithValueEncodeParas);
                    try {
                        httpURLConnectionWithProxy.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                        httpURLConnectionWithProxy.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                        for (Map.Entry entry : hashMap.entrySet()) {
                            httpURLConnectionWithProxy.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        if (httpURLConnectionWithProxy instanceof HttpsURLConnection) {
                            try {
                                SSLContext sSLContext = SSLContext.getInstance("TLS");
                                sSLContext.init(null, new TrustManager[]{new SSLTrustManager("-----BEGIN CERTIFICATE-----\nMIIETzCCAzegAwIBAgIDAjpvMA0GCSqGSIb3DQEBCwUAMEIxCzAJBgNVBAYTAlVT\nMRYwFAYDVQQKEw1HZW9UcnVzdCBJbmMuMRswGQYDVQQDExJHZW9UcnVzdCBHbG9i\nYWwgQ0EwHhcNMTMxMTA1MjEzNjUwWhcNMjIwNTIwMjEzNjUwWjBEMQswCQYDVQQG\nEwJVUzEWMBQGA1UEChMNR2VvVHJ1c3QgSW5jLjEdMBsGA1UEAxMUR2VvVHJ1c3Qg\nU1NMIENBIC0gRzMwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDjvn4K\nhqPPa209K6GXrUkkTdd3uTR5CKWeop7eRxKSPX7qGYax6E89X/fQp3eaWx8KA7UZ\nU9ulIZRpY51qTJEMEEe+EfpshiW3qwRoQjgJZfAU2hme+msLq2LvjafvY3AjqK+B\n89FuiGdT7BKkKXWKp/JXPaKDmJfyCn3U50NuMHhiIllZuHEnRaoPZsZVP/oyFysx\nj0ag+mkUfJ2fWuLrM04QprPtd2PYw5703d95mnrU7t7dmszDt6ldzBE6B7tvl6QB\nI0eVH6N3+liSxsfQvc+TGEK3fveeZerVO8rtrMVwof7UEJrwEgRErBpbeFBFV0xv\nvYDLgVwts7x2oR5lAgMBAAGjggFKMIIBRjAfBgNVHSMEGDAWgBTAephojYn7qwVk\nDBF9qn1luMrMTjAdBgNVHQ4EFgQU0m/3lvSFP3I8MH0j2oV4m6N8WnwwEgYDVR0T\nAQH/BAgwBgEB/wIBADAOBgNVHQ8BAf8EBAMCAQYwNgYDVR0fBC8wLTAroCmgJ4Yl\naHR0cDovL2cxLnN5bWNiLmNvbS9jcmxzL2d0Z2xvYmFsLmNybDAvBggrBgEFBQcB\nAQQjMCEwHwYIKwYBBQUHMAGGE2h0dHA6Ly9nMi5zeW1jYi5jb20wTAYDVR0gBEUw\nQzBBBgpghkgBhvhFAQc2MDMwMQYIKwYBBQUHAgEWJWh0dHA6Ly93d3cuZ2VvdHJ1\nc3QuY29tL3Jlc291cmNlcy9jcHMwKQYDVR0RBCIwIKQeMBwxGjAYBgNVBAMTEVN5\nbWFudGVjUEtJLTEtNTM5MA0GCSqGSIb3DQEBCwUAA4IBAQCg1Pcs+3QLf2TxzUNq\nn2JTHAJ8mJCi7k9o1CAacxI+d7NQ63K87oi+fxfqd4+DYZVPhKHLMk9sIb7SaZZ9\nY73cK6gf0BOEcP72NZWJ+aZ3sEbIu7cT9clgadZM/tKO79NgwYCA4ef7i28heUrg\n3Kkbwbf7w0lZXLV3B0TUl/xJAIlvBk4BcBmsLxHA4uYPL4ZLjXvDuacu9PGsFj45\nSVGeF0tPEDpbpaiSb/361gsDTUdWVxnzy2v189bPsPX1oxHSIFMTNDcFLENaY9+N\nQNaFHlHpURceA1bJ8TCt55sRornQMYGbaLHZ6PPmlH7HrhMvh+3QJbBo+d4IWvMp\nzNSS\n-----END CERTIFICATE-----")}, new SecureRandom());
                                ((HttpsURLConnection) httpURLConnectionWithProxy).setSSLSocketFactory(sSLContext.getSocketFactory());
                                ((HttpsURLConnection) httpURLConnectionWithProxy).setHostnameVerifier(new DefaultHostVerifier(httpURLConnectionWithProxy.getURL().getHost()));
                            } catch (Throwable th2) {
                                cn.jiguang.ad.a.d("JWakeConfigHelper", "set ssl config error:" + th2.getMessage());
                            }
                        }
                        if (httpURLConnectionWithProxy.getResponseCode() == 200) {
                            inputStream2 = httpURLConnectionWithProxy.getInputStream();
                            try {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                                str = new String(byteArrayOutputStream.toByteArray());
                            } catch (UnsupportedEncodingException e3) {
                                httpURLConnection = httpURLConnectionWithProxy;
                                inputStream = inputStream2;
                                unsupportedEncodingException = e3;
                                cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + unsupportedEncodingException.getMessage());
                                if (inputStream != null) {
                                }
                            } catch (IOException e4) {
                                httpURLConnection = httpURLConnectionWithProxy;
                                inputStream = inputStream2;
                                iOException = e4;
                                cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + iOException.getMessage());
                                if (inputStream != null) {
                                }
                            } catch (JSONException e5) {
                                httpURLConnection = httpURLConnectionWithProxy;
                                inputStream = inputStream2;
                                jSONException = e5;
                                cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + jSONException.getMessage());
                                if (inputStream != null) {
                                }
                            } catch (Throwable th3) {
                                httpURLConnection = httpURLConnectionWithProxy;
                                inputStream = inputStream2;
                                th = th3;
                                cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + th.getMessage());
                                if (inputStream != null) {
                                }
                            }
                        } else {
                            inputStream2 = null;
                            str = null;
                        }
                        if (TextUtils.isEmpty(str)) {
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e6) {
                                    cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + e6.getMessage());
                                }
                            }
                            if (httpURLConnectionWithProxy != null) {
                                httpURLConnectionWithProxy.disconnect();
                                return null;
                            }
                            return null;
                        }
                        cn.jiguang.ad.a.a("JWakeConfigHelper", "request wakeConfig success,response body:" + str);
                        JSONObject jSONObject = new JSONObject(str);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e7) {
                                cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + e7.getMessage());
                            }
                        }
                        if (httpURLConnectionWithProxy != null) {
                            httpURLConnectionWithProxy.disconnect();
                        }
                        return jSONObject;
                    } catch (UnsupportedEncodingException e8) {
                        unsupportedEncodingException = e8;
                        httpURLConnection = httpURLConnectionWithProxy;
                        inputStream = null;
                        cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + unsupportedEncodingException.getMessage());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e9) {
                                cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + e9.getMessage());
                            }
                        }
                    } catch (IOException e10) {
                        iOException = e10;
                        httpURLConnection = httpURLConnectionWithProxy;
                        inputStream = null;
                        cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + iOException.getMessage());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e11) {
                                cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + e11.getMessage());
                            }
                        }
                    } catch (JSONException e12) {
                        jSONException = e12;
                        httpURLConnection = httpURLConnectionWithProxy;
                        inputStream = null;
                        cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + jSONException.getMessage());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e13) {
                                cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + e13.getMessage());
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        httpURLConnection = httpURLConnectionWithProxy;
                        inputStream = null;
                        cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + th.getMessage());
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e14) {
                                cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + e14.getMessage());
                            }
                        }
                    }
                } catch (UnsupportedEncodingException e15) {
                    unsupportedEncodingException = e15;
                    inputStream = null;
                } catch (IOException e16) {
                    iOException = e16;
                    inputStream = null;
                } catch (JSONException e17) {
                    jSONException = e17;
                    inputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
            } catch (UnsupportedEncodingException e18) {
                unsupportedEncodingException = e18;
                httpURLConnection = null;
            } catch (IOException e19) {
                iOException = e19;
                httpURLConnection = null;
            } catch (JSONException e20) {
                jSONException = e20;
                httpURLConnection = null;
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = null;
            }
        } catch (Throwable th7) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e21) {
                    cn.jiguang.ad.a.d("JWakeConfigHelper", "request wakeConfig exception:" + e21.getMessage());
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th7;
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        if (jSONObject != null) {
            cn.jiguang.ad.a.a("JWakeConfigHelper", "write wakeConfigJson:" + jSONObject);
            cn.jiguang.v.d.a(context, "bwc.catch", jSONObject);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cn.jiguang.ah.a b(Context context, JSONObject jSONObject) {
        int optInt;
        int optInt2;
        String optString;
        String str = "disable";
        cn.jiguang.ah.a aVar = new cn.jiguang.ah.a();
        if (jSONObject == null) {
            return aVar;
        }
        try {
            optInt = jSONObject.optInt("app_wakeup_stat", -1);
        } catch (JSONException e2) {
            cn.jiguang.ad.a.d("JWakeConfigHelper", "parseWakeConfig exception:" + e2.toString());
        }
        if (optInt < 0) {
            return aVar;
        }
        int optInt3 = jSONObject.optInt("app_report_app_list_threshold", -1);
        if (optInt3 > 0) {
            f.b(context, "JAppAll", optInt3 * 1000);
        }
        int optInt4 = jSONObject.optInt("app_wakeup_threshold", -1) * 1000;
        if (optInt4 > 0) {
            aVar.f3700e = optInt4;
        }
        int optInt5 = jSONObject.optInt("app_get_threshold", -1) * 1000;
        if (optInt5 > 0) {
            aVar.f = optInt5;
        }
        int optInt6 = jSONObject.optInt("app_report_threshold", -1) * 1000;
        if (optInt6 > 0) {
            aVar.g = optInt6;
        }
        if (optInt != 0 && optInt != 1) {
            if (optInt == 2) {
                aVar.f3698c = false;
            } else {
                String optString2 = jSONObject.optString("errmsg");
                cn.jiguang.ad.a.d("JWakeConfigHelper", "parseWakeConfigJson error: " + optString2);
            }
            optInt2 = jSONObject.optInt("app_wakeup_disable", -1);
            if (optInt2 != 0) {
                if (optInt2 == 1) {
                    aVar.f3699d = false;
                } else if (optInt2 == 2) {
                }
                aVar.f3696a = !"disable".equals(jSONObject.optString("app_wakeup_config", "enable"));
                aVar.f3697b = "disable".equals(jSONObject.optString("app_wakeuped_config", "enable")) ? false : true;
                optString = jSONObject.optString("app_package_config", "disable");
                if (!optString.isEmpty()) {
                    str = optString;
                }
                aVar.h = str;
                aVar.i = a(jSONObject, "app_package_list");
                aVar.j = a(jSONObject, "app_blacklist");
                return aVar;
            }
            aVar.f3699d = true;
            aVar.f3696a = !"disable".equals(jSONObject.optString("app_wakeup_config", "enable"));
            aVar.f3697b = "disable".equals(jSONObject.optString("app_wakeuped_config", "enable")) ? false : true;
            optString = jSONObject.optString("app_package_config", "disable");
            if (!optString.isEmpty()) {
            }
            aVar.h = str;
            aVar.i = a(jSONObject, "app_package_list");
            aVar.j = a(jSONObject, "app_blacklist");
            return aVar;
        }
        aVar.f3698c = true;
        optInt2 = jSONObject.optInt("app_wakeup_disable", -1);
        if (optInt2 != 0) {
        }
        aVar.f3699d = true;
        aVar.f3696a = !"disable".equals(jSONObject.optString("app_wakeup_config", "enable"));
        aVar.f3697b = "disable".equals(jSONObject.optString("app_wakeuped_config", "enable")) ? false : true;
        optString = jSONObject.optString("app_package_config", "disable");
        if (!optString.isEmpty()) {
        }
        aVar.h = str;
        aVar.i = a(jSONObject, "app_package_list");
        aVar.j = a(jSONObject, "app_blacklist");
        return aVar;
    }
}
