// Time Complexity : O(V + E)
// Space Complexity : O(V) // Recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using DFS. Use hashamp with key as the node and value as the cloned node. Start by running the DFS on the node and base case to see if node is present in the map return. Then create the deep copy of the node and iterate over its neighbor by calling the dfs() and adding the neighbor to the cloned node.
 */
class Solution {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }

        map = new HashMap<>();

        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node){

        //base
        if(map.containsKey(node)){
            return;
        }

        //logic

        Node copyNode = clone(node);
        List<Node> neighbors = node.neighbors;

        for(Node neighbor: neighbors){
            dfs(neighbor);
            map.get(node).neighbors.add(map.get(neighbor));
        }

    }

    private Node clone(Node node){

        if(map.containsKey(node)){
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        return newNode;
    }

}