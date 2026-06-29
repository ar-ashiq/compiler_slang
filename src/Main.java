import slang.Operator;
import slang.expressions.BinaryExpression;
import slang.expressions.Expression;
import slang.expressions.NumericConstant;
import slang.expressions.UnaryExpression;

public class Main {
    public static void main(String[] args) {
        Expression ex;
//       arithmetic expression 2+3
        ex = new BinaryExpression(
                new NumericConstant(2), new NumericConstant(3), Operator.ADD
        );
        double ans = ex.evaluate();
        System.out.println(ans);

//        arithmetic expression -(5*3)
        ex = new UnaryExpression(
                new BinaryExpression(
                        new NumericConstant(5),
                        new NumericConstant(3),
                        Operator.MUL).evaluate(),
                Operator.SUB
        );
        ans = ex.evaluate();
        System.out.println(ans);
    }
}