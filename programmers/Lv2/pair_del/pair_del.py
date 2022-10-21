def solution(s):
    i = 0

    while len(s) > i:
        if len(s) - i != 1:
            if s[i] == s[i+1]:
                s = s.replace(s[i], "", 2)
                i = 0
            else:
                i += 1
                if len(s) == i:
                    break
    return 1 if len(s) == 0 else 0

print(solution('cdcd'))