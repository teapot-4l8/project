package cn.jpush.android.helper;

import android.util.SparseArray;
import com.just.agentweb.DefaultWebClient;
import com.tencent.bugly.CrashModule;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final SparseArray<String> f4361a;

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f4361a = sparseArray;
        sparseArray.put(1060, "need not show notification by foreground");
        f4361a.put(1061, "need not show notification by isNeedShowNotification return false");
        f4361a.put(1050, "ssp buildId error");
        f4361a.put(1051, "ssp but no alert");
        f4361a.put(1032, "MSG already cancle");
        f4361a.put(1033, "overide msg already cancle");
        f4361a.put(1034, "MSG already end");
        f4361a.put(1035, "msg delay show");
        f4361a.put(1036, "notification disabled");
        f4361a.put(972, "Deep link set small icon failed");
        f4361a.put(973, "Deep link set large icon failed");
        f4361a.put(974, "Deep link- device in blacklist");
        f4361a.put(975, "Deep link source error");
        f4361a.put(976, "Deep link jump success");
        f4361a.put(977, "Deep link jump failed");
        f4361a.put(978, "Fail Deep link jump success");
        f4361a.put(979, "Fail Deep link jump failed");
        f4361a.put(981, "Deep link notify not show");
        f4361a.put(980, "Deep link notify show");
        f4361a.put(983, "wrong with resource file push_notification.xml");
        f4361a.put(993, "target app uninstall,not found target app small icon");
        f4361a.put(985, "Deep link source is not empty and pkgname is empty but deeplink error");
        f4361a.put(986, "Message is not in push time");
        f4361a.put(988, "Deep link target app uninstalled");
        f4361a.put(995, "Message JSON parsing succeed");
        f4361a.put(996, "Message JSON parsing failed");
        f4361a.put(997, "Message already received, give up");
        f4361a.put(998, "Message already received, still process");
        f4361a.put(1000, "User clicked and opened the Message");
        f4361a.put(1028, "User clicked and opened the Message from JPushInterface.reportNotificationOpened");
        f4361a.put(DefaultWebClient.DERECT_OPEN_OTHER_PAGE, "Message download succeed");
        f4361a.put(1002, "Message received succeed");
        f4361a.put(1003, "Message silence download succeed");
        f4361a.put(CrashModule.MODULE_ID, "Video silence downlaod succeed");
        f4361a.put(1005, "User clicked video and jumped to url Message (browser)");
        f4361a.put(1008, "Video is force closed by user");
        f4361a.put(1007, "User clicked 'OK'");
        f4361a.put(1006, "User clicked 'Cancel'");
        f4361a.put(1011, "Download failed");
        f4361a.put(1012, "User clicked to download again");
        f4361a.put(1013, "The file already exist and same size. Don't download again.");
        f4361a.put(1100, "Invalid param or unexpected result.");
        f4361a.put(1014, "Failed to preload required resource");
        f4361a.put(1015, "User clicked install alert on status bar after downloading finished.");
        f4361a.put(1016, "User clicked the webview's url");
        f4361a.put(1017, "User clicked call action");
        f4361a.put(1018, "The Message show in the status bar");
        f4361a.put(1019, "Click applist and show the Message");
        f4361a.put(1020, "Down image failed");
        f4361a.put(1021, "Down html failed");
        f4361a.put(1022, "Down Message failed");
        f4361a.put(1030, "Discard the message because it is not in the push time");
        f4361a.put(1031, "Stop push service");
        f4361a.put(1032, "Resume push service");
        f4361a.put(1052, "Message count limit");
        f4361a.put(1053, "Message interval limit");
    }

    public static String a(int i) {
        if (f4361a.get(i) == null) {
            Logger.d("StatusCode", "Unknown report code - " + i);
            return "";
        }
        return f4361a.get(i);
    }
}
