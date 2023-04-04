package com.speed.speed_library.business.update.fullupdate;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.i;
import androidx.core.content.FileProvider;
import com.speed.speed_library.R;
import com.speed.speed_library.business.update.fullupdate.c;
import java.io.File;
import java.net.URLEncoder;

/* loaded from: classes2.dex */
public class FullUpdateDownLoadService extends Service {

    /* renamed from: e  reason: collision with root package name */
    private static final CharSequence f5633e = "com.speed.library.chanel.name";
    private String f;
    private String g;
    private File h;
    private File i;
    private ResultReceiver n;

    /* renamed from: b  reason: collision with root package name */
    private NotificationManager f5635b = null;

    /* renamed from: c  reason: collision with root package name */
    private i.c f5636c = null;

    /* renamed from: d  reason: collision with root package name */
    private PendingIntent f5637d = null;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private String m = "";

    /* renamed from: a  reason: collision with root package name */
    Bundle f5634a = new Bundle();
    private Handler.Callback o = new Handler.Callback() { // from class: com.speed.speed_library.business.update.fullupdate.FullUpdateDownLoadService.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case -1:
                    if (FullUpdateDownLoadService.this.k) {
                        Toast.makeText(FullUpdateDownLoadService.this.getApplicationContext(), R.string.au_download_failure, 1).show();
                    }
                    FullUpdateDownLoadService.this.a();
                    FullUpdateDownLoadService.this.b();
                    break;
                case 0:
                    if (FullUpdateDownLoadService.this.k) {
                        Toast.makeText(FullUpdateDownLoadService.this.getApplicationContext(), R.string.au_download_success, 1).show();
                        FullUpdateDownLoadService fullUpdateDownLoadService = FullUpdateDownLoadService.this;
                        fullUpdateDownLoadService.b(fullUpdateDownLoadService.i);
                    }
                    FullUpdateDownLoadService.this.b();
                    break;
                case 1:
                    if (FullUpdateDownLoadService.this.k) {
                        Toast.makeText(FullUpdateDownLoadService.this.getApplicationContext(), R.string.au_download_start, 1).show();
                        break;
                    }
                    break;
                case 2:
                    if (FullUpdateDownLoadService.this.k) {
                        Toast.makeText(FullUpdateDownLoadService.this.getApplicationContext(), R.string.au_download_install, 1).show();
                    }
                    FullUpdateDownLoadService.this.b();
                    break;
                case 3:
                    if (FullUpdateDownLoadService.this.k) {
                        Toast.makeText(FullUpdateDownLoadService.this.getApplicationContext(), R.string.au_download_error_sdcard, 1).show();
                    }
                    FullUpdateDownLoadService.this.b();
                    break;
                case 4:
                    if (FullUpdateDownLoadService.this.k) {
                        Toast.makeText(FullUpdateDownLoadService.this.getApplicationContext(), R.string.au_download_error_url, 1).show();
                    }
                    FullUpdateDownLoadService.this.b();
                    break;
                case 5:
                    if (FullUpdateDownLoadService.this.k) {
                        Toast.makeText(FullUpdateDownLoadService.this.getApplicationContext(), R.string.au_download_error_file, 1).show();
                    }
                    FullUpdateDownLoadService.this.b();
                    FullUpdateDownLoadService.this.f5635b.cancel(0);
                    break;
            }
            return true;
        }
    };
    private Handler p = new Handler(this.o);

    /* renamed from: q  reason: collision with root package name */
    private c.a f5638q = new c.a() { // from class: com.speed.speed_library.business.update.fullupdate.FullUpdateDownLoadService.2

        /* renamed from: b  reason: collision with root package name */
        private int f5641b = 160;

        /* renamed from: c  reason: collision with root package name */
        private long f5642c = 0;

        /* renamed from: d  reason: collision with root package name */
        private int f5643d = 0;

        @Override // com.speed.speed_library.business.update.fullupdate.c.a
        public void a(int i) {
            if ((i == this.f5643d || System.currentTimeMillis() - this.f5642c <= this.f5641b) && i != 100) {
                return;
            }
            this.f5642c = System.currentTimeMillis();
            this.f5643d = i;
            if (FullUpdateDownLoadService.this.f5636c != null) {
                FullUpdateDownLoadService.this.f5636c.a(100, i, false);
                i.c cVar = FullUpdateDownLoadService.this.f5636c;
                cVar.b(FullUpdateDownLoadService.this.getString(R.string.au_download_ongoing) + i + "%");
                Notification b2 = FullUpdateDownLoadService.this.f5636c.b();
                b2.flags = 24;
                FullUpdateDownLoadService.this.f5635b.notify(0, b2);
            }
            Log.d("FullUpdateDownLoadService", "apk downloading progress:" + i + "");
            if (FullUpdateDownLoadService.this.n != null) {
                FullUpdateDownLoadService.this.f5634a.putInt("progress", this.f5643d);
                FullUpdateDownLoadService.this.n.send(8344, FullUpdateDownLoadService.this.f5634a);
            }
        }

        @Override // com.speed.speed_library.business.update.fullupdate.c.a
        public void a() {
            FullUpdateDownLoadService.this.f5636c.b(FullUpdateDownLoadService.this.getString(R.string.au_download_notification_success));
            FullUpdateDownLoadService.this.f5636c.a(0, 0, false);
            FullUpdateDownLoadService.this.f5636c.c(-1);
            FullUpdateDownLoadService.this.f5635b.notify(0, FullUpdateDownLoadService.this.f5636c.b());
            if (FullUpdateDownLoadService.this.i.exists() && FullUpdateDownLoadService.this.i.isFile()) {
                FullUpdateDownLoadService fullUpdateDownLoadService = FullUpdateDownLoadService.this;
                if (fullUpdateDownLoadService.a(fullUpdateDownLoadService.i.getPath())) {
                    Message obtainMessage = FullUpdateDownLoadService.this.p.obtainMessage();
                    obtainMessage.what = 0;
                    FullUpdateDownLoadService.this.p.sendMessage(obtainMessage);
                }
            }
            FullUpdateDownLoadService.this.f5635b.cancel(0);
        }

        @Override // com.speed.speed_library.business.update.fullupdate.c.a
        public void b() {
            try {
                FullUpdateDownLoadService.this.a(-1);
                FullUpdateDownLoadService.this.stopSelf();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f5635b.cancel(0);
        this.j = false;
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ResultReceiver resultReceiver = this.n;
        if (resultReceiver != null) {
            resultReceiver.send(8345, this.f5634a);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        this.k = intent.getBooleanExtra("show", false);
        this.l = intent.getBooleanExtra("update_force", false);
        this.g = intent.getStringExtra("download_url");
        this.n = (ResultReceiver) intent.getParcelableExtra("update_receiver");
        if (this.j) {
            if (this.k) {
                Toast.makeText(this, R.string.au_download_downloading, 0).show();
            }
            return super.onStartCommand(intent, i, i2);
        }
        if (TextUtils.isEmpty(com.speed.speed_library.business.update.fullupdate.a.f5646b.a().a())) {
            this.f = com.speed.speed_library.business.update.fullupdate.a.f5646b.a().f5655a.getPackageName() + "/download";
        } else {
            this.f = com.speed.speed_library.business.update.fullupdate.a.f5646b.a().a();
        }
        if (TextUtils.isEmpty(this.g)) {
            a(4);
            return super.onStartCommand(intent, 1, i2);
        }
        File file = new File(getExternalCacheDir().getAbsolutePath() + "/" + this.f);
        this.h = file;
        if (file.exists()) {
            File file2 = new File(this.h.getPath() + "/" + URLEncoder.encode(this.g));
            if (file2.exists() && file2.isFile() && a(file2.getPath())) {
                if (this.k) {
                    a(2);
                    b(file2);
                }
                stopSelf();
                return super.onStartCommand(intent, 1, i2);
            }
        }
        this.m = d.a(this);
        c();
        new a().start();
        return super.onStartCommand(intent, 1, i2);
    }

    private void c() {
        this.f5635b = (NotificationManager) getSystemService("notification");
        this.f5636c = new i.c(this, "com.speed.library.chanel.id").a(this.f5637d).a((CharSequence) this.m).b(getString(R.string.au_download_start)).a(com.speed.speed_library.business.update.fullupdate.a.f5646b.a().b() != 0 ? com.speed.speed_library.business.update.fullupdate.a.f5646b.a().b() : R.mipmap.ic_home_notice).a(true).b(true).c(8).a(new long[]{0}).a((Uri) null).a(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("com.speed.library.chanel.id", f5633e, 4);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setVibrationPattern(new long[]{0});
            notificationChannel.setSound(null, null);
            notificationChannel.enableLights(false);
            this.f5635b.createNotificationChannel(notificationChannel);
            this.f5636c.a("com.speed.library.chanel.id");
        }
        Intent intent = new Intent();
        intent.setFlags(536870912);
        intent.setClass(getApplicationContext(), FullUpdateDownLoadService.class);
        this.f5637d = PendingIntent.getActivity(this, R.string.app_name, intent, 134217728);
        Notification b2 = this.f5636c.b();
        b2.flags = 16;
        this.f5635b.notify(0, b2);
    }

    public boolean a(String str) {
        try {
            return getPackageManager().getPackageArchiveInfo(str, 1) != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) {
        Uri fromFile;
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(this, getString(R.string.speed_provider_file_authorities), file);
                intent.setFlags(1);
            } else {
                fromFile = Uri.fromFile(file);
            }
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Message obtainMessage = this.p.obtainMessage();
        obtainMessage.what = i;
        this.p.sendMessage(obtainMessage);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.p.removeCallbacksAndMessages(null);
    }

    /* loaded from: classes2.dex */
    class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (FullUpdateDownLoadService.this.h == null) {
                FullUpdateDownLoadService fullUpdateDownLoadService = FullUpdateDownLoadService.this;
                fullUpdateDownLoadService.h = new File(FullUpdateDownLoadService.this.getExternalCacheDir().getAbsolutePath() + "/" + FullUpdateDownLoadService.this.f);
            }
            if (FullUpdateDownLoadService.this.h.exists()) {
                Log.d("FullUpdateDownLoadService", "start download delete.");
                FullUpdateDownLoadService.c(FullUpdateDownLoadService.this.h);
            }
            if (!FullUpdateDownLoadService.this.h.exists() && !FullUpdateDownLoadService.this.h.mkdirs()) {
                FullUpdateDownLoadService.this.a(5);
            } else {
                Log.d("FullUpdateDownLoadService", "start download apk to sdcard download apk.");
                a();
            }
            FullUpdateDownLoadService.this.j = false;
            FullUpdateDownLoadService.this.stopSelf();
        }

        private void a() {
            FullUpdateDownLoadService fullUpdateDownLoadService = FullUpdateDownLoadService.this;
            fullUpdateDownLoadService.i = new File(FullUpdateDownLoadService.this.h.getPath() + "/" + URLEncoder.encode(FullUpdateDownLoadService.this.g));
            if (FullUpdateDownLoadService.this.i.exists() && FullUpdateDownLoadService.this.i.isFile()) {
                FullUpdateDownLoadService fullUpdateDownLoadService2 = FullUpdateDownLoadService.this;
                if (fullUpdateDownLoadService2.a(fullUpdateDownLoadService2.i.getPath())) {
                    if (FullUpdateDownLoadService.this.k) {
                        FullUpdateDownLoadService.this.a(2);
                        Log.d("FullUpdateDownLoadService", "33333");
                        FullUpdateDownLoadService fullUpdateDownLoadService3 = FullUpdateDownLoadService.this;
                        fullUpdateDownLoadService3.b(fullUpdateDownLoadService3.i);
                        return;
                    }
                    return;
                }
            }
            try {
                Log.d("FullUpdateDownLoadService", "22222");
                FullUpdateDownLoadService fullUpdateDownLoadService4 = FullUpdateDownLoadService.this;
                fullUpdateDownLoadService4.h = new File(FullUpdateDownLoadService.this.getExternalCacheDir().getAbsolutePath() + "/" + FullUpdateDownLoadService.this.f);
                FullUpdateDownLoadService.this.a(1);
                FullUpdateDownLoadService.this.j = true;
                c.a(FullUpdateDownLoadService.this.g, FullUpdateDownLoadService.this.i, false, FullUpdateDownLoadService.this.f5638q);
            } catch (Exception e2) {
                FullUpdateDownLoadService.this.a(-1);
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(File file) {
        File[] listFiles;
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                c(file2);
            } else {
                System.out.println(file2 + ":" + file2.delete());
            }
        }
        System.out.println(file + ":" + file.delete());
    }
}
