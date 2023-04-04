package androidx.core.g;

import android.os.Build;
import java.util.Arrays;

/* compiled from: ObjectsCompat.java */
/* loaded from: classes.dex */
public class c {
    public static boolean a(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return C$r8$backportedMethods$utility$Objects$2$equals.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int a(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Arrays.hashCode(objArr);
        }
        return Arrays.hashCode(objArr);
    }
}
