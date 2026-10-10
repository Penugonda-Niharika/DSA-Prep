class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int p[] : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        int[] indegree = new int[numCourses];

        // Calculate indegree of each node
        for(int i=0; i<numCourses; i++) {
            for(int v : adj.get(i)) {
                indegree[v]++;
            }
        }


        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with indegree 0 to the queue
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }


        List<Integer> ans = new ArrayList<>();

        // Implement BFS-based topological sort here
        while(!q.isEmpty()) {
            int n = q.poll();
            ans.add(n);
            List<Integer> a = adj.get(n);
            for(int v : a) {
                indegree[v]--;
                if(indegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        if (ans.size() == numCourses) {
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[0];
    }
}