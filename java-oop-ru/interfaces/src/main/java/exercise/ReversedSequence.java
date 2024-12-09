package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String value;

    ReversedSequence(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(value);
        sb.reverse();
        return sb.toString();
    }

    @Override
    public int length() {
        return toString().length();
    }

    @Override
    public char charAt(int index) {
        return toString().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return toString().substring(start, end);
    }
}
// END
