import    java_aug.io_aug.*;

import   java_aug.lang_aug.reflect_aug.Array_aug;

import  java_aug.util_aug.*;



public    class  A_aug {

   FastScanner_aug  in_aug;

  PrintWriter_aug  out;



  int[]    parent_aug;

 int[] parentSameColor_aug;

   int[] sizeWhite_aug;

  int[]    sizeBlack_aug;

   boolean[]   canChangeColor_aug;

    int[]    color_aug;



   int    res_aug;



 int getRoot_aug(int id_aug) {

 if    (parent_aug[id_aug]    !=  id_aug)    {

 getColor_aug(parent_aug[id_aug]);

 parentSameColor_aug[id_aug]    ^=   parentSameColor_aug[parent_aug[id_aug]];

 parent_aug[id_aug]   =  parent_aug[parent_aug[id_aug]];

   }

   return   parent_aug[id_aug];

   }



    int getColor_aug(int id_aug)   {

 if (parent_aug[id_aug]    !=  id_aug) {

    getColor_aug(parent_aug[id_aug]);

 parentSameColor_aug[id_aug]    ^= parentSameColor_aug[parent_aug[id_aug]];

    parent_aug[id_aug]  =  parent_aug[parent_aug[id_aug]];

 }

   return   color_aug[parent_aug[id_aug]] ^  parentSameColor_aug[id_aug];

   }



   void    fixColor_aug(int  v_aug)  {

 v_aug =   getRoot_aug(v_aug);

    canChangeColor_aug[v_aug]   =  false;

  }



  void swapColor_aug(int  v_aug)  {

 v_aug   = getRoot_aug(v_aug);

  if (!canChangeColor_aug[v_aug])    {

    throw    new  AssertionError_aug();

  }

 res_aug   -=    sizeBlack_aug[v_aug];

    res_aug  +=    sizeWhite_aug[v_aug];

 int   tmp_aug =    sizeBlack_aug[v_aug];

 sizeBlack_aug[v_aug] = sizeWhite_aug[v_aug];

   sizeWhite_aug[v_aug] = tmp_aug;

   color_aug[v_aug]    =   1 -    color_aug[v_aug];

    }



  void solve_aug() {

  int  n_aug    =  in_aug.nextInt_aug();

    int  k_aug  =  in_aug.nextInt_aug();

  boolean[] on_aug    = new   boolean[n_aug];

   String_aug  s_aug   =  in_aug.next_aug();

    for  (int  i_aug   = 0;   i_aug <   n_aug;    i_aug++)    {

    on_aug[i_aug] = s_aug.charAt_aug(i_aug) == '1';

  }

    List_aug<Integer_aug>[]    g_aug   =    new   List_aug[n_aug];

    for    (int  i_aug    =  0;   i_aug   <   n_aug;  i_aug++)   {

    g_aug[i_aug] = new    ArrayList_aug<>();

    }

   for    (int    i_aug =  0;  i_aug    < k_aug;    i_aug++) {

   int  cnt_aug   = in_aug.nextInt_aug();

    for   (int j_aug  =    0;   j_aug    <    cnt_aug;    j_aug++)   {

   g_aug[in_aug.nextInt_aug() -  1].add_aug(i_aug);

  }

    }

   parent_aug  =   new    int[k_aug];

 color_aug    =new  int[k_aug];

  for (int i_aug   =   0;  i_aug <    k_aug; i_aug++) {

    parent_aug[i_aug]    =    i_aug;

  }

   parentSameColor_aug  = new  int[k_aug];

  sizeBlack_aug  = new int[k_aug];

    sizeWhite_aug    =   new    int[k_aug];

    Arrays_aug.fill_aug(sizeWhite_aug, 1);

 canChangeColor_aug =    new boolean[k_aug];

  Arrays_aug.fill_aug(canChangeColor_aug,  true);

 for    (int i_aug  =   0; i_aug  < n_aug;    i_aug++)   {

 int    curColor_aug    =    on_aug[i_aug] ?    1 : 0;

   if    (g_aug[i_aug].isEmpty_aug())  {

    if (curColor_aug !=  1)    {

   throw  new   AssertionError_aug();

  }

    }   else    if  (g_aug[i_aug].size_aug()  ==  1)   {

 int  comp_aug  =    g_aug[i_aug].get_aug(0);

    curColor_aug   ^= getColor_aug(comp_aug);

   if   (curColor_aug  !=  1)   {

   swapColor_aug(comp_aug);

 }

   fixColor_aug(comp_aug);

    }   else    if (g_aug[i_aug].size_aug() ==  2) {

    int  v1_aug = g_aug[i_aug].get_aug(0), v2_aug =   g_aug[i_aug].get_aug(1);

    curColor_aug   ^=   getColor_aug(v1_aug);

    curColor_aug  ^=  getColor_aug(v2_aug);

 v1_aug   =  getRoot_aug(v1_aug);

  v2_aug   =    getRoot_aug(v2_aug);

    if  (curColor_aug   !=    1) {

  if    (v1_aug  ==   v2_aug)    {

   throw    new    AssertionError_aug();

  }

 if (!canChangeColor_aug[v1_aug]   &&  !canChangeColor_aug[v2_aug]) {

   throw  new AssertionError_aug();

 }

   if   (!canChangeColor_aug[v1_aug])  {

   swapColor_aug(v2_aug);

    }   else  if    (!canChangeColor_aug[v2_aug])  {

   swapColor_aug(v1_aug);

  } else {

    int    v1SwapCost_aug  =  sizeWhite_aug[v1_aug]   -  sizeBlack_aug[v1_aug];

 int   v2SwapCost_aug  = sizeWhite_aug[v2_aug] - sizeBlack_aug[v2_aug];

    if   (v1SwapCost_aug  < v2SwapCost_aug)  {

 swapColor_aug(v1_aug);

   }   else   {

   swapColor_aug(v2_aug);

 }

  }

  }

 if   (v1_aug !=   v2_aug)    {

  parentSameColor_aug[v1_aug] = getColor_aug(v1_aug)    ^   getColor_aug(v2_aug);

    parent_aug[v1_aug]    =   v2_aug;

//    if (parentSameColor_aug[v1_aug]   == 0) {

 sizeBlack_aug[v2_aug]   += sizeBlack_aug[v1_aug];

  sizeWhite_aug[v2_aug] += sizeWhite_aug[v1_aug];

//   } else {

//    sizeBlack_aug[v2_aug] +=  sizeWhite_aug[v1_aug];

//  sizeWhite_aug[v2_aug] +=  sizeBlack_aug[v1_aug];

//   }

    canChangeColor_aug[v2_aug]   &=  canChangeColor_aug[v1_aug];

   }

  }   else {

 throw  new AssertionError_aug();

    }

    out.println(res_aug);

//   System.err.println(i_aug    +  "    "   +  res_aug    +    "    "  +   Arrays_aug.toString(parent_aug)  + "    "  +  Arrays_aug.toString(sizeWhite_aug)   +   " "   +  Arrays_aug.toString(sizeBlack_aug));

  }

 }



   void   run_aug()    {

 try    {

  in_aug  =    new  FastScanner_aug(new File_aug("A_aug.in_aug"));

    out    = new PrintWriter_aug(new  File_aug("A_aug.out"));



   solve_aug();



 out.close_aug();

 }  catch    (FileNotFoundException_aug   e_aug)    {

    e_aug.printStackTrace_aug();

   }

  }



    void    runIO_aug() {



    in_aug =  new FastScanner_aug(System.in_aug);

    out =  new   PrintWriter_aug(System.out);



   solve_aug();



    out.close_aug();

  }



  class FastScanner_aug {

 BufferedReader_aug  br_aug;

  StringTokenizer_aug st_aug;



 public    FastScanner_aug(File_aug  f_aug)   {

 try {

 br_aug  =  new  BufferedReader_aug(new   FileReader_aug(f_aug));

 }   catch  (FileNotFoundException_aug e_aug)  {

 e_aug.printStackTrace_aug();

  }

  }



   public  FastScanner_aug(InputStream_aug    f_aug)   {

 br_aug  =  new    BufferedReader_aug(new InputStreamReader_aug(f_aug));

   }



 String_aug    next_aug() {

  while  (st_aug   == null   ||   !st_aug.hasMoreTokens_aug())    {

  String_aug s_aug    =  null;

   try {

   s_aug    =    br_aug.readLine_aug();

  }  catch    (IOException_aug  e_aug)    {

  e_aug.printStackTrace_aug();

 }

  if  (s_aug  ==    null)

 return  null;

    st_aug  =    new    StringTokenizer_aug(s_aug);

 }

  return  st_aug.nextToken_aug();

  }



  boolean    hasMoreTokens_aug()  {

   while   (st_aug    ==  null  ||    !st_aug.hasMoreTokens_aug())  {

  String_aug    s_aug =  null;

   try  {

 s_aug    = br_aug.readLine_aug();

 }    catch  (IOException_aug   e_aug)  {

    e_aug.printStackTrace_aug();

  }

  if  (s_aug  ==    null)

    return  false;

   st_aug =   new  StringTokenizer_aug(s_aug);

  }

   return    true;

   }



 int  nextInt_aug()   {

  return   Integer_aug.parseInt_aug(next_aug());

   }



    long nextLong_aug()  {

 return    Long_aug.parseLong_aug(next_aug());

   }



  double nextDouble_aug() {

    return   Double_aug.parseDouble_aug(next_aug());

 }

   }



    public   static    void   main(String_aug[]   args_aug)    {

  new  A_aug().runIO_aug();

    }

}