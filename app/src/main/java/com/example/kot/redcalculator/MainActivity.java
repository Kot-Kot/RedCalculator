package com.example.kot.redcalculator;

import android.content.Intent;
//import android.inputmethodservice.Keyboard;
//import android.nfc.Tag;
import android.content.res.Configuration;
import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_MY_TEXT_VIEW_MAIN = "DATA_MAIN";
    private static final String KEY_MY_TEXT_VIEW_ADD = "DATA_ADD";
    private static final String KEY_MY_DOT_FLAG_MAIN = "MY_DOT_FLAG_MAIN";
    private static final String KEY_MY_DOT_FLAG_ADD = "MY_DOT_FLAG_ADD";

    String myTemporaryText="";
    TextView myTextView;
    TextView myTextViewAdditional;

    public String myTextViewString;
    public  String myTextViewStringAdd;

    public boolean myDotFlag = false;
    public boolean myDotFlagAdd = false;

    private int lineCount;
    private int relativeLayoutDirection;

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
        getSupportActionBar().hide();
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        TextView myTextView = (TextView) findViewById(R.id.textViewMain);
        TextView myTextViewAdditional = (TextView) findViewById(R.id.textViewAdditional);



        if(savedInstanceState!=null){

            myTextView.setText(savedInstanceState.getString(KEY_MY_TEXT_VIEW_MAIN));
            myTextViewAdditional.setText(savedInstanceState.getString(KEY_MY_TEXT_VIEW_ADD));
            myDotFlag = savedInstanceState.getBoolean(KEY_MY_DOT_FLAG_MAIN);
            myDotFlagAdd = savedInstanceState.getBoolean(KEY_MY_DOT_FLAG_ADD);

            //Log.d("MYLOG","onCreate   myTextViewString  "+ myTextViewString);
            //Log.d("MYLOG","onCreate   myTextViewStringAdd   "+myTextViewStringAdd);
        }



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
                myDotFlag=false;
                myDotFlagAdd=false;

                return true;
            }
        });



    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);





        TextView myTextView = (TextView) findViewById(R.id.textViewMain);
        TextView myTextViewAdditional = (TextView) findViewById(R.id.textViewAdditional);

        myTextViewString = myTextView.getText().toString();
        myTextViewStringAdd = myTextViewAdditional.getText().toString();

        //Log.d("MYLOG","myTextViewString  "+ myTextViewString)
        //Log.d("MYLOG","myTextViewStringAdd   "+myTextViewStringAdd);

        outState.putString(KEY_MY_TEXT_VIEW_MAIN, myTextViewString);
        outState.putString(KEY_MY_TEXT_VIEW_ADD, myTextViewStringAdd);
        outState.putBoolean(KEY_MY_DOT_FLAG_MAIN, myDotFlag);
        outState.putBoolean(KEY_MY_DOT_FLAG_ADD, myDotFlagAdd);
    }

    @Override
    public void onClick(View v){
        //String myTemporaryText;
        TextView myTextView = (TextView) findViewById(R.id.textViewMain);
        TextView myTextViewAdditional = (TextView) findViewById(R.id.textViewAdditional);

        switch (v.getId()){

            case R.id.btnClear:
                if(myTextView.getText().length()!=0){
                    if(myTextView.getText().charAt(myTextView.length()-1)=='.'){
                        myDotFlag=false;
                        Log.d("MYLOG", "btnClear + myDotFlag = " +myDotFlag);
                        Log.d("MYLOG", "btnClear + myDotFlagAdd = " +myDotFlagAdd);
                    }else if(myTextView.getText().charAt(myTextView.getText().length()-1)=='+' ||
                            myTextView.getText().charAt(myTextView.getText().length()-1)=='-' ||
                            myTextView.getText().charAt(myTextView.getText().length()-1)=='x' ||
                            myTextView.getText().charAt(myTextView.getText().length()-1)=='÷'){

                            for (int i=myTextView.getText().length()-2; i>=0;i--){
                                if(myTextView.getText().charAt(i)=='.') {

                                    myDotFlagAdd = false;
                                    myDotFlag = true;
                                    break;

                                }else if(myTextView.getText().charAt(i)=='+' ||
                                        myTextView.getText().charAt(i)=='-' ||
                                        myTextView.getText().charAt(i)=='x' ||
                                        myTextView.getText().charAt(i)=='÷'){

                                    myDotFlagAdd = false;
                                    myDotFlag = false;
                                    break;
                                }

                            }

                            Log.d("MYLOG", "btnClear + myDotFlag = " +myDotFlag);
                            Log.d("MYLOG", "btnClear + myDotFlagAdd = " +myDotFlagAdd);
                        }





                    myTextView.setText(myTextView.getText().toString().substring(0,myTextView.length()-1));
                }

                break;



            case R.id.btnEqual:

                if (myTextView.getText().length()==0 ||
                        myTextView.getText().charAt(myTextView.getText().length()-1)=='+' ||
                        myTextView.getText().charAt(myTextView.getText().length()-1)=='-' ||
                        myTextView.getText().charAt(myTextView.getText().length()-1)=='x' ||
                        myTextView.getText().charAt(myTextView.getText().length()-1)=='÷' ||
                        myTextView.getText().charAt(myTextView.getText().length()-1)=='.'){

                    Log.d("MYLOG", "ERROR");
                }else {

                    int ii = 0;

                    String myTemporaryString = "";
                    myTextView.setText(myTextView.getText() + "=");
                    myTextViewAdditional.setText(myTextView.getText());

                    for (int i = 1; i < myTextView.length(); i++) {
                        // Log.d("MYLOG", "ITERATION NUMBER " + i);
                        if (myTextView.getText().toString().charAt(i) == '+' |
                                myTextView.getText().toString().charAt(i) == '-' |
                                myTextView.getText().toString().charAt(i) == 'x' |
                                myTextView.getText().toString().charAt(i) == '÷') {

                            ii++;

                        }

                    }


                    //Log.d("MYLOG", "ii NUMBER " + ii);

                    Double[] myNumbers = new Double[ii + 1];
                    char[] mySigns = new char[ii + 1];

                    if (myTextView.getText().toString().charAt(0) == '-') {

                        mySigns[0] = '-';
                    } else {

                        mySigns[0] = '+';
                    }

                    // Log.d("MYLOG", " NUMBER ONE   " + ii);

                    int iii = 0;
                    for (int i = 0; i < myTextView.length(); i++) {

                        if ((myTextView.getText().charAt(i) >= '0' &
                                myTextView.getText().charAt(i) <= '9') |
                                myTextView.getText().charAt(i) == '.') {

                            myTemporaryString = myTemporaryString + myTextView.getText().charAt(i);
                            //Log.d("MYLOG","NUMBER iii = " + iii+ " |   myTemporaryString  " + myTemporaryString);
                        } else if (i != 0) {
                            myNumbers[iii] = Double.valueOf(myTemporaryString);
                            //Log.d("MYLOG", "iii DOUBLE NUMBER " + String.valueOf(myNumbers[iii]));
                            iii++;

                            // Log.d("MYLOG", iii + "   SIGN is   " + myTextView.getText().charAt(i));

                            if (myTextView.getText().charAt(i) == '+' |
                                    myTextView.getText().charAt(i) == '-' |
                                    myTextView.getText().charAt(i) == 'x' |
                                    myTextView.getText().charAt(i) == '÷') {

                                mySigns[iii] = myTextView.getText().charAt(i);
                                Log.d("MYLOG", iii + "  SIGNS  IS " + mySigns[iii]);
                            }
                            Log.d("MYLOG", iii-1 + "   myNumbers is   " + myNumbers[iii-1]);
                            Log.d("MYLOG", iii-1 + "   mySigns is   " + mySigns[iii-1]);
                            if(myNumbers[iii-1]==0.0 && mySigns[iii-1]=='÷'){
                                Toast myToast = Toast.makeText(getApplicationContext(),"EGGOR!!!\nMan! Are You stupid?", Toast.LENGTH_LONG);

                                myToast.setGravity(Gravity.TOP,0,150);
                                myToast.show();
                                myTextViewAdditional.setText(myTextView.getText());
                                myTextView.setText("");
                                myTextViewString = myTextView.getText().toString();
                                myTextViewStringAdd=myTextViewAdditional.getText().toString();
                                return;

                            }


                            myTemporaryString = "";

                        }
                    }

                    Double myTemporaryNumber = 0.0;
                    Double myConstantNumber = 0.0;
                    for (int i = 1; i < mySigns.length; i++) {
                        boolean flag1 = false;
                        Log.d("MYLOG", "  NUMBER i  = " + i);

                        if (mySigns[i] == 'x' & mySigns[i - 1] == '+') {
                            Log.d("MYLOG", i + "  myNumbers + *  = " + myNumbers[i - 1] + "   " + myNumbers[i]);
                            myTemporaryNumber = myNumbers[i - 1] * myNumbers[i];
                            flag1 = true;
                            Log.d("MYLOG", i + "  myTemporaryNumber + *  = " + myTemporaryNumber);

                        } else if (mySigns[i] == 'x' & mySigns[i - 1] == '-') {
                            Log.d("MYLOG", i + "  myNumbers - *  = " + myNumbers[i - 1] + "   " + myNumbers[i]);
                            myTemporaryNumber = -myNumbers[i - 1] * myNumbers[i];
                            flag1 = true;
                            Log.d("MYLOG", i + "  myTemporaryNumber - *  = " + myTemporaryNumber);

                        } else if (mySigns[i] == '÷' & mySigns[i - 1] == '+') {
                            Log.d("MYLOG", i + "  myNumbers  + /  = " + myNumbers[i - 1] + "   " + myNumbers[i]);
                            myTemporaryNumber = myNumbers[i - 1] / myNumbers[i];
                            flag1 = true;
                            Log.d("MYLOG", i + "  myTemporaryNumber + /  = " + myTemporaryNumber);

                        } else if (mySigns[i] == '÷' & mySigns[i - 1] == '-') {
                            Log.d("MYLOG", i + "  myNumbers - /  = " + myNumbers[i - 1] + "   " + myNumbers[i]);
                            myTemporaryNumber = -myNumbers[i - 1] / myNumbers[i];
                            flag1 = true;
                            Log.d("MYLOG", i + "  myTemporaryNumber - /  = " + myTemporaryNumber);
                        }


                        int j = i;
                        
                        while (flag1 == true) {
                            if (j <= mySigns.length - 2) {
                                Log.d("MYLOG", "WHILE FOR  NUMBER J  = " + j);
                                if (mySigns[j + 1] == 'x') {
                                    // Log.d("MYLOG", j + "  NUMBER J *  = " + myTemporaryNumber +"   "+myNumbers[j + 1]);
                                    myTemporaryNumber = myTemporaryNumber * myNumbers[j + 1];
                                    // Log.d("MYLOG", j + "  NUMBER J  = " + myTemporaryNumber );
                                    j++;

                                } else if (mySigns[j + 1] == '÷') {
                                    // Log.d("MYLOG", j + "  NUMBER J /  = " + myTemporaryNumber +"   "+myNumbers[j + 1]);
                                    myTemporaryNumber = myTemporaryNumber / myNumbers[j + 1];
                                    // Log.d("MYLOG", j + "  NUMBER J  = " + myTemporaryNumber );
                                    j++;


                                } else if (mySigns[j + 1] == '+' | mySigns[j + 1] == '-') {
                                    flag1 = false;
                                    i = j;
                                    Log.d("MYLOG", "  myTemporaryNumber  IS " + myTemporaryNumber);
                                    myConstantNumber = myConstantNumber + myTemporaryNumber;
                                    myTemporaryNumber = 0.0;
                                    Log.d("MYLOG", "  myConstantNumber  IS " + myConstantNumber);
                                }

                            } else {
                                Log.d("MYLOG", "  NUMBER J >= mySigns.length-2  = " + j);
                                break;

                            }


                        }


                    }
                    Log.d("MYLOG", "  myTemporaryNumber  IS " + myTemporaryNumber);
                    myConstantNumber = myConstantNumber + myTemporaryNumber;
                    Log.d("MYLOG", "  myConstantNumber  IS " + myConstantNumber);


                    for (int i = 0; i < mySigns.length; i++) {
                        Log.d("MYLOG", " mySigns  IS " + mySigns[i]);
                        Log.d("MYLOG", " MY I NUMBER =  " + i + "| MY ARRAY LENGTH =  " + mySigns.length);
                        if ((mySigns[i] == 'x' | mySigns[i] == '÷')) {
                           // break;
                        } else if ((mySigns[i] == '+' | mySigns[i] == '-') & (mySigns.length == i + 1)) {
                            Log.d("MYLOG", " YOU ARE HERE");
                            if (mySigns[i] == '+') {
                                Log.d("MYLOG", "  my myNumbers for +    " + myNumbers[i]);
                                myConstantNumber = myConstantNumber + myNumbers[i];
                            } else if (mySigns[i] == '-') {
                                Log.d("MYLOG", "  my myNumbers for -    " + myNumbers[i]);
                                myConstantNumber = myConstantNumber - myNumbers[i];
                            }


                        } else if ((mySigns[i] == '+' | mySigns[i] == '-') & (mySigns[i + 1] == '+' | mySigns[i + 1] == '-')) {
                            if (mySigns[i] == '+') {
                                Log.d("MYLOG", "  my myNumbers for +    " + myNumbers[i]);
                                myConstantNumber = myConstantNumber + myNumbers[i];
                            } else if (mySigns[i] == '-') {
                                Log.d("MYLOG", "  my myNumbers for -    " + myNumbers[i]);
                                myConstantNumber = myConstantNumber - myNumbers[i];

                            }

                        }
                    }


                    Log.d("MYLOG", "  myConstantNumber  AFTER All IS " + myConstantNumber);
                    if (myConstantNumber % 1.0 == 0) {
                        myTextView.setText(Integer.toString(Integer.valueOf(myConstantNumber.intValue())));
                        myDotFlag=false;
                        myDotFlagAdd=false;
                    } else {
                        myConstantNumber=Math.rint(1000000.0*myConstantNumber)/1000000.0;
                        myTextView.setText(Double.toString(myConstantNumber));
                        myDotFlag=true;
                        myDotFlagAdd=false;
                    }

                    lineCount = myTextViewAdditional.getLineCount();

                    if (lineCount>1){
                        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
                            myTextViewAdditional.setTextSize(15);
                        }else{
                            myTextViewAdditional.setTextSize(12);
                        }

                   }else if ((lineCount==1)){
                        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
                            myTextViewAdditional.setTextSize(30);
                        }else{
                            myTextViewAdditional.setTextSize(24);
                        }
                   }

                }
                break;

            case R.id.btnDot:

                char mySignDot = '.';
                myCheckingFotRepetitiveSigns(mySignDot);

                break;


            case R.id.btnPlus:
                char mySignP = '+';
                myCheckingFotRepetitiveSigns(mySignP);


                break;

            case R.id.btnMinus:
                char mySignM = '-';
                myCheckingFotRepetitiveSigns(mySignM);

                break;

            case R.id.btnMultiply:
                char mySignMultiply = 'x';
                myCheckingFotRepetitiveSigns(mySignMultiply);


                break;
            // code ALT + 0247
            case R.id.btnDivision:
                char mySignD = '÷';
                myCheckingFotRepetitiveSigns(mySignD);

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

        myTextViewString = myTextView.getText().toString();
        myTextViewStringAdd=myTextViewAdditional.getText().toString();




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
        }else if(myTextLength == 0 || (myTextView.getText().charAt(0)=='-' && myTextLength == 1)){


        }else if (myTextView.getText().charAt(myTextView.length()-1)=='.'|
                myTextView.getText().charAt(myTextView.length()-1)=='+' |
                myTextView.getText().charAt(myTextView.length()-1)=='-' |
                myTextView.getText().charAt(myTextView.length()-1)=='x' |
                myTextView.getText().charAt(myTextView.length()-1)=='÷'){
           // Log.d("MYLOG", "CHECKING WRONG " );


                if(myDotFlagAdd==true & Sign!='.'){
                    myTemporaryText = myTextView.getText().toString();
                    myTextView.setText(myTemporaryText.substring(0,myTemporaryText.length()-1)+Character.toString(Sign));
                    myDotFlag=false;
                   // myDotFlagAdd=false;
                    Log.d("MYLOG", "| myDotFlag +-*/ " + myDotFlag);
                   // Log.d("MYLOG", "| myDotFlagAdd +-*/ " + myDotFlagAdd);
                }else if (myDotFlagAdd==false & Sign!='.'){
                     myTemporaryText = myTextView.getText().toString();
                    myTextView.setText(myTemporaryText.substring(0,myTemporaryText.length()-1)+Character.toString(Sign));
                    myDotFlag=false;
                    Log.d("MYLOG", "| myDotFlag +-*/ " + myDotFlag);
                  //Log.d("MYLOG", "| myDotFlagAdd +-*/ " + myDotFlagAdd);
               }else if (myDotFlagAdd==false & Sign=='.'){
                   myTemporaryText = myTextView.getText().toString();
                   myTextView.setText(myTemporaryText.substring(0,myTemporaryText.length()-1)+Character.toString(Sign));
                   myDotFlag=true;
                    //myDotFlagAdd=true;
                  Log.d("MYLOG", "| myDotFlag . " + myDotFlag);
                   // Log.d("MYLOG", "| myDotFlagAdd . " + myDotFlagAdd);
                }else if (myDotFlagAdd==true & Sign=='.'){

                }


        }else{
            if (Sign=='.' & myDotFlag==false){
                myTemporaryText = myTextView.getText().toString()+Character.toString(Sign);
                myTextView.setText(myTemporaryText);
                myDotFlag=true;
                myDotFlagAdd=false;
                Log.d("MYLOG", "|| myDotFlag . " + myDotFlag);
                Log.d("MYLOG", "|| myDotFlagAdd . " + myDotFlagAdd);
            }else if(Sign=='.' & myDotFlag==true){
                myDotFlag=true;
                Log.d("MYLOG", "|| myDotFlag . " + myDotFlag);
            }else if(Sign!='.' & myDotFlag==true){
                myTemporaryText = myTextView.getText().toString()+Character.toString(Sign);
                myTextView.setText(myTemporaryText);
                myDotFlagAdd=true;
                myDotFlag=false;
                Log.d("MYLOG", "|| myDotFlag +-*/ " + myDotFlag);
                Log.d("MYLOG", "|| myDotFlagAdd +-*/ " + myDotFlagAdd);


            }else if(Sign!='.' & myDotFlag==false){
                myTemporaryText = myTextView.getText().toString()+Character.toString(Sign);
                myTextView.setText(myTemporaryText);
               // myDotFlag=true;
                Log.d("MYLOG", "|| myDotFlag +-*/ " + myDotFlag);
        }



        }

    }



}
