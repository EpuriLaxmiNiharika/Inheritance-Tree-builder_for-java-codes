import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String.*;
import java.util.*;
class Main{
	class C extends D {}
} 

class D{

		class E {}
	
}

class F extends G{}
class G{}
public class outerclass{
class A
{
class B
{
}

}
public static void main(String args[])
{
ListFilesUtil l = new ListFilesUtil();
List<File> file = l.listFilesAndFilesSubDirectories(args[0]);
for(int i =0 ; i< file.size() ; i++)
	{
	//l.list_class(file.get(i));
	}
}
}
