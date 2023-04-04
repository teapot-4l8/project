package cn.bingoogolapple.qrcode.zxing;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: QRCodeDecoder.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static final Map<DecodeHintType, Object> f3634a = new EnumMap(DecodeHintType.class);

    /* renamed from: b  reason: collision with root package name */
    static final Map<DecodeHintType, Object> f3635b;

    /* renamed from: c  reason: collision with root package name */
    static final Map<DecodeHintType, Object> f3636c;

    /* renamed from: d  reason: collision with root package name */
    static final Map<DecodeHintType, Object> f3637d;

    /* renamed from: e  reason: collision with root package name */
    static final Map<DecodeHintType, Object> f3638e;
    static final Map<DecodeHintType, Object> f;
    static final Map<DecodeHintType, Object> g;

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.AZTEC);
        arrayList.add(BarcodeFormat.CODABAR);
        arrayList.add(BarcodeFormat.CODE_39);
        arrayList.add(BarcodeFormat.CODE_93);
        arrayList.add(BarcodeFormat.CODE_128);
        arrayList.add(BarcodeFormat.DATA_MATRIX);
        arrayList.add(BarcodeFormat.EAN_8);
        arrayList.add(BarcodeFormat.EAN_13);
        arrayList.add(BarcodeFormat.ITF);
        arrayList.add(BarcodeFormat.MAXICODE);
        arrayList.add(BarcodeFormat.PDF_417);
        arrayList.add(BarcodeFormat.QR_CODE);
        arrayList.add(BarcodeFormat.RSS_14);
        arrayList.add(BarcodeFormat.RSS_EXPANDED);
        arrayList.add(BarcodeFormat.UPC_A);
        arrayList.add(BarcodeFormat.UPC_E);
        arrayList.add(BarcodeFormat.UPC_EAN_EXTENSION);
        f3634a.put(DecodeHintType.POSSIBLE_FORMATS, arrayList);
        f3634a.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f3634a.put(DecodeHintType.CHARACTER_SET, "utf-8");
        f3635b = new EnumMap(DecodeHintType.class);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(BarcodeFormat.CODABAR);
        arrayList2.add(BarcodeFormat.CODE_39);
        arrayList2.add(BarcodeFormat.CODE_93);
        arrayList2.add(BarcodeFormat.CODE_128);
        arrayList2.add(BarcodeFormat.EAN_8);
        arrayList2.add(BarcodeFormat.EAN_13);
        arrayList2.add(BarcodeFormat.ITF);
        arrayList2.add(BarcodeFormat.PDF_417);
        arrayList2.add(BarcodeFormat.RSS_14);
        arrayList2.add(BarcodeFormat.RSS_EXPANDED);
        arrayList2.add(BarcodeFormat.UPC_A);
        arrayList2.add(BarcodeFormat.UPC_E);
        arrayList2.add(BarcodeFormat.UPC_EAN_EXTENSION);
        f3635b.put(DecodeHintType.POSSIBLE_FORMATS, arrayList2);
        f3635b.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f3635b.put(DecodeHintType.CHARACTER_SET, "utf-8");
        f3636c = new EnumMap(DecodeHintType.class);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(BarcodeFormat.AZTEC);
        arrayList3.add(BarcodeFormat.DATA_MATRIX);
        arrayList3.add(BarcodeFormat.MAXICODE);
        arrayList3.add(BarcodeFormat.QR_CODE);
        f3636c.put(DecodeHintType.POSSIBLE_FORMATS, arrayList3);
        f3636c.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f3636c.put(DecodeHintType.CHARACTER_SET, "utf-8");
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        f3637d = enumMap;
        enumMap.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, (DecodeHintType) Collections.singletonList(BarcodeFormat.QR_CODE));
        f3637d.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f3637d.put(DecodeHintType.CHARACTER_SET, "utf-8");
        EnumMap enumMap2 = new EnumMap(DecodeHintType.class);
        f3638e = enumMap2;
        enumMap2.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, (DecodeHintType) Collections.singletonList(BarcodeFormat.CODE_128));
        f3638e.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f3638e.put(DecodeHintType.CHARACTER_SET, "utf-8");
        EnumMap enumMap3 = new EnumMap(DecodeHintType.class);
        f = enumMap3;
        enumMap3.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, (DecodeHintType) Collections.singletonList(BarcodeFormat.EAN_13));
        f.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        f.put(DecodeHintType.CHARACTER_SET, "utf-8");
        g = new EnumMap(DecodeHintType.class);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(BarcodeFormat.QR_CODE);
        arrayList4.add(BarcodeFormat.UPC_A);
        arrayList4.add(BarcodeFormat.EAN_13);
        arrayList4.add(BarcodeFormat.CODE_128);
        g.put(DecodeHintType.POSSIBLE_FORMATS, arrayList4);
        g.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        g.put(DecodeHintType.CHARACTER_SET, "utf-8");
    }

    public static String a(Bitmap bitmap) {
        RGBLuminanceSource rGBLuminanceSource;
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            rGBLuminanceSource = new RGBLuminanceSource(width, height, iArr);
            try {
                return new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(rGBLuminanceSource)), f3634a).getText();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                if (rGBLuminanceSource != null) {
                    try {
                        return new MultiFormatReader().decode(new BinaryBitmap(new GlobalHistogramBinarizer(rGBLuminanceSource)), f3634a).getText();
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            rGBLuminanceSource = null;
        }
    }
}
