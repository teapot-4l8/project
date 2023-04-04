package cn.jpush.android.s;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.TagAliasReceiver;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f4450a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f4451b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<Long, a> f4452c = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4453a;

        /* renamed from: b  reason: collision with root package name */
        public int f4454b;

        /* renamed from: c  reason: collision with root package name */
        public long f4455c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f4456d;

        /* renamed from: e  reason: collision with root package name */
        public String f4457e;
        public int f = -1;
        public int g = -1;
        public int h = 0;
        public int i;

        public a(int i, int i2, long j, ArrayList<String> arrayList, String str) {
            this.i = 0;
            this.f4453a = i;
            this.f4454b = i2;
            this.f4455c = j;
            this.f4456d = arrayList;
            if (i == 1 && arrayList == null) {
                this.f4456d = new ArrayList<>();
            }
            this.f4457e = str;
            this.i = 1;
        }

        public String toString() {
            return "TagAliasCacheBean{protoType=" + this.f4453a + ", actionType=" + this.f4454b + ", seqID=" + this.f4455c + ", tags=" + this.f4456d + ", alias='" + this.f4457e + "', totalPage=" + this.f + ", currPage=" + this.g + ", retryCount=" + this.h + '}';
        }
    }

    private a a(JSONObject jSONObject, a aVar) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onUpdateCacheNode,responseJson:" + jSONObject + ",tagAliasCacheNode:" + aVar);
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return null;
        }
        if (TextUtils.equals(jSONObject.optString("op"), "get")) {
            if (aVar.f4453a == 1) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("tags");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.getString(i));
                        }
                        if (arrayList.size() > 0) {
                            aVar.f4456d.addAll(arrayList);
                        }
                    }
                } catch (Throwable th) {
                    Logger.e("TagAliasNewProtoRetryHelper", "parse tag list failed - error:" + th);
                }
            } else {
                String optString = jSONObject.optString("alias");
                if (optString != null) {
                    aVar.f4457e = optString;
                }
            }
        }
        return aVar;
    }

    public static b a() {
        if (f4450a == null) {
            synchronized (f4451b) {
                if (f4450a == null) {
                    f4450a = new b();
                }
            }
        }
        return f4450a;
    }

    private boolean a(Context context, int i, a aVar) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - CheckAndSendAgain, errorCode:" + i + ",tagAliasCacheNode:" + aVar);
        if (i == 1 && aVar.h == 0) {
            aVar.h++;
            if (a(context, aVar.f4453a, aVar.f4455c)) {
                return true;
            }
            return b(context, aVar);
        }
        return false;
    }

    private boolean a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "tagAlias cache was null";
        } else {
            Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasResponse, tagAliasCacheNode:" + aVar);
            if (aVar.g < aVar.f) {
                return true;
            }
            str = "all tags info was loaded";
        }
        Logger.d("TagAliasNewProtoRetryHelper", str);
        return false;
    }

    private boolean b(Context context, a aVar) {
        String a2;
        String str;
        Logger.d("TagAliasNewProtoRetryHelper", "action - onSendAgain, tagAliasCacheNode:" + aVar);
        if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "onSendAgain - tagAliasCacheNode was null");
            return false;
        }
        if (aVar.f4453a == 1) {
            a2 = cn.jpush.android.s.a.a(context, aVar.f4456d, aVar.f4455c, aVar.f4454b, aVar.f, aVar.g);
        } else if (aVar.f4453a != 2) {
            Logger.d("TagAliasNewProtoRetryHelper", "unsupport proto type");
            return false;
        } else {
            a2 = cn.jpush.android.s.a.a(context, aVar.f4457e, aVar.f4455c, aVar.f4453a);
        }
        if (a2 != null) {
            if (aVar.h > 200) {
                this.f4452c.remove(Long.valueOf(aVar.f4455c));
                cn.jpush.android.s.a.a(context, aVar.f4453a, JPushInterface.ErrorCode.ERROR_CODE_TOO_BUSY, aVar.f4455c);
                str = "same tag/alias request times greate than 200";
            } else {
                cn.jpush.android.s.a.a(context, aVar.f4453a, aVar.f4455c, a2);
                aVar.h++;
                this.f4452c.put(Long.valueOf(aVar.f4455c), aVar);
                str = "send request success";
            }
            Logger.d("TagAliasNewProtoRetryHelper", str);
            return true;
        }
        return false;
    }

    public int a(int i, int i2) {
        if (i == 0) {
            return i2;
        }
        if (i2 != 100) {
            switch (i2) {
                case 1:
                case 2:
                    return JPushInterface.ErrorCode.ERROR_CODE_TOO_BUSY;
                case 3:
                    return JPushInterface.ErrorCode.ERROR_CODE_BLACKLIST;
                case 4:
                    return JPushInterface.ErrorCode.ERROR_CODE_INVALIDUSER;
                case 5:
                    return JPushInterface.ErrorCode.ERROR_CODE_INVALIDREQ;
                case 6:
                    return JPushInterface.ErrorCode.ERROR_CODE_TOO_MANY_TAGS;
                case 7:
                case 8:
                    return JPushInterface.ErrorCode.ERROR_CODE_GET_FAILED;
                default:
                    return i2;
            }
        }
        return JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE;
    }

    public int a(long j) {
        Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasTimeOut :" + j);
        a remove = this.f4452c.remove(Long.valueOf(j));
        Logger.d("TagAliasNewProtoRetryHelper", "onTagAliasTimeOut,removed cachenode:" + remove);
        if (remove != null) {
            return remove.f4453a;
        }
        return 0;
    }

    public Intent a(Context context, long j, int i, JSONObject jSONObject, Intent intent) {
        String str;
        Logger.d("TagAliasNewProtoRetryHelper", "action - onTagAliasResponse, seqID:" + j + ",errorCode:" + i + ",intent:" + intent);
        a aVar = this.f4452c.get(Long.valueOf(j));
        StringBuilder sb = new StringBuilder();
        sb.append("tagAliasCacheNode:");
        sb.append(aVar);
        Logger.d("TagAliasNewProtoRetryHelper", sb.toString());
        this.f4452c.remove(Long.valueOf(j));
        if (jSONObject == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "responseJson was null");
            return intent;
        } else if (aVar == null) {
            Logger.w("TagAliasNewProtoRetryHelper", "tagAliasCacheNode was null");
            return intent;
        } else {
            if (!a(context, i, aVar)) {
                if (i != 0) {
                    if (i == 100) {
                        long optLong = jSONObject.optLong("wait", -1L);
                        Logger.ww("TagAliasNewProtoRetryHelper", "set tag/alias action will freeze " + optLong + " seconds");
                        if (optLong > 0) {
                            cn.jpush.android.cache.a.a(context, optLong);
                        }
                    }
                    int a2 = a(aVar.f4453a, i);
                    intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, a2);
                    Logger.d("TagAliasNewProtoRetryHelper", "mapped errorCode:" + a2);
                    return intent;
                }
                aVar.h = 0;
                if (aVar.f4454b == 5) {
                    aVar.f = jSONObject.optInt("total", -1);
                    aVar.g = jSONObject.optInt("curr", -1);
                    a(jSONObject, aVar);
                }
                if (a(context, aVar)) {
                    aVar.g++;
                    Logger.d("TagAliasNewProtoRetryHelper", "load next page, currpage:" + aVar.g + ",totalPage:" + aVar.f);
                    if (a(context, aVar.f4453a, aVar.f4455c)) {
                        return null;
                    }
                    str = b(context, aVar) ? "get next page request was sended" : "get next page request was sended";
                }
                if (aVar.f4454b == 5) {
                    if (aVar.f4453a == 1) {
                        if (aVar.f4456d.size() > 0) {
                            intent.putStringArrayListExtra("tags", aVar.f4456d);
                        }
                    } else if (aVar.f4453a == 2 && aVar.f4457e != null) {
                        intent.putExtra("alias", aVar.f4457e);
                    }
                } else if (aVar.f4454b == 6) {
                    if (aVar.f4453a == 1) {
                        intent.putExtra("validated", jSONObject.optBoolean("validated", false));
                    } else {
                        Logger.w("TagAliasNewProtoRetryHelper", "unsupport  proto type");
                    }
                }
                return intent;
            }
            str = "retry action was sended";
            Logger.d("TagAliasNewProtoRetryHelper", str);
            return null;
        }
    }

    public void a(int i, int i2, long j, ArrayList<String> arrayList, String str) {
        a aVar = new a(i, i2, j, arrayList, str);
        Logger.d("TagAliasNewProtoRetryHelper", "action - createNewCacheNode, tagAliasCacheNode:" + aVar);
        this.f4452c.put(Long.valueOf(j), aVar);
    }

    public boolean a(int i) {
        ConcurrentHashMap<Long, a> concurrentHashMap = this.f4452c;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return true;
        }
        for (Map.Entry<Long, a> entry : this.f4452c.entrySet()) {
            a value = entry.getValue();
            if (value != null && value.f4453a == i) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Context context, int i, long j) {
        if ((i == 1 || i == 2) && cn.jpush.android.cache.a.i(context)) {
            Logger.w("TagAliasNewProtoRetryHelper", "tag/alias action was freezed");
            cn.jpush.android.s.a.a(context, i, JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE, j);
            return true;
        }
        return false;
    }
}
