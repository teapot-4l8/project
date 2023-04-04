package q.rorbin.badgeview;

import android.graphics.PointF;
import java.util.List;

/* compiled from: MathUtil.java */
/* loaded from: classes2.dex */
public class d {
    public static double a(double d2) {
        return (d2 / 6.283185307179586d) * 360.0d;
    }

    public static double a(double d2, int i) {
        if (d2 < 0.0d) {
            d2 += 1.5707963267948966d;
        }
        double d3 = i - 1;
        Double.isNaN(d3);
        return d2 + (d3 * 1.5707963267948966d);
    }

    public static int a(PointF pointF, PointF pointF2) {
        if (pointF.x > pointF2.x) {
            if (pointF.y > pointF2.y) {
                return 4;
            }
            return pointF.y < pointF2.y ? 1 : -1;
        } else if (pointF.x < pointF2.x) {
            if (pointF.y > pointF2.y) {
                return 3;
            }
            return pointF.y < pointF2.y ? 2 : -1;
        } else {
            return -1;
        }
    }

    public static float b(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }

    public static void a(PointF pointF, float f, Double d2, List<PointF> list) {
        float f2;
        if (d2 != null) {
            double atan = (float) Math.atan(d2.doubleValue());
            double cos = Math.cos(atan);
            double d3 = f;
            Double.isNaN(d3);
            double sin = Math.sin(atan);
            Double.isNaN(d3);
            f2 = (float) (sin * d3);
            f = (float) (cos * d3);
        } else {
            f2 = 0.0f;
        }
        list.add(new PointF(pointF.x + f, pointF.y + f2));
        list.add(new PointF(pointF.x - f, pointF.y - f2));
    }
}
