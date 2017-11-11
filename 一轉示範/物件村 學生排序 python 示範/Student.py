
class Student:
    def __init__(self, height, weight, grades, studentId):
        self._id = str(studentId)
        self._height = int(height)
        self._weight = int(weight)
        self._grades = int(grades)

    @property
    def id(self):
        return self._id

    @property
    def height(self):
        return self._height

    @property
    def weight(self):
        return self._weight
        
    @property
    def grades(self):
        return self._grades

    def __str__(self):
        return "Student [height={0.height}, weight={0.weight}, grades={0.grades}, id={0.id}]".format(self)
    
    def __lt__(self, other):
        return self.grades < other.grades

    def __eq__(self, other):
        return self.grades == other.grades
    