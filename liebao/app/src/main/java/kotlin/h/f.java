package kotlin.h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class f implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7204a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final Pattern f7205b;

    public f(Pattern pattern) {
        kotlin.d.b.i.b(pattern, "nativePattern");
        this.f7205b = pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f(String str) {
        this(r2);
        kotlin.d.b.i.b(str, "pattern");
        Pattern compile = Pattern.compile(str);
        kotlin.d.b.i.a((Object) compile, "Pattern.compile(pattern)");
    }

    public final String a(CharSequence charSequence, String str) {
        kotlin.d.b.i.b(charSequence, "input");
        kotlin.d.b.i.b(str, "replacement");
        String replaceAll = this.f7205b.matcher(charSequence).replaceAll(str);
        kotlin.d.b.i.a((Object) replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final List<String> a(CharSequence charSequence, int i) {
        kotlin.d.b.i.b(charSequence, "input");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        Matcher matcher = this.f7205b.matcher(charSequence);
        if (!matcher.find() || i == 1) {
            return kotlin.a.h.a(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i > 0 ? kotlin.f.d.d(i, 10) : 10);
        int i3 = i - 1;
        do {
            arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
            i2 = matcher.end();
            if (i3 >= 0 && arrayList.size() == i3) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String pattern = this.f7205b.toString();
        kotlin.d.b.i.a((Object) pattern, "nativePattern.toString()");
        return pattern;
    }

    /* compiled from: Regex.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.d.b.g gVar) {
            this();
        }
    }
}
