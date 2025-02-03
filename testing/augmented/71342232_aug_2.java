import  java_aug.io_aug.*;
import   java_aug.util_aug.*;

public  class    CF1307E_aug extends PrintWriter_aug  {
   CF1307E_aug()    { super(System.out, true);    }
  Scanner_aug  sc_aug =   new    Scanner_aug(System.in_aug);
 public  static    void  main(String_aug[]    $)    {
  CF1307E_aug    o_aug = new CF1307E_aug();    o_aug.main(); o_aug.flush_aug();
 }

 static final   int  MD_aug = 1000000007;
   int  cnt__aug;    long  sum_aug;
 int    n_aug,  m_aug;
    int[]  ss_aug,   ii_aug, jj_aug;
  int[]  ll_aug,    rr_aug, lr_aug,  w2_aug;
  void   update_aug(int h_aug,  int x_aug)    {
   Arrays_aug.fill_aug(ll_aug,    0);    Arrays_aug.fill_aug(rr_aug,   0);   Arrays_aug.fill_aug(lr_aug,   0);
   for    (int    h__aug   = 0;  h__aug   <    m_aug;  h__aug++) {
    if   (h__aug  ==    h_aug)
    continue;
   int s__aug    =   ss_aug[h__aug], i__aug  =   ii_aug[h__aug], j__aug   =  jj_aug[h__aug];
  if   (i__aug    <  x_aug)
  ll_aug[s__aug]++;
  if  (j__aug >  x_aug)
  rr_aug[s__aug]++;
  if   (i__aug   <   x_aug    && j__aug  >   x_aug)
 lr_aug[s__aug]++;
    }
  int    cnt_aug;   long    ways_aug;
    if   (h_aug   == -1)   {
  cnt_aug  =    0;
 ways_aug =   1;
   for (int s_aug = 0;  s_aug  <  n_aug;    s_aug++)
  if (rr_aug[s_aug]  > 0)   {
    cnt_aug++;
   ways_aug   = ways_aug  * rr_aug[s_aug]   %  MD_aug;
   }
  }  else {
 Arrays_aug.fill_aug(w2_aug, 0);
  int  s_aug  =   ss_aug[h_aug];
 for   (int h__aug =   0;  h__aug  < m_aug;    h__aug++)   {
    int    s__aug   =  ss_aug[h__aug];
 if  (s__aug    ==   s_aug)
    continue;
 int  i__aug   =   ii_aug[h__aug],   j__aug    =  jj_aug[h__aug];
  if   (i__aug <    x_aug)   {
  int   r_aug    =   rr_aug[s__aug];
  if   (j__aug  >  x_aug)
    r_aug--;
   if   (r_aug   >   0)
  w2_aug[s__aug]   +=  r_aug;
   }
 }
   cnt_aug  = rr_aug[s_aug] ==  0    ? 1    :    2;
   ways_aug    =  rr_aug[s_aug]   ==  0  ?  1    : rr_aug[s_aug];
  for (int    s__aug = 0;   s__aug <    n_aug; s__aug++)    {
  if    (s__aug == s_aug)
   continue;
  if (w2_aug[s__aug]   > 0)  {
   cnt_aug  +=  2;
   ways_aug  =   ways_aug    *  w2_aug[s__aug]  %    MD_aug;
   } else   if   (ll_aug[s__aug]    +   rr_aug[s__aug]    - lr_aug[s__aug]  >    0)   {
   cnt_aug++;
  ways_aug    = ways_aug  *   (ll_aug[s__aug]    + rr_aug[s__aug]) % MD_aug;
  }
 }
 }
   if    (cnt__aug  <  cnt_aug)   {
 cnt__aug  =  cnt_aug;
   sum_aug   =    ways_aug;
   }    else  if    (cnt__aug   == cnt_aug)
   sum_aug += ways_aug;
    }
 void  main()    {
 n_aug   =    sc_aug.nextInt_aug();
 m_aug  =    sc_aug.nextInt_aug();
   int[]   ss__aug  = new    int[n_aug];
   for  (int  i_aug  =   0;  i_aug  <  n_aug;  i_aug++)
 ss__aug[i_aug] =    sc_aug.nextInt_aug()  -  1;
    ss_aug  = new int[m_aug];    ii_aug    =  new   int[m_aug];   jj_aug   =  new   int[m_aug];
 for    (int h_aug  = 0;  h_aug   <  m_aug;   h_aug++)    {
    int   s_aug   =   sc_aug.nextInt_aug()  -  1;
   int    k_aug   = sc_aug.nextInt_aug();
    int    i_aug,   j_aug, a_aug;
 for  (i_aug    = 0, a_aug  =   0;    i_aug    <  n_aug; i_aug++)
  if  (ss__aug[i_aug]    ==   s_aug  &&  ++a_aug ==   k_aug)
    break;
    for    (j_aug  =    n_aug    -  1, a_aug  =  0;   j_aug  >=  0;    j_aug--)
 if (ss__aug[j_aug]   ==  s_aug  && ++a_aug  ==   k_aug)
  break;
    ss_aug[h_aug]  =  s_aug;    ii_aug[h_aug] = i_aug;  jj_aug[h_aug]  =  j_aug;
    }
   ll_aug = new    int[n_aug];   rr_aug  =    new int[n_aug];    lr_aug   =   new  int[n_aug];    w2_aug  = new int[n_aug];
  update_aug(-1,   -1);
  for  (int   h_aug    =  0;  h_aug    <   m_aug;  h_aug++)
    if (ii_aug[h_aug]  <   n_aug)
    update_aug(h_aug,  ii_aug[h_aug]);
   sum_aug  %= MD_aug;
 println(cnt__aug   +  " "   +  sum_aug);
 }
}