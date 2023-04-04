package kotlin.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Strings.kt */
/* loaded from: classes2.dex */
public class r extends q {
    public static final CharSequence c(CharSequence charSequence) {
        kotlin.d.b.i.b(charSequence, "$this$reversed");
        StringBuilder reverse = new StringBuilder(charSequence).reverse();
        kotlin.d.b.i.a((Object) reverse, "StringBuilder(this).reverse()");
        return reverse;
    }
}
