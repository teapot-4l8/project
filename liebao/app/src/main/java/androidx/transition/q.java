package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PathProperty.java */
/* loaded from: classes.dex */
class q<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f2649a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f2650b;

    /* renamed from: c  reason: collision with root package name */
    private final float f2651c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f2652d;

    /* renamed from: e  reason: collision with root package name */
    private final PointF f2653e;
    private float f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f2652d = new float[2];
        this.f2653e = new PointF();
        this.f2649a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f2650b = pathMeasure;
        this.f2651c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(T t, Float f) {
        this.f = f.floatValue();
        this.f2650b.getPosTan(this.f2651c * f.floatValue(), this.f2652d, null);
        this.f2653e.x = this.f2652d[0];
        this.f2653e.y = this.f2652d[1];
        this.f2649a.set(t, this.f2653e);
    }
}
