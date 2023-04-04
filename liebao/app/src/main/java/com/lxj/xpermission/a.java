package com.lxj.xpermission;

import android.os.Build;

/* compiled from: PermissionConstants.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f5362a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f5363b = {"android.permission.CAMERA"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f5364c = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f5365d = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f5366e = {"android.permission.RECORD_AUDIO"};
    private static final String[] f = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};
    private static final String[] g = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
    private static final String[] h = {"android.permission.BODY_SENSORS"};
    private static final String[] i = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
    private static final String[] j = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String[] a(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1639857183:
                if (str.equals("android.permission-group.CONTACTS")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -1410061184:
                if (str.equals("android.permission-group.PHONE")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1250730292:
                if (str.equals("android.permission-group.CALENDAR")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1140935117:
                if (str.equals("android.permission-group.CAMERA")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 421761675:
                if (str.equals("android.permission-group.SENSORS")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 828638019:
                if (str.equals("android.permission-group.LOCATION")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 852078861:
                if (str.equals("android.permission-group.STORAGE")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 1581272376:
                if (str.equals("android.permission-group.MICROPHONE")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1795181803:
                if (str.equals("android.permission-group.SMS")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return f5362a;
            case 1:
                return f5363b;
            case 2:
                return f5364c;
            case 3:
                return f5365d;
            case 4:
                return f5366e;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    return g;
                }
                return f;
            case 6:
                return h;
            case 7:
                return i;
            case '\b':
                return j;
            default:
                return new String[]{str};
        }
    }
}
