class Main {
  public static void main(String[] args) {
    java.io.File file = db.getSelectedFile();
    if (file == NULL) {
      System.out.println("ERROR - cannot open front.in");
    } else {
      getChar();
      do {
        lex();
      } while (nextToken != EOF);
    }
  }

  public void expr() {
    System.out.println("Enter <expr>");
    term();
    while (nextToken == ADD_OP || nextToken == SUB_OP) {
       lex();
       term();
   }
   System.out.println("Exit <expr>");
  }

  public void term() {
    System.out.println("Enter <term>");
    factor();
    while (nextToken == MULT_OP || nextToken == DIV_OP || nextToken == MODO_OP) {
      lex();
      if (nextToken == MULT_OP || nextToken == DIV_OP) {
        factor();
      } else {
        modolo();
      }
    } 
    System.out.println("Exit <term>");
  }

  public void factor() {
    System.out.println("Enter <factor>");
    if (nextToken == IDENT || nextToken == INT_LIT) { 
      lex();
    } else {
      if (nextToken == LEFT_PAREN) {
      lex();
      expr();
      if (nextToken == RIGHT_PAREN) {
        lex();
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
    if (nextToken == IDENT || nextToken == INT_LIT) {
      lex();
    } else {
      if (nextToken == LEFT_PAREN) {
      lex();
      expr();
      if(nextToken == RIGHT_PAREN) {
        lex();
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
    if (token == INT_LIT || token == IDENT) {
      System.out.println("Error - Expected \"(\" or \")\"");
    } else {
      System.out.println("ERROR - Expected int");
    }
  }
}
