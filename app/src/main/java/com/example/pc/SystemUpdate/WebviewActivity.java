package com.example.pc.SystemUpdate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

public class WebviewActivity extends AppCompatActivity {

    WebView webView;
    String samsung, vivo, oppo, moto, mi, oneplus, nokia, hwae, htc;
    Button update;
    ProgressDialog progressl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        update = findViewById(R.id.updatebutton);

        webView = findViewById(R.id.webview);
        progressl = new ProgressDialog(WebviewActivity.this);
        moto = "https://support.motorola.com/in/en/softwareupgrade";
        nokia = "https://www.nokia.com/en_us/phones/support/nokia-6-user-guide/update-your-phone-software";
        oppo = "https://oppo-in.custhelp.com/app/soft_update";
        vivo = "http://www.vivoweb.org/support/user-guide/installation";
        mi = "http://en.miui.com/thread-2804733-1-1.html";
        oneplus = "https://downloads.oneplus.com/";
        hwae = "http://consumer.huawei.com/minisite/se/androidupdate/index.html";
        samsung = "https://www.samsung.com/uk/support/mobile-devices/how-do-i-check-for-operating-system-updates-on-my-samsung-galaxy-device/";
        htc = "https://www.htc.com/us/support/updates.aspx";
        int data = getIntent().getIntExtra("id", 10);

        switch (data) {
            case 1:
                webView.loadUrl(samsung);
                break;
            case 2:
                webView.loadUrl(htc);
                break;

            case 3:
                webView.loadUrl(hwae);
                break;

            case 4:
                webView.loadUrl(nokia);
                break;

            case 5:
                webView.loadUrl(mi);
                break;

            case 6:
                webView.loadUrl(moto);
                break;
            case 7:
                webView.loadUrl(oneplus);
                break;
            case 8:
                webView.loadUrl(vivo);
                break;
            case 9:
                webView.loadUrl(oppo);
                break;
            case 10:
                open();
                break;

            default:
                open();
        }

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebChromeClient(new WebChromeClient() {


            public void onProgressChanged(WebView view, int progress) {


                progressl.setTitle("Loading");
                progressl.setMessage("Wait while loading...");
                progressl.setCancelable(false); // disable dismiss by tapping outside of the dialog
                progressl.show();
// To dismiss the dialog

                 /*   if ((!webView.getUrl().equals(urlothers))) {
                        if ((!webView.getUrl().equals(url))
                                && (!webView.getUrl().equals("https://www.fbdown.net/download.php"))
                                && (!webView.getUrl().equals("https://twdown.net/download.php"))
                                ) {
                            webView.loadUrl(url);
                        }
                    }
                   */
                if (progress > 70) {
                    progressl.dismiss();
                }


            }
        });


        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        open();

                    }
                }
        );

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(WebviewActivity.this, MainActivity.class));
        finish();
    }

    private void open() {

        startActivity(new Intent(WebviewActivity.this, ScanActivity.class));
        finish();
    }
}
