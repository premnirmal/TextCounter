package com.github.premnirmal.textcounter;

/**
 * Created by prem on 10/28/14.
 * <p/>
 * Class that handles the counting up/down of the text value
 */
class Counter implements Runnable {

    final CounterView view;
    final float increment, startValue, endValue;
    final long interval;
    float currentValue, newValue;

    Counter(CounterView view, float startValue, float endValue, long interval, float increment) {
        this.view = view;
        this.startValue = startValue;
        this.endValue = endValue;
        this.interval = interval;
        this.increment = increment;
        this.newValue = this.startValue;
        this.currentValue = this.startValue - increment;
    }

    @Override
    public void run() {
        if (valuesAreCorrect()) {
            final float valueToSet;
            if(increment > 0) {
                if (newValue <= endValue) {
                    valueToSet = newValue;
                } else {
                    valueToSet = endValue;
                }
            } else if(increment < 0) {
                if (newValue >= endValue) {
                    valueToSet = newValue;
                } else {
                    valueToSet = endValue;
                }
            } else {
                return;
            }
            view.setCurrentTextValue(valueToSet);
            currentValue = newValue;
            newValue += increment;
            view.removeCallbacks(Counter.this);
            view.postDelayed(Counter.this, interval);
        } else {
            view.setCurrentTextValue(endValue);
        }
    }

    private boolean valuesAreCorrect() {
        if (increment > 0) {
            return newValue >= currentValue && newValue < endValue;
        } else if (increment < 0) {
            return newValue < currentValue && newValue > endValue;
        } else {
            return false;
        }
    }
}
