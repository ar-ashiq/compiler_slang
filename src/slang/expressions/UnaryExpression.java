package slang.expressions;

import slang.Operator;

public class UnaryExpression extends Expression{

    private final double _value1;
    private final Operator _op;

    public UnaryExpression(double n, Operator op) {
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
