import javax.swing.JFrame;

public class MainFrame{
    public void mainFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Cool Password Generator");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setVisible(true);
    }
}
