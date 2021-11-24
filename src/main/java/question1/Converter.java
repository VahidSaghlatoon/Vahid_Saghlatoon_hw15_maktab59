package question1;

public class Converter {

    public Integer convertStringToInteger(String input) {
        String checkedInput;
        Integer generatedNumber ;
        if (input == null || input.equals(""))
            throw new IllegalArgumentException("Your input value is null or empty");
        else {
            checkedInput = checkAllCharsBeDigit(input);
            if (checkedInput == null) return null;
            else generatedNumber = convertCheckedStringToInteger(checkedInput);
        }
        return generatedNumber;
    }

    private Integer convertCheckedStringToInteger(String input) {
        int parseInt = Integer.parseInt(input);
        if (!(parseInt >= -32767 && parseInt <= 32767))
            return null;
        return parseInt;
    }

    private String checkAllCharsBeDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= 48 && input.charAt(i) <= 57))
                return null;
        }
        return input;
    }
}
