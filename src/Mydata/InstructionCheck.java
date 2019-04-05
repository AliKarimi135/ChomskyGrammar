/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mydata;

import java.util.ArrayList;

/**
 * @author ali
 */
/**
 *This class :
 *     <br>1)function String CheckRepitedVariable(String V):متغیر های تکراری را حذف می کند
 *     <br>2) function String CheckProductionsAlephba(String v):متغیرهایی که این الفبا را تولید می کنند را مشخص می کند
 *     <br>3)function String CheckProductionsVariable(String v):متغیرهایی که این متغیرهای ورودی را تولید می کنند مشخص می کند
 *     <br>4)function String Decarty(String V1, String V2):رشته را به کاراکتر تبدیل وبا هم ضرب دکارتی می کند 
 */
public class InstructionCheck {

    ArrayList<GrammerProperties> ArrayListGrammer;

    public InstructionCheck(ArrayList<GrammerProperties> GrammerList) {
        ArrayListGrammer = new ArrayList<GrammerProperties>(GrammerList);
        ArrayListGrammer = GrammerList;
    }
/**
 * a) ورودی یک رشته از متغیرهاست که اگر متغیر تکراری در آن باشد
  <br>b)فقط یک متغیراز آن را نگه می دارد و بقیه را حذف می کند.
  <br>c)رشته خروجی شامل متغیرهای متفاوت است.
  <br>d)اگر ورودی تابع تولید کننده ایی نداشته باشد رشته (#)برگردانده می شود

 * @param V
 * @return
 */
    public String CheckRepitedVariable(String V) {
        char[] var = V.toCharArray();
        String VarProduc ="";
        for (int j = 0; j < var.length; j++) {
            if (var[j] != '#') {
                VarProduc += var[j] + "";
            }
            for (int i = j + 1; i < var.length; i++) {
                if (var[j] == var[i]) {
                    var[i] = '#';
                }

            }
        }
        VarProduc = VarProduc.trim();
        return VarProduc;
    }
    /**
     *a) ورودی یک حرف از حروف الفباست
     <br>b) متغیرهایی که این الفبا را تولید می کنند را مشخص می کند
     <br>c)خروجی تولید کننده های الفبای ورودی هستند
     <br>d)اگر ورودی تابع تولید کننده ایی نداشته باشد رشته (#)برگردانده می شود

     * @param v
     * @return
     */

    public String CheckProductionsAlephba(String v) {
        String produc ="";
        v = v.trim();
        for (int k = 0; k < ArrayListGrammer.size(); k++) {
            if (v.compareTo(ArrayListGrammer.get(k).getAlephba()) == 0) {
                produc += ArrayListGrammer.get(k).getLeftVariable();
            }
        }
        produc = produc.trim();
        if (produc.length() == 0) {
            return "#";
        }

        return CheckRepitedVariable(produc);
    }
/**
 * a) ورودی یک رشته از متغیرهاست
  <br>b)متغیرهایی که این متغیرهای ورودی را تولید می کنند مشخص می کند.
  <br>c)خروجی رشته ای از تولید کننده های متغیر های ورودی هستند
  <br>d)اگر ورودی تابع تولید کننده ایی نداشته باشد رشته (#)برگردانده می شود

 * @param v
 * @return
 */
    public String CheckProductionsVariable(String v) {
        String produc ="";
        v = v.trim();
        for (int k = 0; k < ArrayListGrammer.size(); k++) {
            if (v.compareTo(ArrayListGrammer.get(k).getRightVariable()) == 0) {
                produc += ArrayListGrammer.get(k).getLeftVariable();
            }
        }
        produc = produc.trim();
        if (produc.length() == 0) {
            return "#";
        }
      return CheckRepitedVariable(produc);
    }
/**
 * a) ورودی دو رشته از متغیر هاست
  <br>a)رشته را به کاراکتر تبدیل وبا هم ضرب دکارتی می کند و به تابع های مربوطه برای چک کردن
  <br>a)تولید کننده های متغیرهایی که از ضرب دکارتی حاصل می شوند فرستاده می شود
  <br>b)خروجی رشته ایی ازتولید کننده ها است
  <br>c)اگر ورودی تابع تولید کننده ایی نداشته باشد رشته (#)برگردانده می شود

 * @param V1
 * @param V2
 * @return
 */
    public String Decarty(String V1, String V2) {
        V1=V1.trim();
        V2=V2.trim();
        char[] variable1 = V1.toCharArray();
        char[] variable2 = V2.toCharArray();
        String produ = "";
        String decarty = "";
        for (int i = 0; i < variable1.length; i++) {
            for (int j = 0; j < variable2.length; j++) {
                decarty =String.valueOf(variable1[i]);
                decarty+=String.valueOf(variable2[j]);
                decarty = CheckProductionsVariable(decarty);
                if (decarty.compareTo("#") != 0) {
                    produ += decarty;
                }
            }
        }
        produ = produ.trim();
        if (produ.length() == 0) {
            return "#";
        }
       return CheckRepitedVariable(produ);
    }
}
