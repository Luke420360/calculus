package calculus.ast;
/**
 * Repräsentation von binären OperationsException
 * bsp: 1 + 1, x*4 usw.
 * Hat zwei kinder einen linken und rechten Operanden
 */
public class BinaryOp extends Expression {

    private final Operator operator;
    private final Expression left;
    private final Expression right;

    public BinaryOp(Operator operator, Expression left, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override public double evaluate(double x) {
        // Rekursiv für die fancyness
        double leftValue = left.evaluate(x);
        double rightValue = right.evaluate(x);

        switch (operator) {
            case PLUS: return leftValue + rightValue;
            case MINUS: return leftValue - rightValue;
            case TIMES: return leftValue * rightValue;
            case DIVIDE: return leftValue / rightValue; // Check for zero?
            case POWER: return Math.pow(leftValue, rightValue); 
            default: throw new IllegalStateException("Unbekannter Operator! " + operator);
        }
    }

    @Override
    public String toString() {
        String symbol;
        switch (operator) {
            case PLUS:   symbol = "+"; break;
            case MINUS:  symbol = "-"; break;
            case TIMES:  symbol = "*"; break;
            case DIVIDE: symbol = "/"; break;
            case POWER:  symbol = "^"; break;
            default:
                throw new IllegalStateException("Unbekannter Operator! " + operator);
        }
        return "(" + left + ' ' + symbol + ' ' + right + ')';
    }
}
