package com.trello.rxlifecycle3;

import b.b.d.e;
import b.b.d.g;
import java.util.concurrent.CancellationException;

/* compiled from: Functions.java */
/* loaded from: classes2.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    static final e<Throwable, Boolean> f6284a = new e<Throwable, Boolean>() { // from class: com.trello.rxlifecycle3.a.1
        @Override // b.b.d.e
        public Boolean a(Throwable th) {
            if (th instanceof c) {
                return true;
            }
            b.b.c.b.a(th);
            return false;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final g<Boolean> f6285b = new g<Boolean>() { // from class: com.trello.rxlifecycle3.a.2
        @Override // b.b.d.g
        public boolean a(Boolean bool) {
            return bool.booleanValue();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    static final e<Object, b.b.b> f6286c = new e<Object, b.b.b>() { // from class: com.trello.rxlifecycle3.a.3
        @Override // b.b.d.e
        /* renamed from: b */
        public b.b.b a(Object obj) {
            return b.b.b.a(new CancellationException());
        }
    };
}
