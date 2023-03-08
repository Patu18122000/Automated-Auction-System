package com.Main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.DAO.AdministratorDao;
import com.DAO.AdministratorDaoImpl;
import com.DAO.BuyerDao;
import com.DAO.BuyerrDaoImpl;
import com.DAO.SellerDao;
import com.DAO.SellerDaoImpl;
import com.UseCases.AddItemsToSeller;
import com.UseCases.AdminLoginbyUser;
import com.UseCases.BuyItemsUC;
import com.UseCases.BuyerRegistration;
import com.UseCases.LoginBuyer;
import com.UseCases.LoginSeller;
import com.UseCases.RemoveItembySId;
import com.UseCases.SellerRegistration;
import com.UseCases.ShowBuyItemsByID;
import com.UseCases.ShowItemsToSeller;
import com.UseCases.UpdateItemsById;
import com.custome.ConsoleColour;
import com.model.BuyItem;
import com.model.Buyer;
import com.model.Items;
import com.model.Seller;

public class Main {

	public static void main(String[] args){
		System.out.println(ConsoleColour.GREEN_BACKGROUND+"   Welcome To - AUTOMATED AUCTION SYSTEM   "+ConsoleColour.RESET);
		System.out.println("===========================================");
		System.out.println(ConsoleColour.GREEN +"+---------------------------+" +"\n"
												+ "| 1.Login as administrator |" +"\n"
												+ "| 2.Regester as Buyer      |" +"\n"
												+ "| 3.Login as Buyer         |" +"\n"
												+ "| 4.Register as Seller 	   |" +"\n"
												+ "| 5.Login as Seller        |" +"\n"
												+"+---------------------------+" + ConsoleColour.RESET);
		
		AdministratorDao adminDao= new AdministratorDaoImpl();
		BuyerDao BuyerDao = new BuyerrDaoImpl();
		SellerDao selleDao = new SellerDaoImpl();
		
		
		try {
			Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter Choice : ");
			int choice= sc.nextInt();
			
			switch(choice) {
			
	//-------------------------- Login Admin-------------------------- //
			
			case 1: 
					String msg= AdminLoginbyUser.main(args);
					
					System.out.println(ConsoleColour.YELLOW+msg+ConsoleColour.RESET);
					if(msg.equalsIgnoreCase("Login Succesfull")) {
						
						while(true) {
							System.out.println(ConsoleColour.GREEN +"+---------------------------+" +"\n"
																	+ "| 1.View Buyer List  	    |" +"\n"
																	+ "| 2.View Seller List        |" +"\n"
																	+ "| 3.View Daily Selling      |" +"\n"
																	+ "| 4.Exit   		    |" +"\n"
																	+"+---------------------------+" + ConsoleColour.RESET);
							
							System.out.println("Enter Choice :");
							
							int ch1= sc.nextInt();
							
							switch(ch1) {
								
							case 1:
								try {
									
									List<Buyer> buyerlist= adminDao.viewBuyerList();
									
									buyerlist.forEach(s ->{
										System.out.println("Buyer id : "+s.getBid());
										System.out.println("Buyer Name : "+s.getBname());
										System.out.println("Buyer email : "+s.getBemail());
										System.out.println("Buyer password : "+s.getBpassWord());
										
										System.out.println("--------------------------------------------------");
									});
									
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								
								break;
								
							case 2:
								try {
									
									List<Seller> sellerlist= adminDao.viewSellerList();
									
									sellerlist.forEach(s ->{
										System.out.println("Seller id : "+s.getSid());
										System.out.println("Seller Name : "+s.getsName());
										System.out.println("Seller email : "+s.getsEmail());
										System.out.println("Seller password : "+s.getsPassword());
										
										System.out.println("--------------------------------------------------");
									});
									
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								
								break;
								
							case 3:
								try {
									
									List<BuyItem> dailyListt= adminDao.viewDailySelling();
									
									dailyListt.forEach(s -> {
										System.out.println("Item name : "+s.getBiName());
										System.out.println("Item Price  : "+s.getBiPrice());
										System.out.println("Item Quantity : "+s.getBiQuantity());
										System.out.println("Buyer Name : "+s.getBibName());
										System.out.println("Purchased Date : "+s.getDate());
										System.out.println("Seller Id : "+s.getIid());
										System.out.println("Buyer Id : "+s.getBid());
										
										System.out.println("--------------------------------------------------");
									});
									
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								
								break;
								
							case 4: 
								System.out.println("Thank You ...");
								System.out.println("=====================================================");
								Main.main(args);
								
							} // switch
							
						} //while
						
					}else {
						Main.main(args);
					} // if
				
	//-------------------------- Registration Buyer-------------------------- //
					
			case 2: String msg2= BuyerRegistration.main(args); 
			
					System.out.println(ConsoleColour.YELLOW+msg2+ConsoleColour.RESET);
					
					System.out.println("===================================================");
					Main.main(args);
					break;
				
	//-------------------------- Login Buyer-------------------------- //
			
			case 3: String msg3= LoginBuyer.main(args);		
					System.out.println(ConsoleColour.YELLOW+msg3+ConsoleColour.RESET);
					
					if(msg3.equalsIgnoreCase("Login Successfull ...")) {
						
						while(true) {
							
							System.out.println(ConsoleColour.GREEN +"+---------------------------+" +"\n"
																	+ "| 1.View All Items List     |" +"\n"
																	+ "| 2.Buy Items From List     |" +"\n"
																	+ "| 3.View All Buy Items      |" +"\n"
																	+ "| 4.Exit   	     		   |" +"\n"
																	+"+---------------------------+" + ConsoleColour.RESET);

							System.out.println("Enter Choice :");
							
							int ch2= sc.nextInt();
							
							switch(ch2) {
							
							case 1:
								try {
									
									List<Items> itemlist= BuyerDao.ShowItemstoBuyer();
									
									System.out.println("-------------------------------------------------------------------");
									itemlist.forEach(s->System.out.println(s));
									System.out.println("-------------------------------------------------------------------");
									
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								
								break;
								
							case 2:
								String msg4= BuyItemsUC.main(args);
								
								System.out.println(ConsoleColour.YELLOW+msg4+ConsoleColour.RESET);
								System.out.println("===================================================");
								break;
								
							case 3:
								
								try {
									
									List<BuyItem> itemlist= ShowBuyItemsByID.main(args);
									
									itemlist.forEach(s ->{
										System.out.println("Item name : "+s.getBiName());
										System.out.println("Item Price  : "+s.getBiPrice());
										System.out.println("Item Quantity : "+s.getBiQuantity());
										System.out.println("Buyer Name : "+s.getBibName());
										System.out.println("Purchased Date : "+s.getDate());
										System.out.println("Seller Id : "+s.getIid());
										System.out.println("Buyer Id : "+s.getBid());
										
										System.out.println("--------------------------------------------------");
									});
									
								} catch (Exception e) {
									System.out.println(e.getMessage());
								}
								
								break;
								
							case 4:
								System.out.println("Thank You ...");
								System.out.println("=====================================================");
								Main.main(args);
							
							} // switch
							
						}// while
						
					}else{
						Main.main(args);
					}// if
					
		//-------------------------- Registration Seller-------------------------- //
					
			case 4:
				String msg5= SellerRegistration.main(args); 
				
				System.out.println(ConsoleColour.YELLOW+msg5+ConsoleColour.RESET);
				
				System.out.println("===================================================");
				Main.main(args);
				break;
				
			case 5:
				String msg6= LoginSeller.main(args);		
				System.out.println(ConsoleColour.YELLOW+msg6+ConsoleColour.RESET);
				
				if(msg6.equalsIgnoreCase("Login Successfull ...")) {
					
					while(true) {
						
						System.out.println(ConsoleColour.GREEN +"+-------------------------------+" +"\n"
																+ "| 1.Sell More Items    	      |" +"\n"
																+ "| 2.Show All Items List    	  |" +"\n"
																+ "| 3.Update price and Quantity  |" +"\n"
																+ "| 4.Remove Items 	          |" +"\n"
																+ "| 5.Exit   	     		      |" +"\n"
																+"+-------------------------------+" + ConsoleColour.RESET);

						System.out.println("Enter Choice :");
						
						int ch3= sc.nextInt();
						
						switch(ch3) {
						
						case 1:
							String msg7= AddItemsToSeller.main(args);
							
							System.out.println(ConsoleColour.YELLOW+msg7+ConsoleColour.RESET);
							System.out.println("===================================================");
							break;
						
						case 2:
							try {
								
								List<Items> itemlist= ShowItemsToSeller.main(args);
								System.out.println("-------------------------------------------------------------------");
								itemlist.forEach(s->System.out.println(s));
								System.out.println("-------------------------------------------------------------------");
								
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
							
							break;
							
						case 3:
							String msg8 = UpdateItemsById.main(args);
							
							System.out.println(ConsoleColour.YELLOW+msg8+ConsoleColour.RESET);
							System.out.println("===================================================");
							break;
							
						case 4:
							String msg9 = RemoveItembySId.main(args);
							
							System.out.println(ConsoleColour.YELLOW+msg9+ConsoleColour.RESET);
							System.out.println("===================================================");
							break;
							
						case 5:
							System.out.println("Thank You ...");
							System.out.println("=====================================================");
							Main.main(args);
						
							
						}// whitch
						
					}// while
					
				}else{
					Main.main(args);
				}//if 
					
			}
			
			
		} catch (InputMismatchException e) {
			System.out.println(ConsoleColour.RED_BACKGROUND+"Incorrect Input ! It should be Number "+ConsoleColour.RESET);
			 Main.main(args);
			
		}
	}
	
	
}
