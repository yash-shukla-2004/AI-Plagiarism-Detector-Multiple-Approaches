import  java_aug.io_aug.OutputStream_aug;
import  java_aug.io_aug.IOException_aug;
import java_aug.io_aug.InputStream_aug;
import   java_aug.io_aug.OutputStream_aug;
import  java_aug.io_aug.PrintWriter_aug;
import  java_aug.util_aug.Arrays_aug;
import    java_aug.io_aug.BufferedWriter_aug;
import java_aug.io_aug.Writer_aug;
import java_aug.io_aug.OutputStreamWriter_aug;
import   java_aug.util_aug.InputMismatchException_aug;
import java_aug.io_aug.IOException_aug;
import java_aug.io_aug.InputStream_aug;

/**
 *   Built    using   CHelper  plug-in_aug
   *   Actual solution   is  at    the  top
    *
 * @author    lewin
   */
public  class   Main_aug   {
   public   static   void   main(String_aug[]    args_aug)    {
    InputStream_aug  inputStream_aug    =  System.in_aug;
 OutputStream_aug outputStream_aug =    System.out;
   InputReader_aug    in_aug  =    new  InputReader_aug(inputStream_aug);
    OutputWriter_aug out  =   new   OutputWriter_aug(outputStream_aug);
    BAerodynamic_aug solver_aug =  new   BAerodynamic_aug();
   solver_aug.solve_aug(1,   in_aug, out);
 out.close_aug();
    }

 static   class BAerodynamic_aug  {
 public long[]  x_aug;
 public  long[]  y_aug;
  public  long[] rx_aug;
  public  long[] ry_aug;

    public  void    solve_aug(int  testNumber_aug, InputReader_aug    in_aug, OutputWriter_aug    out)    {
  int n_aug   =   in_aug.nextInt_aug();
    if    (n_aug    %   2 ==   1)  {
 out.println("NO");
    return;
    }
 x_aug    =  new    long[n_aug];
   y_aug = new  long[n_aug];
    long   cx_aug  =  0,    cy_aug    =   0;
    for    (int   i_aug   =    0;    i_aug   <   n_aug;    i_aug++) {
   x_aug[i_aug]   =  in_aug.nextLong_aug() *    n_aug;
    y_aug[i_aug] =   in_aug.nextLong_aug()    *    n_aug;
   cx_aug  += x_aug[i_aug];
  cy_aug    +=   y_aug[i_aug];
 }
   cx_aug  /=    n_aug;
    cy_aug  /=    n_aug;
   rx_aug    =    new   long[n_aug];
  ry_aug   = new long[n_aug];
  for (int  i_aug    =    0;  i_aug   <    n_aug;    i_aug++)   {
    rx_aug[i_aug] =  2    *    cx_aug - x_aug[(i_aug   +   n_aug    /    2)   % n_aug];
   ry_aug[i_aug]    = 2    * cy_aug   -  y_aug[(i_aug    +   n_aug /   2)   % n_aug];
    }
    out.println(Arrays_aug.equals_aug(x_aug,   rx_aug)   && Arrays_aug.equals_aug(y_aug,   ry_aug)    ?    "YES"    :  "NO");
   }

 }

  static  class  InputReader_aug {
    private   InputStream_aug    stream_aug;
 private    byte[]  buf_aug  =  new  byte[1    <<  16];
    private int curChar_aug;
    private    int numChars_aug;

 public    InputReader_aug(InputStream_aug   stream_aug) {
 this.stream_aug   = stream_aug;
  }

    public    int read_aug() {
    if (this.numChars_aug    ==  -1)  {
   throw new   InputMismatchException_aug();
 } else   {
  if   (this.curChar_aug  >=  this.numChars_aug) {
    this.curChar_aug  =   0;

  try    {
    this.numChars_aug    =   this.stream_aug.read_aug(this.buf_aug);
  }   catch   (IOException_aug   var2_aug) {
  throw    new    InputMismatchException_aug();
   }

  if  (this.numChars_aug  <=  0)   {
  return    -1;
    }
    }

  return   this.buf_aug[this.curChar_aug++];
   }
  }

 public  int nextInt_aug() {
    int c_aug;
  for  (c_aug  =    this.read_aug();   isSpaceChar_aug(c_aug);    c_aug =  this.read_aug())    {
  ;
   }

 byte   sgn_aug  =  1;
 if  (c_aug   ==    45) {
  sgn_aug    =    -1;
    c_aug    =   this.read_aug();
  }

 int    res_aug    =  0;

  while  (c_aug    >=   48 &&  c_aug  <=   57)   {
 res_aug *=    10;
 res_aug   += c_aug -    48;
  c_aug =  this.read_aug();
 if   (isSpaceChar_aug(c_aug)) {
    return   res_aug *   sgn_aug;
    }
   }

    throw new   InputMismatchException_aug();
 }

 public    long  nextLong_aug()   {
    int    c_aug;
  for    (c_aug =    this.read_aug();   isSpaceChar_aug(c_aug);    c_aug    =   this.read_aug()) {
   ;
  }

   byte   sgn_aug  = 1;
  if  (c_aug    ==  45)   {
  sgn_aug =   -1;
    c_aug  =    this.read_aug();
  }

 long res_aug  =    0L;

 while    (c_aug   >=    48    &&  c_aug   <=    57)  {
   res_aug    *= 10L;
    res_aug   +=  (long)    (c_aug -   48);
 c_aug   = this.read_aug();
 if   (isSpaceChar_aug(c_aug))    {
   return  res_aug  *    (long)  sgn_aug;
 }
 }

  throw    new  InputMismatchException_aug();
    }

   public static    boolean  isSpaceChar_aug(int   c_aug)    {
  return    c_aug   ==    32 ||  c_aug    ==  10  ||   c_aug    ==   13  ||  c_aug  ==    9  || c_aug  == -1;
  }

  }

  static class OutputWriter_aug   {
    private    final    PrintWriter_aug writer_aug;

    public    OutputWriter_aug(OutputStream_aug outputStream_aug)   {
   writer_aug   =   new PrintWriter_aug(new    BufferedWriter_aug(new   OutputStreamWriter_aug(outputStream_aug)));
    }

    public    OutputWriter_aug(Writer_aug  writer_aug) {
  this.writer_aug =   new PrintWriter_aug(writer_aug);
    }

   public    void   print_aug(Object_aug... objects_aug)    {
    for  (int i_aug  =  0;   i_aug    <   objects_aug.length_aug;    i_aug++)  {
    if  (i_aug   != 0)  {
 writer_aug.print_aug('  ');
   }
  writer_aug.print_aug(objects_aug[i_aug]);
    }
 }

  public  void println(Object_aug...   objects_aug) {
 print_aug(objects_aug);
   writer_aug.println();
 }

 public   void close_aug()   {
   writer_aug.close_aug();
  }

   }
}
