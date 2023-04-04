package cn.jiguang.ao;

import android.content.Context;
import java.io.File;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f3794a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Set f3795b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ JSONObject f3796c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ File f3797d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Context context, Set set, JSONObject jSONObject, File file) {
        this.f3794a = context;
        this.f3795b = set;
        this.f3796c = jSONObject;
        this.f3797d = file;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.a(this.f3794a, this.f3795b, this.f3796c, this.f3797d, null);
        } catch (Throwable unused) {
        }
    }
}
