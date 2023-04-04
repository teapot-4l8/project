package cn.jiguang.push.asus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.f.c;
import cn.jpush.android.f.e;
import cn.jpush.android.i.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class PushMessageReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f4194a;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
        if (r15 == null) goto L97;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context, String str, long j, JSONObject jSONObject) {
        int i;
        cn.jpush.android.c.a aVar;
        JSONObject jSONObject2;
        char c2;
        if (jSONObject.has("cmd_msg_result")) {
            i = jSONObject.optInt("cmd_msg_result");
            if (i != 0) {
                b.c("PushMessageReceiver", "errorCode:" + i);
                if (i == 2) {
                    i = e.f4338d;
                } else if (i == 5) {
                    i = e.f4337c;
                } else if (i == 1) {
                    i = e.g;
                }
            }
            aVar = new cn.jpush.android.c.a(str, i);
        } else {
            i = 3;
            aVar = null;
        }
        if (jSONObject.has("cmd_msg_result_content")) {
            try {
                jSONObject2 = new JSONObject(jSONObject.getString("cmd_msg_result_content"));
            } catch (Throwable unused) {
                jSONObject2 = null;
            }
        }
        jSONObject2 = jSONObject;
        if (TextUtils.isEmpty(str)) {
            a(context, aVar);
            return;
        }
        switch (str.hashCode()) {
            case -530269543:
                if (str.equals("ups.register")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -129063684:
                if (str.equals("ups.turnOff")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -76940622:
                if (str.equals("ups.unregister")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 685741602:
                if (str.equals("ups.pushStatus")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1306253107:
                if (str.equals("ups.login")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 2074046642:
                if (str.equals("ups.turnOn")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            String optString = jSONObject2.optString("registrationId", "");
            cn.jpush.android.f.b bVar = new cn.jpush.android.f.b(str, j);
            cn.jpush.android.e.a a2 = cn.jpush.android.f.a.a(bVar);
            if (a2 != null) {
                cn.jpush.android.f.a.b(bVar);
            }
            if (!TextUtils.isEmpty(optString)) {
                b.b("PushMessageReceiver", "register succ.");
                if (a2 != null) {
                    a2.a(new cn.jpush.android.e.b(0, optString, "successs"));
                }
                a(context, optString);
                cn.jpush.android.a.b.a(optString);
            } else if (i != 1) {
                a(context, aVar);
                if (a2 != null) {
                    a2.a(new cn.jpush.android.e.b(aVar.a(), "", "failed"));
                }
            }
        } else if (c2 == 1) {
            if (i == 0) {
                cn.jpush.android.a.b.a("");
            }
            cn.jpush.android.f.b bVar2 = new cn.jpush.android.f.b(str, j);
            cn.jpush.android.e.a a3 = cn.jpush.android.f.a.a(bVar2);
            if (a3 != null) {
                cn.jpush.android.f.a.b(bVar2);
                a3.a(new cn.jpush.android.e.b(i, "", i == 0 ? "success" : "failed"));
            }
        } else if (c2 == 2) {
            b.b("PushMessageReceiver", "logined");
            if (TextUtils.isEmpty(c.f4328b) || !TextUtils.isEmpty(cn.jpush.android.a.b.b(context))) {
                return;
            }
            cn.jpush.android.h.a.a(context, c.f4328b, null);
        } else {
            if (c2 == 3) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("isPushStopped", jSONObject2.optBoolean("isPushStopped", false));
                if (aVar != null) {
                    aVar.a(bundle);
                }
            } else if (c2 != 4 && c2 != 5) {
                b.d("PushMessageReceiver", "unkown cmd:" + str);
                return;
            }
            a(context, aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, long j, String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        b.a("PushMessageReceiver", "receive cmd:" + str + ",rid:" + j + ",content:" + str2);
        if (!TextUtils.isEmpty(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONObject2 = jSONObject;
            if (jSONObject2 != null) {
                b.g("PushMessageReceiver", "handle json null");
                return;
            }
            try {
                a(context, str, j, jSONObject2);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        jSONObject = null;
        jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Context context, Intent intent) {
        if ("com.ups.push.PUSH_RESPONSE".equals(intent.getAction())) {
            a(context, intent.getLongExtra("message_rid", -1L), intent.getStringExtra("message_cmd"), intent.getStringExtra("message_content"));
        }
    }

    public abstract void a(Context context, cn.jpush.android.c.a aVar);

    public abstract void a(Context context, String str);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (f4194a == null) {
            f4194a = Executors.newSingleThreadExecutor();
        }
        f4194a.execute(new a(this, context, intent));
    }
}
