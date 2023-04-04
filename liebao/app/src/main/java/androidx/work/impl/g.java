package androidx.work.impl;

import android.content.Context;
import android.os.Build;

/* compiled from: WorkDatabaseMigrations.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static androidx.room.a.a f2969a = new androidx.room.a.a(1, 2) { // from class: androidx.work.impl.g.1
        @Override // androidx.room.a.a
        public void a(androidx.e.a.b bVar) {
            bVar.c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.c("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            bVar.c("DROP TABLE IF EXISTS alarmInfo");
            bVar.c("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static androidx.room.a.a f2970b = new androidx.room.a.a(3, 4) { // from class: androidx.work.impl.g.2
        @Override // androidx.room.a.a
        public void a(androidx.e.a.b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.c("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static androidx.room.a.a f2971c = new androidx.room.a.a(4, 5) { // from class: androidx.work.impl.g.3
        @Override // androidx.room.a.a
        public void a(androidx.e.a.b bVar) {
            bVar.c("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            bVar.c("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    };

    /* compiled from: WorkDatabaseMigrations.java */
    /* loaded from: classes.dex */
    public static class a extends androidx.room.a.a {

        /* renamed from: c  reason: collision with root package name */
        final Context f2972c;

        public a(Context context, int i, int i2) {
            super(i, i2);
            this.f2972c = context;
        }

        @Override // androidx.room.a.a
        public void a(androidx.e.a.b bVar) {
            new androidx.work.impl.utils.e(this.f2972c).a(true);
        }
    }
}
