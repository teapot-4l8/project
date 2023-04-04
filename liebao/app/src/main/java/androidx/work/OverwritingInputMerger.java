package androidx.work;

import androidx.work.e;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class OverwritingInputMerger extends g {
    @Override // androidx.work.g
    public e a(List<e> list) {
        e.a aVar = new e.a();
        HashMap hashMap = new HashMap();
        for (e eVar : list) {
            hashMap.putAll(eVar.a());
        }
        aVar.a(hashMap);
        return aVar.a();
    }
}
