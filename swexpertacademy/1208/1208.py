import sys
sys.stdin = open("input.txt", "r")

T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    count = int(input())
    number = list(map(int, input().split()))
    N = len(number)

    while count > 0:
        number.sort()
        count -= 1
        number[N-1] -= 1
        number[0] += 1

    number.sort()
    print(f'#{test_case} {number[N-1] -  number[0]}')


