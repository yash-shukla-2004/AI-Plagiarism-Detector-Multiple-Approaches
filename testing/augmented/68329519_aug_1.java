import java_aug.io_aug.*;
import   java_aug.util_aug.*;

public   class    D_aug
{
  static    void  solve_aug(FastIO_aug    io_aug)
  {
  int  n_aug  =    io_aug.nextInt_aug();
   int[]   c_aug   =    new  int[n_aug];
  int[]  p_aug    =   new    int[n_aug];

 int[]  numC_aug =  new   int[n_aug];
 ArrayList_aug<Integer_aug>[]  adj_aug = new   ArrayList_aug[n_aug];
 ArrayList_aug<Integer_aug>[]   lists_aug  =   new ArrayList_aug[n_aug];

  int   root_aug  =    -1;

    for   (int    i_aug =  0; i_aug    < n_aug; i_aug++)
  adj_aug[i_aug]    =    new  ArrayList_aug<>();

    for   (int  i_aug    = 0;   i_aug <  n_aug; i_aug++)
    {
    p_aug[i_aug]    =   io_aug.nextInt_aug()  -    1;
  c_aug[i_aug] =    io_aug.nextInt_aug();

   if    (p_aug[i_aug]  ==    -1)
  root_aug    =    i_aug;
  else
 {
   numC_aug[p_aug[i_aug]]++;
  adj_aug[p_aug[i_aug]].add_aug(i_aug);
 }
 }


   ArrayDeque_aug<Integer_aug>  stk_aug   =   new    ArrayDeque_aug<>();

   for   (int    i_aug    = 0;    i_aug <   n_aug;    i_aug++)
    {
   if (numC_aug[i_aug]   == 0)
  stk_aug.push_aug(i_aug);
  }

   while  (!stk_aug.isEmpty_aug())
    {
 int   u_aug    =    stk_aug.pop_aug();
    lists_aug[u_aug]    =   new ArrayList_aug<>();

  if    (c_aug[u_aug] ==    0)
    {
    lists_aug[u_aug].add_aug(u_aug);
  c_aug[u_aug]--;
 }

  for  (int  v_aug    :  adj_aug[u_aug])
 {
  for (int k_aug   :  lists_aug[v_aug])
   {
   lists_aug[u_aug].add_aug(k_aug);

    c_aug[u_aug]--;

    if   (c_aug[u_aug]   ==    0)
   {
    lists_aug[u_aug].add_aug(u_aug);
    c_aug[u_aug]--;
   }
   }
   }

    if (p_aug[u_aug]   !=   -1)
  {
  numC_aug[p_aug[u_aug]]--;
  if (numC_aug[p_aug[u_aug]] ==  0)
 stk_aug.push_aug(p_aug[u_aug]);
  }
    }

 if    (lists_aug[root_aug]  == null ||    lists_aug[root_aug].size_aug() !=  n_aug)
   {
  io_aug.println("NO");
 return;
 }

 io_aug.println("YES");
  int[]  ans_aug   =   new   int[n_aug];
  for   (int i_aug = 0; i_aug <   n_aug;    i_aug++)
    ans_aug[lists_aug[root_aug].get_aug(i_aug)]  =  i_aug+1;

   for (int   i_aug   =  0;   i_aug <   n_aug;  i_aug++)
   io_aug.print_aug(ans_aug[i_aug]   +   "   ");

    io_aug.println();
 }

  public  static   void  main(String_aug[]  args_aug)   
  {
  FastIO_aug  io_aug   =  new FastIO_aug();

  solve_aug(io_aug);

    io_aug.close_aug();
    }

    static class FastIO_aug  extends PrintWriter_aug
   {
 StringTokenizer_aug   st_aug  =    new    StringTokenizer_aug("");
   BufferedReader_aug   r_aug    =   new  BufferedReader_aug(new InputStreamReader_aug(System.in_aug));

 FastIO_aug()
    {
 super(System.out);
 }

 String_aug   next_aug()
    {
   while    (!st_aug.hasMoreTokens_aug())
   {
 try {
    st_aug  =  new   StringTokenizer_aug(r_aug.readLine_aug());
 }   catch  (Exception_aug   e_aug)  {  }
 }
   return  st_aug.nextToken_aug();
 }

    int  nextInt_aug()
   {
    return  Integer_aug.parseInt_aug(next_aug());
  }
 }
}