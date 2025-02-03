//package  com.company;

import   java_aug.io_aug.*;

import  java_aug.util_aug.*;



public   class Main_aug  {

 public   static  class   Task_aug  {





 public    void   solve_aug(Scanner_aug    sc_aug, PrintWriter_aug    pw_aug)    throws    IOException_aug {

 int  n_aug   =   sc_aug.nextInt_aug();

    int[]    numbers_aug    =  new    int[n_aug];

   for   (int    i_aug =   0;   i_aug <    n_aug;   i_aug++) {

  numbers_aug[i_aug]    =    sc_aug.nextInt_aug();

   }

    long[]   sum_aug   = new  long[n_aug];

  int[]    count_aug  =  new   int[n_aug];

 int idx_aug  =   0;

 for  (int   x_aug: numbers_aug)  {

  long curSum_aug    =  x_aug;

    int   curCount_aug   = 1;

   while    (idx_aug    >  0)   {

  long    p_aug  =    sum_aug[idx_aug    - 1];

 int  c_aug   =  count_aug[idx_aug  -   1];

 if (p_aug    * curCount_aug  >=  (long)  c_aug *   curSum_aug)   {

   curSum_aug   +=  p_aug;

  curCount_aug +=    c_aug;

    idx_aug--;

    }   else    {

   break;

  }

   }

 sum_aug[idx_aug]    = curSum_aug;

   count_aug[idx_aug]   =  curCount_aug;

  idx_aug++;

 }

    for (int   i_aug   =    0; i_aug  <   idx_aug;   i_aug++) {

   double   avg_aug   =   1.0 *  sum_aug[i_aug]   /  count_aug[i_aug];

  for    (int j_aug    =    0; j_aug    <  count_aug[i_aug];  j_aug++)    {

   pw_aug.println(avg_aug);

 }

  }

    }

    }

   static    long    TIME_START_aug,   TIME_END_aug;

   public   static void   main(String_aug[]    args_aug)   throws  IOException_aug   {

  Scanner_aug sc_aug    =   new  Scanner_aug(System.in_aug);

// Scanner_aug  sc_aug =  new Scanner_aug(new  FileInputStream("input"));

   PrintWriter_aug    pw_aug   = new   PrintWriter_aug(new    BufferedOutputStream_aug(System.out));

// PrintWriter_aug pw_aug   =   new   PrintWriter_aug(new    FileOutputStream("input"));



  Runtime_aug runtime_aug   = Runtime_aug.getRuntime_aug();

  long usedMemoryBefore_aug   =    runtime_aug.totalMemory_aug()    -    runtime_aug.freeMemory_aug();

  TIME_START_aug   =    System.currentTimeMillis_aug();

  Task_aug    t_aug   =    new  Task_aug();

    t_aug.solve_aug(sc_aug, pw_aug);

  TIME_END_aug  =   System.currentTimeMillis_aug();

  long    usedMemoryAfter_aug   =   runtime_aug.totalMemory_aug()   -  runtime_aug.freeMemory_aug();

  pw_aug.close_aug();

  System.err_aug.println("Memory  increased: " +   (usedMemoryAfter_aug    -   usedMemoryBefore_aug)   /   1000000);

 System.err_aug.println("Time used:    " +   (TIME_END_aug -   TIME_START_aug)   + ".");

 }

 static    class  Scanner_aug   {

  StringTokenizer_aug st_aug;

 BufferedReader_aug    br_aug;

  public   Scanner_aug(InputStream_aug  s_aug)    {

    br_aug    =   new   BufferedReader_aug(new  InputStreamReader_aug(s_aug));

    }

 public Scanner_aug(FileReader_aug    s_aug) throws   FileNotFoundException_aug  {

   br_aug   =  new   BufferedReader_aug(s_aug);

 }

    public String_aug   next_aug()   throws IOException_aug   {

 while  (st_aug    ==  null  || !st_aug.hasMoreTokens_aug())

 st_aug   = new    StringTokenizer_aug(br_aug.readLine_aug());

  return    st_aug.nextToken_aug();

  }

  public  int   nextInt_aug()   throws   IOException_aug {

 return Integer_aug.parseInt_aug(next_aug());

   }

 public  long nextLong_aug()   throws   IOException_aug {

  return Long_aug.parseLong_aug(next_aug());

    }

  public    String_aug    nextLine_aug()  throws  IOException_aug    {

    return  br_aug.readLine_aug();

 }

   public double  nextDouble_aug()  throws   IOException_aug    {

  return  Double_aug.parseDouble_aug(next_aug());

 }

    public boolean ready_aug()    throws  IOException_aug  {

 return   br_aug.ready_aug();

   }

  }

}