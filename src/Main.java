
/**
 * Main class of the Java program. 
 * 
 */
import java.util.LinkedList;
import static org.junit.Assert.assertTrue;

public class Main {

	public static void main(String[] args) {
		// test your implementation here
		LinkedTree<String> t = new LinkedTree();

		t.insert(16, "R");
		t.insert(16, "D");
		t.insert(16, "T");

		t.insert(8, "A");
		t.insert(8, "C");
		t.insert(8, "E");

		t.insert(4, "D");
		t.insert(4, "R");
		t.insert(4, "M");

		t.insert(15, "H");
		t.insert(15, "O");
		t.insert(15, "P");

		t.insert(23, "M");
		t.insert(23, "I");
		t.insert(23, "L");

		t.insert(42, "A");
		t.insert(42, "H");
		t.insert(42, "E");

		int[] toDelete = new int[] { 4, 23, 16 };
		LinkedList<String>[] data = new LinkedList[toDelete.length];

		for (int i = 0; i < toDelete.length; ++i) {
			data[i] = t.delete(toDelete[i]);
			if (data[i] != null) {
				System.out.println(data[i].toString() + " key: " + toDelete[i]);
			}
		}

		// traverse
		t.inorder(0);
		t.postorder(1);
		t.preorder(2);

		// delete test
		replicateDeleteTest();
	}

	public static void replicateDeleteTest() {

		// inserts/ops from insertAndSearchTest()
		LinkedTree<String> x = new LinkedTree();
		x.insert(100, "Root");
		x.insert(150, "Right");
		x.insert(50, "Left");
		x.insert(200, "RightRight");
		x.insert(140, "RightLeft");
		x.insert(20, "LeftLeft");
		x.insert(70, "LeftRight");

		// content of deleteTest()
		LinkedList<String>[] elements = new LinkedList[4];

		elements[0] = x.delete(100);
		elements[1] = x.delete(20);
		elements[2] = x.delete(150);
		elements[3] = x.delete(200);

		for (int i = 0; i < elements.length; i++) {
			assertTrue(elements[i] != null && elements[i].size() == 1);
		}

		assertTrue(elements[0].get(0).equals("Root"));
		assertTrue(elements[1].get(0).equals("LeftLeft"));
		assertTrue(elements[2].get(0).equals("Right"));
		assertTrue(elements[3].get(0).equals("RightRight"));

		assertTrue(x.search(50) != null);
		assertTrue(x.search(70) != null);
		assertTrue(x.search(140) != null);

		assertTrue(x.search(100) == null);
		assertTrue(x.search(20) == null);
		assertTrue(x.search(150) == null);
		assertTrue(x.search(200) == null);
	}
}
