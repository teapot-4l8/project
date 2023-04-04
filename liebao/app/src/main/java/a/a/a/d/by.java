package a.a.a.d;

/* compiled from: RelativeNameException.java */
/* loaded from: classes.dex */
public class by extends IllegalArgumentException {
    public by(bj bjVar) {
        super("'" + bjVar + "' is not an absolute name");
    }

    public by(String str) {
        super(str);
    }
}
