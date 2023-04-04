package androidx.core.f;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class c implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1567a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Executor f1568b = null;

    /* renamed from: c  reason: collision with root package name */
    private final Spannable f1569c;

    /* renamed from: d  reason: collision with root package name */
    private final a f1570d;

    /* renamed from: e  reason: collision with root package name */
    private final PrecomputedText f1571e;

    /* compiled from: PrecomputedTextCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final PrecomputedText.Params f1572a;

        /* renamed from: b  reason: collision with root package name */
        private final TextPaint f1573b;

        /* renamed from: c  reason: collision with root package name */
        private final TextDirectionHeuristic f1574c;

        /* renamed from: d  reason: collision with root package name */
        private final int f1575d;

        /* renamed from: e  reason: collision with root package name */
        private final int f1576e;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: androidx.core.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0036a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f1577a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f1578b;

            /* renamed from: c  reason: collision with root package name */
            private int f1579c;

            /* renamed from: d  reason: collision with root package name */
            private int f1580d;

            public C0036a(TextPaint textPaint) {
                this.f1577a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f1579c = 1;
                    this.f1580d = 1;
                } else {
                    this.f1580d = 0;
                    this.f1579c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f1578b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f1578b = null;
                }
            }

            public C0036a a(int i) {
                this.f1579c = i;
                return this;
            }

            public C0036a b(int i) {
                this.f1580d = i;
                return this;
            }

            public C0036a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f1578b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f1577a, this.f1578b, this.f1579c, this.f1580d);
            }
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f1572a = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f1572a = null;
            }
            this.f1573b = textPaint;
            this.f1574c = textDirectionHeuristic;
            this.f1575d = i;
            this.f1576e = i2;
        }

        public a(PrecomputedText.Params params) {
            this.f1573b = params.getTextPaint();
            this.f1574c = params.getTextDirection();
            this.f1575d = params.getBreakStrategy();
            this.f1576e = params.getHyphenationFrequency();
            this.f1572a = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public TextPaint a() {
            return this.f1573b;
        }

        public TextDirectionHeuristic b() {
            return this.f1574c;
        }

        public int c() {
            return this.f1575d;
        }

        public int d() {
            return this.f1576e;
        }

        public boolean a(a aVar) {
            if ((Build.VERSION.SDK_INT < 23 || (this.f1575d == aVar.c() && this.f1576e == aVar.d())) && this.f1573b.getTextSize() == aVar.a().getTextSize() && this.f1573b.getTextScaleX() == aVar.a().getTextScaleX() && this.f1573b.getTextSkewX() == aVar.a().getTextSkewX()) {
                if ((Build.VERSION.SDK_INT < 21 || (this.f1573b.getLetterSpacing() == aVar.a().getLetterSpacing() && TextUtils.equals(this.f1573b.getFontFeatureSettings(), aVar.a().getFontFeatureSettings()))) && this.f1573b.getFlags() == aVar.a().getFlags()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        if (!this.f1573b.getTextLocales().equals(aVar.a().getTextLocales())) {
                            return false;
                        }
                    } else if (Build.VERSION.SDK_INT >= 17 && !this.f1573b.getTextLocale().equals(aVar.a().getTextLocale())) {
                        return false;
                    }
                    return this.f1573b.getTypeface() == null ? aVar.a().getTypeface() == null : this.f1573b.getTypeface().equals(aVar.a().getTypeface());
                }
                return false;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (a(aVar)) {
                    return Build.VERSION.SDK_INT < 18 || this.f1574c == aVar.b();
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return androidx.core.g.c.a(Float.valueOf(this.f1573b.getTextSize()), Float.valueOf(this.f1573b.getTextScaleX()), Float.valueOf(this.f1573b.getTextSkewX()), Float.valueOf(this.f1573b.getLetterSpacing()), Integer.valueOf(this.f1573b.getFlags()), this.f1573b.getTextLocales(), this.f1573b.getTypeface(), Boolean.valueOf(this.f1573b.isElegantTextHeight()), this.f1574c, Integer.valueOf(this.f1575d), Integer.valueOf(this.f1576e));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return androidx.core.g.c.a(Float.valueOf(this.f1573b.getTextSize()), Float.valueOf(this.f1573b.getTextScaleX()), Float.valueOf(this.f1573b.getTextSkewX()), Float.valueOf(this.f1573b.getLetterSpacing()), Integer.valueOf(this.f1573b.getFlags()), this.f1573b.getTextLocale(), this.f1573b.getTypeface(), Boolean.valueOf(this.f1573b.isElegantTextHeight()), this.f1574c, Integer.valueOf(this.f1575d), Integer.valueOf(this.f1576e));
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return androidx.core.g.c.a(Float.valueOf(this.f1573b.getTextSize()), Float.valueOf(this.f1573b.getTextScaleX()), Float.valueOf(this.f1573b.getTextSkewX()), Integer.valueOf(this.f1573b.getFlags()), this.f1573b.getTextLocale(), this.f1573b.getTypeface(), this.f1574c, Integer.valueOf(this.f1575d), Integer.valueOf(this.f1576e));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                return androidx.core.g.c.a(Float.valueOf(this.f1573b.getTextSize()), Float.valueOf(this.f1573b.getTextScaleX()), Float.valueOf(this.f1573b.getTextSkewX()), Integer.valueOf(this.f1573b.getFlags()), this.f1573b.getTextLocale(), this.f1573b.getTypeface(), this.f1574c, Integer.valueOf(this.f1575d), Integer.valueOf(this.f1576e));
            }
            return androidx.core.g.c.a(Float.valueOf(this.f1573b.getTextSize()), Float.valueOf(this.f1573b.getTextScaleX()), Float.valueOf(this.f1573b.getTextSkewX()), Integer.valueOf(this.f1573b.getFlags()), this.f1573b.getTypeface(), this.f1574c, Integer.valueOf(this.f1575d), Integer.valueOf(this.f1576e));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f1573b.getTextSize());
            sb.append(", textScaleX=" + this.f1573b.getTextScaleX());
            sb.append(", textSkewX=" + this.f1573b.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f1573b.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f1573b.isElegantTextHeight());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                sb.append(", textLocale=" + this.f1573b.getTextLocales());
            } else if (Build.VERSION.SDK_INT >= 17) {
                sb.append(", textLocale=" + this.f1573b.getTextLocale());
            }
            sb.append(", typeface=" + this.f1573b.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f1573b.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f1574c);
            sb.append(", breakStrategy=" + this.f1575d);
            sb.append(", hyphenationFrequency=" + this.f1576e);
            sb.append("}");
            return sb.toString();
        }
    }

    public PrecomputedText a() {
        Spannable spannable = this.f1569c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public a b() {
        return this.f1570d;
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1571e.setSpan(obj, i, i2, i3);
        } else {
            this.f1569c.setSpan(obj, i, i2, i3);
        }
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1571e.removeSpan(obj);
        } else {
            this.f1569c.removeSpan(obj);
        }
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return (T[]) this.f1571e.getSpans(i, i2, cls);
        }
        return (T[]) this.f1569c.getSpans(i, i2, cls);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f1569c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f1569c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f1569c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f1569c.nextSpanTransition(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f1569c.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f1569c.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f1569c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f1569c.toString();
    }
}
