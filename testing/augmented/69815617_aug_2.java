import    java_aug.io_aug.BufferedReader_aug;

import   java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStreamReader_aug;

import  java_aug.util_aug.StringTokenizer_aug;



public  class  AnotA_aug    {



   long x1_aug,x2_aug;

   long  y1_aug,y2_aug;



   AnotA_aug(String_aug  s_aug){

 StringTokenizer_aug st_aug   = new    StringTokenizer_aug(s_aug);

   this.x1_aug   =Integer_aug.parseInt_aug(st_aug.nextToken_aug());

   this.y1_aug  =Integer_aug.parseInt_aug(st_aug.nextToken_aug());

 this.x2_aug  =Integer_aug.parseInt_aug(st_aug.nextToken_aug());

  this.y2_aug   =Integer_aug.parseInt_aug(st_aug.nextToken_aug());

   }

  public static void  main(String_aug[] args_aug)   throws   IOException_aug   {

    BufferedReader_aug    br_aug  =  new    BufferedReader_aug(new  InputStreamReader_aug(System.in_aug));

   int n_aug =    Integer_aug.parseInt_aug(br_aug.readLine_aug());

   for(int  i_aug=0;   i_aug<n_aug;  i_aug++)   {

 AnotA_aug  a_aug =  new   AnotA_aug(br_aug.readLine_aug());

  AnotA_aug   b_aug    =   new  AnotA_aug(br_aug.readLine_aug());

 AnotA_aug  c_aug =    new   AnotA_aug(br_aug.readLine_aug());

  System.out.println(CC_aug(a_aug,b_aug,c_aug)||CC_aug(b_aug,c_aug,a_aug)||CC_aug(c_aug,a_aug,b_aug)?"YES":"NO");

    }

    }





  public    static  boolean CC_aug(AnotA_aug  a_aug,  AnotA_aug   b_aug,   AnotA_aug  c_aug)    {

 return    checkConstraints_aug(a_aug,b_aug,c_aug)&&(

    checkIntersection_aug(c_aug.x1_aug, c_aug.y1_aug,a_aug)&&checkIntersection_aug(c_aug.x2_aug, c_aug.y2_aug,b_aug)||

   checkIntersection_aug(c_aug.x2_aug,  c_aug.y2_aug,a_aug)&&checkIntersection_aug(c_aug.x1_aug,   c_aug.y1_aug,b_aug));



 }



    //Took   Dukkha   code  as reference

 private    static boolean   checkIntersection_aug(long    x_aug,   long y_aug,   AnotA_aug  a_aug)    {

    //check    if   the point is    lying   outside    the segment

    if(x_aug<Math_aug.min_aug(a_aug.x1_aug, a_aug.x2_aug)||x_aug>Math_aug.max_aug(a_aug.x1_aug, a_aug.x2_aug)||y_aug<Math_aug.min_aug(a_aug.y1_aug, a_aug.y2_aug)||y_aug>Math_aug.max_aug(a_aug.y1_aug,    a_aug.y2_aug))

    return  false;

   //check    ratio    between   parts

 int xpart_aug   =  (int)   Math_aug.abs_aug(a_aug.x1_aug-a_aug.x2_aug);

   int ypart_aug =    (int)   Math_aug.abs_aug(a_aug.y1_aug-a_aug.y2_aug);

    int   xmin_aug   =  (int)  Math_aug.min_aug(Math_aug.abs_aug(a_aug.x1_aug-x_aug),   Math_aug.abs_aug(a_aug.x2_aug-x_aug));

    int   ymin_aug    =  (int)   Math_aug.min_aug(Math_aug.abs_aug(a_aug.y1_aug-y_aug),   Math_aug.abs_aug(a_aug.y2_aug-y_aug));



    return   xpart_aug<=5*xmin_aug&&ypart_aug<=5*ymin_aug&&    (long)    (x_aug-a_aug.x2_aug)*(a_aug.y1_aug-a_aug.y2_aug)==(long)(y_aug-a_aug.y2_aug)*(a_aug.x1_aug-a_aug.x2_aug);

    }

  public static boolean checkConstraints_aug(AnotA_aug   a_aug, AnotA_aug  b_aug,    AnotA_aug   c_aug)  {

  if(a_aug.x1_aug==b_aug.x1_aug&&a_aug.y1_aug==b_aug.y1_aug)  {



   return   getAngle_aug(a_aug.x2_aug,a_aug.y2_aug,b_aug.x2_aug,b_aug.y2_aug,a_aug.x1_aug,a_aug.y1_aug);

  }

   else  if(a_aug.x2_aug==b_aug.x1_aug&&a_aug.y2_aug==b_aug.y1_aug)  {



  return    getAngle_aug(a_aug.x1_aug,    a_aug.y1_aug,   b_aug.x2_aug,    b_aug.y2_aug, a_aug.x2_aug,    a_aug.y2_aug);

 }

  else if(a_aug.x1_aug==b_aug.x2_aug&&a_aug.y1_aug==b_aug.y2_aug)  {



    return   getAngle_aug(a_aug.x2_aug,  a_aug.y2_aug, b_aug.x1_aug,  b_aug.y1_aug,   a_aug.x1_aug,  a_aug.y1_aug);

   }

    else  if(a_aug.x2_aug==b_aug.x2_aug&&a_aug.y2_aug==b_aug.y2_aug) {



  return    getAngle_aug(a_aug.x1_aug,  a_aug.y1_aug,  b_aug.x1_aug, b_aug.y1_aug,   a_aug.x2_aug,   a_aug.y2_aug);

   }

  return    false;



    }



  public  static    boolean   getAngle_aug(long    x1_aug,   long  y1_aug,   long    x2_aug, long  y2_aug,    long   x3_aug,  long  y3_aug)    {

   boolean collinear_aug   =areCollinear_aug(    x1_aug, y1_aug,   x2_aug,   y2_aug,    x3_aug,  y3_aug);

    //check    angle  <=    90

    long    a13_aug  = (long)    (x1_aug-x3_aug)    *  (x1_aug-x3_aug)  +  (long)   (y1_aug-y3_aug)  *(y1_aug-y3_aug);    

 long   a23_aug  = (long)    (x2_aug-x3_aug)  *  (x2_aug-x3_aug)   + (long)   (y2_aug-y3_aug)   *(y2_aug-y3_aug);

 long   a12_aug  =    (long)  (x1_aug-x2_aug)  *    (x1_aug-x2_aug)    + (long) (y1_aug-y2_aug)  *(y1_aug-y2_aug);   

   return !collinear_aug&&a13_aug+a23_aug>=a12_aug;

   }



   private   static    boolean    areCollinear_aug(long   x1_aug,  long y1_aug,   long   x2_aug,    long    y2_aug, long x3_aug, long  y3_aug) {

 long area_aug = (long) (x1_aug-x3_aug)*(y2_aug-y3_aug)  - (long)   (x2_aug-x3_aug)*(y1_aug-y3_aug);

    return area_aug==0?true:false;



  }

}