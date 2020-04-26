import java.io.FileInputStream;
import java.io.*;
import java.lang.*;
import java.util.Scanner;


public class Main{


    static int charClass;
    static char[] lexeme = new char[100];
    static char nextChar;
    static int lexLen;
    static int token;
    static int nextToken;
    static File in_fp;
    static FileReader fr;
    static BufferedReader file;

    static int LETTER = 0;
    static int DIGIT = 1;
    static int UNKNOWN = 99;

    static int INT_LIT = 10;
    static int IDENT = 11;
    static int ASSIGN_OP = 20;
    static int ADD_OP = 21;
    static int SUB_OP = 22;
    static int MULT_OP = 23;
    static int DIV_OP = 24;
    static int MODO_OP = 25;
    static int LEFT_PAREN = 26;
    static int RIGHT_PAREN = 27;
    static int NULL = -1;
    

  

  public static void main(String[] args) throws IOException {
    in_fp = new File("front.in");
    fr = new FileReader(in_fp);
    file = new BufferedReader(fr);
    if (file == null)
      System.out.println("ERROR - cannot open front.in");
    else {
      getChar();
      do {
        lex();
      } while (nextToken != NULL);
    }

  }

  public static int lookup(char ch) {
    switch (ch) {
      case '(':
        addChar();
        nextToken = LEFT_PAREN;
        break;
      case ')':
        addChar();
        nextToken = RIGHT_PAREN;
        break;
      case '+':
        addChar();
        nextToken = ADD_OP;
        break;
      case '-':
        addChar();
        nextToken = SUB_OP;
        break;
      case '*':
        addChar();
        nextToken = MULT_OP;
        break;
      case '/':
        addChar();
        nextToken = DIV_OP;
        break;
      default:
        addChar();
        nextToken = NULL;
        break;
    }
    return nextToken;
  }

  public static void addChar() {
    if (lexLen <= 98) {
      lexeme[lexLen++] = nextChar;
      lexeme[lexLen] = '\0';
    } else
    System.out.println("Error - lexeme is too long ");
  }


  public static void getChar() {
    try (char character = (char) file.read()) {
      nextChar = character;
      if (nextChar != NULL) {
        if (Character.isLetter(nextChar))
          charClass = LETTER;
        else if (Character.isDigit(nextChar))
          charClass = DIGIT;
        else
          charClass = UNKNOWN;
      } else
      charClass = NULL;
    } catch (IOException e) {}
  }

  public static void getNonBlank() {
    while (Character.isSpace(nextChar))
    getChar();
  }

  public static int lex() {
    lexLen = 0;
    getNonBlank();
    switch (charClass) {
      case 0:
        addChar();
        getChar();
        while (charClass == LETTER || charClass == DIGIT) {
          addChar();
          getChar();
        }
        nextToken = IDENT;
        break;
      case 1:
        addChar();
        getChar();
        while (charClass == DIGIT) {
          addChar();
          getChar();
        }
        nextToken = INT_LIT;
        break;
      case 99:
        lookup(nextChar);
        getChar();
        break;
      case -1:
        nextToken = NULL;
        lexeme[0] = 'E';
        lexeme[1] = 'O';
        lexeme[2] = 'F';
        lexeme[3] = '\0';
        break;
    }
    String lexemeString = new String(lexeme);
    System.out.println("Next token is: " + nextToken + ", Next lexeme is " +  lexemeString);
    return nextToken;
  }

}