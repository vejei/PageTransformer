package io.github.vejei.pagetransformer.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_view_pager).setOnClickListener((v) -> {
            Intent intent = new Intent(MainActivity.this, SamplesActivity.class);
            intent.putExtra("sample_type", 0);
            startActivity(intent);
        });
        findViewById(R.id.button_view_pager2).setOnClickListener((v) -> {
            Intent intent = new Intent(MainActivity.this, SamplesActivity.class);
            intent.putExtra("sample_type", 1);
            startActivity(intent);
        });
    }
}