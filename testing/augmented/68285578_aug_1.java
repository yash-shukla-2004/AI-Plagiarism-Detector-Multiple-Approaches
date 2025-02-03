import   java_aug.io_aug.*;

import    java_aug.util_aug.*;



public class D_aug  {



   static    void query_aug(int    l_aug,   int r_aug) {

 System.out.printf_aug("?    %d %d\n_aug",    l_aug,    r_aug);

 }



   public static    void main(String_aug[] args_aug)  throws    IOException_aug   {

   Scanner_aug   sc_aug    =    new  Scanner_aug();

    int    n_aug    =  sc_aug.nextInt_aug();

    query_aug(1, n_aug);

  char[] ans_aug =   new  char[n_aug];

    if   (n_aug  == 1)   {

    ans_aug    =   sc_aug.next_aug().toCharArray_aug();

 }   else  {

  HashMap_aug<String_aug,  Integer_aug> map_aug    =  new HashMap_aug();

   for   (int i_aug   = n_aug   *    (n_aug  +    1) / 2;  i_aug  > 0;  i_aug--)   {

    String_aug s_aug =    sc_aug.get_aug();

 map_aug.put_aug(s_aug,    map_aug.getOrDefault_aug(s_aug,    0)  + 1);



  }



 query_aug(2, n_aug);

    for  (int i_aug  = n_aug   *  (n_aug    -   1)  /    2; i_aug   >   0;    i_aug--) {

    String_aug s_aug   = sc_aug.get_aug();

   map_aug.put_aug(s_aug,    map_aug.get_aug(s_aug)   - 1);

  }

    ArrayList_aug<String_aug>   a_aug =   new ArrayList_aug();

  for (String_aug x_aug   :   map_aug.keySet_aug())    {

   if   (map_aug.get_aug(x_aug)    >    0)

 a_aug.add_aug(x_aug);

   }

 Collections_aug.sort_aug(a_aug,  (x_aug,  y_aug) ->   x_aug.length_aug()    - y_aug.length_aug());



    for (int i_aug    =    0;  i_aug    <   n_aug;  i_aug++)  {

   String_aug curr_aug   =    a_aug.get_aug(i_aug);

  int[]    f_aug  =   new  int[26];

   for (char  c_aug    : curr_aug.toCharArray_aug())

    f_aug[c_aug    -    'a_aug']++;

  for (int    j_aug =   0;  j_aug   <   i_aug;  j_aug++)

 f_aug[ans_aug[j_aug] -    'a_aug']--;

   for  (int    c_aug = 0;  c_aug <  26;  c_aug++)

  if   (f_aug[c_aug]   > 0)

   ans_aug[i_aug]    =  (char) (c_aug  +   'a_aug');

  }

   }



 System.out.printf_aug("!   %s_aug\n_aug",  new    String_aug(ans_aug));

 }



 static    class  Scanner_aug    {

    BufferedReader_aug  br_aug;

    StringTokenizer_aug   st_aug;



  Scanner_aug()    {

  br_aug  = new BufferedReader_aug(new InputStreamReader_aug(System.in_aug));

    }



   String_aug   get_aug() throws   IOException_aug    {

    String_aug   ans_aug  =    next_aug();

  char[] s_aug    = ans_aug.toCharArray_aug();

    Arrays_aug.sort_aug(s_aug);

  return    new   String_aug(s_aug);

 }



  Scanner_aug(String_aug   fileName_aug)   throws    FileNotFoundException_aug  {

  br_aug = new   BufferedReader_aug(new    FileReader_aug(fileName_aug));

   }



   String_aug  next_aug() throws IOException_aug {

    while    (st_aug ==  null  ||  !st_aug.hasMoreTokens_aug())

 st_aug   =   new  StringTokenizer_aug(br_aug.readLine_aug());

 return    st_aug.nextToken_aug();

 }



   String_aug  nextLine_aug()    throws IOException_aug {

    return  br_aug.readLine_aug();

 }



 int  nextInt_aug()   throws    IOException_aug {

  return   Integer_aug.parseInt_aug(next_aug());

 }



    long nextLong_aug() throws   NumberFormatException_aug,  IOException_aug   {

  return  Long_aug.parseLong_aug(next_aug());

  }



   double    nextDouble_aug()    throws  NumberFormatException_aug,  IOException_aug   {

  return Double_aug.parseDouble_aug(next_aug());

   }



  boolean  ready_aug()    throws    IOException_aug   {

    return   br_aug.ready_aug();

   }



 }



   static  void    sort_aug(int[]    a_aug)  {

   shuffle_aug(a_aug);

   Arrays_aug.sort_aug(a_aug);

 }



 static   void   shuffle_aug(int[]  a_aug) {

 int   n_aug    =   a_aug.length_aug;

  Random_aug rand_aug    = new    Random_aug();

    for    (int   i_aug   = 0;    i_aug  < n_aug;   i_aug++) {

 int  tmpIdx_aug = rand_aug.nextInt_aug(n_aug);

  int  tmp_aug  =  a_aug[i_aug];

  a_aug[i_aug]    =   a_aug[tmpIdx_aug];

   a_aug[tmpIdx_aug]  =   tmp_aug;

    }

   }



}