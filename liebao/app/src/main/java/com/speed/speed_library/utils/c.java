package com.speed.speed_library.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.d.b.i;

/* compiled from: DateTimeUtils.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    private static final long f5862c;

    /* renamed from: d  reason: collision with root package name */
    private static final long f5863d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f5864e;
    private static final long f;

    /* renamed from: a  reason: collision with root package name */
    public static final c f5860a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final long f5861b = f5861b;

    /* renamed from: b  reason: collision with root package name */
    private static final long f5861b = f5861b;

    static {
        long j = 60 * f5861b;
        f5862c = j;
        long j2 = 24 * j;
        f5863d = j2;
        long j3 = 30 * j2;
        f5864e = j3;
        f = 12 * j3;
    }

    private c() {
    }

    public final String a(long j, String str) {
        i.b(str, "format");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String format = simpleDateFormat.format(new Date(j * 1000));
        i.a((Object) format, "sdf.format(dt)");
        return format;
    }

    public final String a(long j) {
        return a(j, "yyyy-M");
    }

    public final String b(long j) {
        return a(j, "dd");
    }

    public final String c(long j) {
        return a(j, "yyyy.MM.dd");
    }

    public final String a(int i) {
        String formatter = new Formatter(new StringBuilder(), Locale.getDefault()).format("%02d:%02d:%02d", Integer.valueOf(i / 3600), Integer.valueOf((i / 60) % 60), Integer.valueOf(i % 60)).toString();
        i.a((Object) formatter, "formatter.format(\"%02d:%…utes, seconds).toString()");
        return formatter;
    }
}
