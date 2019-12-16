import java.util.*;
import java.io.*;

class Vending
{
  public String fileName;
  public Vending(String userFileName)
  {
    fileName = userFileName;
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

  private boolean confirmPrices()
  {
    System.out.println("would you like to go into user mode(yes or no)");
    Scanner userIn = new Scanner(System.in);
    return(userIn.nextLine().equals("yes"));
  }

  private void selectItem(ArrayList<String> items, ArrayList<Double> prices)
  {
    showItems(items, prices);
    System.out.println("Which one would you like");
    Scanner userIn = new Scanner(System.in);
    String responce = userIn.nextLine();
    try
    {
      int index = items.indexOf(responce);
      System.out.println(items.get(index) + " " + prices.get(index));
    }
    catch(Exception e)
    {
      System.out.println("item " + e + "does not exist");
      selectItem(items, prices);
    }
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
        selectItem(items, prices);
      }
    }
    else
    {
      start();
    }
  }

}