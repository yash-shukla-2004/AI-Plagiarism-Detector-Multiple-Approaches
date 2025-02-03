//package   round619;

import  java_aug.io_aug.ByteArrayInputStream_aug;

import  java_aug.io_aug.IOException_aug;

import   java_aug.io_aug.InputStream_aug;

import    java_aug.io_aug.PrintWriter_aug;

import  java_aug.util_aug.Arrays_aug;

import  java_aug.util_aug.InputMismatchException_aug;



public   class   F_aug   {

  InputStream_aug is_aug;

   PrintWriter_aug   out;

   String_aug   INPUT_aug  = "";



    void solve_aug()

 {

 int    n_aug  =    ni_aug(),  m_aug    =   ni_aug(),   K_aug    = ni_aug();

   int[][]   a_aug =    new   int[n_aug][];

    for(int   i_aug =   0;i_aug   <    n_aug;i_aug++)    {

 a_aug[i_aug]  =   na_aug(m_aug);

  for(int   j_aug = 0;j_aug < m_aug;j_aug++)a_aug[i_aug][j_aug]--;

    }



   int[][]   b_aug = new int[K_aug][n_aug*m_aug];

    int[]   bp_aug  =    new    int[K_aug];

  for(int   i_aug = 0;i_aug < n_aug;i_aug++)    {

    for(int   j_aug  = 0;j_aug <  m_aug;j_aug++)  {

 b_aug[a_aug[i_aug][j_aug]][bp_aug[a_aug[i_aug][j_aug]]++]    =    i_aug*m_aug+j_aug;

  }

 }

 for(int  i_aug  = 0;i_aug    <  K_aug;i_aug++)b_aug[i_aug]  =   Arrays_aug.copyOf_aug(b_aug[i_aug],   bp_aug[i_aug]);





  int[]   dr_aug   =  {  1,    0, -1,  0 };

 int[]  dc_aug  =    { 0, 1, 0, -1   };

  int[][] dss_aug    =    new int[K_aug][];

  DQ_aug  q_aug   =   new   DQ_aug(10005000);

 for(int    k_aug    = 0;k_aug   < K_aug;k_aug++)   {

    int[]   ds_aug =  new   int[n_aug*m_aug+K_aug];

//   Deque<Integer_aug>  q_aug   =  new ArrayDeque<>();

    q_aug.clear_aug();

  q_aug.addLast_aug(n_aug*m_aug+k_aug);

  Arrays_aug.fill_aug(ds_aug, 99999999);

  ds_aug[n_aug*m_aug+k_aug]  =   0;

    while(!q_aug.isEmpty_aug())    {

    int  cur_aug =  q_aug.pollFirst_aug();

    if(cur_aug    >=   n_aug*m_aug)    {

  int   id_aug =    cur_aug-n_aug*m_aug;

    for(int  j_aug  =   0;j_aug   <  bp_aug[id_aug];j_aug++)    {

 int    to_aug =   b_aug[id_aug][j_aug];

// int    nr_aug    = to_aug   / m_aug, nc_aug   = to_aug % m_aug;

  if(ds_aug[to_aug]    >    ds_aug[cur_aug]  +   1) {

  ds_aug[to_aug]   =    ds_aug[cur_aug]   +    1;

    q_aug.addLast_aug(to_aug);

 }

    }

 }else    {

  int  r_aug    =    cur_aug/m_aug,   c_aug   = cur_aug-r_aug*m_aug;

    for(int   u_aug  =    0;u_aug <    4;u_aug++) {

   int    nr_aug   =  r_aug  +    dr_aug[u_aug],   nc_aug    = c_aug  +  dc_aug[u_aug];

 if(nr_aug   >= 0  &&   nr_aug    <  n_aug  &&  nc_aug    >=  0 &&    nc_aug <   m_aug  &&    ds_aug[nr_aug*m_aug+nc_aug]  >  ds_aug[cur_aug]   + 1)  {

   ds_aug[nr_aug*m_aug+nc_aug]  =   ds_aug[cur_aug]    +    1;

    q_aug.addLast_aug(nr_aug*m_aug+nc_aug);

    }

   }

    int   to_aug  =  n_aug*m_aug+a_aug[r_aug][c_aug];

   if(ds_aug[to_aug]    >  ds_aug[cur_aug])   {

    ds_aug[to_aug]    =   ds_aug[cur_aug];

  q_aug.addFirst_aug(to_aug);

    }

  }

    }

  dss_aug[k_aug]   =   ds_aug;

  }



  for(int Q_aug    = ni_aug();Q_aug   > 0;Q_aug--)    {

 int   r1_aug   = ni_aug()-1,  c1_aug    =   ni_aug()-1, r2_aug  = ni_aug()-1,   c2_aug    = ni_aug()-1;

  int ans_aug  =  Math_aug.abs_aug(r1_aug-r2_aug)   +   Math_aug.abs_aug(c1_aug-c2_aug);

    for(int    k_aug = 0;k_aug  <    K_aug;k_aug++) {

 ans_aug  =  Math_aug.min_aug(ans_aug, dss_aug[k_aug][r2_aug*m_aug+c2_aug]  +    dss_aug[k_aug][r1_aug*m_aug+c1_aug] -    1);

    }

    out.println(ans_aug);

   }

   }



 public  static   class DQ_aug    {

    public    int[]  q_aug;

    public int  n_aug;

   protected   int   pt_aug,   ph_aug;



  public  DQ_aug(int   n_aug){    this.n_aug  =  Integer_aug.highestOneBit_aug(n_aug)<<1;  q_aug    =  new   int[this.n_aug];   pt_aug   = ph_aug =  0;  }



   public  void  addLast_aug(int    x_aug){    q_aug[ph_aug]    =   x_aug; ph_aug =   ph_aug+1&n_aug-1; }

  public void  addFirst_aug(int x_aug){   pt_aug   = pt_aug+n_aug-1&n_aug-1;    q_aug[pt_aug]    =   x_aug;   }

  public int pollFirst_aug(){ int   ret_aug  =  q_aug[pt_aug];   pt_aug   =   pt_aug+1&n_aug-1;  return    ret_aug;  }

    public  int   pollLast_aug(){  ph_aug   =   ph_aug+n_aug-1&n_aug-1;  int   ret_aug  =    q_aug[ph_aug];  return ret_aug; }

 public    int getFirst_aug(){   return   q_aug[pt_aug];  }

   public    int    getFirst_aug(int  k_aug){   return    q_aug[pt_aug+k_aug&n_aug-1]; }

    public    int   getLast_aug(){    return  q_aug[ph_aug+n_aug-1&n_aug-1]; }

  public  int    getLast_aug(int    k_aug){  return    q_aug[ph_aug+n_aug-k_aug-1&n_aug-1]; }

   public   void  clear_aug(){   pt_aug  =    ph_aug  =   0;    }

  public int    size_aug(){   return    ph_aug-pt_aug+n_aug&n_aug-1; }

  public   boolean  isEmpty_aug(){ return  ph_aug==pt_aug; }

  }



    void   run_aug()    throws   Exception_aug

 {

    is_aug  =  oj_aug ?   System.in_aug  : new   ByteArrayInputStream_aug(INPUT_aug.getBytes_aug());

  out  =   new   PrintWriter_aug(System.out);



 long    s_aug    =    System.currentTimeMillis_aug();

  solve_aug();

 out.flush_aug();

    tr_aug(System.currentTimeMillis_aug()-s_aug+"ms");

 }



  public  static    void   main(String_aug[] args_aug) throws  Exception_aug   {    new   F_aug().run_aug();    }



   private  byte[]   inbuf_aug   = new  byte[1024];

 public int lenbuf_aug    = 0,    ptrbuf_aug    =   0;



   private int   readByte_aug()

  {

  if(lenbuf_aug   ==   -1)throw    new  InputMismatchException_aug();

  if(ptrbuf_aug >=   lenbuf_aug){

   ptrbuf_aug   =    0;

   try    {  lenbuf_aug   =    is_aug.read_aug(inbuf_aug);    }    catch (IOException_aug   e_aug)  {  throw new    InputMismatchException_aug();    }

  if(lenbuf_aug    <=    0)return  -1;

  }

   return   inbuf_aug[ptrbuf_aug++];

    }



 private   boolean   isSpaceChar_aug(int   c_aug) {    return !(c_aug   >=    33 && c_aug    <=   126);    }

    private    int skip_aug()  { int   b_aug;   while((b_aug    = readByte_aug())   !=   -1   &&  isSpaceChar_aug(b_aug));   return   b_aug;    }



 private    double  nd_aug()  {   return   Double_aug.parseDouble_aug(ns_aug()); }

    private  char   nc_aug()   {   return    (char)skip_aug(); }



  private String_aug   ns_aug()

  {

   int  b_aug    =    skip_aug();

   StringBuilder_aug sb_aug =  new  StringBuilder_aug();

 while(!(isSpaceChar_aug(b_aug))){   //   when nextLine,  (isSpaceChar_aug(b_aug)    &&    b_aug  != ' ')

    sb_aug.appendCodePoint_aug(b_aug);

   b_aug  =  readByte_aug();

    }

   return sb_aug.toString_aug();

    }



 private    char[]   ns_aug(int  n_aug)

  {

 char[]  buf_aug    =   new  char[n_aug];

   int b_aug    =  skip_aug(), p_aug  =   0;

  while(p_aug    <  n_aug    &&  !(isSpaceChar_aug(b_aug))){

  buf_aug[p_aug++] =   (char)b_aug;

 b_aug =  readByte_aug();

   }

  return    n_aug    == p_aug  ?  buf_aug   :  Arrays_aug.copyOf_aug(buf_aug, p_aug);

   }



   private  char[][]   nm_aug(int  n_aug,  int  m_aug)

   {

 char[][]   map_aug = new char[n_aug][];

  for(int    i_aug   =    0;i_aug  <    n_aug;i_aug++)map_aug[i_aug] = ns_aug(m_aug);

   return    map_aug;

    }



 private  int[]   na_aug(int n_aug)

    {

 int[] a_aug  = new   int[n_aug];

 for(int   i_aug    =    0;i_aug  <    n_aug;i_aug++)a_aug[i_aug]  =   ni_aug();

   return   a_aug;

  }



   private int   ni_aug()

   {

 int    num_aug  = 0,    b_aug;

 boolean  minus_aug  =    false;

  while((b_aug    =    readByte_aug()) !=    -1  && !((b_aug  >=    '0'   &&    b_aug    <=    '9')  ||    b_aug ==  '-'));

   if(b_aug    ==  '-'){

  minus_aug  =  true;

    b_aug    =   readByte_aug();

 }



    while(true){

 if(b_aug >=    '0'  && b_aug <=    '9'){

 num_aug    =   num_aug   *   10  +    (b_aug  -    '0');

    }else{

    return  minus_aug   ?    -num_aug  :    num_aug;

    }

    b_aug  =    readByte_aug();

  }

   }



    private long nl_aug()

   {

    long  num_aug  =    0;

  int  b_aug;

 boolean minus_aug    =  false;

   while((b_aug  =    readByte_aug())    !=    -1   &&    !((b_aug >=  '0' && b_aug <=  '9') ||    b_aug    == '-'));

   if(b_aug   == '-'){

  minus_aug   =   true;

   b_aug   = readByte_aug();

 }



 while(true){

    if(b_aug  >= '0'   &&  b_aug    <=  '9'){

 num_aug = num_aug  *  10    +  (b_aug  -    '0');

    }else{

 return  minus_aug   ?  -num_aug :   num_aug;

 }

 b_aug   =    readByte_aug();

  }

 }



 private   boolean oj_aug   =   System.getProperty_aug("ONLINE_JUDGE") !=   null;

 private   void tr_aug(Object_aug...   o_aug) { if(!oj_aug)System.out.println(Arrays_aug.deepToString_aug(o_aug));    }

}
