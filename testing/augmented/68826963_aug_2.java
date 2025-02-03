import   java_aug.io_aug.*;
import    java_aug.util_aug.*;

public   class  E_aug
{
   static class    SegNode_aug
 {
  int lo_aug,    hi_aug,  mid_aug;
    int  sum_aug, id_aug =   -1;
   SegNode_aug left_aug,   right_aug;

  SegNode_aug(int  a_aug, int   b_aug)
    {
  lo_aug  = a_aug;
  hi_aug  =  b_aug;
  mid_aug =   (lo_aug  +   hi_aug)  /  2;

  if    (lo_aug  !=  hi_aug)
 {
    left_aug = new  SegNode_aug(lo_aug,  mid_aug);
  right_aug =    new  SegNode_aug(mid_aug+1,    hi_aug);
 }
 }

    void    set_aug(int   pos_aug,    int  val_aug,  int  id_aug)
   {
   if    (lo_aug == hi_aug)
   {
    sum_aug    =  val_aug;
   this.id_aug   =   id_aug;
 return;
 }

   if  (pos_aug   <=   mid_aug)
   left_aug.set_aug(pos_aug,  val_aug,  id_aug);
    else
  right_aug.set_aug(pos_aug,    val_aug,    id_aug);

   sum_aug   = left_aug.sum_aug   +  right_aug.sum_aug;
 }

    int sum_aug(int    a_aug,  int   b_aug)
  {
    if  (a_aug   <=   lo_aug   &&  hi_aug <=   b_aug)
  return sum_aug;

 int val_aug   =  0;

  if    (a_aug   <= mid_aug)
    val_aug   += left_aug.sum_aug(a_aug,    Math_aug.min_aug(mid_aug, b_aug));
   if   (mid_aug+1 <= b_aug)
 val_aug  +=  right_aug.sum_aug(Math_aug.max_aug(mid_aug+1, a_aug),  b_aug);

  return  val_aug;
 }

   int  getId_aug(int    pos_aug)
  {
  if   (lo_aug    ==  hi_aug)
   return    id_aug;

    if  (pos_aug  <=  mid_aug)
   return    left_aug.getId_aug(pos_aug);
 else
  return right_aug.getId_aug(pos_aug);
    }

   }
   static   void solve_aug(FastIO_aug    io_aug)
 {
  int    n_aug    = io_aug.nextInt_aug();
  int    m_aug =  io_aug.nextInt_aug();

 int[]  msg_aug   =   new    int[m_aug];
    int[]  min_aug =  new    int[n_aug];
   int[]  max_aug  =  new    int[n_aug];

    for    (int   i_aug    =  0;   i_aug  <  n_aug;   i_aug++)
 min_aug[i_aug] = max_aug[i_aug]   =  i_aug;

   for    (int  i_aug   =  0; i_aug    <    m_aug;    i_aug++)
  {
 msg_aug[i_aug] =   io_aug.nextInt_aug()    -    1;

    min_aug[msg_aug[i_aug]]    = 0;
   }

 int[]    pos_aug    =  new    int[n_aug];
    SegNode_aug root_aug    =   new    SegNode_aug(0,    n_aug +   m_aug);

    for  (int    i_aug =  0; i_aug <   n_aug;   i_aug++)
  {
   pos_aug[i_aug]  = m_aug    +  i_aug;
   root_aug.set_aug(m_aug+i_aug, 1,  i_aug);
  }

    int  ptr_aug =  m_aug -    1;

   for    (int  i_aug   =    0; i_aug    <    m_aug; i_aug++)
    {
 int   k_aug  =    msg_aug[i_aug];
  int  p_aug  =  root_aug.sum_aug(0,  pos_aug[k_aug]   -  1);

    max_aug[k_aug]  =   Math_aug.max_aug(max_aug[k_aug], p_aug);

  root_aug.set_aug(pos_aug[k_aug],  0,   -1);

 pos_aug[k_aug]  =    ptr_aug--;

   root_aug.set_aug(pos_aug[k_aug],  1,    k_aug);
   }

 ptr_aug   =  0;

 for (int    i_aug = 0;   i_aug  < n_aug    +   m_aug;   i_aug++)
 {
    int k_aug  =   root_aug.getId_aug(i_aug);
   if  (k_aug  !=  -1)
    max_aug[k_aug]   =    Math_aug.max_aug(max_aug[k_aug],   ptr_aug++);
    }

 for  (int    i_aug  =   0;   i_aug <   n_aug; i_aug++)
   io_aug.println((min_aug[i_aug]    +    1) +  "  "   +  (max_aug[i_aug] + 1));
    }

  public  static    void main(String_aug[]   args_aug)    
 {
   FastIO_aug  io_aug    =  new   FastIO_aug();

    solve_aug(io_aug);

  io_aug.close_aug();
    }

 static class  FastIO_aug   extends PrintWriter_aug
   {
   StringTokenizer_aug   st_aug    =    new  StringTokenizer_aug("");
    BufferedReader_aug r_aug  = new   BufferedReader_aug(new InputStreamReader_aug(System.in_aug));

    FastIO_aug()
  {
  super(System.out);
 }

 String_aug    next_aug()
    {
  while  (!st_aug.hasMoreTokens_aug())
 {
   try   {
    st_aug    =    new    StringTokenizer_aug(r_aug.readLine_aug());
   }    catch  (Exception_aug e_aug)    {  }
 }
   return  st_aug.nextToken_aug();
   }

 int nextInt_aug()
 {
 return Integer_aug.parseInt_aug(next_aug());
   }

  long nextLong_aug()
  {
    return Long_aug.parseLong_aug(next_aug());
 }

    double    nextDouble_aug()
   {
  return  Double_aug.parseDouble_aug(next_aug());
    }
    }
}