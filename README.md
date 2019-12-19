# Vending-Machine
## A vending machine for computer science 

### Things to Remember
Making array List
```Java
ArrayList<String> myStringArray = new ArrayList<String()>;
// This list can only contain Strings

ArrayList<Integer> myIntArray = new ArrayList<Integer()>;
// This list can only contain Integers

ArrayList<Double> myDubArray = new ArrayList<Double()>;
// This list can only contain Doubles

// you see the pattern
```

Opening a File
```Java
File myFile = newFile("Filename.txt");
```

Putting contence of a file in array list
```Java
Scanner myScanner = newScanner(myFile);
while (myScanner.hasNextLine())
{
  myStringArray.add(myScanner.nextLine());
}
```
### Variables to Implement
ArrayList items
```
list of all the items
```
ArrayList prices
```
list of all the prices
```
double totalMoney
```
the total amount of money the user inputed
```


### Methods to Implement
Read file
```
Returns list of items
```

Set Prices
```
for each item in the list set a price
```

Show Items
```
for each item in the list print item
```

Return Change
```
print out how much money is left over
```

Insert Money
```
for each item in the items list ask the user for a price and add it to a second list
```

Select Item
```
lets the user input what item they want and subracts its price from their total money
```

### User Reviews
> I wouldn't put my money in it

> The food is bad
