package kotlin.e;

import java.util.Random;
import kotlin.d.b.i;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes2.dex */
public final class b extends kotlin.e.a {

    /* renamed from: c  reason: collision with root package name */
    private final a f7164c = new a();

    /* compiled from: PlatformRandom.kt */
    /* loaded from: classes2.dex */
    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // kotlin.e.a
    public Random a() {
        Random random = this.f7164c.get();
        i.a((Object) random, "implStorage.get()");
        return random;
    }
}
