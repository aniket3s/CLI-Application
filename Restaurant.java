import java.util.ArrayList;
import java.util.Scanner;
class Restaurant 
{
		static String name;
		static long contact;
		static String address;
		static ArrayList<String>basket = new ArrayList<>();


		public static void main(String[] args) 
	{		
		Scanner sc = new Scanner(System.in);
		
		for (; ; )
		{
			System.out.println();
			System.out.println("__________Connection Resataurant_____________");
			System.out.println();
			System.out.println("1. Create Account     2. Existing User");
			System.out.println();
			System.out.print("Enter an option : ");
			int opt = sc.nextInt();
			System.out.println();
			switch(opt)
			{
				case 1 : createAccount(sc); break;
				case 2 : login(sc); break;
				default : System.out.println("INVALID INPUT "); break;
			}
		}
	}
	public static void createAccount(Scanner sc)
	{
		System.out.println("___________Registration________________");
		System.out.println();
		System.out.print("Name: ");
		name = sc.next();
		System.out.print("Phone: ");
		contact = sc.nextLong();
		System.out.print("Address : ");
		sc.nextLine();
		address = sc.nextLine();
		System.out.println();
		System.out.println("*******Account Created Successfully********");
	}
	public static void login(Scanner sc )
	{
		if (name == null)
		{
			System.out.println("XXXXXXX _Create your Account First_ XXXXXXXXXXXX");
			return;
		}
		System.out.println("       Login    ");
		System.out.println();

		for (int attempt = 3; attempt >= 1; attempt--)
		{
			System.out.print("Username : ");
			String username = sc.next();
			System.out.print("Password : ");
			Long phone = sc.nextLong();
			if (name.equals(username) && contact==phone)
			{
				homePage(sc);
			}else{
				System.out.println("Invalid ID Card");
				System.out.println("Attempt left : "+(attempt-1));
				System.out.println();
			}
		}
		System.out.println("Thank you never visit again ");
		System.exit(0);
	}
	public static void homePage(Scanner sc )
	{
		for (; ; )
		{
		System.out.println("______Home Page_____________");
		System.out.println();
		System.out.println("1. Menu");
		System.out.println("2. See Orderd Items");
		System.out.println("3. Table Booking ");
		System.out.println("4. Logout");
		System.out.println();
		System.out.println("Enter an option:");
		int opt = sc.nextInt();

		switch (opt)
		{
		case 1: menu(sc); break;
		case 2 : order(sc); break;
//		case 3 : tableBooking(); break;
		case 4 : System.out.println("Thank You Visit Again ");
		System.exit(0); break;
		default : System.out.println("Invalid Input "); break;
		}
	  }
	}
	public static void menu (Scanner sc)
	{
			for (; ; )
			{
				System.out.println();
				System.out.println("____Menu__");
				System.out.println("101. kaju Kurma    -  450/-");
				System.out.println("102. Shahi Paneer  -  345/-");
				System.out.println("103. Veg Mix       -  245/-");
				System.out.println("104. Sukhakarta Thali- 500/- ");
				System.out.println("105. Developer's Thali- 999/-");
				System.out.println("106. Exit !");
				System.out.println();
				System.out.println("Enter the food Item ID : ");
				int id = sc.nextInt();

				switch (id)
					{
					case 101: {
					basket.add("101 : kaju_kurma = 450");
					System.out.println("kaju Kurma added to basket successfully ! ");
					break;
					}
					case 102: {
					basket.add("102 : Shahi_Paneer = 345");
					System.out.println("Shahi Paneer added to basket successfully ! ");
					break;
					}
					case 103: {
					basket.add("103 : Veg_Mix = 245");
					System.out.println("Veg Mix added to basket successfully ! ");
					break;
					}
					case 104: {
					basket.add("104 : Sukhakarta_Thali = 500");
					System.out.println("Sukhakarta Thali added to basket successfully ! ");
					break;
					}
					case 105: {
					basket.add("105 : Developer's_Thali = 999");
					System.out.println("Developer's_Thali added to basket successfully ! ");
					break;
					}
					case 106: {
						return;
					}
					default : {
						System.out.println("Invalid food ID ");
						break;
					}
				}
			}	
		}


		public static void order (Scanner sc )
		{
			System.out.println();
			System.out.println("____ORDERS_____");
			System.out.println();
			if (basket.size()==0)
			{
				System.out.println("Basket is Empty Add The Food Item .");
			}
			for (String FoodItem : basket)
			{
				System.out.println(FoodItem);
			}
				System.out.println();
				System.out.println("1. Cancel Order. ");
				System.out.println("2. Remove FoodItem ");
				System.out.println("3. Proceed To Payment.");
				System.out.println();
				System.out.println("Enter the Option : ");
				int opt = sc.nextInt();
				System.out.println();

				switch (opt)
				{
					case 1:{
						System.out.println("Order Cancelled");
						basket.clear();
						break;
					}
					case 2 : {
						System.out.println("Enter foodId : ");
						int foodId = sc.nextInt();
						removefoodId(foodId);
						break;
					}
					case 3 : {
						billGenerate();
						break;
					}
				}
		}
		public static void removefoodId(int foodId)
		{
			ArrayList<String> dupBasket = new ArrayList<>(basket);
			int indx = 0;
			boolean flag = false;
			for (String foodItem : dupBasket)
			{
				String [] arr = foodItem.split(" ");
				if (arr[0].equals(foodId+""))
				{
					dupBasket.remove(indx);
					flag = true;
					System.out.println("Food item Removed ");
				}
				indx++;
			}
			if (!flag){
				System.out.println("Food Item Doesn't exist");
			}
				basket = dupBasket;
		}
			public static void tableBoooking()
			{
				System.out.println();
				System.out.println("___Table_Booking_____");
				System.out.println();
			}
			public static void billGenerate()
			{
				double totalBill = 0;
				for (String foodItem  : basket)
				{
					String [] arr = foodItem.split(" ");
					totalBill += Double.parseDouble(arr[4]);
				}
				System.out.println("Total Bill : "+ totalBill+"rs.");
			} 
}
