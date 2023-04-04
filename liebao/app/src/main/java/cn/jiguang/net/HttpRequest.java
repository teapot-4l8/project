package cn.jiguang.net;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;

/* loaded from: classes.dex */
public class HttpRequest {

    /* renamed from: a  reason: collision with root package name */
    private String f4146a;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f4149d;
    private Object f;
    private boolean g;
    private boolean h;
    private boolean i;
    private SSLTrustManager m;
    private boolean n;
    private HostnameVerifier o;
    private boolean j = true;
    private boolean k = false;
    private boolean l = false;

    /* renamed from: b  reason: collision with root package name */
    private int f4147b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f4148c = -1;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, String> f4150e = new HashMap();

    public HttpRequest(String str) {
        this.f4146a = str;
    }

    public HttpRequest(String str, Map<String, String> map) {
        this.f4146a = str;
        this.f4149d = map;
    }

    public Object getBody() {
        return this.f;
    }

    public int getConnectTimeout() {
        return this.f4147b;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.o;
    }

    public byte[] getParas() {
        Object obj = this.f;
        if (obj != null) {
            if (obj instanceof String) {
                if (!TextUtils.isEmpty((CharSequence) obj)) {
                    return ((String) this.f).getBytes();
                }
            } else if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
        }
        String joinParasWithEncodedValue = HttpUtils.joinParasWithEncodedValue(this.f4149d);
        if (TextUtils.isEmpty(joinParasWithEncodedValue)) {
            return null;
        }
        return joinParasWithEncodedValue.getBytes();
    }

    public Map<String, String> getParasMap() {
        return this.f4149d;
    }

    public int getReadTimeout() {
        return this.f4148c;
    }

    public Map<String, String> getRequestProperties() {
        return this.f4150e;
    }

    public String getRequestProperty(String str) {
        return this.f4150e.get(str);
    }

    public SSLTrustManager getSslTrustManager() {
        return this.m;
    }

    public String getUrl() {
        return this.f4146a;
    }

    public boolean isDoInPut() {
        return this.h;
    }

    public boolean isDoOutPut() {
        return this.g;
    }

    public boolean isHaveRspData() {
        return this.j;
    }

    public boolean isNeedErrorInput() {
        return this.l;
    }

    public boolean isNeedRetryIfHttpsFailed() {
        return this.n;
    }

    public boolean isRspDatazip() {
        return this.k;
    }

    public boolean isUseCaches() {
        return this.i;
    }

    public void setBody(Object obj) {
        this.f = obj;
    }

    public void setConnectTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.f4147b = i;
    }

    public void setDoInPut(boolean z) {
        this.h = z;
    }

    public void setDoOutPut(boolean z) {
        this.g = z;
    }

    public void setHaveRspData(boolean z) {
        this.j = z;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.o = hostnameVerifier;
    }

    public void setNeedErrorInput(boolean z) {
        this.l = z;
    }

    public void setNeedRetryIfHttpsFailed(boolean z) {
        this.n = z;
    }

    public void setParasMap(Map<String, String> map) {
        this.f4149d = map;
    }

    public void setReadTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout can not be negative");
        }
        this.f4148c = i;
    }

    public void setRequestProperties(Map<String, String> map) {
        this.f4150e = map;
    }

    public void setRequestProperty(String str, String str2) {
        this.f4150e.put(str, str2);
    }

    public void setRspDatazip(boolean z) {
        this.k = z;
    }

    public void setSslTrustManager(SSLTrustManager sSLTrustManager) {
        this.m = sSLTrustManager;
    }

    public void setUrl(String str) {
        this.f4146a = str;
    }

    public void setUseCaches(boolean z) {
        this.i = z;
    }

    public void setUserAgent(String str) {
        this.f4150e.put("User-Agent", str);
    }
}
