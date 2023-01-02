from collections import deque

def bfs(graph, visited):
	que = deque([])
	for i in graph:
		for j in i:
			if (visited[j] == False):
				t = que.append(j)
		while (len(que) > 0):
			temp = que.popleft()
			print(temp, end=" ")
			visited[temp] = True
	 
		
			
graph = [
	[1],
	[2, 3, 8],
	[1, 7],
	[1, 4, 5],
 	[3, 5],
  	[3, 4],
   	[7],
	[2, 6, 8],
	[1, 7]
]

visited = [False] * 9
bfs(graph, visited)