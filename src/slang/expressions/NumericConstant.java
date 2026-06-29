package slang.expressions;

public class NumericConstant extends Expression{
    private final double _value;
    public NumericConstant(double n){
        _value = n;
    }

    @Override
    public double evaluate() {
        return _value;
    }
}
