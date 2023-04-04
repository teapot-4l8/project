package com.speed.speed_library.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import kotlin.d.b.i;

/* compiled from: NetWorkUtils.kt */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5871a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static int f5872b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static int f5873c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static int f5874d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static int f5875e = 4;
    private static final int f = 3000;

    /* compiled from: NetWorkUtils.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.d.b.g gVar) {
            this();
        }

        public final boolean a(Context context) {
            i.b(context, com.umeng.analytics.pro.d.R);
            Object systemService = context.getApplicationContext().getSystemService("connectivity");
            if (systemService == null) {
                throw new kotlin.i("null cannot be cast to non-null type android.net.ConnectivityManager");
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        }

        public final boolean b(Context context) {
            int port;
            String str;
            if (Build.VERSION.SDK_INT >= 14) {
                str = System.getProperty("http.proxyHost");
                if (str == null) {
                    str = "";
                }
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    property = "-1";
                }
                port = Integer.parseInt(property);
            } else {
                String host = Proxy.getHost(context);
                i.a((Object) host, "Proxy.getHost(context)");
                port = Proxy.getPort(context);
                str = host;
            }
            return (TextUtils.isEmpty(str) || port == -1) ? false : true;
        }
    }
}
