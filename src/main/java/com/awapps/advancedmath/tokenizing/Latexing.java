package com.awapps.advancedmath.tokenizing;

public class Latexing {
    private TokenList tokenList;
    public Latexing(TokenList tl){
        this.tokenList=tl;
    }
    public String toLatex(){
        int i = 0;
        while(true){
            Token currentToken = tokenList.tokenAt(i);
            if(currentToken.type.equals(TokenType.OPARATOR)){

            }
            if(1==1){
                break;
            }
        }
        return "";
    }
    public static String toLatex(String s){

        return "";
    }

}
