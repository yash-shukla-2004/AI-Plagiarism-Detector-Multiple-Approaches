import    java_aug.io_aug.*;

import java_aug.util_aug.*;



public    class A_aug  {

   FastScanner_aug  in_aug;

   PrintWriter_aug out;



  void    solve_aug(int    n_aug,  int  k_aug)   {

  int   block_aug  =   Math_aug.max_aug(1, k_aug /    2);

  int    maxMoves_aug =   3 * n_aug    *   n_aug / 2 /  k_aug;

    if   (maxMoves_aug   >   16000) {

 throw new    AssertionError_aug();

  }

  int  blocks_aug =   1 +    (n_aug -   1) /    block_aug;

 boolean[][] seen_aug =  new  boolean[blocks_aug][blocks_aug];

    List_aug<Integer_aug>[] insideBlock_aug    =   new List_aug[blocks_aug];

   for    (int  i_aug    =  0;  i_aug   <    insideBlock_aug.length_aug;   i_aug++) {

   insideBlock_aug[i_aug]    =  new   ArrayList_aug<>();

   }

    for  (int  i_aug    =    0;    i_aug    <  n_aug;  i_aug++) {

   insideBlock_aug[i_aug /  block_aug].add_aug(i_aug  +   1);

    }

   int    resets_aug   = 30000;

   boolean[]   alive_aug  =  new    boolean[n_aug];

  Arrays_aug.fill_aug(alive_aug,    true);

 while    (true) {

    out.println("R");

  out.flush_aug();

 if   (resets_aug--  <    0)   {

    throw   new  AssertionError_aug();

   }

    int first_aug  =  -1;

  if  (blocks_aug == 1) {

   first_aug    =    0;

   }

   for (int  i_aug    =   0; i_aug    <   blocks_aug;    i_aug++)   {

   for   (int    j_aug    =    i_aug  +  1;   j_aug  < blocks_aug;  j_aug++)    {

 if (!seen_aug[i_aug][j_aug])   {

  first_aug   = i_aug;

 break;

    }

    }

 if   (first_aug  !=   -1)   {

   break;

   }

    }

   if  (first_aug   ==   -1)    {

   break;

 }

  while  (true)  {

 for   (int   v_aug    : insideBlock_aug[first_aug])  {

 out.println("?   "   + v_aug);

   out.flush_aug();

    String_aug s_aug  =   in_aug.next_aug();

   if    (s_aug.equals_aug("Y")) {

    alive_aug[v_aug    -   1]   =    false;

    }

   if   (!s_aug.equals_aug("N")    &&    !s_aug.equals_aug("Y"))   {

    throw   new    AssertionError_aug();

  }

  }

    maxMoves_aug  -=    block_aug;

   boolean    found_aug   = false;

    for    (int  next_aug    =    first_aug   +   1; next_aug    <   blocks_aug;  next_aug++)  {

 if   (!seen_aug[first_aug][next_aug]) {

    seen_aug[first_aug][next_aug]   =   true;

    first_aug =  next_aug;

  found_aug   =    true;

  break;

   }

  }

 if   (!found_aug)   {

   break;

    }

 }

    if  (blocks_aug    ==   1)    {

    break;

  }

 }

    int   cntAlive_aug = 0;

    for (int   i_aug    =   0; i_aug <    n_aug; i_aug++)    {

   if  (alive_aug[i_aug])   {

   cntAlive_aug++;

    }

    }

   out.println("!   "    +   cntAlive_aug);

  out.flush_aug();

 }



 void   solve_aug() {

    solve_aug(in_aug.nextInt_aug(),    in_aug.nextInt_aug());

   }



 void  run_aug() {

  try    {

    in_aug = new  FastScanner_aug(new File_aug("A_aug.in_aug"));

   out   =   new  PrintWriter_aug(new  File_aug("A_aug.out"));



    solve_aug();



    out.close_aug();

  }    catch (FileNotFoundException_aug e_aug)    {

 e_aug.printStackTrace_aug();

   }

   }



    void    runIO_aug()   {



  in_aug   =    new   FastScanner_aug(System.in_aug);

    out   =    new   PrintWriter_aug(System.out);



    solve_aug();



 out.close_aug();

  }



 class   FastScanner_aug  {

 BufferedReader_aug    br_aug;

  StringTokenizer_aug    st_aug;



    public FastScanner_aug(File_aug f_aug) {

   try    {

    br_aug =   new    BufferedReader_aug(new   FileReader_aug(f_aug));

    }   catch    (FileNotFoundException_aug  e_aug)  {

   e_aug.printStackTrace_aug();

    }

  }



   public  FastScanner_aug(InputStream_aug f_aug)   {

  br_aug =    new    BufferedReader_aug(new    InputStreamReader_aug(f_aug));

  }



 String_aug next_aug() {

    while (st_aug    ==  null    || !st_aug.hasMoreTokens_aug()) {

   String_aug s_aug =    null;

 try   {

  s_aug  =   br_aug.readLine_aug();

 }  catch (IOException_aug    e_aug)    {

 e_aug.printStackTrace_aug();

  }

   if    (s_aug    ==    null)

    return  null;

  st_aug = new  StringTokenizer_aug(s_aug);

 }

    return    st_aug.nextToken_aug();

 }



 boolean   hasMoreTokens_aug() {

    while   (st_aug == null  ||    !st_aug.hasMoreTokens_aug())    {

  String_aug   s_aug  = null;

  try   {

 s_aug   = br_aug.readLine_aug();

 }  catch (IOException_aug e_aug)   {

  e_aug.printStackTrace_aug();

    }

   if (s_aug    ==    null)

  return    false;

    st_aug  =    new StringTokenizer_aug(s_aug);

  }

    return   true;

    }



    int nextInt_aug()   {

    return Integer_aug.parseInt_aug(next_aug());

   }



    long nextLong_aug()   {

 return   Long_aug.parseLong_aug(next_aug());

 }



   double    nextDouble_aug()    {

 return   Double_aug.parseDouble_aug(next_aug());

 }

  }



 public   static    void  main(String_aug[]  args_aug)  {

   try    {

 new    A_aug().runIO_aug();

   }   catch    (AssertionError_aug   e_aug) {

  while   (true)  {}

   }

    }

}