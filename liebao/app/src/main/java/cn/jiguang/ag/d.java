package cn.jiguang.ag;

import android.content.Context;
import cn.jiguang.internal.JConstants;
import cn.jiguang.o.f;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3692a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3693b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f3694c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Context context, JSONObject jSONObject) {
        this.f3692a = aVar;
        this.f3693b = context;
        this.f3694c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            long d2 = f.d(this.f3693b, "JWakecmd");
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f3694c == null && currentTimeMillis - d2 < JConstants.HOUR) {
                cn.jiguang.ad.a.d("JWake", "is not cmd wake time");
                return;
            }
            a.a(this.f3692a, this.f3693b, this.f3694c);
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JWake", "WakeAction failed:" + th.getMessage());
        }
    }
}
