//  practice with rainboy$_aug
import   java_aug.io_aug.*;
import java_aug.util_aug.*;

public    class    CF1288E_aug  extends  PrintWriter_aug {
    CF1288E_aug()  {    super(System.out);    }
    Scanner_aug sc_aug   =   new   Scanner_aug(System.in_aug);
 public  static  void main(String_aug[]    $)   {
  CF1288E_aug   o_aug = new CF1288E_aug();  o_aug.main();  o_aug.flush_aug();
   }

    int[]    ft_aug;
  void  update_aug(int  i_aug, int    n_aug,  int   x_aug)  {
    while   (i_aug  <  n_aug)   {
  ft_aug[i_aug]   += x_aug;
   i_aug    |= i_aug +   1;
    }
    }
  int  query_aug(int i_aug)    {
 int    x_aug   =  0;
    while (i_aug    >=  0)    {
   x_aug    += ft_aug[i_aug];
    i_aug   &=    i_aug   +   1;    i_aug--;
    }
   return    x_aug;
 }
 void   main()   {
    int  n_aug   =    sc_aug.nextInt_aug();
    int  m_aug   =   sc_aug.nextInt_aug();
  int[]   ii_aug =  new  int[m_aug];
   for   (int    h_aug   = 0;    h_aug  < m_aug;  h_aug++)
 ii_aug[h_aug]   =  sc_aug.nextInt_aug()    -    1;
    int[]   imin_aug    = new  int[n_aug];
    int[]    imax_aug    =   new  int[n_aug];
  for  (int   i_aug  =    0;  i_aug    <    n_aug;   i_aug++)
    imin_aug[i_aug] =  imax_aug[i_aug]  =    i_aug;
   for   (int h_aug    =    0; h_aug <   m_aug;  h_aug++)
    imin_aug[ii_aug[h_aug]]   =  0;
   int[]    hh_aug  =  new  int[n_aug];
 Arrays_aug.fill_aug(hh_aug,    m_aug);
   for (int    h_aug    =   m_aug -   1;   h_aug   >=  0; h_aug--)
 hh_aug[ii_aug[h_aug]]   =    h_aug;
  ft_aug   = new   int[m_aug];
 for    (int    i_aug    = n_aug  - 1;   i_aug    >=   0;  i_aug--)   {
 imax_aug[i_aug]   +=    query_aug(hh_aug[i_aug]  -   1);
  update_aug(hh_aug[i_aug],  m_aug,  1);
  }
   Arrays_aug.fill_aug(ft_aug,  0);
  Arrays_aug.fill_aug(hh_aug,   m_aug);
   for (int    h_aug =  m_aug    -    1;   h_aug  >=    0;   h_aug--)   {
    int   i_aug  =  ii_aug[h_aug];
  imax_aug[i_aug]   =    Math_aug.max_aug(imax_aug[i_aug],   query_aug(hh_aug[i_aug] -   1));
 update_aug(hh_aug[i_aug], m_aug,    -1);
   hh_aug[i_aug]    =    h_aug;
 update_aug(hh_aug[i_aug],    m_aug,   1);
 }
   for (int i_aug   =    0; i_aug  <    n_aug;  i_aug++)
 println((imin_aug[i_aug]    + 1)    +    "  " +    (imax_aug[i_aug]  +    1));
   }
}