class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int twy = 0;
        int ten = 0;
        for(int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) {
                five++;
            }
            if(bills[i] == 10) {
                if(five == 0) return false;
                five--;
                ten++;
            }
            if(bills[i] == 20) {
               
                if(five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                    twy++;
                } else if(five >= 3) {
                    five--;
                    five--;
                    five--;
                    twy++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}