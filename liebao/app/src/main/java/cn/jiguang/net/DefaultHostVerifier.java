package cn.jiguang.net;

import android.text.TextUtils;
import cn.jiguang.an.d;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public class DefaultHostVerifier implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    public String f4145a;

    public DefaultHostVerifier(String str) {
        this.f4145a = null;
        this.f4145a = str;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        d.b("DefaultHostVerifier", "host:" + str + ",checkHost:" + this.f4145a);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f4145a, str);
    }
}
