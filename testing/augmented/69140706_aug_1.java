import   java_aug.io_aug.*;

import java_aug.util_aug.*;



public   class    Main_aug{

    static    long   dist_aug(long x1_aug,long  y1_aug,long    x2_aug,long  y2_aug)    {

  return   Math_aug.abs_aug(x1_aug-x2_aug)+Math_aug.abs_aug(y1_aug-y2_aug);

  }

  static    long[][]in_aug;

 public   static  void   main(String_aug[]   args_aug) throws    Exception_aug{

    MScanner_aug   sc_aug=new    MScanner_aug(System.in_aug);

    PrintWriter_aug pw_aug=new    PrintWriter_aug(System.out);

 long  x0_aug=sc_aug.nextLong_aug(),y0_aug=sc_aug.nextLong_aug(),ax_aug=sc_aug.nextLong_aug(),ay_aug=sc_aug.nextLong_aug(),bx_aug=sc_aug.nextLong_aug(),by_aug=sc_aug.nextLong_aug();

  long   xs_aug=sc_aug.nextLong_aug(),ys_aug=sc_aug.nextLong_aug(),t_aug=sc_aug.nextLong_aug();

 int    c_aug=0;

 in_aug=new  long[1000][2];

    while(true) {



   in_aug[c_aug][0]=x0_aug;in_aug[c_aug][1]=y0_aug;

   x0_aug=x0_aug*ax_aug+bx_aug;y0_aug=y0_aug*ay_aug+by_aug;

 c_aug++;

 if(x0_aug>4e16   ||   y0_aug>4e16)break;

 }

 int   finalAns_aug=0;

   for(int start_aug=0;start_aug<c_aug;start_aug++) {

 //increasing    first

   long dist_aug=dist_aug(xs_aug,    ys_aug, in_aug[start_aug][0],   in_aug[start_aug][1]);

    int ans_aug=0;



    if(dist_aug<=t_aug)    {

 ans_aug=1;

    long stx_aug=in_aug[start_aug][0],sty_aug=in_aug[start_aug][1];

    for(int    j_aug=start_aug+1;j_aug<c_aug;j_aug++)    {

   dist_aug+=dist_aug(stx_aug,  sty_aug,    in_aug[j_aug][0],   in_aug[j_aug][1]);

   //if(start_aug==2)   {

  //for(int i_aug=0;i_aug<c_aug;i_aug++)System.out.println(in_aug[i_aug][0]+"    "+in_aug[i_aug][1]);

  //System.out.println(dist_aug+"  "+j_aug+" "+in_aug[j_aug][0]+"  "+in_aug[j_aug][1]);

    //}

  if(dist_aug<=t_aug)   {

    ans_aug++;

 }

 else {

    break;

   }

 stx_aug=in_aug[j_aug][0];sty_aug=in_aug[j_aug][1];

    }

  for(int    j_aug=start_aug-1;j_aug>=0;j_aug--)   {

  dist_aug+=dist_aug(stx_aug,   sty_aug,  in_aug[j_aug][0],  in_aug[j_aug][1]);

   if(dist_aug<=t_aug) {

    ans_aug++;

 }

   else   {

   break;

    }

   stx_aug=in_aug[j_aug][0];sty_aug=in_aug[j_aug][1];

  }

    }

 //decreasing

 long dist2_aug=dist_aug(xs_aug,   ys_aug,   in_aug[start_aug][0],   in_aug[start_aug][1]);

  int   ans2_aug=0;

  if(dist2_aug<=t_aug)  {

 ans2_aug=1;

  long  stx_aug=in_aug[start_aug][0],sty_aug=in_aug[start_aug][1];

   for(int j_aug=start_aug-1;j_aug>=0;j_aug--)  {

  dist2_aug+=dist_aug(stx_aug,   sty_aug,  in_aug[j_aug][0],   in_aug[j_aug][1]);

  if(dist2_aug<=t_aug)  {

  ans2_aug++;

  }

  else   {

 break;

   }

    stx_aug=in_aug[j_aug][0];sty_aug=in_aug[j_aug][1];

 }

 for(int  j_aug=start_aug+1;j_aug<c_aug;j_aug++)  {

    dist2_aug+=dist_aug(stx_aug,   sty_aug,    in_aug[j_aug][0],  in_aug[j_aug][1]);

 if(dist2_aug<=t_aug)   {

    ans2_aug++;

   }

    else    {

  break;

   }

   stx_aug=in_aug[j_aug][0];sty_aug=in_aug[j_aug][1];

  }

    }

   finalAns_aug=Math_aug.max_aug(finalAns_aug,    ans_aug);

   finalAns_aug=Math_aug.max_aug(finalAns_aug, ans2_aug);

   }

   pw_aug.println(finalAns_aug);

  pw_aug.flush_aug();

   }  

  static   class MScanner_aug  {

   StringTokenizer_aug st_aug;

   BufferedReader_aug  br_aug;

   public   MScanner_aug(InputStream_aug  system_aug)  {

   br_aug =    new   BufferedReader_aug(new InputStreamReader_aug(system_aug));

  }



 public    MScanner_aug(String_aug  file_aug)  throws   Exception_aug   {

  br_aug  =    new    BufferedReader_aug(new FileReader_aug(file_aug));

 }



   public    String_aug   next_aug()   throws IOException_aug    {

   while  (st_aug   == null  ||  !st_aug.hasMoreTokens_aug())

    st_aug    =  new  StringTokenizer_aug(br_aug.readLine_aug());

  return st_aug.nextToken_aug();

  }

  public   int[] takearr_aug(int    n_aug)    throws    IOException_aug    {

    int[]in_aug=new int[n_aug];for(int  i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

  return    in_aug;

 }

   public    long[]    takearrl_aug(int  n_aug)    throws  IOException_aug    {

  long[]in_aug=new long[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

  return in_aug;

  }

   public  Integer_aug[] takearrobj_aug(int    n_aug)  throws    IOException_aug  {

    Integer_aug[]in_aug=new    Integer_aug[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

    return   in_aug;

    }

    public   Long_aug[]   takearrlobj_aug(int n_aug)    throws    IOException_aug    {

    Long_aug[]in_aug=new   Long_aug[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

   return  in_aug;

    }

 public   String_aug   nextLine_aug()   throws    IOException_aug    {

  return br_aug.readLine_aug();

  }



  public  int  nextInt_aug() throws  IOException_aug    {

    return  Integer_aug.parseInt_aug(next_aug());

    }



    public   double    nextDouble_aug()  throws   IOException_aug {

  return Double_aug.parseDouble_aug(next_aug());

  }



   public char   nextChar_aug()  throws    IOException_aug  {

   return   next_aug().charAt_aug(0);

   }



   public  Long_aug  nextLong_aug() throws  IOException_aug {

   return Long_aug.parseLong_aug(next_aug());

    }



   public  boolean ready_aug() throws    IOException_aug    {

   return  br_aug.ready_aug();

    }



  public void   waitForInput_aug()    throws    InterruptedException_aug {

    Thread_aug.sleep_aug(3000);

 }

    }

}