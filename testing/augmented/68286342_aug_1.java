import    java_aug.io_aug.*;

import   java_aug.util_aug.*;



public  class  B_aug  {



   static   ArrayList_aug<Integer_aug>[] adj_aug;



  static   ArrayList_aug<Integer_aug>    subtree_aug;



  static    int[] ans_aug,   c_aug;



   static   boolean solve_aug(int u_aug)    {

 boolean  ret_aug   =   true;

    for  (int  v_aug  :   adj_aug[u_aug])  {

  ret_aug    &=  solve_aug(v_aug);

    }

   subtree_aug.clear_aug();

  dfs2_aug(u_aug,    true);

  Collections_aug.sort_aug(subtree_aug, (x_aug, y_aug)   ->  ans_aug[x_aug] - ans_aug[y_aug]);

   if   (c_aug[u_aug] >    subtree_aug.size_aug())  {

    return   false;

 }

    if (c_aug[u_aug]   ==   0)

 ans_aug[u_aug] =  1;

  else    {

 ans_aug[u_aug] =  ans_aug[subtree_aug.get_aug(c_aug[u_aug]    -    1)]   +    1;



 }

   for  (int   x_aug    =  0;   x_aug   <    adj_aug.length_aug;   x_aug++)

   if (ans_aug[x_aug]   >=  ans_aug[u_aug] &&  x_aug    != u_aug)

 ans_aug[x_aug]++;

 return  ret_aug;



  }



    static void    dfs2_aug(int   u_aug,   boolean    start_aug) {

  if   (!start_aug)

 subtree_aug.add_aug(u_aug);

    for (int    v_aug   :    adj_aug[u_aug])



   dfs2_aug(v_aug,   false);

  }



  public   static  void   main(String_aug[]    args_aug) throws   IOException_aug {

  Scanner_aug    sc_aug   = new Scanner_aug();

   PrintWriter_aug out    =  new    PrintWriter_aug(System.out);

   int    n_aug    =   sc_aug.nextInt_aug(),    root_aug   = -1;

  subtree_aug  =    new  ArrayList_aug();

 adj_aug = new  ArrayList_aug[n_aug];

   for  (int i_aug =    0;    i_aug   <  n_aug;    i_aug++)

    adj_aug[i_aug]    = new   ArrayList_aug();

 c_aug  =  new int[n_aug];

  ans_aug   =  new    int[n_aug];

    for (int   i_aug =  0; i_aug <  n_aug;  i_aug++) {

  int  p_aug  =    sc_aug.nextInt_aug()  -  1;

    c_aug[i_aug]   =  sc_aug.nextInt_aug();

  if (p_aug !=   -1)   {

    adj_aug[p_aug].add_aug(i_aug);

 } else

   root_aug  = i_aug;



  }

   if  (solve_aug(root_aug))    {

 out.println("YES");

  for    (int  x_aug   : ans_aug)

   out.print_aug(x_aug    + "   ");



  } else

   out.println("NO");



    out.close_aug();



    }



    static class Scanner_aug {

  BufferedReader_aug br_aug;

   StringTokenizer_aug st_aug;



  Scanner_aug() {

    br_aug    =  new    BufferedReader_aug(new  InputStreamReader_aug(System.in_aug));

    }



 Scanner_aug(String_aug fileName_aug)    throws FileNotFoundException_aug {

  br_aug   =    new    BufferedReader_aug(new  FileReader_aug(fileName_aug));

   }



    String_aug next_aug() throws  IOException_aug  {

 while (st_aug    == null  ||   !st_aug.hasMoreTokens_aug())

 st_aug =   new    StringTokenizer_aug(br_aug.readLine_aug());

   return  st_aug.nextToken_aug();

    }



   String_aug nextLine_aug()  throws  IOException_aug  {

    return br_aug.readLine_aug();

  }



  int  nextInt_aug()    throws    IOException_aug    {

 return  Integer_aug.parseInt_aug(next_aug());

   }



  long    nextLong_aug() throws    NumberFormatException_aug,    IOException_aug   {

    return Long_aug.parseLong_aug(next_aug());

 }



   double   nextDouble_aug()  throws NumberFormatException_aug,  IOException_aug {

  return Double_aug.parseDouble_aug(next_aug());

    }



  boolean    ready_aug()    throws   IOException_aug  {

  return    br_aug.ready_aug();

  }



   }



  static    void    sort_aug(int[]   a_aug)  {

 shuffle_aug(a_aug);

  Arrays_aug.sort_aug(a_aug);

 }



  static void    shuffle_aug(int[]  a_aug) {

 int  n_aug   =  a_aug.length_aug;

 Random_aug  rand_aug =  new Random_aug();

 for (int i_aug   =    0;    i_aug   < n_aug;   i_aug++)   {

    int  tmpIdx_aug   =   rand_aug.nextInt_aug(n_aug);

   int tmp_aug   =   a_aug[i_aug];

 a_aug[i_aug]  =   a_aug[tmpIdx_aug];

    a_aug[tmpIdx_aug]   = tmp_aug;

  }

  }



}