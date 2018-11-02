package com.example.andre.preguntas.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andre.preguntas.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends Activity {

    RadioGroup group;
    TextView textView;
    int questionNumber;
    Button button;
    private RadioButton radioButton;
    Question activeQuestion;

    int rightAnswers;
    int wrongAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        group = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        rightAnswers = 0;
        wrongAnswers = 0;
        questionNumber = 1;
        activeQuestion = new Question();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });



        fill(getQuestion(questionNumber));




    }

    public void nextQuestion()
    {
        int selectedId = group.getCheckedRadioButtonId();
        // find the radiobutton by returned id

        RadioButton radioButton = findViewById(selectedId);

        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);

//        Toast.makeText(QuestionActivity.this,
//                radioButton.getText(), Toast.LENGTH_SHORT).show();

        if(radioButton.getText()==activeQuestion.getAnswerText())
        {
            rightAnswers = rightAnswers +1;
        }
        else {wrongAnswers = wrongAnswers+1;}





        group.removeAllViews();
        questionNumber = questionNumber+1;
        Question question = getQuestion(questionNumber);

        if(question==null)
        {
            //TODO pantalla calificación
//            Toast.makeText(QuestionActivity.this, "Prueba Completa.",
//                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuestionActivity.this, GraphActivity.class);
            intent.putExtra("firstKeyName",rightAnswers);
            intent.putExtra("secondKeyName",wrongAnswers);
            startActivity(intent);

        }
        else
         {

            fill(question);

        }


    }


    public Question getQuestion(int index)
    {
        Question question1 = new Question();
        List<Answer> answers1= new ArrayList<>();
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        Answer answer3 = new Answer();
        Answer answer4 = new Answer();
        switch (index)
        {


            case 1:
                //Pregunta 1

                answer1.setId(1L);
                answer1.setAnswerDescription("Es un concepto similar al de 'array");

                answer2.setId(2L);
                answer2.setAnswerDescription("Es un tipo particular de variable");

                answer3.setId(3L);
                answer3.setAnswerDescription("Es un modelo o plantilla a partir de la cual creamos objetos");

                answer4.setId(4L);
                answer4.setAnswerDescription("Es una categoria de datos ordenada secuencialmente");

                question1.setQuestion("1- ¿Cuál es la descripción que crees que define mejor el concepto 'clase' en la programación orientada a objetos?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);
                answers1.add(answer4);
                question1.setAnswers(answers1);
                question1.setAnswerText("Es un concepto similar al de 'array");
                question1.setAnswerIndex(1);
                activeQuestion = question1;

                return question1;


            case 2:
                //Pregunta 2
                answer1.setId(2L);
                answer1.setAnswerDescription("Sus cardinalidad y su tipo");

                answer2.setId(2L);
                answer2.setAnswerDescription("Sus atributos y sus métodos");

                answer3.setId(3L);
                answer3.setAnswerDescription("La forma en que establece comunicación e intercambia mensajes ");

                answer4.setId(4L);
                answer4.setAnswerDescription("Su interfaz y los eventos asociados");

                question1.setQuestion("2- ¿Qué elementos crees que definen a un objeto?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);
                answers1.add(answer4);
                question1.setAnswerText("Sus cardinalidad y su tipo");
                question1.setAnswers(answers1);
                question1.setAnswerIndex(2);
                activeQuestion = question1;

                return question1;







            default:                return null;

        }
    }


    public void fill(Question question)
    {
        textView.setText(question.getQuestion());
        for(Answer x: question.getAnswers())
        {
            RadioButton rb_flash = new RadioButton(getApplicationContext());
            // Set a Text for new RadioButton
            rb_flash.setText(x.getAnswerDescription());

            // Set the text color of Radio Button
            rb_flash.setTextColor(Color.BLACK);

            // Finally, add the new RadioButton to the RadioGroup
            group.addView(rb_flash);
        }

    }




}
