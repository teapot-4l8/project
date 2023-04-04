package a.a.a.e;

import a.a.a.b.f;
import android.text.TextUtils;
import androidx.recyclerview.widget.l;
import com.google.android.gms.common.internal.ImagesContract;
import com.just.agentweb.AgentWebPermissions;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Http.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f362a;

    /* renamed from: b  reason: collision with root package name */
    private final a.a.a.c.d.a f363b;

    /* renamed from: c  reason: collision with root package name */
    private final int f364c;

    /* renamed from: d  reason: collision with root package name */
    private List<Map<Object, String>> f365d;

    public e(String str) {
        this(str, 5000);
    }

    public e(String str, int i) {
        this.f362a = str;
        this.f364c = i;
        this.f363b = new a.a.a.c.d.a();
        this.f365d = new ArrayList();
    }

    public a.a.a.c.d.a a() {
        this.f363b.a(this.f362a);
        try {
            a(new URL(this.f362a), (URL) null);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f363b.a(this.f365d);
        return this.f363b;
    }

    private boolean a(int i) {
        return i / 100 == 2;
    }

    private boolean b(int i) {
        return i / 100 == 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v9 */
    private void a(URL url, URL url2) {
        HttpURLConnection httpURLConnection;
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new a.a.a.a.a("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                try {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection2 = 1;
                    httpURLConnection2 = 1;
                } catch (Exception e2) {
                    e = e2;
                }
                try {
                    try {
                        httpURLConnection.setDoInput(true);
                        httpURLConnection.setConnectTimeout(this.f364c);
                        httpURLConnection.setReadTimeout(this.f364c);
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        HashMap hashMap = new HashMap();
                        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                            if (!TextUtils.isEmpty(entry.getKey()) && "Server".equals(entry.getKey())) {
                                this.f363b.b(entry.getValue().toString().substring(1, entry.getValue().toString().length() - 1));
                            }
                            hashMap.put(entry.getKey() + "", entry.getValue().toString().substring(1, entry.getValue().toString().length() - 1));
                        }
                        this.f365d.add(hashMap);
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        this.f363b.d(responseCode);
                        if (a(responseCode)) {
                            this.f363b.e(l.a.DEFAULT_DRAG_ANIMATION_DURATION);
                            a(httpURLConnection, true);
                        } else if (b(responseCode)) {
                            this.f363b.a(true);
                            String headerField = httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                            if (TextUtils.isEmpty(headerField)) {
                                throw new a.a.a.a.a("Received empty or null redirect url");
                            }
                            URL url3 = new URL(url, headerField);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception unused2) {
                                }
                            }
                            a(url3, url);
                            httpURLConnection2 = headerField;
                        } else {
                            a(httpURLConnection, false);
                            this.f363b.e(l.a.DEFAULT_DRAG_ANIMATION_DURATION);
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    httpURLConnection2 = httpURLConnection;
                    e.printStackTrace();
                    this.f363b.e(-1);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused4) {
        }
    }

    private void a(HttpURLConnection httpURLConnection, boolean z) {
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[1024];
        InputStream inputStream = z ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                sb.append(new String(bArr, 0, read));
            } else {
                try {
                    break;
                } catch (Exception unused) {
                }
            }
        }
        inputStream.close();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("http size ");
        double length = sb.toString().getBytes().length;
        Double.isNaN(length);
        sb2.append(length / 1024.0d);
        sb2.append("KB");
        f.a(sb2.toString());
        a.a.a.c.d.a aVar = this.f363b;
        double length2 = sb.toString().getBytes().length;
        Double.isNaN(length2);
        aVar.a(length2 / 1024.0d);
    }

    public void b() {
        a.a.a.b.f c2 = a.a.a.a.a().c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ImagesContract.URL, this.f363b.c());
            jSONObject.put("ver", 1);
            jSONObject.put("action", "get_server");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c2.a(new a.a.a.b.b("https://huatuo.qq.com/Report/GetUrlResponseServer", a.a.a.b.h.POST, new a.a.a.b.g(jSONObject)));
        c2.a(new f.a<String>() { // from class: a.a.a.e.e.1
            @Override // a.a.a.b.f.a
            public void a(String str) {
                f.a("ResponseServer info success:" + str);
                try {
                    e.this.f363b.c(new JSONObject(str).getString("server"));
                } catch (JSONException unused) {
                }
            }

            @Override // a.a.a.b.f.a
            public void a(Exception exc) {
                f.b("ResponseServer info fail:" + exc.toString());
            }
        });
    }
}
