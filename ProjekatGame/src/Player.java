public class Projekat_game {

	
	 			public class Player {

				private int x;
				private int y;
				private int width;
				private int height;
				private int health;
				
				public Player(int x, int y, int width, int height, int health) {
					this.x = x;
					this.y = y;
					this.width = width;
					this.height = height;
					this.health = health;
					
				}
				public int getHealth() {
					return health;
				}
				public void setHealth(int health) {
				    if (health < 0) {
				        this.health = 0;
				    } else if (health > 100) {
				        this.health = 100;
				    } else {
				        this.health = health;
				    }
				}
				public int getX() {
					return x;
				}
				public int setX(int x) {
					this.x = x;
					return x;
				}
				public int getY() {
					return y;
				}
				public int setY(int y) {
					this.y = y;
					return y;
				}
				public int getWidth() {
					return width;
				}
				public int setWidth(int width) {
					this.width = width;
					return width;
				}
				public int getHeight() {
					return height;
				}
				public int setHeight(int height) {
					this.height = height;
					return height;
				}
			}
			
			public class Enemy{
				private int x;
				private int y;
				private int width;
				private int height;
				private int damage;
				
				public Enemy(int x, int y, int width, int height, int damage) {
					this.x = x;
					this.y = y;
					this.width = width;
					this.height = height;
					this.damage = damage;
				}
				
				public int getDamage() {
					return damage;
				}
				public void setDamage(int damage) {
					this.damage = damage;
				}
				public int getX() {
					return x;
				}
				public int setX(int x) {
					this.x = x;
					return x;
				}
				public int getY() {
					return y;
				}
				public int setY(int y) {
					this.y = y;
					return y;
				}
				public int getWidth() {
					return width;
				}
				public int setWidth(int width) {
					this.width = width;
					return width;
				}
				public int getHeight() {
					return height;
				}
				public int setHeight(int height) {
					this.height = height;
					return height;
				}
				
			}
			
			public void checkCollision(Player player, Enemy enemy) {
				if (player.x < enemy.x + enemy.width && player.x + player.width > enemy.x &&
					player.y < enemy.y + enemy.height && player.y + player.height > enemy.y) {
					player.setHealth(player.getHealth() - enemy.damage);
				} else if (player.getHealth() < 0) {
					player.setHealth(0);
				}
				System.out.println("Player hit! Health: " + player.getHealth());
			}
				
			public void decreaseHealth(Player player, int damage) {
				player.setHealth(player.getHealth() - damage);
				System.out.println("Player health decreased by " + damage + ". Current health: " + player.getHealth());
			}
				
				public static void main(String[] args) {
					Projekat_game game = new Projekat_game();
					Player player = game.new Player(10, 10, 20, 20, 100);
					Enemy enemy1 = game.new Enemy(15, 15, 20, 20, 30); 
					Enemy enemy2 = game.new Enemy(50, 50, 20, 20, 80); 

					System.out.println("Initial player health: " + player.getHealth());

					game.checkCollision(player, enemy1);
					System.out.println("After collision with enemy1, health: " + player.getHealth());

					game.decreaseHealth(player, 80);
					System.out.println("After decreaseHealth with 80 damage, health: " + player.getHealth());

					game.checkCollision(player, enemy2);
					System.out.println("After collision with enemy2, health: " + player.getHealth());
				}
			
	
	
}
