package androidx.core.f;

import android.text.SpannableStringBuilder;
import com.umeng.analytics.pro.bz;
import java.util.Locale;

/* compiled from: BidiFormatter.java */
/* loaded from: classes.dex */
public final class a {
    private final boolean f;
    private final int g;
    private final d h;

    /* renamed from: a  reason: collision with root package name */
    static final d f1552a = e.f1583c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f1555d = Character.toString(8206);

    /* renamed from: e  reason: collision with root package name */
    private static final String f1556e = Character.toString(8207);

    /* renamed from: b  reason: collision with root package name */
    static final a f1553b = new a(false, 2, f1552a);

    /* renamed from: c  reason: collision with root package name */
    static final a f1554c = new a(true, 2, f1552a);

    /* compiled from: BidiFormatter.java */
    /* renamed from: androidx.core.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0035a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1557a;

        /* renamed from: b  reason: collision with root package name */
        private int f1558b;

        /* renamed from: c  reason: collision with root package name */
        private d f1559c;

        public C0035a() {
            a(a.a(Locale.getDefault()));
        }

        private void a(boolean z) {
            this.f1557a = z;
            this.f1559c = a.f1552a;
            this.f1558b = 2;
        }

        private static a b(boolean z) {
            return z ? a.f1554c : a.f1553b;
        }

        public a a() {
            if (this.f1558b == 2 && this.f1559c == a.f1552a) {
                return b(this.f1557a);
            }
            return new a(this.f1557a, this.f1558b, this.f1559c);
        }
    }

    public static a a() {
        return new C0035a().a();
    }

    a(boolean z, int i, d dVar) {
        this.f = z;
        this.g = i;
        this.h = dVar;
    }

    public boolean b() {
        return (this.g & 2) != 0;
    }

    private String a(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        if (this.f || !(a2 || b(charSequence) == 1)) {
            return this.f ? (!a2 || b(charSequence) == -1) ? f1556e : "" : "";
        }
        return f1555d;
    }

    private String b(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        if (this.f || !(a2 || c(charSequence) == 1)) {
            return this.f ? (!a2 || c(charSequence) == -1) ? f1556e : "" : "";
        }
        return f1555d;
    }

    public CharSequence a(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (b() && z) {
            spannableStringBuilder.append((CharSequence) b(charSequence, a2 ? e.f1582b : e.f1581a));
        }
        if (a2 != this.f) {
            spannableStringBuilder.append(a2 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) a(charSequence, a2 ? e.f1582b : e.f1581a));
        }
        return spannableStringBuilder;
    }

    public CharSequence a(CharSequence charSequence) {
        return a(charSequence, this.h, true);
    }

    static boolean a(Locale locale) {
        return f.a(locale) == 1;
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).b();
    }

    private static int c(CharSequence charSequence) {
        return new b(charSequence, false).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BidiFormatter.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f1560a = new byte[1792];

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f1561b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f1562c;

        /* renamed from: d  reason: collision with root package name */
        private final int f1563d;

        /* renamed from: e  reason: collision with root package name */
        private int f1564e;
        private char f;

        static {
            for (int i = 0; i < 1792; i++) {
                f1560a[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.f1561b = charSequence;
            this.f1562c = z;
            this.f1563d = charSequence.length();
        }

        int a() {
            this.f1564e = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f1564e < this.f1563d && i == 0) {
                byte c2 = c();
                if (c2 != 0) {
                    if (c2 == 1 || c2 == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (c2 != 9) {
                        switch (c2) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                break;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                break;
                            case 18:
                                i3--;
                                i2 = 0;
                                break;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f1564e > 0) {
                switch (d()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        int b() {
            this.f1564e = this.f1563d;
            int i = 0;
            int i2 = 0;
            while (this.f1564e > 0) {
                byte d2 = d();
                if (d2 != 0) {
                    if (d2 == 1 || d2 == 2) {
                        if (i == 0) {
                            return 1;
                        }
                        if (i2 == 0) {
                            i2 = i;
                        }
                    } else if (d2 != 9) {
                        switch (d2) {
                            case 14:
                            case 15:
                                if (i2 == i) {
                                    return -1;
                                }
                                i--;
                                break;
                            case 16:
                            case 17:
                                if (i2 == i) {
                                    return 1;
                                }
                                i--;
                                break;
                            case 18:
                                i++;
                                break;
                            default:
                                if (i2 != 0) {
                                    break;
                                } else {
                                    i2 = i;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else if (i == 0) {
                    return -1;
                } else {
                    if (i2 == 0) {
                        i2 = i;
                    }
                }
            }
            return 0;
        }

        private static byte a(char c2) {
            return c2 < 1792 ? f1560a[c2] : Character.getDirectionality(c2);
        }

        byte c() {
            char charAt = this.f1561b.charAt(this.f1564e);
            this.f = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f1561b, this.f1564e);
                this.f1564e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f1564e++;
            byte a2 = a(this.f);
            if (this.f1562c) {
                char c2 = this.f;
                if (c2 == '<') {
                    return e();
                }
                return c2 == '&' ? g() : a2;
            }
            return a2;
        }

        byte d() {
            char charAt = this.f1561b.charAt(this.f1564e - 1);
            this.f = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f1561b, this.f1564e);
                this.f1564e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f1564e--;
            byte a2 = a(this.f);
            if (this.f1562c) {
                char c2 = this.f;
                if (c2 == '>') {
                    return f();
                }
                return c2 == ';' ? h() : a2;
            }
            return a2;
        }

        private byte e() {
            char charAt;
            int i = this.f1564e;
            while (true) {
                int i2 = this.f1564e;
                if (i2 < this.f1563d) {
                    CharSequence charSequence = this.f1561b;
                    this.f1564e = i2 + 1;
                    char charAt2 = charSequence.charAt(i2);
                    this.f = charAt2;
                    if (charAt2 == '>') {
                        return (byte) 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        char c2 = this.f;
                        do {
                            int i3 = this.f1564e;
                            if (i3 < this.f1563d) {
                                CharSequence charSequence2 = this.f1561b;
                                this.f1564e = i3 + 1;
                                charAt = charSequence2.charAt(i3);
                                this.f = charAt;
                            }
                        } while (charAt != c2);
                    }
                } else {
                    this.f1564e = i;
                    this.f = '<';
                    return bz.k;
                }
            }
        }

        private byte f() {
            char charAt;
            int i = this.f1564e;
            while (true) {
                int i2 = this.f1564e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1561b;
                int i3 = i2 - 1;
                this.f1564e = i3;
                char charAt2 = charSequence.charAt(i3);
                this.f = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    char c2 = this.f;
                    do {
                        int i4 = this.f1564e;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.f1561b;
                            int i5 = i4 - 1;
                            this.f1564e = i5;
                            charAt = charSequence2.charAt(i5);
                            this.f = charAt;
                        }
                    } while (charAt != c2);
                }
            }
            this.f1564e = i;
            this.f = '>';
            return bz.k;
        }

        private byte g() {
            char charAt;
            do {
                int i = this.f1564e;
                if (i >= this.f1563d) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f1561b;
                this.f1564e = i + 1;
                charAt = charSequence.charAt(i);
                this.f = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i = this.f1564e;
            do {
                int i2 = this.f1564e;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1561b;
                int i3 = i2 - 1;
                this.f1564e = i3;
                charAt = charSequence.charAt(i3);
                this.f = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f1564e = i;
            this.f = ';';
            return bz.k;
        }
    }
}
