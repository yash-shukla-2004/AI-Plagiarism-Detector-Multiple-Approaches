import  java_aug.io_aug.*;

import java_aug.util_aug.*;



public   class   Main_aug{

 static  LinkedList_aug<Integer_aug>[]adj_aug;

    static  int[][] sub_aug ,par_aug;

 static  void  dfs_aug(int  i_aug,int root_aug,int  parent_aug)    {

 sub_aug[root_aug][i_aug]=1;

    for(int  j_aug:adj_aug[i_aug]) {

   if(j_aug!=parent_aug)   {

 dfs_aug(j_aug,root_aug,i_aug);

    sub_aug[root_aug][i_aug]+=sub_aug[root_aug][j_aug];

  par_aug[root_aug][j_aug]=i_aug;

   }

 }

    }

 static   long[][]memo_aug;

   static    long   dp_aug(int    i_aug,int    j_aug)  {

  if(i_aug==j_aug)return    0;

  if(memo_aug[i_aug][j_aug]!=-1)return    memo_aug[i_aug][j_aug];

  int nxti_aug=par_aug[j_aug][i_aug],nxtj_aug=par_aug[i_aug][j_aug];

  return    memo_aug[i_aug][j_aug]=sub_aug[i_aug][j_aug]*1l*sub_aug[j_aug][i_aug]+Math_aug.max_aug(dp_aug(nxti_aug,j_aug),  dp_aug(i_aug,nxtj_aug));

 }

 public    static void main(String_aug[]  args_aug)    throws Exception_aug{

    MScanner_aug sc_aug=new MScanner_aug(System.in_aug);

    PrintWriter_aug   pw_aug=new    PrintWriter_aug(System.out);

 int    n_aug=sc_aug.nextInt_aug();

    adj_aug=new    LinkedList_aug[n_aug];

  sub_aug=new  int[n_aug][n_aug];

 par_aug=new   int[n_aug][n_aug];

   for(int   i_aug=0;i_aug<n_aug;i_aug++)adj_aug[i_aug]=new LinkedList_aug<Integer_aug>();

   for(int  i_aug=0;i_aug<n_aug-1;i_aug++)   {

   int x_aug=sc_aug.nextInt_aug()-1,y_aug=sc_aug.nextInt_aug()-1;

   adj_aug[x_aug].add_aug(y_aug);adj_aug[y_aug].add_aug(x_aug);

 }

    for(int   i_aug=0;i_aug<n_aug;i_aug++)  {

    dfs_aug(i_aug,i_aug,-1);

 }

   memo_aug=new   long[n_aug][n_aug];

   for(long[]i_aug:memo_aug)Arrays_aug.fill_aug(i_aug,   -1);

  long    ans_aug=0;

    for(int  i_aug=0;i_aug<n_aug;i_aug++)    {

    for(int  j_aug=i_aug+1;j_aug<n_aug;j_aug++) {

 ans_aug=Math_aug.max_aug(ans_aug,   dp_aug(i_aug, j_aug));

   }

 }

   pw_aug.println(ans_aug);

 pw_aug.flush_aug();

    }    

 static class  MScanner_aug  {

  StringTokenizer_aug  st_aug;

    BufferedReader_aug  br_aug;

  public  MScanner_aug(InputStream_aug    system_aug)   {

  br_aug =    new BufferedReader_aug(new   InputStreamReader_aug(system_aug));

  }



 public   MScanner_aug(String_aug    file_aug) throws Exception_aug  {

    br_aug    = new   BufferedReader_aug(new    FileReader_aug(file_aug));

  }



   public   String_aug  next_aug()   throws IOException_aug    {

  while  (st_aug    == null  ||    !st_aug.hasMoreTokens_aug())

   st_aug   =   new   StringTokenizer_aug(br_aug.readLine_aug());

  return st_aug.nextToken_aug();

   }

  public    int[]    takearr_aug(int n_aug)  throws    IOException_aug  {

 int[]in_aug=new  int[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

    return   in_aug;

 }

 public   long[]   takearrl_aug(int n_aug) throws  IOException_aug   {

  long[]in_aug=new   long[n_aug];for(int   i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

   return in_aug;

    }

 public   Integer_aug[]   takearrobj_aug(int  n_aug)    throws  IOException_aug   {

    Integer_aug[]in_aug=new   Integer_aug[n_aug];for(int  i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

    return   in_aug;

    }

 public   Long_aug[]   takearrlobj_aug(int    n_aug)    throws    IOException_aug  {

  Long_aug[]in_aug=new   Long_aug[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

    return    in_aug;

  }

  public  String_aug nextLine_aug()   throws   IOException_aug  {

  return br_aug.readLine_aug();

 }



    public   int   nextInt_aug()  throws  IOException_aug  {

    return Integer_aug.parseInt_aug(next_aug());

 }



    public  double  nextDouble_aug()   throws    IOException_aug {

    return   Double_aug.parseDouble_aug(next_aug());

   }



  public char  nextChar_aug()  throws IOException_aug   {

  return    next_aug().charAt_aug(0);

   }



    public  Long_aug nextLong_aug() throws    IOException_aug {

   return   Long_aug.parseLong_aug(next_aug());

 }



   public boolean    ready_aug() throws  IOException_aug {

 return   br_aug.ready_aug();

  }



   public   void waitForInput_aug() throws    InterruptedException_aug    {

   Thread_aug.sleep_aug(3000);

    }

   }

}