import  java_aug.io_aug.*;

import   java_aug.lang_aug.reflect_aug.Array_aug;

import    java_aug.util_aug.*;



import    static java_aug.lang_aug.Math_aug.*;



public    class Main_aug {

    void run_aug() throws  IOException_aug {

    long x0_aug    =  nextLong_aug();

 long  y0_aug   =  nextLong_aug();

 long    ax_aug  =   nextLong_aug();

 long    ay_aug  = nextLong_aug();

   long    bx_aug    =   nextLong_aug();

    long  by_aug   =  nextLong_aug();

 long   xs_aug   =   nextLong_aug();

 long    ys_aug =   nextLong_aug();

 long  t_aug   =   nextLong_aug();

 ArrayList_aug<pair_aug>  points_aug   =   new  ArrayList_aug<>();

  points_aug.add_aug(new pair_aug(x0_aug, y0_aug));

    long  prev_x_aug  = x0_aug;

   long prev_y_aug   =  y0_aug;

    while   (sqrt_aug(prev_x_aug)    *  sqrt_aug(ax_aug)   +  sqrt_aug(bx_aug)   <   sqrt_aug(Long_aug.MAX_VALUE_aug)    &&    sqrt_aug(prev_y_aug) * sqrt_aug(ay_aug)    +    sqrt_aug(by_aug)  < sqrt_aug(Long_aug.MAX_VALUE_aug))    {

 prev_x_aug *=   ax_aug;

 prev_x_aug +=    bx_aug;

    prev_y_aug *=   ay_aug;

   prev_y_aug    += by_aug;

 points_aug.add_aug(new pair_aug(prev_x_aug,   prev_y_aug));

 }

 int    best_aug    = 0;

    for  (int    i_aug   =    0;    i_aug  <    points_aug.size_aug();    i_aug++) {

    long    time_aug   =    0;

    pair_aug now_aug    =  new    pair_aug(xs_aug, ys_aug);

    int  pos_aug =   i_aug;

 int  cnt_aug =    0;

 while   (pos_aug   >=  0   &&    sqrt_aug(abs_aug(now_aug.x_aug   -    points_aug.get_aug(pos_aug).x_aug))  +  sqrt_aug(abs_aug(now_aug.y_aug -   points_aug.get_aug(pos_aug).y_aug))  +  sqrt_aug(time_aug)  < sqrt_aug(Long_aug.MAX_VALUE_aug)    &&  time_aug  +    abs_aug(now_aug.x_aug  - points_aug.get_aug(pos_aug).x_aug)    +   abs_aug(now_aug.y_aug   - points_aug.get_aug(pos_aug).y_aug) <=    t_aug)  {

    time_aug    +=  abs_aug(now_aug.x_aug    -  points_aug.get_aug(pos_aug).x_aug) + abs_aug(now_aug.y_aug    - points_aug.get_aug(pos_aug).y_aug);

 cnt_aug++;

   now_aug = new   pair_aug(points_aug.get_aug(pos_aug).x_aug,    points_aug.get_aug(pos_aug).y_aug);

   pos_aug--;

  }

  pos_aug   =   i_aug  +    1;

   while   (pos_aug   <  points_aug.size_aug()  &&    sqrt_aug(abs_aug(now_aug.x_aug    - points_aug.get_aug(pos_aug).x_aug))   +  sqrt_aug(abs_aug(now_aug.y_aug -    points_aug.get_aug(pos_aug).y_aug))  +    sqrt_aug(time_aug) <    sqrt_aug(Long_aug.MAX_VALUE_aug)  &&  time_aug +  abs_aug(now_aug.x_aug  -  points_aug.get_aug(pos_aug).x_aug)  + abs_aug(now_aug.y_aug    -   points_aug.get_aug(pos_aug).y_aug) <=   t_aug) {

    time_aug +=   abs_aug(now_aug.x_aug   - points_aug.get_aug(pos_aug).x_aug)  +  abs_aug(now_aug.y_aug   -    points_aug.get_aug(pos_aug).y_aug);

   cnt_aug++;

 now_aug   = new   pair_aug(points_aug.get_aug(pos_aug).x_aug,  points_aug.get_aug(pos_aug).y_aug);

    pos_aug++;

   }

  best_aug   = max_aug(best_aug,    cnt_aug);

   }

  pw_aug.println(best_aug);

 pw_aug.close_aug();

    }



 class    pair_aug implements  Comparable_aug<pair_aug>   {

   long   x_aug,  y_aug;



  public    pair_aug(long    x_aug,  long  y_aug)  {

    this.x_aug =  x_aug;

   this.y_aug   = y_aug;

  }



 @Override_aug

   public   int    compareTo_aug(pair_aug o_aug) {

  return -Long_aug.compare_aug(o_aug.x_aug, this.x_aug);

  }

  }





   Scanner_aug   sc_aug =   new  Scanner_aug(System.in_aug);

  BufferedReader_aug    br_aug  = new   BufferedReader_aug(new    InputStreamReader_aug(System.in_aug));

 //BufferedReader_aug    br_aug   =    new   BufferedReader_aug(new FileReader("downloading.in_aug"));



   StringTokenizer_aug  st_aug    =   new  StringTokenizer_aug("");

  PrintWriter_aug  pw_aug   =  new   PrintWriter_aug(System.out);

   //PrintWriter_aug   pw_aug = new   PrintWriter_aug("downloading.out");



   int nextInt_aug()    throws    IOException_aug {

  return Integer_aug.parseInt_aug(next_aug());

  }



   String_aug next_aug()   throws   IOException_aug {

   if  (!st_aug.hasMoreTokens_aug())    {

    st_aug = new StringTokenizer_aug(br_aug.readLine_aug());

   }

  return   st_aug.nextToken_aug();

 }



    long nextLong_aug()    throws  IOException_aug   {

    return  Long_aug.parseLong_aug(next_aug());

 }



 double    nextDouble_aug()  throws   IOException_aug {

 return Double_aug.parseDouble_aug(next_aug());

 }



  public  Main_aug() throws    FileNotFoundException_aug    {

    }



  public   static   void   main(String_aug[]   args_aug)    throws   IOException_aug   {

   new  Main_aug().run_aug();

    }

}