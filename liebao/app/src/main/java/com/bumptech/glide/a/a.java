package com.bumptech.glide.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final File f4571b;

    /* renamed from: c  reason: collision with root package name */
    private final File f4572c;

    /* renamed from: d  reason: collision with root package name */
    private final File f4573d;

    /* renamed from: e  reason: collision with root package name */
    private final File f4574e;
    private final int f;
    private long g;
    private final int h;
    private Writer j;
    private int l;
    private long i = 0;
    private final LinkedHashMap<String, c> k = new LinkedHashMap<>(0, 0.75f, true);
    private long m = 0;

    /* renamed from: a  reason: collision with root package name */
    final ThreadPoolExecutor f4570a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0083a());
    private final Callable<Void> n = new Callable<Void>() { // from class: com.bumptech.glide.a.a.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            synchronized (a.this) {
                if (a.this.j == null) {
                    return null;
                }
                a.this.g();
                if (a.this.e()) {
                    a.this.d();
                    a.this.l = 0;
                }
                return null;
            }
        }
    };

    private a(File file, int i, int i2, long j) {
        this.f4571b = file;
        this.f = i;
        this.f4572c = new File(file, "journal");
        this.f4573d = new File(file, "journal.tmp");
        this.f4574e = new File(file, "journal.bkp");
        this.h = i2;
        this.g = j;
    }

    public static a a(File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("valueCount <= 0");
            }
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j);
            if (aVar.f4572c.exists()) {
                try {
                    aVar.b();
                    aVar.c();
                    return aVar;
                } catch (IOException e2) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    aVar.a();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i, i2, j);
            aVar2.d();
            return aVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void b() {
        com.bumptech.glide.a.b bVar = new com.bumptech.glide.a.b(new FileInputStream(this.f4572c), com.bumptech.glide.a.c.f4596a);
        try {
            String a2 = bVar.a();
            String a3 = bVar.a();
            String a4 = bVar.a();
            String a5 = bVar.a();
            String a6 = bVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.f).equals(a4) || !Integer.toString(this.h).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(bVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.l = i - this.k.size();
                    if (bVar.b()) {
                        d();
                    } else {
                        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4572c, true), com.bumptech.glide.a.c.f4596a));
                    }
                    com.bumptech.glide.a.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.a.c.a(bVar);
            throw th;
        }
    }

    private void d(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.k.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        c cVar = this.k.get(substring);
        if (cVar == null) {
            cVar = new c(substring);
            this.k.put(substring, cVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            cVar.f = true;
            cVar.g = null;
            cVar.a(split);
        } else if (indexOf2 != -1 || indexOf != 5 || !str.startsWith("DIRTY")) {
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        } else {
            cVar.g = new b(cVar);
        }
    }

    private void c() {
        a(this.f4573d);
        Iterator<c> it = this.k.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i = 0;
            if (next.g == null) {
                while (i < this.h) {
                    this.i += next.f4584e[i];
                    i++;
                }
            } else {
                next.g = null;
                while (i < this.h) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (this.j != null) {
            this.j.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4573d), com.bumptech.glide.a.c.f4596a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.h));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (c cVar : this.k.values()) {
            if (cVar.g != null) {
                bufferedWriter.write("DIRTY " + cVar.f4583d + '\n');
            } else {
                bufferedWriter.write("CLEAN " + cVar.f4583d + cVar.a() + '\n');
            }
        }
        bufferedWriter.close();
        if (this.f4572c.exists()) {
            a(this.f4572c, this.f4574e, true);
        }
        a(this.f4573d, this.f4572c, false);
        this.f4574e.delete();
        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4572c, true), com.bumptech.glide.a.c.f4596a));
    }

    private static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized d a(String str) {
        f();
        c cVar = this.k.get(str);
        if (cVar == null) {
            return null;
        }
        if (cVar.f) {
            for (File file : cVar.f4580a) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.l++;
            this.j.append((CharSequence) "READ");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            if (e()) {
                this.f4570a.submit(this.n);
            }
            return new d(str, cVar.h, cVar.f4580a, cVar.f4584e);
        }
        return null;
    }

    public b b(String str) {
        return a(str, -1L);
    }

    private synchronized b a(String str, long j) {
        f();
        c cVar = this.k.get(str);
        if (j == -1 || (cVar != null && cVar.h == j)) {
            if (cVar == null) {
                cVar = new c(str);
                this.k.put(str, cVar);
            } else if (cVar.g != null) {
                return null;
            }
            b bVar = new b(cVar);
            cVar.g = bVar;
            this.j.append((CharSequence) "DIRTY");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            this.j.flush();
            return bVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b bVar, boolean z) {
        c cVar = bVar.f4577b;
        if (cVar.g != bVar) {
            throw new IllegalStateException();
        }
        if (z && !cVar.f) {
            for (int i = 0; i < this.h; i++) {
                if (!bVar.f4578c[i]) {
                    bVar.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                } else if (!cVar.b(i).exists()) {
                    bVar.b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            File b2 = cVar.b(i2);
            if (z) {
                if (b2.exists()) {
                    File a2 = cVar.a(i2);
                    b2.renameTo(a2);
                    long j = cVar.f4584e[i2];
                    long length = a2.length();
                    cVar.f4584e[i2] = length;
                    this.i = (this.i - j) + length;
                }
            } else {
                a(b2);
            }
        }
        this.l++;
        cVar.g = null;
        if (cVar.f | z) {
            cVar.f = true;
            this.j.append((CharSequence) "CLEAN");
            this.j.append(' ');
            this.j.append((CharSequence) cVar.f4583d);
            this.j.append((CharSequence) cVar.a());
            this.j.append('\n');
            if (z) {
                long j2 = this.m;
                this.m = 1 + j2;
                cVar.h = j2;
            }
        } else {
            this.k.remove(cVar.f4583d);
            this.j.append((CharSequence) "REMOVE");
            this.j.append(' ');
            this.j.append((CharSequence) cVar.f4583d);
            this.j.append('\n');
        }
        this.j.flush();
        if (this.i > this.g || e()) {
            this.f4570a.submit(this.n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int i = this.l;
        return i >= 2000 && i >= this.k.size();
    }

    public synchronized boolean c(String str) {
        f();
        c cVar = this.k.get(str);
        if (cVar != null && cVar.g == null) {
            for (int i = 0; i < this.h; i++) {
                File a2 = cVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.i -= cVar.f4584e[i];
                cVar.f4584e[i] = 0;
            }
            this.l++;
            this.j.append((CharSequence) "REMOVE");
            this.j.append(' ');
            this.j.append((CharSequence) str);
            this.j.append('\n');
            this.k.remove(str);
            if (e()) {
                this.f4570a.submit(this.n);
            }
            return true;
        }
        return false;
    }

    private void f() {
        if (this.j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.j == null) {
            return;
        }
        Iterator it = new ArrayList(this.k.values()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.g != null) {
                cVar.g.b();
            }
        }
        g();
        this.j.close();
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        while (this.i > this.g) {
            c(this.k.entrySet().iterator().next().getKey());
        }
    }

    public void a() {
        close();
        com.bumptech.glide.a.c.a(this.f4571b);
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class d {

        /* renamed from: b  reason: collision with root package name */
        private final String f4586b;

        /* renamed from: c  reason: collision with root package name */
        private final long f4587c;

        /* renamed from: d  reason: collision with root package name */
        private final long[] f4588d;

        /* renamed from: e  reason: collision with root package name */
        private final File[] f4589e;

        private d(String str, long j, File[] fileArr, long[] jArr) {
            this.f4586b = str;
            this.f4587c = j;
            this.f4589e = fileArr;
            this.f4588d = jArr;
        }

        public File a(int i) {
            return this.f4589e[i];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class b {

        /* renamed from: b  reason: collision with root package name */
        private final c f4577b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean[] f4578c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4579d;

        private b(c cVar) {
            this.f4577b = cVar;
            this.f4578c = cVar.f ? null : new boolean[a.this.h];
        }

        public File a(int i) {
            File b2;
            synchronized (a.this) {
                if (this.f4577b.g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f4577b.f) {
                    this.f4578c[i] = true;
                }
                b2 = this.f4577b.b(i);
                if (!a.this.f4571b.exists()) {
                    a.this.f4571b.mkdirs();
                }
            }
            return b2;
        }

        public void a() {
            a.this.a(this, true);
            this.f4579d = true;
        }

        public void b() {
            a.this.a(this, false);
        }

        public void c() {
            if (this.f4579d) {
                return;
            }
            try {
                b();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: a  reason: collision with root package name */
        File[] f4580a;

        /* renamed from: b  reason: collision with root package name */
        File[] f4581b;

        /* renamed from: d  reason: collision with root package name */
        private final String f4583d;

        /* renamed from: e  reason: collision with root package name */
        private final long[] f4584e;
        private boolean f;
        private b g;
        private long h;

        private c(String str) {
            this.f4583d = str;
            this.f4584e = new long[a.this.h];
            this.f4580a = new File[a.this.h];
            this.f4581b = new File[a.this.h];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < a.this.h; i++) {
                sb.append(i);
                this.f4580a[i] = new File(a.this.f4571b, sb.toString());
                sb.append(".tmp");
                this.f4581b[i] = new File(a.this.f4571b, sb.toString());
                sb.setLength(length);
            }
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.f4584e) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String[] strArr) {
            if (strArr.length != a.this.h) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f4584e[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.f4580a[i];
        }

        public File b(int i) {
            return this.f4581b[i];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class ThreadFactoryC0083a implements ThreadFactory {
        private ThreadFactoryC0083a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }
}
