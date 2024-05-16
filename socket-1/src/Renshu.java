class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    //ここに続きを実装していく
    public int sumUpToN (int n) {
        int sum = 0;
        while (n >= 0) {
            sum += n;
            n -= 1;
        }
        return sum;
    }

    public int sumFromPtoQ(int p, int q) {
        if (p <= q) {
            int sum = 0;
            int n = p;
            while (n <= q){
                sum += n;
                n += 1;
            }
            return sum;
        } else {
            return -1;
        }
    }

    public int sumFromArrayIndex(int[] a, int index) {
        if(index < a.length && index >= 0) {
            int sum = 0;
            for (int i = index; i < a.length; i++) {
                sum += a[i];
            }
            return sum;
        } else {return -1;}
    }

    public int selectMaxValue(int[] a) {
        int Max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(Max < a[i]) {
                Max = a[i];
            }
        }
            return Max;
    }

    public int selectMinValue(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if(min > a[i]) {
                min = a[i];
            }
        }
            return min;
    }

    public int selectMaxIndex (int[] a) {
        int Max = a[0];
        int MaxIndex = 0;
        int doubleMax = 0;
        for (int i = 1; i < a.length; i++) {
            if(Max < a[i]) {
                Max = a[i];
                MaxIndex = i;
            } else if (Max == a[i]) {
                doubleMax = 1;
            }
        }
        if (doubleMax == 1) {
            int min = a[0];
            int minIndex = 0;
            for (int j = 1; j < a.length; j++) {
                if(min > a[j]) {
                    min = a[j];
                    minIndex = j;
                }
            }
            return minIndex;
        } else {
            return MaxIndex;
        }
    }
    public int selectMinIndex (int[] a) {
        int min = a[0];
        int minIndex = 0;
        for (int i = 1; i < a.length; i++) {
            if(min > a[i]) {
                min = a[i];
                minIndex = i;
            } 
        }
        return minIndex;
    }

    public void swapArrayElements(int[] p, int i, int j) {
        int temp = p[j];
        p[j] = p[i];
        p[i] = temp;
    }

    public boolean swapTwoArrays(int[] a, int[] b) {
        if (a.length == b.length) {
                for (int i = 0; i < a.length;i ++) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
            return true;
        } else {
            return false;
        }
    }
}
