package id.co.blogspot.diansano.appkhususexperiment;

import java.util.ArrayList;

public class DataArray {

    String[][] q = {{"Pertanyaan 1", "A", "B", "C", "D"},
                     {"Pertanyaan 2","A", "B", "C", "D"},
                    {"Pertanyaan 3","A", "B", "C", "D"},
                    };

    public ArrayList<Question> getQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        for (int i=0; i < q.length; i++) {


            Question question = new Question();
            question.setQuestion(q[i][0]);
            question.setOption1(q[i][1]);
            question.setOption2(q[i][2]);
            question.setOption3(q[i][3]);
            question.setOption4(q[i][4]);
            //question.setAnswerNr(q[i][5]);
            questionList.add(question);
        }
            return questionList;

    }
}
