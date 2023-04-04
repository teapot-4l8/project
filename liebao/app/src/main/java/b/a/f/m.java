package b.a.f;

import android.net.Uri;
import android.text.TextUtils;
import b.a.h.a.b;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements b.a.j.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.fm.openinstall.a.c f3173a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Uri f3174b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f3175c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar, com.fm.openinstall.a.c cVar, Uri uri) {
        this.f3175c = aVar;
        this.f3173a = cVar;
        this.f3174b = uri;
    }

    @Override // b.a.j.a
    public void a(b.a.h.a.b bVar) {
        if (bVar.a() != b.a.SUCCESS) {
            if (b.a.k.d.f3261a) {
                b.a.k.d.c("decodeWakeUp fail : %s", bVar.c());
            }
            com.fm.openinstall.a.c cVar = this.f3173a;
            if (cVar != null) {
                cVar.a(null, new com.fm.openinstall.b.b(bVar.b(), bVar.c()));
                return;
            }
            return;
        }
        if (b.a.k.d.f3261a) {
            b.a.k.d.a("decodeWakeUp success : %s", bVar.d());
        }
        if (!TextUtils.isEmpty(bVar.c()) && b.a.k.d.f3261a) {
            b.a.k.d.b("decodeWakeUp warning : %s", bVar.c());
        }
        try {
            com.fm.openinstall.b.a aVar = new com.fm.openinstall.b.a();
            if (bVar.b() == 1) {
                aVar = this.f3175c.b(bVar.d());
            } else {
                b.a.h.b d2 = b.a.h.b.d(bVar.d());
                aVar.a(d2.a());
                aVar.b(d2.b());
            }
            if (this.f3173a != null) {
                this.f3173a.a(aVar, null);
            }
            if (aVar == null || aVar.c()) {
                return;
            }
            this.f3175c.a(this.f3174b);
        } catch (JSONException e2) {
            if (b.a.k.d.f3261a) {
                b.a.k.d.c("decodeWakeUp error : %s", e2.toString());
            }
            com.fm.openinstall.a.c cVar2 = this.f3173a;
            if (cVar2 != null) {
                cVar2.a(null, null);
            }
        }
    }
}
