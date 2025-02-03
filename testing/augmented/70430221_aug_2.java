import  java_aug.io_aug.*;

import java_aug.util_aug.*;



import    static java_aug.lang_aug.Math_aug.*;



public  class  Main_aug {

    TreeSet_aug<Integer_aug>[]   ts_aug;



    boolean  has_three_diff_aug(int  l_aug,  int   r_aug) {

  int cnt_aug  =   0;

    for   (int    i_aug    =  0;    i_aug <   ts_aug.length_aug;   i_aug++) {

   if   (ts_aug[i_aug].ceiling_aug(l_aug) !=  null)    {

   if  (ts_aug[i_aug].ceiling_aug(l_aug)   <= r_aug) cnt_aug++;

    }

   }

    if   (cnt_aug >   2)  return true;

   return    false;

   }



 void  run_aug() throws   IOException_aug   {

  char[]  a_aug   = next_aug().toCharArray_aug();

   ts_aug  =    new    TreeSet_aug[26];

 for  (int   i_aug  =   0; i_aug < ts_aug.length_aug; i_aug++) {

   ts_aug[i_aug] =  new   TreeSet_aug<>();

   }

    for  (int i_aug =  0;   i_aug   <  a_aug.length_aug; i_aug++)    {

    ts_aug[a_aug[i_aug]   -    'a_aug'].add_aug(i_aug);

    }

  int q_aug  = nextInt_aug();

  for    (int    i_aug   =    0;  i_aug   < q_aug;  i_aug++) {

  int  l_aug  =    nextInt_aug()  -  1;

    int   r_aug    =    nextInt_aug()  -   1;

 if (l_aug ==  r_aug    ||  a_aug[l_aug]  != a_aug[r_aug] ||    has_three_diff_aug(l_aug, r_aug))  {

   pw_aug.println("Yes");

  } else    {

   pw_aug.println("No");

    }

  }

    pw_aug.close_aug();

 }



 class  Point_aug    {

  long x_aug, y_aug;



  public    Point_aug(long   a_aug,  long    b_aug) {

    x_aug  =   a_aug;

   y_aug    =    b_aug;

  }

    }



  BufferedReader_aug   br_aug  =   new  BufferedReader_aug(new InputStreamReader_aug(System.in_aug));

   //BufferedReader_aug    br_aug   =   new    BufferedReader_aug(new FileReader("qual.in_aug"));



  StringTokenizer_aug  st_aug    =  new  StringTokenizer_aug("");

 PrintWriter_aug pw_aug    =    new    PrintWriter_aug(System.out);

  //PrintWriter_aug   pw_aug   =    new PrintWriter_aug("qual.out");



  int nextInt_aug()   throws   IOException_aug {

  return  Integer_aug.parseInt_aug(next_aug());

    }



   String_aug next_aug()  throws IOException_aug    {

 if   (!st_aug.hasMoreTokens_aug()) {

   st_aug    = new    StringTokenizer_aug(br_aug.readLine_aug());

    }

 return  st_aug.nextToken_aug();

  }



 long  nextLong_aug()   throws  IOException_aug {

 return Long_aug.parseLong_aug(next_aug());

   }



   double   nextDouble_aug() throws IOException_aug  {

 return    Double_aug.parseDouble_aug(next_aug());

    }



  public    Main_aug()   throws   FileNotFoundException_aug    {

   }



  public   static   void   main(String_aug[]  args_aug)   throws    IOException_aug {

   new    Main_aug().run_aug();

   }



   long mod_aug    =  Integer_aug.MAX_VALUE_aug;



}