import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Vending
{
  public Vending(String fileName)
  {
    File itemsFile = new File(fileName);
    try
    {
      Scanner items = new Scanner(itemsFile);
    }
    
    catch(FileNotFoundException e)
    {
      System.out.println("File not found");
    }
    
  }

  public void start()
  {
    while(1 < 2)
    {

      while(items.hasNextLine())
      {
        System.out.println(items.nextLine());
      }

      System.out.println("What item would you like");

      Scanner input = new Scanner(System.in);
      String userIn = input.nextLine();

      if (userIn.equals("admin"))
      {
        setPrice();
      }
      else
      {
        selectItem();
      }
    }
    
    
  }

  private void setPrice()
  {
    System.out.println("prices set");
  }

  private void selectItem()
  {
    System.out.println("ok");
  }

}