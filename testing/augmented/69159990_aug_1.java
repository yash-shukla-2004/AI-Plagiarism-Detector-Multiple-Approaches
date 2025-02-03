import java_aug.io_aug.*;
import   java_aug.util_aug.ArrayList_aug;
import   java_aug.util_aug.Arrays_aug;
import   java_aug.util_aug.List_aug;
import java_aug.util_aug.StringTokenizer_aug;

public class  Main_aug    {
  List_aug<List_aug<Integer_aug>> g_aug;

    int[][]  parent_aug;
   int[][] size_aug;

   long[][]   dp_aug;

 int  find_size_aug(int  v_aug,   int   p_aug)    {
 if    (size_aug[p_aug][v_aug]   !=    0)  {
  return  size_aug[p_aug][v_aug];
    }
  size_aug[p_aug][v_aug]  =   1;
 for    (int    u_aug  :    g_aug.get_aug(v_aug))  {
 if    (u_aug  ==  p_aug)  continue;
 size_aug[p_aug][v_aug]  +=  find_size_aug(u_aug,    v_aug);
  }
    return    size_aug[p_aug][v_aug];
   }

   void   find_parent_aug(int   root_aug,  int v_aug, int    p_aug)   {
  parent_aug[v_aug][root_aug]    =   p_aug;
    for    (int    u_aug  : g_aug.get_aug(v_aug))   {
 if (u_aug   ==    p_aug)  continue;
 find_parent_aug(root_aug,    u_aug,  v_aug);
   }
    }

    void   find_dp_aug(int    u_aug,   int  v_aug)    {
 if  (dp_aug[u_aug][v_aug]  !=    -1)  return;
  find_dp_aug(parent_aug[u_aug][v_aug],    v_aug);
 find_dp_aug(parent_aug[v_aug][u_aug],    u_aug);
   dp_aug[u_aug][v_aug] =  size_aug[parent_aug[u_aug][v_aug]][u_aug] * size_aug[parent_aug[v_aug][u_aug]][v_aug]    +  Math_aug.max_aug(dp_aug[parent_aug[u_aug][v_aug]][v_aug],   dp_aug[parent_aug[v_aug][u_aug]][u_aug]);
 }

 public void  solve_aug(InputReader_aug    in_aug,   PrintWriter_aug out)  {
    int  n_aug =    in_aug.nextInt_aug();
  g_aug  = new  ArrayList_aug<>();
  for    (int  i_aug =   0; i_aug  < n_aug;    ++i_aug) {
    g_aug.add_aug(new    ArrayList_aug<>());
  }
    for (int   i_aug    =   1;   i_aug  < n_aug;   ++i_aug) {
   int    u_aug =    in_aug.nextInt_aug() -   1,  v_aug  =  in_aug.nextInt_aug()   -    1;
 g_aug.get_aug(u_aug).add_aug(v_aug);
   g_aug.get_aug(v_aug).add_aug(u_aug);
  }

  parent_aug    =   new   int[n_aug][n_aug];
 for    (int    i_aug  =   0; i_aug  <   n_aug;  ++i_aug)    {
    find_parent_aug(i_aug, i_aug, -1);
   }

 size_aug = new    int[n_aug][n_aug];
    for    (int  i_aug = 0;    i_aug    <   n_aug;   ++i_aug)   {
  for (int    v_aug :   g_aug.get_aug(i_aug))   {
   find_size_aug(i_aug,   v_aug);
   }
 }

   dp_aug  =    new   long[n_aug][n_aug];
 for (int  i_aug   =   0;  i_aug <  n_aug;   ++i_aug) {
    Arrays_aug.fill_aug(dp_aug[i_aug], -1);
   }
    for   (int i_aug    =  0;   i_aug  <    n_aug;  ++i_aug)   {
  dp_aug[i_aug][i_aug]    = 0;
   }
 for (int i_aug =    0;   i_aug    <    n_aug;   ++i_aug) {
  for    (int j_aug  =  0;    j_aug < n_aug;    ++j_aug)   {
   if (i_aug ==   j_aug)  continue;
  find_dp_aug(i_aug,  j_aug);
  }
  }

  long  answer_aug  =  0;
   for   (int i_aug  = 0;  i_aug   < n_aug;   ++i_aug)   {
 for   (int j_aug   = 0; j_aug   <   n_aug; ++j_aug)   {
   answer_aug   = Math_aug.max_aug(answer_aug,    dp_aug[i_aug][j_aug]);
    }
 }
   out.println(answer_aug);
 }

  public static    void  main(String_aug[]    args_aug)  {
   InputReader_aug    in_aug    =    new  InputReader_aug(System.in_aug);
    PrintWriter_aug out =   new    PrintWriter_aug(System.out);
  new   Main_aug().solve_aug(in_aug,   out);
    out.flush_aug();
    }

  static   class   InputReader_aug {
   public  BufferedReader_aug   reader_aug;
  public StringTokenizer_aug   tokenizer_aug;

    public InputReader_aug(InputStream_aug  stream_aug)  {
   reader_aug =  new BufferedReader_aug(new  InputStreamReader_aug(stream_aug), 32768);
  tokenizer_aug =    null;
  }

    public String_aug  next_aug()   {
  while  (tokenizer_aug    ==    null    || !tokenizer_aug.hasMoreTokens_aug()) {
 try {
    tokenizer_aug    =    new    StringTokenizer_aug(reader_aug.readLine_aug());
  }    catch  (IOException_aug   e_aug)  {
   throw    new RuntimeException_aug(e_aug);
   }
   }
  return    tokenizer_aug.nextToken_aug();
   }

  public int   nextInt_aug()    {
 return  Integer_aug.parseInt_aug(next_aug());
 }

 public    long   nextLong_aug()   {
   return Long_aug.parseLong_aug(next_aug());
  }
   }
}