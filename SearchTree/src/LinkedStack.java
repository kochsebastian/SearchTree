/***************************  LinkedStack.java ******************************/

/** Implementation eines Stacks mithilfe von Verweisen
  */

public class LinkedStack implements Stack {
  
  private Eintrag top;                           // verweist auf obersten
                                                 // StackEintrag
  
  public LinkedStack() {                         // legt leeren Stack an     
    top = null;
  }
  
  public boolean empty() {                       // liefert true,
    return top == null;                          // falls Stack leer
  }
  
  public void push(Object x) {                   // legt Objekt x    
    Eintrag hilf = new Eintrag();                // auf den Stack
    hilf.inhalt  = x;
    hilf.next    = top;
    top          = hilf;
  }
  
  public Object top() {                          // liefert Top-Element 
    if (empty()) 
      throw new RuntimeException(" Stack ist leer ");
    return top.inhalt;                            
  }
  
  public void pop() {                            // entfernt Top-Element
    if (empty()) 
      throw new RuntimeException(" Stack ist leer ");
    top = top.next;
  }
}
