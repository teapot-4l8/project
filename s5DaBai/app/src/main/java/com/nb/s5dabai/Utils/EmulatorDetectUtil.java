package com.nb.s5dabai.Utils;

public class EmulatorDetectUtil {
    public static  boolean isEmulator() {
        String product = android.os.Build.PRODUCT;
        return product != null && product.equals("sdk");
    }
}
