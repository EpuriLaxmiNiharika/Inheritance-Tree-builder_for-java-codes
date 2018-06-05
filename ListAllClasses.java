import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.HashMap;
import com.github.javaparser.ast.*;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.common.base.Strings;
import me.tomassetti.support.DirExplorer;
import java.io.FileInputStream;
import com.github.javaparser.ast.body.*;
import java.io.File;
import java.io.IOException;

public class ListAllClasses extends JFrame{

	ArrayList<String> s = new ArrayList<String>();

	String Directory;

	private DefaultMutableTreeNode classes = new DefaultMutableTreeNode("ClassesList");

	private  JTree tree;


	public ListAllClasses(String s )
	{
		Directory =s;
	}


	public JTree Make_Tree()
	{
		File projectDir = new File(Directory);
		listClasses(projectDir);
		for(int i=0; i< s.size(); i++)
		{
			classes.add(new DefaultMutableTreeNode(s.get(i)));
		}

		tree = new JTree(classes);
		return tree;	
	}

	public static void PrintArrayList(List<String> s)
	{
		for(int i =0; i<s.size();i++)
		{
			System.out.println(s.get(i));
		}
	}

	private  void listClasses(File projectDir) {
		new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
				System.out.println(path);
				System.out.println(Strings.repeat("=", path.length()));
				try {
				new VoidVisitorAdapter<Object>() {
				@Override
				public void visit(ClassOrInterfaceDeclaration n, Object arg) {
				super.visit(n, arg);
				//   System.out.println(" * " + n.getName());
				s.add(n.getName());
				try
				{
				Class c = Class.forName(n.getName());
				System.out.println(c.getSuperclass());
				}
				catch (Exception e)
				{

				}
				}
				}.visit(JavaParser.parse(file), null);
				System.out.println(); // empty line
				} catch (ParseException | IOException e) {
					new RuntimeException(e);
				}
		}).explore(projectDir);
	}

}
