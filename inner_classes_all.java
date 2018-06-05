import java.util.ArrayList;
import java.util.List;
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
import javax.swing.JTree;

class inner_classes_all{

	String dir_name ;
	static ArrayList<String> files_list = new ArrayList<String>();
	static ArrayList<String> s = new ArrayList<String>();
	static ArrayList <String> files = new ArrayList<String>();

	public inner_classes_all(String dir){
		this.dir_name = dir;
	}


	public JTree build_tree()
	{
		Find_InnerClasses(dir_name);
		//	return new Build_Innerclassestree(s).TreeExample();
		return new Build_Innerclassestree().Tree_Innerclass();
	}

	public  void Print_Array(List<BodyDeclaration> a)
	{
		for(int i =0 ; i< a.size(); i++)
		{
			System.out.println(a.get(i).toString());
		}
	}

	public  void copyArrayList(ArrayList<String> s)
	{
		for(int i=0; i< s.size(); i++)
		{
			files_list.add(s.get(i));
		}
	}

	void Find_InnerClasses(String Directory)
	{
		File projectDir = new File(Directory);
		copyArrayList(ListFiles.listClasses(projectDir));
		CompilationUnit cu;
		for(int i =0; i< files_list.size(); i++)
		{
			try (FileInputStream in = new FileInputStream(files_list.get(i))) 
			{
				cu = JavaParser.parse(in);
				List<TypeDeclaration> types = cu.getTypes();
				ArrayList<String> parents = new ArrayList<>();		
				for (TypeDeclaration typeDeclaration : types) 
				{
					printTypes(typeDeclaration, parents);
				}
			}
			catch(Exception e){

				System.out.println(e);
			}

			new Build_Innerclassestree(s).TreeExample();
			s.clear();
		}
		//	 return Build_Innerclassestree().;

	}

	private static void printTypes(BodyDeclaration item, List<String> parents) 
	{
		if (item instanceof TypeDeclaration) 
		{
			TypeDeclaration type = (TypeDeclaration) item;

			s.add(getClassName(type.getName(), parents));

			List<BodyDeclaration> members = type.getMembers();

			List<String> cloneOfParents = new ArrayList<>(parents);

			cloneOfParents.add(type.getName());

			for (BodyDeclaration bodyDeclaration : members) 
			{
				printTypes(bodyDeclaration, cloneOfParents);
			}

		}

	}

	private static String getClassName(String name, List<String> parents) {
		StringBuilder builder = new StringBuilder();
		for (String string : parents) {
			builder.append(string);
			builder.append(".");
		}
		return builder.append(name).toString();

	}

	public  void PrintArrayList(List<String> s)
	{
		for(int i =0; i<s.size();i++)
		{
			System.out.println(s.get(i));
		}
	}
}
