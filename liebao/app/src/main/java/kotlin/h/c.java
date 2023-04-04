package kotlin.h;

/* compiled from: Char.kt */
/* loaded from: classes2.dex */
class c extends b {
    public static final boolean a(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (z) {
            return Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
        }
        return false;
    }
}
