import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Set;

public class InheritanceTree extends JTree
{

	DefaultMutableTreeNode root;
	ArrayList<DefaultMutableTreeNode> s1 = new ArrayList<DefaultMutableTreeNode>();
	JTree tree1;
	ArrayList<String> s = new ArrayList<String>();
	Multimap<String, String> hm = ArrayListMultimap.create();

	public InheritanceTree(Multimap<String, String> hm){

		root = new DefaultMutableTreeNode("Inheritance");
		tree1 = new JTree(root);
		this.hm = hm;
		//copyArrayList(s);
	}



	public JTree TreeBuild()
	{	

		Set<String> keys = hm.keySet();

		// iterate through the key set and display key and values

		for (String key : keys) {

			DefaultMutableTreeNode Node1 = new DefaultMutableTreeNode(key);

			//   System.out.println("Key = " + key);

			for(String s1 : hm.get(key))
			{
				DefaultMutableTreeNode Node2 = new DefaultMutableTreeNode(s1);
				Node1.add(Node2);
			}

			root.add(Node1);

		}

		add(tree1);

		return tree1;

	}

}
