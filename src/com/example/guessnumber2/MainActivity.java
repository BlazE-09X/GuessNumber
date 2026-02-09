package com.example.guessnumber2; // Пакет должен совпадать с названием на скриншоте

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Здесь R станет синим после Clean

        tvInfo = (TextView)findViewById(R.id.textView1);
        etInput = (EditText)findViewById(R.id.editText1);
        bControl = (Button)findViewById(R.id.button1);

        guess = (int)(Math.random() * 6);
        gameFinished = false;
    }

    public void onClick(View v) {
        if (!gameFinished) {
            String text = etInput.getText().toString();
            if (text.length() == 0) return;
            
            int inp = Integer.parseInt(text);

            if (inp > guess)
                tvInfo.setText(getResources().getString(R.string.ahead));
            else if (inp < guess)
                tvInfo.setText(getResources().getString(R.string.behind));
            else {
                tvInfo.setText(getResources().getString(R.string.hit));
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
            }
        } else {
            guess = (int)(Math.random() * 6);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        etInput.setText("");
    }
}