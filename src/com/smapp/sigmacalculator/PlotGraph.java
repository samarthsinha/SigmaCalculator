/**
 * @author Samarth Sinha
 * Date : 25/4/2013
 *  This is a basic Calculator app that can perform  two variable polynomial calculation and one can plot single variable polynomial by giving range and step of plot 
 */
package com.smapp.sigmacalculator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.jjoe64.graphview.GraphView.GraphViewData;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import expression.solver.sigma.ExpressionSolver;
import expression.solver.sigma.FunctionSolver;


public class PlotGraph extends Activity {
    TextView tvFun;
    EditText etStart, etEnd, etStep;
    Button bPlot1;
    static String fun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plotdata);
        fun = getIntent().getExtras().getString("function");
        tvFun = (TextView) findViewById(R.id.tvFun);
        etStart = (EditText) findViewById(R.id.etStart);
        etEnd = (EditText) findViewById(R.id.etEnd);
        etStep = (EditText) findViewById(R.id.etStep);
        bPlot1 = (Button) findViewById(R.id.bPlot1);

        tvFun.setText("f(x)=" + fun);

        bPlot1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double start, end, step, result;
                start = Double.parseDouble(etStart.getText().toString());
                end = Double.parseDouble(etEnd.getText().toString());
                step = Double.parseDouble(etStep.getText().toString());


                FunctionSolver fx = new FunctionSolver(fun);
                fx.setValVar2(0);
                ExpressionSolver es = new ExpressionSolver();
                LineGraphView graphView = new LineGraphView(getApplicationContext(), "f(x)=" + fun);
                GraphViewSeries g = new GraphViewSeries(new GraphViewData[]{});

                for (double i = start; i <= end; i += step) {
                    fx.setValVar1(i);
                    //Log.d("FX "+i," ");
                    String parsedFun = fx.parseFunction();
                    result = es.solve(parsedFun);
                    result = Math.round(result);
                    Log.d("F(" + i + ")", "" + result);
                    g.appendData(new GraphViewData(i, result), true);

                }
                graphView.setScalable(true);
                graphView.setBackgroundColor(Color.BLACK);
                graphView.addSeries(g);
                setContentView(graphView);

            }
        });


    }
}
