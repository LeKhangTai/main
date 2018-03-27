package seedu.address.model.account;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

public class Password {
    public static final String MESSAGE_PASSWORD_CONSTRAINTS =
            "Password should be at least 5 characters long.";
    public static final String PASSWORD_VALIDATION_REGEX = "\\w{5,}";

    private final String password;


    /**
     * Construct a password
     * @param password
     */
    public Password(String password){
        requireNonNull(password);
        checkArgument(isValidPassword(password), MESSAGE_PASSWORD_CONSTRAINTS);

        this.password = password;
    }

    /**
     * Returns true if a given string is a valid password.
     */
    public static boolean isValidPassword(String test) {
        return test.matches(PASSWORD_VALIDATION_REGEX);
    }

    /**
     * Returns password.
     */
    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Credential // short circuit if same obj
                && this.password.equals(((Credential) other).password)); //check password
    }

    @Override
    public int hashCode() {
        return password.hashCode();
    }
}
