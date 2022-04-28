public class BigBinary {
    private StringBuilder bits = new StringBuilder();
    private boolean positive;

    public StringBuilder getBits() {
        return bits;
    }

    public int getActualLength(){
        return bits.length();
    }

    public boolean isPositive() {
        return positive;
    }

    public BigBinary(int[] bits, boolean positive){
        boolean isZero = true;
        for(int i = 0;i < bits.length;i++)
            if(!isZero) {
                this.bits.append(bits[i]);
            }
            else{
                if(bits[i] != 0){
                    this.bits.append(bits[i]);
                    isZero = false;
                }
            }
        this.positive = positive;
    }

    public BigBinary(StringBuilder stringBuilder, boolean positive){
        this.bits = new StringBuilder(stringBuilder.toString());
        this.positive = positive;
    }

    public BigBinary leftMove(int x){
        StringBuilder str = new StringBuilder(this.bits.toString());
        for(int i = 0;i < x;i++)
            str.append(0);
        return new BigBinary(str,positive);
    }

    public StringBuilder align(int x){
        StringBuilder stringBuilder = new StringBuilder(bits.toString());
        for(int i = 0;i < x - bits.length();i++){
            stringBuilder.insert(0,0);
        }
        return stringBuilder;
    }

    public int isLarger(BigBinary bigBinary){
        int length = max(bigBinary.getActualLength(),this.bits.length());
        return this.align(length).toString().compareTo(bigBinary.align(length).toString());
    }

    public BigBinary add(BigBinary bigBinary){
        int length = max(this.getActualLength(),bigBinary.getActualLength());
        if(this.positive == bigBinary.isPositive()){
            StringBuilder result = new StringBuilder();
            StringBuilder str1 = bigBinary.align(length);
            StringBuilder str2 = this.align(length);
            int add = 0;
            add = str1.charAt(length - 1) - 48 & str2.charAt(length - 1) - 48;
            result.insert(0,(str1.charAt(length - 1) - 48) ^ (str2.charAt(length - 1) - 48));
            for(int i = length - 1;i >= 1;i--){
                int num1 = str1.charAt(i - 1) - 48;
                int num2 = str2.charAt(i - 1) - 48;
                result.insert(0,num1 ^ num2 ^ add);
                add = (num1 & num2) | (num1 & add) | (num2 & add);
            }
            if(add != 0)
                result.insert(0,1);
            this.bits = result;
        }else{
            int type;
            if(this.isLarger(bigBinary) > 0){
                type = 1;
            }else if(this.isLarger(bigBinary) < 0){
                type = -1;
            }else{
                type = 0;
            }
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            switch(type) {
                case 0:
                    bits = new StringBuilder("0");
                    return this;
                case 1:
                    a = this.align(length);
                    b = bigBinary.align(length);
                    break;
                case -1:
                    a = bigBinary.align(length);
                    b = this.align(length);
                    this.positive = !this.positive;
                    break;
            }
            int add = 0;
            StringBuilder result = new StringBuilder();
            StringBuilder b1 = new StringBuilder();
            b1.insert(0,abs(b.charAt(length - 1) - 49) ^ 1);
            add = abs(b.charAt(length - 1) - 49) & 1;
            for(int i = length - 2;i >= 0;i--){
                int bi = abs(b.charAt(i) - 49);
                b1.insert(0, (0 ^ bi) ^ add);
                add = bi & add;
            }
            b1.insert(0,1 ^ add);
            a.insert(0,0);
            add = b1.charAt(length) - 48 & a.charAt(length) - 48;
            result.insert(0, b1.charAt(length) - 48 ^ a.charAt(length) - 48);
            for(int i = length - 1;i >= 0;i--){
                int bn = a.charAt(i) - 48;
                int sn = b1.charAt(i) - 48;
                add = sn & bn;
                result.insert(0, sn ^ bn);
                result.insert (0,sn ^ bn ^ add);
                add = (sn & bn) | (add & sn) | (bn & add);
            }
            while(result.charAt(0) == '0'){
                result.deleteCharAt(0);
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
        StringBuilder a = bigbinary.getBits();
        BigBinary result = new BigBinary(new int[]{0},true);
        BigBinary mulNum = new BigBinary(this.getBits(),true);
        for(int i = 0;i < a.length();i++) {
            if (a.charAt(i) == '1')
                result.add(mulNum.leftMove(a.length() - i - 1));
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
        if(bits.length() == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        if(!this.positive){
            result.append('-');
        }
        result.append(bits.toString());
        return result.toString();
    }
}
