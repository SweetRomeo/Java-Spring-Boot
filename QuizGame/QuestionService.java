package org.example;

import java.nio.channels.SelectableChannel;
import java.util.*;

public class QuestionService {
    Question[] questions = new Question[5];
    String[] selection = new String[5];

    public QuestionService() {
        questions[0] = new Question(1, "size of boolean", "1", "2", "3", "4", "1");
        questions[1] = new Question(2, "size of double", "2", "4","6","8","8");
        questions[2] = new Question(3, "size of float", "3", "4","6","8","4");
        questions[3] = new Question(4, "size of int", "5", "4","6","8","4");
        questions[4] = new Question(5, "size of long", "6", "4","6","8","8");

    }

    public void playQuiz()
    {
        for (int i = 0; i < questions.length; ++i) {
            System.out.println("Question Number : " + questions[i].getId());
            System.out.println(questions[i].getQuestion());
            System.out.println("A-) " + questions[i].getOption1());
            System.out.println("B-) " + questions[i].getOption2());
            System.out.println("C-) " + questions[i].getOption3());
            System.out.println("D-) " + questions[i].getOption4());
            Scanner kb = new Scanner(System.in);
            selection[i] = kb.nextLine();
        }

        for (String s : selection) {
            System.out.println(s);
        }
    }
    public void printScore()
    {
        int score = 0;

        for (int i = 0; i < questions.length; ++i) {
            Question question = questions[i];
            String actualAnswer = question.getAnswer();
            String userAnswer = selection[i];

            if (actualAnswer.equals(userAnswer)) {
                score++;
            }
        }
        System.out.println("Your score is : " + score);
    }
}
