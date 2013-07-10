/**
 * @author Samarth Sinha
 * Date : 25/4/2013
 *  This is a basic Calculator app that can perform  two variable polynomial calculation and one can plot single variable polynomial by giving range and step of plot 
 */
package com.smapp.sigmacalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import expression.solver.sigma.ExpressionSolver;

public class Main extends Activity {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bMul, bAdd, bMin, bDot, bDiv, bEq, bClear, bAns, bFx, bPowe;
    TextView output;
    static int counter;
    static String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.calclayout);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b0 = (Button) findViewById(R.id.b0);
        bDiv = (Button) findViewById(R.id.bDiv);
        bDot = (Button) findViewById(R.id.bDot);
        bAdd = (Button) findViewById(R.id.bAdd);
        bMin = (Button) findViewById(R.id.bMin);
        bMul = (Button) findViewById(R.id.bMul);
        bEq = (Button) findViewById(R.id.bEq);
        bAns = (Button) findViewById(R.id.bAns);
        bClear = (Button) findViewById(R.id.bClear);
        bFx = (Button) findViewById(R.id.bFx);
        bPowe = (Button) findViewById(R.id.bPowe);

        output = (TextView) findViewById(R.id.tvHead);
        output.setText("");
        b1.setOnClickListener(new ButtonClickListener());
        b2.setOnClickListener(new ButtonClickListener());
        b3.setOnClickListener(new ButtonClickListener());
        b4.setOnClickListener(new ButtonClickListener());
        b5.setOnClickListener(new ButtonClickListener());
        b6.setOnClickListener(new ButtonClickListener());
        b7.setOnClickListener(new ButtonClickListener());
        b8.setOnClickListener(new ButtonClickListener());
        b9.setOnClickListener(new ButtonClickListener());
        b0.setOnClickListener(new ButtonClickListener());
        bDiv.setOnClickListener(new ButtonClickListener());
        bDot.setOnClickListener(new ButtonClickListener());
        bAdd.setOnClickListener(new ButtonClickListener());
        bMin.setOnClickListener(new ButtonClickListener());
        bMul.setOnClickListener(new ButtonClickListener());
        bEq.setOnClickListener(new ButtonClickListener());
        bClear.setOnClickListener(new ButtonClickListener());
        bAns.setOnClickListener(new ButtonClickListener());
        bFx.setOnClickListener(new ButtonClickListener());
        bPowe.setOnClickListener(new ButtonClickListener());


    }

    class ButtonClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.b0) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + "0");

            } else if (v.getId() == R.id.b1) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + "1");

            } else if (v.getId() == R.id.b2) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + "2");

            } else if (v.getId() == R.id.b3) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + "3");

            } else if (v.getId() == R.id.b4) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + "4");

            } else if (v.getId() == R.id.b5) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + "5");

            } else if (v.getId() == R.id.b6) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + "6");

            } else if (v.getId() == R.id.b7) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + "7");

            } else if (v.getId() == R.id.b8) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + "8");

            } else if (v.getId() == R.id.b9) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + "9");

            } else if (v.getId() == R.id.bDot) {
                if (counter == 1) {
                    counter = 0;
                    output.setText("");
                }
                output.setText(output.getText() + ".");

            } else if (v.getId() == R.id.bMul) {
                if (counter == 1)
                    counter = 0;
                output.setText(output.getText() + "*");

            } else if (v.getId() == R.id.bAdd) {
                if (counter == 1)
                    counter = 0;
                output.setText(output.getText() + "+");

            } else if (v.getId() == R.id.bMin) {
                if (counter == 1)
                    counter = 0;
                output.setText(output.getText() + "-");

            } else if (v.getId() == R.id.bDiv) {
                if (counter == 1)
                    counter = 0;
                output.setText(output.getText() + "/");

            } else if (v.getId() == R.id.bEq) {
                if (counter == 1)
                    counter = 0;
                counter = 1;
                ExpressionSolver expSol = new ExpressionSolver();
                String expression = output.getText().toString();
                ans = expSol.solve(expression) + "";
                output.setText(ans);
            } else if (v.getId() == R.id.bPowe) {
                if (counter == 1)
                    counter = 0;
                output.setText(output.getText() + "^");
            } else if (v.getId() == R.id.bClear) {
                if (counter == 1)
                    counter = 0;
                output.setText("");
            } else if (v.getId() == R.id.bAns) {
                if (counter == 1)
                    counter = 0;
                output.setText(ans);
            } else if (v.getId() == R.id.bFx) {
                Intent i = new Intent(getApplicationContext(), FunctionScreen.class);
                startActivity(i);

            }
        }


    }

}
