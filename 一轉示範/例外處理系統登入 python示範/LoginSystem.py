class AccountNotFoundException (Exception): pass
class PasswordNotFoundException (Exception): pass
class PairInfoNotFoundException  (Exception): pass

class LoginSystem:
    ACCOUNT = '000'
    PASSWORD = '567'

    def logIn(self, account, password):
        if account != LoginSystem.ACCOUNT and password != LoginSystem.PASSWORD:
            raise PairInfoNotFoundException()
        if account != LoginSystem.ACCOUNT:
            raise AccountNotFoundException()
        if password != LoginSystem.PASSWORD:
            raise PasswordNotFoundException()
        
       