import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actions {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(new Dimension(500, 500));
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        JTextField txt = new JTextField(20);
        JButton button = new JButton("b1");
        JLabel lbl = new JLabel("default Label");
        JTextArea JtxtArea = new JTextArea(20, 20);


        for (int i = 0; i < 20; i++)
            jFrame.add(new JButton("Button " + i));


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(e.getSource());
                    }
                });
            }
        });



        jFrame.add(BorderLayout.NORTH, button);
        jFrame.add(BorderLayout.CENTER, txt);
        jFrame.add(BorderLayout.CENTER, txt);

        jFrame.add(lbl);
        jFrame.add(JtxtArea);


        jFrame.setVisible(true);
    }
}
