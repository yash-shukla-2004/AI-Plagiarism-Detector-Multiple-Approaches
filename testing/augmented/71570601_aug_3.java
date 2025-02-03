import   java_aug.io_aug.*;

import  java_aug.util_aug.*;





public class  Main_aug{

 static  class  node_aug implements    Comparable_aug<node_aug>{

 int    i_aug,val_aug;

  node_aug(int  ii_aug,int    v_aug){

    i_aug=ii_aug;val_aug=v_aug;

    }

    @Override_aug

  public  int  compareTo_aug(node_aug    o_aug)    {

  if(val_aug==o_aug.val_aug)return    i_aug-o_aug.i_aug;

  return    val_aug-o_aug.val_aug;

    }

    public   String_aug toString_aug()  {return  i_aug+"  "+val_aug;}

    }

    static  LinkedList_aug<Integer_aug>children_aug[];

    static int[]cnt_aug;

    static  boolean    ok_aug=true;

    static  int[]empty_aug=new int[1];

  static    ArrayList_aug<node_aug>   dfs_aug(int    i_aug) {

    if(!ok_aug)   {

    return new ArrayList_aug<node_aug>();

   }

   if(children_aug[i_aug].size_aug()==0)    {

 if(cnt_aug[i_aug]>0)    {

    ok_aug=false;

   return  new   ArrayList_aug<node_aug>();

   }

  ArrayList_aug<node_aug>arr_aug=new  ArrayList_aug<Main_aug.node_aug>();

  arr_aug.add_aug(new  node_aug(i_aug,  1));

   return  arr_aug;

    }

 ArrayList_aug<node_aug>arr_aug=new ArrayList_aug<Main_aug.node_aug>();

   for(int   j_aug:children_aug[i_aug])    {

   ArrayList_aug<node_aug>child_aug=dfs_aug(j_aug);

  for(node_aug   n_aug:child_aug) {

    arr_aug.add_aug(n_aug);

 }

   }

    if(cnt_aug[i_aug]>arr_aug.size_aug())    {

   ok_aug=false;

   return    new  ArrayList_aug<node_aug>();

   }

   Collections_aug.sort_aug(arr_aug);

 //System.out.println(i_aug+" "+arr_aug);

    int    val_aug;

  if(cnt_aug[i_aug]==0)val_aug=1;

   else   {

 val_aug=arr_aug.get_aug(cnt_aug[i_aug]-1).val_aug+1;

  }

  if(cnt_aug[i_aug]<arr_aug.size_aug()    &&   arr_aug.get_aug(cnt_aug[i_aug]).val_aug<=val_aug)  {

 int  dif_aug=val_aug-arr_aug.get_aug(cnt_aug[i_aug]).val_aug+1;

    for(int idx_aug=cnt_aug[i_aug];idx_aug<arr_aug.size_aug();idx_aug++)  {

  node_aug cur_aug=arr_aug.get_aug(idx_aug);

    arr_aug.set_aug(idx_aug,   new   node_aug(cur_aug.i_aug,  cur_aug.val_aug+dif_aug));

  }

   }

   arr_aug.add_aug(new node_aug(i_aug,  val_aug));

    return   arr_aug;

    }

  public    static  void  main(String_aug[]   args_aug) throws Exception_aug{

  MScanner_aug sc_aug=new  MScanner_aug(System.in_aug);

   PrintWriter_aug  pw_aug=new  PrintWriter_aug(System.out);

 int  n_aug=sc_aug.nextInt_aug();

    children_aug=new    LinkedList_aug[n_aug];

    cnt_aug=new   int[n_aug];

    int    root_aug=-1;

   for(int    i_aug=0;i_aug<n_aug;i_aug++)children_aug[i_aug]=new   LinkedList_aug<Integer_aug>();

   for(int  i_aug=0;i_aug<n_aug;i_aug++)   {

 int   par_aug=sc_aug.nextInt_aug()-1;cnt_aug[i_aug]=sc_aug.nextInt_aug();

  if(par_aug!=-1) {

 children_aug[par_aug].add_aug(i_aug);

   }

   else {

   root_aug=i_aug;

  }

  }

  ArrayList_aug<node_aug>ans_aug=dfs_aug(root_aug);

    //System.out.println(ans_aug);

    if(!ok_aug)    {

  pw_aug.println("NO");

 pw_aug.flush_aug();

  return;

  }

 pw_aug.println("YES");

  int[]vals_aug=new int[n_aug];

   for(node_aug    x_aug:ans_aug)  {

  vals_aug[x_aug.i_aug]=x_aug.val_aug;

   }

    for(int   i_aug:vals_aug)pw_aug.println(i_aug);

   pw_aug.flush_aug();

   }

    static  class  MScanner_aug  {

 StringTokenizer_aug st_aug;

 BufferedReader_aug br_aug;

   public  MScanner_aug(InputStream_aug  system_aug)   {

   br_aug    =  new   BufferedReader_aug(new  InputStreamReader_aug(system_aug));

   }



    public  MScanner_aug(String_aug file_aug)  throws    Exception_aug  {

    br_aug    =  new BufferedReader_aug(new   FileReader_aug(file_aug));

   }



   public    String_aug next_aug()  throws  IOException_aug   {

    while   (st_aug ==   null || !st_aug.hasMoreTokens_aug())

 st_aug    =  new    StringTokenizer_aug(br_aug.readLine_aug());

  return   st_aug.nextToken_aug();

   }

    public int[] takearr_aug(int  n_aug)    throws   IOException_aug {

   int[]in_aug=new  int[n_aug];for(int    i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

  return in_aug;

  }

    public  long[]    takearrl_aug(int  n_aug) throws  IOException_aug  {

   long[]in_aug=new   long[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

   return    in_aug;

 }

   public Integer_aug[] takearrobj_aug(int n_aug)   throws  IOException_aug  {

    Integer_aug[]in_aug=new   Integer_aug[n_aug];for(int  i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

   return   in_aug;

   }

  public Long_aug[] takearrlobj_aug(int    n_aug)    throws    IOException_aug    {

   Long_aug[]in_aug=new Long_aug[n_aug];for(int    i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

   return   in_aug;

   }

   public  String_aug  nextLine_aug()  throws   IOException_aug {

    return  br_aug.readLine_aug();

   }



 public    int  nextInt_aug()   throws    IOException_aug {

   return  Integer_aug.parseInt_aug(next_aug());

   }



   public   double  nextDouble_aug()  throws  IOException_aug  {

    return Double_aug.parseDouble_aug(next_aug());

    }



  public   char   nextChar_aug() throws  IOException_aug    {

   return next_aug().charAt_aug(0);

    }



 public   Long_aug    nextLong_aug()    throws IOException_aug   {

    return    Long_aug.parseLong_aug(next_aug());

 }



   public  boolean   ready_aug()  throws   IOException_aug {

 return    br_aug.ready_aug();

  }



    public  void  waitForInput_aug()    throws  InterruptedException_aug    {

  Thread_aug.sleep_aug(3000);

 }

  }

}