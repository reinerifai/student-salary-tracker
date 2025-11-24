package com.example.moodtracker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Spinner moodSpinner;
    EditText noteInput;
    TextView resultBox;
    Button trackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodSpinner = findViewById(R.id.moodSpinner);
        noteInput = findViewById(R.id.noteInput);
        resultBox = findViewById(R.id.resultBox);
        trackBtn = findViewById(R.id.trackBtn);

        // Mood options
        String[] moods = {"Select Mood", "😊 Happy", "😢 Sad", "😣 Stressed", "😴 Tired", "😡 Angry", "🤩 Excited", "😌 Calm"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, moods);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moodSpinner.setAdapter(adapter);

        trackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage();
            }
        });
    }

    private void showMessage() {
        String mood = moodSpinner.getSelectedItem().toString();
        String note = noteInput.getText().toString().trim();

        if (mood.equals("Select Mood")) {
            resultBox.setText("Please choose your mood.");
            resultBox.setVisibility(View.VISIBLE);
            return;
        }

        // Motivational messages
        String message = "";
        switch (mood) {
            case "😊 Happy":
                message = "Keep shining! Your positive energy is powerful 🌟";
                break;
            case "😢 Sad":
                message = "It's okay to feel sad. Better days are coming 💙";
                break;
            case "😣 Stressed":
                message = "Breathe. You are stronger than you think 💪";
                break;
            case "😴 Tired":
                message = "Rest is important. Take it slow 😌";
                break;
            case "😡 Angry":
                message = "Stay calm. You control your power 🔥";
                break;
            case "🤩 Excited":
                message = "Your excitement is contagious! Keep going 🚀";
                break;
            case "😌 Calm":
                message = "Peace is beautiful. Enjoy the moment 🌙";
                break;
        }

        String finalText = "Your Mood: " + mood + "\n\n" + message;

        if (!note.isEmpty()) {
            finalText += "\n\nYour Note: " + note;
        }

        resultBox.setText(finalText);
        resultBox.setVisibility(View.VISIBLE);
    }
}
