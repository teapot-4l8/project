package b.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f3200a = Executors.newSingleThreadExecutor();

    /* loaded from: classes.dex */
    private static class a implements Callable {

        /* renamed from: a  reason: collision with root package name */
        private final Context f3201a;

        /* renamed from: b  reason: collision with root package name */
        private final String f3202b;

        /* renamed from: c  reason: collision with root package name */
        private final b f3203c;

        public a(Context context, String str, b bVar) {
            this.f3201a = context;
            this.f3202b = str;
            this.f3203c = bVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public SharedPreferences call() {
            SharedPreferences sharedPreferences = this.f3201a.getSharedPreferences(this.f3202b, 0);
            b bVar = this.f3203c;
            if (bVar != null) {
                bVar.a(sharedPreferences);
            }
            return sharedPreferences;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(SharedPreferences sharedPreferences);
    }

    public Future a(Context context, String str, b bVar) {
        FutureTask futureTask = new FutureTask(new a(context, str, bVar));
        this.f3200a.execute(futureTask);
        return futureTask;
    }
}
