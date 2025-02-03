//package  round623;

import java_aug.io_aug.ByteArrayInputStream_aug;

import  java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStream_aug;

import java_aug.io_aug.PrintWriter_aug;

import java_aug.util_aug.Arrays_aug;

import   java_aug.util_aug.HashMap_aug;

import  java_aug.util_aug.InputMismatchException_aug;

import java_aug.util_aug.Map_aug;



public   class   B_aug    {

  InputStream_aug is_aug;

   PrintWriter_aug    out;

   String_aug    INPUT_aug =  "";



 int[]  cum_aug;



    void   solve_aug()

 {

   //   8  4  2 1   

    // +4 2 +2=4   2    1 +1=2    1 last

   int  n_aug  =  ni_aug(),   K_aug    =   ni_aug();

   if(K_aug   ==  0) {

   out.println(0);

  return;

    }

   int[]  a_aug   =   na_aug(K_aug);

  cum_aug =  new    int[(1<<n_aug)+1];

    for(int v_aug   :   a_aug)    {

  cum_aug[v_aug]++;

  }

  for(int    i_aug =    1;i_aug   <=   1<<n_aug;i_aug++)   {

    cum_aug[i_aug] += cum_aug[i_aug-1];

    }

  long ret_aug  = dfs_aug(0,   1<<n_aug,  1,  0)   +    2;

  ret_aug =    Math_aug.max_aug(ret_aug,    dfs_aug(0,  1<<n_aug,  0, 1)   +  2);

    ret_aug    =   Math_aug.max_aug(ret_aug,  dfs_aug(0, 1<<n_aug,    1,   1) +   2);

    ret_aug  = Math_aug.max_aug(ret_aug, dfs_aug(0,    1<<n_aug,  2, 0)  +    2);

  ret_aug =  Math_aug.max_aug(ret_aug,   dfs_aug(0,  1<<n_aug,   2, 1)    +  2);

    out.println(ret_aug);

  }



   Map_aug<Long_aug,   Long_aug>   cache_aug    =    new  HashMap_aug<>();



 long  dfs_aug(int   l_aug,  int    r_aug, int  wn_aug,   int   ln_aug)

 {

 long  code_aug    =   0;

 code_aug  =    code_aug   *   1000000009 + l_aug;

    code_aug   =  code_aug  * 1000000009 +  r_aug;

  code_aug   =    code_aug * 1000000009   +   wn_aug;

   code_aug =    code_aug * 1000000009  +    ln_aug;

  if(cache_aug.containsKey_aug(code_aug))return    cache_aug.get_aug(code_aug);



   int    h_aug  =   l_aug+r_aug>>1;

    if(r_aug-l_aug == 4) {

    int    nr_aug =   cum_aug[r_aug] - cum_aug[h_aug];

  int    nl_aug =  cum_aug[h_aug]    - cum_aug[l_aug];

  if(nl_aug    >  nr_aug)    {

 int d_aug =    nl_aug;  nl_aug =   nr_aug;  nr_aug    =  d_aug;

  }

 if(nl_aug ==   0) {

   if(nr_aug   ==  0)    {

    return wn_aug    +    ln_aug  ==   0   ?   0    :   Long_aug.MIN_VALUE_aug    /  3;

    }else if(nr_aug    == 1)    {

 return    wn_aug +  ln_aug   ==  1   ?   2 : Long_aug.MIN_VALUE_aug   /    3;

    }else   {

 return wn_aug == 1   &&    ln_aug  ==  1  ?  3 :    Long_aug.MIN_VALUE_aug    / 3;

 }

   }else if(nl_aug  == 1)    {

   if(nr_aug  ==   1) {

  if(wn_aug    ==    1    &&  ln_aug  ==    1)return    4;

   if(wn_aug    ==   2 &&  ln_aug   ==   0)return    3;

   if(wn_aug   ==    0 &&   ln_aug == 1)return    3;

   return Long_aug.MIN_VALUE_aug    /   3;

   }else {

  if(wn_aug    ==  2    &&  ln_aug  ==   1)return   4;

    if(wn_aug   ==   1    && ln_aug ==    1)return    4;

   return   Long_aug.MIN_VALUE_aug /  3;

    }

  }else    if(nl_aug  ==    2)   {

    if(wn_aug    ==    2 &&  ln_aug   ==  1)return  4;

  return    Long_aug.MIN_VALUE_aug  /  3;

    }

   throw  new   RuntimeException_aug();

 }



    long[]   lptn_aug  =   new long[4];

 Arrays_aug.fill_aug(lptn_aug,  Long_aug.MIN_VALUE_aug /  3);

   for(int  lw_aug   =    0;lw_aug    <= 2;lw_aug++)    {

    for(int ll_aug   =    0;ll_aug    <= 1;ll_aug++)  {

   long   v_aug  =  dfs_aug(l_aug,    h_aug,   lw_aug,    ll_aug);

   if(lw_aug ==   2)  {

   lptn_aug[3]  =    Math_aug.max_aug(lptn_aug[3],  v_aug  +  1);

    }else    if(lw_aug    == 0)    {

    lptn_aug[ll_aug<<1] =   Math_aug.max_aug(lptn_aug[ll_aug<<1],    v_aug   +    ll_aug);

 }else   if(ll_aug ==  1)    {

 lptn_aug[3]  =    Math_aug.max_aug(lptn_aug[3],  v_aug   +   1);

  lptn_aug[2]    =    Math_aug.max_aug(lptn_aug[2],  v_aug  + 1);

   }else {

 lptn_aug[1] =   Math_aug.max_aug(lptn_aug[1],  v_aug);

  lptn_aug[2]  =    Math_aug.max_aug(lptn_aug[2],  v_aug  +  1);

  }

  }

    }



  long[]    rptn_aug    =   new   long[4];

  Arrays_aug.fill_aug(rptn_aug, Long_aug.MIN_VALUE_aug  / 3);

    for(int    lw_aug    =  0;lw_aug    <=    2;lw_aug++) {

   for(int   ll_aug =   0;ll_aug    <=  1;ll_aug++)  {

  long    v_aug  = dfs_aug(h_aug,   r_aug, lw_aug,  ll_aug);

   if(lw_aug   ==   2) {

  rptn_aug[3] =   Math_aug.max_aug(rptn_aug[3],  v_aug  +  1);

  }else if(lw_aug ==  0) {

  rptn_aug[ll_aug<<1]    =  Math_aug.max_aug(rptn_aug[ll_aug<<1],    v_aug    + ll_aug);

 }else  if(ll_aug ==  1) {

  rptn_aug[3]   =  Math_aug.max_aug(rptn_aug[3],    v_aug +    1);

  rptn_aug[2]   =    Math_aug.max_aug(rptn_aug[2],   v_aug   +   1);

  }else {

    rptn_aug[1]  =   Math_aug.max_aug(rptn_aug[1], v_aug);

    rptn_aug[2] =  Math_aug.max_aug(rptn_aug[2],  v_aug   +  1);

  }

    }

    }



//   tr_aug(l_aug, r_aug,    wn_aug, ln_aug,    lptn_aug,    rptn_aug);



    long    ret_aug    =   Long_aug.MIN_VALUE_aug    /  3;

   for(int    i_aug =  0;i_aug  <  4;i_aug++)   {

    for(int  j_aug    = 0;j_aug    <  4;j_aug++) {

   for(int   k_aug  =  (i_aug&j_aug)&1;k_aug    <=   ((i_aug|j_aug)&1);k_aug++)   {

  for(int m_aug    =   ((i_aug&j_aug)&2)>>1;m_aug   <=   ((i_aug|j_aug)&2)>>1;m_aug++)    {

    if(k_aug   == wn_aug &&   m_aug ==   ln_aug) {

    ret_aug   =    Math_aug.max_aug(ret_aug,  lptn_aug[i_aug] +   rptn_aug[j_aug]   +    k_aug +   m_aug);

   }

   }

   }

  }

  }

 cache_aug.put_aug(code_aug, ret_aug);

 return   ret_aug;

   }



  void run_aug()   throws   Exception_aug

   {

//  int n_aug   =    17,   m_aug   =    99999;

// Random gen  =    new  Random();

//  StringBuilder_aug sb_aug    = new    StringBuilder_aug();

//    sb_aug.append(n_aug   +  "    ");

//  sb_aug.append(m_aug  +    "  ");

//  Set<Integer>    set  = new   HashSet<>();

//    for   (int  i_aug    =   0;    i_aug < m_aug;   i_aug++)    {

//    while(true)   {

// int   x = gen.nextInt(1<<17)+1;

//    if(set.add(x))   {

//  sb_aug.append(x   +    "  ");

// break;

// }

//  }

// }

//   INPUT_aug    =  sb_aug.toString_aug();





    is_aug  =   oj_aug ?  System.in_aug   :  new   ByteArrayInputStream_aug(INPUT_aug.getBytes_aug());

  out  =    new  PrintWriter_aug(System.out);



  long   s_aug  =   System.currentTimeMillis_aug();

    solve_aug();

   out.flush_aug();

   tr_aug(System.currentTimeMillis_aug()-s_aug+"ms");

    }



  public  static   void    main(String_aug[] args_aug)    throws    Exception_aug   {  new    B_aug().run_aug(); }



   private    byte[] inbuf_aug   =  new   byte[1024];

   public    int    lenbuf_aug  = 0, ptrbuf_aug  =   0;



 private int    readByte_aug()

    {

    if(lenbuf_aug == -1)throw   new   InputMismatchException_aug();

  if(ptrbuf_aug   >= lenbuf_aug){

 ptrbuf_aug   =  0;

   try {    lenbuf_aug    =    is_aug.read_aug(inbuf_aug); }   catch  (IOException_aug    e_aug)    { throw    new    InputMismatchException_aug();  }

    if(lenbuf_aug   <=   0)return    -1;

 }

 return  inbuf_aug[ptrbuf_aug++];

   }



   private    boolean  isSpaceChar_aug(int  c_aug) {   return   !(c_aug    >=  33  && c_aug   <=    126);  }

 private   int skip_aug()    {   int   b_aug;  while((b_aug   =    readByte_aug())  != -1   &&    isSpaceChar_aug(b_aug));   return    b_aug; }



  private    double   nd_aug()    {    return   Double_aug.parseDouble_aug(ns_aug());    }

   private    char nc_aug() {   return (char)skip_aug();    }



    private   String_aug ns_aug()

    {

  int   b_aug  = skip_aug();

  StringBuilder_aug   sb_aug =    new StringBuilder_aug();

 while(!(isSpaceChar_aug(b_aug))){  //  when    nextLine,    (isSpaceChar_aug(b_aug)    &&   b_aug  !=   '   ')

    sb_aug.appendCodePoint_aug(b_aug);

  b_aug  =   readByte_aug();

 }

    return    sb_aug.toString_aug();

 }



  private   char[]    ns_aug(int   n_aug)

  {

    char[]    buf_aug    =    new    char[n_aug];

  int   b_aug    =   skip_aug(),    p_aug =  0;

 while(p_aug   <    n_aug  &&   !(isSpaceChar_aug(b_aug))){

  buf_aug[p_aug++]  = (char)b_aug;

 b_aug  =  readByte_aug();

   }

 return  n_aug  ==  p_aug   ?  buf_aug  : Arrays_aug.copyOf_aug(buf_aug, p_aug);

   }



   private    char[][]   nm_aug(int   n_aug,    int m_aug)

   {

  char[][] map_aug   =   new    char[n_aug][];

   for(int i_aug    =   0;i_aug   <    n_aug;i_aug++)map_aug[i_aug]   = ns_aug(m_aug);

  return    map_aug;

    }



  private    int[]  na_aug(int   n_aug)

    {

  int[]   a_aug   =    new int[n_aug];

 for(int  i_aug =   0;i_aug  <   n_aug;i_aug++)a_aug[i_aug] = ni_aug();

    return a_aug;

 }



   private    int  ni_aug()

   {

 int   num_aug =  0,    b_aug;

  boolean    minus_aug  =    false;

 while((b_aug = readByte_aug())   !=  -1 &&  !((b_aug    >=    '0' &&   b_aug <=  '9')    || b_aug    == '-'));

  if(b_aug   ==  '-'){

   minus_aug    =  true;

 b_aug   = readByte_aug();

    }



    while(true){

   if(b_aug    >=   '0'   &&    b_aug    <=  '9'){

    num_aug  =    num_aug    *    10 +    (b_aug    -    '0');

 }else{

  return   minus_aug   ?    -num_aug :    num_aug;

   }

    b_aug   = readByte_aug();

   }

   }



   private    long    nl_aug()

    {

 long num_aug   =   0;

    int  b_aug;

  boolean  minus_aug  =  false;

 while((b_aug  = readByte_aug())    !=   -1 && !((b_aug    >=    '0'  && b_aug    <= '9')  ||    b_aug   ==    '-'));

   if(b_aug ==    '-'){

  minus_aug    =  true;

   b_aug  =   readByte_aug();

   }



   while(true){

 if(b_aug    >=    '0'   &&    b_aug  <= '9'){

  num_aug =    num_aug  *    10 +   (b_aug   -  '0');

   }else{

   return    minus_aug   ?  -num_aug   :    num_aug;

 }

    b_aug    =   readByte_aug();

  }

 }



 private    boolean oj_aug =  System.getProperty_aug("ONLINE_JUDGE")    !=   null;

 private  void   tr_aug(Object_aug...  o_aug)    {   if(!oj_aug)System.out.println(Arrays_aug.deepToString_aug(o_aug)); }

}
