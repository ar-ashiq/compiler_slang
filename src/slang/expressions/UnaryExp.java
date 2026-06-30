package slang.expressions;

import slang.Operator;

public class UnaryExp extends Exp {

    private final Exp _value;
    private final Operator _op;

    public UnaryExp(Exp n, Operator op) {
        _value = n;
        _op = op;
    }

    @Override
    public double evaluate() {
        return switch (_op) {
            case ADD -> _value.evaluate();
            case SUB -> -_value.evaluate();
            default -> Double.NaN;
        };
    }
}
