import   java_aug.io_aug.*;

import    java_aug.util_aug.*;





public class Main_aug{

  static  class  publ_aug   implements  Comparable_aug<publ_aug>{

    int   val_aug,t_aug,idx_aug;

    publ_aug(int v_aug,int    time_aug,int i_aug){

 val_aug=v_aug;

    t_aug=time_aug;

   idx_aug=i_aug;

  }

   @Override_aug

 public  int compareTo_aug(publ_aug    o_aug)    {

  //   TODO   Auto-generated method   stub

   return  val_aug-o_aug.val_aug;

  }



  }

 static class   publ2_aug    implements Comparable_aug<publ2_aug>{

  int    val_aug,t_aug,idx_aug;

 publ2_aug(int    v_aug,int    time_aug,int  i_aug){

   val_aug=v_aug;

    t_aug=time_aug;

   idx_aug=i_aug;

 }

   @Override_aug

   public    int  compareTo_aug(publ2_aug    o_aug) {

  //  TODO    Auto-generated   method stub

 return  t_aug-o_aug.t_aug;

    }



   }

    public static    void  main(String_aug[]   args_aug) throws   Exception_aug{

   MScanner_aug  sc_aug=new  MScanner_aug(System.in_aug);

    PrintWriter_aug  pw_aug=new    PrintWriter_aug(System.out);

   int n_aug=sc_aug.nextInt_aug();

 int[]in_aug=sc_aug.takearr_aug(n_aug);

  int[]t_aug=sc_aug.takearr_aug(n_aug);

    publ_aug[]arr_aug=new publ_aug[n_aug];

   for(int   i_aug=0;i_aug<n_aug;i_aug++)  {

  arr_aug[i_aug]=new   publ_aug(in_aug[i_aug],  t_aug[i_aug],i_aug);

 }

 Arrays_aug.sort_aug(arr_aug);

  PriorityQueue_aug<publ2_aug>pq_aug=new PriorityQueue_aug<publ2_aug>(Collections_aug.reverseOrder_aug());

  int    i_aug=0;

    long ans_aug=0;

 while(i_aug<n_aug)  {

    long   val_aug=arr_aug[i_aug].val_aug;

   while(i_aug<n_aug  &&   arr_aug[i_aug].val_aug==val_aug)   {

   pq_aug.add_aug(new  publ2_aug(arr_aug[i_aug].val_aug,   arr_aug[i_aug].t_aug,arr_aug[i_aug].idx_aug));

    i_aug++;

 }



  long    put_aug=val_aug;

  while((i_aug==n_aug    ||  put_aug<arr_aug[i_aug].val_aug)  &&   !pq_aug.isEmpty_aug()) {

   publ2_aug   cur_aug=pq_aug.poll_aug();

    //System.out.println(cur_aug.val_aug+"    "+put_aug+"  "+cur_aug.t_aug);

  ans_aug+=(put_aug-cur_aug.val_aug)*1l*cur_aug.t_aug;

 put_aug++;

 }





    }

  pw_aug.println(ans_aug);

    pw_aug.flush_aug();

 }

  static class MScanner_aug  {

  StringTokenizer_aug st_aug;

  BufferedReader_aug  br_aug;

 public  MScanner_aug(InputStream_aug    system_aug)   {

  br_aug =  new    BufferedReader_aug(new  InputStreamReader_aug(system_aug));

 }



   public    MScanner_aug(String_aug  file_aug)   throws    Exception_aug  {

    br_aug  =    new  BufferedReader_aug(new FileReader_aug(file_aug));

 }



   public    String_aug next_aug()    throws IOException_aug   {

   while   (st_aug  ==   null || !st_aug.hasMoreTokens_aug())

   st_aug =    new StringTokenizer_aug(br_aug.readLine_aug());

 return    st_aug.nextToken_aug();

    }

    public  int[]  takearr_aug(int n_aug)   throws IOException_aug   {

    int[]in_aug=new    int[n_aug];for(int  i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

   return  in_aug;

    }

    public  long[] takearrl_aug(int  n_aug)  throws    IOException_aug   {

  long[]in_aug=new   long[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

    return   in_aug;

 }

   public  Integer_aug[]    takearrobj_aug(int  n_aug)   throws  IOException_aug {

  Integer_aug[]in_aug=new   Integer_aug[n_aug];for(int   i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

    return   in_aug;

    }

   public Long_aug[]  takearrlobj_aug(int  n_aug)  throws   IOException_aug {

 Long_aug[]in_aug=new    Long_aug[n_aug];for(int    i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

  return  in_aug;

   }

 public String_aug    nextLine_aug() throws   IOException_aug {

   return  br_aug.readLine_aug();

 }



 public   int   nextInt_aug()   throws IOException_aug   {

   return Integer_aug.parseInt_aug(next_aug());

   }



 public  double  nextDouble_aug()  throws    IOException_aug {

    return  Double_aug.parseDouble_aug(next_aug());

 }



    public   char nextChar_aug()    throws IOException_aug {

  return  next_aug().charAt_aug(0);

 }



    public Long_aug   nextLong_aug()  throws  IOException_aug {

  return   Long_aug.parseLong_aug(next_aug());

  }



 public  boolean   ready_aug()   throws   IOException_aug    {

    return    br_aug.ready_aug();

  }



   public   void   waitForInput_aug()  throws   InterruptedException_aug   {

    Thread_aug.sleep_aug(3000);

   }

  }

}