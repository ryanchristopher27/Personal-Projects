# Ryan Christopher
# Name Roll Simulator

import random
import string

def main() :
    numOfPeople = int(input("\nHow many people?\t"))
    i = 0
    mainList = list()
    while (i < numOfPeople) :
        mainList.append(input("\nName " + str(i+1) + ":\t"))
        i+=1
    
    sel = random.randint(0, numOfPeople-1)

    print(f"\nPicked name: {mainList[sel]}")


main()
