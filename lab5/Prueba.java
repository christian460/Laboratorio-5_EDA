package lab5;

public class Prueba {

	public static void main(String[] args) {
		ArbolAvl<Integer> avlTree = new ArbolAvl<>();
        avlTree.insert(100);
        avlTree.insert(200);
        avlTree.insert(300);
        avlTree.insert(400);
        avlTree.insert(500);
        avlTree.insert(50);
        avlTree.insert(25);
        avlTree.insert(350);
        avlTree.insert(375);
        avlTree.insert(360);
        avlTree.insert(355);
        avlTree.insert(150);
        avlTree.insert(175);
        avlTree.insert(120);
        avlTree.insert(190);
        
        System.out.println(avlTree);
        avlTree.delete(200);
        System.out.println(avlTree);
	}
}
