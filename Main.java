package com.company;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.lang.*;

public class Main {
    public static void operate(int key){
        JFileChooser   FileChooser=new   JFileChooser();
        FileChooser.showOpenDialog(null);
       File file= FileChooser.getSelectedFile();
       //file input stream reader;
        try{
            FileInputStream fis=new FileInputStream(file);
            byte[]data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data){
                System.out.println(b);
                data[i]= (byte) (b^key);
                i++;
            }
            FileOutputStream fos= new FileOutputStream(file);
            fos.write(data);
             fos.close();
             fis.close();
             JOptionPane.showMessageDialog(null,"Done");



        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        System.out.println("this is testing");
        JFrame f=new JFrame();
        f.setTitle("ENCRYPTION TOOL");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font =new Font("Roboto",Font.BOLD,25);

        JButton button=new JButton();
        button.setText("OPEN IMAGE");
        button.setFont(font);



        JTextField textField=new JTextField(20);
        button.addActionListener(e -> {
            System.out.println("BUTTON CLICKD");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);



        });
        textField.setFont(font);
        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);

        f.setVisible(true);
    }
}
