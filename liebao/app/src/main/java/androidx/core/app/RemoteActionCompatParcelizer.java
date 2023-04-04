package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1402a = (IconCompat) aVar.b((androidx.versionedparcelable.a) remoteActionCompat.f1402a, 1);
        remoteActionCompat.f1403b = aVar.b(remoteActionCompat.f1403b, 2);
        remoteActionCompat.f1404c = aVar.b(remoteActionCompat.f1404c, 3);
        remoteActionCompat.f1405d = (PendingIntent) aVar.b((androidx.versionedparcelable.a) remoteActionCompat.f1405d, 4);
        remoteActionCompat.f1406e = aVar.b(remoteActionCompat.f1406e, 5);
        remoteActionCompat.f = aVar.b(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.a(false, false);
        aVar.a(remoteActionCompat.f1402a, 1);
        aVar.a(remoteActionCompat.f1403b, 2);
        aVar.a(remoteActionCompat.f1404c, 3);
        aVar.a(remoteActionCompat.f1405d, 4);
        aVar.a(remoteActionCompat.f1406e, 5);
        aVar.a(remoteActionCompat.f, 6);
    }
}
