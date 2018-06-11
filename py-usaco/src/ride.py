"""
ID: dhriti.1
LANG: PYTHON3
PROG: ride
"""


def lettertonumber(letter):
    return ord(letter) - 64


def multiplication(string):
    if len(string) == 0:
        return 1
    else:
        return lettertonumber(string[0]) * multiplication(string[1:])


def ride(comet, group):
    if multiplication(comet) % 47 == multiplication(group) % 47:
        return "GO\n"
    else:
        return "STAY\n"

if __name__ == "__main__":
    with open("ride.in", "r") as f:
        comet = f.readline().strip()
        group = f.readline().strip()
    f = open("ride.out", "w")
    f.write(ride(comet, group))