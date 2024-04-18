package com.example.mathquiz;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView questionTextView;
    Button example1Button;
    Button example2Button;
    Button example3Button;
    Button example4Button;

    String TAG = "MainActivity";

    HashMap[] problems = {
            new HashMap() {
                {
                    put("question", "1 + 2 = ?");
                    put("answer", "3");
                    put("example1", "1");
                    put("example2", "3");
                    put("example3", "2");
                    put("example4", "4");
                }
            },
            new HashMap() {
                {
                    put("question", "3 + 2 = ?");
                    put("answer", "5");
                    put("example1", "4");
                    put("example2", "6");
                    put("example3", "5");
                    put("example4", "2");
                }
            },
            new HashMap() {
                {
                    put("question", "3 + 3 = ?");
                    put("answer", "6");
                    put("example1", "6");
                    put("example2", "1");
                    put("example3", "5");
                    put("example4", "4");
                }
            },
            new HashMap() {
                {
                    put("question", "0 + 3 = ?");
                    put("answer", "3");
                    put("example1", "1");
                    put("example2", "2");
                    put("example3", "4");
                    put("example4", "3");
                }
            },
            new HashMap() {
                {
                    put("question", "4 + 2 = ?");
                    put("answer", "6");
                    put("example1", "6");
                    put("example2", "4");
                    put("example3", "2");
                    put("example4", "5");
                }
            },
            new HashMap() {
                {
                    put("question", "5 + 4 = ?");
                    put("answer", "9");
                    put("example1", "8");
                    put("example2", "6");
                    put("example3", "7");
                    put("example4", "9");
                }
            },
            new HashMap() {
                {
                    put("question", "4 + 4 = ?");
                    put("answer", "8");
                    put("example1", "7");
                    put("example2", "1");
                    put("example3", "8");
                    put("example4", "3");
                }
            },
            new HashMap() {
                {
                    put("question", "2 + 5 = ?");
                    put("answer", "7");
                    put("example1", "7");
                    put("example2", "1");
                    put("example3", "5");
                    put("example4", "4");
                }
            },
            new HashMap() {
                {
                    put("question", "1 + 4 = ?");
                    put("answer", "5");
                    put("example1", "4");
                    put("example2", "5");
                    put("example3", "0");
                    put("example4", "6");
                }
            },
            new HashMap() {
                {
                    put("question", "3 + 1 = ?");
                    put("answer", "4");
                    put("example1", "8");
                    put("example2", "3");
                    put("example3", "4");
                    put("example4", "0");
                }
            }
    };

    int problemNumber = 1;
    String question = "";
    String answer = "";
    String example1 = "";
    String example2 = "";
    String example3 = "";
    String example4 = "";
    int totalCorrect = 0;
    TextView totalCorrectTextView;
    TextView correctIncorrectTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        example1Button = findViewById(R.id.example1Button);
        example2Button = findViewById(R.id.example2Button);
        example3Button = findViewById(R.id.example3Button);
        example4Button = findViewById(R.id.example4Button);
        totalCorrectTextView = findViewById(R.id.totalCorrectTextView);
        correctIncorrectTextView = findViewById(R.id.correctIncorrectTextView);

        showProblem();
        totalCorrectTextView.setText("Total Correct: " + totalCorrect);
        correctIncorrectTextView.setText("Correct/Incorrect");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void showProblem() {

        question = (String)problems[problemNumber - 1].get("question");
        answer = (String)problems[problemNumber - 1].get("answer");
        example1 = (String)problems[problemNumber - 1].get("example1");
        example2 = (String)problems[problemNumber - 1].get("example2");
        example3 = (String)problems[problemNumber - 1].get("example3");
        example4 = (String)problems[problemNumber - 1].get("example4");

        questionTextView.setText(question);
        example1Button.setText(example1);
        example2Button.setText(example2);
        example3Button.setText(example3);
        example4Button.setText(example4);
    }

    public void example1ButtonClicked(View v) {
        Log.d(TAG, "example1ButtonClicked");
        selectExample(example1);
    }

    void selectExample(String example) {
        Log.d(TAG, example);
        if (answer.equals(example)) {
            totalCorrect += 1;
            totalCorrectTextView.setText(Integer.toString(totalCorrect));

            correctIncorrectTextView.setText("Correct");
        } else {
            correctIncorrectTextView.setText("Incorrect");
        }

        totalCorrectTextView.setText("Total Correct: " + totalCorrect);

        example1Button.setEnabled(false);
        example2Button.setEnabled(false);
        example3Button.setEnabled(false);
        example4Button.setEnabled(false);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                example1Button.setEnabled(true);
                example2Button.setEnabled(true);
                example3Button.setEnabled(true);
                example4Button.setEnabled(true);

                if (problemNumber < problems.length) {
                    problemNumber += 1;
                    showProblem();
                } else {
                    Log.d(TAG, "showGameOverBox");
                    showGameOverBox();
                }
        }}, 1000);
    }

    void showGameOverBox() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Game Over")
                .setMessage("Play again?")
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exitApp();
                    }
                })
                .setPositiveButton("Try again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        replay();
                    }
                })
                .setCancelable(false)
                .create();
        alertDialog.show();
    }

    void exitApp() {
        finishAffinity();
    }

    void replay() {
        problemNumber = 1;
        totalCorrect = 0;
        showProblem();
        totalCorrectTextView.setText("Total Correct: " + totalCorrect);
        correctIncorrectTextView.setText("Correct/Incorrect");
    }
    public void example2ButtonClicked(View v) {
        Log.d(TAG, "example2ButtonClicked");
        selectExample(example2);
    }

    public void example3ButtonClicked(View v) {
        Log.d(TAG, "example3ButtonClicked");
        selectExample(example3);
    }

    public void example4ButtonClicked(View v) {
        Log.d(TAG, "example4ButtonClicked");
        selectExample(example4);
    }
}