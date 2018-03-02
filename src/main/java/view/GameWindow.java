package view;

import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    Container container;
    JLabel gameInformer;
    JButton rockButton;
    JButton paperButton;
    JButton scissorsButton;
    JLabel statistic;
    String message = "Welcome to rock/paper/scissors game";
    String statisticMessage = "<html>Statistic:<br> last games wins %d%%,<br> all games wins %d%% on %d games</html>";
    JPanel panel;
    int allGamesNumber = 0;
    int lastGamesWinPercents = 0 ;
    int allGamesWinPercents = 0;

    public GameWindow() {
        super("");
        setBounds(1650, 750, 250, 250);
        //setUndecorated(true);
        setOpacity((float) 0.7);
        setResizable(false);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void drawField(WindowView controller) {
        this.addComponentListener(controller);
        container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        gameInformer = new JLabel(message);
        gameInformer.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() / 3));
        gameInformer.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        gameInformer.setForeground(Color.WHITE);
        setButtons(controller);

        statistic = new JLabel(String.format(statisticMessage, lastGamesWinPercents, allGamesWinPercents, allGamesNumber));
        statistic.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() / 3));
        statistic.setForeground(Color.LIGHT_GRAY);
        constraints.weighty = this.getHeight() / 3;
        constraints.gridx = 0;
        constraints.gridy = 0;
        container.add(gameInformer, constraints);
        constraints.gridy = 1;
        container.add(panel, constraints);
        constraints.gridy = 2;
        container.add(statistic, constraints);
        container.setBackground(Color.BLACK);
        this.pack();
    }
    public void redrawField() {
        gameInformer.setText("<html>"+message+"</html>");
        statistic.setText(String.format(statisticMessage, lastGamesWinPercents, allGamesWinPercents, allGamesNumber));

        this.pack();
    }

    public void resize (){
        container.setSize(this.getWidth(), this.getHeight());
    }

    private void setButtons(WindowView controller){
        ImageIcon rock = new ImageIcon("rock.jpg");
        rockButton = new JButton(rock);
        rockButton.setBackground(Color.LIGHT_GRAY);
        rockButton.addActionListener(controller);
        ImageIcon paper = new ImageIcon("paper.jpg");
        paperButton = new JButton(paper);
        paperButton.setBackground(Color.WHITE);
        paperButton.addActionListener(controller);
        ImageIcon scissors = new ImageIcon("scissors.jpg");
        scissorsButton = new JButton(scissors);
        scissorsButton.setBackground(new Color(199,233,243));
        scissorsButton.addActionListener(controller);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() / 3));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panel.setLayout(new BorderLayout());
        panel.add(rockButton, BorderLayout.WEST);
        panel.add(paperButton, BorderLayout.CENTER);
        panel.add(scissorsButton, BorderLayout.EAST);
        panel.setSize(this.getWidth(), this.getHeight() / 3);
    }

}
