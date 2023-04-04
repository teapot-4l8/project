package cn.jpush.android.local;

import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Set;

/* loaded from: classes.dex */
public class ActionHelper {
    private static final String TAG = "ActionHelper";
    private static volatile ActionHelper actionHelper;
    private static final Object locker = new Object();
    private JPushAction jPushAction;
    private cn.jpush.android.q.a loadedResource;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Context f4377b;

        /* renamed from: c  reason: collision with root package name */
        private String f4378c;

        /* renamed from: d  reason: collision with root package name */
        private Object f4379d;

        public a(Context context, String str, Object obj) {
            this.f4377b = context;
            this.f4378c = str;
            this.f4379d = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ActionHelper.this.initLoad(this.f4377b);
                ActionHelper.this.jPushAction.handleAction(this.f4377b, this.f4378c, this.f4379d);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private Context f4381b;

        /* renamed from: c  reason: collision with root package name */
        private String f4382c;

        /* renamed from: d  reason: collision with root package name */
        private int f4383d;

        /* renamed from: e  reason: collision with root package name */
        private Set<String> f4384e;
        private CallBackParams f;

        public b(Context context, String str, Set<String> set, int i, CallBackParams callBackParams) {
            this.f = callBackParams;
            this.f4382c = str;
            this.f4383d = i;
            this.f4381b = context;
            this.f4384e = set;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ActionHelper.this.initLoad(this.f4381b);
                ActionHelper.this.jPushAction.setAliasAndTags(this.f4381b, this.f4382c, this.f4384e, this.f);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private ActionHelper() {
        JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 13, TAG, null, new Object[0]);
    }

    public static ActionHelper getInstance() {
        if (actionHelper == null) {
            synchronized (locker) {
                if (actionHelper == null) {
                    actionHelper = new ActionHelper();
                }
            }
        }
        return actionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initLoad(Context context) {
        if (this.jPushAction != null) {
            return;
        }
        if (JPushConstants.SUPPORT_DY && JConstants.SDK_VERSION_INT >= 220) {
            long currentTimeMillis = System.currentTimeMillis();
            this.loadedResource = cn.jpush.android.q.a.a(context);
            Logger.d(TAG, "load use time:" + (System.currentTimeMillis() - currentTimeMillis) + ",lr:" + this.loadedResource);
            if (this.loadedResource != null) {
                Class b2 = this.loadedResource.b("cn.p.jpush.JPushActionImpl");
                Logger.d(TAG, "load from cloud");
                this.jPushAction = (JPushAction) b2.newInstance();
            }
        }
        if (this.jPushAction == null) {
            this.jPushAction = new cn.jpush.android.k.a();
        }
    }

    public Object beforLogin(Context context, String str, int i, String str2) {
        initLoad(context);
        return this.jPushAction.beforLogin(context, str, i, str2);
    }

    public void doAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doAction:" + str);
        JCoreHelper.execue(context, TAG, new a(context, str, obj));
    }

    public ProxyActivityAction getPopWinActivity(Context context) {
        initLoad(context);
        return this.jPushAction.getPopWinActivity(context);
    }

    public ProxyActivityAction getPushActivity(Context context) {
        initLoad(context);
        return this.jPushAction.getPushActivity(context);
    }

    public int getResourceID(Context context, String str, String str2, String str3) {
        int identifier;
        StringBuilder sb;
        String str4;
        cn.jpush.android.q.a aVar = this.loadedResource;
        if (aVar != null) {
            identifier = aVar.a(str2, str);
            sb = new StringBuilder();
            str4 = "[getResourceID] try load:";
        } else {
            identifier = context.getResources().getIdentifier(str, str2, str3);
            sb = new StringBuilder();
            str4 = "[getResourceID]:";
        }
        sb.append(str4);
        sb.append(identifier);
        Logger.d(TAG, sb.toString());
        return identifier;
    }

    public String getSdkVersion(String str) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.getSdkVersion(str) : JPushConstants.SDK_VERSION_NAME;
    }

    public void handleNotificationIntent(Context context, Intent intent) {
        initLoad(context);
        this.jPushAction.handleNotificationIntent(context, intent);
    }

    public boolean isSupportedCMD(String str, int i) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.isSupportedCMD(str, i) : i == 3 || i == 29 || i == 28 || i == 27 || i == 10 || i == 26 || i == 25;
    }

    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        initLoad(context);
        this.jPushAction.onJPushMessageReceive(context, jPushMessageReceiver, intent);
    }

    public void onMessage(Context context, CustomMessage customMessage) {
        initLoad(context);
        this.jPushAction.onMessage(context, customMessage);
    }

    public void onMultiAction(Context context, Intent intent) {
        initLoad(context);
        this.jPushAction.onMultiAction(context, intent);
    }

    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        this.jPushAction.onNotifyMessageArrived(context, notificationMessage);
    }

    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        this.jPushAction.onNotifyMessageOpened(context, notificationMessage);
    }

    public void onTagAliasResponse(Context context, long j, int i, Intent intent) {
        initLoad(context);
        this.jPushAction.onTagAliasResponse(context, j, i, intent);
    }

    public void setAliasAndTagsWithCallBack(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback, int i, int i2) {
        JCoreHelper.execue(context, TAG, new b(context, str, set, 0, new CallBackParams(str, set, tagAliasCallback, System.currentTimeMillis(), i, i2)));
    }

    public void setAliasWithCallBack(Context context, int i, String str, int i2, int i3) {
        JCoreHelper.execue(context, TAG, new b(context, str, null, i, new CallBackParams(i, str, System.currentTimeMillis(), i2, i3)));
    }

    public void setTagsWithCallBack(Context context, int i, Set<String> set, int i2, int i3) {
        JCoreHelper.execue(context, TAG, new b(context, null, set, i, new CallBackParams(i, set, System.currentTimeMillis(), i2, i3)));
    }
}
