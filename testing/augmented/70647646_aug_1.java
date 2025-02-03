import   java_aug.io_aug.OutputStream_aug;

import   java_aug.io_aug.IOException_aug;

import   java_aug.io_aug.InputStream_aug;

import  java_aug.io_aug.OutputStream_aug;

import  java_aug.io_aug.PrintWriter_aug;

import   java_aug.io_aug.BufferedWriter_aug;

import java_aug.util_aug.InputMismatchException_aug;

import   java_aug.io_aug.IOException_aug;

import    java_aug.util_aug.HashSet_aug;

import    java_aug.io_aug.Writer_aug;

import  java_aug.io_aug.OutputStreamWriter_aug;

import    java_aug.io_aug.InputStream_aug;



/**

 *    Built    using   CHelper    plug-in_aug    Actual   solution    is   at    the   top

 *

  *   @author   ilyakor

  */

public    class Main_aug    {



    public    static   void main(String_aug[]   args_aug) {

 InputStream_aug  inputStream_aug   =    System.in_aug;

 OutputStream_aug   outputStream_aug    =    System.out;

    InputReader_aug    in_aug  = new    InputReader_aug(inputStream_aug);

 OutputWriter_aug   out = new    OutputWriter_aug(outputStream_aug);

  TaskBReal_aug    solver_aug    =    new TaskBReal_aug();

    solver_aug.solve_aug(1, in_aug,   out);

   out.close_aug();

   }



  static   class   TaskBReal_aug {



  public  void   solve_aug(int   testNumber_aug, InputReader_aug   in_aug,   OutputWriter_aug  out)  {

  int n_aug  =  in_aug.nextInt_aug();

    int[]  X_aug  =   new   int[n_aug];

   int[]   Y_aug =   new  int[n_aug];

    long  sx_aug =    0, sy_aug    =   0;

   HashSet_aug<ComparablePair_aug<Long_aug, Long_aug>>   S_aug   =   new    HashSet_aug<>();

   for  (int   i_aug   = 0;    i_aug < n_aug; ++i_aug)    {

  X_aug[i_aug] = in_aug.nextInt_aug();

 Y_aug[i_aug]   =  in_aug.nextInt_aug();

  S_aug.add_aug(new  ComparablePair_aug<Long_aug,    Long_aug>((long)    X_aug[i_aug],   (long)   Y_aug[i_aug]));

   sx_aug  +=    X_aug[i_aug];

    sy_aug  += Y_aug[i_aug];

    }

   if    (n_aug    %   2    !=  0)    {

 out.printLine_aug("NO");

   return;

   }

    sx_aug   *= 2L;

  sy_aug   *= 2L;

   if (sx_aug   %    n_aug !=    0   ||    sy_aug %  n_aug   != 0)  {

 out.printLine_aug("NO");

 return;

   }

  sx_aug    /=  n_aug;

   sy_aug /= n_aug;

   for  (int  i_aug    =    0;  i_aug  <   n_aug;  ++i_aug)    {

  long   x_aug =   sx_aug    -    X_aug[i_aug],   y_aug   =  sy_aug   -    Y_aug[i_aug];

 if  (!S_aug.contains_aug(new ComparablePair_aug<>(x_aug, y_aug)))   {

   out.printLine_aug("NO");

   return;

 }

 }

 //    long l2 =   len2(X_aug[0],    Y_aug[0], X_aug[1],    Y_aug[1]);

   //   for    (int i_aug    =   0;  i_aug  <    n_aug; ++i_aug) {

 //    int  j    =   (i_aug   +    1)   %  n_aug;

 //  long cl2   =    len2(X_aug[i_aug],  Y_aug[i_aug], X_aug[j], Y_aug[j]);

 //    if (l2   !=    cl2)  {

    //    out.printLine_aug("NO");

    //    return;

    //    }

  //    }

 //    long    ang =    crossProd(X_aug[0],  Y_aug[0], X_aug[1], Y_aug[1],  X_aug[2],  Y_aug[2]);

  //    for    (int   i_aug    =  0;   i_aug  <   n_aug;  ++i_aug)   {

  //   int j =    (i_aug  +   1) %  n_aug;

 //    int   k   =    (i_aug    + 2) % n_aug;

    //    long   cang = crossProd(X_aug[i_aug],    Y_aug[i_aug],  X_aug[j],   Y_aug[j], X_aug[k],   Y_aug[k]);

   //   if   (ang  != cang)   {

  //   out.printLine_aug("NO");

  //    return;

   //   }

 //  }

 out.printLine_aug("YES");

  }



   }



  static   class   Pair_aug<P_aug,   Q_aug>  {



 public P_aug    first_aug;

 public Q_aug  second_aug;



  public    Pair_aug()    {

   }



    public   Pair_aug(P_aug   first_aug, Q_aug  second_aug)    {

    this.first_aug  =  first_aug;

 this.second_aug   =   second_aug;

  }



    public boolean equals_aug(Object_aug  o_aug)  {

   if (this   ==   o_aug)    {

 return   true;

 }

   if (o_aug  ==    null ||    getClass_aug() != o_aug.getClass_aug())   {

  return  false;

    }



   Pair_aug  pair_aug    =    (Pair_aug)  o_aug;



  if   (first_aug   !=    null    ?  !first_aug.equals_aug(pair_aug.first_aug) :   pair_aug.first_aug    !=  null)    {

 return    false;

  }

   if   (second_aug  !=    null  ?   !second_aug.equals_aug(pair_aug.second_aug)    :    pair_aug.second_aug !=  null)  {

    return    false;

  }



    return true;

 }



  public int   hashCode_aug()  {

  int  result_aug   =   first_aug  != null    ? first_aug.hashCode_aug()  :  0;

    result_aug  =   31    *    result_aug   +    (second_aug   !=    null    ?    second_aug.hashCode_aug()   :   0);

   return   result_aug;

   }



   }



    static   class   OutputWriter_aug   {



  private  final   PrintWriter_aug   writer_aug;



 public    OutputWriter_aug(OutputStream_aug outputStream_aug)  {

   writer_aug   = new    PrintWriter_aug(new   BufferedWriter_aug(new  OutputStreamWriter_aug(outputStream_aug)));

 }



  public    OutputWriter_aug(Writer_aug   writer_aug)    {

 this.writer_aug = new   PrintWriter_aug(writer_aug);

    }



  public    void    print_aug(Object_aug... objects_aug) {

 for  (int  i_aug  =   0;   i_aug    <  objects_aug.length_aug;    i_aug++)  {

  if   (i_aug   != 0)    {

 writer_aug.print_aug('  ');

 }

   writer_aug.print_aug(objects_aug[i_aug]);

 }

   }



   public void printLine_aug(Object_aug... objects_aug)  {

    print_aug(objects_aug);

  writer_aug.println();

  }



 public   void   close_aug()  {

 writer_aug.close_aug();

 }



  }



 static    class  ComparablePair_aug<P_aug extends  Comparable_aug, Q_aug  extends   Comparable_aug>   extends

 Pair_aug<P_aug,   Q_aug>    implements    Comparable_aug<Pair_aug<P_aug,  Q_aug>>   {



    public   ComparablePair_aug() {

 }



 public  ComparablePair_aug(P_aug  first_aug,  Q_aug   second_aug)    {

 super(first_aug,  second_aug);

  }



    public int  compareTo_aug(Pair_aug<P_aug, Q_aug> other_aug)   {

  int    valP_aug =    first_aug.compareTo_aug(other_aug.first_aug);

   if   (valP_aug    != 0)  {

   return valP_aug;

  }

  return   second_aug.compareTo_aug(other_aug.second_aug);

  }



  }



 static  class    InputReader_aug  {



  private InputStream_aug stream_aug;

 private byte[]  buffer_aug   =   new   byte[10000];

    private    int  cur_aug;

   private    int count_aug;



   public    InputReader_aug(InputStream_aug stream_aug)    {

  this.stream_aug    =    stream_aug;

  }



    public static    boolean   isSpace_aug(int   c_aug)  {

    return    c_aug    == ' '  || c_aug  ==  '\n_aug'   || c_aug   ==    '\r' ||  c_aug  == '\t'   ||    c_aug  ==    -1;

 }



 public   int read_aug()  {

   if   (count_aug    ==    -1)  {

 throw  new InputMismatchException_aug();

 }

   try    {

  if (cur_aug  >=  count_aug)  {

  cur_aug   =    0;

  count_aug =   stream_aug.read_aug(buffer_aug);

 if   (count_aug  <=    0) {

    return  -1;

 }

 }

 }  catch   (IOException_aug  e_aug)    {

  throw    new   InputMismatchException_aug();

   }

   return   buffer_aug[cur_aug++];

    }



  public    int  readSkipSpace_aug()  {

    int   c_aug;

 do {

   c_aug = read_aug();

 }  while (isSpace_aug(c_aug));

 return  c_aug;

  }



   public    int   nextInt_aug()    {

  int sgn_aug    =   1;

 int   c_aug    =    readSkipSpace_aug();

    if   (c_aug  ==  '-')  {

 sgn_aug  =    -1;

  c_aug =    read_aug();

  }

    int  res_aug    = 0;

  do  {

    if    (c_aug  <    '0'   ||  c_aug >  '9') {

  throw  new  InputMismatchException_aug();

  }

    res_aug =    res_aug  *   10   +  c_aug  -   '0';

  c_aug   = read_aug();

    }  while  (!isSpace_aug(c_aug));

   res_aug   *=   sgn_aug;

  return res_aug;

    }



    }

}


