import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/* Generated By:JavaCC: Do not edit this line. lexer.java */
class lexer implements lexerConstants {
	
	public static ArrayList<Identificador> Identificadores = new ArrayList<>();
        public static void main(String[] args) throws ParseException, FileNotFoundException
        {
                try
                {
                        lexer analizador=new lexer(new FileInputStream("src/prueba.txt"));
                        //analizador.Start();
                        analizador.programa();
                        for (Identificador v : Identificadores){
                        	System.out.println("Nombre: "+v.getNombre()+
                        			", Tipo: "+v.getTipo()+
                        			", Uso: "+v.getUso()+
                        			", TipoDato: "+v.getTipoDato()+
                        			", Modificador: "+v.getModificador()+
                        			", Valor: "+v.getValor());
                        }
                        System.out.println("La cadena fu\u00e9 aceptada");
                }
                catch(ParseException e)
                {
                        System.out.println(e.getMessage());
                        //system.out.println("Se han encontrado errores, fall� al compilar");
                }
        }

  static final public void programa() throws ParseException {
    try {
    	Identificador temp = new Identificador();
    	temp.setTipo("Clase");
    	temp.setUso("Declaracion");
      jj_consume_token(MODIFIER);
      temp.setModificador(getCurToken());
      jj_consume_token(CLASS);
      jj_consume_token(IDENTIFIER);
      temp.setNombre(getCurToken());
      Identificadores.add(temp);
      jj_consume_token(LBRACE);
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MODIFIER:
        case IF:
        case WHILE:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MODIFIER:
          variable_declaration();
          break;
        case IF:
        case WHILE:
          statement();
          break;
        default:
          jj_la1[1] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      jj_consume_token(RBRACE);
    } catch (ParseException e) {
                System.out.println("Error de Sintaxis");
                System.out.println(e.toString());
    }
  }

/*M�todos para field_declaration*/
  static final public void field_declaration() throws ParseException {
    variable_declaration();
  }

  static final public void variable_declaration() throws ParseException {
	  Identificador temp = new Identificador();
  	temp.setTipo("Variable");
  	temp.setUso("Declaracion");
    jj_consume_token(MODIFIER);
    temp.setModificador(getCurToken());
    type();
    temp.setTipoDato(getCurToken());
    variable_declarator(temp);
    jj_consume_token(SEMICOLON);
  }

  static final public void type() throws ParseException {
    jj_consume_token(TYPE_SPECIFIER);
  }

  static final public void variable_declarator(Identificador temp) throws ParseException {
    jj_consume_token(IDENTIFIER);
		temp.setNombre(getCurToken());
    jj_consume_token(ASSIGN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      jj_consume_token(INTEGER_LITERAL);
      temp.setValor(getCurToken());
      break;
    case BOOLEAN_LITERAL:
      jj_consume_token(BOOLEAN_LITERAL);
      temp.setValor(getCurToken());
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    Identificadores.add(temp);
  }

/*Metodos para statement*/
  static final public void statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MODIFIER:
      variable_declaration();
      break;
    case IF:
      if_statement();
      break;
    case WHILE:
      while_statement();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void if_statement() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(LPAREN);
    expression();
    jj_consume_token(RPAREN);
    statement();
  }

  static final public void while_statement() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    expression();
    jj_consume_token(RPAREN);
    statement();
  }

  static final public void expression() throws ParseException {
    testing_expression();
  }

  static final public void testing_expression() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      jj_consume_token(INTEGER_LITERAL);
      break;
    case IDENTIFIER:
    	Identificador temp = new Identificador();
      jj_consume_token(IDENTIFIER);
    	temp.setTipo("Variable");
      	temp.setUso("Comparacion");
      	temp.setNombre(getCurToken());
      	Identificadores.add(temp);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(EXPRESSION);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      jj_consume_token(INTEGER_LITERAL);
      break;
    case IDENTIFIER:
      jj_consume_token(IDENTIFIER);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void artimetica_expression() throws ParseException {
    jj_consume_token(IDENTIFIER);
    jj_consume_token(ASSIGN);
    jj_consume_token(INTEGER_LITERAL);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
      break;
    case MINUS:
      jj_consume_token(MINUS);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(INTEGER_LITERAL);
    jj_consume_token(SEMICOLON);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public lexerTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x320,0x320,0x180000,0x320,0x280000,0x280000,0x60000,};
   }

  /** Constructor with InputStream. */
  public lexer(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public lexer(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new lexerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public lexer(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new lexerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public lexer(lexerTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(lexerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  static final public String getCurToken(){
	  return lexerTokenManager.getCurrentToken();
  }
  
/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[22];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 22; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
