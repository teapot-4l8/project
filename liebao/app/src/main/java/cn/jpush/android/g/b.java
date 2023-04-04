package cn.jpush.android.g;

import android.content.Intent;
import android.text.TextUtils;
import cn.jiguang.push.asus.PushMessageReceiver;

/* loaded from: classes.dex */
public final class b extends cn.a.a.c {
    @Override // cn.a.a.b
    public final void call(cn.a.a.a aVar) {
        try {
            cn.jpush.android.i.b.a("ClientAIDLCallBack", "[call] data:" + String.valueOf(aVar) + ",cmd:" + aVar.f3587a);
            String str = aVar.f3587a;
            long j = aVar.f3588b.getLong("message_rid", -1L);
            String string = aVar.f3588b.getString("message_content");
            String b2 = cn.jpush.android.f.c.b(cn.jpush.android.f.c.f4327a);
            if (TextUtils.isEmpty(b2)) {
                Intent intent = new Intent();
                aVar.f3588b.putString("message_cmd", aVar.f3587a);
                intent.putExtras(aVar.f3588b);
                intent.setAction("com.ups.push.PUSH_RESPONSE");
                intent.setPackage(cn.jpush.android.f.c.f4329c);
                cn.jpush.android.f.c.f4327a.sendBroadcast(intent);
            } else {
                ((PushMessageReceiver) Class.forName(b2).newInstance()).a(cn.jpush.android.f.c.f4327a, j, str, string);
            }
        } catch (Throwable unused) {
        }
    }
}
