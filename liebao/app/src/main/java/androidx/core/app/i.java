package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class i {

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        String A;
        Bundle B;
        Notification E;
        RemoteViews F;
        RemoteViews G;
        RemoteViews H;
        String I;
        String K;
        long L;
        boolean N;
        b O;
        Notification P;
        boolean Q;
        @Deprecated
        public ArrayList<String> R;

        /* renamed from: a  reason: collision with root package name */
        public Context f1443a;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f1446d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f1447e;
        PendingIntent f;
        PendingIntent g;
        RemoteViews h;
        Bitmap i;
        CharSequence j;
        int k;
        int l;
        boolean n;
        e o;
        CharSequence p;

        /* renamed from: q  reason: collision with root package name */
        CharSequence[] f1448q;
        int r;
        int s;
        boolean t;
        String u;
        boolean v;
        String w;
        boolean y;
        boolean z;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f1444b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        ArrayList<a> f1445c = new ArrayList<>();
        boolean m = true;
        boolean x = false;
        int C = 0;
        int D = 0;
        int J = 0;
        int M = 0;

        public c(Context context, String str) {
            Notification notification = new Notification();
            this.P = notification;
            this.f1443a = context;
            this.I = str;
            notification.when = System.currentTimeMillis();
            this.P.audioStreamType = -1;
            this.l = 0;
            this.R = new ArrayList<>();
            this.N = true;
        }

        public c a(long j) {
            this.P.when = j;
            return this;
        }

        public c a(int i) {
            this.P.icon = i;
            return this;
        }

        public c a(CharSequence charSequence) {
            this.f1446d = d(charSequence);
            return this;
        }

        public c b(CharSequence charSequence) {
            this.f1447e = d(charSequence);
            return this;
        }

        public c c(CharSequence charSequence) {
            this.p = d(charSequence);
            return this;
        }

        public c b(int i) {
            this.k = i;
            return this;
        }

        public c a(int i, int i2, boolean z) {
            this.r = i;
            this.s = i2;
            this.t = z;
            return this;
        }

        public c a(PendingIntent pendingIntent) {
            this.f = pendingIntent;
            return this;
        }

        public c b(PendingIntent pendingIntent) {
            this.P.deleteIntent = pendingIntent;
            return this;
        }

        public c a(Uri uri) {
            this.P.sound = uri;
            this.P.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                this.P.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public c a(long[] jArr) {
            this.P.vibrate = jArr;
            return this;
        }

        public c a(boolean z) {
            a(2, z);
            return this;
        }

        public c b(boolean z) {
            a(16, z);
            return this;
        }

        public c c(boolean z) {
            this.x = z;
            return this;
        }

        public c c(int i) {
            this.P.defaults = i;
            if ((i & 4) != 0) {
                this.P.flags |= 1;
            }
            return this;
        }

        private void a(int i, boolean z) {
            if (z) {
                Notification notification = this.P;
                notification.flags = i | notification.flags;
                return;
            }
            Notification notification2 = this.P;
            notification2.flags = (i ^ (-1)) & notification2.flags;
        }

        public Bundle a() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public c a(e eVar) {
            if (this.o != eVar) {
                this.o = eVar;
                if (eVar != null) {
                    eVar.a(this);
                }
            }
            return this;
        }

        public c a(String str) {
            this.I = str;
            return this;
        }

        public Notification b() {
            return new j(this).b();
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        protected c f1450a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f1451b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f1452c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1453d = false;

        public void a(Bundle bundle) {
        }

        public void a(h hVar) {
        }

        public RemoteViews b(h hVar) {
            return null;
        }

        public RemoteViews c(h hVar) {
            return null;
        }

        public RemoteViews d(h hVar) {
            return null;
        }

        public void a(c cVar) {
            if (this.f1450a != cVar) {
                this.f1450a = cVar;
                if (cVar != null) {
                    cVar.a(this);
                }
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<CharSequence> f1449e = new ArrayList<>();

        public d a(CharSequence charSequence) {
            this.f1449e.add(c.d(charSequence));
            return this;
        }

        @Override // androidx.core.app.i.e
        public void a(h hVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(hVar.a()).setBigContentTitle(this.f1451b);
                if (this.f1453d) {
                    bigContentTitle.setSummaryText(this.f1452c);
                }
                Iterator<CharSequence> it = this.f1449e.iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine(it.next());
                }
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f1433a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1434b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public int f1435c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f1436d;

        /* renamed from: e  reason: collision with root package name */
        public PendingIntent f1437e;
        private IconCompat f;
        private final m[] g;
        private final m[] h;
        private boolean i;
        private final int j;
        private final boolean k;

        public IconCompat a() {
            int i;
            if (this.f == null && (i = this.f1435c) != 0) {
                this.f = IconCompat.a(null, "", i);
            }
            return this.f;
        }

        public CharSequence b() {
            return this.f1436d;
        }

        public PendingIntent c() {
            return this.f1437e;
        }

        public Bundle d() {
            return this.f1433a;
        }

        public boolean e() {
            return this.i;
        }

        public m[] f() {
            return this.g;
        }

        public int g() {
            return this.j;
        }

        public boolean h() {
            return this.k;
        }

        public m[] i() {
            return this.h;
        }

        public boolean j() {
            return this.f1434b;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private PendingIntent f1438a;

        /* renamed from: b  reason: collision with root package name */
        private PendingIntent f1439b;

        /* renamed from: c  reason: collision with root package name */
        private IconCompat f1440c;

        /* renamed from: d  reason: collision with root package name */
        private int f1441d;

        /* renamed from: e  reason: collision with root package name */
        private int f1442e;
        private int f;

        public PendingIntent a() {
            return this.f1438a;
        }

        public PendingIntent b() {
            return this.f1439b;
        }

        public IconCompat c() {
            return this.f1440c;
        }

        public int d() {
            return this.f1441d;
        }

        public int e() {
            return this.f1442e;
        }

        public boolean f() {
            return (this.f & 1) != 0;
        }

        public boolean g() {
            return (this.f & 2) != 0;
        }

        public static Notification.BubbleMetadata a(b bVar) {
            if (bVar == null) {
                return null;
            }
            Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setAutoExpandBubble(bVar.f()).setDeleteIntent(bVar.b()).setIcon(bVar.c().d()).setIntent(bVar.a()).setSuppressNotification(bVar.g());
            if (bVar.d() != 0) {
                suppressNotification.setDesiredHeight(bVar.d());
            }
            if (bVar.e() != 0) {
                suppressNotification.setDesiredHeightResId(bVar.e());
            }
            return suppressNotification.build();
        }
    }

    public static Bundle a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return k.a(notification);
        }
        return null;
    }
}
