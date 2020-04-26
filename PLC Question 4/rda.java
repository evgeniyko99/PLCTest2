import java.io.*;
class rda {

  public void expr() {
    System.out.println("Enter <expr>");
    term();
    while (front.nextToken == front.ADD_OP || front.nextToken == front.SUB_OP) {
      front.lex();
      term();
   }
   System.out.println("Exit <expr>");
  }

  public void term() {
    System.out.println("Enter <term>");
    factor();
    while (front.nextToken == front.MULT_OP || front.nextToken == front.DIV_OP || front.nextToken == front.MODO_OP) {
      front.lex();
      if (front.nextToken == front.MULT_OP || front.nextToken == front.DIV_OP) {
        factor();
      } else {
        modolo();
      }
    } 
    System.out.println("Exit <term>");
  }

  public void factor() {
    System.out.println("Enter <factor>");
    if (front.nextToken == front.IDENT || front.nextToken == front.INT_LIT) { 
      front.lex();
    } else {
      if (front.nextToken == front.LEFT_PAREN) {
      front.lex();
      expr();
      if (front.nextToken == front.RIGHT_PAREN) {
        front.lex();
      } else {
        error();
      }
      }
    else
		  error();
    }
    System.out.println("Exit <factor>");
  }

  public void modolo() {
    System.out.println("Enter <modolo>");
    if (front.nextToken == front.IDENT || front.nextToken == front.INT_LIT) {
      front.lex();
    } else {
      if (front.nextToken == front.LEFT_PAREN) {
      front.lex();
      expr();
      if(front.nextToken == front.RIGHT_PAREN) {
        front.lex();
      } else {
        error();
      }
      }
    else
		  error();
    }
    System.out.println("Exit <modolo>");
  }

  public void error() {
    if (front.token == front.INT_LIT || front.token == front.IDENT) {
      System.out.println("Error - Expected \"(\" or \")\"");
    } else {
      System.out.println("ERROR - Expected int");
    }
  }
}