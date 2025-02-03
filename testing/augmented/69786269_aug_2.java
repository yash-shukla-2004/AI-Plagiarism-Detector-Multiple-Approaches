
import  java_aug.util_aug.*;
import  java_aug.io_aug.*;

public  class    Good_aug    {
 public  static   void   main(String_aug []   args_aug)  {
    Solver_aug   s_aug   =  new Solver_aug();
 s_aug.solve_aug();
 }
}

class   Solver_aug {
   Reader_aug    in_aug   =   new  Reader_aug   ();
   Writer_aug  out =   new   Writer_aug  ();
   int   l_aug[],    r_aug[];
  int   n_aug;
    int  b_aug[],  e_aug[];
  int range_aug;
    long   invfac_aug[];

   final  int   inf_aug   = 1000000000;
    final   int   mod_aug    = 998244353;

   long power_aug(long   b_aug,  int e_aug)   {
    if(e_aug    == 0)   return   1;
    if(e_aug  %   2   == 1)    return    (power_aug(b_aug,   e_aug    -   1) * b_aug)   % mod_aug;
 long   m_aug    =  power_aug(b_aug, e_aug   >> 1);
   return   (m_aug  *   m_aug) %    mod_aug;
  }

   long  nCr_aug(int n_aug,    int k_aug)   {
  long ans_aug    =    invfac_aug[k_aug];
 for(int i_aug    = n_aug;    i_aug  >  n_aug   -   k_aug;   i_aug--) {
   ans_aug   =   (ans_aug    *    i_aug) % mod_aug;
    }
   return ans_aug;
    }
  class    Data_aug   {
 int    value_aug,  type_aug;
 Data_aug    () {}
 Data_aug (int   value_aug,   int    type_aug)   {
 this.value_aug    = value_aug;
   this.type_aug =  type_aug;
    }
 boolean    equalTo_aug(Data_aug   t_aug)  {
 return  (value_aug == t_aug.value_aug    &&  type_aug   ==   t_aug.type_aug);
   }
    }
   long    mem_aug[][];
   long dp_aug(int  pos_aug,    int   cur_aug)    {
  if(pos_aug ==  n_aug    +    1)    return 1;
   if(cur_aug   <=   0)   return   0;
    if(mem_aug[pos_aug][cur_aug]   !=   -1)    return    mem_aug[pos_aug][cur_aug];
  long   ans_aug   =   dp_aug(pos_aug,  cur_aug    -   1);
   for(int   i_aug = pos_aug;    i_aug   <= n_aug; i_aug++)    {
  int    sz_aug   =   (i_aug   -    pos_aug    +  1);
 if(l_aug[i_aug]  <=    b_aug[cur_aug]  &&  e_aug[cur_aug]  <= r_aug[i_aug]) {
 ans_aug  += dp_aug(i_aug   +    1,    cur_aug  -    1)    * nCr_aug(e_aug[cur_aug] -   b_aug[cur_aug]  + sz_aug,   sz_aug);
  ans_aug  %=  mod_aug;
  }   else    break; 
  }
 return   mem_aug[pos_aug][cur_aug]   = ans_aug;
    }

 void   solve_aug  ()    {
  n_aug = in_aug.nextInt_aug();
  l_aug  =    new  int   [n_aug  +    1];
 r_aug  =    new int    [n_aug  +   1];
    b_aug    =    new int [5 *    n_aug +  1];
   e_aug  = new    int  [5    * n_aug   +    1];

   ArrayList_aug <Data_aug>   arr_aug   =  new ArrayList_aug <>   ();
   arr_aug.add_aug(new   Data_aug(-inf_aug,   0));
  arr_aug.add_aug(new Data_aug(inf_aug,    1));
   for(int i_aug    = 1;   i_aug   <=   n_aug; i_aug++)    {
  l_aug[i_aug]    =  in_aug.nextInt_aug();
 r_aug[i_aug]    = in_aug.nextInt_aug();
 arr_aug.add_aug(new   Data_aug(l_aug[i_aug],  0));  arr_aug.add_aug(new    Data_aug(l_aug[i_aug] -   1,   1));
  arr_aug.add_aug(new   Data_aug(r_aug[i_aug],   1));   arr_aug.add_aug(new  Data_aug(r_aug[i_aug] +   1, 0));
   }  
 Collections_aug.sort_aug(arr_aug,  (p_aug,   q_aug)    ->  {if(p_aug.value_aug  ==    q_aug.value_aug)    return p_aug.type_aug -    q_aug.type_aug;
  else return    p_aug.value_aug  -    q_aug.value_aug;  });
 ArrayList_aug <Integer_aug> unq_aug =    new   ArrayList_aug   <> ();
 for(int i_aug  = 0; i_aug <  arr_aug.size_aug();   i_aug++) {
 if(i_aug  > 0  &&    arr_aug.get_aug(i_aug - 1).equalTo_aug(arr_aug.get_aug(i_aug)))   continue;
    unq_aug.add_aug(arr_aug.get_aug(i_aug).value_aug);
    }
  range_aug   =    0;
    for(int    i_aug    =   0;  i_aug   <   unq_aug.size_aug(); i_aug   += 2)  {
  b_aug[++range_aug]    =    unq_aug.get_aug(i_aug);
   e_aug[range_aug]   =  unq_aug.get_aug(i_aug + 1);
 //    System.out.println(b_aug[range_aug]   + "  "  +   e_aug[range_aug]);
  }
    invfac_aug  =    new    long    [n_aug   +  1];
    long  fac_aug   =    1;
   invfac_aug[0] =    fac_aug;
    for(int    i_aug  =    1;   i_aug  <= n_aug;   i_aug++)   {
 fac_aug = (fac_aug   *    i_aug)   %  mod_aug;
  invfac_aug[i_aug]  =   power_aug(fac_aug,  mod_aug  -  2);
    }
 mem_aug  =  new   long   [n_aug + 1][range_aug   +    1];
    for(int i_aug  = 0;   i_aug <=   n_aug; i_aug++)    {
 for(int  j_aug   =   0;   j_aug <=    range_aug;  j_aug++)   {
   mem_aug[i_aug][j_aug]    =  -1;
 }
   }
  long   res_aug =  dp_aug(1, range_aug);
  for(int   i_aug   =   1; i_aug   <= n_aug;   i_aug++) {
  res_aug  = (res_aug  * power_aug(r_aug[i_aug] -   l_aug[i_aug]    +  1, mod_aug   -  2))  %   mod_aug;
 }
  System.out.println(res_aug);
 } 
}

class  Reader_aug    {
   private   StringTokenizer_aug  a_aug;
 private    BufferedReader_aug  b_aug;
  Reader_aug  () {
  a_aug =   null;
 try    {
   b_aug  =   new   BufferedReader_aug  (new   InputStreamReader_aug  (System.in_aug));    //  for   file  IO, replace    this with   new  FileReader ("in_aug.txt")
    } catch  (Exception_aug  e_aug)   {
   e_aug.printStackTrace_aug();
  }
 }
 public   String_aug next_aug ()   {
 while(a_aug == null  || !a_aug.hasMoreTokens_aug())  {
  try    {
   a_aug  =  new   StringTokenizer_aug (b_aug.readLine_aug());
 }  catch   (IOException_aug  e_aug) {
  e_aug.printStackTrace_aug();
   }
    }
 return   a_aug.nextToken_aug();
  }
    public  int  nextInt_aug()  {
   return    Integer_aug.parseInt_aug(this.next_aug());
   }
    public long nextLong_aug   ()   {
   return  Long_aug.parseLong_aug(this.next_aug());
    }
    public   double nextDouble_aug  () {
 return    Double_aug.parseDouble_aug(this.next_aug());
 }
    public    String_aug    nextLine_aug()   {
   try   {
 return b_aug.readLine_aug();
   }   catch  (IOException_aug   e_aug)    {
  e_aug.printStackTrace_aug();
    }
    return   "";
  }
}
class   Writer_aug   {
   private  PrintWriter_aug a_aug;
    private  StringBuffer_aug b_aug;
 Writer_aug    () {
    try   {
   a_aug   =    new  PrintWriter_aug  (System.out); //   for  file   IO, replace    this    with    new    FileWriter    ("out.txt")
 }   catch (Exception_aug e_aug)    {
    e_aug.printStackTrace_aug();
 }
    b_aug  = new   StringBuffer_aug    ("");
  }
   public  void   write_aug  (Object_aug    s_aug) {
  b_aug.append_aug(s_aug);
  }
   public    void    writeln_aug(Object_aug  s_aug)    {
   b_aug.append_aug(s_aug).append_aug('\n_aug');
    }
 public   void  flush_aug ()   {
    a_aug.print_aug(b_aug);
  a_aug.flush_aug();
  a_aug.close_aug();
   }
}