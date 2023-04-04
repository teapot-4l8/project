package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.umeng.analytics.pro.ak;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: UMSLNetWorkSenderHelper.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f6808a = "10.0.0.172";

    /* renamed from: b  reason: collision with root package name */
    private int f6809b = 80;

    /* renamed from: c  reason: collision with root package name */
    private Context f6810c;

    public c(Context context) {
        this.f6810c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f6810c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.i = DataHelper.assembleStatelessURL(imprintProperty);
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f6810c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f6810c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.i = a.k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f6818b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f6818b.startsWith("460") || com.umeng.commonsdk.statistics.b.f6818b.startsWith("461")) {
            a.i = a.h;
        }
    }

    private boolean c() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        Context context = this.f6810c;
        if (context == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f6810c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f6810c.getSystemService("connectivity");
            if (DeviceConfig.checkPermission(this.f6810c, "android.permission.ACCESS_NETWORK_STATE") && connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                    if (extraInfo.equals("uniwap")) {
                    }
                }
                return true;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f6810c, th);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0112, code lost:
        com.umeng.commonsdk.debug.UMRTLog.e(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
        r13.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012b, code lost:
        if (r13 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x013c, code lost:
        if (r13 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x013f, code lost:
        return r2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [javax.net.ssl.HttpsURLConnection, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(byte[] bArr, String str, String str2, String str3) {
        HttpsURLConnection httpsURLConnection;
        boolean z = false;
        if (bArr == null || str == null) {
            ULog.i("walle", "[stateless] sendMessage, envelopeByte == null || path == null ");
            return false;
        }
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            a.h = a.k;
            b();
        }
        String str4 = a.i;
        boolean isEmpty = TextUtils.isEmpty(str2);
        ?? r13 = str2;
        if (isEmpty) {
            r13 = str4;
        }
        OutputStream outputStream = null;
        try {
            try {
                if (c()) {
                    httpsURLConnection = (HttpsURLConnection) new URL(((String) r13) + File.separator + str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.f6808a, this.f6809b)));
                } else {
                    httpsURLConnection = (HttpsURLConnection) new URL(((String) r13) + File.separator + str).openConnection();
                }
                try {
                    httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, null, new SecureRandom());
                    httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("Content-Type", ak.aP + str3);
                    httpsURLConnection.setConnectTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                    httpsURLConnection.setReadTimeout(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    httpsURLConnection.connect();
                    if (httpsURLConnection.getResponseCode() == 200) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send stateless message success : " + a.i + "/" + str);
                        z = true;
                    }
                } catch (SSLHandshakeException e2) {
                    e = e2;
                    MLog.e("SSLHandshakeException, Failed to send message.", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    MLog.e("Exception,Failed to send message.", th);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                }
            } catch (SSLHandshakeException e3) {
                e = e3;
                httpsURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                httpsURLConnection = null;
            }
        } finally {
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (Exception unused3) {
                }
            }
            if (r13 != 0) {
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> stateless: disconnect connection.");
                    r13.disconnect();
                } catch (Throwable unused4) {
                }
            }
        }
    }
}
