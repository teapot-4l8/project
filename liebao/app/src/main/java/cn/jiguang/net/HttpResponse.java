package cn.jiguang.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    private String f4151a;

    /* renamed from: b  reason: collision with root package name */
    private String f4152b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f4153c;

    /* renamed from: d  reason: collision with root package name */
    private int f4154d;

    /* renamed from: e  reason: collision with root package name */
    private long f4155e;
    private boolean f;
    private boolean g;
    private int h;

    public HttpResponse() {
        this.h = -1;
        this.f4153c = new HashMap();
    }

    public HttpResponse(String str) {
        this.h = -1;
        this.f4151a = str;
        this.f4154d = 0;
        this.f = false;
        this.g = false;
        this.f4153c = new HashMap();
    }

    private int a() {
        int indexOf;
        try {
            String str = (String) this.f4153c.get("cache-control");
            if (TextUtils.isEmpty(str) || (indexOf = str.indexOf("max-age=")) == -1) {
                return -1;
            }
            int indexOf2 = str.indexOf(",", indexOf);
            int i = indexOf + 8;
            return Integer.parseInt(indexOf2 != -1 ? str.substring(i, indexOf2) : str.substring(i));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public long getExpiredTime() {
        if (this.g) {
            return this.f4155e;
        }
        this.g = true;
        int a2 = a();
        long currentTimeMillis = a2 != -1 ? System.currentTimeMillis() + (a2 * 1000) : !TextUtils.isEmpty(getExpiresHeader()) ? HttpUtils.parseGmtTime(getExpiresHeader()) : -1L;
        this.f4155e = currentTimeMillis;
        return currentTimeMillis;
    }

    public String getExpiresHeader() {
        try {
            if (this.f4153c == null) {
                return null;
            }
            return (String) this.f4153c.get("expires");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getResponseBody() {
        return this.f4152b;
    }

    public int getResponseCode() {
        return this.h;
    }

    public int getType() {
        return this.f4154d;
    }

    public String getUrl() {
        return this.f4151a;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.f4155e;
    }

    public boolean isInCache() {
        return this.f;
    }

    public void setExpiredTime(long j) {
        this.g = true;
        this.f4155e = j;
    }

    public HttpResponse setInCache(boolean z) {
        this.f = z;
        return this;
    }

    public void setResponseBody(String str) {
        this.f4152b = str;
    }

    public void setResponseCode(int i) {
        this.h = i;
    }

    public void setResponseHeader(String str, String str2) {
        Map<String, Object> map = this.f4153c;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void setResponseHeaders(Map<String, Object> map) {
        this.f4153c = map;
    }

    public void setType(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("The type of HttpResponse cannot be smaller than 0.");
        }
        this.f4154d = i;
    }

    public void setUrl(String str) {
        this.f4151a = str;
    }

    public String toString() {
        return "HttpResponse{responseBody='" + this.f4152b + "', responseCode=" + this.h + '}';
    }
}
