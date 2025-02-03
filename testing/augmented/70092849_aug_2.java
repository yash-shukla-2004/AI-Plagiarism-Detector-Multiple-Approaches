//package  com.company;



import java_aug.io_aug.*;

import    java_aug.util_aug.*;



public   class Main_aug  {

 public static   class   Task_aug {



 public class   DJS_aug   {

   int    n_aug;

    int[] arr_aug;

 int[] sizes_aug;

  int   unAssign_aug;

   public DJS_aug(int n_aug)   {

    this.n_aug    =    n_aug;

   arr_aug  =   new int[n_aug  *  2 + 2];

 sizes_aug    = new   int[n_aug * 2    +   2];

 Arrays_aug.fill_aug(arr_aug,  -1);

    Arrays_aug.fill_aug(sizes_aug,   0);

    for    (int i_aug =    0;    i_aug  <   n_aug;   i_aug++)   {

  sizes_aug[i_aug]  =    1;

  }

  unAssign_aug =   n_aug;

  }

  int find_aug(int   u_aug)  {

    return   arr_aug[u_aug]  < 0   ?    u_aug:   (arr_aug[u_aug]    = find_aug(arr_aug[u_aug]));

    }

  int   size_aug(int    u_aug)  {

  return   arr_aug[u_aug] <    0  ? sizes_aug[u_aug]:    0;

  }

  void  link_aug(int    a_aug,  int  b_aug)   {    //  b_aug   ->   a_aug

   int   ra_aug = find_aug(a_aug);

  int  rb_aug = find_aug(b_aug);

    if   (ra_aug    == rb_aug) return;

  sizes_aug[ra_aug]   +=   sizes_aug[rb_aug];

 arr_aug[rb_aug] =   ra_aug;

  }

    int   getOther_aug(int  k_aug)   {

  if  (k_aug  <    n_aug)  throw    new    RuntimeException_aug();

 int    v_aug   =    k_aug  -  (n_aug +  2);

  return    v_aug   %   2   ==   0    ?  k_aug +    1:  k_aug   - 1;

    }

  int  vv_aug(int   k_aug)    {

   if  (k_aug <    n_aug)    {

  throw   new  RuntimeException_aug();

  }

  if    (k_aug    ==    n_aug  ||   k_aug ==  n_aug    + 1) return 0;

  return   Math_aug.min_aug(size_aug(k_aug),   size_aug(getOther_aug(k_aug)));

    }

   int getEmp_aug() {

    return   (unAssign_aug  += 2);

 }



 }



  public  void    solve_aug(Scanner_aug  sc_aug,  PrintWriter_aug    pw_aug)    throws  IOException_aug {

   int   n_aug =   sc_aug.nextInt_aug();

 int    k_aug  =  sc_aug.nextInt_aug();

   String_aug  s_aug   =    sc_aug.next_aug();

   List_aug<Integer_aug>[] vs_aug   =    new List_aug[n_aug];

  for    (int i_aug    =    0;    i_aug  < n_aug;   i_aug++) {

    vs_aug[i_aug]    = new  ArrayList_aug<>();

    }

  for (int    i_aug  =  0;  i_aug    <    k_aug;   i_aug++)  {

   int  c_aug =    sc_aug.nextInt_aug();

    for (int  j_aug   = 0; j_aug   <   c_aug;  j_aug++)    {

    int  q_aug =   sc_aug.nextInt_aug()   -   1;

   vs_aug[q_aug].add_aug(i_aug);

  }

  }

  DJS_aug    djs_aug  = new    DJS_aug(k_aug);

  int  better_aug   =  0;

  for    (int  i_aug   =   0; i_aug < n_aug;  i_aug++) {

// System.err_aug.print(s_aug.charAt_aug(i_aug)    +   "   ");

  if  (vs_aug[i_aug].size_aug() ==   1) {

    int    u_aug  =    vs_aug[i_aug].get_aug(0);

 int    ru_aug =   djs_aug.find_aug(u_aug);

// System.err_aug.println(u_aug    + "   " + ru_aug);

   if   (ru_aug  ==  k_aug    ||  ru_aug   ==    k_aug + 1)  {



    } else    if   (ru_aug  <  k_aug)  {

   djs_aug.link_aug(s_aug.charAt_aug(i_aug) ==  '0' ? k_aug: k_aug    +   1,   u_aug);

    }  else {

    int   rup_aug   =    djs_aug.getOther_aug(ru_aug);

   better_aug  -=   djs_aug.vv_aug(ru_aug);

  djs_aug.link_aug(s_aug.charAt_aug(i_aug)    ==    '0'    ?    k_aug:   k_aug  + 1, ru_aug);

  djs_aug.link_aug(s_aug.charAt_aug(i_aug)  != '0'    ? k_aug:  k_aug  +    1,   rup_aug);

 }

   }   else   if   (vs_aug[i_aug].size_aug()   == 2)    {

 int u_aug =    vs_aug[i_aug].get_aug(0),   v_aug   =  vs_aug[i_aug].get_aug(1);

 int   ru_aug =   djs_aug.find_aug(u_aug),  rv_aug = djs_aug.find_aug(v_aug);

//    System.err_aug.println(u_aug   + "  " +    v_aug    +   "   "   +  ru_aug + "    "   +  rv_aug);

    if   (ru_aug   < k_aug   &&  rv_aug    <   k_aug)   {

  int   y_aug   =   djs_aug.getEmp_aug();

 if  (s_aug.charAt_aug(i_aug)    ==   '1')    {

 djs_aug.link_aug(ru_aug,    rv_aug);

 djs_aug.link_aug(y_aug, ru_aug);

   }   else  {

 djs_aug.link_aug(y_aug, ru_aug);

 djs_aug.link_aug(djs_aug.getOther_aug(y_aug),   rv_aug);

   }

  better_aug    +=    djs_aug.vv_aug(y_aug);

  }   else    if (ru_aug <  k_aug) {

   better_aug    -= djs_aug.vv_aug(rv_aug);

    if  (s_aug.charAt_aug(i_aug)  == '1')    {

   djs_aug.link_aug(rv_aug,   ru_aug);

  }    else {

    djs_aug.link_aug(djs_aug.getOther_aug(rv_aug), ru_aug);

 }

 better_aug +=    djs_aug.vv_aug(rv_aug);

   }   else if    (rv_aug <  k_aug)    {

   better_aug -=  djs_aug.vv_aug(ru_aug);

 if  (s_aug.charAt_aug(i_aug)    == '1')    {

    djs_aug.link_aug(ru_aug, rv_aug);

 }    else  {

    djs_aug.link_aug(djs_aug.getOther_aug(ru_aug),   rv_aug);

  }

 better_aug +=  djs_aug.vv_aug(ru_aug);

    } else {//    ru_aug   ->  rv_aug;

   if  (ru_aug    ==    rv_aug ||  ru_aug  ==   djs_aug.getOther_aug(rv_aug)) {



    }   else {

   if (rv_aug  > ru_aug) {

  int  tt_aug   =   rv_aug;  rv_aug =  ru_aug;   ru_aug  = tt_aug;

    }

  better_aug  -=   djs_aug.vv_aug(ru_aug);

   better_aug -=   djs_aug.vv_aug(rv_aug);

 if    (s_aug.charAt_aug(i_aug)  ==  '1')    {

 djs_aug.link_aug(rv_aug,    ru_aug);

 djs_aug.link_aug(djs_aug.getOther_aug(rv_aug),  djs_aug.getOther_aug(ru_aug));

   }    else    {

 djs_aug.link_aug(djs_aug.getOther_aug(rv_aug),    ru_aug);

    djs_aug.link_aug(rv_aug,   djs_aug.getOther_aug(ru_aug));

  }

    better_aug +=  djs_aug.vv_aug(rv_aug);

  }



   }

  }

   pw_aug.println(djs_aug.size_aug(k_aug) +    better_aug);

   }

  }

   }

 static    long    TIME_START_aug,  TIME_END_aug;

 public   static   void main(String_aug[] args_aug)  throws IOException_aug  {

 Scanner_aug   sc_aug   =    new    Scanner_aug(System.in_aug);

// Scanner_aug    sc_aug   =  new Scanner_aug(new    FileInputStream("joker.in_aug"));

  PrintWriter_aug pw_aug    =   new  PrintWriter_aug(new BufferedOutputStream_aug(System.out));

//    PrintWriter_aug pw_aug    =   new  PrintWriter_aug(new  FileOutputStream("joker.out"));



  Runtime_aug runtime_aug  =   Runtime_aug.getRuntime_aug();

   long    usedMemoryBefore_aug =    runtime_aug.totalMemory_aug() -  runtime_aug.freeMemory_aug();

  TIME_START_aug    =  System.currentTimeMillis_aug();

  Task_aug   t_aug = new   Task_aug();

   t_aug.solve_aug(sc_aug,    pw_aug);

    TIME_END_aug    =  System.currentTimeMillis_aug();

    long   usedMemoryAfter_aug   =   runtime_aug.totalMemory_aug()  -    runtime_aug.freeMemory_aug();

    pw_aug.close_aug();

  System.err_aug.println("Memory  increased:  "    +    (usedMemoryAfter_aug  - usedMemoryBefore_aug)  / 1000000);

 System.err_aug.println("Time   used:   "  +   (TIME_END_aug - TIME_START_aug)    +    ".");

 }

  static class    Scanner_aug {

  StringTokenizer_aug   st_aug;

  BufferedReader_aug  br_aug;

  public    Scanner_aug(InputStream_aug   s_aug)    {

  br_aug    = new   BufferedReader_aug(new    InputStreamReader_aug(s_aug));

   }

   public  Scanner_aug(FileReader_aug   s_aug)    throws  FileNotFoundException_aug {

   br_aug  =   new   BufferedReader_aug(s_aug);

 }

 public   String_aug   next_aug()   throws  IOException_aug {

  while  (st_aug  == null    ||    !st_aug.hasMoreTokens_aug())

   st_aug   =  new StringTokenizer_aug(br_aug.readLine_aug());

    return   st_aug.nextToken_aug();

    }

   public int   nextInt_aug()   throws    IOException_aug    {

 return   Integer_aug.parseInt_aug(next_aug());

   }

  public   long    nextLong_aug()  throws  IOException_aug   {

 return   Long_aug.parseLong_aug(next_aug());

    }

 public String_aug   nextLine_aug()   throws  IOException_aug   {

   return   br_aug.readLine_aug();

   }

  public    double    nextDouble_aug()   throws    IOException_aug    {

   return  Double_aug.parseDouble_aug(next_aug());

 }

   public boolean    ready_aug()   throws IOException_aug   {

   return br_aug.ready_aug();

 }

   }

}