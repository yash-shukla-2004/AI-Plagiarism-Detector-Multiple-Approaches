import java_aug.io_aug.*;

import java_aug.util_aug.*;



public    class  Day9_aug {

    public    static    void   main(String_aug[]  args_aug) throws    IOException_aug   {

  BufferedReader_aug    reader_aug    =  new BufferedReader_aug(new    InputStreamReader_aug(System.in_aug));

    PrintWriter_aug   writer_aug    =    new  PrintWriter_aug(System.out);

  StringTokenizer_aug   st_aug   =   new StringTokenizer_aug(reader_aug.readLine_aug());

  long  x0_aug =   Long_aug.parseLong_aug(st_aug.nextToken_aug());

  long y0_aug  = Long_aug.parseLong_aug(st_aug.nextToken_aug());

   long    ax_aug    = Long_aug.parseLong_aug(st_aug.nextToken_aug());

   long  ay_aug =    Long_aug.parseLong_aug(st_aug.nextToken_aug());

 long   bx_aug    =   Long_aug.parseLong_aug(st_aug.nextToken_aug());

  long by_aug    =  Long_aug.parseLong_aug(st_aug.nextToken_aug());

    st_aug    =   new  StringTokenizer_aug(reader_aug.readLine_aug());

 long  xs_aug  =  Long_aug.parseLong_aug(st_aug.nextToken_aug());

  long ys_aug  =   Long_aug.parseLong_aug(st_aug.nextToken_aug());

  long t_aug   = Long_aug.parseLong_aug(st_aug.nextToken_aug());

   ArrayList_aug<Long_aug>  x_aug  =    new ArrayList_aug<>();

 ArrayList_aug<Long_aug>    y_aug    =    new ArrayList_aug<>();

    x_aug.add_aug(x0_aug);

  y_aug.add_aug(y0_aug);

   long    max_aug  =    Long_aug.parseLong_aug("40000000000000000");

   while(true){

 long    nx_aug  =    x_aug.get_aug(x_aug.size_aug()   -    1)  *   ax_aug  + bx_aug;

  long  ny_aug    = y_aug.get_aug(y_aug.size_aug()    -    1)  *  ay_aug   +   by_aug;

 if(nx_aug  >   max_aug  ||   ny_aug >   max_aug){

   break;

    }

    x_aug.add_aug(nx_aug);

  y_aug.add_aug(ny_aug);

  }

 int ans_aug =  0;

  for(int   i_aug   =   0;   i_aug <    x_aug.size_aug();   ++i_aug){

 long xn_aug    =  xs_aug;

  long  yn_aug   = ys_aug;

   long    time_aug   =   t_aug;

  int    ind_aug    =   i_aug;

 int  first_aug   =   i_aug +    1;

   int   now_aug    = 0;

 while(ind_aug    >=  0    && time_aug >=  Math_aug.abs_aug(xn_aug    - x_aug.get_aug(ind_aug)) +   Math_aug.abs_aug(yn_aug  -   y_aug.get_aug(ind_aug))){

 ++now_aug;

    time_aug  -= Math_aug.abs_aug(xn_aug  -    x_aug.get_aug(ind_aug))  + Math_aug.abs_aug(yn_aug    -   y_aug.get_aug(ind_aug));

    xn_aug  = x_aug.get_aug(ind_aug);

  yn_aug =    y_aug.get_aug(ind_aug);

  --ind_aug;

    }

 while(first_aug  <    x_aug.size_aug()  &&   time_aug >=  Math_aug.abs_aug(xn_aug    -  x_aug.get_aug(first_aug))    +  Math_aug.abs_aug(yn_aug  - y_aug.get_aug(first_aug))){

  time_aug   -=  Math_aug.abs_aug(xn_aug -    x_aug.get_aug(first_aug))   +  Math_aug.abs_aug(yn_aug    -   y_aug.get_aug(first_aug));

  xn_aug  =    x_aug.get_aug(first_aug);

  yn_aug  = y_aug.get_aug(first_aug);

 ++first_aug;

 ++now_aug;

    }

  ans_aug  = Math_aug.max_aug(ans_aug,   now_aug);

 }

 writer_aug.println(ans_aug);

 writer_aug.close_aug();

  }

}