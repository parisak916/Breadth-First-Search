/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author Parisa Khan
 */
public class Edge {
    double weight;
	String id;
	
	
	public Edge(String id, double weight){
		this.weight = weight;
		this.id = id;
	}
	
	public String toString(){
		return "E:" +id;
	}
    
}
