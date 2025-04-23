import threading

def print_numbers():
    for i in range(1, 11):
        print(i)
        threading.Event().wait(1)

def print_letters():
    for letter in 'abcdefghij':
        print(letter)
        threading.Event().wait(3)

thread1 = threading.Thread(target=print_numbers)
thread2 = threading.Thread(target=print_letters)

thread1.start()
thread2.start()

thread1.join()
thread2.join()

print("Done")

