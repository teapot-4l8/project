package cn.jpush.android.helper;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static int f4357a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static int f4358b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static float f4359c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private static float f4360d = -1.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        void a(View view);
    }

    public static int a() {
        return f4357a;
    }

    public static void a(Context context) {
        try {
            if (f4357a == -1 || f4358b == -1) {
                c(context);
                if (f4357a == -1 || f4358b == -1) {
                    b(context);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static void a(View view, a aVar) {
        if (view == null || aVar == null) {
            return;
        }
        aVar.a(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), aVar);
            }
        }
    }

    public static int b() {
        return f4358b;
    }

    private static void b(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("title");
        builder.setContentText("content");
        try {
            ViewGroup viewGroup = (ViewGroup) (Build.VERSION.SDK_INT >= 24 ? builder.createContentView() : (Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification()).contentView).apply(context, new FrameLayout(context));
            Logger.d("NotificationStyleHelper", "begain fetch colors by internal , root view is :" + viewGroup);
            a(viewGroup, new a() { // from class: cn.jpush.android.helper.e.1
                @Override // cn.jpush.android.helper.e.a
                public void a(View view) {
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        if ("title".equals(textView.getText().toString()) && e.f4357a == -1) {
                            int unused = e.f4357a = textView.getCurrentTextColor();
                            float unused2 = e.f4359c = textView.getTextSize();
                        }
                        if ("content".equals(textView.getText().toString()) && e.f4358b == -1) {
                            int unused3 = e.f4358b = textView.getCurrentTextColor();
                            float unused4 = e.f4360d = textView.getTextSize();
                        }
                    }
                }
            });
        } catch (Throwable th) {
            Logger.e("NotificationStyleHelper", "getNotificationColorInternal error:" + th.getMessage());
        }
    }

    public static float c() {
        return f4359c;
    }

    private static void c(Context context) {
        try {
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentTitle("title");
            builder.setContentText("content");
            if (Build.VERSION.SDK_INT >= 16) {
                builder.setSubText("subtext");
            }
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate((Build.VERSION.SDK_INT >= 24 ? builder.createContentView() : (Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification()).contentView).getLayoutId(), (ViewGroup) null);
            Logger.d("NotificationStyleHelper", "begain fetch colors by compat, root view is :" + viewGroup);
            a(viewGroup, new a() { // from class: cn.jpush.android.helper.e.2
                @Override // cn.jpush.android.helper.e.a
                public void a(View view) {
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        if ("title".equals(textView.getText().toString()) && e.f4357a == -1) {
                            int unused = e.f4357a = textView.getCurrentTextColor();
                            float unused2 = e.f4359c = textView.getTextSize();
                            Logger.d("NotificationStyleHelper", "title color is :" + e.f4357a);
                        }
                        if ("content".equals(textView.getText().toString()) && e.f4358b == -1) {
                            int unused3 = e.f4358b = textView.getCurrentTextColor();
                            float unused4 = e.f4360d = textView.getTextSize();
                            Logger.d("NotificationStyleHelper", "content color is :" + e.f4358b);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            Logger.e("NotificationStyleHelper", "getNotificationColorCompat error:" + th.getMessage());
        }
    }

    public static float d() {
        return f4360d;
    }
}
