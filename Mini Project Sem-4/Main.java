import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Main {

    public static void operate(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        System.out.println("this is testing");

        JFrame f=new JFrame();
        f.setTitle("Image Operation by Anmool Kumar");
        f.setSize(500,400);
        f.getContentPane().setBackground(Color.CYAN);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Font font=new Font("Bold Arial",Font.BOLD,12);
        Font f1=new Font("Algerian",Font.BOLD,20);
        JLabel l1 =new JLabel("IMAGE CRYPTOGRAPHY_by ANMOOL KUMAR");
        l1.setFont(f1);

        JLabel l2 =new JLabel("FOR ENCRPTION");
        l2.setFont(font);
        JTextField T1=new JTextField(12);
        T1.setFont(font);

        JLabel l3 =new JLabel("FOR DECRYPTION");
        l3.setFont(font);
        JTextField T2=new JTextField(12);
        T2.setFont(font);

        JButton b1=new JButton();
        b1.setText("ENCRYPTION");
        b1.setFont(font);

        JButton b2=new JButton();
        b2.setText("DECRYPTION");
        b2.setFont(font);

        b1.addActionListener(e->{
            System.out.println("Clicked Button-1");
            String text1=T1.getText();
            int temp1=Integer.parseInt(text1);
            operate(temp1);
        });

        b2.addActionListener(e->{
            System.out.println("Clicked Button-2");
            String text2=T2.getText();
            int temp2=Integer.parseInt(text2);
            operate(temp2);
        });

        f.setLayout(new FlowLayout());
        f.add(l1);
        f.add(l2);
        f.add(T1);
        f.add(l3);
        f.add(T2);
        f.add(b1);
        f.add(b2);
        f.setVisible(true);

    }
}