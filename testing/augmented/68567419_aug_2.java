import  java_aug.io_aug.*;

import java_aug.util_aug.*;

public class   Main_aug{

 public   static    void    main(String_aug[]    args_aug)   throws  Exception_aug{

    MScanner_aug   sc_aug=new MScanner_aug(System.in_aug);

  PrintWriter_aug    pw_aug=new    PrintWriter_aug(System.out);

  int  n_aug=sc_aug.nextInt_aug(),m_aug=sc_aug.nextInt_aug();

 int[]in_aug=sc_aug.takearr_aug(n_aug);

  int   sqrt_aug=0;

    while(sqrt_aug*sqrt_aug<n_aug) {

 sqrt_aug++;

 }

 int   []next_aug=new   int[n_aug],cnt_aug=new  int[n_aug];

  int   []rep_aug=new   int[n_aug];

  for(int  i_aug=n_aug-1;i_aug>=0;i_aug--) {

   if(in_aug[i_aug]+i_aug>=n_aug)  {

   next_aug[i_aug]=n_aug;

 cnt_aug[i_aug]=1;

    rep_aug[i_aug]=i_aug;

   }

 else    {

  int    curPortion_aug=i_aug/sqrt_aug,nextPortion_aug=(in_aug[i_aug]+i_aug)/sqrt_aug;

   if(curPortion_aug==nextPortion_aug)   {

   next_aug[i_aug]=next_aug[i_aug+in_aug[i_aug]];

    cnt_aug[i_aug]=cnt_aug[i_aug+in_aug[i_aug]]+1;

  rep_aug[i_aug]=rep_aug[i_aug+in_aug[i_aug]];

   }

  else    {

 next_aug[i_aug]=i_aug+in_aug[i_aug];

   cnt_aug[i_aug]=1;

    rep_aug[i_aug]=i_aug;

 }



   }

 }

   while(m_aug-->0)  {

    if(sc_aug.nextInt_aug()==0)   {

  int   a_aug=sc_aug.nextInt_aug()-1,p_aug=sc_aug.nextInt_aug();

   in_aug[a_aug]=p_aug;

   for(int   i_aug=a_aug;i_aug>=0;i_aug--)   {

 if(in_aug[i_aug]+i_aug>=n_aug)  {

    next_aug[i_aug]=n_aug;

 cnt_aug[i_aug]=1;

   rep_aug[i_aug]=i_aug;

    }

   else  {

    int curPortion_aug=i_aug/sqrt_aug,nextPortion_aug=(in_aug[i_aug]+i_aug)/sqrt_aug;

  if(curPortion_aug==nextPortion_aug)  {

    next_aug[i_aug]=next_aug[i_aug+in_aug[i_aug]];

 cnt_aug[i_aug]=cnt_aug[i_aug+in_aug[i_aug]]+1;

   rep_aug[i_aug]=rep_aug[i_aug+in_aug[i_aug]];

  }

   else    {

   next_aug[i_aug]=i_aug+in_aug[i_aug];

 cnt_aug[i_aug]=1;

  rep_aug[i_aug]=i_aug;

   }



  }

  if(i_aug%sqrt_aug==0)  {

 break;

 }



    }



 }

    else    {

    int   ans_aug=0,last_aug=sc_aug.nextInt_aug()-1;

   while(true) {

  ans_aug+=cnt_aug[last_aug];

 if(next_aug[last_aug]==n_aug)  {

    last_aug=rep_aug[last_aug];

    break;

    }

 last_aug=next_aug[last_aug];



  }

    pw_aug.println((last_aug+1)+"   "+ans_aug);

   }

 }

   pw_aug.flush_aug();

  } 

    static   class   MScanner_aug  {

 StringTokenizer_aug  st_aug;

   BufferedReader_aug   br_aug;

    public   MScanner_aug(InputStream_aug   system_aug)   {

 br_aug    =    new BufferedReader_aug(new    InputStreamReader_aug(system_aug));

    }



 public    MScanner_aug(String_aug file_aug)    throws  Exception_aug  {

    br_aug    =  new    BufferedReader_aug(new FileReader_aug(file_aug));

   }



 public  String_aug   next_aug() throws   IOException_aug    {

    while  (st_aug   == null   ||  !st_aug.hasMoreTokens_aug())

 st_aug    =  new    StringTokenizer_aug(br_aug.readLine_aug());

   return   st_aug.nextToken_aug();

   }

  public    int[] takearr_aug(int  n_aug)   throws   IOException_aug {

    int[]in_aug=new    int[n_aug];for(int    i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

    return    in_aug;

 }

    public    long[]   takearrl_aug(int    n_aug)  throws    IOException_aug  {

  long[]in_aug=new    long[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

   return   in_aug;

 }

 public   Integer_aug[] takearrobj_aug(int  n_aug) throws IOException_aug {

 Integer_aug[]in_aug=new  Integer_aug[n_aug];for(int  i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

    return in_aug;

 }

   public    Long_aug[]    takearrlobj_aug(int   n_aug)    throws IOException_aug    {

  Long_aug[]in_aug=new  Long_aug[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

    return    in_aug;

    }

   public String_aug nextLine_aug() throws IOException_aug    {

  return  br_aug.readLine_aug();

   }



  public    int  nextInt_aug()   throws   IOException_aug    {

   return  Integer_aug.parseInt_aug(next_aug());

 }



 public    double   nextDouble_aug()  throws  IOException_aug   {

  return    Double_aug.parseDouble_aug(next_aug());

    }



    public   char  nextChar_aug()  throws IOException_aug    {

 return next_aug().charAt_aug(0);

  }



  public  Long_aug  nextLong_aug()   throws   IOException_aug {

  return  Long_aug.parseLong_aug(next_aug());

   }



   public    boolean ready_aug() throws IOException_aug {

 return br_aug.ready_aug();

 }



 public  void  waitForInput_aug()  throws  InterruptedException_aug {

  Thread_aug.sleep_aug(3000);

   }

 }

}