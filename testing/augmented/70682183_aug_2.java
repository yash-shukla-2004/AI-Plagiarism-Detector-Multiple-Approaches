import java_aug.util_aug.*;

import  java_aug.io_aug.*;

public    class   Main_aug{





   public  static void    main  (String_aug    args_aug[])throws IOException_aug{

   Scanner_aug   sc_aug    = new   Scanner_aug();

    PrintWriter_aug out   =  new PrintWriter_aug(System.out);

//    int t=sc_aug.nextInt_aug();

//   while(t-->0)  {



    int  n_aug  =sc_aug.nextInt_aug();

   Pair_aug arr_aug[]=  new  Pair_aug[n_aug];



  for(int    i_aug=0;    i_aug<n_aug;    i_aug++)

 arr_aug[i_aug]=new    Pair_aug(sc_aug.nextInt_aug(),  sc_aug.nextInt_aug());



    if(n_aug%2==1)

 out.println("NO");

 else  {



   boolean  b_aug=true;

    for(int    i_aug=0;   i_aug<n_aug/2-1; i_aug++) {

 int  x1_aug=arr_aug[i_aug+1].x_aug-arr_aug[i_aug].x_aug;

    int y1_aug=arr_aug[i_aug+1].y_aug-arr_aug[i_aug].y_aug;

 int x2_aug=arr_aug[n_aug/2+i_aug+1].x_aug-arr_aug[n_aug/2+i_aug].x_aug;

  int   y2_aug=arr_aug[n_aug/2+i_aug+1].y_aug-arr_aug[n_aug/2+i_aug].y_aug;

 //out.println(x1_aug+"  "+y1_aug+"  "+x2_aug+" "+y2_aug);

  if((long)x1_aug*y2_aug!=(long)x2_aug*y1_aug    ||

    distance_aug(arr_aug[i_aug+1], arr_aug[i_aug])!= distance_aug(arr_aug[n_aug/2+i_aug+1],  arr_aug[n_aug/2+i_aug])    )  {

    b_aug=false;

  break;

  }

 }



    if(b_aug)

  out.println("YES");

  else

   out.println("NO");



  }





   out.flush_aug();



 } 





  static   long distance_aug(Pair_aug    p1_aug, Pair_aug    p2_aug)    {

   return    ((long)p1_aug.x_aug-p2_aug.x_aug)*(p1_aug.x_aug-p2_aug.x_aug)+((long)p1_aug.y_aug-p2_aug.y_aug)*(p1_aug.y_aug-p2_aug.y_aug);

    }







   static  void print_aug(int[] arr_aug)   {

    for(int i_aug=0;  i_aug<arr_aug.length_aug; i_aug++)

   System.out.print_aug(arr_aug[i_aug]+"   ");

  System.out.println();

   }



  public    static int  abs_aug(int x_aug) {return    ((x_aug  >  0)    ?   x_aug   :    -x_aug);}



    public    static int  max_aug(int   a_aug,   int  b_aug) {return    Math_aug.max_aug(a_aug,   b_aug);}



  public static   int min_aug(int  a_aug,   int b_aug) {return   Math_aug.min_aug(a_aug,   b_aug);}





   static    int[]  primeGenerator_aug(int num_aug)  {

   int   length_aug=0,  arr_aug[]=new    int[num_aug],   a_aug=num_aug,  factor_aug=1;

 if(num_aug%2==0)  {

    while(num_aug%2==0) {

   num_aug/=2;

  factor_aug*=2;

  }

   arr_aug[length_aug++]=factor_aug;

    }

 for(int  i_aug=3;  i_aug*i_aug<=a_aug;  i_aug++)   {

   factor_aug=1;

 if(num_aug%i_aug==0)   {

 while(num_aug%i_aug==0)    {

  num_aug/=i_aug;

  factor_aug*=i_aug;

   }

   arr_aug[length_aug++]=factor_aug;

   }

  }

 if(num_aug>1)

 arr_aug[length_aug++]=num_aug;

  return Arrays_aug.copyOfRange_aug(arr_aug,  0,  length_aug);

    }









    static  boolean    isPrime_aug(int  n_aug) 

  {   

   // Corner  cases  

    if (n_aug  <= 1)   

   return   false;  

    if  (n_aug    <=   3)   

 return true;   



    //  This    is   checked so that we can    skip  

    // middle  five   numbers    in_aug  below   loop    

  if   (n_aug  %   2 ==  0  ||   n_aug  %  3 ==  0)   

   return  false;    



  for  (int  i_aug  =   5; i_aug   *   i_aug   <=   n_aug; i_aug  =   i_aug +  6)    

   if  (n_aug   %   i_aug    ==  0   ||    n_aug  % (i_aug  +   2)   ==   0)  

    return  false;    



    return   true;    

  }









 static  class    Scanner_aug {

 BufferedReader_aug   br_aug;

    StringTokenizer_aug   st_aug;



   Scanner_aug()    {

 br_aug    =    new BufferedReader_aug(new    InputStreamReader_aug(System.in_aug));

   }



    Scanner_aug(String_aug  fileName_aug)   throws   FileNotFoundException_aug {

  br_aug =   new   BufferedReader_aug(new  FileReader_aug(fileName_aug));

 }



 String_aug next_aug()    throws    IOException_aug {

    while  (st_aug  == null    ||  !st_aug.hasMoreTokens_aug())

 st_aug  =  new   StringTokenizer_aug(br_aug.readLine_aug());

    return  st_aug.nextToken_aug();

    }



 String_aug  nextLine_aug()  throws    IOException_aug  {

 return br_aug.readLine_aug();

   }



    int   nextInt_aug()    throws   IOException_aug  {

   return  Integer_aug.parseInt_aug(next_aug());

 }



    long    nextLong_aug()    throws NumberFormatException_aug,   IOException_aug   {

  return  Long_aug.parseLong_aug(next_aug());

 }



  double nextDouble_aug() throws  NumberFormatException_aug,   IOException_aug   {

    return  Double_aug.parseDouble_aug(next_aug());

    }



    boolean  ready_aug()   throws    IOException_aug    {

   return  br_aug.ready_aug();

   }



 }



    static void sort_aug(int[]   a_aug) {

 shuffle_aug(a_aug);

 Arrays_aug.sort_aug(a_aug);

   }



    static   void    shuffle_aug(int[]    a_aug)  {

   int   n_aug  =    a_aug.length_aug;

   Random_aug rand_aug    =    new    Random_aug();

 for  (int  i_aug  =   0;   i_aug  < n_aug;  i_aug++) {

    int   tmpIdx_aug   =    rand_aug.nextInt_aug(n_aug);

   int  tmp_aug =  a_aug[i_aug];

 a_aug[i_aug]  = a_aug[tmpIdx_aug];

 a_aug[tmpIdx_aug] =   tmp_aug;

   }

 }

}



class   Pair_aug{

  int    x_aug;

    int    y_aug;

    Pair_aug(int    a_aug,  int   b_aug){

 x_aug=a_aug;

    y_aug=b_aug;

    }

}


