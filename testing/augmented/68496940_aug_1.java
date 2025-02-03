import   java_aug.util_aug.Scanner_aug;

import   java_aug.util_aug.HashSet_aug;

import  java_aug.util_aug.ArrayList_aug;



public    class Main_aug  {



   static    int[]   c_aug;

  static   HashSet_aug<Integer_aug>[]  graph_aug;

 static int[]   res_aug;

 static   ArrayList_aug<Integer_aug>  v_aug;

   static    int[]   allSubNodes_aug;



  public  static    void   main(String_aug[]   args_aug) {

    Scanner_aug  sc_aug   =    new    Scanner_aug(System.in_aug);

   int  n_aug    =   sc_aug.nextInt_aug();



 c_aug = new int[n_aug   +  1];

 int root_aug   = 0;



   v_aug  =    new ArrayList_aug<>();



  graph_aug =  new HashSet_aug[n_aug   +   1];

 for (int   i_aug  = 1;  i_aug    <=    n_aug;   ++i_aug)

 graph_aug[i_aug]    = new   HashSet_aug<Integer_aug>();

    allSubNodes_aug  =   new   int[n_aug +  1];



   for    (int i_aug    =  1;   i_aug   <=    n_aug;    ++i_aug)  {

 v_aug.add_aug(i_aug);



  int    pi_aug   =    sc_aug.nextInt_aug();

 int    ci_aug   =  sc_aug.nextInt_aug();



    if    (pi_aug    ==    0)

  root_aug  =    i_aug;

    else

    graph_aug[pi_aug].add_aug(i_aug);

   c_aug[i_aug]  =    ci_aug;

   }



   getAllSubNodes_aug(root_aug);



  for    (int i_aug =    1;   i_aug    <=    n_aug;  ++i_aug)  {

 if    (allSubNodes_aug[i_aug]    <    c_aug[i_aug])  {

   System.out.println("NO");

 System.exit_aug(0);

    }

 }



 System.out.println("YES");



   res_aug = new    int[n_aug    +    1];



   dfs_aug(root_aug);



  for (int  i_aug   =   1;   i_aug <=    n_aug;   ++i_aug)

    System.out.print_aug(res_aug[i_aug]    + "    ");

 System.out.println();

  }



    public  static   void  getAllSubNodes_aug(int node_aug)    {

    if   (graph_aug[node_aug].size_aug()  ==   0)    {

   allSubNodes_aug[node_aug]    =  0;

  return;

   }



    for    (int subNode_aug    :   graph_aug[node_aug]) {

    getAllSubNodes_aug(subNode_aug);

   allSubNodes_aug[node_aug]    +=  allSubNodes_aug[subNode_aug]    +  1;

   }

   }



 public   static  void   dfs_aug(int  node_aug)   {

   res_aug[node_aug] =   v_aug.remove_aug(c_aug[node_aug]);

   for    (int  subNode_aug : graph_aug[node_aug])

 dfs_aug(subNode_aug);

 }

}