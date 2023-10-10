package com.all.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import static com.tg.android.anti.NativeLib.*;

public class ActivityGithub extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        TextView frida = findViewById(R.id.frida);
        frida.setText(AntiFrida()); // hook break down

        TextView xposed = findViewById(R.id.xposed);
        xposed.setText(AntiXposed());

        TextView root = findViewById(R.id.root);
        root.setText(AntiRoot());

        TextView debug = findViewById(R.id.debug);
        debug.setText(AntiDebug());

        TextView memDump = findViewById(R.id.memDump);
        memDump.setText(AntiMemDump());

        TextView emulator = findViewById(R.id.emulator);
        emulator.setText(AntiEmulator());

        TextView dualApp = findViewById(R.id.dualApp);
        dualApp.setText(AntiDualApp());

    }
}
