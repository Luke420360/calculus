package calculus.ast;

public abstract class Expression {
    /**
     * Wertet den Ausdruck aus mit Wert x
     * @param x Wert, der für die Variable x eingesetzt wird
     * @return numerisches Ergebnis des Ausdrucks
    */
    public abstract double evaluate(double x);

    @Override
    public abstract String toString();
}
