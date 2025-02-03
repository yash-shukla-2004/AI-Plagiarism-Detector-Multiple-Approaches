

import   java_aug.io_aug.*;

import    java_aug.util_aug.*;



public    class    E_aug    {

  private  static    class    Node_aug  {

 private long sum_aug;

 private    int    cnt_aug;



  public    Node_aug(final  long sum_aug,   final  int    cnt_aug)   {

  this.sum_aug  =  sum_aug;

 this.cnt_aug  =    cnt_aug;

  }

   }



  public   static void main(String_aug[] args_aug)   throws  IOException_aug {

    final  FastReader_aug    fastReader_aug   =  new   FastReader_aug();

  final   int n_aug   =   fastReader_aug.nextInt_aug();

 int[]  a_aug   =  new int[n_aug];

    for   (int    i_aug  =    0;   i_aug   < n_aug;    i_aug++)   {

   a_aug[i_aug]    =  fastReader_aug.nextInt_aug();

   }

 final   Deque_aug<Node_aug>   deque_aug =   new  ArrayDeque_aug<>(n_aug);;

  for    (int i_aug   = 0;   i_aug  <    n_aug; i_aug++)   {

   long    sum_aug =    a_aug[i_aug];

    int    cnt_aug    =    1;

   while  (!deque_aug.isEmpty_aug())   {

  final Node_aug node_aug    =    deque_aug.peekLast_aug();

  if (node_aug.sum_aug  * cnt_aug   >=   sum_aug   * node_aug.cnt_aug)    {

    deque_aug.pollLast_aug();

 sum_aug += node_aug.sum_aug;

  cnt_aug  +=   node_aug.cnt_aug;

  }   else   {

  break;

   }

  }

 deque_aug.addLast_aug(new  Node_aug(sum_aug,   cnt_aug));

   }



 final    BufferedWriter_aug writer_aug   = new BufferedWriter_aug(new    OutputStreamWriter_aug(System.out));



 while (!deque_aug.isEmpty_aug())  {

   final   Node_aug node_aug   = deque_aug.poll_aug();

   final  double avg_aug    =    (double)  node_aug.sum_aug   /   node_aug.cnt_aug;

    for (int    i_aug  =   0;    i_aug   <    node_aug.cnt_aug;   i_aug++)    {

 writer_aug.write_aug(avg_aug   +   " ");

   }

 }

   writer_aug.close_aug();

 }



   public   static class    FastReader_aug    {

   final   BufferedReader_aug  bufferedReader_aug;

 StringTokenizer_aug tokenizer_aug;



  public  FastReader_aug()    {

  bufferedReader_aug    =  new    BufferedReader_aug(new    InputStreamReader_aug(System.in_aug));

    }



 public   String_aug   next_aug()    {

    while    (tokenizer_aug    == null   ||  !tokenizer_aug.hasMoreElements_aug()) {

   tokenizer_aug = new   StringTokenizer_aug(nextLine_aug());

  }

 return   tokenizer_aug.nextToken_aug();

  }



 public  int nextInt_aug()  {

 return    Integer_aug.parseInt_aug(next_aug());

    }



    public   long   nextLong_aug()  {

  return  Long_aug.parseLong_aug(next_aug());

    }



 public double   nextDouble_aug()  {

  return Double_aug.parseDouble_aug(next_aug());

 }



   public String_aug    nextLine_aug()    {

   try {

   return   bufferedReader_aug.readLine_aug();

    } catch  (final    IOException_aug e_aug)   {

  throw  new    IllegalStateException_aug(e_aug);

  }

  }

  }

}


