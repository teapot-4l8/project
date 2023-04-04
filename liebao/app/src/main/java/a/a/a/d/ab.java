package a.a.a.d;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* compiled from: FormattedTime.java */
/* loaded from: classes.dex */
final class ab {

    /* renamed from: a  reason: collision with root package name */
    private static NumberFormat f110a;

    /* renamed from: b  reason: collision with root package name */
    private static NumberFormat f111b;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        f110a = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(2);
        DecimalFormat decimalFormat2 = new DecimalFormat();
        f111b = decimalFormat2;
        decimalFormat2.setMinimumIntegerDigits(4);
        f111b.setGroupingUsed(false);
    }

    public static String a(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        StringBuilder sb = new StringBuilder();
        gregorianCalendar.setTime(date);
        sb.append(f111b.format(gregorianCalendar.get(1)));
        sb.append(f110a.format(gregorianCalendar.get(2) + 1));
        sb.append(f110a.format(gregorianCalendar.get(5)));
        sb.append(f110a.format(gregorianCalendar.get(11)));
        sb.append(f110a.format(gregorianCalendar.get(12)));
        sb.append(f110a.format(gregorianCalendar.get(13)));
        return sb.toString();
    }
}
