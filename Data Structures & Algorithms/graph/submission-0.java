class Graph {

private Map<Integer, Set<Integer>> adjList;
    public Graph() {

        this.adjList = new HashMap<>();

    }

    public void addEdge(int src, int dst) {
            adjList.putIfAbsent(src, new HashSet<>());
             adjList.putIfAbsent(dst, new HashSet<>());
            adjList.get(src).add(dst);


    }

    public boolean removeEdge(int src, int dst) {
        if(!adjList.containsKey(src)){
          return false;
        }
       return adjList.get(src).remove(dst);
    }

    public boolean hasPath(int src, int dst) {
        if(src == dst){
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(src);
        visited.add(src);

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for ( int neighbor : adjList.get(curr)){
                if(neighbor == dst){
                    return true;
                }

                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
                
                
            }
        }
        return false;
    }
}
