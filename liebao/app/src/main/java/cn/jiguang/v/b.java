package cn.jiguang.v;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.o.i;
import com.youth.banner.config.BannerConfig;
import java.nio.ByteBuffer;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static long f4238a;

    static {
        cn.jiguang.ap.b.a("JCommon");
        cn.jiguang.ap.b.a("JLocation");
        cn.jiguang.ap.b.a("JArp");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:158:0x030d A[Catch: all -> 0x0334, TryCatch #0 {all -> 0x0334, blocks: (B:4:0x000b, B:6:0x0011, B:8:0x0017, B:10:0x001d, B:11:0x0027, B:41:0x0087, B:75:0x0184, B:77:0x0188, B:80:0x018f, B:84:0x0199, B:116:0x01f6, B:117:0x0201, B:118:0x020a, B:119:0x020f, B:121:0x0215, B:123:0x024d, B:124:0x025e, B:139:0x0287, B:156:0x0309, B:158:0x030d, B:161:0x0314, B:170:0x032c, B:164:0x031e, B:141:0x028c, B:142:0x0295, B:143:0x029e, B:144:0x02a6, B:145:0x02aa, B:146:0x02b2, B:147:0x02ba, B:148:0x02c2, B:149:0x02ca, B:151:0x02d0, B:152:0x02d8, B:153:0x02e0, B:154:0x02ea, B:87:0x01a3, B:90:0x01ad, B:93:0x01b7, B:96:0x01bf, B:99:0x01c9, B:102:0x01d3, B:105:0x01dd, B:43:0x008c, B:45:0x0093, B:47:0x009c, B:49:0x00b9, B:50:0x00c8, B:51:0x00e1, B:53:0x00e6, B:54:0x00ef, B:56:0x00f8, B:58:0x00ff, B:61:0x0112, B:63:0x011b, B:65:0x0124, B:67:0x0131, B:68:0x0138, B:70:0x013c, B:74:0x014a, B:13:0x002b, B:16:0x0036, B:19:0x0040, B:22:0x004a, B:25:0x0054, B:28:0x005e, B:31:0x0068, B:34:0x0072, B:37:0x007c), top: B:177:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0314 A[Catch: all -> 0x0334, TryCatch #0 {all -> 0x0334, blocks: (B:4:0x000b, B:6:0x0011, B:8:0x0017, B:10:0x001d, B:11:0x0027, B:41:0x0087, B:75:0x0184, B:77:0x0188, B:80:0x018f, B:84:0x0199, B:116:0x01f6, B:117:0x0201, B:118:0x020a, B:119:0x020f, B:121:0x0215, B:123:0x024d, B:124:0x025e, B:139:0x0287, B:156:0x0309, B:158:0x030d, B:161:0x0314, B:170:0x032c, B:164:0x031e, B:141:0x028c, B:142:0x0295, B:143:0x029e, B:144:0x02a6, B:145:0x02aa, B:146:0x02b2, B:147:0x02ba, B:148:0x02c2, B:149:0x02ca, B:151:0x02d0, B:152:0x02d8, B:153:0x02e0, B:154:0x02ea, B:87:0x01a3, B:90:0x01ad, B:93:0x01b7, B:96:0x01bf, B:99:0x01c9, B:102:0x01d3, B:105:0x01dd, B:43:0x008c, B:45:0x0093, B:47:0x009c, B:49:0x00b9, B:50:0x00c8, B:51:0x00e1, B:53:0x00e6, B:54:0x00ef, B:56:0x00f8, B:58:0x00ff, B:61:0x0112, B:63:0x011b, B:65:0x0124, B:67:0x0131, B:68:0x0138, B:70:0x013c, B:74:0x014a, B:13:0x002b, B:16:0x0036, B:19:0x0040, B:22:0x004a, B:25:0x0054, B:28:0x005e, B:31:0x0068, B:34:0x0072, B:37:0x007c), top: B:177:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x032c A[Catch: all -> 0x0334, TRY_LEAVE, TryCatch #0 {all -> 0x0334, blocks: (B:4:0x000b, B:6:0x0011, B:8:0x0017, B:10:0x001d, B:11:0x0027, B:41:0x0087, B:75:0x0184, B:77:0x0188, B:80:0x018f, B:84:0x0199, B:116:0x01f6, B:117:0x0201, B:118:0x020a, B:119:0x020f, B:121:0x0215, B:123:0x024d, B:124:0x025e, B:139:0x0287, B:156:0x0309, B:158:0x030d, B:161:0x0314, B:170:0x032c, B:164:0x031e, B:141:0x028c, B:142:0x0295, B:143:0x029e, B:144:0x02a6, B:145:0x02aa, B:146:0x02b2, B:147:0x02ba, B:148:0x02c2, B:149:0x02ca, B:151:0x02d0, B:152:0x02d8, B:153:0x02e0, B:154:0x02ea, B:87:0x01a3, B:90:0x01ad, B:93:0x01b7, B:96:0x01bf, B:99:0x01c9, B:102:0x01d3, B:105:0x01dd, B:43:0x008c, B:45:0x0093, B:47:0x009c, B:49:0x00b9, B:50:0x00c8, B:51:0x00e1, B:53:0x00e6, B:54:0x00ef, B:56:0x00f8, B:58:0x00ff, B:61:0x0112, B:63:0x011b, B:65:0x0124, B:67:0x0131, B:68:0x0138, B:70:0x013c, B:74:0x014a, B:13:0x002b, B:16:0x0036, B:19:0x0040, B:22:0x004a, B:25:0x0054, B:28:0x005e, B:31:0x0068, B:34:0x0072, B:37:0x007c), top: B:177:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(Context context, String str, Object obj) {
        char c2;
        Intent intent;
        char c3;
        char c4;
        try {
            if (context == null) {
                cn.jiguang.ad.a.d("JCommonActionHelper", "context is null,give up continue");
                return null;
            } else if (TextUtils.isEmpty(str)) {
                cn.jiguang.ad.a.d("JCommonActionHelper", "action is null,give up continue");
                return null;
            } else {
                switch (str.hashCode()) {
                    case -835320015:
                        if (str.equals("get_all_ids")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -24181482:
                        if (str.equals("get_loc_info")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 385278662:
                        if (str.equals("periodtask")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 781805572:
                        if (str.equals("deviceinfo")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 805881853:
                        if (str.equals("getwakeenable")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1567409176:
                        if (str.equals("filter_pkg_list")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1660517635:
                        if (str.equals("on_register")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1947980230:
                        if (str.equals("service_create")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1976348689:
                        if (str.equals("get_imei")) {
                            c2 = '\b';
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
                        cn.jiguang.l.b.a().d(context);
                        if (cn.jiguang.d.a.i(context)) {
                            cn.jiguang.ab.a.a().d(context);
                        }
                        cn.jiguang.ae.a.a(context, ((obj instanceof Bundle) && ((Bundle) obj).getBoolean("login")) ? 2 : 0);
                        cn.jiguang.q.b.a().b(context);
                        cn.jiguang.q.c.a().b(context);
                        cn.jiguang.i.a.a().b(context);
                        cn.jiguang.i.b.a().b(context);
                        cn.jiguang.i.e.a().b(context);
                        cn.jiguang.p.b.a();
                        cn.jiguang.p.b.a(context);
                        cn.jiguang.ag.a.a().b(context);
                        cn.jiguang.ag.a.a().c(context, (JSONObject) null);
                        break;
                    case 1:
                        return cn.jiguang.ab.a.a().f(context);
                    case 2:
                        return cn.jiguang.ag.a.a().f(context);
                    case 3:
                        cn.jiguang.ag.a.a();
                        if (obj instanceof List) {
                            return cn.jiguang.ai.c.a(cn.jiguang.ai.b.b(context, d.a(context, "bwc.catch")), (List) obj);
                        }
                        return obj;
                    case 4:
                        return cn.jiguang.q.b.a().f(context);
                    case 5:
                        cn.jiguang.ag.a.a().h(context);
                        break;
                    case 6:
                        return cn.jiguang.x.a.a(context);
                    case 7:
                        cn.jiguang.p.b.a();
                        if (Build.VERSION.SDK_INT >= 11) {
                            String g = cn.jiguang.o.f.g(context);
                            cn.jiguang.ad.a.a("CopyManager", "int copy:" + g);
                            if (!TextUtils.isEmpty(g)) {
                                try {
                                    cn.jiguang.ax.b.a().a(context);
                                    cn.jiguang.p.b.b(context, new JSONObject(g));
                                } catch (JSONException unused) {
                                }
                            }
                        }
                        cn.jiguang.ag.a.a().g(context);
                        cn.jiguang.ax.b.a().b(BannerConfig.LOOP_TIME, 3000L, new c());
                        break;
                    case '\b':
                        return cn.jiguang.u.e.a(context, "");
                }
                Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
                if (bundle != null) {
                    switch (str.hashCode()) {
                        case -1485564867:
                            if (str.equals("notification_state")) {
                                c4 = 7;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case -955011762:
                            if (str.equals("init_local_ctrl")) {
                                c4 = 0;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case -955005568:
                            if (str.equals("lbsenable")) {
                                c4 = 1;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case -691876648:
                            if (str.equals("set_ctrl_url")) {
                                c4 = 3;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 98618:
                            if (str.equals("cmd")) {
                                c4 = 4;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 112894784:
                            if (str.equals("waked")) {
                                c4 = 5;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 1391522972:
                            if (str.equals("lbsforenry")) {
                                c4 = 2;
                                break;
                            }
                            c4 = 65535;
                            break;
                        case 2063320150:
                            if (str.equals("set_sdktype_info")) {
                                c4 = 6;
                                break;
                            }
                            c4 = 65535;
                            break;
                        default:
                            c4 = 65535;
                            break;
                    }
                    if (c4 == 1) {
                        boolean z = bundle.getBoolean("enable");
                        cn.jiguang.ad.a.a("JCommonActionHelper", "[setLBSEnable] " + z);
                        cn.jiguang.o.f.b(context, "JLocation", z);
                    } else if (c4 == 3) {
                        cn.jiguang.ai.b.f3709a = bundle.getString("test_wake_controll_url");
                    } else if (c4 == 4) {
                        JSONObject a2 = a(bundle);
                        if (a2 != null) {
                            int optInt = a2.optInt("cmd");
                            long a3 = e.a();
                            String a4 = cn.jiguang.u.a.a(context, optInt);
                            byte[] a5 = e.a(f4238a, a4);
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("cmd", 25);
                            bundle2.putInt("ver", 1);
                            bundle2.putLong("rid", a3);
                            bundle2.putLong("timeout", 0L);
                            bundle2.putByteArray("body", a5);
                            if (!TextUtils.isEmpty(a4)) {
                                cn.jiguang.ad.a.a("JCommonActionHelper", "tcp report deviceInfo:" + a4);
                            }
                            JCoreManager.onEvent(context, "JCOMMON", 16, null, bundle2, new Object[0]);
                            if (optInt != 4) {
                                if (optInt != 5) {
                                    if (optInt == 9) {
                                        cn.jiguang.i.d.a().c(context);
                                    } else if (optInt == 58) {
                                        cn.jiguang.p.b.a().a(context, a2);
                                    } else if (optInt == 44) {
                                        cn.jiguang.i.e.a().c(context);
                                    } else if (optInt != 45) {
                                        if (optInt == 54) {
                                            cn.jiguang.i.e.a().a(context, a2);
                                        } else if (optInt != 55) {
                                            switch (optInt) {
                                                case 50:
                                                    cn.jiguang.ag.a.a().c(context, a2);
                                                    break;
                                                case 51:
                                                    cn.jiguang.q.d.a().a(context, a2);
                                                    break;
                                                case 52:
                                                    cn.jiguang.l.b.a().b(context, a2);
                                                    break;
                                            }
                                        } else {
                                            i.a(context, a2);
                                        }
                                    }
                                }
                                if (cn.jiguang.d.a.i(context)) {
                                    cn.jiguang.ab.a.a().b(context, a2);
                                }
                            } else {
                                cn.jiguang.i.a.a().c(context);
                            }
                        }
                    } else if (c4 == 5) {
                        cn.jiguang.ag.a.b(context, bundle);
                    } else if (c4 == 6) {
                        cn.jiguang.af.a.a().a(context, bundle);
                    } else if (c4 == 7) {
                        cn.jiguang.ae.a.a(context, bundle.getInt("scence"));
                    }
                    intent = !(obj instanceof Intent) ? (Intent) obj : null;
                    if (intent != null) {
                        return null;
                    }
                    if (str.hashCode() == 1563192504 && str.equals("get_receiver")) {
                        c3 = 0;
                        if (c3 == 0) {
                            return null;
                        }
                        cn.jiguang.i.b.a().a(context, intent);
                        return null;
                    }
                    c3 = 65535;
                    if (c3 == 0) {
                    }
                }
                if (!(obj instanceof Intent)) {
                }
                if (intent != null) {
                }
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JCommonActionHelper", "onEvent throwable:" + th.getMessage());
            return null;
        }
    }

    private static JSONObject a(Bundle bundle) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bundle.getByteArray("RESPONSE_BODY"));
            f4238a = wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            cn.jiguang.ad.a.a("JCommonActionHelper", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e2) {
            cn.jiguang.ad.a.d("JCommonActionHelper", "parseBundle2Json exception:" + e2.getMessage());
            return null;
        }
    }
}
