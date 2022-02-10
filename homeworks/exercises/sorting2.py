array = [4,6,1,3,5]

print(array)

def bubbleSort(array):
    n = len(array)
    for i in range(n-1):
        for j in range(n-i-1):
            if(array[j]>array[j+1]):
                array[j],array[j+1] = array[j+1], array[j]
print("New array: ")
bubbleSort(array)
for i in range(len(array)):
    print(array[i])