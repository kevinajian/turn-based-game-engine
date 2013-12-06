package view.player;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

public class PrestoryPanel extends JScrollPane{

    JTextArea text;
    public PrestoryPanel(PlayerView v1){
        String s = v1.getPreStory();
        text = new JTextArea(s);
        text.setVisible(true);
    }
}
