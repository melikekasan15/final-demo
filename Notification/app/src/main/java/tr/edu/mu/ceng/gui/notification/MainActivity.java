package tr.edu.mu.ceng.gui.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class  MainActivity extends AppCompatActivity {
    // 1. notification channel
    // 2. notification Builder
    // 3. notification Manager

    private static final String CHANNEL_ID = "notification";
    private static final String CHANNEL_NAME = "notification";
    private static final String CHANNEL_DESC = "Erken Uyarı Bildirim Paneli";
    private int id;
    //private Context context;
    //private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.text_view);

        String message = getIntent().getStringExtra("message");
        textView.setText(message);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        findViewById(R.id.buttonNotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "Bölge 1 için acil ilaçlama ...";
                NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                        .setContentTitle("ACİL!!")
                        .setContentText(message)
                        .setAutoCancel(true);
                displayNotification();
            }
        });
    }

    private void displayNotification() {
        String message = "Bölge 1 için acil ilaçlama ...";
        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp)
                .setContentTitle("ACİL!!")
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(id, mbuilder.build());

    }
}











