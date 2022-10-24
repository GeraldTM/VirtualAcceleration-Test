import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.Math;

public class virtalAccel implements WindowListener {
    static double current;
    static double target;
    static double speed;
    static boolean isClosed;
    static int delay;

    public static void main(String args[]) {
        visualize();
        current = 0;
        target = 0;
        speed = 0;
        delay = 0;


    }

    public static double doMath(double t, double s, int c) {

        if (t == 0) {
            current = 0;
        } else if (t > 0 && current + s < t) {
            current += s;
        } else if (t < 0 && current - s > t) {
            current -= s;
        } else{
            current = t;
        }
        try {
            Thread.sleep(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return current;
    }



    public static void visualize() {
        //create a new JFrame
        JFrame f = new JFrame("virtalAcceleration Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 150);

        //f.getContentPane()reate a new JPanel and content
        JPanel tp = new JPanel();
        JLabel t = new JLabel("Target:");
        JTextField tt = new JTextField(2);
        tp.add(t);
        tp.add(tt);

        JPanel ap = new JPanel();
        JLabel a = new JLabel("Acceleration Incriments:");
        JTextField at = new JTextField(2);
        ap.add(a);
        ap.add(at);

        JPanel sp = new JPanel();
        JLabel s = new JLabel("Acceleration Speed:");
        JTextField st = new JTextField(2);
        sp.add(s);
        sp.add(st);


        JPanel i = new JPanel();
        JButton b = new JButton("Run");
        i.add(b);

        JPanel o = new JPanel();
        



        JTextArea ol = new JTextArea("Output:");
        o.add(ol);

        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        f.setLayout(fl);

        f.add(tp);
        f.add(ap);
        f.add(sp);
        f.add(i);
        f.add(o);
        f.setVisible(true);

        while (isClosed == false) {
            boolean run = b.getModel().isPressed();
            if (run) {
                target = Double.parseDouble(tt.getText());
                speed = Double.parseDouble(at.getText());
                delay = Integer.parseInt(st.getText());
                ol.setText("Output:" + doMath(target, speed, delay));
                o.updateUI();
            } else {
                target = 0;
                speed = 0;
                delay = 0;
                ol.setText("Output:" + doMath(target, speed, delay));
                o.updateUI();
            }
        }     
    }

    @Override
    public void windowOpened(WindowEvent e) {
        isClosed = false;
    }

    @Override
    public void windowClosed(WindowEvent e) {
        isClosed = true;        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }
}

