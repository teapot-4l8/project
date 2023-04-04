package cn.jpush.android.webview.bridge;

import android.text.TextUtils;
import android.webkit.WebView;
import androidx.recyclerview.widget.l;
import cn.jpush.android.helper.Logger;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Method> f4525a;

    /* renamed from: b  reason: collision with root package name */
    private String f4526b;

    /* renamed from: c  reason: collision with root package name */
    private String f4527c;

    public c(String str, Class cls) {
        String a2;
        try {
            if (TextUtils.isEmpty(str)) {
                throw new Exception("injected name can not be null");
            }
            this.f4526b = str;
            this.f4525a = new HashMap<>();
            Method[] declaredMethods = cls.getDeclaredMethods();
            StringBuilder sb = new StringBuilder("javascript:(function(b){console.log(\"");
            sb.append(this.f4526b);
            sb.append(" initialization begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
            for (Method method : declaredMethods) {
                if (method.getModifiers() == 9 && (a2 = a(method)) != null) {
                    this.f4525a.put(a2, method);
                    sb.append(String.format(Locale.ENGLISH, "a.%s=", method.getName()));
                }
            }
            sb.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
            sb.append(this.f4526b);
            sb.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));if(g.code!=200){throw\"");
            sb.append(this.f4526b);
            sb.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
            sb.append(this.f4526b);
            sb.append("=a;console.log(\"");
            sb.append(this.f4526b);
            sb.append(" initialization end\")})(window);");
            this.f4527c = sb.toString();
            Logger.d("JsCallJava", "----------" + sb.toString());
        } catch (Exception e2) {
            Logger.e("JsCallJava", "init js error:" + e2.getMessage());
        }
    }

    private String a(String str, int i, Object obj) {
        String valueOf;
        if (obj == null) {
            valueOf = "null";
        } else if (obj instanceof String) {
            String replace = ((String) obj).replace("\"", "\\\"");
            valueOf = "\"" + ((Object) replace) + "\"";
        } else {
            valueOf = ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof JSONObject)) ? String.valueOf(obj) : "";
        }
        String format = String.format(Locale.ENGLISH, "{\"code\": %d, \"result\": %s}", Integer.valueOf(i), valueOf);
        Logger.d("JsCallJava", this.f4526b + " call json: " + str + " result:" + format);
        return format;
    }

    private String a(Method method) {
        StringBuilder sb;
        String str;
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        if (length < 1 || parameterTypes[0] != WebView.class) {
            Logger.w("JsCallJava", "method(" + name + ") must use webview to be first parameter, will be pass");
            return null;
        }
        for (int i = 1; i < length; i++) {
            Class<?> cls = parameterTypes[i];
            if (cls == String.class) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_S";
            } else if (cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_N";
            } else if (cls == Boolean.TYPE) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_B";
            } else if (cls == JSONObject.class) {
                sb = new StringBuilder();
                sb.append(name);
                str = "_O";
            } else {
                sb = new StringBuilder();
                sb.append(name);
                str = "_P";
            }
            sb.append(str);
            name = sb.toString();
        }
        return name;
    }

    public String a() {
        return this.f4527c;
    }

    public String a(WebView webView, String str) {
        StringBuilder sb;
        String message;
        String sb2;
        if (TextUtils.isEmpty(str)) {
            sb2 = "call data empty";
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("method");
                JSONArray jSONArray = jSONObject.getJSONArray("types");
                JSONArray jSONArray2 = jSONObject.getJSONArray("args");
                int length = jSONArray.length();
                Object[] objArr = new Object[length + 1];
                int i = 0;
                objArr[0] = webView;
                int i2 = 0;
                while (true) {
                    Object obj = null;
                    if (i >= length) {
                        break;
                    }
                    String optString = jSONArray.optString(i);
                    if ("string".equals(optString)) {
                        string = string + "_S";
                        int i3 = i + 1;
                        if (!jSONArray2.isNull(i)) {
                            obj = jSONArray2.getString(i);
                        }
                        objArr[i3] = obj;
                    } else if ("number".equals(optString)) {
                        string = string + "_N";
                        i2 = (i2 * 10) + i + 1;
                    } else if ("boolean".equals(optString)) {
                        string = string + "_B";
                        objArr[i + 1] = Boolean.valueOf(jSONArray2.getBoolean(i));
                    } else if ("object".equals(optString)) {
                        string = string + "_O";
                        int i4 = i + 1;
                        if (!jSONArray2.isNull(i)) {
                            obj = jSONArray2.getJSONObject(i);
                        }
                        objArr[i4] = obj;
                    } else {
                        string = string + "_P";
                    }
                    i++;
                }
                Method method = this.f4525a.get(string);
                if (method == null) {
                    return a(str, 500, "not found method(" + string + ") with valid parameters");
                }
                if (i2 > 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    while (i2 > 0) {
                        int i5 = i2 - ((i2 / 10) * 10);
                        Class<?> cls = parameterTypes[i5];
                        if (cls == Integer.TYPE) {
                            objArr[i5] = Integer.valueOf(jSONArray2.getInt(i5 - 1));
                        } else if (cls == Long.TYPE) {
                            objArr[i5] = Long.valueOf(Long.parseLong(jSONArray2.getString(i5 - 1)));
                        } else {
                            objArr[i5] = Double.valueOf(jSONArray2.getDouble(i5 - 1));
                        }
                        i2 /= 10;
                    }
                }
                return a(str, l.a.DEFAULT_DRAG_ANIMATION_DURATION, method.invoke(null, objArr));
            } catch (Exception e2) {
                if (e2.getCause() != null) {
                    sb = new StringBuilder();
                    sb.append("method execute error:");
                    message = e2.getCause().getMessage();
                } else {
                    sb = new StringBuilder();
                    sb.append("method execute error:");
                    message = e2.getMessage();
                }
                sb.append(message);
                sb2 = sb.toString();
            }
        }
        return a(str, 500, sb2);
    }
}
