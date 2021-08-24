package com.example.interact_with_other_apps_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
// Event is on January 23, 2021 -- from 7:30 AM to 10:30 AM.
            Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
            Calendar beginTime = Calendar.getInstance();
            beginTime.set(2021, 0, 23, 7, 30);
            Calendar endTime = Calendar.getInstance();
            endTime.set(2021, 0, 23, 10, 30);
            calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
            calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
            calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
            calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");

            startActivity(calendarIntent);

        });
    }
}