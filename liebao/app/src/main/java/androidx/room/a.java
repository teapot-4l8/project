package androidx.room;

import android.content.Context;
import androidx.e.a.c;
import androidx.room.j;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: DatabaseConfiguration.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final c.InterfaceC0044c f2390a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f2391b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2392c;

    /* renamed from: d  reason: collision with root package name */
    public final j.d f2393d;

    /* renamed from: e  reason: collision with root package name */
    public final List<j.b> f2394e;
    public final boolean f;
    public final j.c g;
    public final Executor h;
    public final Executor i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    private final Set<Integer> m;

    public a(Context context, String str, c.InterfaceC0044c interfaceC0044c, j.d dVar, List<j.b> list, boolean z, j.c cVar, Executor executor, Executor executor2, boolean z2, boolean z3, boolean z4, Set<Integer> set) {
        this.f2390a = interfaceC0044c;
        this.f2391b = context;
        this.f2392c = str;
        this.f2393d = dVar;
        this.f2394e = list;
        this.f = z;
        this.g = cVar;
        this.h = executor;
        this.i = executor2;
        this.j = z2;
        this.k = z3;
        this.l = z4;
        this.m = set;
    }

    public boolean a(int i, int i2) {
        Set<Integer> set;
        return !((i > i2) && this.l) && this.k && ((set = this.m) == null || !set.contains(Integer.valueOf(i)));
    }
}
