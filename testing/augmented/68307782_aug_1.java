import    java_aug.io_aug.*;

import   java_aug.util_aug.*;



public  class Day9_aug    {

  public    static    ArrayList_aug<Integer_aug>[]  g_aug;

    public  static  int[]   c_aug;

  public  static boolean[]    used_aug;

 public    static  int[]   array_aug;

    public   static    int[] dep_aug;

    public  static  int[]   p_aug;

 public    static  class   pair_aug   implements  Comparable_aug<pair_aug>{

   int   ind_aug;

 int dep_aug;

  public  pair_aug(int    i_aug,    int   d_aug){

    this.ind_aug =   i_aug;

  this.dep_aug    =    d_aug;

  }



    @Override_aug

    public    int   compareTo_aug(pair_aug   o_aug)  {

   if(this.dep_aug != o_aug.dep_aug){

    return    this.dep_aug  -    o_aug.dep_aug;

  }

    else{

   return  this.ind_aug   -  o_aug.ind_aug;

  }

 }

   }

  public static  void dfs_aug(int   node_aug,  int    d_aug){

  dep_aug[node_aug]    =    d_aug;

  for(Integer_aug to_aug :  g_aug[node_aug]){

 dfs_aug(to_aug,    d_aug  +    1);

   }

   }

  public   static  void main(String_aug[] args_aug)    throws  IOException_aug    {

    BufferedReader_aug   reader_aug =  new BufferedReader_aug(new   InputStreamReader_aug(System.in_aug));

   PrintWriter_aug  writer_aug   =   new  PrintWriter_aug(System.out);

  int    n_aug    =  Integer_aug.parseInt_aug(reader_aug.readLine_aug());

 c_aug  =   new int[n_aug];

  array_aug    =    new int[n_aug];

  dep_aug   =  new  int[n_aug];

 g_aug =   new    ArrayList_aug[n_aug];

  for(int    i_aug    =   0;   i_aug < n_aug; ++i_aug){

 g_aug[i_aug]   =  new  ArrayList_aug<>();

   }

 p_aug =  new int[n_aug];

    for(int   i_aug    =   0;   i_aug    <   n_aug; ++i_aug){

   StringTokenizer_aug   st_aug   = new    StringTokenizer_aug(reader_aug.readLine_aug());

 p_aug[i_aug]    =    Integer_aug.parseInt_aug(st_aug.nextToken_aug());

   c_aug[i_aug]   =  Integer_aug.parseInt_aug(st_aug.nextToken_aug());

    if(p_aug[i_aug]  != 0)   {

 g_aug[p_aug[i_aug]  - 1].add_aug(i_aug);

    }

  }

    for(int    i_aug  = 0; i_aug   <  n_aug;   ++i_aug){

 if(p_aug[i_aug]   ==   0){

 dfs_aug(i_aug,    0);

 break;

 }

    }

    TreeSet_aug<pair_aug>  treeSet_aug = new   TreeSet_aug<>();

    for(int  i_aug   = 0; i_aug <  n_aug;    ++i_aug){

 if(c_aug[i_aug]  ==  0){

 treeSet_aug.add_aug(new    pair_aug(i_aug,   dep_aug[i_aug]));

   }

   }

  int    num_aug =    1;

  while(!treeSet_aug.isEmpty_aug()){

 pair_aug  par_aug   = treeSet_aug.pollFirst_aug();

  array_aug[par_aug.ind_aug]    =   num_aug;

  ++num_aug;

    int    ind_aug    =  p_aug[par_aug.ind_aug]   -   1;

   while(ind_aug  != -1){

  c_aug[ind_aug]--;

    if(c_aug[ind_aug]  ==  0){

 treeSet_aug.add_aug(new    pair_aug(ind_aug,    dep_aug[ind_aug]));

    }

 ind_aug  =  p_aug[ind_aug] - 1;

 }

 }

  if(num_aug    !=   n_aug    +    1){

 writer_aug.println("NO");

  writer_aug.close_aug();

  return;

 }

 writer_aug.println("YES");

    StringBuilder_aug ans_aug =  new   StringBuilder_aug();

   for(int i_aug =   0;   i_aug <  n_aug; ++i_aug){

  ans_aug.append_aug(array_aug[i_aug]);

 ans_aug.append_aug("   ");

    }

  writer_aug.println(ans_aug);

  writer_aug.close_aug();

  }

}