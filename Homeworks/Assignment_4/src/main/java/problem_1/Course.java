package problem_1;

import java.util.Objects;

/**
 * A class representing course.
 */
public class Course {
    private final String name;
    private final String prefix;
    private final int number;

    /**
     * Constructor for Course class.
     * @param name Name of the course.
     * @param prefix Prefix of the course.
     * @param number ID number of the course.
     */
    public Course(String name, String prefix, int number) {
        this.name = name;
        this.prefix = prefix;
        this.number = number;
    }

    /**
     * Override toString method.
     * @return  String consisted of the three attributes.
     */
    @Override
    public String toString() {
        return prefix + number + ": " + name;
    }

    /**
     * Override the equals method.As long as the three attributes are the same, we say they are equals.
     * @param o An object to be compared.
     * @return True if they share the same attributes.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course course = (Course) o;
        return number == course.number &&
                name.equals(course.name) &&
                prefix.equals(course.prefix);
    }

    /**
     * Override the hashcode method.
     * @return hashcode values associated with their attributes.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, prefix, number);
    }


}
