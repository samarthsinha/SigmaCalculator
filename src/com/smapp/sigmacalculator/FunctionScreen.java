/**
 * @author Samarth Sinha
 * Date : 25/4/2013
 *  This is a basic Calculator app that can perform  two variable polynomial calculation and one can plot single variable polynomial by giving range and step of plot 
 */

package com.smapp.sigmacalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import expression.solver.sigma.ExpressionSolver;
import expression.solver.sigma.FunctionSolver;

public class FunctionScreen extends Activity {


    Button bCalc, bBack, bPlot;
    EditText etValVar1, etValVar2, etFun;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.functioncalc);
        Toast.makeText(this, "Plotting Functionality is for Single variable", Toast.LENGTH_LONG).show();

        bCalc = (Button) findViewById(R.id.bCalc);
        bBack = (Button) findViewById(R.id.bBack);
        etValVar1 = (EditText) findViewById(R.id.etValVar1);
        etValVar2 = (EditText) findViewById(R.id.etValVar2);
        etFun = (EditText) findViewById(R.id.etFun);
        tvResult = (TextView) findViewById(R.id.tvResult);
        bPlot = (Button) findViewById(R.id.bPlot);
        bCalc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(etFun.getText())) {
                    etFun.setError("Don't Leave this Blank");
                } else {
                    FunctionSolver funSol = new FunctionSolver(etFun.getText().toString());
                    double val1;
                    double val2;
                    if (!TextUtils.isEmpty(etValVar1.getText()) && TextUtils.isDigitsOnly(etValVar1.getText())) {
                        val1 = Double.parseDouble(etValVar1.getText().toString());
                    } else val1 = 0;
                    if (!TextUtils.isEmpty(etValVar2.getText()) && TextUtils.isDigitsOnly(etValVar1.getText())) {
                        val2 = Double.parseDouble(etValVar2.getText().toString());
                    } else val2 = 0;
                    funSol.setValVar1(val1);
                    funSol.setValVar2(val2);
                    ExpressionSolver es = new ExpressionSolver();
                    double result = es.solve(funSol.parseFunction());
                    tvResult.setText("f(" + val1 + "," + val2 + ") = " + result);
                    tvResult.setVisibility(TextView.VISIBLE);
                }


            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main.class);
                startActivity(i);
                finish();
            }
        });

        bPlot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etFun.getText())) {
                    etFun.setError("Plot Can't be used on Empty");
                } else {
                    Bundle b = new Bundle();
                    b.putString("function", etFun.getText().toString());
                    Intent i = new Intent(FunctionScreen.this, PlotGraph.class);
                    i.putExtras(b);
                    startActivity(i);
                    finish();
                }

            }
        });

    }
}
