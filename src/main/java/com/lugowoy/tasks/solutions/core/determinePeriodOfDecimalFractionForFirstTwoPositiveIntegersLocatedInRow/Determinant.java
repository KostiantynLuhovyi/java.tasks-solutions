package com.lugowoy.tasks.determinePeriodOfDecimalFractionForFirstTwoPositiveIntegersLocatedInRow;

import com.lugowoy.helper.models.Array;

/**
 * Created by Konstantin Lugowoy on 03.09.2017.
 */

public interface Determinant {

    void determine(Array<Integer> array);

    static void determinePeriodOfDecimalFractionForFirstTwoPositiveIntegersLocatedInRow(Array<Integer> array) {
        long p, q, r, l, t, n;
        for (int i = 0; i < array.getLength() - 1; i++) {
            if (array.getLength() < 2) {
                break;
            } else if ((array.get(i) >= 0) && (array.get(i + 1) >= 0)) {
                p = array.get(i);
                q = array.get(i + 1);
                r = p;
                for (n = 0; n < q; n++) {
                    r = (r * 10) % q;
                }
                t = r;
                l = 0;
                do {
                    r = (r * 10) % q;
                    l++;
                } while (r != t);
                t = r = p;
                System.out.println();
                System.out.print("The period of the decimal fraction p = m / i " +
                                              "for the first two consecutive positive integers i and m, is equal : 0.");
                for (n = 0; n < l; n++) {
                    r = (r * 10) % q;
                }
                for (n = 0; r != t; n++) {
                    System.out.print(t * 10 / q);
                    r = (r * 10) % q;
                    t = (t * 10) % q;
                }
                System.out.print('(');
                for (n = 0; n < l; n++) {
                    System.out.print(t * 10 / q);
                    t = (t * 10) % q;
                }

                System.out.println(')' + " = " + p + "/" + q);
                break;
            }
        }
    }

}
