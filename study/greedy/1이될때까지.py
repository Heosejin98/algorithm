N, K = map(int, input().split())

cnt = 0
while (N >= 1):
    N = N - 1
    if N % K  == 0:
        N = N / K
        cnt += 1

print(cnt)