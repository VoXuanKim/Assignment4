package fa.training.utils;

public class IsbnValidator {
    public static boolean isValidIsbn(String isbn) {

        String isbnWithoutHyphens = isbn.replace("-", "");


        if (isbnWithoutHyphens.matches("\\d{10,17}")) {
            return true;
        } else {
            return false;
        }
    }
}
