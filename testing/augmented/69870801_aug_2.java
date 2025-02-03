import    java_aug.io_aug.BufferedReader_aug;

import   java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStreamReader_aug;

import  java_aug.util_aug.StringTokenizer_aug;



public   class    LetterA_aug   {

    static  class    Point_aug{

   long    x_aug,y_aug;

    Point_aug(long    x_aug,  long   y_aug){

    this.x_aug=x_aug;

  this.y_aug=y_aug;

 }

  }

  static    class    Segment_aug{

    long    x1_aug,y1_aug,x2_aug,y2_aug;

   Point_aug   p1_aug,p2_aug;

    Segment_aug(String_aug    sr_aug){

   StringTokenizer_aug st_aug=  new  StringTokenizer_aug(sr_aug);

   this.x1_aug=Integer_aug.parseInt_aug(st_aug.nextToken_aug());

    this.y1_aug=Integer_aug.parseInt_aug(st_aug.nextToken_aug());

    this.x2_aug=Integer_aug.parseInt_aug(st_aug.nextToken_aug());

 this.y2_aug=Integer_aug.parseInt_aug(st_aug.nextToken_aug());

 this.p1_aug= new    Point_aug(x1_aug,y1_aug);

 this.p2_aug=new Point_aug(x2_aug,y2_aug);

   }

   }

  static    boolean    acute_aug(Point_aug p1_aug, Point_aug  p2_aug, Point_aug    p3_aug){

    long  area_aug=(long)(p1_aug.x_aug-p3_aug.x_aug)*(p2_aug.y_aug-p3_aug.y_aug)-(long)(p1_aug.y_aug-p3_aug.y_aug)*(p2_aug.x_aug-p3_aug.x_aug);

   long   a_aug=(long)(p1_aug.x_aug-p3_aug.x_aug)*(p1_aug.x_aug-p3_aug.x_aug)+(long)   (p1_aug.y_aug-p3_aug.y_aug)*(p1_aug.y_aug-p3_aug.y_aug)    ;

   long   b_aug=(long)(p2_aug.x_aug-p3_aug.x_aug)*(p2_aug.x_aug-p3_aug.x_aug)+(long)  (p2_aug.y_aug-p3_aug.y_aug)*(p2_aug.y_aug-p3_aug.y_aug);

  long  c_aug=(long)(p2_aug.x_aug-p1_aug.x_aug)*(p2_aug.x_aug-p1_aug.x_aug)+(long)   (p2_aug.y_aug-p1_aug.y_aug)*(p2_aug.y_aug-p1_aug.y_aug);

  return area_aug!=0  &&  c_aug<=a_aug+b_aug;

   }

 static  boolean    verticalSegment_aug(Segment_aug  a_aug,    Segment_aug    b_aug){

   if(a_aug.p1_aug.x_aug==b_aug.p1_aug.x_aug   &&   a_aug.p1_aug.y_aug==b_aug.p1_aug.y_aug){

 return    acute_aug(a_aug.p2_aug,b_aug.p2_aug,a_aug.p1_aug);

   }

  if(a_aug.p2_aug.x_aug==b_aug.p2_aug.x_aug   &&   a_aug.p2_aug.y_aug==b_aug.p2_aug.y_aug){

  return    acute_aug(a_aug.p1_aug,b_aug.p1_aug,a_aug.p2_aug);

 }

    if(a_aug.p1_aug.x_aug==b_aug.p2_aug.x_aug &&    a_aug.p1_aug.y_aug==b_aug.p2_aug.y_aug){

   return acute_aug(a_aug.p2_aug,b_aug.p1_aug,a_aug.p1_aug);

    }

 if(a_aug.p2_aug.x_aug==b_aug.p1_aug.x_aug  && a_aug.p2_aug.y_aug==b_aug.p1_aug.y_aug){

    return acute_aug(a_aug.p1_aug,b_aug.p2_aug,a_aug.p2_aug);

   }

 return false;

  }

 static   boolean   intersecting_aug(Segment_aug   s_aug,Point_aug   p_aug){

  if(p_aug.x_aug<Math_aug.min_aug(s_aug.p1_aug.x_aug,s_aug.p2_aug.x_aug) ||    p_aug.x_aug>Math_aug.max_aug(s_aug.p1_aug.x_aug,s_aug.p2_aug.x_aug)   ||

    p_aug.y_aug<Math_aug.min_aug(s_aug.p1_aug.y_aug,s_aug.p2_aug.y_aug)||  p_aug.y_aug>Math_aug.max_aug(s_aug.p1_aug.y_aug,s_aug.p2_aug.y_aug))

 return    false;

    int x_aug=(int)   Math_aug.abs_aug(s_aug.p1_aug.x_aug-s_aug.p2_aug.x_aug);

 int  y_aug= (int)   Math_aug.abs_aug(s_aug.p1_aug.y_aug-s_aug.p2_aug.y_aug);

   int xm_aug=   (int)  Math_aug.min_aug(Math_aug.abs_aug(s_aug.p1_aug.x_aug-p_aug.x_aug),Math_aug.abs_aug(s_aug.p2_aug.x_aug-p_aug.x_aug));

   int  ym_aug=   (int)   Math_aug.min_aug(Math_aug.abs_aug(s_aug.p1_aug.y_aug-p_aug.y_aug),Math_aug.abs_aug(s_aug.p2_aug.y_aug-p_aug.y_aug));

  return   x_aug<=5*xm_aug    &&   y_aug<=5*ym_aug    &&

  (long)(p_aug.x_aug-s_aug.p2_aug.x_aug)*(s_aug.p1_aug.y_aug-s_aug.p2_aug.y_aug)==(long)(p_aug.y_aug-s_aug.p2_aug.y_aug)*(s_aug.p1_aug.x_aug-s_aug.p2_aug.x_aug);

  }



 static boolean   check_aug(Segment_aug    a_aug,   Segment_aug   b_aug, Segment_aug c_aug){

   return verticalSegment_aug(a_aug,b_aug) &&    (intersecting_aug(a_aug,c_aug.p1_aug)  &&   intersecting_aug(b_aug,c_aug.p2_aug)

 ||    intersecting_aug(b_aug,c_aug.p1_aug)  &&  intersecting_aug(a_aug,c_aug.p2_aug));

   }



 public static void    main(String_aug[]   args_aug) throws   IOException_aug {

  BufferedReader_aug    br_aug= new BufferedReader_aug(new    InputStreamReader_aug(System.in_aug));

  int    n_aug= Integer_aug.parseInt_aug(br_aug.readLine_aug());

 for(int  i_aug=0;i_aug<n_aug;i_aug++)    {

   Segment_aug  a_aug=new Segment_aug(br_aug.readLine_aug());

 Segment_aug   b_aug= new   Segment_aug(br_aug.readLine_aug());

  Segment_aug c_aug=    new Segment_aug(br_aug.readLine_aug());

   System.out.println(check_aug(a_aug,b_aug,c_aug)||check_aug(b_aug,c_aug,a_aug)||check_aug(c_aug,a_aug,b_aug)?"YES":"NO");

 }



 }

}