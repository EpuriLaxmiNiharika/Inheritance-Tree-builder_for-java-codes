import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTree;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public  class ListInheritanceClasses {

	ArrayList<String> s = new ArrayList<String>();
	ArrayList<String> files_list = new ArrayList<String>();
	static Multimap<String, String> hm = ArrayListMultimap.create();
	public static ArrayList<String> list = new ArrayList<String>();


	String Directory;

	public ListInheritanceClasses(String directory){

		Directory = directory;

	}

	final String keywords[] = { "abstract","class", "interface"};

	final String modifiers[] = {"private","protected", "public"};

	final char brackets[] = {'{', '}','[',']',')','('};



	public  boolean find_keyword(String s)
	{
		for(int i=0; i< keywords.length; i++)
		{
			if(s.equals(keywords[i]))
			{
				return true;
			}

		}

		return false;      


	}

	public  boolean find_modifiers(String s)
	{
		for(int i=0; i< keywords.length; i++)
		{
			if(s.contains(modifiers[i]))
			{
				return true;
			}

		}

		return false;      


	}

	public  String return_substring(String s)
	{
		for(int i =0 ; i< s.length() ; i++)
		{
			if(find_bracket(s.charAt(i)))
			{
				//	System.out.println(s.charAt(i));
				if(i>=1)
					return s.substring(0,i);
				else
					String.valueOf(s.charAt(0));
			}	

		}
		return s;

	}

	public  boolean find_bracket(char s)
	{
		for(int i=0; i< brackets.length; i++)
		{
			if(s == brackets[i])
			{
				return true;
			}

		}

		return false;      
	}

	public  boolean find_keywords(String s3)
	{
		System.out.println("I am s3"+s3);
		//if(s3.length()>=5){
		//	System.out.println(s3.substring(s3.length()-5,s3.length()));}
		if(s3.length()>=5)
		{
			String s1 = s3.substring(s3.length()-5,s3.length());
			System.out.println(s1);
			if(s1.equals("class"))
			{
				//	System.out.println(s1);
				return true;
			}
			if(s3.length()>=9)
			{
				//	System.out.println("I am mad "+s3);
				String s2 = s3.substring(s3.length()-9,s3.length());
				if(s2.equals("interface"))
				{
					//	System.out.println("I am s2: " +s2);
					return true;
				}

			}
		}


		return false; 
	}





	public  void getHashMap()
	{int flag =0;
		for(int i=0 ; i<list.size();i++)
		{
			if((list.get(i).equals("extends")) && i >= 2) 
			{	
				if((!find_keyword(list.get(i-1))) && (find_keywords(list.get(i-2))) && (i <= list.size()-2) && (!find_keyword(list.get(i+1))) && (!find_bracket(list.get(i+1).charAt(0))))
				{
					//	list.set(i+1, return_substring(list.get(i+1)));
					String s1 = return_substring(list.get(i+1));
					if(list.get(i-2).contains("class"))
					{
						if(i>=3)
						{
							if(list.get(i-3).contains("abstract"))
							{
								flag =0;
							}

							else if(list.get(i-3).contains("interface")) { flag = 1;}

							else if(list.get(i-3).contains("class")) {flag = 1;}

						}

						if(flag ==0) {

							s.add(list.get(i-1)+  "->" + s1);

							hm.put(s1,list.get(i-1));
						}

					}


					else if(list.get(i-2).contains("interface"))
					{
						if(i>=3)
						{
							if(list.get(i-3).contains("interface")){flag =1;}
							if(list.get(i-3).contains("class")){flag =1;}
							if(list.get(i-3).contains("abstract")) {flag = 1;}
						}

						if(flag ==0) {

							s.add(list.get(i-1)+  "->" + s1);

							hm.put(s1,list.get(i-1));

						}


					}

				}

			}
		}
	}

	public   void copyArrayList(ArrayList<String> s)
	{
		//  System.out.println(" i am suzesss" + s.size());
		for(int i=0; i< s.size(); i++)
		{
			files_list.add(s.get(i));
		}

		//	System.out.println(" i am craxck" + files_list.size());

	}

	public JTree InheritanceTreeBuild() {

		getInherianceList();

		return new InheritanceTree(hm).TreeBuild();

	}


	public void getInherianceList() 
	{

		try{
			File projectDir = new File(Directory);
			copyArrayList(ListFiles.listClasses(projectDir));
			//	System.out.println("files zie "+files_list.size());
			Split_Words();				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}



	}

	public  void PrintArrayList(List<String> s)
	{
		for(int i =0; i<s.size();i++)
		{
			System.out.println(s.get(i));
		}
	}
	public void Split_Words()
	{
		for(int i =0; i< files_list.size(); i++)
		{
			try{Scanner s = new Scanner(new File(files_list.get(i)));
				String lineFromFile;
				while (s.hasNext()){
					list.add(s.next().toString());
				}
				getHashMap();
				list.clear();
				s.close();
			}
			catch (Exception e) {
				System.out.println(e);

			}
		}

		//	System.out.println("I am sasasa");
		//	System.out.println(files_list.size());
		//	PrintArrayList(s);	


	}		


}

