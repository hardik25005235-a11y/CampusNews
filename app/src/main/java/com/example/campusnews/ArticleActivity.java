package com.example.campusnews;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class ArticleActivity extends AppCompatActivity {

    TextView articleTitle;
    TextView articleContent;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        articleTitle = findViewById(R.id.articleTitle);
        articleContent = findViewById(R.id.articleContent);
        backButton = findViewById(R.id.backButton);

        String category = getIntent().getStringExtra("category");
        String title = getIntent().getStringExtra("title");

        articleTitle.setText(title);

        String content;

        if (category.equals("Academic")) {

            content = "The college has announced important information regarding "
                    + "the upcoming semester examinations. Students are advised "
                    + "to check the examination schedule and prepare accordingly.";

        } else if (category.equals("Events")) {

            content = "The annual college fest will be conducted on the college "
                    + "campus. Students can participate in various competitions, "
                    + "cultural activities and other events.";

        } else {

            content = "The college is organizing a campus placement drive. "
                    + "Eligible students can register and participate in the "
                    + "selection process conducted by the visiting companies.";
        }

        articleContent.setText(content);

        backButton.setOnClickListener(v -> finish());

        showNotification(title);
    }

    private void showNotification(String title) {

        String channelId = "campus_news_channel";

        NotificationManager manager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Campus News",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, channelId)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("CampusNews")
                        .setContentText(title)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

        manager.notify(1, builder.build());
    }
}
