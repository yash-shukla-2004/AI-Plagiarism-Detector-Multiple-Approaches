//package  educational.round82;

import  java_aug.io_aug.ByteArrayInputStream_aug;

import    java_aug.io_aug.IOException_aug;

import   java_aug.io_aug.InputStream_aug;

import   java_aug.io_aug.PrintWriter_aug;

import   java_aug.util_aug.Arrays_aug;

import  java_aug.util_aug.InputMismatchException_aug;



public  class    E_aug  {

  InputStream_aug    is_aug;

  PrintWriter_aug out;

    String_aug   INPUT_aug    =   "";



  void   solve_aug()

    {

   for(int T_aug  =  ni_aug();T_aug  >  0;T_aug--) {

  char[]  s_aug   =   ns_aug().toCharArray_aug();

   char[]    t_aug    = ns_aug().toCharArray_aug();

  if(ok_aug(s_aug,    t_aug)) {

    out.println("YES");

   }else  {

  out.println("NO");

    }

    }

  }



 boolean  ok_aug(char[] s_aug, char[]    t_aug)

 {

   int n_aug = s_aug.length_aug,  m_aug   =    t_aug.length_aug;

  for(int  K_aug  = 0;K_aug  <   m_aug;K_aug++) {

   //   [0,K_aug),    [K_aug,m_aug)

   int[] dp_aug   =   new int[K_aug+1];

   Arrays_aug.fill_aug(dp_aug, -999999999);

  dp_aug[0]    =   0;

  for(int    i_aug  =   0;i_aug   <    n_aug;i_aug++)  {

  for(int    j_aug  =    K_aug;j_aug  >=  0;j_aug--)   {

    if(dp_aug[j_aug]    >=    0) {

   if(j_aug  <  K_aug   &&  s_aug[i_aug] == t_aug[j_aug])    {

  dp_aug[j_aug+1] =   Math_aug.max_aug(dp_aug[j_aug+1],  dp_aug[j_aug]);

  }

  if(dp_aug[j_aug]  <  m_aug-K_aug  &&    s_aug[i_aug]  == t_aug[K_aug+dp_aug[j_aug]])    {

    dp_aug[j_aug]++;

    }

   }

 }

   }

    if(dp_aug[K_aug]   ==   m_aug-K_aug)return  true;

  }

    return    false;

 }



    void    run_aug() throws    Exception_aug

 {

  is_aug =    oj_aug ? System.in_aug  : new   ByteArrayInputStream_aug(INPUT_aug.getBytes_aug());

    out   = new    PrintWriter_aug(System.out);



  long  s_aug    =   System.currentTimeMillis_aug();

  solve_aug();

  out.flush_aug();

 tr_aug(System.currentTimeMillis_aug()-s_aug+"ms");

  }



    public    static   void    main(String_aug[] args_aug) throws    Exception_aug {   new E_aug().run_aug();  }



   private  byte[]    inbuf_aug  =  new byte[1024];

 public   int lenbuf_aug    =  0,    ptrbuf_aug   =   0;



  private int    readByte_aug()

 {

  if(lenbuf_aug  ==  -1)throw  new   InputMismatchException_aug();

 if(ptrbuf_aug >= lenbuf_aug){

   ptrbuf_aug    = 0;

 try  { lenbuf_aug  =   is_aug.read_aug(inbuf_aug);    }  catch (IOException_aug   e_aug)   {   throw   new InputMismatchException_aug();   }

 if(lenbuf_aug    <= 0)return    -1;

  }

    return  inbuf_aug[ptrbuf_aug++];

    }



 private    boolean   isSpaceChar_aug(int   c_aug) { return  !(c_aug >=    33  && c_aug    <= 126);  }

  private  int  skip_aug()    {  int  b_aug;   while((b_aug    =    readByte_aug())  !=  -1   &&   isSpaceChar_aug(b_aug));  return b_aug;  }



 private double  nd_aug()   { return  Double_aug.parseDouble_aug(ns_aug()); }

  private char   nc_aug() {  return (char)skip_aug();  }



   private String_aug    ns_aug()

  {

  int  b_aug  = skip_aug();

  StringBuilder_aug    sb_aug  =   new StringBuilder_aug();

  while(!(isSpaceChar_aug(b_aug))){  //  when nextLine, (isSpaceChar_aug(b_aug)  &&   b_aug  !=   ' ')

    sb_aug.appendCodePoint_aug(b_aug);

    b_aug =   readByte_aug();

  }

   return sb_aug.toString_aug();

    }



  private  char[] ns_aug(int   n_aug)

    {

    char[]   buf_aug    =  new    char[n_aug];

 int b_aug    =    skip_aug(),    p_aug    =   0;

 while(p_aug <  n_aug   && !(isSpaceChar_aug(b_aug))){

    buf_aug[p_aug++] =   (char)b_aug;

  b_aug  =    readByte_aug();

    }

   return n_aug  == p_aug   ?   buf_aug  :   Arrays_aug.copyOf_aug(buf_aug, p_aug);

  }



    private    char[][]    nm_aug(int  n_aug,   int m_aug)

    {

    char[][]    map_aug =  new  char[n_aug][];

 for(int    i_aug =   0;i_aug    < n_aug;i_aug++)map_aug[i_aug]    =   ns_aug(m_aug);

   return  map_aug;

  }



 private int[]    na_aug(int    n_aug)

    {

    int[] a_aug   =   new   int[n_aug];

   for(int  i_aug  =   0;i_aug  <   n_aug;i_aug++)a_aug[i_aug] =  ni_aug();

   return  a_aug;

    }



   private    int ni_aug()

    {

  int    num_aug  =   0,   b_aug;

  boolean  minus_aug  =  false;

 while((b_aug    =   readByte_aug())   !=  -1  &&  !((b_aug    >=  '0' &&    b_aug   <=   '9') || b_aug    ==   '-'));

   if(b_aug == '-'){

   minus_aug =    true;

 b_aug  =   readByte_aug();

 }



  while(true){

    if(b_aug    >=    '0' &&    b_aug   <=   '9'){

   num_aug  = num_aug *  10  +   (b_aug - '0');

    }else{

 return minus_aug  ?    -num_aug  :  num_aug;

  }

  b_aug    =    readByte_aug();

 }

   }



    private    long    nl_aug()

  {

  long  num_aug  =  0;

 int  b_aug;

  boolean    minus_aug  =  false;

  while((b_aug  =   readByte_aug())   != -1  && !((b_aug  >=    '0'   &&  b_aug    <= '9')   || b_aug  ==    '-'));

  if(b_aug    ==    '-'){

   minus_aug =   true;

    b_aug =  readByte_aug();

 }



 while(true){

  if(b_aug >=   '0'  &&    b_aug <=    '9'){

    num_aug    =   num_aug  * 10 +    (b_aug  - '0');

    }else{

  return  minus_aug  ?  -num_aug  :    num_aug;

    }

    b_aug =  readByte_aug();

  }

 }



   private  boolean oj_aug =    System.getProperty_aug("ONLINE_JUDGE")    !=    null;

    private    void tr_aug(Object_aug...  o_aug)    {    if(!oj_aug)System.out.println(Arrays_aug.deepToString_aug(o_aug));    }

}
