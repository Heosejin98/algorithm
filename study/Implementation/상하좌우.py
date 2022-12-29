#N = input()
#A = map(int, input().split())
import copy

N = 5
A = ["R", "R", "R", "U", "D", "D"]

cur = [1, 1]

for i in A:
	temp = copy.deepcopy(cur)
	if (i == "R"):
		cur[1] += 1
	elif (i == "L"):
		cur[1] -= 1
	elif(i == "D"):
		cur[0] += 1
	elif(i == "U"):
		cur[0] -= 1     
	if (cur[0] < 1 or cur[1] < 1):
		cur = temp
	elif (cur[0] > 5 or cur[1] > 5):
		cur = temp

print(cur)
