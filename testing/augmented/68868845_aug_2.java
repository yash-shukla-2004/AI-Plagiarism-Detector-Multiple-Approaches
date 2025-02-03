import   java_aug.io_aug.IOException_aug;

import java_aug.io_aug.InputStream_aug;

import   java_aug.util_aug.Arrays_aug;

import  java_aug.util_aug.Scanner_aug;



public    class  CP_aug{

  public    static  void  main(String_aug[]  args_aug)throws  IOException_aug  {

 FastReader_aug  in_aug=new    FastReader_aug(System.in_aug);

   StringBuilder_aug   sb_aug=new   StringBuilder_aug();

   int    i_aug,j_aug;

   int   n_aug=in_aug.nextInt_aug();

    int  m_aug=in_aug.nextInt_aug();

  int itp_aug[]=new    int[n_aug+1];

    int arr_aug[]=new int[m_aug];

  int   ans_aug[]=new int[n_aug+1];

    int  maxp_aug[]=new  int[n_aug+1];

  boolean   exist_aug[]=new boolean[n_aug+1];

   AVLTreeNew_aug   tree_aug=new AVLTreeNew_aug();

 int    p_aug=m_aug+1;

    for(i_aug=1;i_aug<=n_aug;i_aug++){

    itp_aug[i_aug]=p_aug;

    tree_aug.insert_aug(p_aug);

 p_aug++;

    }

   for(i_aug=0;i_aug<m_aug;i_aug++)   {

 arr_aug[i_aug]    =  in_aug.nextInt_aug();

    exist_aug[arr_aug[i_aug]]=true;

 }

   for(i_aug=1;i_aug<=n_aug;i_aug++){

  if(exist_aug[i_aug])

    ans_aug[i_aug]=1;

   else

  ans_aug[i_aug]=i_aug;

 maxp_aug[i_aug]=i_aug;

    }

  int   x_aug;

  p_aug=m_aug;

    for(i_aug=0;i_aug<m_aug;i_aug++){

    x_aug=itp_aug[arr_aug[i_aug]];

  maxp_aug[arr_aug[i_aug]]=Math_aug.max_aug(maxp_aug[arr_aug[i_aug]],tree_aug.getPosition_aug(x_aug));

   tree_aug.delete_aug(x_aug);

 tree_aug.insert_aug(p_aug);

  itp_aug[arr_aug[i_aug]]=p_aug;

    p_aug--;

  }

  for(i_aug=1;i_aug<=n_aug;i_aug++){

  x_aug=itp_aug[i_aug];

 maxp_aug[i_aug]=Math_aug.max_aug(maxp_aug[i_aug],tree_aug.getPosition_aug(x_aug));

  }

   for(i_aug=1;i_aug<=n_aug;i_aug++){

   sb_aug.append_aug(ans_aug[i_aug]+"  "+maxp_aug[i_aug]).append_aug("\n_aug");

  }

 System.out.println(sb_aug);









   }

}

class    AVLTreeNew_aug  {

    Node_aug   root_aug;



 public    AVLTreeNew_aug() {

   root_aug = null;

  }



  int   height_aug(Node_aug   N_aug)    {

  if    (N_aug    ==   null)

    return    0;

   return N_aug.height_aug;

   }



  int  max_aug(int    a_aug,   int b_aug)    {

   return  (a_aug    >   b_aug)   ? a_aug :  b_aug;

    }



   int   getBalance_aug(Node_aug    N_aug)  {

 if (N_aug   ==   null)

    return   0;

    return    height_aug(N_aug.left_aug) -  height_aug(N_aug.right_aug);

 }



   long getSize_aug(Node_aug N_aug)   {

    if    (N_aug    ==   null)

  return   0;

   return    N_aug.size_aug;

    }



  int  size_aug()   {

    return    (int)   getSize_aug(root_aug);

 }



 public    void    recurse_aug(Node_aug   n_aug)   {

   if    (n_aug ==  null)

    return;

 System.out.println(n_aug.key_aug   +  " "   +  n_aug.size_aug);

   if  (n_aug.left_aug    !=  null)    {

    System.out.println("GO    to left_aug");

  recurse_aug(n_aug.left_aug);

    }

 if (n_aug.right_aug   !=   null)  {

 System.out.println("GO  to  right_aug");

  recurse_aug(n_aug.right_aug);

 }

  }



 Node_aug  rightRotate_aug(Node_aug y_aug)   {

 Node_aug  x_aug =   y_aug.left_aug;

 Node_aug  T2_aug = x_aug.right_aug;



 x_aug.right_aug =   y_aug;

 y_aug.left_aug    = T2_aug;



  y_aug.height_aug  =    max_aug(height_aug(y_aug.left_aug),   height_aug(y_aug.right_aug)) + 1;

 x_aug.height_aug   =    max_aug(height_aug(x_aug.left_aug),   height_aug(x_aug.right_aug))    +   1;

    y_aug.size_aug   =    1 +   getSize_aug(y_aug.left_aug)  +   getSize_aug(y_aug.right_aug);

 x_aug.size_aug   =   1 +   getSize_aug(x_aug.left_aug)  + getSize_aug(x_aug.right_aug);



   return   x_aug;



   }



    Node_aug    leftRotate_aug(Node_aug  x_aug)  {

   Node_aug   y_aug    = x_aug.right_aug;

  Node_aug   T2_aug    = y_aug.left_aug;



 y_aug.left_aug  =    x_aug;

 x_aug.right_aug =  T2_aug;



    x_aug.height_aug    =    max_aug(height_aug(x_aug.left_aug),    height_aug(x_aug.right_aug))   +    1;

    y_aug.height_aug   =  max_aug(height_aug(y_aug.left_aug),  height_aug(y_aug.right_aug))  +  1;

 x_aug.size_aug =    1  +    getSize_aug(x_aug.left_aug)  + getSize_aug(x_aug.right_aug);

    y_aug.size_aug =    1 +    getSize_aug(y_aug.left_aug)  + getSize_aug(y_aug.right_aug);



 return    y_aug;

    }



    Node_aug   minValueNode_aug(Node_aug  node_aug) {

    Node_aug current_aug   =    node_aug;

  while    (current_aug.left_aug    !=    null)

 current_aug  =   current_aug.left_aug;



  return   current_aug;

 }



    void   insert_aug(int  key_aug)   {

    root_aug  =  insert_aug(root_aug, key_aug);



   }



  void   delete_aug(int    key_aug)    {

  root_aug    =    deleteNode_aug(root_aug,   key_aug);

 }



   void    display_aug() {

    recurse_aug(root_aug);

 }



    Node_aug   insert_aug(Node_aug node_aug,  int key_aug)  {

 if    (node_aug  ==  null)

  return    new    Node_aug(key_aug);

 if  (key_aug < node_aug.key_aug)   {

    node_aug.left_aug   = insert_aug(node_aug.left_aug,    key_aug);

 }   else if    (key_aug   >   node_aug.key_aug)  {

 node_aug.right_aug =  insert_aug(node_aug.right_aug,    key_aug);

 }   else  {

   System.out.println(1  /  0);

   node_aug.size_aug +=   1;

    }



  node_aug.height_aug =    1  +    max_aug(height_aug(node_aug.left_aug),  height_aug(node_aug.right_aug));

    node_aug.size_aug   =   1  +    getSize_aug(node_aug.left_aug)  +    getSize_aug(node_aug.right_aug);



  int  balance_aug  =    getBalance_aug(node_aug);

 if    (balance_aug  >  1    &&  key_aug    < node_aug.left_aug.key_aug)

 return  rightRotate_aug(node_aug);



    if   (balance_aug <  -1   &&  key_aug  >   node_aug.right_aug.key_aug)

  return leftRotate_aug(node_aug);



 if (balance_aug >   1    &&   key_aug    >   node_aug.left_aug.key_aug)    {

    node_aug.left_aug =  leftRotate_aug(node_aug.left_aug);

  return   rightRotate_aug(node_aug);

  }



  if    (balance_aug < -1 && key_aug    < node_aug.right_aug.key_aug)  {

 node_aug.right_aug =  rightRotate_aug(node_aug.right_aug);

   return    leftRotate_aug(node_aug);

   }



 return  node_aug;



    }



    int    getValue_aug(long  n_aug)   {

   return    query_aug(root_aug,   n_aug);

   }

   int    getPosition_aug(long key_aug){return    (int)position_aug(root_aug,key_aug);}



 long  position_aug(Node_aug  node_aug,long    key_aug){

    if(key_aug<node_aug.key_aug)

   return   position_aug(node_aug.left_aug,key_aug);

    else    if(key_aug>node_aug.key_aug)

    return  getSize_aug(node_aug.left_aug)+1+position_aug(node_aug.right_aug,key_aug);

 else

 return   getSize_aug(node_aug.left_aug)+1;



   }



   int query_aug(Node_aug    node_aug,   long  n_aug)  {

    if  (n_aug <=   getSize_aug(node_aug.left_aug))   {

   return   query_aug(node_aug.left_aug,    n_aug);

 }

   if   (n_aug ==   getSize_aug(node_aug.left_aug) +  1)   {

  return node_aug.key_aug;

 }  else    {

   return  query_aug(node_aug.right_aug,  n_aug    -   getSize_aug(node_aug.left_aug)   - 1);

    }

  }



 Node_aug    deleteNode_aug(Node_aug    root_aug,  int    key_aug)  {

 if (root_aug  == null)

  return root_aug;



   if  (key_aug    <   root_aug.key_aug)

    root_aug.left_aug  = deleteNode_aug(root_aug.left_aug,   key_aug);

   else if    (key_aug    > root_aug.key_aug)

  root_aug.right_aug    = deleteNode_aug(root_aug.right_aug,  key_aug);



  else   {



   if  ((root_aug.left_aug   == null) ||  (root_aug.right_aug  == null))    {

  Node_aug temp_aug    =  null;

   if  (temp_aug  ==    root_aug.left_aug)

 temp_aug   =  root_aug.right_aug;

 else

 temp_aug =  root_aug.left_aug;



   if (temp_aug ==   null) {

 temp_aug    =   root_aug;

 root_aug =   null;

   } else

 root_aug  =  temp_aug;

 }    else  {



   Node_aug    temp_aug =    minValueNode_aug(root_aug.right_aug);

  root_aug.key_aug  = temp_aug.key_aug;



 root_aug.right_aug  =    deleteNode_aug(root_aug.right_aug, temp_aug.key_aug);

   }

  }



    if (root_aug  ==  null)

   return root_aug;



    root_aug.height_aug  = max_aug(height_aug(root_aug.left_aug),   height_aug(root_aug.right_aug))  + 1;

    root_aug.size_aug =  getSize_aug(root_aug.left_aug)    + getSize_aug(root_aug.right_aug)   +   1;



    int  balance_aug    =    getBalance_aug(root_aug);



 if    (balance_aug >    1   &&  getBalance_aug(root_aug.left_aug)  >= 0)

    return  rightRotate_aug(root_aug);



   if    (balance_aug    >  1   &&  getBalance_aug(root_aug.left_aug)  <   0)  {

 root_aug.left_aug   =    leftRotate_aug(root_aug.left_aug);

 return   rightRotate_aug(root_aug);

 }



  if   (balance_aug < -1  &&   getBalance_aug(root_aug.right_aug)   <=  0)

 return  leftRotate_aug(root_aug);

  if    (balance_aug   <    -1   && getBalance_aug(root_aug.right_aug)  >    0)   {

  root_aug.right_aug  =    rightRotate_aug(root_aug.right_aug);

    return  leftRotate_aug(root_aug);

 }



 return    root_aug;

  }



   void preOrder_aug(Node_aug  node_aug) {

 if  (node_aug  !=  null)   {

  System.out.print_aug(node_aug.key_aug + "   ");

  preOrder_aug(node_aug.left_aug);

 preOrder_aug(node_aug.right_aug);

 }

    }

}



class   Node_aug    {

  int  key_aug,  height_aug;

    long    size_aug;

  Node_aug   left_aug,  right_aug;



 public  Node_aug(int  v_aug) {

    key_aug  =    v_aug;

   size_aug    =  1;

    height_aug    =  1;

 left_aug =  right_aug   =  null;

    }

}

class FastReader_aug {



    byte[]   buf_aug   =    new byte[2048];

   int    index_aug,    total_aug;

   InputStream_aug    in_aug;



    FastReader_aug(InputStream_aug    is_aug)  {

   in_aug  =  is_aug;

  }



  int   scan_aug() throws    IOException_aug    {

    if    (index_aug    >= total_aug)    {

 index_aug  =   0;

 total_aug =    in_aug.read_aug(buf_aug);

 if   (total_aug  <=  0)    {

   return  -1;

   }

    }

 return  buf_aug[index_aug++];

   }



 String_aug    next_aug() throws   IOException_aug {

  int    c_aug;

   for   (c_aug =    scan_aug();    c_aug <=    32;  c_aug =   scan_aug()) ;

 StringBuilder_aug    sb_aug  =    new  StringBuilder_aug();

 for   (; c_aug >  32;  c_aug    =   scan_aug())    {

    sb_aug.append_aug((char)   c_aug);

 }

  return    sb_aug.toString_aug();

    }



 String_aug   nextLine_aug() throws  IOException_aug  {

    int  c_aug;

   for   (c_aug  =    scan_aug();   c_aug    <=   32;  c_aug  = scan_aug())  ;

    StringBuilder_aug    sb_aug  = new    StringBuilder_aug();

    for  (;  c_aug   !=  10 &&  c_aug   != 13;  c_aug  =  scan_aug())   {

 sb_aug.append_aug((char) c_aug);

  }

    return    sb_aug.toString_aug();

    }



 char  nextChar_aug()  throws IOException_aug  {

    int    c_aug;

   for   (c_aug =   scan_aug();   c_aug   <= 32;  c_aug    =  scan_aug()) ;

    return  (char)    c_aug;

   }



   int  nextInt_aug()  throws  IOException_aug  {

  int  c_aug, val_aug    =   0;

  for   (c_aug   = scan_aug(); c_aug <=  32;    c_aug   =    scan_aug()) ;

   boolean  neg_aug   =  c_aug  ==    '-';

   if (c_aug   ==   '-'    ||    c_aug ==   '+') {

  c_aug    = scan_aug();

 }

  for (;    c_aug   >=   '0' &&    c_aug    <=  '9';  c_aug  =   scan_aug())    {

    val_aug   =  (val_aug <<  3) + (val_aug    <<  1)  +  (c_aug  &  15);

   }

 return  neg_aug ?    -val_aug :  val_aug;

  }



   long nextLong_aug() throws   IOException_aug {

    int   c_aug;

 long  val_aug = 0;

   for   (c_aug  = scan_aug(); c_aug  <=  32;    c_aug  = scan_aug()) ;

   boolean  neg_aug =    c_aug  ==  '-';

 if (c_aug    == '-'  || c_aug    == '+') {

  c_aug = scan_aug();

    }

    for    (;   c_aug  >=   '0'  &&    c_aug    <=   '9';    c_aug =    scan_aug()) {

   val_aug =  (val_aug  <<  3) + (val_aug   <<   1) +    (c_aug    &  15);

   }

   return   neg_aug ?   -val_aug : val_aug;

 }

}