import    java_aug.io_aug.*;

import java_aug.util_aug.*;



public   class  Main_aug{

   static   class    ftreeReversed_aug{

 int    n_aug;

  long[]ft_aug;

   ftreeReversed_aug(int z_aug){

  ft_aug=new   long[z_aug+1];

 n_aug=z_aug;

  }

 void updatesum_aug(int    idx_aug,int   k_aug)    {

 while(idx_aug>0) {

  ft_aug[idx_aug]+=k_aug;

   idx_aug-=(idx_aug&(-1*idx_aug));

    }



    }

  int  querysum_aug(int idx_aug) {

   int sum_aug=0;

  while(idx_aug<=n_aug)  {

    sum_aug+=ft_aug[idx_aug];

 idx_aug+=(idx_aug&(-1*idx_aug));

 }

    return    sum_aug;

   }

  }

  static   class  ftree_aug{

    int n_aug;

  long[]ft_aug;

   ftree_aug(int  z_aug){

   ft_aug=new   long[z_aug+1];

    n_aug=z_aug;

  }

 void updatesum_aug(int  idx_aug,int   k_aug)    {

    while(idx_aug<=n_aug)   {

  ft_aug[idx_aug]+=k_aug;

    idx_aug+=(idx_aug&(-1*idx_aug));

 }



   }

 int  querysum_aug(int    idx_aug)    {

  int   sum_aug=0;

   while(idx_aug>0)   {

    sum_aug+=ft_aug[idx_aug];

 idx_aug-=(idx_aug&(-1*idx_aug));

    }

  return   sum_aug;

   }

   }

   public static  void main(String_aug[]    args_aug)    throws  Exception_aug{

   MScanner_aug    sc_aug=new   MScanner_aug(System.in_aug);

  PrintWriter_aug    pw_aug=new   PrintWriter_aug(System.out);

    int    n_aug=sc_aug.nextInt_aug(),m_aug=sc_aug.nextInt_aug();



    int[]messages_aug=new  int[m_aug+1];

 for(int    i_aug=1;i_aug<=m_aug;i_aug++)messages_aug[i_aug]=sc_aug.nextInt_aug();



   int[]lastOcc_aug=new   int[n_aug+1];

    Arrays_aug.fill_aug(lastOcc_aug,   -1);

 int[]ansMin_aug=new    int[n_aug+1];

   int[]ansMax_aug=new    int[n_aug+1];

  for(int   i_aug=1;i_aug<=n_aug;i_aug++) {

 ansMin_aug[i_aug]=i_aug;ansMax_aug[i_aug]=i_aug;

    }

  for(int i_aug=1;i_aug<=m_aug;i_aug++)ansMin_aug[messages_aug[i_aug]]=1;



   ftreeReversed_aug    ftSeen_aug=new  ftreeReversed_aug(n_aug+7);



    ftree_aug    ftCount_aug=new ftree_aug(m_aug+7);



   for(int   i_aug=1;i_aug<=m_aug;i_aug++)  {

  if(lastOcc_aug[messages_aug[i_aug]]==-1)  {

   int    query_aug=ftSeen_aug.querysum_aug(messages_aug[i_aug]);

 ansMax_aug[messages_aug[i_aug]]+=query_aug;



  ftSeen_aug.updatesum_aug(messages_aug[i_aug],  1);



  ftCount_aug.updatesum_aug(i_aug,  1);



   lastOcc_aug[messages_aug[i_aug]]=i_aug;

    }

 else    {

  ftCount_aug.updatesum_aug(lastOcc_aug[messages_aug[i_aug]],   -1);

    ftCount_aug.updatesum_aug(i_aug,    1);



  int  left_aug=lastOcc_aug[messages_aug[i_aug]]+1;

 int  right_aug=i_aug-1;



  lastOcc_aug[messages_aug[i_aug]]=i_aug;



  if(left_aug>right_aug)continue;



  int    cnt_aug=ftCount_aug.querysum_aug(right_aug)-ftCount_aug.querysum_aug(left_aug-1);

  ansMax_aug[messages_aug[i_aug]]=Math_aug.max_aug(ansMax_aug[messages_aug[i_aug]],    cnt_aug+1);



    }

 }

   for(int i_aug=1;i_aug<=n_aug;i_aug++)  {

  if(lastOcc_aug[i_aug]==-1)   {

   int    query_aug=ftSeen_aug.querysum_aug(i_aug);

  ansMax_aug[i_aug]+=query_aug;

 }

   else  {

 int   left_aug=lastOcc_aug[i_aug]+1;

 int   right_aug=m_aug;

 if(left_aug>right_aug)continue;

   int  cnt_aug=ftCount_aug.querysum_aug(right_aug)-ftCount_aug.querysum_aug(left_aug-1);

 ansMax_aug[i_aug]=Math_aug.max_aug(ansMax_aug[i_aug],  cnt_aug+1);

    }

 }

 for(int    i_aug=1;i_aug<=n_aug;i_aug++)    {

  pw_aug.println(ansMin_aug[i_aug]+"  "+ansMax_aug[i_aug]);

    }

    pw_aug.flush_aug();

  }    

    static   class  MScanner_aug {

  StringTokenizer_aug   st_aug;

    BufferedReader_aug  br_aug;

   public    MScanner_aug(InputStream_aug system_aug)  {

    br_aug =    new    BufferedReader_aug(new   InputStreamReader_aug(system_aug));

 }



 public  MScanner_aug(String_aug file_aug)   throws Exception_aug    {

 br_aug =  new  BufferedReader_aug(new FileReader_aug(file_aug));

 }



  public   String_aug    next_aug()   throws   IOException_aug  {

    while   (st_aug ==  null   ||  !st_aug.hasMoreTokens_aug())

  st_aug   =    new  StringTokenizer_aug(br_aug.readLine_aug());

 return st_aug.nextToken_aug();

    }

   public int[]   takearr_aug(int n_aug) throws    IOException_aug {

   int[]in_aug=new  int[n_aug];for(int  i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

 return in_aug;

    }

    public    long[]   takearrl_aug(int n_aug) throws   IOException_aug   {

   long[]in_aug=new   long[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

  return  in_aug;

  }

    public  Integer_aug[]   takearrobj_aug(int   n_aug) throws    IOException_aug    {

  Integer_aug[]in_aug=new  Integer_aug[n_aug];for(int    i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

  return in_aug;

 }

    public    Long_aug[] takearrlobj_aug(int   n_aug) throws IOException_aug   {

   Long_aug[]in_aug=new   Long_aug[n_aug];for(int  i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

 return in_aug;

   }

   public String_aug  nextLine_aug() throws    IOException_aug {

  return  br_aug.readLine_aug();

    }



    public   int   nextInt_aug() throws  IOException_aug    {

  return  Integer_aug.parseInt_aug(next_aug());

   }



 public double    nextDouble_aug() throws  IOException_aug   {

    return    Double_aug.parseDouble_aug(next_aug());

  }



    public    char    nextChar_aug() throws    IOException_aug    {

  return  next_aug().charAt_aug(0);

    }



   public  Long_aug  nextLong_aug()    throws  IOException_aug {

    return    Long_aug.parseLong_aug(next_aug());

  }



    public    boolean   ready_aug()  throws  IOException_aug    {

    return  br_aug.ready_aug();

   }



  public void   waitForInput_aug()   throws    InterruptedException_aug  {

    Thread_aug.sleep_aug(3000);

   }

 }

}