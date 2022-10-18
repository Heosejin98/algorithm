


def solution(n):
    answer = n + 1
    s_num = format(n, 'b')
    one_chk = s_num.count('1')

    while format(answer, 'b').count('1') != one_chk :
        answer += 1 

    return answer


print(solution(15))