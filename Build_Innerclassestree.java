
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class Build_Innerclassestree extends JFrame{


	public static JTree tree1;
	public static DefaultMutableTreeNode inner;

	static ArrayList<DefaultMutableTreeNode> s1 = new ArrayList<DefaultMutableTreeNode>();

	static ArrayList<String> s = new ArrayList<String>();

	public Build_Innerclassestree(ArrayList<String> s)
	{

		copyArrayList(s);
		inner = new DefaultMutableTreeNode("InnerClasses");
		tree1 = new JTree(inner);
	}

	public Build_Innerclassestree()
	{

	}


	public static void copyArrayList(ArrayList<String> s1)
	{

		for(int i=0; i< s1.size(); i++)
		{
			s.add(s1.get(i));

		}
	}

	public  void PrintArrayList(List<String> s)
	{
		for(int i =0; i<s.size();i++)
		{
			System.out.println(s.get(i));
		}
	}


	public  boolean check_substring(String s1,String s2)
	{
		if(s1.contains(s2))
		{

			return true; 
		}
		else {			
			return false;
		}
	} 


	public  int find_dots(String s)
	{
		int count =0;
		for(int i = 0; i < s.length(); i++)	
		{ if( s.charAt(i) == '.' )
			count++;

		}
		return count;

	}

	public JTree Tree_Innerclass()
	{
		return tree1;

	}

	public  void Change_List()
	{

		//System.out.println("I am s");

		//PrintArrayList(s);	
		ArrayList <String> temp = new ArrayList<String>();

		for(; s.size()>1; )
		{
			if(find_dots(s.get(0)) ==0)
			{
				if(find_dots(s.get(1)) ==0)
				{
					//	System.out.println("sasa"+s.get(0));
					s.remove(0);

				}
				else if(s.get(1).contains(s.get(0)) && (find_dots(s.get(1))!=0))
				{

					temp.add(s.get(0));
					s.remove(0);
				}		

			}
			else{
				temp.add(s.get(0));
				s.remove(0);

			}

		}
		//System.out.println("I am temp");
		if(find_dots(s.get(0)) == 1)
			temp.add(s.get(0));
		//PrintArrayList(temp);
		s = temp;
		//PrintArrayList(s);
		//PrintArrayList(s);	

	}

	public JTree TreeExample()
	{	

		Change_List();
		// PrintArrayList(s);	
		s1.clear();
		for(int i =0; i< s.size();i++)
		{
			s1.add(new DefaultMutableTreeNode(s.get(i)));
			if(find_dots(s.get(i)) ==0)
			{
				inner.add(s1.get(i));
			}
		}
		for(int i =0; i< s1.size(); i++)
		{			
			System.out.println("I am listing all class");
			String str = s1.get(i).getUserObject().toString();
			int len = str.length();
			int count = find_dots(str);
			System.out.println(str);
			//	System.out.println(count);
			for(int j =i+1 ; j< s1.size() ; j++)
			{
				String str1 = s1.get(j).getUserObject().toString();
				int count1 = find_dots(str1);
				//	System.out.println(count1);
				if((count1 == count+1) && check_substring(str1, str))
				{
					//System.out.println(str);
					//	if(s.get(j).charAt(len) == '.')
					s1.get(i).add(s1.get(j));
					//	else;
				} 

			}

		}

		add(tree1);
		return tree1;
	}


}
