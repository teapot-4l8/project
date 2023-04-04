package kotlin.g;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Sequences.kt */
/* loaded from: classes2.dex */
public class h extends g {

    /* compiled from: Iterables.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Iterable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f7185a;

        public a(b bVar) {
            this.f7185a = bVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f7185a.a();
        }
    }

    public static final <T, R> b<R> a(b<? extends T> bVar, kotlin.d.a.b<? super T, ? extends R> bVar2) {
        kotlin.d.b.i.b(bVar, "$this$map");
        kotlin.d.b.i.b(bVar2, "transform");
        return new i(bVar, bVar2);
    }

    public static final <T, A extends Appendable> A a(b<? extends T> bVar, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.d.a.b<? super T, ? extends CharSequence> bVar2) {
        kotlin.d.b.i.b(bVar, "$this$joinTo");
        kotlin.d.b.i.b(a2, "buffer");
        kotlin.d.b.i.b(charSequence, "separator");
        kotlin.d.b.i.b(charSequence2, "prefix");
        kotlin.d.b.i.b(charSequence3, "postfix");
        kotlin.d.b.i.b(charSequence4, "truncated");
        a2.append(charSequence2);
        Iterator<? extends T> a3 = bVar.a();
        int i2 = 0;
        while (a3.hasNext()) {
            T next = a3.next();
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.h.g.a(a2, next, bVar2);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(b bVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.d.a.b bVar2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        CharSequence charSequence5 = charSequence2;
        if ((i2 & 4) != 0) {
        }
        CharSequence charSequence6 = charSequence3;
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            bVar2 = null;
        }
        return c.a(bVar, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar2);
    }

    public static final <T> String a(b<? extends T> bVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.d.a.b<? super T, ? extends CharSequence> bVar2) {
        kotlin.d.b.i.b(bVar, "$this$joinToString");
        kotlin.d.b.i.b(charSequence, "separator");
        kotlin.d.b.i.b(charSequence2, "prefix");
        kotlin.d.b.i.b(charSequence3, "postfix");
        kotlin.d.b.i.b(charSequence4, "truncated");
        String sb = ((StringBuilder) c.a(bVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar2)).toString();
        kotlin.d.b.i.a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> Iterable<T> b(b<? extends T> bVar) {
        kotlin.d.b.i.b(bVar, "$this$asIterable");
        return new a(bVar);
    }
}
