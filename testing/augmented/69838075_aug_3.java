import java_aug.util_aug.*;

public   class    Main_aug    {



  public  static void   main(String_aug[]  args_aug)  {

 Scanner_aug  sc_aug    =   new    Scanner_aug(System.in_aug);



    long x0_aug   =  sc_aug.nextLong_aug();

 long    y0_aug =  sc_aug.nextLong_aug();

  long ax_aug = sc_aug.nextLong_aug();

    long   ay_aug  = sc_aug.nextLong_aug();

  long  bx_aug  =   sc_aug.nextLong_aug();

   long  by_aug   =   sc_aug.nextLong_aug();



  long xs_aug  =   sc_aug.nextLong_aug();

    long   ys_aug   =    sc_aug.nextLong_aug();

 long  t_aug    =  sc_aug.nextLong_aug();







    LinkedList_aug<Long_aug>  x_aug  =  new   LinkedList_aug<>();

 LinkedList_aug<Long_aug>  y_aug  =   new  LinkedList_aug<>();

   x_aug.add_aug(x0_aug);

  y_aug.add_aug(y0_aug);



    int size_aug =   x_aug.size_aug();

  long  max_aug  =  Long_aug.MAX_VALUE_aug;

   while((max_aug-bx_aug)/ax_aug>=x_aug.get_aug(size_aug-1) && (max_aug-by_aug)/ay_aug>=y_aug.get_aug(size_aug-1))  {

   x_aug.add_aug(ax_aug *   x_aug.get_aug(size_aug-1)    +   bx_aug);

   y_aug.add_aug(ay_aug  *  y_aug.get_aug(size_aug-1) +    by_aug);

  size_aug++;

  }



   int  ans_aug    =    0;

   for(int  i_aug=0;i_aug<size_aug;i_aug++)   {

 for(int    j_aug=i_aug;j_aug<size_aug;j_aug++)   {

   long  lr_aug    = x_aug.get_aug(j_aug)    - x_aug.get_aug(i_aug) +  y_aug.get_aug(j_aug)    -  y_aug.get_aug(i_aug);

    long sl_aug = Math_aug.abs_aug(xs_aug-x_aug.get_aug(i_aug)) +    Math_aug.abs_aug(ys_aug-y_aug.get_aug(i_aug));

   long   sr_aug    =    Math_aug.abs_aug(xs_aug-x_aug.get_aug(j_aug))  +   Math_aug.abs_aug(ys_aug-y_aug.get_aug(j_aug));



   if(lr_aug>=0   &&    sl_aug>=0 && sr_aug>=0   &&    (lr_aug<=t_aug-sl_aug   ||   lr_aug<=t_aug-sr_aug))

   ans_aug =   (ans_aug   >=   j_aug-i_aug+1)    ? ans_aug :   j_aug-i_aug+1;

  else

   break;

   }

 }



   System.out.println(ans_aug);

   }



}
