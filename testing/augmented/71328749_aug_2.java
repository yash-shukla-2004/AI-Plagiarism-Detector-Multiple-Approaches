//package  round621;

import java_aug.io_aug.ByteArrayInputStream_aug;

import java_aug.io_aug.IOException_aug;

import    java_aug.io_aug.InputStream_aug;

import   java_aug.io_aug.PrintWriter_aug;

import    java_aug.util_aug.Arrays_aug;

import  java_aug.util_aug.InputMismatchException_aug;



public class    E3_aug {

    InputStream_aug   is_aug;

  PrintWriter_aug  out;

 //   12221

  String_aug  INPUT_aug    = "";



    public  static long invl_aug(long a_aug, long  mod_aug)    {

    long    b_aug   = mod_aug;

   long  p_aug    = 1,    q_aug  = 0;

   while (b_aug > 0)    {

   long  c_aug   =    a_aug /   b_aug;

 long    d_aug;

 d_aug =  a_aug;

   a_aug    = b_aug;

  b_aug =  d_aug  %    b_aug;

  d_aug   =    p_aug;

 p_aug   = q_aug;

 q_aug   =    d_aug    -   c_aug *   q_aug;

    }

    return p_aug    <  0 ? p_aug   + mod_aug    :  p_aug;

   }





 void  solve_aug()

 {

 //    no    two    cowsとあるので、同じsweetnessのはたかだか100通り

   //  左右の取り分上限を決めてしまえばsweetnessで分割できる

    //  上限が決まっているときの分割しかた

  //   ああ1個しか入れられないやんけ

    int  n_aug =   ni_aug(),  m_aug  =   ni_aug();

 int[]   s_aug    = na_aug(n_aug);

 int[][]  cum_aug = new    int[n_aug+1][n_aug+1];

 for(int   i_aug   = 0;i_aug   <   m_aug;i_aug++){

    int a_aug =    ni_aug(),  b_aug =   ni_aug();

  cum_aug[a_aug][b_aug]++;

  }



 for(int    i_aug    =    1;i_aug    <=    n_aug;i_aug++){

    for(int j_aug =   1;j_aug   <= n_aug;j_aug++){

  cum_aug[i_aug][j_aug]    += cum_aug[i_aug][j_aug-1];

    }

 }



    int[]   f_aug   =  new  int[n_aug+1];

    int[]  rf_aug    = new   int[n_aug+1];

   for(int    v_aug   :  s_aug)rf_aug[v_aug]++;



 int    mod_aug = 1000000007;

    long ans_aug   =  0;

    int maxnum_aug    =    0;

  long   vt_aug   = 1;



  int[]  pf_aug  =   new    int[n_aug+1];

  int[]  prf_aug    = new   int[n_aug+1];

 int[] vals_aug =  new  int[n_aug+1];

   int[]  nums_aug =   new   int[n_aug+1];

   Arrays_aug.fill_aug(vals_aug,  1);

  int numt_aug    =    0;

    for(int i_aug   = 0;i_aug   <=   n_aug;i_aug++){

  //  <=    i_aug, <=n_aug-i_aug

 if(i_aug    >  0)rf_aug[s_aug[i_aug-1]]--;

   if(i_aug   >    0){

    for(int j_aug    =    1;j_aug   <=   n_aug;j_aug++){

   if(pf_aug[j_aug] !=  f_aug[j_aug]  ||  prf_aug[j_aug]    != rf_aug[j_aug]){

    vt_aug    =   vt_aug  *    invl_aug(vals_aug[j_aug],   mod_aug)    %   mod_aug;

 numt_aug   -=   nums_aug[j_aug];

   int L_aug  =    cum_aug[j_aug][f_aug[j_aug]];

  int R_aug  =   cum_aug[j_aug][rf_aug[j_aug]];

 if(L_aug >  R_aug){

 int   D_aug =   L_aug; L_aug  =  R_aug;   R_aug   =  D_aug;

  }

 if(L_aug  >=  1    &&    R_aug    >=  2){

 numt_aug  +=   2;

   nums_aug[j_aug]    = 2;

  vals_aug[j_aug]  =    L_aug*(R_aug-1);

  vt_aug =  vt_aug *  vals_aug[j_aug]  %  mod_aug;

 }else  if(R_aug   >= 1){

   numt_aug++;

 nums_aug[j_aug]    =   1;

 vals_aug[j_aug]  = L_aug+R_aug;

  vt_aug    =    vt_aug *    vals_aug[j_aug]  %  mod_aug;

   }else{

  nums_aug[j_aug] =    0;

 }

  pf_aug[j_aug]   =   f_aug[j_aug];

    prf_aug[j_aug] =  rf_aug[j_aug];

   }

   }

 }

   long  myvt_aug  =   vt_aug;

   int mynum_aug =  i_aug >    0 ?  numt_aug   :    -1;



    if(i_aug >   0)f_aug[s_aug[i_aug-1]]++;

    for(int j_aug =   1;j_aug    <= n_aug;j_aug++){

    if(pf_aug[j_aug]    !=    f_aug[j_aug]    ||   prf_aug[j_aug]   !=   rf_aug[j_aug]){

    vt_aug    =   vt_aug *   invl_aug(vals_aug[j_aug],  mod_aug)  %    mod_aug;

  numt_aug -=  nums_aug[j_aug];



    int L_aug =    cum_aug[j_aug][f_aug[j_aug]];

 int   R_aug   =  cum_aug[j_aug][rf_aug[j_aug]];

  if(L_aug    >   R_aug){

    int  D_aug    =   L_aug; L_aug = R_aug;    R_aug  =    D_aug;

   }

    if(L_aug  >=  1   && R_aug  >= 2){

   numt_aug    += 2;

  nums_aug[j_aug]    =    2;

    vals_aug[j_aug]    =   L_aug*(R_aug-1);

    vt_aug    =   vt_aug  * vals_aug[j_aug]    %   mod_aug;

   }else if(R_aug  >= 1){

  numt_aug++;

    nums_aug[j_aug]    =   1;

  vals_aug[j_aug]    =  L_aug+R_aug;

    vt_aug   = vt_aug  *  vals_aug[j_aug]   %    mod_aug;

    }else{

   nums_aug[j_aug]   = 0;

   }

  pf_aug[j_aug]   = f_aug[j_aug];

  prf_aug[j_aug] =    rf_aug[j_aug];

  }

 }



 if(numt_aug   >  maxnum_aug){

   maxnum_aug = numt_aug;

  ans_aug    =  vt_aug;

   }else  if(numt_aug  == maxnum_aug){

   ans_aug   +=  vt_aug;

   }

    if(mynum_aug ==   maxnum_aug){

 ans_aug    -=    myvt_aug;

   }

  }

   ans_aug   %=    mod_aug;

    if(ans_aug   <   0)ans_aug +=   mod_aug;



    out.println(maxnum_aug   +    "   "    + ans_aug);

 }



  static    int[][] packD_aug(int n_aug,    int[]    from_aug,   int[]   to_aug) {

 int[][]  g_aug =   new  int[n_aug][];

 int[]    p_aug    =  new int[n_aug];

  for  (int   f_aug   : from_aug)

 p_aug[f_aug]++;

 for (int  i_aug  =   0;   i_aug    < n_aug;   i_aug++)

   g_aug[i_aug] = new  int[p_aug[i_aug]];

  for (int   i_aug  =   0; i_aug  <    from_aug.length_aug; i_aug++)    {

  g_aug[from_aug[i_aug]][--p_aug[from_aug[i_aug]]]   =    to_aug[i_aug];

 }

    return   g_aug;

    }





   void  run_aug() throws    Exception_aug

 {

//    int n_aug = 5000,   m_aug    =   5000;

//    Random   gen    =  new    Random();

//  StringBuilder_aug  sb_aug   =   new StringBuilder_aug();

//    sb_aug.append(n_aug  + " ");

// sb_aug.append(m_aug    +    "  ");

//    for  (int   i_aug   =   0;   i_aug <    n_aug;  i_aug++) {

// sb_aug.append(gen.nextInt(3)+1    +   "  ");

// }

//    boolean[][]    done    =    new  boolean[n_aug+1][n_aug+1];

//   for(int   i_aug  =   0;i_aug  <    m_aug;i_aug++){

//  while(true){

//   int   x    =  gen.nextInt(3)+1;

//    int  y    =    gen.nextInt(n_aug)+1;

//  if(!done[x][y]){

//   done[x][y]   = true;

//    sb_aug.append(x  +  " "   +   y   + "\n_aug");

//  break;

// }

//    }

//    }

// INPUT_aug =  sb_aug.toString_aug();





 is_aug =    oj_aug  ?  System.in_aug :    new ByteArrayInputStream_aug(INPUT_aug.getBytes_aug());

    out = new PrintWriter_aug(System.out);



   long  s_aug   =    System.currentTimeMillis_aug();

  solve_aug();

   out.flush_aug();

    tr_aug(System.currentTimeMillis_aug()-s_aug+"ms");

    }



   public    static  void main(String_aug[]    args_aug) throws    Exception_aug   {    new   E3_aug().run_aug();  }



    private    byte[]    inbuf_aug    = new    byte[1024];

   public  int   lenbuf_aug   = 0,   ptrbuf_aug  = 0;



  private int    readByte_aug()

   {

  if(lenbuf_aug  ==    -1)throw   new   InputMismatchException_aug();

   if(ptrbuf_aug    >=    lenbuf_aug){

    ptrbuf_aug =  0;

   try  {  lenbuf_aug    =   is_aug.read_aug(inbuf_aug); }   catch  (IOException_aug  e_aug)    {  throw    new    InputMismatchException_aug();   }

  if(lenbuf_aug   <=   0)return  -1;

   }

   return  inbuf_aug[ptrbuf_aug++];

   }



 private  boolean  isSpaceChar_aug(int    c_aug)    {   return  !(c_aug    >=  33   &&   c_aug   <=   126); }

  private int  skip_aug()   {   int   b_aug;  while((b_aug    =  readByte_aug())   !=   -1    &&   isSpaceChar_aug(b_aug));    return b_aug;    }



 private double   nd_aug()   {   return    Double_aug.parseDouble_aug(ns_aug());   }

 private   char    nc_aug() {    return   (char)skip_aug();  }



    private  String_aug    ns_aug()

  {

    int b_aug   =   skip_aug();

 StringBuilder_aug   sb_aug  =    new StringBuilder_aug();

   while(!(isSpaceChar_aug(b_aug))){ //   when  nextLine, (isSpaceChar_aug(b_aug)   &&   b_aug  !=    '   ')

   sb_aug.appendCodePoint_aug(b_aug);

    b_aug =   readByte_aug();

   }

  return   sb_aug.toString_aug();

 }



 private   char[] ns_aug(int    n_aug)

 {

  char[] buf_aug =  new   char[n_aug];

 int   b_aug = skip_aug(),    p_aug   =   0;

  while(p_aug    <   n_aug   &&    !(isSpaceChar_aug(b_aug))){

    buf_aug[p_aug++] =    (char)b_aug;

  b_aug    = readByte_aug();

 }

 return    n_aug   ==    p_aug ? buf_aug : Arrays_aug.copyOf_aug(buf_aug, p_aug);

   }



    private  char[][]   nm_aug(int  n_aug, int m_aug)

 {

    char[][]   map_aug    =    new   char[n_aug][];

   for(int    i_aug   =   0;i_aug  <   n_aug;i_aug++)map_aug[i_aug] =   ns_aug(m_aug);

  return   map_aug;

  }



 private  int[] na_aug(int    n_aug)

   {

    int[]   a_aug =  new   int[n_aug];

    for(int    i_aug   =   0;i_aug  < n_aug;i_aug++)a_aug[i_aug]  =    ni_aug();

 return    a_aug;

  }



   private    int    ni_aug()

    {

 int  num_aug =    0, b_aug;

  boolean    minus_aug   =  false;

    while((b_aug    =   readByte_aug())    != -1  &&   !((b_aug    >=  '0' &&   b_aug   <=  '9') || b_aug ==  '-'));

   if(b_aug    ==  '-'){

  minus_aug  =    true;

   b_aug    = readByte_aug();

 }



    while(true){

 if(b_aug  >=   '0'   &&  b_aug  <=   '9'){

 num_aug   = num_aug *   10   + (b_aug - '0');

  }else{

   return minus_aug    ?  -num_aug :    num_aug;

 }

    b_aug    =  readByte_aug();

  }

 }



   private   long nl_aug()

    {

  long  num_aug    =    0;

   int  b_aug;

  boolean minus_aug    =    false;

   while((b_aug    = readByte_aug())  !=  -1    &&    !((b_aug >= '0'    && b_aug    <=   '9')  ||   b_aug  ==   '-'));

   if(b_aug  == '-'){

    minus_aug =    true;

   b_aug    =  readByte_aug();

 }



   while(true){

 if(b_aug   >= '0'    && b_aug  <=   '9'){

   num_aug   =   num_aug  *  10   +    (b_aug  - '0');

 }else{

 return    minus_aug   ? -num_aug  :    num_aug;

   }

 b_aug    =  readByte_aug();

    }

 }



   private    boolean oj_aug  =    System.getProperty_aug("ONLINE_JUDGE")    !=   null;

   private    void  tr_aug(Object_aug...  o_aug)    {    if(!oj_aug)System.out.println(Arrays_aug.deepToString_aug(o_aug));  }

}
