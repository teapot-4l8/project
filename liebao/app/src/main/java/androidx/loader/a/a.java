package androidx.loader.a;

import androidx.lifecycle.ab;
import androidx.lifecycle.l;
import androidx.loader.b.c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: LoaderManager.java */
    /* renamed from: androidx.loader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047a<D> {
        void a(c<D> cVar);

        void a(c<D> cVar, D d2);
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public static <T extends l & ab> a a(T t) {
        return new b(t, t.getViewModelStore());
    }
}
