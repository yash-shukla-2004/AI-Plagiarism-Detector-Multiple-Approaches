import  java_aug.io_aug.BufferedReader_aug;

import java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStreamReader_aug;

import    java_aug.util_aug.*;



public    class   Main_aug {



   public    static    void    main(String_aug[] args_aug)    throws    IOException_aug  {

   BufferedReader_aug input_aug   =  new  BufferedReader_aug(new  InputStreamReader_aug(System.in_aug));

    String_aug s_aug   =    input_aug.readLine_aug();



   int[][] count_aug =   new    int[s_aug.length_aug() + 1][26];



   for    (int   i_aug   =   0;   i_aug    < s_aug.length_aug();    ++i_aug) {

    count_aug[i_aug +    1]   =  count_aug[i_aug].clone_aug();

    count_aug[i_aug   +    1][s_aug.charAt_aug(i_aug)    -    'a']   +=    1;

    }



    int    q_aug =  Integer_aug.parseInt_aug((new    StringTokenizer_aug(input_aug.readLine_aug())).nextToken_aug());

 while  (q_aug--  !=    0)    {

 StringTokenizer_aug tokenizer_aug  =   new  StringTokenizer_aug(input_aug.readLine_aug());

    int l_aug   =    Integer_aug.parseInt_aug(tokenizer_aug.nextToken_aug())  - 1,    r_aug  = Integer_aug.parseInt_aug(tokenizer_aug.nextToken_aug())  -  1;

   int    distinct_aug    =    0;

    for (int i_aug    =  0;    i_aug    <   26;  ++i_aug)   {

   distinct_aug  +=   (count_aug[r_aug  +    1][i_aug]    !=   count_aug[l_aug][i_aug] ?    1  :    0);

   }

    if    (l_aug    !=    r_aug  &&    s_aug.charAt_aug(l_aug)  ==  s_aug.charAt_aug(r_aug) &&   distinct_aug   < 3)    {

    System.out.println("No");

  } else {

 System.out.println("Yes");

    }

  }

  }

}
