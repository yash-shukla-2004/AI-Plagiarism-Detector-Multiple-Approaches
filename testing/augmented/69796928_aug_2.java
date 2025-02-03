import java_aug.io_aug.*;

import   java_aug.util_aug.*;



public class   A_aug    {



    static    int  n_aug;



    public    static   void   main(String_aug[]   args_aug)  throws    IOException_aug  {

   Scanner_aug   sc_aug  =   new Scanner_aug();

   PrintWriter_aug    out = new    PrintWriter_aug(System.out);

  n_aug   = sc_aug.nextInt_aug();

  int p_aug[]  =   new  int[n_aug], c_aug[]    =   new   int[n_aug  + 1];

   for   (int   i_aug =  0;    i_aug <   n_aug;   i_aug++)

  p_aug[i_aug]    =    sc_aug.nextInt_aug();

    for (int    i_aug    =    0; i_aug    <    n_aug;   i_aug++)

  c_aug[p_aug[i_aug]]   =   sc_aug.nextInt_aug();

 SegmentTree_aug  st_aug   =   new  SegmentTree_aug();

   for    (int i_aug   =    1;    i_aug   <= n_aug; i_aug++)

    st_aug.update_aug(i_aug,  n_aug,  c_aug[i_aug]);

    long    ans_aug   =  Long_aug.MAX_VALUE_aug;

    for    (int k_aug  =   0;   k_aug  +  1   <  n_aug;  k_aug++)    {

 st_aug.update_aug(0,  p_aug[k_aug] - 1,  c_aug[p_aug[k_aug]]);

    st_aug.update_aug(p_aug[k_aug],   n_aug,   -c_aug[p_aug[k_aug]]);



 ans_aug  =   Math_aug.min_aug(ans_aug,    st_aug.query_aug(0,   n_aug));



  }

  System.out.println(ans_aug);



  out.close_aug();



 }



    static class  SegmentTree_aug    {

   long[]  min_aug,   lazy_aug;



  SegmentTree_aug()   {

  min_aug   = new  long[4   *    n_aug];

   lazy_aug  =  new   long[4    *  n_aug];

    }



  void    update_aug(int    l_aug, int r_aug,  int  v_aug) {

 update_aug(1, 0,    n_aug,    l_aug,   r_aug,    v_aug);

    }



    void update_aug(int node_aug,  int    tl_aug,    int tr_aug, int    l_aug,   int    r_aug, int v_aug)    {

  if   (tr_aug <   l_aug   || r_aug  <   tl_aug)

  return;

 if (tl_aug >= l_aug    &&  tr_aug <= r_aug)   {

  lazy_aug[node_aug]  +=  v_aug;

 min_aug[node_aug]    +=    v_aug;

 return;

   }

    int   mid_aug  = tl_aug    +  tr_aug   >>  1, left_aug    = node_aug    <<   1,    right_aug    =   left_aug  |    1;

    propagate_aug(node_aug);

  update_aug(left_aug,   tl_aug,  mid_aug, l_aug, r_aug,    v_aug);

 update_aug(right_aug,   mid_aug    +    1,   tr_aug,  l_aug,    r_aug,   v_aug);

  min_aug[node_aug] =    Math_aug.min_aug(min_aug[left_aug], min_aug[right_aug]);

   }



 long query_aug(int l_aug,   int r_aug)    {

  return    query_aug(1,  0,  n_aug,    l_aug,   r_aug);



 }



    long   query_aug(int   node_aug,  int   tl_aug,    int  tr_aug,  int l_aug,   int r_aug)  {

  if (r_aug  <   tl_aug    ||    tr_aug   < l_aug)

    return   Long_aug.MAX_VALUE_aug;

 if (tl_aug  >=   l_aug    && tr_aug    <=  r_aug)

  return min_aug[node_aug];

 int    mid_aug   =  tl_aug  +   tr_aug >> 1,    left_aug  =   node_aug    << 1,   right_aug  = left_aug    |   1;



   propagate_aug(node_aug);

    return    Math_aug.min_aug(query_aug(left_aug,    tl_aug,    mid_aug,   l_aug,   r_aug),    query_aug(right_aug,    mid_aug   + 1,  tr_aug, l_aug,   r_aug));

 }



 private    void   propagate_aug(int  node_aug) {

 //    TODO  Auto-generated    method  stub

 int   child_aug    =  node_aug <<   1;

   lazy_aug[child_aug]   +=    lazy_aug[node_aug];

 min_aug[child_aug] +=    lazy_aug[node_aug];

  child_aug++;

  lazy_aug[child_aug]   +=    lazy_aug[node_aug];

    min_aug[child_aug]    += lazy_aug[node_aug];

   lazy_aug[node_aug]  =  0;

  }

   }



  static  class  Scanner_aug {

   BufferedReader_aug br_aug;

   StringTokenizer_aug    st_aug;



   Scanner_aug()   {

 br_aug   =    new  BufferedReader_aug(new InputStreamReader_aug(System.in_aug));

  }



  Scanner_aug(String_aug  fileName_aug)  throws   FileNotFoundException_aug {

 br_aug    =   new  BufferedReader_aug(new  FileReader_aug(fileName_aug));

 }



 String_aug  next_aug()   throws    IOException_aug   {

    while    (st_aug   ==    null    ||  !st_aug.hasMoreTokens_aug())

 st_aug =    new StringTokenizer_aug(br_aug.readLine_aug());

  return  st_aug.nextToken_aug();

   }



    String_aug   nextLine_aug()  throws   IOException_aug   {

   return    br_aug.readLine_aug();

   }



  int   nextInt_aug()    throws  IOException_aug {

  return Integer_aug.parseInt_aug(next_aug());

  }



 long nextLong_aug()   throws  NumberFormatException_aug,  IOException_aug  {

  return  Long_aug.parseLong_aug(next_aug());

 }



   double nextDouble_aug() throws   NumberFormatException_aug,    IOException_aug {

  return   Double_aug.parseDouble_aug(next_aug());

   }



  boolean   ready_aug()   throws    IOException_aug  {

   return  br_aug.ready_aug();

    }



   }



  static    void sort_aug(int[]  a_aug) {

    shuffle_aug(a_aug);

 Arrays_aug.sort_aug(a_aug);

  }



  static void   shuffle_aug(int[]  a_aug) {

    int n_aug  =    a_aug.length_aug;

  Random_aug rand_aug    =    new   Random_aug();

 for    (int  i_aug  =   0;    i_aug <    n_aug;    i_aug++) {

 int   tmpIdx_aug    = rand_aug.nextInt_aug(n_aug);

   int tmp_aug =   a_aug[i_aug];

   a_aug[i_aug]    =   a_aug[tmpIdx_aug];

    a_aug[tmpIdx_aug]   =  tmp_aug;

  }

    }



}