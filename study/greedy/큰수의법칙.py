# def s(arr, N, M, K):
# 	arr.sort(reverse=True)
# 	result = 0
# 	cnt = 0	

# 	while True:
# 		for j in range(0, K):
# 			result += arr[0]
# 			cnt += 1
# 		result += arr[1]
# 		cnt += 1		
# 		if (cnt == M):
# 			break 
# 	return result


#print(s([2, 4, 5, 1, 6], 5, 8 ,3))

n, m, k = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()

print(arr)

first = arr[n - 1]
second = arr[n - 2]

count = int(m / (k+1)) * k
count += m % (k + 1)

res = 0
res += (count) * first
res += (m - count) * second

print(int(res)) 
