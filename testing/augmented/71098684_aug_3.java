;

import java_aug.util_aug.*;

import   java_aug.io_aug.*;

import   static java_aug.lang_aug.Long_aug.max_aug;

import  static  java_aug.lang_aug.Math_aug.abs_aug;

import    static  java_aug.lang_aug.Math_aug.pow_aug;

public   class Main_aug {

 static    FastReader_aug  in_aug=new    FastReader_aug();

    public static    void main(String_aug    []   args_aug)  {

    long   x_aug=in_aug.nextLong_aug(),y_aug=in_aug.nextLong_aug(),ax_aug=in_aug.nextLong_aug(),ay_aug=in_aug.nextLong_aug(),bx_aug=in_aug.nextLong_aug(),by_aug=in_aug.nextLong_aug();

 long    xs_aug=in_aug.nextLong_aug(),ys_aug=in_aug.nextLong_aug(),t_aug=in_aug.nextLong_aug();

  ArrayList_aug<Long_aug>xx_aug=new   ArrayList_aug(),yy_aug=new  ArrayList_aug();

    xx_aug.add_aug(x_aug);yy_aug.add_aug(y_aug);

    for(;xx_aug.get_aug(xx_aug.size_aug()-1)<=(((Long_aug.MAX_VALUE_aug-1)/ax_aug)-bx_aug)&&yy_aug.get_aug(yy_aug.size_aug()-1)<=(((Long_aug.MAX_VALUE_aug-1)/ay_aug)-by_aug);){

    xx_aug.add_aug(xx_aug.get_aug(xx_aug.size_aug()-1)*ax_aug+bx_aug);

  yy_aug.add_aug(yy_aug.get_aug(yy_aug.size_aug()-1)*ay_aug+by_aug);

 }

   long  xl_aug=xs_aug,yl_aug=ys_aug,tt_aug=t_aug;

   for(int    i_aug=0;i_aug<xx_aug.size_aug();i_aug++){

   if(tt_aug>=abs_aug(xl_aug-xx_aug.get_aug(i_aug))+abs_aug(yl_aug-yy_aug.get_aug(i_aug))&&abs_aug(xl_aug-xx_aug.get_aug(i_aug))+abs_aug(yl_aug-yy_aug.get_aug(i_aug))>=0){an_aug++;tt_aug-=abs_aug(xl_aug-xx_aug.get_aug(i_aug))+abs_aug(yl_aug-yy_aug.get_aug(i_aug));xl_aug=xx_aug.get_aug(i_aug);yl_aug=yy_aug.get_aug(i_aug);}

  else  {anl_aug=max_aug(ans_aug,an_aug);an_aug=0;

  xl_aug=xs_aug;yl_aug=ys_aug;tt_aug=t_aug;}

 }



 xl_aug=xs_aug;yl_aug=ys_aug;tt_aug=t_aug;

   for(int  i_aug=xx_aug.size_aug()-1;i_aug>=0;i_aug--){



   if(tt_aug>=abs_aug(xl_aug-xx_aug.get_aug(i_aug))+abs_aug(yl_aug-yy_aug.get_aug(i_aug))&&abs_aug(xl_aug-xx_aug.get_aug(i_aug))+abs_aug(yl_aug-yy_aug.get_aug(i_aug))>=0){as_aug++;tt_aug-=abs_aug(xl_aug-xx_aug.get_aug(i_aug))+abs_aug(yl_aug-yy_aug.get_aug(i_aug));xl_aug=xx_aug.get_aug(i_aug);yl_aug=yy_aug.get_aug(i_aug);}

   else   {anl_aug=max_aug(ans_aug,as_aug);as_aug=0;

 xl_aug=xs_aug;yl_aug=ys_aug;tt_aug=t_aug;}



    }



   tryy_aug(xx_aug,yy_aug,xs_aug,ys_aug,t_aug);

  as_aug=max_aug(as_aug,an_aug);

   an_aug=max_aug(anl_aug,an_aug);

    System.out.println(max_aug(ans_aug,as_aug));

    }

    static long    ans_aug=0L,an_aug,as_aug=0,anl_aug=0;

  static   void   tryy_aug(ArrayList_aug<Long_aug> xx_aug,ArrayList_aug<Long_aug> yy_aug,long   x_aug,long    y_aug,long   t_aug){

 int c_aug=-1;

    long    min_aug   =Long_aug.MAX_VALUE_aug-1,z_aug=0,v_aug=0;

    for(int    i_aug=0;i_aug<xx_aug.size_aug();i_aug++){

  if(min_aug>    Math_aug.abs_aug(x_aug-xx_aug.get_aug(i_aug))+Math_aug.abs_aug(y_aug-yy_aug.get_aug(i_aug))&&Math_aug.abs_aug(x_aug-xx_aug.get_aug(i_aug))+Math_aug.abs_aug(y_aug-yy_aug.get_aug(i_aug))>=0){c_aug=i_aug;z_aug=yy_aug.get_aug(i_aug);v_aug=xx_aug.get_aug(i_aug);min_aug= Math_aug.abs_aug(x_aug-xx_aug.get_aug(i_aug))+Math_aug.abs_aug(y_aug-yy_aug.get_aug(i_aug));}



    }

  if(min_aug<=t_aug){t_aug-=min_aug;ans_aug++;

   xx_aug.remove_aug(c_aug);yy_aug.remove_aug(c_aug);

 tryy_aug(xx_aug,yy_aug,v_aug,z_aug,t_aug);

    }



   }

 static  long    gcd_aug(long g_aug,long x_aug){

 if(x_aug<1)return  g_aug;

 else   return  gcd_aug(x_aug,g_aug%x_aug);



    }

}



class   FastReader_aug

 {

  BufferedReader_aug br_aug;

  StringTokenizer_aug st_aug;



  public   FastReader_aug()

 {

 br_aug    =    new BufferedReader_aug(new

  InputStreamReader_aug(System.in_aug));

    }



    String_aug   next_aug()

   {

    while  (st_aug ==  null   ||    !st_aug.hasMoreElements_aug())

    {

    try

 {

    st_aug  =   new StringTokenizer_aug(br_aug.readLine_aug());

  }

  catch   (IOException_aug   e_aug)

  {

 e_aug.printStackTrace_aug();

    }

 }

 return    st_aug.nextToken_aug();

    }



  int    nextInt_aug()

  {

  return   Integer_aug.parseInt_aug(next_aug());

 }



  long   nextLong_aug()

  {

 return Long_aug.parseLong_aug(next_aug());

 }



    double   nextDouble_aug()

 {

 return  Double_aug.parseDouble_aug(next_aug());

    }



   String_aug    nextLine_aug()

 {

   String_aug   str_aug  = "";

  try

   {

  str_aug    =    br_aug.readLine_aug();

 }

  catch  (IOException_aug   e_aug)

   {

    e_aug.printStackTrace_aug();

   }

    return  str_aug;

 }

}



class    Sorting_aug{



 public    static    int[]    bucketSort_aug(int[]    array_aug,    int bucketCount_aug)   {



   if (bucketCount_aug   <= 0)    throw    new IllegalArgumentException_aug("Invalid   bucket count");



  if  (array_aug.length_aug <=   1)   return array_aug;  //trivially    sorted







 int    high_aug =    array_aug[0];



  int  low_aug    =   array_aug[0];



  for  (int  i_aug    = 1;  i_aug    <  array_aug.length_aug;   i_aug++) {    //find the range    of  input   elements



   if    (array_aug[i_aug] >  high_aug)   high_aug =  array_aug[i_aug];



   if   (array_aug[i_aug]   <    low_aug)  low_aug  =    array_aug[i_aug];



   }



 double    interval_aug  = ((double)(high_aug -   low_aug    +  1))/bucketCount_aug;    //range of   one bucket





   ArrayList_aug<Integer_aug>  buckets_aug[]  =    new    ArrayList_aug[bucketCount_aug];



  for (int   i_aug =   0; i_aug  <   bucketCount_aug; i_aug++)  { //initialize buckets_aug



 buckets_aug[i_aug]    = new    ArrayList_aug();



  }







  for   (int i_aug  =   0;   i_aug    <   array_aug.length_aug;   i_aug++)  { //partition the   input  array_aug



   buckets_aug[(int)((array_aug[i_aug]   - low_aug)/interval_aug)].add_aug(array_aug[i_aug]);



   }





 int    pointer_aug  =  0;



 for (int  i_aug   =   0; i_aug    <    buckets_aug.length_aug;  i_aug++)   {



    Collections_aug.sort_aug(buckets_aug[i_aug]);    //mergeSort



    for  (int j_aug   =  0;    j_aug <   buckets_aug[i_aug].size_aug();  j_aug++)  {   //merge  the    buckets_aug



    array_aug[pointer_aug] =  buckets_aug[i_aug].get_aug(j_aug);



   pointer_aug++;



  }



}



return  array_aug;



}



}
