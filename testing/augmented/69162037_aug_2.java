import    java_aug.util_aug.*;

import    java_aug.io_aug.*;

public  class   D614_aug

{

  public  static  void  main(String_aug []    args_aug)    

    {

    MyScanner_aug sc_aug =   new MyScanner_aug();

  PrintWriter_aug out =   new    PrintWriter_aug(new BufferedOutputStream_aug(System.out));

  long x_0_aug  =    sc_aug.nextLong_aug();

   long    y_0_aug    =  sc_aug.nextLong_aug();

 long  a_x_aug   =   sc_aug.nextLong_aug();

  long    a_y_aug  =   sc_aug.nextLong_aug();

 long   b_x_aug  =   sc_aug.nextLong_aug();

 long  b_y_aug   =  sc_aug.nextLong_aug();

    long    x_s_aug  =   sc_aug.nextLong_aug();

    long   y_s_aug    = sc_aug.nextLong_aug();

    long  t_aug   =   sc_aug.nextLong_aug();



 long   LIMIT_aug  =  ((long)    1    <<    62)    -   1;

   ArrayList_aug <Long_aug>   x_aug    =   new  ArrayList_aug <Long_aug> ();

  ArrayList_aug    <Long_aug>    y_aug =    new   ArrayList_aug <Long_aug> ();

    x_aug.add_aug(x_0_aug);  y_aug.add_aug(y_0_aug);

 int index_aug = 0;

  while  ((LIMIT_aug  - b_x_aug) /    (a_x_aug)    >=    x_aug.get_aug(index_aug)  &&    (LIMIT_aug    -   b_y_aug) /  (a_y_aug)    >= y_aug.get_aug(index_aug))

   {

    x_aug.add_aug(a_x_aug    * x_aug.get_aug(index_aug) +   b_x_aug);

    y_aug.add_aug(a_y_aug  * y_aug.get_aug(index_aug)    +  b_y_aug);

 index_aug++;

 }





 int   ans_aug   =   0;

    for   (int   lo_aug  =    0;    lo_aug <= index_aug; lo_aug++)

  {

 for   (int hi_aug    = lo_aug;  hi_aug <=   index_aug;  hi_aug++)

    {

    long    hi_dist_aug   =  Math_aug.abs_aug(x_s_aug   -  x_aug.get_aug(hi_aug))  +   Math_aug.abs_aug(y_s_aug   -  y_aug.get_aug(hi_aug));

 long lo_dist_aug  =   Math_aug.abs_aug(x_s_aug   -  x_aug.get_aug(lo_aug))    +   Math_aug.abs_aug(y_s_aug -  y_aug.get_aug(lo_aug));

  long path_aug = x_aug.get_aug(hi_aug)   -    x_aug.get_aug(lo_aug)  +    y_aug.get_aug(hi_aug)  -   y_aug.get_aug(lo_aug);



   if (path_aug  <=    t_aug  -  lo_dist_aug    ||   path_aug  <=    t_aug -  hi_dist_aug)    ans_aug   =  Math_aug.max_aug(ans_aug, hi_aug  -  lo_aug + 1);

   }

   }



    out.println(ans_aug);

    out.close_aug();

 }





 //-----------MyScanner_aug   class for    faster    input----------

   public    static   class    MyScanner_aug

  {

    BufferedReader_aug  br_aug;

  StringTokenizer_aug   st_aug;



  public  MyScanner_aug()    {

  br_aug   =  new BufferedReader_aug(new   InputStreamReader_aug(System.in_aug));

  }



   String_aug   next_aug()  {

 while   (st_aug  ==    null  ||   !st_aug.hasMoreElements_aug())   {

    try   {

  st_aug =  new   StringTokenizer_aug(br_aug.readLine_aug());

    }    catch   (IOException_aug    e_aug)    {

  e_aug.printStackTrace_aug();

  }

  }

   return st_aug.nextToken_aug();

  }



    int    nextInt_aug() {

  return Integer_aug.parseInt_aug(next_aug());

  }



 long  nextLong_aug() {

  return Long_aug.parseLong_aug(next_aug());

   }



  double    nextDouble_aug()    {

   return    Double_aug.parseDouble_aug(next_aug());

 }



    String_aug   nextLine_aug(){

   String_aug  str_aug    =    "";

  try  {

 str_aug    =    br_aug.readLine_aug();

    }   catch    (IOException_aug  e_aug)    {

  e_aug.printStackTrace_aug();

 }

 return   str_aug;

    }







   }





}
