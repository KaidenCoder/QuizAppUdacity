package com.example.android.quizapp;
/**
 * This project is done by Khaidem Sandip Singha under the Udacity Android Foundations Nanodegree program.
 *
 * I confirm that this submission is my own work. I have not used code from any other Udacity student's or graduate's submission of the same project.
 * I understand that Udacity will check my submission for plagiarism, and that failure to adhere to the Udacity Honor Code may result in the cancellation of my
 * enrollment.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //initialising the variable data-type
    int score_answer1;
    int score_answer2;
    int score_answer3;
    int score_answer4;
    int score_answer5;
    int score_answer6;
    int total_score;

    /**
     * This method is called when the Restart Quiz button is clicked. It restarts the quiz.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_restart = findViewById(R.id.restart);
        button_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restartIntent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(restartIntent);
            }
        });
    }

    /**
     * This method is called when the Submit button is clicked. It displays the answers and the total score.
     */
    public void submit(View view){
        //A CharSequence is a readable sequence of char values
        CharSequence resultsDisplay;

        //Question1 answer checking
        Boolean answer1;
        RadioButton choice4_question1 = this.findViewById(R.id.choice4_question1);
        answer1 = choice4_question1.isChecked();
        if (answer1) {
            score_answer1 = 1;
        } else {
            score_answer1 = 0;
        }

        //Question2 answer checking
        Boolean answer2;
        RadioButton choice4_question2 = this.findViewById(R.id.choice4_question2);
        answer2 = choice4_question2.isChecked();
        if (answer2) {
            score_answer2 = 1;
        } else {
            score_answer2 = 0;
        }

        //Question3 answer checking
        Boolean answer3;
        RadioButton choice1_question3 = this.findViewById(R.id.choice1_question3);
        answer3 = choice1_question3.isChecked();
        if (answer3) {
            score_answer3 = 1;
        } else {
            score_answer3 = 0;
        }

        //Question4 answer checking
        Boolean answer4;
        RadioButton choice1_question4 = this.findViewById(R.id.choice1_question4);
        answer4 = choice1_question4.isChecked();
        if (answer4) {
            score_answer4 = 1;
        } else {
            score_answer4 = 0;
        }

        //Question 5 answer checking.
        Boolean answer5_one;
        Boolean answer5_two;
        Boolean answer5_three;
        Boolean answer5_four;
        CheckBox choice1_question5 = this.findViewById(R.id.choice1_question5);
        CheckBox choice2_question5 = this.findViewById(R.id.choice2_question5);
        CheckBox choice3_question5 = this.findViewById(R.id.choice3_question5);
        CheckBox choice4_question5 = this.findViewById(R.id.choice4_question5);
        answer5_one = choice1_question5.isChecked();
        answer5_two = choice2_question5.isChecked();
        answer5_three = choice3_question5.isChecked();
        answer5_four = choice4_question5.isChecked();
        if (answer5_one && answer5_two && !answer5_three && !answer5_four) {
            score_answer5 = 1;
        } else {
            score_answer5 = 0;
        }

        //Question 6 answer checking.
        String answer6;
        EditText question6_answer = (EditText) this.findViewById(R.id.antonym_answer);
        answer6 = question6_answer.getText().toString().toUpperCase();
        if(answer6.equals("NATURAL")){
            score_answer6 = 1;
        }else{
            score_answer6 = 0;
        }

        //displays the total score of all the five questions
        total_score = score_answer1 + score_answer2 + score_answer3 + score_answer4 + score_answer5 + score_answer6;

        if(total_score == 6){
            resultsDisplay = " Perfect Score!";
        }else{
           resultsDisplay = "Good Try! Try again for perfect score. You scored "+ total_score+" out of 6";
        }

        //Allows users to put their own name
        EditText nameField =  findViewById(R.id.name);
        String name = nameField.getText().toString();

        Context text = getApplicationContext();
        int  duration = Toast.LENGTH_LONG;
        Toast message =Toast.makeText(text, resultsDisplay, duration);
        //displays the resultsDisplay on the screen just like a pop up.
        message.show();

         String answers = "Name: "+name+ "\nYou scored " +total_score+" out of 6.\n";
         answers += "\n"+getString(R.string.answer1)+"\n\n"+getString(R.string.answer2)+"\n";
         answers += "\n"+getString(R.string.answer3)+"\n\n"+getString(R.string.answer4)+"\n";
         answers += "\n"+getString(R.string.answer5);
         answers += "\n\n"+getString(R.string.answer6);
        //displayMessage displays all the answer.
         displayMessage(answers);

    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView answerSummaryTextView = findViewById(R.id.answers);
        answerSummaryTextView.setText(message);
   }
}
