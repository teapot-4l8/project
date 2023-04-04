package cn.bingoogolapple.qrcode.zxing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import cn.bingoogolapple.qrcode.core.b;
import cn.bingoogolapple.qrcode.core.f;
import cn.bingoogolapple.qrcode.core.h;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import java.util.Map;

/* loaded from: classes.dex */
public class ZXingView extends f {
    private MultiFormatReader i;
    private Map<DecodeHintType, Object> j;

    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZXingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // cn.bingoogolapple.qrcode.core.f
    protected void a() {
        this.i = new MultiFormatReader();
        if (this.h == b.ONE_DIMENSION) {
            this.i.setHints(a.f3635b);
        } else if (this.h == b.TWO_DIMENSION) {
            this.i.setHints(a.f3636c);
        } else if (this.h == b.ONLY_QR_CODE) {
            this.i.setHints(a.f3637d);
        } else if (this.h == b.ONLY_CODE_128) {
            this.i.setHints(a.f3638e);
        } else if (this.h == b.ONLY_EAN_13) {
            this.i.setHints(a.f);
        } else if (this.h == b.HIGH_FREQUENCY) {
            this.i.setHints(a.g);
        } else if (this.h == b.CUSTOM) {
            this.i.setHints(this.j);
        } else {
            this.i.setHints(a.f3634a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bingoogolapple.qrcode.core.f
    public h a(Bitmap bitmap) {
        return new h(a.a(bitmap));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    @Override // cn.bingoogolapple.qrcode.core.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h a(byte[] bArr, int i, int i2, boolean z) {
        Result result;
        Rect rect;
        PlanarYUVLuminanceSource planarYUVLuminanceSource;
        try {
            try {
                rect = this.f3615c.a(i2);
                try {
                    if (rect != null) {
                        planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, rect.left, rect.top, rect.width(), rect.height(), false);
                    } else {
                        planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
                    }
                    result = this.i.decodeWithState(new BinaryBitmap(new GlobalHistogramBinarizer(planarYUVLuminanceSource)));
                    if (result == null) {
                        try {
                            result = this.i.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)));
                            if (result != null) {
                                cn.bingoogolapple.qrcode.core.a.a("GlobalHistogramBinarizer 没识别到，HybridBinarizer 能识别到");
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            if (result != null) {
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    result = null;
                }
            } finally {
                this.i.reset();
            }
        } catch (Exception e4) {
            e = e4;
            result = null;
            rect = null;
        }
        if (result != null) {
            return null;
        }
        String text = result.getText();
        if (TextUtils.isEmpty(text)) {
            return null;
        }
        BarcodeFormat barcodeFormat = result.getBarcodeFormat();
        cn.bingoogolapple.qrcode.core.a.a("格式为：" + barcodeFormat.name());
        boolean a2 = a(barcodeFormat);
        if (k() || a2) {
            ResultPoint[] resultPoints = result.getResultPoints();
            PointF[] pointFArr = new PointF[resultPoints.length];
            int i3 = 0;
            for (ResultPoint resultPoint : resultPoints) {
                pointFArr[i3] = new PointF(resultPoint.getX(), resultPoint.getY());
                i3++;
            }
            if (a(pointFArr, rect, a2, text)) {
                return null;
            }
        }
        return new h(text);
    }

    private boolean a(BarcodeFormat barcodeFormat) {
        return l() && barcodeFormat == BarcodeFormat.QR_CODE;
    }
}
