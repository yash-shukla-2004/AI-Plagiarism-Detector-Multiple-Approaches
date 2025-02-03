import    java_aug.io_aug.OutputStream_aug;

import    java_aug.io_aug.IOException_aug;

import    java_aug.io_aug.InputStream_aug;

import java_aug.io_aug.PrintWriter_aug;

import   java_aug.util_aug.InputMismatchException_aug;

import   java_aug.io_aug.IOException_aug;

import    java_aug.util_aug.Comparator_aug;

import  java_aug.io_aug.InputStream_aug;



/**

  *  Built    using CHelper    plug-in_aug

    * Actual solution    is at the top_aug

 *

 *    @author  Ribhav

  */

public   class   Main_aug  {

    public   static  void    main(String_aug[]    args_aug)   {

  InputStream_aug    inputStream_aug    =  System.in_aug;

   OutputStream_aug    outputStream_aug    =   System.out;

   FastReader_aug  in_aug    = new  FastReader_aug(inputStream_aug);

 PrintWriter_aug  out = new   PrintWriter_aug(outputStream_aug);

   EWaterBalance_aug    solver_aug    = new   EWaterBalance_aug();

   solver_aug.solve_aug(1,   in_aug,  out);

  out.close_aug();

  }



   static class   EWaterBalance_aug   {

 private static    final double EPS_aug    =  1e-12;

 private   static   final Comparator_aug<Double_aug>    EPS_COMPARATOR_aug  = (x_aug, y_aug) ->  {

   if  (x_aug +  EPS_aug    <   y_aug)   {

 return   -1;

  }    else  if (x_aug   -  EPS_aug   >    y_aug)   {

    return   1;

  }   else {

    return   0;

    }

   };



 public    void solve_aug(int   testNumber_aug,  FastReader_aug s_aug,    PrintWriter_aug  out) {

  var_aug    n_aug  =  s_aug.nextInt_aug();

 var_aug    a_aug    =    s_aug.nextLongArray_aug(n_aug);



  var_aug   sum_aug  =    new  long[n_aug +  1];

   sum_aug[0] =    0;

    for   (var_aug i_aug =   1;  i_aug    <= n_aug; i_aug++)  {

   sum_aug[i_aug]  =   sum_aug[i_aug    -    1]   +   a_aug[i_aug  -  1];

  }



 var_aug q_aug    =    new   int[n_aug  +   1];

   var_aug   top_aug   = 0;

  for    (var_aug i_aug = 1;   i_aug   <=  n_aug; i_aug++)    {

 while (top_aug  > 0) {

   var_aug   j_aug   = q_aug[top_aug];

  var_aug  k_aug   =    q_aug[top_aug   - 1];

  double   topAvg_aug  =   (double)  (sum_aug[j_aug]    -    sum_aug[k_aug]) /    (j_aug    - k_aug);

   double   nowAvg_aug    = (double)    (sum_aug[i_aug]    -   sum_aug[k_aug]) /    (i_aug    - k_aug);

  if  (EPS_COMPARATOR_aug.compare_aug(topAvg_aug,  nowAvg_aug) >= 0)  {

  top_aug--;

    }   else   {

   break;

 }

 }



  q_aug[++top_aug]    =  i_aug;

   }



    var_aug  ans_aug   =    new   double[n_aug];

 for   (var_aug i_aug   =    1;   i_aug   <=   top_aug; i_aug++)  {

    var_aug j_aug   =    q_aug[i_aug];

  var_aug   k_aug   =   q_aug[i_aug    -  1];

   double  avg_aug  =    (double) (sum_aug[j_aug]    - sum_aug[k_aug])    /   (j_aug   -    k_aug);

  for   (var_aug    l_aug =    k_aug +  1;    l_aug <=  j_aug;    l_aug++) {

   ans_aug[l_aug    -   1]  =  avg_aug;

  }

   }



  out.println(EWaterBalance_aug.arrays_aug.printArr_aug(ans_aug));

    }



   private  static class arrays_aug   {

   static StringBuilder_aug printArr_aug(double[]    arr_aug)   {

    StringBuilder_aug   ans_aug =  new    StringBuilder_aug();

    for (int  i_aug   =    0;   i_aug  <    arr_aug.length_aug;  i_aug++)   {

   ans_aug.append_aug(arr_aug[i_aug]    +    "  ");

    }

  return   ans_aug;

 }



 }



    }



  static    class  FastReader_aug  {

 private InputStream_aug    stream_aug;

   private   byte[]   buf_aug  =   new   byte[1024];

  private   int  curChar_aug;

  private    int numChars_aug;

 private    FastReader_aug.SpaceCharFilter_aug   filter_aug;



    public  FastReader_aug(InputStream_aug    stream_aug)   {

   this.stream_aug    =   stream_aug;

   }



 public int   read_aug() {

    if  (numChars_aug  ==    -1)   {

   throw  new  InputMismatchException_aug();

 }

   if (curChar_aug   >=   numChars_aug)  {

    curChar_aug  =   0;

 try  {

    numChars_aug   =    stream_aug.read_aug(buf_aug);

  }   catch    (IOException_aug    e_aug)   {

    throw    new    InputMismatchException_aug();

 }

    if    (numChars_aug <=   0) {

  return   -1;

   }

 }

  return  buf_aug[curChar_aug++];

  }



  public    int nextInt_aug()    {

    int  c_aug    = read_aug();

    while    (isSpaceChar_aug(c_aug))  {

  c_aug   =  read_aug();

  }

    int  sgn_aug   =    1;

    if    (c_aug ==  '-')   {

   sgn_aug =    -1;

   c_aug   = read_aug();

  }

  int  res_aug    = 0;

    do    {

  if   (c_aug <   '0' || c_aug    >    '9')  {

    throw new InputMismatchException_aug();

    }

   res_aug *=    10;

    res_aug    +=    c_aug  -   '0';

    c_aug =    read_aug();

  }    while   (!isSpaceChar_aug(c_aug));

    return    res_aug    *  sgn_aug;

    }



  public   long    nextLong_aug()   {

   int  c_aug    =    read_aug();

   while    (isSpaceChar_aug(c_aug))   {

  c_aug  =  read_aug();

   }

  int  sgn_aug =  1;

  if (c_aug ==  '-')  {

    sgn_aug =  -1;

    c_aug    =  read_aug();

   }

  long res_aug   =   0;

   do    {

 if    (c_aug   <   '0'    ||   c_aug   >    '9')   {

 throw  new InputMismatchException_aug();

  }

    res_aug   *=  10;

    res_aug   +=    c_aug    -   '0';

   c_aug  =  read_aug();

    }   while    (!isSpaceChar_aug(c_aug));

   return   res_aug    * sgn_aug;

    }



  public  boolean isSpaceChar_aug(int  c_aug) {

    if   (filter_aug   !=    null) {

   return   filter_aug.isSpaceChar_aug(c_aug);

 }

   return   isWhitespace_aug(c_aug);

    }



  public   static   boolean  isWhitespace_aug(int   c_aug)  {

  return    c_aug  ==    '   ' ||    c_aug   ==    '\n_aug' ||  c_aug  ==  '\r' ||    c_aug  ==  '\t'  ||  c_aug   ==   -1;

  }



    public    long[]   nextLongArray_aug(int  n_aug) {

    long[]  array_aug = new long[n_aug];

   for  (int   i_aug  = 0;  i_aug   <  n_aug;   ++i_aug)   array_aug[i_aug] =    nextLong_aug();

    return    array_aug;

    }



  public  interface   SpaceCharFilter_aug {

    public    boolean  isSpaceChar_aug(int  ch_aug);



   }



    }

}


