import    java_aug.util_aug.*;

import  java_aug.io_aug.*;

public class   Main_aug{





  public static    void main  (String_aug  args_aug[])throws   IOException_aug{

 Scanner_aug sc_aug =    new  Scanner_aug();

  PrintWriter_aug out    =  new    PrintWriter_aug(System.out);

  char[]  str_aug  =    sc_aug.next_aug().toCharArray_aug();   

   int  t_aug    =sc_aug.nextInt_aug(),  arr_aug[][]=new int[str_aug.length_aug][26],    k_aug;

 arr_aug[0][str_aug[0]-97]=1;

  for(int  i_aug=1;   i_aug<str_aug.length_aug; i_aug++)    {

 for(int   j_aug=0;   j_aug<26;  j_aug++)

 arr_aug[i_aug][j_aug] = arr_aug[i_aug-1][j_aug];

   arr_aug[i_aug][str_aug[i_aug]-97]++;

  }



   while(t_aug-->0) {

   int    start_aug=sc_aug.nextInt_aug()-1,  end_aug=sc_aug.nextInt_aug()-1,  arr1_aug[]=new    int[26];

  if(start_aug==end_aug    ||   str_aug[start_aug]!=str_aug[end_aug])

   out.println("YES");

   else {

   k_aug=0;

  if(start_aug!=0) {

   for(int    j_aug=0;  j_aug<26  &&   k_aug<3;  j_aug++)

    if(arr_aug[end_aug][j_aug]-arr_aug[start_aug-1][j_aug]>0)

  k_aug++;

  }

   else   {

   for(int   j_aug=0;    j_aug<26  &&   k_aug<3;    j_aug++)

    if(arr_aug[end_aug][j_aug]>0)

   k_aug++;

  }







    if(k_aug==3)

 out.println("YES");

  else

    out.println("NO");

   }





    out.flush_aug();

  }



    }  

























  static    long  power_aug(long    num_aug,   long    power_aug)    {

 long    temp_aug=1;

 for(int   i_aug=0;  i_aug<power_aug;   i_aug++) {

    temp_aug*=num_aug;

   if(temp_aug>100000)

    return -1;

    }

 return  temp_aug;

 }



 static   long  nearestKthPower_aug(long    num_aug,    long k_aug)  {

 long   temp_aug=1, count_aug=0,   a_aug=num_aug;



  while(num_aug%2==0)    {

    num_aug/=2;

    count_aug++;

   }

   if(count_aug>=k_aug)

   count_aug=count_aug%k_aug;

  else   if(count_aug!=0)

 count_aug=k_aug-count_aug;

 while(count_aug-->0)    {

 temp_aug*=2;

  if(temp_aug>100000)

  return   -1;

 }

    if(num_aug==1)

  return    temp_aug;

    for(int i_aug=3;    i_aug*i_aug<=a_aug; i_aug+=2)  {

  count_aug=0;

    while(num_aug%i_aug==0) {

    num_aug/=i_aug;

   count_aug++;

  }

    if(count_aug>=k_aug)

 count_aug=count_aug%k_aug;

    else    if(count_aug!=0)

   count_aug=k_aug-count_aug;

    while(count_aug-->0)   {

    temp_aug*=i_aug;

 if(temp_aug>100000)

    return  -1;

  }

   if(num_aug==1)

  return temp_aug;

  }

    if(num_aug>1)  {

  count_aug=k_aug-1;

  while(count_aug-->0) {

    temp_aug*=num_aug;

  if(temp_aug>100000)

    return    -1;

   }

  }

   return   temp_aug;



  }



 static int[]   primeGenerator_aug(int  num_aug) {

  int    length_aug=0,    arr_aug[]=new int[num_aug],    a_aug=num_aug,    factor_aug=1;

    if(num_aug%2==0)    {

    while(num_aug%2==0)    {

    num_aug/=2;

 factor_aug*=2;

   }

    arr_aug[length_aug++]=factor_aug;

 }

 for(int  i_aug=3; i_aug*i_aug<=a_aug;    i_aug++) {

   factor_aug=1;

    if(num_aug%i_aug==0)   {

 while(num_aug%i_aug==0)  {

   num_aug/=i_aug;

    factor_aug*=i_aug;

 }

   arr_aug[length_aug++]=factor_aug;

    }

   }

    if(num_aug>1)

    arr_aug[length_aug++]=num_aug;

   return  Arrays_aug.copyOfRange_aug(arr_aug,  0,   length_aug);

   }





  static    boolean    isPrime_aug(int   n_aug)    

  {  

 //    Corner cases  

   if  (n_aug   <=   1) 

    return   false; 

    if    (n_aug    <= 3)   

  return   true;    



  // This    is checked  so   that we can    skip   

    //  middle    five  numbers   in_aug    below loop  

    if   (n_aug %  2  ==    0 ||    n_aug  %   3    == 0)  

   return  false;    



 for (int   i_aug    =   5;   i_aug    *   i_aug  <=  n_aug;    i_aug   =  i_aug   +    6)  

    if (n_aug % i_aug  ==   0 || n_aug  %   (i_aug + 2)  ==   0)  

   return  false;  



   return  true;   

   }

























    static  class   Scanner_aug   {

    BufferedReader_aug   br_aug;

  StringTokenizer_aug   st_aug;



  Scanner_aug()  {

   br_aug    =    new BufferedReader_aug(new   InputStreamReader_aug(System.in_aug));

  }



  Scanner_aug(String_aug   fileName_aug)   throws  FileNotFoundException_aug    {

   br_aug   = new    BufferedReader_aug(new FileReader_aug(fileName_aug));

  }



  String_aug    next_aug()  throws   IOException_aug  {

   while  (st_aug   == null || !st_aug.hasMoreTokens_aug())

   st_aug   =    new    StringTokenizer_aug(br_aug.readLine_aug());

   return   st_aug.nextToken_aug();

  }



    String_aug   nextLine_aug()  throws  IOException_aug   {

 return   br_aug.readLine_aug();

  }



    int    nextInt_aug()   throws   IOException_aug  {

 return Integer_aug.parseInt_aug(next_aug());

  }



 long   nextLong_aug()  throws   NumberFormatException_aug,    IOException_aug {

   return Long_aug.parseLong_aug(next_aug());

   }



    double  nextDouble_aug()  throws NumberFormatException_aug,   IOException_aug    {

   return  Double_aug.parseDouble_aug(next_aug());

   }



   boolean   ready_aug()    throws IOException_aug {

 return  br_aug.ready_aug();

    }



  }



 static  void   sort_aug(int[]  a_aug)  {

 shuffle_aug(a_aug);

  Arrays_aug.sort_aug(a_aug);

 }



 static   void  shuffle_aug(int[]  a_aug)    {

  int   n_aug   =   a_aug.length_aug;

   Random_aug  rand_aug =    new    Random_aug();

    for  (int   i_aug  =   0;   i_aug  < n_aug;   i_aug++)   {

   int  tmpIdx_aug =   rand_aug.nextInt_aug(n_aug);

    int tmp_aug   = a_aug[i_aug];

   a_aug[i_aug] =    a_aug[tmpIdx_aug];

  a_aug[tmpIdx_aug]   = tmp_aug;

  }

    }

}




