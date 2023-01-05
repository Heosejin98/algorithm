def solution(s):
	res = 0
	
	arr = list(map(int, str(s)))
	i = len(arr) - 1

	if (len(arr) > 1):
		if (arr[0] >= 5 and arr[1] >= 5):
			temp = 10 ** len(arr)
			temp = temp - s
			arr = list(map(int, str(temp)))
			arr.insert(0, 1)
			arr.insert(1, 0)
	i = len(arr) - 1
	while (i >= 0):
		if (arr[i] <= 5): # 4이하면 내림 
			res += arr[i]
		elif (arr[i] >= 6): # 6이상이면 올림
			res += 10 - arr[i]
			if (i != 0):
				arr[i - 1] += 1
			else:
				arr.insert(0, 1)
				i += 1
		i -= 1
	return (res)