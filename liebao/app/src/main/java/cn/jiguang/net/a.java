package cn.jiguang.net;

import android.content.Context;
import android.os.AsyncTask;
import cn.jiguang.net.HttpUtils;

/* loaded from: classes.dex */
final class a extends AsyncTask<HttpRequest, Void, HttpResponse> {

    /* renamed from: a  reason: collision with root package name */
    private HttpUtils.HttpListener f4157a;

    /* renamed from: b  reason: collision with root package name */
    private Context f4158b;

    public a(Context context, HttpUtils.HttpListener httpListener) {
        this.f4157a = httpListener;
        this.f4158b = context;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ HttpResponse doInBackground(HttpRequest[] httpRequestArr) {
        HttpRequest[] httpRequestArr2 = httpRequestArr;
        if (httpRequestArr2 == null || httpRequestArr2.length == 0) {
            return null;
        }
        return HttpUtils.httpGet(this.f4158b, httpRequestArr2[0]);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(HttpResponse httpResponse) {
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
    }
}
