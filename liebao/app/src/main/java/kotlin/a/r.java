package kotlin.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Collections.kt */
/* loaded from: classes2.dex */
public class r extends q {
    public static final <T> T a(Iterable<? extends T> iterable) {
        kotlin.d.b.i.b(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) h.b((List<? extends Object>) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return it.next();
    }

    public static final <T> T b(List<? extends T> list) {
        kotlin.d.b.i.b(list, "$this$first");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final <T> T b(Iterable<? extends T> iterable) {
        kotlin.d.b.i.b(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) h.c((List<? extends Object>) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T c(List<? extends T> list) {
        kotlin.d.b.i.b(list, "$this$single");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> List<T> b(Iterable<? extends T> iterable, int i) {
        kotlin.d.b.i.b(iterable, "$this$take");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i + " is less than zero.").toString());
        } else if (i == 0) {
            return h.a();
        } else {
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return h.c(iterable);
                }
                if (i == 1) {
                    return h.a(h.a((Iterable<? extends Object>) iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            for (T t : iterable) {
                arrayList.add(t);
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return h.a((List) arrayList);
        }
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c2) {
        kotlin.d.b.i.b(iterable, "$this$toCollection");
        kotlin.d.b.i.b(c2, "destination");
        for (T t : iterable) {
            c2.add(t);
        }
        return c2;
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable) {
        kotlin.d.b.i.b(iterable, "$this$toList");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return h.a(collection);
                }
                return h.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            }
            return h.a();
        }
        return h.a(h.d(iterable));
    }

    public static final <T> List<T> d(Iterable<? extends T> iterable) {
        kotlin.d.b.i.b(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return h.a((Collection) iterable);
        }
        return (List) h.a(iterable, new ArrayList());
    }

    public static final <T> List<T> a(Collection<? extends T> collection) {
        kotlin.d.b.i.b(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.d.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.d.b.i.b(iterable, "$this$joinTo");
        kotlin.d.b.i.b(a2, "buffer");
        kotlin.d.b.i.b(charSequence, "separator");
        kotlin.d.b.i.b(charSequence2, "prefix");
        kotlin.d.b.i.b(charSequence3, "postfix");
        kotlin.d.b.i.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.h.g.a(a2, t, bVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.d.a.b bVar, int i2, Object obj) {
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
            bVar = null;
        }
        return h.a(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar);
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.d.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.d.b.i.b(iterable, "$this$joinToString");
        kotlin.d.b.i.b(charSequence, "separator");
        kotlin.d.b.i.b(charSequence2, "prefix");
        kotlin.d.b.i.b(charSequence3, "postfix");
        kotlin.d.b.i.b(charSequence4, "truncated");
        String sb = ((StringBuilder) h.a(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        kotlin.d.b.i.a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }
}
