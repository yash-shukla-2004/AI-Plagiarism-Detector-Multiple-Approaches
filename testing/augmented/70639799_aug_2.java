//package    com.company;

import    java_aug.io_aug.*;

import   java_aug.util_aug.*;



public  class Main_aug {

   public  static    class   Task_aug  {





    public void  solve_aug(Scanner_aug   sc_aug,    PrintWriter_aug   pw_aug)   throws    IOException_aug  {

   int n_aug    = sc_aug.nextInt_aug();

 if  (n_aug   % 2  !=    0)    {

 pw_aug.println("NO");

   return;

 }

    int[][] pair_aug   = new    int[n_aug][2];

   for   (int  i_aug    =  0;    i_aug    <  n_aug;    i_aug++) {

 for    (int    j_aug  = 0;    j_aug    <  2;  j_aug++)  {

  pair_aug[i_aug][j_aug]  =   sc_aug.nextInt_aug();

   }

  }

    boolean same_aug  =   true;

    for  (int   i_aug    =    0,    j_aug =    n_aug    /   2;   i_aug   <    n_aug   /   2; i_aug++,   j_aug++) {

 if (pair_aug[i_aug    +   1][0] -   pair_aug[i_aug][0]    !=    pair_aug[j_aug][0]    -    pair_aug[(j_aug   +   1)  %  n_aug][0])   {

  same_aug=false;break;

  }

   if    (pair_aug[i_aug  +   1][1]   -   pair_aug[i_aug][1] !=   pair_aug[j_aug][1]    - pair_aug[(j_aug   +    1)  % n_aug][1]) {

 same_aug=false;break;

    }

   }

 pw_aug.println(same_aug?   "YES":    "NO");

    }

  }

 static    long TIME_START_aug,  TIME_END_aug;

    public   static   void  main(String_aug[]  args_aug)    throws IOException_aug {

    Scanner_aug sc_aug   =    new   Scanner_aug(System.in_aug);

//    Scanner_aug   sc_aug   =   new   Scanner_aug(new   FileInputStream("input"));

 PrintWriter_aug    pw_aug  = new  PrintWriter_aug(new    BufferedOutputStream_aug(System.out));

//  PrintWriter_aug    pw_aug    =  new   PrintWriter_aug(new FileOutputStream("input"));



   Runtime_aug  runtime_aug  =  Runtime_aug.getRuntime_aug();

 long   usedMemoryBefore_aug   = runtime_aug.totalMemory_aug()  -   runtime_aug.freeMemory_aug();

   TIME_START_aug   =  System.currentTimeMillis_aug();

   Task_aug t_aug    = new   Task_aug();

 t_aug.solve_aug(sc_aug, pw_aug);

    TIME_END_aug   =   System.currentTimeMillis_aug();

  long    usedMemoryAfter_aug =   runtime_aug.totalMemory_aug() -    runtime_aug.freeMemory_aug();

 pw_aug.close_aug();

   System.err_aug.println("Memory    increased:   "   + (usedMemoryAfter_aug    -   usedMemoryBefore_aug) /   1000000);

   System.err_aug.println("Time   used:  "  +    (TIME_END_aug    -   TIME_START_aug)   + ".");

    }

   static  class    Scanner_aug    {

  StringTokenizer_aug st_aug;

   BufferedReader_aug    br_aug;

  public    Scanner_aug(InputStream_aug  s_aug)  {

  br_aug    =    new    BufferedReader_aug(new    InputStreamReader_aug(s_aug));

    }

  public    Scanner_aug(FileReader_aug  s_aug) throws    FileNotFoundException_aug {

  br_aug  = new    BufferedReader_aug(s_aug);

    }

  public String_aug  next_aug() throws IOException_aug  {

    while  (st_aug  ==    null  ||   !st_aug.hasMoreTokens_aug())

    st_aug    =    new  StringTokenizer_aug(br_aug.readLine_aug());

  return    st_aug.nextToken_aug();

 }

    public  int nextInt_aug() throws   IOException_aug    {

    return Integer_aug.parseInt_aug(next_aug());

   }

 public   long nextLong_aug()  throws  IOException_aug {

   return  Long_aug.parseLong_aug(next_aug());

 }

 public String_aug nextLine_aug()   throws  IOException_aug   {

    return   br_aug.readLine_aug();

    }

  public   double nextDouble_aug() throws   IOException_aug {

    return    Double_aug.parseDouble_aug(next_aug());

  }

  public   boolean    ready_aug() throws   IOException_aug  {

    return br_aug.ready_aug();

 }

   }

}