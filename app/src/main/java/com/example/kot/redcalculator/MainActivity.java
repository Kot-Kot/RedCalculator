package com.example.kot.redcalculator;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String myTemporaryText="";
    TextView myTextView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.about:
                Intent myIntent = new Intent(this, AboutActivity.class);
                startActivity(myIntent);

                return true;
            case R.id.exit:
                finish();
                android.os.Process.killProcess(android.os.Process.myPid());

                //finish();
                //System.exit(0);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = (TextView) findViewById(R.id.textViewMain);


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

        myButtonClear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                TextView myTextView = (TextView) findViewById(R.id.textViewMain);
                myTextView.setText("");
                return true;
            }
        });



    }



    @Override
    public void onClick(View v){
        //String myTemporaryText;
        TextView myTextView = (TextView) findViewById(R.id.textViewMain);
        TextView myTV1 = (TextView) findViewById(R.id.textView1);
        TextView myTV2 = (TextView) findViewById(R.id.textView2);

        switch (v.getId()){

            case R.id.btnClear:
                String myTemporaryString1 = "";
                for (int i=0;i<myTextView.length()-1;i++){
                    myTemporaryString1 = myTemporaryString1+myTextView.getText().charAt(i);
                }

                myTextView.setText(myTemporaryString1);

                break;



            case R.id.btnEqual:
                TextView myTextViewAdditional = (TextView) findViewById(R.id.textViewAdditional);
                int ii=0;
                //double[] myNumbers={};



               // boolean myFlagForNumber2 = false;


                String myTemporaryString = "";
                myTextView.setText(myTextView.getText()+"=");
                myTextViewAdditional.setText(myTextView.getText());

                for (int i=0; i < myTextView.length();i++) {
                   // Log.d("MYLOG", "ITERATION NUMBER " + i);
                    if (myTextView.getText().toString().charAt(i) == '+' |
                            myTextView.getText().toString().charAt(i) == '-' |
                            myTextView.getText().toString().charAt(i) == 'x' |
                            myTextView.getText().toString().charAt(i) == '÷' ){

                            ii++;

                    }

                }


                //Log.d("MYLOG", "ii NUMBER " + ii);

                Double[] myNumbers = new Double[ii+1];
                char[] mySigns = new char[ii+1];

                if (myTextView.getText().toString().charAt(0) == '-'){

                    mySigns[0]='-';
                }else {

                    mySigns[0]='+';
                }

                Log.d("MYLOG", " NUMBER ONE   " + ii);

                int iii=0;
                for (int i=0; i < myTextView.length();i++) {
                    if ((myTextView.getText().charAt(i) >= '0' &
                            myTextView.getText().charAt(i) <= '9') |
                            myTextView.getText().charAt(i) == '.' ) {

                        myTemporaryString = myTemporaryString + myTextView.getText().charAt(i);
                        //Log.d("MYLOG","NUMBER iii = " + iii+ " |   myTemporaryString  " + myTemporaryString);
                    } else {
                        myNumbers[iii] = Double.valueOf(myTemporaryString);
                        //Log.d("MYLOG", "iii DOUBLE NUMBER " + String.valueOf(myNumbers[iii]));
                        iii++;

                       // Log.d("MYLOG", iii + "   SIGN is   " + myTextView.getText().charAt(i));

                        if(myTextView.getText().charAt(i) == '+' |
                                myTextView.getText().charAt(i) == '-' |
                                myTextView.getText().charAt(i) == 'x' |
                                myTextView.getText().charAt(i) == '÷'){

                            mySigns[iii]=myTextView.getText().charAt(i);
                            Log.d("MYLOG", iii + "  SIGNS  IS " + mySigns[iii]);
                        }


                        myTemporaryString = "";

                    }
                }

                Double myTemporaryNumber = 0.0;
                for (int i=0; i<mySigns.length;i++){
                    if (mySigns[i]=='x') {
                        myTemporaryNumber = myNumbers[i-1]*myNumbers[i];
                        if (mySigns[i-1]=='-'){
                            myTemporaryNumber = -myTemporaryNumber;



                    }
                    }



                }






                break;

            case R.id.btnDot:

                char mySingDot = '.';
                myCheckingFotRepetitiveSigns(mySingDot);
                //int myTextLength = myTextView.length();
                //Log.d("MYLOG", "LENGTH " + myTextLength);
               // Log.d("MYLOG", "LAST SIGN " + myTextView.getText().charAt(myTextLength-1));
               /* if (myTextView.getText().toString()=="" |
                        myTextView.getText().charAt(myTextView.length()-1)=='.' |
                        myTextView.getText().charAt(myTextView.length()-1)=='+' |
                        myTextView.getText().charAt(myTextView.length()-1)=='-' |
                        myTextView.getText().charAt(myTextView.length()-1)=='x' |
                        myTextView.getText().charAt(myTextView.length()-1)=='÷'){

                    break;


                }else{



                myTemporaryText = myTextView.getText().toString()+".";

                myTextView.setText(myTemporaryText);

                }*/
                break;


            case R.id.btnPlus:
                char mySignP = '+';
                myCheckingFotRepetitiveSigns(mySignP);

               // myTemporaryText = myEditText.getText().toString()+"+";

               // myEditText.setText(myTemporaryText);

               // myEditText.setSelection(myEditText.getText().length());
                break;

            case R.id.btnMinus:
                char mySignM = '-';
                myCheckingFotRepetitiveSigns(mySignM);
                //myTemporaryText = myEditText.getText().toString()+"-";
                //myEditText.setText(myTemporaryText);
                //myEditText.setSelection(myEditText.getText().length());
                break;

            case R.id.btnMultiply:
                char mySignMultiply = 'x';
                myCheckingFotRepetitiveSigns(mySignMultiply);
               // myTemporaryText = myTextView.getText().toString()+"x";
               // myTextView.setText(myTemporaryText);

                break;
            // code ALT + 0247
            case R.id.btnDivision:
                char mySignD = '÷';
                myCheckingFotRepetitiveSigns(mySignD);
                //myTemporaryText = myTextView.getText().toString()+"÷";
             //  myTextView.setText(myTemporaryText);

                break;


            case R.id.btn0:

                myTemporaryText = myTextView.getText().toString()+"0";
                myTextView.setText(myTemporaryText);

                break;

            case R.id.btn1:


                myTemporaryText = myTextView.getText().toString()+"1";
                myTextView.setText(myTemporaryText);

                break;
            case R.id.btn2:
                myTemporaryText = myTextView.getText().toString()+"2";
                myTextView.setText(myTemporaryText);

                break;
            case R.id.btn3:
                myTemporaryText = myTextView.getText().toString()+"3";
                myTextView.setText(myTemporaryText);

                break;
            case R.id.btn4:
                myTemporaryText = myTextView.getText().toString()+"4";
                myTextView.setText(myTemporaryText);

                break;
            case R.id.btn5:
                myTemporaryText = myTextView.getText().toString()+"5";
                myTextView.setText(myTemporaryText);

                break;
            case R.id.btn6:
                myTemporaryText = myTextView.getText().toString()+"6";
                myTextView.setText(myTemporaryText);

                break;
            case R.id.btn7:
                myTemporaryText = myTextView.getText().toString()+"7";
                myTextView.setText(myTemporaryText);

                break;
            case R.id.btn8:
                myTemporaryText = myTextView.getText().toString()+"8";
                myTextView.setText(myTemporaryText);

                break;
            case R.id.btn9:
                myTemporaryText = myTextView.getText().toString()+"9";
                myTextView.setText(myTemporaryText);

                break;

        }




    }

    public void myCheckingFotRepetitiveSigns(char Sign){
        TextView myTextView = (TextView) findViewById(R.id.textViewMain);
        int myTextLength = myTextView.length();
        //Log.d("MYLOG", "LENGTH " + myTextLength);
       // Log.d("MYLOG", "LAST SIGN " + myTextView.getText().charAt(myTextLength-1));

        if (myTextLength == 0 & Sign == '-'){

            myTemporaryText = myTextView.getText().toString()+Character.toString(Sign);
            myTextView.setText(myTemporaryText);

           // Log.d("MYLOG", "CHECKING RIGHT " );

        }else if (
                myTextView.getText().charAt(myTextView.length()-1)=='.' |
                myTextView.getText().charAt(myTextView.length()-1)=='+' |
                myTextView.getText().charAt(myTextView.length()-1)=='-' |
                myTextView.getText().charAt(myTextView.length()-1)=='x' |
                myTextView.getText().charAt(myTextView.length()-1)=='÷'){
           // Log.d("MYLOG", "CHECKING WRONG " );

        }else{

            myTemporaryText = myTextView.getText().toString()+Character.toString(Sign);

            myTextView.setText(myTemporaryText);

        }

    }



}
