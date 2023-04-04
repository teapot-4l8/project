package androidx.lifecycle;

import androidx.lifecycle.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements j {

    /* renamed from: a  reason: collision with root package name */
    private final e f1979a;

    /* renamed from: b  reason: collision with root package name */
    private final j f1980b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(e eVar, j jVar) {
        this.f1979a = eVar;
        this.f1980b = jVar;
    }

    /* renamed from: androidx.lifecycle.FullLifecycleObserverAdapter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1981a;

        static {
            int[] iArr = new int[h.a.values().length];
            f1981a = iArr;
            try {
                iArr[h.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1981a[h.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1981a[h.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1981a[h.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1981a[h.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1981a[h.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1981a[h.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // androidx.lifecycle.j
    public void onStateChanged(l lVar, h.a aVar) {
        switch (AnonymousClass1.f1981a[aVar.ordinal()]) {
            case 1:
                this.f1979a.a(lVar);
                break;
            case 2:
                this.f1979a.b(lVar);
                break;
            case 3:
                this.f1979a.c(lVar);
                break;
            case 4:
                this.f1979a.d(lVar);
                break;
            case 5:
                this.f1979a.e(lVar);
                break;
            case 6:
                this.f1979a.f(lVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        j jVar = this.f1980b;
        if (jVar != null) {
            jVar.onStateChanged(lVar, aVar);
        }
    }
}
