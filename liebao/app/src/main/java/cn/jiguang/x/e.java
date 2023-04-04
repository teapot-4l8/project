package cn.jiguang.x;

import android.text.TextUtils;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.supplier.IdSupplier;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class e implements IIdentifierListener {

    /* renamed from: a  reason: collision with root package name */
    private d f4251a;

    public e(d dVar) {
        this.f4251a = dVar;
    }

    public final void OnSupport(boolean z, IdSupplier idSupplier) {
        try {
            try {
                if (idSupplier == null) {
                    this.f4251a.f4249a.put("");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                String oaid = idSupplier.getOAID();
                String vaid = idSupplier.getVAID();
                String aaid = idSupplier.getAAID();
                if (!TextUtils.isEmpty(oaid)) {
                    jSONObject.put("oaid", oaid);
                }
                if (!TextUtils.isEmpty(vaid)) {
                    jSONObject.put("vaid", vaid);
                }
                if (!TextUtils.isEmpty(aaid)) {
                    jSONObject.put("aaid", aaid);
                }
                this.f4251a.f4249a.put(jSONObject.toString());
                idSupplier.shutDown();
            } catch (Throwable unused) {
                this.f4251a.f4249a.put("");
            }
        } catch (Throwable unused2) {
        }
    }
}
