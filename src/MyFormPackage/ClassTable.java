/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFormPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * this class:ساختن فرم دلخواه
 * @author ali
 */
public class ClassTable {

    public ClassTable() {
    }
    JFrame frame;

    /**
     *this:ایجاد فریم با جدول
     * @param CYK آرایه دو بعدی ساخته شده توسط الگوریتم CYK
     * @param inStr رشته ورودی که کاربر برای  چک کردن عضو گرامر بودن یا نبودن وارد کرده است.
     * @param produc کلید برای تشخیص تولید یا عدم تولید رشته کاربر در گرامر
     */
    public void setDataTable(String[][] CYK, String inputStr, boolean produc) {
        frame = new JFrame();
        frame.setTitle("نتیجه بررسی رشته ورودی ");
        int row, col;
        int StrLen = CYK.length;
        String Message;
        if (produc) {
            Message = "  رشته  " + inputStr + " توسط این گرامر تولید می شود. ";
        } else {
            Message = "  رشته  " + inputStr + "  توسط این گرامر تولید نمی شود. ";
        }
        String[] alephba = new String[StrLen];
        String[] header = new String[StrLen];
        for (int j = 0; j < StrLen; j++) {
            alephba[j] = String.valueOf(inputStr.charAt(j));
            header[j] = "  ";
        }
        for (row = 0; row < StrLen; row++) {
            for (col = 0; col < StrLen; col++) {
                if (CYK[row][col].compareTo("#") == 0) {
                    CYK[row][col] = " ";
                }

            }
        }

        JTable table = new JTable(StrLen + 1, StrLen);
        table.setTableHeader(null);
        table.setFillsViewportHeight(true);
        table.setEnabled(false);
        /**
         * this:مجموعه متغیرها را می سازد
         */
        String sequenVar=" { ";
        int rowT, colT = 0;
        //thisپر کردن جدول با آرایه
        for (int diagonal = 0; diagonal < StrLen; diagonal++) {
            for (row = 0, colT = 0; row < (StrLen - diagonal); row++, colT++) {
                col = diagonal + row;
                rowT = StrLen - diagonal - 1;
                if(CYK[row][col].compareTo("Ø")!=0){
                for(int k=0;k<CYK[row][col].length();k++){
                   sequenVar+=String.valueOf(CYK[row][col].charAt(k));
                   if((k+1)<CYK[row][col].length())
                      sequenVar+=",";
                
             }//end for k
                sequenVar+=" } ";
                table.setValueAt(sequenVar, rowT, colT);
                sequenVar=" { ";
            }else{
                 table.setValueAt(CYK[row][col], rowT, colT);
            }
        }
        }//end for diagonal
        for (col = 0; col < StrLen; col++) {
            table.setValueAt(alephba[col], StrLen, col);
        }

        table.repaint();

        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().setLayout(new BorderLayout());
        JLabel jlblMess = new JLabel(Message);
        jlblMess.setBackground(Color.green);
        jlblMess.setFont(new Font("Arial", Font.TRUETYPE_FONT, 20));
        JButton jbtnEndMess = new JButton("خروج");
        jbtnEndMess.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        frame.getContentPane().add(jbtnEndMess, BorderLayout.AFTER_LAST_LINE);
        frame.getContentPane().add(jlblMess, BorderLayout.PAGE_START);

        frame.add(scrollPane, BorderLayout.CENTER);
     
        frame.setSize(350, 250);
        MyTools.Tools.setFormLocation(frame);
        frame.setVisible(true);
    }
}
