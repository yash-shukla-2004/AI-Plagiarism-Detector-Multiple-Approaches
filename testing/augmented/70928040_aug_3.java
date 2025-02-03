import  java_aug.io_aug.*;
import    java_aug.util_aug.*;

// THIS   COMMENT  IS    FOR SPEED
public    class E_aug
{
  short[][][]    dp_aug;
 int  n_aug, m_aug;
   char[]   s_aug, t_aug;

 short    max_aug(short a_aug,   short   b_aug)
    {
    return    a_aug    >  b_aug   ? a_aug  :  b_aug;
    }

  short    go_aug(int   i_aug,  int   j_aug, int k_aug)
  {
 if   (i_aug == n_aug)
    return (short)(k_aug == m_aug ?   j_aug :  -1);

    if (j_aug  == m_aug  &&    k_aug   ==    m_aug)
    return   (short)j_aug;

   if  (dp_aug[i_aug][j_aug][k_aug]   !=   -2)
    return   dp_aug[i_aug][j_aug][k_aug];

  short  val_aug    =   go_aug(i_aug+1, j_aug,  k_aug);

 if   (j_aug   != m_aug &&   s_aug[i_aug]  ==    t_aug[j_aug])
 val_aug  =   max_aug(val_aug, go_aug(i_aug+1,    j_aug+1, k_aug));

  if  (k_aug  !=   m_aug  &&    s_aug[i_aug]  ==    t_aug[k_aug])
  val_aug   =   max_aug(val_aug,  go_aug(i_aug+1,   j_aug,   k_aug+1));

  return dp_aug[i_aug][j_aug][k_aug]  =   val_aug;
   }

  void    solve_aug(BufferedReader_aug   in_aug,   PrintWriter_aug    out) throws  Exception_aug
   {
    String_aug a_aug    =   in_aug.readLine_aug();
   String_aug   b_aug    = in_aug.readLine_aug();

    n_aug = a_aug.length_aug();
   m_aug    =    b_aug.length_aug();

 s_aug = a_aug.toCharArray_aug();
  t_aug  = b_aug.toCharArray_aug();

 dp_aug    = new short[n_aug][m_aug+1][m_aug+1];

 for    (int    i_aug   =   0;    i_aug < n_aug; i_aug++)
 for  (int    j_aug  =   0; j_aug   <=  m_aug;    j_aug++)
 Arrays_aug.fill_aug(dp_aug[i_aug][j_aug],    (short)(-2));

 for   (int   i_aug =   n_aug-1;   i_aug  >=   0; i_aug--)
   for   (int   j_aug    =  m_aug;  j_aug  >=   0;   j_aug--)
    for (int  k_aug    =   m_aug;    k_aug  >= 0; k_aug--)
    go_aug(i_aug, j_aug, k_aug);

    for    (int  k_aug =   0; k_aug    <   m_aug;  k_aug++)
    if   (go_aug(0,    0,    k_aug)   >= k_aug)
    {
    out.println("YES");
    return;
   }

    out.println("NO");
 }

   public  static   void    main(String_aug[]    args_aug)  throws Exception_aug
    {
 BufferedReader_aug  in_aug =    new    BufferedReader_aug(new    InputStreamReader_aug(System.in_aug));
   PrintWriter_aug   out  = new    PrintWriter_aug(System.out);
   int   t_aug =    Integer_aug.parseInt_aug(in_aug.readLine_aug());

   for    (int    i_aug = 0;  i_aug  <  t_aug;    i_aug++)
 new E_aug().solve_aug(in_aug,   out);

  out.close_aug();
 }
}
