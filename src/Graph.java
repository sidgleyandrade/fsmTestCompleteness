import java.util.Iterator;
import java.util.Set;
import org.jgraph.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.alg.BronKerboschCliqueFinder;

public class Graph {	
	
	static UndirectedGraph<Object, DefaultEdge> graph;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ListenableGraph<Object, DefaultEdge> graph = new ListenableUndirectedGraph<Object, DefaultEdge>(DefaultEdge.class);
		graph = new SimpleGraph<Object, DefaultEdge>(DefaultEdge.class);		
		
		// add vertex
		graph.addVertex( "0" );
		graph.addVertex( "1" );
		graph.addVertex( "2" );
		graph.addVertex( "3" );
		graph.addVertex( "4" );
		graph.addVertex( "5" );
		graph.addVertex( "6" );
		graph.addVertex( "7" );
		graph.addVertex( "8" );
		graph.addVertex( "9" );
		graph.addVertex( "10" );
		graph.addVertex( "11" );
		graph.addVertex( "12" );
		graph.addVertex( "13" );
		graph.addVertex( "14" );
		graph.addVertex( "15" );
        
        // add vertex 0
		graph.addEdge( "0", "1" );
		graph.addEdge( "0", "3" );
		graph.addEdge( "0", "4" );
		graph.addEdge( "0", "6" );
		graph.addEdge( "0", "7" );
		graph.addEdge( "0", "8" );
		graph.addEdge( "0", "9" );
		graph.addEdge( "0", "12" );
		graph.addEdge( "0", "14" );
        
		// add vertex 1
		graph.addEdge( "1", "4" );
		graph.addEdge( "1", "6" );
		graph.addEdge( "1", "9" );
		graph.addEdge( "1", "13" );
		graph.addEdge( "1", "14" );
        
		// add vertex 2
		graph.addEdge( "2", "4" );
		graph.addEdge( "2", "6" );
		graph.addEdge( "2", "10" );
		graph.addEdge( "2", "14" );
        
		// add vertex 3		
		graph.addEdge( "3", "11" );
        
		// add vertex 4
		graph.addEdge( "4", "7" );
		graph.addEdge( "4", "8" );
		graph.addEdge( "4", "9" );
		graph.addEdge( "4", "10" );
		graph.addEdge( "4", "12" );
		graph.addEdge( "4", "13" );
        
		// add vertex 5
		graph.addEdge( "6", "7" );
		graph.addEdge( "6", "8" );
		graph.addEdge( "6", "9" );
		graph.addEdge( "6", "10" );
		graph.addEdge( "6", "12" );
		graph.addEdge( "6", "13" );
        
		// add vertex 6
		graph.addEdge( "7", "12" );
		graph.addEdge( "7", "13" );
		graph.addEdge( "7", "14" );
        
		// add vertex 7
		graph.addEdge( "8", "12" );
		graph.addEdge( "8", "13" );
		graph.addEdge( "8", "14" );
        
		// add vertex 9
		graph.addEdge( "9", "13" );
		graph.addEdge( "9", "14" );
        
		// add vertex 9
		graph.addEdge( "10", "14" );
        
		// add vertex 12
		graph.addEdge( "12", "13" );
		graph.addEdge( "12", "14" );
        
		// add vertex 13
		graph.addEdge( "13", "14" );
        		
		
		// show graph({V},{E})
		System.out.format("Grafo: %s\n\n", graph.toString());
                
		// clique finder
		BronKerboschCliqueFinder<Object, DefaultEdge> finder = new BronKerboschCliqueFinder<Object, DefaultEdge>( graph );        
		//Iterator<Set<Object>> itr = finder.getAllMaximalCliques().iterator();
        Iterator<Set<Object>> itr = finder.getBiggestMaximalCliques().iterator();
                
        // show cliques        
        System.out.println("Cliques -> ");
        while(itr.hasNext()) {
           Object element = itr.next();           
           System.out.println(element);
        }
        
        // remove vertex 0
        graph.removeVertex("0");

        // show graph({V},{E}) no vertex 0
     	System.out.format("\nGrafo sem o nó 0 (arestas foram excluídas): %s", graph.toString());	
	}
	
	public static Object[] parserClique (Object s) {			
		return s.toString().split("\\[|\\,|\\]");
		
	}
	
}