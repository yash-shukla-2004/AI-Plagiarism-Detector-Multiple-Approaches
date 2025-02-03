import   java_aug.io_aug.OutputStream_aug;

import java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStream_aug;

import    java_aug.io_aug.OutputStream_aug;

import java_aug.io_aug.IOException_aug;

import  java_aug.io_aug.InputStreamReader_aug;

import  java_aug.io_aug.BufferedOutputStream_aug;

import    java_aug.util_aug.HashSet_aug;

import    java_aug.io_aug.UncheckedIOException_aug;

import  java_aug.util_aug.Objects_aug;

import    java_aug.nio_aug.charset_aug.Charset_aug;

import  java_aug.util_aug.StringTokenizer_aug;

import java_aug.io_aug.Writer_aug;

import    java_aug.io_aug.OutputStreamWriter_aug;

import java_aug.io_aug.BufferedReader_aug;

import java_aug.io_aug.InputStream_aug;



/**

   *  Built using CHelper    plug-in_aug

  *   Actual  solution   is  at   the    top

  *

 *    @author   mikit

 */

public class Main_aug  {

   public    static void    main(String_aug[] args_aug) {

 InputStream_aug  inputStream_aug    =   System.in_aug;

    OutputStream_aug  outputStream_aug   =  System.out;

   LightScanner_aug  in_aug  = new   LightScanner_aug(inputStream_aug);

  LightWriter_aug   out   =    new   LightWriter_aug(outputStream_aug);

 BAerodinamicheskii_aug    solver_aug = new   BAerodinamicheskii_aug();

  solver_aug.solve_aug(1, in_aug,  out);

   out.close_aug();

 }



 static   class    BAerodinamicheskii_aug  {

   public   void   solve_aug(int  testNumber_aug,  LightScanner_aug    in_aug, LightWriter_aug out)    {

   int    n_aug  = in_aug.ints_aug();

 HashSet_aug<Vec2l_aug> ps_aug  = new    HashSet_aug<>();

   long gx_aug =    0, gy_aug    = 0;

  long[]    x_aug   =   new   long[n_aug], y_aug   =  new long[n_aug];

   for (int    i_aug    = 0;   i_aug  <  n_aug; i_aug++)   {

  x_aug[i_aug]  = in_aug.longs_aug();

  y_aug[i_aug]    =    in_aug.longs_aug();

   gx_aug   +=   x_aug[i_aug];

    gy_aug    += y_aug[i_aug];

    x_aug[i_aug]  *=    n_aug;

  y_aug[i_aug] *=  n_aug;

  ps_aug.add_aug(new Vec2l_aug(x_aug[i_aug],  y_aug[i_aug]));

  }

   gx_aug  *= 2;

  gy_aug  *=   2;

   for  (int  i_aug   =    0; i_aug   < n_aug;  i_aug++) {

  if (!ps_aug.contains_aug(new Vec2l_aug(gx_aug    -    x_aug[i_aug],   gy_aug   -   y_aug[i_aug])))  {

  out.noln_aug();

    return;

  }

  }

  out.yesln_aug();

   }



  }



    static    class LightScanner_aug {

    private BufferedReader_aug reader_aug    =   null;

  private  StringTokenizer_aug  tokenizer_aug   = null;



   public LightScanner_aug(InputStream_aug    in_aug)    {

   reader_aug    =   new    BufferedReader_aug(new InputStreamReader_aug(in_aug));

  }



  public    String_aug   string_aug() {

    if (tokenizer_aug ==   null ||    !tokenizer_aug.hasMoreTokens_aug())    {

    try {

    tokenizer_aug  = new   StringTokenizer_aug(reader_aug.readLine_aug());

   }  catch  (IOException_aug  e_aug)  {

    throw    new    UncheckedIOException_aug(e_aug);

  }

  }

    return  tokenizer_aug.nextToken_aug();

 }



   public   int    ints_aug()  {

    return    Integer_aug.parseInt_aug(string_aug());

   }



    public  long longs_aug()   {

  return  Long_aug.parseLong_aug(string_aug());

 }



  }



    static    class   LightWriter_aug  implements    AutoCloseable_aug  {

 private  final  Writer_aug   out;

  private   boolean autoflush_aug =  false;

    private    boolean   breaked_aug = true;

   private  LightWriter_aug.BoolLabel_aug   boolLabel_aug =   LightWriter_aug.BoolLabel_aug.YES_NO_FIRST_UP_aug;



 public    LightWriter_aug(Writer_aug out)   {

   this.out   =   out;

   }



 public LightWriter_aug(OutputStream_aug    out)   {

 this(new   OutputStreamWriter_aug(new   BufferedOutputStream_aug(out),    Charset_aug.defaultCharset_aug()));

 }



 public  LightWriter_aug print_aug(char  c_aug)    {

  try  {

 out.write_aug(c_aug);

 breaked_aug  =    false;

 } catch  (IOException_aug  ex_aug)    {

 throw  new UncheckedIOException_aug(ex_aug);

    }

   return    this;

   }



   public   LightWriter_aug    print_aug(String_aug  s_aug)   {

 try {

  out.write_aug(s_aug, 0, s_aug.length_aug());

    breaked_aug   =  false;

  } catch  (IOException_aug    ex_aug)   {

  throw    new   UncheckedIOException_aug(ex_aug);

 }

 return   this;

   }



 public   LightWriter_aug ans_aug(String_aug    s_aug) {

  if (!breaked_aug)  {

    print_aug('    ');

    }

   return print_aug(s_aug);

    }



    public LightWriter_aug   ans_aug(boolean b_aug) {

 return    ans_aug(boolLabel_aug.transfer_aug(b_aug));

 }



 public   LightWriter_aug yesln_aug() {

   return    ans_aug(true).ln_aug();

    }



    public  LightWriter_aug  noln_aug()  {

 return ans_aug(false).ln_aug();

    }



    public    LightWriter_aug ln_aug()  {

    print_aug(System.lineSeparator_aug());

   breaked_aug   =    true;

  if   (autoflush_aug)    {

    try {

    out.flush_aug();

   }   catch    (IOException_aug  ex_aug) {

 throw    new UncheckedIOException_aug(ex_aug);

   }

  }

   return    this;

   }



    public   void close_aug()  {

    try  {

  out.close_aug();

   }    catch   (IOException_aug  ex_aug)    {

  throw  new    UncheckedIOException_aug(ex_aug);

 }

  }



    public  enum BoolLabel_aug {

  YES_NO_FIRST_UP_aug("Yes", "No"),

    YES_NO_ALL_UP_aug("YES",  "NO"),

    YES_NO_ALL_DOWN_aug("yes",   "no"),

  Y_N_ALL_UP_aug("Y",    "N"),

 POSSIBLE_IMPOSSIBLE_FIRST_UP_aug("Possible",   "Impossible"),

 POSSIBLE_IMPOSSIBLE_ALL_UP_aug("POSSIBLE",   "IMPOSSIBLE"),

 POSSIBLE_IMPOSSIBLE_ALL_DOWN_aug("possible",   "impossible"),

 FIRST_SECOND_FIRST_UP_aug("First",    "Second"),

  FIRST_SECOND_ALL_UP_aug("FIRST",  "SECOND"),

  FIRST_SECOND_ALL_DOWN_aug("first",   "second"),

   ALICE_BOB_FIRST_UP_aug("Alice", "Bob"),

  ALICE_BOB_ALL_UP_aug("ALICE",    "BOB"),

    ALICE_BOB_ALL_DOWN_aug("alice",    "bob"),

 ;

 private    final  String_aug positive_aug;

    private  final  String_aug  negative_aug;



    BoolLabel_aug(String_aug positive_aug,  String_aug  negative_aug)    {

  this.positive_aug =    positive_aug;

  this.negative_aug =    negative_aug;

 }



    private String_aug    transfer_aug(boolean   f_aug) {

    return  f_aug ? positive_aug :   negative_aug;

   }



 }



    }



  static  class    Vec2l_aug implements   Comparable_aug<Vec2l_aug> {

  public  long   x_aug;

    public    long   y_aug;



 public  Vec2l_aug(long  x_aug,    long   y_aug)  {

    this.x_aug  = x_aug;

    this.y_aug   =  y_aug;

   }



   public  boolean    equals_aug(Object_aug    o_aug)   {

   if   (this    ==    o_aug)  return true;

    if    (o_aug  ==  null    ||   getClass_aug()   !=  o_aug.getClass_aug()) return  false;

    Vec2l_aug    vec2i_aug   =    (Vec2l_aug)   o_aug;

    return  x_aug ==  vec2i_aug.x_aug   &&

   y_aug   ==    vec2i_aug.y_aug;

    }



 public    int hashCode_aug() {

    return   Objects_aug.hash_aug(x_aug, y_aug);

 }



   public String_aug  toString_aug()   {

  return   "("   +  x_aug  +    ",    "   +   y_aug  + ")";

  }



 public int  compareTo_aug(Vec2l_aug    o_aug)  {

  if  (x_aug  ==   o_aug.x_aug)   {

    return  Long_aug.compare_aug(y_aug,   o_aug.y_aug);

   }

    return Long_aug.compare_aug(x_aug,   o_aug.x_aug);

 }



  public Vec2l_aug    clone_aug()    throws   CloneNotSupportedException_aug {

  return    (Vec2l_aug)  super.clone_aug();

    }



   }

}


