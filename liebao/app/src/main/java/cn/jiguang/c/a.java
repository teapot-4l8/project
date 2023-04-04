package cn.jiguang.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.at.d;
import cn.jiguang.at.h;
import cn.jiguang.at.n;
import cn.jiguang.at.p;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends JDispatchAction {
    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i, int i2, long j, long j2, ByteBuffer byteBuffer) {
        try {
            if (i == 19) {
                h.a().a(context, "tcp_a18", null);
            } else if (i == 30 || i == 32) {
                cn.jiguang.e.a.a().a(0, i);
            } else if (i == 25) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("RESPONSE_BODY", byteBuffer.array());
                d.a(context, "cmd", bundle);
            } else if (i != 26) {
            } else {
                short s = byteBuffer.getShort();
                if (s == 0) {
                    p.a().a(context, j2);
                } else {
                    p.a().a(j2, s);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.f("JCoreDispatchAction", "dispatchMessage failed:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        return (short) 3;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        return "core_sdk_ver";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        return cn.jiguang.a.a.f3640b;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        return (short) 6;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i) {
        return i == 0 || i == 1 || i == 19 || i == 25 || i == 26 || i == 30 || i == 32;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        if (bundle != null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (str2.equals("asm")) {
                    cn.jiguang.e.a.a().a(context, bundle);
                } else if (!str2.equals("asmr")) {
                    if (str2.equals("lbsenable")) {
                        d.a(context, str2, bundle);
                        if (bundle != null) {
                            cn.jiguang.g.b.a(context, cn.jiguang.g.a.y().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(bundle.getBoolean("enable"))));
                        }
                    } else if (!str2.equals("lbsforenry")) {
                        if (str2.equals("notification_state")) {
                            d.a(context, str2, bundle);
                        } else if (str2.equals("old_cmd")) {
                            d.a(context, str2, bundle);
                        }
                    } else {
                        long j = bundle.getLong("forenry");
                        cn.jiguang.an.d.b("JCoreDispatchAction", "setLbsPermissionDialogShieldDelay=" + j);
                        if (((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.w())).longValue() <= 0) {
                            cn.jiguang.g.b.a(context, cn.jiguang.g.a.w().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis())));
                        }
                        cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[1];
                        aVarArr[0] = cn.jiguang.g.a.x().a((cn.jiguang.g.a<Long>) (j > 0 ? Long.valueOf(j) : null));
                        cn.jiguang.g.b.a(context, aVarArr);
                    }
                } else {
                    cn.jiguang.e.a a2 = cn.jiguang.e.a.a();
                    String string = bundle.getString(JThirdPlatFormInterface.KEY_DATA);
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(string);
                    String optString = jSONObject.optString("mtmmi");
                    String optString2 = jSONObject.optString("ktmfp");
                    String optString3 = jSONObject.optString("ktma");
                    String optString4 = jSONObject.optString("ktmr");
                    String optString5 = jSONObject.optString("ktmu");
                    String optString6 = jSONObject.optString("asmrc", "0");
                    cn.jiguang.an.d.b("ShareProcessManager", "msg response,msgId:" + optString + ",fromPkg:" + optString2 + ",appKey:" + optString3 + ",rid:" + optString4 + ",uid:" + optString5 + ",responseCode:" + optString6);
                    if (optString6.equals("0") && !TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                        cn.jiguang.an.d.b("ShareProcessManager", "response success,will send msg response to server");
                        cn.jiguang.ap.b.b(context, JConstants.SDK_TYPE, 4, 2, n.b(), Long.parseLong(optString5), cn.jiguang.av.b.a(0, (byte) 0, Long.parseLong(optString), optString3));
                    } else if (optString6.equals("1") && !TextUtils.isEmpty(optString5)) {
                        a2.a(context, Long.parseLong(optString5));
                    } else if (!optString6.equals("3") || TextUtils.isEmpty(optString5)) {
                        cn.jiguang.an.d.b("ShareProcessManager", "invalid msg response");
                    } else {
                        a2.a(context, Long.parseLong(optString5));
                        cn.jiguang.e.a.a(context, optString2);
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.an.d.f("JCoreDispatchAction", "onActionRun failed:" + th.getMessage());
            }
        }
    }
}
