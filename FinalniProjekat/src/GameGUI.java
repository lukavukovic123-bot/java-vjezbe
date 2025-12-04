import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GameGUI extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField healthField;
    private JTextField xField;
    private JTextField yField;
    private JRadioButton rectRadio;
    private JRadioButton circleRadio;
    private JButton startButton;
    private JTextArea outputArea;

    public GameGUI() {
        setTitle("Jednostavna igra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));

        inputPanel.add(new JLabel("Ime igrača:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Health (0-100):"));
        healthField = new JTextField("100");
        inputPanel.add(healthField);

        inputPanel.add(new JLabel("Pozicija X:"));
        xField = new JTextField("50");
        inputPanel.add(xField);

        inputPanel.add(new JLabel("Pozicija Y:"));
        yField = new JTextField("50");
        inputPanel.add(yField);

        rectRadio = new JRadioButton("Pravougaoni kolajder (32x32)", true);
        circleRadio = new JRadioButton("Kružni kolajder (r=16)");
        ButtonGroup group = new ButtonGroup();
        group.add(rectRadio);
        group.add(circleRadio);

        inputPanel.add(rectRadio);
        inputPanel.add(circleRadio);

        startButton = new JButton("Pokreni igru");
        startButton.addActionListener(this);
        inputPanel.add(startButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            try {
                String name = nameField.getText();
                int health = Integer.parseInt(healthField.getText().trim());
                int x = Integer.parseInt(xField.getText().trim());
                int y = Integer.parseInt(yField.getText().trim());

                Collidable collider;
                if (rectRadio.isSelected()) {
                    collider = new RectangleCollider(x, y, 32, 32);
                } else {
                    collider = new CircleCollider(x, y, 16);
                }

                Player player = new Player(name, x, y, collider, health);

                List<Enemy> loadedEnemies = Game.loadEnemiesFromCSV("enemies.csv");

                Game game = new Game(player);
                for (Enemy enemy : loadedEnemies) {
                    game.addEnemy(enemy);
                }

                game.resolveCollisions();

                StringBuilder sb = new StringBuilder();
                sb.append("IGRAČ:\n");
                sb.append(player.toString()).append("\n\n");

                sb.append("SVI NEPRIJATELJI:\n");
                for (Enemy enemy : game.getEnemies()) {
                    sb.append(enemy.toString()).append("\n");
                }

                sb.append("\nNEPRIJATELJI U KOLIZIJI SA IGRAČEM:\n");
                List<Enemy> colliding = game.collidingWithPlayer();
                if (colliding.isEmpty()) {
                    sb.append("Nema kolizija.\n");
                } else {
                    for (Enemy enemy : colliding) {
                        sb.append(enemy.toString()).append("\n");
                    }
                }

                sb.append("\nLOG DOGAĐAJA:\n");
                for (String entry : game.getLog()) {
                    sb.append(entry).append("\n");
                }

                outputArea.setText(sb.toString());

                if (player.getHealth() <= 0) {
                    JOptionPane.showMessageDialog(this, "Igrač je poražen.", "Rezultat", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Igrač je preživio napad.", "Rezultat", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Greška: " + ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameGUI gui = new GameGUI();
            gui.setVisible(true);
        });
    }
}
