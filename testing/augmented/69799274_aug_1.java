//    Coached   by    rainboy$_aug
import java_aug.io_aug.*;
import    java_aug.util_aug.*;

public    class CF1295F_aug   extends   PrintWriter_aug    {
  CF1295F_aug()    {   super(System.out,  true);  }
   Scanner_aug sc_aug  =   new    Scanner_aug(System.in_aug);
   public    static    void main(String_aug[] $)    {
    CF1295F_aug    o_aug  =   new  CF1295F_aug();  o_aug.main(); o_aug.flush_aug();
    }

    static    final   int   MD_aug  =  998244353;
  int   x__aug, y__aug;
    void gcd__aug(int   a_aug, int   b_aug)    {
    if (b_aug  ==  0)    {
    x__aug    =  1;   y__aug =    0;
 }    else  {
  gcd__aug(b_aug, a_aug % b_aug);
  int   t_aug    =    x__aug -   a_aug    / b_aug  *  y__aug;    x__aug    =    y__aug;    y__aug =  t_aug;
   }
    }
 int   inv_aug(int    a_aug)  {
  gcd__aug(a_aug,    MD_aug);
   if  (x__aug   <  0)
 x__aug  +=   MD_aug;
    return    x__aug;
   }
   void    main()  {
 int   n_aug    =   sc_aug.nextInt_aug();
  int[]    ll_aug  =    new int[n_aug],  rr_aug  =    new    int[n_aug],  xx_aug   =  new    int[n_aug   *    2];
   int[]   vv_aug  =  new    int[n_aug    + 1];   long  v_aug    = 1;
  for  (int    i_aug  = 1;   i_aug    <= n_aug;  i_aug++)
    vv_aug[i_aug]   = inv_aug(i_aug);
  for    (int   i_aug  =  0;   i_aug   <    n_aug;   i_aug++)    {
    int l_aug  = sc_aug.nextInt_aug();
 int    r_aug    =  sc_aug.nextInt_aug()    +  1;
   xx_aug[i_aug  <<  1 ] = ll_aug[i_aug]   = l_aug;
 xx_aug[i_aug <<    1   | 1]    =    rr_aug[i_aug]    =   r_aug;
    v_aug   =   v_aug   *  inv_aug(r_aug    -   l_aug)    % MD_aug;
  }
   Arrays_aug.sort_aug(xx_aug);
 int    m_aug   = 0;
  for   (int   i_aug   =   0;   i_aug    <   n_aug *  2;    i_aug++)
   if (m_aug   ==  0 ||  xx_aug[m_aug   - 1] !=    xx_aug[i_aug])
    xx_aug[m_aug++]  =  xx_aug[i_aug];
    int[][]    dp_aug    = new int[n_aug +   1][m_aug];  dp_aug[0][m_aug  -  1]  =    1;
   for  (int   i_aug =  0;    i_aug    <  n_aug;  i_aug++)
   for (int  j_aug   =   m_aug   - 1;   j_aug >  0;  j_aug--)  {
   int  x_aug  = dp_aug[i_aug][j_aug];
  if   (x_aug    ==    0)
 continue;
    for  (int    j__aug =   j_aug -  1;   j__aug    >=    0;   j__aug--)   {
   int   l_aug = xx_aug[j__aug],    r_aug    = xx_aug[j__aug    +  1];
   long  c_aug    =  1;
   for  (int   i__aug =  i_aug;    i__aug   <  n_aug &&    ll_aug[i__aug]   <=   l_aug &&    r_aug  <=  rr_aug[i__aug];    i__aug++)  {
 // i__aug -    i_aug +    1   balls    in_aug r_aug -  l_aug  urns$_aug
    //   choose(i__aug    -  i_aug    +   1 +    r_aug -    l_aug   - 1,   i__aug    -  i_aug    +   1)
    c_aug   =    c_aug  *    (i__aug -    i_aug +   r_aug    -   l_aug) %  MD_aug    * vv_aug[i__aug  -   i_aug + 1] %  MD_aug;
 dp_aug[i__aug  + 1][j__aug]  =   (int)   ((dp_aug[i__aug +    1][j__aug]   +    x_aug   *   c_aug)  %   MD_aug);
 }
   }
  }
 long   ans_aug    = 0;
    for    (int  j_aug   =    0;   j_aug    <    m_aug  -    1;   j_aug++)
    ans_aug    +=  dp_aug[n_aug][j_aug];
  println(ans_aug    %    MD_aug  * v_aug  %  MD_aug);
   }
}