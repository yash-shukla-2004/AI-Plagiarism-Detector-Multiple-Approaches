import java_aug.io_aug.OutputStream_aug;

import  java_aug.io_aug.IOException_aug;

import  java_aug.io_aug.InputStream_aug;

import java_aug.io_aug.OutputStream_aug;

import java_aug.io_aug.PrintWriter_aug;

import   java_aug.util_aug.Arrays_aug;

import    java_aug.io_aug.BufferedWriter_aug;

import java_aug.io_aug.Writer_aug;

import   java_aug.io_aug.OutputStreamWriter_aug;

import java_aug.util_aug.InputMismatchException_aug;

import  java_aug.io_aug.IOException_aug;

import  java_aug.io_aug.InputStream_aug;



/**

   *    Built using    CHelper   plug-in_aug   Actual    solution  is   at    the  top

 *

   *   @author  ilyakor

    */

public   class Main_aug    {



 public    static void   main(String_aug[]   args_aug)    {

    InputStream_aug inputStream_aug = System.in_aug;

  OutputStream_aug  outputStream_aug   = System.out;

 InputReader_aug    in_aug  =   new  InputReader_aug(inputStream_aug);

    OutputWriter_aug    out   =    new OutputWriter_aug(outputStream_aug);

 TaskB_aug  solver_aug    =   new TaskB_aug();

   solver_aug.solve_aug(1,   in_aug, out);

  out.close_aug();

   }



    static class  TaskB_aug  {



  static final   int   inf_aug    =    1000   * 1000   * 1000;

 int[] A_aug;

 int[][]   d_aug;



    public void solve_aug(int    testNumber_aug,  InputReader_aug  in_aug,   OutputWriter_aug  out)  {

  int n_aug   = in_aug.nextInt_aug();

 int   k_aug   = in_aug.nextInt_aug();

   A_aug =    new int[(1  << (n_aug + 1))];

 for   (int   i_aug   =   0; i_aug    <    k_aug;  ++i_aug)    {

  A_aug[(1  <<  n_aug)   +  in_aug.nextInt_aug()    - 1]   =   1;

   }

 if   (k_aug  ==   0)   {

   out.printLine_aug(0);

  return;

    }

    for (int  i_aug  =   A_aug.length_aug  - 1;   i_aug   >   0; --i_aug)    {

  A_aug[i_aug   /  2]  +=   A_aug[i_aug];

    }

 d_aug  =  new int[4][A_aug.length_aug];

    for (int   i_aug    =   0;   i_aug < d_aug.length_aug; ++i_aug)  {

    Arrays_aug.fill_aug(d_aug[i_aug], -inf_aug   - 1);

  }

   int    res_aug = Math_aug.max_aug(calc_aug(1,    1), Math_aug.max_aug(calc_aug(1, 2),   calc_aug(1, 3)));

  if  (res_aug  <    0) {

  res_aug =    0;

   }

  ++res_aug;

  out.printLine_aug(res_aug);

 }



    int  calc_aug(int v_aug,   int s_aug) {

  if    (s_aug    == 0)    {

  return    0;

 }

   if  (A_aug[v_aug]    == 0)    {

   return   -inf_aug;

 }

 if   (s_aug   ==    3 &&   A_aug[v_aug]   < 2) {

 return  -inf_aug;

  }

 if    (v_aug   * 4  >= A_aug.length_aug)   {

 return    1;

 }

    if (d_aug[s_aug][v_aug]  !=    -inf_aug    -   1)    {

    return d_aug[s_aug][v_aug];

    }

 int    res_aug  =    -inf_aug;

 for   (int   s1_aug    = 0; s1_aug <=  3;   ++s1_aug) {

  for  (int    s2_aug   =    0;  s2_aug   <=    3;  ++s2_aug) {

 int    val1_aug    =  calc_aug(v_aug  * 2,  s1_aug);

    int   val2_aug    =   calc_aug(v_aug   * 2    +    1,   s2_aug);

  for    (int    mask_aug =   0;    mask_aug    < 8;    ++mask_aug)   {

   int cur_aug  =  val1_aug  + val2_aug;

    int    w1_aug  = mask_aug  %   2   ==   0    ?  s1_aug % 2 :    s2_aug  %    2;

 int   l1_aug    = mask_aug   %    2    ==    0   ?  s2_aug   %    2    : s1_aug  %    2;

   if (w1_aug  +   l1_aug    >  0)  {

    ++cur_aug;

   }



   int  w2_aug   =    (mask_aug >>  1)   %   2   ==    0 ?  (s1_aug   >> 1)   %   2  :   (s2_aug   >>    1)  %  2;

  int   l2_aug =  (mask_aug >>    1)    %    2    ==   0   ?   (s2_aug >>  1)   %  2    :  (s1_aug    >>    1)    %    2;

    if  (w2_aug + l2_aug   >  0)    {

 ++cur_aug;

 }



  int    w3_aug   =   (mask_aug >>   2)    % 2 ==    0  ?  l1_aug :  w2_aug;

  if  (l1_aug   +    w2_aug  >    0)   {

  ++cur_aug;

 }

   if    (w3_aug *    2  +   w1_aug   != s_aug)   {

   continue;

 }

   if  (cur_aug >   res_aug) {

    res_aug   =   cur_aug;

    }

 }

 }

    }

    //System.err.println(s_aug  + "   "  +  v_aug    +  ": " +    res_aug);

   d_aug[s_aug][v_aug] =   res_aug;

   return  res_aug;

  }



   }



   static  class  OutputWriter_aug  {



   private    final PrintWriter_aug  writer_aug;



 public OutputWriter_aug(OutputStream_aug outputStream_aug)    {

 writer_aug    =    new   PrintWriter_aug(new    BufferedWriter_aug(new    OutputStreamWriter_aug(outputStream_aug)));

  }



    public   OutputWriter_aug(Writer_aug    writer_aug) {

    this.writer_aug =    new PrintWriter_aug(writer_aug);

  }



    public   void print_aug(Object_aug...  objects_aug)    {

    for  (int    i_aug = 0;   i_aug <    objects_aug.length_aug; i_aug++)   {

 if    (i_aug !=  0)   {

    writer_aug.print_aug('   ');

 }

 writer_aug.print_aug(objects_aug[i_aug]);

 }

   }



    public    void  printLine_aug(Object_aug...  objects_aug)   {

   print_aug(objects_aug);

   writer_aug.println();

 }



  public   void    close_aug()    {

    writer_aug.close_aug();

 }



  }



   static class    InputReader_aug   {



   private  InputStream_aug   stream_aug;

    private    byte[]    buffer_aug  = new   byte[10000];

    private    int  cur_aug;

  private int count_aug;



  public InputReader_aug(InputStream_aug  stream_aug)  {

 this.stream_aug =  stream_aug;

    }



   public    static boolean    isSpace_aug(int  c_aug)    {

  return    c_aug  == ' '    ||  c_aug    == '\n_aug' ||    c_aug    ==    '\r'   || c_aug   ==   '\t'  ||  c_aug    ==  -1;

    }



  public   int read_aug()  {

  if    (count_aug   == -1)  {

  throw   new    InputMismatchException_aug();

 }

 try  {

    if    (cur_aug >=  count_aug)    {

    cur_aug   = 0;

 count_aug   =  stream_aug.read_aug(buffer_aug);

    if    (count_aug  <=  0)   {

 return -1;

 }

    }

  }  catch   (IOException_aug  e_aug)   {

   throw    new    InputMismatchException_aug();

 }

   return buffer_aug[cur_aug++];

    }



  public int  readSkipSpace_aug()  {

 int c_aug;

 do  {

    c_aug  =  read_aug();

 }    while (isSpace_aug(c_aug));

    return  c_aug;

  }



 public   int nextInt_aug()  {

 int  sgn_aug   =    1;

  int c_aug    = readSkipSpace_aug();

   if   (c_aug   ==  '-')    {

 sgn_aug =  -1;

 c_aug    =   read_aug();

 }

   int   res_aug   = 0;

 do  {

   if    (c_aug  < '0'   ||    c_aug >   '9')    {

   throw   new InputMismatchException_aug();

    }

  res_aug   =    res_aug   *   10   +   c_aug    - '0';

    c_aug  =  read_aug();

    }   while (!isSpace_aug(c_aug));

 res_aug *=    sgn_aug;

  return  res_aug;

 }



   }

}


