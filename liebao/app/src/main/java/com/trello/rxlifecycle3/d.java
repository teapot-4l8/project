package com.trello.rxlifecycle3;

import b.b.e;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

/* compiled from: RxLifecycle.java */
/* loaded from: classes.dex */
public class d {
    @Nonnull
    @CheckReturnValue
    public static <T, R> b<T> a(@Nonnull e<R> eVar) {
        return new b<>(eVar);
    }

    @Nonnull
    @CheckReturnValue
    public static <T, R> b<T> a(@Nonnull e<R> eVar, @Nonnull b.b.d.e<R, R> eVar2) {
        com.trello.rxlifecycle3.b.a.a(eVar, "lifecycle == null");
        com.trello.rxlifecycle3.b.a.a(eVar2, "correspondingEvents == null");
        return a(b(eVar.f(), eVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <R> e<Boolean> b(e<R> eVar, b.b.d.e<R, R> eVar2) {
        return e.a(eVar.b(1L).a((b.b.d.e<? super R, ? extends R>) eVar2), eVar.a(1L), new b.b.d.b<R, R, Boolean>() { // from class: com.trello.rxlifecycle3.d.1
            @Override // b.b.d.b
            /* renamed from: a */
            public Boolean b(R r, R r2) {
                return Boolean.valueOf(r2.equals(r));
            }
        }).b((b.b.d.e) a.f6284a).a(a.f6285b);
    }
}
