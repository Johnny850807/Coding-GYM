import collections

STORE, GUEST, ACTION = (0, 1, 2)

stores = input().split(" ")
storesMap = collections.defaultdict(list)
actionMap = { 'A' : lambda store, guest: storesMap[store].append(guest), 'R' : lambda store, guest: storesMap[store].remove(guest) }

def showAll():
    for store in storesMap:
        print("商店名稱: " + store)
        print("隊伍: " + " ".join(storesMap[store]))

def main():
    while(True):
        cmds = input().split(" ") 
        if len(cmds) == 1:
            break
        store = cmds[STORE]
        guest = cmds[GUEST]
        action = cmds[ACTION].upper()
        actionMap[action](store, guest) 
    
    print (storesMap)

main()
showAll()