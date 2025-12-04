import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<String> log;

    public Game(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();
        this.log = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<String> getLog() {
        return log;
    }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int dmg = e.getEffectiveDamage();
        int oldHealth = p.getHealth();
        p.applyDamage(dmg);
        int newHealth = p.getHealth();
        log.add("Igrač je pogođen od neprijatelja tipa '" + e.getType() +
                "' za " + dmg + " dmg. Health: " + oldHealth + " -> " + newHealth + ".");
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        log.add("Dodat neprijatelj: " + e.toString());
    }

    public List<Enemy> findByType(String query) {
        String q = query == null ? "" : query.toLowerCase();
        ArrayList<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(q)) {
                result.add(e);
            }
        }
        return result;
    }

    public List<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                result.add(e);
            }
        }
        return result;
    }

    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                log.add("Kolizija između igrača i neprijatelja: " + e.getType());
                decreaseHealth(player, e);
                if (player.getHealth() == 0) {
                    log.add("Igrač je poražen.");
                    break;
                }
            }
        }
    }

    public static List<Enemy> loadEnemiesFromCSV(String filePath) {
        ArrayList<Enemy> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                String trimmed = line.trim();
                if (trimmed.isEmpty() || trimmed.startsWith("#")) {
                    continue;
                }
                String[] parts = trimmed.split(",");
                if (parts.length < 9) {
                    throw new IllegalArgumentException("Neispravan zapis u CSV na liniji " + lineNo + ": " + line);
                }

                String type = parts[0].trim();
                String enemyClass = parts[1].trim().toLowerCase();
                int x = Integer.parseInt(parts[2].trim());
                int y = Integer.parseInt(parts[3].trim());
                String colliderType = parts[4].trim().toLowerCase();
                int size1 = Integer.parseInt(parts[5].trim());
                int size2 = Integer.parseInt(parts[6].trim());
                int damage = Integer.parseInt(parts[7].trim());
                int health = Integer.parseInt(parts[8].trim());

                Collidable collider;
                if (colliderType.equals("rect") || colliderType.equals("rectangle")) {
                    collider = new RectangleCollider(x, y, size1, size2);
                } else if (colliderType.equals("circle")) {
                    collider = new CircleCollider(x, y, size1);
                } else {
                    throw new IllegalArgumentException("Nepoznat tip kolajdera na liniji " + lineNo + ": " + colliderType);
                }

                Enemy enemy;
                if (enemyClass.equals("melee")) {
                    enemy = new MeleeEnemy(type, x, y, collider, damage, health);
                } else if (enemyClass.equals("boss")) {
                    enemy = new BossEnemy(type, x, y, collider, damage, health);
                } else {
                    throw new IllegalArgumentException("Nepoznata klasa neprijatelja na liniji " + lineNo + ": " + enemyClass);
                }

                result.add(enemy);
            }
        } catch (IOException e) {
            throw new RuntimeException("Greška pri čitanju CSV fajla: " + e.getMessage(), e);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Neispravan broj u CSV fajlu: " + e.getMessage(), e);
        }
        return result;
    }
}
