import java_aug.util_aug.*;



import  java_aug.io_aug.*;

public    class   cf_aug    {

    public   static  void  main(String_aug[] args_aug)   throws    IOException_aug,InterruptedException_aug{

  Scanner_aug sc_aug =new  Scanner_aug(System.in_aug);

 PrintWriter_aug    pw_aug =   new    PrintWriter_aug(System.out);

  int    n_aug  =sc_aug.nextInt_aug();

   long   []    curr_aug =new    long   [n_aug];

   long   [] temp_aug =new  long[n_aug];

   long    []  prefixSum_aug=new   long[n_aug+1];

   for (int   i_aug =0;i_aug<n_aug;++i_aug)

   curr_aug[i_aug]=sc_aug.nextLong_aug();

  for (int   i_aug =1;i_aug<=n_aug;++i_aug)   {

   temp_aug[i_aug-1]=sc_aug.nextLong_aug();

   prefixSum_aug[i_aug]=temp_aug[i_aug-1]+prefixSum_aug[i_aug-1];

 }

   PriorityQueue_aug<Long_aug>    pq_aug   =new PriorityQueue_aug<Long_aug>();

    for    (int  i_aug   =0;i_aug<n_aug;++i_aug) {

    long   j_aug=0;

 pq_aug.add_aug(prefixSum_aug[i_aug]+curr_aug[i_aug]);

    while   (!pq_aug.isEmpty_aug()&&pq_aug.peek_aug()<=prefixSum_aug[i_aug+1])

   j_aug+=(pq_aug.poll_aug()-prefixSum_aug[i_aug]);

 j_aug+=(temp_aug[i_aug]*pq_aug.size_aug());

   pw_aug.print_aug(j_aug+"    ");

   }

  pw_aug.flush_aug();

 }

 static  class    Scanner_aug    {

 StringTokenizer_aug stringTokenizer_aug;

 BufferedReader_aug  bfBufferedReader_aug;

 public Scanner_aug(InputStream_aug  system_aug)    {

    bfBufferedReader_aug=new  BufferedReader_aug(new  InputStreamReader_aug( system_aug));

 }

 public Scanner_aug(String_aug  file_aug)  throws  Exception_aug {

    bfBufferedReader_aug    =   new BufferedReader_aug(new  FileReader_aug(    file_aug));

   } 

    public String_aug  next_aug() throws  IOException_aug   {

 while  (stringTokenizer_aug  ==  null    ||   !stringTokenizer_aug.hasMoreTokens_aug())

 stringTokenizer_aug   =  new  StringTokenizer_aug( bfBufferedReader_aug.readLine_aug());

    return stringTokenizer_aug.nextToken_aug();

  }



 public   String_aug   nextLine_aug() throws  IOException_aug    {

  return   bfBufferedReader_aug.readLine_aug();

  }



 public   int    nextInt_aug()   throws IOException_aug  {

   return  Integer_aug.parseInt_aug(next_aug());

    }



   public   double  nextDouble_aug() throws    IOException_aug    {

 return Double_aug.parseDouble_aug(next_aug());

 }



    public  char  nextChar_aug()    throws   IOException_aug   {

  return    next_aug().charAt_aug(0);

    }



  public  Long_aug nextLong_aug()   throws  IOException_aug   {

   return Long_aug.parseLong_aug(next_aug());

    }



    public  boolean    ready_aug() throws   IOException_aug  {

  return    bfBufferedReader_aug.ready_aug();

 }



 public void waitForInput_aug()   throws    InterruptedException_aug  {

  Thread_aug.sleep_aug(3000);

  }

    }

 }