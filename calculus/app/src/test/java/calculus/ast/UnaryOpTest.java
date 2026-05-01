package calculus.ast;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnaryOpTest {
    //Toleranz für Gleitkommawerte wie sin(PI)
    private static final double EPSILON = 1e-9;

    @Test
    void negateReturnsNegativeValue() {
        Expression expr = new UnaryOp(UnaryFunction.NEGATE, new NumberLiteral(5.0));

        assertEquals(-5.0, expr.evaluate(0.0));
    }

    @Test
    void sinOfZeroIsZero() {
        Expression expr = new UnaryOp(UnaryFunction.SIN, new NumberLiteral(0.0));

        assertEquals(0.0, expr.evaluate(0.0), EPSILON);
    }

    @Test
    void cosOfZeroIsOne() {
        Expression expr = new UnaryOp(UnaryFunction.COS, new NumberLiteral(0.0));

        assertEquals(1.0, expr.evaluate(0.0), EPSILON);
    }

    @Test
    void sinOfPiIsZero() {
        Expression expr = new UnaryOp(UnaryFunction.SIN, new NumberLiteral(Math.PI));

        assertEquals(0.0, expr.evaluate(0.0), EPSILON);
    }

    @Test
    void lnOfEIsOne() {
        Expression expr = new UnaryOp(UnaryFunction.LN, new NumberLiteral(Math.E));

        assertEquals(1.0, expr.evaluate(0.0), EPSILON);
    }

    @Test
    void sqrtOfFourIsTwo() {
        Expression expr = new UnaryOp(UnaryFunction.SQRT, new NumberLiteral(4.0));

        assertEquals(2.0, expr.evaluate(0.0));
    }

    @Test
    void sqrtOfNegativeIsNaN() {
        Expression expr = new UnaryOp(UnaryFunction.SQRT, new NumberLiteral(-1.0));

        assertTrue(Double.isNaN(expr.evaluate(0.0)));
    }

    @Test
    void absOfNegativeIsPositive() {
        Expression expr = new UnaryOp(UnaryFunction.ABS, new NumberLiteral(-7.0));

        assertEquals(7.0, expr.evaluate(0.0));
    }
}