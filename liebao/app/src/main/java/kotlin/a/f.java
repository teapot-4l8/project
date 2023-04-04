package kotlin.a;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Arrays.kt */
/* loaded from: classes2.dex */
public class f extends e {
    public static final <T> boolean a(T[] tArr, T t) {
        kotlin.d.b.i.b(tArr, "$this$contains");
        return b.b(tArr, t) >= 0;
    }

    public static final <T> int b(T[] tArr, T t) {
        kotlin.d.b.i.b(tArr, "$this$indexOf");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (kotlin.d.b.i.a(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final char a(char[] cArr) {
        kotlin.d.b.i.b(cArr, "$this$single");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }
}
