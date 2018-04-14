/******************************  TreeTools.java  ******************************/

/**
 * Tool-Klasse mit einigen Algorithmen fuer Baeume
 */

public class TreeTools {

  /**
   * Ermittelt die Hoehe eines Baumes
   * @param b der zu uebergebende Baum
   * @return Hoehe des Baumes
   */
  public static int treeHeight(Tree b) {
	if(b.empty()){
		return 0;
	}
	else{
		int heightright=0;
		 int heightleft=0;
		 if(!b.empty())
			  heightleft = treeHeight(b.left());
		  if(!b.empty())
			  heightright = treeHeight(b.right());
		  if(heightleft > heightright){
		        return heightleft+1;
		    }
		  else{
			  return heightright+1;
		  }
	}

  }
  
  /**
   * Ermittelt die Anzahl der Knoten eines Baumes
   * @param b der zu uebergebende Baum
   * @return Anzahl der Knoten des Baumes
   */
  public static int anzahlKnoten(Tree b) {
	  
	  if(b.empty()){
		  return 0;
	  }	 
	  else{
		  int zaehler = 1;  
	  
		  if(!b.left().empty()){
			  zaehler += anzahlKnoten(b.left());
		  }
		  if (!b.right().empty()){
			  zaehler += anzahlKnoten(b.right());
		  }
	 
		  return zaehler;
	  }
}
    
   
  
  /**
   * gibt den �bergebenen Baum in Inorder-Traversierung mit Klammerung aus
   * @param b der zu uebergebende Baum
   */
  public static void printTreeInorderWithParenthesis(Tree b) {
    // TODO
	  if(!b.empty()) {
		  System.out.print("(");
		  printTreeInorderWithParenthesis(b.left());
		   System.out.printf("%c",b.value());
		   printTreeInorderWithParenthesis(b.right());
		   System.out.print(")");
		  }
    
  }  
   
  /**
   * gibt den �bergebenen Baum in Levelorder-Traversierung aus
   * @param b der zu uebergebende Baum
   */
  public static void printTreeLevelorder(Tree b) {
    // TODO
	  if(!b.empty()){
	        if(!b.left().empty() && !b.right().empty()){
	            System.out.print(b.value() + " ");
	            System.out.print(b.left().value() + " ");
	            System.out.print(b.right().value() + " ");
	            printTreeLevelorder(b.left());
	            printTreeLevelorder(b.right());
	        }
	        else if(b.left().empty() && b.right().empty()){;}
	        else if(b.right().empty()){
	            System.out.print(b.left().value() + " ");
	            
	        }
	        else{
	            System.out.print(b.right().value() + " ");
	         
	        }
	    }
    
  }  
   
  /**
   * Sortiert gegebene Zahlenfolge per Suchbaum
   * @param zahlen zu sortierende Zahlenfolge
   * @return sortierte Folge
   */
  public static int[] searchTreeSort(int[] zahlen) {
	SearchTree t = new SearchTree();
	for(int i : zahlen){
		t.insert(i);
	}
	LinkedStack s = new LinkedStack();
	tree2SortedStack(t,s);
	for(int i =0; !s.empty();i++){
		zahlen[i] = (int) s.top();
		s.pop();
	}

	return zahlen;

    
  }  

  /**
   * Helfermethode zum sortieren von Elementen im SearchTree
   * @param b SearchTree mit zu sortierendem Inhalt
   * @param k Stack in den der SearchTree Inhalt sortiert werden soll
   */
  private static void tree2SortedStack(Tree b, Stack k) {
    if(b.empty())
    	return;
    
    tree2SortedStack(b.right(),k);
    k.push(b.value()); 
    tree2SortedStack(b.left(),k);
	  
    
  }
  
  public static int [] createRandomArray(int n){
	  return StdRandom.permutation(n);
  }
  
  public static void heightOfRandomSearchTree(int nodes, int iterations){
	
	  SearchTree[] st = new SearchTree[iterations];
	  for(int i=0;i<iterations;i++){
		  st[i]= new SearchTree();
	  }
	  
	  for(int x=0;x<st.length;x++){
		  int [] a = createRandomArray(nodes);
		  for(int i: a){
			  st[x].insert(i);
		  }
	  }
	  int i=0;
	  int sum=0;
	  for(SearchTree s : st){
		  i++;
		  System.out.println("Hoehe Suchbaum "+i+": " + treeHeight(s));
		  sum+=treeHeight(s);
	  }
		System.out.format("Durchschnittliche Hoehe: " + sum/iterations + " entspricht %.2f  * log2(n)" ,(sum/iterations)/(Math.log(nodes)/Math.log(2)));  
  }
  /**
   * Druckt einen Baum auf der Konsole ebenenweise aus.
   * Nutzt treeHeight(Tree), printLevel(Tree,int,int) und spaces(int).
   * @param b der zu druckende Baum
   */
  public static void printTree(Tree b) {

    // Berechne die Hoehe des Baumes
    int resthoehe = treeHeight(b);

    //Gehe die Ebenen des Baumes durch
    for(int i = 0; i < resthoehe; i++) {
      //Drucke die Ebene, beruecksichtige Anzahl der Leerzeichen
      //fuer korrekte Einrueckung
      printLevel(b, i, spaces(resthoehe - i));
      System.out.println();
      System.out.println();
    }
  }

  /**
   * Druckt eine Ebene eines Baumes aehnlich der Breitensuche.
   * 0 ist dabei die Wurzel. Vor und nach jedem Element werden Leerzeichen 
   * eingefuegt.
   * @param b der auszugebende Baum
   * @param ebene die gewuenschte Ebene beginnend bei 0
   * @param spaces Anzahl von Leerzeichen vor und nach jedem Element
   */
  public static void printLevel(Tree b, int level, int spaces) {

    // Wenn 0 erreicht, drucke Element mit Leerzeichen
    if(level == 0) {

      for (int i = 0; i < spaces; i++) System.out.print(" ");
      if(b != null) {
    	  System.out.print(b.value());
      }
      else { // Wenn Nullzeiger uebergeben wurde, ein Leerzeichen drucken
    	  System.out.print(" ");
      }
      for (int i = 0; i <= spaces; i++) System.out.print(" ");

    } else {

      // Steige rekursiv ab, betrachte Soehne als Teilbaeume und verringere
      // dabei die zu druckende Ebene. In endende Aeste wird mit dem Nullzeiger
      // gelaufen.
      if(b != null && !b.left().empty()) {
        printLevel(b.left(), level - 1, spaces);
      }
      else {
        printLevel(null, level - 1, spaces);
      }

      if(b != null && !b.right().empty()) {
        printLevel(b.right(), level - 1, spaces);
      }
      else {
        printLevel(null, level - 1, spaces);
      }
    }
  }

  /**
   * Berechnet die Anzahl an benoetigten Leerzeichen fuer
   * eine korrekte Einrueckung, also 0.5 * (2^(level) - 2).
   * @param level die Ebene, Blaetter sind Ebene 1, darueber aufsteigend
   * @return Anzahl der Leerzeichen zur Elementtrennung
   */
  private static int spaces(int level) {

    if(level == 1) {
      return 0;
    }
    else {
      // verdoppele die Leerzeichen gegenueber der Ebene darunter
      // und fuege ein weiteres Leerzeichen hinzu
      return 2 * spaces(level - 1) + 1;
    }
  }
}
