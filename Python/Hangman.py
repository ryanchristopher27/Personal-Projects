# Ryan Christopher
# Hangman



def main() :

    print("\nWELCOME TO HANGMAN!")

    word = input("\nPLAYER 1: Enter the word or phrase you would like to use:\t")
    print("\n\n\n\n\n\n\n")

    length = len(word)

    userWord = ""
    wrongLet = ""
    rightLet = ""

    i=0
    while (i < length) :
        userWord = userWord + "-"
        i = i + 1

    strikes = 0

    while (word != userWord) :

        check = False

        while (check == False) :
            letter = input("\nPLAYER 2: Guess a letter:\t")
            if (len(letter) > 1) :
                print("\nYou may only enter 1 letter at a time.")
            else :
                check = True

        bool = False
        j=0
        while (j < len(word)) :
           if (letter == word[j]) :
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
        print("\nWrong Letters: " + wrongLet)
        print("Right Letters: " + rightLet)
        print("Strikes: ", strikes)

    print("\nCongratulations! You guessed the word!")
    print("\nThe word was " + word)
    print("\nNumber of Strikes: ", strikes)


main()