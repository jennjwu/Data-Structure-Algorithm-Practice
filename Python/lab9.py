print('-------Part C-------')
print()
print('-------Part c.1-------')

# Part c.1
import random
from random import randrange

NUMBER_OF_STUDENTS = 20
NUMBER_OF_QUESTIONS = 20
NUMBER_OF_CHOICES = 4  # 3 choices is A/B/C, 4 choices is A/B/C/D, 5 is A/B/C/D/E
QUESTION_WEIGHTS = []

def answer_choices(n: int) -> str:
    ''' Takes a number n and returns a string containing the first n letters of
        the alphabet.
    '''
    ALPHABET = 'abcdefghijklmnopqrstuvwxyz'
    return ALPHABET[0:n]

def generate_answers(questions: int, n: int) -> str:
    ''' Generates and returns a string of letters representing the correct answers
        to the test.
    '''
    result = ''
    for x in range(questions):
        randomAnswer = random.choice(answer_choices(n))
        result += randomAnswer
    return result

ANSWERS = generate_answers(NUMBER_OF_QUESTIONS, NUMBER_OF_CHOICES)
print("Answers:")
print(ANSWERS)
print()

print('-------Part c.2-------')

# Part c.2
from collections import namedtuple
Student = namedtuple('Student', 'id answers scores total')

# Part c.3
def grade_test(student: namedtuple) -> list:
    ''' Take in a list of answers and compares them to the right answers and return a list of integers
        indicating right or wrong answers, 1 for a right answer and 0 for a wrong answer.
    '''
    #print(student)
    grade = 0
    gradedAnswers = []
    for n in range(len(student.answers)):
        if student.answers[n] == ANSWERS[n]:
            gradedAnswers.append(1)
        else:
            gradedAnswers.append(0)
    for num in gradedAnswers:
        if num == 1:
            grade += 1
    return Student(student.id, student.answers, gradedAnswers, grade)

# Modified c.2 for Part c.3
from operator import attrgetter
def random_students(n: int) -> list:
    ''' Generates and returns a list of Student namedtuples with graded scores and total grade.
    '''
    Students = []
    for x in range(n):
        #create temporary Student w/o graded answers and total score
        tempStudent = Student(randrange(999999), generate_answers(NUMBER_OF_QUESTIONS, NUMBER_OF_CHOICES), [], [])

        #grades student's answers
        tempStudent = grade_test(tempStudent)
        Students.append(tempStudent)

    #sort by total attribute in Student named tuple in descending order
    Students = sorted(Students, key=attrgetter('total'), reverse=True)
    
    return Students

student_body = random_students(NUMBER_OF_STUDENTS)

print(student_body)
print()

print('-------Part c.3-------')

def print_top_ten_and_mean(all_students: list) -> int:
    '''Takes in the sorted list of students and prints out the top ten student's IDs based on total and calculates
       and prints the mean total for all students. Returns the calculated mean of total.
    '''
    #get top ten
    print("Top Ten Students:")
    for x in range(10):
        print(all_students[x].id)

    #get mean
    total_score = 0
    for student in all_students:
        total_score += student.total
    avg = total_score / NUMBER_OF_STUDENTS
    return avg

#print("All Students (Graded):")
#print(student_body)

print("Mean Score (All Students):", print_top_ten_and_mean(student_body))


print()
print('-------Part c.4-------')
# Part c.4
def generate_weighted_student_answer(corr_ans: str) -> str:
    '''Generates a weighted student answer choice by adding random number of copies of the correct answer
    to the answer choices
    '''
    ans_choice = answer_choices(NUMBER_OF_CHOICES)
    num_copies = random.randint(0, 2*NUMBER_OF_CHOICES)
    for i in range(num_copies):
        ans_choice += corr_ans
    return random.choice(ans_choice)


def random_students2(n: int) -> list:
    ''' Generates and returns a sorted list of Student namedtuples that chose answer choices using the
        weighted approach.
    '''
    Students = []
    for x in range(n):
        #create temporary Student w/o graded answers and total score
        studentans = ''
        for ans in range(NUMBER_OF_QUESTIONS):
            studentans += generate_weighted_student_answer(ANSWERS[ans])
        
        tempStudent = Student(randrange(999999), studentans, [], [])

        #grades student's answers
        tempStudent = grade_test(tempStudent)
        Students.append(tempStudent)

    #sort by total attribute in Student named tuple in descending order
    Students = sorted(Students, key=attrgetter('total'), reverse=True)
    
    return Students

student_body2 = random_students2(NUMBER_OF_STUDENTS)
#print(student_body2)

print("Mean Score (All Students):", print_top_ten_and_mean(student_body2))


#Part c.5
print()
print('-------Part c.5-------')

def question_weights(all_students: list) -> list:
    '''Calculates the number of wrong selections for each question for use as the question's weighted point value.
       Returns a list of weights for all questions
    '''
    wts = []
    for ques in range(NUMBER_OF_QUESTIONS):
        num_wrong = 0
        for student in all_students:
            if student.scores[ques] == 0:
                num_wrong = num_wrong + 1
        wts.append(num_wrong)
    return wts

QUESTION_WEIGHTS = question_weights(student_body2)
        
print("Question Weights:",QUESTION_WEIGHTS)

def max_score(ques_wt: list) -> int:
    '''Calculates the maximum score possible given each question's weights and returns this value.
    '''
    max = 0
    for ques in ques_wt:
        max += ques_wt[ques]
    return max

print("Max Score:", max_score(QUESTION_WEIGHTS))
print()

def Student_weighted_score(student: Student, ques_wt: list) -> Student:
    '''Calculates the new score for a student given a list of question weights. Returns a new Student namedtuple.
    '''
    total_score = 0
    for ques in range(NUMBER_OF_QUESTIONS):
        points = student.scores[ques]*ques_wt[ques]
        #print("ans is:",student.scores[ques],"wt is:",ques_wt[ques],"points is:",points)
        total_score += points
    return Student(student.id, student.answers, student.scores, total_score)

def give_weighted_score(all_students: list) -> list:
    '''Generates an updated list of Student namedtuples using the weighted scores
    '''
    students_with_weights = []
    for student in all_students:
        students_with_weights.append(Student_weighted_score(student,QUESTION_WEIGHTS))

    #re-sort on new weighted score
    students_with_weights = sorted(students_with_weights, key=attrgetter('total'), reverse=True)
        
    return students_with_weights

student_body3 = give_weighted_score(student_body2)
#print( student_body3 )
print("Mean Score (All Students):", print_top_ten_and_mean(student_body3))

