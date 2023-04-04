package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* compiled from: PropertyValuesHolderUtils.java */
/* loaded from: classes.dex */
class s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
        }
        return PropertyValuesHolder.ofFloat(new q(property, path), 0.0f, 1.0f);
    }
}
