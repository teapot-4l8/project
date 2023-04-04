package kotlin.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringBuilder.kt */
/* loaded from: classes2.dex */
public class l extends k {
    public static final <T> void a(Appendable appendable, T t, kotlin.d.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.d.b.i.b(appendable, "$this$appendElement");
        if (bVar != null) {
            appendable.append(bVar.a(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
