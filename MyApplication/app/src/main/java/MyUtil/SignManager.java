package MyUtil;

import java.util.Locale;
import java.util.TreeMap;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

public final class SignManager {
    public static final SignManager INSTANCE = new SignManager();
    public static final String KEY_AUTOHOME = "@7U$aPOE@$";
    public static final String KEY_SHARE = "moc.861ehc.relaed.bup.wyfv";
    public static final String KEY_V1 = "com.che168.www";
    public static final String KEY_V2 = "W@oC!AH_6Ew1f6%8";

    private SignManager() {
    }

    public static String signByType(int i, TreeMap<String, String> paramMap) {
        Intrinsics.checkParameterIsNotNull(paramMap, "paramMap");
        StringBuilder sb = new StringBuilder();
        String str = KEY_V1;
        if (i != 0) {
            if (i == 1) {
                str = KEY_V2;
            } else if (i == 2) {
                str = KEY_SHARE;
            } else if (i == 3) {
                str = KEY_AUTOHOME;
            }
        }
        sb.append(str);
        for (String str2 : paramMap.keySet()) {
            sb.append(str2);
            sb.append(paramMap.get(str2));
        }
        sb.append(str);
        String encodeMD5 = SecurityUtil.encodeMD5(sb.toString());
        if (encodeMD5 != null) {
            Locale locale = Locale.ROOT;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
            if (encodeMD5 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = encodeMD5.toUpperCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            if (upperCase != null) {
                return upperCase;
            }
        }
        return "";
    }
}
