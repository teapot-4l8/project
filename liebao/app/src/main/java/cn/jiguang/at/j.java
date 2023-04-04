package cn.jiguang.at;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.ak;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3945a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3946b;

    /* renamed from: c  reason: collision with root package name */
    private String f3947c;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f3948d;

    public j(h hVar, Context context, String str, Bundle bundle) {
        this.f3945a = hVar;
        this.f3946b = context;
        this.f3947c = str;
        this.f3948d = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cn.jiguang.ar.i iVar;
        h hVar;
        cn.jiguang.ar.i iVar2;
        long j;
        String str;
        cn.jiguang.ar.i iVar3;
        try {
            if (this.f3947c.equals("tcp_a1")) {
                iVar3 = this.f3945a.f3939a;
                if (iVar3 != null) {
                    return;
                }
                hVar = this.f3945a;
            } else {
                if (!this.f3947c.equals("tcp_a3") && !this.f3947c.equals("tcp_a4") && !this.f3947c.equals("tcp_a20")) {
                    if (this.f3947c.equals("tcp_a5")) {
                        if (this.f3948d != null) {
                            byte[] byteArray = this.f3948d.getByteArray("body");
                            int i = this.f3948d.getInt("cmd", -1);
                            int i2 = this.f3948d.getInt("ver", -1);
                            long j2 = this.f3948d.getLong("rid", -1L);
                            String string = this.f3948d.getString(ak.u);
                            long j3 = this.f3948d.getLong("timeout");
                            cn.jiguang.an.d.b("JCoreTCPManager", "send quest,cmd:" + i + ",ver:" + i2 + ",rid:" + j2 + ",body size:" + byteArray.length);
                            if (i >= 0 && i2 >= 0 && j2 >= 0 && !TextUtils.isEmpty(string)) {
                                n.a().a(this.f3946b, j2, i, i2, byteArray, string, j3);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (this.f3947c.equals("tcp_a19")) {
                        h.d(this.f3945a);
                        return;
                    } else if (this.f3947c.equals("tcp_a11")) {
                        cn.jiguang.an.d.c("JCoreTCPManager", "resgiter success:" + cn.jiguang.d.a.b(this.f3946b));
                        b.a().a(this.f3946b, 0, 0, cn.jiguang.d.a.b(this.f3946b));
                        d.a(this.f3946b, "on_register", null);
                        return;
                    } else if (this.f3947c.equals("tcp_a10")) {
                        h.e(this.f3945a);
                        return;
                    } else if (this.f3947c.equals("tcp_a9")) {
                        h.a(this.f3945a, this.f3946b);
                        return;
                    } else if (this.f3947c.equals("tcp_a8")) {
                        h.b(this.f3945a, this.f3946b);
                        return;
                    } else if (this.f3947c.equals("tcp_a2")) {
                        f.a().a(this.f3946b, false);
                        this.f3945a.a(this.f3948d);
                        return;
                    } else if (this.f3947c.equals("tcp_a13")) {
                        cn.jiguang.an.d.c("JCoreTCPManager", "resgiter failed");
                        if (this.f3948d != null) {
                            int i3 = this.f3948d.getInt("resCode", 0);
                            this.f3945a.f3941c = i3;
                            Context context = this.f3946b;
                            String a2 = cn.jiguang.ay.c.a(i3);
                            cn.jiguang.an.d.i("ConnectingHelper", "Register Failed with server error - code:" + i3);
                            if (!TextUtils.isEmpty(a2)) {
                                cn.jiguang.an.d.g("ConnectingHelper", "Local error description: " + a2);
                            }
                            b.a().a(context, 0, i3, a2);
                            String a3 = cn.jiguang.am.a.a(context);
                            if (i3 != 11) {
                                if (i3 == 1012) {
                                    cn.jiguang.ar.c.a(context);
                                    return;
                                }
                                if (i3 != 10001) {
                                    switch (i3) {
                                        case 1005:
                                            str = "包名: " + context.getPackageName() + " 与 AppKey:" + a3 + "不匹配";
                                            break;
                                        case 1006:
                                            str = "包名: " + context.getPackageName() + " 不存在";
                                            break;
                                        case 1007:
                                            cn.jiguang.an.d.d("ConnectingHelper", "IMEI is duplicated reported by server. Give up now. ");
                                            return;
                                        case 1008:
                                            str = " AppKey:" + a3 + " 是无效的AppKey,请确认与JIGUANG web端的AppKey一致";
                                            break;
                                        case 1009:
                                            str = " AppKey:" + a3 + " 非android AppKey";
                                            break;
                                        default:
                                            cn.jiguang.an.d.d("ConnectingHelper", "Unhandled server response error code - " + i3);
                                            return;
                                    }
                                } else {
                                    str = " 未在manifest中配置AppKey";
                                }
                                cn.jiguang.f.a.a(context, str, -1);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (this.f3947c.equals("tcp_a12")) {
                        cn.jiguang.an.d.c("JCoreTCPManager", "login failed");
                        if (this.f3948d != null) {
                            h.b(this.f3945a, this.f3948d.getInt("resCode", 0));
                            return;
                        }
                        return;
                    } else if (!this.f3947c.equals("tcp_a14")) {
                        if (this.f3947c.equals("tcp_a15")) {
                            this.f3945a.b(this.f3948d);
                            return;
                        } else if (this.f3947c.equals("tcp_a16")) {
                            this.f3945a.c(this.f3948d);
                            return;
                        } else if (this.f3947c.equals("tcp_a17")) {
                            h.f(this.f3945a);
                            return;
                        } else if (this.f3947c.equals("tcp_a18")) {
                            h.g(this.f3945a);
                            return;
                        } else if (this.f3947c.equals("tcp_a6")) {
                            if (this.f3948d != null) {
                                long j4 = this.f3948d.getLong("rid", -1L);
                                if (j4 > 0) {
                                    n.a().a(this.f3946b, j4);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (this.f3947c.equals("tcp_a7")) {
                            if (this.f3948d != null) {
                                long j5 = this.f3948d.getLong("rid", -1L);
                                if (j5 > 0) {
                                    n.a().a(j5);
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (this.f3947c.equals("tcp_a21")) {
                            this.f3945a.e();
                            return;
                        } else if (this.f3947c.equals("tcp_a22")) {
                            this.f3945a.b();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        hVar = this.f3945a;
                    }
                }
                iVar = this.f3945a.f3939a;
                if (iVar != null) {
                    iVar2 = this.f3945a.f3939a;
                    if (iVar2.c() != null) {
                        byte[] byteArray2 = this.f3948d.getByteArray("body");
                        int i4 = this.f3948d.getInt("cmd", -1);
                        int i5 = this.f3948d.getInt("ver", -1);
                        long j6 = this.f3948d.getLong("rid", -1L);
                        String string2 = this.f3948d.getString(ak.u);
                        cn.jiguang.an.d.b("JCoreTCPManager", "send data,cmd:" + i4 + ",ver:" + i5 + ",rid:" + j6 + ",body size:" + byteArray2.length);
                        if (i4 >= 0 && i5 >= 0 && j6 >= 0) {
                            if (this.f3947c.equals("tcp_a3")) {
                                n.a().a(this.f3946b, j6, i4, i5, byteArray2, string2);
                                return;
                            }
                            if (this.f3947c.equals("tcp_a20")) {
                                long j7 = this.f3948d.getLong("uid", 0L);
                                if (j7 == 0) {
                                    cn.jiguang.an.d.f("JCoreTCPManager", "share response uid is 0");
                                    return;
                                }
                                j = j7;
                            } else {
                                j = 0;
                            }
                            h.a().c().c().a(cn.jiguang.av.b.a(this.f3946b, i4, i5, j6, byteArray2, j));
                            return;
                        }
                        return;
                    }
                    return;
                }
                cn.jiguang.an.d.b("JCoreTCPManager", "send data failed:tcp breaked,will restart");
                hVar = this.f3945a;
            }
            hVar.h();
        } catch (Throwable th) {
            cn.jiguang.an.d.g("JCoreTCPManager", "tcp action failed:" + th.getMessage());
        }
    }
}
