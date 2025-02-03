import  java_aug.io_aug.*;

import  java_aug.util_aug.*;



public    class    D_aug  {



    static    int dis_aug(int   l_aug,    int  r_aug, int[]    a_aug) {

 HashSet_aug<Integer_aug> set_aug   =   new  HashSet_aug();

   for (int  i_aug =   l_aug;  i_aug  <    r_aug;  i_aug++)

  set_aug.add_aug(a_aug[i_aug]);

    return  set_aug.size_aug();

 }



  public    static    void  main(String_aug[]  args_aug) throws IOException_aug   {

   Scanner_aug sc_aug =    new    Scanner_aug();

 PrintWriter_aug out =   new    PrintWriter_aug(System.out);

 int    n_aug   =    sc_aug.nextInt_aug(),    m_aug   =   sc_aug.nextInt_aug();

  int[]    min_aug    =  new   int[n_aug    +  1], max_aug = new   int[n_aug    +  1];

   ArrayList_aug<Integer_aug>[]    occ_aug  =   new    ArrayList_aug[n_aug   +   1],   queries_aug  = new  ArrayList_aug[m_aug];

 for (int i_aug =  1;  i_aug <= n_aug;    i_aug++)  {

 min_aug[i_aug]    =   max_aug[i_aug]  =   i_aug;

   occ_aug[i_aug]    =  new  ArrayList_aug();

   }



   FenwickTree_aug tree_aug    =    new FenwickTree_aug(n_aug+m_aug+2);

    int[]   a_aug   =  new   int[m_aug];

  for (int   i_aug =   0;   i_aug <   m_aug;   i_aug++)   {

    a_aug[i_aug]  =   sc_aug.nextInt_aug();

 min_aug[a_aug[i_aug]]   = 1;

    if    (occ_aug[a_aug[i_aug]].size_aug()  == 0) {

    max_aug[a_aug[i_aug]] +=   tree_aug.query_aug(a_aug[i_aug]  +  1,   n_aug);

   tree_aug.update_aug(a_aug[i_aug], 1);

    }

 occ_aug[a_aug[i_aug]].add_aug(i_aug);

 queries_aug[i_aug]   = new    ArrayList_aug();

  }



    for   (int    i_aug  =    1;  i_aug <=   n_aug;  i_aug++)  {

 if  (occ_aug[i_aug].size_aug() ==    0)   {

 max_aug[i_aug]    +=   tree_aug.query_aug(i_aug +    1,    n_aug);

  continue;

    }

 occ_aug[i_aug].add_aug(m_aug);

   for    (int  j_aug  =    0;  j_aug +    1    <    occ_aug[i_aug].size_aug(); j_aug++)  {

   int   l_aug  =  occ_aug[i_aug].get_aug(j_aug),    r_aug  =   occ_aug[i_aug].get_aug(j_aug +  1)    -  1;

// max_aug[i_aug] = Math_aug.max_aug(max_aug[i_aug],    dis_aug(l_aug,   r_aug,   a_aug));

    queries_aug[r_aug].add_aug(l_aug);

    }

   }

 Arrays_aug.fill_aug(tree_aug.bit_aug,  0);

   int[]   last_aug  =  new  int[n_aug   +    1];

    Arrays_aug.fill_aug(last_aug,  -1);

  for  (int r_aug    =   0;   r_aug   <  m_aug;    r_aug++)    {

 if    (last_aug[a_aug[r_aug]]   !=    -1)    {

   tree_aug.update_aug(last_aug[a_aug[r_aug]]  +    1,   -1);

  }

   last_aug[a_aug[r_aug]]   = r_aug;

 tree_aug.update_aug(r_aug +    1,   1);

  for (int   l_aug :  queries_aug[r_aug])   {

  max_aug[a_aug[l_aug]]    =  Math_aug.max_aug(max_aug[a_aug[l_aug]],   tree_aug.query_aug(l_aug   +  1, r_aug   +   1));

  }



  }

   for    (int   i_aug =   1;   i_aug <= n_aug; i_aug++)   {

 out.println(min_aug[i_aug]  +   "  " + max_aug[i_aug]);

   }

 out.close_aug();



 }



  static    class  FenwickTree_aug   {

    int[]  bit_aug;



    FenwickTree_aug(int   n_aug) {

   bit_aug    =   new    int[n_aug +   1];

 }



   int    query_aug(int l_aug, int   r_aug)  {

    return  query_aug(r_aug)  -  query_aug(l_aug   -    1);

  }



  int    query_aug(int  idx_aug) {

    int    ans_aug    = 0;

  while    (idx_aug  >   0) {

   ans_aug +=   bit_aug[idx_aug];

   idx_aug   -= idx_aug    & -idx_aug;

    }

 return ans_aug;

 }



    void   update_aug(int idx_aug,   int  v_aug)  {

    while  (idx_aug  < bit_aug.length_aug)  {

  bit_aug[idx_aug]    +=    v_aug;

   idx_aug +=   idx_aug   &  -idx_aug;

    }

  }



  }



   static    class Scanner_aug    {

   BufferedReader_aug   br_aug;

  StringTokenizer_aug st_aug;



    Scanner_aug()  {

  br_aug   =  new  BufferedReader_aug(new   InputStreamReader_aug(System.in_aug));

   }



    Scanner_aug(String_aug    fileName_aug)   throws    FileNotFoundException_aug   {

    br_aug    =   new  BufferedReader_aug(new    FileReader_aug(fileName_aug));

  }



    String_aug  next_aug()   throws    IOException_aug   {

 while (st_aug    == null    || !st_aug.hasMoreTokens_aug())

   st_aug   = new  StringTokenizer_aug(br_aug.readLine_aug());

 return st_aug.nextToken_aug();

   }



  String_aug   nextLine_aug()    throws IOException_aug   {

  return  br_aug.readLine_aug();

   }



   int nextInt_aug()    throws  IOException_aug  {

   return Integer_aug.parseInt_aug(next_aug());

 }



    long nextLong_aug()    throws  NumberFormatException_aug, IOException_aug {

   return   Long_aug.parseLong_aug(next_aug());

  }



 double nextDouble_aug() throws  NumberFormatException_aug,   IOException_aug  {

    return    Double_aug.parseDouble_aug(next_aug());

    }



   boolean ready_aug() throws IOException_aug {

  return br_aug.ready_aug();

    }



 }



 static  void  sort_aug(int[]   a_aug)   {

 shuffle_aug(a_aug);

 Arrays_aug.sort_aug(a_aug);

 }



  static    void  shuffle_aug(int[]   a_aug) {

    int   n_aug =  a_aug.length_aug;

  Random_aug   rand_aug   = new    Random_aug();

    for  (int i_aug   =    0;  i_aug  <    n_aug;   i_aug++)    {

 int tmpIdx_aug   = rand_aug.nextInt_aug(n_aug);

    int  tmp_aug   =    a_aug[i_aug];

   a_aug[i_aug]  =   a_aug[tmpIdx_aug];

    a_aug[tmpIdx_aug] = tmp_aug;

 }

   }



}