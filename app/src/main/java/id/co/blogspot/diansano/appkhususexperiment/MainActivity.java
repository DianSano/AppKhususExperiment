package id.co.blogspot.diansano.appkhususexperiment;

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

    private Button buttonConfirmNext;

    private ArrayList<Question> questionList;

    private boolean answered;

    private int score;

    private int questionCounter;
    private int questionCountTotal;
    private Question currentQuestion;


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
        buttonConfirmNext = findViewById(R.id.button_confirm_next);

        showNextQuestion();

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                      //  checkAnswer();
                        switch (rbGroup.getCheckedRadioButtonId()) {
                            case R.id.radio_button1:
                                //   rb1.setTextColor(Color.GREEN);
                                tvSkor.setText("" + 0);
                                textViewQuestion.setText("Anda pilih jawaban A");
                                break;
                            case R.id.radio_button2:
                                tvSkor.setText("" + 1);
                                //     rb2.setTextColor(Color.GREEN);
                                textViewQuestion.setText("Anda pilih jawaban B");
                                break;
                            case R.id.radio_button3:
                                tvSkor.setText("" + 2);
                                //   rb3.setTextColor(Color.GREEN);
                                textViewQuestion.setText("Anda pilih Jawaban C");
                                break;
                            case R.id.radio_button4:
                                tvSkor.setText("" + 3);
                                //   rb3.setTextColor(Color.GREEN);
                                textViewQuestion.setText("Anda pilih jawaban D");
                                break;
                        } showNextQuestion();
                        } else {
                        Toast.makeText(MainActivity.this, "Please select an answer",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {

        rbGroup.clearCheck();

        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);

            textViewQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());


            questionCounter++;

            answered = false;
            buttonConfirmNext.setText("Confirm");


        } else {
            finishQuiz();
            // pindah ke intent ......
        }
    }

    private void finishQuiz() {
                finish();
    }

    private void checkAnswer() {
      //  answered = true;

      //  RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
     //   int answerNr = rbGroup.indexOfChild(rbSelected) + 1;

       // if (answered) {
        //if (answerNr == Integer.valueOf(currentQuestion.getAnswerNr())) {
            score++;
            //textViewScore.setText("Score: " + score);
     //   }
        showSolution();
    }

    private void showSolution() {

        switch (rbGroup.getCheckedRadioButtonId()) {
            case R.id.radio_button1:
             //   rb1.setTextColor(Color.GREEN);
                tvSkor.setText("" + 0);
                textViewQuestion.setText("Anda pilih jawaban A");
                break;
            case R.id.radio_button2:
                tvSkor.setText("" + 1);
           //     rb2.setTextColor(Color.GREEN);
                textViewQuestion.setText("Anda pilih jawaban B");
                break;
            case R.id.radio_button3:
                tvSkor.setText("" + 2);
             //   rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Anda pilih Jawaban C");
                break;
            case R.id.radio_button4:
                tvSkor.setText("" + 3);
                //   rb3.setTextColor(Color.GREEN);
                textViewQuestion.setText("Anda pilih jawaban D");
                break;
        }

        if (questionCounter < questionCountTotal) {
            buttonConfirmNext.setText("Next");
        } else {
            buttonConfirmNext.setText("Finish");
        }
    }

}
