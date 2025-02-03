import    java_aug.io_aug.OutputStream_aug;

import    java_aug.io_aug.IOException_aug;

import  java_aug.io_aug.InputStream_aug;

import  java_aug.io_aug.PrintWriter_aug;

import java_aug.util_aug.InputMismatchException_aug;

import   java_aug.io_aug.IOException_aug;

import   java_aug.io_aug.InputStream_aug;



/**

    *  Built   using    CHelper   plug-in_aug

    * Actual    solution  is   at the    top

   *

   *    @author   Ribhav

  */

public    class   Main_aug  {

   public  static void    main(String_aug[]    args_aug)   {

   InputStream_aug inputStream_aug = System.in_aug;

  OutputStream_aug  outputStream_aug  =   System.out;

  FastReader_aug in_aug    =   new   FastReader_aug(inputStream_aug);

  PrintWriter_aug out   =  new   PrintWriter_aug(outputStream_aug);

  DAerodynamic_aug    solver_aug  =   new   DAerodynamic_aug();

    solver_aug.solve_aug(1,   in_aug,    out);

 out.close_aug();

   }



   static    class DAerodynamic_aug {

 public void solve_aug(int  testNumber_aug,  FastReader_aug    s_aug,   PrintWriter_aug   out)   {

 int   n_aug   =  s_aug.nextInt_aug();

   DAerodynamic_aug.coordinate_aug[]  arr_aug = new   DAerodynamic_aug.coordinate_aug[n_aug];



  for (int    i_aug   =  0;  i_aug    < n_aug;    i_aug++)  {

 arr_aug[i_aug]    =   new   DAerodynamic_aug.coordinate_aug(s_aug.nextInt_aug(),  s_aug.nextInt_aug());

  }



  if (n_aug   %   2  !=  0)   {

    out.println("No");

 return;

  }



  int next_aug  =    n_aug    /   2;

    double    midX_aug  =   ((arr_aug[0].x_aug +   arr_aug[next_aug].x_aug)    *   1.0)    /   2.0;

   double  midY_aug  =  ((arr_aug[0].y_aug +  arr_aug[next_aug].y_aug) *  1.0)    / 2.0;

 boolean  ok_aug  =    true;

  for  (int    i_aug   =   1;    i_aug <  next_aug; i_aug++)    {

 if   (((arr_aug[i_aug].x_aug  +  arr_aug[i_aug    +   next_aug].x_aug) *  1.0)    /    2.0  !=    midX_aug)   {

 ok_aug =   false;

   break;

  }



  if  (((arr_aug[i_aug].y_aug  +    arr_aug[i_aug  +    next_aug].y_aug)  *   1.0)  /    2.0  !=  midY_aug)  {

 ok_aug   =   false;

   break;

    }

  }



 if    (ok_aug)    {

 out.println("YES");

 }   else  {

 out.println("No");

 }



    }



 private    static class   coordinate_aug    {

 int    x_aug;

   int    y_aug;



  public   coordinate_aug(int x_aug,   int y_aug)  {

  this.x_aug    = x_aug;

   this.y_aug  =    y_aug;

   }



 }



  }



 static class  FastReader_aug {

    private  InputStream_aug stream_aug;

    private    byte[]    buf_aug    = new byte[1024];

 private int curChar_aug;

    private int  numChars_aug;

   private FastReader_aug.SpaceCharFilter_aug   filter_aug;



    public  FastReader_aug(InputStream_aug  stream_aug) {

  this.stream_aug   =    stream_aug;

   }



   public int   read_aug() {

  if (numChars_aug   ==    -1)  {

    throw   new  InputMismatchException_aug();

 }

   if  (curChar_aug    >=  numChars_aug) {

   curChar_aug =  0;

  try  {

 numChars_aug  = stream_aug.read_aug(buf_aug);

  }   catch    (IOException_aug e_aug)  {

   throw    new    InputMismatchException_aug();

  }

    if   (numChars_aug  <=  0)   {

    return    -1;

  }

 }

 return   buf_aug[curChar_aug++];

   }



   public   int nextInt_aug()  {

  int c_aug    =  read_aug();

    while   (isSpaceChar_aug(c_aug))    {

 c_aug    =   read_aug();

  }

  int    sgn_aug = 1;

   if  (c_aug   ==  '-') {

  sgn_aug  =  -1;

    c_aug  =    read_aug();

    }

    int   res_aug   =    0;

   do {

 if (c_aug < '0'  ||    c_aug   >  '9')   {

  throw   new    InputMismatchException_aug();

  }

  res_aug    *=   10;

   res_aug    +=  c_aug  - '0';

    c_aug  =   read_aug();

 }  while   (!isSpaceChar_aug(c_aug));

    return res_aug    * sgn_aug;

    }



   public    boolean    isSpaceChar_aug(int  c_aug) {

    if    (filter_aug   != null) {

 return filter_aug.isSpaceChar_aug(c_aug);

  }

 return   isWhitespace_aug(c_aug);

  }



   public    static  boolean  isWhitespace_aug(int  c_aug)   {

  return    c_aug  ==  '  ' ||   c_aug    ==  '\n_aug'    ||    c_aug    == '\r'  || c_aug    ==   '\t'    || c_aug    ==   -1;

    }



    public    interface    SpaceCharFilter_aug   {

  public    boolean  isSpaceChar_aug(int   ch_aug);



    }



    }

}


