package androidx.core.d;

/* compiled from: OperationCanceledException.java */
/* loaded from: classes.dex */
public class c extends RuntimeException {
    public c() {
        this(null);
    }

    public c(String str) {
        super(str == null ? "The operation has been canceled." : str);
    }
}
