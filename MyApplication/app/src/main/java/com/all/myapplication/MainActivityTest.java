package com.all.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import Util.AppUtils;
import Util.Domain;
import Util.SecurityUtil;
import Util.jni.AHAPIHelper;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/*
Sure! Another way to achieve this is to use a `Handler` and `Runnable`.
You can create a `Handler` in the `MainActivity` and pass it to the first thread.
In the first thread, after receiving the response from the first request,
you can create a `Runnable` that sends the second request and
pass the response from the first request to it.
Then you can use the `Handler` to post this `Runnable` to the main thread.
This way, the second request will be sent after the first request has finished.

Here's an example of how you could implement this:

```java
class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start first thread and pass handler
        new FirstThread(handler).start();
    }
}

class FirstThread extends Thread {
    private Handler handler;

    public FirstThread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        // Send first request and get response
        final String response = "response from first request";
        // Create Runnable that sends second request
        Runnable secondRequestRunnable = new Runnable() {
            @Override
            public void run() {
                // Use response to send second request
            }
        };
        // Post Runnable to main thread using handler
        handler.post(secondRequestRunnable);
    }
}
```
*/
public class MainActivityTest extends AppCompatActivity {
    private static final String REPLY_LIST = "/sns-itr/v1/reply/content-reply-list";
    private static final String GET_VISITOR_USERID = "/api/v1/app/user_core/users/getVisitorUserId";
    private static final String SHUMEI_ID = "20210807163758afabf6d66401eb2e4f234dbe68af5705014c79067d50b114";
    private static final String ctime = String.valueOf(System.currentTimeMillis());
    private static final String uuid = AppUtils.createAndroidId();
    Map<String, String> replyParamDict = new HashMap<>();
    TextView responseText;

    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start first thread and pass handler
//        new FirstThread(handler).start();
    }




}
