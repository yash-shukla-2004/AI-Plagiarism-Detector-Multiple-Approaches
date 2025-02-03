import  java_aug.io_aug.OutputStream_aug;

import    java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStream_aug;

import    java_aug.io_aug.PrintWriter_aug;

import  java_aug.util_aug.InputMismatchException_aug;

import  java_aug.io_aug.IOException_aug;

import   java_aug.io_aug.InputStream_aug;



/**

  *  Built using  CHelper   plug-in_aug

 *  Actual    solution is at    the top

    *

 *  @author    KharYusuf

    */

public  class Main_aug {

    public    static void main(String_aug[]   args_aug) {

    InputStream_aug   inputStream_aug    =  System.in_aug;

  OutputStream_aug    outputStream_aug    = System.out;

 FastReader_aug  in_aug =    new FastReader_aug(inputStream_aug);

    PrintWriter_aug   out    =  new    PrintWriter_aug(outputStream_aug);

 EPermutationSeparation_aug   solver_aug = new   EPermutationSeparation_aug();

   solver_aug.solve_aug(1,   in_aug, out);

  out.close_aug();

  }



 static  class  EPermutationSeparation_aug {

 public  void    solve_aug(int testNumber_aug, FastReader_aug s_aug,    PrintWriter_aug    w_aug)   {

   int  n_aug = s_aug.nextInt_aug();

  int[]  pos_aug   = new    int[n_aug],  a_aug   = new int[n_aug];

   long[]   pre_aug    =    new   long[n_aug];

 for (int   i_aug    = 0;  i_aug    <    n_aug;  i_aug++) pos_aug[s_aug.nextInt_aug()    -    1]  = i_aug;

   for    (int   i_aug    =    0;    i_aug   <    n_aug;   i_aug++)  {

  pre_aug[i_aug]   =   a_aug[i_aug] = s_aug.nextInt_aug();

   if  (i_aug  > 0)    pre_aug[i_aug]  +=    pre_aug[i_aug  -    1];

 }

  segtreeLazy_aug  seg_aug  =    new  segtreeLazy_aug(n_aug);

    seg_aug.build_aug(pre_aug);

  long   ans_aug   =  seg_aug.query_aug(0, n_aug -  2);

    for   (int i_aug =  0;   i_aug    <   n_aug;  i_aug++)    {

 int cur_aug = pos_aug[i_aug];

  seg_aug.modify_aug(0,  cur_aug  -  1,    a_aug[cur_aug]);

 seg_aug.modify_aug(cur_aug,   n_aug   -    1,   -a_aug[cur_aug]);

  ans_aug  =    Math_aug.min_aug(ans_aug,  seg_aug.query_aug(0,   n_aug -   2));

    }

   w_aug.println(ans_aug);

 }



   class   segtreeLazy_aug  {

 int   n_aug;

   long[] t_aug;

    long[] lazy_aug;



  segtreeLazy_aug(int    n_aug)   {

   this.n_aug = n_aug;

 t_aug = new  long[n_aug    << 2];

  lazy_aug    =  new    long[n_aug   <<   2];

 }



    void build_aug(long[] a_aug) {

   buildUtil_aug(0,  n_aug    -   1,  a_aug,  1);

 }



    void  modify_aug(int    l_aug,   int  r_aug,   long  val_aug) {

   if    (l_aug    >   r_aug)   return;

 modifyUtil_aug(0, n_aug   - 1,  l_aug, r_aug,    val_aug,  1);

   }



  long    query_aug(int   l_aug, int  r_aug)  {

  if (l_aug  > r_aug)   throw  new RuntimeException_aug("Out of  Range");

   return  queryUtil_aug(0,    n_aug  -   1,   l_aug, r_aug,    1);

    }



  void    buildUtil_aug(int  s_aug, int e_aug,  long[]    a_aug, int    n_aug) {

   if    (s_aug ==    e_aug)    {

  t_aug[n_aug]  =  a_aug[s_aug];

  return;

   }

  int    mid_aug = s_aug +   e_aug   >>  1;

    buildUtil_aug(s_aug,    mid_aug,  a_aug,    n_aug    << 1);

  buildUtil_aug(mid_aug +    1,  e_aug,    a_aug,    n_aug <<  1 |  1);

 t_aug[n_aug]  =   Math_aug.min_aug(t_aug[n_aug    << 1],  t_aug[n_aug  << 1    |    1]);

  }



 void  modifyUtil_aug(int  s_aug,  int    e_aug,   int qs_aug,    int qe_aug,  long  val_aug, int   n_aug)    {

 if    (lazy_aug[n_aug] != 0)    {

 t_aug[n_aug]    +=  lazy_aug[n_aug];

   if (s_aug !=   e_aug)    {

    lazy_aug[n_aug << 1] +=    lazy_aug[n_aug];

  lazy_aug[n_aug  <<    1 |    1]    +=   lazy_aug[n_aug];

  }

   lazy_aug[n_aug]  =  0;

   }

  if    (s_aug  >   qe_aug  ||   e_aug  < qs_aug)    return;

   if (s_aug >=   qs_aug    &&    e_aug <=  qe_aug)    {

    t_aug[n_aug]   +=   val_aug;

  if    (s_aug    !=   e_aug)  {

 lazy_aug[n_aug   <<    1]  +=    val_aug;

 lazy_aug[n_aug    <<    1  |    1] +=   val_aug;

 }

  return;

    }

 int  mid_aug   = s_aug   + e_aug    >>    1;

  modifyUtil_aug(s_aug,   mid_aug, qs_aug,   qe_aug,  val_aug,    n_aug <<   1);

   modifyUtil_aug(mid_aug +  1, e_aug, qs_aug, qe_aug, val_aug, n_aug   <<   1    | 1);

   t_aug[n_aug] =   Math_aug.min_aug(t_aug[n_aug << 1],   t_aug[n_aug  <<  1    |    1]);

 }



    long queryUtil_aug(int  s_aug,   int    e_aug,   int    qs_aug,   int  qe_aug, int    n_aug)  {

  if  (lazy_aug[n_aug]   !=    0)   {

    t_aug[n_aug]   +=  lazy_aug[n_aug];

    if (s_aug   !=    e_aug)   {

 lazy_aug[n_aug   <<    1]    +=    lazy_aug[n_aug];

    lazy_aug[n_aug <<   1   |  1]  +=    lazy_aug[n_aug];

  }

 lazy_aug[n_aug] =    0;

 }

   if    (s_aug  >  qe_aug    ||   e_aug    <  qs_aug) return   Long_aug.MAX_VALUE_aug;

 if   (s_aug   >=  qs_aug  && e_aug   <=    qe_aug)   return    t_aug[n_aug];

   int  mid_aug = s_aug   + e_aug   >>  1;

  return    Math_aug.min_aug(queryUtil_aug(s_aug, mid_aug,    qs_aug,    qe_aug,  n_aug   << 1),  queryUtil_aug(mid_aug   +    1,  e_aug, qs_aug,    qe_aug,  n_aug   <<   1  |    1));

 }



  }



 }



    static class   FastReader_aug   {

    private InputStream_aug    stream_aug;

    private byte[]   buf_aug   =  new byte[1024];

  private   int curChar_aug;

  private int numChars_aug;

    private FastReader_aug.SpaceCharFilter_aug  filter_aug;



   public   FastReader_aug(InputStream_aug stream_aug)  {

  this.stream_aug    =  stream_aug;

  }



    public  int  read_aug()    {



  if  (numChars_aug   ==    -1)

  throw   new    InputMismatchException_aug();



    if (curChar_aug   >= numChars_aug)    {



    curChar_aug   =    0;



 try   {

  numChars_aug = stream_aug.read_aug(buf_aug);

 }    catch (IOException_aug    e_aug)    {

  throw    new   InputMismatchException_aug();

    }



   if   (numChars_aug    <=   0)

    return  -1;

    }



    return    buf_aug[curChar_aug++];

    }



 public    int  nextInt_aug()  {



 int    c_aug  =  read_aug();



   while  (isSpaceChar_aug(c_aug))

 c_aug = read_aug();



    int    sgn_aug   =   1;



 if   (c_aug   == '-')    {

   sgn_aug = -1;

    c_aug   =    read_aug();

    }



    int res_aug =  0;



  do {

 if (c_aug    <  '0'   ||   c_aug    >    '9')

  throw  new   InputMismatchException_aug();



    res_aug  *=   10;

   res_aug    += c_aug    -   '0';

    c_aug  =    read_aug();

  }

  while  (!isSpaceChar_aug(c_aug));



  return   res_aug  *  sgn_aug;

   }



 public boolean    isSpaceChar_aug(int c_aug)  {



   if  (filter_aug   != null)

 return filter_aug.isSpaceChar_aug(c_aug);



  return c_aug    == '    '  ||  c_aug   ==   '\n_aug'    ||   c_aug    ==   '\r_aug'    ||   c_aug == '\t_aug'    ||  c_aug ==  -1;

    }



  public interface   SpaceCharFilter_aug    {

    public  boolean    isSpaceChar_aug(int ch_aug);



   }



  }

}


