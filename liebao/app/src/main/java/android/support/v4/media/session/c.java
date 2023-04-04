package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* compiled from: MediaControllerCompatApi21.java */
/* loaded from: classes.dex */
class c {

    /* compiled from: MediaControllerCompatApi21.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(int i, int i2, int i3, int i4, int i5);

        void a(Bundle bundle);

        void a(CharSequence charSequence);

        void a(Object obj);

        void a(String str, Bundle bundle);

        void a(List<?> list);

        void b(Object obj);
    }

    public static Object a(a aVar) {
        return new b(aVar);
    }

    /* compiled from: MediaControllerCompatApi21.java */
    /* renamed from: android.support.v4.media.session.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0016c {
        public static AudioAttributes a(Object obj) {
            return ((MediaController.PlaybackInfo) obj).getAudioAttributes();
        }

        public static int b(Object obj) {
            return a(a(obj));
        }

        private static int a(AudioAttributes audioAttributes) {
            if ((audioAttributes.getFlags() & 1) == 1) {
                return 7;
            }
            if ((audioAttributes.getFlags() & 4) == 4) {
                return 6;
            }
            int usage = audioAttributes.getUsage();
            if (usage != 13) {
                switch (usage) {
                    case 2:
                        return 0;
                    case 3:
                        return 8;
                    case 4:
                        return 4;
                    case 5:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        return 5;
                    case 6:
                        return 2;
                    default:
                        return 3;
                }
            }
            return 1;
        }
    }

    /* compiled from: MediaControllerCompatApi21.java */
    /* loaded from: classes.dex */
    static class b<T extends a> extends MediaController.Callback {

        /* renamed from: a  reason: collision with root package name */
        protected final T f480a;

        public b(T t) {
            this.f480a = t;
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.f480a.a();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f480a.a(str, bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f480a.a(playbackState);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f480a.b(mediaMetadata);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f480a.a(list);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence charSequence) {
            this.f480a.a(charSequence);
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f480a.a(bundle);
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            this.f480a.a(playbackInfo.getPlaybackType(), C0016c.b(playbackInfo), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }
}
