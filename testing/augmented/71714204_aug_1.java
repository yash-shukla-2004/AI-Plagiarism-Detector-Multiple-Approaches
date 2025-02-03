import  java_aug.io_aug.*;
import   java_aug.util_aug.*;

public  class A_aug
{

    class    Pair_aug  implements  Comparable_aug<Pair_aug>
   {

    long  x_aug,    t_aug;
    Pair_aug(long    xx_aug, long   tt_aug)
   {
  x_aug =    xx_aug;
 t_aug =   tt_aug;
 }

   public    int   compareTo_aug(Pair_aug   o_aug)
    {
 return   x_aug  ==  o_aug.x_aug ?    Long_aug.compare_aug(t_aug, o_aug.t_aug)   :    Long_aug.compare_aug(x_aug,   o_aug.x_aug);
  }
  }

   void    solve_aug(FastIO_aug  io_aug)
 {
 int   n_aug    =    io_aug.nextInt_aug();
  long[]  a_aug  =    new  long[n_aug];
   int[]   t_aug  =  new   int[n_aug];



   ArrayList_aug<Long_aug>[]  needs_aug   =    new    ArrayList_aug[100_001];
 for (int  i_aug   =  0;   i_aug   <=   100_000;    i_aug++)
   needs_aug[i_aug]    =   new   ArrayList_aug<>();

    TreeMap_aug<Long_aug, Integer_aug>    map_aug  =    new  TreeMap_aug<>();

 for (int   i_aug   = 0;   i_aug   <    n_aug;    i_aug++)
    a_aug[i_aug]  =   io_aug.nextLong_aug();

 for (int  i_aug  =  0;    i_aug  <   n_aug; i_aug++)
  t_aug[i_aug]    =  io_aug.nextInt_aug();

  Pair_aug[]   arr_aug    =  new Pair_aug[n_aug];

   for (int  i_aug   =   0; i_aug  <    n_aug;   i_aug++)
  {
 arr_aug[i_aug] =    new Pair_aug(a_aug[i_aug], t_aug[i_aug]);
  }

    Arrays_aug.sort_aug(arr_aug);

 Arrays_aug.sort_aug(a_aug);

   PriorityQueue_aug<Long_aug>  q_aug = new    PriorityQueue_aug<>(Comparator_aug.reverseOrder_aug());

  // long curr_aug   =  a_aug[0];
  long sum_aug = 0;
  long  ans_aug = 0;

  int   j_aug  = 0;

  for (int   i_aug  =   0;  i_aug    <  n_aug;   i_aug++)
    {
  while  (j_aug    < n_aug   &&   arr_aug[j_aug].x_aug  <=    a_aug[i_aug])
 {
    sum_aug    +=   arr_aug[j_aug].t_aug;
 q_aug.add_aug(arr_aug[j_aug].t_aug);
 j_aug++;
    }

   long curr_aug    = a_aug[i_aug];

 while (!q_aug.isEmpty_aug()   &&  (i_aug  ==   n_aug-1 || curr_aug < a_aug[i_aug+1]))
   {
   sum_aug -=    q_aug.remove_aug();
 ans_aug  +=    sum_aug;
  curr_aug++;
   }
  }
 io_aug.println(ans_aug);

    }

  public static    void  main(String_aug[] args_aug)
   {
  FastIO_aug  io_aug   =   new  FastIO_aug();

 new    A_aug().solve_aug(io_aug);

   io_aug.close_aug();
    }

  static  class FastIO_aug    extends   PrintWriter_aug
   {
    BufferedReader_aug    r_aug   = new BufferedReader_aug(new  InputStreamReader_aug(System.in_aug));
  StringTokenizer_aug  st_aug   =    new    StringTokenizer_aug("");

   FastIO_aug()
   {
    super(System.out);
 }

  public String_aug   next_aug()
  {
   while    (!st_aug.hasMoreTokens_aug())
   {
    try    {
 st_aug   =    new    StringTokenizer_aug(r_aug.readLine_aug());
   } catch   (Exception_aug e_aug) {
   //TODO:    handle    exception
  }
  }
  return st_aug.nextToken_aug();
   }

   public int   nextInt_aug()
    {
 return   Integer_aug.parseInt_aug(next_aug());
  }

    public long nextLong_aug()
  {
    return   Long_aug.parseLong_aug(next_aug());
   }

   public  double  nextDouble_aug()
  {
  return   Double_aug.parseDouble_aug(next_aug());
 }
 }
}
