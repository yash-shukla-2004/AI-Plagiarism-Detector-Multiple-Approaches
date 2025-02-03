import   java_aug.io_aug.*;
import   java_aug.util_aug.*;

public   class   A_aug{

    static    ArrayList_aug<edge_aug>[]adj_aug;
   static   int  []col_aug;
  static    class  edge_aug
 {
  int   v_aug,idx_aug;
   edge_aug(int   v_aug,int idx_aug){
    this.v_aug=v_aug;
  this.idx_aug=idx_aug;
   }
  }
  static  void   dfs_aug(int    u_aug,int max_aug,int  p_aug,int   colP_aug)  {
    int   curr_aug=1;
   for(edge_aug   a_aug:adj_aug[u_aug])  {
    int    v_aug=a_aug.v_aug,idx_aug=a_aug.idx_aug;
 if(v_aug==p_aug)
    continue;
   if(curr_aug==colP_aug)
    curr_aug++;
   if(curr_aug>max_aug)
  curr_aug=1;
    col_aug[idx_aug]=curr_aug;
    dfs_aug(v_aug,max_aug,u_aug,curr_aug);
   if(++curr_aug>max_aug)
 curr_aug=1;

  }
  }
   public static    void main(String_aug[]  args_aug)   throws    IOException_aug  {
  Scanner_aug sc_aug=new    Scanner_aug();
  PrintWriter_aug   out=new  PrintWriter_aug(System.out);
 int    n_aug=sc_aug.nextInt_aug(),k_aug=sc_aug.nextInt_aug();
    adj_aug=new   ArrayList_aug[n_aug];
   for(int  i_aug=0;i_aug<n_aug;i_aug++)
  adj_aug[i_aug]=new   ArrayList_aug();
    for(int    i_aug=1;i_aug<n_aug;i_aug++)    {
    int  u_aug=sc_aug.nextInt_aug()-1,v_aug=sc_aug.nextInt_aug()-1;
   adj_aug[u_aug].add_aug(new edge_aug(v_aug, i_aug));
 adj_aug[v_aug].add_aug(new   edge_aug(u_aug,    i_aug));
 }
  int  ans_aug=-1,lo_aug=1,hi_aug=n_aug-1;
  while(lo_aug<=hi_aug) {
 int  greater_aug=0;
   int  mid_aug=lo_aug+hi_aug>>1;
   for(int   i_aug=0;i_aug<n_aug;i_aug++)
   if(adj_aug[i_aug].size_aug()>mid_aug)
 greater_aug++;
   if(greater_aug<=k_aug)    {
    ans_aug=mid_aug;
   hi_aug=mid_aug-1;
    }
    else
   lo_aug=mid_aug+1;
   }
 col_aug=new   int  [n_aug];
  out.println(ans_aug);
    dfs_aug(0,  ans_aug,  -1,    -1);
    for(int i_aug=1;i_aug<n_aug;i_aug++)
  out.println(col_aug[i_aug]);
    out.close_aug();

  }
    static  class Scanner_aug
  {
   BufferedReader_aug   br_aug;
 StringTokenizer_aug   st_aug;
    Scanner_aug(){
  br_aug=new BufferedReader_aug(new  InputStreamReader_aug(System.in_aug));
 }
    Scanner_aug(String_aug    fileName_aug)    throws FileNotFoundException_aug{
   br_aug=new    BufferedReader_aug(new   FileReader_aug(fileName_aug));
    }
   String_aug  next_aug() throws   IOException_aug   {
   while(st_aug==null   ||   !st_aug.hasMoreTokens_aug())
   st_aug=new   StringTokenizer_aug(br_aug.readLine_aug());
 return st_aug.nextToken_aug();
  }
    String_aug   nextLine_aug()   throws   IOException_aug  {
   return  br_aug.readLine_aug();
   }
  int   nextInt_aug() throws IOException_aug{
  return  Integer_aug.parseInt_aug(next_aug());
   }
    long nextLong_aug()  throws  NumberFormatException_aug,   IOException_aug {
  return Long_aug.parseLong_aug(next_aug());
  }
    double    nextDouble_aug()  throws   NumberFormatException_aug,  IOException_aug  {
    return   Double_aug.parseDouble_aug(next_aug());
   }
    }
}