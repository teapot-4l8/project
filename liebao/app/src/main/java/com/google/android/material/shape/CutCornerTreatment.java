package com.google.android.material.shape;

/* loaded from: classes.dex */
public class CutCornerTreatment extends CornerTreatment {
    private final float size;

    public CutCornerTreatment(float f) {
        this.size = f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(float f, float f2, ShapePath shapePath) {
        shapePath.reset(0.0f, this.size * f2);
        double d2 = f;
        double sin = Math.sin(d2);
        double d3 = this.size;
        Double.isNaN(d3);
        double d4 = f2;
        Double.isNaN(d4);
        double cos = Math.cos(d2);
        double d5 = this.size;
        Double.isNaN(d5);
        Double.isNaN(d4);
        shapePath.lineTo((float) (sin * d3 * d4), (float) (cos * d5 * d4));
    }
}
