package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzdot;
import com.google.android.gms.internal.ads.zzdxr;
import com.google.android.gms.internal.ads.zzdyh;
import com.google.android.gms.internal.ads.zzww;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbn {
    public static boolean zzdn(int i) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcth)).booleanValue()) {
            return ((Boolean) zzww.zzra().zzd(zzabq.zzcti)).booleanValue() || i <= 15299999;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0135 A[Catch: JSONException -> 0x0151, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0151, blocks: (B:33:0x011c, B:47:0x0144, B:48:0x0148, B:49:0x014d, B:38:0x012b, B:41:0x0135), top: B:55:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014d A[Catch: JSONException -> 0x0151, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0151, blocks: (B:33:0x011c, B:47:0x0144, B:48:0x0148, B:49:0x014d, B:38:0x012b, B:41:0x0135), top: B:55:0x011c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject zza(Context context, View view) {
        String str;
        char c2;
        int hashCode;
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (view == null) {
            return jSONObject2;
        }
        try {
            int[] zzu = zzu(view);
            int[] iArr = new int[2];
            if (view != null) {
                iArr[0] = view.getMeasuredWidth();
                iArr[1] = view.getMeasuredHeight();
                for (ViewParent parent = view.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    iArr[0] = Math.min(((ViewGroup) parent).getMeasuredWidth(), iArr[0]);
                    iArr[1] = Math.min(((ViewGroup) parent).getMeasuredHeight(), iArr[1]);
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("width", zzd(context, view.getMeasuredWidth()));
            jSONObject3.put("height", zzd(context, view.getMeasuredHeight()));
            jSONObject3.put("x", zzd(context, zzu[0]));
            jSONObject3.put("y", zzd(context, zzu[1]));
            jSONObject3.put("maximum_visible_width", zzd(context, iArr[0]));
            jSONObject3.put("maximum_visible_height", zzd(context, iArr[1]));
            jSONObject3.put("relative_to", "window");
            jSONObject2.put("frame", jSONObject3);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                jSONObject = zza(context, rect);
            } else {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("width", 0);
                jSONObject4.put("height", 0);
                jSONObject4.put("x", zzd(context, zzu[0]));
                jSONObject4.put("y", zzd(context, zzu[1]));
                jSONObject4.put("relative_to", "window");
                jSONObject = jSONObject4;
            }
            jSONObject2.put("visible_bounds", jSONObject);
        } catch (Exception unused) {
            zzd.zzez("Unable to get native ad view bounding box");
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyv)).booleanValue()) {
            ViewParent parent2 = view.getParent();
            try {
                if (parent2 != null) {
                    try {
                        str = (String) parent2.getClass().getMethod("getTemplateTypeName", new Class[0]).invoke(parent2, new Object[0]);
                    } catch (IllegalAccessException e2) {
                        e = e2;
                        zzd.zzc("Cannot access method getTemplateTypeName: ", e);
                        str = "";
                        c2 = 65535;
                        hashCode = str.hashCode();
                        if (hashCode != -2066603854) {
                        }
                        if (c2 == 0) {
                        }
                        return jSONObject2;
                    } catch (NoSuchMethodException unused2) {
                    } catch (SecurityException e3) {
                        e = e3;
                        zzd.zzc("Cannot access method getTemplateTypeName: ", e);
                        str = "";
                        c2 = 65535;
                        hashCode = str.hashCode();
                        if (hashCode != -2066603854) {
                        }
                        if (c2 == 0) {
                        }
                        return jSONObject2;
                    } catch (InvocationTargetException e4) {
                        e = e4;
                        zzd.zzc("Cannot access method getTemplateTypeName: ", e);
                        str = "";
                        c2 = 65535;
                        hashCode = str.hashCode();
                        if (hashCode != -2066603854) {
                        }
                        if (c2 == 0) {
                        }
                        return jSONObject2;
                    }
                    c2 = 65535;
                    hashCode = str.hashCode();
                    if (hashCode != -2066603854) {
                        if (hashCode == 2019754500 && str.equals("medium_template")) {
                            c2 = 1;
                        }
                    } else if (str.equals("small_template")) {
                        c2 = 0;
                    }
                    if (c2 == 0) {
                        jSONObject2.put("native_template_type", 1);
                    } else if (c2 == 1) {
                        jSONObject2.put("native_template_type", 2);
                    } else {
                        jSONObject2.put("native_template_type", 0);
                    }
                }
                hashCode = str.hashCode();
                if (hashCode != -2066603854) {
                }
                if (c2 == 0) {
                }
            } catch (JSONException e5) {
                zzd.zzc("Could not log native template signal to JSON", e5);
            }
            str = "";
            c2 = 65535;
        }
        return jSONObject2;
    }

    public static JSONObject zzt(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdaj)).booleanValue()) {
                com.google.android.gms.ads.internal.zzr.zzkv();
                jSONObject.put("contained_in_scroll_view", zzj.zzs(view));
            } else {
                com.google.android.gms.ads.internal.zzr.zzkv();
                jSONObject.put("contained_in_scroll_view", zzj.zzr(view) != -1);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject zzb(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            com.google.android.gms.ads.internal.zzr.zzkv();
            jSONObject.put("can_show_on_lock_screen", zzj.zzq(view));
            com.google.android.gms.ads.internal.zzr.zzkv();
            jSONObject.put("is_keyguard_locked", zzj.zzaw(context));
        } catch (JSONException unused) {
            zzd.zzez("Unable to get lock screen information");
        }
        return jSONObject;
    }

    public static JSONObject zza(Context context, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View view) {
        String str;
        String str2;
        JSONObject jSONObject;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject2 = new JSONObject();
        if (map != null && view != null) {
            int[] zzu = zzu(view);
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, WeakReference<View>> next = it.next();
                View view2 = next.getValue().get();
                if (view2 != null) {
                    int[] zzu2 = zzu(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator<Map.Entry<String, WeakReference<View>>> it2 = it;
                    try {
                        jSONObject4.put("width", zzd(context, view2.getMeasuredWidth()));
                        jSONObject4.put("height", zzd(context, view2.getMeasuredHeight()));
                        jSONObject4.put("x", zzd(context, zzu2[0] - zzu[0]));
                        jSONObject4.put("y", zzd(context, zzu2[1] - zzu[1]));
                        jSONObject4.put(str4, str3);
                        jSONObject3.put("frame", jSONObject4);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject = zza(context, rect);
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject.put("width", 0);
                            jSONObject.put("height", 0);
                            jSONObject.put("x", zzd(context, zzu2[0] - zzu[0]));
                            jSONObject.put("y", zzd(context, zzu2[1] - zzu[1]));
                            jSONObject.put(str4, str3);
                        }
                        jSONObject3.put("visible_bounds", jSONObject);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject3.put("text_color", textView.getCurrentTextColor());
                            str = str3;
                            str2 = str4;
                            try {
                                jSONObject3.put("font_size", textView.getTextSize());
                                jSONObject3.put("text", textView.getText());
                            } catch (JSONException unused) {
                                zzd.zzez("Unable to get asset views information");
                                it = it2;
                                str3 = str;
                                str4 = str2;
                            }
                        } else {
                            str = str3;
                            str2 = str4;
                        }
                        jSONObject3.put("is_clickable", map2 != null && map2.containsKey(next.getKey()) && view2.isClickable());
                        jSONObject2.put(next.getKey(), jSONObject3);
                    } catch (JSONException unused2) {
                        str = str3;
                        str2 = str4;
                    }
                    it = it2;
                    str3 = str;
                    str4 = str2;
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject zza(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("click_point", zza(context, point, point2));
                jSONObject2.put("asset_id", str);
                return jSONObject2;
            } catch (Exception e2) {
                e = e2;
                jSONObject = jSONObject2;
                zzd.zzc("Error occurred while grabbing click signals.", e);
                return jSONObject;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static int[] zzu(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public static Point zza(MotionEvent motionEvent, View view) {
        int[] zzu = zzu(view);
        return new Point(((int) motionEvent.getRawX()) - zzu[0], ((int) motionEvent.getRawY()) - zzu[1]);
    }

    private static JSONObject zza(Context context, Point point, Point point2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", zzd(context, point2.x));
            jSONObject.put("y", zzd(context, point2.y));
            jSONObject.put("start_x", zzd(context, point.x));
            jSONObject.put("start_y", zzd(context, point.y));
            return jSONObject;
        } catch (JSONException e2) {
            zzd.zzc("Error occurred while putting signals into JSON object.", e2);
            return null;
        }
    }

    public static boolean zza(Context context, zzdot zzdotVar) {
        if (zzdotVar.zzhmp) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdak)).booleanValue()) {
                return ((Boolean) zzww.zzra().zzd(zzabq.zzdan)).booleanValue();
            }
            String str = (String) zzww.zzra().zzd(zzabq.zzdal);
            if (!str.isEmpty() && context != null) {
                String packageName = context.getPackageName();
                for (String str2 : zzdyh.zza(zzdxr.zzb(';')).zza(str)) {
                    if (str2.equals(packageName)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static JSONObject zzbn(@Nonnull Context context) {
        JSONObject jSONObject = new JSONObject();
        com.google.android.gms.ads.internal.zzr.zzkv();
        DisplayMetrics zza = zzj.zza((WindowManager) context.getSystemService("window"));
        try {
            jSONObject.put("width", zzd(context, zza.widthPixels));
            jSONObject.put("height", zzd(context, zza.heightPixels));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static WindowManager.LayoutParams zzaaj() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzww.zzra().zzd(zzabq.zzdam)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    private static int zzd(Context context, int i) {
        return zzww.zzqw().zzd(context, i);
    }

    private static JSONObject zza(Context context, Rect rect) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzd(context, rect.right - rect.left));
        jSONObject.put("height", zzd(context, rect.bottom - rect.top));
        jSONObject.put("x", zzd(context, rect.left));
        jSONObject.put("y", zzd(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }
}
