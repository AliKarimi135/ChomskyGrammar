/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTools;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author ali
 */
/**
 * this package:فرم برنامه را در وسط صفحه مانیتور کاربر نشان می دهد.<br>
 *           
 */
public class Tools {

    /**
     *
     * this function:فرم برنامه را در وسط صفحه مانیتور کاربر نشان می دهد.
     */
    public static void setFormLocation(JFrame jf) {
        double w = Toolkit.getDefaultToolkit().getScreenSize().width;
        double h = Toolkit.getDefaultToolkit().getScreenSize().height;
        w = (w - jf.getWidth()) / 2;
        h = (h - jf.getHeight()) / 2;
        jf.setLocation((int) w, (int) h);
    }
}
