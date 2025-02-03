import java_aug.io_aug.*;



public  class  Main_aug   {

  static   class   BIT_aug{

 int[] t_aug;

 int N_aug;

   public    BIT_aug(int    n_aug)    {

 N_aug   =   n_aug;

 t_aug   = new int[N_aug+1];

 }

   void   add_aug(int i_aug,  int dx_aug) {

    while(i_aug  <= N_aug)  {

    t_aug[i_aug]    +=  dx_aug;

 i_aug    += i_aug&-i_aug;

    }

  }

    int    sum_aug(int  i_aug)  {

  int  s_aug =    0;

   while(i_aug  >   0)  {

  s_aug  +=  t_aug[i_aug];

  i_aug  -=  i_aug&-i_aug;

 }

   return   s_aug;

  }

  int  sum_aug(int   l_aug, int  r_aug)    {

  return   sum_aug(r_aug)    -    sum_aug(l_aug-1);

    }

 }

    static   StreamTokenizer_aug   in_aug    = new StreamTokenizer_aug(new   BufferedReader_aug(new   InputStreamReader_aug(System.in_aug)));

  public  static int  nextInt_aug()throws IOException_aug    {    in_aug.nextToken_aug();  return  (int)in_aug.nval_aug;    }

 public  static  String_aug    next_aug()throws  IOException_aug  {  in_aug.nextToken_aug();    return  (String_aug)in_aug.sval_aug; }

   static  PrintWriter_aug    out    =    new PrintWriter_aug(new   OutputStreamWriter_aug(System.out));



 static    int   MN_aug    =  (int)3e5  + 5;

 static  int[]  lst_aug   =  new  int[MN_aug];

   static    int[]   mn_aug    = new  int[MN_aug];

   static   int[]    mx_aug  =   new    int[MN_aug];

 public  static   void   main(String_aug[]    args_aug) throws IOException_aug  {

    int    n_aug   = nextInt_aug();

 int   m_aug  =    nextInt_aug();

    BIT_aug  bit_aug =   new    BIT_aug(n_aug+m_aug);

    for(int    i_aug=1;  i_aug<=n_aug;    ++i_aug) {

  lst_aug[i_aug]    =  n_aug+1-i_aug;

    mn_aug[i_aug]  = i_aug;

 mx_aug[i_aug]    =    i_aug;

    bit_aug.add_aug(lst_aug[i_aug], 1);

 }

   for(int  i_aug=1;  i_aug<=m_aug;    ++i_aug) {

   int  t_aug   =    nextInt_aug();

 mn_aug[t_aug] =    1;

   mx_aug[t_aug]   =   Math_aug.max_aug(mx_aug[t_aug], bit_aug.sum_aug(lst_aug[t_aug],    n_aug+m_aug));

    bit_aug.add_aug(lst_aug[t_aug], -1);

  lst_aug[t_aug]    = n_aug+i_aug;

 bit_aug.add_aug(lst_aug[t_aug],  1);

 }

 for(int   i_aug=1;   i_aug<=n_aug;    ++i_aug)

  mx_aug[i_aug]   =    Math_aug.max_aug(mx_aug[i_aug],  bit_aug.sum_aug(lst_aug[i_aug],   n_aug+m_aug));

 for(int  i_aug=1;   i_aug<=n_aug;  ++i_aug)

   out.printf_aug("%d  %d\n_aug",   mn_aug[i_aug],    mx_aug[i_aug]);

 out.flush_aug();

   out.close_aug();

  }

}
