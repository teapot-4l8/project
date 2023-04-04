package com.speed.speed_library.business.update.fullupdate;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.View;
import com.speed.speed_library.b.g;
import com.speed.speed_library.b.h;
import com.speed.speed_library.event.BadgeEvent;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.VersionCheckModel;
import kotlin.d.b.i;

/* compiled from: FullUpdate.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static com.speed.speed_library.widget.a.e f5645a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f5646b = new a();

    /* renamed from: c  reason: collision with root package name */
    private static com.speed.speed_library.business.update.fullupdate.b f5647c;

    private a() {
    }

    public final com.speed.speed_library.business.update.fullupdate.b a() {
        return f5647c;
    }

    public final com.speed.speed_library.widget.a.e b() {
        com.speed.speed_library.widget.a.e eVar = f5645a;
        if (eVar == null) {
            i.b("updateDialog");
        }
        return eVar;
    }

    public final void a(Activity activity, boolean z) {
        i.b(activity, "activity");
        b.b.e<BaseModel<VersionCheckModel>> a2 = d.a.a.a.a.c.f6985a.a().a("0").b(b.b.h.a.d()).a(b.b.a.b.a.a());
        if (z) {
            a2.a(new b(activity, activity));
        } else {
            a2.a(new c(activity));
        }
    }

    /* compiled from: FullUpdate.kt */
    /* loaded from: classes2.dex */
    public static final class b extends com.speed.speed_library.a.c<BaseModel<VersionCheckModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f5648a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, Context context) {
            super(context);
            this.f5648a = activity;
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<VersionCheckModel> baseModel) {
            i.b(baseModel, "response");
            a.f5646b.a(this.f5648a, baseModel, true);
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
            h.f5614a.a(th);
        }
    }

    /* compiled from: FullUpdate.kt */
    /* loaded from: classes2.dex */
    public static final class c extends com.speed.speed_library.a.c<BaseModel<VersionCheckModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f5649a;

        c(Activity activity) {
            this.f5649a = activity;
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<VersionCheckModel> baseModel) {
            i.b(baseModel, "response");
            a.f5646b.a(this.f5649a, baseModel, false);
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
            h.f5614a.a(th);
        }
    }

    public final void a(Activity activity, BaseModel<VersionCheckModel> baseModel, boolean z) {
        i.b(activity, "activity");
        i.b(baseModel, "response");
        if (h.f5614a.a(baseModel, false)) {
            if (baseModel.getData().getVercode() <= com.speed.speed_library.utils.e.b(g.f5610b.a())) {
                if (z) {
                    com.speed.speed_library.b.f.a("当前已是最新版本", 0, 2, null);
                    return;
                }
                return;
            }
            g.f5610b.a(baseModel.getData().getVercode());
            org.greenrobot.eventbus.c.a().d(new BadgeEvent());
            if (baseModel.getData().getState() == 1) {
                b(activity, baseModel.getData().getLog(), baseModel.getData().getApp_url());
            } else {
                a(activity, baseModel.getData().getLog(), baseModel.getData().getApp_url());
            }
        }
    }

    public final void a(Activity activity, String str, String str2) {
        i.b(activity, "activity");
        i.b(str, "content");
        i.b(str2, "downloadUrl");
        if (activity.isFinishing()) {
            return;
        }
        com.speed.speed_library.widget.a.e eVar = new com.speed.speed_library.widget.a.e(activity);
        f5645a = eVar;
        if (eVar == null) {
            i.b("updateDialog");
        }
        eVar.a(str);
        com.speed.speed_library.widget.a.e eVar2 = f5645a;
        if (eVar2 == null) {
            i.b("updateDialog");
        }
        eVar2.setCanceledOnTouchOutside(true);
        com.speed.speed_library.widget.a.e eVar3 = f5645a;
        if (eVar3 == null) {
            i.b("updateDialog");
        }
        eVar3.a(new f(activity, str2));
        com.speed.speed_library.widget.a.e eVar4 = f5645a;
        if (eVar4 == null) {
            i.b("updateDialog");
        }
        eVar4.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullUpdate.kt */
    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f5653a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f5654b;

        f(Activity activity, String str) {
            this.f5653a = activity;
            this.f5654b = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.f5646b.b().dismiss();
            a.f5646b.a(this.f5653a, this.f5654b, true, false);
        }
    }

    public final void b(Activity activity, String str, String str2) {
        i.b(activity, "activity");
        i.b(str, "content");
        i.b(str2, "downloadUrl");
        if (activity.isFinishing()) {
            return;
        }
        com.speed.speed_library.widget.a.e eVar = new com.speed.speed_library.widget.a.e(activity);
        f5645a = eVar;
        if (eVar == null) {
            i.b("updateDialog");
        }
        eVar.a(str);
        com.speed.speed_library.widget.a.e eVar2 = f5645a;
        if (eVar2 == null) {
            i.b("updateDialog");
        }
        eVar2.setCanceledOnTouchOutside(false);
        com.speed.speed_library.widget.a.e eVar3 = f5645a;
        if (eVar3 == null) {
            i.b("updateDialog");
        }
        eVar3.setOnKeyListener(d.f5650a);
        com.speed.speed_library.widget.a.e eVar4 = f5645a;
        if (eVar4 == null) {
            i.b("updateDialog");
        }
        eVar4.a(new e(activity, str2));
        com.speed.speed_library.widget.a.e eVar5 = f5645a;
        if (eVar5 == null) {
            i.b("updateDialog");
        }
        eVar5.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullUpdate.kt */
    /* loaded from: classes2.dex */
    public static final class d implements DialogInterface.OnKeyListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f5650a = new d();

        d() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i == 4) {
                i.a((Object) keyEvent, "keyEvent");
                if (keyEvent.getAction() == 0) {
                    Activity b2 = com.speed.speed_library.business.update.fullupdate.d.b(g.f5610b.a());
                    if (b2 != null) {
                        b2.onBackPressed();
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullUpdate.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f5651a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f5652b;

        e(Activity activity, String str) {
            this.f5651a = activity;
            this.f5652b = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.f5646b.b().b().setVisibility(0);
            a.f5646b.b().a().setVisibility(8);
            a.f5646b.a(this.f5651a, this.f5652b, true, true);
        }
    }

    public final void a(Activity activity, String str, boolean z, boolean z2) {
        i.b(activity, "activity");
        i.b(str, "download");
        com.speed.speed_library.business.update.fullupdate.b bVar = new com.speed.speed_library.business.update.fullupdate.b();
        bVar.f5655a = g.f5610b.a();
        f5647c = bVar;
        Intent intent = new Intent(activity, FullUpdateDownLoadService.class);
        intent.putExtra("download_url", str);
        intent.putExtra("show", z);
        intent.putExtra("update_force", z2);
        if (z2) {
            intent.putExtra("update_receiver", new ResultReceiverC0141a(new Handler()));
        }
        activity.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FullUpdate.kt */
    /* renamed from: com.speed.speed_library.business.update.fullupdate.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class ResultReceiverC0141a extends ResultReceiver {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResultReceiverC0141a(Handler handler) {
            super(handler);
            i.b(handler, "handler");
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            i.b(bundle, "resultData");
            super.onReceiveResult(i, bundle);
            if (i == 8344) {
                int i2 = bundle.getInt("progress");
                a.f5646b.b().b().setProgress(i2);
                a.f5646b.b().b().setMax(100);
                if (i2 == 100) {
                    a.f5646b.b().dismiss();
                    return;
                }
                return;
            }
            a.f5646b.b().dismiss();
        }
    }
}
