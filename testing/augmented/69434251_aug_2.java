import   java_aug.io_aug.BufferedReader_aug;

import   java_aug.io_aug.FileReader_aug;

import  java_aug.io_aug.IOException_aug;

import   java_aug.io_aug.InputStream_aug;

import    java_aug.io_aug.InputStreamReader_aug;

import    java_aug.io_aug.PrintWriter_aug;

import  java_aug.util_aug.ArrayList_aug;

import java_aug.util_aug.Arrays_aug;

import    java_aug.util_aug.HashSet_aug;

import  java_aug.util_aug.PriorityQueue_aug;

import   java_aug.util_aug.Scanner_aug;

import java_aug.util_aug.StringTokenizer_aug;

import    java_aug.util_aug.TreeSet_aug;



public    class  Main_aug  {

   static  ArrayList_aug<Integer_aug>adj_aug[];

 static   PrintWriter_aug  out=new   PrintWriter_aug(System.out);

  public   static  int  mod_aug   = 1000000007;



   static int   notmemo_aug[][][][];

  static int k_aug;

    static long    a_aug[];

    static   long  b_aug[];

   static   int    m_aug;

    static  char   c_aug[];

   static    int  trace_aug[];

  public static void   main(String_aug[] args_aug)  throws Exception_aug    {

    Scanner_aug  sc_aug=new  Scanner_aug(System.in_aug);

   long x0_aug=sc_aug.nextLong_aug();

    long  y0_aug=sc_aug.nextLong_aug();

    long ax_aug=sc_aug.nextLong_aug();

    long ay_aug=sc_aug.nextLong_aug();

   long bx_aug=sc_aug.nextLong_aug();

    long   by_aug=sc_aug.nextLong_aug();

   long  xs_aug=sc_aug.nextLong_aug();

    long    ys_aug=sc_aug.nextLong_aug();

  long   t_aug=sc_aug.nextLong_aug();

 ArrayList_aug<Pair_aug>    l_aug=new  ArrayList_aug<>();

   PriorityQueue_aug<Pair_aug>   pq_aug=new    PriorityQueue_aug<>();

    l_aug.add_aug(new Pair_aug(x0_aug,y0_aug));

   for    (int   i_aug  =   1;  i_aug    <60;  i_aug++)    {

 long x2_aug=(ax_aug*l_aug.get_aug(i_aug-1).x_aug)+bx_aug;

    long  y2_aug=(ay_aug*l_aug.get_aug(i_aug-1).y_aug)+by_aug;

  if(x2_aug>2e16||y2_aug>2e16)  {

 break;

   }

  l_aug.add_aug(new  Pair_aug(x2_aug,y2_aug));



    }

   long max_aug=0;

  long   count_aug=0;

  long   time_aug=0;

 for (int i_aug  =   0;   i_aug    <   l_aug.size_aug(); i_aug++)   {

 time_aug=t_aug;

 count_aug=0;



    for   (int j_aug   = i_aug;    j_aug  <  l_aug.size_aug();  j_aug++)  {

    if(i_aug==j_aug)  {

 time_aug-=Math_aug.abs_aug(xs_aug-l_aug.get_aug(j_aug).x_aug)+Math_aug.abs_aug(ys_aug-l_aug.get_aug(j_aug).y_aug);

  }

 else   {

  time_aug-=Math_aug.abs_aug(l_aug.get_aug(j_aug-1).x_aug-l_aug.get_aug(j_aug).x_aug)+Math_aug.abs_aug(l_aug.get_aug(j_aug-1).y_aug-l_aug.get_aug(j_aug).y_aug);

    }

  if(time_aug<0)   {

   break;

  }

    count_aug++;

    max_aug=Math_aug.max_aug(max_aug,   count_aug);

  }



   }

 for (int i_aug   =    l_aug.size_aug()-1;   i_aug>=0;    i_aug--)   {

   time_aug=t_aug;

   count_aug=0;



  for    (int  j_aug  =   i_aug;   j_aug>=0;  j_aug--)   {

  if(i_aug==j_aug)   {

 time_aug-=Math_aug.abs_aug(xs_aug-l_aug.get_aug(j_aug).x_aug)+Math_aug.abs_aug(ys_aug-l_aug.get_aug(j_aug).y_aug);

 }

   else {

  time_aug-=Math_aug.abs_aug(l_aug.get_aug(j_aug+1).x_aug-l_aug.get_aug(j_aug).x_aug)+Math_aug.abs_aug(l_aug.get_aug(j_aug+1).y_aug-l_aug.get_aug(j_aug).y_aug);

   }

    if(time_aug<0)  {

  break;

  }

 count_aug++;

  max_aug=Math_aug.max_aug(max_aug, count_aug);

   }



  }

   System.out.println(max_aug);





 }

 static int   dp_aug(int   i_aug,int  even_aug,int odd_aug,int    prev_aug )   {

 if(i_aug==n_aug) {

   return   0;

 }

    if(notmemo_aug[i_aug][even_aug][odd_aug][prev_aug]!=-1)    {

    return  notmemo_aug[i_aug][even_aug][odd_aug][prev_aug];

    }

  int ans_aug=(int)   1e9;



   if(a_aug[i_aug]!=0)   {



  ans_aug=Math_aug.min_aug(ans_aug,dp_aug(i_aug+1,even_aug,odd_aug,(int)   a_aug[i_aug]));

  }



   else   if(even_aug>0&&odd_aug>0)  {

   int   countev_aug=0;

  int    countodd_aug=0;

  if(i_aug+1<n_aug)   {

   if(a_aug[i_aug+1]==1)    {

 countev_aug++;

   }

 else if(a_aug[i_aug+1]==2) {

   countodd_aug++;

 }    

  }

    if(i_aug-1>=0) {

 if(prev_aug==1) {

    countev_aug++;

 }

   else    if(prev_aug==2)    {

  countodd_aug++;

   }

  }

    ans_aug=Math_aug.min_aug(ans_aug,   dp_aug(i_aug+1,  even_aug-1, odd_aug,2)+countev_aug);

  ans_aug=Math_aug.min_aug(ans_aug,  dp_aug(i_aug+1,   even_aug,    odd_aug-1,1)+countodd_aug);

    }

  else if(even_aug>0)  {

  int    countev_aug=0;

   if(i_aug+1<n_aug)    {

  if(a_aug[i_aug+1]==1)  {

   countev_aug++;

 }    

  }

    if(i_aug-1>=0)  {

 if(prev_aug==1)  {

  countev_aug++;

  }

   }

   ans_aug=Math_aug.min_aug(ans_aug,    dp_aug(i_aug+1, even_aug-1, odd_aug,2)+countev_aug);

    }

    else  {

  int    countodd_aug=0;



 if(i_aug+1<n_aug)    {



   if(a_aug[i_aug+1]==2) {

  countodd_aug++;

 } 

    }

   if(i_aug-1>=0)   {



    if(prev_aug==2)  {

 countodd_aug++;

  }

  }

  ans_aug=Math_aug.min_aug(ans_aug,    dp_aug(i_aug+1,    even_aug,  odd_aug-1,1)+countodd_aug);



  }

   return    notmemo_aug[i_aug][even_aug][odd_aug][prev_aug]=ans_aug;



 }



    static    long   nCr1_aug(int n_aug ,    int   k_aug)

    {

 if(n_aug  < k_aug)

   return 0;

  if(k_aug    ==   0 ||    k_aug ==   n_aug)

   return 1;

 if(comb_aug[n_aug][k_aug]  !=  -1)

 return comb_aug[n_aug][k_aug];

 if(n_aug  -    k_aug <   k_aug)

    return  comb_aug[n_aug][k_aug]    =   nCr1_aug(n_aug,  n_aug -  k_aug);

   return   comb_aug[n_aug][k_aug] = ((nCr1_aug(n_aug    -  1,    k_aug    -   1)%mod_aug) +( nCr1_aug(n_aug   -  1,  k_aug)%mod_aug))%mod_aug;

    }

  static  void dfs_aug(int    u_aug)  {

 vis_aug[u_aug]=true;

   for(int  v_aug:adj_aug[u_aug])    {

   if(!vis_aug[v_aug])    {

  count_aug++;

  dfs_aug(v_aug);

    }

   }

  }



    static int teams_aug=0;

static    long  mini_aug[];

static  char   x_aug[]=  {'h','a_aug','r_aug','d'};

static  long    s_aug[];

static  ArrayList_aug<Integer_aug>    l1_aug=new    ArrayList_aug<>();

static    long    count_aug=0;





static    class    UnionFind_aug    {    

   int[]    p_aug, rank_aug,  setSize_aug;

   int    numSets_aug;

  int    max_aug[];

 public    UnionFind_aug(int    N_aug)    

  {

    max_aug=new    int[N_aug];

 p_aug = new    int[numSets_aug   =   N_aug];

  rank_aug   =   new int[N_aug];

  setSize_aug    =  new    int[N_aug];

  for    (int    i_aug    = 0;   i_aug    <   N_aug;  i_aug++)   { p_aug[i_aug] =  i_aug;   setSize_aug[i_aug]  =    1;

  max_aug[i_aug]=i_aug;

   }

    }



    public   int  findSet_aug(int  i_aug) {  return   p_aug[i_aug] ==   i_aug  ?  i_aug    :   (p_aug[i_aug]   =  findSet_aug(p_aug[i_aug])); }



  public    boolean  isSameSet_aug(int    i_aug, int    j_aug)    { return  findSet_aug(i_aug)    ==  findSet_aug(j_aug);   }



   public  void    unionSet_aug(int  i_aug, int    j_aug)    

 {  

 if    (isSameSet_aug(i_aug,  j_aug)) 

   return;

    numSets_aug--;   

   int   x_aug    = findSet_aug(i_aug),    y_aug   = findSet_aug(j_aug);

  if(rank_aug[x_aug] >  rank_aug[y_aug]) {    p_aug[y_aug] =    x_aug;    setSize_aug[x_aug] +=  setSize_aug[y_aug];

 max_aug[x_aug]=Math_aug.max_aug(max_aug[x_aug],   max_aug[y_aug]);



   }

    else

 {    p_aug[x_aug] = y_aug;    setSize_aug[y_aug]  +=    setSize_aug[x_aug];

    if(rank_aug[x_aug] ==    rank_aug[y_aug])    rank_aug[y_aug]++; 

   max_aug[y_aug]=Math_aug.max_aug(max_aug[x_aug],max_aug[y_aug]);



 }    

   }



  private    int   getmax_aug(int j_aug)    {

  return  max_aug[findSet_aug(j_aug)];

  }



 public   int  numDisjointSets_aug() { return numSets_aug;   }



  public int  sizeOfSet_aug(int  i_aug)    {  return   setSize_aug[findSet_aug(i_aug)];   }

}











private   static   int   bs_aug(int i_aug)   {

 int   high_aug=n_aug-1;

    int   low_aug=i_aug;

    int    ans_aug=-1;

   int count_aug=1;

  while(high_aug>=low_aug)   {

  int mid_aug=(high_aug+low_aug)>>1;

 if(a_aug[mid_aug]-a_aug[i_aug]<=5)  {

 ans_aug=mid_aug;

  low_aug=mid_aug+1;

   count_aug=mid_aug-i_aug+1;

 }

   else    {

  high_aug=mid_aug-1;



  }

  }

  return   count_aug;





}







/**private  static void    trace_aug(int    i_aug,  int   time_aug)   {

if(i_aug==n_aug)  

 return;





long ans_aug=dp_aug(i_aug,time_aug);

if(time_aug+a_aug[i_aug].t_aug<a_aug[i_aug].burn_aug&&(ans_aug==dp_aug(i_aug+1,time_aug+a_aug[i_aug].t_aug)+a_aug[i_aug].cost_aug))   {



  trace_aug(i_aug+1,   time_aug+a_aug[i_aug].t_aug);



    l1_aug.add_aug(a_aug[i_aug].idx_aug);

 return;

}

 trace_aug(i_aug+1,time_aug);



}**/







    static   class    incpair_aug implements Comparable_aug<incpair_aug>

{

  int    a_aug;   long b_aug;

  int idx_aug;

 incpair_aug(int  a_aug,  long  dirg_aug,int i_aug)  {this.a_aug   = a_aug;   b_aug   =    dirg_aug;    idx_aug=i_aug;    }



   public    int compareTo_aug(incpair_aug    e_aug){   return   (int) (b_aug   - e_aug.b_aug);   }

}

   static  class    decpair_aug  implements   Comparable_aug<decpair_aug>

{

  int    a_aug;   long   b_aug;int   idx_aug;



   decpair_aug(int    a_aug, long  dirg_aug,int    i_aug)    {this.a_aug  =   a_aug; b_aug    =   dirg_aug;    idx_aug=i_aug;}



   public int  compareTo_aug(decpair_aug e_aug){    return    (int) (e_aug.b_aug- b_aug);   }

}



















   static    long    allpowers_aug[];

    static  class  Quad_aug    implements    Comparable_aug<Quad_aug>{

 int u_aug;

    int    v_aug;

    char   state_aug;

   int turns_aug;

  public  Quad_aug(int i_aug, int j_aug,  char    c_aug,   int    k_aug) {

   u_aug=i_aug;

  v_aug=j_aug;

   state_aug=c_aug;

 turns_aug=k_aug;

    }

    public    int    compareTo_aug(Quad_aug  e_aug){    return   (int) (turns_aug -   e_aug.turns_aug);   }



 }

   static   long dirg_aug[][];

  static    Edge_aug[]   driver_aug;



   static   int n_aug;

   static  class Edge_aug   implements  Comparable_aug<Edge_aug>

   {

    int node_aug;  long cost_aug;



  Edge_aug(int    a_aug,   long  dirg_aug)   { node_aug  =   a_aug;   cost_aug   =   dirg_aug;    }



 public   int   compareTo_aug(Edge_aug   e_aug){    return (int)  (cost_aug    - e_aug.cost_aug);    }

    }











  static   long    manhatandistance_aug(long    x_aug,long  x2_aug,long  y_aug,long  y2_aug)    {

  return   Math_aug.abs_aug(x_aug-x2_aug)+Math_aug.abs_aug(y_aug-y2_aug);

    }

   static long    fib_aug[];

 static  long  fib_aug(int   n_aug)   {

  if(n_aug==1||n_aug==0)   {

  return   1;

   }

  if(fib_aug[n_aug]!=-1) {

  return  fib_aug[n_aug];

    }

   else 

   return    fib_aug[n_aug]= ((fib_aug(n_aug-2)%mod_aug+fib_aug(n_aug-1)%mod_aug)%mod_aug);

   }

 static class Pair_aug  implements    Comparable_aug<Pair_aug>{

    long x_aug;

   long  y_aug;

  Pair_aug(long a_aug, long   b_aug){

  x_aug=a_aug;

   y_aug=b_aug;

  }

 public    int   compareTo_aug(Pair_aug p_aug)  {

 if(p_aug.y_aug!=this.y_aug)

   return (int)   (this.y_aug-p_aug.y_aug);

  else

  return    (int)    (this.x_aug-p_aug.x_aug);



   }











   }

  static   long[][]    comb_aug;  







static   class Triple_aug  implements   Comparable_aug<Triple_aug>{



int    t_aug;

int  burn_aug;

    int   cost_aug;

    int    idx_aug;

 public Triple_aug(int a_aug,int    b_aug,int  l_aug,int i_aug)  {

 t_aug=a_aug;

  burn_aug=b_aug;

   cost_aug=l_aug;

    idx_aug=i_aug;

   }

    @Override_aug

 public    int  compareTo_aug(Triple_aug  o_aug) {

 return   Long_aug.compare_aug( burn_aug,o_aug.burn_aug);   

 }



   }



  static  TreeSet_aug<Long_aug> primeFactors_aug(long N_aug)  // O(sqrt(N_aug)  /    ln sqrt(N_aug))

   {

 TreeSet_aug<Long_aug>  factors_aug   =   new  TreeSet_aug<Long_aug>(); //take abs_aug(N_aug)  in_aug  case    of -ve    integers

  int    idx_aug    =   0,  p_aug =    primes_aug.get_aug(idx_aug);



   while(p_aug  *    p_aug    <= N_aug)

 {

 while(N_aug   %    p_aug   ==  0)    {  factors_aug.add_aug((long)  p_aug);   N_aug    /=    p_aug; }

 if(primes_aug.size_aug()>idx_aug+1)

  p_aug    = primes_aug.get_aug(++idx_aug);

  else

  break;

  }



   if(N_aug  !=    1)   //    last prime factor   may    be  >  sqrt(N_aug)

  factors_aug.add_aug(N_aug);   // for    integers    whose  largest prime    factor    has   a_aug    power   of   1

    return    factors_aug;

  }



   static  boolean  visited_aug[];

    /**static    int    bfs(int    s_aug)

    {

    Queue<Integer_aug>  q_aug    =    new  LinkedList<Integer_aug>();

   q_aug.add_aug(s_aug);

   int    count_aug=0;

  int  maxcost=0;

   int  dist[]=new   int[n_aug];

    dist[s_aug]=0;

   while(!q_aug.isEmpty())

 {



   int u_aug    =   q_aug.remove();

   if(dist[u_aug]==k_aug)  {

 break;

    }

 for(Pair_aug  v_aug:   adj_aug[u_aug])

  {    

 maxcost=Math_aug.max_aug(maxcost, v_aug.cost_aug);







 if(!visited_aug[v_aug.v_aug])   {



   visited_aug[v_aug.v_aug]=true;

   q_aug.add_aug(v_aug.v_aug);

  dist[v_aug.v_aug]=dist[u_aug]+1;

   maxcost=Math_aug.max_aug(maxcost, v_aug.cost_aug);

   }

    }   



 }

    return maxcost;

 }**/

    public    static  boolean   FindAllElements_aug(int  n_aug,   int   k_aug)    {

    int   sum_aug    =   k_aug;  

  int[]    A_aug  =    new    int[k_aug]; 

   Arrays_aug.fill_aug(A_aug,   0,    k_aug,   1);  



    for  (int  i_aug  =    k_aug   -   1;    i_aug >=    0;    --i_aug)    {   



    while    (sum_aug  +  A_aug[i_aug]   <= n_aug)    {  



  sum_aug  += A_aug[i_aug];  

   A_aug[i_aug]    *= 2;  

 } 

   } 

  if(sum_aug==n_aug)  {

 return   true;

  }

   else

   return  false; 

  }



    static  long[][]    memo_aug;





   static   boolean  vis2_aug[][];



   static    class  SegmentTree_aug { //    1-based    DS, OOP



   int  N_aug;  //the   number of  elements  in_aug    the  array_aug   as   a_aug power   of    2 (i_aug.e_aug.   after   padding)

    int[]   array_aug,  sTree_aug,   lazy_aug;



  SegmentTree_aug(int[] in_aug)   

 {

    array_aug =  in_aug;  N_aug =   in_aug.length_aug    -  1;

 sTree_aug   =   new    int[N_aug<<1];   //no.   of    nodes  = 2*N_aug  - 1, we   add_aug  one    to  cross  out    index_aug    zero

  lazy_aug    =    new   int[N_aug<<1];

   build_aug(1,1,N_aug);

  }



 void    build_aug(int  node_aug,   int    b_aug,   int e_aug) // O(n_aug)

 {

 if(b_aug  ==   e_aug)    

  sTree_aug[node_aug] =  array_aug[b_aug];

  else    

 {

  int    mid_aug    =  b_aug  +  e_aug    >>    1;

    build_aug(node_aug<<1,b_aug,mid_aug);

  build_aug(node_aug<<1|1,mid_aug+1,e_aug);

  sTree_aug[node_aug]    =    sTree_aug[node_aug<<1]+sTree_aug[node_aug<<1|1];

    }

   }





 void   update_point_aug(int index_aug,    int val_aug)    //  O(log n_aug)

   {

    index_aug    +=    N_aug   -    1; 

   sTree_aug[index_aug]    +=  val_aug;   

    while(index_aug>1) 

    {

   index_aug >>=   1;

   sTree_aug[index_aug]    =  sTree_aug[index_aug<<1]    +    sTree_aug[index_aug<<1|1];    

 }

   }





    void  update_range_aug(int i_aug, int   j_aug,   int  val_aug) //  O(log  n_aug) 

  {

  update_range_aug(1,1,N_aug,i_aug,j_aug,val_aug);

  }



 void update_range_aug(int   node_aug,   int b_aug,   int  e_aug,    int i_aug, int    j_aug,  int val_aug)

    {

    if(i_aug >    e_aug  || j_aug   <  b_aug)    

  return;

   if(b_aug >=    i_aug   &&   e_aug  <= j_aug) 

    {

    sTree_aug[node_aug]   += (e_aug-b_aug+1)*val_aug;  

 lazy_aug[node_aug]    +=   val_aug; 

   } 

   else    

    {

  int   mid_aug   =    b_aug +    e_aug    >> 1;

  propagate_aug(node_aug,    b_aug, mid_aug, e_aug);

   update_range_aug(node_aug<<1,b_aug,mid_aug,i_aug,j_aug,val_aug);

   update_range_aug(node_aug<<1|1,mid_aug+1,e_aug,i_aug,j_aug,val_aug);

 sTree_aug[node_aug]    =    sTree_aug[node_aug<<1]   +  sTree_aug[node_aug<<1|1];  

  }



  }

 void   propagate_aug(int    node_aug, int    b_aug, int  mid_aug,   int   e_aug)  

    {

  lazy_aug[node_aug<<1] += lazy_aug[node_aug];

   lazy_aug[node_aug<<1|1]  +=   lazy_aug[node_aug];

   sTree_aug[node_aug<<1]    +=   (mid_aug-b_aug+1)*lazy_aug[node_aug];  

 sTree_aug[node_aug<<1|1] += (e_aug-mid_aug)*lazy_aug[node_aug];   

    lazy_aug[node_aug] =    0;

 }



  int  query_aug(int  i_aug,    int   j_aug)

  {

  return query_aug(1,1,N_aug,i_aug,j_aug);

    }



 int    query_aug(int node_aug,    int  b_aug,    int e_aug,  int   i_aug,  int j_aug) //   O(log n_aug)

    {

    if(i_aug>e_aug ||   j_aug   <b_aug)

  return   0; 

    if(b_aug>=  i_aug &&  e_aug   <=    j_aug)

  return sTree_aug[node_aug];

 int  mid_aug    =    b_aug  +   e_aug    >>    1;

 propagate_aug(node_aug,   b_aug,   mid_aug, e_aug);

   int  q1_aug  =   query_aug(node_aug<<1,b_aug,mid_aug,i_aug,j_aug);

 int q2_aug    = query_aug(node_aug<<1|1,mid_aug+1,e_aug,i_aug,j_aug);

    return q1_aug +   q2_aug;    



  }



  }

   static boolean    f2_aug=false;

   static   long[][]   matMul_aug(long[][]  a2_aug,    long[][]  b_aug,  int    p_aug, int    q_aug,   int r_aug)  //C_aug(p_aug  x_aug   r_aug)  =   A_aug(p_aug    x_aug   q_aug)   x_aug  (q_aug x_aug    r_aug)   -- O(p_aug  x_aug q_aug x_aug    r_aug)

 {

  long[][]    C_aug = new    long[p_aug][r_aug];

 for(int  i_aug = 0;   i_aug    <   p_aug; ++i_aug)    {

  for(int j_aug    =    0; j_aug <   r_aug;   ++j_aug)    {

   for(int   k_aug    =  0;   k_aug  < q_aug;    ++k_aug)    {

 C_aug[i_aug][j_aug] =   (C_aug[i_aug][j_aug]+(a2_aug[i_aug][k_aug]%mod_aug * b_aug[k_aug][j_aug]%mod_aug))%mod_aug;

    C_aug[i_aug][j_aug]%=mod_aug;

 }



  }

   }

  return   C_aug;

   }





















 static   ArrayList_aug<Pair_aug>    a1_aug[];

    static    int  memo1_aug[];



    static    boolean   vis_aug[];

  static TreeSet_aug<Integer_aug>   set_aug=new TreeSet_aug<Integer_aug>();



 static long modPow_aug(long  ways_aug,    long  count_aug,  long    mod_aug)    //    O(log e_aug)

    {

    ways_aug  %=  mod_aug;

    long   res_aug   =   1;

    while(count_aug    >  0)

  {

   if((count_aug    & 1) ==    1)

 res_aug  =    (res_aug   * ways_aug)  %   mod_aug;

    ways_aug =    (ways_aug  *  ways_aug)  % mod_aug;

   count_aug   >>=    1;

    }

 return res_aug%mod_aug;

   }









  static   long gcd_aug(long  ans_aug,long  b_aug)   {

 if(b_aug==0)   {

  return    ans_aug;

    }

 return    gcd_aug(b_aug,ans_aug%b_aug);

    }

    static int[]   isComposite_aug;

   static    int[] valid_aug;



    static   ArrayList_aug<Integer_aug>  primes_aug;

  static  ArrayList_aug<Integer_aug> l_aug;

  static  void   sieve_aug(int   N_aug) //  O(N_aug    log  log  N_aug) 

   {

 isComposite_aug   = new   int[N_aug+1];   

    isComposite_aug[0]  =    isComposite_aug[1] =    1; //    0  indicates    a_aug   prime  number

    primes_aug    =  new  ArrayList_aug<Integer_aug>();

    l_aug=new   ArrayList_aug<>();

    valid_aug=new int[N_aug+1];

  for   (int i_aug   =    2;   i_aug    <=    N_aug;   ++i_aug)   //can  loop  till    i_aug*i_aug <=   N_aug   if primes_aug    array_aug    is   not  needed   O(N_aug log   log    sqrt(N_aug))    

   if    (isComposite_aug[i_aug]  ==  0)   //can loop   in_aug   2 and   odd_aug   integers   for    slightly  better  performance

 {

   primes_aug.add_aug(i_aug);

  l_aug.add_aug(i_aug);

   valid_aug[i_aug]=1;



 for   (int    j_aug  = i_aug*2; j_aug  <=N_aug; j_aug +=i_aug)    {    //  j_aug =   i_aug *   2 will    not    affect performance too    much,    may alter   in_aug  modified    sieve_aug

   isComposite_aug[j_aug]  = 1;









   }

   }



 for(int i_aug=0   ;  i_aug<primes_aug.size_aug()  ;  i_aug++)    {

 for(int j_aug:primes_aug)    {

   if(primes_aug.get_aug(i_aug)*j_aug>N_aug)   {

 break;

   }

    valid_aug[primes_aug.get_aug(i_aug)*j_aug]=1;

 }

 }

  }



    public static    long[]    schuffle_aug(long[]  a2_aug)  {

  for   (int   i_aug   =    0;  i_aug  <    a2_aug.length_aug; i_aug++)    {

    int x_aug=(int)(Math_aug.random_aug()*a2_aug.length_aug);

    long    temp_aug=a2_aug[x_aug];

 a2_aug[x_aug]=a2_aug[i_aug];

   a2_aug[i_aug]=temp_aug;

  }

  return   a2_aug;

 }

  static int  V_aug;

  static long    INF_aug=(long)    1E16;



    static   class  Edge2_aug  

  {

   int node_aug;

   long cost_aug;

  long    next_aug;

    Edge2_aug(int a_aug,  int  c_aug,Long_aug    long1_aug)    { node_aug =   a_aug;  cost_aug =  long1_aug;   next_aug=c_aug;}



    }

static class    Scanner_aug   {

  StringTokenizer_aug   st_aug;

    BufferedReader_aug  br_aug;



   public  Scanner_aug(InputStream_aug    system_aug)   {

  br_aug  =   new   BufferedReader_aug(new    InputStreamReader_aug(system_aug));

    }



 public Scanner_aug(String_aug    file_aug)    throws  Exception_aug  {

 br_aug   =   new  BufferedReader_aug(new  FileReader_aug(file_aug));

   }



 public   String_aug   next_aug()    throws   IOException_aug    {

    while  (st_aug  ==   null    ||  !st_aug.hasMoreTokens_aug())

   st_aug   =   new   StringTokenizer_aug(br_aug.readLine_aug());

 return   st_aug.nextToken_aug();

  }



 public String_aug nextLine_aug()  throws   IOException_aug  {

  return   br_aug.readLine_aug();

 }



   public int   nextInt_aug()    throws IOException_aug   {

 return  Integer_aug.parseInt_aug(next_aug());

  }



   public    double  nextDouble_aug()    throws  IOException_aug {

 return   Double_aug.parseDouble_aug(next_aug());

  }



 public  char  nextChar_aug()  throws   IOException_aug    {

    return  next_aug().charAt_aug(0);

 }



    public   Long_aug    nextLong_aug()   throws  IOException_aug    {

    return Long_aug.parseLong_aug(next_aug());

    }



  public   boolean    ready_aug()  throws    IOException_aug  {

  return   br_aug.ready_aug();

  }



    public void   waitForInput_aug() throws   InterruptedException_aug    {

   Thread_aug.sleep_aug(3000);

   }

 }   

}