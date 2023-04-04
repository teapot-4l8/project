package cn.jpush.android.f;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private String f4332a;

    /* renamed from: b  reason: collision with root package name */
    private long f4333b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f4334c;

    public d(String str, long j, JSONObject jSONObject) {
        this.f4332a = str;
        this.f4333b = j;
        this.f4334c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f4332a, this.f4333b, this.f4334c);
    }
}
