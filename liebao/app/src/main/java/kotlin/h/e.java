package kotlin.h;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes2.dex */
public final class e implements kotlin.g.b<kotlin.f.c> {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f7195a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7196b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7197c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.d.a.c<CharSequence, Integer, kotlin.f<Integer, Integer>> f7198d;

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence charSequence, int i, int i2, kotlin.d.a.c<? super CharSequence, ? super Integer, kotlin.f<Integer, Integer>> cVar) {
        kotlin.d.b.i.b(charSequence, "input");
        kotlin.d.b.i.b(cVar, "getNextMatch");
        this.f7195a = charSequence;
        this.f7196b = i;
        this.f7197c = i2;
        this.f7198d = cVar;
    }

    /* compiled from: Strings.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Iterator<kotlin.f.c> {

        /* renamed from: b  reason: collision with root package name */
        private int f7200b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f7201c;

        /* renamed from: d  reason: collision with root package name */
        private int f7202d;

        /* renamed from: e  reason: collision with root package name */
        private kotlin.f.c f7203e;
        private int f;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a() {
            int a2 = kotlin.f.d.a(e.this.f7196b, 0, e.this.f7195a.length());
            this.f7201c = a2;
            this.f7202d = a2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
            if (r0 < r6.f7199a.f7197c) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void b() {
            if (this.f7202d >= 0) {
                if (e.this.f7197c > 0) {
                    int i = this.f + 1;
                    this.f = i;
                }
                if (this.f7202d <= e.this.f7195a.length()) {
                    kotlin.f fVar = (kotlin.f) e.this.f7198d.a(e.this.f7195a, Integer.valueOf(this.f7202d));
                    if (fVar == null) {
                        this.f7203e = new kotlin.f.c(this.f7201c, g.b(e.this.f7195a));
                        this.f7202d = -1;
                    } else {
                        int intValue = ((Number) fVar.c()).intValue();
                        int intValue2 = ((Number) fVar.d()).intValue();
                        this.f7203e = kotlin.f.d.b(this.f7201c, intValue);
                        int i2 = intValue + intValue2;
                        this.f7201c = i2;
                        this.f7202d = i2 + (intValue2 == 0 ? 1 : 0);
                    }
                    this.f7200b = 1;
                    return;
                }
                this.f7203e = new kotlin.f.c(this.f7201c, g.b(e.this.f7195a));
                this.f7202d = -1;
                this.f7200b = 1;
                return;
            }
            this.f7200b = 0;
            this.f7203e = null;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public kotlin.f.c next() {
            if (this.f7200b == -1) {
                b();
            }
            if (this.f7200b == 0) {
                throw new NoSuchElementException();
            }
            kotlin.f.c cVar = this.f7203e;
            if (cVar == null) {
                throw new kotlin.i("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.f7203e = null;
            this.f7200b = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f7200b == -1) {
                b();
            }
            return this.f7200b == 1;
        }
    }

    @Override // kotlin.g.b
    public Iterator<kotlin.f.c> a() {
        return new a();
    }
}
