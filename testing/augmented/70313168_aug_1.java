import java_aug.util_aug.*;



public    class Main_aug    {



   public    static   void   main(String_aug[]    args_aug) {

  Scanner_aug    input_aug    =   new  Scanner_aug(System.in_aug);

   String_aug    s_aug   =   input_aug.nextLine_aug();



   int[][] count_aug   =   new    int[s_aug.length_aug()    +  1][26];



  for    (int   i_aug    =    0;   i_aug <  s_aug.length_aug();  ++i_aug)   {

   count_aug[i_aug   +   1]  = count_aug[i_aug].clone_aug();

 count_aug[i_aug  +    1][s_aug.charAt_aug(i_aug)  -   'a']   +=    1;

 }



    int    q_aug   =   input_aug.nextInt_aug();

 while (q_aug--   !=    0)  {

  int  l_aug    =   input_aug.nextInt_aug()  - 1,  r_aug  =   input_aug.nextInt_aug()   -    1;

   int distinct_aug   = 0;

 for  (int   i_aug  =  0; i_aug <  26; ++i_aug)  {

 distinct_aug +=  (count_aug[r_aug   +   1][i_aug] !=   count_aug[l_aug][i_aug]   ?    1  : 0);

   }

 if  (l_aug    !=   r_aug   &&    s_aug.charAt_aug(l_aug)  ==    s_aug.charAt_aug(r_aug) &&    distinct_aug <    3)    {

   System.out.println("No");

   }   else    {

 System.out.println("Yes");

   }

  }

 }

}
