/******************************  TreeToolsTest.java  **************************/

/**
 * Test fuer die Klasse TreeTools
 */

public class TreeToolsTest {

  public static void main(String[] argv) {

    // Erzeuge einen Test-Baum
	//  System.out.println("Test");
  
    LinkedTree a = new LinkedTree(new Character('A'));
    LinkedTree b = new LinkedTree(new Character('B'));
    LinkedTree m = new LinkedTree(a, new Character('*'), b);
    LinkedTree f = new LinkedTree(new Character('F'));
    LinkedTree p = new LinkedTree(f, new Character('+'), m);
    LinkedTree x = new LinkedTree(new Character('X'));
    LinkedTree y = new LinkedTree(new Character('Y'));
    LinkedTree n = new LinkedTree(x, new Character('-'), y);
    LinkedTree d = new LinkedTree(p, new Character('/'), n);
    
    
    // Testet treeHeight(), anzahlKnoten(), 
    System.out.println(TreeTools.treeHeight(d));
    System.out.println(TreeTools.anzahlKnoten(d));
    TreeTools.printTree(m); 
    TreeTools.printTreeInorderWithParenthesis(m);
    TreeTools.printTreeLevelorder(a);
    // printTreeInorderWithParenthesis(), printTreeLevelorder()
    
   
    System.out.println("Baumhoehe laut Methode (sollte 4 sein): " 
                   + TreeTools.treeHeight(d));
    
    System.out.println("Anzahl Knoten laut Methode (sollte 9 sein): "
                   + TreeTools.anzahlKnoten(d));
  
    System.out.print("Ausdruck mit Klammerung: ");
    TreeTools.printTreeInorderWithParenthesis(d);
    System.out.println();
   
    System.out.print("Baum ebenenweise: ");
    TreeTools.printTreeLevelorder(d);
    System.out.println();

    
    // Testet searchTreeSort()
    
    System.out.println("Sortiere  6194283");
    int[] a2 = {6,1,9,4,2,8,3};
    a2 = TreeTools.searchTreeSort(a2);
    System.out.print("Ergebnis (sollte 1234689 sein): ");
    for(int i = 0; i < a2.length; i++) 
      System.out.print(a2[i]);
    
    System.out.println();
   	TreeTools.heightOfRandomSearchTree(1000, 100);
	//  System.out.println(Math.log(1000)/Math.log(2));
  }
  
}

