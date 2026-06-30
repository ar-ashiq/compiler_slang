package slang.expressions;

import slang.Operator;

public class BinaryExp extends Exp {
    private final NumericConstant _exp1, _exp2;
    private final Operator _op;

    public BinaryExp(NumericConstant n1, NumericConstant n2, Operator op) {
        _exp1 = n1;
        _exp2 = n2;
        _op = op;
    }

    @Override
    public double evaluate() {
        return switch (_op) {
            case ADD -> _exp1.evaluate() + _exp2.evaluate();
            case SUB -> _exp1.evaluate() - _exp2.evaluate();
            case MUL -> _exp1.evaluate() * _exp2.evaluate();
            case DIV -> _exp1.evaluate() / _exp2.evaluate();
            default ->  Double.NaN;
        };
    }
}
