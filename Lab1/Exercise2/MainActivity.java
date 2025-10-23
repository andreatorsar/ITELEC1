package com.example.mainactivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvName;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvTitle = findViewById(R.id.tvTitle);
        tvName = findViewById(R.id.tvName);
        etName = findViewById(R.id.etName);

        etName.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) { // when user finishes typing
                String name = etName.getText().toString();
                if (!name.isEmpty()) {
                    tvTitle.setText("Welcome, " + name + "!");
                } else {
                    tvTitle.setText("User Information");
                }
            }
        });
    }
}
