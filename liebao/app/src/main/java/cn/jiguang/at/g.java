package cn.jiguang.at;

import android.content.Context;
import android.os.Message;
import cn.jiguang.internal.JConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends cn.jiguang.ax.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f3938a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f3938a = fVar;
    }

    @Override // cn.jiguang.ax.a
    public final void a(Message message) {
        Context context;
        cn.jiguang.an.d.b("PeriodWorker", "time is up, next period=" + (JConstants.DEFAULT_HEARTBEAT_INTERVAL * 1000));
        f fVar = this.f3938a;
        context = fVar.f3935c;
        fVar.c(context);
    }
}
