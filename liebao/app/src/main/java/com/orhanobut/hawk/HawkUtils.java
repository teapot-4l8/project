package com.orhanobut.hawk;

/* loaded from: classes2.dex */
final class HawkUtils {
    private HawkUtils() {
    }

    public static void checkNull(String str, Object obj) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException(str + " should not be null");
    }

    public static void checkNullOrEmpty(String str, String str2) {
        if (isEmpty(str2)) {
            throw new NullPointerException(str + " should not be null or empty");
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
