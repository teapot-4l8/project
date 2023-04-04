package cn.jiguang.o;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4171a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4172b;

    /* renamed from: c  reason: collision with root package name */
    private String f4173c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f4174d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, Context context, String str, JSONObject jSONObject) {
        this.f4171a = aVar;
        this.f4172b = context;
        this.f4173c = str;
        this.f4174d = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a.a(this.f4171a, this.f4172b, this.f4173c, this.f4174d);
        } catch (Throwable unused) {
        }
    }
}
