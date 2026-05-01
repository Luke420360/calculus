package calculus.ast;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VariableTest {
    @Test
    void evaluateReturnsTheGivenX(){
        Variable x = new Variable();

        assertEquals(.0, x.evaluate(.0));
        assertEquals(12, x.evaluate(12));
        assertEquals(-.5, x.evaluate(-.5));
    }

    @Test
    void toStringReturnsX() {
        Variable x = new Variable();
        assertEquals("x", x.toString());
    }
}
