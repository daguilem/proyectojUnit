package proyectojUnit;

import java.util.ArrayList;
import java.util.List;

public class GameStore {
    public List<VideoGame> inventory;
    public int gamesPurchased;
    public int gamesSold;
    public double totalEarnings;

    public GameStore() {
        inventory = new ArrayList<>();
        gamesPurchased = 0;
        gamesSold = 0;
        totalEarnings = 0.0;
    }

    public void addGame(VideoGame game) {
        inventory.add(game);
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (VideoGame game : inventory) {
            System.out.println("Title: " + game.getTitle());
            System.out.println("Genre: " + game.getGenre());
            System.out.println("Platform: " + game.getPlatform());
            System.out.println("Quantity: " + game.getQuantity());
            System.out.println("Price: " + game.getPrice());
            System.out.println("----------------------");
        }
    }

    public void sellGame(String title, int quantity) {
        VideoGame game = findGame(title);
        if (game != null && game.getQuantity() >= quantity) {
            game.setQuantity(game.getQuantity() - quantity);
            gamesSold += quantity;
            totalEarnings += (quantity * game.getPrice());
            System.out.println("Successfully sold " + quantity + " copies of " + title);
        } else {
            System.out.println("Sorry, the game is not available in the desired quantity.");
        }
    }

    public void purchaseGame(String title, int quantity) {
        VideoGame game = findGame(title);
        if (game != null) {
            game.setQuantity(game.getQuantity() + quantity);
            gamesPurchased += quantity;
            totalEarnings -= (quantity* game.getPrice());
            System.out.println("Successfully purchased " + quantity + " copies of " + title);
        } else {
        	System.out.println("Sorry, the game is not available in the desired quantity.");
          	}
    }

    public void displayStats() {
        System.out.println("Games Purchased: " + gamesPurchased);
        System.out.println("Games Sold: " + gamesSold);
        System.out.println("Total Earnings: $" + totalEarnings);
    }

    public VideoGame findGame(String title) {
        for (VideoGame game : inventory) {
            if (game.getTitle().equals(title)) {
                return game;
            }
        }
        return null;
    }
}
