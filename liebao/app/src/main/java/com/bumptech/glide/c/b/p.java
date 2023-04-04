package com.bumptech.glide.c.b;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: GlideException.java */
/* loaded from: classes.dex */
public final class p extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private static final StackTraceElement[] f4848a = new StackTraceElement[0];

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f4849b;

    /* renamed from: c  reason: collision with root package name */
    private com.bumptech.glide.c.h f4850c;

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.c.a f4851d;

    /* renamed from: e  reason: collision with root package name */
    private Class<?> f4852e;
    private String f;

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public p(String str) {
        this(str, Collections.emptyList());
    }

    public p(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    public p(String str, List<Throwable> list) {
        this.f = str;
        setStackTrace(f4848a);
        this.f4849b = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.c.h hVar, com.bumptech.glide.c.a aVar) {
        a(hVar, aVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bumptech.glide.c.h hVar, com.bumptech.glide.c.a aVar, Class<?> cls) {
        this.f4850c = hVar;
        this.f4851d = aVar;
        this.f4852e = cls;
    }

    public List<Throwable> a() {
        return this.f4849b;
    }

    public List<Throwable> b() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public void a(String str) {
        List<Throwable> b2 = b();
        int size = b2.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), b2.get(i));
            i = i2;
        }
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof p) {
            for (Throwable th2 : ((p) th).a()) {
                a(th2, list);
            }
            return;
        }
        list.add(th);
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(printWriter);
    }

    private void a(Appendable appendable) {
        a(this, appendable);
        a(a(), new a(appendable));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f);
        sb.append(this.f4852e != null ? ", " + this.f4852e : "");
        sb.append(this.f4851d != null ? ", " + this.f4851d : "");
        sb.append(this.f4850c != null ? ", " + this.f4850c : "");
        List<Throwable> b2 = b();
        if (b2.isEmpty()) {
            return sb.toString();
        }
        if (b2.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(b2.size());
            sb.append(" causes:");
        }
        for (Throwable th : b2) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    private static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof p) {
                ((p) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlideException.java */
    /* loaded from: classes.dex */
    public static final class a implements Appendable {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f4853a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4854b = true;

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        a(Appendable appendable) {
            this.f4853a = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c2) {
            if (this.f4854b) {
                this.f4854b = false;
                this.f4853a.append("  ");
            }
            this.f4854b = c2 == '\n';
            this.f4853a.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            CharSequence a2 = a(charSequence);
            return append(a2, 0, a2.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) {
            CharSequence a2 = a(charSequence);
            boolean z = false;
            if (this.f4854b) {
                this.f4854b = false;
                this.f4853a.append("  ");
            }
            if (a2.length() > 0 && a2.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.f4854b = z;
            this.f4853a.append(a2, i, i2);
            return this;
        }
    }
}
