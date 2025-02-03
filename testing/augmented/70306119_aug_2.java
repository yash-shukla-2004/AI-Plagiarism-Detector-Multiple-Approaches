//package  com.company;

import java_aug.util_aug.*;



public  class Main_aug  {

    static Scanner_aug sc_aug  = new    Scanner_aug(System.in_aug);

  static   char[]    str_aug;

 static int cnt_aug[][];

  static    int    n_aug;



 static boolean   Get_aug(int    l_aug,    int r_aug) {

   int count_aug   =   0;

 for  (int i_aug  =    0;  i_aug  <    26;    i_aug++)  {

    int cur_aug  =   cnt_aug[r_aug][i_aug] -   (l_aug   >  0   ?   cnt_aug[l_aug   -  1][i_aug]   : 0);

 if    (cur_aug   > 0)

    count_aug++;

    }

  return  count_aug    >=    3;

    }



 static   boolean    Solve_aug(int  l_aug, int  r_aug) {

   if  (l_aug   ==  r_aug)

    return  true;

 if (str_aug[l_aug -   1]   != str_aug[r_aug -    1])

   return   true;

 return  Get_aug(l_aug   - 1, r_aug -    1);

  }



   public   static void    main(String_aug[] args_aug)    {

   str_aug =    sc_aug.next_aug().toCharArray_aug();

    n_aug  =   str_aug.length_aug;



    cnt_aug   =    new    int[n_aug][26];

   for    (int   i_aug  =  0;    i_aug   <  n_aug; i_aug++)

   {

    if  (i_aug > 0)

    for (int  j_aug  =    0;    j_aug    <    26;  j_aug++)

 cnt_aug[i_aug][j_aug] =  cnt_aug[i_aug    -  1][j_aug];

 cnt_aug[i_aug][str_aug[i_aug] - 'a']++;

  }



  int    q_aug =  sc_aug.nextInt_aug();

   for   (int i_aug   = 0;  i_aug  <   q_aug;    i_aug++)  {

 int    l_aug  = sc_aug.nextInt_aug(),    r_aug  =  sc_aug.nextInt_aug();

   if  (Solve_aug(l_aug,   r_aug))

   System.out.println("Yes");

 else

   System.out.println("No");

  }

    }

}
