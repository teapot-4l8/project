package cn.jpush.android.d;

import android.content.Context;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.u.g;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static Queue<a> f4309a;

    public static synchronized void a(Context context, String str) {
        synchronized (c.class) {
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
                return;
            }
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                Logger.w("MsgQueueUtils", "can't get files dir");
                return;
            }
            File file = new File(filesDir, str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static synchronized void a(Context context, String str, ArrayList<a> arrayList) {
        synchronized (c.class) {
            Logger.v("MsgQueueUtils", "Action - saveObjects");
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
            } else if (arrayList == null) {
                Logger.w("MsgQueueUtils", "mObjectList is null");
            } else {
                File file = new File(context.getFilesDir(), str);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayList.size(); i++) {
                    jSONArray.put(arrayList.get(i).a());
                }
                cn.jpush.android.u.c.a(file.getAbsolutePath(), jSONArray.toString());
            }
        }
    }

    public static boolean a(Context context, a aVar) {
        if (f4309a == null) {
            f4309a = new ConcurrentLinkedQueue();
            try {
                ArrayList<a> b2 = b(context, "msg_queue_v350");
                if (b2 != null && !b2.isEmpty()) {
                    Iterator<a> it = b2.iterator();
                    while (it.hasNext()) {
                        f4309a.offer(it.next());
                    }
                }
            } catch (Exception e2) {
                Logger.ww("MsgQueueUtils", "init lastMsgQueue failed:" + e2.getMessage());
            }
        }
        if (context == null) {
            Logger.ww("MsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (aVar == null) {
            Logger.ww("MsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (f4309a.contains(aVar)) {
            Logger.e("MsgQueueUtils", "Duplicated msg. Give up processing - " + aVar);
            return true;
        }
        if (f4309a.size() >= 200) {
            f4309a.poll();
        }
        f4309a.offer(aVar);
        try {
            ArrayList<a> b3 = b(context, "msg_queue_v350");
            if (b3 == null) {
                b3 = new ArrayList<>();
            }
            if (b3.size() >= 50) {
                b3.remove(0);
            }
            b3.add(aVar);
            a(context, "msg_queue_v350", b3);
        } catch (Exception e3) {
            Logger.ww("MsgQueueUtils", "msg save in sp failed:" + e3.getMessage());
        }
        return false;
    }

    public static synchronized ArrayList<a> b(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (c.class) {
            FileInputStream fileInputStream2 = null;
            if (context == null) {
                Logger.w("MsgQueueUtils", "unexcepted , context is null");
                return null;
            }
            ArrayList<a> arrayList = new ArrayList<>();
            try {
                File file = new File(context.getFilesDir(), str);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        JSONArray jSONArray = new JSONArray(new String(g.a((InputStream) fileInputStream)));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(a.a(jSONArray.getJSONObject(i)));
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        Logger.w("MsgQueueUtils", "load objects error:" + th.getMessage());
                        a(context, str);
                        g.a((Closeable) fileInputStream);
                        return arrayList;
                    }
                }
                g.a((Closeable) fileInputStream2);
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
            return arrayList;
        }
    }
}
