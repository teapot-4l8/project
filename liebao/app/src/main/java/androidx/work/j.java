package androidx.work;

import android.os.Build;
import androidx.work.o;

/* compiled from: OneTimeWorkRequest.java */
/* loaded from: classes.dex */
public final class j extends o {
    j(a aVar) {
        super(aVar.f3084b, aVar.f3085c, aVar.f3086d);
    }

    /* compiled from: OneTimeWorkRequest.java */
    /* loaded from: classes.dex */
    public static final class a extends o.a<a, j> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.o.a
        /* renamed from: b */
        public a c() {
            return this;
        }

        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f3085c.f2867d = OverwritingInputMerger.class.getName();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.o.a
        /* renamed from: a */
        public j d() {
            if (this.f3083a && Build.VERSION.SDK_INT >= 23 && this.f3085c.j.c()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new j(this);
        }
    }
}
