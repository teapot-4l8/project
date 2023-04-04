package com.trello.rxlifecycle3.a;

import b.b.d.e;
import com.trello.rxlifecycle3.d;

/* compiled from: RxLifecycleAndroid.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final e<a, a> f6297a = new e<a, a>() { // from class: com.trello.rxlifecycle3.a.c.1
        @Override // b.b.d.e
        public a a(a aVar) {
            switch (AnonymousClass3.f6299a[aVar.ordinal()]) {
                case 1:
                    return a.DESTROY;
                case 2:
                    return a.STOP;
                case 3:
                    return a.PAUSE;
                case 4:
                    return a.STOP;
                case 5:
                    return a.DESTROY;
                case 6:
                    throw new com.trello.rxlifecycle3.c("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + aVar + " not yet implemented");
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final e<b, b> f6298b = new e<b, b>() { // from class: com.trello.rxlifecycle3.a.c.2
        @Override // b.b.d.e
        public b a(b bVar) {
            switch (AnonymousClass3.f6300b[bVar.ordinal()]) {
                case 1:
                    return b.DETACH;
                case 2:
                    return b.DESTROY;
                case 3:
                    return b.DESTROY_VIEW;
                case 4:
                    return b.STOP;
                case 5:
                    return b.PAUSE;
                case 6:
                    return b.STOP;
                case 7:
                    return b.DESTROY_VIEW;
                case 8:
                    return b.DESTROY;
                case 9:
                    return b.DETACH;
                case 10:
                    throw new com.trello.rxlifecycle3.c("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + bVar + " not yet implemented");
            }
        }
    };

    public static <T> com.trello.rxlifecycle3.b<T> a(b.b.e<a> eVar) {
        return d.a(eVar, f6297a);
    }

    public static <T> com.trello.rxlifecycle3.b<T> b(b.b.e<b> eVar) {
        return d.a(eVar, f6298b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RxLifecycleAndroid.java */
    /* renamed from: com.trello.rxlifecycle3.a.c$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6299a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f6300b;

        static {
            int[] iArr = new int[b.values().length];
            f6300b = iArr;
            try {
                iArr[b.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6300b[b.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6300b[b.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6300b[b.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6300b[b.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6300b[b.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6300b[b.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6300b[b.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6300b[b.DESTROY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6300b[b.DETACH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[a.values().length];
            f6299a = iArr2;
            try {
                iArr2[a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6299a[a.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6299a[a.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6299a[a.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6299a[a.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6299a[a.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }
}
