package com.lugowoy.tasks.solutions.arrays.onedimensional.determineTimeOfStayOfCustomerInQueue;

import com.lugowoy.helper.checkers.CheckerArray;
import com.lugowoy.helper.utils.Capacity;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/**
 * Created by Konstantin Lugowoy on 16.03.2017.
 */
public interface DeterminantCustomerInQueue<T, V> {

    V determine(@NotNull final Queue<T> queue, final int customerIndex);

    static BigDecimal determineTimeStayCustomerInQueue(@NotNull final Queue<Customer> customerQueue,
                                                       final int indexOfCustomer) {
        CheckerArray.check(customerQueue.getQueue(), Capacity.UPPER.get());
        BigDecimal resultTime = new BigDecimal(0);
        for (int i = 0; i < customerQueue.getQueue().length; i++) {
            if (i != indexOfCustomer) {
                resultTime = resultTime.add(Queue.getTimeService());
            } else {
                break;
            }
        }
        return resultTime;
    }

}
