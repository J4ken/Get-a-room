package main.java;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;

/**
 * Created by Jacob on 2/12/2016.
 */
public class MainFrame extends JFrame
{

    private Board board;
    private LayoutPanel lPanel;

    public MainFrame(){
        super("get-a-room");
    }

    public void setUpFrame() throws IOException, NotInBoardBoundsException {
        board = new Board(Board.ROOM_HEIGHT, Board.ROOM_WIDTH);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createMenuBar();
        JPanel mainPanel = (JPanel) getContentPane();
        lPanel = new LayoutPanel();
        mainPanel.add(lPanel, BorderLayout.CENTER);
        lPanel.renderRoom(board);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Creates a menubar with menuitems
     */
    public void createMenuBar(){
        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        //add exit
        JMenuItem exitMI = new JMenuItem("exit");
        exitMI.setToolTipText("Exit application");
        exitMI.setMnemonic(KeyEvent.VK_E);
        exitMI.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
         });

        //add read
        JMenuItem readMI = new JMenuItem("read");
        readMI.setToolTipText("read file");
        readMI.setMnemonic(KeyEvent.VK_I);
        readMI.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.out.println("read datafile");

            }
        });

        //add generate
        JMenuItem generateMI = new JMenuItem("generate");
        generateMI.setToolTipText("generate room");
        generateMI.setMnemonic(KeyEvent.VK_I);
        generateMI.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                System.out.println("Generating room");
                try {
                    lPanel.renderRoom(board);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (NotInBoardBoundsException e1) {
                    e1.printStackTrace();
                }
            }
        });

        file.add(exitMI);
        file.add(readMI);
        file.add(generateMI);

        menubar.add(file);
        setJMenuBar(menubar);
    }
}
