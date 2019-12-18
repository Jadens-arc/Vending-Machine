import java.util.*;
import java.io.*;

class Vending
{
  private String fileName;
  private double userMoney;
  private double userSpending;
  private ArrayList<Integer> accepedCash = new ArrayList<Integer>();

  public Vending(String userFileName)
  {
    
    fileName = userFileName;
    userMoney = 0.0;
    userSpending = 0.0;
    accepedCash.add(1);
    accepedCash.add(5);
    accepedCash.add(10);
    accepedCash.add(20);
  }

  private ArrayList<String> readFile()
  {
    ArrayList<String> items = new ArrayList<String>();
    try
    {
      File myFile = new File(fileName);
      Scanner inFile = new Scanner(myFile);
      while(inFile.hasNext())
      {
        items.add(inFile.nextLine());

      }
      inFile.close();
    }
    catch(Exception e)
    {
      System.out.println("File does not exist");
    }
  return items;

  }

  private ArrayList<Double> setPrices(ArrayList<String> items)
  {
    System.out.println("please enter the price for each item");
    ArrayList<Double> prices = new ArrayList<Double>();
    for(String item: items)
    {
      System.out.println(item + ":");
      Scanner userIn = new Scanner(System.in);
      prices.add(Double.valueOf(userIn.nextLine()));
      
    }
    return prices;
  }

  private  void showItems(ArrayList<String> items, ArrayList<Double> prices)
  {
    for (String item: items )
    {
      int index = items.indexOf(item);
      System.out.println(items.get(index) + " " + prices.get(index));
    }
  }

  private  void showItems(ArrayList<String> items, ArrayList<Double> prices, double max)
  {
    for (String item: items )
    {
      int index = items.indexOf(item);
      if (prices.get(index) <= max)
      {
        System.out.println(items.get(index) + " " + prices.get(index));
      }
    }
  }

  private boolean confirmPrices()
  {
    System.out.println("would you like to go into user mode(yes or no)");
    Scanner userIn = new Scanner(System.in);
    return(userIn.nextLine().equals("yes"));
  }

  private void selectItem(ArrayList<String> items, ArrayList<Double> prices, double max)
  {
    showItems(items, prices, max);
    System.out.println("Which one would you like");
    Scanner userIn = new Scanner(System.in);
    String responce = userIn.nextLine();
    try
    {
      int index = items.indexOf(responce);
      userMoney -= prices.get(index);
      System.out.println("you have $" + userMoney + " left");
      System.out.println("would you like to purchase more items");
      Scanner userIn = new Scanner(System.in);
      String userChoice = userIn.nextLine();
      if ()
    }
    catch(Exception e)
    {
      System.out.println("item " + e + "does not exist");
      selectItem(items, prices, max);
    }
  }

  public double insertMoney()
  {
    System.out.println("please insert one of the following monetary denominations and say \"done\" when you are finished ");
    System.out.println(accepedCash);

    Scanner moneyScanner = new Scanner(System.in);
    String money = moneyScanner.next();
    try
    {
      userMoney += Double.valueOf(money);
    }
    catch(Exception e)
    {
      if (money.equals("done"))
      {
        
      }
      insertMoney();
    }

    while (!(money.equals("done")))
    {
      moneyScanner = new Scanner(System.in);
      money = moneyScanner.next();
      try
      {
        userMoney += Double.valueOf(money);
        System.out.println("Total: " + userMoney);
      }
      catch(Exception e)
      {
        if (money.equals("done"))
        {
          break;
        }
        insertMoney();
      }
    } 
    return userMoney;
    //Scanner 
  } 


  public void start()
  {
    ArrayList<String> items = readFile();
    ArrayList<Double> prices = setPrices(items);
    showItems(items, prices);
    if (confirmPrices())
    {
      while(true != false)
      {
        userMoney = 0;
        selectItem(items, prices, insertMoney());
      }
    }
    else
    {
      start();
    }
  }

}