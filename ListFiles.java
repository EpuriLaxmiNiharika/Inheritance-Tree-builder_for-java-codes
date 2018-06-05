import java.util.ArrayList;
import com.github.javaparser.JavaParser;
import me.tomassetti.support.DirExplorer;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import com.github.javaparser.ParseException;

public class ListFiles {

	static ArrayList <String> files = new ArrayList<String>();

	public static ArrayList<String> listClasses(File projectDir) {    
		files.clear();
		new DirExplorer((level, path, file) -> path.endsWith(".java"), (level, path, file) -> {
				path = projectDir.toString() + path;
				files.add(path);
				try {
				JavaParser.parse(file);
				}
				catch (ParseException | IOException e) {
				new RuntimeException(e);
				}            
				}).explore(projectDir);

		//System.out.println("in another cas"+files.size());
		return files;
	}
}

