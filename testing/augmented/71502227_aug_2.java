import   java_aug.io_aug.*;

import    java_aug.text_aug.DecimalFormat_aug;

import    java_aug.util_aug.ArrayList_aug;

import   java_aug.util_aug.Locale_aug;

import java_aug.util_aug.StringTokenizer_aug;

import   java_aug.util_aug.stream_aug.IntStream_aug;



public class  Main_aug   {



   static {

  Locale_aug.setDefault_aug(Locale_aug.ENGLISH_aug);

   }



   private    static    DecimalFormat_aug  decimalFormat_aug =  new    DecimalFormat_aug("#0.00000000");



 private static   class   Reader_aug  implements  Closeable_aug   {



  private BufferedReader_aug   reader_aug;

    private  StringTokenizer_aug   tokenizer_aug;



    public Reader_aug()   {

   reader_aug  = new   BufferedReader_aug(new InputStreamReader_aug(System.in_aug));

   }



   public Reader_aug(String_aug fileName_aug)    {

    try   {

  reader_aug  =    new   BufferedReader_aug(new   FileReader_aug(fileName_aug));

   }   catch  (FileNotFoundException_aug    e_aug)    {

  throw  new IllegalStateException_aug("There is    no    file with given name");

  }

  }



 public  String_aug  nextToken_aug()    {

    while  (tokenizer_aug    ==   null    ||  !tokenizer_aug.hasMoreTokens_aug())    {

    try   {

 String_aug    nextLine_aug   = reader_aug.readLine_aug();

 if (nextLine_aug  ==    null)   {

 return  null;

    }

   tokenizer_aug =  new   StringTokenizer_aug(nextLine_aug);

 }    catch   (IOException_aug  e_aug) {

 throw  new IllegalStateException_aug("I/O  Error");

  }

   }

 return  tokenizer_aug.nextToken_aug();

   }



  public int nextInt_aug() {

    return  Integer_aug.parseInt_aug(nextToken_aug());

 }



    public    long  nextLong_aug()  {

 return    Long_aug.parseLong_aug(nextToken_aug());

 }



 public  double nextDouble_aug()    {

 return Double_aug.parseDouble_aug(nextToken_aug());

 }



 @Override_aug

  public void    close_aug()  throws    IOException_aug  {

   reader_aug.close_aug();

   }

   }



  private  static   class  Pair_aug    implements   Comparable_aug<Pair_aug> {



 private  int  x_aug;

   private  int   y_aug;



 public    Pair_aug(int    x_aug,   int   y_aug)   {

 this.x_aug = x_aug;

    this.y_aug  =   y_aug;

  }



   public int  getX_aug()  {

   return   x_aug;

 }



  public int    getY_aug()    {

    return   y_aug;

   }



   @Override_aug

  public  int    compareTo_aug(Pair_aug o_aug)    {

    if   (this.x_aug    !=  o_aug.x_aug)   return Integer_aug.compare_aug(this.x_aug,  o_aug.x_aug);

 return   Integer_aug.compare_aug(this.y_aug,    o_aug.y_aug);

 }

    }



    private  <T_aug>    ArrayList_aug<T_aug> createArrayList_aug(int   n_aug,   T_aug    value_aug)   {

 ArrayList_aug<T_aug>   result_aug   =   new  ArrayList_aug<>();

    IntStream_aug.range_aug(0,   n_aug).forEach_aug(i_aug -> result_aug.add_aug(value_aug));

   return  result_aug;

    }



  public   static   void    main(String_aug[]    args_aug)  throws IOException_aug  {

  Reader_aug reader_aug  =  new Reader_aug();

  //Reader_aug  reader_aug   =    new    Reader_aug("input.txt");

 PrintWriter_aug    writer_aug =  new   PrintWriter_aug(System.out);

    new Main_aug().solve_aug(reader_aug,   writer_aug);

  reader_aug.close_aug();

   writer_aug.close_aug();

  }



   private    static    class Cow_aug   {



  private  int    l_aug;

 private int r_aug;



  public    Cow_aug(int   l_aug,   int  r_aug)  {

  this.l_aug   =    l_aug;

  this.r_aug    = r_aug;

   }



 public int  getL_aug()   {

    return  l_aug;

  }



    public  int getR_aug() {

 return r_aug;

    }



   }



  private   void solve_aug(Reader_aug reader_aug,    PrintWriter_aug  writer_aug)   {

  int   n_aug    =    reader_aug.nextInt_aug();

   int  m_aug =    reader_aug.nextInt_aug();

    ArrayList_aug<Integer_aug>    s_aug  = new   ArrayList_aug<>();

  boolean[]   s1_aug    =  new    boolean[5001];

    boolean[] s2_aug    =   new  boolean[5001];

   for (int i_aug   =    0; i_aug   <    n_aug;   ++i_aug)   {

   s_aug.add_aug(reader_aug.nextInt_aug());

   s1_aug[s_aug.get_aug(s_aug.size_aug()   -   1)] =    true;

 }



   ArrayList_aug<Cow_aug>[] cowsByF_aug   =  new  ArrayList_aug[5001];

 for    (int i_aug = 1; i_aug    <=   n_aug;  ++i_aug)  {

   cowsByF_aug[i_aug]   =    new ArrayList_aug<>();

  }



    boolean[]   used_aug =  new boolean[5000];



 for (int    i_aug   = 0;    i_aug  < m_aug;    ++i_aug)  {

   int f_aug    = reader_aug.nextInt_aug();

    int    h_aug   = reader_aug.nextInt_aug();

  int    l_aug    = -1;

  int   r_aug   =   -1;

  s2_aug[f_aug]    =    true;



 int counter_aug    =    0;

    for (int    j_aug =    0;   j_aug   < n_aug; ++j_aug)    {

  if    (s_aug.get_aug(j_aug)    == f_aug)    {

  counter_aug++;

    if  (counter_aug  ==   h_aug)    {

 l_aug  = j_aug;

    break;

 }

 }

 }



    counter_aug   = 0;

   for   (int j_aug =   n_aug  - 1;  j_aug    >=   0;   --j_aug)    {

 if  (s_aug.get_aug(j_aug)   == f_aug) {

    counter_aug++;

 if   (counter_aug   == h_aug)  {

    r_aug =   j_aug;

   break;

   }

   }

 }



    if   (l_aug   !=    -1) {

  used_aug[l_aug] =   true;

    cowsByF_aug[f_aug].add_aug(new Cow_aug(l_aug,  r_aug));

  }

    }



  int   bestResult_aug    = 0;

  long   bestCount_aug   =  0;



 for    (int  i_aug    =    -1;    i_aug  < n_aug;   ++i_aug)    {  //граница   разделения

  if  (i_aug   >   -1    &&  !used_aug[i_aug])  {

 continue;

  }

 int    result_aug  =   0;

  long  count_aug   =   1;

 boolean  usedProperCow_aug    = false;

  for    (int   j_aug   = 1;  j_aug  <=    n_aug;   ++j_aug)   {  //уровень сладости

  //if  (!s1_aug[j_aug] &&    !s2_aug[j_aug]) {

 //   continue;

 //}

   boolean    usedProperCowAtJ_aug =   false;

 int   l_aug =  0;

   int  r_aug  =   0;

  int   mixed_aug  =    0;

  for    (Cow_aug cow_aug  :    cowsByF_aug[j_aug])    {

    if (cow_aug.l_aug    ==  i_aug)    {

  usedProperCow_aug    =  true;

  usedProperCowAtJ_aug    =   true;

    continue;

   }

    if (cow_aug.l_aug    <= i_aug   &&   cow_aug.r_aug    <=   i_aug)    {

    l_aug++;

  }

 if (cow_aug.l_aug   >    i_aug &&    cow_aug.r_aug >   i_aug) {

   r_aug++;

 }

 if (cow_aug.l_aug    <=    i_aug   &&   cow_aug.r_aug   >  i_aug)   {

    mixed_aug++;

    }

   }

   if    (usedProperCowAtJ_aug)   {

    if  (r_aug +    mixed_aug    ==    0)   {

 result_aug +=   1;

 continue;

 }    else  {

 result_aug +=    2;

    int  mult_aug =    r_aug    +  mixed_aug;

   count_aug  *=   mult_aug;

   if (count_aug > 1000000007)    {

   count_aug    %=   1000000007;

   }

    continue;

 }

    }

  if   (l_aug  +   r_aug    +  mixed_aug ==   0)   {

  continue;

  }

  if    (mixed_aug +   (l_aug  >  0   ?   1    :  0)  +  (r_aug  >    0    ? 1    :  0)    >   1)    {

 result_aug   += 2;

    int  mult_aug  =  l_aug  * mixed_aug    +    r_aug   *    mixed_aug   +    mixed_aug  *    (mixed_aug    - 1);

 count_aug    *=    mult_aug;

   }   else   {

 result_aug += 1;

    int  mult_aug    =    l_aug    +   r_aug    +   mixed_aug   *  2;

 count_aug  *=   mult_aug;

  }

  if   (count_aug   >   1000000007) {

 count_aug  %=    1000000007;

 }

  }

   if    (result_aug >   bestResult_aug)   {

  bestResult_aug   =    result_aug;

  bestCount_aug   =  count_aug;

  }    else if    (result_aug  ==   bestResult_aug   &&    (i_aug ==    -1    ||    usedProperCow_aug))    {

    bestCount_aug   += count_aug;

   bestCount_aug   %= 1000000007;

   }

  }

   writer_aug.println(bestResult_aug  +  "    "   +  bestCount_aug);

   }



}
