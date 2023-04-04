package a.a.a.b;

import a.a.a.b.f;
import a.a.a.e.q;
import android.text.TextUtils;
import com.just.agentweb.AgentWebPermissions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpNormalUrlLoader.java */
/* loaded from: classes.dex */
public class c implements f<String> {
    private static final b g = new a();

    /* renamed from: a  reason: collision with root package name */
    private a.a.a.b.b f17a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f18b = 5000;

    /* renamed from: c  reason: collision with root package name */
    private b f19c = g;

    /* renamed from: d  reason: collision with root package name */
    private HttpURLConnection f20d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f21e;
    private volatile boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpNormalUrlLoader.java */
    /* loaded from: classes.dex */
    public interface b {
        HttpURLConnection a(URL url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    @Override // a.a.a.b.f
    public void a(f.a<? super String> aVar) {
        StringBuilder sb;
        String str = "Finished http url fetcher fetch in ";
        if (this.f17a == null || this.f18b < 1 || this.f19c == null) {
            a.a.a.e.f.b("Failed to load data");
            aVar.a((Exception) new IllegalArgumentException("Failed to load data"));
        }
        long a2 = a.a.a.e.h.a();
        try {
            try {
                aVar.a((f.a<? super String>) a(this.f17a.c(), 0, null, this.f17a.e()));
                sb = new StringBuilder();
            } catch (IOException e2) {
                a.a.a.e.f.b("Failed to load data for url" + e2.toString());
                aVar.a((Exception) e2);
                sb = new StringBuilder();
            }
            sb.append("Finished http url fetcher fetch in ");
            str = a.a.a.e.h.a(a2);
            sb.append((int) str);
            sb.append("ms");
            a.a.a.e.f.b(sb.toString());
        } catch (Throwable th) {
            a.a.a.e.f.b(str + a.a.a.e.h.a(a2) + "ms");
            throw th;
        }
    }

    private String a(URL url, int i, URL url2, Map<String, String> map) {
        if (i >= 1) {
            throw new a.a.a.a.a("Too many (> 1) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new a.a.a.a.a("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f20d = this.f19c.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f20d.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f20d.setConnectTimeout(this.f18b);
        this.f20d.setReadTimeout(this.f18b);
        this.f20d.setUseCaches(false);
        this.f20d.setRequestMethod(this.f17a.b().a());
        this.f20d.setDoInput(true);
        this.f20d.setInstanceFollowRedirects(false);
        this.f20d.connect();
        if (h.POST == this.f17a.b() && q.b(this.f17a.a().a())) {
            OutputStream outputStream = this.f20d.getOutputStream();
            outputStream.write(this.f17a.a().a().getBytes());
            outputStream.flush();
            outputStream.close();
        }
        this.f21e = this.f20d.getInputStream();
        if (this.f) {
            return null;
        }
        int responseCode = this.f20d.getResponseCode();
        if (a(responseCode)) {
            return b();
        }
        if (!b(responseCode)) {
            if (responseCode == -1) {
                throw new a.a.a.a.a(responseCode);
            }
            throw new a.a.a.a.a(this.f20d.getResponseMessage(), responseCode);
        }
        String headerField = this.f20d.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
        if (TextUtils.isEmpty(headerField)) {
            throw new a.a.a.a.a("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        a();
        return a(url3, i + 1, url, map);
    }

    private static boolean a(int i) {
        return i / 100 == 2;
    }

    private static boolean b(int i) {
        return i / 100 == 3;
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = this.f21e.read(bArr);
            if (read != -1) {
                sb.append(new String(bArr, 0, read, "GBK"));
            } else {
                a();
                return sb.toString();
            }
        }
    }

    public void a() {
        InputStream inputStream = this.f21e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f20d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f20d = null;
    }

    @Override // a.a.a.b.f
    public f<String> a(a.a.a.b.b bVar) {
        this.f17a = bVar;
        return this;
    }

    /* compiled from: HttpNormalUrlLoader.java */
    /* loaded from: classes.dex */
    private static class a implements b {
        a() {
        }

        @Override // a.a.a.b.c.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }
}
