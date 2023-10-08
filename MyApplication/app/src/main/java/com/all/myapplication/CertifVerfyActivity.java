package com.all.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import androidx.annotation.Nullable;
import android.util.Base64;

import java.io.InputStream;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CertifVerfyActivity extends AppCompatActivity {
    private Button btnPubKey, btnCert, btnHost;
    private StringBuilder stringBuilder1, stringBuilder2, stringBuilder3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cert);

        btnPubKey = findViewById(R.id.PubKeyBtn);
        btnCert = findViewById(R.id.CertBtn);
        btnHost = findViewById(R.id.HostBtn);

        btnPubKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRequestPubKey();
            }
        });

        btnCert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRequestCert();
            }
        });

        btnHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doRequestHost();
            }
        });
    }

    private void doRequestPubKey() {
        /**
         * 公钥验证
         * */
        stringBuilder1 = new StringBuilder();
        new Thread() {
            @Override
            public void run() {
                //获取目标公钥: openssl s_client -connect www.baidu.com:443 -servername www.baidu.com | openssl x509 -pubkey -noout | openssl rsa -pubin -outform der | openssl dgst -sha256 -binary | openssl enc -base64
                //获取目标公钥: openssl s_client -connect www.baidu.com:443 -servername www.baidu.com | openssl x509 -pubkey -noout | openssl rsa -pubin -outform der | openssl dgst -sha1 -binary | openssl enc -base64
                // 每个人的电脑都不一样
                final String CA_PUBLIC_KEY = "sha256/Q6TCQAWqP4t+eq41xnKaUgJdrPWqyG5L+Ni2YzMhqdY=";
                final String CA_DOMAIN = "www.baidu.com";
                //只校验公钥
                CertificatePinner pinner = new CertificatePinner.Builder().add(CA_DOMAIN, CA_PUBLIC_KEY).build();
                OkHttpClient client = new OkHttpClient.Builder().certificatePinner(pinner).build();
                Request req = new Request.Builder().url("https://www.baidu.com/?q=defaultCerts").build();
                Call call = client.newCall(req);
                try {
                    Response res = call.execute();
//                    Log.e("[doRequestPubKey]", "状态码：" + res.code());
                    stringBuilder1.append("[PubKey] 请求发送成功 状态码").append(res.code());
//                    setTextViewText(R.id.result_text, "请求发送成功" + "状态码：" + res.code());
                } catch (IOException ex) {
//                    Log.e("[doRequestPubKey]", "网络请求异常" + ex);
                    stringBuilder1.append("请求失败 网络请求异常").append(ex);
//                    setTextViewText(R.id.result_text, "请求失败" + "网络请求异常" + ex);
                }
                String result = stringBuilder1.toString();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setTextViewText(R.id.result_text, result);
                    }
                });
            }

        }.start();
    }

    private void doRequestCert() {
        /**
         * 证书校验
         * */
        stringBuilder2 = new StringBuilder();
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                // 服务器返回的证书
                X509Certificate cf = chain[0];
                RSAPublicKey pubkey = (RSAPublicKey) cf.getPublicKey();
                String encoded = Base64.encodeToString(pubkey.getEncoded(), 0);
//                Log.e("服务器返回证书：", encoded);
                stringBuilder2.append("服务器返回证书：").append(encoded);

                // 读取客户端预设的证书
                InputStream client_input = getResources().openRawResource(R.raw.baidu);
                CertificateFactory finalcf = CertificateFactory.getInstance("X.509");
                X509Certificate realCertificate = (X509Certificate) finalcf.generateCertificate(client_input);
                String realPubKey = Base64.encodeToString(realCertificate.getPublicKey().getEncoded(), 0);
//                Log.e("客户端预设证书：", realPubKey);
                stringBuilder2.append("客户端预设证书：").append(realPubKey);

                cf.checkValidity();

                final boolean expected = realPubKey.equalsIgnoreCase(encoded);
                Log.e("eq=", String.valueOf(expected));
                if (!expected) {
//                    setTextViewText(R.id.result_text, "证书不一致");
                    stringBuilder2.append("*证书不一致*");
                    throw new CertificateException("证书不一致");
                }
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };

        SSLSocketFactory factory = null;

        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
            factory = sslContext.getSocketFactory();
        } catch (Exception e) {
        }

        SSLSocketFactory finalFactory = factory;
        new Thread() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient.Builder().sslSocketFactory(finalFactory, trustManager).build();
                    Request req = new Request.Builder().url("https://www.baidu.com/?q=defaultCerts").build();
                    Call call = client.newCall(req);

                    Response res = call.execute();
//                    Log.e("[doRequestCert]", "状态码：" + res.code());
                    stringBuilder2.append("状态码：" + res.code());
                    String result = stringBuilder2.toString();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setTextViewText(R.id.result_text, result);
                        }
                    });
//                    Log.e("[doRequestCert]", stringBuilder2.toString());
                } catch (IOException ex) {
                    stringBuilder2.append("网络请求异常" + ex);
                    Log.e("[doRequestCert]", "网络请求异常" + ex);
                }
            }
        }.start();
    }

    private void doRequestHost() {
        /**
         * Host校验
         * */
        stringBuilder3 = new StringBuilder();
        HostnameVerifier verify = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                if("www.baidu.com".equalsIgnoreCase(hostname)){
                    return true;
                }
                return false;
            }
        };

        new Thread() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient.Builder().hostnameVerifier(verify).build();
                    Request req = new Request.Builder().url("https://www.baidu.com/?q=defaultCerts").build();
                    Call call = client.newCall(req);

                    Response res = call.execute();
//                    Log.e("[Host] 请求发送成功", "状态码：" + res.code());
                    stringBuilder3.append("[Host] 请求发送成功 状态码").append(res.code());
                } catch (IOException ex) {
                    stringBuilder3.append("网络请求异常").append(ex);
//                    Log.e("Main", "网络请求异常" + ex);
                }
                String result = stringBuilder3.toString();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setTextViewText(R.id.result_text, result);
                    }
                });
            }
        }.start();
    }

    private void setTextViewText(int textViewId, String text) {
        TextView textView = findViewById(textViewId);
        textView.setText(text);
    }

}
