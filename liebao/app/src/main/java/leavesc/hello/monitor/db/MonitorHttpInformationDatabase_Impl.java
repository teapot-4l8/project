package leavesc.hello.monitor.db;

import androidx.e.a.c;
import androidx.room.b.d;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class MonitorHttpInformationDatabase_Impl extends MonitorHttpInformationDatabase {

    /* renamed from: d  reason: collision with root package name */
    private volatile a f7236d;

    @Override // androidx.room.j
    protected c b(androidx.room.a aVar) {
        return aVar.f2390a.a(c.b.a(aVar.f2391b).a(aVar.f2392c).a(new l(aVar, new l.a(1) { // from class: leavesc.hello.monitor.db.MonitorHttpInformationDatabase_Impl.1
            @Override // androidx.room.l.a
            public void b(androidx.e.a.b bVar) {
                bVar.c("CREATE TABLE IF NOT EXISTS `monitor_httpInformation` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `requestDate` INTEGER, `responseDate` INTEGER, `duration` INTEGER NOT NULL, `method` TEXT, `url` TEXT, `host` TEXT, `path` TEXT, `scheme` TEXT, `protocol` TEXT, `requestHeaders` TEXT, `requestBody` TEXT, `requestContentType` TEXT, `requestContentLength` INTEGER NOT NULL, `requestBodyIsPlainText` INTEGER NOT NULL, `responseCode` INTEGER NOT NULL, `responseHeaders` TEXT, `responseBody` TEXT, `responseMessage` TEXT, `responseContentType` TEXT, `responseContentLength` INTEGER NOT NULL, `responseBodyIsPlainText` INTEGER NOT NULL, `error` TEXT)");
                bVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"60a69cdb7e3eced3640e0977f99371d3\")");
            }

            @Override // androidx.room.l.a
            public void a(androidx.e.a.b bVar) {
                bVar.c("DROP TABLE IF EXISTS `monitor_httpInformation`");
            }

            @Override // androidx.room.l.a
            protected void d(androidx.e.a.b bVar) {
                if (MonitorHttpInformationDatabase_Impl.this.f2456c != null) {
                    int size = MonitorHttpInformationDatabase_Impl.this.f2456c.size();
                    for (int i = 0; i < size; i++) {
                        ((j.b) MonitorHttpInformationDatabase_Impl.this.f2456c.get(i)).a(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void c(androidx.e.a.b bVar) {
                MonitorHttpInformationDatabase_Impl.this.f2454a = bVar;
                MonitorHttpInformationDatabase_Impl.this.a(bVar);
                if (MonitorHttpInformationDatabase_Impl.this.f2456c != null) {
                    int size = MonitorHttpInformationDatabase_Impl.this.f2456c.size();
                    for (int i = 0; i < size; i++) {
                        ((j.b) MonitorHttpInformationDatabase_Impl.this.f2456c.get(i)).b(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            protected void e(androidx.e.a.b bVar) {
                HashMap hashMap = new HashMap(23);
                hashMap.put("id", new d.a("id", "INTEGER", true, 1));
                hashMap.put("requestDate", new d.a("requestDate", "INTEGER", false, 0));
                hashMap.put("responseDate", new d.a("responseDate", "INTEGER", false, 0));
                hashMap.put("duration", new d.a("duration", "INTEGER", true, 0));
                hashMap.put("method", new d.a("method", "TEXT", false, 0));
                hashMap.put(ImagesContract.URL, new d.a(ImagesContract.URL, "TEXT", false, 0));
                hashMap.put("host", new d.a("host", "TEXT", false, 0));
                hashMap.put("path", new d.a("path", "TEXT", false, 0));
                hashMap.put("scheme", new d.a("scheme", "TEXT", false, 0));
                hashMap.put("protocol", new d.a("protocol", "TEXT", false, 0));
                hashMap.put("requestHeaders", new d.a("requestHeaders", "TEXT", false, 0));
                hashMap.put("requestBody", new d.a("requestBody", "TEXT", false, 0));
                hashMap.put("requestContentType", new d.a("requestContentType", "TEXT", false, 0));
                hashMap.put("requestContentLength", new d.a("requestContentLength", "INTEGER", true, 0));
                hashMap.put("requestBodyIsPlainText", new d.a("requestBodyIsPlainText", "INTEGER", true, 0));
                hashMap.put("responseCode", new d.a("responseCode", "INTEGER", true, 0));
                hashMap.put("responseHeaders", new d.a("responseHeaders", "TEXT", false, 0));
                hashMap.put("responseBody", new d.a("responseBody", "TEXT", false, 0));
                hashMap.put("responseMessage", new d.a("responseMessage", "TEXT", false, 0));
                hashMap.put("responseContentType", new d.a("responseContentType", "TEXT", false, 0));
                hashMap.put("responseContentLength", new d.a("responseContentLength", "INTEGER", true, 0));
                hashMap.put("responseBodyIsPlainText", new d.a("responseBodyIsPlainText", "INTEGER", true, 0));
                hashMap.put(com.umeng.analytics.pro.d.O, new d.a(com.umeng.analytics.pro.d.O, "TEXT", false, 0));
                d dVar = new d("monitor_httpInformation", hashMap, new HashSet(0), new HashSet(0));
                d a2 = d.a(bVar, "monitor_httpInformation");
                if (dVar.equals(a2)) {
                    return;
                }
                throw new IllegalStateException("Migration didn't properly handle monitor_httpInformation(leavesc.hello.monitor.db.entity.HttpInformation).\n Expected:\n" + dVar + "\n Found:\n" + a2);
            }
        }, "60a69cdb7e3eced3640e0977f99371d3", "1146df273c189113149160cb4d0787c0")).a());
    }

    @Override // androidx.room.j
    protected g c() {
        return new g(this, "monitor_httpInformation");
    }

    @Override // leavesc.hello.monitor.db.MonitorHttpInformationDatabase
    public a m() {
        a aVar;
        if (this.f7236d != null) {
            return this.f7236d;
        }
        synchronized (this) {
            if (this.f7236d == null) {
                this.f7236d = new b(this);
            }
            aVar = this.f7236d;
        }
        return aVar;
    }
}
