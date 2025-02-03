//package round623;

import  java_aug.io_aug.ByteArrayInputStream_aug;

import java_aug.io_aug.IOException_aug;

import  java_aug.io_aug.InputStream_aug;

import   java_aug.io_aug.PrintWriter_aug;

import  java_aug.util_aug.Arrays_aug;

import java_aug.util_aug.InputMismatchException_aug;

import    java_aug.util_aug.Random_aug;



public   class    D2_aug   {

    InputStream_aug    is_aug;

  PrintWriter_aug out;

 String_aug INPUT_aug   = "";



   void    solve_aug()

 {

 long   S_aug    =   System.currentTimeMillis_aug();

 int n_aug  =    ni_aug(),    K_aug    = ni_aug();

  int[][] M_aug  =    new   int[n_aug][];

  for(int    i_aug = 0;i_aug <   n_aug;i_aug++)    {

  M_aug[i_aug]   =    na_aug(n_aug);

 }

  Random_aug  gen_aug   =  new   Random_aug();



    long  ans_aug  =    Long_aug.MAX_VALUE_aug;

   while(System.currentTimeMillis_aug() -  S_aug    <=  2700)    {

   boolean[]   hey_aug =    new boolean[n_aug];

    for(int    i_aug    =    0;i_aug  < n_aug/2;i_aug++)    {

    while(true)    {

 int   id_aug   =  gen_aug.nextInt_aug(n_aug-1)+1;

   if(!hey_aug[id_aug])    {

  hey_aug[id_aug] =    true;

  break;

 }

   }

   }

   long[]   dp_aug   =    new  long[n_aug];

    Arrays_aug.fill_aug(dp_aug,  Long_aug.MAX_VALUE_aug  / 3);

 dp_aug[0]  = 0;

  long[] cs_aug  =   new long[K_aug+1];

 for(int i_aug =    0;i_aug  < K_aug;i_aug++)   {

    long[]   ndp_aug =  new   long[n_aug];

    Arrays_aug.fill_aug(ndp_aug,   Long_aug.MAX_VALUE_aug  / 3);

 if(i_aug   % 2  ==   0)    {

 for(int    j_aug   = 0;j_aug   <  n_aug;j_aug++) {

   for(int  k_aug    = 0;k_aug  < n_aug;k_aug++)  {

 if(j_aug   !=   k_aug &&    hey_aug[k_aug])    {

   ndp_aug[k_aug] =  Math_aug.min_aug(ndp_aug[k_aug],    dp_aug[j_aug]    + M_aug[j_aug][k_aug]);

 }

   }

  }

   }else    {

 for(int   j_aug    =  0;j_aug    <  n_aug;j_aug++) {

 for(int k_aug    =  0;k_aug  <   n_aug;k_aug++)    {

   if(j_aug   !=    k_aug    &&  !hey_aug[k_aug]) {

  ndp_aug[k_aug]  =  Math_aug.min_aug(ndp_aug[k_aug],   dp_aug[j_aug]   +    M_aug[j_aug][k_aug]);

   }

 }

   }

 }

    dp_aug = ndp_aug;

    }

  ans_aug   =   Math_aug.min_aug(ans_aug, dp_aug[0]);

 }



    out.println(ans_aug);

 }



  void  run_aug() throws  Exception_aug

    {

//    int  n_aug =  80,   m_aug    = 99999;

//  Random_aug    gen_aug  = new  Random_aug(1);

// StringBuilder_aug    sb_aug  =  new   StringBuilder_aug();

//  sb_aug.append(n_aug +  "   ");

//    sb_aug.append(10   +    "    ");

// for  (int    i_aug  =    0; i_aug    <  n_aug*n_aug; i_aug++)    {

// sb_aug.append(gen_aug.nextInt_aug(100000000)   +  "  ");

//    }

//    INPUT_aug   =  sb_aug.toString_aug();





   is_aug  =    oj_aug   ?  System.in_aug   :  new  ByteArrayInputStream_aug(INPUT_aug.getBytes_aug());

 out =    new  PrintWriter_aug(System.out);



  long   s_aug    =    System.currentTimeMillis_aug();

  solve_aug();

 out.flush_aug();

 tr_aug(System.currentTimeMillis_aug()-s_aug+"ms");

  }



   public  static void    main(String_aug[]    args_aug)   throws Exception_aug   {   new   D2_aug().run_aug();    }



    private  byte[]   inbuf_aug  = new   byte[1024];

    public    int lenbuf_aug   =   0,   ptrbuf_aug   =   0;



  private    int  readByte_aug()

  {

  if(lenbuf_aug    ==  -1)throw  new   InputMismatchException_aug();

  if(ptrbuf_aug  >= lenbuf_aug){

   ptrbuf_aug  =   0;

    try    {    lenbuf_aug  =  is_aug.read_aug(inbuf_aug);  }   catch (IOException_aug   e_aug)    {    throw    new   InputMismatchException_aug(); }

  if(lenbuf_aug <=   0)return  -1;

   }

  return   inbuf_aug[ptrbuf_aug++];

   }



    private boolean isSpaceChar_aug(int    c_aug) {    return   !(c_aug >=   33  &&    c_aug   <= 126);  }

   private  int   skip_aug()   {   int  b_aug; while((b_aug   =    readByte_aug())  !=    -1   &&  isSpaceChar_aug(b_aug)); return b_aug;   }



   private   double    nd_aug()   {   return    Double_aug.parseDouble_aug(ns_aug());   }

  private    char    nc_aug()    {   return    (char)skip_aug();    }



  private    String_aug ns_aug()

  {

   int    b_aug   =   skip_aug();

    StringBuilder_aug  sb_aug   =   new  StringBuilder_aug();

 while(!(isSpaceChar_aug(b_aug))){ // when  nextLine,    (isSpaceChar_aug(b_aug)    && b_aug   !=  '   ')

  sb_aug.appendCodePoint_aug(b_aug);

  b_aug   =    readByte_aug();

   }

 return   sb_aug.toString_aug();

 }



  private    char[]  ns_aug(int    n_aug)

    {

 char[]   buf_aug  =  new char[n_aug];

  int b_aug    =  skip_aug(),  p_aug    =   0;

    while(p_aug  <  n_aug   &&  !(isSpaceChar_aug(b_aug))){

   buf_aug[p_aug++]  = (char)b_aug;

   b_aug =    readByte_aug();

   }

    return   n_aug    ==  p_aug    ?   buf_aug  :  Arrays_aug.copyOf_aug(buf_aug,    p_aug);

  }



  private  char[][]   nm_aug(int  n_aug, int    m_aug)

  {

 char[][]  map_aug =  new  char[n_aug][];

   for(int    i_aug =  0;i_aug    < n_aug;i_aug++)map_aug[i_aug]   =    ns_aug(m_aug);

 return map_aug;

    }



    private int[]    na_aug(int   n_aug)

    {

  int[] a_aug =   new    int[n_aug];

    for(int  i_aug =  0;i_aug  <    n_aug;i_aug++)a_aug[i_aug]  = ni_aug();

    return a_aug;

 }



    private int ni_aug()

   {

 int   num_aug =  0,  b_aug;

  boolean   minus_aug   =   false;

    while((b_aug = readByte_aug())   != -1    &&  !((b_aug >=    '0'    &&  b_aug    <=    '9')  || b_aug    ==   '-'));

 if(b_aug  ==  '-'){

   minus_aug  =   true;

   b_aug    =    readByte_aug();

    }



  while(true){

 if(b_aug   >=    '0' &&    b_aug <=   '9'){

   num_aug    =  num_aug *   10   +    (b_aug    -   '0');

   }else{

  return   minus_aug   ?  -num_aug  :    num_aug;

   }

 b_aug   =    readByte_aug();

  }

 }



  private    long nl_aug()

   {

  long  num_aug = 0;

 int  b_aug;

   boolean  minus_aug  =    false;

   while((b_aug   =    readByte_aug())   !=   -1  &&  !((b_aug  >=   '0'  && b_aug <=  '9')  || b_aug    ==  '-'));

 if(b_aug  ==   '-'){

    minus_aug =    true;

 b_aug    =  readByte_aug();

 }



 while(true){

  if(b_aug  >=   '0'    &&  b_aug   <= '9'){

    num_aug  = num_aug   *    10   +   (b_aug    -    '0');

    }else{

   return minus_aug   ? -num_aug    :    num_aug;

   }

 b_aug   =  readByte_aug();

    }

 }



 private boolean oj_aug    =  System.getProperty_aug("ONLINE_JUDGE")   !=  null;

 private   void  tr_aug(Object_aug...  o_aug)   { if(!oj_aug)System.out.println(Arrays_aug.deepToString_aug(o_aug)); }

}
