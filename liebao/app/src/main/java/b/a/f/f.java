package b.a.f;

import java.io.File;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3161a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f3162b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ com.fm.openinstall.a.d f3163c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ a f3164d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, String str, String str2, com.fm.openinstall.a.d dVar) {
        this.f3164d = aVar;
        this.f3161a = str;
        this.f3162b = str2;
        this.f3163c = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            File file = new File(this.f3161a);
            File file2 = new File(this.f3162b);
            b.a.i.b.a((byte[]) null, file, file2);
            this.f3163c.a(file2);
        } catch (IOException e2) {
            if (b.a.k.d.f3261a) {
                e2.printStackTrace();
            }
            this.f3163c.a(null);
        }
    }
}
