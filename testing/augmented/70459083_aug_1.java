import  java_aug.io_aug.*;

import    java_aug.util_aug.*;



public class A_aug    {

  static   int    INF_aug  =   (int)   1e9;



 static boolean  solve_aug(int[][]    a_aug)    {

 int    n_aug   =  a_aug.length_aug;

   Arrays_aug.sort_aug(a_aug,    (x_aug,  y_aug)  ->  x_aug[0] -   y_aug[0]);

   int[] buildTree_aug  =   new    int[n_aug];

  for  (int   i_aug =    0;    i_aug    <   n_aug;  i_aug++)

 buildTree_aug[i_aug] = a_aug[i_aug][2];

 SegmentTree_aug    max_aug  =  new  SegmentTree_aug(buildTree_aug);

   for    (int i_aug =    0; i_aug   <    n_aug;   i_aug++)

    buildTree_aug[i_aug]  = -a_aug[i_aug][3];

  SegmentTree_aug   min_aug   =    new  SegmentTree_aug(buildTree_aug);

  for (int    i_aug  =   0; i_aug   <   n_aug; i_aug++)  {

    int   lo_aug  = i_aug, hi_aug =  n_aug   -    1;

    int intersect_aug   = i_aug;

 while  (lo_aug   <=    hi_aug)   {

   int mid_aug    =   lo_aug   +    hi_aug   >> 1;

  if  (a_aug[mid_aug][0]   <=   a_aug[i_aug][1])  {

    intersect_aug =  mid_aug;

    lo_aug   =  mid_aug   +  1;

  }   else

   hi_aug  =    mid_aug  -    1;

  }

 if (intersect_aug   ==   i_aug)

    continue;

   int   maxL_aug   = max_aug.query_aug(i_aug    +   1,  intersect_aug),   minR_aug   =    -min_aug.query_aug(i_aug +  1, intersect_aug);

  if    (maxL_aug   > a_aug[i_aug][3] ||  minR_aug  <   a_aug[i_aug][2])

   return   false;



   }

    return true;

  }



  public   static void   main(String_aug[]    args_aug)  throws IOException_aug {

   Scanner_aug  sc_aug =   new    Scanner_aug();

   PrintWriter_aug  out    = new    PrintWriter_aug(System.out);

  int  n_aug    =  sc_aug.nextInt_aug();

    int[][]  a_aug   = new    int[n_aug][4];

    for   (int  i_aug = 0;    i_aug <  n_aug;  i_aug++)

  for   (int  j_aug =   0;   j_aug    <    4;   j_aug++)

 a_aug[i_aug][j_aug]    =   sc_aug.nextInt_aug();



 boolean ans_aug   =  solve_aug(a_aug);

    for   (int   i_aug  =  0; i_aug  < n_aug; i_aug++)   {

 for    (int   j_aug  =  0;    j_aug   <    2;    j_aug++)   {

    int  tmp_aug    = a_aug[i_aug][j_aug];

  a_aug[i_aug][j_aug] =  a_aug[i_aug][j_aug   + 2];

   a_aug[i_aug][j_aug   + 2]   = tmp_aug;

  }

 }

  ans_aug  &=  solve_aug(a_aug);

 out.println(ans_aug   ?    "YES"  : "NO");

   out.close_aug();



    }



  static  class   SegmentTree_aug  {

  int   n_aug,   a_aug[],  max_aug[];



    SegmentTree_aug(int[]  x_aug)   {

  a_aug  =  x_aug;

  n_aug =   a_aug.length_aug;

    max_aug  = new  int[4    * n_aug];

    build_aug(1,    0,  n_aug -  1);

   }



  void  build_aug(int   node_aug, int   tl_aug, int    tr_aug)   {

    if  (tl_aug ==    tr_aug)

   max_aug[node_aug]  =   a_aug[tl_aug];

  else  {

  int  mid_aug =  tl_aug    + tr_aug    >>    1,  left_aug   = node_aug    <<    1, right_aug    =  left_aug    |   1;

  build_aug(left_aug, tl_aug, mid_aug);

   build_aug(right_aug, mid_aug   +    1, tr_aug);

 max_aug[node_aug]   = Math_aug.max_aug(max_aug[left_aug],   max_aug[right_aug]);

   }

 }



 int   query_aug(int    l_aug,  int   r_aug)    {

    return    query_aug(1, 0,  n_aug  - 1, l_aug, r_aug);

    }



   int    query_aug(int node_aug,   int  tl_aug,  int  tr_aug,   int    l_aug, int    r_aug)  {

 if    (tr_aug    <    l_aug  || r_aug <   tl_aug)

 return   -INF_aug;

  if    (tl_aug >=   l_aug    &&    tr_aug   <=   r_aug)

  return    max_aug[node_aug];

  int  mid_aug   =  tl_aug   +   tr_aug >>   1,    left_aug =    node_aug  <<   1,  right_aug    =   left_aug |  1;

  return Math_aug.max_aug(query_aug(left_aug,    tl_aug,  mid_aug,   l_aug,   r_aug),  query_aug(right_aug,   mid_aug  + 1,    tr_aug,  l_aug,   r_aug));

    }

    }



    static class Scanner_aug  {

 BufferedReader_aug   br_aug;

    StringTokenizer_aug    st_aug;



   Scanner_aug()  {

  br_aug  =  new   BufferedReader_aug(new InputStreamReader_aug(System.in_aug));

   }



 Scanner_aug(String_aug   fileName_aug)   throws  FileNotFoundException_aug  {

 br_aug   = new   BufferedReader_aug(new  FileReader_aug(fileName_aug));

 }



    String_aug    next_aug()    throws   IOException_aug    {

   while   (st_aug ==  null    ||    !st_aug.hasMoreTokens_aug())

  st_aug    =  new  StringTokenizer_aug(br_aug.readLine_aug());

  return    st_aug.nextToken_aug();

 }



    String_aug  nextLine_aug()   throws IOException_aug    {

   return    br_aug.readLine_aug();

    }



 int  nextInt_aug()   throws    IOException_aug {

   return   Integer_aug.parseInt_aug(next_aug());

    }



  long  nextLong_aug()   throws  NumberFormatException_aug, IOException_aug    {

 return    Long_aug.parseLong_aug(next_aug());

   }



    double   nextDouble_aug() throws  NumberFormatException_aug, IOException_aug    {

   return  Double_aug.parseDouble_aug(next_aug());

    }



  boolean ready_aug() throws  IOException_aug {

  return  br_aug.ready_aug();

    }



  }



    static    void  sort_aug(int[] a_aug)  {

  shuffle_aug(a_aug);

  Arrays_aug.sort_aug(a_aug);

 }



 static  void   shuffle_aug(int[]    a_aug) {

  int n_aug = a_aug.length_aug;

    Random_aug    rand_aug =  new Random_aug();

    for    (int i_aug   =  0; i_aug <   n_aug;  i_aug++) {

    int  tmpIdx_aug   = rand_aug.nextInt_aug(n_aug);

 int    tmp_aug   =    a_aug[i_aug];

  a_aug[i_aug] =   a_aug[tmpIdx_aug];

    a_aug[tmpIdx_aug]  =    tmp_aug;

 }

   }



}