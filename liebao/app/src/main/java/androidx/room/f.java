package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InvalidationLiveDataContainer.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    final Set<LiveData> f2421a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final j f2422b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(j jVar) {
        this.f2422b = jVar;
    }
}
