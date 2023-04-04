package cn.jiguang.ao;

import android.content.Context;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f3792a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f3793b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Object obj, Context context) {
        this.f3792a = obj;
        this.f3793b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONArray c2;
        Set c3;
        try {
            c2 = k.c(this.f3792a);
            if (c2 != null) {
                c3 = k.c(c2);
                k.a(this.f3793b, c2, c3);
            } else {
                cn.jiguang.an.d.b("ReportUtils", JThirdPlatFormInterface.KEY_DATA + this.f3792a + " is empty");
            }
        } catch (Throwable unused) {
        }
    }
}
