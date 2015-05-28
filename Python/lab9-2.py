print('-------Part D-------')
print()
print('-------Part d.1-------')

def calculate_GPA(grades: list) -> float:
    gpa = 0.0
    for letters in grades:
        if letters == 'A':
            gpa += 4.0
        elif letters == 'B':
            gpa += 3.0
        elif letters == 'C':
            gpa += 2.0
        elif letters == 'D':
            gpa += 1.0
        elif letters == 'F':
            gpa += 0.0
    gpa = gpa / len(grades)
    #print("gpa is:",gpa)
    return gpa

print(calculate_GPA(['A','B','A','A']))

def calculate_GPA2(grades: list) -> float:
    gpas = {'A': 4.0, 'A-': 3.7, 'B+': 3.3, 'B': 3.0, 'B-': 2.7, 'C+': 2.3,
            'C': 2.0, 'C-': 1.7, 'D+': 1.3, 'D': 1.0, 'D-': 0.7, 'F': 0.0}
    total_gpa = 0.0
    for letters in grades:
        total_gpa += gpas[letters]
    total_gpa = total_gpa / len(grades)
    return total_gpa

print(calculate_GPA2(['A','A-','B+','A']))
assert calculate_GPA(['A', 'C', 'A', 'B', 'A', 'F', 'D']) == 2.5714285714285716
assert calculate_GPA2(['A', 'C', 'A', 'B', 'A', 'F', 'D']) == 2.5714285714285716

print()
print('-------Part d.2-------')

def flatten_2D_list(lists: list) -> list:
    newlist = []
    for sublists in lists:
        for items in sublists:
            newlist.append(items)
    return newlist

print(flatten_2D_list([[1,3,2],[4,5,6]]))
assert flatten_2D_list([[1, 3, 2], [3, 5, 1], [7, 5, 1], [3, 2], [9, 4]]) == [1, 3, 2, 3, 5, 1, 7, 5, 1, 3, 2, 9, 4]

print()
print('-------Part d.3-------')
