package converter;

class Coder {
    String method(int num, int newRad) {
        return Long.toString(num, newRad);
    }
    String method(int num) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(count);
        }
        return sb.toString();
    }
    String method(String str , int newRad) {
        int rez = 0;
        for (char ch : str.toCharArray()) {
            rez += ch - 48;
        }
        return Long.toString(rez, newRad);
    }
    boolean method(String str) {
        return str.contains(".");
    }
    String[] algoritm(String str) {
        return str.split("\\.");
    }
    String algDecDouble(String str, int newRad) {
        String[] numbers = algoritm(str);
        str = "0." + numbers[1];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            double rez = newRad * Double.parseDouble(str);
            str = String.valueOf(rez);
            numbers = str.split("\\.");
            stringBuilder.append(Long.toString(Integer.parseInt(numbers[0]), newRad));
            str = "0." + numbers[1];
        }
        return stringBuilder.toString();
    }
    String algConvertInDec(String str, int rad) {
        String[] numbers = algoritm(str);
        str = numbers[1];
        double rez = 0;
        for(int i = 0; i < str.length(); i++) {
            double st = Character. getNumericValue(str.charAt(i));
            rez += st / Math.pow(rad, (i + 1));
        }
        String rezult = String.valueOf(rez);
        return rezult;
    }
}
class CoderFactory {
    String converting(int rad, String str, int newRad) {
        if (rad != 1) {
            int num = Integer.parseInt(str, rad);
            if (newRad != 1) {
                return new Coder().method(num, newRad);
            } else {
                return new Coder().method(num);
            }
        } else {
            return new Coder().method(str, newRad);
        }
    }
}
class CoderAlgConvertInDec{
    String method(int rad, String str, int newRad) {
        if (rad == 10) {
            return new Coder().algDecDouble(str, newRad);
        } else {
            str = new Coder().algConvertInDec(str, rad);
            return new Coder().algDecDouble(str, newRad);
        }
    }
}
class CoderAlg{
    String method(int rad, String str, int newRad) {
        boolean alg = new Coder().method(str);
        if (!(alg)) {
            return new CoderFactory().converting(rad, str, newRad);
        } else {
            String[] numers = new Coder().algoritm(str);
            String str1 = numers[0];
            return new CoderFactory().converting(rad, str1, newRad) + "." + new CoderAlgConvertInDec().method(rad,str,newRad);
        }
    }
}
