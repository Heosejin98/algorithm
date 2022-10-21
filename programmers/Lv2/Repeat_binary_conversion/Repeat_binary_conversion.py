from numpy import integer


def solution(s):
    answer = [0, 0]
    i = 0
          
    while len(s) != 1:
        answer[0] += 1
        answer[1] += s.count('0')
        s = format(s.count('1'), 'b')
        print(s)

    return answer

print(solution("01110"))