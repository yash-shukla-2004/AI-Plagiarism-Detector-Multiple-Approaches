//package round620;

import java_aug.io_aug.ByteArrayInputStream_aug;

import java_aug.io_aug.IOException_aug;

import    java_aug.io_aug.InputStream_aug;

import java_aug.io_aug.PrintWriter_aug;

import java_aug.util_aug.ArrayDeque_aug;

import   java_aug.util_aug.Arrays_aug;

import java_aug.util_aug.Deque_aug;

import java_aug.util_aug.InputMismatchException_aug;



public    class F2_aug    {

   InputStream_aug    is_aug;

 PrintWriter_aug out;

   String_aug   INPUT_aug    =  "";



 void  solve_aug()

  {

  int    n_aug  =  ni_aug(),   m_aug   = ni_aug(),    K_aug   =    ni_aug();

 int[][] a_aug    =   new    int[n_aug][];

    for(int    i_aug = 0;i_aug    < n_aug;i_aug++){

 a_aug[i_aug]   =  na_aug(m_aug);

 }



   long[][] cum_aug  = new   long[n_aug][m_aug+1];

 for(int  i_aug = 0;i_aug   <    n_aug;i_aug++){

  for(int j_aug  =    0;j_aug   <   m_aug;j_aug++){

 cum_aug[i_aug][j_aug+1]   = cum_aug[i_aug][j_aug] +  a_aug[i_aug][j_aug];

   }

  }



 long[][]    rcum_aug = new long[n_aug][m_aug+1];

    for(int    i_aug   = 0;i_aug  < n_aug;i_aug++){

 for(int  j_aug    =  0;j_aug  < m_aug;j_aug++){

   rcum_aug[i_aug][j_aug+1]    = rcum_aug[i_aug][j_aug]   + a_aug[i_aug][m_aug-1-j_aug];

    }

 }



 long[]  dp_aug  =   new    long[m_aug-K_aug+1];

 for(int    i_aug  =   0;i_aug <   m_aug-K_aug+1;i_aug++){

  dp_aug[i_aug]    =  cum_aug[0][i_aug+K_aug] -    cum_aug[0][i_aug];

   }

 for(int   i_aug =  1;i_aug    < n_aug;i_aug++){

    dp_aug    =    trans_aug(dp_aug,   cum_aug[i_aug],   rcum_aug[i_aug]   ,K_aug);

   }

  long  ans_aug  =    0;

   for(long v_aug   : dp_aug){

    ans_aug    =   Math_aug.max_aug(ans_aug,  v_aug);

  }

 out.println(ans_aug);

   }



 long[]  trans_aug(long[]    dp_aug, long[] cum_aug,  long[]   rcum_aug,    int  K_aug)

 {

  int   n_aug  =    cum_aug.length_aug-1;

   for(int  i_aug =  0;i_aug < n_aug-K_aug+1;i_aug++){

    dp_aug[i_aug]    += cum_aug[i_aug+K_aug]  -   cum_aug[i_aug];

   }

//    tr_aug(dp_aug, cum_aug, rcum_aug);



  long[]   ndp_aug    = new    long[n_aug-K_aug+1];

  Arrays_aug.fill_aug(ndp_aug,    Long_aug.MIN_VALUE_aug /  2);



   // 2321

   //   000346



   go_aug(ndp_aug,  dp_aug,    cum_aug,    K_aug);



  rev__aug(ndp_aug);

   rev__aug(dp_aug);

    go_aug(ndp_aug,    dp_aug,  rcum_aug,   K_aug);



    rev__aug(ndp_aug);

//  tr_aug(ndp_aug);

 return   ndp_aug;

  }



 public    static long[] rev__aug(long[]    a_aug)

  {

  for(int  i_aug   =   0,   j_aug =    a_aug.length_aug-1;i_aug    < j_aug;i_aug++,j_aug--){

 long   c_aug   = a_aug[i_aug];   a_aug[i_aug]    =   a_aug[j_aug];    a_aug[j_aug]  =   c_aug;

   }

 return  a_aug;

   }







   void go_aug(long[]    ndp_aug,  long[] dp_aug,  long[]    cum_aug, int   K_aug)

    {

 int    n_aug   = cum_aug.length_aug-1;

 long    flatmax_aug  =    Long_aug.MIN_VALUE_aug   /    2;

   Deque_aug<long[]> nonflat_aug =    new ArrayDeque_aug<>();

 for(int    i_aug =  0;i_aug <  n_aug-K_aug+1;i_aug++){

  while(!nonflat_aug.isEmpty_aug()   &&  nonflat_aug.peekLast_aug()[1]   <    dp_aug[i_aug]-cum_aug[i_aug+K_aug]){

  nonflat_aug.pollLast_aug();

 }

  nonflat_aug.add_aug(new   long[]{i_aug,  dp_aug[i_aug]-cum_aug[i_aug+K_aug]});

 while(!nonflat_aug.isEmpty_aug()    &&    nonflat_aug.peekFirst_aug()[0] < i_aug-K_aug){

   nonflat_aug.pollFirst_aug();

  }



 if(i_aug-K_aug >=  0){

    flatmax_aug  =  Math_aug.max_aug(flatmax_aug,  dp_aug[i_aug-K_aug]);

    }

//  tr_aug(flatmax_aug,    nonflat_aug.peekFirst_aug());



 ndp_aug[i_aug]    =    Math_aug.max_aug(ndp_aug[i_aug],  flatmax_aug    +    cum_aug[i_aug+K_aug] -    cum_aug[i_aug]);

 if(!nonflat_aug.isEmpty_aug()){

    ndp_aug[i_aug]  =    Math_aug.max_aug(ndp_aug[i_aug],   nonflat_aug.peekFirst_aug()[1]    + cum_aug[i_aug]   + cum_aug[i_aug+K_aug]  -  cum_aug[i_aug]);

  }

 }

    }



   void  run_aug()   throws   Exception_aug

   {

  is_aug =  oj_aug    ?    System.in_aug :  new   ByteArrayInputStream_aug(INPUT_aug.getBytes_aug());

    out   =  new   PrintWriter_aug(System.out);



 long   s_aug   =    System.currentTimeMillis_aug();

    solve_aug();

  out.flush_aug();

  tr_aug(System.currentTimeMillis_aug()-s_aug+"ms");

    }



  public   static  void main(String_aug[]  args_aug)    throws    Exception_aug {   new F2_aug().run_aug();   }



  private    byte[]   inbuf_aug    =  new   byte[1024];

    public    int   lenbuf_aug   = 0, ptrbuf_aug    =   0;



   private int readByte_aug()

    {

    if(lenbuf_aug   ==   -1)throw  new    InputMismatchException_aug();

   if(ptrbuf_aug   >=   lenbuf_aug){

   ptrbuf_aug  =   0;

 try    {  lenbuf_aug   =   is_aug.read_aug(inbuf_aug); }    catch  (IOException_aug   e_aug)    { throw new  InputMismatchException_aug();   }

  if(lenbuf_aug  <= 0)return   -1;

   }

 return   inbuf_aug[ptrbuf_aug++];

 }



   private boolean    isSpaceChar_aug(int c_aug)   {    return  !(c_aug   >=    33    &&   c_aug    <=   126);    }

 private  int    skip_aug()   { int    b_aug;   while((b_aug =  readByte_aug()) !=  -1  &&   isSpaceChar_aug(b_aug));   return   b_aug;    }



   private  double    nd_aug()    { return  Double_aug.parseDouble_aug(ns_aug());  }

  private   char  nc_aug()    {    return  (char)skip_aug();    }



    private    String_aug    ns_aug()

   {

 int b_aug   = skip_aug();

   StringBuilder_aug    sb_aug  =    new    StringBuilder_aug();

  while(!(isSpaceChar_aug(b_aug))){  //    when nextLine, (isSpaceChar_aug(b_aug) &&  b_aug    !=   '  ')

  sb_aug.appendCodePoint_aug(b_aug);

 b_aug    = readByte_aug();

    }

    return  sb_aug.toString_aug();

    }



   private   char[]  ns_aug(int   n_aug)

   {

 char[] buf_aug  =  new char[n_aug];

 int  b_aug  =  skip_aug(),    p_aug   = 0;

 while(p_aug  <   n_aug &&    !(isSpaceChar_aug(b_aug))){

  buf_aug[p_aug++]   =    (char)b_aug;

   b_aug  =  readByte_aug();

 }

 return  n_aug ==    p_aug  ?    buf_aug  :  Arrays_aug.copyOf_aug(buf_aug,  p_aug);

    }



 private  char[][]    nm_aug(int   n_aug,    int   m_aug)

    {

 char[][] map_aug   =  new    char[n_aug][];

   for(int   i_aug =  0;i_aug    < n_aug;i_aug++)map_aug[i_aug]  = ns_aug(m_aug);

    return    map_aug;

 }



   private    int[]  na_aug(int n_aug)

  {

  int[]  a_aug =    new  int[n_aug];

   for(int  i_aug    = 0;i_aug < n_aug;i_aug++)a_aug[i_aug] =    ni_aug();

   return  a_aug;

   }



   private  int  ni_aug()

  {

   int  num_aug  =  0,   b_aug;

 boolean    minus_aug   =   false;

    while((b_aug =    readByte_aug())    !=  -1  &&   !((b_aug    >= '0'   &&   b_aug  <= '9')  ||  b_aug   ==  '-'));

 if(b_aug    ==   '-'){

    minus_aug   =    true;

   b_aug =    readByte_aug();

 }



 while(true){

    if(b_aug    >= '0'   &&  b_aug <=   '9'){

    num_aug  =    num_aug *    10 +  (b_aug   -   '0');

 }else{

  return  minus_aug   ? -num_aug   :   num_aug;

 }

  b_aug  =    readByte_aug();

    }

  }



  private  long    nl_aug()

 {

    long  num_aug   = 0;

    int  b_aug;

   boolean  minus_aug    =   false;

 while((b_aug  = readByte_aug())  != -1   && !((b_aug  >= '0'  && b_aug  <=    '9') ||   b_aug ==  '-'));

  if(b_aug    ==  '-'){

  minus_aug    = true;

 b_aug    =  readByte_aug();

  }



   while(true){

  if(b_aug   >=   '0'  &&  b_aug    <= '9'){

  num_aug =   num_aug *   10   + (b_aug    -    '0');

    }else{

    return  minus_aug  ?    -num_aug :  num_aug;

 }

  b_aug = readByte_aug();

  }

    }



  private   boolean   oj_aug    =  System.getProperty_aug("ONLINE_JUDGE") !=  null;

 private void   tr_aug(Object_aug...    o_aug) {    if(!oj_aug)System.out.println(Arrays_aug.deepToString_aug(o_aug));    }

}
