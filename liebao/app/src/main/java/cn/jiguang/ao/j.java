package cn.jiguang.ao;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3786a;

    private j(Context context) {
        this.f3786a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(Context context, byte b2) {
        this(context);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            String a2 = i.a(this.f3786a);
            LinkedHashSet b2 = i.b(this.f3786a);
            b2.addAll(i.a());
            cn.jiguang.an.d.b("ReportSis", "sis urls=" + b2.toString() + " post json=" + a2);
            if (!cn.jiguang.f.a.d(this.f3786a)) {
                cn.jiguang.an.d.f("ReportSis", "give up sis, because network is not connected");
                return;
            }
            Iterator it = b2.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 28 && !str.startsWith("https://")) {
                        cn.jiguang.an.d.f("ReportSis", "won't use http at device since 28");
                    } else if (i.a(this.f3786a, str, a2)) {
                        return;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
