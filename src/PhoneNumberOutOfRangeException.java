public class PhoneNumberOutOfRangeException extends RuntimeException {

    public PhoneNumberOutOfRangeException() {
        this("ERROR: PhoneNumberOutOfRangeException - There must be only 10 digits/letters.");
    }

    public PhoneNumberOutOfRangeException(String message) {
        super(message);
    }

    public String getStackTraceString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n").append(this.getMessage()).append("\n");
        for (StackTraceElement e : this.getStackTrace()) {
            stringBuilder.append(e).append("\n");
        }
        return stringBuilder.toString();
    }
}
