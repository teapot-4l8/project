package cn.jiguang.aj;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f3713a;

    /* renamed from: b  reason: collision with root package name */
    private int f3714b;

    /* renamed from: c  reason: collision with root package name */
    private String f3715c;

    /* renamed from: d  reason: collision with root package name */
    private Context f3716d;

    public d(c cVar, Context context, int i, String str) {
        this.f3713a = cVar;
        this.f3716d = context;
        this.f3714b = i;
        this.f3715c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (TextUtils.isEmpty(this.f3715c)) {
                this.f3715c = "https://ce3e75d5.jpush.cn/wi/cjc4sa";
            }
            if (JCoreManager.isInternal() && !TextUtils.isEmpty(JConstants.TUU)) {
                this.f3715c = JConstants.TUU;
            }
            c.a(this.f3713a, this.f3716d, this.f3714b, this.f3715c);
        } catch (Throwable th) {
            cn.jiguang.an.d.f("UPM", "UpdateAction failed:" + th.getMessage());
        }
    }
}
