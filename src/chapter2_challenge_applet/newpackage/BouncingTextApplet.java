package chapter2_challenge_applet.newpackage;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class BouncingTextApplet extends Applet implements Runnable {

    private Thread animationThread;
    private int x = 0;
    private String name = "TESFAMIKAEL HAILU"; // Replace with your name
    private int speed = 5;
    private boolean running = false;
    private Image logo;

    @Override
    public void init() {
        setSize(400, 200);
        setBackground(Color.DARK_GRAY);

        // Load the image from the same directory as the HTML file
        logo = getImage(getDocumentBase(), "logo.png");
    }

    @Override
    public void start() {
        if (animationThread == null) {
            running = true;
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    @Override
    public void stop() {
        running = false;
        animationThread = null;
    }

    @Override
    public void run() {
        while (running) {
            x += speed;
            if (x > getWidth()) {
                x = 0;
            }
            repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Handle interrupt
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        // Draw bouncing text
        g.setColor(Color.GREEN);
        g.drawString(name, x, 100);

        // Draw a rectangle box
        g.drawRect(10, 70, getWidth() - 20, 40);

        // Draw the image in the top-left corner
        if (logo != null) {
            g.drawImage(logo, 10, 10, this); // x=10, y=10
        }
    }
}
