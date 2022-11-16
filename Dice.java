// class Dice in java
// Made by Paul Giglio
// COP3252, Robert Myers, Assignment X

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JCheckBox;


public class Dice
{
  public static void main(String[] args)
  {
    JFrame frame = new JFrame( "Dice" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    DicePanel dp = new DicePanel();
    dp.setBackground(Color.white);
    frame.add( dp );
    frame.setSize( 600, 100 );
    frame.setVisible( true );
  }
}

class DicePanel extends JPanel
{
  private Integer rand1 = 1 + (int)(6 * Math.random());
  private Integer rand2 = 1 + (int)(6 * Math.random());
  private Integer rand3 = 1 + (int)(6 * Math.random());
  private Integer rand4 = 1 + (int)(6 * Math.random());
  private Integer rand5 = 1 + (int)(6 * Math.random());
  public Color background;
  private JButton Roll = new JButton("Roll the Dice!");
  private JLabel Dice1 = new JLabel(rand1.toString());
  private JLabel Dice2 = new JLabel(rand2.toString());
  private JLabel Dice3 = new JLabel(rand3.toString());
  private JLabel Dice4 = new JLabel(rand4.toString());
  private JLabel Dice5 = new JLabel(rand5.toString());
  private JCheckBox Reroll1 = new JCheckBox();
  private JCheckBox Reroll2 = new JCheckBox();
  private JCheckBox Reroll3 = new JCheckBox();
  private JCheckBox Reroll4 = new JCheckBox();
  private JCheckBox Reroll5 = new JCheckBox();
  private ButtonHandler button = new ButtonHandler();
  private JLabel label1 = new JLabel("Your Dice:");
  
  public void paint(Graphics g)
  {
    super.paint( g );
    setBackground( background );
  }
  
  public DicePanel()
  {
    background = Color.white;
    add(Roll);
    add(label1);
    Roll.addActionListener(button);
    add(Reroll1);
    add(Dice1);
    add(Reroll2);
    add(Dice2);
    add(Reroll3);
    add(Dice3);
    add(Reroll4);
    add(Dice4);
    add(Reroll5);
    add(Dice5);
  }
  
  private class ButtonHandler implements ActionListener
  {
    public void actionPerformed( ActionEvent event)
    {
      if(Reroll1.isSelected())
      {
        rand1 = 1 + (int)(6 * Math.random());
        remove(Dice1);
        Dice1 = new JLabel(rand1.toString());
      }
      
      if(Reroll2.isSelected())
      {
        rand2 = 1 + (int)(6 * Math.random());
        remove(Dice2);
        Dice2 = new JLabel(rand2.toString());
      }
      if(Reroll3.isSelected())
      {
        rand3 = 1 + (int)(6 * Math.random());
        remove(Dice3);
        Dice3 = new JLabel(rand3.toString());
      }
      if(Reroll4.isSelected())
      {
        rand4 = 1 + (int)(6 * Math.random());
        remove(Dice4);
        Dice4 = new JLabel(rand4.toString());
      }
      if(Reroll5.isSelected())
      {
        rand5 = 1 + (int)(6 * Math.random());
        remove(Dice5);
        Dice5 = new JLabel(rand5.toString());
      }
      
      remove(Reroll1);
      add(Reroll1);
      add(Dice1);
      remove(Reroll2);
      add(Reroll2);
      add(Dice2);
      remove(Reroll3);
      add(Reroll3);
      add(Dice3);
      remove(Reroll4);
      add(Reroll4);
      add(Dice4);
      remove(Reroll5);
      add(Reroll5);
      add(Dice5);
      
      setVisible(false);
      setVisible(true);
    }
  }
}