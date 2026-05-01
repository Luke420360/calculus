package calculus.ast;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberLiteralTest {

    @Test
    void evaluateReturnsConstantValue() {
        NumberLiteral two = new NumberLiteral(2.0);

        assertEquals(2.0, two.evaluate(0.0));
        assertEquals(2.0, two.evaluate(5.0));
        assertEquals(2.0, two.evaluate(-99.0));
    }

    @Test
    void toStringReturnsValueAsString() {
        NumberLiteral pi = new NumberLiteral(3.14);

        assertEquals("3.14", pi.toString());
    }
}