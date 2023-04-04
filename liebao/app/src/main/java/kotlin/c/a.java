package kotlin.c;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.d.b.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReadWrite.kt */
/* loaded from: classes2.dex */
public final class a implements kotlin.g.b<String> {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedReader f7145a;

    public a(BufferedReader bufferedReader) {
        i.b(bufferedReader, "reader");
        this.f7145a = bufferedReader;
    }

    /* compiled from: ReadWrite.kt */
    /* renamed from: kotlin.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0181a implements Iterator<String> {

        /* renamed from: b  reason: collision with root package name */
        private String f7147b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7148c;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C0181a() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f7147b == null && !this.f7148c) {
                String readLine = a.this.f7145a.readLine();
                this.f7147b = readLine;
                if (readLine == null) {
                    this.f7148c = true;
                }
            }
            return this.f7147b != null;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f7147b;
            this.f7147b = null;
            if (str == null) {
                i.a();
            }
            return str;
        }
    }

    @Override // kotlin.g.b
    public Iterator<String> a() {
        return new C0181a();
    }
}
