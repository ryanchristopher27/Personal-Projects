# Ryan Christopher
# Hangman()



def main() :

    print("\nWELCOME TO HANGMAN!\n")

    word = input("\nPLAYER 1: Enter the word or phrase you would like to use:\t")

    length = len(word)

    userWord = ""

    i=0
    while (i < length) :
        userWord = userWord + "-"
        i = i + 1

    wrongLet = ""
    rightLet = ""
    strikes = 0

    while (word != userWord) :
        # letterGuess(word, userWord, wrongLet, rightLet, strikes)
        # printHangman(userWord, wrongLet, rightLet, strikes)

        letter = input("\nPLAYER 2: Guess a letter:\t")
        bool = False
        j=0
        while (j < len(word)) :
           if (letter == word[j]) :
                # print(userWord[i])
                userList = list(userWord)
                userList[j] = letter
                userWord = "".join(userList)
                bool = True
           j += 1
        if (bool == True) : 
            rightLet = rightLet + " " + letter
        else :
            wrongLet = wrongLet + " " + letter
            strikes = strikes + 1

        print("\nYour Guess: " + userWord)
        print("\nYour Wrong Letters: " + wrongLet)
        print("\nYour Right Letters: " + rightLet)
        print("\nYour Strikes: ")
        print(strikes)


    print("\nCongratulations! You guessed the word!")
    print("\nThe word was " + word)
    print("\nNumber of Strikes: ")
    print(strikes)
        

# def letterGuess(word, userWord, wrongLet, rightLet, strikes) :

#     letter = input("\nGuess a letter:\t")

#     bool = False
#     i=0

#     # for letter in word :
#     while (i < len(word)) :
#        if (letter == word[i]) :
#             # print(userWord[i])

#             userList = list(userWord)
#             userList[i] = letter
#             userWord = "".join(userList)

#             bool = True
#        i += 1

#     if (bool == True) : 
#         rightLet = rightLet + " " + letter
#     else :
#         wrongLet = wrongLet + " " + letter
#         strikes = strikes + 1

#     # print(letter)

#     # print("Wrong Letters:" + wrongLet)
#     # print("Right Letters:" + rightLet)
#     # print(userWord)

# def printHangman(userWord, wrongLet, rightLet, strikes) :

#     print("\nYour Guess: " + userWord)
#     print("\nYour Wrong Letters: " + wrongLet)
#     print("\nYour Right Letters: " + rightLet)
#     print("\nYour Strikes: ")
#     print(strikes)


main()