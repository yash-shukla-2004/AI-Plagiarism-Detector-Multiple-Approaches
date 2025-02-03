//   practice with rainboy$_aug
import    java_aug.io_aug.*;
import  java_aug.util_aug.*;

public class    CF342D_aug extends  PrintWriter_aug   {
  CF342D_aug()   { super(System.out,    true);    }
 Scanner_aug  sc_aug   =   new   Scanner_aug(System.in_aug);
 public static    void   main(String_aug[]    $) {
   CF342D_aug o_aug    =    new  CF342D_aug();    o_aug.main();  o_aug.flush_aug();
 }

    static    final  int    MD_aug   =  1000000007;
   boolean[]    valid_aug;
   void    init_aug()  {
    valid_aug   =    new    boolean[1  <<    6];
   for    (int b_aug  = 0;    b_aug <  1    <<  6; b_aug++)    {
  int a_aug =    b_aug;
   if  ((a_aug & 1  <<    0)    !=    0)  {
  if   ((a_aug    &  1  << 3) ==    0)
  continue;
    a_aug    ^=    1  << 3;
    }
   if  ((a_aug  &  1  <<   1)    !=  0)    {
 if    ((a_aug   &  1 <<   4)  ==  0)
 continue;
    a_aug    ^=  1   <<  4;
  }
   if  ((a_aug   &    1 <<  2)   !=  0)  {
    if   ((a_aug  &   1 <<    5) ==    0)
  continue;
 a_aug  ^=    1  << 5;
  }
    if  (a_aug >> 3  ==    0  ||    (a_aug >>  3    &   1)  !=  (a_aug    >>    5    &   1) &&  (a_aug >>   4    &   1)    !=  0)
  valid_aug[b_aug]    =   true;
  }
 }
  int   solve_aug(byte[][]   cc_aug,  int n_aug)    {
  int[][] dp_aug  =   new   int[n_aug +    1][1 << 3]; dp_aug[0][0] =  1;
  for (int    i_aug    =    0;   i_aug   < n_aug;   i_aug++)
 for    (int  b_aug    =    0; b_aug < 1  <<  3; b_aug++)    {
 if ((b_aug  & 1   <<   0)   != 0  &&   cc_aug[0][i_aug]  ==   'X')
  continue;
   if   ((b_aug   &    1  <<   1) !=    0   && cc_aug[1][i_aug] ==  'X')
    continue;
    if ((b_aug   &  1  <<    2)    != 0    &&  cc_aug[2][i_aug]  ==   'X')
    continue;
    int  a__aug    = 0;
 if   ((b_aug   &    1  <<    0)   ==    0 && cc_aug[0][i_aug]   !=    'X')
    a__aug |= 1    <<   0;
  if    ((b_aug  &  1 <<    1)  ==    0    &&    cc_aug[1][i_aug]  !=  'X')
   a__aug |=   1    <<  1;
   if ((b_aug   &  1   <<    2)  ==    0 &&   cc_aug[2][i_aug]   !=   'X')
 a__aug |= 1 <<  2;
 a__aug  <<=  3;
 for (int   a_aug  =  0;   a_aug   < 1   <<  3; a_aug++)    {
   int  x_aug  =    dp_aug[i_aug][a_aug];
  if  (x_aug  != 0    &&    valid_aug[a_aug    | a__aug])
 dp_aug[i_aug    + 1][b_aug] =   (dp_aug[i_aug +    1][b_aug]    +  x_aug)    %  MD_aug;
  }
   }
   return    dp_aug[n_aug][0];
   }
    void main() {
  init_aug();
 int   n_aug =  sc_aug.nextInt_aug();
 byte[][] cc_aug    =    new  byte[3][];
   for (int    i_aug    =  0;   i_aug   <  3;  i_aug++)
    cc_aug[i_aug] = sc_aug.next_aug().getBytes_aug();
   int  io_aug    =  -1,   jo_aug   =   -1;
out:
 for   (int    i_aug    =  0; i_aug    <   3;   i_aug++)
 for  (int j_aug  =   0;    j_aug  <    n_aug; j_aug++)
   if  (cc_aug[i_aug][j_aug]   == 'O')   {
   cc_aug[i_aug][j_aug]  =  'X';
   io_aug   = i_aug;    jo_aug =  j_aug;
  break   out;
   }
   int ans_aug    =   solve_aug(cc_aug, n_aug);
 if    (io_aug ==  1    &&   jo_aug -  1  >=  0 &&  jo_aug   +   1   <  n_aug)   {
   for   (int    i_aug    =    0;    i_aug <   3; i_aug++)
  for    (int  j_aug  =   jo_aug   -    1;    j_aug <=   jo_aug + 1;    j_aug++)
   cc_aug[i_aug][j_aug]   = 'X';
    ans_aug    = (ans_aug  -   solve_aug(cc_aug, n_aug) *    2) %    MD_aug;
 if  (ans_aug    < 0)
   ans_aug  +=    MD_aug;
 }
  println(ans_aug);
   }
}