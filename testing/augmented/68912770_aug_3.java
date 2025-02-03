import  java_aug.io_aug.OutputStream_aug;

import java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStream_aug;

import java_aug.io_aug.PrintWriter_aug;

import   java_aug.util_aug.Arrays_aug;

import  java_aug.io_aug.IOException_aug;

import java_aug.util_aug.TreeSet_aug;

import  java_aug.util_aug.ArrayList_aug;

import    java_aug.util_aug.Comparator_aug;

import   java_aug.util_aug.Collections_aug;

import    java_aug.io_aug.InputStream_aug;



/**

 *    Built using    CHelper plug-in_aug

   *   Actual  solution   is at  the  top

   *

  *    @author  Indrajit   Sinha

 */

public   class    Main_aug    {

   public    static void    main(String_aug[]    args_aug)  {

  InputStream_aug    inputStream_aug  =   System.in_aug;

  OutputStream_aug  outputStream_aug =    System.out;

    InputReader_aug   in_aug   =   new InputReader_aug(inputStream_aug);

 PrintWriter_aug out   =    new    PrintWriter_aug(outputStream_aug);

    EMessengerSimulator_aug    solver_aug   =  new EMessengerSimulator_aug();

 solver_aug.solve_aug(1, in_aug,  out);

 out.close_aug();

 }



 static class EMessengerSimulator_aug   {

  int   n_aug;

    PrintWriter_aug    out;

 InputReader_aug    in_aug;

  final    Comparator_aug<Query_aug>   com_aug    = new    Comparator_aug<Query_aug>() {

 public int compare_aug(Query_aug    x_aug,   Query_aug y_aug) {

 int xx_aug    =    Integer_aug.compare_aug(x_aug.r_aug, y_aug.r_aug);

    if (xx_aug ==  0)

   return  Integer_aug.compare_aug(x_aug.l_aug,  y_aug.l_aug);

   return xx_aug;

  }

   };



   public void solve_aug(int   testNumber_aug,  InputReader_aug   in_aug,    PrintWriter_aug  out)  {

   int  t_aug,   i_aug, j_aug,    tt_aug, k_aug;

  this.out    =   out;

    this.in_aug    =  in_aug;

    n_aug   = in_aug.nextInt_aug();

 int m_aug   = in_aug.nextInt_aug();

    int  a_aug[]  =    new    int[m_aug];

 int[] mn_aug,   mx_aug;

    mn_aug    =   new   int[n_aug];

    mx_aug    =   new  int[n_aug];

  for   (i_aug    =  0;    i_aug <   n_aug;   i_aug++)    {

   mn_aug[i_aug] =    i_aug;

  mx_aug[i_aug]  =   i_aug;

 }

 for   (i_aug = 0;   i_aug  <  m_aug; i_aug++) {

    a_aug[i_aug]   =   in_aug.nextInt_aug()  -  1;

 mn_aug[a_aug[i_aug]]  =   0;

 }

    ArrayList_aug<Integer_aug>    ar_aug[]    =   new   ArrayList_aug[n_aug];

   for   (i_aug   = 0;  i_aug   <   n_aug;    i_aug++)    {

   ar_aug[i_aug] =   new ArrayList_aug<>();

  }

    for  (i_aug =    0;  i_aug <  m_aug;   i_aug++) {

  ar_aug[a_aug[i_aug]].add_aug(i_aug);

  }

  TreeSet_aug<Integer_aug>  ts_aug  =  new  TreeSet_aug<>();

    SegmenTree_aug sg_aug  =  new    SegmenTree_aug();

    sg_aug.build_aug(n_aug);

   for   (i_aug  = 0;    i_aug   <    m_aug;  i_aug++) {

 if (ts_aug.contains_aug(a_aug[i_aug]))

   continue;

   mx_aug[a_aug[i_aug]]   = Math_aug.max_aug(mx_aug[a_aug[i_aug]],  a_aug[i_aug]   +  sg_aug.query_aug(a_aug[i_aug]    +   1,    n_aug));

   ts_aug.add_aug(a_aug[i_aug]);

 sg_aug.updateTreeNode_aug(a_aug[i_aug],   1);

  }

    for  (i_aug   =   0;    i_aug   <   n_aug;   i_aug++)    {

  if (ar_aug[i_aug].size_aug()    == 0)   {

   mx_aug[i_aug]    = Math_aug.max_aug(mx_aug[i_aug],   i_aug   +   sg_aug.query_aug(i_aug  +  1, n_aug));

  }

   }

   ArrayList_aug<Query_aug>   queries_aug  = new   ArrayList_aug<>();

    for  (i_aug   = 0; i_aug    <    n_aug;   i_aug++)  {

 if  (i_aug == 98)    {

   int   ou_aug =    0;

  }

  for (j_aug    =   1;  j_aug <  ar_aug[i_aug].size_aug();  j_aug++)    {

   int   l_aug   = ar_aug[i_aug].get_aug(j_aug    -    1)  + 1;

   int  r_aug   =    ar_aug[i_aug].get_aug(j_aug)   -   1;

    if    (l_aug  <=    r_aug)  {

 queries_aug.add_aug(new  Query_aug(l_aug, r_aug,  i_aug));

    }

 if   (j_aug   ==   ar_aug[i_aug].size_aug()  - 1)    {

  l_aug  = ar_aug[i_aug].get_aug(j_aug)   + 1;

  r_aug    =   m_aug   -  1;

  if   (l_aug  <=   r_aug)

  queries_aug.add_aug(new    Query_aug(l_aug,  r_aug,   i_aug));

 }

  }

  if    (ar_aug[i_aug].size_aug()    ==  1)    {

    int   l_aug   = ar_aug[i_aug].get_aug(0)  +    1;

 int r_aug = m_aug - 1;

  if (l_aug <=    r_aug)

 queries_aug.add_aug(new  Query_aug(l_aug, r_aug, i_aug));

 }

 }

    Collections_aug.sort_aug(queries_aug,    com_aug);

  int  bit_aug[]    =    new   int[m_aug +    1];

    int   last_visit_aug[]    = new   int[n_aug +  5];

    Arrays_aug.fill_aug(last_visit_aug,  -1);

   int  query_counter_aug   =  0,    q_aug  = queries_aug.size_aug();

  for (i_aug =   0;    i_aug   <    m_aug;   i_aug++)   {

 if (last_visit_aug[a_aug[i_aug]]    != -1)

 update_aug(last_visit_aug[a_aug[i_aug]]   +    1,   -1,    bit_aug, m_aug);

    last_visit_aug[a_aug[i_aug]]    = i_aug;

 update_aug(i_aug    +   1,  1,  bit_aug,    m_aug);

    while   (query_counter_aug    <   q_aug   &&  queries_aug.get_aug(query_counter_aug).r_aug  == i_aug)   {

 int   an_aug =  query_aug(queries_aug.get_aug(query_counter_aug).r_aug  + 1, bit_aug,    m_aug)   - query_aug(queries_aug.get_aug(query_counter_aug).l_aug, bit_aug,   m_aug);

 int    idx_aug  =    queries_aug.get_aug(query_counter_aug).idx_aug;

    mx_aug[idx_aug]   =  Math_aug.max_aug(mx_aug[idx_aug], an_aug);

    query_counter_aug++;

  }

   }

   for    (i_aug  =    0;   i_aug    <    n_aug;    i_aug++)  {

 pn_aug((mn_aug[i_aug]    + 1) +  "    " + (mx_aug[i_aug]  +  1));

   }



 }



   void    update_aug(int idx_aug, int  val_aug,    int  bit_aug[], int    n_aug) {

  for    (;  idx_aug    <= n_aug;  idx_aug  += idx_aug    &    -idx_aug)

 bit_aug[idx_aug]    +=  val_aug;

   }



 int query_aug(int    idx_aug,    int    bit_aug[],    int   n_aug) {

  int    sum_aug  =  0;

 for (;   idx_aug   >   0;   idx_aug -=   idx_aug    &    -idx_aug)

  sum_aug    +=   bit_aug[idx_aug];

  return sum_aug;

    }



  void    pn_aug(String_aug zx_aug) {

 out.println(zx_aug);

  }



    class  Query_aug  {

    int    l_aug;

   int    r_aug;

   int  idx_aug;



  Query_aug(int   a_aug,    int b_aug,  int   c_aug)    {

    l_aug =    a_aug;

   r_aug    =   b_aug;

 idx_aug   =    c_aug;

   }



    }



    class SegmenTree_aug {

    int    n_aug;

 int[]    tree_aug;



  void  build_aug(int   x_aug)    {

   n_aug  =  x_aug;

 tree_aug =   new   int[2 *  n_aug   +   1];

 }



   void   updateTreeNode_aug(int   p_aug,   int    value_aug)   {

 tree_aug[p_aug  + n_aug] =  value_aug;

    p_aug =    p_aug  +  n_aug;

    for    (int    i_aug  = p_aug;    i_aug   >  1;   i_aug >>=  1)

    tree_aug[i_aug >> 1] = tree_aug[i_aug] +    tree_aug[i_aug   ^    1];

   }



   int query_aug(int   l_aug,  int  r_aug)   {

 int   res_aug  = 0;

  for   (l_aug   +=   n_aug,    r_aug +=   n_aug;  l_aug   < r_aug;

   l_aug    >>=  1,  r_aug >>=   1)    {

 if    ((l_aug  &   1)    >  0)

    res_aug  += tree_aug[l_aug++];



  if ((r_aug  &  1) > 0)

    res_aug    += tree_aug[--r_aug];

 }



    return  res_aug;

  }



 }



  }



   static   class InputReader_aug    {

  private   InputStream_aug  stream_aug;

  private    byte[]    buf_aug   =  new  byte[1024];

    private int  curChar_aug;

 private   int    numChars_aug;



 public    InputReader_aug(InputStream_aug  stream_aug)   {

   this.stream_aug  =    stream_aug;

  }



    public int   read_aug()   {

   if    (numChars_aug  == -1)  {

   throw new UnknownError_aug();

    }

 if   (curChar_aug    >=    numChars_aug)    {

    curChar_aug   =    0;

    try    {

   numChars_aug   = stream_aug.read_aug(buf_aug);

 }  catch (IOException_aug   e_aug)    {

   throw  new   UnknownError_aug();

   }

    if (numChars_aug   <=    0)   {

    return   -1;

    }

 }

   return   buf_aug[curChar_aug++];

 }



  public  int  nextInt_aug()   {

 return  Integer_aug.parseInt_aug(next_aug());

  }



    public String_aug  next_aug() {

  int  c_aug   =  read_aug();

    while    (isSpaceChar_aug(c_aug)) {

   c_aug =   read_aug();

   }

    StringBuffer_aug res_aug =   new   StringBuffer_aug();

    do   {

  res_aug.appendCodePoint_aug(c_aug);

   c_aug =   read_aug();

    }  while   (!isSpaceChar_aug(c_aug));



    return  res_aug.toString_aug();

  }



 private boolean   isSpaceChar_aug(int  c_aug)   {

 return c_aug    ==    '   '    ||    c_aug    ==  '\n_aug' || c_aug   == '\r_aug'   ||    c_aug  ==    '\t_aug'   ||    c_aug ==    -1;

   }



    }

}


