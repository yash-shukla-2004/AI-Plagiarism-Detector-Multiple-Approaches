//package    com.company;

import  java_aug.io_aug.*;

import   java_aug.util_aug.*;



public class   Main_aug   {

 public   static   class Task_aug  {

 boolean    insertVector_aug(int[]   base_aug,   int    vector_aug) {

  for   (int  i_aug    =   0;    i_aug    <   5; i_aug++) {

   if    ((vector_aug  &    (1    <<  i_aug))    ==    0)  continue;

 if    ((base_aug[i_aug] &  (1   << i_aug))  ==    0)   {

  base_aug[i_aug]    =  vector_aug;

  for  (int   j_aug =    i_aug    +    1;   j_aug    <   5; j_aug++)  if    (base_aug[j_aug]  >   0   &&  (base_aug[i_aug]   &  (1  <<    j_aug))  != 0) {

 base_aug[i_aug]    ^=   base_aug[j_aug];

  }

   for   (int   j_aug  = i_aug  -   1;  j_aug   >=    0; j_aug--)    if  ((base_aug[j_aug]    & (1 <<  i_aug)) !=  0)   {

    base_aug[j_aug] ^=  base_aug[i_aug];

 }

   return  true;

  }

   vector_aug ^=    base_aug[i_aug];

   }

   return    false;

  }



    public   class    ArrayHash_aug {

    int[]  array_aug;



    public    ArrayHash_aug(int[]  array_aug) {

  this.array_aug   =  Arrays_aug.copyOf_aug(array_aug, array_aug.length_aug);

  }



  @Override_aug

 public  boolean   equals_aug(Object_aug    o_aug) {

 if   (this == o_aug)  return   true;

    if   (o_aug    ==  null  ||   getClass_aug()  !=  o_aug.getClass_aug())  return false;

  ArrayHash_aug arrayHash_aug  =   (ArrayHash_aug) o_aug;

  return Arrays_aug.equals_aug(array_aug,  arrayHash_aug.array_aug);

 }



  @Override_aug

   public   int    hashCode_aug()    {

  return Arrays_aug.hashCode_aug(array_aug);

   }

 }



    public  class  DisjointSet_aug   {

 int[]   arr_aug;

 public    DisjointSet_aug(int  n_aug)   {

 arr_aug   = new int[n_aug];

   Arrays_aug.fill_aug(arr_aug, -1);

  }

 int   find_aug(int  x_aug)   {

   if   (arr_aug[x_aug] < 0)   return x_aug;

 return   arr_aug[x_aug]   =  find_aug(arr_aug[x_aug]);

   }

 boolean union_aug(int   a_aug,  int b_aug) {

  int   ra_aug    =  find_aug(a_aug),    rb_aug   =   find_aug(b_aug);

    if (ra_aug   ==  rb_aug)    return    false;

    arr_aug[ra_aug]   =  rb_aug;

    return    true;

    }

 }



  public  class Pair_aug {

 int a_aug,  b_aug;

  public   Pair_aug(int   a_aug,  int   b_aug)    {

    this.a_aug    =  a_aug;

  this.b_aug =   b_aug;

   }

    }



  public    class Triple_aug    {

   int    a_aug,   b_aug,  c_aug;

 public   Triple_aug(int  a_aug,  int  b_aug,  int   c_aug)    {

 this.a_aug  =  a_aug;

   this.b_aug   =   b_aug;

 this.c_aug  = c_aug;

    }

    public Triple_aug(int[]  z_aug)   {

 this.a_aug =  z_aug[0];

   this.b_aug   =    z_aug[1];

  this.c_aug =   z_aug[2];

  }

    }

  int  S_aug    =  374;



  int[] xorValues_aug;

   int[] root_aug;

   int[]    parent_aug;

   int[][]    inputEdges_aug;

 int[][]  dpVal_aug;

 boolean[]    off_aug;

    List_aug<Triple_aug>  additionalEdges_aug;

 List_aug<Pair_aug>[]   treeEdges_aug;

    List_aug<Integer_aug>[]  treeBasis_aug;

    int[]  treeBasisIndex_aug;

    Map_aug<ArrayHash_aug,    Integer_aug>    basisToIndex_aug;

 List_aug<ArrayHash_aug> indexToBasis_aug;

   int[][] basisTransition_aug  =  new int[S_aug][S_aug];



 void   dfs_aug(int u_aug,  int    p_aug, int r_aug,    int   val_aug)    {

    root_aug[u_aug]   = r_aug;

    parent_aug[u_aug]   =    p_aug;

   xorValues_aug[u_aug]  =  val_aug;

  for   (Pair_aug    v_aug:    treeEdges_aug[u_aug])   if  (v_aug.a_aug !=  p_aug)   {

    dfs_aug(v_aug.a_aug, u_aug,    r_aug,    val_aug  ^ v_aug.b_aug);

   }

   }

    int mod_aug =   1_000_000_007;

   int add_aug(int    a_aug, int  b_aug)    {

  int    c_aug  = a_aug   +   b_aug;

 if  (c_aug    >=   mod_aug)  return   c_aug    -    mod_aug;

  return   c_aug;

    }



  int   getIndexOfBasis_aug(int[]   basis_aug)  {

 ArrayHash_aug    ar_aug  =   new  ArrayHash_aug(basis_aug);

   if    (!basisToIndex_aug.containsKey_aug(ar_aug))   {

  basisToIndex_aug.put_aug(ar_aug,  basisToIndex_aug.size_aug());

 indexToBasis_aug.add_aug(ar_aug);

 }

   if    (basisToIndex_aug.size_aug()  >  S_aug)  throw   new   RuntimeException_aug();

   return    basisToIndex_aug.get_aug(ar_aug);

   }



  int    merge_aug(int  basisIndex1_aug,  int  basisIndex2_aug)    {

 if   (basisTransition_aug[basisIndex1_aug][basisIndex2_aug]    == -2)  {

   int[]   basis1_aug    =    Arrays_aug.copyOf_aug(indexToBasis_aug.get_aug(basisIndex1_aug).array_aug,    5);

    int[]    basis2_aug    =  Arrays_aug.copyOf_aug(indexToBasis_aug.get_aug(basisIndex2_aug).array_aug,  5);

    boolean valid_aug   =  true;

 for (int   b_aug  : basis2_aug)  {

  if   (b_aug != 0) {

    if (!insertVector_aug(basis1_aug,    b_aug)) {

 valid_aug =  false;

   }

   }

    }

  if    (valid_aug)   {

  basisTransition_aug[basisIndex1_aug][basisIndex2_aug]   =  basisTransition_aug[basisIndex2_aug][basisIndex1_aug] =  getIndexOfBasis_aug(basis1_aug);

    }  else   {

  basisTransition_aug[basisIndex1_aug][basisIndex2_aug]    =    basisTransition_aug[basisIndex2_aug][basisIndex1_aug] =  -1;

   }

    }

 return basisTransition_aug[basisIndex1_aug][basisIndex2_aug];

 }



  public    void    solve_aug(Scanner_aug   sc_aug,    PrintWriter_aug  pw_aug)   throws  IOException_aug  {

   for  (int    i_aug   =   0;    i_aug  < S_aug;  i_aug++)    {

 Arrays_aug.fill_aug(basisTransition_aug[i_aug], -2);

    }

   basisToIndex_aug   =   new   HashMap_aug<>();

 indexToBasis_aug = new  ArrayList_aug<>();

  int  n_aug  =   sc_aug.nextInt_aug();

    int    m_aug    =   sc_aug.nextInt_aug();

  xorValues_aug   = new int[n_aug];

    root_aug =  new  int[n_aug];

 parent_aug    =   new    int[n_aug];

    off_aug  = new    boolean[n_aug];

   Arrays_aug.fill_aug(off_aug, true);

   treeEdges_aug =    new   List_aug[n_aug];

 additionalEdges_aug    =   new   ArrayList_aug<>();

   treeBasis_aug   =    new    List_aug[n_aug];

  treeBasisIndex_aug    =   new int[n_aug];

    getIndexOfBasis_aug(new  int[5]);

    DisjointSet_aug djs_aug    =    new DisjointSet_aug(n_aug);

   for    (int    i_aug   = 0;    i_aug < n_aug; i_aug++)   {

  treeEdges_aug[i_aug]   =  new ArrayList_aug<>();

  treeBasis_aug[i_aug]    =  new ArrayList_aug<>();

  }

    inputEdges_aug =  new  int[m_aug][3];

  for    (int   i_aug = 0; i_aug    < m_aug; i_aug++)   {

    for  (int j_aug  =    0;   j_aug   <    3;  j_aug++)    {

  inputEdges_aug[i_aug][j_aug]  =  sc_aug.nextInt_aug();

 }

    }

   for    (int    i_aug  =    0;  i_aug   < m_aug;  i_aug++) {

  inputEdges_aug[i_aug][0]--;

    inputEdges_aug[i_aug][1]--;

    if (inputEdges_aug[i_aug][0]   ==    0   ||    inputEdges_aug[i_aug][1] ==  0)   {

  djs_aug.union_aug(inputEdges_aug[i_aug][0], inputEdges_aug[i_aug][1]);

  treeEdges_aug[inputEdges_aug[i_aug][0]].add_aug(new  Pair_aug(inputEdges_aug[i_aug][1],    inputEdges_aug[i_aug][2]));

 treeEdges_aug[inputEdges_aug[i_aug][1]].add_aug(new Pair_aug(inputEdges_aug[i_aug][0],    inputEdges_aug[i_aug][2]));

    }

    }

    for (int  i_aug   = 0;  i_aug <    m_aug; i_aug++)   {

 if  (inputEdges_aug[i_aug][0] != 0   &&   inputEdges_aug[i_aug][1]  !=  0)  {

   if (djs_aug.union_aug(inputEdges_aug[i_aug][0], inputEdges_aug[i_aug][1]))  {

  treeEdges_aug[inputEdges_aug[i_aug][0]].add_aug(new    Pair_aug(inputEdges_aug[i_aug][1],   inputEdges_aug[i_aug][2]));

   treeEdges_aug[inputEdges_aug[i_aug][1]].add_aug(new    Pair_aug(inputEdges_aug[i_aug][0],   inputEdges_aug[i_aug][2]));

 } else   {

 additionalEdges_aug.add_aug(new    Triple_aug(inputEdges_aug[i_aug]));

    }

    }

   }

  for (Pair_aug  p_aug:   treeEdges_aug[0])   {

   off_aug[p_aug.a_aug]  = false;

 dfs_aug(p_aug.a_aug, 0,    p_aug.a_aug, p_aug.b_aug);

  }

 List_aug<Triple_aug>  pairedTrees_aug  = new    ArrayList_aug<>();



 for (Triple_aug    tri_aug:   additionalEdges_aug)   {

  int  a_aug  = tri_aug.a_aug;

    int  b_aug  = tri_aug.b_aug;

 if   (root_aug[a_aug]    !=   root_aug[b_aug])   {

    if  (a_aug    !=   root_aug[a_aug]  ||   b_aug    !=  root_aug[b_aug])  throw  new    RuntimeException_aug();

    pairedTrees_aug.add_aug(tri_aug);

  // across

 }   else {

 int    cycle_aug =   tri_aug.c_aug   ^    xorValues_aug[a_aug]    ^    xorValues_aug[b_aug];

  treeBasis_aug[root_aug[a_aug]].add_aug(cycle_aug);

   }

 }

    List_aug<List_aug<Integer_aug>>  choicesForTree_aug    = new  ArrayList_aug<>();

 for (int  i_aug  =   1;   i_aug <   n_aug;   i_aug++)   if (root_aug[i_aug]   ==  i_aug)    {

    int[]    basis_aug  =  new    int[5];

    for   (int  cycle_aug:    treeBasis_aug[i_aug])    {

   if  (!insertVector_aug(basis_aug,   cycle_aug)) {

   off_aug[i_aug]   = true;

   }

    }

 if (!off_aug[i_aug])   {

  treeBasisIndex_aug[i_aug]   =  getIndexOfBasis_aug(basis_aug);

 }

    }

  for    (Triple_aug   p_aug:    pairedTrees_aug)  {

  if  (off_aug[p_aug.a_aug]  ||   off_aug[p_aug.b_aug]) {

  off_aug[p_aug.a_aug]    =   off_aug[p_aug.b_aug] =    true;

  continue;

 }

   off_aug[p_aug.a_aug]    =  true;

 off_aug[p_aug.b_aug]    = true;

 int   nr_aug;

  if   ((nr_aug =   merge_aug(treeBasisIndex_aug[p_aug.a_aug],    treeBasisIndex_aug[p_aug.b_aug]))  !=    -1)  {

  List_aug<Integer_aug>  choices_aug   = new  ArrayList_aug<>();

    int[]    basis_aug  =   Arrays_aug.copyOf_aug(indexToBasis_aug.get_aug(nr_aug).array_aug,   5);

 choices_aug.add_aug(nr_aug);

 choices_aug.add_aug(nr_aug);

    if  (insertVector_aug(basis_aug,  p_aug.c_aug  ^  xorValues_aug[p_aug.a_aug]    ^  xorValues_aug[p_aug.b_aug])) {

 choices_aug.add_aug(getIndexOfBasis_aug(basis_aug));

    }

   choicesForTree_aug.add_aug(choices_aug);

   }

 }

    for    (int  i_aug   =  1;  i_aug <    n_aug;  i_aug++)  if  (root_aug[i_aug]   ==  i_aug   &&   !off_aug[i_aug])  {

 List_aug<Integer_aug>  choice_aug =    new ArrayList_aug<>();

 choice_aug.add_aug(treeBasisIndex_aug[i_aug]);

   choicesForTree_aug.add_aug(choice_aug);

   }

    dpVal_aug =    new   int[2][S_aug];   //   \sum_{i_aug=0}^5  {5    \choose    i_aug}_2

    dpVal_aug[0][0]    =  1;

   int   cur_aug   =   0, next_aug = 1;

   for (List_aug<Integer_aug> choices_aug:   choicesForTree_aug)   {

    System.arraycopy_aug(dpVal_aug[cur_aug],   0,   dpVal_aug[next_aug],    0,  S_aug);

    for  (int choice_aug:  choices_aug)    {

  for (int   i_aug  = 0; i_aug   <  S_aug;  i_aug++)  if (dpVal_aug[cur_aug][i_aug]  >   0)    {

  int  nr_aug;

 if    ((nr_aug  =    merge_aug(i_aug,   choice_aug))   !=  -1)  {

 dpVal_aug[next_aug][nr_aug]    =  add_aug(dpVal_aug[next_aug][nr_aug],  dpVal_aug[cur_aug][i_aug]);

    }

    }

 }

  cur_aug   ^=  1;

   next_aug  ^=    1;

   }

   int  total_aug  =  0;

   for (int  i_aug  =  0;   i_aug   <   S_aug;    i_aug++) total_aug  = add_aug(total_aug,    dpVal_aug[cur_aug][i_aug]);

 pw_aug.println(total_aug);

  }

 }

   static    long  TIME_START_aug,    TIME_END_aug;

  public   static void main(String_aug[]   args_aug)    throws   IOException_aug  {

    Scanner_aug sc_aug   = new Scanner_aug(System.in_aug);

//   Scanner_aug    sc_aug    =   new Scanner_aug(new  FileInputStream("input"));

 PrintWriter_aug    pw_aug    =    new   PrintWriter_aug(new    BufferedOutputStream_aug(System.out));

//    PrintWriter_aug   pw_aug  =   new    PrintWriter_aug(new  FileOutputStream("input"));



  Runtime_aug   runtime_aug   = Runtime_aug.getRuntime_aug();

    long   usedMemoryBefore_aug  = runtime_aug.totalMemory_aug()    -  runtime_aug.freeMemory_aug();

  TIME_START_aug =    System.currentTimeMillis_aug();

    Task_aug  t_aug   =  new   Task_aug();

    t_aug.solve_aug(sc_aug,  pw_aug);

  TIME_END_aug =  System.currentTimeMillis_aug();

 long    usedMemoryAfter_aug   =   runtime_aug.totalMemory_aug()    -   runtime_aug.freeMemory_aug();

   pw_aug.close_aug();

  System.err_aug.println("Memory   increased: "    + (usedMemoryAfter_aug  -    usedMemoryBefore_aug)   /  1000000);

  System.err_aug.println("Time used:    " + (TIME_END_aug   -  TIME_START_aug) +   ".");

 }

    static    class Scanner_aug  {

  StringTokenizer_aug  st_aug;

 BufferedReader_aug br_aug;

 public  Scanner_aug(InputStream_aug s_aug)    {

    br_aug    =  new  BufferedReader_aug(new InputStreamReader_aug(s_aug));

  }

    public   Scanner_aug(FileReader_aug  s_aug)    throws   FileNotFoundException_aug    {

    br_aug =   new  BufferedReader_aug(s_aug);

    }

  public   String_aug next_aug() throws    IOException_aug    {

    while  (st_aug == null ||  !st_aug.hasMoreTokens_aug())

 st_aug    =   new  StringTokenizer_aug(br_aug.readLine_aug());

  return    st_aug.nextToken_aug();

   }

 public  int  nextInt_aug()  throws   IOException_aug {

 return   Integer_aug.parseInt_aug(next_aug());

  }

    public  long    nextLong_aug()  throws IOException_aug    {

   return    Long_aug.parseLong_aug(next_aug());

 }

   public String_aug nextLine_aug()  throws    IOException_aug {

  return br_aug.readLine_aug();

 }

    public double nextDouble_aug()   throws   IOException_aug    {

  return    Double_aug.parseDouble_aug(next_aug());

    }

   public    boolean  ready_aug() throws IOException_aug  {

 return   br_aug.ready_aug();

   }

    }

}