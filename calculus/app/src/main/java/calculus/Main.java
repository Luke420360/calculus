package calculus;

import calculus.ast.BinaryOp;
import calculus.ast.Expression;
import calculus.ast.NumberLiteral;
import calculus.ast.Operator;
import calculus.ast.UnaryFunction;
import calculus.ast.UnaryOp;
import calculus.ast.Variable;

public class Main {
    public static void main(String[] args) {
        // Ausdruck: sin(x) + x^2
        Expression x = new Variable();
        Expression sinusVonX = new UnaryOp(UnaryFunction.SIN, x);
        Expression xQuadrat = new BinaryOp(Operator.POWER, x, new NumberLiteral(2.0));
        Expression formel = new BinaryOp(Operator.PLUS, sinusVonX, xQuadrat);

        System.out.println("Ausdruck: " + formel);
        System.out.println("f(0) = " + formel.evaluate(0.0));
        System.out.println("f(1) = " + formel.evaluate(1.0));
        System.out.println("f(Pi) = " + formel.evaluate(Math.PI));
    }
}
