package com.yimt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class keyboard extends AppCompatActivity {
    private static final int REQUEST_CODE_LANGUAGE = 1;
    private TextView sourceLanguageBot;
    private TextView targetLanguageBot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);

        sourceLanguageBot = findViewById(R.id.SourceLanguageBot);
        targetLanguageBot = findViewById(R.id.TargetLanguageBot);
        ImageButton removeSourceText = findViewById(R.id.RemoveSourceText);
        TextView sourceText = findViewById(R.id.SourceLanguageTop);

        removeSourceText.setOnClickListener(v -> {
            sourceText.setText("");
        });

        sourceLanguageBot.setOnClickListener(v -> {
            Intent intent = new Intent(this, language.class);
            intent.putExtra("viewId", R.id.SourceLanguageBot);
            startActivityForResult(intent, REQUEST_CODE_LANGUAGE);
        });

        targetLanguageBot.setOnClickListener(v -> {
            Intent intent = new Intent(this, language.class);
            intent.putExtra("viewId", R.id.TargetLanguageBot);
            startActivityForResult(intent, REQUEST_CODE_LANGUAGE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_LANGUAGE && resultCode == RESULT_OK && data != null) {
            int viewId = data.getIntExtra("viewId", 0);
            String language = data.getStringExtra("language");

            if (viewId == R.id.SourceLanguageBot) {
                sourceLanguageBot.setText(language);
            } else if (viewId == R.id.TargetLanguageBot) {
                targetLanguageBot.setText(language);
            }
        }
    }


}