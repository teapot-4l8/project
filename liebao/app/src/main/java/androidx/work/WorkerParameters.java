package androidx.work;

import android.net.Network;
import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    private UUID f2753a;

    /* renamed from: b  reason: collision with root package name */
    private e f2754b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f2755c;

    /* renamed from: d  reason: collision with root package name */
    private a f2756d;

    /* renamed from: e  reason: collision with root package name */
    private int f2757e;
    private Executor f;
    private androidx.work.impl.utils.b.a g;
    private p h;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f2758a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public List<Uri> f2759b = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public Network f2760c;
    }

    public WorkerParameters(UUID uuid, e eVar, Collection<String> collection, a aVar, int i, Executor executor, androidx.work.impl.utils.b.a aVar2, p pVar) {
        this.f2753a = uuid;
        this.f2754b = eVar;
        this.f2755c = new HashSet(collection);
        this.f2756d = aVar;
        this.f2757e = i;
        this.f = executor;
        this.g = aVar2;
        this.h = pVar;
    }

    public UUID a() {
        return this.f2753a;
    }

    public e b() {
        return this.f2754b;
    }

    public Set<String> c() {
        return this.f2755c;
    }

    public List<Uri> d() {
        return this.f2756d.f2759b;
    }

    public List<String> e() {
        return this.f2756d.f2758a;
    }

    public Network f() {
        return this.f2756d.f2760c;
    }

    public int g() {
        return this.f2757e;
    }

    public Executor h() {
        return this.f;
    }

    public androidx.work.impl.utils.b.a i() {
        return this.g;
    }

    public p j() {
        return this.h;
    }
}
