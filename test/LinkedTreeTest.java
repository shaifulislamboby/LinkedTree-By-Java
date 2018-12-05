import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.LinkedList;

public class LinkedTreeTest {
    LinkedTree<String> x;
    
    @Before
    public final void init() {
    	
    	x = new LinkedTree<String>();
    	
        x.insert(100, "Root");
        x.insert(150, "Right");
        x.insert(50, "Left");
        x.insert(200, "RightRight");
        x.insert(140, "RightLeft");
        x.insert(20, "LeftLeft");
        x.insert(70, "LeftRight");
    }
    
    @Test
    public final void insertAndSearchTest() {
        
        LinkedList<String>[] elements = new LinkedList[7];
        
        elements[0] = x.search(100);
        elements[1] = x.search(150);
        elements[2] = x.search(50);
        elements[3] = x.search(200);
        elements[4] = x.search(140);
        elements[5] = x.search(20);
        elements[6] = x.search(70);
        
        for (int i = 0; i < elements.length; i++)
            assertTrue(elements[i] != null && elements[i].size() == 1);
            
        assertTrue(elements[0].get(0).equals("Root"));
        assertTrue(elements[1].get(0).equals("Right"));
        assertTrue(elements[2].get(0).equals("Left"));
        assertTrue(elements[3].get(0).equals("RightRight"));
        assertTrue(elements[4].get(0).equals("RightLeft"));
        assertTrue(elements[5].get(0).equals("LeftLeft"));
        assertTrue(elements[6].get(0).equals("LeftRight"));
    }
    
    @Test
    public final void deleteTest() {
        LinkedList<String>[] elements = new LinkedList[4];
        
        elements[0] = x.delete(100);
        elements[1] = x.delete(20);
        elements[2] = x.delete(150);
        elements[3] = x.delete(200);
        
        
        for (int i = 0; i < elements.length; i++)
            assertTrue(elements[i] != null && elements[i].size() == 1);
            
        assertTrue(elements[0].get(0).equals("Root"));
        assertTrue(elements[1].get(0).equals("LeftLeft"));
        assertTrue(elements[2].get(0).equals("Right"));
        assertTrue(elements[3].get(0).equals("RightRight"));
        
        assertTrue(x.search(50) != null);
        assertTrue(x.search(70) != null);
        assertTrue(x.search(140) != null);
        
        assertNull(x.search(100));
        assertNull(x.search(20));
        assertNull(x.search(150));
        assertNull(x.search(200));
        
    }
}
