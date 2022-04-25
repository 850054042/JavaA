public class BigBinary {
    private int[] bits;
    private boolean positive;

    public void setBits(int[] bits) {
        this.bits = bits;
    }

    public int[] getBits() {
        return bits;
    }

    public int getActualLength(){
        int n = bits.length;
        for(int i = 0;i < bits.length;i++){
            if(bits[i] != 0){
                n = i;
                break;
            }
        }
        return bits.length - n;
    }

    public boolean isPositive() {
        return positive;
    }

    public BigBinary(int[] bits, boolean positive){
        this.bits = new int[bits.length];
        for(int i = 0;i < bits.length;i++){
            this.bits[i] = bits[i];
        }
        this.positive = positive;
    }

    public int[] align(int length){
        int[] result = new int[length];
        if(bits.length < length){
            for(int i = length - 1;i >= length - bits.length;i--){
                result[i] = bits[i - length + bits.length];
            }
            for(int i = 0;i < length - bits.length;i++){
                result[i] = 0;
            }
            return result;
        }
        else{
            for(int i = length - 1;i >= 0;i--){
                result[i] = bits[i - length + bits.length];
            }
            return result;
        }
    }

    public int isLarger(BigBinary bigBinary){
        if(this.getActualLength() > bigBinary.getActualLength())
            return 1;
        if(this.getActualLength() < bigBinary.getActualLength())
            return -1;
        int[] b = bigBinary.getBits();
        int length = this.getActualLength();
        for(int i = 0;i < length;i++){
            if(bits[bits.length - length + i] > b[b.length - length + i])
                return 1;
            if(bits[bits.length - length + i] < b[b.length - length + i])
                return -1;
        }
        return 0;
    }

    public BigBinary leftMove(int x){
        int[] a = new int[bits.length + x];
        for(int i = 0;i < bits.length;i++)
            a[i] = bits[i];
        for(int i = bits.length;i < bits.length + x;i++)
            a[i] = 0;
        return new BigBinary(a,positive);
    }

    public BigBinary add(BigBinary bigBinary){
        int length = max(this.getActualLength(),bigBinary.getActualLength());
        if(this.positive == bigBinary.isPositive()){
            int[] result = new int[length + 1];
            int[] addNumber = bigBinary.align(length);
            int[] originNumber = this.align(length);
            int add = 0;
            add = addNumber[length - 1] & originNumber[length - 1];
            result[length] = addNumber[length - 1] ^ originNumber[length - 1];
            for(int i = length - 2;i >= 0;i--){
                result[i + 1] = (addNumber[i] ^ originNumber[i]) ^ add;
                add = (addNumber[i] & originNumber[i]) | (add & addNumber[i]) | (originNumber[i] & add);
            }
            result[0] = add;
            bits = result;
        }else{
            if(this.isLarger(bigBinary) == -1)
                this.positive = bigBinary.isPositive();
            int[] a = new int[length];
            int[] b = new int[length];
            switch(this.isLarger(bigBinary)) {
                case 0:
                    int[] result = {0};
                    bits = result;
                    return this;
                case 1:
                    a = this.align(length);
                    b = bigBinary.align(length);
                    break;
                case -1:
                    a = bigBinary.align(length);
                    b = this.align(length);
                    break;
            }
            int[] a1 = new int[length + 1];
            int[] b1 = new int[length + 1];
            a1[0] = 0;
            b1[0] = 1;
            int add = 0;
            int[] result = new int[length + 1];
            b1[length] = abs(b[length - 1] - 1) ^ 1;
            add = abs(b[length - 1] - 1) & 1;
            a1[length] = a[length - 1];
            for(int i = length - 2;i >= 0;i--){
                b1[i + 1] = (0 ^ abs(b[i] - 1)) ^ add;
                add = abs(b[i] - 1) & add;
                a1[i + 1] = a[i];
            }
            b1[0] = b1[0] ^ add;
            add = a1[length] & b1[length];
            result[length] = a1[length] ^ b1[length];
            for(int i = length - 1;i >= 0;i--){
                result[i] = (a1[i] ^ b1[i]) ^ add;
                add = (a1[i] & b1[i]) | (add & a1[i]) | (b1[i] & add);
            }
            this.bits = result;
        }
        return this;
    }

    public BigBinary minus(BigBinary bigBinary){
        BigBinary bigBinary1 = new BigBinary(bigBinary.getBits(),!bigBinary.isPositive());
        return this.add(bigBinary1);
    }

    public static BigBinary add(BigBinary b1, BigBinary b2){
        BigBinary a = new BigBinary(b1.getBits(), b1.isPositive());
        return a.add(b2);
    }

    public static BigBinary minus(BigBinary b1, BigBinary b2){
        BigBinary a = new BigBinary(b1.getBits(), b1.isPositive());
        return a.minus(b2);
    }

    public BigBinary multiply(BigBinary bigbinary){
        if(this.getActualLength() == 0 || bigbinary.getActualLength() == 0)
            return new BigBinary(new int[]{0},true);
        int[] a = new int[bigbinary.getBits().length];
        for(int i = 0;i < bigbinary.getBits().length;i++)
            a[i] = bigbinary.getBits()[i];
        BigBinary result = new BigBinary(new int[]{0},true);
        for(int i = 0;i < a.length;i++) {
            if (a[i] == 1)
                result.add(this.leftMove(a.length - i - 1));
        }
        this.positive = ! this.positive ^ bigbinary.isPositive();
        this.bits = result.getBits();
        return this;
    }

    public static BigBinary multiply(BigBinary b1, BigBinary b2){
        BigBinary a = new BigBinary(b1.getBits(), b1.isPositive());
        return a.multiply(b2);
    }

    public static int max(int x,int y){
        return x>y ? x:y;
    }

    public static int abs(int x){
        return x>=0 ? x:-x;
    }

    @Override
    public String toString() {
        boolean iszero = true;
        int pos = 0;
        for(int i = 0;i < bits.length;i++)
            if(bits[i] != 0){
                pos = i;
                iszero = false;
                break;
            }
        if(iszero)
            return "0";
        else{
            StringBuilder result = new StringBuilder();
            if(!positive)
                result.append('-');
            for(int i = pos;i < bits.length;i++) {
                result.append(bits[i]);
            }
            return result.toString();
        }
    }
}
