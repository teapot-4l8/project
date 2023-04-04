package cn.jpush.android.d;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.u.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d implements Serializable {
    private static final long serialVersionUID = 8407025843324043625L;
    public String A;
    public String B;
    public String E;
    public String F;
    public String G;
    public String H;
    public int I;
    public String J;
    public String K;
    public int L;
    public String N;
    public String O;
    public String P;
    public int Q;
    public int S;
    public Integer X;
    public String Y;
    public long Z;

    /* renamed from: a  reason: collision with root package name */
    public String f4310a;
    public String aa;
    public boolean ab;
    public boolean ac;
    public long ad;
    public String ag;
    public String ah;
    public String ai;
    public String aj;
    public String ak;

    /* renamed from: b  reason: collision with root package name */
    public String f4311b;

    /* renamed from: c  reason: collision with root package name */
    public String f4312c;

    /* renamed from: d  reason: collision with root package name */
    public int f4313d;

    /* renamed from: e  reason: collision with root package name */
    public int f4314e;
    public String f;
    public String g;
    public int h;
    public boolean i;
    public int j;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f4315q;
    public int r;
    public String s;
    public String t;
    public String u;
    public int v;
    public String w;
    public String x;
    public String y;
    public int z;
    public int k = 0;
    public int C = -1;
    public String D = "";
    public boolean M = false;
    public int R = 0;
    public ArrayList<String> T = new ArrayList<>();
    public String U = "";
    public String V = "";
    public byte W = 0;
    public double ae = 200.0d;
    public double af = 200.0d;

    public static d a(Context context, String str, String str2) {
        String str3;
        d dVar = new d();
        byte b2 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("_jmsgid_");
            dVar.f4312c = optString;
            if (optString.isEmpty()) {
                dVar.f4312c = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
            }
            dVar.W = (byte) jSONObject.optInt("rom_type");
            int optInt = jSONObject.optInt("show_type", -1);
            JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
            if (optJSONObject != null) {
                dVar.u = optJSONObject.optString("n_content");
                dVar.s = optJSONObject.optString("n_title");
                dVar.B = optJSONObject.optString("n_extras");
                dVar.D = optJSONObject.optString("n_channel_id");
                dVar.C = optJSONObject.optInt("n_alert_type");
                dVar.z = optJSONObject.optInt("n_priority");
                dVar.ai = optJSONObject.optString("n_sound");
                dVar.r = optJSONObject.optInt("n_flag", 1);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rich_content");
                if (optJSONObject2 != null) {
                    dVar.M = true;
                    dVar.a(optJSONObject2);
                    dVar.h = 3;
                } else {
                    dVar.h = 4;
                    dVar.R = -1;
                }
            } else {
                dVar.u = jSONObject.optString("n_content");
                dVar.s = jSONObject.optString("n_title");
                dVar.B = jSONObject.optString("n_extras");
                dVar.D = jSONObject.optString("n_channel_id");
                dVar.C = jSONObject.optInt("n_alert_type");
                dVar.z = jSONObject.optInt("n_priority");
                dVar.W = (byte) jSONObject.optInt("rom_type");
                dVar.ai = jSONObject.optString("n_sound");
            }
            if (optInt != -1) {
                dVar.h = optInt;
            }
            dVar.p = 0;
            dVar.f4315q = true;
            dVar.f4310a = context.getPackageName();
            return dVar;
        } catch (Throwable th) {
            Logger.e("PushEntity", "parseContent error:" + th);
            if (TextUtils.isEmpty(dVar.f4312c)) {
                str3 = "NO MSGID";
            } else {
                str3 = dVar.f4312c;
                b2 = dVar.W;
            }
            cn.jpush.android.helper.c.a(str3, str2, b2, 996, context);
            return null;
        }
    }

    public static d a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            d dVar = new d();
            dVar.f4310a = jSONObject.optString("appId");
            dVar.f4311b = jSONObject.optString("senderId");
            dVar.f4312c = jSONObject.optString("messageId");
            dVar.f4313d = jSONObject.optInt("notificationId");
            dVar.f4314e = jSONObject.optInt("messageType");
            dVar.f = jSONObject.optString("overrideMessageId");
            dVar.h = jSONObject.optInt("messageVersion");
            dVar.i = jSONObject.optBoolean("notificationOnly");
            dVar.j = jSONObject.optInt("notificationBuilderId");
            dVar.k = jSONObject.optInt("notificationType");
            dVar.l = jSONObject.optString("message");
            dVar.m = jSONObject.optString("contentType");
            dVar.n = jSONObject.optString("title");
            dVar.o = jSONObject.optString("extras");
            dVar.p = jSONObject.optInt(com.umeng.analytics.pro.d.y);
            dVar.f4315q = jSONObject.optBoolean("isFullScreen");
            dVar.r = jSONObject.optInt("notificationRemoveMode");
            dVar.s = jSONObject.optString("notificationTitle");
            dVar.t = jSONObject.optString("notificationAppName");
            dVar.u = jSONObject.optString("notificationContent");
            dVar.v = jSONObject.optInt("notificationStyle");
            dVar.w = jSONObject.optString("notificationBigText");
            dVar.x = jSONObject.optString("notificationBigPicPath");
            dVar.y = jSONObject.optString("notificationInbox");
            dVar.z = jSONObject.optInt("notificationPriority");
            dVar.A = jSONObject.optString("notificationCategory");
            dVar.B = jSONObject.optString("notificationExtra");
            dVar.C = jSONObject.optInt("notificationAlertType");
            dVar.D = jSONObject.optString("notificationChannelId");
            dVar.E = jSONObject.optString("source");
            dVar.F = jSONObject.optString("smallIcon");
            dVar.G = jSONObject.optString("largeIcon");
            dVar.H = jSONObject.optString("deeplink");
            dVar.I = jSONObject.optInt("failedAction");
            dVar.J = jSONObject.optString("failedLink");
            dVar.K = jSONObject.optString("targetPkgName");
            dVar.L = jSONObject.optInt("deeplinkBuilderId");
            dVar.M = jSONObject.optBoolean("isRichPush");
            dVar.N = jSONObject.optString("showUrl");
            dVar.O = jSONObject.optString("showTitle");
            dVar.P = jSONObject.optString("_webPagePath");
            dVar.Q = jSONObject.optInt("jumpMode");
            dVar.R = jSONObject.optInt("richType");
            dVar.S = jSONObject.optInt("showMode");
            String optString = jSONObject.optString("showResourceList");
            if (!TextUtils.isEmpty(optString)) {
                dVar.T = new ArrayList<>(Arrays.asList(optString.split(",")));
            }
            dVar.U = jSONObject.optString("fromNum");
            dVar.V = jSONObject.optString("toNum");
            dVar.W = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_PLATFORM);
            if (jSONObject.has("badgeAddNum")) {
                dVar.X = Integer.valueOf(jSONObject.optInt("badgeAddNum"));
            }
            dVar.Y = jSONObject.optString("geofenceid");
            dVar.Z = jSONObject.optLong("radius");
            dVar.aa = jSONObject.optString("status");
            dVar.ab = jSONObject.optBoolean("repeat");
            dVar.ac = jSONObject.optBoolean("hasShow");
            dVar.ad = jSONObject.optLong("expiration");
            dVar.ae = jSONObject.optDouble("longitude");
            dVar.af = jSONObject.optDouble("latitude");
            dVar.ag = jSONObject.optString("lastGeoStatus");
            dVar.ah = jSONObject.optString("developerArg0");
            dVar.ai = jSONObject.optString("sound");
            dVar.aj = jSONObject.optString("showBeginTime");
            dVar.ak = jSONObject.optString("showEndTime");
            return dVar;
        } catch (Throwable th) {
            Logger.w("PushEntity", "parseJSONString e:" + th);
            th.printStackTrace();
            return null;
        }
    }

    public static d a(String str, String str2, String str3, long j) {
        JSONObject jSONObject;
        d dVar;
        d dVar2 = null;
        try {
            jSONObject = new JSONObject(str);
            dVar = new d();
        } catch (Throwable th) {
            th = th;
        }
        try {
            String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID, "");
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("ad_id", "");
            }
            if (TextUtils.isEmpty(optString)) {
                optString = jSONObject.optString("_jmsgid_", "");
            }
            if (TextUtils.isEmpty(optString)) {
                optString = j + "";
            }
            Logger.d("PushEntity", "preParseOriginalMsgMessage msgId = " + optString);
            dVar.f4312c = optString;
            dVar.f4310a = str2;
            dVar.f4311b = str3;
            boolean z = true;
            if (jSONObject.optInt("n_only", 0) != 1) {
                z = false;
            }
            int optInt = z ? jSONObject.optInt("n_builder_id", 0) : 0;
            dVar.i = z;
            dVar.j = optInt;
            dVar.g = str;
            dVar.h = jSONObject.optInt("show_type", 3);
            dVar.k = jSONObject.optInt("notificaion_type", 0);
            dVar.f = jSONObject.optString("override_msg_id", "");
            dVar.l = jSONObject.optString("message", "");
            dVar.m = jSONObject.optString("content_type", "");
            dVar.n = jSONObject.optString("title", "");
            dVar.o = jSONObject.optString("extras", "");
            return dVar;
        } catch (Throwable th2) {
            th = th2;
            dVar2 = dVar;
            Logger.w("PushEntity", "processMessage failed:" + th.getMessage());
            return dVar2;
        }
    }

    private void a(JSONObject jSONObject) {
        this.M = true;
        this.N = jSONObject.optString("e_url", "").trim();
        this.O = jSONObject.optString("e_title", "").trim();
        if (!TextUtils.isEmpty(this.N) && !cn.jpush.android.u.a.a(this.N)) {
            this.N = "http://" + this.N;
            Logger.i("PushEntity", "Add http to non-prefix url: " + this.N);
        }
        this.R = jSONObject.optInt("e_rich_type", 0);
        this.Q = jSONObject.optInt("e_jump_mode", 0);
        this.S = jSONObject.optInt("e_show", 0);
        int i = this.R;
        if (3 == i || 2 == i || 1 == i) {
            this.T = g.a(jSONObject.optJSONArray("e_eres"));
        }
        this.U = jSONObject.optString("from_num", "");
        this.V = jSONObject.optString("to_num", "");
    }

    public a a() {
        return new a(this);
    }

    public void a(Context context) {
        try {
            JSONObject optJSONObject = new JSONObject(this.g).optJSONObject("m_content");
            int optInt = optJSONObject.optInt("ad_t", 0);
            this.p = optInt;
            if (optInt != 0) {
                return;
            }
            this.f4315q = optJSONObject.optInt("full_screen", 0) >= 1;
            this.r = optJSONObject.optInt("n_flag", 1);
            this.s = optJSONObject.optString("n_title", "");
            this.t = optJSONObject.optString("n_app_name", "");
            this.u = optJSONObject.optString("n_content", "");
            this.v = optJSONObject.optInt("n_style", 0);
            this.w = optJSONObject.optString("n_big_text", "");
            this.x = optJSONObject.optString("n_big_pic_path", "");
            this.y = optJSONObject.optString("n_inbox", "");
            this.B = optJSONObject.optString("n_extras", "");
            this.z = optJSONObject.optInt("n_priority", 0);
            this.A = optJSONObject.optString("n_category", "");
            this.C = optJSONObject.optInt("n_alert_type", -1);
            this.D = optJSONObject.optString("n_channel_id");
            this.F = optJSONObject.optString("n_small_icon", "");
            this.G = optJSONObject.optString("n_large_icon", "");
            this.E = optJSONObject.optString("n_source", "");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("n_intent");
            if (optJSONObject2 != null) {
                this.H = optJSONObject2.optString("n_url", "");
                this.I = optJSONObject2.optInt("n_fail_handle_type", 0);
                this.J = optJSONObject2.optString("n_fail_handle_url", "");
                this.K = optJSONObject2.optString("n_package_name", "");
                this.L = optJSONObject2.optInt("n_builder_id", 0);
            }
            if (TextUtils.isEmpty(this.s)) {
                Logger.dd("PushEntity", "Not found notificaiton title for developer mode. Use the application name.");
                this.s = cn.jpush.android.u.a.b(context);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("ad_content");
            if (!optJSONObject.isNull("ad_content") && optJSONObject3 != null) {
                a(optJSONObject3);
            }
            if (optJSONObject.has("n_badge_add_num")) {
                this.X = Integer.valueOf(optJSONObject.optInt("n_badge_add_num"));
            } else {
                this.X = null;
            }
            this.ai = optJSONObject.optString("n_sound");
            this.aj = optJSONObject.optString("n_show_begin_time");
            this.ak = optJSONObject.optString("n_show_end_time");
        } catch (Throwable th) {
            Logger.ww("PushEntity", "parse notification failed:" + th.getMessage());
        }
    }

    public NotificationMessage b() {
        NotificationMessage notificationMessage = new NotificationMessage();
        notificationMessage.appkey = this.f4311b;
        notificationMessage.msgId = this.f4312c;
        notificationMessage.notificationAlertType = this.C;
        notificationMessage.notificationBigPicPath = this.x;
        notificationMessage.notificationBigText = this.w;
        notificationMessage.notificationBuilderId = this.j;
        notificationMessage.notificationCategory = this.A;
        notificationMessage.notificationContent = this.u;
        notificationMessage.notificationExtras = this.B;
        notificationMessage.notificationId = this.f4313d;
        notificationMessage.notificationInbox = this.y;
        notificationMessage.notificationLargeIcon = this.G;
        notificationMessage.notificationPriority = this.z;
        notificationMessage.notificationSmallIcon = this.F;
        notificationMessage.notificationStyle = this.v;
        notificationMessage.notificationTitle = this.s;
        notificationMessage.appId = this.f4310a;
        notificationMessage.notificationType = this.k;
        notificationMessage.developerArg0 = this.ah;
        notificationMessage.notificationChannelId = this.D;
        notificationMessage.isRichPush = this.M;
        notificationMessage.richType = this.R;
        notificationMessage._webPagePath = this.P;
        notificationMessage.showResourceList = this.T;
        notificationMessage.platform = this.W;
        return notificationMessage;
    }

    public String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", this.f4310a);
            jSONObject.put("senderId", this.f4311b);
            jSONObject.put("messageId", this.f4312c);
            jSONObject.put("notificationId", this.f4313d);
            jSONObject.put("messageType", this.f4314e);
            jSONObject.put("overrideMessageId", this.f);
            jSONObject.put("messageVersion", this.h);
            jSONObject.put("notificationOnly", this.i);
            jSONObject.put("notificationBuilderId", this.j);
            jSONObject.put("notificationType", this.k);
            jSONObject.put("message", this.l);
            jSONObject.put("contentType", this.m);
            jSONObject.put("title", this.n);
            jSONObject.put("extras", this.o);
            jSONObject.put(com.umeng.analytics.pro.d.y, this.p);
            jSONObject.put("isFullScreen", this.f4315q);
            jSONObject.put("notificationRemoveMode", this.r);
            jSONObject.put("notificationTitle", this.s);
            jSONObject.put("notificationAppName", this.t);
            jSONObject.put("notificationContent", this.u);
            jSONObject.put("notificationStyle", this.v);
            jSONObject.put("notificationBigText", this.w);
            jSONObject.put("notificationBigPicPath", this.x);
            jSONObject.put("notificationInbox", this.y);
            jSONObject.put("notificationPriority", this.z);
            jSONObject.put("notificationCategory", this.A);
            jSONObject.put("notificationExtra", this.B);
            jSONObject.put("notificationAlertType", this.C);
            jSONObject.put("notificationChannelId", this.D);
            jSONObject.put("source", this.E);
            jSONObject.put("smallIcon", this.F);
            jSONObject.put("largeIcon", this.G);
            jSONObject.put("deeplink", this.H);
            jSONObject.put("failedAction", this.I);
            jSONObject.put("failedLink", this.J);
            jSONObject.put("targetPkgName", this.K);
            jSONObject.put("deeplinkBuilderId", this.L);
            jSONObject.put("isRichPush", this.M);
            jSONObject.put("showUrl", this.N);
            jSONObject.put("showTitle", this.O);
            jSONObject.put("_webPagePath", this.P);
            jSONObject.put("jumpMode", this.Q);
            jSONObject.put("richType", this.R);
            jSONObject.put("showMode", this.S);
            jSONObject.put("showResourceList", g.a(this.T, ","));
            jSONObject.put("fromNum", this.U);
            jSONObject.put("toNum", this.V);
            jSONObject.put(JThirdPlatFormInterface.KEY_PLATFORM, (int) this.W);
            jSONObject.put("badgeAddNum", this.X);
            jSONObject.put("geofenceid", this.Y);
            jSONObject.put("radius", this.Z);
            jSONObject.put("status", this.aa);
            jSONObject.put("repeat", this.ab);
            jSONObject.put("hasShow", this.ac);
            jSONObject.put("expiration", this.ad);
            jSONObject.put("longitude", this.ae);
            jSONObject.put("latitude", this.af);
            jSONObject.put("lastGeoStatus", this.ag);
            jSONObject.put("developerArg0", this.ah);
            jSONObject.put("sound", this.ai);
            jSONObject.put("showBeginTime", this.aj);
            jSONObject.put("showEndTime", this.ak);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String toString() {
        return "PushEntity{appId='" + this.f4310a + "', senderId='" + this.f4311b + "', messageId='" + this.f4312c + "', notificationId=" + this.f4313d + ", messageType=" + this.f4314e + ", overrideMessageId='" + this.f + "', originalMessage='" + this.g + "', messageVersion=" + this.h + ", notificationOnly=" + this.i + ", notificationBuilderId=" + this.j + ", notificationType=" + this.k + ", message='" + this.l + "', contentType='" + this.m + "', title='" + this.n + "', extras='" + this.o + "', type=" + this.p + ", isFullScreen=" + this.f4315q + ", notificationRemoveMode=" + this.r + ", notificationTitle='" + this.s + "', notificationAppName='" + this.t + "', notificationContent='" + this.u + "', notificationStyle=" + this.v + ", notificationBigText='" + this.w + "', notificationBigPicPath='" + this.x + "', notificationInbox='" + this.y + "', notificationPriority=" + this.z + ", notificationCategory='" + this.A + "', notificationExtra='" + this.B + "', notificationAlertType=" + this.C + ", notificationChannelId='" + this.D + "', source='" + this.E + "', smallIcon='" + this.F + "', largeIcon='" + this.G + "', deeplink='" + this.H + "', failedAction=" + this.I + ", failedLink='" + this.J + "', targetPkgName='" + this.K + "', deeplinkBuilderId=" + this.L + ", isRichPush=" + this.M + ", showUrl='" + this.N + "', showTitle='" + this.O + "', _webPagePath='" + this.P + "', jumpMode=" + this.Q + ", richType=" + this.R + ", showMode=" + this.S + ", showResourceList=" + this.T + ", fromNum='" + this.U + "', toNum='" + this.V + "', platform=" + ((int) this.W) + ", badgeAddNum=" + this.X + ", geofenceid='" + this.Y + "', radius=" + this.Z + ", status='" + this.aa + "', repeat=" + this.ab + ", hasShow=" + this.ac + ", expiration=" + this.ad + ", longitude=" + this.ae + ", latitude=" + this.af + ", lastGeoStatus='" + this.ag + "', developerArg0='" + this.ah + "', sound='" + this.ai + "', showBeginTime='" + this.aj + "', showEndTime='" + this.ak + "'}";
    }
}
