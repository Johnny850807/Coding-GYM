stores = input().split()

queuedict = dict()
for s in stores:
    queuedict.setdefault(s, list())

while True:
    line = input()
    if line is "0":
        break
    store, name, status = line.strip().split(" ")
    if status is "A":
        queuedict[store].append(name)
    elif status is "R":
        queuedict[store].remove(name)

for s in stores:
    print("store:",s,"\nqueue:"," ".join(queuedict[s]))
