package com.speed.speed_library.module.setting;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.just.agentweb.DefaultWebClient;
import com.speed.speed_library.R;
import com.speed.speed_library.b.f;
import com.speed.speed_library.b.g;
import com.speed.speed_library.b.h;
import com.speed.speed_library.event.BadgeEvent;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.CommonModel;
import com.speed.speed_library.model.UploadModel;
import com.speed.speed_library.model.UserModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLConnection;
import java.util.HashMap;
import kotlin.d.b.i;
import okhttp3.ab;
import okhttp3.v;
import okhttp3.w;

/* compiled from: FeedbackActivity.kt */
/* loaded from: classes2.dex */
public final class FeedbackActivity extends com.speed.speed_library.a.a implements View.OnClickListener {
    private Uri o;
    private File p;
    private q.rorbin.badgeview.a r;
    private HashMap s;
    private int k = 1;
    private final int l = 1000;
    private final int m = DefaultWebClient.DERECT_OPEN_OTHER_PAGE;
    private final String n = "takenPhoto.jpg";

    /* renamed from: q  reason: collision with root package name */
    private String f5788q = "";

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.s == null) {
            this.s = new HashMap();
        }
        View view = (View) this.s.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.s.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_feedback);
        l();
        m();
    }

    public final void l() {
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText("问题反馈");
        LinearLayout linearLayout = (LinearLayout) d(R.id.ll_right);
        i.a((Object) linearLayout, "ll_right");
        linearLayout.setVisibility(0);
        ((ImageView) d(R.id.iv_right)).setImageDrawable(getResources().getDrawable(R.mipmap.ic_feedback_notice));
        EditText editText = (EditText) d(R.id.et_contact);
        UserModel j = g.f5610b.j();
        editText.setText((j == null || (r2 = j.getPhone()) == null) ? "" : "");
        q.rorbin.badgeview.a a2 = new q.rorbin.badgeview.e(this).a((ImageView) d(R.id.iv_right));
        i.a((Object) a2, "QBadgeView(this).bindTarget(iv_right)");
        this.r = a2;
        if (g.f5610b.f() > g.f5610b.u()) {
            q.rorbin.badgeview.a aVar = this.r;
            if (aVar == null) {
                i.b("mFeedbackBadge");
            }
            aVar.a(-1);
            return;
        }
        q.rorbin.badgeview.a aVar2 = this.r;
        if (aVar2 == null) {
            i.b("mFeedbackBadge");
        }
        aVar2.a(0);
    }

    public final void m() {
        FeedbackActivity feedbackActivity = this;
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(feedbackActivity);
        ((RadioGroup) d(R.id.radioGroup)).setOnCheckedChangeListener(new c());
        ((RadioGroup) d(R.id.radioGroup_two)).setOnCheckedChangeListener(new d());
        ((ImageView) d(R.id.iv_upload)).setOnClickListener(feedbackActivity);
        ((Button) d(R.id.btn_commit)).setOnClickListener(feedbackActivity);
        ((LinearLayout) d(R.id.ll_right)).setOnClickListener(feedbackActivity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FeedbackActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c implements RadioGroup.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            RadioButton radioButton = (RadioButton) FeedbackActivity.this.d(R.id.radioBtn_first);
            i.a((Object) radioButton, "radioBtn_first");
            if (radioButton.getId() == i) {
                RadioButton radioButton2 = (RadioButton) FeedbackActivity.this.d(R.id.radioBtn_first);
                i.a((Object) radioButton2, "radioBtn_first");
                if (radioButton2.isChecked()) {
                    ((RadioGroup) FeedbackActivity.this.d(R.id.radioGroup_two)).clearCheck();
                }
                FeedbackActivity.this.k = 1;
                return;
            }
            RadioButton radioButton3 = (RadioButton) FeedbackActivity.this.d(R.id.radioBtn_second);
            i.a((Object) radioButton3, "radioBtn_second");
            if (radioButton3.getId() == i) {
                RadioButton radioButton4 = (RadioButton) FeedbackActivity.this.d(R.id.radioBtn_second);
                i.a((Object) radioButton4, "radioBtn_second");
                if (radioButton4.isChecked()) {
                    ((RadioGroup) FeedbackActivity.this.d(R.id.radioGroup_two)).clearCheck();
                }
                FeedbackActivity.this.k = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FeedbackActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements RadioGroup.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            RadioButton radioButton = (RadioButton) FeedbackActivity.this.d(R.id.radioBtn_third);
            i.a((Object) radioButton, "radioBtn_third");
            if (radioButton.getId() == i) {
                RadioButton radioButton2 = (RadioButton) FeedbackActivity.this.d(R.id.radioBtn_third);
                i.a((Object) radioButton2, "radioBtn_third");
                if (radioButton2.isChecked()) {
                    ((RadioGroup) FeedbackActivity.this.d(R.id.radioGroup)).clearCheck();
                }
                FeedbackActivity.this.k = 3;
                return;
            }
            RadioButton radioButton3 = (RadioButton) FeedbackActivity.this.d(R.id.radioBtn_four);
            i.a((Object) radioButton3, "radioBtn_four");
            if (radioButton3.getId() == i) {
                RadioButton radioButton4 = (RadioButton) FeedbackActivity.this.d(R.id.radioBtn_four);
                i.a((Object) radioButton4, "radioBtn_four");
                if (radioButton4.isChecked()) {
                    ((RadioGroup) FeedbackActivity.this.d(R.id.radioGroup)).clearCheck();
                }
                FeedbackActivity.this.k = 0;
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            finish();
        } else if (i.a(view, (ImageView) d(R.id.iv_upload))) {
            r();
        } else if (i.a(view, (Button) d(R.id.btn_commit))) {
            q();
        } else if (i.a(view, (LinearLayout) d(R.id.ll_right))) {
            if (!com.speed.speed_library.business.e.f5632a.b()) {
                f.a("请登录后查看回复信息", 0, 2, null);
                com.speed.speed_library.business.a.f5623a.f();
                return;
            }
            com.speed.speed_library.b.c.f5594a.a(this, com.speed.speed_library.b.b.f5592a.f(), "反馈回复");
            g.f5610b.f(g.f5610b.f());
            q.rorbin.badgeview.a aVar = this.r;
            if (aVar == null) {
                i.b("mFeedbackBadge");
            }
            aVar.a(0);
            org.greenrobot.eventbus.c.a().d(new BadgeEvent());
        }
    }

    private final void r() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请上传图片");
        builder.setItems(new CharSequence[]{"拍照", "相册"}, new e());
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FeedbackActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                FeedbackActivity.this.n();
            } else if (i != 1) {
            } else {
                FeedbackActivity.this.o();
            }
        }
    }

    public final void n() {
        if (androidx.core.content.b.b(this, "android.permission.CAMERA") != 0) {
            androidx.core.app.a.a(this, new String[]{"android.permission.CAMERA"}, 2);
        } else {
            t();
        }
    }

    private final void t() {
        Uri fromFile;
        if (!i.a((Object) "mounted", (Object) Environment.getExternalStorageState())) {
            return;
        }
        File file = new File(getExternalCacheDir(), this.n);
        this.p = file;
        if (file == null) {
            try {
                i.b("camerPhotoFile");
            } catch (IOException unused) {
            }
        }
        file.exists();
        File file2 = this.p;
        if (file2 == null) {
            i.b("camerPhotoFile");
        }
        file2.createNewFile();
        if (com.speed.speed_library.b.c.f5594a.d()) {
            FeedbackActivity feedbackActivity = this;
            String string = getResources().getString(R.string.speed_provider_file_authorities);
            File file3 = this.p;
            if (file3 == null) {
                i.b("camerPhotoFile");
            }
            fromFile = FileProvider.getUriForFile(feedbackActivity, string, file3);
            i.a((Object) fromFile, "FileProvider.getUriForFi…erPhotoFile\n            )");
        } else {
            File file4 = this.p;
            if (file4 == null) {
                i.b("camerPhotoFile");
            }
            fromFile = Uri.fromFile(file4);
            i.a((Object) fromFile, "Uri.fromFile(camerPhotoFile)");
        }
        this.o = fromFile;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Uri uri = this.o;
        if (uri == null) {
            i.b("cameraPhotoUrl");
        }
        intent.putExtra("output", uri);
        startActivityForResult(intent, this.l);
    }

    public final void o() {
        if (androidx.core.content.b.b(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            androidx.core.app.a.a(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        } else {
            startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), this.m);
        }
    }

    @Override // androidx.fragment.app.e, android.app.Activity, androidx.core.app.a.InterfaceC0030a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        i.b(strArr, "permissions");
        i.b(iArr, "grantResults");
        if (i == 1) {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                o();
            } else {
                Toast.makeText(this, "You denied this permission!!", 0).show();
            }
        } else if (i != 2) {
        } else {
            if ((!(iArr.length == 0)) && iArr[0] == 0) {
                t();
            } else {
                Toast.makeText(this, "You denied this permission!!", 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.e, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != this.l) {
            if (i == this.m && i2 == -1) {
                Uri data = intent != null ? intent.getData() : null;
                if (data == null) {
                    i.a();
                }
                a(data);
            }
        } else if (i2 == -1) {
            try {
                File file = this.p;
                if (file == null) {
                    i.b("camerPhotoFile");
                }
                Uri fromFile = Uri.fromFile(file);
                i.a((Object) fromFile, "Uri.fromFile(camerPhotoFile)");
                this.o = fromFile;
                if (fromFile == null) {
                    i.b("cameraPhotoUrl");
                }
                a(fromFile);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void a(Uri uri) {
        i.b(uri, "uri");
        String a2 = com.speed.speed_library.utils.a.f5858a.a(this, uri);
        com.speed.speed_library.utils.a aVar = com.speed.speed_library.utils.a.f5858a;
        if (a2 == null) {
            i.a();
        }
        Bitmap a3 = com.speed.speed_library.utils.a.f5858a.a(aVar.a(a2), com.speed.speed_library.utils.a.f5858a.c(a2));
        if (a3 == null) {
            i.a();
        }
        ((ImageView) d(R.id.iv_upload)).setImageBitmap(a3);
        a(a2);
    }

    public final void a(String str) {
        i.b(str, "path");
        File file = new File(com.speed.speed_library.utils.a.f5858a.b(str));
        ab a2 = ab.a(v.b(URLConnection.getFileNameMap().getContentTypeFor(file.getName())), file);
        String name = file.getName();
        i.a((Object) name, "file?.name");
        int b2 = kotlin.h.g.b((CharSequence) name, ".", 0, false, 6, (Object) null);
        String name2 = file.getName();
        i.a((Object) name2, "file?.name");
        if (name2 == null) {
            throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
        }
        String substring = name2.substring(b2);
        i.a((Object) substring, "(this as java.lang.String).substring(startIndex)");
        w.b a3 = w.b.a("file", String.valueOf(System.currentTimeMillis()) + substring, a2);
        d.a.a.a.a.a a4 = d.a.a.a.a.c.f6985a.a();
        i.a((Object) a3, "part");
        a4.a(a3).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(s()).a(new b(this));
    }

    /* compiled from: FeedbackActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends com.speed.speed_library.a.c<BaseModel<UploadModel>> {
        b(Context context) {
            super(context);
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<UploadModel> baseModel) {
            i.b(baseModel, "response");
            if (h.f5614a.a(baseModel, true)) {
                FeedbackActivity.this.f5788q = baseModel.getData().getFile_path();
                f.a("上传成功", 0, 2, null);
                return;
            }
            ((ImageView) FeedbackActivity.this.d(R.id.iv_upload)).setImageDrawable(FeedbackActivity.this.getResources().getDrawable(R.mipmap.ic_setting_fadeback_upload_img));
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
            ((ImageView) FeedbackActivity.this.d(R.id.iv_upload)).setImageDrawable(FeedbackActivity.this.getResources().getDrawable(R.mipmap.ic_setting_fadeback_upload_img));
            f.a("图片上传失败，请重新上传", 0, 2, null);
        }
    }

    public final String p() {
        File file = new File(getApplicationInfo().dataDir + '/' + com.speed.speed_library.speed.a.a() + ".log");
        if (file.exists()) {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), kotlin.h.d.f7190a);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            String a2 = kotlin.c.b.a((Reader) bufferedReader);
            bufferedReader.close();
            return a2;
        }
        return "";
    }

    public final void q() {
        k();
        EditText editText = (EditText) d(R.id.et_content);
        i.a((Object) editText, "et_content");
        String obj = editText.getText().toString();
        if (obj == null) {
            throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String obj2 = kotlin.h.g.a(obj).toString();
        if (TextUtils.isEmpty(obj2) || obj2.length() < 3) {
            f.a("反馈内容必须超过3个字符", 0, 2, null);
            return;
        }
        g gVar = g.f5610b;
        String p = p();
        if (p == null) {
            p = "";
        }
        gVar.d(p);
        d.a.a.a.a.a a2 = d.a.a.a.a.c.f6985a.a();
        int i = this.k;
        EditText editText2 = (EditText) d(R.id.et_content);
        i.a((Object) editText2, "et_content");
        String obj3 = editText2.getText().toString();
        EditText editText3 = (EditText) d(R.id.et_contact);
        i.a((Object) editText3, "et_contact");
        a2.a(i, obj3, editText3.getText().toString(), this.f5788q, "", g.f5610b.g()).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(s()).a(new a(this));
    }

    /* compiled from: FeedbackActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends com.speed.speed_library.a.c<CommonModel> {
        a(Context context) {
            super(context);
        }

        @Override // com.speed.speed_library.a.c
        public void b(CommonModel commonModel) {
            i.b(commonModel, "response");
            if (h.f5614a.a(commonModel, true)) {
                f.a("反馈成功", 0, 2, null);
                FeedbackActivity.this.finish();
            }
        }

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
            f.a("反馈失败，请稍后再试", 0, 2, null);
        }
    }
}
