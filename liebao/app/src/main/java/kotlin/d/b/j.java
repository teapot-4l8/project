package kotlin.d.b;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* loaded from: classes2.dex */
public abstract class j<R> implements Serializable, h<R> {

    /* renamed from: a  reason: collision with root package name */
    private final int f7157a;

    public j(int i) {
        this.f7157a = i;
    }

    public String toString() {
        String a2 = o.a(this);
        i.a((Object) a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
