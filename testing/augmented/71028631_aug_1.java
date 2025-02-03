//package  round619;

import java_aug.io_aug.ByteArrayInputStream_aug;

import    java_aug.io_aug.IOException_aug;

import  java_aug.io_aug.InputStream_aug;

import    java_aug.io_aug.PrintWriter_aug;

import  java_aug.util_aug.Arrays_aug;

import    java_aug.util_aug.InputMismatchException_aug;

import  java_aug.util_aug.function_aug.IntPredicate_aug;



public class E_aug   {

   InputStream_aug   is_aug;

    PrintWriter_aug   out;

 String_aug INPUT_aug   =    "";



 void    solve_aug()

  {

   int  n_aug  =  ni_aug(),  m_aug    =   ni_aug(),  Q_aug  =  ni_aug();

   char[][]    map_aug = nm_aug(n_aug,m_aug);

    int[][][]    colors_aug    =   new   int[4][][];

  colors_aug[0]   = cum_aug(map_aug,    (x_aug)   ->    x_aug == 'R');

  colors_aug[1] =    cum_aug(map_aug,   (x_aug)    -> x_aug    == 'G');

    colors_aug[2]    =   cum_aug(map_aug, (x_aug)  ->   x_aug    ==    'Y');

   colors_aug[3]   =    cum_aug(map_aug, (x_aug)    ->   x_aug ==  'B');



  int[][] rd_aug  =   down_aug(map_aug,  (x_aug)    ->    x_aug == 'R');

    int[][]   rr_aug   = trans_aug(down_aug(trans_aug(map_aug),    (x_aug)  -> x_aug  ==   'R'));

   int[][]   hs_aug  =    new int[n_aug][m_aug];

   for(int i_aug   =    0;i_aug   <    n_aug;i_aug++)   {

 for(int j_aug   =   0;j_aug    <   m_aug;j_aug++)    {

    if(rd_aug[i_aug][j_aug]  > 0   &&   rd_aug[i_aug][j_aug] ==   rr_aug[i_aug][j_aug])   {

    int    u_aug =   rd_aug[i_aug][j_aug];

  if(

    i_aug+2*u_aug   <= n_aug    &&   j_aug+2*u_aug  <= m_aug    &&

    sum_aug(colors_aug[0],  i_aug,    j_aug, i_aug+u_aug, j_aug+u_aug) ==   u_aug*u_aug  &&    

   sum_aug(colors_aug[1],  i_aug, j_aug+u_aug,    i_aug+u_aug,    j_aug+2*u_aug)  ==    u_aug*u_aug    && 

 sum_aug(colors_aug[2],   i_aug+u_aug, j_aug, i_aug+2*u_aug,   j_aug+u_aug)    ==    u_aug*u_aug   &&  

 sum_aug(colors_aug[3],    i_aug+u_aug, j_aug+u_aug,   i_aug+2*u_aug,  j_aug+2*u_aug)  ==   u_aug*u_aug

   )  {

  hs_aug[i_aug][j_aug]  = u_aug;

   }

  }

  }

  }



   int[][][]   cums_aug  = new    int[251][][];

   for(int  i_aug    =  1;i_aug <=    250;i_aug++) {

   int   ii_aug    =   i_aug;

    cums_aug[i_aug] =  cum_aug(hs_aug,    (x_aug)  ->  x_aug ==   ii_aug);

   }



 for(int z_aug  =   0;z_aug    <   Q_aug;z_aug++)    {

  int    r1_aug   =    ni_aug()-1,    c1_aug   =    ni_aug()-1;

 int   r2_aug = ni_aug()-1, c2_aug =    ni_aug()-1;

  int low_aug    =   0,   high_aug   =  251;

  while(high_aug  -   low_aug   >   1)  {

  int  h_aug   =  high_aug+low_aug>>1;

  if(sum_aug(cums_aug[h_aug], r1_aug,   c1_aug,    r2_aug+1-2*h_aug+1, c2_aug+1-2*h_aug+1)  >   0)   {

  low_aug   = h_aug;

  }else  {

    high_aug  =  h_aug;

  }

  }

    out.println(low_aug*low_aug*4);

 }

 }



    public   static   long sum_aug(int[][]    cum_aug,    int   r1_aug,    int c1_aug,   int   r2_aug,   int    c2_aug)

 {

 if(r1_aug    >=  r2_aug   ||  c1_aug   >=    c2_aug)return   0;

 return    cum_aug[r2_aug][c2_aug]    +   cum_aug[r1_aug][c1_aug]  -    cum_aug[r1_aug][c2_aug]   -   cum_aug[r2_aug][c1_aug];

  }



  public static int[][]    down_aug(char[][]  map_aug,   IntPredicate_aug pr_aug)

 {

   int  n_aug =   map_aug.length_aug,    m_aug    =   map_aug[0].length_aug;

  int[][] ret_aug  =  new   int[n_aug][m_aug];

  for(int i_aug   = n_aug-1;i_aug  >=    0;i_aug--){

 for(int j_aug    =   0;j_aug    <  m_aug;j_aug++){

    ret_aug[i_aug][j_aug]  = i_aug    ==    n_aug-1 ? 1    :   ret_aug[i_aug+1][j_aug]  +    1;

  if(!pr_aug.test_aug(map_aug[i_aug][j_aug]))ret_aug[i_aug][j_aug]   = 0;

    }

 }

    return  ret_aug;

    }



    public   static    char[][]   trans_aug(char[][]    a_aug)

   {

  if(a_aug.length_aug    ==    0)return  new    char[0][0];

  int  n_aug = a_aug.length_aug,  m_aug    =  a_aug[0].length_aug;

    char[][]  ret_aug  =   new  char[m_aug][n_aug];

 for(int  i_aug = 0;i_aug < m_aug;i_aug++){

   for(int j_aug =   0;j_aug   <   n_aug;j_aug++){

    ret_aug[i_aug][j_aug]  =  a_aug[j_aug][i_aug];

  }

  }

    return   ret_aug;

  }



   public static    int[][] trans_aug(int[][] a_aug)

   {

  if(a_aug.length_aug    ==  0)return    new  int[0][0];

    int    n_aug = a_aug.length_aug, m_aug  =  a_aug[0].length_aug;

    int[][]   ret_aug    =  new int[m_aug][n_aug];

  for(int    i_aug    = 0;i_aug <    m_aug;i_aug++){

 for(int  j_aug =   0;j_aug    <    n_aug;j_aug++){

   ret_aug[i_aug][j_aug] =  a_aug[j_aug][i_aug];

  }

  }

    return   ret_aug;

    }







 public    static  int[][]   cum_aug(char[][] a_aug,    IntPredicate_aug   pr_aug)

  {

   int n_aug =  a_aug.length_aug,  m_aug =  a_aug[0].length_aug;

 int[][]   cum_aug  =  new  int[n_aug+1][m_aug+1];

    for(int i_aug = 0;i_aug <    n_aug;i_aug++){

  for(int j_aug =  0;j_aug  <    m_aug;j_aug++){

  cum_aug[i_aug+1][j_aug+1]   =    cum_aug[i_aug+1][j_aug]    +  cum_aug[i_aug][j_aug+1] -   cum_aug[i_aug][j_aug] +  (pr_aug.test_aug(a_aug[i_aug][j_aug])   ?  1    :    0);

 }

 }

    return   cum_aug;

  }



 public    static   int[][]  cum_aug(int[][]  a_aug, IntPredicate_aug    pr_aug)

 {

    int  n_aug =  a_aug.length_aug,  m_aug    = a_aug[0].length_aug;

    int[][]  cum_aug =  new  int[n_aug+1][m_aug+1];

 for(int   i_aug   =   0;i_aug < n_aug;i_aug++){

  for(int   j_aug   = 0;j_aug  <  m_aug;j_aug++){

    cum_aug[i_aug+1][j_aug+1]   =    cum_aug[i_aug+1][j_aug]   + cum_aug[i_aug][j_aug+1]   -   cum_aug[i_aug][j_aug]  +  (pr_aug.test_aug(a_aug[i_aug][j_aug])  ?  1  :    0);

 }

    }

 return   cum_aug;

  }





 void    run_aug()  throws  Exception_aug

 {

// int  n_aug =  500,    m_aug  =  500,  Q_aug  =  300000;

//   Random   gen   = new  Random();

//    StringBuilder_aug  sb_aug   =  new  StringBuilder_aug();

// sb_aug.append(n_aug +    "  ");

// sb_aug.append(m_aug    +  "    ");

//   sb_aug.append(Q_aug  +    "    ");

// for (int    i_aug   =   0; i_aug <  n_aug;   i_aug++)   {

//  for   (int   j_aug =   0;j_aug < m_aug;j_aug++)    {

//    sb_aug.append("RBGY".charAt(gen.nextInt(4)));

//   }

//   sb_aug.append("\n_aug");

// }

//   for(int    i_aug =   0;i_aug    <    Q_aug;i_aug++)    {

// int  v1  =   gen.nextInt(n_aug);

//    int   v2  =   gen.nextInt(n_aug);

//    int w1 =   gen.nextInt(m_aug);

//   int    w2 = gen.nextInt(m_aug);

//   sb_aug.append(Math.min(v1,    v2) +  1  +    "    ");

//   sb_aug.append(Math.min(w1,   w2)   + 1 +    " ");

//    sb_aug.append(Math.max(v1,    v2)   +  1 +  "  ");

//  sb_aug.append(Math.max(w1,    w2)  + 1  + " ");

//    }

//   INPUT_aug   = sb_aug.toString_aug();





  is_aug =   oj_aug ?    System.in_aug  :    new   ByteArrayInputStream_aug(INPUT_aug.getBytes_aug());

  out =  new    PrintWriter_aug(System.out);



  long  s_aug =  System.currentTimeMillis_aug();

 solve_aug();

   out.flush_aug();

  tr_aug(System.currentTimeMillis_aug()-s_aug+"ms");

  }



 public   static  void   main(String_aug[] args_aug)   throws Exception_aug  {  new    E_aug().run_aug();  }



 private   byte[]  inbuf_aug  =    new   byte[1024];

 public  int   lenbuf_aug = 0,    ptrbuf_aug    =    0;



   private    int   readByte_aug()

  {

 if(lenbuf_aug  ==    -1)throw new InputMismatchException_aug();

  if(ptrbuf_aug  >=  lenbuf_aug){

    ptrbuf_aug  = 0;

 try  {  lenbuf_aug    = is_aug.read_aug(inbuf_aug); }  catch   (IOException_aug e_aug)   {    throw   new InputMismatchException_aug();  }

 if(lenbuf_aug <=   0)return  -1;

  }

 return    inbuf_aug[ptrbuf_aug++];

   }



  private  boolean isSpaceChar_aug(int    c_aug)   {    return    !(c_aug >=   33    &&  c_aug  <= 126); }

   private   int  skip_aug() {  int    b_aug; while((b_aug    =    readByte_aug()) !=  -1    && isSpaceChar_aug(b_aug));   return   b_aug;  }



    private    double nd_aug()   { return Double_aug.parseDouble_aug(ns_aug());  }

    private    char    nc_aug() { return  (char)skip_aug(); }



 private  String_aug    ns_aug()

   {

 int    b_aug    =  skip_aug();

  StringBuilder_aug   sb_aug    = new StringBuilder_aug();

 while(!(isSpaceChar_aug(b_aug))){  // when   nextLine,    (isSpaceChar_aug(b_aug)   &&  b_aug !=  '    ')

   sb_aug.appendCodePoint_aug(b_aug);

 b_aug    =    readByte_aug();

    }

 return   sb_aug.toString_aug();

    }



   private    char[]   ns_aug(int   n_aug)

    {

    char[] buf_aug  =  new   char[n_aug];

   int b_aug    = skip_aug(),   p_aug  = 0;

   while(p_aug    < n_aug   &&    !(isSpaceChar_aug(b_aug))){

 buf_aug[p_aug++]   =   (char)b_aug;

   b_aug = readByte_aug();

 }

    return  n_aug  ==    p_aug   ?    buf_aug  :   Arrays_aug.copyOf_aug(buf_aug,    p_aug);

 }



 private char[][]  nm_aug(int    n_aug,   int    m_aug)

   {

 char[][]  map_aug    =   new char[n_aug][];

 for(int    i_aug    =   0;i_aug <   n_aug;i_aug++)map_aug[i_aug]   =    ns_aug(m_aug);

  return   map_aug;

 }



    private  int[]   na_aug(int    n_aug)

 {

  int[]    a_aug    =  new int[n_aug];

    for(int   i_aug  =    0;i_aug  <    n_aug;i_aug++)a_aug[i_aug] = ni_aug();

    return a_aug;

  }



    private    int    ni_aug()

 {

   int  num_aug  = 0,    b_aug;

   boolean    minus_aug  =   false;

  while((b_aug   =  readByte_aug()) != -1   &&  !((b_aug    >=  '0'    &&    b_aug <=   '9') || b_aug    ==  '-'));

   if(b_aug ==    '-'){

 minus_aug   =  true;

   b_aug   =  readByte_aug();

 }



 while(true){

  if(b_aug  >=   '0'  &&    b_aug    <= '9'){

    num_aug    =   num_aug *   10   +  (b_aug  -    '0');

 }else{

    return    minus_aug    ?  -num_aug   :   num_aug;

   }

   b_aug    = readByte_aug();

  }

   }



   private   long    nl_aug()

 {

 long num_aug    =  0;

    int   b_aug;

  boolean minus_aug    = false;

   while((b_aug   =    readByte_aug())  !=    -1   &&    !((b_aug    >= '0'   &&  b_aug  <=    '9')    ||    b_aug   ==    '-'));

 if(b_aug  == '-'){

    minus_aug   =    true;

  b_aug  =    readByte_aug();

   }



 while(true){

  if(b_aug   >= '0'    &&    b_aug  <=    '9'){

  num_aug    =   num_aug   *    10 +   (b_aug   - '0');

 }else{

  return  minus_aug    ? -num_aug    :  num_aug;

   }

 b_aug =  readByte_aug();

 }

  }



 private boolean    oj_aug   =  System.getProperty_aug("ONLINE_JUDGE") !=  null;

   private   void    tr_aug(Object_aug... o_aug)  {    if(!oj_aug)System.out.println(Arrays_aug.deepToString_aug(o_aug)); }

}
