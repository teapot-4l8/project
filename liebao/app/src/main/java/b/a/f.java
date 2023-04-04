package b.a;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Future f3151a;

    /* renamed from: c  reason: collision with root package name */
    private final String f3153c = "";

    /* renamed from: b  reason: collision with root package name */
    private final Map f3152b = new HashMap();

    public f(Future future) {
        this.f3151a = future;
    }

    public c a() {
        try {
            return c.a(((SharedPreferences) this.f3151a.get()).getInt("FM_init_state", c.f3111a.a()));
        } catch (InterruptedException | ExecutionException unused) {
            return c.f3111a;
        }
    }

    public c a(String str) {
        try {
            return c.a(((SharedPreferences) this.f3151a.get()).getInt(str, c.f3111a.a()));
        } catch (InterruptedException | ExecutionException unused) {
            return c.f3111a;
        }
    }

    public void a(long j) {
        try {
            SharedPreferences.Editor edit = ((SharedPreferences) this.f3151a.get()).edit();
            edit.putLong("FM_last_time", j);
            edit.apply();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public void a(b.a.b.c cVar) {
        try {
            SharedPreferences.Editor edit = ((SharedPreferences) this.f3151a.get()).edit();
            edit.putString("FM_pb_data", b.a.b.c.a(cVar));
            edit.apply();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public void a(b.a.c.b bVar) {
        try {
            SharedPreferences.Editor edit = ((SharedPreferences) this.f3151a.get()).edit();
            edit.putString("FM_config_data", bVar.toString());
            edit.apply();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public void a(String str, c cVar) {
        try {
            SharedPreferences.Editor edit = ((SharedPreferences) this.f3151a.get()).edit();
            edit.putInt(str, cVar.a());
            edit.apply();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public String b() {
        try {
            return ((SharedPreferences) this.f3151a.get()).getString("FM_init_data", "");
        } catch (InterruptedException | ExecutionException unused) {
            return "";
        }
    }

    public void b(String str) {
        try {
            SharedPreferences.Editor edit = ((SharedPreferences) this.f3151a.get()).edit();
            edit.putString("FM_init_data", str);
            edit.apply();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public String c() {
        try {
            return ((SharedPreferences) this.f3151a.get()).getString("FM_init_msg", "");
        } catch (InterruptedException | ExecutionException unused) {
            return "";
        }
    }

    public void c(String str) {
        try {
            SharedPreferences.Editor edit = ((SharedPreferences) this.f3151a.get()).edit();
            edit.putString("FM_init_msg", str);
            edit.apply();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public b.a.c.b d() {
        try {
            return b.a.c.b.b(((SharedPreferences) this.f3151a.get()).getString("FM_config_data", ""));
        } catch (InterruptedException | ExecutionException unused) {
            return new b.a.c.b();
        }
    }

    public b.a.b.c e() {
        try {
            return b.a.b.c.c(((SharedPreferences) this.f3151a.get()).getString("FM_pb_data", ""));
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    public long f() {
        try {
            return ((SharedPreferences) this.f3151a.get()).getLong("FM_last_time", 0L);
        } catch (InterruptedException | ExecutionException unused) {
            return 0L;
        }
    }

    public void g() {
        try {
            SharedPreferences.Editor edit = ((SharedPreferences) this.f3151a.get()).edit();
            edit.clear();
            edit.apply();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }
}
