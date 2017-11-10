
class Student:
    def __init__(self, height, weight, grades, studentId):
        self.__id = str(studentId)
        self.__height = int(height)
        self.__weight = int(weight)
        self.__grades = int(grades)

    @property
    def id(self):
        return self.__id

    @property
    def height(self):
        return self.__height

    @property
    def weight(self):
        return self.__weight
        
    @property
    def grades(self):
        return self.__grades

    def __str__(self):
        return "Student [height={0.height}, weight={0.weight}, grades={0.grades}, id={0.id}]".format(self)
    
    def __lt__(self, other):
        return self.grades < other.grades

    def __eq__(self, other):
        return self.grades == other.grades
    