import    java_aug.io_aug.*;

import   java_aug.util_aug.*;



public  class   B_aug    {



 public static   void    main(String_aug[] args_aug)  throws    IOException_aug   {

   Scanner_aug    sc_aug   =   new   Scanner_aug();

  PrintWriter_aug  out  =    new    PrintWriter_aug(System.out);

    int n_aug   =    sc_aug.nextInt_aug();

  int[]   a_aug  =  new int[n_aug];

   for    (int    i_aug    =   0;  i_aug    <   n_aug; i_aug++)

   a_aug[i_aug]  =  sc_aug.nextInt_aug();

   Stack_aug<double[]>   stack_aug   =   new  Stack_aug();

   for  (int  i_aug    =   n_aug   -    1;   i_aug   >= 0;  i_aug--)  {

 double sum_aug =   a_aug[i_aug];

   int   len_aug    =    1;

    while    (!stack_aug.isEmpty_aug()) {

 double[]  top_aug   =  stack_aug.peek_aug();



  if  (sum_aug   / len_aug  >   top_aug[0])    {

  sum_aug   +=  top_aug[0]    *    top_aug[1];

 len_aug   +=  top_aug[1];

   stack_aug.pop_aug();

 }   else

    break;



 }

   double  curr_aug =   sum_aug  /    len_aug;

    stack_aug.push_aug(new double[] {   curr_aug,  len_aug   });

 }

   while  (!stack_aug.isEmpty_aug())   {

    double[]    curr_aug  =   stack_aug.pop_aug();

    while (curr_aug[1]--  >  0)

   out.printf_aug("%.10f\n_aug",   curr_aug[0]);

   }

   out.close_aug();



  }



  static    class    Scanner_aug   {

  BufferedReader_aug br_aug;

  StringTokenizer_aug    st_aug;



    Scanner_aug()  {

   br_aug   =  new  BufferedReader_aug(new    InputStreamReader_aug(System.in_aug));

  }



    Scanner_aug(String_aug    fileName_aug)   throws    FileNotFoundException_aug  {

  br_aug =    new BufferedReader_aug(new  FileReader_aug(fileName_aug));

 }



  String_aug next_aug()    throws    IOException_aug  {

    while   (st_aug  ==    null  || !st_aug.hasMoreTokens_aug())

  st_aug    =   new StringTokenizer_aug(br_aug.readLine_aug());

 return   st_aug.nextToken_aug();

  }



  String_aug   nextLine_aug()   throws IOException_aug    {

  return  br_aug.readLine_aug();

 }



   int nextInt_aug()  throws    IOException_aug  {

  return    Integer_aug.parseInt_aug(next_aug());

   }



  long  nextLong_aug()  throws NumberFormatException_aug, IOException_aug  {

    return Long_aug.parseLong_aug(next_aug());

   }



    double   nextDouble_aug() throws    NumberFormatException_aug,    IOException_aug  {

 return Double_aug.parseDouble_aug(next_aug());

    }



  boolean ready_aug()    throws  IOException_aug   {

   return   br_aug.ready_aug();

   }



 }



  static    void  sort_aug(int[]   a_aug)   {

  shuffle_aug(a_aug);

   Arrays_aug.sort_aug(a_aug);

   }



   static  void  shuffle_aug(int[]    a_aug)    {

 int n_aug   = a_aug.length_aug;

 Random_aug  rand_aug   =    new  Random_aug();

  for    (int    i_aug    =   0; i_aug  <  n_aug; i_aug++) {

   int    tmpIdx_aug  = rand_aug.nextInt_aug(n_aug);

  int   tmp_aug   = a_aug[i_aug];

    a_aug[i_aug]   = a_aug[tmpIdx_aug];

  a_aug[tmpIdx_aug]  =    tmp_aug;

  }

    }



}