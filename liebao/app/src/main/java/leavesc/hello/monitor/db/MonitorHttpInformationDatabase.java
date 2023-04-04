package leavesc.hello.monitor.db;

import android.content.Context;
import androidx.room.i;
import androidx.room.j;

/* loaded from: classes2.dex */
public abstract class MonitorHttpInformationDatabase extends j {

    /* renamed from: d  reason: collision with root package name */
    private static volatile MonitorHttpInformationDatabase f7235d;

    public abstract a m();

    public static MonitorHttpInformationDatabase a(Context context) {
        if (f7235d == null) {
            synchronized (MonitorHttpInformationDatabase.class) {
                if (f7235d == null) {
                    f7235d = b(context);
                }
            }
        }
        return f7235d;
    }

    private static MonitorHttpInformationDatabase b(Context context) {
        return (MonitorHttpInformationDatabase) i.a(context, MonitorHttpInformationDatabase.class, "MonitorHttpInformation.db").c();
    }
}
