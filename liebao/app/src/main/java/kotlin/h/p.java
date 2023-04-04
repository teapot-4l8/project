package kotlin.h;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes2.dex */
public class p extends o {
    public static final int b(CharSequence charSequence) {
        kotlin.d.b.i.b(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final String a(CharSequence charSequence, kotlin.f.c cVar) {
        kotlin.d.b.i.b(charSequence, "$this$substring");
        kotlin.d.b.i.b(cVar, "range");
        return charSequence.subSequence(cVar.f().intValue(), cVar.g().intValue() + 1).toString();
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        kotlin.d.b.i.b(charSequence, "$this$regionMatchesImpl");
        kotlin.d.b.i.b(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!kotlin.h.a.a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        kotlin.d.b.i.b(charSequence, "$this$indexOfAny");
        kotlin.d.b.i.b(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.a.b.a(cArr), i);
        }
        int c2 = kotlin.f.d.c(i, 0);
        int b2 = g.b(charSequence);
        if (c2 > b2) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(c2);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                } else if (kotlin.h.a.a(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return c2;
            }
            if (c2 == b2) {
                return -1;
            }
            c2++;
        }
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        kotlin.f.c a2;
        if (!z2) {
            a2 = new kotlin.f.c(kotlin.f.d.c(i, 0), kotlin.f.d.d(i2, charSequence.length()));
        } else {
            a2 = kotlin.f.d.a(kotlin.f.d.d(i, g.b(charSequence)), kotlin.f.d.c(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a3 = a2.a();
            int b2 = a2.b();
            int c2 = a2.c();
            if (c2 >= 0) {
                if (a3 > b2) {
                    return -1;
                }
            } else if (a3 < b2) {
                return -1;
            }
            while (!g.a((String) charSequence2, 0, (String) charSequence, a3, charSequence2.length(), z)) {
                if (a3 == b2) {
                    return -1;
                }
                a3 += c2;
            }
            return a3;
        }
        int a4 = a2.a();
        int b3 = a2.b();
        int c3 = a2.c();
        if (c3 >= 0) {
            if (a4 > b3) {
                return -1;
            }
        } else if (a4 < b3) {
            return -1;
        }
        while (!g.a(charSequence2, 0, charSequence, a4, charSequence2.length(), z)) {
            if (a4 == b3) {
                return -1;
            }
            a4 += c3;
        }
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.f<Integer, String> b(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (!z && collection.size() == 1) {
            String str = (String) kotlin.a.h.b(collection);
            int a2 = !z2 ? g.a(charSequence, str, i, false, 4, (Object) null) : g.b(charSequence, str, i, false, 4, (Object) null);
            if (a2 < 0) {
                return null;
            }
            return kotlin.h.a(Integer.valueOf(a2), str);
        }
        kotlin.f.c cVar = !z2 ? new kotlin.f.c(kotlin.f.d.c(i, 0), charSequence.length()) : kotlin.f.d.a(kotlin.f.d.d(i, g.b(charSequence)), 0);
        if (charSequence instanceof String) {
            int a3 = cVar.a();
            int b2 = cVar.b();
            int c2 = cVar.c();
            if (c2 < 0 ? a3 >= b2 : a3 <= b2) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (g.a(str2, 0, (String) charSequence, a3, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (a3 == b2) {
                            break;
                        }
                        a3 += c2;
                    } else {
                        return kotlin.h.a(Integer.valueOf(a3), str3);
                    }
                }
            }
        } else {
            int a4 = cVar.a();
            int b3 = cVar.b();
            int c3 = cVar.c();
            if (c3 < 0 ? a4 >= b3 : a4 <= b3) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (g.a(str4, 0, charSequence, a4, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (a4 == b3) {
                            break;
                        }
                        a4 += c3;
                    } else {
                        return kotlin.h.a(Integer.valueOf(a4), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return g.a(charSequence, c2, i, z);
    }

    public static final int a(CharSequence charSequence, char c2, int i, boolean z) {
        kotlin.d.b.i.b(charSequence, "$this$indexOf");
        if (z || !(charSequence instanceof String)) {
            return g.a(charSequence, new char[]{c2}, i, z);
        }
        return ((String) charSequence).indexOf(c2, i);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return g.a(charSequence, str, i, z);
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.d.b.i.b(charSequence, "$this$indexOf");
        kotlin.d.b.i.b(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, str, i, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = g.b(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return g.b(charSequence, str, i, z);
    }

    public static final int b(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.d.b.i.b(charSequence, "$this$lastIndexOf");
        kotlin.d.b.i.b(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, (CharSequence) str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return g.a(charSequence, charSequence2, z);
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        kotlin.d.b.i.b(charSequence, "$this$contains");
        kotlin.d.b.i.b(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (g.a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    static /* synthetic */ kotlin.g.b a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, i, z, i2);
    }

    private static final kotlin.g.b<kotlin.f.c> a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        return new e(charSequence, i, i2, new a(kotlin.a.b.a(strArr), z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Strings.kt */
    /* loaded from: classes2.dex */
    public static final class a extends kotlin.d.b.j implements kotlin.d.a.c<CharSequence, Integer, kotlin.f<? extends Integer, ? extends Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f7206a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f7207b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, boolean z) {
            super(2);
            this.f7206a = list;
            this.f7207b = z;
        }

        @Override // kotlin.d.a.c
        public /* synthetic */ kotlin.f<? extends Integer, ? extends Integer> a(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }

        public final kotlin.f<Integer, Integer> a(CharSequence charSequence, int i) {
            kotlin.d.b.i.b(charSequence, "$receiver");
            kotlin.f b2 = p.b(charSequence, (Collection<String>) this.f7206a, i, this.f7207b, false);
            if (b2 != null) {
                return kotlin.h.a(b2.a(), Integer.valueOf(((String) b2.b()).length()));
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Strings.kt */
    /* loaded from: classes2.dex */
    public static final class b extends kotlin.d.b.j implements kotlin.d.a.b<kotlin.f.c, String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CharSequence f7208a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence) {
            super(1);
            this.f7208a = charSequence;
        }

        @Override // kotlin.d.a.b
        public final String a(kotlin.f.c cVar) {
            kotlin.d.b.i.b(cVar, "it");
            return g.a(this.f7208a, cVar);
        }
    }

    public static /* synthetic */ kotlin.g.b a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return g.a(charSequence, strArr, z, i);
    }

    public static final kotlin.g.b<String> a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        kotlin.d.b.i.b(charSequence, "$this$splitToSequence");
        kotlin.d.b.i.b(strArr, "delimiters");
        return kotlin.g.c.a(a(charSequence, strArr, 0, z, i, 2, null), new b(charSequence));
    }

    public static /* synthetic */ List b(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return g.b(charSequence, strArr, z, i);
    }

    public static final List<String> b(CharSequence charSequence, String[] strArr, boolean z, int i) {
        kotlin.d.b.i.b(charSequence, "$this$split");
        kotlin.d.b.i.b(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return a(charSequence, str, z, i);
            }
        }
        Iterable<kotlin.f.c> b2 = kotlin.g.c.b(a(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.a.h.a(b2, 10));
        for (kotlin.f.c cVar : b2) {
            arrayList.add(g.a(charSequence, cVar));
        }
        return arrayList;
    }

    private static final List<String> a(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        int a2 = g.a(charSequence, str, 0, z);
        if (a2 == -1 || i == 1) {
            return kotlin.a.h.a(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? kotlin.f.d.d(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i2, a2).toString());
            i2 = str.length() + a2;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            a2 = g.a(charSequence, str, i2, z);
        } while (a2 != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static final CharSequence a(CharSequence charSequence) {
        kotlin.d.b.i.b(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean a2 = kotlin.h.a.a(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!a2) {
                    break;
                }
                length--;
            } else if (a2) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }
}
