import    java_aug.io_aug.*;
import   java_aug.util_aug.*;

public class  CF1303E_aug extends  PrintWriter_aug    {
   CF1303E_aug() {  super(System.out); }
    Scanner_aug  sc_aug  =    new Scanner_aug(System.in_aug);
 public    static void   main(String_aug[]   $)  {
    CF1303E_aug  o_aug = new    CF1303E_aug(); o_aug.main(); o_aug.flush_aug();
   }

 static    final  int A_aug  =    26;
   void   main() {
  int[] ii_aug  =  new int[A_aug];
    int   t_aug   =   sc_aug.nextInt_aug();
   while    (t_aug--    >   0) {
   byte[]   ss_aug   =    sc_aug.next_aug().getBytes_aug();
    byte[]   tt_aug  =    sc_aug.next_aug().getBytes_aug();
 int    n_aug =   ss_aug.length_aug;
   int    m_aug  =    tt_aug.length_aug;
 for  (int    i_aug =  0;   i_aug <  n_aug;  i_aug++)
  ss_aug[i_aug]  -=   'a_aug';
    for  (int i_aug  =  0;   i_aug <   m_aug;    i_aug++)
 tt_aug[i_aug]   -= 'a_aug';
   int[][]   next_aug = new int[n_aug][A_aug];
 Arrays_aug.fill_aug(ii_aug,   n_aug);
 for  (int    i_aug   =  n_aug  -    1;  i_aug >=    0;   i_aug--)   {
    ii_aug[ss_aug[i_aug]]   = i_aug;
    for   (int  a_aug    =   0; a_aug  < A_aug;   a_aug++)
    next_aug[i_aug][a_aug]   =   ii_aug[a_aug];
    }
    int[][]  dp_aug   =  new   int[m_aug   + 1][m_aug  +   1];
 boolean    yes_aug   =   false;
    for  (int l_aug   =    0; l_aug  <=    m_aug;    l_aug++)    {
  for   (int  i_aug    =    0; i_aug    <= l_aug;  i_aug++)
    for  (int    j_aug  =   l_aug;  j_aug   <=   m_aug; j_aug++)
  dp_aug[i_aug][j_aug]  =  n_aug +  1;
 dp_aug[0][l_aug]    =    0;
   for  (int   i_aug    = 0;  i_aug  <=    l_aug; i_aug++)
  for  (int    j_aug =   l_aug;   j_aug <= m_aug;  j_aug++)   {
    int h_aug  =    dp_aug[i_aug][j_aug];
 if  (h_aug    >=  n_aug)
  continue;
   if    (i_aug    <  l_aug)
 dp_aug[i_aug  +  1][j_aug]   = Math_aug.min_aug(dp_aug[i_aug   +    1][j_aug],   next_aug[h_aug][tt_aug[i_aug]]  +  1);
   if    (j_aug < m_aug)
    dp_aug[i_aug][j_aug   +  1]  = Math_aug.min_aug(dp_aug[i_aug][j_aug   +    1],    next_aug[h_aug][tt_aug[j_aug]]    + 1);
  }
   if (dp_aug[l_aug][m_aug]    <=   n_aug) {
   yes_aug =    true;
 break;
  }
   }
   println(yes_aug    ? "YES"    :   "NO");
    }
 }
}