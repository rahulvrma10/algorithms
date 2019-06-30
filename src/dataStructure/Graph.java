package dataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


// create graph 
// adding elements to graph
// traversing DFS -> iterative , recursion 
// 	traersing BFS -> iterative, recursion 
public class Graph {

	//graph nodes lookup
	HashMap<Integer,Node> graphNodes = new HashMap<Integer,Node>();

	//node of graph
	public static class Node{
		int id ; 
		LinkedList<Node> subNodes = new LinkedList<>()  ;

		Node(int id ){
			this.id = id ;
		}

		@Override
		public String toString() {
			return "Node [id=" + id + "]";
		}
	}

	//adding node
	public Graph.Node addNode(int id) {
		Node node = graphNodes.get(id) ;
		if(node==null) {
			graphNodes.put(id, new Node(id));
		}
		return graphNodes.get(id) ;
	}
	
	//adding edge
	public void addEdge(int sourceId, int  	destinationid) {
		Node sourceNode =addNode(sourceId) ;
		Node destinationNode =addNode(destinationid);
		sourceNode.subNodes.add(destinationNode);
	}

	public Node getNode(int id) {
		return graphNodes.get(id) ;
	}

	//DFS recursion
	public boolean traversreDFS(int sourceId , int destinationId){
		Node sourceNode = getNode(sourceId) ;
		Node destinationNode = getNode(destinationId) ;
		HashSet<Integer> visitedNodeIds = new HashSet<>() ;
		return hasPathDFS(sourceNode , destinationNode , visitedNodeIds) ; 
	}

	private boolean hasPathDFS(Node sourceNode, Node destinationNode, HashSet<Integer> visitedNodeIds) {
		if(visitedNodeIds.contains(sourceNode.id)) {
			return false;
		}
		visitedNodeIds.add(sourceNode.id);
		System.out.println(sourceNode.id);
		if(sourceNode.id == destinationNode.id) {
			return true ; //path is there
		}else {
			for(Node subNode : sourceNode.subNodes) {
				//System.out.println("passing subnodes of" + subNode.id + subNode.subNodes);
				if(hasPathDFS(subNode , destinationNode , visitedNodeIds)) {
					return true;
				}
			}
		}
		return false;
	}

	//DFS iterative
	private boolean hasPathDFSIterative(int sourceId , int destinationId) {
		HashSet<Integer> visitedNodeIds = new HashSet<>() ;
		Stack<Node> stack = new Stack<Node>();
		stack.push(getNode(sourceId));

		while(!stack.isEmpty()) {
			Node node = stack.pop() ;
			if(visitedNodeIds.contains(node.id)) {
				continue;
			}
			visitedNodeIds.add(node.id);
			System.out.println(node.id);
			if(node.id == destinationId) {
				return true ;
			}
			for(Node n : node.subNodes) {
				stack.push(n);
			}
		}
		return false;
	}

	//BFS iterative
	private boolean hasPathBFSIterative(int sourceId , int destinationId) {
		LinkedList<Node> queue = new LinkedList<Node>() ;
		HashSet<Integer> visitedNodeIds = new HashSet<>() ;
		queue.add(getNode(sourceId)) ; 
		while(!queue.isEmpty()) {
			Node node = queue.pollFirst() ; 
			if(visitedNodeIds.contains(node.id)) {
				continue;
			}
			visitedNodeIds.add(node.id) ; // visiting the node
			System.out.println(node.id);
			for(Node n : node.subNodes) { //exploring nodes by  putting in que
				queue.add(n);
			}
		}
		return false ;
	}
	

	//BFS recursive
	private boolean traverseBFS(int sourceId , int destinationId) {
		LinkedList<Node> queue = new LinkedList<Node>() ;
		HashSet<Integer> visitedNodeIds = new HashSet<>() ;
		queue.add(getNode(sourceId)) ; 
		return hasPathBFS(queue,visitedNodeIds,destinationId);
		
	}
	
	private boolean hasPathBFS(LinkedList<Node> queue, HashSet<Integer> visitedNodeIds, int destinationId) {

		if(queue.isEmpty()) {
			return false;
		}
		Node node = queue.pop();
//		if(visitedNodeIds.contains(node.id)) {
//			return false;
//		}
		visitedNodeIds.add(node.id);
		System.out.println(node.id);
		if(node.id == destinationId) {
			return true;
		}
		for(Node n : node.subNodes) {
			if(!visitedNodeIds.contains(n.id) && !queue.contains(n))
			queue.add(n);
		}
		if(hasPathBFS(queue, visitedNodeIds, destinationId)) {
			return true ;
		}
		return false ;
	}

	public static void main(String[] args) {

		Graph g = new Graph() ;
		   g.addEdge(0, 1); 
		    g.addEdge(0, 2); 
		    g.addEdge(1, 2); 
		    g.addEdge(2, 0); 
		    g.addEdge(2, 3); 


//		System.out.println(g.traversreDFS(0, 3));;
//
//		System.out.println(g.hasPathDFSIterative(0, 3));;
//
//		
//		System.out.println(g.hasPathBFSIterative(0, 3));;
		System.out.println(g.traverseBFS(0, 3));


	}




}
