package calculus.ast;
/**
 * Repräsentiert eine numerische Konstante im Baum also
 * zum Bleistift 2, oder pi
 */
public final class NumberLiteral extends Expression {
    private final double value;

    public NumberLiteral(double value) {
        this.value = value;
    }

    @Override
    public double evaluate(double x){
        return this.value;
    }

    @Override
    public String toString() {
        return Double.toString(this.value);
    }
}
