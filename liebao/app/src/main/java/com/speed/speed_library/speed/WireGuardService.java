package com.speed.speed_library.speed;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.VpnService;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.speed.speed_library.R;
import com.speed.speed_library.a;
import com.speed.speed_library.speed.b;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.u;
import kotlin.d.b.m;
import kotlin.d.b.o;
import kotlin.reflect.KProperty;
import wg.Callback;
import wg.Wg;

/* compiled from: WireGuardService.kt */
/* loaded from: classes2.dex */
public final class WireGuardService extends VpnService {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty[] f5825a = {o.a(new m(o.a(WireGuardService.class), "sp", "getSp()Landroid/content/SharedPreferences;")), o.a(new m(o.a(WireGuardService.class), "smartRoutePath", "getSmartRoutePath()Ljava/lang/String;")), o.a(new m(o.a(WireGuardService.class), "sMainHandler", "getSMainHandler$speed_library_release()Landroid/os/Handler;"))};
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final b f5826b = new b(null);

    /* renamed from: c  reason: collision with root package name */
    private float f5827c;

    /* renamed from: d  reason: collision with root package name */
    private a f5828d;

    /* renamed from: e  reason: collision with root package name */
    private ParcelFileDescriptor f5829e;
    private int f;
    private com.speed.speed_library.speed.b g;
    private final kotlin.b h;
    private String i;
    private String j;
    private final kotlin.b k;
    private final Handler l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;

    /* renamed from: q  reason: collision with root package name */
    private final String f5830q;
    private long r;
    private final RemoteCallbackList<com.speed.speed_library.b> s;
    private final a.AbstractBinderC0132a t;
    private MediaPlayer u;
    private final kotlin.b v;
    private c w;
    private boolean x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    public static final class h implements MediaPlayer.OnErrorListener {

        /* renamed from: a  reason: collision with root package name */
        public static final h f5841a = new h();

        h() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            return false;
        }
    }

    private final String c() {
        kotlin.b bVar = this.k;
        KProperty kProperty = f5825a[1];
        return (String) bVar.a();
    }

    public final Handler b() {
        kotlin.b bVar = this.v;
        KProperty kProperty = f5825a[2];
        return (Handler) bVar.a();
    }

    public WireGuardService() {
        System.loadLibrary("gojni");
        this.f = 4;
        this.h = kotlin.c.a(new k());
        this.i = "";
        this.j = "";
        this.k = kotlin.c.a(new j());
        this.l = new Handler(Looper.getMainLooper());
        this.m = "99";
        this.n = "100";
        this.o = "101";
        this.p = "102";
        this.f5830q = "102";
        this.s = new RemoteCallbackList<>();
        this.t = new d();
        this.v = kotlin.c.a(i.f5842a);
    }

    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    static final class k extends kotlin.d.b.j implements kotlin.d.a.a<SharedPreferences> {
        k() {
            super(0);
        }

        @Override // kotlin.d.a.a
        /* renamed from: b */
        public final SharedPreferences a() {
            return WireGuardService.this.getSharedPreferences("WG.config", 0);
        }
    }

    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    static final class j extends kotlin.d.b.j implements kotlin.d.a.a<String> {
        j() {
            super(0);
        }

        @Override // kotlin.d.a.a
        /* renamed from: b */
        public final String a() {
            Context applicationContext = WireGuardService.this.getApplicationContext();
            kotlin.d.b.i.a((Object) applicationContext, "applicationContext");
            File filesDir = applicationContext.getFilesDir();
            kotlin.d.b.i.a((Object) filesDir, "applicationContext.filesDir");
            return filesDir.getAbsolutePath();
        }
    }

    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.d.b.g gVar) {
            this();
        }
    }

    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    public static final class d extends a.AbstractBinderC0132a {
        d() {
        }

        @Override // com.speed.speed_library.a
        public void b() {
            WireGuardService.a(WireGuardService.this, null, 1, null);
        }

        @Override // com.speed.speed_library.a
        public void a(com.speed.speed_library.b bVar) {
            kotlin.d.b.i.b(bVar, "callback");
            WireGuardService.this.s.register(bVar);
        }

        @Override // com.speed.speed_library.a
        public void b(com.speed.speed_library.b bVar) {
            kotlin.d.b.i.b(bVar, "callback");
            WireGuardService.this.s.unregister(bVar);
        }

        @Override // com.speed.speed_library.a
        public int a() {
            return WireGuardService.this.f;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.speed.speed_library.speed.a.a(this, "onCreate");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        com.speed.speed_library.speed.a.a(this, "onStartCommand");
        a(this, 1, null, 2, null);
        g();
        a(intent);
        new Thread(new f()).start();
        com.speed.speed_library.speed.b bVar = this.g;
        if (bVar != null && bVar.h() == 1) {
            h();
            j();
        }
        return 2;
    }

    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    static final class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            WireGuardService.this.l.post(new Runnable() { // from class: com.speed.speed_library.speed.WireGuardService.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        WireGuardService.this.d();
                    } catch (Exception e2) {
                        WireGuardService wireGuardService = WireGuardService.this;
                        com.speed.speed_library.speed.a.a(wireGuardService, "连接失败 =" + e2.getMessage());
                        WireGuardService wireGuardService2 = WireGuardService.this;
                        wireGuardService2.a(WireGuardService.this.n + e2.getMessage());
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // android.net.VpnService, android.app.Service
    public IBinder onBind(Intent intent) {
        kotlin.d.b.i.b(intent, "intent");
        com.speed.speed_library.speed.a.a(this, "onBind with action = " + intent.getAction());
        a(intent);
        String action = intent.getAction();
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode == -700396143) {
                if (action.equals("android.net.VpnService")) {
                    return super.onBind(intent);
                }
            } else if (hashCode == 1869978999 && action.equals("WG.SERVICE")) {
                return this.t;
            }
        }
        return null;
    }

    @Override // android.net.VpnService
    public void onRevoke() {
        com.speed.speed_library.speed.a.a(this, "onRevoke");
        super.onRevoke();
        i();
        a(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:80|(1:147)(1:84)|(1:86)|87|(1:146)(1:91)|(1:93)|94|(5:96|(1:126)(1:100)|(1:102)|103|(8:105|106|(1:108)(1:120)|109|(1:111)(1:119)|(1:113)|114|(4:116|117|(4:64|(6:67|68|69|71|72|65)|76|77)|78)(1:118)))|127|128|(1:130)(1:140)|131|(1:135)|136|(4:138|117|(0)|78)(1:139)) */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x027c, code lost:
        r0 = new java.lang.StringBuilder();
        r0.append("Default SmartRoute file [assets/");
        r3 = r20.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0287, code lost:
        if (r3 != null) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0289, code lost:
        r3 = r3.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x028e, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x028f, code lost:
        r0.append(r3);
        r0.append("] doesn't exist");
        com.speed.speed_library.speed.a.a(r2, r0.toString());
        r2.addRoute("0.0.0.0", 0);
     */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d() {
        com.speed.speed_library.speed.b bVar;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String d2;
        InputStreamReader inputStreamReader;
        b.C0155b a2;
        b.C0155b a3;
        b.C0155b a4;
        com.speed.speed_library.speed.b bVar2;
        ArrayList<String> c2;
        b.C0155b a5;
        b.C0155b a6;
        b.C0155b a7;
        com.speed.speed_library.speed.a.a(this, "Trying to establish Vpn");
        VpnService.Builder builder = new VpnService.Builder(this);
        builder.setSession(com.speed.speed_library.speed.a.a());
        com.speed.speed_library.speed.b bVar3 = this.g;
        String str = "";
        String str2 = (bVar3 == null || (a7 = bVar3.a()) == null || (str2 = a7.e()) == null) ? "" : "";
        com.speed.speed_library.speed.b bVar4 = this.g;
        builder.addAddress(str2, (bVar4 == null || (a6 = bVar4.a()) == null) ? 0 : a6.m());
        builder.addDnsServer("22.0.0.1");
        BufferedReader bufferedReader3 = null;
        if (Build.VERSION.SDK_INT >= 21) {
            StringBuilder sb = new StringBuilder();
            sb.append("Set DisallowPackages start::");
            com.speed.speed_library.speed.b bVar5 = this.g;
            sb.append((bVar5 == null || (a5 = bVar5.a()) == null) ? null : Integer.valueOf(a5.i()));
            String sb2 = sb.toString();
            if (sb2 == null) {
                sb2 = "88";
            }
            com.speed.speed_library.speed.a.a(builder, sb2);
            builder.addDisallowedApplication(getPackageName());
            com.speed.speed_library.speed.b bVar6 = this.g;
            if (bVar6 != null && bVar6.i() == 1 && (bVar2 = this.g) != null && (c2 = bVar2.c()) != null) {
                Iterator<String> it = c2.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    try {
                        builder.addDisallowedApplication(next);
                        com.speed.speed_library.speed.a.a(builder, "不走vpn的包名 = " + next);
                    } catch (Exception e2) {
                        com.speed.speed_library.speed.a.a(builder, "addDisallowedApplication error = " + e2);
                    }
                }
            }
        } else {
            com.speed.speed_library.speed.a.a(builder, "Disallow packages is not supported");
        }
        com.speed.speed_library.speed.b bVar7 = this.g;
        if ((bVar7 != null && bVar7.b() == 0) || !f() || ((bVar = this.g) != null && bVar.i() == 1)) {
            com.speed.speed_library.speed.a.a(builder, "SmartRoute is disabled");
            builder.addRoute("0.0.0.0", 0);
        } else {
            com.speed.speed_library.speed.a.a(builder, "Set SmartRoute start");
            File file = new File(c(), "cidr.txt");
            if (file.exists()) {
                com.speed.speed_library.speed.a.a(builder, "Read downloaded SmartRoute file [" + file.getAbsolutePath() + ']');
                InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(file), kotlin.h.d.f7190a);
                bufferedReader = inputStreamReader2 instanceof BufferedReader ? (BufferedReader) inputStreamReader2 : new BufferedReader(inputStreamReader2, 8192);
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" SmartRoute type_name [");
                com.speed.speed_library.speed.b bVar8 = this.g;
                String b2 = (bVar8 == null || (a4 = bVar8.a()) == null) ? null : a4.b();
                if (b2 == null) {
                    kotlin.d.b.i.a();
                }
                sb3.append(b2);
                sb3.append(']');
                com.speed.speed_library.speed.a.a(builder, sb3.toString());
                com.speed.speed_library.speed.b bVar9 = this.g;
                String b3 = (bVar9 == null || (a3 = bVar9.a()) == null) ? null : a3.b();
                if (b3 == null) {
                    kotlin.d.b.i.a();
                }
                if (!TextUtils.isEmpty(b3)) {
                    com.speed.speed_library.speed.b bVar10 = this.g;
                    String b4 = (bVar10 == null || (a2 = bVar10.a()) == null) ? null : a2.b();
                    if (b4 == null) {
                        kotlin.d.b.i.a();
                    }
                    if (!kotlin.h.g.b(b4, "CN", false, 2, (Object) null)) {
                        try {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Read default SmartRoute file [assets/");
                            com.speed.speed_library.speed.b bVar11 = this.g;
                            sb4.append(bVar11 != null ? bVar11.e() : null);
                            sb4.append(']');
                            com.speed.speed_library.speed.a.a(builder, sb4.toString());
                            AssetManager assets = getAssets();
                            com.speed.speed_library.speed.b bVar12 = this.g;
                            String e3 = bVar12 != null ? bVar12.e() : null;
                            if (e3 == null) {
                                kotlin.d.b.i.a();
                            }
                            InputStream open = assets.open(e3);
                            kotlin.d.b.i.a((Object) open, "assets.open(mConfig?.toChinaRouteFileName!!)");
                            inputStreamReader = new InputStreamReader(open, kotlin.h.d.f7190a);
                        } catch (Exception unused) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Default SmartRoute file [assets/");
                            com.speed.speed_library.speed.b bVar13 = this.g;
                            sb5.append(bVar13 != null ? bVar13.e() : null);
                            sb5.append("] doesn't exist");
                            com.speed.speed_library.speed.a.a(builder, sb5.toString());
                            builder.addRoute("0.0.0.0", 0);
                        }
                        if (inputStreamReader instanceof BufferedReader) {
                            bufferedReader2 = (BufferedReader) inputStreamReader;
                            bufferedReader3 = bufferedReader2;
                            if (bufferedReader3 != null) {
                                Iterator a8 = kotlin.g.c.a(kotlin.c.b.a(bufferedReader3), e.f5836a).a();
                                while (a8.hasNext()) {
                                    List list = (List) a8.next();
                                    try {
                                        String str3 = (String) list.get(0);
                                        int parseInt = Integer.parseInt((String) list.get(1));
                                        com.speed.speed_library.speed.a.a(builder, "SmartRoute ip = " + str3 + " prefixLength =" + parseInt);
                                        builder.addRoute(str3, parseInt);
                                    } catch (Exception e4) {
                                        com.speed.speed_library.speed.a.a(builder, "Error occurs when set SmartRoute = " + kotlin.a.h.a(list, ",", null, null, 0, null, null, 62, null) + ", error = " + e4);
                                    }
                                }
                                bufferedReader3.close();
                                com.speed.speed_library.speed.a.a(builder, "Set SmartRoute end");
                            }
                            builder.addRoute("22.0.0.1", 32);
                        } else {
                            bufferedReader = new BufferedReader(inputStreamReader, 8192);
                        }
                    }
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Read default SmartRoute file [assets/");
                com.speed.speed_library.speed.b bVar14 = this.g;
                sb6.append(bVar14 != null ? bVar14.d() : null);
                sb6.append(']');
                com.speed.speed_library.speed.a.a(builder, sb6.toString());
                AssetManager assets2 = getAssets();
                com.speed.speed_library.speed.b bVar15 = this.g;
                if (bVar15 != null && (d2 = bVar15.d()) != null) {
                    str = d2;
                }
                InputStream open2 = assets2.open(str);
                kotlin.d.b.i.a((Object) open2, "assets.open(mConfig?.sma…RouteLocalFilename ?: \"\")");
                InputStreamReader inputStreamReader3 = new InputStreamReader(open2, kotlin.h.d.f7190a);
                if (inputStreamReader3 instanceof BufferedReader) {
                    bufferedReader2 = (BufferedReader) inputStreamReader3;
                    bufferedReader3 = bufferedReader2;
                    if (bufferedReader3 != null) {
                    }
                    builder.addRoute("22.0.0.1", 32);
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader3, 8192);
                }
            }
            bufferedReader3 = bufferedReader;
            if (bufferedReader3 != null) {
            }
            builder.addRoute("22.0.0.1", 32);
        }
        this.f5829e = builder.establish();
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.d.b.j implements kotlin.d.a.b<String, List<? extends String>> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f5836a = new e();

        e() {
            super(1);
        }

        @Override // kotlin.d.a.b
        public final List<String> a(String str) {
            boolean z;
            kotlin.d.b.i.b(str, "it");
            List<String> a2 = new kotlin.h.f("/").a(str, 0);
            if (!a2.isEmpty()) {
                ListIterator<String> listIterator = a2.listIterator(a2.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        return kotlin.a.h.b(a2, listIterator.nextIndex() + 1);
                    }
                }
            }
            return kotlin.a.h.a();
        }
    }

    private final void e() {
        b.C0155b c0155b;
        b.C0155b a2;
        b.C0155b a3;
        ParcelFileDescriptor parcelFileDescriptor = this.f5829e;
        if (parcelFileDescriptor != null) {
            long fd = parcelFileDescriptor.getFd();
            File file = new File(getApplicationInfo().dataDir + '/' + com.speed.speed_library.speed.a.a() + ".log");
            if (!file.exists()) {
                file.createNewFile();
                com.speed.speed_library.speed.a.a(this, "WireGuard log_path =" + file.getAbsolutePath());
            }
            com.speed.speed_library.speed.b bVar = this.g;
            String f2 = (bVar == null || (a3 = bVar.a()) == null) ? null : a3.f();
            if (f2 == null) {
                kotlin.d.b.i.a();
            }
            String str = (String) kotlin.h.g.b((CharSequence) f2, new String[]{","}, false, 0, 6, (Object) null).get(0);
            com.speed.speed_library.speed.b bVar2 = this.g;
            String f3 = (bVar2 == null || (a2 = bVar2.a()) == null) ? null : a2.f();
            if (f3 == null) {
                kotlin.d.b.i.a();
            }
            String str2 = (String) kotlin.h.g.b((CharSequence) f3, new String[]{","}, false, 0, 6, (Object) null).get(1);
            com.speed.speed_library.speed.b bVar3 = this.g;
            if (bVar3 == null || (c0155b = bVar3.a()) == null) {
                c0155b = new b.C0155b();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                \"listen_port\":\"");
            sb.append(c0155b.l());
            sb.append("\",\n                \"own_private\":\"");
            sb.append(str);
            sb.append("\",\n                \"own_public\":\"");
            sb.append(str2);
            sb.append("\",\n                \"their_public\":\"");
            sb.append(c0155b.c());
            sb.append("\",\n                \"endpoint\":\"");
            sb.append(c0155b.d());
            sb.append("\",\n                \"log_path\":\"");
            sb.append(getApplicationInfo().dataDir);
            sb.append('/');
            sb.append(com.speed.speed_library.speed.a.a());
            sb.append(".log\",\n\t            \"allow_ip\":\"");
            sb.append(c0155b.e());
            sb.append("\",\n\t            \"netmask\":");
            sb.append(c0155b.k());
            sb.append(",\n\t            \"is_add\":");
            sb.append(c0155b.h());
            sb.append(",\n\t            \"interval_time\":");
            sb.append(c0155b.j());
            sb.append(",\n\t            \"ts\":");
            sb.append(c0155b.a());
            sb.append(",\n\t            \"sign\":\"");
            sb.append(c0155b.g());
            sb.append("\",\n                \"report_url\":\"");
            com.speed.speed_library.speed.b bVar4 = this.g;
            sb.append(bVar4 != null ? bVar4.f() : null);
            sb.append("\",\n\t            \"flow_status\":1,\n                \"smartRoute\":");
            com.speed.speed_library.speed.b bVar5 = this.g;
            sb.append(bVar5 != null ? Integer.valueOf(bVar5.b()) : null);
            sb.append(",\n                \"netKill\":");
            com.speed.speed_library.speed.b bVar6 = this.g;
            sb.append(bVar6 != null ? Integer.valueOf(bVar6.g()) : null);
            sb.append("\n                }\n            ");
            String sb2 = sb.toString();
            com.speed.speed_library.speed.a.a(this, "wg config = " + sb2);
            String init = Wg.init(fd, sb2);
            if (TextUtils.isEmpty(init)) {
                a aVar = new a();
                this.f5828d = aVar;
                if (aVar == null) {
                    kotlin.d.b.i.a();
                }
                aVar.start();
                a(2, this.m + a());
                return;
            }
            com.speed.speed_library.speed.a.a(this, "wg init error = " + init);
            a(this.n + a());
        }
    }

    public static /* synthetic */ void a(WireGuardService wireGuardService, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        wireGuardService.a(str);
    }

    public final void a(String str) {
        kotlin.d.b.i.b(str, JThirdPlatFormInterface.KEY_MSG);
        com.speed.speed_library.speed.a.a(this, "DisconnectVpn");
        a(3, str);
        a aVar = this.f5828d;
        if (aVar != null) {
            aVar.a();
        }
        this.f5828d = null;
        ParcelFileDescriptor parcelFileDescriptor = this.f5829e;
        if (parcelFileDescriptor != null) {
            parcelFileDescriptor.close();
        }
        this.f5829e = null;
        this.f5827c = 0.0f;
        a(4, str);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        i();
        stopSelf();
        com.speed.speed_library.speed.a.a(this, "Exiting");
        System.exit(0);
    }

    static /* synthetic */ void a(WireGuardService wireGuardService, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        wireGuardService.a(i2, str);
    }

    private final void a(int i2, String str) {
        if (this.f != i2) {
            int beginBroadcast = this.s.beginBroadcast();
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                com.speed.speed_library.speed.a.a(this, "callbacks" + this.s.getBroadcastItem(i3));
            }
            kotlin.f.c b2 = kotlin.f.d.b(0, beginBroadcast);
            ArrayList<com.speed.speed_library.b> arrayList = new ArrayList(kotlin.a.h.a(b2, 10));
            Iterator<Integer> it = b2.iterator();
            while (it.hasNext()) {
                arrayList.add(this.s.getBroadcastItem(((u) it).b()));
            }
            for (com.speed.speed_library.b bVar : arrayList) {
                try {
                    bVar.a(i2, str);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            this.s.finishBroadcast();
        }
        this.f = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long j2, long j3) {
        int beginBroadcast = this.s.beginBroadcast();
        for (int i2 = 0; i2 < beginBroadcast; i2++) {
            com.speed.speed_library.speed.a.a(this, "callbacks" + this.s.getBroadcastItem(i2));
        }
        kotlin.f.c b2 = kotlin.f.d.b(0, beginBroadcast);
        ArrayList<com.speed.speed_library.b> arrayList = new ArrayList(kotlin.a.h.a(b2, 10));
        Iterator<Integer> it = b2.iterator();
        while (it.hasNext()) {
            arrayList.add(this.s.getBroadcastItem(((u) it).b()));
        }
        for (com.speed.speed_library.b bVar : arrayList) {
            try {
                bVar.a(j2, j3);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.s.finishBroadcast();
    }

    private final boolean f() {
        boolean z = Build.VERSION.SDK_INT >= 23;
        if (!z) {
            com.speed.speed_library.speed.a.a(this, "Smart route is unsupported");
        }
        return z;
    }

    private final void a(Intent intent) {
        com.speed.speed_library.speed.b bVar;
        if (intent == null || (bVar = (com.speed.speed_library.speed.b) intent.getParcelableExtra("configExtra")) == null) {
            return;
        }
        this.g = bVar;
    }

    private final void g() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(com.speed.speed_library.speed.a.a(), com.speed.speed_library.speed.a.a(), 2);
            Object systemService = getSystemService("notification");
            if (systemService == null) {
                throw new kotlin.i("null cannot be cast to non-null type android.app.NotificationManager");
            }
            ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
            Notification.Builder builder = new Notification.Builder(getApplicationContext(), com.speed.speed_library.speed.a.a());
            builder.setOngoing(true).setWhen(System.currentTimeMillis());
            startForeground(1, builder.build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    public final class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private OutputStream f5832b;

        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com.speed.speed_library.speed.a.a(this, "start background thread");
            try {
                this.f5832b = new ParcelFileDescriptor.AutoCloseOutputStream(ParcelFileDescriptor.createPipe()[1]);
                Wg.start(new C0154a());
            } catch (Exception e2) {
                e2.printStackTrace();
                com.speed.speed_library.speed.a.a(this, "BackgroundThread error = " + e2);
            }
        }

        /* compiled from: WireGuardService.kt */
        /* renamed from: com.speed.speed_library.speed.WireGuardService$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0154a implements Callback {
            C0154a() {
            }

            @Override // wg.Callback
            public void callStatus(long j) {
                com.speed.speed_library.speed.b bVar;
                com.speed.speed_library.speed.a.a(this, "callStatus" + j);
                if (j != 101) {
                    if (j == 102) {
                        WireGuardService wireGuardService = WireGuardService.this;
                        wireGuardService.a(WireGuardService.this.p + WireGuardService.this.a());
                    }
                } else if (WireGuardService.this.g == null || (bVar = WireGuardService.this.g) == null || bVar.g() != 0) {
                    WireGuardService wireGuardService2 = WireGuardService.this;
                    wireGuardService2.a(WireGuardService.this.o + WireGuardService.this.a());
                }
            }

            @Override // wg.Callback
            public void callDownFlow(long j) {
                com.speed.speed_library.speed.a.a(this, "callDownFlow" + j);
                WireGuardService.this.r = j;
            }

            @Override // wg.Callback
            public void callUpFlow(long j) {
                com.speed.speed_library.speed.a.a(this, "callUpFlow" + j);
                WireGuardService.this.a(j, WireGuardService.this.r);
            }

            @Override // wg.Callback
            public void callFd(long j) {
                int i = (int) j;
                WireGuardService.this.protect(i);
                com.speed.speed_library.speed.a.a(this, "callFd::" + i);
            }
        }

        public final void a() {
            com.speed.speed_library.speed.a.a(this, "Stop background thread");
            try {
                OutputStream outputStream = this.f5832b;
                if (outputStream != null) {
                    outputStream.write(0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            OutputStream outputStream2 = this.f5832b;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            this.f5832b = null;
        }
    }

    public final String a() {
        File file = new File(getApplicationInfo().dataDir + '/' + com.speed.speed_library.speed.a.a() + ".log");
        if (file.exists()) {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), kotlin.h.d.f7190a);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            String a2 = kotlin.c.b.a((Reader) bufferedReader);
            bufferedReader.close();
            return a2;
        }
        return "";
    }

    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    static final class i extends kotlin.d.b.j implements kotlin.d.a.a<Handler> {

        /* renamed from: a  reason: collision with root package name */
        public static final i f5842a = new i();

        i() {
            super(0);
        }

        @Override // kotlin.d.a.a
        /* renamed from: b */
        public final Handler a() {
            return new Handler(Looper.getMainLooper());
        }
    }

    public final boolean a(Context context) {
        kotlin.d.b.i.b(context, "$this$isScreenOn");
        try {
            Object systemService = context.getApplicationContext().getSystemService("power");
            if (systemService == null) {
                throw new kotlin.i("null cannot be cast to non-null type android.os.PowerManager");
            }
            return ((PowerManager) systemService).isScreenOn();
        } catch (Exception unused) {
            return false;
        }
    }

    private final void h() {
        if (this.w == null) {
            this.w = new c();
        }
        c cVar = this.w;
        if (cVar != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            registerReceiver(cVar, intentFilter);
        }
    }

    private final void i() {
        c cVar;
        com.speed.speed_library.speed.b bVar = this.g;
        if (bVar == null || bVar.h() != 1 || (cVar = this.w) == null) {
            return;
        }
        unregisterReceiver(cVar);
        this.w = null;
    }

    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    public final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            if (intent == null || (action = intent.getAction()) == null) {
                return;
            }
            int hashCode = action.hashCode();
            if (hashCode == -2128145023) {
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    com.speed.speed_library.speed.a.a(action, "screen off");
                    WireGuardService.this.k();
                }
            } else if (hashCode == -1454123155 && action.equals("android.intent.action.SCREEN_ON")) {
                com.speed.speed_library.speed.a.a(action, "screen on");
                WireGuardService.this.l();
            }
        }
    }

    private final void j() {
        if (this.u == null) {
            this.u = MediaPlayer.create(this, R.raw.main);
        }
        MediaPlayer mediaPlayer = this.u;
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(new g());
            mediaPlayer.setOnErrorListener(h.f5841a);
            if (a((Context) this)) {
                return;
            }
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WireGuardService.kt */
    /* loaded from: classes2.dex */
    public static final class g implements MediaPlayer.OnCompletionListener {
        g() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            WireGuardService.this.b().postDelayed(new Runnable() { // from class: com.speed.speed_library.speed.WireGuardService.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    WireGuardService.this.x = false;
                    WireGuardService.this.k();
                }
            }, 4L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        MediaPlayer mediaPlayer = this.u;
        if (mediaPlayer == null || this.x) {
            return;
        }
        mediaPlayer.start();
        this.x = true;
        com.speed.speed_library.speed.a.a(mediaPlayer, "music is playing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        MediaPlayer mediaPlayer = this.u;
        if (mediaPlayer == null || !this.x) {
            return;
        }
        mediaPlayer.pause();
        this.x = false;
        com.speed.speed_library.speed.a.a(mediaPlayer, "music is pause");
    }
}
