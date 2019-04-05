/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTools;

/**
 * this package:برای بررسی رشته است که رشته مورد نظر الفبا کوچک باشد
 *             
 */
public class CheckInput {

    /**
     * this function: بررسی می کند که رشته ورودی اش الفبا کوچک باشد
     * @param inputStr ورودی تابع
     * @return true || false
     */
    public boolean CheckAlephba(String inputStr) {
        inputStr = inputStr.trim();
        char[] s = inputStr.toCharArray();
        if (inputStr.length() == 1) {
            if (s[0] >= 'a' && s[0] <= 'z') {
                return true;
            }
            return false;
        }
        for (int j = 0; j < s.length; j++) {
            if (!(s[j] >= 'a' && s[j] <= 'z')) {
                return false;
            }
        }

        return true;
    }
}
