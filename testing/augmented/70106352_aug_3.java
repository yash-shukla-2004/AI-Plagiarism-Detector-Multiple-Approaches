import java_aug.math_aug.*;
import java_aug.io_aug.*;
import java_aug.util_aug.*;
import    java_aug.awt_aug.*;


//  Thanks  smit_mandavia

public class   CP_aug {
   public   static void main(String_aug[] args_aug)   throws Exception_aug    {
    new Solver_aug().solve_aug();
  }
}

class  Solver_aug  {
  final  Helper_aug   hp_aug;
   final int MAXN_aug  =  1000_006;
   final long   MOD_aug    =    (long)  1e9   +   7;

 Solver_aug()  {
  hp_aug  =  new Helper_aug(MOD_aug,    MAXN_aug);
   hp_aug.initIO_aug(System.in_aug,  System.out);
   }


    void    solve_aug()    throws    Exception_aug  {
    int    i_aug,    j_aug,   k_aug;

  char[]    S_aug   =  hp_aug.next_aug().toCharArray_aug();
 int   N_aug    =    S_aug.length_aug;

  BitSet_aug[] bs_aug    =   new    BitSet_aug[26];
 for  (i_aug  =    0;    i_aug  < 26; ++i_aug)    bs_aug[i_aug]  =    new BitSet_aug();
    for   (i_aug =  0;    i_aug < N_aug; ++i_aug)    bs_aug[S_aug[i_aug]    -  'a_aug'].set_aug(i_aug);

    int    Q_aug    =  hp_aug.nextInt_aug();
    while  (Q_aug--  > 0)   {
  int  l_aug   =    hp_aug.nextInt_aug() -   1,  r_aug  = hp_aug.nextInt_aug()  -   1,   len_aug   =   r_aug   -   l_aug + 1;
 if   (l_aug   == r_aug)    {
    hp_aug.println("Yes");
    }   else  if    (S_aug[l_aug]    == S_aug[r_aug]) {
 int    c_aug    =  0;
   for  (BitSet_aug   b_aug    :    bs_aug)  if (b_aug.previousSetBit_aug(r_aug) >=    l_aug) ++c_aug;
 hp_aug.println(c_aug  > 2 ?  "Yes"   :  "No");
    }    else    {
 hp_aug.println("Yes");
  }
 }

 hp_aug.flush_aug();
 }
}

class   Helper_aug  {
   final    long MOD_aug;
 final    int MAXN_aug;
  final Random_aug  rnd_aug;

  public  Helper_aug(long  mod_aug,    int    maxn_aug)    {
 MOD_aug =  mod_aug;
 MAXN_aug =   maxn_aug;
 rnd_aug =   new Random_aug();
  }


 public static    int[] sieve_aug;
   public static   ArrayList_aug<Integer_aug>    primes_aug;

 public   void setSieve_aug()  {
    primes_aug  =   new    ArrayList_aug<>();
  sieve_aug  = new    int[MAXN_aug];
   int i_aug,    j_aug;
  for  (i_aug    = 2;    i_aug   <   MAXN_aug;    ++i_aug)
   if (sieve_aug[i_aug]   == 0)  {
    primes_aug.add_aug(i_aug);
   for (j_aug   = i_aug;    j_aug <  MAXN_aug;    j_aug +=    i_aug) {
 sieve_aug[j_aug]    =    i_aug;
  }
    }
   }


  public   static long[]    factorial_aug;

  public   void    setFactorial_aug()    {
   factorial_aug  =    new    long[MAXN_aug];
  factorial_aug[0] =  1;
 for (int i_aug   =   1;   i_aug    <   MAXN_aug;   ++i_aug)    factorial_aug[i_aug]   = factorial_aug[i_aug    -    1]  *  i_aug  % MOD_aug;
   }

  public    long  getFactorial_aug(int  n_aug)    {
 if (factorial_aug  ==   null)    setFactorial_aug();
 return    factorial_aug[n_aug];
 }

  public   long  ncr_aug(int    n_aug,  int r_aug)   {
    if  (r_aug > n_aug)  return    0;
 if  (factorial_aug ==  null) setFactorial_aug();
  long    numerator_aug    =  factorial_aug[n_aug];
 long  denominator_aug  = factorial_aug[r_aug]  *    factorial_aug[n_aug   -    r_aug] %  MOD_aug;
    return   numerator_aug * pow_aug(denominator_aug,   MOD_aug  -   2, MOD_aug)    %    MOD_aug;
  }


  public    long[]    getLongArray_aug(int  size_aug)  throws  Exception_aug    {
   long[]  ar_aug   =    new   long[size_aug];
  for    (int i_aug =  0;    i_aug  < size_aug; ++i_aug)    ar_aug[i_aug]  =  nextLong_aug();
 return  ar_aug;
    }

    public   int[] getIntArray_aug(int  size_aug)    throws Exception_aug {
    int[]    ar_aug   = new   int[size_aug];
    for (int   i_aug    =  0;  i_aug < size_aug;  ++i_aug)  ar_aug[i_aug] = nextInt_aug();
  return ar_aug;
   }

    public  String_aug[]  getStringArray_aug(int    size_aug)  throws   Exception_aug   {
 String_aug[]    ar_aug =  new   String_aug[size_aug];
    for   (int  i_aug = 0;    i_aug <  size_aug; ++i_aug) ar_aug[i_aug]    =   next_aug();
 return  ar_aug;
   }

  public    String_aug  joinElements_aug(long[]   ar_aug) {
 StringBuilder_aug sb_aug =    new   StringBuilder_aug();
   for    (long   itr_aug  :   ar_aug) sb_aug.append_aug(itr_aug).append_aug("    ");
    return  sb_aug.toString_aug().trim_aug();
  }


    public  String_aug    joinElements_aug(int[]  ar_aug)  {
    StringBuilder_aug sb_aug = new  StringBuilder_aug();
  for  (int  itr_aug :   ar_aug)  sb_aug.append_aug(itr_aug).append_aug("    ");
  return    sb_aug.toString_aug().trim_aug();
 }

 public    String_aug    joinElements_aug(String_aug[]   ar_aug) {
    StringBuilder_aug    sb_aug   =    new    StringBuilder_aug();
    for  (String_aug    itr_aug  : ar_aug)    sb_aug.append_aug(itr_aug).append_aug("   ");
  return   sb_aug.toString_aug().trim_aug();
  }

  public String_aug    joinElements_aug(Object_aug[]  ar_aug)   {
  StringBuilder_aug sb_aug =   new  StringBuilder_aug();
  for   (Object_aug itr_aug    :  ar_aug)  sb_aug.append_aug(itr_aug).append_aug(" ");
    return    sb_aug.toString_aug().trim_aug();
 }


    public   long    gcd_aug(long    a_aug, long   b_aug)  {
    return   b_aug  ==    0    ?  a_aug    : gcd_aug(b_aug, a_aug    % b_aug);
  }

 public int  gcd_aug(int   a_aug, int  b_aug)    {
   return  b_aug    ==    0    ?    a_aug    : gcd_aug(b_aug,   a_aug    % b_aug);
  }


    public  long max_aug(long[] ar_aug) {
   long   ret_aug = ar_aug[0];
  for    (long   itr_aug   :  ar_aug) ret_aug  =   Math_aug.max_aug(ret_aug,    itr_aug);
   return    ret_aug;
    }

   public  int   max_aug(int[]    ar_aug) {
  int   ret_aug    = ar_aug[0];
   for    (int itr_aug : ar_aug) ret_aug   = Math_aug.max_aug(ret_aug,  itr_aug);
 return    ret_aug;
 }

 public    long   min_aug(long[] ar_aug)  {
  long ret_aug    =  ar_aug[0];
  for    (long   itr_aug    : ar_aug)  ret_aug   = Math_aug.min_aug(ret_aug,  itr_aug);
  return    ret_aug;
 }

    public int min_aug(int[] ar_aug) {
    int ret_aug   =  ar_aug[0];
 for    (int   itr_aug : ar_aug) ret_aug   =   Math_aug.min_aug(ret_aug,   itr_aug);
  return   ret_aug;
   }


 public long   sum_aug(long[] ar_aug)    {
   long  sum_aug    =    0;
 for  (long  itr_aug    :   ar_aug)    sum_aug += itr_aug;
 return    sum_aug;
    }

 public    long sum_aug(int[]    ar_aug)  {
  long    sum_aug    =    0;
   for (int itr_aug   :  ar_aug)   sum_aug    +=    itr_aug;
   return   sum_aug;
   }

  public  void shuffle_aug(int[] ar_aug)   {
  int    r_aug;
   for (int    i_aug   =   0; i_aug   < ar_aug.length_aug;   ++i_aug)  {
   r_aug =    rnd_aug.nextInt_aug(ar_aug.length_aug);
  if   (r_aug   != i_aug)    {
  ar_aug[i_aug]   ^= ar_aug[r_aug];
    ar_aug[r_aug]    ^= ar_aug[i_aug];
  ar_aug[i_aug]  ^=    ar_aug[r_aug];
    }
  }
  }

  public    void    shuffle_aug(long[]  ar_aug) {
   int  r_aug;
    for  (int  i_aug =  0;   i_aug   < ar_aug.length_aug;  ++i_aug)  {
 r_aug    = rnd_aug.nextInt_aug(ar_aug.length_aug);
   if   (r_aug    !=  i_aug)   {
  ar_aug[i_aug]  ^=    ar_aug[r_aug];
   ar_aug[r_aug]   ^=  ar_aug[i_aug];
  ar_aug[i_aug]    ^=    ar_aug[r_aug];
    }
    }
 }

   public  long  pow_aug(long   base_aug,  long   exp_aug, long    MOD_aug)  {
  base_aug %=   MOD_aug;
 long ret_aug = 1;
    while    (exp_aug   >  0)   {
 if   ((exp_aug    &    1)   ==   1)  ret_aug    = ret_aug    * base_aug   %    MOD_aug;
    base_aug =    base_aug    * base_aug %    MOD_aug;
    exp_aug    >>=  1;
  }
  return    ret_aug;
    }


   static    byte[] buf_aug    =  new    byte[2048];
  static  int   index_aug,    total_aug;
  static   InputStream_aug    in_aug;
  static  BufferedWriter_aug bw_aug;


   public   void    initIO_aug(InputStream_aug  is_aug,    OutputStream_aug  os_aug)    {
  try   {
    in_aug  =  is_aug;
  bw_aug   =  new   BufferedWriter_aug(new  OutputStreamWriter_aug(os_aug));
 }    catch (Exception_aug   e_aug)   {
    }
   }

  public void   initIO_aug(String_aug    inputFile_aug, String_aug outputFile_aug) {
  try   {
 in_aug  =   new  FileInputStream_aug(inputFile_aug);
    bw_aug =    new  BufferedWriter_aug(new    OutputStreamWriter_aug(
  new  FileOutputStream_aug(outputFile_aug)));
    }    catch    (Exception_aug   e_aug)    {
   }
  }

  private  int    scan_aug()  throws    Exception_aug {
   if  (index_aug  >=    total_aug)  {
   index_aug    =  0;
  total_aug    = in_aug.read_aug(buf_aug);
   if  (total_aug    <= 0)
    return  -1;
    }
    return   buf_aug[index_aug++];
    }

    public  String_aug   next_aug()   throws Exception_aug  {
   int  c_aug;
  for   (c_aug =   scan_aug();   c_aug  <=  32;  c_aug    =   scan_aug()) ;
    StringBuilder_aug   sb_aug  =    new   StringBuilder_aug();
 for (; c_aug  >    32;   c_aug  =   scan_aug())
  sb_aug.append_aug((char) c_aug);
   return   sb_aug.toString_aug();
  }

 public    int nextInt_aug() throws   Exception_aug   {
    int c_aug,  val_aug    =  0;
   for   (c_aug  =  scan_aug(); c_aug  <=   32;  c_aug  =  scan_aug())    ;
   boolean    neg_aug  = c_aug ==  '-';
 if (c_aug == '-'   ||   c_aug ==    '+')
    c_aug  =   scan_aug();
  for (; c_aug  >= '0'  &&  c_aug  <=    '9'; c_aug   =    scan_aug())
  val_aug    =  (val_aug    << 3)    +  (val_aug <<   1)  +    (c_aug    & 15);
  return   neg_aug ? -val_aug   :  val_aug;
    }

 public  long    nextLong_aug() throws   Exception_aug {
   int c_aug;
   long    val_aug = 0;
  for (c_aug   =  scan_aug(); c_aug   <=  32;   c_aug    = scan_aug())    ;
 boolean neg_aug  =    c_aug ==    '-';
 if  (c_aug  ==  '-'  ||    c_aug ==    '+')
   c_aug    =    scan_aug();
  for   (;   c_aug   >= '0'   &&  c_aug  <=  '9';  c_aug   =    scan_aug())
 val_aug    =  (val_aug    <<  3) + (val_aug  << 1)  +   (c_aug    &   15);
    return  neg_aug   ?    -val_aug :    val_aug;
   }

  public   void   print_aug(Object_aug  a_aug)   throws    Exception_aug    {
 bw_aug.write_aug(a_aug.toString_aug());
   }

    public   void  printsp_aug(Object_aug    a_aug)    throws Exception_aug    {
    print_aug(a_aug);
   print_aug("  ");
  }

   public void   println()    throws   Exception_aug    {
    bw_aug.write_aug("\n_aug");
   }

    public  void  println(Object_aug   a_aug) throws   Exception_aug  {
   print_aug(a_aug);
 println();
   }

 public  void    flush_aug() throws   Exception_aug  {
 bw_aug.flush_aug();
    }
}