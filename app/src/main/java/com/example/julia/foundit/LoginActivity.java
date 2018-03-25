//package edu.gatech.t_squaremobile;
package com.example.julia.foundit;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import com.example.julia.foundit.LostItemBrowseActivity;
import com.example.julia.foundit.R;

//import edu.gatech.t_squaremobile.R;

public class LoginActivity extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_login);

        webView = (WebView)findViewById(R.id.webView);
        webView.clearCache(true);
        webView.clearHistory();
        webView.loadUrl("google.com");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!url.contains("dev.m") || url.contains("cas")) {
                    view.loadUrl(url);
                } else {
                    // run "mockup"-specific code
                    String cookies = CookieManager.getInstance().getCookie(url);
//                    String[] splitParams = url.split("\\?")[1].split("&");
                    String[] splitParams = cookies.split("=");
//                    String sessionName = splitParams[0].split("=")[1];
//                    String sessionId = splitParams[1].split("=")[1];
                    String sessionName = splitParams[0];
                    String sessionId = splitParams[1];
                    //GlobalState.setSessionName(sessionName);
                    //GlobalState.setSessionId(sessionId);
                    Intent homeIntent = new Intent(getApplicationContext(), LostItemBrowseActivity.class);
                    startActivity(homeIntent);

                }
                return true;
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        LoginActivity.this);

                alertDialogBuilder.setTitle("Refresh page");
                alertDialogBuilder
                        .setMessage("Login page has failed to load. Would you like to try again?")
                        .setCancelable(false)
                        .setPositiveButton("Refresh", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                webView.reload();
                            }
                        })

                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        // if this button is clicked, just close
                                        // the dialog box and do nothing
                                        dialog.cancel();
                                    }
                                });
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });


        webView.getSettings().setJavaScriptEnabled(true);

        setProgressBarIndeterminateVisibility(true);
        setProgressBarVisibility(true);


        final Activity activity = this;
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                activity.setProgress(progress * 100);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri data = intent.getData();
        if(data != null) {
            if(data.getQueryParameter("sessionName") != null && data.getQueryParameter("sessionId") != null) {
                //GlobalState.setSessionName(data.getQueryParameter("sessionName"));
                //GlobalState.setSessionId(data.getQueryParameter("sessionId"));
            }
        }
        Intent homeIntent = new Intent(this, LostItemBrowseActivity.class);
        startActivity(homeIntent);
    }

    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //	getMenuInflater().inflate(R.menu.login, menu);
    //	return true;
    //}

//	public void onPress(View view) {
//
////		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APIEndpoints.LOGINURL));
////        intent.putExtra(Browser.EXTRA_APPLICATION_ID, "com.android.chrome");
//////		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
////		startActivity(intent);
//
//        WebView webview = new WebView(this);
//        setContentView(webview);
//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.loadUrl(APIEndpoints.LOGINURL);
//
//    }
//
//	public void onPress2(View view) {
//		final Intent intent = new Intent(this, HomeScreenActivity.class);
//		final View addView = getLayoutInflater().inflate(
//				R.layout.set_debug_credentials, null);
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//		builder.setTitle("Set debug mode credentials");
//		builder.setView(addView);
//		// Set up the buttons
//		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//			@SuppressWarnings("unchecked")
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				EditText edittextUserId = (EditText) addView.findViewById(R.id.EditTextEnterUserId);
//				EditText edittextSessionName = (EditText) addView.findViewById(R.id.EditTextEnterSessionName);
//				EditText edittextSessionId = (EditText) addView.findViewById(R.id.EditTextEnterSessionId);
//				GlobalState.setUserId(edittextUserId.getText().toString());
//				GlobalState.setSessionName(edittextSessionName.getText().toString());
//				GlobalState.setSessionId(edittextSessionId.getText().toString());
//
//				startActivity(intent);
//			}
//		});
//		builder.setNegativeButton("Cancel",
//				new DialogInterface.OnClickListener() {
//			@Override
//			public void onClick(DialogInterface dialog, int which) {
//				dialog.cancel();
//			}
//		});
//		builder.show();
//
//	}
}