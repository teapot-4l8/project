package cn.jiguang.f;

import android.content.Context;
import android.widget.Toast;

/* loaded from: classes.dex */
final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f4066a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f4067b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str) {
        this.f4066a = context;
        this.f4067b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Toast.makeText(this.f4066a, this.f4067b, 0).show();
        } catch (Throwable unused) {
        }
    }
}
