import Student

students = []
for i in range(int(input())):
    students.append(Student.Student(*input().split(" ")))

for student in students:
    print (str(student))