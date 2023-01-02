def s(location):
    lst = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
    
    col = lst.index(location[0])
    row = int(location[1]) - 1
    
    cnt = 0
    # 앞 - col 뒤 - row 
    MOVE = [[2, -1], [2, 1], #UP 
            [-2, -1], [-2, 1], #DOWN
            [-1, -2], [1, -2], #LEFT
            [-1, 2], [1, 2]] #RIGHT
    for i in MOVE:
        a = col + i[0]
        b = row + i[1]
        
        if (col + i[0] >= 0 and col + i[0] <= 7) and (row + i[1] >= 0 and row + i[1] <= 7):
            cnt += 1    
        a = 0
        b = 0
    
    return (cnt)
print(s("a1"))