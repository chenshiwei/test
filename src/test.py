import sys

def addNum(a, b):
    return a + b

if __name__ == '__main__':
    a = 3
    b = 7

    # if args input
    if len(sys.argv) == 3:
        a = int(sys.argv[1])
        b = int(sys.argv[2])

    x = addNum(a, b)
    print(x)

    with open(r"F:\MavenProject\test\src\result.txt", 'w') as f:
        f.write("the result: " + str(x))