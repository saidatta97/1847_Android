package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    double input1 = 0, input2 = 0;
    TextView edt1;
    TextView edt2;
    boolean Addition, Subtract, Multiplication, Division, mRemainder, decimal,Zero;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub,
            btnMul, btnDivision, btnEqual, btnDel, btnDot, btnclear;

    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.zero);
        btn1 = (Button) findViewById(R.id.one);
        btn2 = (Button) findViewById(R.id.two);
        btn3 = (Button) findViewById(R.id.three);
        btn4 = (Button) findViewById(R.id.four);
        btn5 = (Button) findViewById(R.id.five);
        btn6 = (Button) findViewById(R.id.six);
        btn7 = (Button) findViewById(R.id.seven);
        btn8 = (Button) findViewById(R.id.eight);
        btn9 = (Button) findViewById(R.id.nine);
        btnDot = (Button) findViewById(R.id.dot);
        btnAdd = (Button) findViewById(R.id.add);
        btnSub = (Button) findViewById(R.id.minus);
        btnMul = (Button) findViewById(R.id.mul);
        btnDivision = (Button) findViewById(R.id.div);
        btnclear = (Button) findViewById(R.id.clear);
        btnEqual = (Button) findViewById(R.id.equal);
        btnDel = (Button) findViewById(R.id.del);

        builder = new AlertDialog.Builder(this);
        edt1 = (TextView) findViewById(R.id.ip);
        edt2 = (TextView) findViewById(R.id.op);

        edt1.setText(null);


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edt1.getText().length() > 1)
                {
                    edt1.setText(edt1.getText() + "0");
                }

                if (edt1.getText().length() == 0) {
                    edt1.setText(edt1.getText() + "0");
                }
                else
                {


                    if (edt1.getText().length() == 1) {
                        if (edt1.getText().toString().charAt(0) == '0') {
                            Toast toast = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
                            toast.show();

                        }
                        if (edt1.getText().toString().charAt(0) == '.') {

                            edt1.setText(edt1.getText() + "0");

                        }

                    }

                }



            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "9");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    edt2.setText(edt1.getText() + "+");
                    Addition = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    edt2.setText(edt1.getText() + "-");
                    Subtract = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    edt2.setText(edt1.getText() + "*");
                    Multiplication = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt1.getText().length() != 0) {
                    input1 = Float.parseFloat(edt1.getText() + "");
                    edt2.setText(edt1.getText() + "/");
                    Division = true;
                    decimal = false;
                    edt1.setText(null);
                }
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Addition || Subtract || Multiplication || Division || mRemainder) {
                    if (edt1.getText() == "") {
                        input2 = 0;
                        edt2.setText(edt2.getText() + "0");
                    } else {
                        StringBuffer copy=new StringBuffer(edt2.getText());
                        copy.append(edt1.getText());
                        input2 = Float.parseFloat(edt1.getText() + "");
                        edt2.setText(copy);
                    }
                }

                if (Addition) {

                    edt1.setText(input1 + input2 + "");
                    Addition = false;
                }

                if (Subtract) {

                    edt1.setText(input1 - input2 + "");
                    Subtract = false;
                }

                if (Multiplication) {
                    edt1.setText(input1 * input2 + "");
                    Multiplication = false;
                }

                if (Division) {
                    if(input2==0) {
                        Toast toast = Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT);
                        toast.show();
                        edt1.setText("Error");
                    }
                    else
                    {
                        edt1.setText(input1 / input2 + "");
                    }
                    Division = false;
                }


            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                edt2.setText("");
                input1 = 0.0;
                input2 = 0.0;
                decimal = false;
            }
        });


        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt1.getText().length()>0){
                    CharSequence name= edt1.getText().toString();
                    edt1.setText(name.subSequence(0,name.length()-1));

                }

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decimal) {

                    Toast toast = Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT);
                    toast.show();
                    //do nothing or you can show the error
                } else {
                    edt1.setText(edt1.getText() + ".");
                    decimal = true;
                }


            }
        });



    }
}