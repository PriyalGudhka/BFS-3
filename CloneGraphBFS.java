// Time Complexity : O(V + E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Using BFS. Use hashamp with key as the node and value as the cloned node. Start by adding the node in the queue and creating the deep copy of the node. Then poll from the queue and extract the neighbors of the curr node and then check if not present in the queue add in the queue and then add neighbors to the cloned node. We need map to avoid adding duplicates.
 */
class Solution {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }

        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node cloneNode = clone(node);

        while(!q.isEmpty()){

            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;

            for(Node neighbor: neighbors){
                if(!map.containsKey(neighbor)){
                    q.add(neighbor);
                }

                Node clonedNeighbor = clone(neighbor);
                map.get(curr).neighbors.add(clonedNeighbor);

            }
        }

        return cloneNode;
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