package com.example.yuanyuanlai.notebook.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MarkDownPreView extends NestedScrollView {

    private WebView mWebView;
    private Context mContext;
    private OnLoadingFinishListener mOnLoadingFinishListener;

    public MarkDownPreView(@NonNull Context context) {
        super(context);
    }

    public MarkDownPreView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MarkDownPreView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    public void init(Context context) {
        if (!isInEditMode()) {
            if (Build.VERSION.SDK_INT >= 21) {
                WebView.enableSlowWholeDocumentDraw();
            }
            this.mContext = context;
            this.mWebView = new WebView(context);
            this.mWebView.getSettings().setJavaScriptEnabled(true);
            this.mWebView.setVerticalScrollBarEnabled(false);
            this.mWebView.setHorizontalScrollBarEnabled(false);
            this.mWebView.addJavascriptInterface(new JavaScriptInterface(this), "handler");
            this.mWebView.setWebViewClient(new MarkDownWebViewClient(this));
            this.mWebView.loadUrl("file:///android_asset/markdown.html");
            addView(this.mWebView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        }
    }

    class MarkDownWebViewClient extends WebViewClient {

        MarkDownPreView markDownPreView;

        public MarkDownWebViewClient(MarkDownPreView markDownPreView) {
            this.markDownPreView = markDownPreView;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if(this.markDownPreView.mOnLoadingFinishListener != null) {
                this.markDownPreView.mOnLoadingFinishListener.onLoadingFinish();
            }
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    class JavaScriptInterface {

        private MarkDownPreView markDownPreView;

        public JavaScriptInterface(MarkDownPreView markDownPreView) {
            this.markDownPreView = markDownPreView;
        }

        public void none() {

        }

    }

    /**
    调用html里面的parseMarkdown方法
     */
    public void parseMarkDown(String html, boolean gfmEnabled) {
        this.mWebView.loadUrl("javascript:parseMarkdown(\"" + html.replace("\n", "\\n").replace("\"", "\\\"").replace("'", "\\'") + "\", " + gfmEnabled + ")");
    }

    public interface OnLoadingFinishListener {
        void onLoadingFinish();
    }

    public void setOnLoadingFinishListener(OnLoadingFinishListener onLoadingFinishListener) {
        mOnLoadingFinishListener = onLoadingFinishListener;
    }

}
