package expression.solver.sigma;

import java.util.Queue;
import java.util.Stack;

public class FunctionSolver {
    String function;
    int numVar;
    char var1, var2;
    double valVar1, valVar2;
    Queue<String> q;
    Stack<String> st;

    public FunctionSolver() {
        this("0");
    }

    public FunctionSolver(String fun) {
        this(fun, 'x');
    }

    public FunctionSolver(String fun, char var1) {
        this(fun, var1, 'y');
    }

    public FunctionSolver(String fun, char var1, char var2) {
        this.function = fun;
        this.var1 = var1;
        this.var2 = var2;
        this.valVar1 = 0;
        this.valVar2 = 0;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getNumVar() {
        return numVar;
    }

    public void setNumVar(int numVar) {
        this.numVar = numVar;
    }

    public char getVar1() {
        return var1;
    }

    public void setVar1(char var1) {
        this.var1 = var1;
    }

    public char getVar2() {
        return var2;
    }

    public void setVar2(char var2) {
        this.var2 = var2;
    }

    public double getValVar1() {
        return valVar1;
    }

    public void setValVar1(double valVar1) {
        this.valVar1 = valVar1;
    }

    public double getValVar2() {
        return valVar2;
    }

    public void setValVar2(double valVar2) {
        this.valVar2 = valVar2;
    }

    public String parseFunction() {
        int i;
        int lenFun;
        String temp = "";
        lenFun = this.function.length();
        for (i = 0; i < lenFun; i++) {
            char c = function.charAt(i);
            if (c == var1) {
                temp += valVar1;
                continue;
            } else if (c == var2) {
                temp += valVar2;
                continue;
            }
            temp += c;
        }
        return temp;

    }


}
