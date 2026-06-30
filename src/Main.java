import slang.Operator;
import slang.expressions.BinaryExpression;
import slang.expressions.Expression;
import slang.expressions.NumericConstant;
import slang.expressions.UnaryExpression;
import slang.lexer.Lexer;
import slang.lexer.Token;

public class Main {
    public static void main(String[] args) {
//        step1AST();
        step2PrintTokens("2 * 3 a+ (44+25- 3)");
    }

    private static void step2PrintTokens(String expression) {
        Lexer l = new Lexer(expression);
        Token x = l.getToken();
        while (!Token.TOKEN_NULL.equals(x)){
            System.out.print(x+" ");
            if (Token.TOKEN_DOUBLE.equals(x)){
                System.out.print(l.getNumber());
            }
            System.out.println();
            x = l.getToken();
        }
    }

    private static void step1AST(){
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