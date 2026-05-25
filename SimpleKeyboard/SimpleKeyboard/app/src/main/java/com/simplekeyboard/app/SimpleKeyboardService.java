package com.simplekeyboard.app;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class SimpleKeyboardService extends InputMethodService {

    private boolean isUpperCase = false;
    private boolean webViewVisible = false;
    private WebView webView;

    @Override
    public View onCreateInputView() {
        View keyboardView = getLayoutInflater().inflate(R.layout.keyboard_view, null);

        webView = keyboardView.findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com");

        int[] letterIds = {
            R.id.key_q, R.id.key_w, R.id.key_e, R.id.key_r, R.id.key_t,
            R.id.key_y, R.id.key_u, R.id.key_i, R.id.key_o, R.id.key_p,
            R.id.key_a, R.id.key_s, R.id.key_d, R.id.key_f, R.id.key_g,
            R.id.key_h, R.id.key_j, R.id.key_k, R.id.key_l,
            R.id.key_z, R.id.key_x, R.id.key_c, R.id.key_v, R.id.key_b,
            R.id.key_n, R.id.key_m
        };

        for (int id : letterIds) {
            Button btn = keyboardView.findViewById(id);
            btn.setOnClickListener(v -> {
                String ch = ((Button) v).getText().toString();
                getCurrentInputConnection().commitText(
                    isUpperCase ? ch.toUpperCase() : ch.toLowerCase(), 1);
            });
        }

        int[] numIds = {
            R.id.key_1, R.id.key_2, R.id.key_3, R.id.key_4, R.id.key_5,
            R.id.key_6, R.id.key_7, R.id.key_8, R.id.key_9, R.id.key_0
        };
        for (int id : numIds) {
            Button btn = keyboardView.findViewById(id);
            btn.setOnClickListener(v ->
                getCurrentInputConnection().commitText(
                    ((Button) v).getText().toString(), 1));
        }

        keyboardView.findViewById(R.id.key_space).setOnClickListener(v ->
            getCurrentInputConnection().commitText(" ", 1));

        keyboardView.findViewById(R.id.key_delete).setOnClickListener(v ->
            getCurrentInputConnection().deleteSurroundingText(1, 0));

        keyboardView.findViewById(R.id.key_enter).setOnClickListener(v ->
            getCurrentInputConnection().performEditorAction(EditorInfo.IME_ACTION_GO));

        keyboardView.findViewById(R.id.key_comma).setOnClickListener(v ->
            getCurrentInputConnection().commitText(",", 1));

        keyboardView.findViewById(R.id.key_period).setOnClickListener(v ->
            getCurrentInputConnection().commitText(".", 1));

        Button shiftBtn = keyboardView.findViewById(R.id.key_shift);
        shiftBtn.setOnClickListener(v -> {
            isUpperCase = !isUpperCase;
            shiftBtn.setAlpha(isUpperCase ? 1.0f : 0.5f);
            for (int id : letterIds) {
                Button b = keyboardView.findViewById(id);
                b.setText(isUpperCase
                    ? b.getText().toString().toUpperCase()
                    : b.getText().toString().toLowerCase());
            }
        });

        // Hidden search button — toggles WebView panel
        keyboardView.findViewById(R.id.key_search).setOnClickListener(v -> {
            webViewVisible = !webViewVisible;
            webView.setVisibility(webViewVisible ? View.VISIBLE : View.GONE);
        });

        return keyboardView;
    }
}
