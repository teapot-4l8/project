package cn.jpush.android.p;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static Queue<Integer> f4434a = new ConcurrentLinkedQueue();

    public static int a() {
        if (f4434a.size() > 0) {
            return f4434a.poll().intValue();
        }
        return 0;
    }

    public static boolean a(int i) {
        return f4434a.offer(Integer.valueOf(i));
    }

    public static int b() {
        return f4434a.size();
    }

    public static boolean b(int i) {
        return f4434a.contains(Integer.valueOf(i));
    }
}
