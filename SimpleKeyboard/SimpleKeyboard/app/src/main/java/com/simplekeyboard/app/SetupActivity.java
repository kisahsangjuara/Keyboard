package com.simplekeyboard.app;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 80, 40, 40);

        TextView tv = new TextView(this);
        tv.setText("Simple Keyboard Setup\n\n"
            + "Step 1: Tap 'Enable Keyboard' and turn ON Simple Keyboard.\n\n"
            + "Step 2: Tap 'Set as Default' and choose Simple Keyboard.\n\n"
            + "Tip: The hidden search button is at the end of the number row (after '0'). "
            + "Tap it to open Google inside the keyboard!");
        tv.setTextSize(16);
        tv.setPadding(0, 0, 0, 40);

        Button enableBtn = new Button(this);
        enableBtn.setText("Step 1: Enable Keyboard");
        enableBtn.setOnClickListener(v ->
            startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)));

        Button defaultBtn = new Button(this);
        defaultBtn.setText("Step 2: Set as Default");
        defaultBtn.setOnClickListener(v -> {
            android.view.inputmethod.InputMethodManager imm =
                (android.view.inputmethod.InputMethodManager)
                    getSystemService(INPUT_METHOD_SERVICE);
            imm.showInputMethodPicker();
        });

        layout.addView(tv);
        layout.addView(enableBtn);
        layout.addView(defaultBtn);
        setContentView(layout);
    }
}
