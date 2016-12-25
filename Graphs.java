/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graphs {


	public static void main(String[] args){
            Graphs graph = new Graphs();
		Graph<String, Integer> graph1 = new SparseGraph<String,Integer>();
		graph1.addEdge(1, "A", "C");
                graph1.addEdge(6, "A", "F");
		graph1.addEdge(5, "B", "C");
                graph1.addEdge(10, "B" , "Z");
		graph1.addEdge(3, "B", "D");
		graph1.addEdge(4, "D", "E");
                System.out.println("Original: vertices and edges");
		System.out.println(graph1);
		
                String path = BreadthSearch(graph1);
               System.out.println("print breadth first search path");
		System.out.println(path);

		
		Layout<String, Integer> layout =  new CircleLayout<String, Integer>(graph1);
		BasicVisualizationServer<String, Integer> vv = new BasicVisualizationServer<String, Integer>(layout);
		
		vv.setPreferredSize(new Dimension(600,600)); //Sets the viewing area size
		
		
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		
				
		
		JFrame frame = new JFrame("Simple Graph View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(vv);
		frame.pack();
		frame.setVisible(true); 
		
	}
        
        //Breadth first search - checks adj of start, adds to queue if it is unvisted, then adds to visited sequence
        public static <V,E> String BreadthSearch(Graph<V, E> g){
		StringBuilder b =  new StringBuilder();
		
		Queue<V> Qu =  new LinkedList<V>();
		Set<V> visited = new HashSet();
		Set<V> found =  new HashSet();
		
		V start = (V) g.getVertices().toArray()[0];
                Qu.add(start);
		found.add(start);	
		
		while(!Qu.isEmpty()){
                        V vertex = Qu.remove();
			for(V neighbor :  g.getNeighbors(vertex)){				
				if( !found.contains(neighbor) && !visited.contains(neighbor)){
					found.add(neighbor);	
                                        Qu.add(neighbor);
				}
			}
			b.append(vertex.toString() + " ");
			visited.add(vertex);
		}
		
		return b.toString();
 	}
}
