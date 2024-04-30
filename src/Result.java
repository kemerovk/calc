public class Result {
    static String getResult(String str){

        char[] chars = str.toCharArray();
        if (chars[0] == '.' || chars[chars.length-1] == '.') return "error";

        boolean isSqrtA = chars[0] == '√';
        int index;
        if (isSqrtA) index = 1;
        else index = 0;
        StringBuilder fir = new StringBuilder();
        StringBuilder sec = new StringBuilder();

        while (chars[index] != '/' && chars[index] != '+' && chars[index] != '-' && chars[index] != '*'  && chars[index] != '%'){
            fir.append(chars[index]);
            index++;
        }

        char option = chars[index];
        index++;

        boolean isSqrtB = chars[index] == '√';
        if (isSqrtB) index++;
        while (chars[index] != '='){
            sec.append(chars[index]);
            index++;
        }

        float first = Float.parseFloat(fir.toString());
        if (isSqrtA) first = (float) Math.sqrt(first);

        float second = Float.parseFloat(sec.toString());
        if (isSqrtB) second = (float) Math.sqrt(second);

        return switch (option){
            case '+' -> addition(first, second);
            case '-' -> subtraction(first, second);
            case '/' -> division(first, second);
            case '*' -> multiplication(first, second);
            case '%' -> mod(first, second);
            default -> "cannot complete operation";
        };

    }


    private static String addition(float a, float b){
        return (isInt(a) && isInt(b))? "" + (int) (a + b): "" + (a + b);
    }


    private static String subtraction(float a, float b){
        return (isInt(a) && isInt(b))? "" + (int) (a - b): "" + (a - b);
    }

    private static String multiplication(float a, float b){
        return (isInt(a) && isInt(b))? "" + (int) (a * b): "" + (a * b);
    }

    private static String division(float a, float b){
        return (isInt(a) && isInt(b) && a % b == 0)? "" + (int) (a / b): "" + (a / b);
    }
    private static String mod(float a, float b){
        return (isInt(a) && isInt(b))? "" + (int) (a % b): "can't complete operation mod with no integers";
    }

    private static boolean isInt(float a){
        return a == (int) a;
    }
}
