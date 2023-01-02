def s(N, M, lst1):
	res = 0

	location = lst1.pop(0)
	direction = location.pop()
 
	# 앞 col 뒷 row
	# 위, 왼쪽, 아래, 오른쪽
	direction_map = [[0, -1], [1, 0], [0, 1], [1, 0]]
	game_map = []	
	for i in lst1:
		game_map.append(i)
	
	f = True
	while f:
		f_cnt = 0
		for i in direction_map:
			tm = game_map[location[0]][location[1]]
			if (game_map[location[0]][location[1]] == 0):
				game_map[location[0]][location[1]] = 1
				res += 1
			col = location[0] + i[0]
			row = location[1] + i[1]
			tt = game_map[location[0] + i[0]][location[1] + i[1]]
			if (game_map[location[0] + i[0]][location[1] + i[1]] == 0):
				location[0] += i[0]
				location[1] += i[1]
				break
			else:
				f_cnt += 1
		if (f_cnt == 4):
			break
	return (res)
    
lst = [[1, 1, 0], [1,1,1,1], [1, 0, 0, 1], [1, 0, 0, 1], [1, 0, 0, 1], [1,1,1,1]]
print(s(4, 4, lst))