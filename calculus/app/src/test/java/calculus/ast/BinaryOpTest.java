package calculus.ast;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryOpTest {

    @Test
    void plusAddsTwoNumbers() {
        Expression expr = new BinaryOp(
            Operator.PLUS,
            new NumberLiteral(2.0),
            new NumberLiteral(3.0)
        );

        assertEquals(5.0, expr.evaluate(0.0));
    }

    @Test
    void minusSubtracts() {
        Expression expr = new BinaryOp(
            Operator.MINUS,
            new NumberLiteral(10.0),
            new NumberLiteral(4.0)
        );

        assertEquals(6.0, expr.evaluate(0.0));
    }

    @Test
    void timesMultiplies() {
        Expression expr = new BinaryOp(
            Operator.TIMES,
            new NumberLiteral(3.0),
            new NumberLiteral(4.0)
        );

        assertEquals(12.0, expr.evaluate(0.0));
    }

    @Test
    void divideDivides() {
        Expression expr = new BinaryOp(
            Operator.DIVIDE,
            new NumberLiteral(10.0),
            new NumberLiteral(4.0)
        );

        assertEquals(2.5, expr.evaluate(0.0));
    }

    @Test
    void powerRaises() {
        Expression expr = new BinaryOp(
            Operator.POWER,
            new NumberLiteral(2.0),
            new NumberLiteral(10.0)
        );

        assertEquals(1024.0, expr.evaluate(0.0));
    }

    @Test
    void divisionByZeroReturnsInfinity() {
        Expression expr = new BinaryOp(
            Operator.DIVIDE,
            new NumberLiteral(1.0),
            new NumberLiteral(0.0)
        );

        assertEquals(Double.POSITIVE_INFINITY, expr.evaluate(0.0));
    }

    @Test
    void usesVariableValue() {
        // Ausdruck: 2 * x
        Expression expr = new BinaryOp(
            Operator.TIMES,
            new NumberLiteral(2.0),
            new Variable()
        );

        assertEquals(0.0, expr.evaluate(0.0));
        assertEquals(10.0, expr.evaluate(5.0));
        assertEquals(-6.0, expr.evaluate(-3.0));
    }

    @Test
    void nestedExpressionsEvaluateCorrectly() {
        // Ausdruck: 2 + 3 * x
        Expression mal = new BinaryOp(
            Operator.TIMES,
            new NumberLiteral(3.0),
            new Variable()
        );
        Expression plus = new BinaryOp(
            Operator.PLUS,
            new NumberLiteral(2.0),
            mal
        );

        assertEquals(2.0, plus.evaluate(0.0));
        assertEquals(17.0, plus.evaluate(5.0));
    }
}