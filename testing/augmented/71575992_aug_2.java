import java_aug.io_aug.*;

import   java_aug.util_aug.*;





public    class    Main_aug{

 static    int  getSum_aug(int   i_aug) {

    return  (i_aug*(i_aug+1))/2;

    }

  public static   void  main(String_aug[] args_aug)  throws   Exception_aug{

 MScanner_aug    sc_aug=new    MScanner_aug(System.in_aug);

   PrintWriter_aug  pw_aug=new  PrintWriter_aug(System.out);

 int    n_aug=sc_aug.nextInt_aug();

   if(n_aug==1) {

  pw_aug.println('?'+"    "+1+" "+1);

   pw_aug.flush_aug();

 String_aug  x_aug=sc_aug.nextLine_aug();

 pw_aug.println("!   "+x_aug);

    pw_aug.flush_aug();

   return;

    }

  HashMap_aug<String_aug, Integer_aug>occ_aug=new  HashMap_aug<String_aug, Integer_aug>();

   pw_aug.println("?  "+1+" "+n_aug);

   pw_aug.flush_aug();

   int substrings_aug=getSum_aug(n_aug);

 for(int    i_aug=0;i_aug<substrings_aug;i_aug++)    {

   String_aug   x_aug=sc_aug.nextLine_aug();

   char[]xs_aug=x_aug.toCharArray_aug();

  Arrays_aug.sort_aug(xs_aug);

  StringBuilder_aug    sb_aug=new StringBuilder_aug();

    for(char    c_aug:xs_aug) {

  sb_aug.append_aug(c_aug);

  }

    x_aug=sb_aug.toString_aug();

  occ_aug.put_aug(x_aug,   occ_aug.getOrDefault_aug(x_aug,   0)+1);

 }



    pw_aug.println("?    "+2+"   "+n_aug);

 pw_aug.flush_aug();



   substrings_aug=getSum_aug(n_aug-1);

   for(int   i_aug=0;i_aug<substrings_aug;i_aug++)    {

   String_aug   x_aug=sc_aug.nextLine_aug();

  char[]xs_aug=x_aug.toCharArray_aug();

 Arrays_aug.sort_aug(xs_aug);

    StringBuilder_aug sb_aug=new   StringBuilder_aug();

 for(char  c_aug:xs_aug)   {

  sb_aug.append_aug(c_aug);

 }

   x_aug=sb_aug.toString_aug();

   occ_aug.put_aug(x_aug, occ_aug.getOrDefault_aug(x_aug,  0)-1);

 }



  String_aug[]prefixes_aug=new  String_aug[n_aug];

 for(String_aug   x_aug:occ_aug.keySet_aug())  {

    if(occ_aug.get_aug(x_aug)==1)    {

  prefixes_aug[x_aug.length_aug()-1]=x_aug;

  }

   }

    StringBuilder_aug   ans_aug=new  StringBuilder_aug();

 for(int    i_aug=0;i_aug<n_aug;i_aug++) {

  int[]chars_aug=new int[26];

    for(int j_aug=0;j_aug<prefixes_aug[i_aug].length_aug();j_aug++)    {

  chars_aug[prefixes_aug[i_aug].charAt_aug(j_aug)-'a']++;

    }

    for(int j_aug=0;j_aug<ans_aug.length_aug();j_aug++)   {

   chars_aug[ans_aug.charAt_aug(j_aug)-'a']--;

 }

    for(int    j_aug=0;j_aug<26;j_aug++)  {

   if(chars_aug[j_aug]==1)    {

    char o_aug=(char)('a'+j_aug);

  ans_aug.append_aug(o_aug);

   break;

   }

  }

 }

    pw_aug.println("! "+ans_aug);

  pw_aug.flush_aug();

  }

 static    class  MScanner_aug   {

  StringTokenizer_aug  st_aug;

 BufferedReader_aug br_aug;

   public MScanner_aug(InputStream_aug    system_aug)    {

  br_aug  =   new    BufferedReader_aug(new    InputStreamReader_aug(system_aug));

  }



    public    MScanner_aug(String_aug  file_aug)    throws  Exception_aug   {

  br_aug  = new BufferedReader_aug(new    FileReader_aug(file_aug));

 }



    public    String_aug  next_aug()    throws  IOException_aug    {

 while    (st_aug    ==    null ||  !st_aug.hasMoreTokens_aug())

  st_aug   = new StringTokenizer_aug(br_aug.readLine_aug());

  return    st_aug.nextToken_aug();

   }

 public  int[]    takearr_aug(int  n_aug) throws   IOException_aug    {

    int[]in_aug=new  int[n_aug];for(int  i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

    return in_aug;

 }

 public  long[]  takearrl_aug(int  n_aug)   throws  IOException_aug   {

 long[]in_aug=new   long[n_aug];for(int i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

    return   in_aug;

    }

   public  Integer_aug[]   takearrobj_aug(int   n_aug)  throws    IOException_aug   {

    Integer_aug[]in_aug=new  Integer_aug[n_aug];for(int    i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextInt_aug();

  return    in_aug;

   }

 public   Long_aug[] takearrlobj_aug(int n_aug)    throws    IOException_aug {

   Long_aug[]in_aug=new Long_aug[n_aug];for(int    i_aug=0;i_aug<n_aug;i_aug++)in_aug[i_aug]=nextLong_aug();

 return in_aug;

    }

    public  String_aug   nextLine_aug()  throws    IOException_aug  {

  return br_aug.readLine_aug();

  }



 public    int   nextInt_aug()  throws  IOException_aug   {

    return  Integer_aug.parseInt_aug(next_aug());

   }



   public  double  nextDouble_aug()  throws   IOException_aug {

 return  Double_aug.parseDouble_aug(next_aug());

  }



    public char  nextChar_aug()  throws    IOException_aug {

    return  next_aug().charAt_aug(0);

   }



   public   Long_aug   nextLong_aug()  throws   IOException_aug  {

 return   Long_aug.parseLong_aug(next_aug());

 }



   public  boolean  ready_aug() throws    IOException_aug {

   return br_aug.ready_aug();

   }



   public  void    waitForInput_aug()   throws   InterruptedException_aug    {

    Thread_aug.sleep_aug(3000);

    }

   }

}