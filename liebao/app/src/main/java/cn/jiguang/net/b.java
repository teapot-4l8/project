package cn.jiguang.net;

import android.content.Context;
import android.os.AsyncTask;
import cn.jiguang.net.HttpUtils;

/* loaded from: classes.dex */
final class b extends AsyncTask<String, Void, HttpResponse> {

    /* renamed from: a  reason: collision with root package name */
    private HttpUtils.HttpListener f4159a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4160b;

    public b(HttpUtils.HttpListener httpListener, Context context) {
        this.f4159a = httpListener;
        this.f4160b = context;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ HttpResponse doInBackground(String[] strArr) {
        String[] strArr2 = strArr;
        if (strArr2 == null || strArr2.length == 0) {
            return null;
        }
        return HttpUtils.httpGet(this.f4160b, strArr2[0]);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(HttpResponse httpResponse) {
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
    }
}
