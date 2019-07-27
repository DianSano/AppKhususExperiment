package id.co.blogspot.diansano.appkhususexperiment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textViewQuestion, tvSkor;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb5;

    private Button buttonConfirmNext;

    private ArrayList<Question> questionList;

    private boolean answered;

    //  private int score;

    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;

    private String ringkasanQuiz = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuestion = findViewById(R.id.textview_question);
        tvSkor = findViewById(R.id.tv_skor);

        DataArray dataArray = new DataArray();
        questionList = dataArray.getQuestions();
        questionCountTotal = questionList.size();

        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        rb5 = findViewById(R.id.radio_button5);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        showNextQuestion();

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()
                            || rb5.isChecked()) {
                        switch (rbGroup.getCheckedRadioButtonId()) {
                            case R.id.radio_button1:  //   rb1.setTextColor(Color.GREEN);
                                tvSkor.setText("Skor: " + 0);
                                ringkasanQuiz += "Anda pilih jawaban A skor: 0 \n";
                                break;
                            case R.id.radio_button2:
                                tvSkor.setText("Skor: " + 1);
                                ringkasanQuiz += "Anda pilih jawaban B skor: 1 \n";
                                break;
                            case R.id.radio_button3:
                                tvSkor.setText("Skor: " + 2);
                                ringkasanQuiz += "Anda pilih jawaban C skor: 2 \n";
                                break;
                            case R.id.radio_button4:
                                tvSkor.setText("Skor: " + 3);
                                ringkasanQuiz += "Anda pilih jawaban D skor: 3 \n";
                                break;
                            case R.id.radio_button5:
                                tvSkor.setText("Skor: " + 4);
                                ringkasanQuiz += "Anda pilih jawaban E skor: 4 \n";
                                break;
                        }

                        showNextQuestion();
                    } else {
                        Toast.makeText(MainActivity.this, "Pilih salah satu jawaban",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        //pertanyaan ke-2 dan ke-4 ada 5 radio button yang lain hanya 4
        if (questionCounter == 1 || questionCounter == 3) {
            rb5.setVisibility(View.VISIBLE);
        } else {
            rb5.setVisibility(View.INVISIBLE);
        }
        if (questionCounter < questionCountTotal) {
            rbGroup.clearCheck();
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            rb5.setText(currentQuestion.getOption5());

            ringkasanQuiz += "Pertanyaan ke: " + (questionCounter + 1) + " ";
            questionCounter++;

            answered = false;
            buttonConfirmNext.setText("Confirm");


        } else {
            // pindah ke intent ......
            finishQuiz();

        }
    }

    private void finishQuiz() {
        Intent intent = new Intent(this, RingkasanQuiz.class);
        intent.putExtra("ringkasanQuiz", ringkasanQuiz);
        startActivity(intent);
    }

}
