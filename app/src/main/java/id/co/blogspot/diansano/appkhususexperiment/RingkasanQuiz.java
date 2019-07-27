package id.co.blogspot.diansano.appkhususexperiment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RingkasanQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringkasan_quiz);

        TextView ringkasanQuiz = findViewById(R.id.tv_ringkasan_quiz);
        ringkasanQuiz.setText(getIntent().getStringExtra("ringkasanQuiz"));
    }

}
