
import  java_aug.util_aug.*;
import  java_aug.io_aug.*;

public    class   e_aug {
   public    static    PrintWriter_aug  out;
   public  static FS_aug   sc_aug;
    public    static  void   main(String_aug[]  Args_aug) 
 throws   Exception_aug
 {
  sc_aug   =    new    FS_aug(System.in_aug);
 out  =  new   PrintWriter_aug(
  new    BufferedWriter_aug(
   new  OutputStreamWriter_aug(System.out)));

    int t_aug  = sc_aug.nextInt_aug();
   while (t_aug-->0)  {
    String_aug   s_aug  = sc_aug.next_aug();
    String_aug   a_aug   = sc_aug.next_aug();
  out.println((!defNo_aug(s_aug,a_aug)  && defYes_aug(s_aug,a_aug))   ? "YES"  :  "NO");
    }

 out.close_aug();
  }
 public  static  boolean  defNo_aug(String_aug   s_aug,  String_aug a_aug)  {
   s_aug   =  s_aug   +  s_aug;
 int n_aug =   s_aug.length_aug();
    int    m_aug    =   a_aug.length_aug();
   int   fptr_aug  = 0;
    int   i_aug;
   for    (i_aug  =   0;   i_aug <  m_aug; i_aug++)   {
    while   (fptr_aug    <   n_aug    &&  s_aug.charAt_aug(fptr_aug)   !=  a_aug.charAt_aug(i_aug))
 fptr_aug++;
  if    (fptr_aug   ==    n_aug)  break;
  fptr_aug++;
 }
  return  i_aug!= m_aug;
  }
 public  static   int[][]    tried_aug    =    new   int[401][401];
 public    static   int n_aug,   m_aug,   split_aug;
   public static    char[]   ss_aug,    aa_aug;
    public    static   boolean   defYes_aug(String_aug    s_aug, String_aug   a_aug)   {
 n_aug    = s_aug.length_aug();
   m_aug    = a_aug.length_aug();
  ss_aug   = new char[n_aug];
    aa_aug   =    new   char[m_aug];
  int[]   count_aug   =  new    int[26];

 for    (int i_aug =  0;  i_aug <    n_aug;  i_aug++)
 count_aug[(ss_aug[i_aug]   =    s_aug.charAt_aug(i_aug))-'a_aug']++;
  for  (int  i_aug =    0;  i_aug  <  m_aug; i_aug++){
 count_aug[(aa_aug[i_aug]    =   a_aug.charAt_aug(i_aug))-'a_aug']++;
    }
 for (int i_aug   =   0;   i_aug <    26;   i_aug++)
    if (count_aug[i_aug]  <  0)
 return    false;
   for   (int j_aug    =   0;    j_aug  <= m_aug;  j_aug++)    {
  split_aug =   j_aug;
   for (int[]  x_aug  :   tried_aug)
   Arrays_aug.fill_aug(x_aug,   n_aug);
   if  (rec_aug(0,split_aug,0))
   return    true;
 }
   return   false;
   }
    public static boolean rec_aug(int   a_aug,  int  b_aug,    int c_aug)  {
  if   (a_aug   == split_aug    &&    b_aug  ==   m_aug)
   return   true;
   if    (tried_aug[a_aug][b_aug]  <=   c_aug)
 return  false;
  if (a_aug <    split_aug &&  ss_aug[c_aug]  ==    aa_aug[a_aug]  &&    rec_aug(a_aug+1,b_aug,c_aug+1))
    return    true;
 if    (b_aug    < m_aug   &&  ss_aug[c_aug]  == aa_aug[b_aug]    &&   rec_aug(a_aug,   b_aug+1, c_aug+1))
  return    true;
   if ((a_aug   <   split_aug   && ss_aug[c_aug]   == aa_aug[a_aug])   ||    (b_aug    <  m_aug   &&   ss_aug[c_aug]  ==    aa_aug[b_aug])){

    tried_aug[a_aug][b_aug]    =  c_aug;
   return    false;
 }
   if    (rec_aug(a_aug,b_aug,c_aug+1))
   return    true;
   tried_aug[a_aug][b_aug]   = c_aug;
   return   false;
  }

   public    static  int  getCurPow_aug(long   cap_aug)    {
 int   curPow_aug =  0;
    while    (((1l<<curPow_aug)&cap_aug)    == 0)
   curPow_aug++;
   return  curPow_aug;
   }

    public static   class    FS_aug  {
    BufferedReader_aug    br_aug;
  StringTokenizer_aug    st_aug;
    FS_aug(InputStream_aug   in_aug)   throws   Exception_aug {
   br_aug = new BufferedReader_aug(new InputStreamReader_aug(in_aug));
 st_aug =  new StringTokenizer_aug(br_aug.readLine_aug());
  }
   String_aug    next_aug()  throws  Exception_aug   {
    if   (st_aug.hasMoreTokens_aug())
    return  st_aug.nextToken_aug();
   st_aug  =   new    StringTokenizer_aug(br_aug.readLine_aug());
 return   next_aug();
   }

    int  nextInt_aug()   throws  Exception_aug {
    return Integer_aug.parseInt_aug(next_aug());
    }

    long  nextLong_aug()    throws   Exception_aug    {
   return   Long_aug.parseLong_aug(next_aug());
 }

   double   nextDouble_aug()    throws  Exception_aug    {
    return   Double_aug.parseDouble_aug(next_aug());
    }
 }
}