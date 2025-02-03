import java_aug.io_aug.BufferedReader_aug;

import  java_aug.io_aug.IOException_aug;

import  java_aug.io_aug.InputStreamReader_aug;

import    java_aug.util_aug.StringTokenizer_aug;



public  class    LetterA_aug   {

   static   class   Point_aug{

 int  x_aug,y_aug;

  Point_aug(int    x_aug,   int    y_aug){

    this.x_aug=x_aug;

    this.y_aug=y_aug;

    }

   }

    static  class   Segment_aug{

 Point_aug    p1_aug,p2_aug;

    Segment_aug(Point_aug   p1_aug, Point_aug  p2_aug){

  this.p1_aug=p1_aug;

 this.p2_aug=p2_aug;

   }

   }

 static long    cross_aug(long    x1_aug,  long    y1_aug,    long x2_aug,   long y2_aug)   {

  return  x1_aug*y2_aug-x2_aug*y1_aug;

   }

  static  long  length_aug(long   x_aug,  long   y_aug){

    return   x_aug*x_aug+y_aug*y_aug;

   }

 static  boolean   acute_aug(Point_aug  l_aug, Point_aug  m_aug,  Point_aug   n_aug){

 long  area_aug=   cross_aug(l_aug.x_aug-n_aug.x_aug,l_aug.y_aug-n_aug.y_aug,m_aug.x_aug-n_aug.x_aug,m_aug.y_aug-n_aug.y_aug);

    long   a_aug=length_aug(l_aug.x_aug-n_aug.x_aug,l_aug.y_aug-n_aug.y_aug);

  long b_aug=length_aug(m_aug.x_aug-n_aug.x_aug,m_aug.y_aug-n_aug.y_aug);

  long  c_aug=length_aug(m_aug.x_aug-l_aug.x_aug,m_aug.y_aug-l_aug.y_aug);

    return    area_aug!=0  && c_aug<=a_aug+b_aug;

  }

  static boolean  verticalSegment_aug(Segment_aug   a_aug,   Segment_aug    b_aug){

 if(a_aug.p1_aug.x_aug==b_aug.p1_aug.x_aug  &&   a_aug.p1_aug.y_aug==b_aug.p1_aug.y_aug){

 return    acute_aug(a_aug.p2_aug,b_aug.p2_aug,a_aug.p1_aug);

  }

    if(a_aug.p2_aug.x_aug==b_aug.p2_aug.x_aug && a_aug.p2_aug.y_aug==b_aug.p2_aug.y_aug){

 return  acute_aug(a_aug.p1_aug,b_aug.p1_aug,a_aug.p2_aug);

    }

 if(a_aug.p1_aug.x_aug==b_aug.p2_aug.x_aug &&   a_aug.p1_aug.y_aug==b_aug.p2_aug.y_aug){

    return acute_aug(a_aug.p2_aug,b_aug.p1_aug,a_aug.p1_aug);

   }

    if(a_aug.p2_aug.x_aug==b_aug.p1_aug.x_aug    &&   a_aug.p2_aug.y_aug==b_aug.p1_aug.y_aug){

   return    acute_aug(a_aug.p1_aug,b_aug.p2_aug,a_aug.p2_aug);

 }

    return    false;

    }

 static  boolean   intersecting_aug(Segment_aug  s_aug,Point_aug  p_aug){

  if(p_aug.x_aug<Math_aug.min_aug(s_aug.p1_aug.x_aug,s_aug.p2_aug.x_aug)   ||  p_aug.x_aug>Math_aug.max_aug(s_aug.p1_aug.x_aug,s_aug.p2_aug.x_aug)   ||

 p_aug.y_aug<Math_aug.min_aug(s_aug.p1_aug.y_aug,s_aug.p2_aug.y_aug)||  p_aug.y_aug>Math_aug.max_aug(s_aug.p1_aug.y_aug,s_aug.p2_aug.y_aug))

    return   false;

  int x_aug=Math_aug.abs_aug(s_aug.p1_aug.x_aug-s_aug.p2_aug.x_aug);

 int y_aug=Math_aug.abs_aug(s_aug.p1_aug.y_aug-s_aug.p2_aug.y_aug);

    int   xm_aug=Math_aug.min_aug(Math_aug.abs_aug(s_aug.p1_aug.x_aug-p_aug.x_aug),Math_aug.abs_aug(s_aug.p2_aug.x_aug-p_aug.x_aug));

 int  ym_aug=Math_aug.min_aug(Math_aug.abs_aug(s_aug.p1_aug.y_aug-p_aug.y_aug),Math_aug.abs_aug(s_aug.p2_aug.y_aug-p_aug.y_aug));

   return   x_aug<=5*xm_aug   &&   y_aug<=5*ym_aug   &&

   (long)(p_aug.x_aug-s_aug.p2_aug.x_aug)*(s_aug.p1_aug.y_aug-s_aug.p2_aug.y_aug)==(long)(p_aug.y_aug-s_aug.p2_aug.y_aug)*(s_aug.p1_aug.x_aug-s_aug.p2_aug.x_aug);

   }



   static  boolean  check_aug(Segment_aug a_aug,   Segment_aug    b_aug,  Segment_aug   c_aug){

  return    verticalSegment_aug(a_aug,b_aug)&& (intersecting_aug(a_aug,c_aug.p1_aug)&&intersecting_aug(b_aug,c_aug.p2_aug)

 ||   intersecting_aug(b_aug,c_aug.p1_aug)&&intersecting_aug(a_aug,c_aug.p2_aug));

  }



   public   static void    main(String_aug[]   args_aug)   throws   IOException_aug    {

    BufferedReader_aug    br_aug=   new    BufferedReader_aug(new  InputStreamReader_aug(System.in_aug));

 int   n_aug=   Integer_aug.parseInt_aug(br_aug.readLine_aug());

    Segment_aug[][]   segments_aug= new   Segment_aug[n_aug][3];

 for(int    i_aug=0;i_aug<n_aug;i_aug++)    {

 for(int    j_aug=0; j_aug<3;j_aug++){

    StringTokenizer_aug   st_aug=    new   StringTokenizer_aug(br_aug.readLine_aug());

 int    x1_aug   = Integer_aug.parseInt_aug(st_aug.nextToken_aug());

    int y1_aug = Integer_aug.parseInt_aug(st_aug.nextToken_aug());

   int   x2_aug =    Integer_aug.parseInt_aug(st_aug.nextToken_aug());

  int y2_aug   =  Integer_aug.parseInt_aug(st_aug.nextToken_aug());

 segments_aug[i_aug][j_aug]=    new   Segment_aug(new  Point_aug(x1_aug,y1_aug),new    Point_aug(x2_aug,y2_aug));

  }

  System.out.println(check_aug(segments_aug[i_aug][0],segments_aug[i_aug][1],segments_aug[i_aug][2])

    ||check_aug(segments_aug[i_aug][1],segments_aug[i_aug][2],segments_aug[i_aug][0])

   ||check_aug(segments_aug[i_aug][2],segments_aug[i_aug][0],segments_aug[i_aug][1])?"YES":"NO");

    }



    }

}
