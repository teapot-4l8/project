package com.bumptech.glide.c.a;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.c.a.d;
import com.just.agentweb.AgentWebPermissions;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class j implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    static final b f4655a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.c.c.g f4656b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4657c;

    /* renamed from: d  reason: collision with root package name */
    private final b f4658d;

    /* renamed from: e  reason: collision with root package name */
    private HttpURLConnection f4659e;
    private InputStream f;
    private volatile boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    public interface b {
        HttpURLConnection a(URL url);
    }

    public j(com.bumptech.glide.c.c.g gVar, int i) {
        this(gVar, i, f4655a);
    }

    j(com.bumptech.glide.c.c.g gVar, int i, b bVar) {
        this.f4656b = gVar;
        this.f4657c = i;
        this.f4658d = bVar;
    }

    @Override // com.bumptech.glide.c.a.d
    public void a(com.bumptech.glide.g gVar, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long a2 = com.bumptech.glide.i.e.a();
        try {
            try {
                aVar.a((d.a<? super InputStream>) a(this.f4656b.a(), 0, null, this.f4656b.b()));
            } catch (IOException e2) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
                }
                aVar.a((Exception) e2);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                }
                sb = new StringBuilder();
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(com.bumptech.glide.i.e.a(a2));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.bumptech.glide.i.e.a(a2));
            }
            throw th;
        }
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) {
        if (i >= 5) {
            throw new com.bumptech.glide.c.e("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new com.bumptech.glide.c.e("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.f4659e = this.f4658d.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.f4659e.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.f4659e.setConnectTimeout(this.f4657c);
        this.f4659e.setReadTimeout(this.f4657c);
        this.f4659e.setUseCaches(false);
        this.f4659e.setDoInput(true);
        this.f4659e.setInstanceFollowRedirects(false);
        this.f4659e.connect();
        this.f = this.f4659e.getInputStream();
        if (this.g) {
            return null;
        }
        int responseCode = this.f4659e.getResponseCode();
        if (a(responseCode)) {
            return a(this.f4659e);
        }
        if (!b(responseCode)) {
            if (responseCode == -1) {
                throw new com.bumptech.glide.c.e(responseCode);
            }
            throw new com.bumptech.glide.c.e(this.f4659e.getResponseMessage(), responseCode);
        }
        String headerField = this.f4659e.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
        if (TextUtils.isEmpty(headerField)) {
            throw new com.bumptech.glide.c.e("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        b();
        return a(url3, i + 1, url, map);
    }

    private static boolean a(int i) {
        return i / 100 == 2;
    }

    private static boolean b(int i) {
        return i / 100 == 3;
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f = com.bumptech.glide.i.c.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f = httpURLConnection.getInputStream();
        }
        return this.f;
    }

    @Override // com.bumptech.glide.c.a.d
    public void b() {
        InputStream inputStream = this.f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f4659e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f4659e = null;
    }

    @Override // com.bumptech.glide.c.a.d
    public void c() {
        this.g = true;
    }

    @Override // com.bumptech.glide.c.a.d
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.c.a.d
    public com.bumptech.glide.c.a d() {
        return com.bumptech.glide.c.a.REMOTE;
    }

    /* compiled from: HttpUrlFetcher.java */
    /* loaded from: classes.dex */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.c.a.j.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }
}
