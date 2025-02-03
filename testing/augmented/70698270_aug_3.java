import    java_aug.io_aug.BufferedReader_aug;

import java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStreamReader_aug;

import  java_aug.io_aug.PrintWriter_aug;

import   java_aug.math_aug.*;

import java_aug.util_aug.*;

import   java_aug.util_aug.function_aug.*;



public    class  D_aug    {



  private  static final  FastReader_aug   in_aug   =  new  FastReader_aug();

  private    static  final    FastWriter_aug out =    new  FastWriter_aug();



   public    static    void   main(String_aug[] args_aug) {

   new    D_aug().run_aug();

   }



    private    void    run_aug()    {

  var_aug t_aug    = 1;

   while (t_aug-- > 0)   {

   solve_aug();

    }



    out.flush_aug();

    }



  private   void solve_aug()    {

 var_aug    n_aug =  in_aug.nextInt_aug();

  var_aug points_aug   =   new   ArrayList_aug<IntPair_aug>(n_aug);

  for  (var_aug   i_aug    =   0;  i_aug < n_aug;  i_aug++)    {

 points_aug.add_aug(new   IntPair_aug(in_aug.nextInt_aug(),  in_aug.nextInt_aug()));

 }



    if   (n_aug   %    2 ==  1)    {

   out.println("NO");

  return ;

  }



 points_aug.add_aug(points_aug.get_aug(0));

  var_aug  m_aug  = n_aug    /  2;

  for    (int    i_aug = 0, j_aug   =  m_aug;  i_aug   <   m_aug;  i_aug++,   j_aug++)  {

    var_aug dx_aug = points_aug.get_aug(i_aug  + 1).a_aug    -  points_aug.get_aug(i_aug).a_aug;

  var_aug   dy_aug    = points_aug.get_aug(i_aug   +  1).b_aug    -   points_aug.get_aug(i_aug).b_aug;



 var_aug tx_aug = points_aug.get_aug(j_aug    +    1).a_aug    -   points_aug.get_aug(j_aug).a_aug;

   var_aug    ty_aug =   points_aug.get_aug(j_aug +  1).b_aug   -   points_aug.get_aug(j_aug).b_aug;



    if   (!(dx_aug + tx_aug    == 0    &&    dy_aug   +   ty_aug ==    0))  {

    out.println("NO");

 return    ;

   }

 }



 out.println("YES");

 }



    @SuppressWarnings_aug("unused")

  private    static  int  binarySearch_aug(int  left_aug,  int right_aug, Predicate_aug<Integer_aug>    leftShouldAdvance_aug)  {

 while  (left_aug    < right_aug)    {

   int  mid_aug    =    left_aug +   (right_aug    - left_aug)  / 2;

 if   (leftShouldAdvance_aug.test_aug(mid_aug))    {

   left_aug    =  mid_aug +   1;

    } else    {

   right_aug    =    mid_aug;

    }

   }



   return  left_aug;

 }



  @SuppressWarnings_aug("unused")

 private static class  Pair_aug<T_aug, U_aug>    {



   T_aug a_aug;

   U_aug b_aug;



 Pair_aug(T_aug   a_aug,  U_aug   b_aug) {

  this.a_aug =  a_aug;

  this.b_aug    =   b_aug;

    }



   T_aug   getA_aug()   {

   return a_aug;

 }



  U_aug  getB_aug()  {

    return  b_aug;

   }



    }



   @SuppressWarnings_aug("unused")

 private   static  class    IntPair_aug  extends Pair_aug<Integer_aug, Integer_aug>    {



   IntPair_aug(Integer_aug    a_aug, Integer_aug    b_aug) {

   super(a_aug, b_aug);

   }



  }



 @SuppressWarnings_aug("unused")

  private static  class    Triple_aug<T_aug, U_aug,   V_aug> {



    T_aug    a_aug;

    U_aug b_aug;

 V_aug  c_aug;



 Triple_aug(T_aug    a_aug,    U_aug b_aug,    V_aug    c_aug)  {

  this.a_aug   =   a_aug;

  this.b_aug    =   b_aug;

    this.c_aug =    c_aug;

  }



   T_aug   getA_aug() {

   return a_aug;

    }



 U_aug getB_aug()   {

   return  b_aug;

 }



 V_aug getC_aug() {

    return  c_aug;

 }



  }



   @SuppressWarnings_aug("unused")

   private static   class    IntTriple_aug  extends Triple_aug<Integer_aug,   Integer_aug,   Integer_aug>   {



  IntTriple_aug(Integer_aug    a_aug,   Integer_aug b_aug,  Integer_aug    c_aug)  {

    super(a_aug,  b_aug,   c_aug);

  }



    }



    @SuppressWarnings_aug("unused")

 private   static    class  FastReader_aug {



   private   static   final   BufferedReader_aug br_aug    =   new    BufferedReader_aug(new InputStreamReader_aug(System.in_aug));

  private static   StringTokenizer_aug    in_aug;



    public String_aug    next_aug()   {

   while   (in_aug  ==  null   ||   !in_aug.hasMoreTokens_aug())   {

   try  {

   in_aug  =  new    StringTokenizer_aug(br_aug.readLine_aug());

 }    catch (IOException_aug    e_aug) {

   return   null;

    }

   }

  return  in_aug.nextToken_aug();

  }



    public    BigDecimal_aug    nextBigDecimal_aug()    {

   return  new   BigDecimal_aug(next_aug());

   }



    public  BigInteger_aug    nextBigInteger_aug()   {

  return   new BigInteger_aug(next_aug());

  }



   public   boolean   nextBoolean_aug() {

 return Boolean_aug.valueOf_aug(next_aug());

    }



  public byte   nextByte_aug()    {

 return Byte_aug.valueOf_aug(next_aug());

  }



   public   double   nextDouble_aug()    {

    return  Double_aug.valueOf_aug(next_aug());

    }



  public double[]   nextDoubleArray_aug(int   length_aug) {

    var_aug a_aug = new  double[length_aug];

 for    (var_aug    i_aug    =    0;   i_aug    < length_aug;    i_aug++)    {

 a_aug[i_aug] = nextDouble_aug();

 }

 return a_aug;

    }



    public    int    nextInt_aug() {

 return  Integer_aug.valueOf_aug(next_aug());

    }



   public  int[]   nextIntArray_aug(int    length_aug) {

   var_aug    a_aug    =  new  int[length_aug];

  for   (var_aug   i_aug = 0;  i_aug    <    length_aug; i_aug++)   {

 a_aug[i_aug] =    nextInt_aug();

 }

 return a_aug;

  }



  public    long    nextLong_aug()  {

 return    Long_aug.valueOf_aug(next_aug());

 }



   public  long[]   nextLongArray_aug(int length_aug)    {

  var_aug   a_aug = new long[length_aug];

  for    (var_aug  i_aug  =   0;   i_aug  < length_aug; i_aug++) {

 a_aug[i_aug]    = nextLong_aug();

 }

   return   a_aug;

    }



    }



   @SuppressWarnings_aug("unused")

  private static    class FastWriter_aug   extends    PrintWriter_aug   {



   public    FastWriter_aug() {

  super(System.out);

  }



    public  void println(double[]  a_aug) {

   for   (var_aug  i_aug    =    0; i_aug  <   a_aug.length_aug;    i_aug++)  {

   print_aug(a_aug[i_aug]);

 print_aug(i_aug +  1    <    a_aug.length_aug  ? '  '   :   '\n_aug');

 }

 }



 public  void  println(int[] a_aug)    {

    for    (var_aug  i_aug  =    0;    i_aug < a_aug.length_aug;  i_aug++)    {

    print_aug(a_aug[i_aug]);

  print_aug(i_aug   +   1   <   a_aug.length_aug  ? '  '   :   '\n_aug');

   }

    }



   public  void  println(long[]    a_aug)  {

 for (var_aug    i_aug =   0; i_aug   <  a_aug.length_aug;   i_aug++) {

   print_aug(a_aug[i_aug]);

 print_aug(i_aug    + 1 < a_aug.length_aug ? '   ' :   '\n_aug');

  }

   }



   public  <T_aug>    void   println(T_aug[]    a_aug)  {

 for   (var_aug    i_aug    =   0;   i_aug  <   a_aug.length_aug; i_aug++)    {

    print_aug(a_aug[i_aug]);

 print_aug(i_aug  +  1 <   a_aug.length_aug ?    '   '    : '\n_aug');

    }

    }



 public    void   debug_aug(String_aug name_aug,  Object_aug o_aug)   {

 String_aug value_aug    =  Arrays_aug.deepToString_aug(new   Object_aug[]    {    o_aug });

  value_aug   =   value_aug.substring_aug(1,  value_aug.length_aug()   -  1);

 System.err_aug.println(name_aug +   "   =>   "   +    value_aug);

   }



 }



}
