lookup_table = {'A' : 'Z', 'B' : 'Y', 'C' : 'X', 'D' : 'W', 'E' : 'V',
        'F' : 'U', 'G' : 'T', 'H' : 'S', 'I' : 'R', 'J' : 'Q',
        'K' : 'P', 'L' : 'O', 'M' : 'N', 'N' : 'M', 'O' : 'L',
        'P' : 'K', 'Q' : 'J', 'R' : 'I', 'S' : 'H', 'T' : 'G',
        'U' : 'F', 'V' : 'E', 'W' : 'D', 'X' : 'C', 'Y' : 'B', 'Z' : 'A'}

def atbash(msg):
    cipher = ""
    for ltr in msg:
        if (ltr != " "):
            cipher += lookup_table[ltr]
        else:
            cipher += " "
    return cipher
    
def main():
    message = 'In the afterlife you could be headed for the serious strife'
    print(atbash(message.upper()))
      
    #decrypt the given message
    message = 'RM GSV ZUGVIORUV BLF XLFOW YV SVZWVW ULI GSV HVIRLFH HGIRUV'
    print(atbash(message.upper()))
    
if __name__ == '__main__':
    main()
