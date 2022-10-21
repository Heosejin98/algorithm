def solution(brown, yellow):
    
    temp = brown + yellow
    answer = [1, temp]
    for i in range(1, temp//2):
        if (i-2) * (temp//i-2) == yellow:
            answer[0], answer[1] =  i,  temp//i
    return answer

print(solution(24, 24))