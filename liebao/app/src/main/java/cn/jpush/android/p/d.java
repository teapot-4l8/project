package cn.jpush.android.p;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.p.b;
import cn.jpush.android.service.SchedulerReceiver;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f4426a;

    /* renamed from: b  reason: collision with root package name */
    private LinkedList<a> f4427b;

    /* renamed from: c  reason: collision with root package name */
    private final Comparator<a> f4428c = new Comparator<a>() { // from class: cn.jpush.android.p.d.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            if (aVar.f4430a < aVar2.f4430a) {
                return -1;
            }
            return aVar.f4430a == aVar2.f4430a ? 0 : 1;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f4430a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4431b;

        /* renamed from: c  reason: collision with root package name */
        private cn.jpush.android.d.d f4432c;

        /* renamed from: d  reason: collision with root package name */
        private int f4433d;

        public a(long j, int i) {
            this.f4430a = j;
            this.f4431b = false;
            this.f4433d = i;
        }

        public a(long j, cn.jpush.android.d.d dVar) {
            this.f4430a = j;
            this.f4431b = true;
            this.f4432c = dVar;
        }

        public a(JSONObject jSONObject) {
            try {
                this.f4430a = jSONObject.getLong("operationTime");
                this.f4431b = jSONObject.optBoolean("showOrDismiss");
                String optString = jSONObject.optString("pushEntity");
                if (!TextUtils.isEmpty(optString)) {
                    this.f4432c = cn.jpush.android.d.d.a(optString);
                }
                this.f4433d = jSONObject.optInt("notifyId");
            } catch (Throwable unused) {
            }
        }

        public JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("operationTime", this.f4430a);
                jSONObject.put("showOrDismiss", this.f4431b);
                if (this.f4431b) {
                    jSONObject.put("pushEntity", this.f4432c != null ? this.f4432c.c() : null);
                } else {
                    jSONObject.put("notifyId", this.f4433d);
                }
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public String toString() {
            return "Item{operationTime=" + this.f4430a + ", showOrDismiss=" + this.f4431b + ", pushEntity=" + this.f4432c + ", notifyId=" + this.f4433d + '}';
        }
    }

    private d() {
    }

    public static d a() {
        if (f4426a == null) {
            synchronized (d.class) {
                if (f4426a == null) {
                    f4426a = new d();
                }
            }
        }
        return f4426a;
    }

    private static void a(Context context, LinkedList<a> linkedList, long j, a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.f4430a > j) {
            linkedList.add(aVar);
        } else if (!aVar.f4431b) {
            Logger.d("NotificationScheduler", "cancelNotification:" + aVar);
            b.c(context, aVar.f4433d);
        } else if (b.c(context, aVar.f4432c)) {
            Logger.d("NotificationScheduler", "item: " + aVar + " already cancel");
        } else {
            long b2 = cn.jpush.android.u.b.b(aVar.f4432c.ak);
            int a2 = b.a(aVar.f4432c);
            if (b2 <= 0) {
                Logger.d("NotificationScheduler", "handleNotification:" + aVar);
                b.a.a(context, aVar.f4432c);
            } else if (b2 <= j) {
                Logger.d("NotificationScheduler", "cancelNotification:" + aVar);
                b.c(context, a2);
            } else {
                Logger.d("NotificationScheduler", "handleNotification:" + aVar);
                b.a.a(context, aVar.f4432c);
                linkedList.add(new a(b2, a2));
            }
        }
    }

    private void b(Context context, a aVar) {
        try {
            Logger.d("NotificationScheduler", "schedule item=" + aVar);
            Intent intent = new Intent(context, SchedulerReceiver.class);
            intent.setAction(SchedulerReceiver.DELAY_NOTIFY);
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 1000, intent, 0);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    alarmManager.setWindow(0, aVar.f4430a, 300L, broadcast);
                } else {
                    alarmManager.set(0, aVar.f4430a, broadcast);
                }
                Logger.d("NotificationScheduler", "setAlarm at=" + cn.jpush.android.u.b.a("yyyy-MM-dd HH:mm:ss").format(new Date(aVar.f4430a)));
            }
        } catch (Throwable th) {
            Logger.ww("NotificationScheduler", "can't trigger alarm cause by exception:" + th);
        }
    }

    public void a(Context context) {
        this.f4427b = new LinkedList<>();
        String str = (String) Sp.get(context, Key.NotiSchedule());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f4427b.add(new a(jSONArray.getJSONObject(i)));
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Context context, a aVar) {
        a(context);
        LinkedList<a> linkedList = new LinkedList<>();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = aVar != null;
        Iterator<a> it = this.f4427b.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (z && next.f4430a > aVar.f4430a) {
                a(context, linkedList, currentTimeMillis, aVar);
                z = false;
            }
            a(context, linkedList, currentTimeMillis, next);
        }
        if (z) {
            a(context, linkedList, currentTimeMillis, aVar);
        }
        this.f4427b = linkedList;
        b(context);
        if (!linkedList.isEmpty()) {
            b(context, linkedList.getFirst());
        }
    }

    public void b(Context context) {
        String str;
        LinkedList<a> linkedList = this.f4427b;
        if (linkedList == null || linkedList.isEmpty()) {
            str = null;
        } else {
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = this.f4427b.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a());
            }
            str = jSONArray.toString();
        }
        Collections.sort(this.f4427b, this.f4428c);
        Sp.set(context, Key.NotiSchedule().set(str));
    }
}
