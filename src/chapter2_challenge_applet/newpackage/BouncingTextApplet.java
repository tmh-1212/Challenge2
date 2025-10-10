
package chapter2_challenge_applet.newpackage;
    import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BouncingTextApplet extends Applet implements Runnable {
    private Thread thread;
    private int x = 0;
    private String text = "Tesfamikael Hailu";  // Replace with your actual name
    private boolean running = false;

    @Override
    public void init() {
        setSize(400, 100);
        setBackground(Color.BLACK);
    }

    @Override
    public void start() {
        if (thread == null || !running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void stop() {
        running = false;
        thread = null;
    }

    @Override
    public void run() {
        while (running) {
            x += 5;
            if (x > getWidth()) {
                x = 0;
            }

            repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Handle exception
                break;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString(text, x, 50);
    }
}

   
