package calculus.ast;

public final class Variable extends Expression {

    private final String name;

    public Variable() {
        this.name = "x";
    }

    @Override
    public double evaluate(double x) {
        return x;
    }

    @Override
    public String toString() {
        return name;
    }
}
