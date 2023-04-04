package cn.jiguang.at;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.internal.JConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static volatile p f3968a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3969b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private Map<Long, String> f3970c = new HashMap();

    public static p a() {
        if (f3968a == null) {
            synchronized (f3969b) {
                if (f3968a == null) {
                    f3968a = new p();
                }
            }
        }
        return f3968a;
    }

    private static String a(Context context, String str, String str2) {
        String str3 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a(str));
        if (TextUtils.isEmpty(str2) || str2.equals(str3)) {
            StringBuilder sb = new StringBuilder("need not ");
            sb.append(str);
            sb.append(" userctrl,newest version:");
            if (TextUtils.isEmpty(str2)) {
                str2 = "null";
            }
            sb.append(str2);
            cn.jiguang.an.d.a("UserCtrlHelper", sb.toString());
            return "";
        }
        return str2;
    }

    public final void a(long j) {
        cn.jiguang.an.d.b("UserCtrlHelper", "onUserCtrlTimeout rid:" + j);
        this.f3970c.remove(Long.valueOf(j));
    }

    public final void a(long j, int i) {
        String remove = this.f3970c.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(remove)) {
            cn.jiguang.an.d.b("UserCtrlHelper", "onUserCtrlFailed but not found rid:" + j);
            return;
        }
        cn.jiguang.an.d.b("UserCtrlHelper", "onUserCtrlFailed rid:" + j + ",sdkType:" + remove + ",errorCode:" + i);
        b.a();
        if (TextUtils.isEmpty(b.a(remove, ""))) {
            cn.jiguang.an.d.b("UserCtrlHelper", "onUserCtrlFailed but not found sdkversion by sdkType:" + remove);
        }
    }

    public final void a(Context context) {
        if (context == null) {
            cn.jiguang.an.d.f("UserCtrlHelper", "handleUserCtrl failed,context is null");
            return;
        }
        HashMap<String, JDispatchAction> hashMap = b.f3924a;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, JDispatchAction> entry : hashMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null) {
                    String a2 = a(context, entry.getKey(), value.getSdkVersion(entry.getKey()));
                    if (!TextUtils.isEmpty(a2)) {
                        short userCtrlProperty = value.getUserCtrlProperty(entry.getKey());
                        String key = entry.getKey();
                        cn.jiguang.an.d.b("UserCtrlHelper", "sendUserCtrlInfo sdkType:" + key + ",property:" + ((int) userCtrlProperty) + ",verInfo:" + a2);
                        long b2 = n.b();
                        cn.jiguang.ap.b.a(context, JConstants.SDK_TYPE, 26, 0, b2, 10000L, cn.jiguang.av.b.a(userCtrlProperty, (short) 1, a2));
                        this.f3970c.put(Long.valueOf(b2), key);
                    }
                }
            }
        }
    }

    public final void a(Context context, long j) {
        String str;
        Map<Long, String> map;
        String remove = this.f3970c.remove(Long.valueOf(j));
        if (TextUtils.isEmpty(remove)) {
            str = "userCtrlSuccess but not found rid:" + j;
        } else {
            cn.jiguang.an.d.b("UserCtrlHelper", "userCtrlSuccess rid:" + j + ",sdkType:" + remove);
            b.a();
            String a2 = b.a(remove, "");
            if (!TextUtils.isEmpty(a2)) {
                cn.jiguang.g.b.a(context, cn.jiguang.g.a.a(remove).a((cn.jiguang.g.a<String>) a2));
                map = this.f3970c;
                if (map == null && map.isEmpty() && !cn.jiguang.am.b.a().d()) {
                    h.a().a(context, "tcp_a21", null);
                    return;
                }
                return;
            }
            str = "userCtrlSuccess but not found sdkversion by sdkType:" + remove;
        }
        cn.jiguang.an.d.b("UserCtrlHelper", str);
        map = this.f3970c;
        if (map == null) {
        }
    }

    public final boolean b(Context context) {
        if (context == null) {
            cn.jiguang.an.d.g("UserCtrlHelper", "get isNeedUserCtrl failed,context is null");
            return false;
        }
        HashMap<String, JDispatchAction> hashMap = b.f3924a;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, JDispatchAction> entry : hashMap.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && !TextUtils.isEmpty(a(context, entry.getKey(), value.getSdkVersion(entry.getKey())))) {
                    return true;
                }
            }
        }
        return false;
    }
}
