
public class BigBinary {
    private int[] bits;
    private boolean positive;
    public BigBinary(int[] bits,boolean positive){
        this.bits = new int[bits.length];
        for (int i = 0;i < bits.length;i++){
            this.bits[i] = bits[i];
        }
        this.positive = positive;
    }

    public int[] getBits() {
        return bits;
    }
    public boolean isPositive() {
        return positive;
    }

    public static boolean compare(BigBinary b1,BigBinary b2){
        int m = 0;
        while (b1.getBits()[m] == 0 && m < b1.getBits().length - 1){
            m++;
        }
        int[] a = new int[b1.getBits().length - m];
        for (int i = 0;i + m < b1.getBits().length;i++){
            a[i] = b1.getBits()[i + m];
        }

        int n = 0;
        while (b2.getBits()[n] == 0 && n < b2.getBits().length - 1){
            n++;
        }
        int[] b = new int[b2.getBits().length - n];
        for (int i = 0;i + n < b2.getBits().length;i++){
            b[i] = b2.getBits()[i + n];
        }
        if (a.length > b.length){
            return true;
        }else {
            if (a.length < b.length){
                return false;
            }else {
                for (int i = 0;i < a.length;i++){
                    if (a[i] > b[i]){
                        return true;
                    }else {
                        if (a[i] < b[i]){
                            return false;
                        }
                    }
                }
                return true;
            }
        }
    }
    public static BigBinary change(BigBinary bigBinary){
        return new BigBinary(bigBinary.getBits(),(!bigBinary.isPositive()));
    }

    public static BigBinary add(BigBinary b1,BigBinary b2){
        if (b1.isPositive() == b2.isPositive()){
            return new BigBinary(ADD(b1.getBits(), b2.getBits()), b1.isPositive());
        }else {
            if (compare(b1, b2)){
                return new BigBinary(MINUS(b1.getBits(), b2.getBits()), b1.isPositive());
            }else {
                return new BigBinary(MINUS(b2.getBits(),b1.getBits()), b2.isPositive());
            }
        }
    }
    public BigBinary add(BigBinary bigBinary){
        return add(new BigBinary(bits,positive),bigBinary);
    }

    public static BigBinary minus(BigBinary b1,BigBinary b2){
        return add(b1,change(b2));
    }
    public BigBinary minus(BigBinary bigBinary){
        return minus(new BigBinary(bits,positive),bigBinary);
    }

    public static BigBinary multiply(BigBinary bigBinary1, BigBinary bigBinary2){
        return null;
    }
    public BigBinary multiply(BigBinary bigBinary){
        return multiply(new BigBinary(getBits(),isPositive()),bigBinary);
    }

    public String toString(){
        if (bits.length == 0){
            return "0";
        }else {
            int count = 0;
            while (bits[count] != 1 && count < bits.length - 1){
                count++;
            }
            if (count == bits.length - 1 && bits[count] == 0){
                return "0";
            }
            StringBuilder builder = new StringBuilder();
            if (!isPositive()) {
                builder.append("-");
            }
            for (int i = 0;i + count < bits.length;i++){
                builder.append(bits[i+count]);
            }
            return builder.toString();
        }
    }
    public static int[] ADD(int[] a,int[] b){
        int max = Math.max(a.length, b.length);
        int[] c = new int[max];
        int[] result = new int[max+1];
        int jin = 0;
        if (a.length == max){
            for (int i = 0;i < b.length;i++){
                c[i + max - b.length] = b[i];
            }
            for(int i = max - 1;i >= 0;i--){
                result[i + 1] = c[i]^a[i]^jin;
                jin = (c[i]&a[i]) | (c[i]&jin) | (a[i]&jin);
            }
            result[0] = jin;
        }else {
            for (int i = 0;i < a.length;i++){
                c[i + max - a.length] = a[i];
            }
            for(int i = max - 1;i >= 0;i--){
                result[i + 1] = c[i]^b[i]^jin;
                jin = (c[i]&b[i]) | (c[i]&jin) | (b[i]&jin);
            }
            result[0] = jin;
        }
        return result;
    }
    public static int[] MINUS(int[] A,int[] B){
        int m = 0;
        while (A[m] == 0 && m < A.length - 1){
            m++;
        }
        int[] a = new int[A.length - m];
        for (int i = 0;i < a.length;i++){
            a[i] = A[i + m];
        }
        int n = 0;
        while (B[n] == 0 && n < B.length -1){
            n++;
        }
        int[] b = new int[B.length - n];
        for (int i = 0;i < b.length;i++){
            b[i] = B[i + n];
        }

        int max = Math.max(a.length, b.length);
        int[] c = new int[max];
        int[] d = new int[max];
        int[] result;
        if (a.length == max){
            for (int i = 0;i < b.length;i++){
                c[i + max - b.length] = b[i];
            }
            for (int i = 0;i < max;i++){
                d[i] = (c[i] == 0 ? 1:0);
            }
            result = ADD(a,d);
        }else {
            for (int i = 0;i < a.length;i++){
                c[i + max - a.length] = a[i];
            }
            for (int i = 0;i < max;i++){
                d[i] = (c[i] == 0 ? 1:0);
            }
            result = ADD(d,b);
        }
        result = ADD(result, new int[]{1});
        result[0] = 0;
        result[1] = 0;
        return result;
    }
}
