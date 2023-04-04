package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TransitionValues.java */
/* loaded from: classes.dex */
public class ac {

    /* renamed from: b  reason: collision with root package name */
    public View f2510b;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f2509a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<w> f2511c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (obj instanceof ac) {
            ac acVar = (ac) obj;
            return this.f2510b == acVar.f2510b && this.f2509a.equals(acVar.f2509a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f2510b.hashCode() * 31) + this.f2509a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2510b + "\n") + "    values:";
        for (String str2 : this.f2509a.keySet()) {
            str = str + "    " + str2 + ": " + this.f2509a.get(str2) + "\n";
        }
        return str;
    }
}
