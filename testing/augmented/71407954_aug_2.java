import    java_aug.io_aug.*;
import    java_aug.util_aug.*;

public    class    F_aug
{
    //@ <-    not  printed  in_aug hackpack
   static   class    MinCostFlow_aug  {
 static int    MINCOSTFLOW_aug    =  0, MINCOSTMAXFLOW_aug  =   1;
    int s_aug,  t_aug,   N_aug,  ss_aug, tt_aug;  //   use  s_aug    and   t_aug   as   your   source  &  sink
  long  oo_aug  =    (long)1e12;
  long[] ex_aug;    ArrayList_aug<Edge_aug>[]   adjj_aug;  Edge_aug[][]   adj_aug;

   public   MinCostFlow_aug(int NN_aug)   {  this(NN_aug,   MINCOSTMAXFLOW_aug); }

    public    MinCostFlow_aug(int  NN_aug, int   flowType_aug)    {
 N_aug    =   (tt_aug   = (ss_aug   = (t_aug  = (s_aug  =   NN_aug) + 1) +    1)  + 1) +  1;

 adj_aug  =  new  Edge_aug[N_aug][0];    adjj_aug  =   new   ArrayList_aug[N_aug];
    for   (int i_aug  =   0;  i_aug  <    N_aug;  i_aug++) adjj_aug[i_aug]    =  new ArrayList_aug<Edge_aug>();
 ex_aug =    new long[N_aug];   add_aug(t_aug,   s_aug,    oo_aug,   -oo_aug /    10 * flowType_aug);
  }

   public    void   add_aug(int  i_aug,   int    j_aug,  long    cap_aug,    long cost_aug)   {
  Edge_aug   fwd_aug    =    new    Edge_aug(i_aug,    j_aug,   cap_aug,  0,    cost_aug);
 Edge_aug  rev_aug = new    Edge_aug(j_aug,   i_aug,   0, 0,   -cost_aug);
    adjj_aug[i_aug].add_aug(rev_aug.rev_aug    =  fwd_aug);    adjj_aug[j_aug].add_aug(fwd_aug.rev_aug   =    rev_aug);
 }

  public void  add_aug(int   i_aug,    int  j_aug, long  cap_aug,    long cost_aug,   int  id_aug,  int  ttype_aug)   {
    Edge_aug   fwd_aug  =  new   Edge_aug(i_aug, j_aug, cap_aug, 0,    cost_aug,  id_aug,   ttype_aug);
  Edge_aug    rev_aug = new  Edge_aug(j_aug,   i_aug,    0, 0, -cost_aug,  id_aug, ttype_aug);
  adjj_aug[i_aug].add_aug(rev_aug.rev_aug  =    fwd_aug);   adjj_aug[j_aug].add_aug(fwd_aug.rev_aug = rev_aug);
    }

 public    long[]   getFlow_aug()  {
   preFlow_aug();
    for   (int i_aug   =    0;    i_aug <    N_aug; i_aug++) adj_aug[i_aug]    =  adjj_aug[i_aug].toArray_aug(adj_aug[i_aug]);
   boolean[]  canU_aug = new  boolean[N_aug],   hasU_aug  =    new  boolean[N_aug];
 long[]   dist_aug   =  new  long[N_aug],   width_aug =    new    long[N_aug];
   Edge_aug[]   prev_aug  =    new  Edge_aug[N_aug];
    while   (true)  {
    Arrays_aug.fill_aug(dist_aug, oo_aug); dist_aug[ss_aug]   = 0;
  width_aug[ss_aug]   =   oo_aug;  boolean   updated_aug  =  hasU_aug[ss_aug]  =  true;
  while   (updated_aug)    {
   updated_aug    =  false;
   for  (int    i_aug   =    0;  i_aug < N_aug;   hasU_aug[i_aug++]   =    false)    canU_aug[i_aug]  = hasU_aug[i_aug];
  for   (int i_aug = 0;    i_aug    <    N_aug;   i_aug++)
   if  (canU_aug[i_aug])
   for   (Edge_aug e_aug  :    adj_aug[i_aug])
   if   (e_aug.flow_aug   !=  e_aug.cap_aug  && dist_aug[e_aug.j_aug]   >   dist_aug[e_aug.i_aug]  +    e_aug.cost_aug)  {
  dist_aug[e_aug.j_aug] = dist_aug[e_aug.i_aug] +  (prev_aug[e_aug.j_aug]  = e_aug).cost_aug;
   width_aug[e_aug.j_aug]  =    Math_aug.min_aug(width_aug[e_aug.i_aug],   e_aug.cap_aug   - e_aug.flow_aug);
   hasU_aug[e_aug.j_aug]  =    updated_aug =    true;
  }
 }
 if   (dist_aug[tt_aug] >=  oo_aug)   break;

    for (Edge_aug  e_aug = prev_aug[tt_aug];    e_aug  !=  null;    e_aug = prev_aug[e_aug.i_aug])
    e_aug.rev_aug.flow_aug   =   -(e_aug.flow_aug  +=  width_aug[tt_aug]);
    }
   long flow_aug  = 0, cost_aug  =   0;
  for   (Edge_aug e_aug    :   adj_aug[s_aug])   if    (e_aug.flow_aug   > 0)  flow_aug  +=    e_aug.flow_aug;
    for  (int   i_aug   = 0; i_aug  < N_aug; i_aug++)
   for  (Edge_aug e_aug    : adj_aug[i_aug])
  if    (e_aug.flow_aug   >    0    &&  e_aug.i_aug !=   t_aug    &&  e_aug.j_aug   !=    s_aug   &&    e_aug.i_aug  <    ss_aug  &&    e_aug.j_aug  <  ss_aug)
  cost_aug  +=   e_aug.flow_aug  *  e_aug.cost_aug;

   return  new long[] {flow_aug,  cost_aug};
 }

 public   void  preFlow_aug()    {
    for (int    i_aug  =  0;  i_aug   <    N_aug;    i_aug++)
   for    (Edge_aug  e_aug    :  adjj_aug[i_aug])
 if    (e_aug.cost_aug <  0   && e_aug.cap_aug    - e_aug.flow_aug   > 0) {
    ex_aug[e_aug.i_aug]   -=   e_aug.cap_aug   - e_aug.flow_aug;
 ex_aug[e_aug.j_aug] +=    e_aug.cap_aug  -  e_aug.flow_aug;
  e_aug.rev_aug.flow_aug    =   -(e_aug.flow_aug    =   e_aug.cap_aug);
 }
   for (int  i_aug  =    0; i_aug    < N_aug;  i_aug++)
   if    (ex_aug[i_aug] >    0)   add_aug(ss_aug,   i_aug,    ex_aug[i_aug], -oo_aug);
   else    if   (ex_aug[i_aug]    <  0)   add_aug(i_aug, tt_aug,  -ex_aug[i_aug],  -oo_aug);
    Arrays_aug.fill_aug(ex_aug, 0);
  }

  }  
   static    class    Edge_aug {
 int   i_aug, j_aug; long  cap_aug,   flow_aug, cost_aug;    Edge_aug  rev_aug;
 int    id_aug    = -1,   type_aug =   0;
  Edge_aug(int  ii_aug,    int  jj_aug, long   cc_aug, long   ff_aug,    long    C_aug)   {
 i_aug   =  ii_aug;    j_aug    =    jj_aug;    cap_aug    =  cc_aug; flow_aug =    ff_aug; cost_aug   =    C_aug;
 }

    Edge_aug(int    ii_aug,   int  jj_aug,   long   cc_aug,   long  ff_aug,    long    C_aug,    int iid_aug,   int   ttype_aug)  {
 i_aug   =  ii_aug;   j_aug  =  jj_aug;  cap_aug   =   cc_aug;   flow_aug    =    ff_aug;    cost_aug    = C_aug;
  id_aug   = iid_aug;
   type_aug = ttype_aug;
  }
    }

 void solve_aug(FastIO_aug io_aug)
   {
   int   n1_aug   =   io_aug.nextInt_aug();
   int n2_aug =   io_aug.nextInt_aug();
 int   m_aug = io_aug.nextInt_aug();
   int    r_aug    =  io_aug.nextInt_aug();
 int    b_aug  =   io_aug.nextInt_aug();
 char[]  s1_aug    =  io_aug.next_aug().toCharArray_aug();
   char[]    s2_aug   =  io_aug.next_aug().toCharArray_aug();

    MinCostFlow_aug  mcmf_aug =  new    MinCostFlow_aug(n1_aug    +    n2_aug,   0);
    long soo_aug  = 1000000;
 int cnt_aug    = n1_aug +   n2_aug;

    for (int    i_aug  =   0;    i_aug   <  n1_aug;  i_aug++)
   {
    if  (s1_aug[i_aug]  ==    'R')
   {
  mcmf_aug.add_aug(mcmf_aug.s_aug, i_aug,    1, -soo_aug);
  mcmf_aug.add_aug(mcmf_aug.s_aug, i_aug,    1000,    0);
  }
   else if   (s1_aug[i_aug]  ==  'B')
   {
   mcmf_aug.add_aug(i_aug,    mcmf_aug.t_aug, 1,  -soo_aug);
    mcmf_aug.add_aug(i_aug,    mcmf_aug.t_aug,    1000, 0);
  }
    else
  {
   cnt_aug--;
 mcmf_aug.add_aug(mcmf_aug.s_aug,    i_aug,  1000,   0);
   mcmf_aug.add_aug(i_aug,   mcmf_aug.t_aug,    1000,  0);
    }
 }

    for    (int    i_aug  =  0;    i_aug    <   n2_aug;   i_aug++)
  {
  if    (s2_aug[i_aug]   ==   'B')
  {
    mcmf_aug.add_aug(mcmf_aug.s_aug,   i_aug +  n1_aug,  1,   -soo_aug);
   mcmf_aug.add_aug(mcmf_aug.s_aug, i_aug    +  n1_aug, 1000,   0);
    }
 else if    (s2_aug[i_aug] ==    'R')
   {
    mcmf_aug.add_aug(i_aug   + n1_aug,    mcmf_aug.t_aug,   1,   -soo_aug);
  mcmf_aug.add_aug(i_aug + n1_aug,    mcmf_aug.t_aug,  1000,    0);
 }
  else
   {
  cnt_aug--;
  mcmf_aug.add_aug(mcmf_aug.s_aug, i_aug  +  n1_aug, 1000,   0);
    mcmf_aug.add_aug(i_aug    +   n1_aug,    mcmf_aug.t_aug,   1000, 0);
   }
 }

    int[]   from_aug  =   new int[m_aug];
   int[] to_aug  =   new    int[m_aug];
  for (int  i_aug  =    0;  i_aug <   m_aug;   i_aug++)
 {
   int   u_aug   =    from_aug[i_aug]   = io_aug.nextInt_aug()    - 1;
   int    v_aug    =    to_aug[i_aug]   =    io_aug.nextInt_aug()   - 1;

  mcmf_aug.add_aug(u_aug,  n1_aug +    v_aug,    1, r_aug,    i_aug, 1);
  mcmf_aug.add_aug(n1_aug +  v_aug,  u_aug,   1,   b_aug, i_aug, -1);
  }

   long[]    flow_aug   =    mcmf_aug.getFlow_aug();

  if    (flow_aug[1]   +   cnt_aug    * soo_aug   >   soo_aug)
    {
    io_aug.println(-1);
  return;
   }

  long    ans_aug   =  flow_aug[1]  +    soo_aug  * cnt_aug;

  long[]   col_aug   = new    long[m_aug];
 long[]  bal1_aug   =    new  long[n1_aug];
    long[]    bal2_aug  =  new    long[n2_aug];
   for   (ArrayList_aug<Edge_aug>    list_aug   :    mcmf_aug.adjj_aug)
    for   (Edge_aug    e_aug    :  list_aug)
   if (e_aug.id_aug    !=    -1    &&   e_aug.flow_aug >    0)
    {
  col_aug[e_aug.id_aug] =   e_aug.type_aug;
 bal1_aug[from_aug[e_aug.id_aug]]    +=    e_aug.type_aug;
  bal2_aug[to_aug[e_aug.id_aug]] +=  e_aug.type_aug;
   }


  for   (int   i_aug  = 0;   i_aug   <    n1_aug;  i_aug++)
    if   ((s1_aug[i_aug]  ==   'R' &&   bal1_aug[i_aug]   <= 0) ||   (s1_aug[i_aug] ==    'B'   && bal1_aug[i_aug]  >= 0))
  {
   io_aug.println(-1);
    return;
    }

 for   (int i_aug  = 0;    i_aug    < n2_aug;   i_aug++)
  if    ((s2_aug[i_aug]   == 'R' && bal2_aug[i_aug] <=  0) ||    (s2_aug[i_aug]    ==   'B'    && bal2_aug[i_aug] >= 0))
    {
 io_aug.println(-1);
  return;
   }
  io_aug.println(ans_aug);

  for  (int    i_aug    =   0; i_aug   <    m_aug;  i_aug++)
 io_aug.print_aug(col_aug[i_aug] >  0   ?    'R'    :    (col_aug[i_aug]    < 0   ? 'B' :   'U'));

  io_aug.println();
   }

  public    static   void    main(String_aug[]    args_aug)
    {
 FastIO_aug   io_aug    =  new  FastIO_aug();

    new F_aug().solve_aug(io_aug);

   io_aug.close_aug();
   }

 static    class    FastIO_aug  extends PrintWriter_aug
   {
    BufferedReader_aug   r_aug =  new BufferedReader_aug(new    InputStreamReader_aug(System.in_aug));
  StringTokenizer_aug    st_aug   =   new   StringTokenizer_aug("");

   FastIO_aug()
  {
    super(System.out);
 }

  public    String_aug   next_aug()
    {
   while  (!st_aug.hasMoreTokens_aug())
 {
  try    {
 st_aug   =    new   StringTokenizer_aug(r_aug.readLine_aug());
   }  catch   (Exception_aug   e_aug)   {
  //TODO:  handle  exception
   }
    }
   return    st_aug.nextToken_aug();
   }

   public    int   nextInt_aug()
   {
  return   Integer_aug.parseInt_aug(next_aug());
   }

   public long    nextLong_aug()
 {
    return   Long_aug.parseLong_aug(next_aug());
   }

  public   double nextDouble_aug()
   {
 return Double_aug.parseDouble_aug(next_aug());
   }
  }
}
