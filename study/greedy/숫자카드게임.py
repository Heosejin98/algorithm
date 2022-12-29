N, M = map(int, input().split())

value = 0
for i in range(N):
    card = list(map(int, input().split()))
    card.sort()
    if value < card[0]:
        value = card[0] 
        
print(value)