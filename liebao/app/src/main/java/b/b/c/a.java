package b.b.c;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* compiled from: CompositeException.java */
/* loaded from: classes.dex */
public final class a extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private final List<Throwable> f3284a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3285b;

    /* renamed from: c  reason: collision with root package name */
    private Throwable f3286c;

    public a(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public a(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof a) {
                    linkedHashSet.addAll(((a) th).a());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (linkedHashSet.isEmpty()) {
            throw new IllegalArgumentException("errors is empty");
        }
        arrayList.addAll(linkedHashSet);
        this.f3284a = Collections.unmodifiableList(arrayList);
        this.f3285b = this.f3284a.size() + " exceptions occurred. ";
    }

    public List<Throwable> a() {
        return this.f3284a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f3285b;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        if (this.f3286c == null) {
            C0069a c0069a = new C0069a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.f3284a.iterator();
            C0069a c0069a2 = c0069a;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th : b(next)) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        c0069a2.initCause(next);
                    } catch (Throwable unused) {
                    }
                    c0069a2 = a(c0069a2);
                }
            }
            this.f3286c = c0069a;
        }
        return this.f3286c;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(new d(printWriter));
    }

    private void a(b bVar) {
        StackTraceElement[] stackTrace;
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.f3284a) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            a(sb, th, "\t");
            i++;
        }
        bVar.a(sb.toString());
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        StackTraceElement[] stackTrace;
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompositeException.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        abstract void a(Object obj);

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CompositeException.java */
    /* loaded from: classes.dex */
    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private final PrintStream f3287a;

        c(PrintStream printStream) {
            this.f3287a = printStream;
        }

        @Override // b.b.c.a.b
        void a(Object obj) {
            this.f3287a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    /* loaded from: classes.dex */
    static final class d extends b {

        /* renamed from: a  reason: collision with root package name */
        private final PrintWriter f3288a;

        d(PrintWriter printWriter) {
            this.f3288a = printWriter;
        }

        @Override // b.b.c.a.b
        void a(Object obj) {
            this.f3288a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    /* renamed from: b.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0069a extends RuntimeException {
        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }

        C0069a() {
        }
    }

    private List<Throwable> b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }

    Throwable a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.f3286c == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }
}
