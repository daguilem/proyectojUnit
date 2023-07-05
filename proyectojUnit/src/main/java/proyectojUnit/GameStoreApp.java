package proyectojUnit;

import java.util.Scanner;

public class GameStoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameStore gameStore = new GameStore();
        boolean isAdmin = false;

        // Seteo inicial de la tienda
        gameStore.addGame(new VideoGame("CrossCode", "RPG", "PC", 10, 9000));
        gameStore.addGame(new VideoGame("Hotline Miami", "shoot'em up", "PC", 5, 6000));
        gameStore.addGame(new VideoGame("BloodBorne", "Action", "PS4", 8, 40000));
        gameStore.addGame(new VideoGame("Black", "Shooter", "PS4", 10, 7000));

        while (true) {
            System.out.println("Welcome to the Game Store!");
            System.out.println("Please choose an option:");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Admin Password: ");
                    String adminPassword = scanner.nextLine();
                    isAdmin = adminPassword.equals("admin123"); // Verificar la contraseña del administrador
                    if (isAdmin) {
                        System.out.println("Admin Login Successful!");
                    } else {
                        System.out.println("Admin Login Failed!");
                    }
                    break;

                case 2:
                    isAdmin = false;
                    System.out.println("Customer Login Successful!");
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            while (true) {
                System.out.println("----------------------");
                System.out.println("Please choose an option:");
                System.out.println("1. View Inventory");
                System.out.println("2. Buy Game");
                if (isAdmin) {
                    System.out.println("3. Sell Game");
                    System.out.println("4. View Stats");
                }
                System.out.println("5. Logout");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        gameStore.displayInventory();
                        break;

                    case 2:
                        System.out.print("Enter the title of the game you want to buy: ");
                        String buyTitle = scanner.nextLine();
                        System.out.print("Enter the quantity you want to buy: ");
                        int buyQuantity = scanner.nextInt();
                        scanner.nextLine();
                        if (!isAdmin) {
                        	gameStore.sellGame(buyTitle, buyQuantity);
                        	break;
                        	}
                        else {
                        	VideoGame game = gameStore.findGame(buyTitle);
                        	if (game != null) {
                        		gameStore.purchaseGame(buyTitle, buyQuantity);
                        		break;
                        		}
                        	else {
                        		System.out.print("Game does not exists would you like to create it and buy it?:(y/n) ");
                        		String response = scanner.nextLine();
                                if (response.equals("y")) {
                                	System.out.println("Game genre: ");
                                	String new_genre = scanner.nextLine();
                                	System.out.println("Game platform: ");
                                	String new_platform = scanner.nextLine();  
                                	System.out.println("Game price: ");
                                	double new_price = scanner.nextDouble();
                                	gameStore.addGame(new VideoGame(buyTitle, new_genre, new_platform, 0, new_price));
                                	gameStore.purchaseGame(buyTitle, buyQuantity);
                                	break;
                                }
                                else {
                                	break;
                                }
                                
                        	}
                        }
                    case 3:
                        if (isAdmin) {
                            System.out.print("Enter the title of the game you want to sell: ");
                            String sellTitle = scanner.nextLine();
                            System.out.print("Enter the quantity you want to sell: ");
                            int sellQuantity = scanner.nextInt();
                            scanner.nextLine();
                            gameStore.sellGame(sellTitle, sellQuantity);
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                        break;

                    case 4:
                        if (isAdmin) {
                            gameStore.displayStats();
                        } else {
                            System.out.println("Invalid choice. Please try again.");
                        }
                        break;

                    case 5:
                        System.out.println("Logged out successfully.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                if (option == 5) {
                    break;
                }
            }
        }
    }
}