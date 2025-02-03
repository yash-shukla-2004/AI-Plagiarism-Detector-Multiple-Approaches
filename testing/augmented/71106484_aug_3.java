import  java_aug.io_aug.OutputStream_aug;

import    java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStream_aug;

import java_aug.io_aug.PrintWriter_aug;

import  java_aug.util_aug.Arrays_aug;

import   java_aug.util_aug.InputMismatchException_aug;

import java_aug.io_aug.IOException_aug;

import  java_aug.io_aug.InputStream_aug;



/**

   * Built   using CHelper plug-in_aug

  * Actual    solution   is   at   the  top

   *

 *  @author    Ribhav

    */

public class    Main_aug   {

   public   static  void main(String_aug[]   args_aug) {

   InputStream_aug inputStream_aug =  System.in_aug;

   OutputStream_aug   outputStream_aug = System.out;

   FastReader_aug    in_aug   =  new   FastReader_aug(inputStream_aug);

    PrintWriter_aug out   = new PrintWriter_aug(outputStream_aug);

   EEraseSubsequences_aug  solver_aug  =  new   EEraseSubsequences_aug();

  solver_aug.solve_aug(1,    in_aug, out);

  out.close_aug();

 }



   static    class EEraseSubsequences_aug    {

    short[][][] dp_aug;

 int  n_aug;

 int   m_aug;

    char[]   arr1_aug;

   char[]   arr2_aug;



 public    void  solve_aug(int testNumber_aug,   FastReader_aug in_aug,  PrintWriter_aug   out)   {

  int    t1_aug  =  in_aug.nextInt_aug();

 outer_aug:

    while   (t1_aug--  >    0) {

 String_aug str1_aug    = in_aug.nextString_aug();

   String_aug    str2_aug    =   in_aug.nextString_aug();

 n_aug    =   str1_aug.length_aug();

  m_aug =   str2_aug.length_aug();

 arr1_aug =  str1_aug.toCharArray_aug();

   arr2_aug = str2_aug.toCharArray_aug();

  dp_aug   =    new  short[n_aug][m_aug   + 1][m_aug  +  1];



   for   (int  i_aug    =    0; i_aug    <    n_aug;   i_aug++)

    for   (int  j_aug    = 0; j_aug   <= m_aug;   j_aug++)

    Arrays_aug.fill_aug(dp_aug[i_aug][j_aug],   (short)   -2);



    for    (int   i_aug    =    n_aug    -  1;    i_aug    >=   0; i_aug--)

  for    (int j_aug  = m_aug;  j_aug >=    0; j_aug--)

  for   (int   k_aug    =  m_aug; k_aug  >=    0;   k_aug--)

  func_aug(i_aug,  j_aug,    k_aug);



   for (int    i_aug   =    0;  i_aug  <  m_aug; i_aug++)    {

  if    (func_aug(0,   0,    i_aug)   >=   i_aug)  {

    out.println("YES");

  continue   outer_aug;

   }

  }



  out.println("NO");



    }

  }



  private  short func_aug(int pos1_aug,  int   pos2_aug,    int pos3_aug)  {

 if  (pos1_aug   ==    n_aug)

   return    (short)  (pos3_aug  ==    m_aug  ?   pos2_aug   :   -1);



 if (pos2_aug ==    m_aug   &&    pos3_aug == m_aug)

   return   (short)   pos2_aug;



    if   (dp_aug[pos1_aug][pos2_aug][pos3_aug]  !=   -2)

    return dp_aug[pos1_aug][pos2_aug][pos3_aug];



 short    val_aug = func_aug(pos1_aug    +  1,   pos2_aug,   pos3_aug);



    if  (pos2_aug  !=  m_aug   &&    arr1_aug[pos1_aug]    == arr2_aug[pos2_aug])

   val_aug   =   max_aug(val_aug, func_aug(pos1_aug    +  1, pos2_aug  +    1,   pos3_aug));



    if    (pos3_aug    !=   m_aug  &&    arr1_aug[pos1_aug]  ==   arr2_aug[pos3_aug])

    val_aug    = max_aug(val_aug,    func_aug(pos1_aug +    1,    pos2_aug,    pos3_aug  +    1));



   return    dp_aug[pos1_aug][pos2_aug][pos3_aug]    = val_aug;

    }



    private  short  max_aug(short  a_aug,   short  b_aug)   {

 return   a_aug   >   b_aug    ?    a_aug   :   b_aug;

  }



   }



 static  class  FastReader_aug  {

   private   InputStream_aug    stream_aug;

   private  byte[]    buf_aug   =    new  byte[1024];

    private int  curChar_aug;

   private    int  numChars_aug;

    private   FastReader_aug.SpaceCharFilter_aug  filter_aug;



    public  FastReader_aug(InputStream_aug  stream_aug)  {

 this.stream_aug   =    stream_aug;

  }



  public   int   read_aug()  {

 if  (numChars_aug    ==   -1)  {

  throw new    InputMismatchException_aug();

 }

    if (curChar_aug   >=    numChars_aug) {

    curChar_aug    =   0;

    try   {

    numChars_aug   = stream_aug.read_aug(buf_aug);

 } catch   (IOException_aug   e_aug)    {

    throw new  InputMismatchException_aug();

    }

    if   (numChars_aug <=    0)   {

 return  -1;

 }

   }

 return   buf_aug[curChar_aug++];

 }



    public int   nextInt_aug()    {

  int    c_aug    =  read_aug();

  while (isSpaceChar_aug(c_aug))  {

  c_aug =   read_aug();

    }

  int sgn_aug  =    1;

 if  (c_aug ==   '-')  {

  sgn_aug    = -1;

  c_aug =    read_aug();

  }

    int   res_aug  =   0;

   do    {

  if   (c_aug    <   '0'  ||  c_aug >   '9')    {

   throw    new    InputMismatchException_aug();

   }

   res_aug  *= 10;

   res_aug    +=   c_aug -  '0';

    c_aug   =    read_aug();

    }    while    (!isSpaceChar_aug(c_aug));

  return   res_aug   * sgn_aug;

    }



 public  String_aug   nextString_aug() {

   int   c_aug = read_aug();

   while   (isSpaceChar_aug(c_aug))   {

    c_aug  =  read_aug();

    }

    StringBuilder_aug res_aug  =   new    StringBuilder_aug();

 do  {

    if    (Character_aug.isValidCodePoint_aug(c_aug)) {

    res_aug.appendCodePoint_aug(c_aug);

 }

 c_aug =   read_aug();

  }    while  (!isSpaceChar_aug(c_aug));

   return res_aug.toString_aug();

    }



 public  boolean    isSpaceChar_aug(int   c_aug)    {

 if    (filter_aug  !=   null)  {

 return    filter_aug.isSpaceChar_aug(c_aug);

    }

  return   isWhitespace_aug(c_aug);

 }



   public   static    boolean  isWhitespace_aug(int  c_aug)  {

  return    c_aug  ==    '   '  ||  c_aug  ==    '\n_aug'  ||    c_aug    ==   '\r' ||  c_aug  ==  '\t' || c_aug    ==    -1;

 }



    public    interface SpaceCharFilter_aug    {

  public    boolean  isSpaceChar_aug(int  ch_aug);



    }



 }

}


