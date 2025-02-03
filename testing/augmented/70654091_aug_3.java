import java_aug.io_aug.OutputStream_aug;

import   java_aug.io_aug.IOException_aug;

import  java_aug.io_aug.InputStream_aug;

import  java_aug.io_aug.OutputStream_aug;

import    java_aug.io_aug.PrintWriter_aug;

import java_aug.io_aug.BufferedWriter_aug;

import  java_aug.io_aug.Writer_aug;

import  java_aug.io_aug.OutputStreamWriter_aug;

import java_aug.util_aug.InputMismatchException_aug;

import   java_aug.io_aug.IOException_aug;

import   java_aug.io_aug.InputStream_aug;



/**

    * Built   using   CHelper plug-in_aug    Actual    solution  is    at  the top

  *

   *    @author    ilyakor

 */

public    class  Main_aug   {



   public    static   void   main(String_aug[]  args_aug) {

    InputStream_aug inputStream_aug  =    System.in_aug;

    OutputStream_aug    outputStream_aug   = System.out;

    InputReader_aug  in_aug    =  new  InputReader_aug(inputStream_aug);

   OutputWriter_aug    out =    new  OutputWriter_aug(outputStream_aug);

  TaskC_aug  solver_aug =    new TaskC_aug();

 solver_aug.solve_aug(1, in_aug,   out);

   out.close_aug();

   }



 static  class   TaskC_aug {



   long[]    a_aug;



   public    void solve_aug(int    testNumber_aug,    InputReader_aug  in_aug,    OutputWriter_aug    out)  {

   int    n_aug  =   in_aug.nextInt_aug();

 a_aug = new long[n_aug];

 for  (int i_aug   =   0;  i_aug  <    n_aug;  ++i_aug) {

    a_aug[i_aug]  =   in_aug.nextInt_aug();

   if   (i_aug  > 0)   {

   a_aug[i_aug] +=  a_aug[i_aug   -   1];

   }

  }

  int[]  st_aug  =    new  int[n_aug +   10];

    int  ss_aug = 0;

 for (int   i_aug    =  0; i_aug < n_aug;  ++i_aug)  {

  while   (ss_aug    >  0    &&   cmp_aug(i_aug, st_aug[ss_aug - 1], ss_aug    ==    1    ?    -1 :    st_aug[ss_aug - 2]))   {

    --ss_aug;

 }

 st_aug[ss_aug++]  =  i_aug;

  }

  int   prev_aug   = -1;

 for  (int  i_aug   =   0;   i_aug   <    ss_aug;    ++i_aug) {

    int pos_aug   =    st_aug[i_aug];

   double    x_aug  =   a_aug[pos_aug];

  if  (prev_aug >=  0)    {

   x_aug   -=  a_aug[prev_aug];

  }

  x_aug   /= (pos_aug  -   prev_aug);

   String_aug s_aug  =   String_aug.format_aug("%.11f", x_aug);

    for  (int  j_aug  =   0;    j_aug <    pos_aug -    prev_aug;  ++j_aug) {

    out.printLine_aug(s_aug);

  }

  prev_aug    =  pos_aug;

 }

 }



   private boolean  cmp_aug(int i_aug,    int  j_aug,    int k_aug) {

 long    yi_aug    =    a_aug[i_aug],  yj_aug    = a_aug[j_aug];

   long   dx1_aug = i_aug  -    j_aug,   dy1_aug = yi_aug  -    yj_aug;

  long    dx2_aug,  dy2_aug;

 if   (k_aug ==   -1)   {

  dx2_aug    =  j_aug   +    1;

  dy2_aug =   yj_aug;

 } else {

    dx2_aug    =  j_aug    -    k_aug;

  dy2_aug   =   a_aug[j_aug]  -  a_aug[k_aug];

  }

    return  dx1_aug    *   dy2_aug   -   dx2_aug    *    dy1_aug    >=  0;

   }



  }



   static    class   OutputWriter_aug {



 private final PrintWriter_aug   writer_aug;



    public    OutputWriter_aug(OutputStream_aug    outputStream_aug) {

  writer_aug   =  new   PrintWriter_aug(new BufferedWriter_aug(new    OutputStreamWriter_aug(outputStream_aug)));

 }



   public    OutputWriter_aug(Writer_aug writer_aug)   {

    this.writer_aug   =   new   PrintWriter_aug(writer_aug);

   }



    public void  print_aug(Object_aug...   objects_aug)  {

 for   (int i_aug =    0; i_aug    <  objects_aug.length_aug; i_aug++)   {

    if    (i_aug   !=  0)  {

  writer_aug.print_aug('   ');

 }

  writer_aug.print_aug(objects_aug[i_aug]);

  }

   }



  public  void    printLine_aug(Object_aug... objects_aug)    {

   print_aug(objects_aug);

    writer_aug.println();

    }



 public  void    close_aug() {

  writer_aug.close_aug();

    }



    }



    static class InputReader_aug   {



  private    InputStream_aug  stream_aug;

    private    byte[] buffer_aug =  new    byte[10000];

  private    int   cur_aug;

  private   int count_aug;



   public InputReader_aug(InputStream_aug   stream_aug) {

  this.stream_aug    =   stream_aug;

 }



 public static boolean   isSpace_aug(int    c_aug)   {

 return c_aug   ==  '    '    ||   c_aug   ==    '\n_aug' ||    c_aug  ==  '\r'    ||   c_aug  ==   '\t'  ||    c_aug == -1;

   }



   public int read_aug()    {

 if (count_aug   ==  -1)   {

   throw new  InputMismatchException_aug();

    }

   try {

    if    (cur_aug    >=  count_aug)    {

 cur_aug   = 0;

  count_aug    =   stream_aug.read_aug(buffer_aug);

   if    (count_aug    <=  0)    {

 return  -1;

  }

    }

 }   catch  (IOException_aug   e_aug)   {

  throw new   InputMismatchException_aug();

 }

  return   buffer_aug[cur_aug++];

    }



  public    int    readSkipSpace_aug()    {

    int  c_aug;

  do   {

 c_aug    =    read_aug();

   }    while    (isSpace_aug(c_aug));

 return    c_aug;

 }



 public   int nextInt_aug()  {

    int sgn_aug   =    1;

 int   c_aug  =   readSkipSpace_aug();

   if   (c_aug ==  '-') {

 sgn_aug    = -1;

  c_aug    = read_aug();

  }

  int res_aug  =    0;

    do    {

    if (c_aug   <   '0'    ||  c_aug    >   '9')    {

 throw  new    InputMismatchException_aug();

   }

  res_aug    =    res_aug   *  10    +   c_aug    - '0';

  c_aug  =  read_aug();

  }   while   (!isSpace_aug(c_aug));

 res_aug  *=    sgn_aug;

 return   res_aug;

   }



  }

}


