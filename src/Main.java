import slang.Operator;
import slang.expressions.BinaryExp;
import slang.expressions.Exp;
import slang.expressions.NumericConstant;
import slang.expressions.UnaryExp;
import slang.lexer.Lexer;
import slang.lexer.Token;

public class Main {
    public static void main(String[] args) {
//        step1AST();
        step2PrintTokens("2 * 3 + (44+25- 3)");
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
        Exp ex;
//       arithmetic expression 2+3
        ex = new BinaryExp(
                new NumericConstant(2), new NumericConstant(3), Operator.ADD
        );
        double ans = ex.evaluate();
        System.out.println(ans);

//        arithmetic expression -(5*3)
        ex = new UnaryExp(
                new BinaryExp(
                        new NumericConstant(5),
                        new NumericConstant(3),
                        Operator.MUL),
                Operator.SUB
        );
        ans = ex.evaluate();
        System.out.println(ans);
    }
}