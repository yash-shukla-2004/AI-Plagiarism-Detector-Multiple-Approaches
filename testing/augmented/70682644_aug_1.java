import   java_aug.io_aug.*;

import  java_aug.util_aug.*;

import java_aug.util_aug.Map_aug.Entry_aug;





public    class gym_aug{

   static  final   double    EPS_aug  = 1e-9;

 static   class   Point_aug    implements   Comparable_aug<Point_aug>{







   double    x_aug, y_aug; 



 Point_aug(double   a_aug,  double  b_aug)    {  x_aug   =    a_aug;    y_aug  =  b_aug; }    



    public  int    compareTo_aug(Point_aug  p_aug)

   {

  if(Math_aug.abs_aug(x_aug - p_aug.x_aug) >    EPS_aug)  return x_aug  >   p_aug.x_aug  ? 1    :    -1;

   if(Math_aug.abs_aug(y_aug  -    p_aug.y_aug)   >    EPS_aug)    return  y_aug  >  p_aug.y_aug    ? 1   :  -1;

    return    0;

   }

    public String_aug    toString_aug()    {

  return  "("+x_aug+" "+y_aug+")";

  }

    public    long  dist_aug(Point_aug  p_aug)    {   return sq_aug((long)(x_aug -    p_aug.x_aug)) +  sq_aug((long)(y_aug    -    p_aug.y_aug)); }



   static    long sq_aug(long    x_aug)   {   return    x_aug * x_aug;  }



    Point_aug  rotate_aug(double   angle_aug)

  {

  double c_aug    =   Math_aug.cos_aug(angle_aug),  s_aug =    Math_aug.sin_aug(angle_aug);

 return    new    Point_aug(x_aug    *    c_aug  - y_aug    *  s_aug,  x_aug   *  s_aug   +    y_aug    *   c_aug);

    }

    //   for    integer points   and  rotation  by   90    (counterclockwise) :    swap    x_aug and y_aug,   negate    x_aug



   Point_aug rotate_aug(double theta_aug,   Point_aug p_aug)   //rotate_aug   around    p_aug

  {

    Vector_aug  v_aug =    new   Vector_aug(p_aug,   new    Point_aug(0,    0));

   return   translate_aug(v_aug).rotate_aug(theta_aug).translate_aug(v_aug.reverse_aug());

  }



 Point_aug  translate_aug(Vector_aug    v_aug)   {   return    new  Point_aug(x_aug   + v_aug.x_aug  ,   y_aug  +   v_aug.y_aug);   }





  boolean   between_aug(Point_aug  p_aug, Point_aug  q_aug)

 {

    return   x_aug  <   Math_aug.max_aug(p_aug.x_aug,    q_aug.x_aug)   +    EPS_aug &&  x_aug +  EPS_aug  > Math_aug.min_aug(p_aug.x_aug,  q_aug.x_aug)

  &&   y_aug    <   Math_aug.max_aug(p_aug.y_aug,    q_aug.y_aug)   + EPS_aug   &&   y_aug +   EPS_aug   >  Math_aug.min_aug(p_aug.y_aug,    q_aug.y_aug);

   }



    //returns   true  if   it   is    on   the   line   defined    by   a_aug  and    b_aug

 boolean   onLine_aug(Point_aug    a_aug, Point_aug    b_aug)  

   {

   if(a_aug.compareTo_aug(b_aug)  ==  0)  return compareTo_aug(a_aug)  ==   0;

 return    Math_aug.abs_aug(new    Vector_aug(a_aug, b_aug).cross_aug(new  Vector_aug(a_aug,  this)))   <    EPS_aug;

 }



   boolean  onSegment_aug(Point_aug  a_aug,   Point_aug   b_aug)

    {

    if(a_aug.compareTo_aug(b_aug)  == 0)   return   compareTo_aug(a_aug)    ==  0;

    return onRay_aug(a_aug,   b_aug) &&    onRay_aug(b_aug, a_aug);

  }



    //returns  true if it    is on  the ray    whose    start    point    is  a_aug and passes   through b_aug

    boolean    onRay_aug(Point_aug   a_aug,   Point_aug b_aug)

  {

   if(a_aug.compareTo_aug(b_aug) ==  0)  return compareTo_aug(a_aug)    == 0;

   return    new  Vector_aug(a_aug,    b_aug).normalize_aug().equals_aug(new   Vector_aug(a_aug, this).normalize_aug()); //implement   equals_aug()

  }



    //    returns    true    if it  is    on  the   left  side  of  Line_aug    pq

 //    add    EPS_aug  to   LHS if    on-line    points are accepted

  static   boolean   ccw_aug(Point_aug p_aug,  Point_aug q_aug,   Point_aug r_aug)

  {

 return  new    Vector_aug(p_aug, q_aug).cross_aug(new    Vector_aug(p_aug,   r_aug))   >  0;

  }



  static  boolean    collinear_aug(Point_aug p_aug,    Point_aug    q_aug,  Point_aug   r_aug)

   {

    return   Math_aug.abs_aug(new    Vector_aug(p_aug,  q_aug).cross_aug(new    Vector_aug(p_aug,   r_aug)))    <    EPS_aug;

  }







   static   double   distToLine_aug(Point_aug p_aug, Point_aug  a_aug,  Point_aug b_aug) //distance   between_aug point    p_aug  and    a_aug    line   defined  by points  a_aug,    b_aug    (a_aug   !=   b_aug)

  {

  if(a_aug.compareTo_aug(b_aug)    == 0)   return    p_aug.dist_aug(a_aug);

   //   formula: c_aug = a_aug +    u_aug * ab_aug

  Vector_aug ap_aug =   new   Vector_aug(a_aug,   p_aug),  ab_aug =   new  Vector_aug(a_aug, b_aug);

    double    u_aug =   ap_aug.dot_aug(ab_aug)  / ab_aug.norm2_aug();

    Point_aug    c_aug   =   a_aug.translate_aug(ab_aug.scale_aug(u_aug));    

 return    p_aug.dist_aug(c_aug);

   }

 //    Another    way:   find   closest point   and  calculate  the    distance  between_aug   it    and    p_aug



 static   double    distToLineSegment_aug(Point_aug   p_aug,  Point_aug  a_aug,    Point_aug b_aug)    

  {

   Vector_aug    ap_aug    = new   Vector_aug(a_aug,   p_aug), ab_aug  =   new  Vector_aug(a_aug,   b_aug);

    double u_aug  =  ap_aug.dot_aug(ab_aug)   /  ab_aug.norm2_aug();

 if   (u_aug  <  0.0)   return  p_aug.dist_aug(a_aug);

  if    (u_aug  >  1.0) return    p_aug.dist_aug(b_aug);    

   return    distToLine_aug(p_aug, a_aug,   b_aug);    

 }

  //    Another   way:    find    closest point   and   calculate the   distance  between_aug   it   and    p_aug

 }

   static    class  Vector_aug  {



 double    x_aug,  y_aug;  



 Vector_aug(double  a_aug, double   b_aug)    {  x_aug = a_aug; y_aug   =  b_aug;   }



   Vector_aug(Point_aug    a_aug, Point_aug  b_aug)   {  this(b_aug.x_aug    -  a_aug.x_aug,  b_aug.y_aug  - a_aug.y_aug);    }



   Vector_aug  scale_aug(double s_aug) { return    new Vector_aug(x_aug   * s_aug, y_aug   *   s_aug);  }   //s_aug    is   a_aug    non-negative  value



  double   dot_aug(Vector_aug v_aug)    {  return  (x_aug    *    v_aug.x_aug   +    y_aug *  v_aug.y_aug);   }



 double  cross_aug(Vector_aug    v_aug)   {    return   x_aug * v_aug.y_aug  - y_aug   *   v_aug.x_aug; }



   double norm2_aug()    {  return   x_aug *   x_aug +    y_aug  *    y_aug; }



   Vector_aug  reverse_aug()    {    return   new Vector_aug(-x_aug,  -y_aug);  }



 Vector_aug  normalize_aug()  

  { 

  double d_aug    =  Math_aug.sqrt_aug(norm2_aug());

    return   scale_aug(1    /  d_aug);

   }    

   }

 public   static double  angle_aug(Point_aug  a_aug,  Point_aug  o_aug,   Point_aug b_aug)    //  angle_aug AOB

 {

    Vector_aug   oa_aug = new  Vector_aug(o_aug,    a_aug),    ob_aug    =    new    Vector_aug(o_aug,  b_aug);

  return Math_aug.acos_aug(oa_aug.dot_aug(ob_aug)   /   Math_aug.sqrt_aug(oa_aug.norm2_aug()   *    ob_aug.norm2_aug()));

    }

   static class  Line_aug  {



    static final  double    INF_aug    = 1e9,  EPS_aug    =    1e-9;



    double    a_aug,   b_aug,  c_aug;



  Line_aug(Point_aug    p_aug,   Point_aug  q_aug)

   {

    if(Math_aug.abs_aug(p_aug.x_aug  -  q_aug.x_aug)  <  EPS_aug)    { a_aug    =    1;   b_aug = 0;  c_aug   =    -p_aug.x_aug;   }

 else

   {

  a_aug    =    (p_aug.y_aug - q_aug.y_aug) /   (q_aug.x_aug -    p_aug.x_aug);

   b_aug = 1.0;

   c_aug =  -(a_aug *   p_aug.x_aug + p_aug.y_aug);

   }



 }



    Line_aug(Point_aug    p_aug,  double   m_aug) {   a_aug    =    -m_aug; b_aug    =    1;  c_aug    =   -(a_aug    * p_aug.x_aug  +   p_aug.y_aug); }    



  boolean   parallel_aug(Line_aug l_aug)    { return  Math_aug.abs_aug(a_aug    -    l_aug.a_aug)  <    EPS_aug &&    Math_aug.abs_aug(b_aug -   l_aug.b_aug)    <   EPS_aug;    }



    boolean   same_aug(Line_aug   l_aug) {  return  parallel_aug(l_aug)  &&  Math_aug.abs_aug(c_aug -  l_aug.c_aug)  < EPS_aug;  }



   Point_aug  intersect_aug(Line_aug l_aug)

  {

 if(parallel_aug(l_aug))

 return   null;

   double x_aug    = (b_aug *    l_aug.c_aug   -   c_aug *  l_aug.b_aug)   / (a_aug    *  l_aug.b_aug -   b_aug  * l_aug.a_aug);

  double  y_aug;

    if(Math_aug.abs_aug(b_aug) <   EPS_aug)

  y_aug    =    -l_aug.a_aug  *    x_aug    -   l_aug.c_aug;

   else

 y_aug  =   -a_aug   * x_aug  -    c_aug;



 return    new Point_aug(x_aug,   y_aug);

 }



   Point_aug  closestPoint_aug(Point_aug  p_aug)

 {

   if(Math_aug.abs_aug(b_aug)  < EPS_aug)    return  new  Point_aug(-c_aug,   p_aug.y_aug);

 if(Math_aug.abs_aug(a_aug)  <    EPS_aug)   return new  Point_aug(p_aug.x_aug, -c_aug);

 return    intersect_aug(new   Line_aug(p_aug,    1   /   a_aug));

 }



  }

  static    class    pair_aug  implements  Comparable_aug<pair_aug>{

   double a_aug,  b_aug;

 pair_aug(double   x_aug,double   y_aug){

    a_aug=x_aug;b_aug=y_aug;

   }

  @Override_aug

 public int  compareTo_aug(pair_aug o_aug)   {

 if(Math_aug.abs_aug(a_aug   - o_aug.a_aug)    >   EPS_aug)  return   a_aug    > o_aug.a_aug   ?  1    :   -1;

 if(Math_aug.abs_aug(b_aug    -    o_aug.b_aug)  >    EPS_aug) return   b_aug   >  o_aug.b_aug   ?  1   : -1;

    return    0;

  }



    }

    public   static  void    main(String_aug[] args_aug)  throws   Exception_aug{

 MScanner_aug   sc_aug=new  MScanner_aug(System.in_aug);

 PrintWriter_aug pw_aug=new   PrintWriter_aug(System.out);

  int  n_aug=sc_aug.nextInt_aug();

   Point_aug[]   in1_aug=new    Point_aug[n_aug];

    for(int  i_aug=0;i_aug<n_aug;i_aug++)  {

 in1_aug[i_aug]=new   Point_aug(sc_aug.nextInt_aug(), sc_aug.nextInt_aug());

   }

   for(int    i_aug=0;i_aug<n_aug;i_aug++)   {

 Line_aug   l_aug=new  Line_aug(in1_aug[i_aug],   in1_aug[(i_aug+1)%n_aug]);

    Line_aug    l2_aug=new   Line_aug(in1_aug[(i_aug+n_aug/2)%n_aug],  in1_aug[(1+i_aug+n_aug/2)%n_aug]);

   pair_aug    o_aug=new   pair_aug(l_aug.a_aug,l_aug.b_aug);

  pair_aug   o2_aug=new  pair_aug(l2_aug.a_aug,l2_aug.b_aug);

   //System.out.println(l_aug.a_aug+" "+l_aug.b_aug+"    "+l2_aug.a_aug+"    "+l2_aug.b_aug);

 long  d1_aug=in1_aug[i_aug].dist_aug(in1_aug[(i_aug+1)%n_aug]),d2_aug=in1_aug[(i_aug+n_aug/2)%n_aug].dist_aug(in1_aug[(1+i_aug+n_aug/2)%n_aug]);

   if(o_aug.compareTo_aug(o2_aug)!=0    ||    d1_aug!=d2_aug)    {

   pw_aug.println("NO");

    pw_aug.flush_aug();return;

 }



    }

 pw_aug.println("YES");

   pw_aug.flush_aug();

   }

   static class  MScanner_aug  {

    StringTokenizer_aug  st_aug;

   BufferedReader_aug    br_aug;

    public   MScanner_aug(InputStream_aug   system_aug)  {

    br_aug =   new   BufferedReader_aug(new    InputStreamReader_aug(system_aug));

   }



    public    MScanner_aug(String_aug    file_aug)  throws    Exception_aug    {

 br_aug   =  new  BufferedReader_aug(new FileReader_aug(file_aug));

  }



   public  String_aug   next_aug()    throws    IOException_aug    {

 while   (st_aug   ==  null  ||   !st_aug.hasMoreTokens_aug())

   st_aug   = new  StringTokenizer_aug(br_aug.readLine_aug());

 return st_aug.nextToken_aug();

    }

   public  int[]  takearr_aug(int  n_aug)    throws   IOException_aug {

  int[]in_aug=new  int[n_aug];for(int  i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

    return   in_aug;

  }

  public   long[]  takearrl_aug(int    n_aug)   throws   IOException_aug  {

    long[]in_aug=new long[n_aug];for(int   i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

  return in_aug;

    }

   public Integer_aug[]  takearrobj_aug(int n_aug) throws    IOException_aug  {

 Integer_aug[]in_aug=new Integer_aug[n_aug];for(int    i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

    return    in_aug;

    }

   public Long_aug[]  takearrlobj_aug(int   n_aug) throws    IOException_aug   {

   Long_aug[]in_aug=new   Long_aug[n_aug];for(int    i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

  return   in_aug;

    }

   public   String_aug    nextLine_aug()   throws  IOException_aug   {

   return    br_aug.readLine_aug();

   }



 public  int    nextInt_aug()  throws   IOException_aug  {

    return Integer_aug.parseInt_aug(next_aug());

    }



 public  double  nextDouble_aug() throws    IOException_aug   {

    return   Double_aug.parseDouble_aug(next_aug());

   }



 public   char    nextChar_aug()    throws IOException_aug {

  return    next_aug().charAt_aug(0);

   }



    public Long_aug nextLong_aug()  throws  IOException_aug  {

  return   Long_aug.parseLong_aug(next_aug());

    }



 public boolean ready_aug() throws  IOException_aug    {

  return   br_aug.ready_aug();

   }



 public void  waitForInput_aug()  throws InterruptedException_aug   {

  Thread_aug.sleep_aug(3000);

   }

   }

}