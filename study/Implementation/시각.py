def s(N):
    cnt = 0
    str_list = []
    for i in range(0, N + 1):
        for j in range(60):
            for k in range(60):
                if "3" in str(i) + str(j) + str(k):
                    cnt += 1
    return (cnt)
print(s(5))