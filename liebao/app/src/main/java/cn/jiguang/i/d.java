package cn.jiguang.i;

import android.content.Context;
import cn.jiguang.o.i;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d extends cn.jiguang.o.a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile d f4095c;

    /* renamed from: a  reason: collision with root package name */
    private Context f4096a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f4097b;

    public static d a() {
        if (f4095c == null) {
            synchronized (d.class) {
                f4095c = new d();
            }
        }
        return f4095c;
    }

    @Override // cn.jiguang.o.a
    protected final String a(Context context) {
        this.f4096a = context;
        return "JAppPermission";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void a(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            this.f4097b = strArr;
            if (strArr == null || strArr.length <= 0) {
                cn.jiguang.ad.a.a("JAppPermission", "collect failed");
                return;
            }
            cn.jiguang.ad.a.a("JAppPermission", "collect success:" + Arrays.toString(this.f4097b));
        } catch (Throwable th) {
            this.f4097b = null;
            cn.jiguang.ad.a.d("JAppPermission", "collect throwable:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void b(Context context, String str) {
        String[] strArr = this.f4097b;
        if (strArr == null || strArr.length == 0) {
            cn.jiguang.ad.a.d("JAppPermission", "there are no data to report");
            return;
        }
        int length = strArr.length;
        StringBuilder sb = new StringBuilder("[");
        String a2 = cn.jiguang.am.a.a(context);
        long d2 = cn.jiguang.d.a.d(context);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            String str2 = this.f4097b[i];
            if (i2 == 0) {
                sb.append("\"");
            } else {
                sb.append(",\"");
            }
            sb.append(str2);
            sb.append("\"");
            i++;
            i2++;
            if (i2 >= 50 || sb.length() > 1000 || i == length) {
                sb.append("]");
                String format = String.format(Locale.ENGLISH, "{\"total\":%d,\"page\":%d,\"senderid\":\"%s\",\"uid\":%s,\"permission_list\":%s}", Integer.valueOf(length), Integer.valueOf(i3), a2, Long.valueOf(d2), sb.toString());
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(JThirdPlatFormInterface.KEY_DATA, format);
                } catch (JSONException e2) {
                    cn.jiguang.ad.a.d("JAppPermission", "package json exception:" + e2.getMessage());
                }
                cn.jiguang.d.a.a(context, jSONObject, "android_permissions");
                i.a(context, (Object) jSONObject);
                super.b(context, str);
                i3++;
                sb = new StringBuilder("[");
                i2 = 0;
            }
        }
        this.f4097b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final boolean b() {
        cn.jiguang.ad.a.a("JAppPermission", "for googlePlay:false");
        return true;
    }
}
