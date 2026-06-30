package slang.lexer;

public class Lexer {
    private final String _iExpression;
    private int index;
    private double number;

    public Lexer(String iExpression) {
        _iExpression = iExpression;
        this.index = 0;
    }

    public Token getToken() {
        while (index < _iExpression.length() &&
                (_iExpression.charAt(index) == ' ' || _iExpression.charAt(index) == '\t')
        ){
            index++;
        }
        if (_iExpression.length() == index) {
            return Token.TOKEN_NULL;
        }
        switch (_iExpression.charAt(index)) {
            case '+':
                index++;
                return Token.TOKEN_ADD;
            case '-':
                index++;
                return Token.TOKEN_SUB;
            case '*':
                index++;
                return Token.TOKEN_MUL;
            case '/':
                index++;
                return Token.TOKEN_DIV;
            case '(':
                index++;
                return Token.TOKEN_OPAREN;
            case ')':
                index++;
                return Token.TOKEN_CPAREN;
        }
        if (isNumber(_iExpression.charAt(index))){
            number = 0;
            while(index<_iExpression.length() && isNumber(_iExpression.charAt(index))){
                number = (_iExpression.charAt(index) - '0') + number * 10;
                index++;
            }
            return Token.TOKEN_DOUBLE;
        }
        throw new RuntimeException("Invalid token at index " + index);
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public double getNumber() {
        return number;
    }
}
