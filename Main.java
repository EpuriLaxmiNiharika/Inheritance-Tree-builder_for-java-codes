import javax.swing.JFrame;
import javax.swing.JTree;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main extends JTree{
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		inner_classes_all in = new inner_classes_all(args[0]);
		ListInheritanceClasses inheritance = new ListInheritanceClasses(args[0]);
		ListAllClasses e = new ListAllClasses(args[0]);
		JTree middle = e.Make_Tree();
		JTree left = in.build_tree();
		JTree right = inheritance.InheritanceTreeBuild();
		JPanel panel = new JPanel(new GridLayout(1,0));
		panel.add(new JScrollPane(middle));
		panel.add(new JScrollPane(left));
		panel.add(new JScrollPane(right));
		f.add(new JScrollPane(panel));
		f.setSize(500,400);
		f.setLocation(200,200);
		f.setVisible(true);
	}
}
