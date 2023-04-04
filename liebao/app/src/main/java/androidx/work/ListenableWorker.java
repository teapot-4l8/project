package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class ListenableWorker {
    private Context mAppContext;
    private volatile boolean mStopped;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    public void onStopped() {
    }

    public abstract ListenableFuture<a> startWork();

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.mAppContext = context;
        this.mWorkerParams = workerParameters;
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public final UUID getId() {
        return this.mWorkerParams.a();
    }

    public final e getInputData() {
        return this.mWorkerParams.b();
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.c();
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.d();
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.e();
    }

    public final Network getNetwork() {
        return this.mWorkerParams.f();
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.g();
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.h();
    }

    public androidx.work.impl.utils.b.a getTaskExecutor() {
        return this.mWorkerParams.i();
    }

    public p getWorkerFactory() {
        return this.mWorkerParams.j();
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public static a a() {
            return new c();
        }

        public static a a(e eVar) {
            return new c(eVar);
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new C0060a();
        }

        a() {
        }

        /* loaded from: classes.dex */
        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            private final e f2751a;

            public c() {
                this(e.f2787a);
            }

            public c(e eVar) {
                this.f2751a = eVar;
            }

            public e d() {
                return this.f2751a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.f2751a.equals(((c) obj).f2751a);
            }

            public int hashCode() {
                return 28070925 + this.f2751a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f2751a + '}';
            }
        }

        /* renamed from: androidx.work.ListenableWorker$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0060a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final e f2750a;

            public C0060a() {
                this(e.f2787a);
            }

            public C0060a(e eVar) {
                this.f2750a = eVar;
            }

            public e d() {
                return this.f2750a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.f2750a.equals(((C0060a) obj).f2750a);
            }

            public int hashCode() {
                return 28070863 + this.f2750a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f2750a + '}';
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends a {
            public int hashCode() {
                return 1386378834;
            }

            public String toString() {
                return "Retry";
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }
        }
    }
}
