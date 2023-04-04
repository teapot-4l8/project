package cn.jiguang.u;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c {
    public static String a(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", String.class).invoke(loadClass, new String(str));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() < 14) {
            return null;
        }
        return str;
    }

    public static ArrayList<cn.jiguang.t.b> a(Context context) {
        String str;
        String str2;
        int i;
        String str3;
        String replace;
        StringBuilder sb;
        StringBuilder sb2;
        String replace2;
        String str4;
        String replace3;
        StringBuilder sb3;
        String a2;
        StringBuilder sb4;
        String replace4;
        String str5 = Build.MANUFACTURER;
        String a3 = a(context, cn.jiguang.s.a.a(4, 1));
        String a4 = a(context, cn.jiguang.s.a.a(4, 0));
        if (a3 != null && !TextUtils.isEmpty(a3)) {
            a4 = a4 + "," + a3;
        }
        String[] split = TextUtils.isEmpty(a4) ? null : a4.split(",");
        int length = split == null ? 1 : split.length;
        if (length == 0) {
            return null;
        }
        ArrayList<cn.jiguang.t.b> arrayList = new ArrayList<>();
        if (split == null || split.length == 0) {
            str = null;
        } else {
            int length2 = split.length;
            String a5 = a(context, cn.jiguang.s.a.a(0, 0));
            if (TextUtils.isEmpty(a5)) {
                a5 = a(context, cn.jiguang.s.a.a(0, 2));
            }
            if (length2 > 1) {
                a5 = a5 + "," + a(context, cn.jiguang.s.a.a(0, 1));
            }
            if (a5 == null || TextUtils.isEmpty(a5.trim().replace(",", ""))) {
                String str6 = a(context, cn.jiguang.s.a.a(0, 3)) + "," + a(context, cn.jiguang.s.a.a(0, 4));
                if ((str6 == null || TextUtils.isEmpty(str6.trim().replace(",", ""))) && ((str6 = a(context, cn.jiguang.s.a.a(0, 6))) == null || TextUtils.isEmpty(str6.trim().replace(",", "")))) {
                    String a6 = a(context, cn.jiguang.s.a.a(0, 8));
                    String a7 = a(context, cn.jiguang.s.a.a(0, 9));
                    String a8 = a(context, cn.jiguang.s.a.a(0, 10));
                    if (TextUtils.isEmpty(a7)) {
                        str4 = a6 + "," + a(context, cn.jiguang.s.a.a(0, 10));
                    } else if (TextUtils.isEmpty(a8)) {
                        str4 = a6 + "," + a7;
                    } else {
                        str4 = a7 + "," + a8;
                    }
                    if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                        str4 = a(context, cn.jiguang.s.a.a(0, 36)) + "," + a(context, cn.jiguang.s.a.a(0, 37));
                        if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                            str4 = a(context, cn.jiguang.s.a.a(0, 21));
                            if (!TextUtils.isEmpty(str4)) {
                                String a9 = a(context, cn.jiguang.s.a.a(0, 20));
                                if (TextUtils.isEmpty(a9)) {
                                    str4 = a(context, cn.jiguang.s.a.a(0, 22)) + "," + str4;
                                } else {
                                    str4 = a9 + "," + str4;
                                }
                            }
                            if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                str4 = a(context, cn.jiguang.s.a.a(0, 11));
                                if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                    String a10 = a(context, cn.jiguang.s.a.a(0, 14));
                                    if (TextUtils.isEmpty(a10)) {
                                        a10 = a(context, cn.jiguang.s.a.a(0, 13));
                                    }
                                    str4 = a10 + "," + a(context, cn.jiguang.s.a.a(0, 15));
                                    if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                        str4 = a(context, cn.jiguang.s.a.a(0, 17)) + "," + a(context, cn.jiguang.s.a.a(0, 18));
                                        if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                            str4 = a(context, cn.jiguang.s.a.a(0, 22));
                                            if (TextUtils.isEmpty(str4)) {
                                                str4 = a(context, cn.jiguang.s.a.a(0, 23));
                                            }
                                            if (str4 == null || TextUtils.isEmpty(str4)) {
                                                str4 = a(context, cn.jiguang.s.a.a(0, 26));
                                                if (str4 == null || TextUtils.isEmpty(str4.trim())) {
                                                    str4 = a(context, cn.jiguang.s.a.a(0, 27)) + "," + a(context, cn.jiguang.s.a.a(0, 28));
                                                    if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                                        str4 = a(context, cn.jiguang.s.a.a(0, 29)) + "," + a(context, cn.jiguang.s.a.a(0, 30));
                                                        if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                                            str4 = a(context, cn.jiguang.s.a.a(0, 31)) + "," + a(context, cn.jiguang.s.a.a(0, 32));
                                                            if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                                                str4 = a(context, cn.jiguang.s.a.a(0, 33)) + "," + a(context, cn.jiguang.s.a.a(0, 34));
                                                                if ((str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) && ((str4 = a(context, cn.jiguang.s.a.a(0, 35))) == null || TextUtils.isEmpty(str4.trim().replace(",", "")))) {
                                                                    str4 = a(context, cn.jiguang.s.a.a(0, 42)) + "," + a(context, cn.jiguang.s.a.a(0, 43));
                                                                    if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                                                        str4 = a(context, cn.jiguang.s.a.a(0, 44)) + "," + a(context, cn.jiguang.s.a.a(0, 45));
                                                                        if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                                                            str4 = a(context, cn.jiguang.s.a.a(0, 16));
                                                                            if (str4 == null || TextUtils.isEmpty(str4.trim())) {
                                                                                str4 = a(context, cn.jiguang.s.a.a(0, 19));
                                                                                if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                                                                    str4 = a(context, cn.jiguang.s.a.a(0, 39)) + "," + a(context, cn.jiguang.s.a.a(0, 40));
                                                                                    if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                                                                        str4 = a(context, cn.jiguang.s.a.a(0, 38));
                                                                                        if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                                                                            str4 = a(context, cn.jiguang.s.a.a(0, 7));
                                                                                            if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                                                                                str4 = a(context, cn.jiguang.s.a.a(0, 5));
                                                                                                if (str4 == null || TextUtils.isEmpty(str4.trim().replace(",", ""))) {
                                                                                                    str = a(context, cn.jiguang.s.a.a(0, 41));
                                                                                                    if (str != null && !TextUtils.isEmpty(str.trim().replace(",", ""))) {
                                                                                                        replace3 = str.replace("null", "");
                                                                                                    }
                                                                                                } else if (length2 > 1) {
                                                                                                    sb3 = new StringBuilder(",");
                                                                                                    sb3.append(str4);
                                                                                                    str4 = sb3.toString();
                                                                                                }
                                                                                            }
                                                                                        } else if (length2 > 1) {
                                                                                            sb3 = new StringBuilder();
                                                                                        }
                                                                                    } else if (length2 > 1) {
                                                                                        sb3 = new StringBuilder();
                                                                                    }
                                                                                    str = replace3.replace("N/A", "");
                                                                                }
                                                                            } else {
                                                                                sb3 = new StringBuilder();
                                                                            }
                                                                            sb3.append(str4);
                                                                            sb3.append(",");
                                                                            str4 = sb3.toString();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            } else {
                                                a2 = a(context, cn.jiguang.s.a.a(0, 24));
                                                String a11 = a(context, cn.jiguang.s.a.a(0, 25));
                                                if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a11)) {
                                                    str4 = a2 + "," + a11;
                                                } else if (TextUtils.isEmpty(a2)) {
                                                    if (!TextUtils.isEmpty(a11)) {
                                                        sb3 = new StringBuilder();
                                                        sb3.append(str4);
                                                        sb3.append(",");
                                                        sb3.append(a11);
                                                    } else if (length2 > 1 && !str4.contains(",")) {
                                                        sb3 = new StringBuilder();
                                                        sb3.append(str4);
                                                        sb3.append(",");
                                                    }
                                                    str4 = sb3.toString();
                                                } else {
                                                    sb4 = new StringBuilder();
                                                    sb4.append(str4);
                                                    sb4.append(",");
                                                    sb4.append(a2);
                                                    str4 = sb4.toString();
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    a2 = a(context, cn.jiguang.s.a.a(0, 12));
                                    if (!TextUtils.isEmpty(a2)) {
                                        sb4 = new StringBuilder();
                                        sb4.append(str4);
                                        sb4.append(",");
                                        sb4.append(a2);
                                        str4 = sb4.toString();
                                    }
                                }
                            }
                        }
                    }
                    replace3 = str4.replace("null", "");
                    str = replace3.replace("N/A", "");
                } else {
                    replace4 = str6.replace("null", "");
                }
            } else {
                replace4 = a5.replace("null", "");
            }
            str = replace4.replace("N/A", "");
        }
        if (split == null || split.length == 0) {
            str2 = null;
        } else {
            int length3 = split.length;
            String a12 = a(context, cn.jiguang.s.a.a(3, 0));
            if (a12 == null || TextUtils.isEmpty(a12.trim().replace(",", ""))) {
                String str7 = a(context, cn.jiguang.s.a.a(3, 1)) + "," + a(context, cn.jiguang.s.a.a(3, 2));
                if (str7 == null || TextUtils.isEmpty(str7.trim().replace(",", ""))) {
                    str7 = a(context, cn.jiguang.s.a.a(3, 4)) + "," + a(context, cn.jiguang.s.a.a(3, 5));
                    if ((str7 == null || TextUtils.isEmpty(str7.trim().replace(",", ""))) && ((str7 = a(context, cn.jiguang.s.a.a(3, 6))) == null || TextUtils.isEmpty(str7.trim().replace(",", "")))) {
                        str7 = a(context, cn.jiguang.s.a.a(3, 7)) + "," + a(context, cn.jiguang.s.a.a(3, 8));
                        if (str7 == null || TextUtils.isEmpty(str7.trim().replace(",", ""))) {
                            str7 = a(context, cn.jiguang.s.a.a(3, 9)) + "," + a(context, cn.jiguang.s.a.a(3, 10));
                            if (str7 == null || TextUtils.isEmpty(str7.trim().replace(",", ""))) {
                                str7 = a(context, cn.jiguang.s.a.a(3, 12)) + "," + a(context, cn.jiguang.s.a.a(3, 12));
                                if (str7 == null || TextUtils.isEmpty(str7.trim().replace(",", ""))) {
                                    str7 = a(context, cn.jiguang.s.a.a(3, 13)) + "," + a(context, cn.jiguang.s.a.a(3, 14));
                                    if (str7 == null || TextUtils.isEmpty(str7.trim().replace(",", ""))) {
                                        String a13 = a(context, cn.jiguang.s.a.a(3, 3));
                                        if (length3 == 1) {
                                            str2 = a13;
                                        } else {
                                            if (!"ABSENT".equalsIgnoreCase(split[1]) || "ABSENT".equalsIgnoreCase(split[0])) {
                                                if (!"ABSENT".equalsIgnoreCase(split[1])) {
                                                    sb2 = new StringBuilder(",");
                                                    sb2.append(a13);
                                                }
                                                str2 = str7;
                                            } else {
                                                sb2 = new StringBuilder();
                                                sb2.append(a13);
                                                sb2.append(",");
                                            }
                                            str7 = sb2.toString();
                                            str2 = str7;
                                        }
                                        if (str2 != null && !TextUtils.isEmpty(str2.trim().replace(",", ""))) {
                                            replace2 = str2.replace("null", "");
                                            str2 = replace2.replace("N/A", "");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                replace2 = str7.replace("null", "");
                str2 = replace2.replace("N/A", "");
            } else {
                str2 = a12.replace("null", "").replace("N/A", "");
            }
        }
        if (split == null || split.length == 0) {
            i = 0;
            str3 = null;
        } else {
            int length4 = split.length;
            String a14 = a(context, cn.jiguang.s.a.a(1, 0));
            String a15 = a(context, cn.jiguang.s.a.a(1, 1));
            if (!TextUtils.isEmpty(a15)) {
                a14 = a14 + "," + a15;
            }
            if (a14 == null || TextUtils.isEmpty(a14.trim().replace(",", ""))) {
                i = 0;
                String a16 = a(context, cn.jiguang.s.a.a(1, 2));
                if ((a16 == null || TextUtils.isEmpty(a16.trim().replace(",", ""))) && ((a16 = a(context, cn.jiguang.s.a.a(1, 3))) == null || TextUtils.isEmpty(a16.trim().replace(",", "")) || !a16.contains(","))) {
                    str3 = a(context, cn.jiguang.s.a.a(1, 4));
                    if (str3 != null && !TextUtils.isEmpty(str3.trim().replace(",", "")) && str3.contains(",")) {
                        replace = str3.replace("null", "");
                    }
                } else {
                    replace = a16.replace("null", "");
                }
            } else {
                if (length4 <= 1 || a14.contains(",")) {
                    i = 0;
                } else {
                    i = 0;
                    if ("ABSENT".equalsIgnoreCase(split[0])) {
                        sb = new StringBuilder(",");
                        sb.append(a14);
                    } else {
                        sb = new StringBuilder();
                        sb.append(a14);
                        sb.append(",");
                    }
                    a14 = sb.toString();
                }
                replace = a14.replace("null", "");
            }
            str3 = replace.replace("N/A", "");
        }
        if (length == 1) {
            cn.jiguang.t.b bVar = new cn.jiguang.t.b();
            bVar.f4220a = a(str == null ? null : str.trim().replace(",", ""));
            if (!"ABSENT".equalsIgnoreCase(a4)) {
                bVar.f4222c = str2 == null ? null : str2.trim().replace(",", "");
                bVar.f4221b = str3 == null ? null : str3.trim().replace(",", "");
            }
            arrayList.add(bVar);
        } else {
            String[] split2 = str != null ? str.split(",") : null;
            String[] split3 = str3 != null ? str3.split(",") : null;
            String[] split4 = str2 != null ? str2.split(",") : null;
            while (i < 2) {
                cn.jiguang.t.b bVar2 = new cn.jiguang.t.b();
                if (split2 != null && i < split2.length) {
                    bVar2.f4220a = a(split2[i]);
                }
                if (!"ABSENT".equalsIgnoreCase(split[i])) {
                    if (split3 != null && i < split3.length) {
                        bVar2.f4221b = split3[i];
                    }
                    if (split4 != null && i < split4.length) {
                        bVar2.f4222c = split4[i];
                    }
                }
                arrayList.add(bVar2);
                i++;
            }
        }
        return arrayList;
    }

    public static String b(Context context, String str) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (JConstants.isAndroidQ(context, false, "do not getIccid")) {
            return "";
        }
        if (cn.jiguang.f.a.c(context, "android.permission.READ_PHONE_STATE")) {
            str = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } else {
            cn.jiguang.ad.a.d("JIGUANG-JDeviceImeiHelper", "collect simSerialNumber failed because has no android.permission.READ_PHONE_STATE");
        }
        return str;
    }
}
