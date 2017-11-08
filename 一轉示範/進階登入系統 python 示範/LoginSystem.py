class AccountDuplicatedException (Exception): pass
class AccountNotFoundException  (Exception): pass

class LoginSystem:
    FILE_PATH = r'../../資源區/IO進階登入accounts.txt'
    def __init__(self):
        self.__accountsMap = {}
        self.__prepareAccounts()

    def __prepareAccounts(self):
        with open(LoginSystem.FILE_PATH, 'w+') as file:
            lines = file.readlines()
            for line in lines:
                account, password, name = line.split(" ")
                self.__accountsMap[account, password] = name

    def logIn(self, account, password):
        if account, password not in self.__accountsMap:
            raise AccountNotFoundException()
    
    def signUp(self, account, password, name):
        for act, pwd in __accountsMap:
            if act == account:
                raise AccountDuplicatedException()
        
    def __addAndWriteMember(self, account, password, name):
        with open(LoginSystem.FILE_PATH, 'w+') as file:
            self.__accountsMap[account, password] = name
            file.writeline(account + " " + password + " " + name)
            
                