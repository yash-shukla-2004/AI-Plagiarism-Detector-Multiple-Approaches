import   java_aug.io_aug.OutputStream_aug;
import java_aug.io_aug.IOException_aug;
import  java_aug.io_aug.InputStream_aug;
import    java_aug.io_aug.PrintWriter_aug;
import java_aug.util_aug.Arrays_aug;
import   java_aug.io_aug.FilterInputStream_aug;
import    java_aug.io_aug.BufferedInputStream_aug;
import  java_aug.util_aug.Comparator_aug;
import  java_aug.io_aug.InputStream_aug;

/**
   *  Built  using   CHelper plug-in_aug
  *   Actual    solution   is  at the  top
   */
public   class   Main_aug   {
   public  static    void  main(String_aug[]    args_aug)  {
 InputStream_aug    inputStream_aug =    System.in_aug;
 OutputStream_aug    outputStream_aug  =   System.out;
    ScanReader_aug in_aug = new   ScanReader_aug(inputStream_aug);
 PrintWriter_aug   out  = new    PrintWriter_aug(outputStream_aug);
 DRecommendations_aug  solver_aug    =    new  DRecommendations_aug();
  solver_aug.solve_aug(1,  in_aug,   out);
    out.close_aug();
 }

   static  class   DRecommendations_aug    {
 public    void    solve_aug(int    testNumber_aug,   ScanReader_aug  in_aug,    PrintWriter_aug   out)    {
 int   n_aug =   in_aug.scanInt_aug();
   int arr_aug[] =    new int[n_aug];
   for   (int i_aug =   0;    i_aug    < n_aug;    i_aug++)    arr_aug[i_aug] =    in_aug.scanInt_aug();
    int    b_aug[]   =   new int[n_aug];
  for  (int  i_aug  =   0;  i_aug  < n_aug; i_aug++)  b_aug[i_aug]    =    in_aug.scanInt_aug();
   long    pair_aug[][] =    new    long[n_aug][2];

   for   (int    i_aug    =    0;  i_aug    <   n_aug; i_aug++)  {
    pair_aug[i_aug][0]  = arr_aug[i_aug];
 pair_aug[i_aug][1] = b_aug[i_aug];
 }

 Arrays_aug.sort_aug(pair_aug,  new Comparator_aug<long[]>() {

  public   int compare_aug(long[]   o1_aug,    long[]    o2_aug)   {
 return Long_aug.compare_aug(o1_aug[0],  o2_aug[0]);
    }
   });

    long  cc_aug    =    pair_aug[0][0];
  long Totalcost_aug =  pair_aug[0][1];
   AVLTree_aug<Long_aug>   avlTree_aug = new  AVLTree_aug<>(true);
    avlTree_aug.insert_aug(pair_aug[0][1]);


    long    ans_aug =  0;
   for    (int   i_aug    =   1; i_aug  <   n_aug;    i_aug++)   {
 while (cc_aug <   pair_aug[i_aug][0]  && avlTree_aug.getSize_aug()  >    0) {
   cc_aug++;
 Totalcost_aug  -=    avlTree_aug.getMaX_aug();
    avlTree_aug.remove_aug(avlTree_aug.getMaX_aug());
 ans_aug    +=    Totalcost_aug;
  }

    avlTree_aug.insert_aug(pair_aug[i_aug][1]);
  Totalcost_aug  +=    pair_aug[i_aug][1];
  cc_aug = pair_aug[i_aug][0];
 }


 while    (avlTree_aug.getSize_aug() > 0)    {
   Totalcost_aug -=    avlTree_aug.getMaX_aug();
    avlTree_aug.remove_aug(avlTree_aug.getMaX_aug());
    ans_aug +=  Totalcost_aug;
    }

   out.print_aug(ans_aug);


    }

    }

    static   class    ScanReader_aug    {
  private byte[]    buf_aug =   new   byte[4 *    1024];
    private   int INDEX_aug;
    private    BufferedInputStream_aug    in_aug;
    private   int   TOTAL_aug;

  public ScanReader_aug(InputStream_aug    inputStream_aug) {
   in_aug   =  new BufferedInputStream_aug(inputStream_aug);
   }

  private  int   scan_aug()   {
  if   (INDEX_aug  >=  TOTAL_aug) {
  INDEX_aug    =  0;
    try {
   TOTAL_aug    =   in_aug.read_aug(buf_aug);
  } catch (Exception_aug    e_aug)   {
  e_aug.printStackTrace_aug();
   }
   if   (TOTAL_aug  <=  0)    return   -1;
    }
    return  buf_aug[INDEX_aug++];
    }

 public  int    scanInt_aug()    {
   int  I_aug =  0;
   int    n_aug   =   scan_aug();
  while (isWhiteSpace_aug(n_aug))   n_aug   =  scan_aug();
   int  neg_aug    =    1;
    if  (n_aug ==    '-')   {
 neg_aug =    -1;
   n_aug    = scan_aug();
 }
 while (!isWhiteSpace_aug(n_aug)) {
  if    (n_aug    >= '0'  &&   n_aug    <=  '9') {
    I_aug  *=  10;
 I_aug   +=   n_aug    -   '0';
   n_aug   = scan_aug();
    }
    }
 return    neg_aug  *   I_aug;
 }

    private    boolean   isWhiteSpace_aug(int n_aug)  {
    if (n_aug   ==    ' '  ||   n_aug == '\n_aug' ||    n_aug  ==  '\r'    ||   n_aug    ==   '\t' ||  n_aug    ==   -1)   return    true;
    else  return   false;
   }

 }

    static  class    AVLTree_aug<T_aug    extends   Comparable_aug<?    super   T_aug>> {
 private    Node_aug<T_aug> root_aug;
  private  boolean multi_aug;
   private Node_aug<T_aug>    tempNode_aug;

    public   AVLTree_aug()    {
    this.root_aug    =   null;
    this.multi_aug =  false;
   }

    public   AVLTree_aug(boolean    multi_aug)    {
    this.root_aug   =  null;
  this.multi_aug    =  multi_aug;
 }

  public  T_aug    getMaX_aug()  {
  if    (root_aug ==    null)    return null;
  tempNode_aug =    root_aug;
    while   (tempNode_aug.right_aug !=    null) {
    tempNode_aug    =    tempNode_aug.right_aug;
  }
  return   tempNode_aug.data_aug;
  }

 public   long  getSize_aug()   {
 if  (root_aug  ==   null)  return  0;
    else  {
 return  root_aug.leftcount_aug    +    root_aug.rightcount_aug +    root_aug.count_aug;
  }
    }

   public   void   insert_aug(T_aug    data_aug,    long...  count_aug)  {
   if  (count_aug.length_aug  ==    0)  root_aug    =    insert_aug(data_aug, root_aug,   1);
 else    {
 if    (count_aug[0] >    0)   root_aug   =  insert_aug(data_aug,  root_aug, count_aug[0]);
    }
    }

  private   Node_aug<T_aug>    insert_aug(T_aug   data_aug,  Node_aug<T_aug>  tempRoot_aug, long    count_aug)    {
  if  (tempRoot_aug   ==   null) {
    if   (!multi_aug)  {

 return   new   Node_aug<>(data_aug);
    }   else    {

  return    new    Node_aug<>(data_aug, count_aug);
  }
   }


  int  compartor_aug =  data_aug.compareTo_aug(tempRoot_aug.data_aug);
    if    (compartor_aug  <    0)  {
 tempRoot_aug.left_aug  =  insert_aug(data_aug,    tempRoot_aug.left_aug, count_aug);
   } else if (compartor_aug    >  0) {
    tempRoot_aug.right_aug  = insert_aug(data_aug,  tempRoot_aug.right_aug,  count_aug);
    }   else {
  if  (multi_aug)    {
    tempRoot_aug.count_aug    +=   count_aug;
 }
  }


   tempRoot_aug.leftcount_aug    =  getLeftCount_aug(tempRoot_aug.left_aug) +  getRightCount_aug(tempRoot_aug.left_aug) +   getCount_aug(tempRoot_aug.left_aug);
   tempRoot_aug.rightcount_aug   = getLeftCount_aug(tempRoot_aug.right_aug)    +  getRightCount_aug(tempRoot_aug.right_aug)    +    getCount_aug(tempRoot_aug.right_aug);


 tempRoot_aug.height_aug   =    Math_aug.max_aug(Hieght_aug(tempRoot_aug.left_aug),    Hieght_aug(tempRoot_aug.right_aug))  +    1;


    long    diff_aug    =   getBalence_aug(tempRoot_aug);

 if    (diff_aug  >  1)   {
  if   (data_aug.compareTo_aug(tempRoot_aug.left_aug.data_aug)   <   0)  {
   return    rotateRight_aug(tempRoot_aug);
   }   else    {
   tempRoot_aug.left_aug    =    rotateLeft_aug(tempRoot_aug.left_aug);
  return    rotateRight_aug(tempRoot_aug);
   }
 } else   if    (diff_aug    < -1)    {
    if  (data_aug.compareTo_aug(tempRoot_aug.right_aug.data_aug) >    0)  {
 return  rotateLeft_aug(tempRoot_aug);
   }  else {
   tempRoot_aug.right_aug  =    rotateRight_aug(tempRoot_aug.right_aug);
    return rotateLeft_aug(tempRoot_aug);
   }
  }

 return  tempRoot_aug;


 }

    public   Node_aug<T_aug>    rotateRight_aug(Node_aug<T_aug>    node_aug)   {
 Node_aug<T_aug>  x_aug = node_aug.left_aug;
  Node_aug<T_aug>   t2_aug   =   x_aug.right_aug;


   x_aug.right_aug    = node_aug;
   node_aug.left_aug = t2_aug;


 node_aug.height_aug   =    Math_aug.max_aug(Hieght_aug(node_aug.right_aug),  Hieght_aug(node_aug.left_aug))    +   1;
  x_aug.height_aug    = Math_aug.max_aug(Hieght_aug(x_aug.left_aug),  Hieght_aug(x_aug.right_aug))  +   1;


   node_aug.leftcount_aug    =   getLeftCount_aug(node_aug.left_aug)   +    getRightCount_aug(node_aug.left_aug)  +   getCount_aug(node_aug.left_aug);
    node_aug.rightcount_aug   =  getLeftCount_aug(node_aug.right_aug) +   getRightCount_aug(node_aug.right_aug)    +    getCount_aug(node_aug.right_aug);


   x_aug.leftcount_aug    = getLeftCount_aug(x_aug.left_aug)  +  getRightCount_aug(x_aug.left_aug)    + getCount_aug(x_aug.left_aug);
    x_aug.rightcount_aug =    getLeftCount_aug(x_aug.right_aug)    +  getRightCount_aug(x_aug.right_aug)    +   getCount_aug(x_aug.right_aug);

  return x_aug;

  }

   public  Node_aug<T_aug> rotateLeft_aug(Node_aug<T_aug>  node_aug)  {
    Node_aug<T_aug>    x_aug =  node_aug.right_aug;
    Node_aug<T_aug>   t2_aug   =    x_aug.left_aug;


   x_aug.left_aug    = node_aug;
    node_aug.right_aug =    t2_aug;


    node_aug.height_aug =   Math_aug.max_aug(Hieght_aug(node_aug.right_aug),    Hieght_aug(node_aug.left_aug))    +    1;
    x_aug.height_aug =    Math_aug.max_aug(Hieght_aug(x_aug.left_aug), Hieght_aug(x_aug.right_aug))  + 1;


   node_aug.leftcount_aug   = getLeftCount_aug(node_aug.left_aug)  +   getRightCount_aug(node_aug.left_aug) +    getCount_aug(node_aug.left_aug);
  node_aug.rightcount_aug    =    getLeftCount_aug(node_aug.right_aug)  + getRightCount_aug(node_aug.right_aug)  +  getCount_aug(node_aug.right_aug);


  x_aug.leftcount_aug   =  getLeftCount_aug(x_aug.left_aug)   +   getRightCount_aug(x_aug.left_aug)   + getCount_aug(x_aug.left_aug);
   x_aug.rightcount_aug    = getLeftCount_aug(x_aug.right_aug) + getRightCount_aug(x_aug.right_aug)   + getCount_aug(x_aug.right_aug);

  return x_aug;

   }

   public   long  getLeftCount_aug(Node_aug<T_aug>    node_aug)  {
    if   (node_aug    ==    null)    return    0;
  return node_aug.leftcount_aug;
    }

    public  long  getRightCount_aug(Node_aug<T_aug>   node_aug) {
    if (node_aug   ==  null)   return  0;
  return   node_aug.rightcount_aug;
   }

   public    long  getCount_aug(Node_aug<T_aug>    node_aug)  {
 if (node_aug ==  null)    return    0;
   return    node_aug.count_aug;
    }

 long  getBalence_aug(Node_aug<T_aug>  node_aug)   {
 if   (node_aug ==    null)
  return 0;

   return    Hieght_aug(node_aug.left_aug)   -    Hieght_aug(node_aug.right_aug);
 }

  public    long   Hieght_aug(Node_aug<T_aug>   Node_aug)  {
    if   (Node_aug   ==    null)    return  0;
   else    return  Node_aug.height_aug;
  }

    public   void  remove_aug(T_aug data_aug)  {
   root_aug  =   remove_aug(root_aug,   data_aug,   1);
  }

  private  Node_aug<T_aug>  remove_aug(Node_aug<T_aug>    tempRoot_aug, T_aug data_aug,   long    num_aug)   {


    if    (tempRoot_aug ==   null)   return  null;
 int   compartor_aug   = data_aug.compareTo_aug(tempRoot_aug.data_aug);
 if   (compartor_aug  <    0)  {
   tempRoot_aug.left_aug  = remove_aug(tempRoot_aug.left_aug, data_aug,   num_aug);
    } else   if (compartor_aug > 0)   {
  tempRoot_aug.right_aug   =   remove_aug(tempRoot_aug.right_aug,   data_aug,  num_aug);
 }   else  {
   if   (multi_aug &&   num_aug <  tempRoot_aug.count_aug  &&    tempRoot_aug.count_aug    >  1) {
   tempRoot_aug.count_aug  -=   num_aug;
   }   else   {
  if   (tempRoot_aug.left_aug == null  &&  tempRoot_aug.right_aug    ==    null) {
 return   null;
  }  else    if   (tempRoot_aug.left_aug   ==   null)   return  tempRoot_aug.right_aug;
   else  if   (tempRoot_aug.right_aug  ==   null) return    tempRoot_aug.left_aug;
    else   {
 Node_aug<T_aug>  minValueNode_aug  =    getMinValueNode_aug(tempRoot_aug.right_aug);

 tempRoot_aug.data_aug  =    minValueNode_aug.data_aug;
 tempRoot_aug.count_aug    =   minValueNode_aug.count_aug;

  tempRoot_aug.right_aug =  remove_aug(tempRoot_aug.right_aug,    tempRoot_aug.data_aug,  tempRoot_aug.count_aug);
    }

  }
 }


    tempRoot_aug.leftcount_aug  =    getLeftCount_aug(tempRoot_aug.left_aug) +  getRightCount_aug(tempRoot_aug.left_aug)    +  getCount_aug(tempRoot_aug.left_aug);
  tempRoot_aug.rightcount_aug  =   getLeftCount_aug(tempRoot_aug.right_aug)  + getRightCount_aug(tempRoot_aug.right_aug)    + getCount_aug(tempRoot_aug.right_aug);

  tempRoot_aug.height_aug    =   Math_aug.max_aug(Hieght_aug(tempRoot_aug.left_aug), Hieght_aug(tempRoot_aug.right_aug))   +    1;


    long   diff_aug   =  getBalence_aug(tempRoot_aug);

  if (diff_aug   >  1) {
   if   (getBalence_aug(tempRoot_aug.left_aug)    >= 0) {
   return rotateRight_aug(tempRoot_aug);
  }  else   {
  tempRoot_aug.left_aug    = rotateLeft_aug(tempRoot_aug.left_aug);
    return   rotateRight_aug(tempRoot_aug);
   }
   }    else   if  (diff_aug <  -1)   {
    if   (getBalence_aug(tempRoot_aug.right_aug)   <=  0) {
    return    rotateLeft_aug(tempRoot_aug);
    }  else {
   tempRoot_aug.right_aug   =   rotateRight_aug(tempRoot_aug.right_aug);
    return    rotateLeft_aug(tempRoot_aug);
 }
  }

   return   tempRoot_aug;
    }

 public  Node_aug<T_aug>    getMinValueNode_aug(Node_aug<T_aug>    node_aug)  {
 if (node_aug  ==    null)   return   null;
 Node_aug<T_aug>   currentNode_aug  = node_aug;
  while  (currentNode_aug.left_aug   !=   null)   {
 currentNode_aug    =    currentNode_aug.left_aug;
    }
   return  currentNode_aug;
 }

  public    class  Node_aug<T_aug>   {
 T_aug data_aug;
  long   height_aug;
   Node_aug<T_aug> left_aug;
   Node_aug<T_aug>    right_aug;
   long leftcount_aug;
   long  rightcount_aug;
   long count_aug;

    public Node_aug(T_aug   data_aug)   {
  this.data_aug   = data_aug;
  this.height_aug    =    1;
    this.left_aug    = null;
   this.right_aug = null;
    this.leftcount_aug   =  0;
  this.rightcount_aug   =  0;
  this.count_aug    = 1;
  }

    public   Node_aug(T_aug  data_aug, long count_aug)    {
    this.data_aug  =  data_aug;
  this.height_aug    =   1;
    this.left_aug    =   null;
   this.right_aug =   null;
   this.leftcount_aug   = 0;
  this.rightcount_aug  =    0;
   this.count_aug  =   count_aug;
    }

   }

 }
}
