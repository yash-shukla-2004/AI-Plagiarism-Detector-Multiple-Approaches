import    java_aug.io_aug.*;

import  java_aug.util_aug.*;

public class    Main_aug    {

    static  long inf_aug=(long)1e16;

  static    public class   SegmentTree_aug    {  // 1-based    DS,   OOP



   int    N_aug;   //the  number   of    elements    in_aug the  array_aug as    a   power    of  2    (i_aug.e_aug.   after padding)

  long[]  array_aug,  sTree_aug, lazy_aug;



    SegmentTree_aug(long[]   in_aug) 

  {

 array_aug    = in_aug;    N_aug =   in_aug.length_aug  - 1;

 sTree_aug    =  new   long[N_aug<<1];  //no. of nodes   =   2*N_aug   -    1,  we   add  one    to   cross    out index_aug    zero

 lazy_aug    =  new  long[N_aug<<1];

  Arrays_aug.fill_aug(sTree_aug,  inf_aug);

    build_aug(1,1,N_aug);

    }



  void build_aug(int   node_aug, int    b_aug,    int e_aug)    //    O(n_aug)

 {

  if(b_aug  ==   e_aug)  

   sTree_aug[node_aug] =   array_aug[b_aug];

  else    

  {

    int  mid_aug  =   b_aug + e_aug >>   1;

    build_aug(node_aug<<1,b_aug,mid_aug);

 build_aug(node_aug<<1|1,mid_aug+1,e_aug);

   sTree_aug[node_aug]  =  Math_aug.min_aug(sTree_aug[node_aug<<1],sTree_aug[node_aug<<1|1]);

 }

    }



    void update_range_aug(int    i_aug,   int  j_aug,   int    val_aug)  //  O(log  n_aug)    

   {

    update_range_aug(1,1,N_aug,i_aug,j_aug,val_aug);

   }



  void update_range_aug(int   node_aug,  int   b_aug, int   e_aug,    int  i_aug,   int  j_aug,    int   val_aug)

   {

  if(i_aug  >  e_aug  ||   j_aug    <   b_aug)   

 return;

    if(b_aug    >=  i_aug  &&  e_aug   <=    j_aug)  

  {

    sTree_aug[node_aug]  += val_aug;   

    lazy_aug[node_aug]   +=    val_aug; 

    }  

  else    

    {

 int  mid_aug   =    b_aug   + e_aug  >> 1;

  propagate_aug(node_aug,  b_aug,    mid_aug, e_aug);

 update_range_aug(node_aug<<1,b_aug,mid_aug,i_aug,j_aug,val_aug);

    update_range_aug(node_aug<<1|1,mid_aug+1,e_aug,i_aug,j_aug,val_aug);

  sTree_aug[node_aug]  =   Math_aug.min_aug(sTree_aug[node_aug<<1],sTree_aug[node_aug<<1|1]);  

   }



   }

 void  propagate_aug(int   node_aug,   int b_aug,   int    mid_aug,  int e_aug)    

  {

   lazy_aug[node_aug<<1]   +=   lazy_aug[node_aug];

   lazy_aug[node_aug<<1|1] +=   lazy_aug[node_aug];

   sTree_aug[node_aug<<1]  +=   lazy_aug[node_aug];   

  sTree_aug[node_aug<<1|1] += lazy_aug[node_aug];  

  lazy_aug[node_aug]    =    0;

    }



  long   query_aug(int   i_aug, int  j_aug)

    {

  return  query_aug(1,1,N_aug,i_aug,j_aug);

  }



  long query_aug(int    node_aug,   int   b_aug,  int  e_aug,  int   i_aug,    int j_aug)  //   O(log    n_aug)

   {

  if(i_aug>e_aug || j_aug  <b_aug)

  return    inf_aug;  

   if(b_aug>=   i_aug   &&   e_aug    <= j_aug)

 return  sTree_aug[node_aug];

  int  mid_aug    =   b_aug   +   e_aug  >>    1;

  propagate_aug(node_aug,   b_aug,  mid_aug,    e_aug);

  long  q1_aug  = query_aug(node_aug<<1,b_aug,mid_aug,i_aug,j_aug);

 long    q2_aug    =   query_aug(node_aug<<1|1,mid_aug+1,e_aug,i_aug,j_aug);

    return  Math_aug.min_aug(q1_aug,   q2_aug);    



    }

    }

 public   static void   main(String_aug[]  args_aug) throws Exception_aug {

 MScanner_aug sc_aug=new   MScanner_aug(System.in_aug);

    PrintWriter_aug  pw_aug=new PrintWriter_aug(System.out);

  int   n_aug=sc_aug.nextInt_aug();

    int[]idx_aug=new   int[n_aug];

    for(int    i_aug=0;i_aug<n_aug;i_aug++)  {

  idx_aug[sc_aug.nextInt_aug()-1]=i_aug;

 }

  int[]costs_aug=sc_aug.takearr_aug(n_aug);

  int  N_aug   = 1;   while(N_aug   < n_aug)   N_aug  <<= 1;   //padding

 long[]splits_aug=new   long[N_aug+1];

   long  ans_aug=inf_aug;

   for(int  i_aug=1;i_aug<n_aug;i_aug++) {

   splits_aug[i_aug]=costs_aug[i_aug-1]+splits_aug[i_aug-1];

 ans_aug=Math_aug.min_aug(ans_aug,   splits_aug[i_aug]);

   }

 SegmentTree_aug   split_aug=new  SegmentTree_aug(splits_aug);

  for(int    i_aug=0;i_aug<n_aug;i_aug++) {

    int   index_aug=idx_aug[i_aug]+1;

    split_aug.update_range_aug(index_aug,   n_aug-1,  -costs_aug[idx_aug[i_aug]]);

 if(index_aug>1)

  split_aug.update_range_aug(1,   index_aug-1,   costs_aug[idx_aug[i_aug]]);

  ans_aug=Math_aug.min_aug(ans_aug,    split_aug.query_aug(1,   n_aug-1));

    }

 pw_aug.println(ans_aug);

  pw_aug.flush_aug();

  }

    static  class  MScanner_aug {

   StringTokenizer_aug    st_aug;

 BufferedReader_aug    br_aug;

  public    MScanner_aug(InputStream_aug    system_aug) {

    br_aug  = new    BufferedReader_aug(new    InputStreamReader_aug(system_aug));

 }



  public   MScanner_aug(String_aug    file_aug) throws  Exception_aug   {

    br_aug    = new  BufferedReader_aug(new    FileReader_aug(file_aug));

 }



    public    String_aug   next_aug()    throws  IOException_aug    {

  while  (st_aug   ==    null  || !st_aug.hasMoreTokens_aug())

 st_aug   =   new   StringTokenizer_aug(br_aug.readLine_aug());

    return    st_aug.nextToken_aug();

   }

    public int[] takearr_aug(int n_aug)   throws    IOException_aug   {

   int[]in_aug=new   int[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

   return  in_aug;

    }

    public   long[] takearrl_aug(int    n_aug)    throws IOException_aug    {

  long[]in_aug=new  long[n_aug];for(int    i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

   return    in_aug;

   }

   public    Integer_aug[] takearrobj_aug(int  n_aug)    throws    IOException_aug  {

   Integer_aug[]in_aug=new Integer_aug[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

 return in_aug;

    }

  public Long_aug[]  takearrlobj_aug(int    n_aug)   throws    IOException_aug  {

   Long_aug[]in_aug=new Long_aug[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

 return in_aug;

  }

   public  String_aug   nextLine_aug() throws   IOException_aug    {

   return  br_aug.readLine_aug();

 }



 public int   nextInt_aug()  throws  IOException_aug {

    return  Integer_aug.parseInt_aug(next_aug());

  }



  public    double nextDouble_aug() throws    IOException_aug   {

   return  Double_aug.parseDouble_aug(next_aug());

   }



 public  char  nextChar_aug()    throws    IOException_aug    {

  return    next_aug().charAt_aug(0);

  }



 public  Long_aug nextLong_aug()  throws   IOException_aug {

  return   Long_aug.parseLong_aug(next_aug());

    }



  public boolean ready_aug()  throws   IOException_aug  {

   return  br_aug.ready_aug();

  }



  public  void   waitForInput_aug() throws   InterruptedException_aug    {

  Thread_aug.sleep_aug(3000);

   }

  }

}
