package okhttp3.internal.f;

import c.l;
import c.r;
import c.s;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: FileSystem.java */
/* loaded from: classes2.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7633a = new a() { // from class: okhttp3.internal.f.a.1
        @Override // okhttp3.internal.f.a
        public s a(File file) {
            return l.a(file);
        }

        @Override // okhttp3.internal.f.a
        public r b(File file) {
            try {
                return l.b(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return l.b(file);
            }
        }

        @Override // okhttp3.internal.f.a
        public r c(File file) {
            try {
                return l.c(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return l.c(file);
            }
        }

        @Override // okhttp3.internal.f.a
        public void d(File file) {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.f.a
        public boolean e(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.f.a
        public long f(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.f.a
        public void a(File file, File file2) {
            d(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // okhttp3.internal.f.a
        public void g(File file) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    g(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }
    };

    s a(File file);

    void a(File file, File file2);

    r b(File file);

    r c(File file);

    void d(File file);

    boolean e(File file);

    long f(File file);

    void g(File file);
}
