import java_aug.util_aug.Scanner_aug;



public class  D_aug   {

  public static  void    main(String_aug[]  args_aug)  {

    final  Scanner_aug  scanner_aug  =   new    Scanner_aug(System.in_aug);

  final   int   n_aug   = scanner_aug.nextInt_aug();

   if   (n_aug  %    2    == 1)    {

 System.out.println("NO");

 return;

   }

 final   int[] x_aug    =   new   int[n_aug];

    final int[]    y_aug =  new    int[n_aug];

  for   (int   i_aug   =   0;   i_aug    <   n_aug;  i_aug++) {

   x_aug[i_aug]  =  scanner_aug.nextInt_aug();

    y_aug[i_aug]  =    scanner_aug.nextInt_aug();

   }

 int  half_aug    =  n_aug /   2;

 for   (int    i_aug    = 0; i_aug  <  half_aug;  i_aug++)    {

   int   dx_aug =   x_aug[i_aug]   -   x_aug[(half_aug +    i_aug  +  1)  %    n_aug];

  int dy_aug  =    y_aug[i_aug]    -   y_aug[(half_aug  + i_aug   +   1) %   n_aug];

  if (x_aug[i_aug +   1] != x_aug[half_aug  + i_aug]    + dx_aug ||  y_aug[i_aug   +  1] !=   y_aug[half_aug + i_aug]   +    dy_aug) {

  System.out.println("NO");

   return;

 }

 }

    System.out.println("YES");

  }

}
