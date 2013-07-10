package expression.solver.sigma;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Samarth Sinha
 *         <Br>Date : 25/04/2013
 *         Description : ExpressionSolver class gets a mathematical string as one of the parameters.This contains modules to process on the given
 *         string to get the correct result of the expression.
 *         <p/>
 *         Limitation : No parenthesis parsing implemented
 *         - Power(^) got the same precedence as that of multiply(*) and Division(/)
 *         If you give expression as '2*3^3' the result that you will get is '6^3 = 216' and not '2*9 = 18'<Br/>
 */
public class ExpressionSolver {
    String expression;
    Queue<String> q;
    Stack<String> resultStack;

    /**
     * No-args constructer
     */
    public ExpressionSolver() {
        expression = "0";
        q = new LinkedList<String>();
        resultStack = new Stack<String>();
    }

    /**
     * This function parses the given string into numbers and operators
     *
     * @param void
     * @return void
     */
    private void parse() {

        int i, flag = 0;
        String temp = "";
        try {

            for (i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);
                if (i == 0 && c == '-' && flag == 0) {
                    temp += c;
                    continue;
                }
                //to put number in the queue u have to check if the character read is any operator or not
                if (!(c != '+' && c != '-' && c != '/' && c != '*' && c != '^') && flag == 0) {
                    if (expression.charAt(i + 1) == '-')
                        flag = 1;

                    q.add(temp);
                    q.add("" + c);
                    temp = "";
                    continue;
                } else if (flag == 1) {
                    temp += c;
                    flag = 0;
                } else if (c == 'E') {
                    temp += c;
                    flag = 2;

                } else if (flag == 2) {
                    temp += c;
                    flag = 0;
                } else
                    temp += c;
            }
            q.add(temp);

        } catch (NumberFormatException e) {
            System.out.println("Error in Parsing " + e);
        }
    }

    /**
     * This function needs to be called in order to calculate value of given mathematical expression.
     * This function requires mathematical @param exp as parameter
     * and return the calculated double value
     *
     * @return result
     */
    public double solve(String exp) {
        if (!exp.equals(""))
            this.expression = exp;
        parse();
        double result = 0;
        int lenQ = q.size();
        int i;
        double a, b;
        double x = 0;
        String operator;
        String s;
        while (lenQ > 0) {

            s = q.remove();
            lenQ--;
            if (!s.equals("*") && !s.equals("/") && !s.equals("^"))
                resultStack.push(s);
            else {
                resultStack.push(s);
                resultStack.push(q.remove());
                lenQ--;


                b = Double.parseDouble(resultStack.pop());
//					Log.d("b",""+b);
                operator = resultStack.pop();
                a = Double.parseDouble(resultStack.pop());
//					Log.d("a",""+a);
                if (operator.equals("/"))
                    x = a / b;
                else if (operator.equals("*"))
                    x = a * b;
                else if (operator.equals("^"))
                    x = Math.pow(a, b);
                else x = 0;
//					Log.d("x",""+x);
                resultStack.push("" + x);
            }
        }

	
	/*	while(resultStack.size()!=1)
		{
			b  = Double.parseDouble(resultStack.pop());
			operator = resultStack.pop();
			a = Double.parseDouble(resultStack.pop());
			if(operator.equals("+"))
				result=a+b;
			if(operator.equals("-"))
				result=a-b;
			resultStack.push(result+"");		
		}*/
        Stack<String> revStack = new Stack<String>();
        while (resultStack.size() != 0) {
            revStack.push(resultStack.pop());
        }
        resultStack = revStack;
        while (resultStack.size() != 1) {
            a = Double.parseDouble(resultStack.pop());
//			Log.d("a",""+a);
            operator = resultStack.pop();
            b = Double.parseDouble(resultStack.pop());
//			Log.d("b",""+b);
            if (operator.equals("+"))
                result = a + b;
            if (operator.equals("-"))
                result = a - b;
//			Log.d("RESULT",""+result);
            resultStack.push(result + "");
        }

        result = Double.parseDouble(resultStack.pop());
        return result;
    }


}
