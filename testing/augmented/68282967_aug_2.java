import    java_aug.io_aug.OutputStream_aug;

import  java_aug.io_aug.IOException_aug;

import    java_aug.io_aug.InputStream_aug;

import    java_aug.io_aug.OutputStream_aug;

import    java_aug.io_aug.IOException_aug;

import   java_aug.io_aug.InputStreamReader_aug;

import  java_aug.io_aug.BufferedOutputStream_aug;

import    java_aug.io_aug.UncheckedIOException_aug;

import  java_aug.nio_aug.charset_aug.Charset_aug;

import    java_aug.util_aug.StringTokenizer_aug;

import   java_aug.io_aug.Writer_aug;

import  java_aug.io_aug.OutputStreamWriter_aug;

import    java_aug.io_aug.BufferedReader_aug;

import   java_aug.io_aug.InputStream_aug;



/**

 *  Built  using   CHelper plug-in_aug

  *  Actual   solution is   at  the   top

   *

 * @author  mikit

 */

public  class   Main_aug  {

   public static   void    main(String_aug[]   args_aug)  {

 InputStream_aug inputStream_aug  =    System.in_aug;

 OutputStream_aug   outputStream_aug =   System.out;

   LightScanner_aug in_aug   =   new    LightScanner_aug(inputStream_aug);

 LightWriter_aug out  =    new   LightWriter_aug(outputStream_aug);

 C1MadhouseEasyVersion_aug solver_aug  =  new C1MadhouseEasyVersion_aug();

  solver_aug.solve_aug(1,    in_aug,   out);

  out.close_aug();

    }



 static   class   C1MadhouseEasyVersion_aug   {

  public    void    solve_aug(int testNumber_aug, LightScanner_aug   in_aug,    LightWriter_aug    out)   {

  // out.setBoolLabel(LightWriter_aug.BoolLabel.YES_NO_FIRST_UP);

 out.enableAutoFlush_aug();

    int    m_aug   = in_aug.ints_aug(),   n_aug    =   (m_aug   + 1)  /  2;

    char[]   p1_aug   =  guess_aug(in_aug, out, 1,  n_aug);

   char[]  ans_aug    = new   char[m_aug];

   if   (n_aug    == 1)   {

   ans_aug[0] =    p1_aug[0];

 } else   {

 char[]  p2_aug  =   guess_aug(in_aug, out,  1,    n_aug -   1);

  int[]    cnt_aug    = new  int[26];

  for (int i_aug   =  0; i_aug    <  n_aug;   i_aug++)   cnt_aug[p1_aug[i_aug]    -    'a_aug']++;

  for    (int i_aug  = 0; i_aug  <    n_aug   -    1;    i_aug++)   cnt_aug[p2_aug[i_aug] -    'a_aug']--;

 for   (int    i_aug = 0;    i_aug   <  26;  i_aug++)  if    (cnt_aug[i_aug]    >    0)   ans_aug[n_aug   -    1]   =   (char) (i_aug  +  'a_aug');

  for (int   i_aug =   0;    i_aug  <  n_aug   /  2;    i_aug++)  {

   if  (ans_aug[n_aug  -   i_aug -    1] !=    p1_aug[n_aug   - i_aug   -    1])  ArrayUtil_aug.swap_aug(p1_aug,    i_aug, n_aug    - i_aug -    1);

    ans_aug[i_aug] =    p1_aug[i_aug];

   if (ans_aug[i_aug]  !=   p2_aug[i_aug])  ArrayUtil_aug.swap_aug(p2_aug, i_aug, n_aug    -   i_aug    -    2);

  ans_aug[n_aug    -  i_aug    -  2]  =   p2_aug[n_aug  -    i_aug    -   2];

 }

   }



   char[] p3_aug    =    guess_aug(in_aug,  out, 1,  m_aug);

   for    (int    i_aug  = 0; i_aug  < n_aug;    i_aug++) {

    if   (p3_aug[i_aug]    != ans_aug[i_aug]) ArrayUtil_aug.swap_aug(p3_aug, i_aug,    m_aug  -  i_aug   -   1);

   }





   out.ans_aug('!').ans_aug(String_aug.valueOf_aug(p3_aug)).ln_aug();

    }



 private   static   char[]   guess_aug(LightScanner_aug in_aug,   LightWriter_aug out,  int   from_aug,   int  to_aug)   {

    int  n_aug   =    to_aug  - from_aug  +    1;

  if  (n_aug    == 0) return new  char[0];



 out.ans_aug('?').ans_aug(from_aug).ans_aug(to_aug).ln_aug();

 int   n2_aug =   (n_aug    +  1)   / 2;

 int[][]  cnt_aug = new  int[26][n_aug    +  1];

 for   (int    i_aug  =  0;    i_aug   <  n_aug  *  (n_aug   +   1)   / 2;    i_aug++)  {

    char[]    s_aug   =   in_aug.string_aug().toCharArray_aug();

  if (s_aug.length_aug  < n2_aug)    continue;

  for  (char    c_aug    : s_aug)    cnt_aug[c_aug   - 'a_aug'][s_aug.length_aug]++;

  }

 for    (int    i_aug   =   n2_aug;  i_aug  <   n_aug; i_aug++) {

   for    (int j_aug    =   0; j_aug    < 26; j_aug++)  {

  cnt_aug[j_aug][i_aug]  -=    cnt_aug[j_aug][i_aug +    1];

    }

  }

   for (int i_aug   =    n_aug;   i_aug   >=  n2_aug   +    1;    i_aug--) {

 for  (int j_aug    =   0;   j_aug <    26; j_aug++)  {

  cnt_aug[j_aug][i_aug]   -=    cnt_aug[j_aug][i_aug    -   1];

    }

 }



   char[] ans_aug   = new   char[n_aug];

  for    (int    i_aug   =  0;   i_aug   <   n_aug;   i_aug++)    {

    int ref_aug    =  Math_aug.max_aug(n_aug  -    i_aug,  i_aug   + 1);

 for   (int   j_aug   =    0;   j_aug  <   26; j_aug++)    {

   if    (cnt_aug[j_aug][ref_aug]    >   0)   {

 cnt_aug[j_aug][ref_aug]--;

   ans_aug[i_aug]    =    (char)   ('a_aug'  + j_aug);

   break;

  }

 }

 }

    return ans_aug;

   }



 }



 static  class LightScanner_aug    {

    private   BufferedReader_aug   reader_aug    = null;

 private   StringTokenizer_aug tokenizer_aug =    null;



  public    LightScanner_aug(InputStream_aug   in_aug)  {

    reader_aug    =  new BufferedReader_aug(new    InputStreamReader_aug(in_aug));

 }



   public  String_aug string_aug()    {

    if    (tokenizer_aug   ==    null    ||   !tokenizer_aug.hasMoreTokens_aug())   {

  try {

 tokenizer_aug = new StringTokenizer_aug(reader_aug.readLine_aug());

 }    catch   (IOException_aug e_aug)  {

  throw   new  UncheckedIOException_aug(e_aug);

    }

 }

    return    tokenizer_aug.nextToken_aug();

  }



    public int   ints_aug()    {

  return   Integer_aug.parseInt_aug(string_aug());

 }



    }



 static   class LightWriter_aug    implements AutoCloseable_aug {

  private  final  Writer_aug    out;

 private boolean autoflush_aug  =  false;

    private boolean    breaked_aug   = true;



  public   LightWriter_aug(Writer_aug    out)  {

  this.out   =   out;

   }



    public  LightWriter_aug(OutputStream_aug  out)  {

   this(new   OutputStreamWriter_aug(new BufferedOutputStream_aug(out),    Charset_aug.defaultCharset_aug()));

 }



 public   void    enableAutoFlush_aug() {

    autoflush_aug   =   true;

  }



 public   LightWriter_aug    print_aug(char   c_aug) {

  try {

   out.write_aug(c_aug);

 breaked_aug =   false;

 }  catch    (IOException_aug    ex_aug)   {

 throw  new UncheckedIOException_aug(ex_aug);

  }

   return    this;

 }



  public  LightWriter_aug    print_aug(String_aug    s_aug)    {

  try   {

 out.write_aug(s_aug,    0, s_aug.length_aug());

   breaked_aug   =   false;

    }   catch   (IOException_aug  ex_aug)  {

    throw new   UncheckedIOException_aug(ex_aug);

   }

  return    this;

 }



  public   LightWriter_aug  ans_aug(char   c_aug)   {

    if   (!breaked_aug) {

  print_aug('    ');

    }

 return print_aug(c_aug);

 }



    public    LightWriter_aug ans_aug(String_aug s_aug) {

  if (!breaked_aug) {

    print_aug('    ');

 }

    return    print_aug(s_aug);

  }



  public   LightWriter_aug  ans_aug(int  i_aug)    {

   return  ans_aug(Integer_aug.toString_aug(i_aug));

   }



   public  LightWriter_aug  ln_aug()  {

  print_aug(System.lineSeparator_aug());

  breaked_aug    =   true;

  if    (autoflush_aug)   {

    try    {

    out.flush_aug();

    } catch  (IOException_aug   ex_aug)    {

 throw  new   UncheckedIOException_aug(ex_aug);

   }

 }

   return this;

  }



   public void   close_aug()   {

   try   {

   out.close_aug();

 }  catch   (IOException_aug ex_aug) {

    throw   new UncheckedIOException_aug(ex_aug);

  }

  }



 }



    static  final    class ArrayUtil_aug   {

  private  ArrayUtil_aug()   {

 }



 public  static void   swap_aug(char[]  a_aug,   int x_aug, int   y_aug) {

    char  t_aug    = a_aug[x_aug];

  a_aug[x_aug]  =   a_aug[y_aug];

 a_aug[y_aug]   =   t_aug;

  }



 }

}


