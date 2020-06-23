package tr.edu.mu.ceng.gui.notification;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bildirimler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildirimler);

        TextView textView = findViewById(R.id.text_view);

        String message = getIntent().getStringExtra("message");
        textView.setText(message);
    }
}