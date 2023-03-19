package com.nb.day30ssldemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRequest();
            }
        });
    }

    private void doRequest() {
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
        HostnameVerifier verify = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        new Thread() {
            @Override
            public void run() {
                try {
                    InputStream client_input = getResources().openRawResource(R.raw.client);
                    SSLContext sslContext = SSLContext.getInstance("TLS");
                    KeyStore keyStore = KeyStore.getInstance("PKCS12");
                    keyStore.load(client_input, "bilibilisucks".toCharArray());

                    KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                    keyManagerFactory.init(keyStore, "bilibilisucks".toCharArray());
                    sslContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[]{trustManager}, new SecureRandom());
                    SSLSocketFactory factory = sslContext.getSocketFactory();

                    OkHttpClient client = new OkHttpClient.Builder().sslSocketFactory(factory, trustManager).hostnameVerifier(verify).build();
                    Request req = new Request.Builder().url("https://192.168.43.71:443/index").build();
                    Call call = client.newCall(req);

                    Response res = call.execute();
                    Log.e("请求发送成功", "状态码：" + res.code());

                } catch (Exception ex) {
                    Log.e("Main", "网络请求异常" + ex);
                }
            }
        }.start();
    }
}