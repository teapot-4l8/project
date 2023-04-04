package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes.dex */
final class zzaa implements Continuation<Void, List<TResult>> {
    private final /* synthetic */ Collection zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(Collection collection) {
        this.zza = collection;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task<Void> task) {
        ArrayList arrayList = new ArrayList();
        for (Task task2 : this.zza) {
            arrayList.add(task2.getResult());
        }
        return arrayList;
    }
}
