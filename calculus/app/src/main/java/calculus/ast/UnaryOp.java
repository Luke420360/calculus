package calculus.ast;
/**
 * Repräsentiert eine unäre Operation im AST,
 * z.B. -x, sin(x), ln(x), sqrt(x).
 * Hat genau ein Kind: den Operanden.
 */
public class UnaryOp extends Expression {

    private final UnaryFunction function;
    private final Expression operand;

    public UnaryOp(UnaryFunction function, Expression operand){
        this.function = function;
        this.operand = operand;
    }
    
    @Override
    public double evaluate(double x) {
        double value = operand.evaluate(x);

        switch (function) {
            case NEGATE: return -value;
            case SIN:    return Math.sin(value);
            case COS:    return Math.cos(value);
            case TAN:    return Math.tan(value);
            case LN:     return Math.log(value);
            case EXP:    return Math.exp(value);
            case SQRT:   return Math.sqrt(value);
            case ABS:    return Math.abs(value); // Betrag
            default:
                throw new IllegalStateException("Unbekannte Funktion: " + function);
        }
    }

    @Override
    public String toString() {
        if (function == UnaryFunction.NEGATE) {
            return "(-" + operand + ")";
        }

        String name;
        switch (function) {
            case SIN:  name = "sin";  break;
            case COS:  name = "cos";  break;
            case TAN:  name = "tan";  break;
            case LN:   name = "ln";   break;
            case EXP:  name = "exp";  break;
            case SQRT: name = "sqrt"; break;
            case ABS:  name = "abs";  break;
            default:
                throw new IllegalStateException("Unbekannte Funktion: " + function);
        }
        return name + "(" + operand + ")";
    }
}
