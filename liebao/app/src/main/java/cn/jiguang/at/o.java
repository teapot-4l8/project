package cn.jiguang.at;

import android.os.Bundle;
import android.os.Message;
import cn.jiguang.api.JCoreManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends cn.jiguang.ax.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f3967a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f3967a = nVar;
    }

    @Override // cn.jiguang.ax.a
    public final void a(Message message) {
        long j = message.what - 100000;
        Bundle bundle = new Bundle();
        bundle.putLong("rid", j);
        h.a().a(JCoreManager.getAppContext(null), "tcp_a6", bundle);
    }
}
