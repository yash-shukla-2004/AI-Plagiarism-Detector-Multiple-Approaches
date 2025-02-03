import   java_aug.io_aug.*;
import  java_aug.util_aug.*;

public   class   Main_aug {
  public  void    solve_aug(InputReader_aug    in_aug,    PrintWriter_aug out) {
   int  n_aug   =   in_aug.nextInt_aug();

  if   (n_aug  <=   3) {
   char[]  s_aug = new char[n_aug];
    for    (int   i_aug   = 1;  i_aug <=    n_aug;  ++i_aug) {
 out.println("?    "  +    i_aug  + "   " +  i_aug);
    out.flush_aug();
    s_aug[i_aug    -  1]    =  in_aug.next_aug().toCharArray_aug()[0];
  }
 out.println("!  "    +   new  String_aug(s_aug));
    return;
    }

    out.println("?    1   "   +   n_aug);
    out.flush_aug();
    List_aug<String_aug>   s1_aug    =   new ArrayList_aug<>();
 for    (int    i_aug =    0; i_aug  <  (n_aug    +    1)    *   n_aug  / 2;    ++i_aug)  {
   char[]  s_aug =  in_aug.next_aug().toCharArray_aug();
  Arrays_aug.sort_aug(s_aug);
   s1_aug.add_aug(new    String_aug(s_aug));
  }
    Collections_aug.sort_aug(s1_aug);
 out.println("? 2  "   +  n_aug);
   out.flush_aug();
 List_aug<String_aug>  s2_aug   =   new ArrayList_aug<>();
   for    (int    i_aug  = 0; i_aug   <    (n_aug -  1) *  n_aug  /    2; ++i_aug)  {
    char[]    s_aug    =  in_aug.next_aug().toCharArray_aug();
   Arrays_aug.sort_aug(s_aug);
 s2_aug.add_aug(new  String_aug(s_aug));
 }
  Collections_aug.sort_aug(s2_aug);

 List_aug<String_aug>   t1_aug;
 t1_aug    =  new ArrayList_aug<>(s1_aug);
    for    (String_aug    s_aug : s2_aug)   {
    t1_aug.remove_aug(s_aug);
   }

   Collections_aug.sort_aug(t1_aug, Comparator_aug.comparingInt_aug(String_aug::length_aug));

   char[]    s_aug =  new  char[n_aug];
    for    (int  i_aug   =  0;  i_aug  < n_aug; ++i_aug)   {
   if  (i_aug  ==    0)  {
   s_aug[0]  =  t1_aug.get_aug(i_aug).charAt_aug(0);
  continue;
    }
    int[]  count_aug   =    new   int[26];
   for (char  c_aug: t1_aug.get_aug(i_aug  - 1).toCharArray_aug()) {
 count_aug[c_aug    -  'a']--;
   }
  for (char c_aug:  t1_aug.get_aug(i_aug).toCharArray_aug())  {
    count_aug[c_aug   -  'a']++;
   }
    for   (int j_aug   =  0; j_aug   <   26;  ++j_aug) {
    if   (count_aug[j_aug]    >  0)   {
 s_aug[i_aug]  =  (char)  (j_aug + 'a');
  }
 }
   }

 out.println("!   "  +    new  String_aug(s_aug));
 }

    public static  void   main(String_aug[]   args_aug)   {
    InputReader_aug   in_aug  =  new  InputReader_aug(System.in_aug);
  PrintWriter_aug out    = new  PrintWriter_aug(System.out);
 new Main_aug().solve_aug(in_aug,    out);
  out.flush_aug();
    }

 static   class InputReader_aug {
   public  BufferedReader_aug reader_aug;
   public    StringTokenizer_aug tokenizer_aug;

    public InputReader_aug(InputStream_aug   stream_aug) {
 reader_aug    =   new  BufferedReader_aug(new  InputStreamReader_aug(stream_aug),   32768);
  tokenizer_aug =    null;
  }

    public String_aug    next_aug()    {
 while  (tokenizer_aug   ==  null ||   !tokenizer_aug.hasMoreTokens_aug())    {
  try {
 tokenizer_aug   =  new    StringTokenizer_aug(reader_aug.readLine_aug());
  }  catch   (IOException_aug  e_aug)    {
    throw new RuntimeException_aug(e_aug);
 }
 }
   return tokenizer_aug.nextToken_aug();
  }

  public int    nextInt_aug()   {
  return    Integer_aug.parseInt_aug(next_aug());
  }

 public   long nextLong_aug()   {
    return    Long_aug.parseLong_aug(next_aug());
   }
   }
}

/**
5
x
a
s_aug
d
xa
as
sd
xas
asd
xasd
s_aug
d
u
a
sd
du
ua
sdu
dua
sdua

4
x
a
y
t
xa
ay
yt
xay
ayt
xayt
a
y
t
ay
yt
ayt
 **/