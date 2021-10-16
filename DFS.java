import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

    private Stack<Node> queue;
    static ArrayList<Node> nodes = new ArrayList<Node>();

    static class Node {
        String data;
        boolean visited;
        List<Node> neighbours;

        Node(String data) {
            this.data = data;
            this.neighbours = new ArrayList<>();
            visited = false;    
        }

        public void addneighbours(Node neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    }

    public DFS() {
        queue = new Stack<Node>();
    }

    public void calcular(Node node, String target) {
        queue.push(node);
        node.visited = true;
        while (!queue.isEmpty()) {   
            System.out.print( "Pila -> "); 
            for(DFS.Node s : queue)
                System.out.print(s.data + " "); 
            System.out.println(); 
            Node element = queue.pop();
            if(element.data == target)
                break;   
            List<Node> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    queue.push(n);
                    n.visited = true;
                }
            }

        }
    }

    public static void main(String arg[]) {

        Node nodeS = new Node("S");
        Node nodeA = new Node("A");
        Node nodeD = new Node("D");
        Node nodeB = new Node("B");
        Node nodeE = new Node("E");
        Node nodeC = new Node("C");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        nodeS.addneighbours(nodeA);
        nodeS.addneighbours(nodeD);
        nodeA.addneighbours(nodeS);
        nodeA.addneighbours(nodeD);
        nodeA.addneighbours(nodeB);
        nodeD.addneighbours(nodeS);
        nodeD.addneighbours(nodeA);
        nodeD.addneighbours(nodeE);
        nodeB.addneighbours(nodeA);
        nodeB.addneighbours(nodeE);
        nodeB.addneighbours(nodeC);
        nodeE.addneighbours(nodeD);
        nodeE.addneighbours(nodeB);
        nodeE.addneighbours(nodeF);
        nodeC.addneighbours(nodeB);
        nodeF.addneighbours(nodeE);
        nodeF.addneighbours(nodeG);
        nodeG.addneighbours(nodeF);

        DFS busqueda = new DFS();
        busqueda.calcular(nodeS, "G");

    }
}