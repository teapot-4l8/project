package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaControllerCompat {

    /* loaded from: classes.dex */
    public static abstract class a implements IBinder.DeathRecipient {

        /* renamed from: a  reason: collision with root package name */
        final Object f444a;

        /* renamed from: b  reason: collision with root package name */
        HandlerC0012a f445b;

        /* renamed from: c  reason: collision with root package name */
        android.support.v4.media.session.a f446c;

        public void a() {
        }

        public void a(int i) {
        }

        public void a(Bundle bundle) {
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void a(b bVar) {
        }

        public void a(PlaybackStateCompat playbackStateCompat) {
        }

        public void a(CharSequence charSequence) {
        }

        public void a(String str, Bundle bundle) {
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
        }

        public void a(boolean z) {
        }

        public void b() {
        }

        public void b(int i) {
        }

        public a() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f444a = android.support.v4.media.session.c.a(new b(this));
                return;
            }
            c cVar = new c(this);
            this.f446c = cVar;
            this.f444a = cVar;
        }

        void a(int i, Object obj, Bundle bundle) {
            HandlerC0012a handlerC0012a = this.f445b;
            if (handlerC0012a != null) {
                Message obtainMessage = handlerC0012a.obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        /* loaded from: classes.dex */
        private static class b implements c.a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f449a;

            b(a aVar) {
                this.f449a = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.c.a
            public void a() {
                a aVar = this.f449a.get();
                if (aVar != null) {
                    aVar.b();
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(String str, Bundle bundle) {
                a aVar = this.f449a.get();
                if (aVar != null) {
                    if (aVar.f446c == null || Build.VERSION.SDK_INT >= 23) {
                        aVar.a(str, bundle);
                    }
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Object obj) {
                a aVar = this.f449a.get();
                if (aVar == null || aVar.f446c != null) {
                    return;
                }
                aVar.a(PlaybackStateCompat.a(obj));
            }

            @Override // android.support.v4.media.session.c.a
            public void b(Object obj) {
                a aVar = this.f449a.get();
                if (aVar != null) {
                    aVar.a(MediaMetadataCompat.a(obj));
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(List<?> list) {
                a aVar = this.f449a.get();
                if (aVar != null) {
                    aVar.a(MediaSessionCompat.QueueItem.a(list));
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(CharSequence charSequence) {
                a aVar = this.f449a.get();
                if (aVar != null) {
                    aVar.a(charSequence);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Bundle bundle) {
                a aVar = this.f449a.get();
                if (aVar != null) {
                    aVar.a(bundle);
                }
            }

            @Override // android.support.v4.media.session.c.a
            public void a(int i, int i2, int i3, int i4, int i5) {
                a aVar = this.f449a.get();
                if (aVar != null) {
                    aVar.a(new b(i, i2, i3, i4, i5));
                }
            }
        }

        /* loaded from: classes.dex */
        private static class c extends a.AbstractBinderC0013a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f450a;

            @Override // android.support.v4.media.session.a
            public void a(boolean z) {
            }

            c(a aVar) {
                this.f450a = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void a(String str, Bundle bundle) {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(1, str, bundle);
                }
            }

            public void a() {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(PlaybackStateCompat playbackStateCompat) {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(2, playbackStateCompat, null);
                }
            }

            public void a(MediaMetadataCompat mediaMetadataCompat) {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(3, mediaMetadataCompat, null);
                }
            }

            public void a(List<MediaSessionCompat.QueueItem> list) {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(5, list, null);
                }
            }

            public void a(CharSequence charSequence) {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void b(boolean z) {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(11, Boolean.valueOf(z), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(int i) {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(9, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void b(int i) {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(12, Integer.valueOf(i), null);
                }
            }

            public void a(Bundle bundle) {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(7, bundle, null);
                }
            }

            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(4, parcelableVolumeInfo != null ? new b(parcelableVolumeInfo.f463a, parcelableVolumeInfo.f464b, parcelableVolumeInfo.f465c, parcelableVolumeInfo.f466d, parcelableVolumeInfo.f467e) : null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void b() {
                a aVar = this.f450a.get();
                if (aVar != null) {
                    aVar.a(13, null, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class HandlerC0012a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            boolean f447a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a f448b;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.f447a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.a(data);
                            this.f448b.a((String) message.obj, data);
                            return;
                        case 2:
                            this.f448b.a((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.f448b.a((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.f448b.a((b) message.obj);
                            return;
                        case 5:
                            this.f448b.a((List) message.obj);
                            return;
                        case 6:
                            this.f448b.a((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.a(bundle);
                            this.f448b.a(bundle);
                            return;
                        case 8:
                            this.f448b.b();
                            return;
                        case 9:
                            this.f448b.a(((Integer) message.obj).intValue());
                            return;
                        case 10:
                        default:
                            return;
                        case 11:
                            this.f448b.a(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.f448b.b(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            this.f448b.a();
                            return;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f451a;

        /* renamed from: b  reason: collision with root package name */
        private final int f452b;

        /* renamed from: c  reason: collision with root package name */
        private final int f453c;

        /* renamed from: d  reason: collision with root package name */
        private final int f454d;

        /* renamed from: e  reason: collision with root package name */
        private final int f455e;

        b(int i, int i2, int i3, int i4, int i5) {
            this.f451a = i;
            this.f452b = i2;
            this.f453c = i3;
            this.f454d = i4;
            this.f455e = i5;
        }
    }

    /* loaded from: classes.dex */
    static class MediaControllerImplApi21 {

        /* renamed from: a  reason: collision with root package name */
        final Object f439a;

        /* renamed from: b  reason: collision with root package name */
        final MediaSessionCompat.Token f440b;

        /* renamed from: c  reason: collision with root package name */
        private final List<a> f441c;

        /* renamed from: d  reason: collision with root package name */
        private HashMap<a, a> f442d;

        void a() {
            if (this.f440b.a() == null) {
                return;
            }
            for (a aVar : this.f441c) {
                a aVar2 = new a(aVar);
                this.f442d.put(aVar, aVar2);
                aVar.f446c = aVar2;
                try {
                    this.f440b.a().a(aVar2);
                    aVar.a(13, null, null);
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                }
            }
            this.f441c.clear();
        }

        /* loaded from: classes.dex */
        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f443a;

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f443a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f439a) {
                    mediaControllerImplApi21.f440b.a(b.a.a(androidx.core.app.e.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.f440b.a(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerImplApi21.a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(List<MediaSessionCompat.QueueItem> list) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(CharSequence charSequence) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }
    }
}
