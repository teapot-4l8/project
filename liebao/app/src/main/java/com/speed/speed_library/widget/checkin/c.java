package com.speed.speed_library.widget.checkin;

import com.umeng.analytics.pro.ak;
import java.util.Calendar;
import java.util.TimeZone;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: DateUtil.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5937a = new a(null);

    /* compiled from: DateUtil.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final int a() {
            Calendar calendar = Calendar.getInstance();
            i.a((Object) calendar, ak.av);
            calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            calendar.set(5, 1);
            calendar.roll(5, -1);
            return calendar.get(5);
        }

        public final String b() {
            Calendar calendar = Calendar.getInstance();
            i.a((Object) calendar, ak.av);
            calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            int i = calendar.get(1);
            return String.valueOf(i) + "-" + (calendar.get(2) + 1);
        }

        public final int c() {
            Calendar calendar = Calendar.getInstance();
            i.a((Object) calendar, ak.av);
            calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            calendar.set(5, 1);
            return calendar.get(7);
        }

        public final int d() {
            Calendar calendar = Calendar.getInstance();
            i.a((Object) calendar, ak.av);
            calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            return calendar.get(5);
        }
    }
}
