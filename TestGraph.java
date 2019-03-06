import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TestGraph {
	public static void main(String[] args) {
		try {
			
			BufferedReader bufReader = new BufferedReader(new FileReader("C:\\Users\\plas_\\Desktop\\자료구조설계\\자료구조 2주차\\graph.txt"));
			
			String line = bufReader.readLine();
			String lineSplit[] = line.split(" ");
			Graph g = new Graph(lineSplit);
			line = bufReader.readLine();
			while(line != null) {
				String lineSplitedge[] = line.split(" ");
				g.add(lineSplitedge[0], lineSplitedge[1]);
				line = bufReader.readLine();
			}
			System.out.println(g);
			//g.Breadth_First_Search("A");
			for(int k=0; k<g.size; k++) {
				for(int t=0; t<g.size; t++) {
					if(k != t)
					g.findPath(g.vertices[k], g.vertices[t]);
				}
			}
			bufReader.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}