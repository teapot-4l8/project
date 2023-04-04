package kotlin.e;

import java.util.Random;

/* compiled from: PlatformRandom.kt */
/* loaded from: classes2.dex */
public abstract class a extends c {
    public abstract Random a();

    @Override // kotlin.e.c
    public int a(int i) {
        return d.a(a().nextInt(), i);
    }

    @Override // kotlin.e.c
    public int b() {
        return a().nextInt();
    }
}
