import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles the graphical user interface for the Dungeon Crawler.
 * Teacher Solution.
 */
public class GamePanel {
    private JFrame frame;
    private JTextArea mainDisplay;
    private JTextArea statsDisplay;
    private JButton exploreButton;
    
    private Player player;
    private Deck deck;
    private DungeonMap map;
    private BossCard boss;

    public GamePanel(Player player, Deck deck, DungeonMap map, BossCard boss) {
        this.player = player;
        this.deck = deck;
        this.map = map;
        this.boss = boss;
        
        initializeGUI();
        updateStats();
    }

    private void initializeGUI() {
        frame = new JFrame("AP CSA Dungeon Crawler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(950, 550);
        frame.setLayout(new BorderLayout(10, 10));

        mainDisplay = new JTextArea();
        mainDisplay.setEditable(false);
        mainDisplay.setFont(new Font("Monospaced", Font.PLAIN, 14));
        mainDisplay.setText("Welcome to the Dungeon!\nYour start location is at Row 0, Col 0.\nClick 'Explore Room' and enter coordinates to move.\n");
        JScrollPane scrollPane = new JScrollPane(mainDisplay);
        frame.add(scrollPane, BorderLayout.CENTER);

        statsDisplay = new JTextArea();
        statsDisplay.setEditable(false);
        statsDisplay.setFont(new Font("Monospaced", Font.BOLD, 14));
        statsDisplay.setPreferredSize(new Dimension(380, 0));
        statsDisplay.setBackground(new Color(240, 240, 240));
        frame.add(statsDisplay, BorderLayout.EAST);

        JPanel controlPanel = new JPanel();
        exploreButton = new JButton("Explore Room");
        exploreButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        
        exploreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                advanceGame();
            }
        });
        
        controlPanel.add(exploreButton);
        frame.add(controlPanel, BorderLayout.SOUTH);
    }

    public void showWindow() {
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    private void advanceGame() {
        if (player.getHp() <= 0) {
            mainDisplay.append("\nYou are defeated. Game Over.\n");
            exploreButton.setEnabled(false);
            return;
        }

        String rowInput = JOptionPane.showInputDialog(frame, "Enter the Row you want to explore:");
        String colInput = JOptionPane.showInputDialog(frame, "Enter the Column you want to explore:");

        if (rowInput == null || colInput == null) return; // User canceled

        try {
            int r = Integer.parseInt(rowInput.trim());
            int c = Integer.parseInt(colInput.trim());

            if (!map.isValidMove(r, c)) {
                JOptionPane.showMessageDialog(frame, "Invalid move! You must select an unexplored [ ? ] room adjacent to a cleared room. Check your array indices.");
                return;
            }

            mainDisplay.append("\n-----------------------------------\n");

            if (map.isBossRoom(r, c)) {
                mainDisplay.append("You entered the BOSS ROOM!\n");
                boss.applyEffect(player);
                
                if (player.getHp() <= 0) {
                    map.markVisited(r, c, "FAIL ");
                } else {
                    map.markVisited(r, c, "WIN!!");
                    exploreButton.setEnabled(false);
                }
            } else {
                Card drawnCard = deck.drawCard();
                if (drawnCard == null) {
                    mainDisplay.append("The dungeon deck is empty!\n");
                    return;
                }

                mainDisplay.append("You entered a room: " + drawnCard.getName() + "\n");
                mainDisplay.append(drawnCard.getDescription() + "\n");
                
                drawnCard.applyEffect(player);
                
                if (player.getHp() <= 0) {
                    map.markVisited(r, c, "FAIL ");
                } else {
                    map.markVisited(r, c, "CLEAR");
                }
            }

            updateStats();
            mainDisplay.setCaretPosition(mainDisplay.getDocument().getLength());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid integers for Row and Column.");
        }
    }

    private void updateStats() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PLAYER STATS ===\n");
        sb.append("HP: ").append(player.getHp()).append("\n");
        sb.append("Gold: ").append(player.getGold()).append("\n\n");
        
        sb.append("=== ACTION HAND ===\n");
        sb.append(player.getHandAsString()).append("\n");
        
        sb.append("=== DUNGEON MAP ===\n");
        sb.append("Cleared Rooms: ").append(map.countCleared()).append("\n\n");
        sb.append(map.printMap());
        
        statsDisplay.setText(sb.toString());
    }
}