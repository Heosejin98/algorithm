import heapq


def solution(n, k, enemy):
    sum = 0
    heap = []
    
    for i in range(0, len(enemy)):
        temp = enemy[i]
        heapq.heappush(heap, temp)
        
        if (len(heap) > k):
            sum += heapq.heappop(heap)
        
        if (sum > n):
            return i     
    
    return len(enemy) 
    


print(s(7, 3, [2, 2, 2, 2, 2, 2, 4, 5, 6]))