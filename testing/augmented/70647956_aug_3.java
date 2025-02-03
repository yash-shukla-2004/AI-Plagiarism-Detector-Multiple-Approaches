import java_aug.io_aug.OutputStream_aug;
import java_aug.io_aug.IOException_aug;
import    java_aug.io_aug.InputStream_aug;
import java_aug.io_aug.OutputStream_aug;
import    java_aug.io_aug.PrintWriter_aug;
import   java_aug.io_aug.BufferedWriter_aug;
import   java_aug.io_aug.Writer_aug;
import  java_aug.io_aug.OutputStreamWriter_aug;
import   java_aug.util_aug.InputMismatchException_aug;
import    java_aug.io_aug.IOException_aug;
import  java_aug.io_aug.InputStream_aug;

/**
 * Built   using CHelper   plug-in_aug
    *    Actual   solution   is   at    the   top
 *
  *   @author   lewin
    */
public   class  Main_aug  {
   public static   void main(String_aug[]   args_aug)    {
  InputStream_aug  inputStream_aug =   System.in_aug;
 OutputStream_aug   outputStream_aug  =  System.out;
  InputReader_aug    in_aug    =   new   InputReader_aug(inputStream_aug);
 OutputWriter_aug out =    new   OutputWriter_aug(outputStream_aug);
  CWaterBalance_aug    solver_aug   = new CWaterBalance_aug();
   solver_aug.solve_aug(1,   in_aug,  out);
    out.close_aug();
  }

    static    class   CWaterBalance_aug    {
    long ccw_aug(CWaterBalance_aug.Point_aug a_aug,    CWaterBalance_aug.Point_aug    b_aug,  CWaterBalance_aug.Point_aug    c_aug)   {
 long    dx1_aug  =    b_aug.x_aug - a_aug.x_aug;
   long dy1_aug    =  b_aug.y_aug - a_aug.y_aug;
  long dx2_aug    =  c_aug.x_aug    -   a_aug.x_aug;
    long  dy2_aug   =  c_aug.y_aug  - a_aug.y_aug;
   return   dx1_aug   *  dy2_aug -    dy1_aug    *    dx2_aug;
 }

  public void solve_aug(int testNumber_aug,  InputReader_aug    in_aug,  OutputWriter_aug    out) {
 int   n_aug    =    in_aug.nextInt_aug();
    int[] arr_aug =  in_aug.readIntArray_aug(n_aug);
    long[] h_aug  = new    long[n_aug    +    1];
    for (int    i_aug   =   1;    i_aug   <= n_aug;    i_aug++) {
  h_aug[i_aug]  =    h_aug[i_aug    -    1] +   arr_aug[i_aug  -    1];
    }

    CWaterBalance_aug.Point_aug[]  v_aug =    new   CWaterBalance_aug.Point_aug[n_aug +   1];
   int sidx_aug =  0;
    for  (int i_aug    =   0;    i_aug <=   n_aug;    i_aug++) {
    CWaterBalance_aug.Point_aug add_aug   =  new    CWaterBalance_aug.Point_aug(i_aug,  h_aug[i_aug]);
    while (sidx_aug  >=   2    &&   ccw_aug(v_aug[sidx_aug    -   2],  v_aug[sidx_aug    - 1], add_aug)   <= 0) sidx_aug--;
   v_aug[sidx_aug++]   =  add_aug;
   }
  for  (int i_aug    =    1;    i_aug    < sidx_aug;  i_aug++)   {
  double  pr_aug    =    1.0  *    (v_aug[i_aug].y_aug - v_aug[i_aug   -  1].y_aug)    /  (v_aug[i_aug].x_aug -  v_aug[i_aug    -   1].x_aug);
    for  (int  j_aug  =  (int)    v_aug[i_aug    -   1].x_aug; j_aug   < v_aug[i_aug].x_aug;   j_aug++)    {
 out.printf_aug("%.10f\n_aug",  pr_aug);
  }
   }
   }

    static    class Point_aug   {
    public    long   x_aug;
   public long   y_aug;

 public  Point_aug(long    x_aug,   long    y_aug)   {
   this.x_aug   =  x_aug;
  this.y_aug    =  y_aug;
   }

   public String_aug  toString_aug() {
 return    "Point_aug{"    +
   "x_aug=" +   x_aug  +
   ",  y_aug="    +   y_aug +
   '}';
  }

   }

    }

  static  class   InputReader_aug   {
    private  InputStream_aug   stream_aug;
    private   byte[]    buf_aug =    new    byte[1   <<    16];
   private    int   curChar_aug;
   private int numChars_aug;

  public  InputReader_aug(InputStream_aug    stream_aug)    {
   this.stream_aug = stream_aug;
    }

   public  int[]  readIntArray_aug(int    tokens_aug)   {
  int[]  ret_aug   =    new  int[tokens_aug];
   for (int   i_aug  =   0;    i_aug    <    tokens_aug;    i_aug++) {
 ret_aug[i_aug]  =  nextInt_aug();
    }
  return  ret_aug;
   }

  public   int  read_aug() {
  if    (this.numChars_aug   ==  -1) {
 throw  new   InputMismatchException_aug();
   } else   {
    if   (this.curChar_aug >=  this.numChars_aug)  {
  this.curChar_aug  =    0;

    try    {
  this.numChars_aug  = this.stream_aug.read_aug(this.buf_aug);
   }   catch (IOException_aug var2_aug)  {
  throw  new  InputMismatchException_aug();
 }

   if    (this.numChars_aug <=  0)   {
   return   -1;
   }
  }

   return   this.buf_aug[this.curChar_aug++];
    }
   }

    public    int  nextInt_aug() {
  int  c_aug;
  for (c_aug =   this.read_aug();    isSpaceChar_aug(c_aug);   c_aug =   this.read_aug())   {
   ;
    }

    byte  sgn_aug   = 1;
    if (c_aug    == 45)  {
   sgn_aug =  -1;
   c_aug =   this.read_aug();
    }

   int   res_aug   = 0;

   while (c_aug    >= 48 &&  c_aug  <=   57) {
 res_aug    *=  10;
   res_aug    +=   c_aug -  48;
  c_aug   =   this.read_aug();
   if  (isSpaceChar_aug(c_aug))  {
 return   res_aug    *   sgn_aug;
  }
    }

    throw  new  InputMismatchException_aug();
   }

  public  static    boolean    isSpaceChar_aug(int   c_aug)  {
    return    c_aug  ==  32 ||   c_aug  == 10  || c_aug  == 13   ||   c_aug   == 9 || c_aug  ==  -1;
    }

 }

   static  class   OutputWriter_aug {
  private   final  PrintWriter_aug writer_aug;

   public   OutputWriter_aug(OutputStream_aug   outputStream_aug)  {
    writer_aug    =    new   PrintWriter_aug(new  BufferedWriter_aug(new   OutputStreamWriter_aug(outputStream_aug)));
 }

  public  OutputWriter_aug(Writer_aug writer_aug)  {
   this.writer_aug    =  new PrintWriter_aug(writer_aug);
    }

 public    void   printf_aug(String_aug format_aug,  Object_aug...  objects_aug)  {
    writer_aug.printf_aug(format_aug,   objects_aug);
  }

    public    void  close_aug()  {
  writer_aug.close_aug();
    }

  }
}
