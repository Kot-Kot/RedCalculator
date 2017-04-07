package com.example.kot.redcalculator;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CancellationSignal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String myTemporaryText;
    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText myEditText = (EditText) findViewById(R.id.editTextMain);
        myEditText.setCursorVisible(true);


        Button myButton1 = (Button) findViewById(R.id.btn1);
        Button myButton0 = (Button) findViewById(R.id.btn0);
        Button myButton2 = (Button) findViewById(R.id.btn2);
        Button myButton3 = (Button) findViewById(R.id.btn3);
        Button myButton4 = (Button) findViewById(R.id.btn4);
        Button myButton5 = (Button) findViewById(R.id.btn5);
        Button myButton6 = (Button) findViewById(R.id.btn6);
        Button myButton7 = (Button) findViewById(R.id.btn7);
        Button myButton8 = (Button) findViewById(R.id.btn8);
        Button myButton9 = (Button) findViewById(R.id.btn9);

        Button myButtonDot = (Button) findViewById(R.id.btnDot);

        Button myButtonDivision = (Button) findViewById(R.id.btnDivision);
        Button myButtonPlus = (Button) findViewById(R.id.btnPlus);
        Button myButtonMinus = (Button) findViewById(R.id.btnMinus);
        Button myButtonMultiply = (Button) findViewById(R.id.btnMultiply);

        Button myButtonEqual = (Button) findViewById(R.id.btnEqual);

        Button myButtonClear = (Button) findViewById(R.id.btnClear);

        myButton0.setWidth(myButton1.getWidth());
        myButtonClear.setWidth(myButtonPlus.getWidth());

        myButton0.setOnClickListener((View.OnClickListener) this);
        myButton1.setOnClickListener((View.OnClickListener) this);
        myButton2.setOnClickListener((View.OnClickListener) this);
        myButton3.setOnClickListener((View.OnClickListener) this);
        myButton4.setOnClickListener((View.OnClickListener) this);
        myButton5.setOnClickListener((View.OnClickListener) this);
        myButton6.setOnClickListener((View.OnClickListener) this);
        myButton7.setOnClickListener((View.OnClickListener) this);
        myButton8.setOnClickListener((View.OnClickListener) this);
        myButton9.setOnClickListener((View.OnClickListener) this);

        myButtonDot.setOnClickListener((View.OnClickListener) this);
        myButtonDivision.setOnClickListener((View.OnClickListener) this);
        myButtonPlus.setOnClickListener((View.OnClickListener) this);
        myButtonMinus.setOnClickListener((View.OnClickListener) this);
        myButtonMultiply.setOnClickListener((View.OnClickListener) this);
        myButtonEqual.setOnClickListener((View.OnClickListener) this);
        myButtonClear.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View v){
        //String myTemporaryText;
        EditText myEditText = (EditText) findViewById(R.id.editTextMain);
        TextView myTV1 = (TextView) findViewById(R.id.textView1);
        TextView myTV2 = (TextView) findViewById(R.id.textView2);

        switch (v.getId()){

            case R.id.btnClear:
                finish();
                break;



            case R.id.btnEqual:
                int myNumber1=0;
                int myNumber2=0;
                boolean myFlagForNumber1 = false;
               // boolean myFlagForNumber2 = false;
                char myCurrentSign = ' ';
                //char myNextSign;
                String myTemporaryString = "";
                myEditText.setText(myEditText.getText()+" ");

                for (int i=0; i < myEditText.length();i++){

                    if (    myEditText.getText().toString().charAt(i) != '+' &
                            myEditText.getText().toString().charAt(i) != '-' &
                            myEditText.getText().toString().charAt(i) != 'x' &
                            myEditText.getText().toString().charAt(i) != '÷' &
                            myEditText.getText().toString().charAt(i) != ' '){

                        myTemporaryString = myTemporaryString + myEditText.getText().toString().charAt(i);


                    }else if (myFlagForNumber1 == false) {
                        myFlagForNumber1 = true;
                        myCurrentSign = myEditText.getText().charAt(i);
                        myNumber1 = Integer.parseInt(myTemporaryString);

                        myTV1.setText(myTV1.getText() + " " + Integer.toString(myNumber1));

                        myTemporaryString="";




                    }else if(myFlagForNumber1 == true){
                        //myFlagForNumber2 = true;
                        myNumber2 = Integer.parseInt(myTemporaryString);

                        myTV2.setText(myTV2.getText() + " " + Integer.toString(myNumber2));

                        myTemporaryString="";

                        if(myCurrentSign == '+'){
                            myNumber1 = myNumber1 + myNumber2;
                        }else if(myCurrentSign == '-'){
                            myNumber1 = myNumber1 - myNumber2;
                        }else if(myCurrentSign == 'x'){
                            myNumber1 = myNumber1 * myNumber2;
                        }else if(myCurrentSign == '÷'){
                            myNumber1 = myNumber1 / myNumber2;
                        }
                        myCurrentSign = myEditText.getText().charAt(i);
                    }


                }

                myEditText.setText(Integer.toString(myNumber1));


                break;

            case R.id.btnDot:

                myTemporaryText = myEditText.getText().toString()+".";

                myEditText.setText(myTemporaryText);

                myEditText.setSelection(myEditText.getText().length());
                break;


            case R.id.btnPlus:

                myTemporaryText = myEditText.getText().toString()+"+";

                myEditText.setText(myTemporaryText);

                myEditText.setSelection(myEditText.getText().length());
                break;

            case R.id.btnMinus:
                myTemporaryText = myEditText.getText().toString()+"-";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;

            case R.id.btnMultiply:
                myTemporaryText = myEditText.getText().toString()+"x";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;
            // code ALT + 0247
            case R.id.btnDivision:
                myTemporaryText = myEditText.getText().toString()+"÷";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;


            case R.id.btn0:
                myEditText.setSelection(myEditText.getText().length());
                myTemporaryText = myEditText.getText().toString()+"0";
                myEditText.setText(myTemporaryText);
                //myEditText.setSelection(myEditText.getText().length());
                break;

            case R.id.btn1:


                myTemporaryText = myEditText.getText().toString()+"1";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;
            case R.id.btn2:
                myTemporaryText = myEditText.getText().toString()+"2";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;
            case R.id.btn3:
                myTemporaryText = myEditText.getText().toString()+"3";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;
            case R.id.btn4:
                myTemporaryText = myEditText.getText().toString()+"4";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;
            case R.id.btn5:
                myTemporaryText = myEditText.getText().toString()+"5";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;
            case R.id.btn6:
                myTemporaryText = myEditText.getText().toString()+"6";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;
            case R.id.btn7:
                myTemporaryText = myEditText.getText().toString()+"7";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;
            case R.id.btn8:
                myTemporaryText = myEditText.getText().toString()+"8";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;
            case R.id.btn9:
                myTemporaryText = myEditText.getText().toString()+"9";
                myEditText.setText(myTemporaryText);
                myEditText.setSelection(myEditText.getText().length());
                break;

        }




    }

}
