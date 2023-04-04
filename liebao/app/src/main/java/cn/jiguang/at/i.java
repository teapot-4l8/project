package cn.jiguang.at;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.tencent.bugly.CrashModule;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends cn.jiguang.ax.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3944a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f3944a = hVar;
    }

    @Override // cn.jiguang.ax.a
    public final void a(Message message) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        Context context6;
        if (message != null) {
            int i = message.what;
            if (i == 1011) {
                h hVar = this.f3944a;
                context = hVar.k;
                hVar.a(context, "tcp_a14", null);
            } else if (i == 1022) {
                h hVar2 = this.f3944a;
                context2 = hVar2.k;
                hVar2.a(context2, "tcp_a17", null);
            } else if (i == 2000) {
                p a2 = p.a();
                context3 = this.f3944a.k;
                a2.a(context3);
            } else {
                switch (i) {
                    case CrashModule.MODULE_ID /* 1004 */:
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("force", true);
                        h hVar3 = this.f3944a;
                        context4 = hVar3.k;
                        hVar3.a(context4, "tcp_a16", bundle);
                        return;
                    case 1005:
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("force", false);
                        h hVar4 = this.f3944a;
                        context5 = hVar4.k;
                        hVar4.a(context5, "tcp_a16", bundle2);
                        return;
                    case 1006:
                    case 1007:
                        h hVar5 = this.f3944a;
                        context6 = hVar5.k;
                        hVar5.a(context6, "tcp_a2", null);
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
