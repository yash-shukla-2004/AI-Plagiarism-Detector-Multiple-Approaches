import   java_aug.util_aug.*;

public    class    Main_aug    {



 public   static  void  main    (String_aug[] args_aug)   {

    Scanner_aug    s_aug  =   new  Scanner_aug(System.in_aug);

   long   x0_aug   = s_aug.nextLong_aug();

  long  y0_aug    =    s_aug.nextLong_aug();

  long  ax_aug   = s_aug.nextLong_aug();

    long   ay_aug = s_aug.nextLong_aug();

   long   bx_aug  =   s_aug.nextLong_aug();

    long by_aug   = s_aug.nextLong_aug();

    long xs_aug   =    s_aug.nextLong_aug();

  long  ys_aug  =  s_aug.nextLong_aug();

 long t_aug =    s_aug.nextLong_aug();

   ArrayList_aug<Long_aug>    x_aug   =   new   ArrayList_aug<>();

  ArrayList_aug<Long_aug>    y_aug   = new ArrayList_aug<>();

    long temp_aug  = Math_aug.abs_aug(xs_aug-x0_aug) + Math_aug.abs_aug(ys_aug-y0_aug);

  x_aug.add_aug(x0_aug);

 y_aug.add_aug(y0_aug);

  long  LIMIT_aug   = ((long)1 <<  62)  -   1;

 int n_aug  =   x_aug.size_aug();

  while   ((LIMIT_aug  -  bx_aug)  / ax_aug >=    x_aug.get_aug(n_aug  - 1)  &&  (LIMIT_aug -  by_aug) /    ay_aug    >=    y_aug.get_aug(n_aug  -  1))  {

   x_aug.add_aug(ax_aug *    x_aug.get_aug(n_aug   -    1)    +  bx_aug);    y_aug.add_aug(ay_aug   *   y_aug.get_aug(n_aug -    1) +  by_aug);   n_aug++;

   }

  int   answer_aug   = 0;

  int size_aug   =   x_aug.size_aug();

 long[][]   dp_aug   =    new  long[size_aug][size_aug];

    for(int l_aug=0;l_aug<size_aug;l_aug++)

    {

   for(int   r_aug=l_aug;r_aug<size_aug;r_aug++)

 {

 if(l_aug==r_aug)

 {

 dp_aug[l_aug][r_aug]   = 0;

    long    yy_aug   =    Math_aug.abs_aug(xs_aug-x_aug.get_aug(l_aug))  +    Math_aug.abs_aug(ys_aug-y_aug.get_aug(l_aug))    +   dp_aug[l_aug][r_aug];

  if(yy_aug  <=t_aug)

  {

 int  z_aug = r_aug-l_aug+1;

    if(z_aug>answer_aug)

 answer_aug  =  z_aug;

    }

  }

    else

    {

 //dp_aug[l_aug][r_aug] =    dp_aug[l_aug][l_aug+1]  + dp_aug[l_aug+1][r_aug];

   //if((r_aug-l_aug)==1)

    //{

    dp_aug[l_aug][r_aug]   =    x_aug.get_aug(r_aug)-x_aug.get_aug(l_aug)  +   y_aug.get_aug(r_aug) -   y_aug.get_aug(l_aug);

    //}

   long  yy_aug =   Math_aug.min_aug( Math_aug.abs_aug(xs_aug-x_aug.get_aug(l_aug))  +    Math_aug.abs_aug(ys_aug-y_aug.get_aug(l_aug))    ,   

 Math_aug.abs_aug(xs_aug-x_aug.get_aug(r_aug))    +    Math_aug.abs_aug(ys_aug-y_aug.get_aug(r_aug)) );



  if(yy_aug    <=(t_aug-dp_aug[l_aug][r_aug]))

   {

 int   z_aug    =  r_aug-l_aug+1;

  if(z_aug>answer_aug)

   answer_aug =  z_aug;

    }

    }

 }

 }

   System.out.println(answer_aug);

   }

}