print('-------Part D-------')
print()
print('-------Part d.1a-------')

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

print()
print('-------Part d.1b-------')

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
print('-------Part d.3a-------')

def skip_every_third_item(items: list):
    n_count = 1
    for things in items:
        if n_count % 3 != 0:
            print(things)
        n_count += 1

L = ['If', 'you', '432234', 'did', 'the', '9834234', 'exercise', 'correctly', '534523423', 
		 'this', 'should', '1044323', 'be', 'readable']
skip_every_third_item(L)

print()
print('-------Part d.3b-------')
def skip_every_nth_item(items: list, n: int):
    n_count = 1
    for things in items:
        if n_count % n != 0:
            print(things)
        n_count += 1

skip_every_nth_item(L, 3)

print()
print('-------Part d.4a-------')

def tally_days_worked(payroll: list) -> dict:
    tally = {}
    for items in payroll:
        if items in tally:
            tally[items] += 1
        else:
            tally[items] = 1
    return tally

work_week = ['Bob', 'Jane', 'Kyle', 'Larry', 'Brenda', 'Samantha', 'Bob', 
             'Kyle', 'Larry', 'Jane', 'Samantha', 'Jane', 'Jane', 'Kyle', 
             'Larry', 'Brenda', 'Samantha']
workers = tally_days_worked(work_week)
print(workers)

print()
print('-------Part d.4b-------')   

def pay_employees(hours: list, wages: list):
    daily = 8
    for person, days in hours.items():
        pay = days*daily*wages[person]
        print("%s will be paid $%.2f for %d hours of work at $%.2f per hour." % (person, pay, days*daily, wages[person]))

hourly_wages = {'Kyle': 13.50, 'Brenda': 8.50, 'Jane': 15.50, 'Bob': 30.00,
                'Samantha': 8.50, 'Larry': 8.50, 'Huey': 18.00}
pay_employees(workers, hourly_wages)

print()
print('-------Part d.5-------') 

def reverse_dict(mydict: dict) -> dict:
    newdict = {}
    for k,v in mydict.items():
        newdict[v] = k
    return newdict

print(reverse_dict({'a': 'one', 'b': 'two', 'c': 'three', 'd': 'four', 'e': 'five', 'f': 'six'}))


