package cn.jiguang.u;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import cn.jiguang.f.i;
import cn.jiguang.f.k;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.just.agentweb.AgentWebPermissions;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.pro.ak;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f4226a = new Object();
    private static CookieManager h;

    /* renamed from: b  reason: collision with root package name */
    private String f4227b;

    /* renamed from: c  reason: collision with root package name */
    private String f4228c;

    /* renamed from: d  reason: collision with root package name */
    private String f4229d;

    /* renamed from: e  reason: collision with root package name */
    private Context f4230e;
    private int f = 0;
    private String g;

    public d(Context context) {
        String d2 = cn.jiguang.f.a.d(context, this.f4227b);
        String b2 = c.b(context, this.f4228c);
        String e2 = cn.jiguang.f.a.e(context, this.f4229d);
        CookieManager cookieManager = new CookieManager();
        h = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(h);
        this.f4230e = context;
        this.f4227b = d2;
        this.f4228c = b2;
        this.f4229d = e2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:168:0x02ad, code lost:
        if (r14 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x02d4, code lost:
        if (r14 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x02fb, code lost:
        if (r14 != null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x02fd, code lost:
        r14.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0300, code lost:
        r10 = r16;
        r11 = r18;
        r12 = 404;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01dd, code lost:
        r14 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private cn.jiguang.t.a a(Context context, String str, int i, long j, boolean z, File file, String str2) {
        Throwable th;
        String str3;
        HttpURLConnection httpURLConnection;
        int responseCode;
        Map<String, List<String>> headerFields;
        String str4;
        String str5;
        File file2 = file;
        long j2 = (j < 200 || j > JConstants.MIN) ? 2000L : j;
        String uuid = UUID.randomUUID().toString();
        String str6 = "multipart/form-data";
        if (h == null) {
            h = new CookieManager();
        }
        boolean z2 = false;
        HttpURLConnection httpURLConnection2 = null;
        InputStream inputStream = null;
        Map<String, List<String>> map = null;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            try {
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    } catch (AssertionError e2) {
                        e = e2;
                        str3 = str6;
                        cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                        if (inputStream != null) {
                        }
                    } catch (SSLPeerUnverifiedException e3) {
                        e = e3;
                        str3 = str6;
                        cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                        if (inputStream != null) {
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str3 = str6;
                        cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                        if (inputStream != null) {
                        }
                    }
                } catch (AssertionError e5) {
                    e = e5;
                } catch (SSLPeerUnverifiedException e6) {
                    e = e6;
                } catch (Exception e7) {
                    e = e7;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    httpURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                    httpURLConnection.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(z2);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 6 Build/LYZ28E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.23 Mobile Safari/537.36");
                    if (h.getCookieStore().getCookies().size() > 0) {
                        try {
                            httpURLConnection.setRequestProperty("Cookie", TextUtils.join(";", h.getCookieStore().getCookies()));
                        } catch (AssertionError e8) {
                            e = e8;
                            str3 = str6;
                            httpURLConnection2 = httpURLConnection;
                            cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                            if (inputStream != null) {
                            }
                        } catch (SSLPeerUnverifiedException e9) {
                            e = e9;
                            str3 = str6;
                            httpURLConnection2 = httpURLConnection;
                            cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                            if (inputStream != null) {
                            }
                        } catch (Exception e10) {
                            e = e10;
                            str3 = str6;
                            httpURLConnection2 = httpURLConnection;
                            cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                            if (inputStream != null) {
                            }
                        }
                    }
                    httpURLConnection.setInstanceFollowRedirects(z);
                    if (file2 != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str6);
                        str3 = str6;
                        try {
                            sb.append(";boundary=");
                            sb.append(uuid);
                            httpURLConnection.setRequestProperty("Content-Type", sb.toString());
                            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("--");
                            stringBuffer.append(uuid);
                            stringBuffer.append("\r\n");
                            stringBuffer.append("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + file.getName() + "\"\r\n");
                            StringBuilder sb2 = new StringBuilder("Content-Type: application/octet-stream; charset=UTF-8");
                            sb2.append("\r\n");
                            stringBuffer.append(sb2.toString());
                            stringBuffer.append("\r\n");
                            dataOutputStream.write(stringBuffer.toString().getBytes());
                            FileInputStream fileInputStream = new FileInputStream(file2);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                try {
                                    dataOutputStream.write(bArr, 0, read);
                                } catch (AssertionError e11) {
                                    e = e11;
                                    httpURLConnection2 = httpURLConnection;
                                    cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                                    if (inputStream != null) {
                                    }
                                } catch (SSLPeerUnverifiedException e12) {
                                    e = e12;
                                    httpURLConnection2 = httpURLConnection;
                                    cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                                    if (inputStream != null) {
                                    }
                                } catch (Exception e13) {
                                    e = e13;
                                    httpURLConnection2 = httpURLConnection;
                                    cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                                    if (inputStream != null) {
                                    }
                                }
                            }
                            fileInputStream.close();
                            dataOutputStream.write("\r\n".getBytes());
                            dataOutputStream.write(("--" + uuid + "--\r\n").getBytes());
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        } catch (AssertionError e14) {
                            e = e14;
                            httpURLConnection2 = httpURLConnection;
                            cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                        } catch (SSLPeerUnverifiedException e16) {
                            e = e16;
                            httpURLConnection2 = httpURLConnection;
                            cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                        } catch (Exception e18) {
                            e = e18;
                            httpURLConnection2 = httpURLConnection;
                            cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                }
                            }
                        }
                    } else {
                        str3 = str6;
                    }
                    responseCode = httpURLConnection.getResponseCode();
                    try {
                        a(httpURLConnection.getHeaderFields());
                    } catch (AssertionError e20) {
                        e = e20;
                        i3 = responseCode;
                        httpURLConnection2 = httpURLConnection;
                        cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                        if (inputStream != null) {
                        }
                    } catch (SSLPeerUnverifiedException e21) {
                        e = e21;
                        i3 = responseCode;
                        httpURLConnection2 = httpURLConnection;
                        cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                        if (inputStream != null) {
                        }
                    } catch (Exception e22) {
                        e = e22;
                        i3 = responseCode;
                        httpURLConnection2 = httpURLConnection;
                        cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                        if (inputStream != null) {
                        }
                    }
                } catch (AssertionError e23) {
                    e = e23;
                    str3 = str6;
                } catch (SSLPeerUnverifiedException e24) {
                    e = e24;
                    str3 = str6;
                } catch (Exception e25) {
                    e = e25;
                    str3 = str6;
                }
                if (responseCode == 302) {
                    String headerField = httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                    if (i >= 0) {
                        cn.jiguang.t.a a2 = a(context, headerField, i - 1, 0L, z, null, null);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return a2;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return null;
                    }
                    return null;
                } else if (responseCode == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    headerFields = httpURLConnection.getHeaderFields();
                    try {
                        byte[] a3 = k.a(inputStream);
                        if (a3 != null && a3.length > 0) {
                            str4 = new String(a3, "UTF-8");
                            break;
                        }
                        break;
                    } catch (AssertionError e28) {
                        e = e28;
                        i3 = responseCode;
                        httpURLConnection2 = httpURLConnection;
                        map = headerFields;
                        cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                        if (inputStream != null) {
                        }
                    } catch (SSLPeerUnverifiedException e29) {
                        e = e29;
                        i3 = responseCode;
                        httpURLConnection2 = httpURLConnection;
                        map = headerFields;
                        cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                        if (inputStream != null) {
                        }
                    } catch (Exception e30) {
                        e = e30;
                        i3 = responseCode;
                        httpURLConnection2 = httpURLConnection;
                        map = headerFields;
                        cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e.getMessage());
                        if (inputStream != null) {
                        }
                    }
                } else {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e31) {
                            e31.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    httpURLConnection2 = httpURLConnection;
                    int i4 = 404;
                    int i5 = responseCode;
                    Map<String, List<String>> map2 = map;
                    if (i5 == i4) {
                        return null;
                    }
                    if (i5 != 200 && !cn.jiguang.f.a.d(context)) {
                        return null;
                    }
                    int i6 = i2;
                    if (i6 >= 3) {
                        return new cn.jiguang.t.a(-1, map2, "<<failed_with_retries>>");
                    }
                    i2 = i6 + 1;
                    try {
                        Thread.sleep(j2);
                    } catch (InterruptedException e32) {
                        cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e32.getMessage());
                    }
                    file2 = file;
                    map = map2;
                    i3 = i5;
                    str6 = str3;
                    z2 = false;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection2 = httpURLConnection;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e33) {
                        e33.printStackTrace();
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
            } catch (IOException e34) {
                e34.printStackTrace();
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (responseCode < 200 || responseCode >= 300) {
            if (responseCode >= 400 && responseCode < 500) {
                if (400 == responseCode) {
                    str5 = "server fail";
                } else if (401 != responseCode && 404 != responseCode && 406 != responseCode && 408 != responseCode && 409 != responseCode) {
                    str5 = null;
                }
            }
            str5 = "<<error>>";
        } else {
            str5 = str4;
        }
        return new cn.jiguang.t.a(responseCode, headerFields, str5);
    }

    private String a(int i) {
        String a2 = cn.jiguang.r.a.a(this.f4230e, i);
        this.g = a2;
        return a2;
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        String d2 = cn.jiguang.f.a.d(context, "");
        String b2 = c.b(context, "");
        String e2 = cn.jiguang.f.a.e(context, "");
        return i.d(d2 + b2 + e2);
    }

    private String a(String str) {
        String e2 = e(str);
        if (!TextUtils.isEmpty(e2) && Patterns.PHONE.matcher(e2).matches()) {
            return e2;
        }
        return null;
    }

    private String a(String str, cn.jiguang.t.a aVar) {
        if (a(this.f4230e, aVar)) {
            return c(str);
        }
        return null;
    }

    private String a(TreeMap<String, String> treeMap) {
        if (treeMap.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append((Object) entry.getValue());
        }
        String c2 = cn.jiguang.r.a.c(this.f4230e);
        return i.d(sb.toString() + c2).toUpperCase();
    }

    private static void a(Map<String, List<String>> map) {
        List<String> list = map.get("Set-Cookie");
        if (list != null) {
            for (String str : list) {
                h.getCookieStore().add(null, HttpCookie.parse(str).get(0));
            }
        }
    }

    private static boolean a(Context context, cn.jiguang.t.a aVar) {
        File a2;
        if (context == null || aVar == null || (a2 = cn.jiguang.f.e.a(context, "resp.raw")) == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder("");
        if (aVar.f4219c != null && aVar.f4219c.size() > 0) {
            for (Map.Entry<String, List<String>> entry : aVar.f4219c.entrySet()) {
                if (entry.getKey() != null) {
                    sb.append(entry.getKey());
                    sb.append(": ");
                }
                Iterator<String> it = entry.getValue().iterator();
                if (it.hasNext()) {
                    while (true) {
                        sb.append(it.next());
                        if (it.hasNext()) {
                            sb.append(", ");
                        }
                    }
                }
                sb.append("\n");
            }
        }
        sb.append("\r\n\r\n");
        if (!TextUtils.isEmpty(aVar.f4218b)) {
            sb.append(aVar.f4218b);
        }
        if (cn.jiguang.f.e.a(a2, sb.toString())) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2);
            File a3 = cn.jiguang.f.e.a(context, "resp.zip");
            if (a3 == null) {
                return false;
            }
            if (a3 != null) {
                try {
                    if (a3.exists()) {
                        a3.delete();
                    }
                } catch (Throwable th) {
                    cn.jiguang.ad.a.d("JCommonFileHelper", "delete throwable:" + th.getMessage());
                }
            }
            try {
                cn.jiguang.v.d.a(arrayList, a3);
                return true;
            } catch (IOException e2) {
                cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e2.getMessage());
                return false;
            }
        }
        return false;
    }

    private boolean a(String str, String str2, String str3) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        if (!TextUtils.isEmpty(str)) {
            treeMap.put("imei", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            treeMap.put(ak.aa, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            treeMap.put("imsi", str3);
        }
        treeMap.put("version", cn.jiguang.r.a.a(this.f4230e));
        treeMap.put("app_id", cn.jiguang.r.a.b(this.f4230e));
        treeMap.put(ak.W, cn.jiguang.v.g.a("yyyyMMddHHmmss").format(new Date()));
        treeMap.put("sign", a(treeMap));
        String str4 = "";
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            try {
                str4 = str4 + "&" + ((Object) entry.getKey()) + "=" + URLEncoder.encode(entry.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        try {
            cn.jiguang.t.a a2 = a(this.f4230e, this.g + "statistic/query?" + str4, 10, 30000L, false, null, null);
            if (a2.f4217a != 200) {
                return false;
            }
            JSONObject b2 = b(a2.f4218b);
            String str5 = null;
            if (b2 != null) {
                if (b2.optInt(JThirdPlatFormInterface.KEY_CODE, -1) != 200) {
                    return false;
                }
                str5 = a(b2.optString("num"));
            } else if (a2.f4219c != null || !TextUtils.isEmpty(a2.f4218b)) {
                synchronized (f4226a) {
                    this.f = 0;
                    try {
                        str5 = a(str4, a2);
                    } catch (Throwable unused2) {
                    }
                    this.f4230e.deleteFile("resp.raw");
                    this.f4230e.deleteFile("resp.zip");
                }
            }
            if (TextUtils.isEmpty(str5)) {
                return false;
            }
            d(str5);
            return true;
        } catch (Throwable unused3) {
            return false;
        }
    }

    private static JSONObject b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONObject(str);
        } catch (Exception e2) {
            cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e2.getMessage());
            return null;
        }
    }

    private String c(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Context context = this.f4230e;
            cn.jiguang.t.a a2 = a(context, this.g + "statistic/query?" + str, 10, 30000L, false, cn.jiguang.f.e.a(this.f4230e, "resp.zip"), "resp_data");
            if (a2.f4217a != 200) {
                return null;
            }
            JSONObject b2 = b(a2.f4218b);
            if (b2 != null) {
                if (b2.optInt(JThirdPlatFormInterface.KEY_CODE, -1) != 200) {
                    return null;
                }
                return a(b2.optString("num"));
            } else if (!(a2.f4219c == null && TextUtils.isEmpty(a2.f4218b)) && (i = this.f) <= 4) {
                this.f = i + 1;
                try {
                    return a(str, a2);
                } catch (Throwable th) {
                    cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber throwable:" + th.getMessage());
                    return null;
                }
            } else {
                return null;
            }
        } catch (Throwable th2) {
            cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber throwable:" + th2.getMessage());
            return null;
        }
    }

    private void d(String str) {
        StringBuilder sb;
        String message;
        String a2;
        cn.jiguang.r.a.a(this.f4230e, str);
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("num", str);
                if (!TextUtils.isEmpty(this.f4227b)) {
                    jSONObject.put("imei", this.f4227b);
                }
                if (!TextUtils.isEmpty(this.f4229d)) {
                    jSONObject.put("imsi", this.f4229d);
                }
                if (!TextUtils.isEmpty(this.f4228c)) {
                    jSONObject.put(ak.aa, this.f4228c);
                }
                try {
                    a2 = cn.jiguang.bb.d.a(jSONObject.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                cn.jiguang.d.a.a(this.f4230e, jSONObject2, "nb");
                jSONObject2.put("content", a2);
                cn.jiguang.ad.a.a("JDevicePNWorker", "collect success:" + jSONObject2);
                cn.jiguang.o.i.a(this.f4230e, (Object) jSONObject2);
                cn.jiguang.r.a.a(this.f4230e, false);
            } catch (Throwable th) {
                sb = new StringBuilder("report phoneNumber throwable:");
                message = th.getMessage();
                sb.append(message);
                cn.jiguang.ad.a.d("JDevicePNWorker", sb.toString());
            }
        } catch (JSONException e3) {
            sb = new StringBuilder("report phoneNumber exception:");
            message = e3.getMessage();
            sb.append(message);
            cn.jiguang.ad.a.d("JDevicePNWorker", sb.toString());
        }
    }

    private String e(String str) {
        try {
            String substring = cn.jiguang.r.a.c(this.f4230e).substring(0, 16);
            return new String(cn.jiguang.bb.d.a(str, substring, substring));
        } catch (Exception e2) {
            cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e2.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x009d A[Catch: Exception -> 0x00db, TryCatch #0 {Exception -> 0x00db, blocks: (B:2:0x0000, B:4:0x0008, B:6:0x0010, B:9:0x0019, B:11:0x0025, B:14:0x002e, B:15:0x0033, B:17:0x0042, B:19:0x004a, B:21:0x0052, B:23:0x005a, B:26:0x0063, B:28:0x006b, B:30:0x0073, B:33:0x007c, B:35:0x0084, B:37:0x008c, B:44:0x009d, B:46:0x00a8, B:51:0x00b7, B:53:0x00c4, B:55:0x00cc), top: B:61:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        int i;
        try {
            if (TextUtils.isEmpty(this.f4227b) && TextUtils.isEmpty(this.f4228c) && TextUtils.isEmpty(this.f4229d)) {
                return;
            }
            String d2 = cn.jiguang.r.a.d(this.f4230e);
            if (!TextUtils.isEmpty(d2) && !cn.jiguang.r.a.e(this.f4230e)) {
                d(d2);
                return;
            }
            cn.jiguang.r.a.f(this.f4230e);
            String str = this.f4229d;
            int i2 = 0;
            if (!TextUtils.isEmpty(str)) {
                if (!str.startsWith("46000") && !str.startsWith("46002") && !str.startsWith("46007") && !str.startsWith("46008")) {
                    if (!str.startsWith("46001") && !str.startsWith("46006") && !str.startsWith("46009")) {
                        if (str.startsWith("46003") || str.startsWith("46005") || str.startsWith("46011")) {
                            i = 2;
                            if (i == -1) {
                                a(i);
                                if (TextUtils.isEmpty(this.g)) {
                                    return;
                                }
                                a(this.f4227b, this.f4228c, this.f4229d);
                                return;
                            }
                            String str2 = "";
                            while (i2 < 3) {
                                a(i2);
                                i2++;
                                if (!TextUtils.isEmpty(this.g) && !str2.equals(this.g)) {
                                    str2 = this.g;
                                    if (a(this.f4227b, this.f4228c, this.f4229d)) {
                                        return;
                                    }
                                }
                            }
                            return;
                        }
                    }
                    i = 1;
                    if (i == -1) {
                    }
                }
                i = 0;
                if (i == -1) {
                }
            }
            i = -1;
            if (i == -1) {
            }
        } catch (Exception e2) {
            cn.jiguang.ad.a.d("JDevicePNWorker", "report phoneNumber exception:" + e2.getMessage());
        }
    }
}
