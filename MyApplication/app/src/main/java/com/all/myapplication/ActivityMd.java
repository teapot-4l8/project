package com.all.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ActivityMd extends AppCompatActivity {
    static {
        System.loadLibrary("algorithm");
    }
    private TextView txtDataString;
    private String text;

    public native String md5_(String string);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.dataString);
                text = editText.getText().toString();

                String string = md5_(text);
                setTextViewText(R.id.newMdRes, string);

                String sb = OriginMd5(text);
                setTextViewText(R.id.oldMdRes, sb);
            }
        });

    }

    private String OriginMd5(String string) {
        try {
            // Create an instance of MessageDigest with MD5 algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Convert the input string to bytes
            byte[] inputBytes = string.getBytes();

            // Calculate the MD5 hash
            byte[] hashBytes = md.digest(inputBytes);

            // Convert the hash bytes to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            // Return the hexadecimal string representation of the MD5 hash
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void setTextViewText(int textViewId, String text) {
        TextView textView = findViewById(textViewId);
        textView.setText(text);
    }
}
