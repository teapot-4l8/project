package com.speed.speed_library.debug.netinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.c;
import androidx.core.content.b;
import com.speed.speed_library.R;

/* loaded from: classes2.dex */
public class NetInfoActivity extends c {
    private EditText k;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_netinfo);
        setTitle("网络诊断");
        if (b.b(this, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            androidx.core.app.a.a(this, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 1);
        }
        this.k = (EditText) findViewById(R.id.main_activity_et_input);
        findViewById(R.id.start_btn).setOnClickListener(new View.OnClickListener() { // from class: com.speed.speed_library.debug.netinfo.NetInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(NetInfoActivity.this.getApplicationContext(), RoutesActivity.class);
                intent.putExtra("http", NetInfoActivity.this.k.getText().toString());
                NetInfoActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.start_routes).setOnClickListener(new View.OnClickListener() { // from class: com.speed.speed_library.debug.netinfo.NetInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetInfoActivity.this.startActivity(new Intent(NetInfoActivity.this.getApplicationContext(), RoutesActivity.class));
            }
        });
        findViewById(R.id.start_interfaces).setOnClickListener(new View.OnClickListener() { // from class: com.speed.speed_library.debug.netinfo.NetInfoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NetInfoActivity.this.startActivity(new Intent(NetInfoActivity.this.getApplicationContext(), InterfacesActivity.class));
            }
        });
    }
}
