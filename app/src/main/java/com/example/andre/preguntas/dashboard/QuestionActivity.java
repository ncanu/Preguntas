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

        RadioButton radioButton;

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

        switch (index)
        {


            case 1:
                //Pregunta 1
                question1 = new Question();
                answers1= new ArrayList<>();
                answer1 = new Answer();
                answer2 = new Answer();
                answer3 = new Answer();


                answer1.setId(1L);
                answer1.setAnswerDescription("British Home Championship");

                answer2.setId(2L);
                answer2.setAnswerDescription("FA Cup");

                answer3.setId(3L);
                answer3.setAnswerDescription("Copa América");


                question1.setQuestion("¿Cuál es el torneo entre selecciones nacionales más antiguo de la historia del fútbol?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);

                question1.setAnswers(answers1);
                question1.setAnswerText("Copa América");
                question1.setAnswerIndex(1);
                activeQuestion = question1;



                return question1;


            case 2:
                //Pregunta 2
                question1 = new Question();
                answers1= new ArrayList<>();
                answer1 = new Answer();
                answer2 = new Answer();
                answer3 = new Answer();



                answer1.setId(2L);
                answer1.setAnswerDescription("Club Atlético Independiente");

                answer2.setId(2L);
                answer2.setAnswerDescription("Boca Juniors");

                answer3.setId(3L);
                answer3.setAnswerDescription("Peñarol");

                question1.setQuestion("¿Cuál ha sido el equipo que más Copas Libertadores de América ha ganado en la historia?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);

                question1.setAnswerText("Club Atlético Independiente");
                question1.setAnswers(answers1);
                question1.setAnswerIndex(2);
                activeQuestion = question1;



                return question1;

            case 3:
                //Pregunta 2

                question1 = new Question();
                answers1= new ArrayList<>();
                answer1 = new Answer();
                answer2 = new Answer();
                answer3 = new Answer();



                answer1.setId(3L);
                answer1.setAnswerDescription("Brasil 2014");

                answer2.setId(2L);
                answer2.setAnswerDescription("Uruguay 1930");

                answer3.setId(3L);
                answer3.setAnswerDescription("Brasil 1950");

                question1.setQuestion("¿A qué Mundial corresponde el famoso hecho del \"Maracanazo\"?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);

                question1.setAnswerText("Brasil 1950");
                question1.setAnswers(answers1);
                question1.setAnswerIndex(2);
                activeQuestion = question1;

                return question1;


            case 4:
                //Pregunta 2

                question1 = new Question();
                answers1= new ArrayList<>();
                answer1 = new Answer();
                answer2 = new Answer();
                answer3 = new Answer();



                answer1.setId(4L);
                answer1.setAnswerDescription("Azteca");

                answer2.setId(2L);
                answer2.setAnswerDescription("Telstar");

                answer3.setId(3L);
                answer3.setAnswerDescription("Tango");

                question1.setQuestion("¿Cuál fue el nombre del balón oficial con el que se jugó México 70?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);

                question1.setAnswerText("Telstar");
                question1.setAnswers(answers1);
                question1.setAnswerIndex(2);
                activeQuestion = question1;

                return question1;


            case 5:
                //Pregunta 2

                question1 = new Question();
                answers1= new ArrayList<>();
                answer1 = new Answer();
                answer2 = new Answer();
                answer3 = new Answer();



                answer1.setId(2L);
                answer1.setAnswerDescription("Inglaterra 1966");

                answer2.setId(2L);
                answer2.setAnswerDescription("México 1970");

                answer3.setId(3L);
                answer3.setAnswerDescription("España 1982");

                question1.setQuestion("¿En qué Mundial de Fútbol fueron incorporadas las tarjetas para sancionar a los jugadores?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);

                question1.setAnswerText("México 1970");
                question1.setAnswers(answers1);
                question1.setAnswerIndex(2);
                activeQuestion = question1;

                return question1;

            case 6:
                //Pregunta 2
                question1 = new Question();
                answers1= new ArrayList<>();
                answer1 = new Answer();
                answer2 = new Answer();
                answer3 = new Answer();



                answer1.setId(2L);
                answer1.setAnswerDescription("Lionel Messi");

                answer2.setId(2L);
                answer2.setAnswerDescription("Zlatan Ibrahimovic");

                answer3.setId(3L);
                answer3.setAnswerDescription("Cristiano Ronaldo");

                question1.setQuestion("¿Quién ha sido el máximo goleador de la Liga de Campeones o Copa de Campeones de Europa desde su inicio en 1955?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);

                question1.setAnswerText("Cristiano Ronaldo");
                question1.setAnswers(answers1);
                question1.setAnswerIndex(2);
                activeQuestion = question1;

                return question1;

            case 7:
                //Pregunta 2
                question1 = new Question();
                answers1= new ArrayList<>();
                answer1 = new Answer();
                answer2 = new Answer();
                answer3 = new Answer();



                answer1.setId(2L);
                answer1.setAnswerDescription("Ocho");

                answer2.setId(2L);
                answer2.setAnswerDescription("Siete");

                answer3.setId(3L);
                answer3.setAnswerDescription("Nueve");

                question1.setQuestion("¿Cuántos jugadores por equipo debe haber mínimo en la cancha para que empiece el partido?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);

                question1.setAnswerText("Siete");
                question1.setAnswers(answers1);
                question1.setAnswerIndex(2);
                activeQuestion = question1;

                return question1;


            case 8:
                //Pregunta 2

                question1 = new Question();
                answers1= new ArrayList<>();
                answer1 = new Answer();
                answer2 = new Answer();
                answer3 = new Answer();


                answer1.setId(2L);
                answer1.setAnswerDescription("Una cada uno");

                answer2.setId(2L);
                answer2.setAnswerDescription("Ninguna");


                question1.setQuestion("¿Cuántas veces Pelé y Maradona ganaron la Copa América?");
                answers1.add(answer1);
                answers1.add(answer2);

                question1.setAnswerText("Ninguna");
                question1.setAnswers(answers1);
                question1.setAnswerIndex(2);
                activeQuestion = question1;

                return question1;

            case 9:
                //Pregunta 2

                question1 = new Question();
                answers1= new ArrayList<>();
                answer1 = new Answer();
                answer2 = new Answer();
                answer3 = new Answer();


                answer1.setId(2L);
                answer1.setAnswerDescription("38");

                answer2.setId(2L);
                answer2.setAnswerDescription("64");

                answer3.setId(3L);
                answer3.setAnswerDescription("52");

                question1.setQuestion("¿Cuántos partidos se disputaron en el pasado Mundial de Brasil 2014?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);

                question1.setAnswerText("64");
                question1.setAnswers(answers1);
                question1.setAnswerIndex(2);
                activeQuestion = question1;

                return question1;


            case 10:
                //Pregunta 2

                question1 = new Question();
                answers1= new ArrayList<>();
                answer1 = new Answer();
                answer2 = new Answer();
                answer3 = new Answer();


                answer1.setId(2L);
                answer1.setAnswerDescription("Uruguay");

                answer2.setId(2L);
                answer2.setAnswerDescription("Brasil");

                answer3.setId(3L);
                answer3.setAnswerDescription("Chile");

                question1.setQuestion("¿Cuál equipo fue el campeón de la primera Copa América en 1916?");
                answers1.add(answer1);
                answers1.add(answer2);
                answers1.add(answer3);

                question1.setAnswerText("Uruguay");
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
