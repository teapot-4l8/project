package com.just.agentweb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.appcompat.app.b;

/* loaded from: classes.dex */
public class DefaultUIController extends AbsAgentWebUIController {
    private Activity mActivity;
    private b mAlertDialog;
    protected b mConfirmDialog;
    private ProgressDialog mProgressDialog;
    private WebParentLayout mWebParentLayout;
    private JsPromptResult mJsPromptResult = null;
    private JsResult mJsResult = null;
    private b mPromptDialog = null;
    private b mAskOpenOtherAppDialog = null;
    private Resources mResources = null;

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onPermissionsDeny(String[] strArr, String str, String str2) {
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsAlert(WebView webView, String str, String str2) {
        AgentWebUtils.toastShowShort(webView.getContext().getApplicationContext(), str2);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onOpenPagePrompt(WebView webView, String str, final Handler.Callback callback) {
        LogUtils.i(this.TAG, "onOpenPagePrompt");
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            if (this.mAskOpenOtherAppDialog == null) {
                this.mAskOpenOtherAppDialog = new b.a(activity).b(this.mResources.getString(R.string.agentweb_leave_app_and_go_other_page, AgentWebUtils.getApplicationName(activity))).a(this.mResources.getString(R.string.agentweb_tips)).b(17039360, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Handler.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.handleMessage(Message.obtain((Handler) null, -1));
                        }
                    }
                }).a(this.mResources.getString(R.string.agentweb_leave), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Handler.Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.handleMessage(Message.obtain((Handler) null, 1));
                        }
                    }
                }).b();
            }
            this.mAskOpenOtherAppDialog.show();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        onJsConfirmInternal(str2, jsResult);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onSelectItemsPrompt(WebView webView, String str, String[] strArr, Handler.Callback callback) {
        showChooserInternal(strArr, callback);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onForceDownloadAlert(String str, Handler.Callback callback) {
        onForceDownloadAlertInternal(callback);
    }

    private void onForceDownloadAlertInternal(final Handler.Callback callback) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            new b.a(activity).a(this.mResources.getString(R.string.agentweb_tips)).b(this.mResources.getString(R.string.agentweb_honeycomblow)).b(this.mResources.getString(R.string.agentweb_download), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    Handler.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.handleMessage(Message.obtain());
                    }
                }
            }).a(this.mResources.getString(R.string.agentweb_cancel), new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            }).b().show();
        }
    }

    private void showChooserInternal(String[] strArr, final Handler.Callback callback) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            b b2 = new b.a(activity).a(strArr, -1, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    String str = DefaultUIController.this.TAG;
                    LogUtils.i(str, "which:" + i);
                    if (callback != null) {
                        Message obtain = Message.obtain();
                        obtain.what = i;
                        callback.handleMessage(obtain);
                    }
                }
            }).a(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.5
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    Handler.Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.handleMessage(Message.obtain((Handler) null, -1));
                    }
                }
            }).b();
            this.mAlertDialog = b2;
            b2.show();
        }
    }

    private void onJsConfirmInternal(String str, JsResult jsResult) {
        String str2 = this.TAG;
        LogUtils.i(str2, "activity:" + this.mActivity.hashCode() + "  ");
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            toCancelJsresult(jsResult);
        } else if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            toCancelJsresult(jsResult);
        } else {
            if (this.mConfirmDialog == null) {
                this.mConfirmDialog = new b.a(activity).b(str).b(17039360, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.9
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DefaultUIController defaultUIController = DefaultUIController.this;
                        defaultUIController.toDismissDialog(defaultUIController.mConfirmDialog);
                        DefaultUIController defaultUIController2 = DefaultUIController.this;
                        defaultUIController2.toCancelJsresult(defaultUIController2.mJsResult);
                    }
                }).a(17039370, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.8
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DefaultUIController defaultUIController = DefaultUIController.this;
                        defaultUIController.toDismissDialog(defaultUIController.mConfirmDialog);
                        if (DefaultUIController.this.mJsResult != null) {
                            DefaultUIController.this.mJsResult.confirm();
                        }
                    }
                }).a(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        DefaultUIController defaultUIController = DefaultUIController.this;
                        defaultUIController.toCancelJsresult(defaultUIController.mJsResult);
                    }
                }).b();
            }
            this.mConfirmDialog.a(str);
            this.mJsResult = jsResult;
            this.mConfirmDialog.show();
        }
    }

    private void onJsPromptInternal(String str, String str2, JsPromptResult jsPromptResult) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            jsPromptResult.cancel();
        } else if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            jsPromptResult.cancel();
        } else {
            if (this.mPromptDialog == null) {
                final EditText editText = new EditText(activity);
                editText.setText(str2);
                this.mPromptDialog = new b.a(activity).b(editText).a(str).b(17039360, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.12
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DefaultUIController defaultUIController = DefaultUIController.this;
                        defaultUIController.toDismissDialog(defaultUIController.mPromptDialog);
                        DefaultUIController defaultUIController2 = DefaultUIController.this;
                        defaultUIController2.toCancelJsresult(defaultUIController2.mJsPromptResult);
                    }
                }).a(17039370, new DialogInterface.OnClickListener() { // from class: com.just.agentweb.DefaultUIController.11
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DefaultUIController defaultUIController = DefaultUIController.this;
                        defaultUIController.toDismissDialog(defaultUIController.mPromptDialog);
                        if (DefaultUIController.this.mJsPromptResult != null) {
                            DefaultUIController.this.mJsPromptResult.confirm(editText.getText().toString());
                        }
                    }
                }).a(new DialogInterface.OnCancelListener() { // from class: com.just.agentweb.DefaultUIController.10
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        dialogInterface.dismiss();
                        DefaultUIController defaultUIController = DefaultUIController.this;
                        defaultUIController.toCancelJsresult(defaultUIController.mJsPromptResult);
                    }
                }).b();
            }
            this.mJsPromptResult = jsPromptResult;
            this.mPromptDialog.show();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        onJsPromptInternal(str2, str3, jsPromptResult);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onMainFrameError(WebView webView, int i, String str, String str2) {
        String str3 = this.TAG;
        LogUtils.i(str3, "mWebParentLayout onMainFrameError:" + this.mWebParentLayout);
        WebParentLayout webParentLayout = this.mWebParentLayout;
        if (webParentLayout != null) {
            webParentLayout.showPageMainFrameError();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowMainFrame() {
        WebParentLayout webParentLayout = this.mWebParentLayout;
        if (webParentLayout != null) {
            webParentLayout.hideErrorLayout();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onLoading(String str) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new ProgressDialog(activity);
            }
            this.mProgressDialog.setCancelable(false);
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setMessage(str);
            this.mProgressDialog.show();
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onCancelLoading() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.mProgressDialog.dismiss();
            }
            this.mProgressDialog = null;
        }
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowMessage(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !str2.contains("performDownload")) {
            AgentWebUtils.toastShowShort(this.mActivity.getApplicationContext(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toCancelJsresult(JsResult jsResult) {
        if (jsResult != null) {
            jsResult.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.just.agentweb.AbsAgentWebUIController
    public void bindSupportWebParent(WebParentLayout webParentLayout, Activity activity) {
        this.mActivity = activity;
        this.mWebParentLayout = webParentLayout;
        this.mResources = activity.getResources();
    }
}
