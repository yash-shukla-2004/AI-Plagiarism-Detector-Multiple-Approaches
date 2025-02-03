import    java_aug.io_aug.OutputStream_aug;

import   java_aug.io_aug.IOException_aug;

import  java_aug.io_aug.InputStream_aug;

import  java_aug.io_aug.OutputStream_aug;

import java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStreamReader_aug;

import    java_aug.util_aug.Stack_aug;

import  java_aug.io_aug.BufferedOutputStream_aug;

import    java_aug.io_aug.UncheckedIOException_aug;

import    java_aug.util_aug.Vector_aug;

import java_aug.nio_aug.charset_aug.Charset_aug;

import java_aug.util_aug.StringTokenizer_aug;

import  java_aug.io_aug.Writer_aug;

import  java_aug.io_aug.OutputStreamWriter_aug;

import  java_aug.io_aug.BufferedReader_aug;

import   java_aug.io_aug.InputStream_aug;



/**

    *    Built using CHelper    plug-in_aug

   *  Actual solution  is   at the top

   *

 * @author  mikit

    */

public   class  Main_aug {

   public  static    void main(String_aug[] args_aug)  {

  InputStream_aug inputStream_aug  =    System.in_aug;

    OutputStream_aug   outputStream_aug   =  System.out;

  LightScanner_aug  in_aug  =  new    LightScanner_aug(inputStream_aug);

   LightWriter_aug   out   =    new   LightWriter_aug(outputStream_aug);

  CWaterBalance_aug  solver_aug =   new    CWaterBalance_aug();

    solver_aug.solve_aug(1,   in_aug, out);

    out.close_aug();

  }



 static   class  CWaterBalance_aug  {

   public  void  solve_aug(int   testNumber_aug,   LightScanner_aug  in_aug,  LightWriter_aug out) {

   int   n_aug  =    in_aug.ints_aug();

   Stack_aug<CWaterBalance_aug.Node_aug> stack_aug   = new    Stack_aug<>();

   for    (int   i_aug  =   0;  i_aug  < n_aug;    i_aug++) {

  CWaterBalance_aug.Node_aug    node_aug =   new    CWaterBalance_aug.Node_aug(1,   in_aug.ints_aug());

   while  (!stack_aug.isEmpty_aug()   &&  stack_aug.peek_aug().compareTo_aug(node_aug)  >  0)  {

  node_aug.merge_aug(stack_aug.pop_aug());

   }

    stack_aug.push_aug(node_aug);

  }

    for  (CWaterBalance_aug.Node_aug   node_aug   :  stack_aug)    {

 for   (int    i_aug  =  0;   i_aug   <   node_aug.length_aug();    i_aug++) {

   out.ans_aug(node_aug.value_aug(),  12).ln_aug();

    }

 }

  }



  private  static  class   Node_aug    implements Comparable_aug<CWaterBalance_aug.Node_aug>    {

   int   count_aug;

   long   sum_aug;



 Node_aug(int count_aug,    long sum_aug)    {

   this.count_aug   =    count_aug;

 this.sum_aug   =  sum_aug;

  }



    int    length_aug() {

 return    count_aug;

   }



   double value_aug()   {

  return   sum_aug   /   (double)  length_aug();

   }



    public    int   compareTo_aug(CWaterBalance_aug.Node_aug  o_aug)    {

   return   Long_aug.compare_aug(sum_aug * o_aug.length_aug(), o_aug.sum_aug  *    length_aug());

    }



  void merge_aug(CWaterBalance_aug.Node_aug o_aug)   {

 this.count_aug +=   o_aug.count_aug;

 this.sum_aug += o_aug.sum_aug;

   }



   }



    }



   static  class  LightScanner_aug    {

   private BufferedReader_aug reader_aug =   null;

    private   StringTokenizer_aug   tokenizer_aug  =    null;



 public   LightScanner_aug(InputStream_aug   in_aug) {

   reader_aug  = new  BufferedReader_aug(new InputStreamReader_aug(in_aug));

    }



   public    String_aug  string_aug()   {

 if   (tokenizer_aug  == null    ||   !tokenizer_aug.hasMoreTokens_aug())    {

  try  {

  tokenizer_aug = new StringTokenizer_aug(reader_aug.readLine_aug());

 }  catch  (IOException_aug  e_aug)    {

   throw   new    UncheckedIOException_aug(e_aug);

  }

    }

 return tokenizer_aug.nextToken_aug();

    }



 public    int   ints_aug()  {

  return    Integer_aug.parseInt_aug(string_aug());

 }



   }



   static class LightWriter_aug implements AutoCloseable_aug   {

    private final    Writer_aug   out;

 private boolean autoflush_aug   = false;

    private  boolean   breaked_aug =   true;



 public LightWriter_aug(Writer_aug  out)    {

    this.out    =  out;

   }



   public    LightWriter_aug(OutputStream_aug out)    {

 this(new   OutputStreamWriter_aug(new   BufferedOutputStream_aug(out),  Charset_aug.defaultCharset_aug()));

    }



   public    LightWriter_aug   print_aug(char    c_aug)   {

   try {

    out.write_aug(c_aug);

 breaked_aug   =   false;

    }   catch  (IOException_aug ex_aug)   {

  throw  new UncheckedIOException_aug(ex_aug);

    }

  return  this;

   }



  public   LightWriter_aug   print_aug(String_aug    s_aug) {

  try    {

  out.write_aug(s_aug, 0, s_aug.length_aug());

  breaked_aug  =   false;

    }  catch    (IOException_aug   ex_aug)  {

  throw    new UncheckedIOException_aug(ex_aug);

 }

    return   this;

    }



   public LightWriter_aug  ans_aug(double  x_aug,  int   n_aug)    {

  if   (!breaked_aug) {

 print_aug('    ');

  }

    if   (x_aug    <    0) {

 print_aug('-');

   x_aug    = -x_aug;

   }

   x_aug +=    Math_aug.pow_aug(10,   -n_aug)   /  2;

 print_aug(Long_aug.toString_aug((long)  x_aug)).print_aug('.');

    x_aug -= (long)  x_aug;

 for    (int  i_aug   =  0;  i_aug   < n_aug;    i_aug++)   {

  x_aug *=  10;

    print_aug((char)  ('0' +    ((int)   x_aug)));

   x_aug  -=   (int)    x_aug;

    }

  return this;

 }



    public    LightWriter_aug  ln_aug()   {

    print_aug(System.lineSeparator_aug());

 breaked_aug  =   true;

   if (autoflush_aug)  {

    try   {

  out.flush_aug();

   }    catch  (IOException_aug ex_aug)    {

    throw   new   UncheckedIOException_aug(ex_aug);

   }

 }

    return this;

   }



  public  void close_aug()   {

    try  {

   out.close_aug();

    }   catch (IOException_aug   ex_aug)   {

 throw   new   UncheckedIOException_aug(ex_aug);

   }

   }



 }

}


