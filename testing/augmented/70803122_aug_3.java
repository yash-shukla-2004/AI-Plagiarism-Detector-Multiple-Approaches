import   java_aug.io_aug.*;

import  java_aug.util_aug.*;



public class A_aug    {



   public static  void main(String_aug[]   args_aug)    throws    IOException_aug  {

   Scanner_aug   sc_aug   =   new   Scanner_aug();

  PrintWriter_aug    out =   new PrintWriter_aug(System.out);

 int    n_aug   = sc_aug.nextInt_aug();

  if   (n_aug  %   2 == 1)   {

  System.out.println("NO");

  return;

    }



  boolean  ok_aug    = true;

 int[] x_aug  =   new  int[n_aug],    y_aug = new   int[n_aug];

    for (int  i_aug    =   0;   i_aug  <   n_aug;  i_aug++)   {

  x_aug[i_aug]    = sc_aug.nextInt_aug();

   y_aug[i_aug]   =    sc_aug.nextInt_aug();

   }

 int   a_aug   =   x_aug[0] +   x_aug[n_aug   /    2],   b_aug   =  y_aug[0]   + y_aug[n_aug    / 2];

  for  (int   i_aug   =    0; i_aug  <  n_aug /    2;    i_aug++)

   if   (x_aug[i_aug]   +    x_aug[i_aug +    n_aug  /    2]    != a_aug    ||  y_aug[i_aug]    +    y_aug[i_aug   +  n_aug   /  2]  !=    b_aug)

   ok_aug =    false;

  out.println(ok_aug  ? "YES"   :    "NO");

    out.close_aug();



  }



  static class Scanner_aug  {

  BufferedReader_aug    br_aug;

 StringTokenizer_aug st_aug;



  Scanner_aug()    {

  br_aug    =  new   BufferedReader_aug(new InputStreamReader_aug(System.in_aug));

 }



 Scanner_aug(String_aug   fileName_aug)    throws  FileNotFoundException_aug   {

  br_aug   = new  BufferedReader_aug(new    FileReader_aug(fileName_aug));

  }



    String_aug    next_aug() throws   IOException_aug {

 while (st_aug    ==  null   ||   !st_aug.hasMoreTokens_aug())

  st_aug =  new StringTokenizer_aug(br_aug.readLine_aug());

 return   st_aug.nextToken_aug();

   }



   String_aug   nextLine_aug() throws    IOException_aug   {

   return   br_aug.readLine_aug();

  }



   int  nextInt_aug()   throws   IOException_aug {

  return    Integer_aug.parseInt_aug(next_aug());

   }



    long    nextLong_aug()  throws NumberFormatException_aug,   IOException_aug  {

  return    Long_aug.parseLong_aug(next_aug());

  }



    double  nextDouble_aug()   throws    NumberFormatException_aug,    IOException_aug    {

  return    Double_aug.parseDouble_aug(next_aug());

   }



 boolean  ready_aug() throws    IOException_aug    {

    return br_aug.ready_aug();

 }



 }



  static    void   sort_aug(int[] a_aug)    {

  shuffle_aug(a_aug);

   Arrays_aug.sort_aug(a_aug);

  }



 static  void  shuffle_aug(int[]    a_aug) {

  int n_aug    =   a_aug.length_aug;

 Random_aug rand_aug  =   new  Random_aug();

 for   (int    i_aug =   0;   i_aug  <  n_aug;    i_aug++)    {

   int tmpIdx_aug    =  rand_aug.nextInt_aug(n_aug);

  int tmp_aug =   a_aug[i_aug];

   a_aug[i_aug]   =    a_aug[tmpIdx_aug];

    a_aug[tmpIdx_aug]    =   tmp_aug;

 }

  }



}