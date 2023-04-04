package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.i;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.gms.ads.AdRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationCompatBuilder.java */
/* loaded from: classes.dex */
public class j implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Notification.Builder f1454a;

    /* renamed from: b  reason: collision with root package name */
    private final i.c f1455b;

    /* renamed from: c  reason: collision with root package name */
    private RemoteViews f1456c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f1457d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Bundle> f1458e = new ArrayList();
    private final Bundle f = new Bundle();
    private int g;
    private RemoteViews h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i.c cVar) {
        this.f1455b = cVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1454a = new Notification.Builder(cVar.f1443a, cVar.I);
        } else {
            this.f1454a = new Notification.Builder(cVar.f1443a);
        }
        Notification notification = cVar.P;
        this.f1454a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.f1446d).setContentText(cVar.f1447e).setContentInfo(cVar.j).setContentIntent(cVar.f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.g, (notification.flags & 128) != 0).setLargeIcon(cVar.i).setNumber(cVar.k).setProgress(cVar.r, cVar.s, cVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f1454a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1454a.setSubText(cVar.p).setUsesChronometer(cVar.n).setPriority(cVar.l);
            Iterator<i.a> it = cVar.f1444b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            if (cVar.B != null) {
                this.f.putAll(cVar.B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (cVar.x) {
                    this.f.putBoolean("android.support.localOnly", true);
                }
                if (cVar.u != null) {
                    this.f.putString("android.support.groupKey", cVar.u);
                    if (cVar.v) {
                        this.f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (cVar.w != null) {
                    this.f.putString("android.support.sortKey", cVar.w);
                }
            }
            this.f1456c = cVar.F;
            this.f1457d = cVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1454a.setShowWhen(cVar.m);
            if (Build.VERSION.SDK_INT < 21 && cVar.R != null && !cVar.R.isEmpty()) {
                this.f.putStringArray("android.people", (String[]) cVar.R.toArray(new String[cVar.R.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1454a.setLocalOnly(cVar.x).setGroup(cVar.u).setGroupSummary(cVar.v).setSortKey(cVar.w);
            this.g = cVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1454a.setCategory(cVar.A).setColor(cVar.C).setVisibility(cVar.D).setPublicVersion(cVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = cVar.R.iterator();
            while (it2.hasNext()) {
                this.f1454a.addPerson(it2.next());
            }
            this.h = cVar.H;
            if (cVar.f1445c.size() > 0) {
                Bundle bundle = cVar.a().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new Bundle() : bundle;
                Bundle bundle2 = new Bundle();
                for (int i = 0; i < cVar.f1445c.size(); i++) {
                    bundle2.putBundle(Integer.toString(i), k.a(cVar.f1445c.get(i)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                cVar.a().putBundle("android.car.EXTENSIONS", bundle);
                this.f.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1454a.setExtras(cVar.B).setRemoteInputHistory(cVar.f1448q);
            if (cVar.F != null) {
                this.f1454a.setCustomContentView(cVar.F);
            }
            if (cVar.G != null) {
                this.f1454a.setCustomBigContentView(cVar.G);
            }
            if (cVar.H != null) {
                this.f1454a.setCustomHeadsUpContentView(cVar.H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1454a.setBadgeIconType(cVar.J).setShortcutId(cVar.K).setTimeoutAfter(cVar.L).setGroupAlertBehavior(cVar.M);
            if (cVar.z) {
                this.f1454a.setColorized(cVar.y);
            }
            if (!TextUtils.isEmpty(cVar.I)) {
                this.f1454a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1454a.setAllowSystemGeneratedContextualActions(cVar.N);
            this.f1454a.setBubbleMetadata(i.b.a(cVar.O));
        }
        if (cVar.Q) {
            if (this.f1455b.v) {
                this.g = 2;
            } else {
                this.g = 1;
            }
            this.f1454a.setVibrate(null);
            this.f1454a.setSound(null);
            notification.defaults &= -2;
            notification.defaults &= -3;
            this.f1454a.setDefaults(notification.defaults);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.f1455b.u)) {
                    this.f1454a.setGroup("silent");
                }
                this.f1454a.setGroupAlertBehavior(this.g);
            }
        }
    }

    @Override // androidx.core.app.h
    public Notification.Builder a() {
        return this.f1454a;
    }

    public Notification b() {
        Bundle a2;
        RemoteViews d2;
        RemoteViews c2;
        i.e eVar = this.f1455b.o;
        if (eVar != null) {
            eVar.a(this);
        }
        RemoteViews b2 = eVar != null ? eVar.b(this) : null;
        Notification c3 = c();
        if (b2 != null) {
            c3.contentView = b2;
        } else if (this.f1455b.F != null) {
            c3.contentView = this.f1455b.F;
        }
        if (Build.VERSION.SDK_INT >= 16 && eVar != null && (c2 = eVar.c(this)) != null) {
            c3.bigContentView = c2;
        }
        if (Build.VERSION.SDK_INT >= 21 && eVar != null && (d2 = this.f1455b.o.d(this)) != null) {
            c3.headsUpContentView = d2;
        }
        if (Build.VERSION.SDK_INT >= 16 && eVar != null && (a2 = i.a(c3)) != null) {
            eVar.a(a2);
        }
        return c3;
    }

    private void a(i.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            IconCompat a2 = aVar.a();
            if (Build.VERSION.SDK_INT >= 23) {
                builder = new Notification.Action.Builder(a2 != null ? a2.d() : null, aVar.b(), aVar.c());
            } else {
                builder = new Notification.Action.Builder(a2 != null ? a2.b() : 0, aVar.b(), aVar.c());
            }
            if (aVar.f() != null) {
                for (RemoteInput remoteInput : m.a(aVar.f())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.d() != null) {
                bundle = new Bundle(aVar.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.e());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.h());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.j());
            builder.addExtras(bundle);
            this.f1454a.addAction(builder.build());
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f1458e.add(k.a(this.f1454a, aVar));
        }
    }

    protected Notification c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f1454a.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.f1454a.build();
            if (this.g != 0) {
                if (build.getGroup() != null && (build.flags & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 && this.g == 2) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 && this.g == 1) {
                    a(build);
                }
            }
            return build;
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f1454a.setExtras(this.f);
            Notification build2 = this.f1454a.build();
            RemoteViews remoteViews = this.f1456c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1457d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.g != 0) {
                if (build2.getGroup() != null && (build2.flags & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 && this.g == 2) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 && this.g == 1) {
                    a(build2);
                }
            }
            return build2;
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.f1454a.setExtras(this.f);
            Notification build3 = this.f1454a.build();
            RemoteViews remoteViews4 = this.f1456c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1457d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.g != 0) {
                if (build3.getGroup() != null && (build3.flags & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 && this.g == 2) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 && this.g == 1) {
                    a(build3);
                }
            }
            return build3;
        } else if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> a2 = k.a(this.f1458e);
            if (a2 != null) {
                this.f.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f1454a.setExtras(this.f);
            Notification build4 = this.f1454a.build();
            RemoteViews remoteViews6 = this.f1456c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f1457d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (Build.VERSION.SDK_INT >= 16) {
            Notification build5 = this.f1454a.build();
            Bundle a3 = i.a(build5);
            Bundle bundle = new Bundle(this.f);
            for (String str : this.f.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = k.a(this.f1458e);
            if (a4 != null) {
                i.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.f1456c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f1457d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        } else {
            return this.f1454a.getNotification();
        }
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
