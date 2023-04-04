package b.a.f;

import android.text.TextUtils;
import b.a.h.a.b;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements b.a.j.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.fm.openinstall.a.b f3156a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3157b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, com.fm.openinstall.a.b bVar) {
        this.f3157b = aVar;
        this.f3156a = bVar;
    }

    @Override // b.a.j.a
    public void a(b.a.h.a.b bVar) {
        if (bVar.a() != b.a.SUCCESS) {
            if (b.a.k.d.f3261a) {
                b.a.k.d.c("decodeInstall fail : %s", bVar.c());
            }
            com.fm.openinstall.a.b bVar2 = this.f3156a;
            if (bVar2 != null) {
                bVar2.a(null, new com.fm.openinstall.b.b(bVar.b(), bVar.c()));
                return;
            }
            return;
        }
        if (b.a.k.d.f3261a) {
            b.a.k.d.a("decodeInstall success : %s", bVar.d());
        }
        if (!TextUtils.isEmpty(bVar.c()) && b.a.k.d.f3261a) {
            b.a.k.d.b("decodeInstall warning : %s", bVar.c());
        }
        try {
            b.a.h.b d2 = b.a.h.b.d(bVar.d());
            com.fm.openinstall.b.a aVar = new com.fm.openinstall.b.a();
            aVar.a(d2.a());
            aVar.b(d2.b());
            if (this.f3156a != null) {
                this.f3156a.a(aVar, null);
            }
        } catch (JSONException e2) {
            if (b.a.k.d.f3261a) {
                b.a.k.d.c("decodeInstall error : %s", e2.toString());
            }
            com.fm.openinstall.a.b bVar3 = this.f3156a;
            if (bVar3 != null) {
                bVar3.a(null, null);
            }
        }
    }
}
