package slang.expressions;

import slang.Operator;

public class UnaryExp extends Exp {

    private final double _value1;
    private final Operator _op;

    public UnaryExp(double n, Operator op) {
        _value1 = n;
        _op = op;
    }

    @Override
    public double evaluate() {
        return switch (_op) {
            case ADD -> _value1;
            case SUB -> -_value1;
            default -> Double.NaN;
        };
    }
}
