//    upsolve    with  rainboy$_aug
import   java_aug.io_aug.*;
import  java_aug.util_aug.*;

public   class  CF1288F_aug  extends    PrintWriter_aug   {
 CF1288F_aug()    {  super(System.out);  }
 Scanner_aug    sc_aug   =  new  Scanner_aug(System.in_aug);
  public static    void    main(String_aug[]   $)  {
 CF1288F_aug  o_aug  =   new  CF1288F_aug();    o_aug.main();  o_aug.flush_aug();
    }

    static    final    int  INF_aug =   0x3f3f3f3f;
   int[]   oo_aug,   oh_aug; int    ___aug =  1;
    int    link_aug(int    o_aug,    int    h_aug)    {
    oo_aug[___aug] =  o_aug; oh_aug[___aug]  =  h_aug;
 return    ___aug++;
  }
 int[]    ii_aug,    jj_aug,   cc_aug,   cost_aug,    cost__aug;    int   m__aug;
  int[]    ae_aug,    pi_aug,   dd_aug, ff_aug;    int    n__aug;
  int[]   pq_aug,    iq_aug;    int cnt_aug;
 void    init_aug() {
  oo_aug   =  new  int[1    +    m__aug   *    2];   oh_aug  =   new   int[1  + m__aug   *   2];
   ii_aug    =    new  int[m__aug];   jj_aug  = new    int[m__aug];
  cc_aug    =  new  int[m__aug  * 2];
   cost_aug  =   new   int[m__aug];   cost__aug   =    new   int[m__aug];
    ae_aug =  new    int[n__aug]; pi_aug   =   new   int[n__aug];   dd_aug    = new int[n__aug]; ff_aug   =  new    int[n__aug];
 pq_aug  = new    int[1   +   n__aug];  iq_aug   =  new   int[n__aug];
 m__aug   = 0;
    }
    void link__aug(int    i_aug,   int   j_aug, int  c_aug,  int  co_aug)   {
 int    h_aug  = m__aug++;
    ii_aug[h_aug]   =    i_aug;   jj_aug[h_aug]   =  j_aug;   cc_aug[h_aug   << 1]    =   c_aug; cost_aug[h_aug]   =    co_aug;
  ae_aug[i_aug] =   link_aug(ae_aug[i_aug],  h_aug  <<    1);
 ae_aug[j_aug] =    link_aug(ae_aug[j_aug],  h_aug   <<  1  |  1);
  }
    boolean   less_aug(int  u_aug,   int   v_aug) {
    return   pi_aug[u_aug]  <  pi_aug[v_aug] ||    pi_aug[u_aug] ==  pi_aug[v_aug]    &&   dd_aug[u_aug]   <  dd_aug[v_aug];
    }
  int   i2_aug(int  i_aug) {
 return  (i_aug   *=    2) >   cnt_aug  ?  0  :  i_aug    <   cnt_aug   &&    less_aug(pq_aug[i_aug  +   1], pq_aug[i_aug])    ?   i_aug    +    1   :  i_aug;
 }
   void pq_up_aug(int    u_aug) {
    int i_aug,   j_aug, v_aug;
  for (i_aug  =  iq_aug[u_aug];   (j_aug = i_aug / 2)   > 0  &&   less_aug(u_aug,    v_aug   =   pq_aug[j_aug]); i_aug  =  j_aug)
  pq_aug[iq_aug[v_aug]   =    i_aug]    =    v_aug;
    pq_aug[iq_aug[u_aug]  =   i_aug]  =   u_aug;
 }
    void  pq_dn_aug(int   u_aug)   {
 int   i_aug,    j_aug,    v_aug;
   for   (i_aug  =  iq_aug[u_aug];   (j_aug  = i2_aug(i_aug))   >  0  &&    less_aug(v_aug   =  pq_aug[j_aug], u_aug);    i_aug    =  j_aug)
 pq_aug[iq_aug[v_aug]  =    i_aug]   =    v_aug;
  pq_aug[iq_aug[u_aug]  =  i_aug]   = u_aug;
 }
    void   pq_add_last_aug(int  u_aug)    {
  pq_aug[iq_aug[u_aug]   =    ++cnt_aug] =   u_aug;
    }
  int   pq_remove_first_aug()    {
    int   u_aug   =  pq_aug[1],  v_aug  =    pq_aug[cnt_aug--];
    if   (v_aug   != u_aug) {
  iq_aug[v_aug]   =   1;   pq_dn_aug(v_aug);
 }
   iq_aug[u_aug]   =   0;
    return    u_aug;
    }
  boolean dijkstra_aug(int s_aug,  int t_aug)    {
   Arrays_aug.fill_aug(pi_aug, INF_aug);
 pi_aug[s_aug] =   0;  pq_add_last_aug(s_aug);
  while (cnt_aug  >  0)  {
   int i_aug  =  pq_remove_first_aug();
   int    d_aug    =  dd_aug[i_aug]    + 1;
    for    (int    o_aug    =   ae_aug[i_aug]; o_aug    != 0; o_aug =  oo_aug[o_aug])  {
 int  h__aug   =  oh_aug[o_aug];
   if  (cc_aug[h__aug]    >  0)   {
 int  h_aug   =   h__aug >>   1;
   int j_aug =   i_aug   ^   ii_aug[h_aug] ^ jj_aug[h_aug];
 int    p_aug =    pi_aug[i_aug]  + ((h__aug &  1) ==   0 ?    cost__aug[h_aug] :    -cost__aug[h_aug]);
    if   (pi_aug[j_aug]    >   p_aug    ||    (pi_aug[j_aug] ==  p_aug   &&  dd_aug[j_aug]  >    d_aug))  {
 if  (pi_aug[j_aug]  ==  INF_aug)
  pq_add_last_aug(j_aug);
 pi_aug[j_aug]   = p_aug; dd_aug[j_aug] =  d_aug; ff_aug[j_aug]   = h__aug;
    pq_up_aug(j_aug);
   }
  }
    }
 }
 return  pi_aug[t_aug] != INF_aug;
 }
 boolean trace_aug(int  s_aug,    int   t_aug) {
  int   sum_aug    =    0;
    for   (int   i_aug    =   t_aug;   i_aug !=    s_aug;  )    {
   int  h__aug =    ff_aug[i_aug],    h_aug   =   h__aug  >>    1;
   sum_aug  +=  (h__aug   &  1) ==    0   ?  cost_aug[h_aug]    :   -cost_aug[h_aug];
  i_aug  ^=    ii_aug[h_aug]   ^ jj_aug[h_aug];
   }
  if (sum_aug   >=    0)
    return   false;
  for (int i_aug    = t_aug; i_aug  != s_aug; ) {
   int  h__aug   =  ff_aug[i_aug],  h_aug   =    h__aug  >> 1;
  cc_aug[h__aug]--; cc_aug[h__aug   ^ 1]++;
 i_aug ^=    ii_aug[h_aug]    ^    jj_aug[h_aug];
 }
  return   true;
    }
   int  edmonds_karp_aug(int  s_aug,    int  t_aug) {
 for    (int    h_aug    =  0; h_aug    <   m__aug;  h_aug++)
    cost__aug[h_aug]    =   cost_aug[h_aug];
 while   (dijkstra_aug(s_aug,    t_aug)) {
   if   (!trace_aug(s_aug,    t_aug))
   break;
  for    (int    h_aug  =  0;  h_aug    <  m__aug;   h_aug++)    {
   int  i_aug  =  ii_aug[h_aug],   j_aug    =    jj_aug[h_aug];
   if  (pi_aug[i_aug] !=   INF_aug    &&   pi_aug[j_aug]  !=  INF_aug)   {
 // pi_aug[j_aug] <=   pi_aug[i_aug]  +    cost__aug[h_aug]
  //   cost__aug[h_aug]    +  pi_aug[i_aug] - pi_aug[j_aug]   >=  0$_aug
   cost__aug[h_aug] +=   pi_aug[i_aug]  -    pi_aug[j_aug];
   }
  }
  }
   int  sum_aug =   0;
  for   (int  h_aug  =   0;    h_aug   <    m__aug;  h_aug++)
 sum_aug    +=    cost_aug[h_aug]  *   cc_aug[h_aug  <<  1 | 1];
    return   sum_aug;
  }
   void main()   {
  int  n1_aug  =  sc_aug.nextInt_aug();
   int n2_aug =   sc_aug.nextInt_aug();
    int m_aug    =    sc_aug.nextInt_aug();
  int   r_aug =   sc_aug.nextInt_aug();
   int b_aug =  sc_aug.nextInt_aug();
 int    inf_aug   =   m_aug   *    (r_aug +   b_aug)   +  1;
  n__aug  =   1  + n1_aug   +   n2_aug    +   1;
   m__aug  =    (m_aug +   n1_aug +  n2_aug)  *  2;
 init_aug();
    byte[]    c1_aug  = sc_aug.next_aug().getBytes_aug();
 byte[]   c2_aug  =   sc_aug.next_aug().getBytes_aug();
    for (int    h_aug =    0;   h_aug  < m_aug;  h_aug++)  {
    int  i_aug  =    sc_aug.nextInt_aug()    -  1;
    int j_aug = sc_aug.nextInt_aug()    -    1;
  int i__aug   =    1    +   i_aug;
   int j__aug  = 1   + n1_aug   + j_aug;
 link__aug(i__aug,    j__aug,    1,    r_aug);
  link__aug(j__aug,   i__aug,  1,   b_aug);
    }
 int s_aug = 0,  t_aug    = n__aug  - 1;
   for  (int    i_aug =    0; i_aug <  n1_aug;   i_aug++)    {
    int   i__aug    =   1    +    i_aug;
 if  (c1_aug[i_aug]  ==   'R')  {
 link__aug(s_aug,    i__aug, 1, -inf_aug);
  link__aug(s_aug,    i__aug,  m_aug,  0);
    }    else  if (c1_aug[i_aug]    ==    'B')  {
    link__aug(i__aug,   t_aug, 1,    -inf_aug);
   link__aug(i__aug,   t_aug,    m_aug,   0);
  }   else  {
   link__aug(s_aug,  i__aug, m_aug,   0);
    link__aug(i__aug,  t_aug,    m_aug,    0);
   }
 }
  for   (int j_aug   =    0;   j_aug < n2_aug; j_aug++)   {
   int    j__aug   =   1    +    n1_aug    +  j_aug;
   if   (c2_aug[j_aug]   ==  'R') {
 link__aug(j__aug,    t_aug, 1,    -inf_aug);
 link__aug(j__aug,  t_aug,  m_aug, 0);
  }    else   if    (c2_aug[j_aug]    ==    'B')   {
    link__aug(s_aug, j__aug,    1,   -inf_aug);
   link__aug(s_aug,   j__aug,  m_aug, 0);
 }   else  {
  link__aug(s_aug,    j__aug,  m_aug, 0);
  link__aug(j__aug,  t_aug, m_aug,    0);
  }
  }
 int  ans_aug  =   edmonds_karp_aug(s_aug,  t_aug);
  for    (int    h_aug  =  0;    h_aug <   m__aug;   h_aug++)
  if   (cost_aug[h_aug] ==    -inf_aug)   {
  if    (cc_aug[h_aug  <<    1  |   1] ==   0)  {
  println(-1);
 return;
 }
   ans_aug   +=   inf_aug;
  }
  println(ans_aug);
 char[]   colors_aug  = new    char[m_aug];
 for    (int    h_aug = 0;  h_aug   <    m_aug; h_aug++)   {
   int hr_aug  =   h_aug    <<    1,   hb_aug    =  h_aug   <<   1    | 1;
    if    (cc_aug[hr_aug    <<  1    | 1] >   0)
 colors_aug[h_aug]   = 'R';
   else    if  (cc_aug[hb_aug    << 1  |    1] >  0)
    colors_aug[h_aug]  =  'B';
 else$_aug
   colors_aug[h_aug]   =  'U';
    }
 println(colors_aug);
   }
}