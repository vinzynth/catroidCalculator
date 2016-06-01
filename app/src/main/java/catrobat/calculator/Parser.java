package catrobat.calculator;

/**
 * Created by chrl on 01/06/16.
 * <p/>
 * Class for Parser methods
 */
public class Parser {

    public static int doCalculation(String text) {
        if (text.isEmpty() || "-".equals(text))
            return 0;
        // trim by operators
        String s = text;
        while (lastCharIsOperator(s))
            s = s.substring(0, s.length() - 1);

        // add + before - if no operator is there
        String[] splitByMinus = s.split("-");
        String recombined = "";
        for (int i = 0; i < splitByMinus.length; i++) {
            String str = splitByMinus[i];
            if (str.isEmpty()) {
                recombined += "-";
                continue;
            }
            recombined += str;
            if (i == splitByMinus.length - 1)
                break;
            if (!lastCharIsOperator(str))
                recombined += "+";
            if (!recombined.equals(splitByMinus[splitByMinus.length - 1]))
                recombined += "-";
        }

        // split by add
        String[] summands = recombined.split("\\+");

        int result = 0;
        for (String summand : summands) {
            String[] parts = summand.split("\\*|\\/");

            //parse integers
            int[] p = new int[parts.length];

            //parse operators
            String[] op = new String[parts.length - 1];
            int idx = 0;

            int i = 0;
            for (String part : parts) {
                p[i] = Integer.parseInt(part);

                if (i < (parts.length - 1)) {
                    idx += part.length();
                    String operand = summand.substring(idx, idx + 1);
                    op[i] = operand;
                    idx++;
                }
                i++;
            }

            if (p.length == 1) {
                result += p[0];
                continue;
            } else if (p.length <= 0)
                continue;

            int res = Calculations.calculateBySymbol(p[0], p[1], op[0]);
            for (int j = 2; j < p.length; j++) {
                res = Calculations.calculateBySymbol(res, p[j], op[j - 1]);
            }

            result += res;
        }


        return result;
    }

    private static boolean lastCharIsOperator(String text) {
        if (text.isEmpty())
            return false;

        String lastChar = text.substring(text.length() - 1);

        boolean returnMe = "*".equals(lastChar) || "/".equals(lastChar) || "-".equals(lastChar) || "+".equals(lastChar);
        return returnMe;
    }
}
